package com.github.fullsets92.coxinhacobbletweaks.item;

import com.github.fullsets92.coxinhacobbletweaks.CoxinhaCobbleTweaks;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CoxinhaCobbleTweaks.MOD_ID);

    public static final DeferredItem<Item> EXAMPLEITEM = ITEMS.register("exampleitem",
            () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
