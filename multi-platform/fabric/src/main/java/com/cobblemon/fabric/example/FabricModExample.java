package com.cobblemon.fabric.example;

import com.cobblemon.common.example.ExampleCommandRegistry;
import net.fabricmc.api.ModInitializer;

public class FabricModExample implements ModInitializer {

    @Override
    public void onInitialize() {
        ExampleCommandRegistry.registerCommands();
    }

}
