package jjw123.GameCraft.chess.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockChess extends ItemBlock {

	public ItemBlockChess(int id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata (int damageValue) {
		return damageValue;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return "chessblock_" + itemStack.getItemDamage();
	}
}