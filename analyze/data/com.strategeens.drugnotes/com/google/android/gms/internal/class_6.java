package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.internal.class_10;
import com.google.android.gms.internal.class_218;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_29;
import com.google.android.gms.internal.class_3;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.class_4;

// $FF: renamed from: com.google.android.gms.internal.bd
public interface class_6 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.internal.ay) void
   void method_10(class_237 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.bc) void
   void method_11(class_4 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.bf) void
   void method_12(class_3 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.br) void
   void method_13(class_10 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.en) void
   void method_14(class_31 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.er, java.lang.String) void
   void method_15(class_29 var1, String var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.av) boolean
   boolean method_16(class_218 var1) throws RemoteException;

   // $FF: renamed from: ab () com.google.android.gms.dynamic.d
   class_198 method_17() throws RemoteException;

   // $FF: renamed from: ac () com.google.android.gms.internal.ay
   class_237 method_18() throws RemoteException;

   // $FF: renamed from: an () void
   void method_19() throws RemoteException;

   void destroy() throws RemoteException;

   String getMediationAdapterClassName() throws RemoteException;

   boolean isReady() throws RemoteException;

   void pause() throws RemoteException;

   void resume() throws RemoteException;

   void showInterstitial() throws RemoteException;

   void stopLoading() throws RemoteException;

   public abstract static class class_1477 extends Binder implements class_6 {
      public class_1477() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
      }

      // $FF: renamed from: f (android.os.IBinder) com.google.android.gms.internal.bd
      public static class_6 method_3313(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return (class_6)(var1 != null && var1 instanceof class_6?(class_6)var1:new class_6.class_1478(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            class_198 var15 = this.ab();
            var3.writeNoException();
            IBinder var16 = null;
            if(var15 != null) {
               var16 = var15.asBinder();
            }

            var3.writeStrongBinder(var16);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.destroy();
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            boolean var13 = this.isReady();
            var3.writeNoException();
            byte var14;
            if(var13) {
               var14 = 1;
            } else {
               var14 = 0;
            }

            var3.writeInt(var14);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            int var9 = var2.readInt();
            class_218 var10 = null;
            if(var9 != 0) {
               var10 = class_218.CREATOR.method_1506(var2);
            }

            boolean var11 = this.a(var10);
            var3.writeNoException();
            byte var12 = 0;
            if(var11) {
               var12 = 1;
            }

            var3.writeInt(var12);
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
            this.a(class_4.class_1169.method_1537(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.a(class_3.class_1262.method_1598(var2.readStrongBinder()));
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
            this.an();
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            class_237 var8 = this.ac();
            var3.writeNoException();
            if(var8 != null) {
               var3.writeInt(1);
               var8.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            int var6 = var2.readInt();
            class_237 var7 = null;
            if(var6 != 0) {
               var7 = class_237.CREATOR.method_1600(var2);
            }

            this.a(var7);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.a(class_31.class_1093.method_2711(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.a(class_29.class_1384.method_2724(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            String var5 = this.getMediationAdapterClassName();
            var3.writeNoException();
            var3.writeString(var5);
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.a(class_10.class_1411.method_1609(var2.readStrongBinder()));
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

   private static class class_1478 implements class_6 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_2922;

      class_1478(IBinder var1) {
         this.field_2922 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ay) void
      public void method_10(class_237 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.bc) void
      public void method_11(class_4 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.bf) void
      public void method_12(class_3 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.br) void
      public void method_13(class_10 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.en) void
      public void method_14(class_31 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.er, java.lang.String) void
      public void method_15(class_29 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.av) boolean
      public boolean method_16(class_218 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: ab () com.google.android.gms.dynamic.d
      public class_198 method_17() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         class_198 var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.field_2922.transact(1, var1, var2, 0);
            var2.readException();
            var5 = class_198.class_1672.method_5291(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: ac () com.google.android.gms.internal.ay
      public class_237 method_18() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         class_237 var5;
         label42: {
            class_237 var6;
            label41: {
               try {
                  var8 = true;
                  var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                  this.field_2922.transact(12, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = class_237.CREATOR.method_1600(var2);
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

      // $FF: renamed from: an () void
      public void method_19() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.field_2922.transact(11, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public IBinder asBinder() {
         return this.field_2922;
      }

      public void destroy() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.field_2922.transact(2, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public String getMediationAdapterClassName() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.field_2922.transact(18, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public boolean isReady() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.field_2922.transact(3, var1, var2, 0);
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
            this.field_2922.transact(5, var1, var2, 0);
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
            this.field_2922.transact(6, var1, var2, 0);
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
            this.field_2922.transact(9, var1, var2, 0);
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
            this.field_2922.transact(10, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
