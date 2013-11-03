package jjw123.GameCraft.chess.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockChess extends BlockContainer {

	Icon tileBlack, tileWhite, chessMainTop, chessMainSide, chessMainTop1, chessMainTop2, chessMainTop3, chessMainTop4;
	
	public BlockChess(int par1) {
		super(par1, Material.clay);
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		switch(metadata) {
		case  0 :
			return new TileEntityChessMain();
		case 1:
			return new TileEntityChessTile();
		case 2:
			return new TileEntityChessTile();
		case 3:
			return new TileEntityChessMain();
		case 4:
			return new TileEntityChessMain();
		case 5:
			return new TileEntityChessMain();
		case 6:
			return new TileEntityChessMain();
		}
		return super.createTileEntity(world, metadata);
	}

	public void handleRightClick(World world, int x, int y, int z, EntityPlayer player) {
		if(world.getBlockMetadata(x, y, z) == 3 || world.getBlockMetadata(x, y, z) == 4) {
			TileEntityChessMain te = (TileEntityChessMain) world.getBlockTileEntity(x, y, z);
			if(!te.isFinishedBuilding) {
				te.isBuildingX = false;
				player.sendChatToPlayer(ChatMessageComponent.createFromText("Building X = false"));
				if(player.posZ > z + 0.5) {
					te.isBuildingPos = true;
					player.sendChatToPlayer(ChatMessageComponent.createFromText("Building Pos = true"));
					if(world.getBlockMetadata(x, y, z) == 3) {
						te.isLeft = true;
						player.sendChatToPlayer(ChatMessageComponent.createFromText("Left Block Clicked = true"));
					} else {
						te.isLeft = false;
						player.sendChatToPlayer(ChatMessageComponent.createFromText("Left Block Clicked = false"));
					}
				} else {
					te.isBuildingPos = false;
					player.sendChatToPlayer(ChatMessageComponent.createFromText("Building Pos = false"));
					if(world.getBlockMetadata(x, y, z) == 4) {
						te.isLeft = true;
						player.sendChatToPlayer(ChatMessageComponent.createFromText("Left Block Clicked = true"));
					} else {
						te.isLeft = false;
						player.sendChatToPlayer(ChatMessageComponent.createFromText("Left Block Clicked = false"));
					}
				}
				te.tick = 0;
				te.building = true;
			} else if(te.player == null) {
				te.player = (EntityPlayer)player;
			}
		} else if(world.getBlockMetadata(x, y, z) == 5 || world.getBlockMetadata(x, y, z) == 6) {
			TileEntityChessMain te = (TileEntityChessMain) world.getBlockTileEntity(x, y, z);
			if(!te.isFinishedBuilding) {
				te.isBuildingX = true;
				player.sendChatToPlayer(ChatMessageComponent.createFromText("Building X = true"));
				if(player.posX < x + 0.5) {
					te.isBuildingPos = true;
					player.sendChatToPlayer(ChatMessageComponent.createFromText("Building Pos = true"));
					if(world.getBlockMetadata(x, y, z) == 5) {
						te.isLeft = true;
						player.sendChatToPlayer(ChatMessageComponent.createFromText("Left Block Clicked = true"));
					} else {
						te.isLeft = false;
						player.sendChatToPlayer(ChatMessageComponent.createFromText("Left Block Clicked = false"));
					}
				} else {
					te.isBuildingPos = false;
					player.sendChatToPlayer(ChatMessageComponent.createFromText("Building Pos = false"));
					if(world.getBlockMetadata(x, y, z) == 6) {
						te.isLeft = true;
						player.sendChatToPlayer(ChatMessageComponent.createFromText("Left Block Clicked = true"));
					} else {
						te.isLeft = false;
						player.sendChatToPlayer(ChatMessageComponent.createFromText("Left Block Clicked = false"));
					}
				}
				te.tick = 0;
				te.building = true;
			} else if(te.player == null) {
				te.player = (EntityPlayer)player;
			}
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return createTileEntity(world, world.getBlockMetadata((int)minX, (int)minY, (int)minZ));
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		switch(par1World.getBlockMetadata(par2, par3, par4)) {
		case 1:
			TileEntityChessTile te = (TileEntityChessTile) par1World.getBlockTileEntity(par2, par3, par4);
			if(par1World.isRemote) {
				par5EntityPlayer.sendChatToPlayer(ChatMessageComponent.createFromText("tile num = " + te.tileNum));
			}
			return true;
		case 2:
			TileEntityChessTile te1 = (TileEntityChessTile) par1World.getBlockTileEntity(par2, par3, par4);
			if(par1World.isRemote) {
				par5EntityPlayer.sendChatToPlayer(ChatMessageComponent.createFromText("tile num = " + te1.tileNum));
			}
			return true;
		case 3:
			handleRightClick(par1World, par2, par3,  par4, par5EntityPlayer);
			return true;
		case 4:
			handleRightClick(par1World, par2, par3,  par4, par5EntityPlayer);
			return true;
		case 5:
			handleRightClick(par1World, par2, par3,  par4, par5EntityPlayer);
			return true;
		case 6:
			handleRightClick(par1World, par2, par3,  par4, par5EntityPlayer);
			return true;
		default:
			return false;
		}
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entitylivingbase, ItemStack itemstack) {
		if(itemstack.getItemDamage() == 0) {
			if(world.getBlockId(x + 1, y, z) == blockID && world.getBlockMetadata(x + 1, y, z) == 0) {
				world.setBlock(x, y, z, blockID);
				world.setBlock(x + 1, y, z, blockID);
				world.setBlockMetadataWithNotify(x + 1, y, z, 4, 2);
				world.setBlockMetadataWithNotify(x, y, z, 3, 2);
			} else if(world.getBlockId(x - 1, y, z) == blockID && world.getBlockMetadata(x - 1, y, z) == 0) {
				world.setBlock(x, y, z, blockID);
				world.setBlock(x - 1, y, z, blockID);
				world.setBlockMetadataWithNotify(x, y, z, 4, 2);
				world.setBlockMetadataWithNotify(x - 1, y, z, 3, 2);
			} else if(world.getBlockId(x, y, z + 1) == blockID && world.getBlockMetadata(x, y, z + 1) == 0) {
				world.setBlock(x, y, z, blockID);
				world.setBlock(x, y, z + 1, blockID);
				world.setBlockMetadataWithNotify(x, y, z + 1, 6, 2);
				world.setBlockMetadataWithNotify(x, y, z, 5, 2);
			} else if(world.getBlockId(x, y, z - 1) == blockID && world.getBlockMetadata(x, y, z - 1) == 0) {
				world.setBlock(x, y, z - 1, blockID);
				world.setBlock(x, y, z, blockID);
				world.setBlockMetadataWithNotify(x, y, z - 1, 5, 2);
				world.setBlockMetadataWithNotify(x, y, z, 6, 2);
			}
		}
	}
	
	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        if(par1World.getBlockId(par2 + 1, par3, par4) == blockID && (par1World.getBlockMetadata(par2 + 1, par3, par4) == 3 || par1World.getBlockMetadata(par2 + 1, par3, par4) == 4 || par1World.getBlockMetadata(par2 + 1, par3, par4) == 5 || par1World.getBlockMetadata(par2 + 1, par3, par4) == 6)) {
        	return false;
        }
        if(par1World.getBlockId(par2 - 1, par3, par4) == blockID && (par1World.getBlockMetadata(par2 - 1, par3, par4) == 3 || par1World.getBlockMetadata(par2 - 1, par3, par4) == 4 || par1World.getBlockMetadata(par2 - 1, par3, par4) == 5 || par1World.getBlockMetadata(par2 - 1, par3, par4) == 6)) {
        	return false;
        }
        if(par1World.getBlockId(par2, par3, par4 + 1) == blockID && (par1World.getBlockMetadata(par2, par3, par4 + 1) == 3 || par1World.getBlockMetadata(par2, par3, par4 + 1) == 4 || par1World.getBlockMetadata(par2, par3, par4 + 1) == 5 || par1World.getBlockMetadata(par2, par3, par4 + 1) == 6)) {
        	return false;
        }
        if(par1World.getBlockId(par2, par3, par4 - 1) == blockID && (par1World.getBlockMetadata(par2, par3, par4 - 1) == 3 || par1World.getBlockMetadata(par2, par3, par4 - 1) == 4 || par1World.getBlockMetadata(par2, par3, par4 - 1) == 5 || par1World.getBlockMetadata(par2, par3, par4 - 1) == 6)) {
        	return false;
        }
        
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)  {
		switch(par2) {
		case 0:
			if(par1 == 0 || par1 == 1) {
				return chessMainTop;
			} else {
				return chessMainSide;
			}
		case 1:
			return tileBlack;
		case 2:
			return tileWhite;
		case 3:
			if(par1 == 0 || par1 == 1) {
				return chessMainTop1;
			} else {
				return chessMainSide;
			}
		case 4:
			if(par1 == 0 || par1 == 1) {
				return chessMainTop2;
			} else {
				return chessMainSide;
			}
		case 5:
			if(par1 == 0 || par1 == 1) {
				return chessMainTop3;
			} else {
				return chessMainSide;
			}
		case 6:
			if(par1 == 0 || par1 == 1) {
				return chessMainTop4;
			} else {
				return chessMainSide;
			}
		default: return null;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		tileBlack = par1IconRegister.registerIcon("gamecraft:chessBlack");
		tileWhite = par1IconRegister.registerIcon("gamecraft:chessWhite");
		chessMainTop = par1IconRegister.registerIcon("gamecraft:chessMainTop");
		chessMainSide = par1IconRegister.registerIcon("gamecraft:chessMainSide");
		chessMainTop1 = par1IconRegister.registerIcon("gamecraft:chessMainTopLeft");
		chessMainTop2 = par1IconRegister.registerIcon("gamecraft:chessMainTopRight");
		chessMainTop3 = par1IconRegister.registerIcon("gamecraft:chessMainTopLeft_2");
		chessMainTop4 = par1IconRegister.registerIcon("gamecraft:chessMainTopRight_2");
	}
}
