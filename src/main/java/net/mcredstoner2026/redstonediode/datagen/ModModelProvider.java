package net.mcredstoner2026.redstonediode.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.mcredstoner2026.redstonediode.block.ModBlocks;
import net.mcredstoner2026.redstonediode.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool redstoneTestBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.REDSTONE_TEST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        redstoneTestBlockPool.stairs(ModBlocks.REDSTONE_TEST_STAIRS);
        redstoneTestBlockPool.slab(ModBlocks.REDSTONE_TEST_SLAB);

        redstoneTestBlockPool.button(ModBlocks.REDSTONE_TEST_BUTTON);
        redstoneTestBlockPool.pressurePlate(ModBlocks.REDSTONE_TEST_PRESSURE_PLATE);

        redstoneTestBlockPool.fence(ModBlocks.REDSTONE_TEST_FENCE);
        redstoneTestBlockPool.fenceGate(ModBlocks.REDSTONE_TEST_FENCE_GATE);
        redstoneTestBlockPool.wall(ModBlocks.REDSTONE_TEST_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.REDSTONE_TEST_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.REDSTONE_TEST_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.REDSTONE_TEST_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
    }
}
