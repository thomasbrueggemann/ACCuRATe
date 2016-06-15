package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

// $FF: renamed from: com.google.android.gms.internal.gw
public final class class_319 extends ImageView {
   // $FF: renamed from: FL android.net.Uri
   private Uri field_1284;
   // $FF: renamed from: FM int
   private int field_1285;
   // $FF: renamed from: FN int
   private int field_1286;
   // $FF: renamed from: FO com.google.android.gms.internal.gw$a
   private class_319.class_1248 field_1287;

   // $FF: renamed from: al (int) void
   public void method_2043(int var1) {
      this.field_1285 = var1;
   }

   // $FF: renamed from: f (android.net.Uri) void
   public void method_2044(Uri var1) {
      this.field_1284 = var1;
   }

   // $FF: renamed from: fd () int
   public int method_2045() {
      return this.field_1285;
   }

   protected void onDraw(Canvas var1) {
      if(this.field_1287 != null) {
         var1.clipPath(this.field_1287.method_713(this.getWidth(), this.getHeight()));
      }

      super.onDraw(var1);
      if(this.field_1286 != 0) {
         var1.drawColor(this.field_1286);
      }

   }

   public interface class_1248 {
      // $FF: renamed from: d (int, int) android.graphics.Path
      Path method_713(int var1, int var2);
   }
}
