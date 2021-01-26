package com.bainhero.discovery.core.util;

import java.util.Locale;

import com.bainhero.discovery.Discovery;

import net.minecraft.nbt.CompoundNBT;

public class DataUtil {
	
	public static final String RESOURCE = Discovery.MOD_ID.toLowerCase(Locale.US);
	
	public static CompoundNBT getTagSafe(CompoundNBT tag, String key) {
	    if (tag == null) {
	      return new CompoundNBT();
	    }

	    return tag.getCompound(key);
	  }
	
	public static String prefix(String name) {
		return String.format("%s.%s", RESOURCE, name.toLowerCase(Locale.US));
	}
}
