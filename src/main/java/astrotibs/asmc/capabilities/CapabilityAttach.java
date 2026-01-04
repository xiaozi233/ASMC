package astrotibs.asmc.capabilities;

import astrotibs.asmc.capabilities.playerarmortracker.PlayerArmorTrackerProvider;
import astrotibs.asmc.utility.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Constructed following McHorse's tutorial at:
 * https://www.planetminecraft.com/blog/forge-tutorial-capability-system/
 * @author AstroTibs
 */
public class CapabilityAttach
{
	public static final ResourceLocation ASMC_CAPABILITIES = new ResourceLocation(Reference.MOD_ID, "capabilities");
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent event)
	{
		if (event.getObject() instanceof EntityPlayer)
		{
			event.addCapability(ASMC_CAPABILITIES, new PlayerArmorTrackerProvider());
		}
	}
}