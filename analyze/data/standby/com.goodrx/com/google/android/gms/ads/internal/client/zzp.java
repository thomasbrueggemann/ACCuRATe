package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzp extends IInterface {
   void onAdClicked() throws RemoteException;

   public abstract static class zza extends Binder implements zzp {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.client.IAdClickListener");
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
            this.onAdClicked();
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.client.IAdClickListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }
}
