package jjw123.GameCraft.chess.block;

import jjw123.GameCraft.GameCraft;
import jjw123.GameCraft.chess.entity.EntityChessPlayer;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;

public class TileEntityChessMain extends TileEntity {
	
	public int tick = 0;
	public boolean building, isBuildingX, isBuildingPos, isLeft, isFinishedBuilding = false, playerSpawned = false;
	public EntityPlayer player;
	
	@Override
	public void updateEntity() {
		if(building) {
			if(tick % 10 == 0) {
				int blockNum = tick / 10;
				if(blockNum < 8) {
					if(blockNum % 2 == 0) {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum, yCoord, zCoord - (isLeft ? 3 : 4), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum, yCoord, zCoord - (isLeft ? 3 : 4));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum, yCoord, zCoord + (isLeft ? 3 : 4), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum, yCoord, zCoord + (isLeft ? 3 : 4));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? 3 : 4), yCoord, zCoord - 1 - blockNum, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? 3 : 4), yCoord, zCoord - 1 - blockNum);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? 3 : 4), yCoord, zCoord + 1 + blockNum, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? 3 : 4), yCoord, zCoord + 1 + blockNum);
								te.tileNum = blockNum;
							}
						}
					} else {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum, yCoord, zCoord - (isLeft ? 3 : 4), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum, yCoord, zCoord - (isLeft ? 3 : 4));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum, yCoord, zCoord + (isLeft ? 3 : 4), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum, yCoord, zCoord + (isLeft ? 3 : 4));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? 3 : 4), yCoord, zCoord - 1 - blockNum, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? 3 : 4), yCoord, zCoord - 1 - blockNum);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? 3 : 4), yCoord, zCoord + 1 + blockNum, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? 3 : 4), yCoord, zCoord + 1 + blockNum);
								te.tileNum = blockNum;
							}
						}
					}
				} else if(blockNum < 16) {
					if(blockNum % 2 == 0) {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum - 8, yCoord, zCoord - (isLeft ? 2 : 3), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum - 8, yCoord, zCoord - (isLeft ? 2 : 3));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum + 8, yCoord, zCoord + (isLeft ? 2 : 3), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum + 8, yCoord, zCoord + (isLeft ? 2 : 3));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? 2 : 3), yCoord, zCoord - 1 - blockNum + 8, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? 2 : 3), yCoord, zCoord - 1 - blockNum + 8);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? 2 : 3), yCoord, zCoord + 1 + blockNum - 8, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? 2 : 3), yCoord, zCoord + 1 + blockNum - 8);
								te.tileNum = blockNum;
							}
						}
					} else {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum - 8, yCoord, zCoord - (isLeft ? 2 : 3), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum - 8, yCoord, zCoord - (isLeft ? 2 : 3));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum + 8, yCoord, zCoord + (isLeft ? 2 : 3), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum + 8, yCoord, zCoord + (isLeft ? 2 : 3));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? 2 : 3), yCoord, zCoord - 1 - blockNum + 8, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? 2 : 3), yCoord, zCoord - 1 - blockNum + 8);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? 2 : 3), yCoord, zCoord + 1 + blockNum - 8, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? 2 : 3), yCoord, zCoord + 1 + blockNum - 8);
								te.tileNum = blockNum;
							}
						}
					}
				} else if(blockNum < 24) {
					if(blockNum % 2 == 0) {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum - 16, yCoord, zCoord - (isLeft ? 1 : 2), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum - 16, yCoord, zCoord - (isLeft ? 1 : 2));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum + 16, yCoord, zCoord + (isLeft ? 1 : 2), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum + 16, yCoord, zCoord + (isLeft ? 1 : 2));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? 1 : 2), yCoord, zCoord - 1 - blockNum + 16, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? 1 : 2), yCoord, zCoord - 1 - blockNum + 16);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? 1 : 2), yCoord, zCoord + 1 + blockNum - 16, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? 1 : 2), yCoord, zCoord + 1 + blockNum - 16);
								te.tileNum = blockNum;
							}
						}
					} else {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum - 16, yCoord, zCoord - (isLeft ? 1 : 2), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum - 16, yCoord, zCoord - (isLeft ? 1 : 2));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum + 16, yCoord, zCoord + (isLeft ? 1 : 2), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum + 16, yCoord, zCoord + (isLeft ? 1 : 2));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? 1 : 2), yCoord, zCoord - 1 - blockNum + 16, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? 1 : 2), yCoord, zCoord - 1 - blockNum + 16);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? 1 : 2), yCoord, zCoord + 1 + blockNum - 16, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? 1 : 2), yCoord, zCoord + 1 + blockNum - 16);
								te.tileNum = blockNum;
							}
						}
					}
				} else if(blockNum < 32) {
					if(blockNum % 2 == 0) {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum - 24, yCoord, zCoord - (isLeft ? 0 : 1), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum - 24, yCoord, zCoord - (isLeft ? 0 : 1));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum + 24, yCoord, zCoord + (isLeft ? 0 : 1), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum + 24, yCoord, zCoord + (isLeft ? 0 : 1));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? 0 : 1), yCoord, zCoord - 1 - blockNum + 24, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? 0 : 1), yCoord, zCoord - 1 - blockNum + 24);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? 0 : 1), yCoord, zCoord + 1 + blockNum - 24, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? 0 : 1), yCoord, zCoord + 1 + blockNum - 24);
								te.tileNum = blockNum;
							}
						}
					} else {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum - 24, yCoord, zCoord - (isLeft ? 0 : 1), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum - 24, yCoord, zCoord - (isLeft ? 0 : 1));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum + 24, yCoord, zCoord + (isLeft ? 0 : 1), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum + 24, yCoord, zCoord + (isLeft ? 0 : 1));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? 0 : 1), yCoord, zCoord - 1 - blockNum + 24, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? 0 : 1), yCoord, zCoord - 1 - blockNum + 24);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? 0 : 1), yCoord, zCoord + 1 + blockNum - 24, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? 0 : 1), yCoord, zCoord + 1 + blockNum - 24);
								te.tileNum = blockNum;
							}
						}
					}
				} else if(blockNum < 40) {
					if(blockNum % 2 == 0) {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum - 32, yCoord, zCoord - (isLeft ? -1 : 0), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum - 32, yCoord, zCoord - (isLeft ? -1 : 0));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum + 32, yCoord, zCoord + (isLeft ? -1 : 0), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum + 32, yCoord, zCoord + (isLeft ? -1 : 0));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? -1 : 0), yCoord, zCoord - 1 - blockNum + 32, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? -1 : 0), yCoord, zCoord - 1 - blockNum + 32);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? -1 : 0), yCoord, zCoord + 1 + blockNum - 32, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? -1 : 0), yCoord, zCoord + 1 + blockNum - 32);
								te.tileNum = blockNum;
							}
						}
					} else {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum - 32, yCoord, zCoord - (isLeft ? -1 : 0), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum - 32, yCoord, zCoord - (isLeft ? -1 : 0));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum + 32, yCoord, zCoord + (isLeft ? -1 : 0), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum + 32, yCoord, zCoord + (isLeft ? -1 : 0));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? -1 : 0), yCoord, zCoord - 1 - blockNum + 32, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? -1 : 0), yCoord, zCoord - 1 - blockNum + 32);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? -1 : 0), yCoord, zCoord + 1 + blockNum - 32, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? -1 : 0), yCoord, zCoord + 1 + blockNum - 32);
								te.tileNum = blockNum;
							}
						}
					}
				} else if(blockNum < 48) {
					if(blockNum % 2 == 0) {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum - 40, yCoord, zCoord - (isLeft ? -2 : -1), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum - 40, yCoord, zCoord - (isLeft ? -2 : -1));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum + 40, yCoord, zCoord + (isLeft ? -2 : -1), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum + 40, yCoord, zCoord + (isLeft ? -2 : -1));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? -2 : -1), yCoord, zCoord - 1 - blockNum + 40, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? -2 : -1), yCoord, zCoord - 1 - blockNum + 40);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? -2 : -1), yCoord, zCoord + 1 + blockNum - 40, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? -2 : -1), yCoord, zCoord + 1 + blockNum - 40);
								te.tileNum = blockNum;
							}
						}
					} else {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum - 40, yCoord, zCoord - (isLeft ? -2 : -1), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum - 40, yCoord, zCoord - (isLeft ? -2 : -1));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum + 40, yCoord, zCoord + (isLeft ? -2 : -1), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum + 40, yCoord, zCoord + (isLeft ? -2 : -1));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? -2 : -1), yCoord, zCoord - 1 - blockNum + 40, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? -2 : -1), yCoord, zCoord - 1 - blockNum + 40);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? -2 : -1), yCoord, zCoord + 1 + blockNum - 40, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? -2 : -1), yCoord, zCoord + 1 + blockNum - 40);
								te.tileNum = blockNum;
							}
						}
					}
				} else if(blockNum < 56) {
					if(blockNum % 2 == 0) {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum - 48, yCoord, zCoord - (isLeft ? -3 : -2), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum - 48, yCoord, zCoord - (isLeft ? -3 : -2));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum + 48, yCoord, zCoord + (isLeft ? -3 : -2), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum + 48, yCoord, zCoord + (isLeft ? -3 : -2));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? -3 : -2), yCoord, zCoord - 1 - blockNum + 48, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? -3 : -2), yCoord, zCoord - 1 - blockNum + 48);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? -3 : -2), yCoord, zCoord + 1 + blockNum - 48, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? -3 : -2), yCoord, zCoord + 1 + blockNum - 48);
								te.tileNum = blockNum;
							}
						}
					} else {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum - 48, yCoord, zCoord - (isLeft ? -3 : -2), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum - 48, yCoord, zCoord - (isLeft ? -3 : -2));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum + 48, yCoord, zCoord + (isLeft ? -3 : -2), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum + 48, yCoord, zCoord + (isLeft ? -3 : -2));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? -3 : -2), yCoord, zCoord - 1 - blockNum + 48, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? -3 : -2), yCoord, zCoord - 1 - blockNum + 48);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? -3 : -2), yCoord, zCoord + 1 + blockNum - 48, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? -3 : -2), yCoord, zCoord + 1 + blockNum - 48);
								te.tileNum = blockNum;
							}
						}
					}
				} else if(blockNum < 64) {
					if(blockNum % 2 == 0) {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum - 56, yCoord, zCoord - (isLeft ? -4 : -3), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum - 56, yCoord, zCoord - (isLeft ? -4 : -3));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum + 56, yCoord, zCoord + (isLeft ? -4 : -3), GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum + 56, yCoord, zCoord + (isLeft ? -4 : -3));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? -4 : -3), yCoord, zCoord - 1 - blockNum + 56, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? -4 : -3), yCoord, zCoord - 1 - blockNum + 56);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? -4 : -3), yCoord, zCoord + 1 + blockNum - 56, GameCraft.INSTANCE.block.blockID, 2, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? -4 : -3), yCoord, zCoord + 1 + blockNum - 56);
								te.tileNum = blockNum;
							}
						}
					} else {
						if(isBuildingX) {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord + 1 + blockNum - 56, yCoord, zCoord - (isLeft ? -4 : -3), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + 1 + blockNum - 56, yCoord, zCoord - (isLeft ? -4 : -3));
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord - 1 - blockNum + 56, yCoord, zCoord + (isLeft ? -4 : -3), GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - 1 - blockNum + 56, yCoord, zCoord + (isLeft ? -4 : -3));
								te.tileNum = blockNum;
							}
						} else {
							if(isBuildingPos) {
								worldObj.setBlock(xCoord - (isLeft ? -4 : -3), yCoord, zCoord - 1 - blockNum + 56, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord - (isLeft ? -4 : -3), yCoord, zCoord - 1 - blockNum + 56);
								te.tileNum = blockNum;
							} else {
								worldObj.setBlock(xCoord + (isLeft ? -4 : -3), yCoord, zCoord + 1 + blockNum - 56, GameCraft.INSTANCE.block.blockID, 1, 2);
								TileEntityChessTile te = (TileEntityChessTile) worldObj.getBlockTileEntity(xCoord + (isLeft ? -4 : -3), yCoord, zCoord + 1 + blockNum - 56);
								te.tileNum = blockNum;
							}
						}
					}
				} else {
					building = false;
					tick = 0;
					isFinishedBuilding = true;
				}
			}
		
			tick++;
		} else {
			tick = 0;
		}
		if(player != null && isFinishedBuilding && !playerSpawned) {
			EntityChessPlayer chessPlayer = new EntityChessPlayer(worldObj, isLeft ? "jjw123" : "iPixely");
			worldObj.spawnEntityInWorld(chessPlayer);
			chessPlayer.setPosition(xCoord + 0.5, yCoord + 2.65, zCoord + 0.5);
			playerSpawned = true;
		}

		writeToNBT(new NBTTagCompound());	
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("building", building);
        par1NBTTagCompound.setBoolean("isBuildingPos", isBuildingPos);
        par1NBTTagCompound.setBoolean("isBuildingX", isBuildingX);
        par1NBTTagCompound.setBoolean("leftBlockClicked", isLeft);
        par1NBTTagCompound.setBoolean("isFinishedBuilding", isFinishedBuilding);
        par1NBTTagCompound.setBoolean("playerSpawned", playerSpawned);
        par1NBTTagCompound.setInteger("tick", tick);
    }

	@Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        building = par1NBTTagCompound.getBoolean("building");
        isBuildingPos = par1NBTTagCompound.getBoolean("isBuildingPos");
        isBuildingX =  par1NBTTagCompound.getBoolean("isBuildingX");
        isLeft = par1NBTTagCompound.getBoolean("leftBlockClicked");
        isFinishedBuilding =  par1NBTTagCompound.getBoolean("isFinishedBuilding");
        playerSpawned = par1NBTTagCompound.getBoolean("playerSpawned");
        tick = par1NBTTagCompound.getInteger("tick");
    }
}
