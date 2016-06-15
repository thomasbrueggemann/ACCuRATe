package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.internal.OnContentsResponse;
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;
import com.google.android.gms.drive.internal.class_262;
import com.google.android.gms.drive.internal.class_267;
import com.google.android.gms.drive.internal.class_282;

// $FF: renamed from: com.google.android.gms.drive.internal.az
class class_269 extends class_267 {
   // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
   private final BaseImplementation.class_1058<DriveApi.DriveContentsResult> field_553;
   // $FF: renamed from: QU com.google.android.gms.drive.DriveFile$DownloadProgressListener
   private final DriveFile.DownloadProgressListener field_554;

   class_269(BaseImplementation.class_1058<DriveApi.DriveContentsResult> var1, DriveFile.DownloadProgressListener var2) {
      this.field_553 = var1;
      this.field_554 = var2;
   }

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnContentsResponse) void
   public void method_1012(OnContentsResponse var1) throws RemoteException {
      Status var2;
      if(var1.method_5559()) {
         var2 = new Status(-1);
      } else {
         var2 = Status.field_3960;
      }

      this.field_553.method_110(new class_282.class_1599(var2, new class_262(var1.method_5558())));
   }

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDownloadProgressResponse) void
   public void method_1014(OnDownloadProgressResponse var1) throws RemoteException {
      if(this.field_554 != null) {
         this.field_554.onProgress(var1.method_3886(), var1.method_3887());
      }

   }

   // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
   public void method_1024(Status var1) throws RemoteException {
      this.field_553.method_110(new class_282.class_1599(var1, (DriveContents)null));
   }
}
