package net.nikkune.nylle.api.tiers;

import net.nikkune.nylle.api.texts.EnumColors;

import java.util.Locale;

public enum BaseTiers {
    TIN("Tin", EnumColors.TIN, EnumColors.TIN),
    LEAD("Lead", EnumColors.LEAD, EnumColors.LEAD),
    SILVER("Silver", EnumColors.SILVER, EnumColors.SILVER),
    PLATINUM("Platinum", EnumColors.PLATINUM, EnumColors.PLATINUM),
    IRIDIUM("Iridium", EnumColors.IRIDIUM, EnumColors.IRIDIUM),
    OSMIUM("Osmium", EnumColors.OSMIUM, EnumColors.OSMIUM),
    TUNGSTEN("Tungsten", EnumColors.TUNGSTEN, EnumColors.TUNGSTEN);

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
