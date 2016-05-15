package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.LocationRequestUpdateData;
import com.google.android.gms.location.internal.ParcelableGeofence;
import com.google.android.gms.location.internal.zzg;
import com.google.android.gms.location.internal.zzh;
import com.google.android.gms.location.internal.zzj;
import java.util.ArrayList;
import java.util.List;

public interface zzi extends IInterface {
   void zza(long var1, boolean var3, PendingIntent var4) throws RemoteException;

   void zza(PendingIntent var1) throws RemoteException;

   void zza(PendingIntent var1, com.google.android.gms.common.api.internal.zzo var2) throws RemoteException;

   void zza(PendingIntent var1, zzh var2, String var3) throws RemoteException;

   void zza(Location var1, int var2) throws RemoteException;

   void zza(GeofencingRequest var1, PendingIntent var2, zzh var3) throws RemoteException;

   void zza(GestureRequest var1, PendingIntent var2, com.google.android.gms.common.api.internal.zzo var3) throws RemoteException;

   void zza(LocationRequest var1, PendingIntent var2) throws RemoteException;

   void zza(LocationRequest var1, com.google.android.gms.location.zzd var2) throws RemoteException;

   void zza(LocationRequest var1, com.google.android.gms.location.zzd var2, String var3) throws RemoteException;

   void zza(LocationSettingsRequest var1, zzj var2, String var3) throws RemoteException;

   void zza(LocationRequestInternal var1, PendingIntent var2) throws RemoteException;

   void zza(LocationRequestInternal var1, com.google.android.gms.location.zzd var2) throws RemoteException;

   void zza(LocationRequestUpdateData var1) throws RemoteException;

   void zza(zzg var1) throws RemoteException;

   void zza(zzh var1, String var2) throws RemoteException;

   void zza(com.google.android.gms.location.zzd var1) throws RemoteException;

   void zza(List<ParcelableGeofence> var1, PendingIntent var2, zzh var3, String var4) throws RemoteException;

   void zza(String[] var1, zzh var2, String var3) throws RemoteException;

   void zzam(boolean var1) throws RemoteException;

   void zzb(PendingIntent var1) throws RemoteException;

   void zzb(PendingIntent var1, com.google.android.gms.common.api.internal.zzo var2) throws RemoteException;

   void zzc(PendingIntent var1, com.google.android.gms.common.api.internal.zzo var2) throws RemoteException;

   void zzc(Location var1) throws RemoteException;

   void zzd(PendingIntent var1, com.google.android.gms.common.api.internal.zzo var2) throws RemoteException;

   void zze(PendingIntent var1, com.google.android.gms.common.api.internal.zzo var2) throws RemoteException;

   ActivityRecognitionResult zzeh(String var1) throws RemoteException;

   Location zzei(String var1) throws RemoteException;

   LocationAvailability zzej(String var1) throws RemoteException;

   Location zzyN() throws RemoteException;

   public abstract static class zza extends Binder implements zzi {
      public static zzi zzcj(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (zzi)(var1 != null && var1 instanceof zzi?(zzi)var1:new zzi.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            ArrayList var42 = var2.createTypedArrayList(ParcelableGeofence.CREATOR);
            PendingIntent var43;
            if(var2.readInt() != 0) {
               var43 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var43 = null;
            }

            this.zza(var42, var43, zzh.zza.zzci(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            PendingIntent var39;
            if(var2.readInt() != 0) {
               var39 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var39 = null;
            }

            this.zza(var39, zzh.zza.zzci(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.zza(var2.createStringArray(), zzh.zza.zzci(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.zza(zzh.zza.zzci(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            long var35 = var2.readLong();
            boolean var37;
            if(var2.readInt() != 0) {
               var37 = true;
            } else {
               var37 = false;
            }

            PendingIntent var38;
            if(var2.readInt() != 0) {
               var38 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var38 = null;
            }

            this.zza(var35, var37, var38);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            PendingIntent var34;
            if(var2.readInt() != 0) {
               var34 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var34 = null;
            }

            this.zza(var34);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Location var25 = this.zzyN();
            var3.writeNoException();
            if(var25 != null) {
               var3.writeInt(1);
               var25.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            int var23 = var2.readInt();
            LocationRequest var24 = null;
            if(var23 != 0) {
               var24 = LocationRequest.CREATOR.createFromParcel(var2);
            }

            this.zza(var24, com.google.android.gms.location.zzd.zza.zzcf(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            LocationRequest var19;
            if(var2.readInt() != 0) {
               var19 = LocationRequest.CREATOR.createFromParcel(var2);
            } else {
               var19 = null;
            }

            PendingIntent var20;
            if(var2.readInt() != 0) {
               var20 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var20 = null;
            }

            this.zza(var19, var20);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.zza(com.google.android.gms.location.zzd.zza.zzcf(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            PendingIntent var14;
            if(var2.readInt() != 0) {
               var14 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var14 = null;
            }

            this.zzb(var14);
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            int var10 = var2.readInt();
            boolean var11 = false;
            if(var10 != 0) {
               var11 = true;
            }

            this.zzam(var11);
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Location var9;
            if(var2.readInt() != 0) {
               var9 = (Location)Location.CREATOR.createFromParcel(var2);
            } else {
               var9 = null;
            }

            this.zzc(var9);
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            int var21 = var2.readInt();
            LocationRequest var22 = null;
            if(var21 != 0) {
               var22 = LocationRequest.CREATOR.createFromParcel(var2);
            }

            this.zza(var22, com.google.android.gms.location.zzd.zza.zzcf(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Location var8 = this.zzei(var2.readString());
            var3.writeNoException();
            if(var8 != null) {
               var3.writeInt(1);
               var8.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Location var7;
            if(var2.readInt() != 0) {
               var7 = (Location)Location.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            this.zza(var7, var2.readInt());
            var3.writeNoException();
            return true;
         case 34:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            LocationAvailability var6 = this.zzej(var2.readString());
            var3.writeNoException();
            if(var6 != null) {
               var3.writeInt(1);
               var6.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 52:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            int var17 = var2.readInt();
            LocationRequestInternal var18 = null;
            if(var17 != 0) {
               var18 = LocationRequestInternal.CREATOR.zzeX(var2);
            }

            this.zza(var18, com.google.android.gms.location.zzd.zza.zzcf(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 53:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            LocationRequestInternal var15;
            if(var2.readInt() != 0) {
               var15 = LocationRequestInternal.CREATOR.zzeX(var2);
            } else {
               var15 = null;
            }

            PendingIntent var16;
            if(var2.readInt() != 0) {
               var16 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var16 = null;
            }

            this.zza(var15, var16);
            var3.writeNoException();
            return true;
         case 57:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            GeofencingRequest var40;
            if(var2.readInt() != 0) {
               var40 = (GeofencingRequest)GeofencingRequest.CREATOR.createFromParcel(var2);
            } else {
               var40 = null;
            }

            PendingIntent var41;
            if(var2.readInt() != 0) {
               var41 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var41 = null;
            }

            this.zza(var40, var41, zzh.zza.zzci(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 59:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            int var12 = var2.readInt();
            LocationRequestUpdateData var13 = null;
            if(var12 != 0) {
               var13 = LocationRequestUpdateData.CREATOR.zzeY(var2);
            }

            this.zza(var13);
            var3.writeNoException();
            return true;
         case 60:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            GestureRequest var29;
            if(var2.readInt() != 0) {
               var29 = GestureRequest.CREATOR.zzeQ(var2);
            } else {
               var29 = null;
            }

            PendingIntent var30;
            if(var2.readInt() != 0) {
               var30 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var30 = null;
            }

            this.zza(var29, var30, com.google.android.gms.common.api.internal.zzo.zza.zzaN(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 61:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            PendingIntent var28;
            if(var2.readInt() != 0) {
               var28 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var28 = null;
            }

            this.zzc(var28, com.google.android.gms.common.api.internal.zzo.zza.zzaN(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 63:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            LocationSettingsRequest var5;
            if(var2.readInt() != 0) {
               var5 = (LocationSettingsRequest)LocationSettingsRequest.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.zza(var5, zzj.zza.zzck(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 64:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            ActivityRecognitionResult var33 = this.zzeh(var2.readString());
            var3.writeNoException();
            if(var33 != null) {
               var3.writeInt(1);
               var33.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 65:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            PendingIntent var32;
            if(var2.readInt() != 0) {
               var32 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var32 = null;
            }

            this.zza(var32, com.google.android.gms.common.api.internal.zzo.zza.zzaN(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 66:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            PendingIntent var31;
            if(var2.readInt() != 0) {
               var31 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var31 = null;
            }

            this.zzb(var31, com.google.android.gms.common.api.internal.zzo.zza.zzaN(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 67:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.zza(zzg.zza.zzch(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 68:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            PendingIntent var27;
            if(var2.readInt() != 0) {
               var27 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var27 = null;
            }

            this.zzd(var27, com.google.android.gms.common.api.internal.zzo.zza.zzaN(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 69:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            PendingIntent var26;
            if(var2.readInt() != 0) {
               var26 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var26 = null;
            }

            this.zze(var26, com.google.android.gms.common.api.internal.zzo.zza.zzaN(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzi {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(long param1, boolean param3, PendingIntent param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(PendingIntent param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(PendingIntent param1, com.google.android.gms.common.api.internal.zzo param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(PendingIntent param1, zzh param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(Location param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(GeofencingRequest param1, PendingIntent param2, zzh param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(GestureRequest param1, PendingIntent param2, com.google.android.gms.common.api.internal.zzo param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(LocationRequest param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(LocationRequest param1, com.google.android.gms.location.zzd param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(LocationRequest param1, com.google.android.gms.location.zzd param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(LocationSettingsRequest param1, zzj param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(LocationRequestInternal param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(LocationRequestInternal param1, com.google.android.gms.location.zzd param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(LocationRequestUpdateData param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzg param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(zzh param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(com.google.android.gms.location.zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(List<ParcelableGeofence> param1, PendingIntent param2, zzh param3, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(String[] param1, zzh param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzam(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzb(PendingIntent param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzb(PendingIntent param1, com.google.android.gms.common.api.internal.zzo param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzc(PendingIntent param1, com.google.android.gms.common.api.internal.zzo param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzc(Location param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzd(PendingIntent param1, com.google.android.gms.common.api.internal.zzo param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zze(PendingIntent param1, com.google.android.gms.common.api.internal.zzo param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public ActivityRecognitionResult zzeh(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var9 = false;

         ActivityRecognitionResult var6;
         label42: {
            ActivityRecognitionResult var7;
            label41: {
               try {
                  var9 = true;
                  var2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                  var2.writeString(var1);
                  this.zzoz.transact(64, var2, var3, 0);
                  var3.readException();
                  if(var3.readInt() != 0) {
                     var7 = ActivityRecognitionResult.CREATOR.createFromParcel(var3);
                     var9 = false;
                     break label41;
                  }

                  var9 = false;
               } finally {
                  if(var9) {
                     var3.recycle();
                     var2.recycle();
                  }
               }

               var6 = null;
               break label42;
            }

            var6 = var7;
         }

         var3.recycle();
         var2.recycle();
         return var6;
      }

      public Location zzei(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var8 = false;

         Location var6;
         label36: {
            try {
               var8 = true;
               var2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
               var2.writeString(var1);
               this.zzoz.transact(21, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var6 = (Location)Location.CREATOR.createFromParcel(var3);
                  var8 = false;
                  break label36;
               }

               var8 = false;
            } finally {
               if(var8) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var6 = null;
         }

         var3.recycle();
         var2.recycle();
         return var6;
      }

      public LocationAvailability zzej(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var9 = false;

         LocationAvailability var6;
         label42: {
            LocationAvailability var7;
            label41: {
               try {
                  var9 = true;
                  var2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                  var2.writeString(var1);
                  this.zzoz.transact(34, var2, var3, 0);
                  var3.readException();
                  if(var3.readInt() != 0) {
                     var7 = LocationAvailability.CREATOR.createFromParcel(var3);
                     var9 = false;
                     break label41;
                  }

                  var9 = false;
               } finally {
                  if(var9) {
                     var3.recycle();
                     var2.recycle();
                  }
               }

               var6 = null;
               break label42;
            }

            var6 = var7;
         }

         var3.recycle();
         var2.recycle();
         return var6;
      }

      public Location zzyN() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Location var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
               this.zzoz.transact(7, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Location)Location.CREATOR.createFromParcel(var2);
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
