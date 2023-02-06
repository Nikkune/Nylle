package net.nikkune.nylle.api.texts;

import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.nikkune.nylle.Nylle;

public enum APILang implements ILangEntry{
    //Boolean
    TRUE_LOWER("gui", "true_lower"),
    FALSE_LOWER("gui", "false_lower"),
    //Directions
    DOWN("direction", "down"),
    UP("direction", "up"),
    NORTH("direction", "north"),
    SOUTH("direction", "south"),
    WEST("direction", "west"),
    EAST("direction", "east"),
    //Relative Sides
    FRONT("side", "front"),
    LEFT("side", "left"),
    RIGHT("side", "right"),
    BACK("side", "back"),
    TOP("side", "top"),
    BOTTOM("side", "bottom"),
    //Colors
    COLOR_BLACK("color", "black"),
    COLOR_DARK_BLUE("color", "dark_blue"),
    COLOR_DARK_GREEN("color", "dark_green"),
    COLOR_DARK_AQUA("color", "dark_aqua"),
    COLOR_DARK_RED("color", "dark_red"),
    COLOR_PURPLE("color", "purple"),
    COLOR_ORANGE("color", "orange"),
    COLOR_GRAY("color", "gray"),
    COLOR_DARK_GRAY("color", "dark_gray"),
    COLOR_INDIGO("color", "indigo"),
    COLOR_BRIGHT_GREEN("color", "bright_green"),
    COLOR_AQUA("color", "aqua"),
    COLOR_RED("color", "red"),
    COLOR_PINK("color", "pink"),
    COLOR_YELLOW("color", "yellow"),
    COLOR_WHITE("color", "white"),
    COLOR_BROWN("color", "brown"),
    COLOR_BRIGHT_PINK("color", "bright_pink"),
    COLOR_TIN("color", "tin"),
    COLOR_LEAD("color", "lead"),
    COLOR_SILVER("color", "silver"),
    COLOR_PLATINUM("color", "platinum"),
    COLOR_IRIDIUM("color", "iridium"),
    COLOR_OSMIUM("color", "osmium"),
    COLOR_TUNGSTEN("color", "tungsten"),
    //Security
    PUBLIC("security", "public"),
    TRUSTED("security", "trusted"),
    PRIVATE("security", "private"),
    ;

    private final String key;

    APILang(String type, String path) {
        this(Util.makeDescriptionId(type, new ResourceLocation(Nylle.MOD_ID, path)));
    }

    APILang(String key) {
        this.key = key;
    }


    @Override
    public String getTranslationKey() {
        return key;
    }
}
