package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.class_962;
import com.google.android.gms.wearable.internal.class_186;
import com.google.android.gms.wearable.internal.class_923;
import com.google.android.gms.wearable.internal.class_983;

// $FF: renamed from: com.google.android.gms.wearable.internal.af
public interface class_188 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad) void
   void method_980(class_186 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, android.net.Uri) void
   void method_981(class_186 var1, Uri var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.Asset) void
   void method_982(class_186 var1, Asset var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.PutDataRequest) void
   void method_983(class_186 var1, PutDataRequest var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.c) void
   void method_984(class_186 var1, class_962 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.internal.ar) void
   void method_985(class_186 var1, class_983 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.internal.b) void
   void method_986(class_186 var1, class_923 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, java.lang.String) void
   void method_987(class_186 var1, String var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, java.lang.String, java.lang.String, byte[]) void
   void method_988(class_186 var1, String var2, String var3, byte[] var4) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad) void
   void method_989(class_186 var1) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad, android.net.Uri) void
   void method_990(class_186 var1, Uri var2) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.c) void
   void method_991(class_186 var1, class_962 var2) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad, java.lang.String) void
   void method_992(class_186 var1, String var2) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.wearable.internal.ad) void
   void method_993(class_186 var1) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.wearable.internal.ad, android.net.Uri) void
   void method_994(class_186 var1, Uri var2) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.wearable.internal.ad, java.lang.String) void
   void method_995(class_186 var1, String var2) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.wearable.internal.ad) void
   void method_996(class_186 var1) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.wearable.internal.ad) void
   void method_997(class_186 var1) throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.wearable.internal.ad) void
   void method_998(class_186 var1) throws RemoteException;

   // $FF: renamed from: g (com.google.android.gms.wearable.internal.ad) void
   void method_999(class_186 var1) throws RemoteException;

   // $FF: renamed from: h (com.google.android.gms.wearable.internal.ad) void
   void method_1000(class_186 var1) throws RemoteException;

   // $FF: renamed from: i (com.google.android.gms.wearable.internal.ad) void
   void method_1001(class_186 var1) throws RemoteException;

   // $FF: renamed from: j (com.google.android.gms.wearable.internal.ad) void
   void method_1002(class_186 var1) throws RemoteException;

   // $FF: renamed from: k (com.google.android.gms.wearable.internal.ad) void
   void method_1003(class_186 var1) throws RemoteException;

   public abstract static class class_1127 extends Binder implements class_188 {
      // $FF: renamed from: bZ (android.os.IBinder) com.google.android.gms.wearable.internal.af
      public static class_188 method_2725(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (class_188)(var1 != null && var1 instanceof class_188?(class_188)var1:new class_188.class_1128(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_186 var5 = class_186.class_1221.method_4132(var2.readStrongBinder());
            int var6 = var2.readInt();
            class_962 var7 = null;
            if(var6 != 0) {
               var7 = (class_962)class_962.CREATOR.createFromParcel(var2);
            }

            this.b(var5, var7);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.i(class_186.class_1221.method_4132(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.j(class_186.class_1221.method_4132(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.k(class_186.class_1221.method_4132(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_186 var26 = class_186.class_1221.method_4132(var2.readStrongBinder());
            int var27 = var2.readInt();
            PutDataRequest var28 = null;
            if(var27 != 0) {
               var28 = (PutDataRequest)PutDataRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var26, var28);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_186 var23 = class_186.class_1221.method_4132(var2.readStrongBinder());
            int var24 = var2.readInt();
            Uri var25 = null;
            if(var24 != 0) {
               var25 = (Uri)Uri.CREATOR.createFromParcel(var2);
            }

            this.a(var23, var25);
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.b(class_186.class_1221.method_4132(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_186 var20 = class_186.class_1221.method_4132(var2.readStrongBinder());
            int var21 = var2.readInt();
            Uri var22 = null;
            if(var21 != 0) {
               var22 = (Uri)Uri.CREATOR.createFromParcel(var2);
            }

            this.b(var20, var22);
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_186 var17 = class_186.class_1221.method_4132(var2.readStrongBinder());
            int var18 = var2.readInt();
            Uri var19 = null;
            if(var18 != 0) {
               var19 = (Uri)Uri.CREATOR.createFromParcel(var2);
            }

            this.c(var17, var19);
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.a(class_186.class_1221.method_4132(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.createByteArray());
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_186 var14 = class_186.class_1221.method_4132(var2.readStrongBinder());
            int var15 = var2.readInt();
            Asset var16 = null;
            if(var15 != 0) {
               var16 = (Asset)Asset.CREATOR.createFromParcel(var2);
            }

            this.a(var14, var16);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.c(class_186.class_1221.method_4132(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.d(class_186.class_1221.method_4132(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_186 var11 = class_186.class_1221.method_4132(var2.readStrongBinder());
            int var12 = var2.readInt();
            class_923 var13 = null;
            if(var12 != 0) {
               var13 = (class_923)class_923.CREATOR.createFromParcel(var2);
            }

            this.a(var11, var13);
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_186 var8 = class_186.class_1221.method_4132(var2.readStrongBinder());
            int var9 = var2.readInt();
            class_983 var10 = null;
            if(var9 != 0) {
               var10 = (class_983)class_983.CREATOR.createFromParcel(var2);
            }

            this.a(var8, var10);
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.e(class_186.class_1221.method_4132(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.f(class_186.class_1221.method_4132(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_186 var29 = class_186.class_1221.method_4132(var2.readStrongBinder());
            int var30 = var2.readInt();
            class_962 var31 = null;
            if(var30 != 0) {
               var31 = (class_962)class_962.CREATOR.createFromParcel(var2);
            }

            this.a(var29, var31);
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.a(class_186.class_1221.method_4132(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.a(class_186.class_1221.method_4132(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.b(class_186.class_1221.method_4132(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.c(class_186.class_1221.method_4132(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 25:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.g(class_186.class_1221.method_4132(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.h(class_186.class_1221.method_4132(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wearable.internal.IWearableService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1128 implements class_188 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3110;

      class_1128(IBinder var1) {
         this.field_3110 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad) void
      public void method_980(class_186 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, android.net.Uri) void
      public void method_981(class_186 param1, Uri param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.Asset) void
      public void method_982(class_186 param1, Asset param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.PutDataRequest) void
      public void method_983(class_186 param1, PutDataRequest param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.c) void
      public void method_984(class_186 param1, class_962 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.internal.ar) void
      public void method_985(class_186 param1, class_983 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.internal.b) void
      public void method_986(class_186 param1, class_923 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, java.lang.String) void
      public void method_987(class_186 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, java.lang.String, java.lang.String, byte[]) void
      public void method_988(class_186 param1, String param2, String param3, byte[] param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3110;
      }

      // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad) void
      public void method_989(class_186 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad, android.net.Uri) void
      public void method_990(class_186 param1, Uri param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.c) void
      public void method_991(class_186 param1, class_962 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad, java.lang.String) void
      public void method_992(class_186 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.wearable.internal.ad) void
      public void method_993(class_186 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.wearable.internal.ad, android.net.Uri) void
      public void method_994(class_186 param1, Uri param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.wearable.internal.ad, java.lang.String) void
      public void method_995(class_186 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.wearable.internal.ad) void
      public void method_996(class_186 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.wearable.internal.ad) void
      public void method_997(class_186 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (com.google.android.gms.wearable.internal.ad) void
      public void method_998(class_186 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: g (com.google.android.gms.wearable.internal.ad) void
      public void method_999(class_186 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: h (com.google.android.gms.wearable.internal.ad) void
      public void method_1000(class_186 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: i (com.google.android.gms.wearable.internal.ad) void
      public void method_1001(class_186 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: j (com.google.android.gms.wearable.internal.ad) void
      public void method_1002(class_186 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: k (com.google.android.gms.wearable.internal.ad) void
      public void method_1003(class_186 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
