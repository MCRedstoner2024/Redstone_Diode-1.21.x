package net.mcredstoner2026.redstonediode;

import net.fabricmc.api.ModInitializer;

import net.mcredstoner2026.redstonediode.block.ModBlocks;
import net.mcredstoner2026.redstonediode.item.ModItemGroups;
import net.mcredstoner2026.redstonediode.item.ModItems;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedstoneDiode implements ModInitializer {
	public static final String MOD_ID = "redstonediode";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
