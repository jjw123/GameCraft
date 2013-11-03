package jjw123.GameCraft.chess.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class EntityChessPlayer extends EntityLiving {

	private int tick = 0;
	public String username;
	
	public EntityChessPlayer(World par1World, String par2Str) {
		super(par1World);
		setSize(0.5f,  0.5f);
		username = par2Str;
//		capabilities.isFlying = true;
	}
}
