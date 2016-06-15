package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.internal.CreateContentsRequest;
import com.google.android.gms.drive.internal.GetMetadataRequest;
import com.google.android.gms.drive.internal.OnContentsResponse;
import com.google.android.gms.drive.internal.OnDriveIdResponse;
import com.google.android.gms.drive.internal.OnListEntriesResponse;
import com.google.android.gms.drive.internal.OnMetadataResponse;
import com.google.android.gms.drive.internal.QueryRequest;
import com.google.android.gms.drive.internal.class_205;
import com.google.android.gms.drive.internal.class_260;
import com.google.android.gms.drive.internal.class_261;
import com.google.android.gms.drive.internal.class_262;
import com.google.android.gms.drive.internal.class_267;
import com.google.android.gms.drive.internal.class_268;
import com.google.android.gms.drive.internal.class_279;
import com.google.android.gms.drive.internal.class_299;
import com.google.android.gms.drive.internal.q;
import com.google.android.gms.drive.query.Query;
import java.util.List;

// $FF: renamed from: com.google.android.gms.drive.internal.p
public class class_282 implements DriveApi {
   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, int) com.google.android.gms.common.api.PendingResult
   public PendingResult<DriveApi.DriveContentsResult> method_1769(final GoogleApiClient var1, final int var2) {
      return var1.method_942(new class_282.class_1600(var1) {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1316(class_299 var1) throws RemoteException {
            var1.method_2075().method_1034(new CreateContentsRequest(var2), new class_282.class_1606(this));
         }
      });
   }

   public PendingResult<Status> cancelPendingActions(GoogleApiClient var1, List<String> var2) {
      return ((class_299)var1.method_941(Drive.field_2928)).cancelPendingActions(var1, var2);
   }

   public PendingResult<DriveApi.DriveIdResult> fetchDriveId(final GoogleApiClient var1, final String var2) {
      return var1.method_942(new class_282.class_1603(var1) {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1300(class_299 var1) throws RemoteException {
            var1.method_2075().method_1040(new GetMetadataRequest(DriveId.method_3218(var2)), new class_282.class_1601(this));
         }
      });
   }

   public DriveFolder getAppFolder(GoogleApiClient var1) {
      if(!var1.isConnected()) {
         throw new IllegalStateException("Client must be connected");
      } else {
         DriveId var2 = ((class_299)var1.method_941(Drive.field_2928)).method_2077();
         return var2 != null?new class_260(var2):null;
      }
   }

   public DriveFile getFile(GoogleApiClient var1, DriveId var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Id must be provided.");
      } else if(!var1.isConnected()) {
         throw new IllegalStateException("Client must be connected");
      } else {
         return new class_261(var2);
      }
   }

   public DriveFolder getFolder(GoogleApiClient var1, DriveId var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Id must be provided.");
      } else if(!var1.isConnected()) {
         throw new IllegalStateException("Client must be connected");
      } else {
         return new class_260(var2);
      }
   }

   public DriveFolder getRootFolder(GoogleApiClient var1) {
      if(!var1.isConnected()) {
         throw new IllegalStateException("Client must be connected");
      } else {
         return new class_260(((class_299)var1.method_941(Drive.field_2928)).method_2076());
      }
   }

   public CreateFileActivityBuilder newCreateFileActivityBuilder() {
      return new CreateFileActivityBuilder();
   }

   public PendingResult<DriveApi.DriveContentsResult> newDriveContents(GoogleApiClient var1) {
      return this.method_1769(var1, 536870912);
   }

   public OpenFileActivityBuilder newOpenFileActivityBuilder() {
      return new OpenFileActivityBuilder();
   }

   public PendingResult<DriveApi.MetadataBufferResult> query(final GoogleApiClient var1, final Query var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Query must be provided.");
      } else {
         return var1.method_942(new class_282.class_1605(var1) {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
            protected void method_1298(class_299 var1) throws RemoteException {
               var1.method_2075().method_1044(new QueryRequest(var2), new class_282.class_1607(this));
            }
         });
      }
   }

   public PendingResult<Status> requestSync(final GoogleApiClient var1) {
      return var1.method_944(new class_205.class_1096(var1) {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1306(class_299 var1) throws RemoteException {
            var1.method_2075().method_1051(new class_268(this));
         }
      });
   }

   static class class_1599 implements DriveApi.DriveContentsResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_4352;
      // $FF: renamed from: Om com.google.android.gms.drive.DriveContents
      private final DriveContents field_4353;

      public class_1599(Status var1, DriveContents var2) {
         this.field_4352 = var1;
         this.field_4353 = var2;
      }

      public DriveContents getDriveContents() {
         return this.field_4353;
      }

      public Status getStatus() {
         return this.field_4352;
      }
   }

   abstract static class class_1600 extends q<DriveApi.DriveContentsResult> {
      class_1600(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1315(var1);
      }

      // $FF: renamed from: o (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveApi$DriveContentsResult
      public DriveApi.DriveContentsResult method_1315(Status var1) {
         return new class_282.class_1599(var1, (DriveContents)null);
      }
   }

   static class class_1601 extends class_267 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<DriveApi.DriveIdResult> field_549;

      public class_1601(BaseImplementation.class_1058<DriveApi.DriveIdResult> var1) {
         this.field_549 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDriveIdResponse) void
      public void method_1015(OnDriveIdResponse var1) throws RemoteException {
         this.field_549.method_110(new class_282.class_1602(Status.field_3960, var1.getDriveId()));
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnMetadataResponse) void
      public void method_1020(OnMetadataResponse var1) throws RemoteException {
         this.field_549.method_110(new class_282.class_1602(Status.field_3960, (new class_279(var1.method_5866())).getDriveId()));
      }

      // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
      public void method_1024(Status var1) throws RemoteException {
         this.field_549.method_110(new class_282.class_1602(var1, (DriveId)null));
      }
   }

   private static class class_1602 implements DriveApi.DriveIdResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_4355;
      // $FF: renamed from: Oj com.google.android.gms.drive.DriveId
      private final DriveId field_4356;

      public class_1602(Status var1, DriveId var2) {
         this.field_4355 = var1;
         this.field_4356 = var2;
      }

      public DriveId getDriveId() {
         return this.field_4356;
      }

      public Status getStatus() {
         return this.field_4355;
      }
   }

   abstract static class class_1603 extends q<DriveApi.DriveIdResult> {
      class_1603(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1299(var1);
      }

      // $FF: renamed from: p (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveApi$DriveIdResult
      public DriveApi.DriveIdResult method_1299(Status var1) {
         return new class_282.class_1602(var1, (DriveId)null);
      }
   }

   static class class_1604 implements DriveApi.MetadataBufferResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_4357;
      // $FF: renamed from: PI com.google.android.gms.drive.MetadataBuffer
      private final MetadataBuffer field_4358;
      // $FF: renamed from: PJ boolean
      private final boolean field_4359;

      public class_1604(Status var1, MetadataBuffer var2, boolean var3) {
         this.field_4357 = var1;
         this.field_4358 = var2;
         this.field_4359 = var3;
      }

      public MetadataBuffer getMetadataBuffer() {
         return this.field_4358;
      }

      public Status getStatus() {
         return this.field_4357;
      }
   }

   abstract static class class_1605 extends q<DriveApi.MetadataBufferResult> {
      class_1605(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1296(var1);
      }

      // $FF: renamed from: q (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveApi$MetadataBufferResult
      public DriveApi.MetadataBufferResult method_1296(Status var1) {
         return new class_282.class_1604(var1, (MetadataBuffer)null, false);
      }
   }

   private static class class_1606 extends class_267 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<DriveApi.DriveContentsResult> field_551;

      public class_1606(BaseImplementation.class_1058<DriveApi.DriveContentsResult> var1) {
         this.field_551 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnContentsResponse) void
      public void method_1012(OnContentsResponse var1) throws RemoteException {
         this.field_551.method_110(new class_282.class_1599(Status.field_3960, new class_262(var1.method_5558())));
      }

      // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
      public void method_1024(Status var1) throws RemoteException {
         this.field_551.method_110(new class_282.class_1599(var1, (DriveContents)null));
      }
   }

   private static class class_1607 extends class_267 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<DriveApi.MetadataBufferResult> field_550;

      public class_1607(BaseImplementation.class_1058<DriveApi.MetadataBufferResult> var1) {
         this.field_550 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnListEntriesResponse) void
      public void method_1017(OnListEntriesResponse var1) throws RemoteException {
         MetadataBuffer var2 = new MetadataBuffer(var1.method_3029(), (String)null);
         this.field_550.method_110(new class_282.class_1604(Status.field_3960, var2, var1.method_3030()));
      }

      // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
      public void method_1024(Status var1) throws RemoteException {
         this.field_550.method_110(new class_282.class_1604(var1, (MetadataBuffer)null, false));
      }
   }

   static class class_1608 extends class_205.class_1096 {
      class_1608(GoogleApiClient var1, Status var2) {
         super(var1);
         this.b(var2);
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
      protected void method_1305(class_299 var1) {
      }
   }
}
