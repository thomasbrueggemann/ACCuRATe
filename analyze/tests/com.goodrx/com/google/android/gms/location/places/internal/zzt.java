package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public abstract class zzt extends zzc {
   private final String TAG = "SafeDataBufferRef";

   public zzt(DataHolder var1, int var2) {
      super(var1, var2);
   }

   protected String zzG(String var1, String var2) {
      if(this.zzcz(var1) && !this.zzcB(var1)) {
         var2 = this.getString(var1);
      }

      return var2;
   }

   protected int zzz(String var1, int var2) {
      if(this.zzcz(var1) && !this.zzcB(var1)) {
         var2 = this.getInteger(var1);
      }

      return var2;
   }
}
