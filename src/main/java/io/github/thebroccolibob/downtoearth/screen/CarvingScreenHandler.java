package io.github.thebroccolibob.downtoearth.screen;

import io.github.thebroccolibob.downtoearth.item.FlintToolItem;
import io.github.thebroccolibob.downtoearth.recipe.CarvingRecipe;
import io.github.thebroccolibob.downtoearth.registry.ModRecipes;
import io.github.thebroccolibob.downtoearth.registry.ModScreens;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class CarvingScreenHandler extends ScreenHandler {

    private final World world;
    private final ItemStack plankStack;
    private final BlockPos plankPos;

    private final Property selectedRecipe = Property.create();
    private final CraftingResultInventory output = new CraftingResultInventory();
    private final Slot outputSlot;

    private List<RecipeEntry<CarvingRecipe>> availableRecipes = new ArrayList<>();

    public CarvingScreenHandler(int syncId, PlayerInventory inv, CarvingScreenData data) {
        this(syncId, inv, data.plank(), data.pos());
    }

    public CarvingScreenHandler(int syncId, PlayerInventory playerInv,
                                ItemStack plankStack, BlockPos plankPos) {
        super(ModScreens.CARVING, syncId);
        this.world = playerInv.player.getWorld();
        this.plankStack = plankStack.copy();
        this.plankPos = plankPos.toImmutable();

        this.outputSlot = this.addSlot(new Slot(this.output, 0, 143, 33) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }

            @Override
            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                stack.onCraftByPlayer(player.getWorld(), player, stack.getCount());

                if (!world.isClient) {
                    damageTool(player);
                    world.breakBlock(CarvingScreenHandler.this.plankPos, false, player);
                    world.playSound(
                            null,
                            CarvingScreenHandler.this.plankPos,
                            SoundEvents.ITEM_AXE_STRIP,
                            SoundCategory.BLOCKS,
                            1.0f,
                            1.0f
                    );

                    if (player instanceof ServerPlayerEntity serverPlayer) {
                        serverPlayer.closeHandledScreen();
                    }
                }

                super.onTakeItem(player, stack);
            }
        });

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInv, i, 8 + i * 18, 142));
        }

        this.addProperty(this.selectedRecipe);

        this.updateAvailableRecipes();
        this.populateResult();
    }

    private void updateAvailableRecipes() {
        this.availableRecipes = this.world.getRecipeManager().getAllMatches(
                ModRecipes.CARVING_TYPE,
                new SingleStackRecipeInput(this.plankStack),
                this.world
        );
    }

    private boolean isInBounds(int id) {
        return id >= 0 && id < this.availableRecipes.size();
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        if (this.isInBounds(id)) {
            this.selectedRecipe.set(id);
            this.populateResult();
        }
        return true;
    }

    void populateResult() {
        if (!this.availableRecipes.isEmpty() && this.isInBounds(this.selectedRecipe.get())) {
            RecipeEntry<CarvingRecipe> entry = this.availableRecipes.get(this.selectedRecipe.get());
            ItemStack result = entry.value().craft(
                    new SingleStackRecipeInput(this.plankStack),
                    this.world.getRegistryManager()
            );
            if (!result.isEmpty()) {
                this.output.setLastRecipe(entry);
                this.outputSlot.setStackNoCallbacks(result);
            } else {
                this.outputSlot.setStackNoCallbacks(ItemStack.EMPTY);
            }
        } else {
            this.outputSlot.setStackNoCallbacks(ItemStack.EMPTY);
        }
        this.sendContentUpdates();
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return player.squaredDistanceTo(
                this.plankPos.getX() + 0.5,
                this.plankPos.getY() + 0.5,
                this.plankPos.getZ() + 0.5
        ) <= 64.0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasStack()) {
            ItemStack stackInSlot = slot.getStack();
            itemStack = stackInSlot.copy();

            if (slot == this.outputSlot) {
                if (!this.insertItem(stackInSlot, 1, 37, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickTransfer(stackInSlot, itemStack);
            } else {
                if (index >= 1 && index < 28) {
                    if (!this.insertItem(stackInSlot, 28, 37, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 28 && index < 37) {
                    if (!this.insertItem(stackInSlot, 1, 28, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            }

            if (stackInSlot.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            }
            slot.markDirty();

            if (stackInSlot.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTakeItem(player, stackInSlot);
        }

        return itemStack;
    }

    @Override
    public ScreenHandlerType<?> getType() {
        return ModScreens.CARVING;
    }

    private void damageTool(PlayerEntity player) {
        ItemStack main = player.getMainHandStack();
        if (main.getItem() instanceof FlintToolItem) {
            main.damage(1, player, EquipmentSlot.MAINHAND);
            return;
        }

        ItemStack off = player.getOffHandStack();
        if (off.getItem() instanceof FlintToolItem) {
            off.damage(1, player, EquipmentSlot.OFFHAND);
        }
    }


    public List<RecipeEntry<CarvingRecipe>> getAvailableRecipes() {
        return this.availableRecipes;
    }

    public int getAvailableRecipeCount() {
        return this.availableRecipes.size();
    }

    public boolean canCraft() {
        return !this.plankStack.isEmpty() && !this.availableRecipes.isEmpty();
    }

    public int getSelectedRecipe() {
        return this.selectedRecipe.get();
    }
}
