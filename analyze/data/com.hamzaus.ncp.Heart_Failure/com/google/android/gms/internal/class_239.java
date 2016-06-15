package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.class_44;
import com.google.android.gms.internal.dx;
import com.google.android.gms.internal.hc;

// $FF: renamed from: com.google.android.gms.internal.ds
public class class_239 extends hc<dx> {
   // $FF: renamed from: pT int
   final int field_772;

   public class_239(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3, int var4) {
      super(var1, var2, var3, new String[0]);
      this.field_772 = var4;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hj, com.google.android.gms.internal.hc$e) void
   protected void method_1448(class_31 var1, class_234.class_911 var2) throws RemoteException {
      Bundle var3 = new Bundle();
      var1.method_175(var2, this.field_772, this.getContext().getPackageName(), var3);
   }

   // $FF: renamed from: bp () java.lang.String
   protected String method_1451() {
      return "com.google.android.gms.ads.service.START";
   }

   // $FF: renamed from: bq () java.lang.String
   protected String method_1452() {
      return "com.google.android.gms.ads.internal.request.IAdRequestService";
   }

   // $FF: renamed from: br () com.google.android.gms.internal.dx
   public class_44 method_1647() {
      return (class_44)super.method_1455();
   }

   // $FF: renamed from: w (android.os.IBinder) com.google.android.gms.internal.dx
   protected class_44 method_1648(IBinder var1) {
      return class_44.class_885.method_2609(var1);
   }

   // $FF: renamed from: x (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1456(IBinder var1) {
      return this.method_1648(var1);
   }
}
