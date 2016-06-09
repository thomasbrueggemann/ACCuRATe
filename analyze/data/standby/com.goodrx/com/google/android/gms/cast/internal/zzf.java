package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import java.util.Locale;
import java.util.regex.Pattern;

public final class zzf {
   private static final Pattern zzaeb = Pattern.compile("urn:x-cast:[-A-Za-z0-9_]+(\\.[-A-Za-z0-9_]+)*");

   public static <T> boolean zza(T var0, T var1) {
      return var0 == null && var1 == null || var0 != null && var1 != null && var0.equals(var1);
   }

   public static String zzb(Locale var0) {
      StringBuilder var1 = new StringBuilder(20);
      var1.append(var0.getLanguage());
      String var3 = var0.getCountry();
      if(!TextUtils.isEmpty(var3)) {
         var1.append('-').append(var3);
      }

      String var4 = var0.getVariant();
      if(!TextUtils.isEmpty(var4)) {
         var1.append('-').append(var4);
      }

      return var1.toString();
   }
}
