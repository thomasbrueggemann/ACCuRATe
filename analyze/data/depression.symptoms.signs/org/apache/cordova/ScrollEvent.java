package org.apache.cordova;

import android.view.View;

public class ScrollEvent {
   // $FF: renamed from: l int
   public int field_6;
   // $FF: renamed from: nl int
   public int field_7;
   // $FF: renamed from: nt int
   public int field_8;
   // $FF: renamed from: t int
   public int field_9;
   private View targetView;

   ScrollEvent(int var1, int var2, int var3, int var4, View var5) {
      this.field_6 = var3;
      int var10000 = this.field_9;
      this.field_7 = var1;
      this.field_8 = var2;
      this.targetView = var5;
   }

   // $FF: renamed from: dl () int
   public int method_0() {
      return this.field_7 - this.field_6;
   }

   // $FF: renamed from: dt () int
   public int method_1() {
      return this.field_8 - this.field_9;
   }

   public View getTargetView() {
      return this.targetView;
   }
}
