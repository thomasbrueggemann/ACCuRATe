package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest;
import com.google.android.gms.drive.internal.CloseContentsRequest;
import com.google.android.gms.drive.internal.OnContentsResponse;
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;
import com.google.android.gms.drive.internal.OpenContentsRequest;
import com.google.android.gms.drive.internal.class_202;
import com.google.android.gms.drive.internal.class_203;
import com.google.android.gms.drive.internal.class_214;
import com.google.android.gms.drive.internal.class_233;
import com.google.android.gms.drive.internal.class_245;
import com.google.android.gms.drive.internal.q;

// $FF: renamed from: com.google.android.gms.drive.internal.s
public class class_216 extends class_214 implements DriveFile {
   public class_216(DriveId var1) {
      super(var1);
   }

   public PendingResult<Status> commitAndCloseContents(GoogleApiClient var1, final Contents var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Contents must be provided.");
      } else {
         return var1.method_773(new class_216.class_1228(null) {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
            protected void method_1042(class_245 var1) throws RemoteException {
               var2.close();
               var1.method_1708().method_842(new CloseContentsRequest(var2, true), new class_203(this));
            }
         });
      }
   }

   public PendingResult<Status> commitAndCloseContents(GoogleApiClient var1, final Contents var2, final MetadataChangeSet var3) {
      if(var2 == null) {
         throw new IllegalArgumentException("Contents must be provided.");
      } else {
         return var1.method_773(new class_216.class_1227(null) {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
            protected void method_1040(class_245 var1) throws RemoteException {
               var2.close();
               var1.method_1708().method_841(new CloseContentsAndUpdateMetadataRequest(class_216.this.Hw, var3.method_2667(), var2, false, (String)null), new class_203(this));
            }
         });
      }
   }

   public PendingResult<Status> discardContents(GoogleApiClient var1, Contents var2) {
      return Drive.DriveApi.discardContents(var1, var2);
   }

   public PendingResult<DriveApi.ContentsResult> openContents(GoogleApiClient var1, final int var2, final DriveFile.DownloadProgressListener var3) {
      if(var2 != 268435456 && var2 != 536870912 && var2 != 805306368) {
         throw new IllegalArgumentException("Invalid mode provided.");
      } else {
         return var1.method_772(new class_216.class_1230(null) {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
            protected void method_1044(class_245 var1) throws RemoteException {
               var1.method_1708().method_853(new OpenContentsRequest(class_216.this.getDriveId(), var2), new class_216.class_1229(this, var3));
            }
         });
      }
   }

   private abstract class class_1227 extends q<Status> {
      private class_1227() {
      }

      // $FF: synthetic method
      class_1227(Object var2) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1039(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1039(Status var1) {
         return var1;
      }
   }

   private abstract class class_1228 extends q<Status> {
      private class_1228() {
      }

      // $FF: synthetic method
      class_1228(Object var2) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1041(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1041(Status var1) {
         return var1;
      }
   }

   private static class class_1229 extends class_202 {
      // $FF: renamed from: Jb com.google.android.gms.drive.DriveFile$DownloadProgressListener
      private final DriveFile.DownloadProgressListener field_657;
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<DriveApi.ContentsResult> field_658;

      public class_1229(class_797.class_1206<DriveApi.ContentsResult> var1, DriveFile.DownloadProgressListener var2) {
         this.field_658 = var1;
         this.field_657 = var2;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnContentsResponse) void
      public void method_825(OnContentsResponse var1) throws RemoteException {
         this.field_658.method_673(new class_233.class_1234(Status.field_3880, var1.method_4363()));
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDownloadProgressResponse) void
      public void method_826(OnDownloadProgressResponse var1) throws RemoteException {
         if(this.field_657 != null) {
            this.field_657.onProgress(var1.method_3273(), var1.method_3274());
         }

      }

      // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
      public void method_835(Status var1) throws RemoteException {
         this.field_658.method_673(new class_233.class_1234(var1, (Contents)null));
      }
   }

   private abstract class class_1230 extends q<DriveApi.ContentsResult> {
      private class_1230() {
      }

      // $FF: synthetic method
      class_1230(Object var2) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1043(var1);
      }

      // $FF: renamed from: q (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveApi$ContentsResult
      public DriveApi.ContentsResult method_1043(Status var1) {
         return new class_233.class_1234(var1, (Contents)null);
      }
   }
}
