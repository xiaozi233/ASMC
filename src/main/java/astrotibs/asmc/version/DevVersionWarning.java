package astrotibs.asmc.version;

import astrotibs.asmc.ModASMC;
import astrotibs.asmc.utility.Reference;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class DevVersionWarning {
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onPlayerTickEvent(PlayerTickEvent event) {
		
		if ( 
				event.player.worldObj.isRemote 
				&& !ModASMC.devVersionWarned
				) {
    		event.player.addChatComponentMessage(
            		new ChatComponentText(
            				"You're using a "
            				+ EnumChatFormatting.RED + "development version"  + EnumChatFormatting.RESET + " of " + Reference.MOD_NAME + "."
            		 ));
    	
    		event.player.addChatComponentMessage(
            		new ChatComponentText(
            				EnumChatFormatting.RED + "This version is not meant for public use."
            		 ));
    		ModASMC.devVersionWarned = true;
    	}
		
	}
	
}
