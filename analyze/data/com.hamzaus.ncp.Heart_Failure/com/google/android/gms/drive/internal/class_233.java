package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.internal.CloseContentsRequest;
import com.google.android.gms.drive.internal.CreateContentsRequest;
import com.google.android.gms.drive.internal.GetMetadataRequest;
import com.google.android.gms.drive.internal.OnContentsResponse;
import com.google.android.gms.drive.internal.OnDriveIdResponse;
import com.google.android.gms.drive.internal.OnListEntriesResponse;
import com.google.android.gms.drive.internal.OnMetadataResponse;
import com.google.android.gms.drive.internal.QueryRequest;
import com.google.android.gms.drive.internal.class_202;
import com.google.android.gms.drive.internal.class_203;
import com.google.android.gms.drive.internal.class_215;
import com.google.android.gms.drive.internal.class_216;
import com.google.android.gms.drive.internal.class_229;
import com.google.android.gms.drive.internal.class_245;
import com.google.android.gms.drive.internal.q;
import com.google.android.gms.drive.query.Query;

// $FF: renamed from: com.google.android.gms.drive.internal.p
public class class_233 implements DriveApi {
   public PendingResult<Status> discardContents(GoogleApiClient var1, final Contents var2) {
      return var1.method_773(new class_233.class_1243() {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1047(class_245 var1) throws RemoteException {
            var1.method_1708().method_842(new CloseContentsRequest(var2, false), new class_203(this));
         }
      });
   }

   public PendingResult<DriveApi.DriveIdResult> fetchDriveId(GoogleApiClient var1, final String var2) {
      return var1.method_772(new class_233.class_1237() {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1038(class_245 var1) throws RemoteException {
            var1.method_1708().method_850(new GetMetadataRequest(DriveId.method_2740(var2)), new class_233.class_1235(this));
         }
      });
   }

   public DriveFolder getAppFolder(GoogleApiClient var1) {
      if(!var1.isConnected()) {
         throw new IllegalStateException("Client must be connected");
      } else {
         DriveId var2 = ((class_245)var1.method_771(Drive.field_3068)).method_1710();
         return var2 != null?new class_215(var2):null;
      }
   }

   public DriveFile getFile(GoogleApiClient var1, DriveId var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Id must be provided.");
      } else if(!var1.isConnected()) {
         throw new IllegalStateException("Client must be connected");
      } else {
         return new class_216(var2);
      }
   }

   public DriveFolder getFolder(GoogleApiClient var1, DriveId var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Id must be provided.");
      } else if(!var1.isConnected()) {
         throw new IllegalStateException("Client must be connected");
      } else {
         return new class_215(var2);
      }
   }

   public DriveFolder getRootFolder(GoogleApiClient var1) {
      if(!var1.isConnected()) {
         throw new IllegalStateException("Client must be connected");
      } else {
         return new class_215(((class_245)var1.method_771(Drive.field_3068)).method_1709());
      }
   }

   public PendingResult<DriveApi.ContentsResult> newContents(GoogleApiClient var1) {
      return var1.method_772(new class_233.class_1240() {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1034(class_245 var1) throws RemoteException {
            var1.method_1708().method_843(new CreateContentsRequest(), new class_233.class_1239(this));
         }
      });
   }

   public CreateFileActivityBuilder newCreateFileActivityBuilder() {
      return new CreateFileActivityBuilder();
   }

   public OpenFileActivityBuilder newOpenFileActivityBuilder() {
      return new OpenFileActivityBuilder();
   }

   public PendingResult<DriveApi.MetadataBufferResult> query(GoogleApiClient var1, final Query var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Query must be provided.");
      } else {
         return var1.method_772(new class_233.class_1242() {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
            protected void method_1032(class_245 var1) throws RemoteException {
               var1.method_1708().method_854(new QueryRequest(var2), new class_233.class_1241(this));
            }
         });
      }
   }

   public PendingResult<Status> requestSync(GoogleApiClient var1) {
      return var1.method_773(new class_233.class_1245() {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1036(class_245 var1) throws RemoteException {
            var1.method_1708().method_859(new class_203(this));
         }
      });
   }

   public static class class_1234 implements DriveApi.ContentsResult {
      // $FF: renamed from: HD com.google.android.gms.drive.Contents
      private final Contents field_4190;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_4191;

      public class_1234(Status var1, Contents var2) {
         this.field_4191 = var1;
         this.field_4190 = var2;
      }

      public Contents getContents() {
         return this.field_4190;
      }

      public Status getStatus() {
         return this.field_4191;
      }
   }

   private static class class_1235 extends class_202 {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<DriveApi.DriveIdResult> field_654;

      public class_1235(class_797.class_1206<DriveApi.DriveIdResult> var1) {
         this.field_654 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDriveIdResponse) void
      public void method_827(OnDriveIdResponse var1) throws RemoteException {
         this.field_654.method_673(new class_233.class_1236(Status.field_3880, var1.getDriveId()));
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnMetadataResponse) void
      public void method_831(OnMetadataResponse var1) throws RemoteException {
         this.field_654.method_673(new class_233.class_1236(Status.field_3880, (new class_229(var1.method_4602())).getDriveId()));
      }

      // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
      public void method_835(Status var1) throws RemoteException {
         this.field_654.method_673(new class_233.class_1236(var1, (DriveId)null));
      }
   }

   static class class_1236 implements DriveApi.DriveIdResult {
      // $FF: renamed from: Hw com.google.android.gms.drive.DriveId
      private final DriveId field_4192;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_4193;

      public class_1236(Status var1, DriveId var2) {
         this.field_4193 = var1;
         this.field_4192 = var2;
      }

      public DriveId getDriveId() {
         return this.field_4192;
      }

      public Status getStatus() {
         return this.field_4193;
      }
   }

   abstract class class_1237 extends q<DriveApi.DriveIdResult> {
      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1037(var1);
      }

      // $FF: renamed from: p (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveApi$DriveIdResult
      public DriveApi.DriveIdResult method_1037(Status var1) {
         return new class_233.class_1236(var1, (DriveId)null);
      }
   }

   static class class_1238 implements DriveApi.MetadataBufferResult {
      // $FF: renamed from: IL com.google.android.gms.drive.MetadataBuffer
      private final MetadataBuffer field_4194;
      // $FF: renamed from: IM boolean
      private final boolean field_4195;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_4196;

      public class_1238(Status var1, MetadataBuffer var2, boolean var3) {
         this.field_4196 = var1;
         this.field_4194 = var2;
         this.field_4195 = var3;
      }

      public MetadataBuffer getMetadataBuffer() {
         return this.field_4194;
      }

      public Status getStatus() {
         return this.field_4196;
      }
   }

   private static class class_1239 extends class_202 {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<DriveApi.ContentsResult> field_653;

      public class_1239(class_797.class_1206<DriveApi.ContentsResult> var1) {
         this.field_653 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnContentsResponse) void
      public void method_825(OnContentsResponse var1) throws RemoteException {
         this.field_653.method_673(new class_233.class_1234(Status.field_3880, var1.method_4363()));
      }

      // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
      public void method_835(Status var1) throws RemoteException {
         this.field_653.method_673(new class_233.class_1234(var1, (Contents)null));
      }
   }

   abstract class class_1240 extends q<DriveApi.ContentsResult> {
      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1033(var1);
      }

      // $FF: renamed from: q (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveApi$ContentsResult
      public DriveApi.ContentsResult method_1033(Status var1) {
         return new class_233.class_1234(var1, (Contents)null);
      }
   }

   static class class_1241 extends class_202 {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<DriveApi.MetadataBufferResult> field_655;

      public class_1241(class_797.class_1206<DriveApi.MetadataBufferResult> var1) {
         this.field_655 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnListEntriesResponse) void
      public void method_828(OnListEntriesResponse var1) throws RemoteException {
         MetadataBuffer var2 = new MetadataBuffer(var1.method_2676(), (String)null);
         this.field_655.method_673(new class_233.class_1238(Status.field_3880, var2, var1.method_2677()));
      }

      // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
      public void method_835(Status var1) throws RemoteException {
         this.field_655.method_673(new class_233.class_1238(var1, (MetadataBuffer)null, false));
      }
   }

   abstract class class_1242 extends q<DriveApi.MetadataBufferResult> {
      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1031(var1);
      }

      // $FF: renamed from: r (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveApi$MetadataBufferResult
      public DriveApi.MetadataBufferResult method_1031(Status var1) {
         return new class_233.class_1238(var1, (MetadataBuffer)null, false);
      }
   }

   abstract static class class_1243 extends q<Status> {
      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1045(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1045(Status var1) {
         return var1;
      }
   }

   static class class_1244 extends class_233.class_1243 {
      class_1244(GoogleApiClient var1, Status var2) {
         this.a(new class_797.class_1205(((class_245)var1.method_771(Drive.field_3068)).getLooper()));
         this.b(var2);
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
      protected void method_1046(class_245 var1) {
      }
   }

   abstract class class_1245 extends q<Status> {
      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1035(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1035(Status var1) {
         return var1;
      }
   }
}
