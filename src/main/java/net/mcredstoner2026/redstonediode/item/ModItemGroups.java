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

    public static final ItemGroup REDSTONE_TEST_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(RedstoneDiode.MOD_ID, "redstone_test_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.REDSTONE_TEST_ITEM))
                    .displayName(Text.translatable("itemgroup.redstonediode.redstone_test_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.REDSTONE_TEST_ITEM);
                        entries.add(ModBlocks.REDSTONE_TEST_BLOCK);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                        entries.add(ModBlocks.REDSTONE_TEST_STAIRS);
                        entries.add(ModBlocks.REDSTONE_TEST_SLAB);

                        entries.add(ModBlocks.REDSTONE_TEST_BUTTON);
                        entries.add(ModBlocks.REDSTONE_TEST_PRESSURE_PLATE);

                        entries.add(ModBlocks.REDSTONE_TEST_FENCE);
                        entries.add(ModBlocks.REDSTONE_TEST_FENCE_GATE);
                        entries.add(ModBlocks.REDSTONE_TEST_WALL);

                        entries.add(ModBlocks.REDSTONE_TEST_DOOR);
                        entries.add(ModBlocks.REDSTONE_TEST_TRAPDOOR);

                        entries.add(ModBlocks.REDSTONE_TEST_LAMP);
                        entries.add(ModBlocks.CHAIR);

                        entries.add(ModBlocks.REDSTONE_DIODE);
                    }).build());




    public static void registerItemGroups() {
        RedstoneDiode.LOGGER.info("Registering Item Groups for " + RedstoneDiode.MOD_ID);
    }
}
