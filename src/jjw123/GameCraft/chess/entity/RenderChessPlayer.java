package jjw123.GameCraft.chess.entity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;

public class RenderChessPlayer extends RenderPlayer {

	@Override
	protected void func_96450_a(AbstractClientPlayer par1AbstractClientPlayer, double par2, double par4, double par6, String par8Str, float par9, double par10) {}

	@Override
	protected void renderPlayerScale(AbstractClientPlayer par1AbstractClientPlayer, float par2) {
		float f1 = 0.5f;
		GL11.glScalef(f1, f1, f1);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		EntityChessPlayer p = (EntityChessPlayer)par1Entity;
		this.func_130009_a(new ClientChessPlayer(p.worldObj, p.username), par2, par4, par6, par8, par9);
	}
}
