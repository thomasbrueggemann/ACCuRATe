package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzw {
   public static boolean equal(Object var0, Object var1) {
      return var0 == var1 || var0 != null && var0.equals(var1);
   }

   public static int hashCode(Object... var0) {
      return Arrays.hashCode(var0);
   }

   public static zzw.zza zzy(Object var0) {
      return new zzw.zza(var0);
   }

   public static final class zza {
      private final Object zzML;
      private final List<String> zzamp;

      private zza(Object var1) {
         this.zzML = zzx.zzz(var1);
         this.zzamp = new ArrayList();
      }

      // $FF: synthetic method
      zza(Object var1, Object var2) {
         this(var1);
      }

      public String toString() {
         StringBuilder var1 = (new StringBuilder(100)).append(this.zzML.getClass().getSimpleName()).append('{');
         int var2 = this.zzamp.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            var1.append((String)this.zzamp.get(var3));
            if(var3 < var2 - 1) {
               var1.append(", ");
            }
         }

         return var1.append('}').toString();
      }

      public zzw.zza zzg(String var1, Object var2) {
         this.zzamp.add((String)zzx.zzz(var1) + "=" + var2);
         return this;
      }
   }
}
