package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.class_225;
import com.google.android.gms.internal.class_347;
import java.io.IOException;

public class CreateFileActivityBuilder {
   public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
   // $FF: renamed from: HC com.google.android.gms.drive.internal.h
   private final class_225 field_3122 = new class_225(0);
   // $FF: renamed from: HD com.google.android.gms.drive.Contents
   private Contents field_3123;

   public IntentSender build(GoogleApiClient var1) {
      class_347.method_2166(this.field_3123, "Must provide initial contents to CreateFileActivityBuilder.");

      try {
         this.field_3123.getParcelFileDescriptor().close();
      } catch (IOException var4) {
         ;
      }

      this.field_3123.close();
      return this.field_3122.build(var1);
   }

   public CreateFileActivityBuilder setActivityStartFolder(DriveId var1) {
      this.field_3122.method_1402(var1);
      return this;
   }

   public CreateFileActivityBuilder setActivityTitle(String var1) {
      this.field_3122.method_1404(var1);
      return this;
   }

   public CreateFileActivityBuilder setInitialContents(Contents var1) {
      this.field_3123 = (Contents)class_347.method_2170(var1);
      this.field_3122.method_1405(this.field_3123.getRequestId());
      return this;
   }

   public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet var1) {
      this.field_3122.method_1403(var1);
      return this;
   }
}
