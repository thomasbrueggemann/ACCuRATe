package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzab extends IInterface {
   void onSnapshotReady(Bitmap var1) throws RemoteException;

   void zzr(com.google.android.gms.dynamic.zzd var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzab {
      public static zzab zzcY(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            return (zzab)(var1 != null && var1 instanceof zzab?(zzab)var1:new zzab.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            Bitmap var5;
            if(var2.readInt() != 0) {
               var5 = (Bitmap)Bitmap.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.onSnapshotReady(var5);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            this.zzr(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzab {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void onSnapshotReady(Bitmap param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzr(com.google.android.gms.dynamic.zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
