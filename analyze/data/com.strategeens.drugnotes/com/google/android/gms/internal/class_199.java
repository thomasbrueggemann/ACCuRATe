package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.class_0;
import com.google.android.gms.internal.class_1;
import com.google.android.gms.internal.class_2;
import com.google.android.gms.internal.class_206;
import com.google.android.gms.internal.class_230;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_432;
import com.google.android.gms.internal.class_453;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_712;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fy;
import com.google.android.gms.internal.gu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.af
@ey
public final class class_199 implements OnGlobalLayoutListener, OnScrollChangedListener {
   // $FF: renamed from: mH java.lang.Object
   private final Object field_42;
   // $FF: renamed from: mK java.lang.ref.WeakReference
   private final WeakReference<fy> field_43;
   // $FF: renamed from: mL java.lang.ref.WeakReference
   private WeakReference<ViewTreeObserver> field_44;
   // $FF: renamed from: mM java.lang.ref.WeakReference
   private final WeakReference<View> field_45;
   // $FF: renamed from: mN com.google.android.gms.internal.ad
   private final class_206 field_46;
   // $FF: renamed from: mO android.content.Context
   private final Context field_47;
   // $FF: renamed from: mP com.google.android.gms.internal.ah
   private final class_0 field_48;
   // $FF: renamed from: mQ boolean
   private boolean field_49;
   // $FF: renamed from: mR android.view.WindowManager
   private final WindowManager field_50;
   // $FF: renamed from: mS android.os.PowerManager
   private final PowerManager field_51;
   // $FF: renamed from: mT android.app.KeyguardManager
   private final KeyguardManager field_52;
   // $FF: renamed from: mU com.google.android.gms.internal.ag
   private class_1 field_53;
   // $FF: renamed from: mV boolean
   private boolean field_54;
   // $FF: renamed from: mW java.util.concurrent.BlockingQueue
   private final BlockingQueue<Runnable> field_55;
   // $FF: renamed from: mX long
   private long field_56;
   // $FF: renamed from: mY boolean
   private boolean field_57;
   // $FF: renamed from: mZ boolean
   private boolean field_58;
   // $FF: renamed from: my boolean
   private boolean field_59;
   // $FF: renamed from: na android.content.BroadcastReceiver
   private BroadcastReceiver field_60;
   // $FF: renamed from: nb java.util.HashSet
   private final HashSet<ac> field_61;

   public class_199(Context var1, class_237 var2, class_432 var3, View var4, class_369 var5) {
      this((class_237)var2, (class_432)var3, (class_369)var5, var4, (class_0)(new class_230(var1, var5)));
   }

   public class_199(class_237 var1, class_432 var2, class_369 var3, final View var4, class_0 var5) {
      this.field_42 = new Object();
      this.field_59 = false;
      this.field_54 = false;
      this.field_55 = new ArrayBlockingQueue(2);
      this.field_56 = Long.MIN_VALUE;
      this.field_61 = new HashSet();
      this.field_43 = new WeakReference(var2);
      this.field_45 = new WeakReference(var4);
      this.field_44 = new WeakReference((Object)null);
      this.field_57 = true;
      this.field_46 = new class_206(UUID.randomUUID().toString(), var3, var1.field_446, var2.field_1401);
      this.field_48 = var5;
      this.field_50 = (WindowManager)var4.getContext().getSystemService("window");
      this.field_51 = (PowerManager)var4.getContext().getApplicationContext().getSystemService("power");
      this.field_52 = (KeyguardManager)var4.getContext().getSystemService("keyguard");
      this.field_47 = var4.getContext().getApplicationContext();
      this.method_1080(var5);
      this.field_48.method_0(new class_0.class_1544() {
         // $FF: renamed from: aR () void
         public void method_734() {
            class_199.this.field_49 = true;
            class_199.this.method_1093(var4);
            class_199.this.method_1083();
         }
      });
      this.method_1092(this.field_48);

      try {
         final JSONObject var8 = this.method_1094(var4);
         this.field_55.add(new Runnable() {
            public void run() {
               class_199.this.method_1081(var8);
            }
         });
      } catch (Throwable var9) {
         ;
      }

      this.field_55.add(new Runnable() {
         public void run() {
            class_199.this.method_1097(false);
         }
      });
      class_368.method_2502("Tracking ad unit: " + this.field_46.method_1490());
   }

   // $FF: renamed from: a (int, android.util.DisplayMetrics) int
   protected int method_1076(int var1, DisplayMetrics var2) {
      float var3 = var2.density;
      return (int)((float)var1 / var3);
   }

   // $FF: renamed from: a (android.view.View, java.util.Map) void
   protected void method_1077(View var1, Map<String, String> var2) {
      this.method_1097(false);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ac) void
   public void method_1078(class_2 var1) {
      this.field_61.add(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ag) void
   public void method_1079(class_1 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ah) void
   protected void method_1080(class_0 var1) {
      var1.method_4("https://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
   }

   // $FF: renamed from: a (org.json.JSONObject) void
   protected void method_1081(JSONObject var1) {
      try {
         JSONArray var2 = new JSONArray();
         JSONObject var3 = new JSONObject();
         var2.put(var1);
         var3.put("units", var2);
         this.field_48.method_3("AFMA_updateActiveView", var3);
      } catch (Throwable var5) {
         class_368.method_2508("Skipping active view message.", var5);
      }
   }

   // $FF: renamed from: a (java.util.Map) boolean
   protected boolean method_1082(Map<String, String> var1) {
      if(var1 == null) {
         return false;
      } else {
         String var2 = (String)var1.get("hashCode");
         boolean var3;
         if(!TextUtils.isEmpty(var2) && var2.equals(this.field_46.method_1490())) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }
   }

   // $FF: renamed from: aI () void
   protected void method_1083() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: aJ () void
   protected void method_1084() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: aK () void
   public void method_1085() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: aL () void
   protected void method_1086() {
      if(this.field_53 != null) {
         this.field_53.method_6(this);
      }

   }

   // $FF: renamed from: aM () boolean
   public boolean method_1087() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: aN () void
   protected void method_1088() {
      View var1 = (View)this.field_45.get();
      if(var1 != null) {
         ViewTreeObserver var2 = (ViewTreeObserver)this.field_44.get();
         ViewTreeObserver var3 = var1.getViewTreeObserver();
         if(var3 != var2) {
            this.field_44 = new WeakReference(var3);
            var3.addOnScrollChangedListener(this);
            var3.addOnGlobalLayoutListener(this);
            return;
         }
      }

   }

   // $FF: renamed from: aO () void
   protected void method_1089() {
      ViewTreeObserver var1 = (ViewTreeObserver)this.field_44.get();
      if(var1 != null && var1.isAlive()) {
         var1.removeOnScrollChangedListener(this);
         var1.removeGlobalOnLayoutListener(this);
      }
   }

   // $FF: renamed from: aP () org.json.JSONObject
   protected JSONObject method_1090() throws JSONException {
      JSONObject var1 = new JSONObject();
      var1.put("afmaVersion", this.field_46.method_1488()).put("activeViewJSON", this.field_46.method_1489()).put("timestamp", class_381.method_2607().method_2622().elapsedRealtime()).put("adFormat", this.field_46.method_1487()).put("hashCode", this.field_46.method_1490());
      return var1;
   }

   // $FF: renamed from: aQ () org.json.JSONObject
   protected JSONObject method_1091() throws JSONException {
      JSONObject var1 = this.method_1090();
      var1.put("doneReasonCode", "u");
      return var1;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.ah) void
   protected void method_1092(class_0 var1) {
      var1.method_2("/updateActiveView", new class_46() {
         // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
         public void method_213(gu var1, Map<String, String> var2) {
            if(class_199.this.method_1082(var2)) {
               class_199.this.method_1077(var1, var2);
            }
         }
      });
      var1.method_2("/untrackActiveViewUnit", new class_46() {
         // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
         public void method_213(gu var1, Map<String, String> var2) {
            if(class_199.this.method_1082(var2)) {
               class_368.method_2502("Received request to untrack: " + class_199.this.field_46.method_1490());
               class_199.this.destroy();
            }
         }
      });
      var1.method_2("/visibilityChanged", new class_46() {
         // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
         public void method_213(gu var1, Map<String, String> var2) {
            if(class_199.this.method_1082(var2) && var2.containsKey("isVisible")) {
               boolean var3;
               if(!"1".equals(var2.get("isVisible")) && !"true".equals(var2.get("isVisible"))) {
                  var3 = false;
               } else {
                  var3 = true;
               }

               Boolean var4 = Boolean.valueOf(var3);
               class_199.this.method_1095(var4.booleanValue());
            }
         }
      });
      var1.method_2("/viewabilityChanged", class_453.field_1524);
   }

   // $FF: renamed from: d (android.view.View) void
   protected void method_1093(View var1) {
      ArrayList var2 = new ArrayList();
      this.field_55.drainTo(var2);
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         ((Runnable)var4.next()).run();
      }

   }

   protected void destroy() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: e (android.view.View) org.json.JSONObject
   protected JSONObject method_1094(View var1) throws JSONException {
      int[] var2 = new int[2];
      int[] var3 = new int[2];
      var1.getLocationOnScreen(var2);
      var1.getLocationInWindow(var3);
      JSONObject var4 = this.method_1090();
      DisplayMetrics var5 = var1.getContext().getResources().getDisplayMetrics();
      Rect var6 = new Rect();
      var6.left = var2[0];
      var6.top = var2[1];
      var6.right = var6.left + var1.getWidth();
      var6.bottom = var6.top + var1.getHeight();
      Rect var7 = new Rect();
      var7.right = this.field_50.getDefaultDisplay().getWidth();
      var7.bottom = this.field_50.getDefaultDisplay().getHeight();
      Rect var8 = new Rect();
      boolean var9 = var1.getGlobalVisibleRect(var8, (Point)null);
      Rect var10 = new Rect();
      boolean var11 = var1.getLocalVisibleRect(var10);
      Rect var12 = new Rect();
      var1.getHitRect(var12);
      var4.put("viewBox", (new JSONObject()).put("top", this.method_1076(var7.top, var5)).put("bottom", this.method_1076(var7.bottom, var5)).put("left", this.method_1076(var7.left, var5)).put("right", this.method_1076(var7.right, var5))).put("adBox", (new JSONObject()).put("top", this.method_1076(var6.top, var5)).put("bottom", this.method_1076(var6.bottom, var5)).put("left", this.method_1076(var6.left, var5)).put("right", this.method_1076(var6.right, var5))).put("globalVisibleBox", (new JSONObject()).put("top", this.method_1076(var8.top, var5)).put("bottom", this.method_1076(var8.bottom, var5)).put("left", this.method_1076(var8.left, var5)).put("right", this.method_1076(var8.right, var5))).put("globalVisibleBoxVisible", var9).put("localVisibleBox", (new JSONObject()).put("top", this.method_1076(var10.top, var5)).put("bottom", this.method_1076(var10.bottom, var5)).put("left", this.method_1076(var10.left, var5)).put("right", this.method_1076(var10.right, var5))).put("localVisibleBoxVisible", var11).put("hitBox", (new JSONObject()).put("top", this.method_1076(var12.top, var5)).put("bottom", this.method_1076(var12.bottom, var5)).put("left", this.method_1076(var12.left, var5)).put("right", this.method_1076(var12.right, var5))).put("windowVisibility", var1.getWindowVisibility()).put("screenDensity", (double)var5.density).put("isVisible", this.method_1096(var1)).put("isStopped", this.field_54).put("isPaused", this.field_59);
      if(class_712.method_4183()) {
         var4.put("isAttachedToWindow", var1.isAttachedToWindow());
      }

      return var4;
   }

   // $FF: renamed from: f (boolean) void
   protected void method_1095(boolean var1) {
      Iterator var2 = this.field_61.iterator();

      while(var2.hasNext()) {
         ((class_2)var2.next()).method_8(this, var1);
      }

   }

   // $FF: renamed from: f (android.view.View) boolean
   protected boolean method_1096(View var1) {
      return var1.getVisibility() == 0 && var1.isShown() && this.field_51.isScreenOn() && !this.field_52.inKeyguardRestrictedInputMode();
   }

   // $FF: renamed from: g (boolean) void
   protected void method_1097(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public void onGlobalLayout() {
      this.method_1097(false);
   }

   public void onScrollChanged() {
      this.method_1097(true);
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
