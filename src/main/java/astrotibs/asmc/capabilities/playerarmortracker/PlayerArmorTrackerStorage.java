package astrotibs.asmc.capabilities.playerarmortracker;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

/**
 * Constructed following McHorse's tutorial at:
 * https://www.planetminecraft.com/blog/forge-tutorial-capability-system/
 * @author AstroTibs
 */
//Added in v2.0.0
public class PlayerArmorTrackerStorage implements IStorage<IPlayerArmorTracker>
{
	public final static String KEY_TAGGROUPNAME = "asmc_armortracker";
	
	public final static String KEY_BOOTS = "Boots";
	public final static String KEY_LEGGINGS = "Leggings";
	public final static String KEY_CHESTPLATE = "Chestplate";
	public final static String KEY_HELMET = "Helmet";
	
	@Override
	public NBTBase writeNBT(Capability<IPlayerArmorTracker> capability, IPlayerArmorTracker instance, EnumFacing side)
	{
		NBTTagCompound nbttagcompound1 = new NBTTagCompound(); // This mod's capabilities tag
		
        nbttagcompound1.setTag(KEY_BOOTS, instance.getBoots()!=null ? instance.getBoots() : new NBTTagCompound());
        nbttagcompound1.setTag(KEY_LEGGINGS, instance.getLeggings()!=null ? instance.getLeggings() : new NBTTagCompound());
        nbttagcompound1.setTag(KEY_CHESTPLATE, instance.getChestplate()!=null ? instance.getChestplate() : new NBTTagCompound());
        nbttagcompound1.setTag(KEY_HELMET, instance.getHelmet()!=null ? instance.getHelmet() : new NBTTagCompound());
        
		NBTTagCompound compound = new NBTTagCompound(); // The sub-category for the mod's tag
		compound.setTag(KEY_TAGGROUPNAME, nbttagcompound1); 
        
		return compound;
	}
	
	
	@Override
	public void readNBT(Capability<IPlayerArmorTracker> capability, IPlayerArmorTracker instance, EnumFacing side, NBTBase nbt)
	{
		NBTTagCompound compound = ((NBTTagCompound)nbt); // All capabilities tags for this object
		
		NBTTagCompound nbttagcompound1 = (NBTTagCompound)compound.getTag(KEY_TAGGROUPNAME); // Tag with the ID of the mod's name
		
		instance.setBoots(nbttagcompound1.hasKey(KEY_BOOTS) ? (NBTTagCompound)nbttagcompound1.getTag(KEY_BOOTS) : new NBTTagCompound());
		instance.setLeggings(nbttagcompound1.hasKey(KEY_LEGGINGS) ? (NBTTagCompound)nbttagcompound1.getTag(KEY_LEGGINGS) : new NBTTagCompound());
		instance.setChestplate(nbttagcompound1.hasKey(KEY_CHESTPLATE) ? (NBTTagCompound)nbttagcompound1.getTag(KEY_CHESTPLATE) : new NBTTagCompound());
		instance.setHelmet(nbttagcompound1.hasKey(KEY_HELMET) ? (NBTTagCompound)nbttagcompound1.getTag(KEY_HELMET) : new NBTTagCompound());
	}
	
}
