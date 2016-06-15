package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.internal.class_324;
import com.google.android.gms.internal.class_325;

// $FF: renamed from: com.google.android.gms.internal.ir
public interface class_15 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.cast.ApplicationMetadata, java.lang.String, java.lang.String, boolean) void
   void method_98(ApplicationMetadata var1, String var2, String var3, boolean var4) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, double, boolean) void
   void method_99(String var1, double var2, boolean var4) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, long) void
   void method_100(String var1, long var2) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, long, int) void
   void method_101(String var1, long var2, int var4) throws RemoteException;

   // $FF: renamed from: ad (int) void
   void method_102(int var1) throws RemoteException;

   // $FF: renamed from: ae (int) void
   void method_103(int var1) throws RemoteException;

   // $FF: renamed from: af (int) void
   void method_104(int var1) throws RemoteException;

   // $FF: renamed from: ag (int) void
   void method_105(int var1) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.internal.ij) void
   void method_106(class_325 var1) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.internal.io) void
   void method_107(class_324 var1) throws RemoteException;

   // $FF: renamed from: b (java.lang.String, byte[]) void
   void method_108(String var1, byte[] var2) throws RemoteException;

   // $FF: renamed from: j (java.lang.String, java.lang.String) void
   void method_109(String var1, String var2) throws RemoteException;

   void onApplicationDisconnected(int var1) throws RemoteException;

   public abstract static class class_1404 extends Binder implements class_15 {
      public class_1404() {
         this.attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.ad(var2.readInt());
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            int var14 = var2.readInt();
            ApplicationMetadata var15 = null;
            if(var14 != 0) {
               var15 = (ApplicationMetadata)ApplicationMetadata.CREATOR.createFromParcel(var2);
            }

            String var16 = var2.readString();
            String var17 = var2.readString();
            int var18 = var2.readInt();
            boolean var19 = false;
            if(var18 != 0) {
               var19 = true;
            }

            this.a(var15, var16, var17, var19);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.ae(var2.readInt());
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            String var9 = var2.readString();
            double var10 = var2.readDouble();
            int var12 = var2.readInt();
            boolean var13 = false;
            if(var12 != 0) {
               var13 = true;
            }

            this.a(var9, var10, var13);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.j(var2.readString(), var2.readString());
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.b(var2.readString(), var2.createByteArray());
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.ag(var2.readInt());
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.af(var2.readInt());
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.onApplicationDisconnected(var2.readInt());
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.a(var2.readString(), var2.readLong(), var2.readInt());
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.a(var2.readString(), var2.readLong());
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            int var7 = var2.readInt();
            class_325 var8 = null;
            if(var7 != 0) {
               var8 = (class_325)class_325.CREATOR.createFromParcel(var2);
            }

            this.b(var8);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            int var5 = var2.readInt();
            class_324 var6 = null;
            if(var5 != 0) {
               var6 = (class_324)class_324.CREATOR.createFromParcel(var2);
            }

            this.b(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }
}
