package com.rcmd.rcmdcraft.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.rcmd.rcmdcraft.Rcmdcraft;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class IonizatorScreen extends HandledScreen<IonizatorScreenHandler> {

    private static final Identifier TEXTURE = new Identifier(Rcmdcraft.ModID,"textures/gui/ionizator_gui.png");
    public IonizatorScreen(IonizatorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = 5;
        titleY = 5;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices,mouseX,mouseY);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1,1,1,1);
        RenderSystem.setShaderTexture(0,TEXTURE);
        int X = (width-backgroundWidth) /2;
        int Y = (height-backgroundHeight) /2;
        drawTexture(matrices,X,Y,0,0,backgroundWidth,backgroundHeight);
        renderProgressArrow(matrices,X,Y);
    }
    private void renderProgressArrow(MatrixStack matrices, int x, int y)
    {
        if (handler.isCrafting())
        {
            //matrices, top left x, top left y, from where top left x, from where top left y, width amount, height amount
            drawTexture(matrices,x+85,y+30,176,0,8,handler.getScaledProgress());
        }
    }
}
