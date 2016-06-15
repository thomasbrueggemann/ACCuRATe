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

   DriveId getDriveId();

   InputStream getInputStream();

   int getMode();

   OutputStream getOutputStream();

   ParcelFileDescriptor getParcelFileDescriptor();

   // $FF: renamed from: ir () com.google.android.gms.drive.Contents
   Contents method_950();

   // $FF: renamed from: is () void
   void method_951();

   // $FF: renamed from: it () boolean
   boolean method_952();

   PendingResult<DriveApi.DriveContentsResult> reopenForWrite(GoogleApiClient var1);
}
