package com.google.android.gms.iid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzb extends IInterface {
   void send(Message var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzb {
      public static zzb zzcd(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
            return (zzb)(var1 != null && var1 instanceof zzb?(zzb)var1:new zzb.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.iid.IMessengerCompat");
            Message var5;
            if(var2.readInt() != 0) {
               var5 = (Message)Message.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.send(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.iid.IMessengerCompat");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzb {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void send(Message param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
