package astrotibs.asmc.proxy;

import astrotibs.asmc.capabilities.CapabilityAttach;
import astrotibs.asmc.capabilities.playerarmortracker.IPlayerArmorTracker;
import astrotibs.asmc.capabilities.playerarmortracker.PlayerArmorTracker;
import astrotibs.asmc.capabilities.playerarmortracker.PlayerArmorTrackerStorage;
import astrotibs.asmc.config.GeneralConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
	protected Configuration config;
	
	public void preInit(FMLPreInitializationEvent e) {}
	
	public void init(FMLInitializationEvent e)
	{
		MinecraftForge.EVENT_BUS.register(new CapabilityAttach());
		MinecraftForge.EVENT_BUS.register(new GeneralConfig());
		registerCapabilities();
	}
	
	public void postInit(FMLPostInitializationEvent e) {}
	
	protected void registerCapabilities()
	{
		CapabilityManager.INSTANCE.register(IPlayerArmorTracker.class, new PlayerArmorTrackerStorage(), PlayerArmorTracker.class);
	}
}
