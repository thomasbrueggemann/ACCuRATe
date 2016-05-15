package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.internal.zzez;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzfc;
import java.util.List;

public interface zzey extends IInterface {
   void destroy() throws RemoteException;

   Bundle getInterstitialAdapterInfo() throws RemoteException;

   com.google.android.gms.dynamic.zzd getView() throws RemoteException;

   boolean isInitialized() throws RemoteException;

   void pause() throws RemoteException;

   void resume() throws RemoteException;

   void showInterstitial() throws RemoteException;

   void showVideo() throws RemoteException;

   void zza(AdRequestParcel var1, String var2, String var3) throws RemoteException;

   void zza(com.google.android.gms.dynamic.zzd var1, AdRequestParcel var2, String var3, com.google.android.gms.ads.internal.reward.mediation.client.zza var4, String var5) throws RemoteException;

   void zza(com.google.android.gms.dynamic.zzd var1, AdRequestParcel var2, String var3, zzez var4) throws RemoteException;

   void zza(com.google.android.gms.dynamic.zzd var1, AdRequestParcel var2, String var3, String var4, zzez var5) throws RemoteException;

   void zza(com.google.android.gms.dynamic.zzd var1, AdRequestParcel var2, String var3, String var4, zzez var5, NativeAdOptionsParcel var6, List<String> var7) throws RemoteException;

   void zza(com.google.android.gms.dynamic.zzd var1, AdSizeParcel var2, AdRequestParcel var3, String var4, zzez var5) throws RemoteException;

   void zza(com.google.android.gms.dynamic.zzd var1, AdSizeParcel var2, AdRequestParcel var3, String var4, String var5, zzez var6) throws RemoteException;

   void zzb(AdRequestParcel var1, String var2) throws RemoteException;

   zzfb zzeF() throws RemoteException;

   zzfc zzeG() throws RemoteException;

   Bundle zzeH() throws RemoteException;

   Bundle zzeI() throws RemoteException;

   public abstract static class zza extends Binder implements zzey {
      public static zzey zzF(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (zzey)(var1 != null && var1 instanceof zzey?(zzey)var1:new zzey.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            com.google.android.gms.dynamic.zzd var36 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
            AdSizeParcel var37;
            if(var2.readInt() != 0) {
               var37 = AdSizeParcel.CREATOR.zzc(var2);
            } else {
               var37 = null;
            }

            AdRequestParcel var38;
            if(var2.readInt() != 0) {
               var38 = AdRequestParcel.CREATOR.zzb(var2);
            } else {
               var38 = null;
            }

            this.zza(var36, var37, var38, var2.readString(), zzez.zza.zzG(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            com.google.android.gms.dynamic.zzd var34 = this.getView();
            var3.writeNoException();
            IBinder var35 = null;
            if(var34 != null) {
               var35 = var34.asBinder();
            }

            var3.writeStrongBinder(var35);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            com.google.android.gms.dynamic.zzd var31 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
            int var32 = var2.readInt();
            AdRequestParcel var33 = null;
            if(var32 != 0) {
               var33 = AdRequestParcel.CREATOR.zzb(var2);
            }

            this.zza(var31, var33, var2.readString(), zzez.zza.zzG(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.showInterstitial();
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.destroy();
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            com.google.android.gms.dynamic.zzd var28 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
            AdSizeParcel var29;
            if(var2.readInt() != 0) {
               var29 = AdSizeParcel.CREATOR.zzc(var2);
            } else {
               var29 = null;
            }

            AdRequestParcel var30;
            if(var2.readInt() != 0) {
               var30 = AdRequestParcel.CREATOR.zzb(var2);
            } else {
               var30 = null;
            }

            this.zza(var28, var29, var30, var2.readString(), var2.readString(), zzez.zza.zzG(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            com.google.android.gms.dynamic.zzd var26 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
            AdRequestParcel var27;
            if(var2.readInt() != 0) {
               var27 = AdRequestParcel.CREATOR.zzb(var2);
            } else {
               var27 = null;
            }

            this.zza(var26, var27, var2.readString(), var2.readString(), zzez.zza.zzG(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.pause();
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.resume();
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            com.google.android.gms.dynamic.zzd var24 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
            AdRequestParcel var25;
            if(var2.readInt() != 0) {
               var25 = AdRequestParcel.CREATOR.zzb(var2);
            } else {
               var25 = null;
            }

            this.zza(var24, var25, var2.readString(), com.google.android.gms.ads.internal.reward.mediation.client.zza.zza.zzae(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            int var22 = var2.readInt();
            AdRequestParcel var23 = null;
            if(var22 != 0) {
               var23 = AdRequestParcel.CREATOR.zzb(var2);
            }

            this.zzb(var23, var2.readString());
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.showVideo();
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            boolean var20 = this.isInitialized();
            var3.writeNoException();
            byte var21;
            if(var20) {
               var21 = 1;
            } else {
               var21 = 0;
            }

            var3.writeInt(var21);
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            com.google.android.gms.dynamic.zzd var14 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
            AdRequestParcel var15;
            if(var2.readInt() != 0) {
               var15 = AdRequestParcel.CREATOR.zzb(var2);
            } else {
               var15 = null;
            }

            String var16 = var2.readString();
            String var17 = var2.readString();
            zzez var18 = zzez.zza.zzG(var2.readStrongBinder());
            NativeAdOptionsParcel var19;
            if(var2.readInt() != 0) {
               var19 = NativeAdOptionsParcel.CREATOR.zze(var2);
            } else {
               var19 = null;
            }

            this.zza(var14, var15, var16, var17, var18, var19, var2.createStringArrayList());
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            zzfb var12 = this.zzeF();
            var3.writeNoException();
            IBinder var13 = null;
            if(var12 != null) {
               var13 = var12.asBinder();
            }

            var3.writeStrongBinder(var13);
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            zzfc var10 = this.zzeG();
            var3.writeNoException();
            IBinder var11 = null;
            if(var10 != null) {
               var11 = var10.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            Bundle var9 = this.zzeH();
            var3.writeNoException();
            if(var9 != null) {
               var3.writeInt(1);
               var9.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            Bundle var8 = this.getInterstitialAdapterInfo();
            var3.writeNoException();
            if(var8 != null) {
               var3.writeInt(1);
               var8.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            Bundle var7 = this.zzeI();
            var3.writeNoException();
            if(var7 != null) {
               var3.writeInt(1);
               var7.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            int var5 = var2.readInt();
            AdRequestParcel var6 = null;
            if(var5 != 0) {
               var6 = AdRequestParcel.CREATOR.zzb(var2);
            }

            this.zza(var6, var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzey {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void destroy() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.zzoz.transact(5, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public Bundle getInterstitialAdapterInfo() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Bundle var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
               this.zzoz.transact(18, var1, var2, 0);
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

      public com.google.android.gms.dynamic.zzd getView() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.dynamic.zzd var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.zzoz.transact(2, var1, var2, 0);
            var2.readException();
            var5 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public boolean isInitialized() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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

      public void pause() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.zzoz.transact(8, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void resume() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.zzoz.transact(9, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void showInterstitial() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.zzoz.transact(4, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void showVideo() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.zzoz.transact(12, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void zza(AdRequestParcel param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(com.google.android.gms.dynamic.zzd param1, AdRequestParcel param2, String param3, com.google.android.gms.ads.internal.reward.mediation.client.zza param4, String param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(com.google.android.gms.dynamic.zzd param1, AdRequestParcel param2, String param3, zzez param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(com.google.android.gms.dynamic.zzd param1, AdRequestParcel param2, String param3, String param4, zzez param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(com.google.android.gms.dynamic.zzd param1, AdRequestParcel param2, String param3, String param4, zzez param5, NativeAdOptionsParcel param6, List<String> param7) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(com.google.android.gms.dynamic.zzd param1, AdSizeParcel param2, AdRequestParcel param3, String param4, zzez param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zza(com.google.android.gms.dynamic.zzd param1, AdSizeParcel param2, AdRequestParcel param3, String param4, String param5, zzez param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzb(AdRequestParcel param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public zzfb zzeF() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         zzfb var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.zzoz.transact(15, var1, var2, 0);
            var2.readException();
            var5 = zzfb.zza.zzI(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public zzfc zzeG() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         zzfc var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.zzoz.transact(16, var1, var2, 0);
            var2.readException();
            var5 = zzfc.zza.zzJ(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public Bundle zzeH() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Bundle var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
               this.zzoz.transact(17, var1, var2, 0);
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

      public Bundle zzeI() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Bundle var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
               this.zzoz.transact(19, var1, var2, 0);
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
   }
}
