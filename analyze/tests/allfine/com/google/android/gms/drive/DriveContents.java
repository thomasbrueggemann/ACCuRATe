package com.google.android.gms.drive;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import java.io.InputStream;
import java.io.OutputStream;

public interface DriveContents {
    PendingResult<Status> commit(GoogleApiClient var1, MetadataChangeSet var2);

    PendingResult<Status> commit(GoogleApiClient var1, MetadataChangeSet var2, ExecutionOptions var3);

    void discard(GoogleApiClient var1);

    Contents getContents();

    DriveId getDriveId();

    InputStream getInputStream();

    int getMode();

    OutputStream getOutputStream();

    ParcelFileDescriptor getParcelFileDescriptor();

    PendingResult<DriveApi.DriveContentsResult> reopenForWrite(GoogleApiClient var1);
}
