package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.Font;
import net.minecraft.client.font.FontStorage;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.resource.ResourceManager;
import net.minecraft.text.Text;
import net.minecraft.text.TranslationException;
import net.minecraft.util.Hand;
import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import sun.java2d.SunGraphics2D;
import sun.java2d.SurfaceData;

import java.awt.*;
import java.util.DoubleSummaryStatistics;

public class HudLoad implements ClientModInitializer {



    @Override
    public void onInitializeClient() {

        HudRenderCallback.EVENT.register(new HudRenderCallback() {
            @Override
            public void onHudRender(MatrixStack matrixStack, float v) {
                matrixStack.push();

                ItemRenderer r = MinecraftClient.getInstance().getItemRenderer();
                r.zOffset += 500;
                r.renderInGuiWithOverrides(MinecraftClient.getInstance().player.getStackInHand(Hand.MAIN_HAND),0,0);
                r.renderInGuiWithOverrides(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.HEAD),0,50);
                r.renderInGuiWithOverrides(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.CHEST),0,60);
                r.renderInGuiWithOverrides(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.LEGS),0,70);
                r.renderInGuiWithOverrides(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.FEET),0,80);
                MinecraftClient.getInstance().textRenderer.draw(matrixStack,Math.round(MinecraftClient.getInstance().player.getHealth()) + "/" + MinecraftClient.getInstance().player.getMaxHealth(),140,190,0xFF0000);
                r.zOffset -= 500;
                matrixStack.pop();
            }
        });
    }
}
