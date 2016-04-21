package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.class_1123;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.OnContentsResponse;
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;
import com.google.android.gms.drive.internal.OpenContentsRequest;
import com.google.android.gms.drive.internal.class_263;
import com.google.android.gms.drive.internal.class_276;
import com.google.android.gms.drive.internal.class_278;
import com.google.android.gms.drive.internal.class_290;
import com.google.android.gms.drive.internal.class_305;
import com.google.android.gms.drive.internal.class_306;

// $FF: renamed from: com.google.android.gms.drive.internal.s
public class class_265 extends class_263 implements DriveFile {
    public class_265(DriveId var1) {
        super(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.DriveFile$DownloadProgressListener) com.google.android.gms.drive.DriveFile$DownloadProgressListener
    private static DriveFile.DownloadProgressListener method_1682(GoogleApiClient var0, DriveFile.DownloadProgressListener var1) {
        return var1 == null?null:new class_265.class_1164(var0.method_900(var1));
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient var1, Contents var2) {
        return (new class_306(var2)).commit(var1, (MetadataChangeSet)null);
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient var1, Contents var2, MetadataChangeSet var3) {
        return (new class_306(var2)).commit(var1, var3);
    }

    public PendingResult<Status> discardContents(GoogleApiClient var1, Contents var2) {
        return Drive.DriveApi.discardContents(var1, var2);
    }

    public PendingResult<DriveApi.DriveContentsResult> open(GoogleApiClient var1, final int var2, DriveFile.DownloadProgressListener var3) {
        if(var2 != 268435456 && var2 != 536870912 && var2 != 805306368) {
            throw new IllegalArgumentException("Invalid mode provided.");
        } else {
            return var1.method_897(new class_290.class_1722() {
                // $FF: renamed from: OO com.google.android.gms.drive.DriveFile$DownloadProgressListener
                // $FF: synthetic field
                final DriveFile.DownloadProgressListener field_203;

                {
                    this.field_203 = var3;
                }

                // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
                protected void method_1293(class_305 var1) throws RemoteException {
                    var1.method_2091().method_1030(new OpenContentsRequest(class_265.this.getDriveId(), var2, 0), new class_278(this, this.field_203));
                }
            });
        }
    }

    public PendingResult<DriveApi.ContentsResult> openContents(GoogleApiClient var1, final int var2, DriveFile.DownloadProgressListener var3) {
        if(var2 != 268435456 && var2 != 536870912 && var2 != 805306368) {
            throw new IllegalArgumentException("Invalid mode provided.");
        } else {
            return var1.method_897(new class_290.class_1720() {
                // $FF: renamed from: OO com.google.android.gms.drive.DriveFile$DownloadProgressListener
                // $FF: synthetic field
                final DriveFile.DownloadProgressListener field_198;

                {
                    this.field_198 = var3;
                }

                // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
                protected void method_1290(class_305 var1) throws RemoteException {
                    var1.method_2091().method_1030(new OpenContentsRequest(class_265.this.getDriveId(), var2, 0), new class_265.class_1711(this, this.field_198));
                }
            });
        }
    }

    private static class class_1164 implements DriveFile.DownloadProgressListener {
        // $FF: renamed from: OQ com.google.android.gms.common.api.c
        private final c<DriveFile.DownloadProgressListener> field_4794;

        public class_1164(c<DriveFile.DownloadProgressListener> var1) {
            this.field_4794 = var1;
        }

        public void onProgress(final long var1, final long var3) {
            this.field_4794.method_5817(new class_1123.class_1385() {
                // $FF: renamed from: a (com.google.android.gms.drive.DriveFile$DownloadProgressListener) void
                public void method_1645(DriveFile.DownloadProgressListener var1x) {
                    var1x.onProgress(var1, var3);
                }

                // $FF: renamed from: d (java.lang.Object) void
                // $FF: synthetic method
                public void method_324(Object var1x) {
                    this.method_1645((DriveFile.DownloadProgressListener)var1x);
                }

                // $FF: renamed from: gr () void
                public void method_325() {
                }
            });
        }
    }

    private static class class_1711 extends class_276 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<DriveApi.ContentsResult> field_839;
        // $FF: renamed from: OU com.google.android.gms.drive.DriveFile$DownloadProgressListener
        private final DriveFile.DownloadProgressListener field_840;

        public class_1711(BaseImplementation.class_1147<DriveApi.ContentsResult> var1, DriveFile.DownloadProgressListener var2) {
            this.field_839 = var1;
            this.field_840 = var2;
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.OnContentsResponse) void
        public void method_1001(OnContentsResponse var1) throws RemoteException {
            Status var2;
            if(var1.method_5716()) {
                var2 = new Status(-1);
            } else {
                var2 = Status.field_4739;
            }

            this.field_839.method_120(new class_290.class_1719(var2, var1.method_5715()));
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDownloadProgressResponse) void
        public void method_1002(OnDownloadProgressResponse var1) throws RemoteException {
            if(this.field_840 != null) {
                this.field_840.onProgress(var1.method_4001(), var1.method_4002());
            }

        }

        // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
        public void method_1012(Status var1) throws RemoteException {
            this.field_839.method_120(new class_290.class_1719(var1, (Contents)null));
        }
    }
}
