package net.mcredstoner2026.redstonediode.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mcredstoner2026.redstonediode.RedstoneDiode;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(RedstoneDiode.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RedstoneDiode.MOD_ID, name)))));
    }
    public static void registerModItems() {
        RedstoneDiode.LOGGER.info("Registering Mod Items for " + RedstoneDiode.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
        });
    }
}
