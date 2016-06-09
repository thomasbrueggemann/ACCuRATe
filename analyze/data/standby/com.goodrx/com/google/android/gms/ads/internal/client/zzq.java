package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzq extends IInterface {
   void onAdClosed() throws RemoteException;

   void onAdFailedToLoad(int var1) throws RemoteException;

   void onAdLeftApplication() throws RemoteException;

   void onAdLoaded() throws RemoteException;

   void onAdOpened() throws RemoteException;

   public abstract static class zza extends Binder implements zzq {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.client.IAdListener");
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdListener");
            this.onAdClosed();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdListener");
            this.onAdFailedToLoad(var2.readInt());
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdListener");
            this.onAdLeftApplication();
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdListener");
            this.onAdLoaded();
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdListener");
            this.onAdOpened();
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.client.IAdListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }
}
