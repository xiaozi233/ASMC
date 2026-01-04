package astrotibs.asmc.capabilities.playerarmortracker;

import astrotibs.asmc.config.GeneralConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Constructed following McHorse's tutorial at:
 * https://www.planetminecraft.com/blog/forge-tutorial-capability-system/
 * @author AstroTibs
 */
public class PlayerArmorTracker implements IPlayerArmorTracker
{
	private NBTTagCompound boots_stored;
	private NBTTagCompound leggings_stored;
	private NBTTagCompound chestplate_stored;
	private NBTTagCompound helmet_stored;
	
	@Override
	public void setBoots(NBTTagCompound boots)
	{
		if (!GeneralConfig.armorequipSounds)
		{
			this.boots_stored = new NBTTagCompound();
			return;
		}
		
		this.boots_stored = boots;
	}

	@Override
	public void setLeggings(NBTTagCompound leggings)
	{
		if (!GeneralConfig.armorequipSounds)
		{
			this.leggings_stored = new NBTTagCompound();
			return;
		}
		
		this.leggings_stored = leggings;
	}

	@Override
	public void setChestplate(NBTTagCompound chestplate)
	{
		if (!GeneralConfig.armorequipSounds)
		{
			this.chestplate_stored = new NBTTagCompound();
			return;
		}
		
		this.chestplate_stored = chestplate;
	}

	@Override
	public void setHelmet(NBTTagCompound helmet)
	{
		if (!GeneralConfig.armorequipSounds)
		{
			this.helmet_stored = new NBTTagCompound();
			return;
		}
		
		this.helmet_stored = helmet;
	}

	@Override
	public NBTTagCompound getBoots() {return this.boots_stored;}

	@Override
	public NBTTagCompound getLeggings() {return this.leggings_stored;}

	@Override
	public NBTTagCompound getChestplate() {return this.chestplate_stored;}

	@Override
	public NBTTagCompound getHelmet() {return this.helmet_stored;}
	
	
	/**
	 * Converts an itemstack into a useable NBTTagCompound
	 */
	public static NBTTagCompound saveItemStackToNBT(ItemStack itemstack)
    {
    	NBTTagCompound nbttagcompound = new NBTTagCompound();
    	if (itemstack!=null) {itemstack.writeToNBT(nbttagcompound);}
    	return nbttagcompound != null ? nbttagcompound : new NBTTagCompound();
    }
}
