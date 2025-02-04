package com.counterMod;

import com.counterMod.block.ModBlocks;
import com.counterMod.client.CounterBlockEntityRenderer;
import com.counterMod.client.TimerUpdate;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class CounterClient implements ClientModInitializer {
    private static int timerSeconds = 300;

    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlocks.COUNTER_BLOCK_ENTITY_TYPE, CounterBlockEntityRenderer::new);

        HudRenderCallback.EVENT.register(this::onRender);
        TimerUpdate.register();
    }

    private void onRender(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null ) return;

        int screenWidth = drawContext.getScaledWindowWidth();
        String timeText = getTime();

        drawContext.drawText(client.textRenderer, Text.literal("Tiempo: " + timeText), screenWidth - 100, 20, 0xFFFFFF, true);
    }

    public static void setTimer(int seconds) {
        if (seconds < 0) return;
        timerSeconds = seconds;
    }

    public static int getTimer() {
        return timerSeconds;
    }

    public static String getTime() {
        if (timerSeconds < 1) return "--:--";
        int minutes = (int) Math.floor((double) timerSeconds / 60);
        int seconds = timerSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
