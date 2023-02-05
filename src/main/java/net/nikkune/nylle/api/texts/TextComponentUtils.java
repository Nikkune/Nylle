package net.nikkune.nylle.api.texts;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.nikkune.nylle.Nylle;

import java.util.ArrayList;
import java.util.List;

public class TextComponentUtils {
    private TextComponentUtils() {
    }

    public static MutableComponent color(MutableComponent component, int color){
        return component.setStyle(component.getStyle().withColor(TextColor.fromRgb(color)));
    }

    public static MutableComponent build(Object... components){
        MutableComponent result = null;
        Style cachedStyle = Style.EMPTY;
        for (Object component : components){
            if (component == null) continue;
            MutableComponent current = null;
            if (component instanceof IHasTextComponent hasTextComponent) current = hasTextComponent.getTextComponent().copy();
            else if (component instanceof ITranslationKey translationKey) current = translate(translationKey.getTranslationKey());
            else if (component instanceof EnumColors color) cachedStyle = cachedStyle.withColor(color.getColor());
            else if (component instanceof ChatFormatting formatting) cachedStyle.applyFormats(formatting);
            else if (component instanceof ClickEvent event) cachedStyle = cachedStyle.withClickEvent(event);
            else if (component instanceof HoverEvent event) cachedStyle = cachedStyle.withHoverEvent(event);
            else if (component instanceof Block block) current = translate(block.getDescriptionId());
            else if (component instanceof Item item) current = translate(item.getDescriptionId());
            else if (component instanceof ItemStack stack) current = stack.getHoverName().copy();
            else if (component instanceof FluidStack stack) current = stack.getDisplayName().copy();
            else if (component instanceof Fluid fluid) current = translate(fluid.getFluidType().getDescriptionId());
            else if (component instanceof Direction direction) current = getTranslatedDirection(direction);
            else if (component instanceof Boolean bool) current = getTranslatedBoolean(bool);
            else if (component instanceof Component component1) current = getString(component1.getString());
            else current = getString(component.toString());
            if (current == null) continue;
            if (!cachedStyle.isEmpty()){
                current.setStyle(cachedStyle);
                cachedStyle = Style.EMPTY;
            }
            if (result == null) result = current;
            else result.append(current);
        }
        return result;
    }

    private static MutableComponent getTranslatedBoolean(boolean bool){
        return (bool ? APILang.TRUE_LOWER : APILang.FALSE_LOWER).translate();
    }

    private static MutableComponent getTranslatedDirection(Direction direction){
        return (switch (direction) {
            case NORTH -> APILang.NORTH;
            case SOUTH -> APILang.SOUTH;
            case DOWN -> APILang.DOWN;
            case WEST -> APILang.WEST;
            case EAST -> APILang.EAST;
            case UP -> APILang.UP;
        }).translate();
    }

    private static MutableComponent getString(String component){
        return Component.literal(cleanString(component));
    }

    private static String cleanString(String component){
        return component.replace("\u00A0","").replace("\u202f","");
    }

    public static MutableComponent translate(String key, Object... args){
        return Component.translatable(key, args);
    }

    private static boolean hasStyleType(Style current, ChatFormatting formatting){
        return switch (formatting){
            case STRIKETHROUGH -> current.isStrikethrough();
            case OBFUSCATED -> current.isObfuscated();
            case UNDERLINE -> current.isUnderlined();
            case ITALIC -> current.isItalic();
            case RESET -> current.isEmpty();
            case BOLD -> current.isBold();
            default -> current.getColor() != null;
        };
    }

    public static MutableComponent smartTranslate(String key, Object... components){
        if (components.length == 0) return translate(key);
        List<Object> args = new ArrayList<>();
        Style cachedStyle = Style.EMPTY;
        for (Object component : components) {
            if (component == null){
                args.add(null);
                cachedStyle = Style.EMPTY;
                continue;
            }
            MutableComponent current = null;
            if (component instanceof IHasTextComponent hasTextComponent) current = hasTextComponent.getTextComponent().copy();
            else if (component instanceof ITranslationKey translationKey) current = translate(translationKey.getTranslationKey());
            else if (component instanceof Block block) current = translate(block.getDescriptionId());
            else if (component instanceof Item item) current = translate(item.getDescriptionId());
            else if (component instanceof ItemStack stack) current = stack.getHoverName().copy();
            else if (component instanceof FluidStack stack) current = stack.getDisplayName().copy();
            else if (component instanceof Fluid fluid) current = translate(fluid.getFluidType().getDescriptionId());
            else if (component instanceof Direction direction) current = getTranslatedDirection(direction);
            else if (component instanceof Boolean bool) current = getTranslatedBoolean(bool);
            else if (component instanceof EnumColors colors && cachedStyle.getColor() == null){
                cachedStyle = cachedStyle.withColor(colors.getColor());
                continue;
            } else if (component instanceof ChatFormatting formatting && !hasStyleType(cachedStyle, formatting)) {
                cachedStyle = cachedStyle.applyFormat(formatting);
                continue;
            } else if (component instanceof ClickEvent event && cachedStyle.getClickEvent() == null) {
                cachedStyle = cachedStyle.withClickEvent(event);
                continue;
            } else if (component instanceof HoverEvent event && cachedStyle.getHoverEvent() == null) {
                cachedStyle = cachedStyle.withHoverEvent(event);
                continue;
            } else if (!cachedStyle.isEmpty()) {
                if (component instanceof Component) {
                    current = ((Component) component).copy();
                } else if (component instanceof EnumColors) {
                    current = ((EnumColors) component).getName();
                } else {
                    current = getString(component.toString());
                }
            } else if (component instanceof String) {
                component = cleanString((String) component);
            }
            if (!cachedStyle.isEmpty()) {
                if (current == null) {
                    args.add(component);
                } else {
                    args.add(current.setStyle(cachedStyle));
                }
                cachedStyle = Style.EMPTY;
            } else if (current == null) {
                args.add(component);
            } else {
                args.add(current);
            }
        }
        if (!cachedStyle.isEmpty()){
            Object lastComponent = components[components.length - 1];
            if (lastComponent instanceof EnumColors colors) args.add(colors.getName());
            else args.add(lastComponent);
        }
        return translate(key, args.toArray());
    }
}
