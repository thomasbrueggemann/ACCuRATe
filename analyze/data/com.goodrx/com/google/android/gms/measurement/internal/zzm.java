package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import java.util.List;

public interface zzm extends IInterface {
   List<UserAttributeParcel> zza(AppMetadata var1, boolean var2) throws RemoteException;

   void zza(AppMetadata var1) throws RemoteException;

   void zza(EventParcel var1, AppMetadata var2) throws RemoteException;

   void zza(EventParcel var1, String var2, String var3) throws RemoteException;

   void zza(UserAttributeParcel var1, AppMetadata var2) throws RemoteException;

   void zzb(AppMetadata var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzm {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
      }

      public static zzm zzdn(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            return (zzm)(var1 != null && var1 instanceof zzm?(zzm)var1:new zzm.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            EventParcel var18;
            if(var2.readInt() != 0) {
               var18 = EventParcel.CREATOR.zzfN(var2);
            } else {
               var18 = null;
            }

            int var19 = var2.readInt();
            AppMetadata var20 = null;
            if(var19 != 0) {
               var20 = AppMetadata.CREATOR.zzfL(var2);
            }

            this.zza(var18, var20);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            UserAttributeParcel var15;
            if(var2.readInt() != 0) {
               var15 = UserAttributeParcel.CREATOR.zzfO(var2);
            } else {
               var15 = null;
            }

            int var16 = var2.readInt();
            AppMetadata var17 = null;
            if(var16 != 0) {
               var17 = AppMetadata.CREATOR.zzfL(var2);
            }

            this.zza(var15, var17);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            int var13 = var2.readInt();
            AppMetadata var14 = null;
            if(var13 != 0) {
               var14 = AppMetadata.CREATOR.zzfL(var2);
            }

            this.zza(var14);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            int var11 = var2.readInt();
            EventParcel var12 = null;
            if(var11 != 0) {
               var12 = EventParcel.CREATOR.zzfN(var2);
            }

            this.zza(var12, var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            int var9 = var2.readInt();
            AppMetadata var10 = null;
            if(var9 != 0) {
               var10 = AppMetadata.CREATOR.zzfL(var2);
            }

            this.zzb(var10);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            int var5 = var2.readInt();
            AppMetadata var6 = null;
            if(var5 != 0) {
               var6 = AppMetadata.CREATOR.zzfL(var2);
            }

            boolean var7;
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            List var8 = this.zza(var6, var7);
            var3.writeNoException();
            var3.writeTypedList(var8);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.measurement.internal.IMeasurementService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzm {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public List<UserAttributeParcel> zza(AppMetadata param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(AppMetadata param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(EventParcel param1, AppMetadata param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(EventParcel param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(UserAttributeParcel param1, AppMetadata param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzb(AppMetadata param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
