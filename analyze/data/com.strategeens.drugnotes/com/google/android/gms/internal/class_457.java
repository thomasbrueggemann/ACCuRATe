package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_464;
import com.google.android.gms.internal.class_466;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gu;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.cj
@ey
public final class class_457 implements class_46 {
   // $FF: renamed from: a (android.util.DisplayMetrics, java.util.Map, java.lang.String, int) int
   private static int method_2922(DisplayMetrics var0, Map<String, String> var1, String var2, int var3) {
      String var4 = (String)var1.get(var2);
      if(var4 != null) {
         int var6;
         try {
            var6 = class_367.method_2495(var0, Integer.parseInt(var4));
         } catch (NumberFormatException var7) {
            class_368.method_2506("Could not parse " + var2 + " in a video GMSG: " + var4);
            return var3;
         }

         var3 = var6;
      }

      return var3;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
   public void method_213(gu var1, Map<String, String> var2) {
      String var3 = (String)var2.get("action");
      if(var3 == null) {
         class_368.method_2506("Action missing from video GMSG.");
      } else {
         class_464 var4 = var1.method_2530();
         if(var4 == null) {
            class_368.method_2506("Could not get ad overlay for a video GMSG.");
         } else {
            boolean var5 = "new".equalsIgnoreCase(var3);
            boolean var6 = "position".equalsIgnoreCase(var3);
            if(!var5 && !var6) {
               class_466 var12 = var4.method_2953();
               if(var12 == null) {
                  class_466.method_2964(var1, "no_video_view", (String)null);
               } else if("click".equalsIgnoreCase(var3)) {
                  DisplayMetrics var16 = var1.getContext().getResources().getDisplayMetrics();
                  int var17 = method_2922(var16, var2, "x", 0);
                  int var18 = method_2922(var16, var2, "y", 0);
                  long var19 = SystemClock.uptimeMillis();
                  MotionEvent var21 = MotionEvent.obtain(var19, var19, 0, (float)var17, (float)var18, 0);
                  var12.method_2968(var21);
                  var21.recycle();
               } else if("controls".equalsIgnoreCase(var3)) {
                  String var15 = (String)var2.get("enabled");
                  if(var15 == null) {
                     class_368.method_2506("Enabled parameter missing from controls video GMSG.");
                  } else {
                     var12.method_2971(Boolean.parseBoolean(var15));
                  }
               } else if("currentTime".equalsIgnoreCase(var3)) {
                  String var13 = (String)var2.get("time");
                  if(var13 == null) {
                     class_368.method_2506("Time parameter missing from currentTime video GMSG.");
                  } else {
                     try {
                        var12.seekTo((int)(1000.0F * Float.parseFloat(var13)));
                     } catch (NumberFormatException var22) {
                        class_368.method_2506("Could not parse time parameter from currentTime video GMSG: " + var13);
                     }
                  }
               } else if("hide".equalsIgnoreCase(var3)) {
                  var12.setVisibility(4);
               } else if("load".equalsIgnoreCase(var3)) {
                  var12.method_2969();
               } else if("pause".equalsIgnoreCase(var3)) {
                  var12.pause();
               } else if("play".equalsIgnoreCase(var3)) {
                  var12.play();
               } else if("show".equalsIgnoreCase(var3)) {
                  var12.setVisibility(0);
               } else if("src".equalsIgnoreCase(var3)) {
                  var12.method_2967((String)var2.get("src"));
               } else {
                  class_368.method_2506("Unknown video action: " + var3);
               }
            } else {
               DisplayMetrics var7 = var1.getContext().getResources().getDisplayMetrics();
               int var8 = method_2922(var7, var2, "x", 0);
               int var9 = method_2922(var7, var2, "y", 0);
               int var10 = method_2922(var7, var2, "w", -1);
               int var11 = method_2922(var7, var2, "h", -1);
               if(var5 && var4.method_2953() == null) {
                  var4.method_2952(var8, var9, var10, var11);
               } else {
                  var4.method_2951(var8, var9, var10, var11);
               }
            }
         }
      }
   }
}
