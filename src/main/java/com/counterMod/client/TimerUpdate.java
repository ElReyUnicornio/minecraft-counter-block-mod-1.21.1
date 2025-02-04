package com.counterMod.client;

import com.counterMod.CounterClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

@Environment(EnvType.CLIENT)
public class TimerUpdate {
    private static int tickCounter = 0;

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            tickCounter++;

            if (tickCounter >= 20) {
                tickCounter = 0;
                CounterClient.setTimer(CounterClient.getTimer() - 1);
            }
        });
    }
}
