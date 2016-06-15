package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.class_38;
import com.google.android.gms.internal.fv;
import com.google.android.gms.internal.hc;

// $FF: renamed from: com.google.android.gms.internal.fy
public class class_240 extends hc<fv> {
   public class_240(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4) {
      super(var1, var2, var3, var4, new String[0]);
   }

   // $FF: renamed from: C (android.os.IBinder) com.google.android.gms.internal.fv
   protected class_38 method_1649(IBinder var1) {
      return class_38.class_1071.method_3660(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hj, com.google.android.gms.internal.hc$e) void
   protected void method_1448(class_31 var1, class_234.class_911 var2) throws RemoteException {
      var1.method_163(var2, 5077000, this.getContext().getPackageName());
   }

   // $FF: renamed from: bp () java.lang.String
   protected String method_1451() {
      return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
   }

   // $FF: renamed from: bq () java.lang.String
   protected String method_1452() {
      return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
   }

   // $FF: renamed from: dM () com.google.android.gms.internal.fv
   public class_38 method_1650() {
      return (class_38)this.fo();
   }

   // $FF: renamed from: x (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1456(IBinder var1) {
      return this.method_1649(var1);
   }
}
