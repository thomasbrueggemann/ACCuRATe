package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.class_163;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.ok;

// $FF: renamed from: com.google.android.gms.internal.om
public class class_286 extends jl<ok> {
   public class_286(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4) {
      super(var1, var2, var3, var4, (String[])null);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      Bundle var3 = new Bundle();
      var1.method_129(var2, 6587000, this.getContext().getPackageName(), var3);
   }

   // $FF: renamed from: bH (android.os.IBinder) com.google.android.gms.internal.ok
   public class_163 method_1830(IBinder var1) {
      return class_163.class_1067.method_1610(var1);
   }

   // $FF: renamed from: bK () java.lang.String
   protected String method_1794() {
      return "com.google.android.gms.panorama.service.START";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.panorama.internal.IPanoramaService";
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   public IInterface method_1800(IBinder var1) {
      return this.method_1830(var1);
   }
}
