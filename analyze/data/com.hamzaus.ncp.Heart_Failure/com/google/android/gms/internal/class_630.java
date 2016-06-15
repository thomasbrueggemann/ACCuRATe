package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.panorama.PanoramaApi;

// $FF: renamed from: com.google.android.gms.internal.ki
class class_630 implements PanoramaApi.PanoramaResult {
   private final Intent abl;
   // $FF: renamed from: yw com.google.android.gms.common.api.Status
   private final Status field_3338;

   public class_630(Status var1, Intent var2) {
      this.field_3338 = (Status)class_347.method_2170(var1);
      this.abl = var2;
   }

   public Status getStatus() {
      return this.field_3338;
   }

   public Intent getViewerIntent() {
      return this.abl;
   }
}
