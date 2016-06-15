package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.class_154;
import com.google.android.gms.drive.internal.class_245;
import com.google.android.gms.internal.class_347;

public class OpenFileActivityBuilder {
   public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
   // $FF: renamed from: HV java.lang.String
   private String field_3652;
   // $FF: renamed from: HW java.lang.String[]
   private String[] field_3653;
   // $FF: renamed from: HX com.google.android.gms.drive.DriveId
   private DriveId field_3654;

   public IntentSender build(GoogleApiClient var1) {
      class_347.method_2161(var1.isConnected(), "Client must be connected");
      if(this.field_3653 == null) {
         this.field_3653 = new String[0];
      }

      class_154 var2 = ((class_245)var1.method_771(Drive.field_3068)).method_1708();

      try {
         IntentSender var4 = var2.method_837(new OpenFileIntentSenderRequest(this.field_3652, this.field_3653, this.field_3654));
         return var4;
      } catch (RemoteException var5) {
         throw new RuntimeException("Unable to connect Drive Play Service", var5);
      }
   }

   public OpenFileActivityBuilder setActivityStartFolder(DriveId var1) {
      this.field_3654 = (DriveId)class_347.method_2170(var1);
      return this;
   }

   public OpenFileActivityBuilder setActivityTitle(String var1) {
      this.field_3652 = (String)class_347.method_2170(var1);
      return this;
   }

   public OpenFileActivityBuilder setMimeType(String[] var1) {
      boolean var2;
      if(var1 != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      class_347.method_2168(var2, "mimeTypes may not be null");
      this.field_3653 = var1;
      return this;
   }
}
