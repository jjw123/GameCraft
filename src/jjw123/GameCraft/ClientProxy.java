package jjw123.GameCraft;

import jjw123.GameCraft.chess.entity.EntityChessPlayer;
import jjw123.GameCraft.chess.entity.RenderChessPlayer;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRender() {
		RenderingRegistry.registerEntityRenderingHandler(EntityChessPlayer.class, new RenderChessPlayer());
	}
}
