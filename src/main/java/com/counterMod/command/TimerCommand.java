package com.counterMod.command;

import com.counterMod.network.TimerPayload;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.List;

public class TimerCommand {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(
                    CommandManager.literal("timer")
                            .then(CommandManager.argument("timeInSeconds", IntegerArgumentType.integer()).executes(context -> {
                                int time = IntegerArgumentType.getInteger(context, "timeInSeconds");
                                List<ServerPlayerEntity> players = context.getSource().getServer().getPlayerManager().getPlayerList();
                                for(ServerPlayerEntity player : players) {
                                    ServerPlayNetworking.send(player, new TimerPayload(time));
                                }
                                context.getSource().sendFeedback(() -> Text.literal("Se ha iniciado el cronometro"), false);
                                return Command.SINGLE_SUCCESS;
                            }))
            );
        });
    }
}
