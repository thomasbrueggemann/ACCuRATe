package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.internal.zzla;

public interface zzlb extends IInterface {
   void zza(zzla var1, ProxyGrpcRequest var2) throws RemoteException;

   void zza(zzla var1, ProxyRequest var2) throws RemoteException;

   public abstract static class zza extends Binder implements zzlb {
      public static zzlb zzaA(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
            return (zzlb)(var1 != null && var1 instanceof zzlb?(zzlb)var1:new zzlb.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
            zzla var8 = zzla.zza.zzaz(var2.readStrongBinder());
            int var9 = var2.readInt();
            ProxyRequest var10 = null;
            if(var9 != 0) {
               var10 = (ProxyRequest)ProxyRequest.CREATOR.createFromParcel(var2);
            }

            this.zza(var8, var10);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
            zzla var5 = zzla.zza.zzaz(var2.readStrongBinder());
            int var6 = var2.readInt();
            ProxyGrpcRequest var7 = null;
            if(var6 != 0) {
               var7 = (ProxyGrpcRequest)ProxyGrpcRequest.CREATOR.createFromParcel(var2);
            }

            this.zza(var5, var7);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.auth.api.internal.IAuthService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzlb {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(zzla param1, ProxyGrpcRequest param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzla param1, ProxyRequest param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
