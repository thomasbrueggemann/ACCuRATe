package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.internal.class_356;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.class_376;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.class_462;
import com.google.android.gms.internal.class_465;
import com.google.android.gms.internal.class_466;
import com.google.android.gms.internal.class_49;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.internal.class_557;
import com.google.android.gms.internal.class_67;
import com.google.android.gms.internal.class_712;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.dp
@ey
public class class_464 extends class_52.class_1202 {
   // $FF: renamed from: rL int
   private static final int field_1570 = Color.argb(0, 0, 0, 0);
   // $FF: renamed from: mo com.google.android.gms.internal.gu
   private class_371 field_1571;
   // $FF: renamed from: nB android.app.Activity
   private final Activity field_1572;
   // $FF: renamed from: rM com.google.android.gms.internal.dr
   private class_462 field_1573;
   // $FF: renamed from: rN com.google.android.gms.internal.dt
   private class_466 field_1574;
   // $FF: renamed from: rO com.google.android.gms.internal.dp$c
   private class_464.class_1547 field_1575;
   // $FF: renamed from: rP com.google.android.gms.internal.du
   private class_465 field_1576;
   // $FF: renamed from: rQ boolean
   private boolean field_1577;
   // $FF: renamed from: rR boolean
   private boolean field_1578 = false;
   // $FF: renamed from: rS android.widget.FrameLayout
   private FrameLayout field_1579;
   // $FF: renamed from: rT android.webkit.WebChromeClient.CustomViewCallback
   private CustomViewCallback field_1580;
   // $FF: renamed from: rU boolean
   private boolean field_1581 = false;
   // $FF: renamed from: rV boolean
   private boolean field_1582 = false;
   // $FF: renamed from: rW boolean
   private boolean field_1583 = false;
   // $FF: renamed from: rX android.widget.RelativeLayout
   private RelativeLayout field_1584;

   public class_464(Activity var1) {
      this.field_1572 = var1;
   }

   // $FF: renamed from: a (int, int, int, int) android.widget.RelativeLayout.LayoutParams
   private static LayoutParams method_2948(int var0, int var1, int var2, int var3) {
      LayoutParams var4 = new LayoutParams(var2, var3);
      var4.setMargins(var0, var1, 0, 0);
      var4.addRule(10);
      var4.addRule(9);
      return var4;
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.dr) void
   public static void method_2949(Context var0, class_462 var1) {
      Intent var2 = new Intent();
      var2.setClassName(var0, "com.google.android.gms.ads.AdActivity");
      var2.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", var1.field_1555.field_1124);
      class_462.method_2936(var2, var1);
      if(!class_712.method_4184()) {
         var2.addFlags(524288);
      }

      if(!(var0 instanceof Activity)) {
         var2.addFlags(268435456);
      }

      var0.startActivity(var2);
   }

   // $FF: renamed from: X () void
   public void method_220() {
      this.field_1577 = true;
   }

   // $FF: renamed from: a (android.view.View, android.webkit.WebChromeClient.CustomViewCallback) void
   public void method_2950(View var1, CustomViewCallback var2) {
      this.field_1579 = new FrameLayout(this.field_1572);
      this.field_1579.setBackgroundColor(-16777216);
      this.field_1579.addView(var1, -1, -1);
      this.field_1572.setContentView(this.field_1579);
      this.method_220();
      this.field_1580 = var2;
      this.field_1578 = true;
   }

   // $FF: renamed from: b (int, int, int, int) void
   public void method_2951(int var1, int var2, int var3, int var4) {
      if(this.field_1574 != null) {
         this.field_1574.setLayoutParams(method_2948(var1, var2, var3, var4));
      }

   }

   // $FF: renamed from: c (int, int, int, int) void
   public void method_2952(int var1, int var2, int var3, int var4) {
      if(this.field_1574 == null) {
         this.field_1574 = new class_466(this.field_1572, this.field_1571);
         this.field_1584.addView(this.field_1574, 0, method_2948(var1, var2, var3, var4));
         this.field_1571.method_2531().method_2445(false);
      }

   }

   // $FF: renamed from: ce () com.google.android.gms.internal.dt
   public class_466 method_2953() {
      return this.field_1574;
   }

   // $FF: renamed from: cf () void
   public void method_2954() {
      if(this.field_1573 != null && this.field_1578) {
         this.setRequestedOrientation(this.field_1573.orientation);
      }

      if(this.field_1579 != null) {
         this.field_1572.setContentView(this.field_1584);
         this.method_220();
         this.field_1579.removeAllViews();
         this.field_1579 = null;
      }

      if(this.field_1580 != null) {
         this.field_1580.onCustomViewHidden();
         this.field_1580 = null;
      }

      this.field_1578 = false;
   }

   // $FF: renamed from: cg () void
   public void method_2955() {
      this.field_1584.removeView(this.field_1576);
      this.method_2959(true);
   }

   // $FF: renamed from: ch () void
   void method_2956() {
      if(this.field_1572.isFinishing() && !this.field_1582) {
         this.field_1582 = true;
         if(this.field_1572.isFinishing()) {
            if(this.field_1571 != null) {
               this.method_2958();
               this.field_1584.removeView(this.field_1571);
               if(this.field_1575 != null) {
                  this.field_1571.method_2538(false);
                  this.field_1575.field_4377.addView(this.field_1571, this.field_1575.index, this.field_1575.field_4376);
               }
            }

            if(this.field_1573 != null && this.field_1573.field_1559 != null) {
               this.field_1573.field_1559.method_216();
               return;
            }
         }
      }

   }

   // $FF: renamed from: ci () void
   void method_2957() {
      this.field_1571.method_2528();
   }

   // $FF: renamed from: cj () void
   void method_2958() {
      this.field_1571.method_2529();
   }

   public void close() {
      this.field_1572.finish();
   }

   public void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public void onDestroy() {
      if(this.field_1574 != null) {
         this.field_1574.destroy();
      }

      if(this.field_1571 != null) {
         this.field_1584.removeView(this.field_1571);
      }

      this.method_2956();
   }

   public void onPause() {
      if(this.field_1574 != null) {
         this.field_1574.pause();
      }

      this.method_2954();
      if(this.field_1571 != null && (!this.field_1572.isFinishing() || this.field_1575 == null)) {
         class_375.method_2560(this.field_1571);
      }

      this.method_2956();
   }

   public void onRestart() {
   }

   public void onResume() {
      if(this.field_1573 != null && this.field_1573.field_1566 == 4) {
         if(this.field_1581) {
            this.field_1572.finish();
         } else {
            this.field_1581 = true;
         }
      }

      if(this.field_1571 != null) {
         class_375.method_2565(this.field_1571);
      }

   }

   public void onSaveInstanceState(Bundle var1) {
      var1.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.field_1581);
   }

   public void onStart() {
   }

   public void onStop() {
      this.method_2956();
   }

   // $FF: renamed from: p (boolean) void
   public void method_2959(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 50;
      } else {
         var2 = 32;
      }

      this.field_1576 = new class_465(this.field_1572, var2);
      LayoutParams var3 = new LayoutParams(-2, -2);
      var3.addRule(10);
      byte var4;
      if(var1) {
         var4 = 11;
      } else {
         var4 = 9;
      }

      var3.addRule(var4);
      this.field_1576.method_2962(this.field_1573.field_1563);
      this.field_1584.addView(this.field_1576, var3);
   }

   // $FF: renamed from: q (boolean) void
   public void method_2960(boolean var1) {
      if(this.field_1576 != null) {
         this.field_1576.method_2962(var1);
      }

   }

   // $FF: renamed from: r (boolean) void
   void method_2961(boolean var1) throws class_464.class_1545 {
      if(!this.field_1577) {
         this.field_1572.requestWindowFeature(1);
      }

      Window var2 = this.field_1572.getWindow();
      if(!this.field_1583 || this.field_1573.field_1569.field_2513) {
         var2.setFlags(1024, 1024);
      }

      this.setRequestedOrientation(this.field_1573.orientation);
      if(VERSION.SDK_INT >= 11) {
         class_368.method_2502("Enabling hardware acceleration on the AdActivity window.");
         class_379.method_2590(var2);
      }

      this.field_1584 = new class_464.class_1546(this.field_1572, this.field_1573.field_1568);
      if(!this.field_1583) {
         this.field_1584.setBackgroundColor(-16777216);
      } else {
         this.field_1584.setBackgroundColor(field_1570);
      }

      this.field_1572.setContentView(this.field_1584);
      this.method_220();
      boolean var3 = this.field_1573.field_1560.method_2531().method_2457();
      if(var1) {
         this.field_1571 = class_371.method_2515(this.field_1572, this.field_1573.field_1560.method_2525(), true, var3, (class_557)null, this.field_1573.field_1555);
         this.field_1571.method_2531().method_2450((class_67)null, (class_49)null, this.field_1573.field_1561, this.field_1573.field_1565, true, this.field_1573.field_1567, this.field_1573.field_1560.method_2531().method_2456());
         this.field_1571.method_2531().method_2448(new class_356.class_1535() {
            // $FF: renamed from: a (com.google.android.gms.internal.gu) void
            public void method_729(class_371 var1) {
               var1.method_2528();
            }
         });
         if(this.field_1573.field_1556 != null) {
            this.field_1571.loadUrl(this.field_1573.field_1556);
         } else {
            if(this.field_1573.field_1564 == null) {
               throw new class_464.class_1545("No URL or HTML to display in ad overlay.");
            }

            this.field_1571.loadDataWithBaseURL(this.field_1573.field_1562, this.field_1573.field_1564, "text/html", "UTF-8", (String)null);
         }
      } else {
         this.field_1571 = this.field_1573.field_1560;
         this.field_1571.setContext(this.field_1572);
      }

      this.field_1571.method_2522(this);
      ViewParent var4 = this.field_1571.getParent();
      if(var4 != null && var4 instanceof ViewGroup) {
         ((ViewGroup)var4).removeView(this.field_1571);
      }

      if(this.field_1583) {
         this.field_1571.setBackgroundColor(field_1570);
      }

      this.field_1584.addView(this.field_1571, -1, -1);
      if(!var1) {
         this.method_2957();
      }

      this.method_2959(var3);
      if(this.field_1571.method_2532()) {
         this.method_2960(true);
      }

   }

   public void setRequestedOrientation(int var1) {
      this.field_1572.setRequestedOrientation(var1);
   }

   @ey
   private static final class class_1545 extends Exception {
      public class_1545(String var1) {
         super(var1);
      }
   }

   @ey
   private static final class class_1546 extends RelativeLayout {
      // $FF: renamed from: lJ com.google.android.gms.internal.gl
      private final class_376 field_4378;

      public class_1546(Context var1, String var2) {
         super(var1);
         this.field_4378 = new class_376(var1, var2);
      }

      public boolean onInterceptTouchEvent(MotionEvent var1) {
         this.field_4378.method_2587(var1);
         return false;
      }
   }

   @ey
   private static final class class_1547 {
      public final int index;
      // $FF: renamed from: rZ android.view.ViewGroup.LayoutParams
      public final android.view.ViewGroup.LayoutParams field_4376;
      // $FF: renamed from: sa android.view.ViewGroup
      public final ViewGroup field_4377;

      public class_1547(class_371 var1) throws class_464.class_1545 {
         this.field_4376 = var1.getLayoutParams();
         ViewParent var2 = var1.getParent();
         if(var2 instanceof ViewGroup) {
            this.field_4377 = (ViewGroup)var2;
            this.index = this.field_4377.indexOfChild(var1);
            this.field_4377.removeView(var1);
            var1.method_2538(true);
         } else {
            throw new class_464.class_1545("Could not get the parent of the WebView for an overlay.");
         }
      }
   }
}
