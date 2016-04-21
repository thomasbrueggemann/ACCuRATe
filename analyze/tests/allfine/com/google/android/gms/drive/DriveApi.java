package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;

public interface DriveApi {
    @Deprecated
    PendingResult<Status> discardContents(GoogleApiClient var1, Contents var2);

    PendingResult<DriveApi.DriveIdResult> fetchDriveId(GoogleApiClient var1, String var2);

    DriveFolder getAppFolder(GoogleApiClient var1);

    DriveFile getFile(GoogleApiClient var1, DriveId var2);

    DriveFolder getFolder(GoogleApiClient var1, DriveId var2);

    DriveFolder getRootFolder(GoogleApiClient var1);

    @Deprecated
    PendingResult<DriveApi.ContentsResult> newContents(GoogleApiClient var1);

    CreateFileActivityBuilder newCreateFileActivityBuilder();

    PendingResult<DriveApi.DriveContentsResult> newDriveContents(GoogleApiClient var1);

    OpenFileActivityBuilder newOpenFileActivityBuilder();

    PendingResult<DriveApi.MetadataBufferResult> query(GoogleApiClient var1, Query var2);

    PendingResult<Status> requestSync(GoogleApiClient var1);

    @Deprecated
    public interface ContentsResult extends Result {
        Contents getContents();
    }

    public interface DriveContentsResult extends Result {
        DriveContents getDriveContents();
    }

    public interface DriveIdResult extends Result {
        DriveId getDriveId();
    }

    public interface MetadataBufferResult extends Result {
        MetadataBuffer getMetadataBuffer();
    }
}
