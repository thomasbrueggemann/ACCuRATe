package com.google.android.gms.internal;

import com.google.android.gms.internal.class_341;
import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.aq
public class class_226 {
    // $FF: renamed from: a (java.lang.Character.UnicodeBlock) boolean
    private static boolean method_1533(UnicodeBlock var0) {
        return var0 == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || var0 == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || var0 == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || var0 == UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || var0 == UnicodeBlock.CJK_RADICALS_SUPPLEMENT || var0 == UnicodeBlock.CJK_COMPATIBILITY || var0 == UnicodeBlock.CJK_COMPATIBILITY_FORMS || var0 == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || var0 == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT || var0 == UnicodeBlock.BOPOMOFO || var0 == UnicodeBlock.HIRAGANA || var0 == UnicodeBlock.KATAKANA || var0 == UnicodeBlock.HANGUL_SYLLABLES || var0 == UnicodeBlock.HANGUL_JAMO;
    }

    // $FF: renamed from: d (int) boolean
    static boolean method_1534(int var0) {
        return Character.isLetter(var0) && method_1533(UnicodeBlock.of(var0));
    }

    // $FF: renamed from: o (java.lang.String) int
    public static int method_1535(String var0) {
        return class_341.method_2315(var0.getBytes(), 0, var0.length(), 0);
    }

    // $FF: renamed from: p (java.lang.String) java.lang.String[]
    public static String[] method_1536(String var0) {
        if(var0 == null) {
            return null;
        } else {
            ArrayList var1 = new ArrayList();
            char[] var2 = var0.toCharArray();
            int var3 = var0.length();
            boolean var4 = false;
            int var5 = 0;

            int var6;
            boolean var12;
            for(var6 = 0; var6 < var3; var4 = var12) {
                int var8 = Character.codePointAt(var2, var6);
                int var9 = Character.charCount(var8);
                int var11;
                if(method_1534(var8)) {
                    if(var4) {
                        var1.add(new String(var2, var5, var6 - var5));
                    }

                    var1.add(new String(var2, var6, var9));
                    var11 = var5;
                    var12 = false;
                } else if(Character.isLetterOrDigit(var8)) {
                    if(!var4) {
                        var5 = var6;
                    }

                    var11 = var5;
                    var12 = true;
                } else if(var4) {
                    var1.add(new String(var2, var5, var6 - var5));
                    var11 = var5;
                    var12 = false;
                } else {
                    var11 = var5;
                    var12 = var4;
                }

                var6 += var9;
                var5 = var11;
            }

            if(var4) {
                var1.add(new String(var2, var5, var6 - var5));
            }

            return (String[])var1.toArray(new String[var1.size()]);
        }
    }
}
