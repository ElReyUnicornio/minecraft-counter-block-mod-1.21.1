package com.eru.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

public class CounterBlockEntity extends BlockEntity {
    public int digit = 0;

    public CounterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.COUNTER_BLOCK_ENTITY_TYPE, pos, state);
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putInt("digit", digit);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        digit = nbt.getInt("digit");
    }
}
