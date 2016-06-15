package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.class_287;
import com.google.android.gms.internal.class_819;

// $FF: renamed from: com.google.android.gms.internal.ou
public class class_815 implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {
   private class_287 amU;
   private final class_819.class_1659 ane;
   private boolean anf;

   public class_815(class_819.class_1659 var1) {
      this.ane = var1;
      this.amU = null;
      this.anf = true;
   }

   // $FF: renamed from: T (boolean) void
   public void method_4464(boolean var1) {
      this.anf = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ox) void
   public void method_4465(class_287 var1) {
      this.amU = var1;
   }

   public void onConnected(Bundle var1) {
      this.amU.method_1834(false);
      if(this.anf && this.ane != null) {
         this.ane.method_922();
      }

      this.anf = false;
   }

   public void onConnectionFailed(ConnectionResult var1) {
      this.amU.method_1834(true);
      if(this.anf && this.ane != null) {
         if(var1.hasResolution()) {
            this.ane.method_921(var1.getResolution());
         } else {
            this.ane.method_923();
         }
      }

      this.anf = false;
   }

   public void onDisconnected() {
      this.amU.method_1834(true);
   }
}
