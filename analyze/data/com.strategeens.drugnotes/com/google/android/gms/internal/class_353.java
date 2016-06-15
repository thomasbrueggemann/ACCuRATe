package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

// $FF: renamed from: com.google.android.gms.internal.jb
public final class class_353 extends ImageView {
   // $FF: renamed from: Mn android.net.Uri
   private Uri field_1053;
   // $FF: renamed from: Mo int
   private int field_1054;
   // $FF: renamed from: Mp int
   private int field_1055;
   // $FF: renamed from: Mq com.google.android.gms.internal.jb$a
   private class_353.class_1617 field_1056;
   // $FF: renamed from: Mr int
   private int field_1057;
   // $FF: renamed from: Ms float
   private float field_1058;

   // $FF: renamed from: aB (int) void
   public void method_2435(int var1) {
      this.field_1054 = var1;
   }

   // $FF: renamed from: g (android.net.Uri) void
   public void method_2436(Uri var1) {
      this.field_1053 = var1;
   }

   // $FF: renamed from: hj () int
   public int method_2437() {
      return this.field_1054;
   }

   protected void onDraw(Canvas var1) {
      if(this.field_1056 != null) {
         var1.clipPath(this.field_1056.method_890(this.getWidth(), this.getHeight()));
      }

      super.onDraw(var1);
      if(this.field_1055 != 0) {
         var1.drawColor(this.field_1055);
      }

   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      int var3;
      int var4;
      switch(this.field_1057) {
      case 1:
         var4 = this.getMeasuredHeight();
         var3 = (int)((float)var4 * this.field_1058);
         break;
      case 2:
         var3 = this.getMeasuredWidth();
         var4 = (int)((float)var3 / this.field_1058);
         break;
      default:
         return;
      }

      this.setMeasuredDimension(var3, var4);
   }

   public interface class_1617 {
      // $FF: renamed from: g (int, int) android.graphics.Path
      Path method_890(int var1, int var2);
   }
}
