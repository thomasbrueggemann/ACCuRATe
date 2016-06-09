package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzgc;

public interface zzgd extends IInterface {
   void zza(zzgc var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzgd {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            this.zza(zzgc.zza.zzO(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }
}
