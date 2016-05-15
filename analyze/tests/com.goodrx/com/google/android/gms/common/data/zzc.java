package com.google.android.gms.common.data;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public abstract class zzc {
   protected final DataHolder zzahi;
   protected int zzaje;
   private int zzajf;

   public zzc(DataHolder var1, int var2) {
      this.zzahi = (DataHolder)zzx.zzz(var1);
      this.zzbF(var2);
   }

   public boolean equals(Object var1) {
      boolean var2 = var1 instanceof zzc;
      boolean var3 = false;
      if(var2) {
         zzc var4 = (zzc)var1;
         boolean var5 = zzw.equal(Integer.valueOf(var4.zzaje), Integer.valueOf(this.zzaje));
         var3 = false;
         if(var5) {
            boolean var6 = zzw.equal(Integer.valueOf(var4.zzajf), Integer.valueOf(this.zzajf));
            var3 = false;
            if(var6) {
               DataHolder var7 = var4.zzahi;
               DataHolder var8 = this.zzahi;
               var3 = false;
               if(var7 == var8) {
                  var3 = true;
               }
            }
         }
      }

      return var3;
   }

   protected boolean getBoolean(String var1) {
      return this.zzahi.zze(var1, this.zzaje, this.zzajf);
   }

   protected byte[] getByteArray(String var1) {
      return this.zzahi.zzg(var1, this.zzaje, this.zzajf);
   }

   protected float getFloat(String var1) {
      return this.zzahi.zzf(var1, this.zzaje, this.zzajf);
   }

   protected int getInteger(String var1) {
      return this.zzahi.zzc(var1, this.zzaje, this.zzajf);
   }

   protected long getLong(String var1) {
      return this.zzahi.zzb(var1, this.zzaje, this.zzajf);
   }

   protected String getString(String var1) {
      return this.zzahi.zzd(var1, this.zzaje, this.zzajf);
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzaje), Integer.valueOf(this.zzajf), this.zzahi};
      return zzw.hashCode(var1);
   }

   protected void zzbF(int var1) {
      boolean var2;
      if(var1 >= 0 && var1 < this.zzahi.getCount()) {
         var2 = true;
      } else {
         var2 = false;
      }

      zzx.zzab(var2);
      this.zzaje = var1;
      this.zzajf = this.zzahi.zzbH(this.zzaje);
   }

   protected Uri zzcA(String var1) {
      return this.zzahi.zzh(var1, this.zzaje, this.zzajf);
   }

   protected boolean zzcB(String var1) {
      return this.zzahi.zzi(var1, this.zzaje, this.zzajf);
   }

   public boolean zzcz(String var1) {
      return this.zzahi.zzcz(var1);
   }

   protected int zzqc() {
      return this.zzaje;
   }
}
