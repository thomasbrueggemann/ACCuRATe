package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzkt;

public interface zzku extends IInterface {
   void zza(Account var1, int var2, zzkt var3) throws RemoteException;

   public abstract static class zza extends Binder implements zzku {
      public static zzku zzas(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
            return (zzku)(var1 != null && var1 instanceof zzku?(zzku)var1:new zzku.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
            Account var5;
            if(var2.readInt() != 0) {
               var5 = (Account)Account.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.zza(var5, var2.readInt(), zzkt.zza.zzar(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzku {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(Account param1, int param2, zzkt param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
