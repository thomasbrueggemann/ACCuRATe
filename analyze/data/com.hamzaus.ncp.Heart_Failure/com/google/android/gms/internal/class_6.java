package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_182;
import com.google.android.gms.internal.class_4;
import com.google.android.gms.internal.class_48;
import com.google.android.gms.internal.class_5;
import com.google.android.gms.internal.class_50;

// $FF: renamed from: com.google.android.gms.internal.ar
public interface class_6 extends IInterface {
   // $FF: renamed from: P () com.google.android.gms.dynamic.d
   class_157 method_8() throws RemoteException;

   // $FF: renamed from: Q () com.google.android.gms.internal.am
   class_172 method_9() throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.am) void
   void method_10(class_172 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.aq) void
   void method_11(class_5 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.at) void
   void method_12(class_4 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.dd) void
   void method_13(class_48 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.dh, java.lang.String) void
   void method_14(class_50 var1, String var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.aj) boolean
   boolean method_15(class_182 var1) throws RemoteException;

   // $FF: renamed from: ab () void
   void method_16() throws RemoteException;

   void destroy() throws RemoteException;

   boolean isReady() throws RemoteException;

   void pause() throws RemoteException;

   void resume() throws RemoteException;

   void showInterstitial() throws RemoteException;

   void stopLoading() throws RemoteException;

   public abstract static class class_996 extends Binder implements class_6 {
      public class_996() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
      }

      // $FF: renamed from: f (android.os.IBinder) com.google.android.gms.internal.ar
      public static class_6 method_2794(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return (class_6)(var1 != null && var1 instanceof class_6?(class_6)var1:new class_6.class_997(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            class_157 var14 = this.P();
            var3.writeNoException();
            IBinder var15 = null;
            if(var14 != null) {
               var15 = var14.asBinder();
            }

            var3.writeStrongBinder(var15);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.destroy();
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            boolean var12 = this.isReady();
            var3.writeNoException();
            byte var13;
            if(var12) {
               var13 = 1;
            } else {
               var13 = 0;
            }

            var3.writeInt(var13);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            int var8 = var2.readInt();
            class_182 var9 = null;
            if(var8 != 0) {
               var9 = class_182.CREATOR.method_1272(var2);
            }

            boolean var10 = this.a(var9);
            var3.writeNoException();
            byte var11 = 0;
            if(var10) {
               var11 = 1;
            }

            var3.writeInt(var11);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.pause();
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.resume();
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.a(class_5.class_1137.method_875(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.a(class_4.class_814.method_1261(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.showInterstitial();
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.stopLoading();
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.ab();
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            class_172 var7 = this.Q();
            var3.writeNoException();
            if(var7 != null) {
               var3.writeInt(1);
               var7.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            int var5 = var2.readInt();
            class_172 var6 = null;
            if(var5 != 0) {
               var6 = class_172.CREATOR.method_1269(var2);
            }

            this.a(var6);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.a(class_48.class_1045.method_2675(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.a(class_50.class_1011.method_2578(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.client.IAdManager");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_997 implements class_6 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3514;

      class_997(IBinder var1) {
         this.field_3514 = var1;
      }

      // $FF: renamed from: P () com.google.android.gms.dynamic.d
      public class_157 method_8() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         class_157 var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.field_3514.transact(1, var1, var2, 0);
            var2.readException();
            var5 = class_157.class_1317.method_4176(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: Q () com.google.android.gms.internal.am
      public class_172 method_9() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         class_172 var5;
         label42: {
            class_172 var6;
            label41: {
               try {
                  var8 = true;
                  var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                  this.field_3514.transact(12, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = class_172.CREATOR.method_1269(var2);
                     var8 = false;
                     break label41;
                  }

                  var8 = false;
               } finally {
                  if(var8) {
                     var2.recycle();
                     var1.recycle();
                  }
               }

               var5 = null;
               break label42;
            }

            var5 = var6;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.am) void
      public void method_10(class_172 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.aq) void
      public void method_11(class_5 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.at) void
      public void method_12(class_4 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.dd) void
      public void method_13(class_48 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.dh, java.lang.String) void
      public void method_14(class_50 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.aj) boolean
      public boolean method_15(class_182 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: ab () void
      public void method_16() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.field_3514.transact(11, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public IBinder asBinder() {
         return this.field_3514;
      }

      public void destroy() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.field_3514.transact(2, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public boolean isReady() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.field_3514.transact(3, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.field_3514.transact(5, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.field_3514.transact(6, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.field_3514.transact(9, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void stopLoading() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.field_3514.transact(10, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
