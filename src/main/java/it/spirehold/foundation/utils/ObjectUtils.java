package com.waveinformatica.hello.foundation.utils;

import java.util.Arrays;
import java.util.List;

public class ObjectUtils {

    public static String getAsString(Object obj) {
        return obj == null ? null : obj.toString();
    }

    public static boolean getAsBoolean(Object obj, boolean defaultValue) {
        if (obj instanceof Boolean b) {
            return b;
        }

        return defaultValue;
    }

    public static <T> List<T> asList(T... objects) {
        return objects == null ? null : Arrays.asList(objects);
    }

    public static <T> T coalesce(T... objects) {
        for (T obj : objects) {
            if (obj != null) {
                return obj;
            }
        }

        return null;
    }

    public static String formatBinary(int i, int digits) {
        return String.format(String.format("%%%ds", digits), Integer.toBinaryString(i))
            .replace(' ', '0');
    }
}
