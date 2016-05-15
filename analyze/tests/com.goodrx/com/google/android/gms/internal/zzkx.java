package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.consent.GetConsentIntentRequest;

public interface zzkx extends IInterface {
   Intent zza(GetConsentIntentRequest var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzkx {
      public static zzkx zzau(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.auth.api.consent.internal.IConsentService");
            return (zzkx)(var1 != null && var1 instanceof zzkx?(zzkx)var1:new zzkx.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.auth.api.consent.internal.IConsentService");
            GetConsentIntentRequest var5;
            if(var2.readInt() != 0) {
               var5 = (GetConsentIntentRequest)GetConsentIntentRequest.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            Intent var6 = this.zza(var5);
            var3.writeNoException();
            if(var6 != null) {
               var3.writeInt(1);
               var6.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.auth.api.consent.internal.IConsentService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzkx {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public Intent zza(GetConsentIntentRequest param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
