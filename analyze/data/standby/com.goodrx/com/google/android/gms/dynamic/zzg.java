package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzx;

public abstract class zzg<T> {
   private final String zzavI;
   private T zzavJ;

   protected zzg(String var1) {
      this.zzavI = var1;
   }

   protected final T zzaB(Context var1) throws zzg.zza {
      if(this.zzavJ == null) {
         zzx.zzz(var1);
         Context var3 = com.google.android.gms.common.zze.getRemoteContext(var1);
         if(var3 == null) {
            throw new zzg.zza("Could not get remote context.");
         }

         ClassLoader var4 = var3.getClassLoader();

         try {
            this.zzavJ = this.zzd((IBinder)var4.loadClass(this.zzavI).newInstance());
         } catch (ClassNotFoundException var8) {
            throw new zzg.zza("Could not load creator class.", var8);
         } catch (InstantiationException var9) {
            throw new zzg.zza("Could not instantiate creator.", var9);
         } catch (IllegalAccessException var10) {
            throw new zzg.zza("Could not access creator.", var10);
         }
      }

      return this.zzavJ;
   }

   protected abstract T zzd(IBinder var1);

   public static class zza extends Exception {
      public zza(String var1) {
         super(var1);
      }

      public zza(String var1, Throwable var2) {
         super(var1, var2);
      }
   }
}
