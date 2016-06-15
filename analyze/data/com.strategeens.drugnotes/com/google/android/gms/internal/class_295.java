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
import com.google.android.gms.internal.class_38;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fl;
import com.google.android.gms.internal.jl;

// $FF: renamed from: com.google.android.gms.internal.fg
@ey
public class class_295 extends jl<fl> {
   // $FF: renamed from: qg int
   final int field_624;

   public class_295(Context var1, GoogleApiClient.ConnectionCallbacks var2, GoogleApiClient.OnConnectionFailedListener var3, int var4) {
      super(var1, var1.getMainLooper(), var2, var3, new String[0]);
      this.field_624 = var4;
   }

   // $FF: renamed from: B (android.os.IBinder) com.google.android.gms.internal.fl
   protected class_38 method_2018(IBinder var1) {
      return class_38.class_1388.method_2829(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      Bundle var3 = new Bundle();
      var1.method_151(var2, this.field_624, this.getContext().getPackageName(), var3);
   }

   // $FF: renamed from: bK () java.lang.String
   protected String method_1794() {
      return "com.google.android.gms.ads.service.START";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.ads.internal.request.IAdRequestService";
   }

   // $FF: renamed from: cL () com.google.android.gms.internal.fl
   public class_38 method_2019() throws DeadObjectException {
      return (class_38)super.method_1799();
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1800(IBinder var1) {
      return this.method_2018(var1);
   }
}
