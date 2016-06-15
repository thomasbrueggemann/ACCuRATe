package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.class_299;
import com.google.android.gms.internal.class_335;

public class OpenFileActivityBuilder {
   public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
   // $FF: renamed from: OH java.lang.String
   private String field_3777;
   // $FF: renamed from: OI java.lang.String[]
   private String[] field_3778;
   // $FF: renamed from: OJ com.google.android.gms.drive.DriveId
   private DriveId field_3779;

   public IntentSender build(GoogleApiClient var1) {
      class_335.method_2302(var1.isConnected(), "Client must be connected");
      if(this.field_3778 == null) {
         this.field_3778 = new String[0];
      }

      try {
         IntentSender var3 = ((class_299)var1.method_941(Drive.field_2928)).method_2075().method_1026(new OpenFileIntentSenderRequest(this.field_3777, this.field_3778, this.field_3779));
         return var3;
      } catch (RemoteException var4) {
         throw new RuntimeException("Unable to connect Drive Play Service", var4);
      }
   }

   public OpenFileActivityBuilder setActivityStartFolder(DriveId var1) {
      this.field_3779 = (DriveId)class_335.method_2311(var1);
      return this;
   }

   public OpenFileActivityBuilder setActivityTitle(String var1) {
      this.field_3777 = (String)class_335.method_2311(var1);
      return this;
   }

   public OpenFileActivityBuilder setMimeType(String[] var1) {
      boolean var2;
      if(var1 != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      class_335.method_2308(var2, "mimeTypes may not be null");
      this.field_3778 = var1;
      return this;
   }
}
