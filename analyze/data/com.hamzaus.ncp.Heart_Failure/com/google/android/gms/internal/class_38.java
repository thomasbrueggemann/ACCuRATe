package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_37;
import com.google.android.gms.internal.class_386;

// $FF: renamed from: com.google.android.gms.internal.fv
public interface class_38 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.internal.fw) void
   void method_195(class_37 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.fw, java.lang.String, com.google.android.gms.internal.fs[]) void
   void method_196(class_37 var1, String var2, class_386[] var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.fw, boolean) void
   void method_197(class_37 var1, boolean var2) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.internal.fw) void
   void method_198(class_37 var1) throws RemoteException;

   public abstract static class class_1071 extends Binder implements class_38 {
      // $FF: renamed from: A (android.os.IBinder) com.google.android.gms.internal.fv
      public static class_38 method_3660(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            return (class_38)(var1 != null && var1 instanceof class_38?(class_38)var1:new class_38.class_1072(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            this.a(class_37.class_1066.method_2475(var2.readStrongBinder()), var2.readString(), (class_386[])var2.createTypedArray(class_386.CREATOR));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            this.a(class_37.class_1066.method_2475(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            this.b(class_37.class_1066.method_2475(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            class_37 var5 = class_37.class_1066.method_2475(var2.readStrongBinder());
            boolean var6;
            if(var2.readInt() != 0) {
               var6 = true;
            } else {
               var6 = false;
            }

            this.a(var5, var6);
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

   private static class class_1072 implements class_38 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3852;

      class_1072(IBinder var1) {
         this.field_3852 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.fw) void
      public void method_195(class_37 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.fw, java.lang.String, com.google.android.gms.internal.fs[]) void
      public void method_196(class_37 param1, String param2, class_386[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.fw, boolean) void
      public void method_197(class_37 param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3852;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.fw) void
      public void method_198(class_37 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
