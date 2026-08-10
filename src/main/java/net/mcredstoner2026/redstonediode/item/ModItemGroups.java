package net.mcredstoner2026.redstonediode.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.mcredstoner2026.redstonediode.RedstoneDiode;
import net.mcredstoner2026.redstonediode.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static void registerItemGroups() {
        RedstoneDiode.LOGGER.info("Registering Item Groups for " + RedstoneDiode.MOD_ID);
    }
}
