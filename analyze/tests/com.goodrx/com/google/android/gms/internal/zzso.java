package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzsp;
import com.google.android.gms.internal.zzsq;
import com.google.android.gms.internal.zzsr;
import com.google.android.gms.internal.zzss;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsw;
import com.google.android.gms.internal.zzsx;
import java.io.IOException;

public abstract class zzso<M extends zzso<M>> extends zzsu {
   protected zzsq zzbuj;

   // $FF: synthetic method
   public zzsu clone() throws CloneNotSupportedException {
      return this.zzJp();
   }

   // $FF: synthetic method
   public Object clone() throws CloneNotSupportedException {
      return this.zzJp();
   }

   public void writeTo(zzsn var1) throws IOException {
      if(this.zzbuj != null) {
         for(int var2 = 0; var2 < this.zzbuj.size(); ++var2) {
            this.zzbuj.zzmG(var2).writeTo(var1);
         }
      }

   }

   public M zzJp() throws CloneNotSupportedException {
      zzso var1 = (zzso)super.clone();
      zzss.zza(this, var1);
      return var1;
   }

   public final <T> T zza(zzsp<M, T> var1) {
      if(this.zzbuj != null) {
         zzsr var2 = this.zzbuj.zzmF(zzsx.zzmJ(var1.tag));
         if(var2 != null) {
            return var2.zzb(var1);
         }
      }

      return null;
   }

   protected final boolean zza(zzsm var1, int var2) throws IOException {
      int var3 = var1.getPosition();
      if(!var1.zzmo(var2)) {
         return false;
      } else {
         int var4 = zzsx.zzmJ(var2);
         zzsw var5 = new zzsw(var2, var1.zzz(var3, var1.getPosition() - var3));
         zzsr var6 = null;
         if(this.zzbuj == null) {
            this.zzbuj = new zzsq();
         } else {
            var6 = this.zzbuj.zzmF(var4);
         }

         if(var6 == null) {
            var6 = new zzsr();
            this.zzbuj.zza(var4, var6);
         }

         var6.zza(var5);
         return true;
      }
   }

   protected int zzz() {
      int var1 = 0;
      int var2;
      if(this.zzbuj != null) {
         for(var2 = 0; var1 < this.zzbuj.size(); ++var1) {
            var2 += this.zzbuj.zzmG(var1).zzz();
         }
      } else {
         var2 = 0;
      }

      return var2;
   }
}
