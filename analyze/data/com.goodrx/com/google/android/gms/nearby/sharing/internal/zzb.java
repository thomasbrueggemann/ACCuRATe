package com.google.android.gms.nearby.sharing.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.sharing.SharedContent;
import java.util.ArrayList;
import java.util.List;

public interface zzb extends IInterface {
   List<SharedContent> zzEO() throws RemoteException;

   public abstract static class zza extends Binder implements zzb {
      public static zzb zzdG(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.nearby.sharing.internal.IContentProvider");
            return (zzb)(var1 != null && var1 instanceof zzb?(zzb)var1:new zzb.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.nearby.sharing.internal.IContentProvider");
            List var5 = this.zzEO();
            var3.writeNoException();
            var3.writeTypedList(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.nearby.sharing.internal.IContentProvider");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzb {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public List<SharedContent> zzEO() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         ArrayList var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.IContentProvider");
            this.zzoz.transact(2, var1, var2, 0);
            var2.readException();
            var5 = var2.createTypedArrayList(SharedContent.CREATOR);
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }
   }
}
