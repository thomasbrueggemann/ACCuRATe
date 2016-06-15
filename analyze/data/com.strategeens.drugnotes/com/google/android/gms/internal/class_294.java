package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.class_40;
import com.google.android.gms.internal.cm;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.jl;

// $FF: renamed from: com.google.android.gms.internal.cl
@ey
public class class_294 extends jl<cm> {
   // $FF: renamed from: qg int
   final int field_623;

   public class_294(Context var1, GoogleApiClient.ConnectionCallbacks var2, GoogleApiClient.OnConnectionFailedListener var3, int var4) {
      super(var1, var1.getMainLooper(), var2, var3, new String[0]);
      this.field_623 = var4;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      Bundle var3 = new Bundle();
      var1.method_151(var2, this.field_623, this.getContext().getPackageName(), var3);
   }

   // $FF: renamed from: bK () java.lang.String
   protected String method_1794() {
      return "com.google.android.gms.ads.gservice.START";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.ads.internal.gservice.IGservicesValueService";
   }

   // $FF: renamed from: bM () com.google.android.gms.internal.cm
   public class_40 method_2016() throws DeadObjectException {
      return (class_40)super.method_1799();
   }

   // $FF: renamed from: k (android.os.IBinder) com.google.android.gms.internal.cm
   protected class_40 method_2017(IBinder var1) {
      return class_40.class_1167.method_3041(var1);
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1800(IBinder var1) {
      return this.method_2017(var1);
   }
}
