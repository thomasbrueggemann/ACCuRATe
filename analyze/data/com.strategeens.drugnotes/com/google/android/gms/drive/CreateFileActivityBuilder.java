package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.class_262;
import com.google.android.gms.drive.internal.class_275;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_715;

public class CreateFileActivityBuilder {
   public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
   // $FF: renamed from: Ol com.google.android.gms.drive.internal.i
   private final class_275 field_3081 = new class_275(0);
   // $FF: renamed from: Om com.google.android.gms.drive.DriveContents
   private DriveContents field_3082;
   // $FF: renamed from: On boolean
   private boolean field_3083;

   public IntentSender build(GoogleApiClient var1) {
      class_335.method_2306(Boolean.valueOf(this.field_3083), "Must call setInitialDriveContents to CreateFileActivityBuilder.");
      boolean var3;
      if(!var1.method_943(Drive.SCOPE_FILE) && !var1.method_943(Drive.field_2929)) {
         var3 = false;
      } else {
         var3 = true;
      }

      class_335.method_2308(var3, "The apiClient must have suitable scope to create files");
      if(this.field_3082 != null) {
         class_715.method_4189(this.field_3082.getParcelFileDescriptor());
         this.field_3082.method_951();
      }

      return this.field_3081.build(var1);
   }

   public CreateFileActivityBuilder setActivityStartFolder(DriveId var1) {
      this.field_3081.method_1744(var1);
      return this;
   }

   public CreateFileActivityBuilder setActivityTitle(String var1) {
      this.field_3081.method_1746(var1);
      return this;
   }

   public CreateFileActivityBuilder setInitialDriveContents(DriveContents var1) {
      if(var1 != null) {
         if(!(var1 instanceof class_262)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
         }

         if(var1.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
         }

         if(var1.method_952()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
         }

         this.field_3081.method_1747(var1.method_950().getRequestId());
         this.field_3082 = var1;
      } else {
         this.field_3081.method_1747(1);
      }

      this.field_3083 = true;
      return this;
   }

   public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet var1) {
      this.field_3081.method_1745(var1);
      return this;
   }
}
