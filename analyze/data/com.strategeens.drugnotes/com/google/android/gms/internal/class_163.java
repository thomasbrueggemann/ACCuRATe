package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_164;

// $FF: renamed from: com.google.android.gms.internal.ok
public interface class_163 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.internal.oj, android.net.Uri, android.os.Bundle, boolean) void
   void method_836(class_164 var1, Uri var2, Bundle var3, boolean var4) throws RemoteException;

   public abstract static class class_1067 extends Binder implements class_163 {
      // $FF: renamed from: bG (android.os.IBinder) com.google.android.gms.internal.ok
      public static class_163 method_1610(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaService");
            return (class_163)(var1 != null && var1 instanceof class_163?(class_163)var1:new class_163.class_1068(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaService");
            class_164 var5 = class_164.class_1281.method_3139(var2.readStrongBinder());
            Uri var6;
            if(var2.readInt() != 0) {
               var6 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            Bundle var7;
            if(var2.readInt() != 0) {
               var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            boolean var8;
            if(var2.readInt() != 0) {
               var8 = true;
            } else {
               var8 = false;
            }

            this.a(var5, var6, var7, var8);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.panorama.internal.IPanoramaService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1068 implements class_163 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_2857;

      class_1068(IBinder var1) {
         this.field_2857 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.oj, android.net.Uri, android.os.Bundle, boolean) void
      public void method_836(class_164 param1, Uri param2, Bundle param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2857;
      }
   }
}
