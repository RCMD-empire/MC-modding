package com.rcmd.rcmdcraft.screen;

import com.rcmd.rcmdcraft.Rcmdcraft;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModScreenHandlers {
    public static ScreenHandlerType<IonizatorScreenHandler> IONIZATOR_SCREEN_HANDLER;
    public static void registerAllScreenHandlers() {
        IONIZATOR_SCREEN_HANDLER = new ScreenHandlerType<>(IonizatorScreenHandler::new);
        Registry.register(Registry.SCREEN_HANDLER, new Identifier(Rcmdcraft.ModID,
                "ionizator_screen_handler"), IONIZATOR_SCREEN_HANDLER);
    }
}
