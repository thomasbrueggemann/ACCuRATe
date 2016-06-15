package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Query;

public interface DriveFolder extends DriveResource {
   String MIME_TYPE = "application/vnd.google-apps.folder";

   PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient var1, MetadataChangeSet var2, Contents var3);

   PendingResult<DriveFolder.DriveFolderResult> createFolder(GoogleApiClient var1, MetadataChangeSet var2);

   PendingResult<DriveApi.MetadataBufferResult> listChildren(GoogleApiClient var1);

   PendingResult<DriveApi.MetadataBufferResult> queryChildren(GoogleApiClient var1, Query var2);

   public interface DriveFileResult extends Result {
      DriveFile getDriveFile();
   }

   public interface DriveFolderResult extends Result {
      DriveFolder getDriveFolder();
   }
}
