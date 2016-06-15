package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.internal.class_218;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_53;

// $FF: renamed from: com.google.android.gms.internal.cz
public interface class_42 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.av, java.lang.String, com.google.android.gms.internal.da) void
   void method_206(class_198 var1, class_218 var2, String var3, class_53 var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.av, java.lang.String, java.lang.String, com.google.android.gms.internal.da) void
   void method_207(class_198 var1, class_218 var2, String var3, String var4, class_53 var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, com.google.android.gms.internal.av, java.lang.String, com.google.android.gms.internal.da) void
   void method_208(class_198 var1, class_237 var2, class_218 var3, String var4, class_53 var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, com.google.android.gms.internal.av, java.lang.String, java.lang.String, com.google.android.gms.internal.da) void
   void method_209(class_198 var1, class_237 var2, class_218 var3, String var4, String var5, class_53 var6) throws RemoteException;

   void destroy() throws RemoteException;

   class_198 getView() throws RemoteException;

   void pause() throws RemoteException;

   void resume() throws RemoteException;

   void showInterstitial() throws RemoteException;

   public abstract static class class_1355 extends Binder implements class_42 {
      public class_1355() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      }

      // $FF: renamed from: o (android.os.IBinder) com.google.android.gms.internal.cz
      public static class_42 method_3002(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (class_42)(var1 != null && var1 instanceof class_42?(class_42)var1:new class_42.class_1356(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            class_198 var15 = class_198.class_1672.method_5291(var2.readStrongBinder());
            class_237 var16;
            if(var2.readInt() != 0) {
               var16 = class_237.CREATOR.method_1600(var2);
            } else {
               var16 = null;
            }

            class_218 var17;
            if(var2.readInt() != 0) {
               var17 = class_218.CREATOR.method_1506(var2);
            } else {
               var17 = null;
            }

            this.a(var15, var16, var17, var2.readString(), class_53.class_1150.method_2893(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            class_198 var13 = this.getView();
            var3.writeNoException();
            IBinder var14 = null;
            if(var13 != null) {
               var14 = var13.asBinder();
            }

            var3.writeStrongBinder(var14);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            class_198 var10 = class_198.class_1672.method_5291(var2.readStrongBinder());
            int var11 = var2.readInt();
            class_218 var12 = null;
            if(var11 != 0) {
               var12 = class_218.CREATOR.method_1506(var2);
            }

            this.a(var10, var12, var2.readString(), class_53.class_1150.method_2893(var2.readStrongBinder()));
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
            class_198 var7 = class_198.class_1672.method_5291(var2.readStrongBinder());
            class_237 var8;
            if(var2.readInt() != 0) {
               var8 = class_237.CREATOR.method_1600(var2);
            } else {
               var8 = null;
            }

            class_218 var9;
            if(var2.readInt() != 0) {
               var9 = class_218.CREATOR.method_1506(var2);
            } else {
               var9 = null;
            }

            this.a(var7, var8, var9, var2.readString(), var2.readString(), class_53.class_1150.method_2893(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            class_198 var5 = class_198.class_1672.method_5291(var2.readStrongBinder());
            class_218 var6;
            if(var2.readInt() != 0) {
               var6 = class_218.CREATOR.method_1506(var2);
            } else {
               var6 = null;
            }

            this.a(var5, var6, var2.readString(), var2.readString(), class_53.class_1150.method_2893(var2.readStrongBinder()));
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
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1356 implements class_42 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_2746;

      class_1356(IBinder var1) {
         this.field_2746 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.av, java.lang.String, com.google.android.gms.internal.da) void
      public void method_206(class_198 param1, class_218 param2, String param3, class_53 param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.av, java.lang.String, java.lang.String, com.google.android.gms.internal.da) void
      public void method_207(class_198 param1, class_218 param2, String param3, String param4, class_53 param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, com.google.android.gms.internal.av, java.lang.String, com.google.android.gms.internal.da) void
      public void method_208(class_198 param1, class_237 param2, class_218 param3, String param4, class_53 param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, com.google.android.gms.internal.av, java.lang.String, java.lang.String, com.google.android.gms.internal.da) void
      public void method_209(class_198 param1, class_237 param2, class_218 param3, String param4, String param5, class_53 param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2746;
      }

      public void destroy() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.field_2746.transact(5, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public class_198 getView() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         class_198 var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.field_2746.transact(2, var1, var2, 0);
            var2.readException();
            var5 = class_198.class_1672.method_5291(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public void pause() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.field_2746.transact(8, var1, var2, 0);
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
            this.field_2746.transact(9, var1, var2, 0);
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
            this.field_2746.transact(4, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
