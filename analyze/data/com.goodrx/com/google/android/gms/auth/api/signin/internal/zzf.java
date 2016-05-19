package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzf extends IInterface {
   void zznf() throws RemoteException;

   public abstract static class zza extends Binder implements zzf {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.auth.api.signin.internal.IRevocationService");
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.auth.api.signin.internal.IRevocationService");
            this.zznf();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.auth.api.signin.internal.IRevocationService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }
}
