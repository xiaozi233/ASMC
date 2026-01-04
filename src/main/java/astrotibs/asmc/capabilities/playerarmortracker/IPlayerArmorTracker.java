package astrotibs.asmc.capabilities.playerarmortracker;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Constructed following McHorse's tutorial at:
 * https://www.planetminecraft.com/blog/forge-tutorial-capability-system/
 * @author AstroTibs
 */
public interface IPlayerArmorTracker
{
	// --- Setters --- //
	public void setBoots(NBTTagCompound boots);
	public void setLeggings(NBTTagCompound leggings);
	public void setChestplate(NBTTagCompound chestplate);
	public void setHelmet(NBTTagCompound helmet);
	
	// --- Getters --- //
	public NBTTagCompound getBoots();
	public NBTTagCompound getLeggings();
	public NBTTagCompound getChestplate();
	public NBTTagCompound getHelmet();
}