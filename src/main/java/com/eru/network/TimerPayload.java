package com.eru.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public record TimerPayload(int time) implements CustomPayload {
    public static final CustomPayload.Id<TimerPayload> ID = new CustomPayload.Id<>(ModNetwork.TIMER_PACKET_ID);

    public static final PacketCodec<ByteBuf, Integer> PACKET_CODEC = new PacketCodec<ByteBuf, Integer>() {
        @Override
        public void encode(ByteBuf byteBuf, Integer time) {
            PacketByteBuf buf = new PacketByteBuf(byteBuf);
            buf.writeInt(time);
        }

        @Override
        public Integer decode(ByteBuf byteBuf) {
            return new PacketByteBuf(byteBuf).readInt();
        }
    };;

    public static final PacketCodec<RegistryByteBuf, TimerPayload> CODEC = PacketCodec.tuple(PACKET_CODEC, TimerPayload::time, TimerPayload::new);

    @Override
    public CustomPayload.Id<? extends CustomPayload> getId() {
        return ID;
    }
}