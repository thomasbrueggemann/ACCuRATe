package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;

public interface zzc extends IInterface {
   void init(com.google.android.gms.dynamic.zzd var1) throws RemoteException;

   ICameraUpdateFactoryDelegate zzAe() throws RemoteException;

   com.google.android.gms.maps.model.internal.zza zzAf() throws RemoteException;

   IMapViewDelegate zza(com.google.android.gms.dynamic.zzd var1, GoogleMapOptions var2) throws RemoteException;

   IStreetViewPanoramaViewDelegate zza(com.google.android.gms.dynamic.zzd var1, StreetViewPanoramaOptions var2) throws RemoteException;

   void zzd(com.google.android.gms.dynamic.zzd var1, int var2) throws RemoteException;

   IMapFragmentDelegate zzs(com.google.android.gms.dynamic.zzd var1) throws RemoteException;

   IStreetViewPanoramaFragmentDelegate zzt(com.google.android.gms.dynamic.zzd var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzc {
      public static zzc zzcu(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return (zzc)(var1 != null && var1 instanceof zzc?(zzc)var1:new zzc.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            this.init(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            IMapFragmentDelegate var19 = this.zzs(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            IBinder var20 = null;
            if(var19 != null) {
               var20 = var19.asBinder();
            }

            var3.writeStrongBinder(var20);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            com.google.android.gms.dynamic.zzd var15 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
            GoogleMapOptions var16;
            if(var2.readInt() != 0) {
               var16 = GoogleMapOptions.CREATOR.zzft(var2);
            } else {
               var16 = null;
            }

            IMapViewDelegate var17 = this.zza(var15, var16);
            var3.writeNoException();
            IBinder var18 = null;
            if(var17 != null) {
               var18 = var17.asBinder();
            }

            var3.writeStrongBinder(var18);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            ICameraUpdateFactoryDelegate var13 = this.zzAe();
            var3.writeNoException();
            IBinder var14 = null;
            if(var13 != null) {
               var14 = var13.asBinder();
            }

            var3.writeStrongBinder(var14);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            com.google.android.gms.maps.model.internal.zza var11 = this.zzAf();
            var3.writeNoException();
            IBinder var12 = null;
            if(var11 != null) {
               var12 = var11.asBinder();
            }

            var3.writeStrongBinder(var12);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            this.zzd(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            com.google.android.gms.dynamic.zzd var7 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
            StreetViewPanoramaOptions var8;
            if(var2.readInt() != 0) {
               var8 = StreetViewPanoramaOptions.CREATOR.zzfu(var2);
            } else {
               var8 = null;
            }

            IStreetViewPanoramaViewDelegate var9 = this.zza(var7, var8);
            var3.writeNoException();
            IBinder var10 = null;
            if(var9 != null) {
               var10 = var9.asBinder();
            }

            var3.writeStrongBinder(var10);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            IStreetViewPanoramaFragmentDelegate var5 = this.zzt(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            IBinder var6 = null;
            if(var5 != null) {
               var6 = var5.asBinder();
            }

            var3.writeStrongBinder(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.ICreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzc {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void init(com.google.android.gms.dynamic.zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public ICameraUpdateFactoryDelegate zzAe() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         ICameraUpdateFactoryDelegate var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            this.zzoz.transact(4, var1, var2, 0);
            var2.readException();
            var5 = ICameraUpdateFactoryDelegate.zza.zzcs(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public com.google.android.gms.maps.model.internal.zza zzAf() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.maps.model.internal.zza var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            this.zzoz.transact(5, var1, var2, 0);
            var2.readException();
            var5 = com.google.android.gms.maps.model.internal.zza.zza.zzdd(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public IMapViewDelegate zza(com.google.android.gms.dynamic.zzd param1, GoogleMapOptions param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IStreetViewPanoramaViewDelegate zza(com.google.android.gms.dynamic.zzd param1, StreetViewPanoramaOptions param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzd(com.google.android.gms.dynamic.zzd param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IMapFragmentDelegate zzs(com.google.android.gms.dynamic.zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IStreetViewPanoramaFragmentDelegate zzt(com.google.android.gms.dynamic.zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
