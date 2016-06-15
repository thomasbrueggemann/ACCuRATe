package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;

// $FF: renamed from: com.google.android.gms.internal.bx
public interface class_8 extends IInterface {
   // $FF: renamed from: aw () void
   void method_29() throws RemoteException;

   // $FF: renamed from: bB () java.lang.String
   String method_30() throws RemoteException;

   // $FF: renamed from: bC () com.google.android.gms.dynamic.d
   class_198 method_31() throws RemoteException;

   // $FF: renamed from: bE () java.lang.String
   String method_32() throws RemoteException;

   // $FF: renamed from: bI () com.google.android.gms.dynamic.d
   class_198 method_33() throws RemoteException;

   // $FF: renamed from: bJ () java.lang.String
   String method_34() throws RemoteException;

   String getBody() throws RemoteException;

   // $FF: renamed from: j (int) void
   void method_35(int var1) throws RemoteException;

   public abstract static class class_1541 extends Binder implements class_8 {
      public class_1541() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            this.j(var2.readInt());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            this.aw();
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            String var12 = this.bB();
            var3.writeNoException();
            var3.writeString(var12);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            class_198 var10 = this.bC();
            var3.writeNoException();
            IBinder var11 = null;
            if(var10 != null) {
               var11 = var10.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            String var9 = this.getBody();
            var3.writeNoException();
            var3.writeString(var9);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            class_198 var7 = this.bI();
            var3.writeNoException();
            IBinder var8 = null;
            if(var7 != null) {
               var8 = var7.asBinder();
            }

            var3.writeStrongBinder(var8);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            String var6 = this.bE();
            var3.writeNoException();
            var3.writeString(var6);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            String var5 = this.bJ();
            var3.writeNoException();
            var3.writeString(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }
}
