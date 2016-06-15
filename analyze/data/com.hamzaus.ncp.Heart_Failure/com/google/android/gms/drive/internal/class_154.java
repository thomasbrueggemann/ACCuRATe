package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.internal.AddEventListenerRequest;
import com.google.android.gms.drive.internal.AuthorizeAccessRequest;
import com.google.android.gms.drive.internal.CheckResourceIdsExistRequest;
import com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest;
import com.google.android.gms.drive.internal.CloseContentsRequest;
import com.google.android.gms.drive.internal.CreateContentsRequest;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.internal.CreateFolderRequest;
import com.google.android.gms.drive.internal.DeleteCustomPropertyRequest;
import com.google.android.gms.drive.internal.DeleteResourceRequest;
import com.google.android.gms.drive.internal.DisconnectRequest;
import com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest;
import com.google.android.gms.drive.internal.GetMetadataRequest;
import com.google.android.gms.drive.internal.ListParentsRequest;
import com.google.android.gms.drive.internal.LoadRealtimeRequest;
import com.google.android.gms.drive.internal.OpenContentsRequest;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.QueryRequest;
import com.google.android.gms.drive.internal.RemoveEventListenerRequest;
import com.google.android.gms.drive.internal.SetResourceParentsRequest;
import com.google.android.gms.drive.internal.TrashResourceRequest;
import com.google.android.gms.drive.internal.UpdateMetadataRequest;
import com.google.android.gms.drive.internal.class_152;
import com.google.android.gms.drive.internal.class_153;

// $FF: renamed from: com.google.android.gms.drive.internal.aa
public interface class_154 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileIntentSenderRequest) android.content.IntentSender
   IntentSender method_836(CreateFileIntentSenderRequest var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OpenFileIntentSenderRequest) android.content.IntentSender
   IntentSender method_837(OpenFileIntentSenderRequest var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.AddEventListenerRequest, com.google.android.gms.drive.internal.ac, java.lang.String, com.google.android.gms.drive.internal.ab) void
   void method_838(AddEventListenerRequest var1, class_152 var2, String var3, class_153 var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.AuthorizeAccessRequest, com.google.android.gms.drive.internal.ab) void
   void method_839(AuthorizeAccessRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.CheckResourceIdsExistRequest, com.google.android.gms.drive.internal.ab) void
   void method_840(CheckResourceIdsExistRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest, com.google.android.gms.drive.internal.ab) void
   void method_841(CloseContentsAndUpdateMetadataRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsRequest, com.google.android.gms.drive.internal.ab) void
   void method_842(CloseContentsRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateContentsRequest, com.google.android.gms.drive.internal.ab) void
   void method_843(CreateContentsRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileRequest, com.google.android.gms.drive.internal.ab) void
   void method_844(CreateFileRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFolderRequest, com.google.android.gms.drive.internal.ab) void
   void method_845(CreateFolderRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.DeleteCustomPropertyRequest, com.google.android.gms.drive.internal.ab) void
   void method_846(DeleteCustomPropertyRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.DeleteResourceRequest, com.google.android.gms.drive.internal.ab) void
   void method_847(DeleteResourceRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.DisconnectRequest) void
   void method_848(DisconnectRequest var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest, com.google.android.gms.drive.internal.ab) void
   void method_849(GetDriveIdFromUniqueIdentifierRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.GetMetadataRequest, com.google.android.gms.drive.internal.ab) void
   void method_850(GetMetadataRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.ListParentsRequest, com.google.android.gms.drive.internal.ab) void
   void method_851(ListParentsRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.LoadRealtimeRequest, com.google.android.gms.drive.internal.ab) void
   void method_852(LoadRealtimeRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OpenContentsRequest, com.google.android.gms.drive.internal.ab) void
   void method_853(OpenContentsRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.ab) void
   void method_854(QueryRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.RemoveEventListenerRequest, com.google.android.gms.drive.internal.ac, java.lang.String, com.google.android.gms.drive.internal.ab) void
   void method_855(RemoveEventListenerRequest var1, class_152 var2, String var3, class_153 var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.SetResourceParentsRequest, com.google.android.gms.drive.internal.ab) void
   void method_856(SetResourceParentsRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.TrashResourceRequest, com.google.android.gms.drive.internal.ab) void
   void method_857(TrashResourceRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.UpdateMetadataRequest, com.google.android.gms.drive.internal.ab) void
   void method_858(UpdateMetadataRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.ab) void
   void method_859(class_153 var1) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.ab) void
   void method_860(QueryRequest var1, class_153 var2) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.drive.internal.ab) void
   void method_861(class_153 var1) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.drive.internal.ab) void
   void method_862(class_153 var1) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.drive.internal.ab) void
   void method_863(class_153 var1) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.drive.internal.ab) void
   void method_864(class_153 var1) throws RemoteException;

   public abstract static class class_856 extends Binder implements class_154 {
      // $FF: renamed from: P (android.os.IBinder) com.google.android.gms.drive.internal.aa
      public static class_154 method_3459(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (class_154)(var1 != null && var1 instanceof class_154?(class_154)var1:new class_154.class_857(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var53 = var2.readInt();
            GetMetadataRequest var54 = null;
            if(var53 != 0) {
               var54 = (GetMetadataRequest)GetMetadataRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var54, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var51 = var2.readInt();
            QueryRequest var52 = null;
            if(var51 != 0) {
               var52 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var52, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var49 = var2.readInt();
            UpdateMetadataRequest var50 = null;
            if(var49 != 0) {
               var50 = (UpdateMetadataRequest)UpdateMetadataRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var50, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var47 = var2.readInt();
            CreateContentsRequest var48 = null;
            if(var47 != 0) {
               var48 = (CreateContentsRequest)CreateContentsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var48, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var45 = var2.readInt();
            CreateFileRequest var46 = null;
            if(var45 != 0) {
               var46 = (CreateFileRequest)CreateFileRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var46, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var43 = var2.readInt();
            CreateFolderRequest var44 = null;
            if(var43 != 0) {
               var44 = (CreateFolderRequest)CreateFolderRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var44, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var41 = var2.readInt();
            OpenContentsRequest var42 = null;
            if(var41 != 0) {
               var42 = (OpenContentsRequest)OpenContentsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var42, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var39 = var2.readInt();
            CloseContentsRequest var40 = null;
            if(var39 != 0) {
               var40 = (CloseContentsRequest)CloseContentsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var40, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.a(class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var36 = var2.readInt();
            OpenFileIntentSenderRequest var37 = null;
            if(var36 != 0) {
               var37 = (OpenFileIntentSenderRequest)OpenFileIntentSenderRequest.CREATOR.createFromParcel(var2);
            }

            IntentSender var38 = this.a(var37);
            var3.writeNoException();
            if(var38 != null) {
               var3.writeInt(1);
               var38.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var33 = var2.readInt();
            CreateFileIntentSenderRequest var34 = null;
            if(var33 != 0) {
               var34 = (CreateFileIntentSenderRequest)CreateFileIntentSenderRequest.CREATOR.createFromParcel(var2);
            }

            IntentSender var35 = this.a(var34);
            var3.writeNoException();
            if(var35 != null) {
               var3.writeInt(1);
               var35.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var31 = var2.readInt();
            AuthorizeAccessRequest var32 = null;
            if(var31 != 0) {
               var32 = (AuthorizeAccessRequest)AuthorizeAccessRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var32, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var29 = var2.readInt();
            ListParentsRequest var30 = null;
            if(var29 != 0) {
               var30 = (ListParentsRequest)ListParentsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var30, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var27 = var2.readInt();
            AddEventListenerRequest var28 = null;
            if(var27 != 0) {
               var28 = (AddEventListenerRequest)AddEventListenerRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var28, class_152.class_854.method_1383(var2.readStrongBinder()), var2.readString(), class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var25 = var2.readInt();
            RemoveEventListenerRequest var26 = null;
            if(var25 != 0) {
               var26 = (RemoveEventListenerRequest)RemoveEventListenerRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var26, class_152.class_854.method_1383(var2.readStrongBinder()), var2.readString(), class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var23 = var2.readInt();
            DisconnectRequest var24 = null;
            if(var23 != 0) {
               var24 = (DisconnectRequest)DisconnectRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var24);
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var21 = var2.readInt();
            TrashResourceRequest var22 = null;
            if(var21 != 0) {
               var22 = (TrashResourceRequest)TrashResourceRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var22, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var19 = var2.readInt();
            CloseContentsAndUpdateMetadataRequest var20 = null;
            if(var19 != 0) {
               var20 = (CloseContentsAndUpdateMetadataRequest)CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var20, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var17 = var2.readInt();
            QueryRequest var18 = null;
            if(var17 != 0) {
               var18 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(var2);
            }

            this.b(var18, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.b(class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.c(class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.d(class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.e(class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var15 = var2.readInt();
            DeleteResourceRequest var16 = null;
            if(var15 != 0) {
               var16 = (DeleteResourceRequest)DeleteResourceRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var16, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var13 = var2.readInt();
            DeleteCustomPropertyRequest var14 = null;
            if(var13 != 0) {
               var14 = (DeleteCustomPropertyRequest)DeleteCustomPropertyRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var14, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 27:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var11 = var2.readInt();
            LoadRealtimeRequest var12 = null;
            if(var11 != 0) {
               var12 = (LoadRealtimeRequest)LoadRealtimeRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var12, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 28:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var9 = var2.readInt();
            SetResourceParentsRequest var10 = null;
            if(var9 != 0) {
               var10 = (SetResourceParentsRequest)SetResourceParentsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var10, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 29:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var7 = var2.readInt();
            GetDriveIdFromUniqueIdentifierRequest var8 = null;
            if(var7 != 0) {
               var8 = (GetDriveIdFromUniqueIdentifierRequest)GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var8, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 30:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var5 = var2.readInt();
            CheckResourceIdsExistRequest var6 = null;
            if(var5 != 0) {
               var6 = (CheckResourceIdsExistRequest)CheckResourceIdsExistRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var6, class_153.class_805.method_1330(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.internal.IDriveService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_857 implements class_154 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_4293;

      class_857(IBinder var1) {
         this.field_4293 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileIntentSenderRequest) android.content.IntentSender
      public IntentSender method_836(CreateFileIntentSenderRequest param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OpenFileIntentSenderRequest) android.content.IntentSender
      public IntentSender method_837(OpenFileIntentSenderRequest param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.AddEventListenerRequest, com.google.android.gms.drive.internal.ac, java.lang.String, com.google.android.gms.drive.internal.ab) void
      public void method_838(AddEventListenerRequest param1, class_152 param2, String param3, class_153 param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.AuthorizeAccessRequest, com.google.android.gms.drive.internal.ab) void
      public void method_839(AuthorizeAccessRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.CheckResourceIdsExistRequest, com.google.android.gms.drive.internal.ab) void
      public void method_840(CheckResourceIdsExistRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest, com.google.android.gms.drive.internal.ab) void
      public void method_841(CloseContentsAndUpdateMetadataRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsRequest, com.google.android.gms.drive.internal.ab) void
      public void method_842(CloseContentsRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateContentsRequest, com.google.android.gms.drive.internal.ab) void
      public void method_843(CreateContentsRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileRequest, com.google.android.gms.drive.internal.ab) void
      public void method_844(CreateFileRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFolderRequest, com.google.android.gms.drive.internal.ab) void
      public void method_845(CreateFolderRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.DeleteCustomPropertyRequest, com.google.android.gms.drive.internal.ab) void
      public void method_846(DeleteCustomPropertyRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.DeleteResourceRequest, com.google.android.gms.drive.internal.ab) void
      public void method_847(DeleteResourceRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.DisconnectRequest) void
      public void method_848(DisconnectRequest param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest, com.google.android.gms.drive.internal.ab) void
      public void method_849(GetDriveIdFromUniqueIdentifierRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.GetMetadataRequest, com.google.android.gms.drive.internal.ab) void
      public void method_850(GetMetadataRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.ListParentsRequest, com.google.android.gms.drive.internal.ab) void
      public void method_851(ListParentsRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.LoadRealtimeRequest, com.google.android.gms.drive.internal.ab) void
      public void method_852(LoadRealtimeRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OpenContentsRequest, com.google.android.gms.drive.internal.ab) void
      public void method_853(OpenContentsRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.ab) void
      public void method_854(QueryRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.RemoveEventListenerRequest, com.google.android.gms.drive.internal.ac, java.lang.String, com.google.android.gms.drive.internal.ab) void
      public void method_855(RemoveEventListenerRequest param1, class_152 param2, String param3, class_153 param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.SetResourceParentsRequest, com.google.android.gms.drive.internal.ab) void
      public void method_856(SetResourceParentsRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.TrashResourceRequest, com.google.android.gms.drive.internal.ab) void
      public void method_857(TrashResourceRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.UpdateMetadataRequest, com.google.android.gms.drive.internal.ab) void
      public void method_858(UpdateMetadataRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.ab) void
      public void method_859(class_153 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_4293;
      }

      // $FF: renamed from: b (com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.ab) void
      public void method_860(QueryRequest param1, class_153 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.drive.internal.ab) void
      public void method_861(class_153 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.drive.internal.ab) void
      public void method_862(class_153 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.drive.internal.ab) void
      public void method_863(class_153 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.drive.internal.ab) void
      public void method_864(class_153 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
