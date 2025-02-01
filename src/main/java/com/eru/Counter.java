package com.eru;

import com.eru.block.ModBlocks;
import com.eru.command.ModCommands;
import com.eru.network.ModNetwork;
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