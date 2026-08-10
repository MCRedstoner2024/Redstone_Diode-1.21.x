package net.mcredstoner2026.redstonediode.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mcredstoner2026.redstonediode.RedstoneDiode;
import net.mcredstoner2026.redstonediode.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RedstoneDiode.MOD_ID, name), item);
    }
    public static void registerModItems() {
        RedstoneDiode.LOGGER.info("Registering Mod Items for " + RedstoneDiode.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
        });
    }
}
