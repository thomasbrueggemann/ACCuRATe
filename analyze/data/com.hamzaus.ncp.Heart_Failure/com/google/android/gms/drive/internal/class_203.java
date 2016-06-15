package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.drive.internal.class_202;

// $FF: renamed from: com.google.android.gms.drive.internal.aw
public class class_203 extends class_202 {
   // $FF: renamed from: yO com.google.android.gms.common.api.a$d
   private final class_797.class_1206<Status> field_656;

   public class_203(class_797.class_1206<Status> var1) {
      this.field_656 = var1;
   }

   // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
   public void method_835(Status var1) throws RemoteException {
      this.field_656.method_673(var1);
   }

   public void onSuccess() throws RemoteException {
      this.field_656.method_673(Status.field_3880);
   }
}
