package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

public interface zzla extends IInterface {
   void zza(ProxyResponse var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzla {
      public static zzla zzaz(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthCallbacks");
            return (zzla)(var1 != null && var1 instanceof zzla?(zzla)var1:new zzla.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.auth.api.internal.IAuthCallbacks");
            ProxyResponse var5;
            if(var2.readInt() != 0) {
               var5 = (ProxyResponse)ProxyResponse.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.zza(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.auth.api.internal.IAuthCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzla {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(ProxyResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
