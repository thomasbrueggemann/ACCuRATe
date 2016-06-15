package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.internal.OnContentsResponse;
import com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse;
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;
import com.google.android.gms.drive.internal.OnDriveIdResponse;
import com.google.android.gms.drive.internal.OnDrivePreferencesResponse;
import com.google.android.gms.drive.internal.OnListEntriesResponse;
import com.google.android.gms.drive.internal.OnListParentsResponse;
import com.google.android.gms.drive.internal.OnLoadRealtimeResponse;
import com.google.android.gms.drive.internal.OnMetadataResponse;
import com.google.android.gms.drive.internal.OnResourceIdSetResponse;
import com.google.android.gms.drive.internal.OnStorageStatsResponse;
import com.google.android.gms.drive.internal.OnSyncMoreResponse;
import com.google.android.gms.drive.realtime.internal.class_131;

// $FF: renamed from: com.google.android.gms.drive.internal.af
public interface class_191 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnContentsResponse) void
   void method_1012(OnContentsResponse var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse) void
   void method_1013(OnDeviceUsagePreferenceResponse var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDownloadProgressResponse) void
   void method_1014(OnDownloadProgressResponse var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDriveIdResponse) void
   void method_1015(OnDriveIdResponse var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDrivePreferencesResponse) void
   void method_1016(OnDrivePreferencesResponse var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnListEntriesResponse) void
   void method_1017(OnListEntriesResponse var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnListParentsResponse) void
   void method_1018(OnListParentsResponse var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnLoadRealtimeResponse, com.google.android.gms.drive.realtime.internal.m) void
   void method_1019(OnLoadRealtimeResponse var1, class_131 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnMetadataResponse) void
   void method_1020(OnMetadataResponse var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnResourceIdSetResponse) void
   void method_1021(OnResourceIdSetResponse var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnStorageStatsResponse) void
   void method_1022(OnStorageStatsResponse var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnSyncMoreResponse) void
   void method_1023(OnSyncMoreResponse var1) throws RemoteException;

   // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
   void method_1024(Status var1) throws RemoteException;

   void onSuccess() throws RemoteException;

   public abstract static class class_1242 extends Binder implements class_191 {
      public class_1242() {
         this.attachInterface(this, "com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      }

      // $FF: renamed from: Y (android.os.IBinder) com.google.android.gms.drive.internal.af
      public static class_191 method_1705(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            return (class_191)(var1 != null && var1 instanceof class_191?(class_191)var1:new class_191.class_1243(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            int var29 = var2.readInt();
            OnDownloadProgressResponse var30 = null;
            if(var29 != 0) {
               var30 = (OnDownloadProgressResponse)OnDownloadProgressResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var30);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            int var27 = var2.readInt();
            OnListEntriesResponse var28 = null;
            if(var27 != 0) {
               var28 = (OnListEntriesResponse)OnListEntriesResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var28);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            int var25 = var2.readInt();
            OnDriveIdResponse var26 = null;
            if(var25 != 0) {
               var26 = (OnDriveIdResponse)OnDriveIdResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var26);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            int var23 = var2.readInt();
            OnMetadataResponse var24 = null;
            if(var23 != 0) {
               var24 = (OnMetadataResponse)OnMetadataResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var24);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            int var21 = var2.readInt();
            OnContentsResponse var22 = null;
            if(var21 != 0) {
               var22 = (OnContentsResponse)OnContentsResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var22);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            int var19 = var2.readInt();
            Status var20 = null;
            if(var19 != 0) {
               var20 = Status.CREATOR.createFromParcel(var2);
            }

            this.n(var20);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            this.onSuccess();
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            int var17 = var2.readInt();
            OnListParentsResponse var18 = null;
            if(var17 != 0) {
               var18 = (OnListParentsResponse)OnListParentsResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var18);
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            int var15 = var2.readInt();
            OnSyncMoreResponse var16 = null;
            if(var15 != 0) {
               var16 = (OnSyncMoreResponse)OnSyncMoreResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var16);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            int var13 = var2.readInt();
            OnStorageStatsResponse var14 = null;
            if(var13 != 0) {
               var14 = (OnStorageStatsResponse)OnStorageStatsResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var14);
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            int var11 = var2.readInt();
            OnLoadRealtimeResponse var12 = null;
            if(var11 != 0) {
               var12 = (OnLoadRealtimeResponse)OnLoadRealtimeResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var12, class_131.class_1465.method_3802(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            int var9 = var2.readInt();
            OnResourceIdSetResponse var10 = null;
            if(var9 != 0) {
               var10 = (OnResourceIdSetResponse)OnResourceIdSetResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var10);
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            int var7 = var2.readInt();
            OnDrivePreferencesResponse var8 = null;
            if(var7 != 0) {
               var8 = (OnDrivePreferencesResponse)OnDrivePreferencesResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var8);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            int var5 = var2.readInt();
            OnDeviceUsagePreferenceResponse var6 = null;
            if(var5 != 0) {
               var6 = (OnDeviceUsagePreferenceResponse)OnDeviceUsagePreferenceResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var6);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1243 implements class_191 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4506;

      class_1243(IBinder var1) {
         this.field_4506 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnContentsResponse) void
      public void method_1012(OnContentsResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse) void
      public void method_1013(OnDeviceUsagePreferenceResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDownloadProgressResponse) void
      public void method_1014(OnDownloadProgressResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDriveIdResponse) void
      public void method_1015(OnDriveIdResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDrivePreferencesResponse) void
      public void method_1016(OnDrivePreferencesResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnListEntriesResponse) void
      public void method_1017(OnListEntriesResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnListParentsResponse) void
      public void method_1018(OnListParentsResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnLoadRealtimeResponse, com.google.android.gms.drive.realtime.internal.m) void
      public void method_1019(OnLoadRealtimeResponse param1, class_131 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnMetadataResponse) void
      public void method_1020(OnMetadataResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnResourceIdSetResponse) void
      public void method_1021(OnResourceIdSetResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnStorageStatsResponse) void
      public void method_1022(OnStorageStatsResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnSyncMoreResponse) void
      public void method_1023(OnSyncMoreResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_4506;
      }

      // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
      public void method_1024(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onSuccess() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            this.field_4506.transact(7, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
