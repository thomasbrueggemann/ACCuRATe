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
import com.google.android.gms.drive.internal.SetResourceParentsRequest;
import com.google.android.gms.drive.internal.TrashResourceRequest;
import com.google.android.gms.drive.internal.UpdateMetadataRequest;
import com.google.android.gms.drive.internal.class_197;
import com.google.android.gms.drive.internal.class_198;

// $FF: renamed from: com.google.android.gms.drive.internal.ab
public interface class_199 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileIntentSenderRequest) android.content.IntentSender
    IntentSender method_1013(CreateFileIntentSenderRequest var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.OpenFileIntentSenderRequest) android.content.IntentSender
    IntentSender method_1014(OpenFileIntentSenderRequest var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.RealtimeDocumentSyncRequest, com.google.android.gms.drive.internal.ac) void
    void method_1015(RealtimeDocumentSyncRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.AddEventListenerRequest, com.google.android.gms.drive.internal.ad, java.lang.String, com.google.android.gms.drive.internal.ac) void
    void method_1016(AddEventListenerRequest var1, class_197 var2, String var3, class_198 var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.AuthorizeAccessRequest, com.google.android.gms.drive.internal.ac) void
    void method_1017(AuthorizeAccessRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.CheckResourceIdsExistRequest, com.google.android.gms.drive.internal.ac) void
    void method_1018(CheckResourceIdsExistRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest, com.google.android.gms.drive.internal.ac) void
    void method_1019(CloseContentsAndUpdateMetadataRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsRequest, com.google.android.gms.drive.internal.ac) void
    void method_1020(CloseContentsRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateContentsRequest, com.google.android.gms.drive.internal.ac) void
    void method_1021(CreateContentsRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileRequest, com.google.android.gms.drive.internal.ac) void
    void method_1022(CreateFileRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFolderRequest, com.google.android.gms.drive.internal.ac) void
    void method_1023(CreateFolderRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.DeleteResourceRequest, com.google.android.gms.drive.internal.ac) void
    void method_1024(DeleteResourceRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.DisconnectRequest) void
    void method_1025(DisconnectRequest var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest, com.google.android.gms.drive.internal.ac) void
    void method_1026(GetDriveIdFromUniqueIdentifierRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.GetMetadataRequest, com.google.android.gms.drive.internal.ac) void
    void method_1027(GetMetadataRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.ListParentsRequest, com.google.android.gms.drive.internal.ac) void
    void method_1028(ListParentsRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.LoadRealtimeRequest, com.google.android.gms.drive.internal.ac) void
    void method_1029(LoadRealtimeRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.OpenContentsRequest, com.google.android.gms.drive.internal.ac) void
    void method_1030(OpenContentsRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.ac) void
    void method_1031(QueryRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.RemoveEventListenerRequest, com.google.android.gms.drive.internal.ad, java.lang.String, com.google.android.gms.drive.internal.ac) void
    void method_1032(RemoveEventListenerRequest var1, class_197 var2, String var3, class_198 var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.SetDrivePreferencesRequest, com.google.android.gms.drive.internal.ac) void
    void method_1033(SetDrivePreferencesRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.SetResourceParentsRequest, com.google.android.gms.drive.internal.ac) void
    void method_1034(SetResourceParentsRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.TrashResourceRequest, com.google.android.gms.drive.internal.ac) void
    void method_1035(TrashResourceRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.UpdateMetadataRequest, com.google.android.gms.drive.internal.ac) void
    void method_1036(UpdateMetadataRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.internal.ac) void
    void method_1037(class_198 var1) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.ac) void
    void method_1038(QueryRequest var1, class_198 var2) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.drive.internal.ac) void
    void method_1039(class_198 var1) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.drive.internal.ac) void
    void method_1040(class_198 var1) throws RemoteException;

    // $FF: renamed from: d (com.google.android.gms.drive.internal.ac) void
    void method_1041(class_198 var1) throws RemoteException;

    // $FF: renamed from: e (com.google.android.gms.drive.internal.ac) void
    void method_1042(class_198 var1) throws RemoteException;

    // $FF: renamed from: f (com.google.android.gms.drive.internal.ac) void
    void method_1043(class_198 var1) throws RemoteException;

    // $FF: renamed from: g (com.google.android.gms.drive.internal.ac) void
    void method_1044(class_198 var1) throws RemoteException;

    public abstract static class class_1152 extends Binder implements class_199 {
        // $FF: renamed from: U (android.os.IBinder) com.google.android.gms.drive.internal.ab
        public static class_199 method_1617(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
                return (class_199)(var1 != null && var1 instanceof class_199?(class_199)var1:new class_199.class_1153(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var55 = var2.readInt();
                    GetMetadataRequest var56 = null;
                    if(var55 != 0) {
                        var56 = (GetMetadataRequest)GetMetadataRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var56, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var53 = var2.readInt();
                    QueryRequest var54 = null;
                    if(var53 != 0) {
                        var54 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var54, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var51 = var2.readInt();
                    UpdateMetadataRequest var52 = null;
                    if(var51 != 0) {
                        var52 = (UpdateMetadataRequest)UpdateMetadataRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var52, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var49 = var2.readInt();
                    CreateContentsRequest var50 = null;
                    if(var49 != 0) {
                        var50 = (CreateContentsRequest)CreateContentsRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var50, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var47 = var2.readInt();
                    CreateFileRequest var48 = null;
                    if(var47 != 0) {
                        var48 = (CreateFileRequest)CreateFileRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var48, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var45 = var2.readInt();
                    CreateFolderRequest var46 = null;
                    if(var45 != 0) {
                        var46 = (CreateFolderRequest)CreateFolderRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var46, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var43 = var2.readInt();
                    OpenContentsRequest var44 = null;
                    if(var43 != 0) {
                        var44 = (OpenContentsRequest)OpenContentsRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var44, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var41 = var2.readInt();
                    CloseContentsRequest var42 = null;
                    if(var41 != 0) {
                        var42 = (CloseContentsRequest)CloseContentsRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var42, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 9:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    this.a(class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 10:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var38 = var2.readInt();
                    OpenFileIntentSenderRequest var39 = null;
                    if(var38 != 0) {
                        var39 = (OpenFileIntentSenderRequest)OpenFileIntentSenderRequest.CREATOR.createFromParcel(var2);
                    }

                    IntentSender var40 = this.a(var39);
                    var3.writeNoException();
                    if(var40 != null) {
                        var3.writeInt(1);
                        var40.writeToParcel(var3, 1);
                    } else {
                        var3.writeInt(0);
                    }

                    return true;
                case 11:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var35 = var2.readInt();
                    CreateFileIntentSenderRequest var36 = null;
                    if(var35 != 0) {
                        var36 = (CreateFileIntentSenderRequest)CreateFileIntentSenderRequest.CREATOR.createFromParcel(var2);
                    }

                    IntentSender var37 = this.a(var36);
                    var3.writeNoException();
                    if(var37 != null) {
                        var3.writeInt(1);
                        var37.writeToParcel(var3, 1);
                    } else {
                        var3.writeInt(0);
                    }

                    return true;
                case 12:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var33 = var2.readInt();
                    AuthorizeAccessRequest var34 = null;
                    if(var33 != 0) {
                        var34 = (AuthorizeAccessRequest)AuthorizeAccessRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var34, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 13:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var31 = var2.readInt();
                    ListParentsRequest var32 = null;
                    if(var31 != 0) {
                        var32 = (ListParentsRequest)ListParentsRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var32, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 14:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var29 = var2.readInt();
                    AddEventListenerRequest var30 = null;
                    if(var29 != 0) {
                        var30 = (AddEventListenerRequest)AddEventListenerRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var30, class_197.class_1305.method_1731(var2.readStrongBinder()), var2.readString(), class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 15:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var27 = var2.readInt();
                    RemoveEventListenerRequest var28 = null;
                    if(var27 != 0) {
                        var28 = (RemoveEventListenerRequest)RemoveEventListenerRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var28, class_197.class_1305.method_1731(var2.readStrongBinder()), var2.readString(), class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 16:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var25 = var2.readInt();
                    DisconnectRequest var26 = null;
                    if(var25 != 0) {
                        var26 = (DisconnectRequest)DisconnectRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var26);
                    var3.writeNoException();
                    return true;
                case 17:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var23 = var2.readInt();
                    TrashResourceRequest var24 = null;
                    if(var23 != 0) {
                        var24 = (TrashResourceRequest)TrashResourceRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var24, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 18:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var21 = var2.readInt();
                    CloseContentsAndUpdateMetadataRequest var22 = null;
                    if(var21 != 0) {
                        var22 = (CloseContentsAndUpdateMetadataRequest)CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var22, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 19:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var19 = var2.readInt();
                    QueryRequest var20 = null;
                    if(var19 != 0) {
                        var20 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(var2);
                    }

                    this.b(var20, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 20:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    this.b(class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 21:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    this.c(class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 22:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    this.d(class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 23:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    this.e(class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 24:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var17 = var2.readInt();
                    DeleteResourceRequest var18 = null;
                    if(var17 != 0) {
                        var18 = (DeleteResourceRequest)DeleteResourceRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var18, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 27:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var15 = var2.readInt();
                    LoadRealtimeRequest var16 = null;
                    if(var15 != 0) {
                        var16 = (LoadRealtimeRequest)LoadRealtimeRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var16, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 28:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var13 = var2.readInt();
                    SetResourceParentsRequest var14 = null;
                    if(var13 != 0) {
                        var14 = (SetResourceParentsRequest)SetResourceParentsRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var14, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 29:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var11 = var2.readInt();
                    GetDriveIdFromUniqueIdentifierRequest var12 = null;
                    if(var11 != 0) {
                        var12 = (GetDriveIdFromUniqueIdentifierRequest)GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var12, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 30:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var9 = var2.readInt();
                    CheckResourceIdsExistRequest var10 = null;
                    if(var9 != 0) {
                        var10 = (CheckResourceIdsExistRequest)CheckResourceIdsExistRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var10, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 31:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    this.f(class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 32:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    this.g(class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 33:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var7 = var2.readInt();
                    SetDrivePreferencesRequest var8 = null;
                    if(var7 != 0) {
                        var8 = (SetDrivePreferencesRequest)SetDrivePreferencesRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var8, class_198.class_1301.method_1734(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 34:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    int var5 = var2.readInt();
                    RealtimeDocumentSyncRequest var6 = null;
                    if(var5 != 0) {
                        var6 = (RealtimeDocumentSyncRequest)RealtimeDocumentSyncRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var6, class_198.class_1301.method_1734(var2.readStrongBinder()));
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

    private static class class_1153 implements class_199 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4449;

        class_1153(IBinder var1) {
            this.field_4449 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileIntentSenderRequest) android.content.IntentSender
        public IntentSender method_1013(CreateFileIntentSenderRequest param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.OpenFileIntentSenderRequest) android.content.IntentSender
        public IntentSender method_1014(OpenFileIntentSenderRequest param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.RealtimeDocumentSyncRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1015(RealtimeDocumentSyncRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.AddEventListenerRequest, com.google.android.gms.drive.internal.ad, java.lang.String, com.google.android.gms.drive.internal.ac) void
        public void method_1016(AddEventListenerRequest param1, class_197 param2, String param3, class_198 param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.AuthorizeAccessRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1017(AuthorizeAccessRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.CheckResourceIdsExistRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1018(CheckResourceIdsExistRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1019(CloseContentsAndUpdateMetadataRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1020(CloseContentsRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateContentsRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1021(CreateContentsRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1022(CreateFileRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFolderRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1023(CreateFolderRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.DeleteResourceRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1024(DeleteResourceRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.DisconnectRequest) void
        public void method_1025(DisconnectRequest param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1026(GetDriveIdFromUniqueIdentifierRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.GetMetadataRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1027(GetMetadataRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.ListParentsRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1028(ListParentsRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.LoadRealtimeRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1029(LoadRealtimeRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.OpenContentsRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1030(OpenContentsRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1031(QueryRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.RemoveEventListenerRequest, com.google.android.gms.drive.internal.ad, java.lang.String, com.google.android.gms.drive.internal.ac) void
        public void method_1032(RemoveEventListenerRequest param1, class_197 param2, String param3, class_198 param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.SetDrivePreferencesRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1033(SetDrivePreferencesRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.SetResourceParentsRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1034(SetResourceParentsRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.TrashResourceRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1035(TrashResourceRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.UpdateMetadataRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1036(UpdateMetadataRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.ac) void
        public void method_1037(class_198 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_4449;
        }

        // $FF: renamed from: b (com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.ac) void
        public void method_1038(QueryRequest param1, class_198 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.drive.internal.ac) void
        public void method_1039(class_198 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.drive.internal.ac) void
        public void method_1040(class_198 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: d (com.google.android.gms.drive.internal.ac) void
        public void method_1041(class_198 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: e (com.google.android.gms.drive.internal.ac) void
        public void method_1042(class_198 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: f (com.google.android.gms.drive.internal.ac) void
        public void method_1043(class_198 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: g (com.google.android.gms.drive.internal.ac) void
        public void method_1044(class_198 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
