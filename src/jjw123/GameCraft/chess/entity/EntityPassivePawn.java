package jjw123.GameCraft.chess.entity;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityPassivePawn extends EntityChicken {

	private boolean isGhost;
	private int pieceID;
	
	public EntityPassivePawn(World par1World) {
		super(par1World);
	}
	
	public void setGhost(boolean b) {
		isGhost = b;
	}
	
	public void setPieceID(int ID) {
		this.pieceID = ID;
	}
	
	public int getPieceID() {
		return pieceID;
	}
	
	@Override
	public boolean isInvisible() {
		return isGhost;
	}
	
	@Override
	public boolean isInvisibleToPlayer(EntityPlayer player) {
		return false;
	}
}
