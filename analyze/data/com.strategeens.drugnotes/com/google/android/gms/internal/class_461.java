package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.class_247;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.class_477;
import com.google.android.gms.internal.ey;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.dl
@ey
public class class_461 {
   private final Context mContext;
   // $FF: renamed from: mR android.view.WindowManager
   private final WindowManager field_1544;
   // $FF: renamed from: mo com.google.android.gms.internal.gu
   private final class_371 field_1545;
   // $FF: renamed from: rA int
   int field_1546 = -1;
   // $FF: renamed from: rB int
   int field_1547 = -1;
   // $FF: renamed from: rC int
   private int field_1548;
   // $FF: renamed from: rD int
   private int field_1549 = -1;
   // $FF: renamed from: rE int
   private int field_1550 = -1;
   // $FF: renamed from: rF int[]
   private int[] field_1551 = new int[2];
   // $FF: renamed from: rx com.google.android.gms.internal.bl
   private final class_247 field_1552;
   // $FF: renamed from: ry android.util.DisplayMetrics
   DisplayMetrics field_1553;
   // $FF: renamed from: rz float
   private float field_1554;

   public class_461(class_371 var1, Context var2, class_247 var3) {
      this.field_1545 = var1;
      this.mContext = var2;
      this.field_1552 = var3;
      this.field_1544 = (WindowManager)var2.getSystemService("window");
      this.method_2927();
      this.method_2930();
      this.method_2928();
   }

   // $FF: renamed from: bV () void
   private void method_2927() {
      this.field_1553 = new DisplayMetrics();
      Display var1 = this.field_1544.getDefaultDisplay();
      var1.getMetrics(this.field_1553);
      this.field_1554 = this.field_1553.density;
      this.field_1548 = var1.getRotation();
   }

   // $FF: renamed from: bX () void
   private void method_2928() {
      this.field_1545.getLocationOnScreen(this.field_1551);
      this.field_1545.measure(0, 0);
      float var1 = 160.0F / (float)this.field_1553.densityDpi;
      this.field_1549 = Math.round(var1 * (float)this.field_1545.getMeasuredWidth());
      this.field_1550 = Math.round(var1 * (float)this.field_1545.getMeasuredHeight());
   }

   // $FF: renamed from: cd () com.google.android.gms.internal.dk
   private class_477 method_2929() {
      return (new class_477.class_1508()).method_3917(this.field_1552.method_1621()).method_3916(this.field_1552.method_1622()).method_3918(this.field_1552.method_1625()).method_3919(this.field_1552.method_1623()).method_3920(this.field_1552.method_1624()).method_3915();
   }

   // $FF: renamed from: bW () void
   void method_2930() {
      int var1 = class_375.method_2579(this.mContext);
      float var2 = 160.0F / (float)this.field_1553.densityDpi;
      this.field_1546 = Math.round(var2 * (float)this.field_1553.widthPixels);
      this.field_1547 = Math.round(var2 * (float)(this.field_1553.heightPixels - var1));
   }

   // $FF: renamed from: bY () void
   public void method_2931() {
      this.method_2934();
      this.method_2935();
      this.method_2933();
      this.method_2932();
   }

   // $FF: renamed from: bZ () void
   public void method_2932() {
      if(class_368.method_2511(2)) {
         class_368.method_2504("Dispatching Ready Event.");
      }

      this.field_1545.method_2526("onReadyEventReceived", new JSONObject());
   }

   // $FF: renamed from: ca () void
   public void method_2933() {
      try {
         JSONObject var2 = (new JSONObject()).put("x", this.field_1551[0]).put("y", this.field_1551[1]).put("width", this.field_1549).put("height", this.field_1550);
         this.field_1545.method_2526("onDefaultPositionReceived", var2);
      } catch (JSONException var3) {
         class_368.method_2508("Error occured while dispatching default position.", var3);
      }
   }

   // $FF: renamed from: cb () void
   public void method_2934() {
      try {
         JSONObject var2 = (new JSONObject()).put("width", this.field_1546).put("height", this.field_1547).put("density", (double)this.field_1554).put("rotation", this.field_1548);
         this.field_1545.method_2526("onScreenInfoChanged", var2);
      } catch (JSONException var3) {
         class_368.method_2508("Error occured while obtaining screen information.", var3);
      }
   }

   // $FF: renamed from: cc () void
   public void method_2935() {
      class_477 var1 = this.method_2929();
      this.field_1545.method_2526("onDeviceFeaturesReceived", var1.toJson());
   }
}
