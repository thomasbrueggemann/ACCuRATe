package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzp extends IInterface {
   Account getAccount() throws RemoteException;

   public abstract static class zza extends Binder implements zzp {
      public static zzp zzaP(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return (zzp)(var1 != null && var1 instanceof zzp?(zzp)var1:new zzp.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.common.internal.IAccountAccessor");
            Account var5 = this.getAccount();
            var3.writeNoException();
            if(var5 != null) {
               var3.writeInt(1);
               var5.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.IAccountAccessor");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzp {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public Account getAccount() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Account var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.common.internal.IAccountAccessor");
               this.zzoz.transact(2, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Account)Account.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }
   }
}
