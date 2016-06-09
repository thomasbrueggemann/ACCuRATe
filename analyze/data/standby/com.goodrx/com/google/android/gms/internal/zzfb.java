package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzch;
import java.util.ArrayList;
import java.util.List;

public interface zzfb extends IInterface {
   String getBody() throws RemoteException;

   String getCallToAction() throws RemoteException;

   Bundle getExtras() throws RemoteException;

   String getHeadline() throws RemoteException;

   List getImages() throws RemoteException;

   boolean getOverrideClickHandling() throws RemoteException;

   boolean getOverrideImpressionRecording() throws RemoteException;

   String getPrice() throws RemoteException;

   double getStarRating() throws RemoteException;

   String getStore() throws RemoteException;

   void recordImpression() throws RemoteException;

   void zzc(com.google.android.gms.dynamic.zzd var1) throws RemoteException;

   void zzd(com.google.android.gms.dynamic.zzd var1) throws RemoteException;

   zzch zzdK() throws RemoteException;

   public abstract static class zza extends Binder implements zzfb {
      public static zzfb zzI(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            return (zzfb)(var1 != null && var1 instanceof zzfb?(zzfb)var1:new zzfb.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            String var19 = this.getHeadline();
            var3.writeNoException();
            var3.writeString(var19);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            List var18 = this.getImages();
            var3.writeNoException();
            var3.writeList(var18);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            String var17 = this.getBody();
            var3.writeNoException();
            var3.writeString(var17);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzch var15 = this.zzdK();
            var3.writeNoException();
            IBinder var16;
            if(var15 != null) {
               var16 = var15.asBinder();
            } else {
               var16 = null;
            }

            var3.writeStrongBinder(var16);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            String var14 = this.getCallToAction();
            var3.writeNoException();
            var3.writeString(var14);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            double var12 = this.getStarRating();
            var3.writeNoException();
            var3.writeDouble(var12);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            String var11 = this.getStore();
            var3.writeNoException();
            var3.writeString(var11);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            String var10 = this.getPrice();
            var3.writeNoException();
            var3.writeString(var10);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            this.recordImpression();
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            this.zzc(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            this.zzd(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            boolean var8 = this.getOverrideImpressionRecording();
            var3.writeNoException();
            byte var9 = 0;
            if(var8) {
               var9 = 1;
            }

            var3.writeInt(var9);
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            boolean var6 = this.getOverrideClickHandling();
            var3.writeNoException();
            byte var7 = 0;
            if(var6) {
               var7 = 1;
            }

            var3.writeInt(var7);
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            Bundle var5 = this.getExtras();
            var3.writeNoException();
            if(var5 != null) {
               var3.writeInt(1);
               var5.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzfb {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public String getBody() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            this.zzoz.transact(4, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public String getCallToAction() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            this.zzoz.transact(6, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public Bundle getExtras() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Bundle var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
               this.zzoz.transact(15, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
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

      public String getHeadline() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            this.zzoz.transact(2, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public List getImages() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         ArrayList var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            this.zzoz.transact(3, var1, var2, 0);
            var2.readException();
            var5 = var2.readArrayList(this.getClass().getClassLoader());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public boolean getOverrideClickHandling() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            this.zzoz.transact(14, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var2.recycle();
               var1.recycle();
            }
         }

         boolean var6 = false;
         if(var5 != 0) {
            var6 = true;
         }

         var2.recycle();
         var1.recycle();
         return var6;
      }

      public boolean getOverrideImpressionRecording() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            this.zzoz.transact(13, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var2.recycle();
               var1.recycle();
            }
         }

         boolean var6 = false;
         if(var5 != 0) {
            var6 = true;
         }

         var2.recycle();
         var1.recycle();
         return var6;
      }

      public String getPrice() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            this.zzoz.transact(9, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public double getStarRating() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         double var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            this.zzoz.transact(7, var1, var2, 0);
            var2.readException();
            var5 = var2.readDouble();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public String getStore() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            this.zzoz.transact(8, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public void recordImpression() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            this.zzoz.transact(10, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void zzc(com.google.android.gms.dynamic.zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzd(com.google.android.gms.dynamic.zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public zzch zzdK() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         zzch var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            this.zzoz.transact(5, var1, var2, 0);
            var2.readException();
            var5 = zzch.zza.zzt(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }
   }
}
