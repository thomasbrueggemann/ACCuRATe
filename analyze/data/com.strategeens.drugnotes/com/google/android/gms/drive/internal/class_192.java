package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;
import com.google.android.gms.drive.internal.AddEventListenerRequest;
import com.google.android.gms.drive.internal.AuthorizeAccessRequest;
import com.google.android.gms.drive.internal.CancelPendingActionsRequest;
import com.google.android.gms.drive.internal.CheckResourceIdsExistRequest;
import com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest;
import com.google.android.gms.drive.internal.CloseContentsRequest;
import com.google.android.gms.drive.internal.CreateContentsRequest;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.internal.CreateFolderRequest;
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
import com.google.android.gms.drive.internal.SetDrivePreferencesRequest;
import com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest;
import com.google.android.gms.drive.internal.SetResourceParentsRequest;
import com.google.android.gms.drive.internal.TrashResourceRequest;
import com.google.android.gms.drive.internal.UpdateMetadataRequest;
import com.google.android.gms.drive.internal.class_190;
import com.google.android.gms.drive.internal.class_191;

// $FF: renamed from: com.google.android.gms.drive.internal.ae
public interface class_192 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileIntentSenderRequest) android.content.IntentSender
   IntentSender method_1025(CreateFileIntentSenderRequest var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OpenFileIntentSenderRequest) android.content.IntentSender
   IntentSender method_1026(OpenFileIntentSenderRequest var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.RealtimeDocumentSyncRequest, com.google.android.gms.drive.internal.af) void
   void method_1027(RealtimeDocumentSyncRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.AddEventListenerRequest, com.google.android.gms.drive.internal.ag, java.lang.String, com.google.android.gms.drive.internal.af) void
   void method_1028(AddEventListenerRequest var1, class_190 var2, String var3, class_191 var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.AuthorizeAccessRequest, com.google.android.gms.drive.internal.af) void
   void method_1029(AuthorizeAccessRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.CancelPendingActionsRequest, com.google.android.gms.drive.internal.af) void
   void method_1030(CancelPendingActionsRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.CheckResourceIdsExistRequest, com.google.android.gms.drive.internal.af) void
   void method_1031(CheckResourceIdsExistRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest, com.google.android.gms.drive.internal.af) void
   void method_1032(CloseContentsAndUpdateMetadataRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsRequest, com.google.android.gms.drive.internal.af) void
   void method_1033(CloseContentsRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateContentsRequest, com.google.android.gms.drive.internal.af) void
   void method_1034(CreateContentsRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileRequest, com.google.android.gms.drive.internal.af) void
   void method_1035(CreateFileRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFolderRequest, com.google.android.gms.drive.internal.af) void
   void method_1036(CreateFolderRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.DeleteResourceRequest, com.google.android.gms.drive.internal.af) void
   void method_1037(DeleteResourceRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.DisconnectRequest) void
   void method_1038(DisconnectRequest var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest, com.google.android.gms.drive.internal.af) void
   void method_1039(GetDriveIdFromUniqueIdentifierRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.GetMetadataRequest, com.google.android.gms.drive.internal.af) void
   void method_1040(GetMetadataRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.ListParentsRequest, com.google.android.gms.drive.internal.af) void
   void method_1041(ListParentsRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.LoadRealtimeRequest, com.google.android.gms.drive.internal.af) void
   void method_1042(LoadRealtimeRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OpenContentsRequest, com.google.android.gms.drive.internal.af) void
   void method_1043(OpenContentsRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.af) void
   void method_1044(QueryRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.RemoveEventListenerRequest, com.google.android.gms.drive.internal.ag, java.lang.String, com.google.android.gms.drive.internal.af) void
   void method_1045(RemoveEventListenerRequest var1, class_190 var2, String var3, class_191 var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.SetDrivePreferencesRequest, com.google.android.gms.drive.internal.af) void
   void method_1046(SetDrivePreferencesRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest, com.google.android.gms.drive.internal.af) void
   void method_1047(SetFileUploadPreferencesRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.SetResourceParentsRequest, com.google.android.gms.drive.internal.af) void
   void method_1048(SetResourceParentsRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.TrashResourceRequest, com.google.android.gms.drive.internal.af) void
   void method_1049(TrashResourceRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.UpdateMetadataRequest, com.google.android.gms.drive.internal.af) void
   void method_1050(UpdateMetadataRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.drive.internal.af) void
   void method_1051(class_191 var1) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.af) void
   void method_1052(QueryRequest var1, class_191 var2) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.drive.internal.af) void
   void method_1053(class_191 var1) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.drive.internal.af) void
   void method_1054(class_191 var1) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.drive.internal.af) void
   void method_1055(class_191 var1) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.drive.internal.af) void
   void method_1056(class_191 var1) throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.drive.internal.af) void
   void method_1057(class_191 var1) throws RemoteException;

   // $FF: renamed from: g (com.google.android.gms.drive.internal.af) void
   void method_1058(class_191 var1) throws RemoteException;

   // $FF: renamed from: h (com.google.android.gms.drive.internal.af) void
   void method_1059(class_191 var1) throws RemoteException;

   public abstract static class class_1224 extends Binder implements class_192 {
      // $FF: renamed from: X (android.os.IBinder) com.google.android.gms.drive.internal.ae
      public static class_192 method_5801(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (class_192)(var1 != null && var1 instanceof class_192?(class_192)var1:new class_192.class_1225(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var59 = var2.readInt();
            GetMetadataRequest var60 = null;
            if(var59 != 0) {
               var60 = (GetMetadataRequest)GetMetadataRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var60, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var57 = var2.readInt();
            QueryRequest var58 = null;
            if(var57 != 0) {
               var58 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var58, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var55 = var2.readInt();
            UpdateMetadataRequest var56 = null;
            if(var55 != 0) {
               var56 = (UpdateMetadataRequest)UpdateMetadataRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var56, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var53 = var2.readInt();
            CreateContentsRequest var54 = null;
            if(var53 != 0) {
               var54 = (CreateContentsRequest)CreateContentsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var54, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var51 = var2.readInt();
            CreateFileRequest var52 = null;
            if(var51 != 0) {
               var52 = (CreateFileRequest)CreateFileRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var52, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var49 = var2.readInt();
            CreateFolderRequest var50 = null;
            if(var49 != 0) {
               var50 = (CreateFolderRequest)CreateFolderRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var50, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var47 = var2.readInt();
            OpenContentsRequest var48 = null;
            if(var47 != 0) {
               var48 = (OpenContentsRequest)OpenContentsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var48, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var45 = var2.readInt();
            CloseContentsRequest var46 = null;
            if(var45 != 0) {
               var46 = (CloseContentsRequest)CloseContentsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var46, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.a(class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var42 = var2.readInt();
            OpenFileIntentSenderRequest var43 = null;
            if(var42 != 0) {
               var43 = (OpenFileIntentSenderRequest)OpenFileIntentSenderRequest.CREATOR.createFromParcel(var2);
            }

            IntentSender var44 = this.a(var43);
            var3.writeNoException();
            if(var44 != null) {
               var3.writeInt(1);
               var44.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var39 = var2.readInt();
            CreateFileIntentSenderRequest var40 = null;
            if(var39 != 0) {
               var40 = (CreateFileIntentSenderRequest)CreateFileIntentSenderRequest.CREATOR.createFromParcel(var2);
            }

            IntentSender var41 = this.a(var40);
            var3.writeNoException();
            if(var41 != null) {
               var3.writeInt(1);
               var41.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var37 = var2.readInt();
            AuthorizeAccessRequest var38 = null;
            if(var37 != 0) {
               var38 = (AuthorizeAccessRequest)AuthorizeAccessRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var38, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var35 = var2.readInt();
            ListParentsRequest var36 = null;
            if(var35 != 0) {
               var36 = (ListParentsRequest)ListParentsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var36, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var33 = var2.readInt();
            AddEventListenerRequest var34 = null;
            if(var33 != 0) {
               var34 = (AddEventListenerRequest)AddEventListenerRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var34, class_190.class_1244.method_4904(var2.readStrongBinder()), var2.readString(), class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var31 = var2.readInt();
            RemoveEventListenerRequest var32 = null;
            if(var31 != 0) {
               var32 = (RemoveEventListenerRequest)RemoveEventListenerRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var32, class_190.class_1244.method_4904(var2.readStrongBinder()), var2.readString(), class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var29 = var2.readInt();
            DisconnectRequest var30 = null;
            if(var29 != 0) {
               var30 = (DisconnectRequest)DisconnectRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var30);
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var27 = var2.readInt();
            TrashResourceRequest var28 = null;
            if(var27 != 0) {
               var28 = (TrashResourceRequest)TrashResourceRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var28, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var25 = var2.readInt();
            CloseContentsAndUpdateMetadataRequest var26 = null;
            if(var25 != 0) {
               var26 = (CloseContentsAndUpdateMetadataRequest)CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var26, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var23 = var2.readInt();
            QueryRequest var24 = null;
            if(var23 != 0) {
               var24 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(var2);
            }

            this.b(var24, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.b(class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.c(class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.d(class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.e(class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var21 = var2.readInt();
            DeleteResourceRequest var22 = null;
            if(var21 != 0) {
               var22 = (DeleteResourceRequest)DeleteResourceRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var22, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 27:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var19 = var2.readInt();
            LoadRealtimeRequest var20 = null;
            if(var19 != 0) {
               var20 = (LoadRealtimeRequest)LoadRealtimeRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var20, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 28:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var17 = var2.readInt();
            SetResourceParentsRequest var18 = null;
            if(var17 != 0) {
               var18 = (SetResourceParentsRequest)SetResourceParentsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var18, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 29:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var15 = var2.readInt();
            GetDriveIdFromUniqueIdentifierRequest var16 = null;
            if(var15 != 0) {
               var16 = (GetDriveIdFromUniqueIdentifierRequest)GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var16, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 30:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var13 = var2.readInt();
            CheckResourceIdsExistRequest var14 = null;
            if(var13 != 0) {
               var14 = (CheckResourceIdsExistRequest)CheckResourceIdsExistRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var14, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 31:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.f(class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 32:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.g(class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 33:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var11 = var2.readInt();
            SetDrivePreferencesRequest var12 = null;
            if(var11 != 0) {
               var12 = (SetDrivePreferencesRequest)SetDrivePreferencesRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var12, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 34:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var9 = var2.readInt();
            RealtimeDocumentSyncRequest var10 = null;
            if(var9 != 0) {
               var10 = (RealtimeDocumentSyncRequest)RealtimeDocumentSyncRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var10, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 35:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.h(class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 36:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var7 = var2.readInt();
            SetFileUploadPreferencesRequest var8 = null;
            if(var7 != 0) {
               var8 = (SetFileUploadPreferencesRequest)SetFileUploadPreferencesRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var8, class_191.class_1242.method_1705(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 37:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            int var5 = var2.readInt();
            CancelPendingActionsRequest var6 = null;
            if(var5 != 0) {
               var6 = (CancelPendingActionsRequest)CancelPendingActionsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var6, class_191.class_1242.method_1705(var2.readStrongBinder()));
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

   private static class class_1225 implements class_192 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3191;

      class_1225(IBinder var1) {
         this.field_3191 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileIntentSenderRequest) android.content.IntentSender
      public IntentSender method_1025(CreateFileIntentSenderRequest param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OpenFileIntentSenderRequest) android.content.IntentSender
      public IntentSender method_1026(OpenFileIntentSenderRequest param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.RealtimeDocumentSyncRequest, com.google.android.gms.drive.internal.af) void
      public void method_1027(RealtimeDocumentSyncRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.AddEventListenerRequest, com.google.android.gms.drive.internal.ag, java.lang.String, com.google.android.gms.drive.internal.af) void
      public void method_1028(AddEventListenerRequest param1, class_190 param2, String param3, class_191 param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.AuthorizeAccessRequest, com.google.android.gms.drive.internal.af) void
      public void method_1029(AuthorizeAccessRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.CancelPendingActionsRequest, com.google.android.gms.drive.internal.af) void
      public void method_1030(CancelPendingActionsRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.CheckResourceIdsExistRequest, com.google.android.gms.drive.internal.af) void
      public void method_1031(CheckResourceIdsExistRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest, com.google.android.gms.drive.internal.af) void
      public void method_1032(CloseContentsAndUpdateMetadataRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsRequest, com.google.android.gms.drive.internal.af) void
      public void method_1033(CloseContentsRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateContentsRequest, com.google.android.gms.drive.internal.af) void
      public void method_1034(CreateContentsRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileRequest, com.google.android.gms.drive.internal.af) void
      public void method_1035(CreateFileRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFolderRequest, com.google.android.gms.drive.internal.af) void
      public void method_1036(CreateFolderRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.DeleteResourceRequest, com.google.android.gms.drive.internal.af) void
      public void method_1037(DeleteResourceRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.DisconnectRequest) void
      public void method_1038(DisconnectRequest param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest, com.google.android.gms.drive.internal.af) void
      public void method_1039(GetDriveIdFromUniqueIdentifierRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.GetMetadataRequest, com.google.android.gms.drive.internal.af) void
      public void method_1040(GetMetadataRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.ListParentsRequest, com.google.android.gms.drive.internal.af) void
      public void method_1041(ListParentsRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.LoadRealtimeRequest, com.google.android.gms.drive.internal.af) void
      public void method_1042(LoadRealtimeRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OpenContentsRequest, com.google.android.gms.drive.internal.af) void
      public void method_1043(OpenContentsRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.af) void
      public void method_1044(QueryRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.RemoveEventListenerRequest, com.google.android.gms.drive.internal.ag, java.lang.String, com.google.android.gms.drive.internal.af) void
      public void method_1045(RemoveEventListenerRequest param1, class_190 param2, String param3, class_191 param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.SetDrivePreferencesRequest, com.google.android.gms.drive.internal.af) void
      public void method_1046(SetDrivePreferencesRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest, com.google.android.gms.drive.internal.af) void
      public void method_1047(SetFileUploadPreferencesRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.SetResourceParentsRequest, com.google.android.gms.drive.internal.af) void
      public void method_1048(SetResourceParentsRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.TrashResourceRequest, com.google.android.gms.drive.internal.af) void
      public void method_1049(TrashResourceRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.UpdateMetadataRequest, com.google.android.gms.drive.internal.af) void
      public void method_1050(UpdateMetadataRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.af) void
      public void method_1051(class_191 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3191;
      }

      // $FF: renamed from: b (com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.af) void
      public void method_1052(QueryRequest param1, class_191 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.drive.internal.af) void
      public void method_1053(class_191 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.drive.internal.af) void
      public void method_1054(class_191 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.drive.internal.af) void
      public void method_1055(class_191 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.drive.internal.af) void
      public void method_1056(class_191 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (com.google.android.gms.drive.internal.af) void
      public void method_1057(class_191 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: g (com.google.android.gms.drive.internal.af) void
      public void method_1058(class_191 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: h (com.google.android.gms.drive.internal.af) void
      public void method_1059(class_191 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
