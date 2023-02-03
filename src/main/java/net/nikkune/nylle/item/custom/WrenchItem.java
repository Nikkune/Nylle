package net.nikkune.nylle.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class WrenchItem extends Item {
    public WrenchItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        Block block =  level.getBlockState(context.getClickedPos()).getBlock();

        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            assert player != null;
            if (player.isCrouching()) player.sendSystemMessage(Component.literal("Delete cable"));
            else player.sendSystemMessage(Component.literal("Turn cable"));
        }
        return super.useOn(context);
    }
}
