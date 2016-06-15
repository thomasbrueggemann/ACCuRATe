package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.internal.CreateFolderRequest;
import com.google.android.gms.drive.internal.OnDriveIdResponse;
import com.google.android.gms.drive.internal.class_162;
import com.google.android.gms.drive.internal.class_202;
import com.google.android.gms.drive.internal.class_214;
import com.google.android.gms.drive.internal.class_216;
import com.google.android.gms.drive.internal.class_233;
import com.google.android.gms.drive.internal.class_245;
import com.google.android.gms.drive.internal.q;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;

// $FF: renamed from: com.google.android.gms.drive.internal.u
public class class_215 extends class_214 implements DriveFolder {
   public class_215(DriveId var1) {
      super(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.MetadataChangeSet, com.google.android.gms.drive.Contents, int, boolean, java.lang.String) com.google.android.gms.common.api.PendingResult
   private PendingResult<DriveFolder.DriveFileResult> method_1381(GoogleApiClient var1, final MetadataChangeSet var2, final Contents var3, final int var4, final boolean var5, final String var6) {
      return var1.method_773(new class_162() {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1050(class_245 var1) throws RemoteException {
            if(var3 != null) {
               var3.close();
            }

            var1.method_1708().method_844(new CreateFileRequest(class_215.this.getDriveId(), var2.method_2667(), var3, var4, var5, var6), new class_215.class_1221(this));
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         public Result method_884(Status var1) {
            return this.method_1051(var1);
         }

         // $FF: renamed from: s (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveFolder$DriveFileResult
         public DriveFolder.DriveFileResult method_1051(Status var1) {
            return new class_215.class_1222(var1, (DriveFile)null);
         }
      });
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.MetadataChangeSet, com.google.android.gms.drive.Contents, boolean, java.lang.String) com.google.android.gms.common.api.PendingResult
   private PendingResult<DriveFolder.DriveFileResult> method_1382(GoogleApiClient var1, MetadataChangeSet var2, Contents var3, boolean var4, String var5) {
      if(var2 == null) {
         throw new IllegalArgumentException("MetadataChangeSet must be provided.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Contents must be provided.");
      } else if("application/vnd.google-apps.folder".equals(var2.getMimeType())) {
         throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
      } else {
         return this.method_1381(var1, var2, var3, 0, var4, var5);
      }
   }

   public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient var1, MetadataChangeSet var2, Contents var3) {
      return this.method_1382(var1, var2, var3, false, (String)null);
   }

   public PendingResult<DriveFolder.DriveFolderResult> createFolder(GoogleApiClient var1, final MetadataChangeSet var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("MetadataChangeSet must be provided.");
      } else if(var2.getMimeType() != null && !var2.getMimeType().equals("application/vnd.google-apps.folder")) {
         throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
      } else {
         return var1.method_773(new class_215.class_1225(null) {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
            protected void method_1053(class_245 var1) throws RemoteException {
               var1.method_1708().method_845(new CreateFolderRequest(class_215.this.getDriveId(), var2.method_2667()), new class_215.class_1224(this));
            }
         });
      }
   }

   public PendingResult<DriveApi.MetadataBufferResult> listChildren(GoogleApiClient var1) {
      return this.queryChildren(var1, (Query)null);
   }

   public PendingResult<DriveApi.MetadataBufferResult> queryChildren(GoogleApiClient var1, Query var2) {
      Query.Builder var3 = (new Query.Builder()).addFilter(Filters.method_3106(SearchableField.PARENTS, this.getDriveId()));
      if(var2 != null) {
         if(var2.getFilter() != null) {
            var3.addFilter(var2.getFilter());
         }

         var3.setPageToken(var2.getPageToken());
         var3.setSortOrder(var2.getSortOrder());
      }

      return (new class_233()).query(var1, var3.build());
   }

   private static class class_1221 extends class_202 {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<DriveFolder.DriveFileResult> field_660;

      public class_1221(class_797.class_1206<DriveFolder.DriveFileResult> var1) {
         this.field_660 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDriveIdResponse) void
      public void method_827(OnDriveIdResponse var1) throws RemoteException {
         this.field_660.method_673(new class_215.class_1222(Status.field_3880, new class_216(var1.getDriveId())));
      }

      // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
      public void method_835(Status var1) throws RemoteException {
         this.field_660.method_673(new class_215.class_1222(var1, (DriveFile)null));
      }
   }

   private static class class_1224 extends class_202 {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<DriveFolder.DriveFolderResult> field_659;

      public class_1224(class_797.class_1206<DriveFolder.DriveFolderResult> var1) {
         this.field_659 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDriveIdResponse) void
      public void method_827(OnDriveIdResponse var1) throws RemoteException {
         this.field_659.method_673(new class_215.class_1223(Status.field_3880, new class_215(var1.getDriveId())));
      }

      // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
      public void method_835(Status var1) throws RemoteException {
         this.field_659.method_673(new class_215.class_1223(var1, (DriveFolder)null));
      }
   }

   private abstract class class_1225 extends q<DriveFolder.DriveFolderResult> {
      private class_1225() {
      }

      // $FF: synthetic method
      class_1225(Object var2) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1052(var1);
      }

      // $FF: renamed from: t (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveFolder$DriveFolderResult
      public DriveFolder.DriveFolderResult method_1052(Status var1) {
         return new class_215.class_1223(var1, (DriveFolder)null);
      }
   }

   private static class class_1222 implements DriveFolder.DriveFileResult {
      // $FF: renamed from: Jg com.google.android.gms.drive.DriveFile
      private final DriveFile field_3322;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_3323;

      public class_1222(Status var1, DriveFile var2) {
         this.field_3323 = var1;
         this.field_3322 = var2;
      }

      public DriveFile getDriveFile() {
         return this.field_3322;
      }

      public Status getStatus() {
         return this.field_3323;
      }
   }

   private static class class_1223 implements DriveFolder.DriveFolderResult {
      // $FF: renamed from: Jh com.google.android.gms.drive.DriveFolder
      private final DriveFolder field_3324;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_3325;

      public class_1223(Status var1, DriveFolder var2) {
         this.field_3325 = var1;
         this.field_3324 = var2;
      }

      public DriveFolder getDriveFolder() {
         return this.field_3324;
      }

      public Status getStatus() {
         return this.field_3325;
      }
   }
}
