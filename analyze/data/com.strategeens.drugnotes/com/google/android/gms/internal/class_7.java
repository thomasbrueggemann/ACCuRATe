package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;

// $FF: renamed from: com.google.android.gms.internal.bw
public interface class_7 extends IInterface {
   // $FF: renamed from: aw () void
   void method_20() throws RemoteException;

   // $FF: renamed from: bB () java.lang.String
   String method_21() throws RemoteException;

   // $FF: renamed from: bC () com.google.android.gms.dynamic.d
   class_198 method_22() throws RemoteException;

   // $FF: renamed from: bD () com.google.android.gms.dynamic.d
   class_198 method_23() throws RemoteException;

   // $FF: renamed from: bE () java.lang.String
   String method_24() throws RemoteException;

   // $FF: renamed from: bF () double
   double method_25() throws RemoteException;

   // $FF: renamed from: bG () java.lang.String
   String method_26() throws RemoteException;

   // $FF: renamed from: bH () java.lang.String
   String method_27() throws RemoteException;

   String getBody() throws RemoteException;

   // $FF: renamed from: j (int) void
   void method_28(int var1) throws RemoteException;

   public abstract static class class_1494 extends Binder implements class_7 {
      public class_1494() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            this.j(var2.readInt());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            this.aw();
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            String var15 = this.bB();
            var3.writeNoException();
            var3.writeString(var15);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            class_198 var13 = this.bC();
            var3.writeNoException();
            IBinder var14 = null;
            if(var13 != null) {
               var14 = var13.asBinder();
            }

            var3.writeStrongBinder(var14);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            String var12 = this.getBody();
            var3.writeNoException();
            var3.writeString(var12);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            class_198 var10 = this.bD();
            var3.writeNoException();
            IBinder var11 = null;
            if(var10 != null) {
               var11 = var10.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            String var9 = this.bE();
            var3.writeNoException();
            var3.writeString(var9);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            double var7 = this.bF();
            var3.writeNoException();
            var3.writeDouble(var7);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            String var6 = this.bG();
            var3.writeNoException();
            var3.writeString(var6);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            String var5 = this.bH();
            var3.writeNoException();
            var3.writeString(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }
}
