package astrotibs.asmc.capabilities.playerarmortracker;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound; // 【必须导入这个包】
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PlayerArmorTrackerProvider implements ICapabilitySerializable<NBTBase>
{
	@CapabilityInject(IPlayerArmorTracker.class)
	public static Capability<IPlayerArmorTracker> PLAYER_ARMOR_TRACKER = null;

	private IPlayerArmorTracker instance;

	public PlayerArmorTrackerProvider() {
		if (PLAYER_ARMOR_TRACKER != null) {
			this.instance = PLAYER_ARMOR_TRACKER.getDefaultInstance();
		} else {
			// 保持 instance 为 null
			this.instance = null;
		}
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return PLAYER_ARMOR_TRACKER != null && capability == PLAYER_ARMOR_TRACKER;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		if (PLAYER_ARMOR_TRACKER != null && capability == PLAYER_ARMOR_TRACKER) {
			return (T) this.instance;
		}
		return null;
	}

	// ================= 重点修改区域 =================
	@Override
	public NBTBase serializeNBT()
	{
		NBTBase nbt = null;

		// 尝试正常保存数据
		if (PLAYER_ARMOR_TRACKER != null && this.instance != null) {
			nbt = PLAYER_ARMOR_TRACKER.getStorage().writeNBT(PLAYER_ARMOR_TRACKER, this.instance, null);
		}

		// 【关键修复】：
		// 无论上面发生了什么（比如 tracker 是 null，或者 storage.writeNBT 返回了 null），
		// 这里绝对不能返回 null！必须返回一个空对象。
		if (nbt == null) {
			return new NBTTagCompound();
		}

		return nbt;
	}
	// ==============================================

	@Override
	public void deserializeNBT(NBTBase nbt)
	{
		if (PLAYER_ARMOR_TRACKER != null && this.instance != null) {
			PLAYER_ARMOR_TRACKER.getStorage().readNBT(PLAYER_ARMOR_TRACKER, this.instance, null, nbt);
		}
	}
}