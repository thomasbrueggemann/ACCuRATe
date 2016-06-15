package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.internal.FileUploadPreferencesImpl;
import com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse;
import com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest;
import com.google.android.gms.drive.internal.class_205;
import com.google.android.gms.drive.internal.class_267;
import com.google.android.gms.drive.internal.class_268;
import com.google.android.gms.drive.internal.class_299;
import com.google.android.gms.drive.internal.q;

// $FF: renamed from: com.google.android.gms.drive.internal.x
public class class_264 implements DrivePreferencesApi {
   public PendingResult<DrivePreferencesApi.FileUploadPreferencesResult> getFileUploadPreferences(final GoogleApiClient var1) {
      return var1.method_942(new class_264.class_1596(var1) {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1302(class_299 var1) throws RemoteException {
            var1.method_2075().method_1059(class_264.this.new class_1594(this, null));
         }
      });
   }

   public PendingResult<Status> setFileUploadPreferences(final GoogleApiClient var1, FileUploadPreferences var2) {
      if(!(var2 instanceof FileUploadPreferencesImpl)) {
         throw new IllegalArgumentException("Invalid preference value");
      } else {
         return var1.method_944(new class_205.class_1096(var1) {
            // $FF: renamed from: Qr com.google.android.gms.drive.internal.FileUploadPreferencesImpl
            // $FF: synthetic field
            final FileUploadPreferencesImpl field_216;

            {
               this.field_216 = var3;
            }

            // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
            protected void method_1307(class_299 var1) throws RemoteException {
               var1.method_2075().method_1047(new SetFileUploadPreferencesRequest(this.field_216), new class_268(this));
            }
         });
      }
   }

   private class class_1594 extends class_267 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<DrivePreferencesApi.FileUploadPreferencesResult> field_555;

      private class_1594(BaseImplementation.class_1058<DrivePreferencesApi.FileUploadPreferencesResult> var1) {
         this.field_555 = var2;
      }

      // $FF: synthetic method
      class_1594(BaseImplementation.class_1058 var2, Object var3) {
         this();
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse) void
      public void method_1013(OnDeviceUsagePreferenceResponse var1) throws RemoteException {
         this.field_555.method_110(class_264.this.new class_1595(Status.field_3960, var1.method_3238(), null));
      }

      // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
      public void method_1024(Status var1) throws RemoteException {
         this.field_555.method_110(class_264.this.new class_1595(var1, (FileUploadPreferences)null, null));
      }
   }

   private class class_1595 implements DrivePreferencesApi.FileUploadPreferencesResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_4106;
      // $FF: renamed from: Qs com.google.android.gms.drive.FileUploadPreferences
      private final FileUploadPreferences field_4108;

      private class_1595(Status var2, FileUploadPreferences var3) {
         this.field_4106 = var2;
         this.field_4108 = var3;
      }

      // $FF: synthetic method
      class_1595(Status var2, FileUploadPreferences var3, Object var4) {
         this();
      }

      public FileUploadPreferences getFileUploadPreferences() {
         return this.field_4108;
      }

      public Status getStatus() {
         return this.field_4106;
      }
   }

   private abstract class class_1596 extends q<DrivePreferencesApi.FileUploadPreferencesResult> {
      public class_1596(GoogleApiClient var2) {
         super(var2);
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      protected Result method_1109(Status var1) {
         return this.method_1301(var1);
      }

      // $FF: renamed from: t (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DrivePreferencesApi$FileUploadPreferencesResult
      protected DrivePreferencesApi.FileUploadPreferencesResult method_1301(Status var1) {
         return class_264.this.new class_1595(var1, (FileUploadPreferences)null, null);
      }
   }
}
