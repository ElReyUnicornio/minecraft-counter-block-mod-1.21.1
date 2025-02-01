package com.eru.client;

import com.eru.CounterClient;
import com.eru.block.CounterBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class CounterBlockEntityRenderer implements BlockEntityRenderer<CounterBlockEntity> {
    TextRenderer textRenderer;

    public CounterBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        ctx.getTextRenderer();
        this.textRenderer = ctx.getTextRenderer();
    }

    @Override
    public void render(CounterBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        //obtiene el contador actual
        String time = CounterClient.getTime();
        String digit = time.substring(entity.digit, entity.digit + 1);

        //obtiene el ancho del texto y calcula las posiciones y rotaciones del texto
        float width = textRenderer.getWidth(digit);

        //Frente
        matrices.push();
        matrices.translate(0.5, 0.5, 1.1);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
        matrices.scale(1/18f, 1/18f, 1/18f);
        this.textRenderer.draw(
                digit,
                -width/2, -4f,
                0xffffff,
                false,
                matrices.peek().getPositionMatrix(),
                vertexConsumers,
                TextRenderer.TextLayerType.NORMAL,
                0,
                light
        );
        matrices.pop();

        //reverso
        matrices.push();
        matrices.translate(0.5, 0.5, -0.1);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
        matrices.scale(1/18f, 1/18f, 1/18f);
        this.textRenderer.draw(
                digit,
                -width/2, -4f,
                0xffffff,
                false,
                matrices.peek().getPositionMatrix(),
                vertexConsumers,
                TextRenderer.TextLayerType.NORMAL,
                0,
                light
        );
        matrices.pop();

        //derecha
        matrices.push();
        matrices.translate(1.1, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90));
        matrices.scale(1/18f, 1/18f, 1/18f);
        this.textRenderer.draw(
                digit,
                -width/2, -4f,
                0xffffff,
                false,
                matrices.peek().getPositionMatrix(),
                vertexConsumers,
                TextRenderer.TextLayerType.NORMAL,
                0,
                light
        );
        matrices.pop();

        //izquierda
        matrices.push();
        matrices.translate(-0.1, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90));
        matrices.scale(1/18f, 1/18f, 1/18f);
        this.textRenderer.draw(
                digit,
                -width/2, -4f,
                0xffffff,
                false,
                matrices.peek().getPositionMatrix(),
                vertexConsumers,
                TextRenderer.TextLayerType.NORMAL,
                0,
                light
        );
        matrices.pop();
    }
}
