package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_25;
import com.google.android.gms.internal.class_386;
import com.google.android.gms.internal.class_398;

// $FF: renamed from: com.google.android.gms.internal.hu
public interface class_27 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.internal.hl$a, com.google.android.gms.internal.hv) void
   void method_181(class_398.class_1609 var1, class_25 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.hv) void
   void method_182(class_25 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.hv, java.lang.String, com.google.android.gms.internal.hr[]) void
   void method_183(class_25 var1, String var2, class_386[] var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.hv, boolean) void
   void method_184(class_25 var1, boolean var2) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.internal.hv) void
   void method_185(class_25 var1) throws RemoteException;

   public abstract static class class_1382 extends Binder implements class_27 {
      // $FF: renamed from: E (android.os.IBinder) com.google.android.gms.internal.hu
      public static class_27 method_5428(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            return (class_27)(var1 != null && var1 instanceof class_27?(class_27)var1:new class_27.class_1383(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            this.a(class_25.class_1326.method_2670(var2.readStrongBinder()), var2.readString(), (class_386[])var2.createTypedArray(class_386.CREATOR));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            this.a(class_25.class_1326.method_2670(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            this.b(class_25.class_1326.method_2670(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            class_25 var6 = class_25.class_1326.method_2670(var2.readStrongBinder());
            boolean var7;
            if(var2.readInt() != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            this.a(var6, var7);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            class_398.class_1609 var5;
            if(var2.readInt() != 0) {
               var5 = class_398.class_1609.CREATOR.method_2689(var2);
            } else {
               var5 = null;
            }

            this.a(var5, class_25.class_1326.method_2670(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1383 implements class_27 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_2817;

      class_1383(IBinder var1) {
         this.field_2817 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hl$a, com.google.android.gms.internal.hv) void
      public void method_181(class_398.class_1609 param1, class_25 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hv) void
      public void method_182(class_25 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hv, java.lang.String, com.google.android.gms.internal.hr[]) void
      public void method_183(class_25 param1, String param2, class_386[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hv, boolean) void
      public void method_184(class_25 param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2817;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.hv) void
      public void method_185(class_25 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
