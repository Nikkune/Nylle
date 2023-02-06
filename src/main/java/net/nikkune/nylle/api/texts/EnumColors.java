package net.nikkune.nylle.api.texts;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.material.MaterialColor;

import javax.annotation.Nullable;

public enum EnumColors {
    BLACK("\u00a70", APILang.COLOR_BLACK, "Black", "black", new int[]{64, 64, 64}, DyeColor.BLACK),
    DARK_BLUE("\u00a71", APILang.COLOR_DARK_BLUE, "Blue", "blue", new int[]{54, 107, 208}, DyeColor.BLUE),
    DARK_GREEN("\u00a72", APILang.COLOR_DARK_GREEN, "Green", "green", new int[]{89, 193, 95}, DyeColor.GREEN),
    DARK_AQUA("\u00a73", APILang.COLOR_DARK_AQUA, "Cyan", "cyan", new int[]{0, 243, 208}, DyeColor.CYAN),
    DARK_RED("\u00a74", APILang.COLOR_DARK_RED, "Dark Red", "dark_red", new int[]{201, 7, 31}, MaterialColor.NETHER, null),
    PURPLE("\u00a75", APILang.COLOR_PURPLE, "Purple", "purple", new int[]{164, 96, 217}, DyeColor.PURPLE),
    ORANGE("\u00a76", APILang.COLOR_ORANGE, "Orange", "orange", new int[]{255, 161, 96}, DyeColor.ORANGE),
    GRAY("\u00a77", APILang.COLOR_GRAY, "Light Gray", "light_gray", new int[]{207, 207, 207}, DyeColor.LIGHT_GRAY),
    DARK_GRAY("\u00a78", APILang.COLOR_DARK_GRAY, "Gray", "gray", new int[]{122, 122, 122}, DyeColor.GRAY),
    INDIGO("\u00a79", APILang.COLOR_INDIGO, "Light Blue", "light_blue", new int[]{85, 158, 255}, DyeColor.LIGHT_BLUE),
    BRIGHT_GREEN("\u00a7a", APILang.COLOR_BRIGHT_GREEN, "Lime", "lime", new int[]{117, 255, 137}, DyeColor.LIME),
    AQUA("\u00a7b", APILang.COLOR_AQUA, "Aqua", "aqua", new int[]{48, 255, 249}, MaterialColor.COLOR_LIGHT_BLUE, null),
    RED("\u00a7c", APILang.COLOR_RED, "Red", "red", new int[]{255, 56, 60}, DyeColor.RED),
    PINK("\u00a7d", APILang.COLOR_PINK, "Magenta", "magenta", new int[]{213, 94, 203}, DyeColor.MAGENTA),
    YELLOW("\u00a7e", APILang.COLOR_YELLOW, "Yellow", "yellow", new int[]{255, 221, 79}, DyeColor.YELLOW),
    WHITE("\u00a7f", APILang.COLOR_WHITE, "White", "white", new int[]{255, 255, 255}, DyeColor.WHITE),
    BROWN("\u00a76", APILang.COLOR_BROWN, "Brown", "brown", new int[]{161, 118, 73}, DyeColor.BROWN),
    BRIGHT_PINK("\u00a7d", APILang.COLOR_BRIGHT_PINK, "Pink", "pink", new int[]{255, 188, 196}, DyeColor.PINK),
    TIN("\u00a77", APILang.COLOR_TIN, "Tin", "tin", new int[]{69, 86, 92}, DyeColor.LIGHT_BLUE),
    LEAD("\u00a70", APILang.COLOR_LEAD, "Lead", "lead", new int[]{40, 40, 40}, DyeColor.GRAY),
    SILVER("\u00a77", APILang.COLOR_SILVER, "Silver", "silver", new int[]{133, 145, 150}, DyeColor.LIGHT_BLUE),
    PLATINUM("\u00a7c", APILang.COLOR_PLATINUM, "Platinum", "platinum", new int[]{126, 111, 109}, DyeColor.RED),
    IRIDIUM("\u00a7a", APILang.COLOR_IRIDIUM, "Iridium", "iridium", new int[]{76, 86, 75}, DyeColor.GREEN),
    OSMIUM("\u00a71", APILang.COLOR_OSMIUM, "Osmium", "osmium", new int[]{67, 74, 94}, DyeColor.BLUE),
    TUNGSTEN("\u00a7a", APILang.COLOR_TUNGSTEN, "Tungsten", "tungsten", new int[]{116, 126, 109}, DyeColor.LIME),
    ;

    public final String minecraftCode;
    private int[] rgbCode;
    private TextColor color;
    private final APILang langEntry;
    private final String englishName;
    private final String registryPrefix;
    @Nullable
    private final DyeColor dyeColor;
    private final MaterialColor mapColor;

    EnumColors(String minecraftCode, APILang langEntry, String englishName, String registryPrefix, int[] rgbCode, DyeColor dyeColor) {
        this(minecraftCode, langEntry, englishName, registryPrefix, rgbCode, dyeColor.getMaterialColor(), dyeColor);
    }

    EnumColors(String minecraftCode, APILang langEntry, String englishName, String registryPrefix, int[] rgbCode, MaterialColor mapColor, @Nullable DyeColor dyeColor) {
        this.minecraftCode = minecraftCode;
        this.langEntry = langEntry;
        this.englishName = englishName;
        this.registryPrefix = registryPrefix;
        this.dyeColor = dyeColor;
        setColorFromAtlas(rgbCode);
        this.mapColor = mapColor;
    }

    public String getMinecraftCode() {
        return minecraftCode;
    }

    public int[] getRgbCode() {
        return rgbCode;
    }

    public TextColor getColor() {
        return color;
    }

    public float getColor(int index) {
        return rgbCode[index] / 255f;
    }

    public APILang getLangEntry() {
        return langEntry;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getRegistryPrefix() {
        return registryPrefix;
    }

    @Nullable
    public DyeColor getDyeColor() {
        return dyeColor;
    }

    public MaterialColor getMapColor() {
        return mapColor;
    }

    @Override
    public String toString() {
        return minecraftCode;
    }

    public Component getColoredName() {
        return TextComponentUtils.build(this, getName());
    }

    public MutableComponent getName() {
        return langEntry.translate();
    }

    public void setColorFromAtlas(int[] color) {
        rgbCode = color;
        this.color = TextColor.fromRgb(rgbCode[0] << 16 | rgbCode[1] << 8 | rgbCode[2]);
    }

    public float[] getRgbCodeFloat() {
        return new float[]{getColor(0), getColor(1), getColor(2)};
    }
}
