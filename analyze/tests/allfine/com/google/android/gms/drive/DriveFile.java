package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.MetadataChangeSet;

public interface DriveFile extends DriveResource {
    int MODE_READ_ONLY = 268435456;
    int MODE_READ_WRITE = 805306368;
    int MODE_WRITE_ONLY = 536870912;

    @Deprecated
    PendingResult<Status> commitAndCloseContents(GoogleApiClient var1, Contents var2);

    @Deprecated
    PendingResult<Status> commitAndCloseContents(GoogleApiClient var1, Contents var2, MetadataChangeSet var3);

    @Deprecated
    PendingResult<Status> discardContents(GoogleApiClient var1, Contents var2);

    PendingResult<DriveApi.DriveContentsResult> open(GoogleApiClient var1, int var2, DriveFile.DownloadProgressListener var3);

    @Deprecated
    PendingResult<DriveApi.ContentsResult> openContents(GoogleApiClient var1, int var2, DriveFile.DownloadProgressListener var3);

    public interface DownloadProgressListener {
        void onProgress(long var1, long var3);
    }
}
