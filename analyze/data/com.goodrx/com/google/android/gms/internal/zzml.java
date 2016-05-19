package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzmk;

public interface zzml extends IInterface {
   void zza(zzmk var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzml {
      public static zzml zzaY(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
            return (zzml)(var1 != null && var1 instanceof zzml?(zzml)var1:new zzml.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
            this.zza(zzmk.zza.zzaX(var2.readStrongBinder()));
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.service.ICommonService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzml {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(zzmk param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
