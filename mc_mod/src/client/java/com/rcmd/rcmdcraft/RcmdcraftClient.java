package com.rcmd.rcmdcraft;

import com.rcmd.rcmdcraft.screen.IonizatorScreen;
import com.rcmd.rcmdcraft.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class RcmdcraftClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		HandledScreens.register(ModScreenHandlers.IONIZATOR_SCREEN_HANDLER, IonizatorScreen::new);
	}
}