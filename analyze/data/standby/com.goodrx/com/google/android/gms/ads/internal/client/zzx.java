package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzx extends IInterface {
   long getValue() throws RemoteException;

   public abstract static class zza extends Binder implements zzx {
      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
            long var5 = this.getValue();
            var3.writeNoException();
            var3.writeLong(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }
}
