package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_395;
import com.google.android.gms.internal.fe;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.ff
public interface class_39 extends IInterface {
   // $FF: renamed from: a (java.util.Map, long, java.lang.String, java.util.List) void
   void method_199(Map var1, long var2, String var4, List<fe> var5) throws RemoteException;

   // $FF: renamed from: cg () void
   void method_200() throws RemoteException;

   String getVersion() throws RemoteException;

   public abstract static class class_1069 extends Binder implements class_39 {
      // $FF: renamed from: z (android.os.IBinder) com.google.android.gms.internal.ff
      public static class_39 method_4180(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            return (class_39)(var1 != null && var1 instanceof class_39?(class_39)var1:new class_39.class_1070(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            this.a(var2.readHashMap(this.getClass().getClassLoader()), var2.readLong(), var2.readString(), var2.createTypedArrayList(class_395.CREATOR));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            this.cg();
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            String var5 = this.getVersion();
            var3.writeNoException();
            var3.writeString(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1070 implements class_39 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3126;

      class_1070(IBinder var1) {
         this.field_3126 = var1;
      }

      // $FF: renamed from: a (java.util.Map, long, java.lang.String, java.util.List) void
      public void method_199(Map var1, long var2, String var4, List<fe> var5) throws RemoteException {
         Parcel var6 = Parcel.obtain();
         Parcel var7 = Parcel.obtain();

         try {
            var6.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
            var6.writeMap(var1);
            var6.writeLong(var2);
            var6.writeString(var4);
            var6.writeTypedList(var5);
            this.field_3126.transact(1, var6, var7, 0);
            var7.readException();
         } finally {
            var7.recycle();
            var6.recycle();
         }

      }

      public IBinder asBinder() {
         return this.field_3126;
      }

      // $FF: renamed from: cg () void
      public void method_200() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
            this.field_3126.transact(2, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public String getVersion() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
            this.field_3126.transact(3, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }
   }
}
