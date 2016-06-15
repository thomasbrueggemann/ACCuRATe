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
import com.google.android.gms.internal.class_357;
import com.google.android.gms.internal.class_365;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_405;
import com.google.android.gms.internal.class_406;
import com.google.android.gms.internal.class_42;
import com.google.android.gms.internal.class_424;
import com.google.android.gms.internal.class_43;
import com.google.android.gms.internal.class_457;
import com.google.android.gms.internal.class_63;

// $FF: renamed from: com.google.android.gms.internal.cg
public class class_422 extends class_42.class_1039 {
   // $FF: renamed from: od int
   private static final int field_1845 = Color.argb(0, 0, 0, 0);
   // $FF: renamed from: lL com.google.android.gms.internal.ey
   private class_369 field_1846;
   // $FF: renamed from: oe android.app.Activity
   private final Activity field_1847;
   // $FF: renamed from: of com.google.android.gms.internal.ci
   private class_424 field_1848;
   // $FF: renamed from: og com.google.android.gms.internal.ck
   private class_406 field_1849;
   // $FF: renamed from: oh com.google.android.gms.internal.cg$c
   private class_422.class_1155 field_1850;
   // $FF: renamed from: oi com.google.android.gms.internal.cl
   private class_405 field_1851;
   // $FF: renamed from: oj boolean
   private boolean field_1852;
   // $FF: renamed from: ok android.widget.FrameLayout
   private FrameLayout field_1853;
   // $FF: renamed from: ol android.webkit.WebChromeClient.CustomViewCallback
   private CustomViewCallback field_1854;
   // $FF: renamed from: om boolean
   private boolean field_1855 = false;
   // $FF: renamed from: on boolean
   private boolean field_1856 = false;
   // $FF: renamed from: oo boolean
   private boolean field_1857 = false;
   // $FF: renamed from: op android.widget.RelativeLayout
   private RelativeLayout field_1858;

   public class_422(Activity var1) {
      this.field_1847 = var1;
   }

   // $FF: renamed from: a (int, int, int, int) android.widget.RelativeLayout.LayoutParams
   private static LayoutParams method_2554(int var0, int var1, int var2, int var3) {
      LayoutParams var4 = new LayoutParams(var2, var3);
      var4.setMargins(var0, var1, 0, 0);
      var4.addRule(10);
      var4.addRule(9);
      return var4;
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.ci) void
   public static void method_2555(Context var0, class_424 var1) {
      Intent var2 = new Intent();
      var2.setClassName(var0, "com.google.android.gms.ads.AdActivity");
      var2.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", var1.field_1859.field_1610);
      class_424.method_2570(var2, var1);
      var2.addFlags(524288);
      if(!(var0 instanceof Activity)) {
         var2.addFlags(268435456);
      }

      var0.startActivity(var2);
   }

   // $FF: renamed from: aO () void
   private void method_2556() {
      if(this.field_1847.isFinishing() && !this.field_1856) {
         this.field_1856 = true;
         if(this.field_1847.isFinishing()) {
            if(this.field_1846 != null) {
               this.field_1846.method_2346();
               this.field_1858.removeView(this.field_1846);
               if(this.field_1850 != null) {
                  this.field_1846.method_2354(false);
                  this.field_1850.field_3631.addView(this.field_1846, this.field_1850.index, this.field_1850.field_3630);
               }
            }

            if(this.field_1848 != null && this.field_1848.field_1869 != null) {
               this.field_1848.field_1869.method_204();
               return;
            }
         }
      }

   }

   // $FF: renamed from: k (boolean) void
   private void method_2557(boolean var1) throws class_422.class_1153 {
      if(!this.field_1852) {
         this.field_1847.requestWindowFeature(1);
      }

      Window var2 = this.field_1847.getWindow();
      if(!this.field_1857 || this.field_1848.field_1866.field_2734) {
         var2.setFlags(1024, 1024);
      }

      this.setRequestedOrientation(this.field_1848.orientation);
      if(VERSION.SDK_INT >= 11) {
         class_370.method_2363("Enabling hardware acceleration on the AdActivity window.");
         class_356.method_2251(var2);
      }

      this.field_1858 = new class_422.class_1154(this.field_1847, this.field_1848.field_1865);
      if(!this.field_1857) {
         this.field_1858.setBackgroundColor(-16777216);
      } else {
         this.field_1858.setBackgroundColor(field_1845);
      }

      this.field_1847.setContentView(this.field_1858);
      this.method_203();
      boolean var3 = this.field_1848.field_1870.method_2349().method_2330();
      if(var1) {
         this.field_1846 = class_369.method_2333(this.field_1847, this.field_1848.field_1870.method_2338(), true, var3, (class_457)null, this.field_1848.field_1859);
         this.field_1846.method_2349().method_2323((class_63)null, (class_43)null, this.field_1848.field_1871, this.field_1848.field_1862, true, this.field_1848.field_1864);
         this.field_1846.method_2349().method_2322(new class_367.class_1262() {
            // $FF: renamed from: a (com.google.android.gms.internal.ey) void
            public void method_756(class_369 var1) {
               var1.method_2347();
            }
         });
         if(this.field_1848.field_1860 != null) {
            this.field_1846.loadUrl(this.field_1848.field_1860);
         } else {
            if(this.field_1848.field_1861 == null) {
               throw new class_422.class_1153("No URL or HTML to display in ad overlay.");
            }

            this.field_1846.loadDataWithBaseURL(this.field_1848.field_1872, this.field_1848.field_1861, "text/html", "UTF-8", (String)null);
         }
      } else {
         this.field_1846 = this.field_1848.field_1870;
         this.field_1846.setContext(this.field_1847);
      }

      this.field_1846.method_2341(this);
      ViewParent var4 = this.field_1846.getParent();
      if(var4 != null && var4 instanceof ViewGroup) {
         ((ViewGroup)var4).removeView(this.field_1846);
      }

      if(this.field_1857) {
         this.field_1846.setBackgroundColor(field_1845);
      }

      this.field_1858.addView(this.field_1846, -1, -1);
      if(!var1) {
         this.field_1846.method_2347();
      }

      this.method_2564(var3);
   }

   // $FF: renamed from: N () void
   public void method_203() {
      this.field_1852 = true;
   }

   // $FF: renamed from: a (android.view.View, android.webkit.WebChromeClient.CustomViewCallback) void
   public void method_2558(View var1, CustomViewCallback var2) {
      this.field_1853 = new FrameLayout(this.field_1847);
      this.field_1853.setBackgroundColor(-16777216);
      this.field_1853.addView(var1, -1, -1);
      this.field_1847.setContentView(this.field_1853);
      this.method_203();
      this.field_1854 = var2;
   }

   // $FF: renamed from: aL () com.google.android.gms.internal.ck
   public class_406 method_2559() {
      return this.field_1849;
   }

   // $FF: renamed from: aM () void
   public void method_2560() {
      if(this.field_1848 != null) {
         this.setRequestedOrientation(this.field_1848.orientation);
      }

      if(this.field_1853 != null) {
         this.field_1847.setContentView(this.field_1858);
         this.method_203();
         this.field_1853.removeAllViews();
         this.field_1853 = null;
      }

      if(this.field_1854 != null) {
         this.field_1854.onCustomViewHidden();
         this.field_1854 = null;
      }

   }

   // $FF: renamed from: aN () void
   public void method_2561() {
      this.field_1858.removeView(this.field_1851);
      this.method_2564(true);
   }

   // $FF: renamed from: b (int, int, int, int) void
   public void method_2562(int var1, int var2, int var3, int var4) {
      if(this.field_1849 != null) {
         this.field_1849.setLayoutParams(method_2554(var1, var2, var3, var4));
      }

   }

   // $FF: renamed from: c (int, int, int, int) void
   public void method_2563(int var1, int var2, int var3, int var4) {
      if(this.field_1849 == null) {
         this.field_1849 = new class_406(this.field_1847, this.field_1846);
         this.field_1858.addView(this.field_1849, 0, method_2554(var1, var2, var3, var4));
         this.field_1846.method_2349().method_2331(false);
      }

   }

   public void close() {
      this.field_1847.finish();
   }

   // $FF: renamed from: i (boolean) void
   public void method_2564(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 50;
      } else {
         var2 = 32;
      }

      this.field_1851 = new class_405(this.field_1847, var2);
      LayoutParams var3 = new LayoutParams(-2, -2);
      var3.addRule(10);
      byte var4;
      if(var1) {
         var4 = 11;
      } else {
         var4 = 9;
      }

      var3.addRule(var4);
      this.field_1851.method_2493(this.field_1848.field_1873);
      this.field_1858.addView(this.field_1851, var3);
   }

   // $FF: renamed from: j (boolean) void
   public void method_2565(boolean var1) {
      if(this.field_1851 != null) {
         this.field_1851.method_2493(var1);
      }

   }

   public void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public void onDestroy() {
      if(this.field_1849 != null) {
         this.field_1849.destroy();
      }

      if(this.field_1846 != null) {
         this.field_1858.removeView(this.field_1846);
      }

      this.method_2556();
   }

   public void onPause() {
      if(this.field_1849 != null) {
         this.field_1849.pause();
      }

      this.method_2560();
      if(this.field_1846 != null && (!this.field_1847.isFinishing() || this.field_1850 == null)) {
         class_365.method_2295(this.field_1846);
      }

      this.method_2556();
   }

   public void onRestart() {
   }

   public void onResume() {
      if(this.field_1848 != null && this.field_1848.field_1863 == 4) {
         if(this.field_1855) {
            this.field_1847.finish();
         } else {
            this.field_1855 = true;
         }
      }

      if(this.field_1846 != null) {
         class_365.method_2302(this.field_1846);
      }

   }

   public void onSaveInstanceState(Bundle var1) {
      var1.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.field_1855);
   }

   public void onStart() {
   }

   public void onStop() {
      this.method_2556();
   }

   public void setRequestedOrientation(int var1) {
      this.field_1847.setRequestedOrientation(var1);
   }

   private static final class class_1153 extends Exception {
      public class_1153(String var1) {
         super(var1);
      }
   }

   private static final class class_1154 extends RelativeLayout {
      // $FF: renamed from: kG com.google.android.gms.internal.eq
      private final class_357 field_3629;

      public class_1154(Context var1, String var2) {
         super(var1);
         this.field_3629 = new class_357(var1, var2);
      }

      public boolean onInterceptTouchEvent(MotionEvent var1) {
         this.field_3629.method_2258(var1);
         return false;
      }
   }

   private static final class class_1155 {
      public final int index;
      // $FF: renamed from: or android.view.ViewGroup.LayoutParams
      public final android.view.ViewGroup.LayoutParams field_3630;
      // $FF: renamed from: os android.view.ViewGroup
      public final ViewGroup field_3631;

      public class_1155(class_369 var1) throws class_422.class_1153 {
         this.field_3630 = var1.getLayoutParams();
         ViewParent var2 = var1.getParent();
         if(var2 instanceof ViewGroup) {
            this.field_3631 = (ViewGroup)var2;
            this.index = this.field_3631.indexOfChild(var1);
            this.field_3631.removeView(var1);
            var1.method_2354(true);
         } else {
            throw new class_422.class_1153("Could not get the parent of the WebView for an overlay.");
         }
      }
   }
}
