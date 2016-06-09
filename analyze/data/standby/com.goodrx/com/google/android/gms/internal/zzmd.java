package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;

public final class zzmd extends LruCache<zzmd.zza, Drawable> {
   public static final class zza {
      public final int zzakx;
      public final int zzaky;

      public zza(int var1, int var2) {
         this.zzakx = var1;
         this.zzaky = var2;
      }

      public boolean equals(Object var1) {
         boolean var2 = true;
         if(!(var1 instanceof zzmd.zza)) {
            var2 = false;
         } else if(this != var1) {
            zzmd.zza var3 = (zzmd.zza)var1;
            if(var3.zzakx != this.zzakx || var3.zzaky != this.zzaky) {
               return false;
            }
         }

         return var2;
      }

      public int hashCode() {
         Object[] var1 = new Object[]{Integer.valueOf(this.zzakx), Integer.valueOf(this.zzaky)};
         return com.google.android.gms.common.internal.zzw.hashCode(var1);
      }
   }
}
