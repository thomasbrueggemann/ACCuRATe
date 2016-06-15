package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import com.google.android.gms.internal.class_349;

public final class ConnectionResult {
   public static final int API_UNAVAILABLE = 16;
   public static final int CANCELED = 13;
   // $FF: renamed from: CP com.google.android.gms.common.ConnectionResult
   public static final ConnectionResult field_3492 = new ConnectionResult(0, (PendingIntent)null);
   public static final int DATE_INVALID = 12;
   public static final int DEVELOPER_ERROR = 10;
   public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
   public static final int INTERNAL_ERROR = 8;
   public static final int INTERRUPTED = 15;
   public static final int INVALID_ACCOUNT = 5;
   public static final int LICENSE_CHECK_FAILED = 11;
   public static final int NETWORK_ERROR = 7;
   public static final int RESOLUTION_REQUIRED = 6;
   public static final int SERVICE_DISABLED = 3;
   public static final int SERVICE_INVALID = 9;
   public static final int SERVICE_MISSING = 1;
   public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
   public static final int SIGN_IN_REQUIRED = 4;
   public static final int SUCCESS = 0;
   public static final int TIMEOUT = 14;
   // $FF: renamed from: CQ int
   private final int field_3493;
   private final PendingIntent mPendingIntent;

   public ConnectionResult(int var1, PendingIntent var2) {
      this.field_3493 = var1;
      this.mPendingIntent = var2;
   }

   // $FF: renamed from: es () java.lang.String
   private String method_3849() {
      switch(this.field_3493) {
      case 0:
         return "SUCCESS";
      case 1:
         return "SERVICE_MISSING";
      case 2:
         return "SERVICE_VERSION_UPDATE_REQUIRED";
      case 3:
         return "SERVICE_DISABLED";
      case 4:
         return "SIGN_IN_REQUIRED";
      case 5:
         return "INVALID_ACCOUNT";
      case 6:
         return "RESOLUTION_REQUIRED";
      case 7:
         return "NETWORK_ERROR";
      case 8:
         return "INTERNAL_ERROR";
      case 9:
         return "SERVICE_INVALID";
      case 10:
         return "DEVELOPER_ERROR";
      case 11:
         return "LICENSE_CHECK_FAILED";
      case 12:
      default:
         return "unknown status code " + this.field_3493;
      case 13:
         return "CANCELED";
      case 14:
         return "TIMEOUT";
      case 15:
         return "INTERRUPTED";
      }
   }

   public int getErrorCode() {
      return this.field_3493;
   }

   public PendingIntent getResolution() {
      return this.mPendingIntent;
   }

   public boolean hasResolution() {
      return this.field_3493 != 0 && this.mPendingIntent != null;
   }

   public boolean isSuccess() {
      return this.field_3493 == 0;
   }

   public void startResolutionForResult(Activity var1, int var2) throws SendIntentException {
      if(this.hasResolution()) {
         var1.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), var2, (Intent)null, 0, 0, 0);
      }
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("statusCode", this.method_3849()).method_4301("resolution", this.mPendingIntent).toString();
   }
}
