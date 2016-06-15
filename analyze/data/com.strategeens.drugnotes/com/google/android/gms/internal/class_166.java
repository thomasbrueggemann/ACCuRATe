package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_814;
import com.google.android.gms.internal.class_818;
import com.google.android.gms.internal.or;
import com.google.android.gms.internal.ov;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.oq
public interface class_166 extends IInterface {
   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.ov, com.google.android.gms.internal.or) void
   void method_841(String var1, class_814 var2, class_818 var3) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.ov, java.util.List) void
   void method_842(String var1, ov var2, List<or> var3) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.ov, byte[]) void
   void method_843(String var1, class_814 var2, byte[] var3) throws RemoteException;

   public abstract static class class_1132 extends Binder implements class_166 {
      // $FF: renamed from: bI (android.os.IBinder) com.google.android.gms.internal.oq
      public static class_166 method_3812(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            return (class_166)(var1 != null && var1 instanceof class_166?(class_166)var1:new class_166.class_1133(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            String var11 = var2.readString();
            class_814 var12;
            if(var2.readInt() != 0) {
               var12 = class_814.CREATOR.method_4447(var2);
            } else {
               var12 = null;
            }

            int var13 = var2.readInt();
            class_818 var14 = null;
            if(var13 != 0) {
               var14 = class_818.CREATOR.method_4467(var2);
            }

            this.a(var11, var12, var14);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            String var8 = var2.readString();
            int var9 = var2.readInt();
            class_814 var10 = null;
            if(var9 != 0) {
               var10 = class_814.CREATOR.method_4447(var2);
            }

            this.a(var8, var10, var2.createTypedArrayList(class_818.CREATOR));
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            String var5 = var2.readString();
            int var6 = var2.readInt();
            class_814 var7 = null;
            if(var6 != 0) {
               var7 = class_814.CREATOR.method_4447(var2);
            }

            this.a(var5, var7, var2.createByteArray());
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.playlog.internal.IPlayLogService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1133 implements class_166 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_1287;

      class_1133(IBinder var1) {
         this.field_1287 = var1;
      }

      // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.ov, com.google.android.gms.internal.or) void
      public void method_841(String param1, class_814 param2, class_818 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.ov, java.util.List) void
      public void method_842(String param1, ov param2, List<or> param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.ov, byte[]) void
      public void method_843(String param1, class_814 param2, byte[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_1287;
      }
   }
}
