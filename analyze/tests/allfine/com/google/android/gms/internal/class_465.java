package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_468;
import com.google.android.gms.internal.class_487;
import com.google.android.gms.internal.class_9;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.gv;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.ce
@ez
public final class class_465 implements class_9 {
    // $FF: renamed from: a (android.util.DisplayMetrics, java.util.Map, java.lang.String, int) int
    private static int method_2849(DisplayMetrics var0, Map<String, String> var1, String var2, int var3) {
        String var4 = (String)var1.get(var2);
        if(var4 != null) {
            int var6;
            try {
                var6 = class_377.method_2450(var0, Integer.parseInt(var4));
            } catch (NumberFormatException var7) {
                class_378.method_2461("Could not parse " + var2 + " in a video GMSG: " + var4);
                return var3;
            }

            var3 = var6;
        }

        return var3;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
    public void method_24(gv var1, Map<String, String> var2) {
        String var3 = (String)var2.get("action");
        if(var3 == null) {
            class_378.method_2461("Action missing from video GMSG.");
        } else {
            class_487 var4 = var1.method_2485();
            if(var4 == null) {
                class_378.method_2461("Could not get ad overlay for a video GMSG.");
            } else {
                boolean var5 = "new".equalsIgnoreCase(var3);
                boolean var6 = "position".equalsIgnoreCase(var3);
                if(!var5 && !var6) {
                    class_468 var12 = var4.method_2980();
                    if(var12 == null) {
                        class_468.method_2852(var1, "no_video_view", (String)null);
                    } else if("click".equalsIgnoreCase(var3)) {
                        DisplayMetrics var16 = var1.getContext().getResources().getDisplayMetrics();
                        int var17 = method_2849(var16, var2, "x", 0);
                        int var18 = method_2849(var16, var2, "y", 0);
                        long var19 = SystemClock.uptimeMillis();
                        MotionEvent var21 = MotionEvent.obtain(var19, var19, 0, (float)var17, (float)var18, 0);
                        var12.method_2856(var21);
                        var21.recycle();
                    } else if("controls".equalsIgnoreCase(var3)) {
                        String var15 = (String)var2.get("enabled");
                        if(var15 == null) {
                            class_378.method_2461("Enabled parameter missing from controls video GMSG.");
                        } else {
                            var12.method_2859(Boolean.parseBoolean(var15));
                        }
                    } else if("currentTime".equalsIgnoreCase(var3)) {
                        String var13 = (String)var2.get("time");
                        if(var13 == null) {
                            class_378.method_2461("Time parameter missing from currentTime video GMSG.");
                        } else {
                            try {
                                var12.seekTo((int)(1000.0F * Float.parseFloat(var13)));
                            } catch (NumberFormatException var22) {
                                class_378.method_2461("Could not parse time parameter from currentTime video GMSG: " + var13);
                            }
                        }
                    } else if("hide".equalsIgnoreCase(var3)) {
                        var12.setVisibility(4);
                    } else if("load".equalsIgnoreCase(var3)) {
                        var12.method_2857();
                    } else if("pause".equalsIgnoreCase(var3)) {
                        var12.pause();
                    } else if("play".equalsIgnoreCase(var3)) {
                        var12.play();
                    } else if("show".equalsIgnoreCase(var3)) {
                        var12.setVisibility(0);
                    } else if("src".equalsIgnoreCase(var3)) {
                        var12.method_2855((String)var2.get("src"));
                    } else {
                        class_378.method_2461("Unknown video action: " + var3);
                    }
                } else {
                    DisplayMetrics var7 = var1.getContext().getResources().getDisplayMetrics();
                    int var8 = method_2849(var7, var2, "x", 0);
                    int var9 = method_2849(var7, var2, "y", 0);
                    int var10 = method_2849(var7, var2, "w", -1);
                    int var11 = method_2849(var7, var2, "h", -1);
                    if(var5 && var4.method_2980() == null) {
                        var4.method_2985(var8, var9, var10, var11);
                    } else {
                        var4.method_2979(var8, var9, var10, var11);
                    }
                }
            }
        }
    }
}
