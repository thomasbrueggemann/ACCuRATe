package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_27;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.hu;
import com.google.android.gms.internal.jl;

// $FF: renamed from: com.google.android.gms.internal.hx
public class class_296 extends jl<hu> {
   public class_296(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4) {
      super(var1, var2, var3, var4, new String[0]);
   }

   // $FF: renamed from: G (android.os.IBinder) com.google.android.gms.internal.hu
   protected class_27 method_2020(IBinder var1) {
      return class_27.class_1382.method_5428(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      var1.method_139(var2, 6587000, this.getContext().getPackageName());
   }

   // $FF: renamed from: bK () java.lang.String
   protected String method_1794() {
      return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
   }

   // $FF: renamed from: fH () com.google.android.gms.internal.hu
   public class_27 method_2021() throws DeadObjectException {
      return (class_27)this.hw();
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1800(IBinder var1) {
      return this.method_2020(var1);
   }
}
