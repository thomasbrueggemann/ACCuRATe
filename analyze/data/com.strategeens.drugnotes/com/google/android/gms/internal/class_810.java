package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.panorama.PanoramaApi;

// $FF: renamed from: com.google.android.gms.internal.on
class class_810 implements PanoramaApi.PanoramaResult {
   // $FF: renamed from: Eb com.google.android.gms.common.api.Status
   private final Status field_3445;
   private final Intent amR;

   public class_810(Status var1, Intent var2) {
      this.field_3445 = (Status)class_335.method_2311(var1);
      this.amR = var2;
   }

   public Status getStatus() {
      return this.field_3445;
   }

   public Intent getViewerIntent() {
      return this.amR;
   }
}
