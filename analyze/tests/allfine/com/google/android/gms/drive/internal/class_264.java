package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.internal.CreateFolderRequest;
import com.google.android.gms.drive.internal.OnDriveIdResponse;
import com.google.android.gms.drive.internal.class_263;
import com.google.android.gms.drive.internal.class_265;
import com.google.android.gms.drive.internal.class_276;
import com.google.android.gms.drive.internal.class_290;
import com.google.android.gms.drive.internal.class_305;
import com.google.android.gms.drive.internal.class_306;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;

// $FF: renamed from: com.google.android.gms.drive.internal.u
public class class_264 extends class_263 implements DriveFolder {
    public class_264(DriveId var1) {
        super(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.MetadataChangeSet, com.google.android.gms.drive.Contents, int, com.google.android.gms.drive.ExecutionOptions) com.google.android.gms.common.api.PendingResult
    private PendingResult<DriveFolder.DriveFileResult> method_1680(GoogleApiClient var1, final MetadataChangeSet var2, final Contents var3, final int var4, final ExecutionOptions var5) {
        ExecutionOptions.method_4481(var1, var5);
        if(var3 != null) {
            var3.method_4245();
        }

        return var1.method_899(new class_264.class_1691() {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
            protected void method_1298(class_305 var1) throws RemoteException {
                var2.method_2945().setContext(var1.getContext());
                int var2x;
                if(var3 == null) {
                    var2x = 0;
                } else {
                    var2x = var3.getRequestId();
                }

                CreateFileRequest var3x = new CreateFileRequest(class_264.this.getDriveId(), var2.method_2945(), var2x, var4, var5);
                var1.method_2091().method_1022(var3x, new class_264.class_1690(this));
            }
        });
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.MetadataChangeSet, com.google.android.gms.drive.DriveContents, com.google.android.gms.drive.ExecutionOptions) com.google.android.gms.common.api.PendingResult
    private PendingResult<DriveFolder.DriveFileResult> method_1681(GoogleApiClient var1, MetadataChangeSet var2, DriveContents var3, ExecutionOptions var4) {
        if(var3 == null) {
            throw new IllegalArgumentException("DriveContents must be provided.");
        } else if(!(var3 instanceof class_306)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if(var3.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if(var3.getContents().method_4246()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else if(var2 == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if("application/vnd.google-apps.folder".equals(var2.getMimeType())) {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        } else {
            return this.method_1680(var1, var2, var3.getContents(), 0, var4);
        }
    }

    public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient var1, MetadataChangeSet var2, Contents var3) {
        return this.createFile(var1, var2, (DriveContents)(new class_306(var3)));
    }

    public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient var1, MetadataChangeSet var2, DriveContents var3) {
        return this.createFile(var1, var2, var3, (ExecutionOptions)null);
    }

    public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient var1, MetadataChangeSet var2, DriveContents var3, ExecutionOptions var4) {
        if(var4 == null) {
            var4 = (new ExecutionOptions.Builder()).build();
        }

        if(var4.method_4487() != 0) {
            throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
        } else {
            return this.method_1681(var1, var2, var3, var4);
        }
    }

    public PendingResult<DriveFolder.DriveFolderResult> createFolder(GoogleApiClient var1, final MetadataChangeSet var2) {
        if(var2 == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if(var2.getMimeType() != null && !var2.getMimeType().equals("application/vnd.google-apps.folder")) {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        } else {
            return var1.method_899(new class_264.class_1695() {
                // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
                protected void method_1296(class_305 var1) throws RemoteException {
                    var2.method_2945().setContext(var1.getContext());
                    var1.method_2091().method_1023(new CreateFolderRequest(class_264.this.getDriveId(), var2.method_2945()), new class_264.class_1693(this));
                }
            });
        }
    }

    public PendingResult<DriveApi.MetadataBufferResult> listChildren(GoogleApiClient var1) {
        return this.queryChildren(var1, (Query)null);
    }

    public PendingResult<DriveApi.MetadataBufferResult> queryChildren(GoogleApiClient var1, Query var2) {
        Query.Builder var3 = (new Query.Builder()).addFilter(Filters.method_3699(SearchableField.PARENTS, this.getDriveId()));
        if(var2 != null) {
            if(var2.getFilter() != null) {
                var3.addFilter(var2.getFilter());
            }

            var3.setPageToken(var2.getPageToken());
            var3.setSortOrder(var2.getSortOrder());
        }

        return (new class_290()).query(var1, var3.build());
    }

    private static class class_1690 extends class_276 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<DriveFolder.DriveFileResult> field_842;

        public class_1690(BaseImplementation.class_1147<DriveFolder.DriveFileResult> var1) {
            this.field_842 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDriveIdResponse) void
        public void method_1003(OnDriveIdResponse var1) throws RemoteException {
            this.field_842.method_120(new class_264.class_1694(Status.field_4739, new class_265(var1.getDriveId())));
        }

        // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
        public void method_1012(Status var1) throws RemoteException {
            this.field_842.method_120(new class_264.class_1694(var1, (DriveFile)null));
        }
    }

    private static class class_1693 extends class_276 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<DriveFolder.DriveFolderResult> field_841;

        public class_1693(BaseImplementation.class_1147<DriveFolder.DriveFolderResult> var1) {
            this.field_841 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDriveIdResponse) void
        public void method_1003(OnDriveIdResponse var1) throws RemoteException {
            this.field_841.method_120(new class_264.class_1692(Status.field_4739, new class_264(var1.getDriveId())));
        }

        // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
        public void method_1012(Status var1) throws RemoteException {
            this.field_841.method_120(new class_264.class_1692(var1, (DriveFolder)null));
        }
    }

    private static class class_1694 implements DriveFolder.DriveFileResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_4117;
        // $FF: renamed from: OY com.google.android.gms.drive.DriveFile
        private final DriveFile field_4118;

        public class_1694(Status var1, DriveFile var2) {
            this.field_4117 = var1;
            this.field_4118 = var2;
        }

        public DriveFile getDriveFile() {
            return this.field_4118;
        }

        public Status getStatus() {
            return this.field_4117;
        }
    }

    abstract static class class_1691 extends p<DriveFolder.DriveFileResult> {
        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1297(var1);
        }

        // $FF: renamed from: t (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveFolder$DriveFileResult
        public DriveFolder.DriveFileResult method_1297(Status var1) {
            return new class_264.class_1694(var1, (DriveFile)null);
        }
    }

    private static class class_1692 implements DriveFolder.DriveFolderResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_4115;
        // $FF: renamed from: OZ com.google.android.gms.drive.DriveFolder
        private final DriveFolder field_4116;

        public class_1692(Status var1, DriveFolder var2) {
            this.field_4115 = var1;
            this.field_4116 = var2;
        }

        public DriveFolder getDriveFolder() {
            return this.field_4116;
        }

        public Status getStatus() {
            return this.field_4115;
        }
    }

    abstract static class class_1695 extends p<DriveFolder.DriveFolderResult> {
        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1295(var1);
        }

        // $FF: renamed from: u (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveFolder$DriveFolderResult
        public DriveFolder.DriveFolderResult method_1295(Status var1) {
            return new class_264.class_1692(var1, (DriveFolder)null);
        }
    }
}
