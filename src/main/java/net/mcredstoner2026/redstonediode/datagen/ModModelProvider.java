package net.mcredstoner2026.redstonediode.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.mcredstoner2026.redstonediode.block.ModBlocks;
import net.mcredstoner2026.redstonediode.block.custom.RedstoneTestLampBlock;
import net.mcredstoner2026.redstonediode.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

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

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.REDSTONE_TEST_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.REDSTONE_TEST_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.REDSTONE_TEST_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(RedstoneTestLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));



        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.CHAIR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.REDSTONE_TEST_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
    }
}
