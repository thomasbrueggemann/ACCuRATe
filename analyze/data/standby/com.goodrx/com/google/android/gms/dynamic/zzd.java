package com.google.android.gms.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzd extends IInterface {
   public abstract static class zza extends Binder implements zzd {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
      }

      public static zzd zzbs(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (zzd)(var1 != null && var1 instanceof zzd?(zzd)var1:new zzd.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1598968902:
            var3.writeString("com.google.android.gms.dynamic.IObjectWrapper");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzd {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }
   }
}
