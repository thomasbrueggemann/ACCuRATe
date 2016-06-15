package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.class_1033;
import com.google.android.gms.common.api.d;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.OpenContentsRequest;
import com.google.android.gms.drive.internal.class_259;
import com.google.android.gms.drive.internal.class_269;
import com.google.android.gms.drive.internal.class_282;
import com.google.android.gms.drive.internal.class_299;

// $FF: renamed from: com.google.android.gms.drive.internal.t
public class class_261 extends class_259 implements DriveFile {
   public class_261(DriveId var1) {
      super(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.DriveFile$DownloadProgressListener) com.google.android.gms.drive.DriveFile$DownloadProgressListener
   private static DriveFile.DownloadProgressListener method_1698(GoogleApiClient var0, DriveFile.DownloadProgressListener var1) {
      return var1 == null?null:new class_261.class_1516(var0.method_945(var1));
   }

   public PendingResult<DriveApi.DriveContentsResult> open(final GoogleApiClient var1, final int var2, DriveFile.DownloadProgressListener var3) {
      if(var2 != 268435456 && var2 != 536870912 && var2 != 805306368) {
         throw new IllegalArgumentException("Invalid mode provided.");
      } else {
         return var1.method_942(new class_282.class_1600(var1) {
            // $FF: renamed from: Qc com.google.android.gms.drive.DriveFile$DownloadProgressListener
            // $FF: synthetic field
            final DriveFile.DownloadProgressListener field_241;

            {
               this.field_241 = var4;
            }

            // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
            protected void method_1318(class_299 var1) throws RemoteException {
               var1.method_2075().method_1043(new OpenContentsRequest(class_261.this.getDriveId(), var2, 0), new class_269(this, this.field_241));
            }
         });
      }
   }

   private static class class_1516 implements DriveFile.DownloadProgressListener {
      // $FF: renamed from: Qe com.google.android.gms.common.api.d
      private final d<DriveFile.DownloadProgressListener> field_3074;

      public class_1516(d<DriveFile.DownloadProgressListener> var1) {
         this.field_3074 = var1;
      }

      public void onProgress(final long var1, final long var3) {
         this.field_3074.method_5677(new class_1033.class_1137() {
            // $FF: renamed from: a (com.google.android.gms.drive.DriveFile$DownloadProgressListener) void
            public void method_5373(DriveFile.DownloadProgressListener var1x) {
               var1x.onProgress(var1, var3);
            }

            // $FF: renamed from: c (java.lang.Object) void
            // $FF: synthetic method
            public void method_199(Object var1x) {
               this.method_5373((DriveFile.DownloadProgressListener)var1x);
            }

            // $FF: renamed from: gG () void
            public void method_200() {
            }
         });
      }
   }
}
