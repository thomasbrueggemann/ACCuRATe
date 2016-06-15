package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.class_743;
import com.google.android.gms.wearable.internal.class_149;
import com.google.android.gms.wearable.internal.class_711;
import com.google.android.gms.wearable.internal.class_758;

// $FF: renamed from: com.google.android.gms.wearable.internal.ad
public interface class_151 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab) void
   void method_803(class_149 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab, android.net.Uri) void
   void method_804(class_149 var1, Uri var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab, com.google.android.gms.wearable.Asset) void
   void method_805(class_149 var1, Asset var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab, com.google.android.gms.wearable.PutDataRequest) void
   void method_806(class_149 var1, PutDataRequest var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab, com.google.android.gms.wearable.c) void
   void method_807(class_149 var1, class_743 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab, com.google.android.gms.wearable.internal.ao) void
   void method_808(class_149 var1, class_758 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab, com.google.android.gms.wearable.internal.b) void
   void method_809(class_149 var1, class_711 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab, java.lang.String, java.lang.String, byte[]) void
   void method_810(class_149 var1, String var2, String var3, byte[] var4) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.wearable.internal.ab) void
   void method_811(class_149 var1) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.wearable.internal.ab, android.net.Uri) void
   void method_812(class_149 var1, Uri var2) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.wearable.internal.ab) void
   void method_813(class_149 var1) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.wearable.internal.ab, android.net.Uri) void
   void method_814(class_149 var1, Uri var2) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.wearable.internal.ab) void
   void method_815(class_149 var1) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.wearable.internal.ab) void
   void method_816(class_149 var1) throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.wearable.internal.ab) void
   void method_817(class_149 var1) throws RemoteException;

   // $FF: renamed from: g (com.google.android.gms.wearable.internal.ab) void
   void method_818(class_149 var1) throws RemoteException;

   // $FF: renamed from: h (com.google.android.gms.wearable.internal.ab) void
   void method_819(class_149 var1) throws RemoteException;

   public abstract static class class_931 extends Binder implements class_151 {
      // $FF: renamed from: by (android.os.IBinder) com.google.android.gms.wearable.internal.ad
      public static class_151 method_4362(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (class_151)(var1 != null && var1 instanceof class_151?(class_151)var1:new class_151.class_932(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_149 var26 = class_149.class_872.method_3663(var2.readStrongBinder());
            int var27 = var2.readInt();
            class_743 var28 = null;
            if(var27 != 0) {
               var28 = (class_743)class_743.CREATOR.createFromParcel(var2);
            }

            this.a(var26, var28);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.a(class_149.class_872.method_3663(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.b(class_149.class_872.method_3663(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.c(class_149.class_872.method_3663(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_149 var23 = class_149.class_872.method_3663(var2.readStrongBinder());
            int var24 = var2.readInt();
            PutDataRequest var25 = null;
            if(var24 != 0) {
               var25 = (PutDataRequest)PutDataRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var23, var25);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_149 var20 = class_149.class_872.method_3663(var2.readStrongBinder());
            int var21 = var2.readInt();
            Uri var22 = null;
            if(var21 != 0) {
               var22 = (Uri)Uri.CREATOR.createFromParcel(var2);
            }

            this.a(var20, var22);
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.d(class_149.class_872.method_3663(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_149 var17 = class_149.class_872.method_3663(var2.readStrongBinder());
            int var18 = var2.readInt();
            Uri var19 = null;
            if(var18 != 0) {
               var19 = (Uri)Uri.CREATOR.createFromParcel(var2);
            }

            this.b(var17, var19);
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_149 var14 = class_149.class_872.method_3663(var2.readStrongBinder());
            int var15 = var2.readInt();
            Uri var16 = null;
            if(var15 != 0) {
               var16 = (Uri)Uri.CREATOR.createFromParcel(var2);
            }

            this.c(var14, var16);
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.a(class_149.class_872.method_3663(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.createByteArray());
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_149 var11 = class_149.class_872.method_3663(var2.readStrongBinder());
            int var12 = var2.readInt();
            Asset var13 = null;
            if(var12 != 0) {
               var13 = (Asset)Asset.CREATOR.createFromParcel(var2);
            }

            this.a(var11, var13);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.e(class_149.class_872.method_3663(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.f(class_149.class_872.method_3663(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_149 var8 = class_149.class_872.method_3663(var2.readStrongBinder());
            int var9 = var2.readInt();
            class_711 var10 = null;
            if(var9 != 0) {
               var10 = (class_711)class_711.CREATOR.createFromParcel(var2);
            }

            this.a(var8, var10);
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            class_149 var5 = class_149.class_872.method_3663(var2.readStrongBinder());
            int var6 = var2.readInt();
            class_758 var7 = null;
            if(var6 != 0) {
               var7 = (class_758)class_758.CREATOR.createFromParcel(var2);
            }

            this.a(var5, var7);
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.g(class_149.class_872.method_3663(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.h(class_149.class_872.method_3663(var2.readStrongBinder()));
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

   private static class class_932 implements class_151 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2161;

      class_932(IBinder var1) {
         this.field_2161 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab) void
      public void method_803(class_149 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab, android.net.Uri) void
      public void method_804(class_149 param1, Uri param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab, com.google.android.gms.wearable.Asset) void
      public void method_805(class_149 param1, Asset param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab, com.google.android.gms.wearable.PutDataRequest) void
      public void method_806(class_149 param1, PutDataRequest param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab, com.google.android.gms.wearable.c) void
      public void method_807(class_149 param1, class_743 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab, com.google.android.gms.wearable.internal.ao) void
      public void method_808(class_149 param1, class_758 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab, com.google.android.gms.wearable.internal.b) void
      public void method_809(class_149 param1, class_711 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab, java.lang.String, java.lang.String, byte[]) void
      public void method_810(class_149 param1, String param2, String param3, byte[] param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2161;
      }

      // $FF: renamed from: b (com.google.android.gms.wearable.internal.ab) void
      public void method_811(class_149 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.wearable.internal.ab, android.net.Uri) void
      public void method_812(class_149 param1, Uri param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.wearable.internal.ab) void
      public void method_813(class_149 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.wearable.internal.ab, android.net.Uri) void
      public void method_814(class_149 param1, Uri param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.wearable.internal.ab) void
      public void method_815(class_149 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.wearable.internal.ab) void
      public void method_816(class_149 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (com.google.android.gms.wearable.internal.ab) void
      public void method_817(class_149 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: g (com.google.android.gms.wearable.internal.ab) void
      public void method_818(class_149 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: h (com.google.android.gms.wearable.internal.ab) void
      public void method_819(class_149 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
