package jjw123.GameCraft;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class Config {
	
	Configuration config;
	
	public int blockChess;
	
	public Config(File configFile) {
		config = new Configuration(configFile);
	}
	
	public void loadFIle() {
		config.load();
		blockChess = config.getBlock("blockChess", 2600).getInt();
		config.save();
	}
}
