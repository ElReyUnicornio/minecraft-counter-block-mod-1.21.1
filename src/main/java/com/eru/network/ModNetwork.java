package com.eru.network;

import com.eru.Counter;
import com.eru.CounterClient;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.util.Identifier;

public class ModNetwork {
    public static Identifier TIMER_PACKET_ID = Identifier.of(Counter.MOD_ID, "timer");

    public static void register() {
        PayloadTypeRegistry.playS2C().register(TimerPayload.ID, TimerPayload.CODEC);

        ClientPlayNetworking.registerGlobalReceiver(TimerPayload.ID, (payload, context) -> {
            int time = payload.time();
            try {
                context.client().execute(() -> {
                    CounterClient.setTimer(time);
                });
            } catch (Exception ignored) {}
        });
    }
}
