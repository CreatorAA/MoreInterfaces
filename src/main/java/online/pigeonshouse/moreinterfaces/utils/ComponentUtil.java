package online.pigeonshouse.moreinterfaces.utils;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class ComponentUtil {
    public static MutableComponent literal(String text) {
        return Component.literal(text);
    }

    public static MutableComponent translatable(String s, Object... objects) {
        return Component.translatable(s, objects);
    }
}
