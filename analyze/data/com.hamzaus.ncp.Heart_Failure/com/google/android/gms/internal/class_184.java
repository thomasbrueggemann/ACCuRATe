package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.class_10;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_406;
import com.google.android.gms.internal.class_422;
import com.google.android.gms.internal.ey;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.bi
public final class class_184 implements class_10 {
   // $FF: renamed from: a (android.util.DisplayMetrics, java.util.Map, java.lang.String, int) int
   private static int method_1296(DisplayMetrics var0, Map<String, String> var1, String var2, int var3) {
      String var4 = (String)var1.get(var2);
      if(var4 != null) {
         int var6;
         try {
            var6 = class_371.method_2365(var0, Integer.parseInt(var4));
         } catch (NumberFormatException var7) {
            class_370.method_2358("Could not parse " + var2 + " in a video GMSG: " + var4);
            return var3;
         }

         var3 = var6;
      }

      return var3;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.ey, java.util.Map) void
   public void method_19(ey var1, Map<String, String> var2) {
      String var3 = (String)var2.get("action");
      if(var3 == null) {
         class_370.method_2358("Action missing from video GMSG.");
      } else {
         class_422 var4 = var1.method_2348();
         if(var4 == null) {
            class_370.method_2358("Could not get ad overlay for a video GMSG.");
         } else {
            boolean var5 = "new".equalsIgnoreCase(var3);
            boolean var6 = "position".equalsIgnoreCase(var3);
            if(!var5 && !var6) {
               class_406 var12 = var4.method_2559();
               if(var12 == null) {
                  class_406.method_2495(var1, "no_video_view", (String)null);
               } else if("click".equalsIgnoreCase(var3)) {
                  DisplayMetrics var16 = var1.getContext().getResources().getDisplayMetrics();
                  int var17 = method_1296(var16, var2, "x", 0);
                  int var18 = method_1296(var16, var2, "y", 0);
                  long var19 = SystemClock.uptimeMillis();
                  MotionEvent var21 = MotionEvent.obtain(var19, var19, 0, (float)var17, (float)var18, 0);
                  var12.method_2500(var21);
                  var21.recycle();
               } else if("controls".equalsIgnoreCase(var3)) {
                  String var15 = (String)var2.get("enabled");
                  if(var15 == null) {
                     class_370.method_2358("Enabled parameter missing from controls video GMSG.");
                  } else {
                     var12.method_2501(Boolean.parseBoolean(var15));
                  }
               } else if("currentTime".equalsIgnoreCase(var3)) {
                  String var13 = (String)var2.get("time");
                  if(var13 == null) {
                     class_370.method_2358("Time parameter missing from currentTime video GMSG.");
                  } else {
                     try {
                        var12.seekTo((int)(1000.0F * Float.parseFloat(var13)));
                     } catch (NumberFormatException var22) {
                        class_370.method_2358("Could not parse time parameter from currentTime video GMSG: " + var13);
                     }
                  }
               } else if("hide".equalsIgnoreCase(var3)) {
                  var12.setVisibility(4);
               } else if("load".equalsIgnoreCase(var3)) {
                  var12.method_2498();
               } else if("pause".equalsIgnoreCase(var3)) {
                  var12.pause();
               } else if("play".equalsIgnoreCase(var3)) {
                  var12.play();
               } else if("show".equalsIgnoreCase(var3)) {
                  var12.setVisibility(0);
               } else if("src".equalsIgnoreCase(var3)) {
                  var12.method_2502((String)var2.get("src"));
               } else {
                  class_370.method_2358("Unknown video action: " + var3);
               }
            } else {
               DisplayMetrics var7 = var1.getContext().getResources().getDisplayMetrics();
               int var8 = method_1296(var7, var2, "x", 0);
               int var9 = method_1296(var7, var2, "y", 0);
               int var10 = method_1296(var7, var2, "w", -1);
               int var11 = method_1296(var7, var2, "h", -1);
               if(var5 && var4.method_2559() == null) {
                  var4.method_2563(var8, var9, var10, var11);
               } else {
                  var4.method_2562(var8, var9, var10, var11);
               }
            }
         }
      }
   }
}
