package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.class_132;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.kf;

// $FF: renamed from: com.google.android.gms.internal.kh
public class class_237 extends hc<kf> {
   public class_237(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4) {
      super(var1, var2, var3, var4, (String[])null);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hj, com.google.android.gms.internal.hc$e) void
   protected void method_1448(class_31 var1, class_234.class_911 var2) throws RemoteException {
      Bundle var3 = new Bundle();
      var1.method_154(var2, 5077000, this.getContext().getPackageName(), var3);
   }

   // $FF: renamed from: bj (android.os.IBinder) com.google.android.gms.internal.kf
   public class_132 method_1490(IBinder var1) {
      return class_132.class_1060.method_3095(var1);
   }

   // $FF: renamed from: bp () java.lang.String
   protected String method_1451() {
      return "com.google.android.gms.panorama.service.START";
   }

   // $FF: renamed from: bq () java.lang.String
   protected String method_1452() {
      return "com.google.android.gms.panorama.internal.IPanoramaService";
   }

   // $FF: renamed from: x (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   public IInterface method_1456(IBinder var1) {
      return this.method_1490(var1);
   }
}
