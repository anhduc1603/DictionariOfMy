package com.example.dictionariofmy.util;

import java.util.Collection;
import java.util.Map;

public class Util {
    public static boolean isEmpty(String input) {
        if (input == null || input.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static <E> boolean isEmpty(Collection<E> collection) {
        if (collection == null || collection.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Object[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        if (map == null || map.size() == 0) {
            return true;
        }
        return false;
    }


    public static String getValue(String[] strArr, int idx) {
        if (isEmpty(strArr)) {
            return null;
        }
        if (idx > strArr.length - 1) {
            return null;
        }
        return strArr[idx];
    }

    /**
     * Hiện tại đang xét với Double và Long
     *
     * @param value
     * @param varType
     * @return
     */
    public static boolean isNumber(String value, String varType) {
        try {
            if (varType.equals("Double")) {
                Double.parseDouble(value);
            } else if (varType.equals("Long")) {
                Long.parseLong(value);
            } else {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Check 1 số có là số thập phân hay không
     *
     * @return
     */
    public static boolean isDecimal(Double number) {
        return number % 1 != 0;
    }


    public static String distinctSpaces(String name) {
        String str = name.trim();
        while (str.indexOf("  ") > 0)
            str = str.replace("  ", " ");
        return str;
    }

    /**
     * check string NULL
     */
    public static String stringNVL(Object str) {
        return stringNVL(str, "");
    }

    public static String stringNVL(Object str, String valueIfNull) {
        return (str == null) ? valueIfNull : str.toString().trim();
    }
}
