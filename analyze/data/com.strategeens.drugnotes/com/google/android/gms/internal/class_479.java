package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gu;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.di
@ey
public class class_479 {
   // $FF: renamed from: rk java.util.Set
   static final Set<String> field_1650 = new HashSet(Arrays.asList(new String[]{"top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"}));
   // $FF: renamed from: li int
   private int field_1651 = -1;
   // $FF: renamed from: lj int
   private int field_1652 = -1;
   private final Context mContext;
   // $FF: renamed from: mo com.google.android.gms.internal.gu
   private final class_371 field_1653;
   // $FF: renamed from: rd java.util.Map
   private final Map<String, String> field_1654;
   // $FF: renamed from: rl int
   private int field_1655 = 0;
   // $FF: renamed from: rm int
   private int field_1656 = 0;
   // $FF: renamed from: rn boolean
   private boolean field_1657 = true;
   // $FF: renamed from: ro java.lang.String
   private String field_1658 = "top-right";

   public class_479(gu var1, Map<String, String> var2) {
      this.field_1653 = var1;
      this.field_1654 = var2;
      this.mContext = var1.method_2536();
   }

   // $FF: renamed from: bQ () void
   private void method_3020() {
      int[] var1 = class_375.method_2581(this.mContext);
      if(!TextUtils.isEmpty((CharSequence)this.field_1654.get("width"))) {
         int var4 = class_375.method_2547((String)this.field_1654.get("width"));
         if(this.method_3021(var4, var1[0])) {
            this.field_1651 = var4;
         }
      }

      if(!TextUtils.isEmpty((CharSequence)this.field_1654.get("height"))) {
         int var3 = class_375.method_2547((String)this.field_1654.get("height"));
         if(this.method_3025(var3, var1[1])) {
            this.field_1652 = var3;
         }
      }

      if(!TextUtils.isEmpty((CharSequence)this.field_1654.get("offsetX"))) {
         this.field_1655 = class_375.method_2547((String)this.field_1654.get("offsetX"));
      }

      if(!TextUtils.isEmpty((CharSequence)this.field_1654.get("offsetY"))) {
         this.field_1656 = class_375.method_2547((String)this.field_1654.get("offsetY"));
      }

      if(!TextUtils.isEmpty((CharSequence)this.field_1654.get("allowOffscreen"))) {
         this.field_1657 = Boolean.parseBoolean((String)this.field_1654.get("allowOffscreen"));
      }

      String var2 = (String)this.field_1654.get("customClosePosition");
      if(!TextUtils.isEmpty(var2) && field_1650.contains(var2)) {
         this.field_1658 = var2;
      }

   }

   // $FF: renamed from: b (int, int) boolean
   boolean method_3021(int var1, int var2) {
      return var1 >= 50 && var1 < var2;
   }

   // $FF: renamed from: bR () boolean
   boolean method_3022() {
      return this.field_1651 > -1 && this.field_1652 > -1;
   }

   // $FF: renamed from: bS () void
   void method_3023() {
      try {
         JSONObject var2 = (new JSONObject()).put("x", this.field_1655).put("y", this.field_1656).put("width", this.field_1651).put("height", this.field_1652);
         this.field_1653.method_2526("onSizeChanged", var2);
      } catch (JSONException var3) {
         class_368.method_2508("Error occured while dispatching size change.", var3);
      }
   }

   // $FF: renamed from: bT () void
   void method_3024() {
      try {
         JSONObject var2 = (new JSONObject()).put("state", "resized");
         this.field_1653.method_2526("onStateChanged", var2);
      } catch (JSONException var3) {
         class_368.method_2508("Error occured while dispatching state change.", var3);
      }
   }

   // $FF: renamed from: c (int, int) boolean
   boolean method_3025(int var1, int var2) {
      return var1 >= 50 && var1 < var2;
   }

   public void execute() {
      class_368.method_2504("PLEASE IMPLEMENT mraid.resize()");
      if(this.mContext == null) {
         class_368.method_2506("Not an activity context. Cannot resize.");
      } else if(this.field_1653.method_2525().field_447) {
         class_368.method_2506("Is interstitial. Cannot resize an interstitial.");
      } else if(this.field_1653.method_2535()) {
         class_368.method_2506("Is expanded. Cannot resize an expanded banner.");
      } else {
         this.method_3020();
         if(!this.method_3022()) {
            class_368.method_2506("Invalid width and height options. Cannot resize.");
         } else {
            WindowManager var1 = (WindowManager)this.mContext.getSystemService("window");
            DisplayMetrics var2 = new DisplayMetrics();
            var1.getDefaultDisplay().getMetrics(var2);
            int var3 = 16 + class_367.method_2495(var2, this.field_1651);
            int var4 = 16 + class_367.method_2495(var2, this.field_1652);
            ViewParent var5 = this.field_1653.getParent();
            if(var5 != null && var5 instanceof ViewGroup) {
               ((ViewGroup)var5).removeView(this.field_1653);
            }

            LinearLayout var6 = new LinearLayout(this.mContext);
            var6.setBackgroundColor(0);
            PopupWindow var7 = new PopupWindow(this.mContext);
            var7.setHeight(var4);
            var7.setWidth(var3);
            boolean var8;
            if(!this.field_1657) {
               var8 = true;
            } else {
               var8 = false;
            }

            var7.setClippingEnabled(var8);
            var7.setContentView(var6);
            var6.addView(this.field_1653, -1, -1);
            var7.showAtLocation(((Activity)this.mContext).getWindow().getDecorView(), 0, this.field_1655, this.field_1656);
            this.field_1653.method_2521(new class_237(this.mContext, new AdSize(this.field_1651, this.field_1652)));
            this.method_3023();
            this.method_3024();
         }
      }
   }
}
