package net.mcredstoner2026.redstonediode.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.mcredstoner2026.redstonediode.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.REDSTONE_TEST_BLOCK);
        addDrop(ModBlocks.MAGIC_BLOCK);

        addDrop(ModBlocks.REDSTONE_TEST_STAIRS);
        addDrop(ModBlocks.REDSTONE_TEST_SLAB, slabDrops(ModBlocks.REDSTONE_TEST_SLAB));

        addDrop(ModBlocks.REDSTONE_TEST_BUTTON);
        addDrop(ModBlocks.REDSTONE_TEST_PRESSURE_PLATE);

        addDrop(ModBlocks.REDSTONE_TEST_WALL);
        addDrop(ModBlocks.REDSTONE_TEST_FENCE);
        addDrop(ModBlocks.REDSTONE_TEST_FENCE_GATE);

        addDrop(ModBlocks.REDSTONE_TEST_DOOR, doorDrops(ModBlocks.REDSTONE_TEST_DOOR));
        addDrop(ModBlocks.REDSTONE_TEST_TRAPDOOR);
    }
}
