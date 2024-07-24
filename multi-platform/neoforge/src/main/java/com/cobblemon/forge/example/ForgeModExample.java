package com.cobblemon.forge.example;

import com.cobblemon.common.example.ExampleCommandRegistry;

@Mod("cobblemon_forge_mdk")
public class ForgeModExample {

    public ForgeModExample() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onCommandRegistration(RegisterCommandsEvent event) {
        ExampleCommandRegistry.registerCommands(event.getDispatcher(), event.getBuildContext(), event.getCommandSelection());
    }
}
