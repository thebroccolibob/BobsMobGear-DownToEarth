package io.github.thebroccolibob.downtoearth.recipe;

import io.github.thebroccolibob.downtoearth.recipe.GrindingRecipe.Input;
import io.github.thebroccolibob.downtoearth.registry.ModRecipes;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.world.World;

public record GrindingRecipe(Ingredient ingredient, Ingredient reference, ItemStack result) implements Recipe<Input> {

    public static final MapCodec<GrindingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(GrindingRecipe::ingredient),
            Ingredient.DISALLOW_EMPTY_CODEC.optionalFieldOf("reference", Ingredient.EMPTY).forGetter(GrindingRecipe::reference),
            ItemStack.CODEC.fieldOf("result").forGetter(GrindingRecipe::result)
    ).apply(instance, GrindingRecipe::new));

    public static final PacketCodec<RegistryByteBuf, GrindingRecipe> PACKET_CODEC = PacketCodec.tuple(
            Ingredient.PACKET_CODEC, GrindingRecipe::ingredient,
            Ingredient.PACKET_CODEC, GrindingRecipe::reference,
            ItemStack.PACKET_CODEC, GrindingRecipe::result,
            GrindingRecipe::new
    );

    public static RecipeSerializer<GrindingRecipe> SERIALIZER = new RecipeSerializer<>() {
        @Override
        public MapCodec<GrindingRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, GrindingRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    };

    @Override
    public boolean matches(Input input, World world) {
        return ingredient.test(input.ingredient) && reference.test(input.ingredient);
    }

    @Override
    public ItemStack craft(Input input, WrapperLookup lookup) {
        return result.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public ItemStack getResult(WrapperLookup registriesLookup) {
        return result;
    }

    @Override
    public RecipeSerializer<GrindingRecipe> getSerializer() {
        return GrindingRecipe.SERIALIZER;
    }

    @Override
    public RecipeType<GrindingRecipe> getType() {
        return ModRecipes.GRINDING_TYPE;
    }

    public record Input(
            ItemStack ingredient,
            ItemStack reference
    ) implements RecipeInput {
        @Override
        public ItemStack getStackInSlot(int slot) {
            return switch (slot) {
                case 0 -> ingredient;
                case 1 -> reference;
                default -> throw new IllegalArgumentException("No item for index " + slot);
            };
        }

        @Override
        public int getSize() {
            return 2;
        }
    }

}
