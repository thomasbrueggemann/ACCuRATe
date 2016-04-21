package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest;
import com.google.android.gms.drive.internal.CloseContentsRequest;
import com.google.android.gms.drive.internal.OpenContentsRequest;
import com.google.android.gms.drive.internal.class_211;
import com.google.android.gms.drive.internal.class_266;
import com.google.android.gms.drive.internal.class_277;
import com.google.android.gms.drive.internal.class_278;
import com.google.android.gms.drive.internal.class_290;
import com.google.android.gms.drive.internal.class_305;
import java.io.InputStream;
import java.io.OutputStream;

// $FF: renamed from: com.google.android.gms.drive.internal.r
public class class_306 implements DriveContents {
    // $FF: renamed from: Ox com.google.android.gms.drive.Contents
    private final Contents field_946;

    public class_306(Contents var1) {
        this.field_946 = (Contents)class_1090.method_5685(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.MetadataChangeSet, com.google.android.gms.drive.ExecutionOptions) com.google.android.gms.common.api.PendingResult
    private PendingResult<Status> method_2095(GoogleApiClient var1, final MetadataChangeSet var2, final ExecutionOptions var3) {
        if(this.field_946.getMode() == 268435456) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        } else if(ExecutionOptions.method_4482(var3.method_4487()) && !this.field_946.method_4247()) {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        } else {
            ExecutionOptions.method_4481(var1, var3);
            if(this.field_946.method_4246()) {
                throw new IllegalStateException("DriveContents already closed.");
            } else if(this.getDriveId() == null) {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            } else {
                if(var2 == null) {
                    var2 = MetadataChangeSet.field_1908;
                }

                this.field_946.method_4245();
                return var1.method_899(new class_211.class_1699() {
                    // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
                    protected void method_1307(class_305 var1) throws RemoteException {
                        var2.method_2945().setContext(var1.getContext());
                        var1.method_2091().method_1019(new CloseContentsAndUpdateMetadataRequest(class_306.this.field_946.getDriveId(), var2.method_2945(), class_306.this.field_946, var3), new class_277(this));
                    }
                });
            }
        }
    }

    public PendingResult<Status> commit(GoogleApiClient var1, MetadataChangeSet var2) {
        return this.method_2095(var1, var2, (new ExecutionOptions.Builder()).build());
    }

    public PendingResult<Status> commit(GoogleApiClient var1, MetadataChangeSet var2, ExecutionOptions var3) {
        return this.method_2095(var1, var2, var3);
    }

    public void discard(GoogleApiClient var1) {
        if(this.field_946.method_4246()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else {
            this.field_946.method_4245();
            ((<undefinedtype>)var1.method_899(new class_211.class_1699() {
                // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
                protected void method_1308(class_305 var1) throws RemoteException {
                    var1.method_2091().method_1020(new CloseContentsRequest(class_306.this.field_946, false), new class_277(this));
                }
            })).setResultCallback(new ResultCallback() {
                // $FF: renamed from: k (com.google.android.gms.common.api.Status) void
                public void method_5205(Status var1) {
                    if(!var1.isSuccess()) {
                        class_266.method_1687("DriveContentsImpl", "Error discarding contents");
                    } else {
                        class_266.method_1685("DriveContentsImpl", "Contents discarded");
                    }
                }

                // $FF: synthetic method
                public void onResult(Result var1) {
                    this.method_5205((Status)var1);
                }
            });
        }
    }

    public Contents getContents() {
        return this.field_946;
    }

    public DriveId getDriveId() {
        return this.field_946.getDriveId();
    }

    public InputStream getInputStream() {
        return this.field_946.getInputStream();
    }

    public int getMode() {
        return this.field_946.getMode();
    }

    public OutputStream getOutputStream() {
        return this.field_946.getOutputStream();
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.field_946.getParcelFileDescriptor();
    }

    public PendingResult<DriveApi.DriveContentsResult> reopenForWrite(GoogleApiClient var1) {
        if(this.field_946.method_4246()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else if(this.field_946.getMode() != 268435456) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        } else {
            this.field_946.method_4245();
            return var1.method_897(new class_290.class_1722() {
                // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
                protected void method_1294(class_305 var1) throws RemoteException {
                    var1.method_2091().method_1030(new OpenContentsRequest(class_306.this.getDriveId(), 536870912, class_306.this.field_946.getRequestId()), new class_278(this, (DriveFile.DownloadProgressListener)null));
                }
            });
        }
    }
}
