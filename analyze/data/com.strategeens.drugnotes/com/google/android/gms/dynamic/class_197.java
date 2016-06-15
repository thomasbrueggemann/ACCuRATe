package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;

// $FF: renamed from: com.google.android.gms.dynamic.c
public interface class_197 extends IInterface {
   // $FF: renamed from: d (com.google.android.gms.dynamic.d) void
   void method_1067(class_198 var1) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.dynamic.d) void
   void method_1068(class_198 var1) throws RemoteException;

   Bundle getArguments() throws RemoteException;

   int getId() throws RemoteException;

   boolean getRetainInstance() throws RemoteException;

   String getTag() throws RemoteException;

   int getTargetRequestCode() throws RemoteException;

   boolean getUserVisibleHint() throws RemoteException;

   class_198 getView() throws RemoteException;

   boolean isAdded() throws RemoteException;

   boolean isDetached() throws RemoteException;

   boolean isHidden() throws RemoteException;

   boolean isInLayout() throws RemoteException;

   boolean isRemoving() throws RemoteException;

   boolean isResumed() throws RemoteException;

   boolean isVisible() throws RemoteException;

   // $FF: renamed from: jf () com.google.android.gms.dynamic.d
   class_198 method_1069() throws RemoteException;

   // $FF: renamed from: jg () com.google.android.gms.dynamic.c
   class_197 method_1070() throws RemoteException;

   // $FF: renamed from: jh () com.google.android.gms.dynamic.d
   class_198 method_1071() throws RemoteException;

   // $FF: renamed from: ji () com.google.android.gms.dynamic.c
   class_197 method_1072() throws RemoteException;

   void setHasOptionsMenu(boolean var1) throws RemoteException;

   void setMenuVisibility(boolean var1) throws RemoteException;

   void setRetainInstance(boolean var1) throws RemoteException;

   void setUserVisibleHint(boolean var1) throws RemoteException;

   void startActivity(Intent var1) throws RemoteException;

   void startActivityForResult(Intent var1, int var2) throws RemoteException;

   public abstract static class class_1372 extends Binder implements class_197 {
      public class_1372() {
         this.attachInterface(this, "com.google.android.gms.dynamic.IFragmentWrapper");
      }

      // $FF: renamed from: ao (android.os.IBinder) com.google.android.gms.dynamic.c
      public static class_197 method_5470(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return (class_197)(var1 != null && var1 instanceof class_197?(class_197)var1:new class_197.class_1373(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            class_198 var47 = this.jf();
            var3.writeNoException();
            IBinder var48 = null;
            if(var47 != null) {
               var48 = var47.asBinder();
            }

            var3.writeStrongBinder(var48);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            Bundle var46 = this.getArguments();
            var3.writeNoException();
            if(var46 != null) {
               var3.writeInt(1);
               var46.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            int var45 = this.getId();
            var3.writeNoException();
            var3.writeInt(var45);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            class_197 var43 = this.jg();
            var3.writeNoException();
            IBinder var44 = null;
            if(var43 != null) {
               var44 = var43.asBinder();
            }

            var3.writeStrongBinder(var44);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            class_198 var41 = this.jh();
            var3.writeNoException();
            IBinder var42 = null;
            if(var41 != null) {
               var42 = var41.asBinder();
            }

            var3.writeStrongBinder(var42);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            boolean var39 = this.getRetainInstance();
            var3.writeNoException();
            byte var40;
            if(var39) {
               var40 = 1;
            } else {
               var40 = 0;
            }

            var3.writeInt(var40);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            String var38 = this.getTag();
            var3.writeNoException();
            var3.writeString(var38);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            class_197 var36 = this.ji();
            var3.writeNoException();
            IBinder var37 = null;
            if(var36 != null) {
               var37 = var36.asBinder();
            }

            var3.writeStrongBinder(var37);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            int var35 = this.getTargetRequestCode();
            var3.writeNoException();
            var3.writeInt(var35);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            boolean var33 = this.getUserVisibleHint();
            var3.writeNoException();
            byte var34 = 0;
            if(var33) {
               var34 = 1;
            }

            var3.writeInt(var34);
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            class_198 var31 = this.getView();
            var3.writeNoException();
            IBinder var32 = null;
            if(var31 != null) {
               var32 = var31.asBinder();
            }

            var3.writeStrongBinder(var32);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            boolean var29 = this.isAdded();
            var3.writeNoException();
            byte var30 = 0;
            if(var29) {
               var30 = 1;
            }

            var3.writeInt(var30);
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            boolean var27 = this.isDetached();
            var3.writeNoException();
            byte var28 = 0;
            if(var27) {
               var28 = 1;
            }

            var3.writeInt(var28);
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            boolean var25 = this.isHidden();
            var3.writeNoException();
            byte var26 = 0;
            if(var25) {
               var26 = 1;
            }

            var3.writeInt(var26);
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            boolean var23 = this.isInLayout();
            var3.writeNoException();
            byte var24 = 0;
            if(var23) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            boolean var21 = this.isRemoving();
            var3.writeNoException();
            byte var22 = 0;
            if(var21) {
               var22 = 1;
            }

            var3.writeInt(var22);
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            boolean var19 = this.isResumed();
            var3.writeNoException();
            byte var20 = 0;
            if(var19) {
               var20 = 1;
            }

            var3.writeInt(var20);
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            boolean var17 = this.isVisible();
            var3.writeNoException();
            byte var18 = 0;
            if(var17) {
               var18 = 1;
            }

            var3.writeInt(var18);
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            this.d(class_198.class_1672.method_5291(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            int var15 = var2.readInt();
            boolean var16 = false;
            if(var15 != 0) {
               var16 = true;
            }

            this.setHasOptionsMenu(var16);
            var3.writeNoException();
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            int var13 = var2.readInt();
            boolean var14 = false;
            if(var13 != 0) {
               var14 = true;
            }

            this.setMenuVisibility(var14);
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            int var11 = var2.readInt();
            boolean var12 = false;
            if(var11 != 0) {
               var12 = true;
            }

            this.setRetainInstance(var12);
            var3.writeNoException();
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            int var9 = var2.readInt();
            boolean var10 = false;
            if(var9 != 0) {
               var10 = true;
            }

            this.setUserVisibleHint(var10);
            var3.writeNoException();
            return true;
         case 25:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            int var7 = var2.readInt();
            Intent var8 = null;
            if(var7 != 0) {
               var8 = (Intent)Intent.CREATOR.createFromParcel(var2);
            }

            this.startActivity(var8);
            var3.writeNoException();
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            int var5 = var2.readInt();
            Intent var6 = null;
            if(var5 != 0) {
               var6 = (Intent)Intent.CREATOR.createFromParcel(var2);
            }

            this.startActivityForResult(var6, var2.readInt());
            var3.writeNoException();
            return true;
         case 27:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            this.e(class_198.class_1672.method_5291(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.dynamic.IFragmentWrapper");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1373 implements class_197 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_2766;

      class_1373(IBinder var1) {
         this.field_2766 = var1;
      }

      public IBinder asBinder() {
         return this.field_2766;
      }

      // $FF: renamed from: d (com.google.android.gms.dynamic.d) void
      public void method_1067(class_198 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.dynamic.d) void
      public void method_1068(class_198 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public Bundle getArguments() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Bundle var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
               this.field_2766.transact(3, var1, var2, 0);
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

      public int getId() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(4, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public boolean getRetainInstance() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(7, var1, var2, 0);
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

      public String getTag() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(8, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public int getTargetRequestCode() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(10, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public boolean getUserVisibleHint() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(11, var1, var2, 0);
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

      public class_198 getView() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         class_198 var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(12, var1, var2, 0);
            var2.readException();
            var5 = class_198.class_1672.method_5291(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public boolean isAdded() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(13, var1, var2, 0);
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

      public boolean isDetached() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(14, var1, var2, 0);
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

      public boolean isHidden() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(15, var1, var2, 0);
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

      public boolean isInLayout() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(16, var1, var2, 0);
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

      public boolean isRemoving() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(17, var1, var2, 0);
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

      public boolean isResumed() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(18, var1, var2, 0);
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

      public boolean isVisible() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(19, var1, var2, 0);
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

      // $FF: renamed from: jf () com.google.android.gms.dynamic.d
      public class_198 method_1069() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         class_198 var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(2, var1, var2, 0);
            var2.readException();
            var5 = class_198.class_1672.method_5291(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: jg () com.google.android.gms.dynamic.c
      public class_197 method_1070() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         class_197 var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(5, var1, var2, 0);
            var2.readException();
            var5 = class_197.class_1372.method_5470(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: jh () com.google.android.gms.dynamic.d
      public class_198 method_1071() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         class_198 var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(6, var1, var2, 0);
            var2.readException();
            var5 = class_198.class_1672.method_5291(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: ji () com.google.android.gms.dynamic.c
      public class_197 method_1072() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         class_197 var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.field_2766.transact(9, var1, var2, 0);
            var2.readException();
            var5 = class_197.class_1372.method_5470(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public void setHasOptionsMenu(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setMenuVisibility(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setRetainInstance(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setUserVisibleHint(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void startActivity(Intent param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void startActivityForResult(Intent param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
