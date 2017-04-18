package com.venus.android.utils;

import android.text.TextUtils;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public class ValidateUtil {
    public static boolean isMobileNum(String str) {
        String str2 = "[1][34578]\\d{9}";
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(str2);
    }

    public static boolean isLeaglePasswd(String str) {
        if (TextUtils.isEmpty(str) || str.length() > 20 || str.length() < 6) {
            return false;
        }
        return true;
    }

    public static boolean checkTellNum(String str) {
        return str.matches("^(0[0-9]{2,3}-)?([2-9][0-9]{6,7})+(-[0-9]{1,4})?$");
    }

    public static boolean checkBankCard(String str) {
        if (str.length() <= 14) {
            return false;
        }
        String replace = str.replace(" ", "");
        char bankCardCheckCode = getBankCardCheckCode(replace.substring(0, replace.length() - 1));
        if (bankCardCheckCode == 'N' || replace.charAt(replace.length() - 1) != bankCardCheckCode) {
            return false;
        }
        return true;
    }

    public static char getBankCardCheckCode(String str) {
        if (str == null || str.trim().length() == 0 || !str.matches("\\d+")) {
            return 'N';
        }
        char[] toCharArray = str.trim().toCharArray();
        int length = toCharArray.length - 1;
        int i = 0;
        int i2 = 0;
        while (length >= 0) {
            int i3 = toCharArray[length] - 48;
            if (i2 % 2 == 0) {
                i3 *= 2;
                i3 = (i3 % 10) + (i3 / 10);
            }
            i += i3;
            length--;
            i2++;
        }
        return i % 10 == 0 ? '0' : (char) ((10 - (i % 10)) + 48);
    }

    public static final boolean isNull(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNull(Integer num) {
        if (num == null || num.intValue() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNull(Collection collection) {
        if (collection == null || collection.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNull(Map map) {
        if (map == null || map.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNull(String str) {
        return str == null || "".equals(str.trim()) || "null".equals(str.toLowerCase());
    }

    public static final boolean isNull(Long l) {
        if (l == null || l.longValue() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotNull(Long l) {
        return !isNull(l);
    }

    public static final boolean isNotNull(String str) {
        return !isNull(str);
    }

    public static final boolean isNotNull(Collection collection) {
        return !isNull(collection);
    }

    public static final boolean isNotNull(Map map) {
        return !isNull(map);
    }

    public static final boolean isNotNull(Integer num) {
        return !isNull(num);
    }

    public static final boolean isNotNull(Object[] objArr) {
        return !isNull(objArr);
    }

    public static final boolean isUrl(String str) {
        return a(str, "^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$");
    }

    public static final boolean isPwd(String str) {
        return a(str, "^[a-zA-Z]\\w{6,12}$");
    }

    public static final boolean stringCheck(String str) {
        return a(str, "^[a-zA-Z0-9一-龥-_]+$");
    }

    public static final boolean isEmail(String str) {
        return a(str, "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    }

    public static final boolean isInteger(String str) {
        return a(str, "^[+]?\\d+$");
    }

    public static final boolean isNumeric(String str) {
        if (isFloat(str) || isInteger(str)) {
            return true;
        }
        return false;
    }

    public static final boolean isDigits(String str) {
        return a(str, "^[0-9]*$");
    }

    public static final boolean isFloat(String str) {
        return a(str, "^[-\\+]?\\d+(\\.\\d+)?$");
    }

    public static final boolean isTel(String str) {
        if (isMobile(str) || isPhone(str)) {
            return true;
        }
        return false;
    }

    public static final boolean isPhone(String str) {
        return a(str, "^(\\d{3,4}-?)?\\d{7,9}$");
    }

    public static final boolean isMobile(String str) {
        if (str.length() != 11) {
            return false;
        }
        return a(str, "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$");
    }

    public static final boolean isIdCardNo(String str) {
        return a(str, "^(\\d{6})()?(\\d{4})(\\d{2})(\\d{2})(\\d{3})(\\w)$");
    }

    public static final boolean isZipCode(String str) {
        return a(str, "^[0-9]{6}$");
    }

    public static final boolean isIntEqZero(int i) {
        return i == 0;
    }

    public static final boolean isIntGtZero(int i) {
        return i > 0;
    }

    public static final boolean isIntGteZero(int i) {
        return i >= 0;
    }

    public static final boolean isFloatEqZero(float f) {
        return f == 0.0f;
    }

    public static final boolean isFloatGtZero(float f) {
        return f > 0.0f;
    }

    public static final boolean isFloatGteZero(float f) {
        return f >= 0.0f;
    }

    public static final boolean isRightfulString(String str) {
        return a(str, "^[A-Za-z0-9_-]+$");
    }

    public static final boolean isEnglish(String str) {
        return a(str, "^[A-Za-z]+$");
    }

    public static final boolean isChineseChar(String str) {
        return a(str, "^[Α-￥]+$");
    }

    public static final boolean isChinese(String str) {
        return a(str, "^[一-龥]+$");
    }

    public static String stringFilter(String str) {
        return Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(str).replaceAll("").trim();
    }

    public static String htmlFilter(String str) {
        String str2 = "";
        try {
            str2 = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE).matcher(Pattern.compile("<[^>]+>", Pattern.CASE_INSENSITIVE).matcher(Pattern.compile("<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>", Pattern.CASE_INSENSITIVE).matcher(Pattern.compile("<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>", Pattern.CASE_INSENSITIVE).matcher(str).replaceAll("")).replaceAll("")).replaceAll("")).replaceAll("");
        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }
        return str2;
    }

    private static final boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return Pattern.compile(str2).matcher(str).matches();
    }
}
