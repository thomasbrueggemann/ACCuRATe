package com.google.android.gms.internal;

import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zznd;
import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;

@zzhb
public class zzbi {
   private static boolean zza(UnicodeBlock var0) {
      return var0 == UnicodeBlock.BOPOMOFO || var0 == UnicodeBlock.BOPOMOFO_EXTENDED || var0 == UnicodeBlock.CJK_COMPATIBILITY || var0 == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || var0 == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT || var0 == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || var0 == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || var0 == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || var0 == UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS || var0 == UnicodeBlock.HANGUL_JAMO || var0 == UnicodeBlock.HANGUL_SYLLABLES || var0 == UnicodeBlock.HIRAGANA || var0 == UnicodeBlock.KATAKANA || var0 == UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS;
   }

   static boolean zzi(int var0) {
      return Character.isLetter(var0) && (zza(UnicodeBlock.of(var0)) || zzj(var0));
   }

   private static boolean zzj(int var0) {
      return var0 >= 'ｦ' && var0 <= 'ﾝ' || var0 >= 'ﾡ' && var0 <= 'ￜ';
   }

   public static int zzx(String var0) {
      byte[] var2;
      byte[] var3;
      try {
         var3 = var0.getBytes("UTF-8");
      } catch (UnsupportedEncodingException var4) {
         var2 = var0.getBytes();
         return zznd.zza(var2, 0, var2.length, 0);
      }

      var2 = var3;
      return zznd.zza(var2, 0, var2.length, 0);
   }

   public static String[] zzy(String var0) {
      if(var0 == null) {
         return null;
      } else {
         ArrayList var1 = new ArrayList();
         char[] var2 = var0.toCharArray();
         int var3 = var0.length();
         boolean var4 = false;
         int var5 = 0;

         int var6;
         boolean var11;
         for(var6 = 0; var6 < var3; var4 = var11) {
            int var8 = Character.codePointAt(var2, var6);
            int var9 = Character.charCount(var8);
            int var10;
            if(zzi(var8)) {
               if(var4) {
                  var1.add(new String(var2, var5, var6 - var5));
               }

               var1.add(new String(var2, var6, var9));
               var10 = var5;
               var11 = false;
            } else if(!Character.isLetterOrDigit(var8) && Character.getType(var8) != 6 && Character.getType(var8) != 8) {
               if(var4) {
                  var1.add(new String(var2, var5, var6 - var5));
                  var10 = var5;
                  var11 = false;
               } else {
                  var10 = var5;
                  var11 = var4;
               }
            } else {
               if(!var4) {
                  var5 = var6;
               }

               var10 = var5;
               var11 = true;
            }

            var6 += var9;
            var5 = var10;
         }

         if(var4) {
            var1.add(new String(var2, var5, var6 - var5));
         }

         return (String[])var1.toArray(new String[var1.size()]);
      }
   }
}
