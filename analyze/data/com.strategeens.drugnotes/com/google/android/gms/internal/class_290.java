package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.class_145;
import com.google.android.gms.internal.class_147;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.ni;
import com.google.android.gms.internal.np;

// $FF: renamed from: com.google.android.gms.internal.nc
public class class_290 extends jl<ni> {
   // $FF: renamed from: Ee com.google.android.gms.internal.np
   protected final np<ni> field_610 = new class_145() {
      // $FF: renamed from: dS () void
      public void method_769() {
         class_290.this.dS();
      }

      // $FF: renamed from: hw () android.os.IInterface
      // $FF: synthetic method
      public IInterface method_770() throws DeadObjectException {
         return this.method_4759();
      }

      // $FF: renamed from: nh () com.google.android.gms.internal.ni
      public class_147 method_4759() throws DeadObjectException {
         return (class_147)class_290.this.hw();
      }
   };
   private final String agD;

   public class_290(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5) {
      super(var1, var2, var3, var4, new String[0]);
      this.agD = var5;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      Bundle var3 = new Bundle();
      var3.putString("client_name", this.agD);
      var1.method_147(var2, 6587000, this.getContext().getPackageName(), var3);
   }

   // $FF: renamed from: aM (android.os.IBinder) com.google.android.gms.internal.ni
   protected class_147 method_1851(IBinder var1) {
      return class_147.class_1065.method_1608(var1);
   }

   // $FF: renamed from: bK () java.lang.String
   protected String method_1794() {
      return "com.google.android.location.internal.GoogleLocationManagerService.START";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1800(IBinder var1) {
      return this.method_1851(var1);
   }
}
