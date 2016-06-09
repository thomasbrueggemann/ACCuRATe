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

public interface zzfc extends IInterface {
   String getAdvertiser() throws RemoteException;

   String getBody() throws RemoteException;

   String getCallToAction() throws RemoteException;

   Bundle getExtras() throws RemoteException;

   String getHeadline() throws RemoteException;

   List getImages() throws RemoteException;

   boolean getOverrideClickHandling() throws RemoteException;

   boolean getOverrideImpressionRecording() throws RemoteException;

   void recordImpression() throws RemoteException;

   void zzc(com.google.android.gms.dynamic.zzd var1) throws RemoteException;

   void zzd(com.google.android.gms.dynamic.zzd var1) throws RemoteException;

   zzch zzdO() throws RemoteException;

   public abstract static class zza extends Binder implements zzfc {
      public static zzfc zzJ(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            return (zzfc)(var1 != null && var1 instanceof zzfc?(zzfc)var1:new zzfc.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            String var16 = this.getHeadline();
            var3.writeNoException();
            var3.writeString(var16);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            List var15 = this.getImages();
            var3.writeNoException();
            var3.writeList(var15);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            String var14 = this.getBody();
            var3.writeNoException();
            var3.writeString(var14);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzch var12 = this.zzdO();
            var3.writeNoException();
            IBinder var13;
            if(var12 != null) {
               var13 = var12.asBinder();
            } else {
               var13 = null;
            }

            var3.writeStrongBinder(var13);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            String var11 = this.getCallToAction();
            var3.writeNoException();
            var3.writeString(var11);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            String var10 = this.getAdvertiser();
            var3.writeNoException();
            var3.writeString(var10);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.recordImpression();
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.zzc(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.zzd(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            boolean var8 = this.getOverrideImpressionRecording();
            var3.writeNoException();
            byte var9 = 0;
            if(var8) {
               var9 = 1;
            }

            var3.writeInt(var9);
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            boolean var6 = this.getOverrideClickHandling();
            var3.writeNoException();
            byte var7 = 0;
            if(var6) {
               var7 = 1;
            }

            var3.writeInt(var7);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
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
            var3.writeString("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzfc {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public String getAdvertiser() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.zzoz.transact(7, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public String getBody() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
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
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
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
               var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
               this.zzoz.transact(13, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
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
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
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
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.zzoz.transact(12, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.zzoz.transact(11, var1, var2, 0);
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

      public void recordImpression() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            this.zzoz.transact(8, var1, var2, 0);
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

      public zzch zzdO() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         zzch var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
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
