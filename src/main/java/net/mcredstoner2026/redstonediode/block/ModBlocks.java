package net.mcredstoner2026.redstonediode.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mcredstoner2026.redstonediode.RedstoneDiode;
import net.mcredstoner2026.redstonediode.block.custom.ChairBlock;
import net.mcredstoner2026.redstonediode.block.custom.MagicBlock;
import net.mcredstoner2026.redstonediode.block.custom.RedstoneDiodeBlock;
import net.mcredstoner2026.redstonediode.block.custom.RedstoneTestLampBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block REDSTONE_TEST_BLOCK = registerBlock("redstone_test_block",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.BRIGHT_RED)
                    .requiresTool()
                    .strength(5.0F, 6.0F)
                    .sounds(BlockSoundGroup.METAL)
                    .solidBlock(Blocks::never)));
    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));

    public static final Block REDSTONE_TEST_STAIRS = registerBlock("redstone_test_stairs",
            new StairsBlock(ModBlocks.REDSTONE_TEST_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block REDSTONE_TEST_SLAB = registerBlock("redstone_test_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));


    public static final Block REDSTONE_TEST_BUTTON = registerBlock("redstone_test_button",
            new ButtonBlock(BlockSetType.IRON, 1,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));

    public static final Block REDSTONE_TEST_PRESSURE_PLATE = registerBlock("redstone_test_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));


    public static final Block REDSTONE_TEST_FENCE = registerBlock("redstone_test_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block REDSTONE_TEST_FENCE_GATE = registerBlock("redstone_test_fence_gate",
            new FenceGateBlock(WoodType.OAK,
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block REDSTONE_TEST_WALL = registerBlock("redstone_test_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));


    public static final Block REDSTONE_TEST_DOOR = registerBlock("redstone_test_door",
            new DoorBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block REDSTONE_TEST_TRAPDOOR = registerBlock("redstone_test_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block REDSTONE_TEST_LAMP = registerBlock("redstone_test_lamp",
            new RedstoneTestLampBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .luminance(state -> state.get(RedstoneTestLampBlock.CLICKED) ? 15 : 0)));


    public static final Block CHAIR = registerBlock("chair",
            new ChairBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Block REDSTONE_DIODE = registerBlock("redstone_diode",
            new RedstoneDiodeBlock(AbstractBlock.Settings.create().nonOpaque()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(RedstoneDiode.MOD_ID, name), block);
    }


    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(RedstoneDiode.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        RedstoneDiode.LOGGER.info("Registering Mod Blocks for " + RedstoneDiode.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(ModBlocks.REDSTONE_TEST_BLOCK);
        });
    }
}
