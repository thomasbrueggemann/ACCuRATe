package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.internal.OnContentsResponse;
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;
import com.google.android.gms.drive.internal.class_276;
import com.google.android.gms.drive.internal.class_290;
import com.google.android.gms.drive.internal.class_306;

// $FF: renamed from: com.google.android.gms.drive.internal.av
class class_278 extends class_276 {
    // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
    private final BaseImplementation.class_1147<DriveApi.DriveContentsResult> field_833;
    // $FF: renamed from: OU com.google.android.gms.drive.DriveFile$DownloadProgressListener
    private final DriveFile.DownloadProgressListener field_834;

    class_278(BaseImplementation.class_1147<DriveApi.DriveContentsResult> var1, DriveFile.DownloadProgressListener var2) {
        this.field_833 = var1;
        this.field_834 = var2;
    }

    // $FF: renamed from: a (com.google.android.gms.drive.internal.OnContentsResponse) void
    public void method_1001(OnContentsResponse var1) throws RemoteException {
        Status var2;
        if(var1.method_5716()) {
            var2 = new Status(-1);
        } else {
            var2 = Status.field_4739;
        }

        this.field_833.method_120(new class_290.class_1721(var2, new class_306(var1.method_5715())));
    }

    // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDownloadProgressResponse) void
    public void method_1002(OnDownloadProgressResponse var1) throws RemoteException {
        if(this.field_834 != null) {
            this.field_834.onProgress(var1.method_4001(), var1.method_4002());
        }

    }

    // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
    public void method_1012(Status var1) throws RemoteException {
        this.field_833.method_120(new class_290.class_1721(var1, (DriveContents)null));
    }
}
