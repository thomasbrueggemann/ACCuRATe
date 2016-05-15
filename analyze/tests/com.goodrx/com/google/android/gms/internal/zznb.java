package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zznb {
   private static final Pattern zzaoi = Pattern.compile("\\\\.");
   private static final Pattern zzaoj = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

   public static String zzcU(String var0) {
      if(!TextUtils.isEmpty(var0)) {
         Matcher var1 = zzaoj.matcher(var0);
         StringBuffer var2 = null;

         while(var1.find()) {
            if(var2 == null) {
               var2 = new StringBuffer();
            }

            switch(var1.group().charAt(0)) {
            case '\b':
               var1.appendReplacement(var2, "\\\\b");
               break;
            case '\t':
               var1.appendReplacement(var2, "\\\\t");
               break;
            case '\n':
               var1.appendReplacement(var2, "\\\\n");
               break;
            case '\f':
               var1.appendReplacement(var2, "\\\\f");
               break;
            case '\r':
               var1.appendReplacement(var2, "\\\\r");
               break;
            case '\"':
               var1.appendReplacement(var2, "\\\\\\\"");
               break;
            case '/':
               var1.appendReplacement(var2, "\\\\/");
               break;
            case '\\':
               var1.appendReplacement(var2, "\\\\\\\\");
            }
         }

         if(var2 != null) {
            var1.appendTail(var2);
            return var2.toString();
         }
      }

      return var0;
   }
}
