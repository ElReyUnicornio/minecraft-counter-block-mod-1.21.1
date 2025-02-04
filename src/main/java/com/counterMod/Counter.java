package com.counterMod;

import com.counterMod.block.ModBlocks;
import com.counterMod.command.ModCommands;
import com.counterMod.network.ModNetwork;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Counter implements ModInitializer {
	public static final String MOD_ID = "counter";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.register();
		ModNetwork.register();
		ModCommands.register();
	}
}