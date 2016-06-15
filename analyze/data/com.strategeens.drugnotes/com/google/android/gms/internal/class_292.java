package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.class_142;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.ki;

// $FF: renamed from: com.google.android.gms.internal.kg
public class class_292 extends jl<ki> {
   public class_292(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String... var5) {
      super(var1, var2, var3, var4, var5);
   }

   // $FF: renamed from: T (android.os.IBinder) com.google.android.gms.internal.ki
   protected class_142 method_1864(IBinder var1) {
      return class_142.class_1146.method_5781(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      var1.method_156(var2, 6587000, this.getContext().getPackageName());
   }

   // $FF: renamed from: bK () java.lang.String
   public String method_1794() {
      return "com.google.android.gms.common.service.START";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.common.internal.service.ICommonService";
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1800(IBinder var1) {
      return this.method_1864(var1);
   }
}
