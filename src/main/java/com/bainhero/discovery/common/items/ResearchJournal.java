package com.bainhero.discovery.common.items;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import com.bainhero.discovery.core.util.DataUtil;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

public class ResearchJournal extends Item{
	
	public static final String TAG_PLAYER_BOOK = DataUtil.prefix("used_book");
	
	public ResearchJournal(Properties properties) {
		super(properties);
	}
	
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if(InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
			tooltip.add(new StringTextComponent("Placeholder for information."));
		}else {
			tooltip.add(new TranslationTextComponent("tooltip.research_journal.information"));
		}
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		CompoundNBT playerData = playerIn.getPersistentData();
		CompoundNBT data = DataUtil.getTagSafe(playerData, TAG_PLAYER_BOOK);
		if(!data.getBoolean(TAG_PLAYER_BOOK)) {
			data.putBoolean(TAG_PLAYER_BOOK, true);
			playerData.put(PlayerEntity.PERSISTED_NBT_TAG, data);
			System.out.println("Debug check success!");
		}
		System.out.println("Test.");
		// OPEN GUI
		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
	}
}