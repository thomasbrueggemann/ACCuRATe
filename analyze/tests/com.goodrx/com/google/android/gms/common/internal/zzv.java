package com.google.android.gms.common.internal;

import java.util.Iterator;

public class zzv {
   private final String separator;

   private zzv(String var1) {
      this.separator = var1;
   }

   public static zzv zzcL(String var0) {
      return new zzv(var0);
   }

   public final String zza(Iterable<?> var1) {
      return this.zza(new StringBuilder(), var1).toString();
   }

   public final StringBuilder zza(StringBuilder var1, Iterable<?> var2) {
      Iterator var3 = var2.iterator();
      if(var3.hasNext()) {
         var1.append(this.zzx(var3.next()));

         while(var3.hasNext()) {
            var1.append(this.separator);
            var1.append(this.zzx(var3.next()));
         }
      }

      return var1;
   }

   CharSequence zzx(Object var1) {
      return (CharSequence)(var1 instanceof CharSequence?(CharSequence)var1:var1.toString());
   }
}
