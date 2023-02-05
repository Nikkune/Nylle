package net.nikkune.nylle.api.tiers;

import net.nikkune.nylle.api.texts.EnumColors;

import java.util.Locale;

public enum BaseTiers {
    TIN("Tin", EnumColors.AQUA, EnumColors.AQUA),
    LEAD("Lead", EnumColors.BLACK, EnumColors.DARK_GRAY),
    SILVER("Silver", EnumColors.GRAY, EnumColors.GRAY),
    PLATINUM("Platinum", EnumColors.DARK_RED, EnumColors.RED),
    IRIDIUM("Iridium", EnumColors.DARK_GREEN, EnumColors.DARK_GREEN),
    OSMIUM("Osmium", EnumColors.INDIGO, EnumColors.INDIGO),
    TUNGSTEN("Tungsten", EnumColors.BRIGHT_GREEN, EnumColors.BRIGHT_GREEN);

    private final String name;
    private final EnumColors color;
    private final EnumColors textColor;

    BaseTiers(String name, EnumColors color, EnumColors textColor) {
        this.name = name;
        this.color = color;
        this.textColor = textColor;
    }

    public String getName() {
        return name;
    }

    public String getLower() {
        return name.toLowerCase(Locale.ROOT);
    }

    public EnumColors getColor() {
        return color;
    }

    public EnumColors getTextColor() {
        return textColor;
    }
}
