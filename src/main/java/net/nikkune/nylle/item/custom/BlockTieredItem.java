package net.nikkune.nylle.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.nikkune.nylle.api.texts.EnumColors;
import net.nikkune.nylle.api.texts.TextComponentUtils;
import net.nikkune.nylle.api.tiers.BaseTiers;
import org.jetbrains.annotations.NotNull;

public class BlockTieredItem extends BlockItem {
    private final BaseTiers tier;

    public BlockTieredItem(Block block, Properties properties, BaseTiers tier) {
        super(block, properties);
        this.tier = tier;
    }

    @NotNull
    @Override
    public Component getName(@NotNull ItemStack stack) {
        EnumColors color = tier.getTextColor();
        if (color == EnumColors.BLACK) {
            color = EnumColors.DARK_GRAY;
        }
        return TextComponentUtils.build(color, super.getName(stack));
    }

}
