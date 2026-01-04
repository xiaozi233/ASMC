package astrotibs.asmc.sounds;

import astrotibs.asmc.utility.Reference;
import net.minecraft.block.BlockBeacon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class BeaconAmbientSound extends MovingSound
{
	private final TileEntityBeacon beacon;
	
	public BeaconAmbientSound(TileEntityBeacon beacon)
	{
		super(new ResourceLocation(Reference.MOD_ID+":block.beacon.ambient"));
		
		this.beacon = beacon;
        this.attenuationType = ISound.AttenuationType.NONE;
        this.repeat = false;
        this.repeatDelay = 0;
	}

	@Override
	public void update()
	{
		if (
				this.beacon != null
				&& (beacon.getWorld().getBlockState(beacon.getPos()).getBlock() instanceof BlockBeacon)
				&& this.beacon.getField(0) > 0) // 0  is levels, 1 and 2 are primary and secondary effect
		{
            this.xPosF = (float)this.beacon.getPos().getX();
            this.yPosF = (float)this.beacon.getPos().getY();
            this.zPosF = (float)this.beacon.getPos().getZ();
            
            EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
			World world = Minecraft.getMinecraft().theWorld;
            
            float distance = MathHelper.sqrt_double(
            		(this.xPosF-player.posX)*(this.xPosF-player.posX) +
            		(this.yPosF-player.posY)*(this.yPosF-player.posY) +
            		(this.zPosF-player.posZ)*(this.zPosF-player.posZ));
            
            this.volume = MathHelper.clamp_float((1F - (distance/7F))*0.9F, 0F, 1F);
		}
		else
		{
			this.donePlaying = true;
		}
	}
}
