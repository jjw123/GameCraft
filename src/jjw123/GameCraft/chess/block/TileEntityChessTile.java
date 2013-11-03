package jjw123.GameCraft.chess.block;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityChessTile extends TileEntity {
	public int tileNum;
	public int tick = 0;
	
	@Override
	public void updateEntity() {
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("tileNum", tileNum);
    }

	@Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
        tileNum = par1NBTTagCompound.getInteger("tileNum");
    }
}
