package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.FileUploadPreferences;

public interface DrivePreferencesApi {
   PendingResult<DrivePreferencesApi.FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient var1);

   PendingResult<Status> setFileUploadPreferences(GoogleApiClient var1, FileUploadPreferences var2);

   public interface FileUploadPreferencesResult extends Result {
      FileUploadPreferences getFileUploadPreferences();
   }
}
