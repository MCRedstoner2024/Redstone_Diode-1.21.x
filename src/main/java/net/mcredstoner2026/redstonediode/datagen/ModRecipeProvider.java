package net.mcredstoner2026.redstonediode.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.mcredstoner2026.redstonediode.block.ModBlocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.REDSTONE, ModBlocks.REDSTONE_DIODE)
                        .pattern(" T ")
                        .pattern(" C ")
                        .pattern(" S ")
                        .input('T', Items.REDSTONE_TORCH)
                        .input('C', Items.COMPARATOR)
                        .input('S', Items.STONE)
                        .criterion(hasItem(Items.REDSTONE_TORCH), conditionsFromItem(Items.REDSTONE_TORCH))
                        .criterion(hasItem(Items.COMPARATOR), conditionsFromItem(Items.COMPARATOR))
                        .criterion(hasItem(Items.REPEATER), conditionsFromItem(Items.REPEATER))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "RedstoneDiode Recipes";
    }
}
