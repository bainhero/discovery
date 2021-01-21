package com.bainhero.discovery.core.init;

import com.bainhero.discovery.Discovery;
import com.bainhero.discovery.common.items.ResearchJournal;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			Discovery.MOD_ID);
	
	public static final RegistryObject<ResearchJournal> RESEARCH_JOURNAL = ITEMS.register("research_journal",
			() -> new ResearchJournal(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));
}
