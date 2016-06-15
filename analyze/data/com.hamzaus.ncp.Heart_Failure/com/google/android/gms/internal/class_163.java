package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.internal.aa;
import com.google.android.gms.internal.class_0;
import com.google.android.gms.internal.class_1;
import com.google.android.gms.internal.class_10;
import com.google.android.gms.internal.class_159;
import com.google.android.gms.internal.class_165;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_186;
import com.google.android.gms.internal.class_2;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_373;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.ey;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.ad
public final class class_163 implements OnGlobalLayoutListener, OnScrollChangedListener {
   // $FF: renamed from: lE long
   private static final long field_495;
   // $FF: renamed from: lA android.view.WindowManager
   private final WindowManager field_496;
   // $FF: renamed from: lB android.os.PowerManager
   private final PowerManager field_497;
   // $FF: renamed from: lC android.app.KeyguardManager
   private final KeyguardManager field_498;
   // $FF: renamed from: lD com.google.android.gms.internal.ae
   private class_1 field_499;
   // $FF: renamed from: lF boolean
   private boolean field_500;
   // $FF: renamed from: lG long
   private long field_501;
   // $FF: renamed from: lH boolean
   private boolean field_502;
   // $FF: renamed from: lI android.content.BroadcastReceiver
   private BroadcastReceiver field_503;
   // $FF: renamed from: lJ java.util.HashSet
   private HashSet<aa> field_504;
   // $FF: renamed from: lh boolean
   private boolean field_505;
   // $FF: renamed from: lq java.lang.Object
   private final Object field_506;
   // $FF: renamed from: lt java.lang.ref.WeakReference
   private final WeakReference<eg> field_507;
   // $FF: renamed from: lu java.lang.ref.WeakReference
   private WeakReference<ViewTreeObserver> field_508;
   // $FF: renamed from: lv java.lang.ref.WeakReference
   private final WeakReference<View> field_509;
   // $FF: renamed from: lw com.google.android.gms.internal.ab
   private final class_165 field_510;
   // $FF: renamed from: lx android.content.Context
   private final Context field_511;
   // $FF: renamed from: ly com.google.android.gms.internal.af
   private final class_0 field_512;
   // $FF: renamed from: lz boolean
   private boolean field_513;

   static {
      field_495 = TimeUnit.MILLISECONDS.toNanos(100L);
   }

   public class_163(class_172 var1, class_383 var2) {
      this(var1, var2, var2.field_1716.method_2351(), var2.field_1716, new class_159(var2.field_1716.getContext(), var2.field_1716.method_2351()));
   }

   public class_163(class_172 var1, class_383 var2, class_373 var3, View var4, class_0 var5) {
      this.field_506 = new Object();
      this.field_505 = false;
      this.field_500 = false;
      this.field_501 = Long.MIN_VALUE;
      this.field_504 = new HashSet();
      this.field_507 = new WeakReference(var2);
      this.field_509 = new WeakReference(var4);
      this.field_508 = new WeakReference((Object)null);
      this.field_502 = true;
      this.field_510 = new class_165(Integer.toString(var2.hashCode()), var3, var1.field_569, var2.field_1724);
      this.field_512 = var5;
      this.field_496 = (WindowManager)var4.getContext().getSystemService("window");
      this.field_497 = (PowerManager)var4.getContext().getApplicationContext().getSystemService("power");
      this.field_498 = (KeyguardManager)var4.getContext().getSystemService("keyguard");
      this.field_511 = var4.getContext().getApplicationContext();
      this.method_1225(var5);
      this.field_512.method_0(new class_0.class_1182() {
         // $FF: renamed from: az () void
         public void method_757() {
            class_163.this.field_513 = true;
            class_163.this.method_1242(false);
            class_163.this.method_1229();
         }
      });
      this.method_1238(this.field_512);
      class_370.method_2356("Tracking ad unit: " + this.field_510.method_1249());
   }

   // $FF: renamed from: a (int, android.util.DisplayMetrics) int
   protected int method_1222(int var1, DisplayMetrics var2) {
      float var3 = var2.density;
      return (int)((float)var1 / var3);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.aa) void
   public void method_1223(class_2 var1) {
      this.field_504.add(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ae) void
   public void method_1224(class_1 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.af) void
   protected void method_1225(class_0 var1) {
      var1.method_3("http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ey, java.util.Map) void
   protected void method_1226(ey var1, Map<String, String> var2) {
      this.method_1242(false);
   }

   // $FF: renamed from: a (org.json.JSONObject) void
   protected void method_1227(JSONObject var1) throws JSONException {
      JSONArray var2 = new JSONArray();
      JSONObject var3 = new JSONObject();
      var2.put(var1);
      var3.put("units", var2);
      this.field_512.method_2("AFMA_updateActiveView", var3);
   }

   // $FF: renamed from: a (android.view.View, boolean) boolean
   protected boolean method_1228(View var1, boolean var2) {
      return var1.getVisibility() == 0 && var2 && var1.isShown() && this.field_497.isScreenOn() && !this.field_498.inKeyguardRestrictedInputMode();
   }

   // $FF: renamed from: aq () void
   protected void method_1229() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ar () void
   protected void method_1230() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: as () void
   public void method_1231() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: at () void
   protected void method_1232() {
      if(this.field_499 != null) {
         this.field_499.method_5(this);
      }

   }

   // $FF: renamed from: au () boolean
   public boolean method_1233() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: av () void
   protected void method_1234() {
      View var1 = (View)this.field_509.get();
      if(var1 != null) {
         ViewTreeObserver var2 = (ViewTreeObserver)this.field_508.get();
         ViewTreeObserver var3 = var1.getViewTreeObserver();
         if(var3 != var2) {
            this.field_508 = new WeakReference(var3);
            var3.addOnScrollChangedListener(this);
            var3.addOnGlobalLayoutListener(this);
            return;
         }
      }

   }

   // $FF: renamed from: aw () void
   protected void method_1235() {
      ViewTreeObserver var1 = (ViewTreeObserver)this.field_508.get();
      if(var1 != null && var1.isAlive()) {
         var1.removeOnScrollChangedListener(this);
         var1.removeGlobalOnLayoutListener(this);
      }
   }

   // $FF: renamed from: ax () org.json.JSONObject
   protected JSONObject method_1236() throws JSONException {
      JSONObject var1 = new JSONObject();
      var1.put("afmaVersion", this.field_510.method_1247()).put("activeViewJSON", this.field_510.method_1248()).put("timestamp", TimeUnit.NANOSECONDS.toMillis(System.nanoTime())).put("adFormat", this.field_510.method_1246()).put("hashCode", this.field_510.method_1249());
      return var1;
   }

   // $FF: renamed from: ay () org.json.JSONObject
   protected JSONObject method_1237() throws JSONException {
      JSONObject var1 = this.method_1236();
      var1.put("doneReasonCode", "u");
      return var1;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.af) void
   protected void method_1238(class_0 var1) {
      var1.method_1("/updateActiveView", new class_10() {
         // $FF: renamed from: b (com.google.android.gms.internal.ey, java.util.Map) void
         public void method_19(ey var1, Map<String, String> var2) {
            class_163.this.method_1226(var1, var2);
         }
      });
      var1.method_1("/activeViewPingSent", new class_10() {
         // $FF: renamed from: b (com.google.android.gms.internal.ey, java.util.Map) void
         public void method_19(ey var1, Map<String, String> var2) {
            if(var2.containsKey("pingType") && "unloadPing".equals(var2.get("pingType"))) {
               class_163.this.method_1240(class_163.this.field_512);
               class_370.method_2356("Unregistered GMSG handlers for: " + class_163.this.field_510.method_1249());
            }

         }
      });
      var1.method_1("/visibilityChanged", new class_10() {
         // $FF: renamed from: b (com.google.android.gms.internal.ey, java.util.Map) void
         public void method_19(ey var1, Map<String, String> var2) {
            if(var2.containsKey("isVisible")) {
               boolean var3;
               if(!"1".equals(var2.get("isVisible")) && !"true".equals(var2.get("isVisible"))) {
                  var3 = false;
               } else {
                  var3 = true;
               }

               Boolean var4 = Boolean.valueOf(var3);
               class_163.this.method_1241(var4.booleanValue());
            }
         }
      });
      var1.method_1("/viewabilityChanged", class_186.field_592);
   }

   // $FF: renamed from: c (android.view.View) org.json.JSONObject
   protected JSONObject method_1239(View var1) throws JSONException {
      int[] var2 = new int[2];
      int[] var3 = new int[2];
      var1.getLocationOnScreen(var2);
      var1.getLocationInWindow(var3);
      JSONObject var4 = this.method_1236();
      DisplayMetrics var5 = var1.getContext().getResources().getDisplayMetrics();
      Rect var6 = new Rect();
      var6.left = var2[0];
      var6.top = var2[1];
      var6.right = var6.left + var1.getWidth();
      var6.bottom = var6.top + var1.getHeight();
      Rect var7 = new Rect();
      var7.right = this.field_496.getDefaultDisplay().getWidth();
      var7.bottom = this.field_496.getDefaultDisplay().getHeight();
      Rect var8 = new Rect();
      boolean var9 = var1.getGlobalVisibleRect(var8, (Point)null);
      Rect var10 = new Rect();
      var1.getLocalVisibleRect(var10);
      var4.put("viewBox", (new JSONObject()).put("top", this.method_1222(var7.top, var5)).put("bottom", this.method_1222(var7.bottom, var5)).put("left", this.method_1222(var7.left, var5)).put("right", this.method_1222(var7.right, var5))).put("adBox", (new JSONObject()).put("top", this.method_1222(var6.top, var5)).put("bottom", this.method_1222(var6.bottom, var5)).put("left", this.method_1222(var6.left, var5)).put("right", this.method_1222(var6.right, var5))).put("globalVisibleBox", (new JSONObject()).put("top", this.method_1222(var8.top, var5)).put("bottom", this.method_1222(var8.bottom, var5)).put("left", this.method_1222(var8.left, var5)).put("right", this.method_1222(var8.right, var5))).put("localVisibleBox", (new JSONObject()).put("top", this.method_1222(var10.top, var5)).put("bottom", this.method_1222(var10.bottom, var5)).put("left", this.method_1222(var10.left, var5)).put("right", this.method_1222(var10.right, var5))).put("screenDensity", (double)var5.density).put("isVisible", this.method_1228(var1, var9)).put("isStopped", this.field_500).put("isPaused", this.field_505);
      return var4;
   }

   // $FF: renamed from: c (com.google.android.gms.internal.af) void
   protected void method_1240(class_0 var1) {
      var1.method_4("/viewabilityChanged");
      var1.method_4("/visibilityChanged");
      var1.method_4("/activeViewPingSent");
      var1.method_4("/updateActiveView");
   }

   // $FF: renamed from: d (boolean) void
   protected void method_1241(boolean var1) {
      Iterator var2 = this.field_504.iterator();

      while(var2.hasNext()) {
         ((class_2)var2.next()).method_6(this, var1);
      }

   }

   // $FF: renamed from: e (boolean) void
   protected void method_1242(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public void onGlobalLayout() {
      this.method_1242(false);
   }

   public void onScrollChanged() {
      this.method_1242(true);
   }

   public void pause() {
      // $FF: Couldn't be decompiled
   }

   public void resume() {
      // $FF: Couldn't be decompiled
   }

   public void stop() {
      // $FF: Couldn't be decompiled
   }
}
