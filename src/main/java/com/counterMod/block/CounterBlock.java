package com.counterMod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class CounterBlock extends Block implements BlockEntityProvider {
    public int digitIndex = 0;
    public CounterBlock(int digitPosition) {
        super(AbstractBlock.Settings.create().dropsNothing());
        this.digitIndex = digitPosition;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        CounterBlockEntity entity = new CounterBlockEntity(pos, state);
        entity.setDigit(this.digitIndex);
        return entity;
    }
}
