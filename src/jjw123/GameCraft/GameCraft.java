package jjw123.GameCraft;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import net.minecraft.block.Block;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import jjw123.GameCraft.chess.block.BlockChess;
import jjw123.GameCraft.chess.block.ItemBlockChess;
import jjw123.GameCraft.chess.block.TileEntityChessMain;
import jjw123.GameCraft.chess.block.TileEntityChessTile;
import jjw123.GameCraft.chess.entity.EntityChessPlayer;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="GameCraft", name="GameCraft", version="0.1.0")
public class GameCraft {
	
	@Instance
	public static GameCraft INSTANCE;
	@SidedProxy(clientSide = "jjw123.GameCraft.ClientProxy", serverSide = "jjw123.GameCraft.CommonProxy")
	public static CommonProxy proxy;
	
	public Config c;
	
	public BlockChess block;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		c = new Config(event.getSuggestedConfigurationFile());
		c.loadFIle();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		block = new BlockChess(c.blockChess);
		
		GameRegistry.registerBlock(block, ItemBlockChess.class, "blockChess");
		
		GameRegistry.registerTileEntity(TileEntityChessTile.class, "tileEntityChessTile");
		GameRegistry.registerTileEntity(TileEntityChessMain.class, "tileEntityChessMain");
		
		LanguageRegistry.addName(new ItemStack(block, 1, 0), "Chess Controller");
		LanguageRegistry.addName(new ItemStack(block, 1, 1), "Black Chess Tile ");
		LanguageRegistry.addName(new ItemStack(block, 1, 2), "White Chess Tile");
		LanguageRegistry.addName(new ItemStack(block, 1, 3), "Chess Controller");
		LanguageRegistry.addName(new ItemStack(block, 1, 4), "Chess Controller");
		LanguageRegistry.addName(new ItemStack(block, 1, 5), "Chess Controller");
		LanguageRegistry.addName(new ItemStack(block, 1, 6), "Chess Controller");
		
		GameRegistry.addRecipe(new ItemStack(block, 1, 0), new Object[] {
			"X", 'X', Block.dirt
		});
		
		proxy.registerRender();
		EntityRegistry.registerModEntity(EntityChessPlayer.class, "Chess Player", 0, INSTANCE, 10, 10, true);
	}
	
	public String serializeEntityPlayer(EntityPlayer player) {
		String serializedObject = "";

		 try {
		     ByteArrayOutputStream bo = new ByteArrayOutputStream();
		     ObjectOutputStream so = new ObjectOutputStream(bo);
		     so.writeObject(player);
		     so.flush();
		     serializedObject = bo.toString();
		 } catch (Exception e) {
		     System.out.println(e);
		     System.exit(1);
		 }
		 
		 return serializedObject;
	}
	
	public EntityPlayer deserializeEntityPlayer(String s) {
		EntityPlayer p = null;
		
		try {
		     byte b[] = s.getBytes(); 
		     ByteArrayInputStream bi = new ByteArrayInputStream(b);
		     ObjectInputStream si = new ObjectInputStream(bi);
		     p = (EntityPlayer) si.readObject();
		 } catch (Exception e) {
		     System.out.println(e);
		     System.exit(1);
		 }
		return p;
	}
}
