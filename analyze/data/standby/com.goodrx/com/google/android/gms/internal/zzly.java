package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.internal.zzlx;

public interface zzly extends IInterface {
   void zza(zzlx var1, LogEventParcelable var2) throws RemoteException;

   public abstract static class zza extends Binder implements zzly {
      public static zzly zzaM(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            return (zzly)(var1 != null && var1 instanceof zzly?(zzly)var1:new zzly.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            zzlx var5 = zzlx.zza.zzaL(var2.readStrongBinder());
            LogEventParcelable var6;
            if(var2.readInt() != 0) {
               var6 = LogEventParcelable.CREATOR.zzaf(var2);
            } else {
               var6 = null;
            }

            this.zza(var5, var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzly {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(zzlx param1, LogEventParcelable param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
