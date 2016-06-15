package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_289;
import com.google.android.gms.internal.class_33;
import com.google.android.gms.internal.class_340;
import com.google.android.gms.plus.internal.b;
import com.google.android.gms.plus.internal.class_144;
import java.util.List;

// $FF: renamed from: com.google.android.gms.plus.internal.d
public interface class_145 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.plus.internal.b, int, int, int, java.lang.String) com.google.android.gms.internal.hh
   class_33 method_731(class_144 var1, int var2, int var3, int var4, String var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.if) void
   void method_732(class_289 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.plus.internal.b) void
   void method_733(class_144 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.plus.internal.b, int, java.lang.String, android.net.Uri, java.lang.String, java.lang.String) void
   void method_734(class_144 var1, int var2, String var3, Uri var4, String var5, String var6) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.plus.internal.b, android.net.Uri, android.os.Bundle) void
   void method_735(class_144 var1, Uri var2, Bundle var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.plus.internal.b, com.google.android.gms.internal.if) void
   void method_736(class_144 var1, class_289 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.plus.internal.b, java.lang.String) void
   void method_737(class_144 var1, String var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.plus.internal.b, java.lang.String, java.lang.String) void
   void method_738(class_144 var1, String var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.plus.internal.b, java.util.List) void
   void method_739(b var1, List<String> var2) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.hs, com.google.android.gms.internal.hs) void
   void method_740(String var1, class_340 var2, class_340 var3) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.plus.internal.b) void
   void method_741(class_144 var1) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.plus.internal.b, java.lang.String) void
   void method_742(class_144 var1, String var2) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.plus.internal.b, java.lang.String) void
   void method_743(class_144 var1, String var2) throws RemoteException;

   void clearDefaultAccount() throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.plus.internal.b, java.lang.String) void
   void method_744(class_144 var1, String var2) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.plus.internal.b, java.lang.String) void
   void method_745(class_144 var1, String var2) throws RemoteException;

   String getAccountName() throws RemoteException;

   // $FF: renamed from: jP () java.lang.String
   String method_746() throws RemoteException;

   // $FF: renamed from: jQ () boolean
   boolean method_747() throws RemoteException;

   // $FF: renamed from: jR () java.lang.String
   String method_748() throws RemoteException;

   void removeMoment(String var1) throws RemoteException;

   public abstract static class class_1149 extends Binder implements class_145 {
      // $FF: renamed from: bm (android.os.IBinder) com.google.android.gms.plus.internal.d
      public static class_145 method_4057(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (class_145)(var1 != null && var1 instanceof class_145?(class_145)var1:new class_145.class_1150(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.a(class_144.class_1133.method_3254(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.a(class_144.class_1133.method_3254(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.b(class_144.class_1133.method_3254(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            class_289 var26;
            if(var2.readInt() != 0) {
               var26 = class_289.CREATOR.method_1968(var2);
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
            this.a(class_144.class_1133.method_3254(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            class_144 var22 = class_144.class_1133.method_3254(var2.readStrongBinder());
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
            class_144 var18 = class_144.class_1133.method_3254(var2.readStrongBinder());
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
            class_33 var16 = this.a(class_144.class_1133.method_3254(var2.readStrongBinder()), var2.readInt(), var2.readInt(), var2.readInt(), var2.readString());
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
            this.c(class_144.class_1133.method_3254(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.b(class_144.class_1133.method_3254(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 34:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.a(class_144.class_1133.method_3254(var2.readStrongBinder()), var2.createStringArrayList());
            var3.writeNoException();
            return true;
         case 40:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.d(class_144.class_1133.method_3254(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 41:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            String var15 = this.jP();
            var3.writeNoException();
            var3.writeString(var15);
            return true;
         case 42:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            boolean var13 = this.jQ();
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
            String var12 = this.jR();
            var3.writeNoException();
            var3.writeString(var12);
            return true;
         case 44:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.e(class_144.class_1133.method_3254(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 45:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            class_144 var9 = class_144.class_1133.method_3254(var2.readStrongBinder());
            int var10 = var2.readInt();
            class_289 var11 = null;
            if(var10 != 0) {
               var11 = class_289.CREATOR.method_1968(var2);
            }

            this.a(var9, var11);
            var3.writeNoException();
            return true;
         case 46:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            String var5 = var2.readString();
            class_340 var6;
            if(var2.readInt() != 0) {
               var6 = class_340.CREATOR.method_2151(var2);
            } else {
               var6 = null;
            }

            int var7 = var2.readInt();
            class_340 var8 = null;
            if(var7 != 0) {
               var8 = class_340.CREATOR.method_2151(var2);
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

   private static class class_1150 implements class_145 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3102;

      class_1150(IBinder var1) {
         this.field_3102 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b, int, int, int, java.lang.String) com.google.android.gms.internal.hh
      public class_33 method_731(class_144 param1, int param2, int param3, int param4, String param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.if) void
      public void method_732(class_289 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b) void
      public void method_733(class_144 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b, int, java.lang.String, android.net.Uri, java.lang.String, java.lang.String) void
      public void method_734(class_144 param1, int param2, String param3, Uri param4, String param5, String param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b, android.net.Uri, android.os.Bundle) void
      public void method_735(class_144 param1, Uri param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b, com.google.android.gms.internal.if) void
      public void method_736(class_144 param1, class_289 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b, java.lang.String) void
      public void method_737(class_144 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b, java.lang.String, java.lang.String) void
      public void method_738(class_144 param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.plus.internal.b, java.util.List) void
      public void method_739(b param1, List<String> param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.hs, com.google.android.gms.internal.hs) void
      public void method_740(String param1, class_340 param2, class_340 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3102;
      }

      // $FF: renamed from: b (com.google.android.gms.plus.internal.b) void
      public void method_741(class_144 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.plus.internal.b, java.lang.String) void
      public void method_742(class_144 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.plus.internal.b, java.lang.String) void
      public void method_743(class_144 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void clearDefaultAccount() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            this.field_3102.transact(6, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      // $FF: renamed from: d (com.google.android.gms.plus.internal.b, java.lang.String) void
      public void method_744(class_144 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.plus.internal.b, java.lang.String) void
      public void method_745(class_144 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public String getAccountName() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            this.field_3102.transact(5, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: jP () java.lang.String
      public String method_746() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            this.field_3102.transact(41, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: jQ () boolean
      public boolean method_747() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            this.field_3102.transact(42, var1, var2, 0);
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

      // $FF: renamed from: jR () java.lang.String
      public String method_748() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            this.field_3102.transact(43, var1, var2, 0);
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
            this.field_3102.transact(17, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }
   }
}
