package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class Utils {
    private static final char[] HEXBYTES = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String filterCampaign(String var0) {
        if(TextUtils.isEmpty(var0)) {
            return null;
        } else {
            String var1 = var0;
            if(var0.contains("?")) {
                String[] var10 = var0.split("[\\?]");
                if(var10.length > 1) {
                    var1 = var10[1];
                }
            }

            if(var1.contains("%3D")) {
                String var9;
                try {
                    var9 = URLDecoder.decode(var1, "UTF-8");
                } catch (UnsupportedEncodingException var11) {
                    return null;
                }

                var1 = var9;
            } else if(!var1.contains("=")) {
                return null;
            }

            Map var2 = parseURLParameters(var1);
            String[] var3 = new String[] {"dclid", "utm_source", "gclid", "utm_campaign", "utm_medium", "utm_term", "utm_content", "utm_id", "gmob_t"};
            StringBuilder var4 = new StringBuilder();

            for(int var5 = 0; var5 < var3.length; ++var5) {
                if(!TextUtils.isEmpty((CharSequence)var2.get(var3[var5]))) {
                    if(var4.length() > 0) {
                        var4.append("&");
                    }

                    var4.append(var3[var5]).append("=").append((String)var2.get(var3[var5]));
                }
            }

            return var4.toString();
        }
    }

    static int fromHexDigit(char var0) {
        int var1 = var0 - 48;
        if(var1 > 9) {
            var1 -= 7;
        }

        return var1;
    }

    static String getLanguage(Locale var0) {
        if(var0 != null && !TextUtils.isEmpty(var0.getLanguage())) {
            StringBuilder var1 = new StringBuilder();
            var1.append(var0.getLanguage().toLowerCase());
            if(!TextUtils.isEmpty(var0.getCountry())) {
                var1.append("-").append(var0.getCountry().toLowerCase());
            }

            return var1.toString();
        } else {
            return null;
        }
    }

    static byte[] hexDecode(String var0) {
        byte[] var1 = new byte[var0.length() / 2];

        for(int var2 = 0; var2 < var1.length; ++var2) {
            var1[var2] = (byte)(fromHexDigit(var0.charAt(var2 * 2)) << 4 | fromHexDigit(var0.charAt(1 + var2 * 2)));
        }

        return var1;
    }

    static String hexEncode(byte[] var0) {
        char[] var1 = new char[2 * var0.length];

        for(int var2 = 0; var2 < var0.length; ++var2) {
            int var3 = 255 & var0[var2];
            var1[var2 * 2] = HEXBYTES[var3 >> 4];
            var1[1 + var2 * 2] = HEXBYTES[var3 & 15];
        }

        return new String(var1);
    }

    public static Map<String, String> parseURLParameters(String var0) {
        HashMap var1 = new HashMap();
        String[] var2 = var0.split("&");
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String[] var5 = var2[var4].split("=");
            if(var5.length > 1) {
                var1.put(var5[0], var5[1]);
            } else if(var5.length == 1 && var5[0].length() != 0) {
                var1.put(var5[0], (Object)null);
            }
        }

        return var1;
    }

    public static void putIfAbsent(Map<String, String> var0, String var1, String var2) {
        if(!var0.containsKey(var1)) {
            var0.put(var1, var2);
        }

    }

    public static boolean safeParseBoolean(String var0, boolean var1) {
        if(var0 != null) {
            if(!var0.equalsIgnoreCase("true") && !var0.equalsIgnoreCase("yes") && !var0.equalsIgnoreCase("1")) {
                if(var0.equalsIgnoreCase("false") || var0.equalsIgnoreCase("no") || var0.equalsIgnoreCase("0")) {
                    return false;
                }
            } else {
                var1 = true;
            }
        }

        return var1;
    }

    public static double safeParseDouble(String var0) {
        return safeParseDouble(var0, 0.0D);
    }

    public static double safeParseDouble(String var0, double var1) {
        if(var0 == null) {
            return var1;
        } else {
            try {
                double var4 = Double.parseDouble(var0);
                return var4;
            } catch (NumberFormatException var6) {
                return var1;
            }
        }
    }

    public static long safeParseLong(String var0) {
        if(var0 == null) {
            return 0L;
        } else {
            try {
                long var2 = Long.parseLong(var0);
                return var2;
            } catch (NumberFormatException var4) {
                return 0L;
            }
        }
    }
}
