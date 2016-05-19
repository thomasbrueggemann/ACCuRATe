package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.messages.internal.MessageWrapper;

public interface zzd extends IInterface {
   void zza(MessageWrapper var1) throws RemoteException;

   void zza(MessageWrapper[] var1) throws RemoteException;

   void zzb(MessageWrapper var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzd {
      public static zzd zzdy(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            return (zzd)(var1 != null && var1 instanceof zzd?(zzd)var1:new zzd.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            int var7 = var2.readInt();
            MessageWrapper var8 = null;
            if(var7 != 0) {
               var8 = MessageWrapper.CREATOR.zzgk(var2);
            }

            this.zza(var8);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            int var5 = var2.readInt();
            MessageWrapper var6 = null;
            if(var5 != 0) {
               var6 = MessageWrapper.CREATOR.zzgk(var2);
            }

            this.zzb(var6);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            this.zza((MessageWrapper[])var2.createTypedArray(MessageWrapper.CREATOR));
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.nearby.messages.internal.IMessageListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzd {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(MessageWrapper param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(MessageWrapper[] var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
            var2.writeTypedArray(var1, 0);
            this.zzoz.transact(4, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void zzb(MessageWrapper param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
