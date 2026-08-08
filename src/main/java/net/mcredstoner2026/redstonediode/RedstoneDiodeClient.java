package net.mcredstoner2026.redstonediode;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.mcredstoner2026.redstonediode.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class RedstoneDiodeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REDSTONE_TEST_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REDSTONE_TEST_TRAPDOOR, RenderLayer.getCutout());
    }
}
