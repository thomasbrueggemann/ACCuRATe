package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_21;
import com.google.android.gms.internal.class_731;
import com.google.android.gms.internal.class_742;
import com.google.android.gms.plus.internal.b;
import com.google.android.gms.plus.internal.class_178;
import java.util.List;

// $FF: renamed from: com.google.android.gms.plus.internal.d
public interface class_181 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.plus.internal.b, int, int, int, java.lang.String) com.google.android.gms.internal.jr
   class_21 method_896(class_178 var1, int var2, int var3, int var4, String var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.ky) void
   void method_897(class_731 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.plus.internal.b) void
   void method_898(class_178 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.plus.internal.b, int, java.lang.String, android.net.Uri, java.lang.String, java.lang.String) void
   void method_899(class_178 var1, int var2, String var3, Uri var4, String var5, String var6) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.plus.internal.b, android.net.Uri, android.os.Bundle) void
   void method_900(class_178 var1, Uri var2, Bundle var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.plus.internal.b, com.google.android.gms.internal.ky) void
   void method_901(class_178 var1, class_731 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.plus.internal.b, java.lang.String) void
   void method_902(class_178 var1, String var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.plus.internal.b, java.lang.String, java.lang.String) void
   void method_903(class_178 var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.plus.internal.b, java.util.List) void
   void method_904(b var1, List<String> var2) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.kk, com.google.android.gms.internal.kk) void
   void method_905(String var1, class_742 var2, class_742 var3) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.plus.internal.b) void
   void method_906(class_178 var1) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.plus.internal.b, java.lang.String) void
   void method_907(class_178 var1, String var2) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.plus.internal.b, java.lang.String) void
   void method_908(class_178 var1, String var2) throws RemoteException;

   void clearDefaultAccount() throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.plus.internal.b, java.lang.String) void
   void method_909(class_178 var1, String var2) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.plus.internal.b, java.lang.String) void
   void method_910(class_178 var1, String var2) throws RemoteException;

   String getAccountName() throws RemoteException;

   // $FF: renamed from: ou () java.lang.String
   String method_911() throws RemoteException;

   // $FF: renamed from: ov () boolean
   boolean method_912() throws RemoteException;

   // $FF: renamed from: ow () java.lang.String
   String method_913() throws RemoteException;

   void removeMoment(String var1) throws RemoteException;

   public abstract static class class_1509 extends Binder implements class_181 {
      // $FF: renamed from: bM (android.os.IBinder) com.google.android.gms.plus.internal.d
      public static class_181 method_5117(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (class_181)(var1 != null && var1 instanceof class_181?(class_181)var1:new class_181.class_1510(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.a(class_178.class_1480.method_3858(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.a(class_178.class_1480.method_3858(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.b(class_178.class_1480.method_3858(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            class_731 var26;
            if(var2.readInt() != 0) {
               var26 = class_731.CREATOR.method_4219(var2);
            } else {
               var26 = null;
            }

            this.a(var26);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            String var25 = this.getAccountName();
            var3.writeNoException();
            var3.writeString(var25);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.clearDefaultAccount();
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.a(class_178.class_1480.method_3858(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            class_178 var22 = class_178.class_1480.method_3858(var2.readStrongBinder());
            Uri var23;
            if(var2.readInt() != 0) {
               var23 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var23 = null;
            }

            Bundle var24;
            if(var2.readInt() != 0) {
               var24 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var24 = null;
            }

            this.a(var22, var23, var24);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            class_178 var18 = class_178.class_1480.method_3858(var2.readStrongBinder());
            int var19 = var2.readInt();
            String var20 = var2.readString();
            Uri var21;
            if(var2.readInt() != 0) {
               var21 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var21 = null;
            }

            this.a(var18, var19, var20, var21, var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            class_21 var16 = this.a(class_178.class_1480.method_3858(var2.readStrongBinder()), var2.readInt(), var2.readInt(), var2.readInt(), var2.readString());
            var3.writeNoException();
            IBinder var17 = null;
            if(var16 != null) {
               var17 = var16.asBinder();
            }

            var3.writeStrongBinder(var17);
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.removeMoment(var2.readString());
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.c(class_178.class_1480.method_3858(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.b(class_178.class_1480.method_3858(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 34:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.a(class_178.class_1480.method_3858(var2.readStrongBinder()), var2.createStringArrayList());
            var3.writeNoException();
            return true;
         case 40:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.d(class_178.class_1480.method_3858(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 41:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            String var15 = this.ou();
            var3.writeNoException();
            var3.writeString(var15);
            return true;
         case 42:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            boolean var13 = this.ov();
            var3.writeNoException();
            byte var14;
            if(var13) {
               var14 = 1;
            } else {
               var14 = 0;
            }

            var3.writeInt(var14);
            return true;
         case 43:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            String var12 = this.ow();
            var3.writeNoException();
            var3.writeString(var12);
            return true;
         case 44:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.e(class_178.class_1480.method_3858(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 45:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            class_178 var9 = class_178.class_1480.method_3858(var2.readStrongBinder());
            int var10 = var2.readInt();
            class_731 var11 = null;
            if(var10 != 0) {
               var11 = class_731.CREATOR.method_4219(var2);
            }

            this.a(var9, var11);
            var3.writeNoException();
            return true;
         case 46:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            String var5 = var2.readString();
            class_742 var6;
            if(var2.readInt() != 0) {
               var6 = class_742.CREATOR.method_4313(var2);
            } else {
               var6 = null;
            }

            int var7 = var2.readInt();
            class_742 var8 = null;
            if(var7 != 0) {
               var8 = class_742.CREATOR.method_4313(var2);
            }

            this.a(var5, var6, var8);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.plus.internal.IPlusService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1510 implements class_181 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3052;

      class_1510(IBinder var1) {
         this.field_3052 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b, int, int, int, java.lang.String) com.google.android.gms.internal.jr
      public class_21 method_896(class_178 param1, int param2, int param3, int param4, String param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ky) void
      public void method_897(class_731 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b) void
      public void method_898(class_178 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b, int, java.lang.String, android.net.Uri, java.lang.String, java.lang.String) void
      public void method_899(class_178 param1, int param2, String param3, Uri param4, String param5, String param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b, android.net.Uri, android.os.Bundle) void
      public void method_900(class_178 param1, Uri param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b, com.google.android.gms.internal.ky) void
      public void method_901(class_178 param1, class_731 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b, java.lang.String) void
      public void method_902(class_178 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b, java.lang.String, java.lang.String) void
      public void method_903(class_178 param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b, java.util.List) void
      public void method_904(b param1, List<String> param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.kk, com.google.android.gms.internal.kk) void
      public void method_905(String param1, class_742 param2, class_742 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3052;
      }

      // $FF: renamed from: b (com.google.android.gms.plus.internal.b) void
      public void method_906(class_178 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.plus.internal.b, java.lang.String) void
      public void method_907(class_178 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.plus.internal.b, java.lang.String) void
      public void method_908(class_178 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void clearDefaultAccount() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            this.field_3052.transact(6, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      // $FF: renamed from: d (com.google.android.gms.plus.internal.b, java.lang.String) void
      public void method_909(class_178 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.plus.internal.b, java.lang.String) void
      public void method_910(class_178 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public String getAccountName() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            this.field_3052.transact(5, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: ou () java.lang.String
      public String method_911() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            this.field_3052.transact(41, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: ov () boolean
      public boolean method_912() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            this.field_3052.transact(42, var1, var2, 0);
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

      // $FF: renamed from: ow () java.lang.String
      public String method_913() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            this.field_3052.transact(43, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public void removeMoment(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            var2.writeString(var1);
            this.field_3052.transact(17, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }
   }
}
