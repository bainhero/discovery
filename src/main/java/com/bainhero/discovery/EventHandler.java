package com.bainhero.discovery;

import com.bainhero.discovery.common.items.ResearchJournal;
import com.bainhero.discovery.core.util.DataUtil;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {
	private static final String TAG_PLAYER_RESEARCH = DataUtil.prefix("found_apple");
	@SubscribeEvent
	public void pickupItem(EntityItemPickupEvent event) {
		CompoundNBT playerData = event.getPlayer().getPersistentData();
		CompoundNBT data = DataUtil.getTagSafe(playerData, PlayerEntity.PERSISTED_NBT_TAG);
		
		if(data.getBoolean(ResearchJournal.TAG_PLAYER_BOOK) && event.getItem().getItem().getItem() == Items.APPLE && !data.getBoolean(TAG_PLAYER_RESEARCH)) {
			System.out.println("All good!"); //Initiate knowledge tree
			data.putBoolean(TAG_PLAYER_RESEARCH, true);
			playerData.put(PlayerEntity.PERSISTED_NBT_TAG, data);
		}
	}
}
