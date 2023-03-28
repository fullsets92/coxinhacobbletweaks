package com.cobblemon.common.example;

import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.pokemon.Species;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;

import static net.minecraft.commands.Commands.literal;

public final class ExampleCommandRegistry {

    public static void registerCommands() {
        CommandRegistrationEvent.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("test").executes(context -> {
                Species species = PokemonSpecies.INSTANCE.getByIdentifier(ResourceLocation.of("cobblemon:bidoof", ':'));
                context.getSource().sendSystemMessage(
                        Component.literal("Got species: ")
                                .withStyle(Style.EMPTY.withColor(0x03e3fc))
                                .append(species.getTranslatedName())
                );

                return 0;
            }));
        });
    }

}
