package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.class_139;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.lu;
import com.google.android.gms.internal.lz;

// $FF: renamed from: com.google.android.gms.internal.lv
public class class_293 extends jl<lz> implements lu {
   // $FF: renamed from: DZ java.lang.String
   private final String field_611;

   public class_293(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, String[] var6) {
      super(var1, var2, var3, var4, var6);
      this.field_611 = var5;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      var1.method_134(var2, 6587000, this.getContext().getPackageName(), this.field_611, this.hv(), new Bundle());
   }

   // $FF: renamed from: ar (android.os.IBinder) com.google.android.gms.internal.lz
   protected class_139 method_1865(IBinder var1) {
      return class_139.class_1087.method_5623(var1);
   }

   // $FF: renamed from: bK () java.lang.String
   protected String method_1794() {
      return "com.google.android.gms.fitness.GoogleFitnessService.START";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.fitness.internal.IGoogleFitnessService";
   }

   // $FF: renamed from: jM () com.google.android.gms.internal.lz
   public class_139 method_441() throws DeadObjectException {
      return (class_139)this.hw();
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1800(IBinder var1) {
      return this.method_1865(var1);
   }
}
