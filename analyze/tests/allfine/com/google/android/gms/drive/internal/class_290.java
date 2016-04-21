package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.internal.CloseContentsRequest;
import com.google.android.gms.drive.internal.CreateContentsRequest;
import com.google.android.gms.drive.internal.GetMetadataRequest;
import com.google.android.gms.drive.internal.OnContentsResponse;
import com.google.android.gms.drive.internal.OnDriveIdResponse;
import com.google.android.gms.drive.internal.OnListEntriesResponse;
import com.google.android.gms.drive.internal.OnMetadataResponse;
import com.google.android.gms.drive.internal.QueryRequest;
import com.google.android.gms.drive.internal.class_211;
import com.google.android.gms.drive.internal.class_264;
import com.google.android.gms.drive.internal.class_265;
import com.google.android.gms.drive.internal.class_276;
import com.google.android.gms.drive.internal.class_277;
import com.google.android.gms.drive.internal.class_287;
import com.google.android.gms.drive.internal.class_305;
import com.google.android.gms.drive.internal.class_306;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.query.Query;

// $FF: renamed from: com.google.android.gms.drive.internal.o
public class class_290 implements DriveApi {
    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, int) com.google.android.gms.common.api.PendingResult
    public PendingResult<DriveApi.DriveContentsResult> method_1793(GoogleApiClient var1, final int var2) {
        return var1.method_897(new class_290.class_1722() {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
            protected void method_1292(class_305 var1) throws RemoteException {
                var1.method_2091().method_1021(new CreateContentsRequest(var2), new class_290.class_1729(this));
            }
        });
    }

    public PendingResult<Status> discardContents(GoogleApiClient var1, final Contents var2) {
        if(var2.method_4246()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else {
            var2.method_4245();
            return var1.method_899(new class_211.class_1699() {
                // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
                protected void method_1306(class_305 var1) throws RemoteException {
                    var1.method_2091().method_1020(new CloseContentsRequest(var2, false), new class_277(this));
                }
            });
        }
    }

    public PendingResult<DriveApi.DriveIdResult> fetchDriveId(GoogleApiClient var1, final String var2) {
        return var1.method_897(new class_290.class_1725() {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
            protected void method_1287(class_305 var1) throws RemoteException {
                var1.method_2091().method_1027(new GetMetadataRequest(DriveId.method_3177(var2)), new class_290.class_1723(this));
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient var1) {
        if(!var1.isConnected()) {
            throw new IllegalStateException("Client must be connected");
        } else {
            DriveId var2 = ((class_305)var1.method_896(Drive.field_3554)).method_2093();
            return var2 != null?new class_264(var2):null;
        }
    }

    public DriveFile getFile(GoogleApiClient var1, DriveId var2) {
        if(var2 == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if(!var1.isConnected()) {
            throw new IllegalStateException("Client must be connected");
        } else {
            return new class_265(var2);
        }
    }

    public DriveFolder getFolder(GoogleApiClient var1, DriveId var2) {
        if(var2 == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if(!var1.isConnected()) {
            throw new IllegalStateException("Client must be connected");
        } else {
            return new class_264(var2);
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient var1) {
        if(!var1.isConnected()) {
            throw new IllegalStateException("Client must be connected");
        } else {
            return new class_264(((class_305)var1.method_896(Drive.field_3554)).method_2092());
        }
    }

    public PendingResult<DriveApi.ContentsResult> newContents(GoogleApiClient var1) {
        return var1.method_897(new class_290.class_1720() {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
            protected void method_1289(class_305 var1) throws RemoteException {
                var1.method_2091().method_1021(new CreateContentsRequest(536870912), new class_290.class_1728(this));
            }
        });
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public PendingResult<DriveApi.DriveContentsResult> newDriveContents(GoogleApiClient var1) {
        return this.method_1793(var1, 536870912);
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<DriveApi.MetadataBufferResult> query(GoogleApiClient var1, final Query var2) {
        if(var2 == null) {
            throw new IllegalArgumentException("Query must be provided.");
        } else {
            return var1.method_897(new class_290.class_1727() {
                // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
                protected void method_1311(class_305 var1) throws RemoteException {
                    var1.method_2091().method_1031(new QueryRequest(var2), new class_290.class_1730(this));
                }
            });
        }
    }

    public PendingResult<Status> requestSync(GoogleApiClient var1) {
        return var1.method_899(new class_211.class_1699() {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
            protected void method_1305(class_305 var1) throws RemoteException {
                var1.method_2091().method_1037(new class_277(this));
            }
        });
    }

    static class class_1719 implements DriveApi.ContentsResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_4988;
        // $FF: renamed from: Ox com.google.android.gms.drive.Contents
        private final Contents field_4989;

        public class_1719(Status var1, Contents var2) {
            this.field_4988 = var1;
            this.field_4989 = var2;
        }

        public Contents getContents() {
            return this.field_4989;
        }

        public Status getStatus() {
            return this.field_4988;
        }
    }

    abstract static class class_1720 extends p<DriveApi.ContentsResult> {
        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1288(var1);
        }

        // $FF: renamed from: p (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveApi$ContentsResult
        public DriveApi.ContentsResult method_1288(Status var1) {
            return new class_290.class_1719(var1, (Contents)null);
        }
    }

    static class class_1721 implements DriveApi.DriveContentsResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_4990;
        // $FF: renamed from: Nb com.google.android.gms.drive.DriveContents
        private final DriveContents field_4991;

        public class_1721(Status var1, DriveContents var2) {
            this.field_4990 = var1;
            this.field_4991 = var2;
        }

        public DriveContents getDriveContents() {
            return this.field_4991;
        }

        public Status getStatus() {
            return this.field_4990;
        }
    }

    abstract static class class_1722 extends p<DriveApi.DriveContentsResult> {
        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1291(var1);
        }

        // $FF: renamed from: q (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveApi$DriveContentsResult
        public DriveApi.DriveContentsResult method_1291(Status var1) {
            return new class_290.class_1721(var1, (DriveContents)null);
        }
    }

    static class class_1723 extends class_276 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<DriveApi.DriveIdResult> field_835;

        public class_1723(BaseImplementation.class_1147<DriveApi.DriveIdResult> var1) {
            this.field_835 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDriveIdResponse) void
        public void method_1003(OnDriveIdResponse var1) throws RemoteException {
            this.field_835.method_120(new class_290.class_1724(Status.field_4739, var1.getDriveId()));
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.OnMetadataResponse) void
        public void method_1008(OnMetadataResponse var1) throws RemoteException {
            this.field_835.method_120(new class_290.class_1724(Status.field_4739, (new class_287(var1.method_6021())).getDriveId()));
        }

        // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
        public void method_1012(Status var1) throws RemoteException {
            this.field_835.method_120(new class_290.class_1724(var1, (DriveId)null));
        }
    }

    private static class class_1724 implements DriveApi.DriveIdResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_4986;
        // $FF: renamed from: MW com.google.android.gms.drive.DriveId
        private final DriveId field_4987;

        public class_1724(Status var1, DriveId var2) {
            this.field_4986 = var1;
            this.field_4987 = var2;
        }

        public DriveId getDriveId() {
            return this.field_4987;
        }

        public Status getStatus() {
            return this.field_4986;
        }
    }

    abstract static class class_1725 extends p<DriveApi.DriveIdResult> {
        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1286(var1);
        }

        // $FF: renamed from: r (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveApi$DriveIdResult
        public DriveApi.DriveIdResult method_1286(Status var1) {
            return new class_290.class_1724(var1, (DriveId)null);
        }
    }

    static class class_1726 implements DriveApi.MetadataBufferResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_4982;
        // $FF: renamed from: Oy com.google.android.gms.drive.MetadataBuffer
        private final MetadataBuffer field_4983;
        // $FF: renamed from: Oz boolean
        private final boolean field_4984;

        public class_1726(Status var1, MetadataBuffer var2, boolean var3) {
            this.field_4982 = var1;
            this.field_4983 = var2;
            this.field_4984 = var3;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.field_4983;
        }

        public Status getStatus() {
            return this.field_4982;
        }
    }

    abstract static class class_1727 extends p<DriveApi.MetadataBufferResult> {
        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1310(var1);
        }

        // $FF: renamed from: s (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveApi$MetadataBufferResult
        public DriveApi.MetadataBufferResult method_1310(Status var1) {
            return new class_290.class_1726(var1, (MetadataBuffer)null, false);
        }
    }

    private static class class_1728 extends class_276 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<DriveApi.ContentsResult> field_837;

        public class_1728(BaseImplementation.class_1147<DriveApi.ContentsResult> var1) {
            this.field_837 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.OnContentsResponse) void
        public void method_1001(OnContentsResponse var1) throws RemoteException {
            this.field_837.method_120(new class_290.class_1719(Status.field_4739, var1.method_5715()));
        }

        // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
        public void method_1012(Status var1) throws RemoteException {
            this.field_837.method_120(new class_290.class_1719(var1, (Contents)null));
        }
    }

    private static class class_1729 extends class_276 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<DriveApi.DriveContentsResult> field_836;

        public class_1729(BaseImplementation.class_1147<DriveApi.DriveContentsResult> var1) {
            this.field_836 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.OnContentsResponse) void
        public void method_1001(OnContentsResponse var1) throws RemoteException {
            this.field_836.method_120(new class_290.class_1721(Status.field_4739, new class_306(var1.method_5715())));
        }

        // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
        public void method_1012(Status var1) throws RemoteException {
            this.field_836.method_120(new class_290.class_1721(var1, (DriveContents)null));
        }
    }

    private static class class_1730 extends class_276 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<DriveApi.MetadataBufferResult> field_838;

        public class_1730(BaseImplementation.class_1147<DriveApi.MetadataBufferResult> var1) {
            this.field_838 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.OnListEntriesResponse) void
        public void method_1005(OnListEntriesResponse var1) throws RemoteException {
            MetadataBuffer var2 = new MetadataBuffer(var1.method_2999(), (String)null);
            this.field_838.method_120(new class_290.class_1726(Status.field_4739, var2, var1.method_3000()));
        }

        // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
        public void method_1012(Status var1) throws RemoteException {
            this.field_838.method_120(new class_290.class_1726(var1, (MetadataBuffer)null, false));
        }
    }

    static class class_1731 extends class_211.class_1699 {
        class_1731(GoogleApiClient var1, Status var2) {
            this.a(new BaseImplementation.CallbackHandler(((class_305)var1.method_896(Drive.field_3554)).getLooper()));
            this.b(var2);
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
        protected void method_1304(class_305 var1) {
        }
    }
}
