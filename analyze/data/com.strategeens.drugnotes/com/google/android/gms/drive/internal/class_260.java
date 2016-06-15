package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.internal.CreateFolderRequest;
import com.google.android.gms.drive.internal.OnDriveIdResponse;
import com.google.android.gms.drive.internal.class_259;
import com.google.android.gms.drive.internal.class_261;
import com.google.android.gms.drive.internal.class_262;
import com.google.android.gms.drive.internal.class_267;
import com.google.android.gms.drive.internal.class_282;
import com.google.android.gms.drive.internal.class_299;
import com.google.android.gms.drive.internal.q;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;

// $FF: renamed from: com.google.android.gms.drive.internal.v
public class class_260 extends class_259 implements DriveFolder {
   public class_260(DriveId var1) {
      super(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.MetadataChangeSet, int, int, com.google.android.gms.drive.ExecutionOptions) com.google.android.gms.common.api.PendingResult
   private PendingResult<DriveFolder.DriveFileResult> method_1696(final GoogleApiClient var1, final MetadataChangeSet var2, final int var3, final int var4, final ExecutionOptions var5) {
      ExecutionOptions.method_4305(var1, var5);
      return var1.method_944(new class_260.class_1214(var1) {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1320(class_299 var1) throws RemoteException {
            var2.method_3001().setContext(var1.getContext());
            CreateFileRequest var2x = new CreateFileRequest(class_260.this.getDriveId(), var2.method_3001(), var3, var4, var5);
            var1.method_2075().method_1035(var2x, new class_260.class_1211(this));
         }
      });
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.MetadataChangeSet, com.google.android.gms.drive.DriveContents, com.google.android.gms.drive.ExecutionOptions) com.google.android.gms.common.api.PendingResult
   private PendingResult<DriveFolder.DriveFileResult> method_1697(GoogleApiClient var1, MetadataChangeSet var2, DriveContents var3, ExecutionOptions var4) {
      int var5;
      if(var3 != null) {
         if(!(var3 instanceof class_262)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
         }

         if(var3.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
         }

         if(var3.method_952()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
         }

         var5 = var3.method_950().getRequestId();
         var3.method_951();
      } else {
         var5 = 1;
      }

      if(var2 == null) {
         throw new IllegalArgumentException("MetadataChangeSet must be provided.");
      } else if("application/vnd.google-apps.folder".equals(var2.getMimeType())) {
         throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
      } else {
         return this.method_1696(var1, var2, var5, 0, var4);
      }
   }

   public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient var1, MetadataChangeSet var2, DriveContents var3) {
      return this.createFile(var1, var2, var3, (ExecutionOptions)null);
   }

   public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient var1, MetadataChangeSet var2, DriveContents var3, ExecutionOptions var4) {
      if(var4 == null) {
         var4 = (new ExecutionOptions.Builder()).build();
      }

      if(var4.method_4311() != 0) {
         throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
      } else {
         return this.method_1697(var1, var2, var3, var4);
      }
   }

   public PendingResult<DriveFolder.DriveFolderResult> createFolder(final GoogleApiClient var1, final MetadataChangeSet var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("MetadataChangeSet must be provided.");
      } else if(var2.getMimeType() != null && !var2.getMimeType().equals("application/vnd.google-apps.folder")) {
         throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
      } else {
         return var1.method_944(new class_260.class_1207(var1) {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
            protected void method_1322(class_299 var1) throws RemoteException {
               var2.method_3001().setContext(var1.getContext());
               var1.method_2075().method_1036(new CreateFolderRequest(class_260.this.getDriveId(), var2.method_3001()), new class_260.class_1210(this));
            }
         });
      }
   }

   public PendingResult<DriveApi.MetadataBufferResult> listChildren(GoogleApiClient var1) {
      return this.queryChildren(var1, (Query)null);
   }

   public PendingResult<DriveApi.MetadataBufferResult> queryChildren(GoogleApiClient var1, Query var2) {
      Query.Builder var3 = (new Query.Builder()).addFilter(Filters.method_3701(SearchableField.PARENTS, this.getDriveId()));
      if(var2 != null) {
         if(var2.getFilter() != null) {
            var3.addFilter(var2.getFilter());
         }

         var3.setPageToken(var2.getPageToken());
         var3.setSortOrder(var2.getSortOrder());
      }

      return (new class_282()).query(var1, var3.build());
   }

   private static class class_1211 extends class_267 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<DriveFolder.DriveFileResult> field_557;

      public class_1211(BaseImplementation.class_1058<DriveFolder.DriveFileResult> var1) {
         this.field_557 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDriveIdResponse) void
      public void method_1015(OnDriveIdResponse var1) throws RemoteException {
         this.field_557.method_110(new class_260.class_1215(Status.field_3960, new class_261(var1.getDriveId())));
      }

      // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
      public void method_1024(Status var1) throws RemoteException {
         this.field_557.method_110(new class_260.class_1215(var1, (DriveFile)null));
      }
   }

   private static class class_1210 extends class_267 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<DriveFolder.DriveFolderResult> field_558;

      public class_1210(BaseImplementation.class_1058<DriveFolder.DriveFolderResult> var1) {
         this.field_558 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDriveIdResponse) void
      public void method_1015(OnDriveIdResponse var1) throws RemoteException {
         this.field_558.method_110(new class_260.class_1208(Status.field_3960, new class_260(var1.getDriveId())));
      }

      // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
      public void method_1024(Status var1) throws RemoteException {
         this.field_558.method_110(new class_260.class_1208(var1, (DriveFolder)null));
      }
   }

   private static class class_1215 implements DriveFolder.DriveFileResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_1833;
      // $FF: renamed from: Qn com.google.android.gms.drive.DriveFile
      private final DriveFile field_1834;

      public class_1215(Status var1, DriveFile var2) {
         this.field_1833 = var1;
         this.field_1834 = var2;
      }

      public DriveFile getDriveFile() {
         return this.field_1834;
      }

      public Status getStatus() {
         return this.field_1833;
      }
   }

   abstract static class class_1214 extends q<DriveFolder.DriveFileResult> {
      class_1214(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1319(var1);
      }

      // $FF: renamed from: r (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveFolder$DriveFileResult
      public DriveFolder.DriveFileResult method_1319(Status var1) {
         return new class_260.class_1215(var1, (DriveFile)null);
      }
   }

   private static class class_1208 implements DriveFolder.DriveFolderResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_1813;
      // $FF: renamed from: Qo com.google.android.gms.drive.DriveFolder
      private final DriveFolder field_1814;

      public class_1208(Status var1, DriveFolder var2) {
         this.field_1813 = var1;
         this.field_1814 = var2;
      }

      public DriveFolder getDriveFolder() {
         return this.field_1814;
      }

      public Status getStatus() {
         return this.field_1813;
      }
   }

   abstract static class class_1207 extends q<DriveFolder.DriveFolderResult> {
      class_1207(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1321(var1);
      }

      // $FF: renamed from: s (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveFolder$DriveFolderResult
      public DriveFolder.DriveFolderResult method_1321(Status var1) {
         return new class_260.class_1208(var1, (DriveFolder)null);
      }
   }
}
