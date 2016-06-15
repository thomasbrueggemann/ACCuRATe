package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.s
public interface class_64 extends IInterface {
   // $FF: renamed from: a (java.lang.String, android.os.Bundle) android.os.Bundle
   Bundle method_336(String var1, Bundle var2) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, java.lang.String, android.os.Bundle) android.os.Bundle
   Bundle method_337(String var1, String var2, Bundle var3) throws RemoteException;

   public abstract static class class_1030 extends Binder implements class_64 {
      // $FF: renamed from: a (android.os.IBinder) com.google.android.gms.internal.s
      public static class_64 method_4491(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.auth.IAuthManagerService");
            return (class_64)(var1 != null && var1 instanceof class_64?(class_64)var1:new class_64.class_1031(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.auth.IAuthManagerService");
            String var9 = var2.readString();
            String var10 = var2.readString();
            int var11 = var2.readInt();
            Bundle var12 = null;
            if(var11 != 0) {
               var12 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            Bundle var13 = this.a(var9, var10, var12);
            var3.writeNoException();
            if(var13 != null) {
               var3.writeInt(1);
               var13.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 2:
            var2.enforceInterface("com.google.android.auth.IAuthManagerService");
            String var5 = var2.readString();
            int var6 = var2.readInt();
            Bundle var7 = null;
            if(var6 != 0) {
               var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            Bundle var8 = this.a(var5, var7);
            var3.writeNoException();
            if(var8 != null) {
               var3.writeInt(1);
               var8.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 1598968902:
            var3.writeString("com.google.android.auth.IAuthManagerService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1031 implements class_64 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2933;

      class_1031(IBinder var1) {
         this.field_2933 = var1;
      }

      // $FF: renamed from: a (java.lang.String, android.os.Bundle) android.os.Bundle
      public Bundle method_336(String param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, java.lang.String, android.os.Bundle) android.os.Bundle
      public Bundle method_337(String param1, String param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2933;
      }
   }
}
