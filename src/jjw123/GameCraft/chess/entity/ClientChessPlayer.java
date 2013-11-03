package jjw123.GameCraft.chess.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class ClientChessPlayer extends AbstractClientPlayer {
	
	public ClientChessPlayer(World par1World, String par2Str) {
		super(par1World, par2Str);
	}
	
	@Override public void sendChatToPlayer(ChatMessageComponent chatmessagecomponent) { }
	@Override public boolean canCommandSenderUseCommand(int i, String s) { return false; }
	@Override public ChunkCoordinates getPlayerCoordinates() { return null; }
}
