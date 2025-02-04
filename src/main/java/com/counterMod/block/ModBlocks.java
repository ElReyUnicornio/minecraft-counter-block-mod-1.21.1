package com.counterMod.block;

import com.counterMod.Counter;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block COLON = new ColonBlock();
    public static final Block MINUTE1 = new CounterBlock(0);
    public static final Block MINUTE2 = new CounterBlock(1);
    public static final Block SECOND1 = new CounterBlock(3);
    public static final Block SECOND2 = new CounterBlock(4);
    public static final BlockEntityType<CounterBlockEntity> COUNTER_BLOCK_ENTITY_TYPE = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Counter.MOD_ID, "counter-block-entity-type"), BlockEntityType.Builder.create(CounterBlockEntity::new, MINUTE1, MINUTE2, SECOND1, SECOND2).build());

    public static void register() {
        Registry.register(Registries.ITEM, Identifier.of(Counter.MOD_ID, "colon-block"), new BlockItem(COLON, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(Counter.MOD_ID, "minute1-block"), new BlockItem(MINUTE1, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(Counter.MOD_ID, "minute2-block"), new BlockItem(MINUTE2, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(Counter.MOD_ID, "second1-block"), new BlockItem(SECOND1, new Item.Settings()));
        Registry.register(Registries.ITEM, Identifier.of(Counter.MOD_ID, "second2-block"), new BlockItem(SECOND2, new Item.Settings()));

        Registry.register(Registries.BLOCK, Identifier.of(Counter.MOD_ID, "colon-block"), COLON);
        Registry.register(Registries.BLOCK, Identifier.of(Counter.MOD_ID, "minute1-block"), MINUTE1);
        Registry.register(Registries.BLOCK, Identifier.of(Counter.MOD_ID, "minute2-block"), MINUTE2);
        Registry.register(Registries.BLOCK, Identifier.of(Counter.MOD_ID, "second1-block"), SECOND1);
        Registry.register(Registries.BLOCK, Identifier.of(Counter.MOD_ID, "second2-block"), SECOND2);
    }
}
