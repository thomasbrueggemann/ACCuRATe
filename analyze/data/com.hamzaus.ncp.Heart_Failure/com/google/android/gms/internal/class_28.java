package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_29;

// $FF: renamed from: com.google.android.gms.internal.gd
public interface class_28 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.internal.gc) void
   void method_137(class_29 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.gc, int) void
   void method_138(class_29 var1, int var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.gc, int, java.lang.String, byte[]) void
   void method_139(class_29 var1, int var2, String var3, byte[] var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.gc, int, byte[]) void
   void method_140(class_29 var1, int var2, byte[] var3) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.internal.gc) void
   void method_141(class_29 var1) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.internal.gc, int) void
   void method_142(class_29 var1, int var2) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.internal.gc) void
   void method_143(class_29 var1) throws RemoteException;

   // $FF: renamed from: dP () int
   int method_144() throws RemoteException;

   // $FF: renamed from: dQ () int
   int method_145() throws RemoteException;

   public abstract static class class_1056 extends Binder implements class_28 {
      // $FF: renamed from: F (android.os.IBinder) com.google.android.gms.internal.gd
      public static class_28 method_4461(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
            return (class_28)(var1 != null && var1 instanceof class_28?(class_28)var1:new class_28.class_1057(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 5001:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            int var6 = this.dP();
            var3.writeNoException();
            var3.writeInt(var6);
            return true;
         case 5002:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            int var5 = this.dQ();
            var3.writeNoException();
            var3.writeInt(var5);
            return true;
         case 5003:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            this.a(class_29.class_1062.method_2129(var2.readStrongBinder()), var2.readInt(), var2.createByteArray());
            var3.writeNoException();
            return true;
         case 5004:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            this.a(class_29.class_1062.method_2129(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            return true;
         case 5005:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            this.a(class_29.class_1062.method_2129(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5006:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            this.a(class_29.class_1062.method_2129(var2.readStrongBinder()), var2.readInt(), var2.readString(), var2.createByteArray());
            var3.writeNoException();
            return true;
         case 5007:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            this.b(class_29.class_1062.method_2129(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            return true;
         case 5008:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            this.b(class_29.class_1062.method_2129(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5009:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            this.c(class_29.class_1062.method_2129(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.appstate.internal.IAppStateService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1057 implements class_28 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2952;

      class_1057(IBinder var1) {
         this.field_2952 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.gc) void
      public void method_137(class_29 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.gc, int) void
      public void method_138(class_29 param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.gc, int, java.lang.String, byte[]) void
      public void method_139(class_29 param1, int param2, String param3, byte[] param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.gc, int, byte[]) void
      public void method_140(class_29 param1, int param2, byte[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2952;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.gc) void
      public void method_141(class_29 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.internal.gc, int) void
      public void method_142(class_29 param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.internal.gc) void
      public void method_143(class_29 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: dP () int
      public int method_144() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
            this.field_2952.transact(5001, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: dQ () int
      public int method_145() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
            this.field_2952.transact(5002, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }
   }
}