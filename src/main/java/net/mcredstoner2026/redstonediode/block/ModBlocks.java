package net.mcredstoner2026.redstonediode.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mcredstoner2026.redstonediode.RedstoneDiode;
import net.mcredstoner2026.redstonediode.block.custom.RedstoneDiodeBlock;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.createLightLevelFromLitBlockState;

public class ModBlocks {

    public static final Block REDSTONE_DIODE = registerBlock("redstone_diode",
            new RedstoneDiodeBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .luminance(state -> state.get(Properties.POWERED) ? 7 : 0)
                    .sounds(BlockSoundGroup.WOOD)
                    .pistonBehavior(PistonBehavior.DESTROY)));


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
            entries.add(ModBlocks.REDSTONE_DIODE);
        });
    }
}
