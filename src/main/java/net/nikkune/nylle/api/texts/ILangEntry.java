package net.nikkune.nylle.api.texts;

import net.minecraft.network.chat.MutableComponent;

public interface ILangEntry extends ITranslationKey{
    default MutableComponent translate(Object... args){
        return TextComponentUtils.smartTranslate(getTranslationKey(), args);
    }

    default MutableComponent translateColored(EnumColors colors, Object... args){
        return TextComponentUtils.build(colors, translate(args));
    }
}
