package com.comscore.applications;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.comscore.analytics.ApplicationState;
import com.comscore.analytics.Core;
import com.comscore.applications.AggregateMeasurement;
import com.comscore.applications.AppStartMeasurement;
import com.comscore.applications.EventType;
import com.comscore.measurement.Label;
import com.comscore.measurement.Measurement;
import com.comscore.utils.API13;
import java.util.HashMap;
import java.util.Locale;

public class ApplicationMeasurement extends Measurement {
   protected ApplicationMeasurement(Core var1, EventType var2, String var3) {
      this(var1, var2, var3, false, false, true);
   }

   protected ApplicationMeasurement(Core var1, EventType var2, String var3, boolean var4, boolean var5, boolean var6) {
      super(var1);
      var1.update(var6);
      if(var6) {
         int var14 = var1.getForegroundTransitionsCountDelta(var5);
         long var15 = var1.getForegroundTotalTime(var4);
         long var17 = var1.getForegroundTimeDelta(var5);
         long var19 = var1.getBackgroundTotalTime(var4);
         long var21 = var1.getBackgroundTimeDelta(var5);
         long var23 = var1.getInactiveTotalTime(var4);
         long var25 = var1.getInactiveTimeDelta(var5);
         long var27 = var1.getApplicationSessionTimeDelta(var5);
         long var29 = var1.getActiveUserSessionTimeDelta(var5);
         long var31 = var1.getUserSessionTimeDelta(var5);
         long var33 = var1.getAutoUpdateInterval();
         int var35 = var1.getApplicationSessionCountDelta(var5);
         int var36 = var1.getActiveUserSessionCountDelta(var5);
         int var37 = var1.getUserSessionCountDelta(var5);
         int var38 = var1.getUserInteractionCount(var5);
         Label var39 = new Label("ns_ap_fg", String.valueOf(var14), Boolean.valueOf(false));
         this.setLabel(var39);
         this.setLabel(new Label("ns_ap_ft", String.valueOf(var15), Boolean.valueOf(false)));
         this.setLabel(new Label("ns_ap_dft", String.valueOf(var17), Boolean.valueOf(false)));
         this.setLabel(new Label("ns_ap_bt", String.valueOf(var19), Boolean.valueOf(false)));
         this.setLabel(new Label("ns_ap_dbt", String.valueOf(var21), Boolean.valueOf(false)));
         this.setLabel(new Label("ns_ap_it", String.valueOf(var23), Boolean.valueOf(false)));
         this.setLabel(new Label("ns_ap_dit", String.valueOf(var25), Boolean.valueOf(false)));
         if(var33 >= 60000L) {
            this.setLabel(new Label("ns_ap_ut", String.valueOf(var33), Boolean.valueOf(false)));
         }

         this.setLabel(new Label("ns_ap_as", String.valueOf(var35), Boolean.valueOf(false)));
         this.setLabel(new Label("ns_ap_das", String.valueOf(var27), Boolean.valueOf(false)));
         if(var36 >= 0) {
            this.setLabel(new Label("ns_ap_aus", String.valueOf(var36), Boolean.valueOf(false)));
            this.setLabel(new Label("ns_ap_daus", String.valueOf(var29), Boolean.valueOf(false)));
            this.setLabel(new Label("ns_ap_uc", String.valueOf(var38), Boolean.valueOf(false)));
         }

         if(var37 >= 0) {
            this.setLabel(new Label("ns_ap_us", String.valueOf(var37), Boolean.valueOf(false)));
            this.setLabel(new Label("ns_ap_dus", String.valueOf(var31), Boolean.valueOf(false)));
         }

         this.setLabel(new Label("ns_ap_usage", Long.toString(this.c - var1.getGenesis()), Boolean.valueOf(false)));
      }

      if(var3 != null) {
         this.setPixelURL(var3);
      }

      this.setLabel(new Label("c1", "19", Boolean.valueOf(false)));
      this.setLabel(new Label("ns_ap_an", var1.getAppName(), Boolean.valueOf(false)));
      this.setLabel(new Label("ns_ap_pn", "android", Boolean.valueOf(false)));
      this.setLabel(new Label("c12", var1.getVisitorId(), Boolean.valueOf(false)));
      if(var1.getCrossPublisherId() != null) {
         this.setLabel(new Label("ns_ak", var1.getCrossPublisherId(), Boolean.valueOf(false)));
         if(var1.getIdHelper().isIdChanged()) {
            this.setLabel(new Label("ns_ap_ni", "1", Boolean.valueOf(false)));
         }
      }

      if(var1.getIdHelper().getMD5AdvertisingId() != null) {
         this.setLabel("ns_ap_i3", var1.getIdHelper().getMD5AdvertisingId());
      }

      this.setLabel(new Label("ns_ap_device", Build.DEVICE, Boolean.valueOf(false)));
      this.setLabel(new Label("ns_type", method_322(var2).toString(), Boolean.valueOf(false)));
      this.setLabel(new Label("ns_ts", Long.toString(this.c), Boolean.valueOf(false)));
      this.setLabel(new Label("ns_nc", "1", Boolean.valueOf(false)));
      this.setLabel(new Label("ns_ap_pfv", VERSION.RELEASE, Boolean.valueOf(false)));
      this.setLabel(new Label("ns_ap_pv", VERSION.RELEASE, Boolean.valueOf(false)));
      this.setLabel(new Label("ns_ap_pfm", "android", Boolean.valueOf(false)));
      this.setLabel(new Label("ns_ap_ar", System.getProperty("os.arch"), Boolean.valueOf(false)));
      this.setLabel(new Label("ns_ap_ev", var2.toString(), Boolean.valueOf(false)));
      Context var7 = var1.getAppContext();
      this.setLabel(new Label("ns_ap_ver", var1.getCurrentVersion(), Boolean.valueOf(false)));
      Point var8 = this.method_321(var7);
      int var9 = var8.x;
      int var10 = var8.y;
      this.setLabel(new Label("ns_ap_res", Integer.toString(var9) + "x" + Integer.toString(var10), Boolean.valueOf(false)));
      this.setLabel(new Label("ns_ap_lang", Locale.getDefault().getLanguage(), Boolean.valueOf(false)));
      this.setLabel(new Label("ns_ap_sv", var1.getVersion(), Boolean.valueOf(false)));
      if(var2.equals(EventType.KEEPALIVE)) {
         this.setLabel("ns_ap_oc", String.valueOf(var1.getOfflineCache().getEventCount()));
      }

      long var11 = var1.getColdStartId();
      int var13 = var1.getColdStartCount();
      this.setLabel(new Label("ns_ap_id", String.valueOf(var11), Boolean.valueOf(false)));
      this.setLabel(new Label("ns_ap_cs", String.valueOf(var13), Boolean.valueOf(false)));
      this.setLabel(new Label("ns_ap_bi", var1.getAppContext().getPackageName(), Boolean.valueOf(false)));
   }

   // $FF: renamed from: a (android.content.Context) android.graphics.Point
   @SuppressLint({"NewApi"})
   private Point method_321(Context var1) {
      Point var2 = new Point();
      Display var3 = ((WindowManager)var1.getSystemService("window")).getDefaultDisplay();
      if(VERSION.SDK_INT >= 13) {
         return API13.getDisplaySize(var3);
      } else {
         var2.x = var3.getWidth();
         var2.y = var3.getHeight();
         return var2;
      }
   }

   // $FF: renamed from: a (com.comscore.applications.EventType) com.comscore.metrics.EventType
   private static com.comscore.metrics.EventType method_322(EventType var0) {
      return var0 != EventType.START && var0 != EventType.CLOSE && var0 != EventType.VIEW?com.comscore.metrics.EventType.HIDDEN:com.comscore.metrics.EventType.VIEW;
   }

   public static ApplicationMeasurement newApplicationMeasurement(Core var0, EventType var1, HashMap<String, String> var2, String var3) {
      boolean var4 = true;
      Object var5;
      if(var1 == EventType.START) {
         var0.incrementRunsCount();
         var5 = new AppStartMeasurement(var0, var1, var3, var0.handleColdStart());
      } else if(var1 == EventType.AGGREGATE) {
         var5 = new AggregateMeasurement(var0, var1, var3);
      } else {
         EventType var6 = EventType.CLOSE;
         var5 = null;
         if(var1 != var6) {
            boolean var7;
            if(var2 != null && var2.get("ns_st_ev") == "hb") {
               var7 = false;
            } else {
               var7 = var4;
            }

            boolean var8;
            if(var2 != null && var2.containsKey("ns_st_ev")) {
               var8 = false;
            } else {
               var8 = var4;
            }

            var5 = new ApplicationMeasurement(var0, var1, var3, false, var7, var8);
         }
      }

      if(var1 != EventType.AGGREGATE) {
         ((ApplicationMeasurement)var5).a(var0.getLabels());
      }

      if(var1 != EventType.AGGREGATE) {
         var4 = false;
      }

      ((ApplicationMeasurement)var5).a(var2, var4);
      if(!((ApplicationMeasurement)var5).hasLabel("name").booleanValue()) {
         if(var0.getCurrentActivityName() == null) {
            if(var1 == EventType.START) {
               ((ApplicationMeasurement)var5).setLabel("name", "start");
               return (ApplicationMeasurement)var5;
            }

            if(var0.getApplicationState() == ApplicationState.FOREGROUND) {
               ((ApplicationMeasurement)var5).setLabel("name", "foreground");
               return (ApplicationMeasurement)var5;
            }

            ((ApplicationMeasurement)var5).setLabel("name", "background");
            return (ApplicationMeasurement)var5;
         }

         ((ApplicationMeasurement)var5).setLabel("name", var0.getCurrentActivityName());
      }

      return (ApplicationMeasurement)var5;
   }
}
