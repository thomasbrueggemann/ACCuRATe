package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.internal.class_267;

// $FF: renamed from: com.google.android.gms.drive.internal.bg
public class class_268 extends class_267 {
   // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
   private final BaseImplementation.class_1058<Status> field_552;

   public class_268(BaseImplementation.class_1058<Status> var1) {
      this.field_552 = var1;
   }

   // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
   public void method_1024(Status var1) throws RemoteException {
      this.field_552.method_110(var1);
   }

   public void onSuccess() throws RemoteException {
      this.field_552.method_110(Status.field_3960);
   }
}
