package com.comscore.analytics;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import com.comscore.analytics.ApplicationState;
import com.comscore.analytics.Core$UserInteractionTask;
import com.comscore.analytics.SessionState;
import com.comscore.analytics.class_10;
import com.comscore.analytics.class_11;
import com.comscore.analytics.class_12;
import com.comscore.analytics.class_13;
import com.comscore.analytics.class_25;
import com.comscore.analytics.class_26;
import com.comscore.analytics.class_27;
import com.comscore.analytics.class_28;
import com.comscore.analytics.class_29;
import com.comscore.analytics.class_30;
import com.comscore.analytics.class_31;
import com.comscore.analytics.class_32;
import com.comscore.analytics.class_33;
import com.comscore.analytics.class_34;
import com.comscore.analytics.class_35;
import com.comscore.analytics.class_36;
import com.comscore.analytics.class_37;
import com.comscore.analytics.class_38;
import com.comscore.analytics.class_39;
import com.comscore.analytics.class_40;
import com.comscore.analytics.class_41;
import com.comscore.analytics.class_42;
import com.comscore.analytics.class_43;
import com.comscore.analytics.class_44;
import com.comscore.analytics.class_45;
import com.comscore.analytics.class_46;
import com.comscore.analytics.class_47;
import com.comscore.analytics.class_48;
import com.comscore.analytics.class_49;
import com.comscore.analytics.class_50;
import com.comscore.analytics.class_6;
import com.comscore.analytics.class_7;
import com.comscore.analytics.class_8;
import com.comscore.analytics.class_9;
import com.comscore.analytics.comScore;
import com.comscore.applications.ApplicationMeasurement;
import com.comscore.applications.EventType;
import com.comscore.applications.KeepAlive;
import com.comscore.measurement.Measurement;
import com.comscore.measurement.MeasurementDispatcher;
import com.comscore.utils.CSLog;
import com.comscore.utils.CacheFlusher;
import com.comscore.utils.ConnectivityChangeReceiver;
import com.comscore.utils.Constants;
import com.comscore.utils.CustomExceptionHandler;
import com.comscore.utils.Date;
import com.comscore.utils.DispatchQueue;
import com.comscore.utils.OfflineMeasurementsCache;
import com.comscore.utils.Storage;
import com.comscore.utils.TransmissionMode;
import com.comscore.utils.Utils;
import com.comscore.utils.id.IdHelper;
import com.comscore.utils.task.TaskExecutor;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class Core {
   // $FF: renamed from: x long
   protected static final long field_317 = 300L;
   // $FF: renamed from: A java.util.concurrent.atomic.AtomicInteger
   protected AtomicInteger field_318;
   // $FF: renamed from: B java.util.concurrent.atomic.AtomicInteger
   protected AtomicInteger field_319;
   // $FF: renamed from: C long
   protected long field_320;
   // $FF: renamed from: D long
   protected long field_321;
   // $FF: renamed from: E long
   protected long field_322;
   // $FF: renamed from: F long
   protected long field_323;
   // $FF: renamed from: G long
   protected long field_324;
   // $FF: renamed from: H long
   protected long field_325;
   // $FF: renamed from: I long
   protected long field_326;
   // $FF: renamed from: J long
   protected long field_327;
   // $FF: renamed from: K long
   protected long field_328;
   // $FF: renamed from: L com.comscore.analytics.SessionState
   protected SessionState field_329;
   // $FF: renamed from: M long
   protected long field_330;
   // $FF: renamed from: N long
   protected long field_331;
   // $FF: renamed from: O long
   protected long field_332;
   // $FF: renamed from: P int
   protected int field_333;
   // $FF: renamed from: Q int
   protected int field_334;
   // $FF: renamed from: R int
   protected int field_335;
   // $FF: renamed from: S long
   protected long field_336;
   // $FF: renamed from: T long
   protected long field_337;
   // $FF: renamed from: U long
   protected long field_338;
   // $FF: renamed from: V int
   protected int field_339;
   // $FF: renamed from: W long
   protected long field_340;
   // $FF: renamed from: X long
   protected long field_341;
   // $FF: renamed from: Y java.lang.Runnable
   protected Runnable field_342;
   // $FF: renamed from: Z java.lang.String
   protected String field_343;
   // $FF: renamed from: a com.comscore.utils.OfflineMeasurementsCache
   OfflineMeasurementsCache field_344;
   // $FF: renamed from: aa java.lang.String
   String field_345;
   // $FF: renamed from: ab android.content.Context
   Context field_346;
   // $FF: renamed from: ac java.util.HashMap
   protected final HashMap<String, String> field_347;
   // $FF: renamed from: ad java.util.HashMap
   protected final HashMap<String, String> field_348;
   // $FF: renamed from: ae boolean
   boolean field_349;
   // $FF: renamed from: af long
   protected long field_350;
   // $FF: renamed from: ag boolean
   protected boolean field_351;
   // $FF: renamed from: ah java.lang.Thread.UncaughtExceptionHandler
   protected UncaughtExceptionHandler field_352;
   // $FF: renamed from: ai boolean
   boolean field_353;
   // $FF: renamed from: aj com.comscore.utils.TransmissionMode
   TransmissionMode field_354;
   // $FF: renamed from: ak com.comscore.utils.TransmissionMode
   TransmissionMode field_355;
   // $FF: renamed from: al java.lang.String[]
   String[] field_356;
   // $FF: renamed from: am com.comscore.utils.id.IdHelper
   private IdHelper field_357;
   // $FF: renamed from: an boolean
   private boolean field_358;
   // $FF: renamed from: ao boolean
   private boolean field_359;
   // $FF: renamed from: b com.comscore.utils.Storage
   Storage field_360;
   // $FF: renamed from: c com.comscore.applications.KeepAlive
   KeepAlive field_361;
   // $FF: renamed from: d com.comscore.utils.CacheFlusher
   CacheFlusher field_362;
   // $FF: renamed from: e com.comscore.utils.DispatchQueue
   @Deprecated
   DispatchQueue field_363;
   // $FF: renamed from: f com.comscore.utils.task.TaskExecutor
   TaskExecutor field_364;
   // $FF: renamed from: g com.comscore.measurement.MeasurementDispatcher
   MeasurementDispatcher field_365;
   // $FF: renamed from: h com.comscore.utils.ConnectivityChangeReceiver
   ConnectivityChangeReceiver field_366;
   // $FF: renamed from: i java.lang.Runnable
   protected Runnable field_367;
   // $FF: renamed from: j java.lang.Runnable
   protected Runnable field_368;
   // $FF: renamed from: k long
   protected long field_369;
   // $FF: renamed from: l boolean
   protected boolean field_370 = true;
   // $FF: renamed from: m boolean
   protected boolean field_371 = true;
   // $FF: renamed from: n boolean
   boolean field_372 = false;
   // $FF: renamed from: o java.util.concurrent.atomic.AtomicInteger
   AtomicInteger field_373;
   // $FF: renamed from: p long
   long field_374;
   // $FF: renamed from: q java.util.concurrent.atomic.AtomicInteger
   AtomicInteger field_375;
   // $FF: renamed from: r long
   long field_376;
   // $FF: renamed from: s long
   long field_377;
   // $FF: renamed from: t java.lang.String
   String field_378;
   // $FF: renamed from: u java.lang.String
   String field_379;
   // $FF: renamed from: v boolean
   boolean field_380 = true;
   // $FF: renamed from: w java.lang.String
   String field_381;
   // $FF: renamed from: y com.comscore.analytics.ApplicationState
   protected ApplicationState field_382;
   // $FF: renamed from: z java.util.concurrent.atomic.AtomicInteger
   protected AtomicInteger field_383;

   public Core() {
      this.field_382 = ApplicationState.INACTIVE;
      this.field_329 = SessionState.INACTIVE;
      this.field_350 = 0L;
      this.field_351 = false;
      this.field_358 = true;
      this.field_375 = new AtomicInteger(0);
      this.field_373 = new AtomicInteger();
      this.field_319 = new AtomicInteger(0);
      this.field_383 = new AtomicInteger(0);
      this.field_318 = new AtomicInteger(0);
      this.field_352 = Thread.getDefaultUncaughtExceptionHandler();
      this.field_349 = true;
      this.field_347 = new HashMap();
      this.field_348 = new HashMap();
      this.reset();
   }

   // $FF: renamed from: A () void
   private void method_210() {
      ArrayList var1 = new ArrayList();
      var1.add("lastApplicationAccumulationTimestamp");
      var1.add("lastSessionAccumulationTimestamp");
      this.method_241("lastActivityTime", var1);
      this.method_240("ns_ap_fg", "foregroundTransitionsCount");
      this.method_240("installTime", "installId");
      this.method_240("ns_ap_ver", "previousVersion");
   }

   // $FF: renamed from: a (com.comscore.analytics.Core) com.comscore.utils.id.IdHelper
   // $FF: synthetic method
   static IdHelper method_211(Core var0) {
      return var0.field_357;
   }

   // $FF: renamed from: a (java.lang.String, java.util.Properties, boolean) java.lang.String
   private String method_212(String var1, Properties var2, boolean var3) {
      if(var2 != null) {
         String var4 = var2.getProperty(var1);
         if(var4 != null) {
            this.field_360.set(var1, var4);
            return var4;
         }
      }

      return var3 && this.field_360.has(var1).booleanValue()?this.field_360.get(var1):null;
   }

   // $FF: renamed from: a (com.comscore.analytics.Core, com.comscore.utils.TransmissionMode) void
   // $FF: synthetic method
   static void method_213(Core var0, TransmissionMode var1) {
      var0.method_216(var1);
   }

   // $FF: renamed from: a (com.comscore.analytics.Core, java.lang.String) void
   // $FF: synthetic method
   static void method_214(Core var0, String var1) {
      var0.method_221(var1);
   }

   // $FF: renamed from: a (com.comscore.analytics.Core, java.lang.String, java.lang.String) void
   // $FF: synthetic method
   static void method_215(Core var0, String var1, String var2) {
      var0.method_222(var1, var2);
   }

   // $FF: renamed from: a (com.comscore.utils.TransmissionMode) void
   private void method_216(TransmissionMode var1) {
      if(this.field_358) {
         this.field_354 = var1;
      }
   }

   // $FF: renamed from: a (com.comscore.analytics.Core, boolean) boolean
   // $FF: synthetic method
   static boolean method_217(Core var0, boolean var1) {
      var0.field_358 = var1;
      return var1;
   }

   // $FF: renamed from: b (com.comscore.analytics.Core, com.comscore.utils.TransmissionMode) void
   // $FF: synthetic method
   static void method_218(Core var0, TransmissionMode var1) {
      var0.method_220(var1);
   }

   // $FF: renamed from: b (com.comscore.analytics.Core, java.lang.String) void
   // $FF: synthetic method
   static void method_219(Core var0, String var1) {
      var0.method_226(var1);
   }

   // $FF: renamed from: b (com.comscore.utils.TransmissionMode) void
   private void method_220(TransmissionMode var1) {
      if(this.field_358) {
         this.field_355 = var1;
      }
   }

   // $FF: renamed from: b (java.lang.String) void
   private void method_221(String var1) {
      if(this.field_358 && this.field_357 != null) {
         this.field_357.setPublisherSecret(var1);
         this.field_357.generateIds();
      }
   }

   // $FF: renamed from: b (java.lang.String, java.lang.String) void
   private void method_222(String var1, String var2) {
      if(this.field_358) {
         this.field_347.put(var1, var2);
      }
   }

   // $FF: renamed from: b (com.comscore.analytics.Core) boolean
   // $FF: synthetic method
   static boolean method_223(Core var0) {
      return var0.field_358;
   }

   // $FF: renamed from: b (com.comscore.analytics.Core, boolean) boolean
   // $FF: synthetic method
   static boolean method_224(Core var0, boolean var1) {
      var0.field_359 = var1;
      return var1;
   }

   // $FF: renamed from: c (com.comscore.analytics.Core, java.lang.String) void
   // $FF: synthetic method
   static void method_225(Core var0, String var1) {
      var0.method_228(var1);
   }

   // $FF: renamed from: c (java.lang.String) void
   private void method_226(String var1) {
      if(this.field_358) {
         this.field_345 = var1;
         if(this.field_360 != null) {
            this.field_360.set("appName", this.field_345);
            return;
         }
      }

   }

   // $FF: renamed from: c (com.comscore.analytics.Core) boolean
   // $FF: synthetic method
   static boolean method_227(Core var0) {
      return var0.field_359;
   }

   // $FF: renamed from: d (java.lang.String) void
   private void method_228(String var1) {
      if(this.field_358) {
         String var2;
         if(this.isSecure()) {
            var2 = "https://sb.scorecardresearch.com/p2?";
         } else {
            var2 = "http://b.scorecardresearch.com/p2?";
         }

         this.method_239(var2);
         this.method_222("c2", var1);
      }
   }

   @Deprecated
   public static Core getInstance() {
      return comScore.getCore();
   }

   // $FF: renamed from: a (com.comscore.applications.EventType, java.util.HashMap, java.lang.String) com.comscore.measurement.Measurement
   protected Measurement method_229(EventType var1, HashMap<String, String> var2, String var3) {
      return ApplicationMeasurement.newApplicationMeasurement(this, var1, var2, var3);
   }

   // $FF: renamed from: a (android.content.Context, com.comscore.utils.Storage) com.comscore.utils.id.IdHelper
   protected IdHelper method_230(Context var1, Storage var2) {
      return new IdHelper(var1, var2, this);
   }

   // $FF: renamed from: a () void
   protected void method_231() {
      this.field_360 = this.method_243();
      this.field_365 = this.method_251();
      this.method_238(this.field_360);
      this.field_363 = this.method_247();
      this.field_361 = this.method_252();
      this.field_344 = this.method_253();
      this.field_362 = this.method_254();
      this.field_366 = this.method_255();
      this.method_256();
      this.field_357 = this.method_230(this.field_346, this.field_360);
   }

   // $FF: renamed from: a (int, boolean) void
   void method_232(int var1, boolean var2) {
      if(this.field_358) {
         this.method_269();
         if(var1 < 60) {
            var1 = 60;
         }

         this.field_370 = var2;
         this.field_369 = (long)(var1 * 1000);
         if(this.field_382 == ApplicationState.FOREGROUND) {
            this.method_268();
            return;
         }

         if(this.field_382 == ApplicationState.BACKGROUND_UX_ACTIVE && !this.field_370) {
            this.method_268();
            return;
         }
      }

   }

   // $FF: renamed from: a (com.comscore.analytics.ApplicationState) void
   protected void method_233(ApplicationState var1) {
      CSLog.method_372(this, "Leaving application state: " + var1);
      switch(class_9.field_18[var1.ordinal()]) {
      case 1:
         this.field_366.start();
         this.field_361.start(3000);
         this.field_346.registerReceiver(this.field_366, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
         this.field_362.start();
         return;
      case 2:
         this.method_269();
         return;
      case 3:
         this.setCurrentActivityName((String)null);
         this.method_269();
         return;
      default:
      }
   }

   // $FF: renamed from: a (com.comscore.analytics.ApplicationState, com.comscore.analytics.ApplicationState) void
   protected void method_234(ApplicationState var1, ApplicationState var2) {
      if(this.field_358 && var2 != ApplicationState.INACTIVE && this.isAutoStartEnabled() && !this.field_372) {
         this.notify(EventType.START, this.field_348, false);
      }
   }

   // $FF: renamed from: a (com.comscore.analytics.SessionState) void
   protected void method_235(SessionState var1) {
      if(this.field_358) {
         CSLog.method_372(this, "Leaving session state: " + var1);
         long var2 = Date.unixTime();
         switch(class_9.field_19[var1.ordinal()]) {
         case 1:
            if(this.field_342 != null) {
               this.field_364.removeEnqueuedTask(this.field_342);
               this.field_342 = null;
            }

            this.field_338 = var2;
         case 2:
            this.field_337 = var2;
         case 3:
            this.field_336 = var2;
            return;
         case 4:
            if(!this.method_262()) {
               this.field_330 += var2 - this.field_341;
               return;
            }
            break;
         default:
            return;
         }
      }

   }

   // $FF: renamed from: a (com.comscore.analytics.SessionState, com.comscore.analytics.SessionState) void
   protected void method_236(SessionState var1, SessionState var2) {
   }

   // $FF: renamed from: a (com.comscore.applications.EventType, java.util.HashMap) void
   void method_237(EventType var1, HashMap<String, String> var2) {
      if(this.field_358) {
         if(this.method_272()) {
            this.method_270();
            return;
         }

         this.method_271();
         if(!this.field_372 && var1 != EventType.START) {
            this.field_365.sendMeasurmement(this.method_229(EventType.START, new HashMap(), this.field_343), false);
         }

         if(var1 != EventType.CLOSE) {
            this.field_365.sendMeasurmement(this.method_229(var1, Utils.mapOfStrings(var2), this.field_343), false);
            return;
         }
      }

   }

   // $FF: renamed from: a (com.comscore.utils.Storage) void
   protected void method_238(Storage var1) {
      this.method_210();
      this.field_365.loadEventData();
   }

   // $FF: renamed from: a (java.lang.String) void
   void method_239(String var1) {
      if(this.field_358) {
         int var2 = var1.indexOf(63);
         if(var2 >= 0) {
            if(var2 < -1 + var1.length()) {
               String[] var3 = var1.substring(var2 + 1).split("&");
               int var4 = var3.length;

               for(int var5 = 0; var5 < var4; ++var5) {
                  String[] var6 = var3[var5].split("=");
                  if(var6.length == 2) {
                     this.setLabel(var6[0], var6[1], false);
                  } else if(var6.length == 1) {
                     this.setLabel("name", var6[0], false);
                  }
               }

               var1 = var1.substring(0, var2 + 1);
            }
         } else {
            var1 = var1 + '?';
         }

         this.field_343 = var1;
      }
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String) void
   void method_240(String var1, String var2) {
      ArrayList var3 = new ArrayList();
      var3.add(var2);
      this.method_241(var1, var3);
   }

   // $FF: renamed from: a (java.lang.String, java.util.ArrayList) void
   void method_241(String var1, ArrayList<String> var2) {
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         String var5 = this.field_360.get(var1);
         String var6 = this.field_360.get(var4);
         if(Utils.isNotEmpty(var5) && Utils.isEmpty(var6)) {
            this.field_360.set(var4, var5);
         }
      }

      this.field_360.remove(var1);
   }

   // $FF: renamed from: a (boolean) void
   protected void method_242(boolean var1) {
      if(this.field_358) {
         long var2 = Date.unixTime();
         long var4 = var2 - this.field_328;
         switch(class_9.field_18[this.field_382.ordinal()]) {
         case 1:
            this.field_325 += var4;
            this.field_322 += var4;
            break;
         case 2:
            this.field_323 += var4;
            this.field_321 += var4;
            break;
         case 3:
            this.field_324 += var4;
            this.field_320 += var4;
         }

         this.field_328 = var2;
         if(var1) {
            this.field_360.set("lastApplicationAccumulationTimestamp", Long.toString(this.field_328));
            this.field_360.set("foregroundTransitionsCount", Long.toString((long)this.field_319.get()));
            this.field_360.set("accumulatedForegroundTime", Long.toString(this.field_324));
            this.field_360.set("accumulatedBackgroundTime", Long.toString(this.field_323));
            this.field_360.set("accumulatedInactiveTime", Long.toString(this.field_325));
            this.field_360.set("totalForegroundTime", Long.toString(this.field_320));
            this.field_360.set("totalBackgroundTime", Long.toString(this.field_321));
            this.field_360.set("totalInactiveTime", Long.toString(this.field_322));
            return;
         }
      }

   }

   public void allowLiveTransmission(TransmissionMode var1, boolean var2) {
      if(this.field_358 && var1 != null) {
         if(!var2) {
            this.method_216(var1);
            return;
         }

         if(this.field_364 != null && this.getLiveTransmissionMode() != var1) {
            this.field_364.execute(new class_47(this, var1), var2);
            return;
         }
      }

   }

   public void allowOfflineTransmission(TransmissionMode var1, boolean var2) {
      if(this.field_358 && var1 != null) {
         if(!var2) {
            this.method_220(var1);
            return;
         }

         if(this.field_364 != null && this.getOfflineTransmissionMode() != var1) {
            this.field_364.execute(new class_48(this, var1), var2);
            return;
         }
      }

   }

   // $FF: renamed from: b () com.comscore.utils.Storage
   protected Storage method_243() {
      return new Storage(this.field_346);
   }

   // $FF: renamed from: b (com.comscore.analytics.ApplicationState) void
   protected void method_244(ApplicationState var1) {
      if(this.field_358) {
         CSLog.method_372(this, "Entering application state: " + var1);
         switch(class_9.field_18[var1.ordinal()]) {
         case 1:
            this.field_366.stop();
            this.field_361.stop();
            this.field_362.stop();

            try {
               this.field_346.unregisterReceiver(this.field_366);
            } catch (IllegalArgumentException var4) {
               ;
            }

            this.method_269();
            return;
         case 2:
            if(!this.field_370) {
               this.method_268();
               return;
            }
            break;
         case 3:
            this.method_268();
            this.field_319.getAndIncrement();
            return;
         default:
            return;
         }
      }

   }

   // $FF: renamed from: b (com.comscore.analytics.SessionState) void
   protected void method_245(SessionState var1) {
      if(this.field_358) {
         CSLog.method_372(this, "Entering session state: " + var1);
         switch(class_9.field_19[var1.ordinal()]) {
         case 1:
            this.method_263();
            this.method_261();
         case 2:
            this.method_264();
         case 3:
            this.method_262();
            return;
         default:
         }
      }
   }

   // $FF: renamed from: b (boolean) void
   protected void method_246(boolean var1) {
      if(this.field_358) {
         long var2 = Date.unixTime();
         long var4 = var2 - this.field_341;
         switch(class_9.field_19[this.field_329.ordinal()]) {
         case 1:
            this.field_332 += var4;
            this.field_338 = var2;
         case 2:
            this.field_331 += var4;
            this.field_337 = var2;
         case 3:
            this.field_330 += var4;
            this.field_336 = var2;
         default:
            this.field_341 = var2;
            if(var1) {
               this.field_360.set("lastSessionAccumulationTimestamp", Long.toString(this.field_341));
               this.field_360.set("lastApplicationSessionTimestamp", Long.toString(this.field_336));
               this.field_360.set("lastUserSessionTimestamp", Long.toString(this.field_337));
               this.field_360.set("lastActiveUserSessionTimestamp", Long.toString(this.field_338));
               this.field_360.set("accumulatedApplicationSessionTime", Long.toString(this.field_330));
               this.field_360.set("accumulatedActiveUserSessionTime", Long.toString(this.field_332));
               this.field_360.set("accumulatedUserSessionTime", Long.toString(this.field_331));
               this.field_360.set("activeUserSessionCount", Long.toString((long)this.field_335));
               this.field_360.set("userSessionCount", Long.toString((long)this.field_334));
               this.field_360.set("lastUserInteractionTimestamp", Long.toString(this.field_340));
               this.field_360.set("userInteractionCount", Integer.toString(this.field_339));
               this.field_360.set("previousGenesis", Long.toString(this.field_327));
               this.field_360.set("genesis", Long.toString(this.field_326));
               this.field_360.set("applicationSessionCountKey", Integer.toString(this.field_333));
               return;
            }
         }
      }

   }

   // $FF: renamed from: c () com.comscore.utils.DispatchQueue
   @Deprecated
   protected DispatchQueue method_247() {
      return new DispatchQueue(this);
   }

   // $FF: renamed from: c (boolean) void
   void method_248(boolean var1) {
      this.field_349 = var1;
   }

   // $FF: renamed from: d () com.comscore.utils.task.TaskExecutor
   protected TaskExecutor method_249() {
      return new TaskExecutor(this);
   }

   // $FF: renamed from: d (boolean) void
   protected void method_250(boolean var1) {
      if(this.field_358) {
         this.field_372 = var1;
      }
   }

   public void disableAutoUpdate() {
      if(this.field_358) {
         this.method_269();
         this.field_370 = true;
         this.field_369 = -1L;
      }
   }

   // $FF: renamed from: e () com.comscore.measurement.MeasurementDispatcher
   protected MeasurementDispatcher method_251() {
      return new MeasurementDispatcher(this);
   }

   public void enableAutoUpdate(int var1, boolean var2, boolean var3) {
      if(this.field_358) {
         if(!var3) {
            this.method_232(var1, var2);
            return;
         }

         if(this.field_364 != null) {
            this.field_364.execute(new class_38(this, var1, var2), var3);
            return;
         }
      }

   }

   // $FF: renamed from: f () com.comscore.applications.KeepAlive
   protected KeepAlive method_252() {
      return new KeepAlive(this, 86400000L);
   }

   public void flush(boolean var1) {
      if(this.field_358 && this.field_364 != null) {
         this.field_364.execute(new class_36(this), var1);
      }
   }

   // $FF: renamed from: g () com.comscore.utils.OfflineMeasurementsCache
   protected OfflineMeasurementsCache method_253() {
      return new OfflineMeasurementsCache(this);
   }

   public int getActiveUserSessionCountDelta(boolean var1) {
      int var2 = -1;
      if(this.field_335 >= 0) {
         var2 = this.field_335;
         if(var1 && this.field_358) {
            this.field_335 = 0;
            this.field_360.set("activeUserSessionCount", Integer.toString(this.field_335));
         }
      }

      return var2;
   }

   public long getActiveUserSessionTimeDelta(boolean var1) {
      long var2 = this.field_332;
      if(var1 && this.field_358) {
         this.field_332 = 0L;
         this.field_360.set("accumulatedActiveUserSessionTime", Long.toString(this.field_332));
      }

      return var2;
   }

   public Context getAppContext() {
      return this.field_346;
   }

   public String getAppName() {
      // $FF: Couldn't be decompiled
   }

   public int getApplicationSessionCountDelta(boolean var1) {
      int var2 = this.field_333;
      if(var1 && this.field_358) {
         this.field_333 = 0;
         this.field_360.set("applicationSessionCountKey", Integer.toString(this.field_333));
      }

      return var2;
   }

   public long getApplicationSessionTimeDelta(boolean var1) {
      long var2 = this.field_330;
      if(var1 && this.field_358) {
         this.field_330 = 0L;
         this.field_360.set("accumulatedApplicationSessionTime", Long.toString(this.field_330));
      }

      return var2;
   }

   public ApplicationState getApplicationState() {
      return this.field_382;
   }

   public String getAutoStartLabel(String var1) {
      return (String)this.field_348.get(var1);
   }

   public HashMap<String, String> getAutoStartLabels() {
      return this.field_348;
   }

   public long getAutoUpdateInterval() {
      return this.field_369;
   }

   public long getBackgroundTimeDelta(boolean var1) {
      long var2 = this.field_323;
      if(var1 && this.field_358) {
         this.field_323 = 0L;
         this.field_360.set("accumulatedBackgroundTime", Long.toString(this.field_323));
      }

      return var2;
   }

   public long getBackgroundTotalTime(boolean var1) {
      long var2 = this.field_321;
      if(var1 && this.field_358) {
         this.field_321 = 0L;
         this.field_360.set("totalBackgroundTime", Long.toString(this.field_321));
      }

      return var2;
   }

   public CacheFlusher getCacheFlusher() {
      return this.field_362;
   }

   public long getCacheFlushingInterval() {
      return this.field_350;
   }

   public int getCacheMaxBatchFiles() {
      return this.field_344 != null?this.field_344.getCacheMaxBatchFiles():100;
   }

   public int getCacheMaxFlushesInARow() {
      return this.field_344 != null?this.field_344.getCacheMaxPosts():10;
   }

   public int getCacheMaxMeasurements() {
      return this.field_344 != null?this.field_344.getCacheMaxMeasurements():2000;
   }

   public long getCacheMeasurementExpiry() {
      return this.field_344 != null?this.field_344.getCacheMeasurementExpiry():31L;
   }

   public long getCacheMinutesToRetry() {
      return this.field_344 != null?this.field_344.getCacheWaitMinutes():30L;
   }

   public int getColdStartCount() {
      return this.field_375.get();
   }

   public long getColdStartId() {
      return this.field_374;
   }

   public ConnectivityChangeReceiver getConnectivityReceiver() {
      return this.field_366;
   }

   public String getCrossPublisherId() {
      return this.field_357 == null?null:this.field_357.getCrossPublisherId();
   }

   public String getCurrentActivityName() {
      return this.field_381;
   }

   public String getCurrentVersion() {
      return this.field_378;
   }

   public String getCustomerC2() {
      return (String)this.getLabels().get("c2");
   }

   public boolean getErrorHandlingEnabled() {
      return this.field_351;
   }

   public long getFirstInstallId() {
      return this.field_377;
   }

   public long getForegroundTimeDelta(boolean var1) {
      long var2 = this.field_324;
      if(var1 && this.field_358) {
         this.field_324 = 0L;
         this.field_360.set("accumulatedForegroundTime", Long.toString(this.field_324));
      }

      return var2;
   }

   public long getForegroundTotalTime(boolean var1) {
      long var2 = this.field_320;
      if(var1 && this.field_358) {
         this.field_320 = 0L;
         this.field_360.set("totalForegroundTime", Long.toString(this.field_320));
      }

      return var2;
   }

   public int getForegroundTransitionsCountDelta(boolean var1) {
      int var2 = this.field_319.get();
      if(var1 && this.field_358) {
         this.field_319.set(0);
         this.field_360.set("foregroundTransitionsCount", Long.toString((long)this.field_319.get()));
      }

      return var2;
   }

   public long getGenesis() {
      return this.field_326;
   }

   public IdHelper getIdHelper() {
      return this.field_357;
   }

   public long getInactiveTimeDelta(boolean var1) {
      long var2 = this.field_325;
      if(var1 && this.field_358) {
         this.field_325 = 0L;
         this.field_360.set("accumulatedInactiveTime", Long.toString(this.field_325));
      }

      return var2;
   }

   public long getInactiveTotalTime(boolean var1) {
      long var2 = this.field_322;
      if(var1 && this.field_358) {
         this.field_322 = 0L;
         this.field_360.set("totalInactiveTime", Long.toString(this.field_322));
      }

      return var2;
   }

   public long getInstallId() {
      return this.field_376;
   }

   public KeepAlive getKeepAlive() {
      return this.field_361;
   }

   public String getLabel(String var1) {
      return (String)this.field_347.get(var1);
   }

   public HashMap<String, String> getLabels() {
      return this.field_347;
   }

   public TransmissionMode getLiveTransmissionMode() {
      return this.field_354;
   }

   public MeasurementDispatcher getMeasurementDispatcher() {
      return this.field_365;
   }

   public String[] getMeasurementLabelOrder() {
      return this.field_356;
   }

   public OfflineMeasurementsCache getOfflineCache() {
      return this.field_344;
   }

   public TransmissionMode getOfflineTransmissionMode() {
      return this.field_355;
   }

   public String getPixelURL() {
      return this.field_343;
   }

   public long getPreviousGenesis() {
      return this.field_327;
   }

   public String getPreviousVersion() {
      String var1 = this.field_379;
      if(this.field_379 != null && this.field_379.length() > 0) {
         this.field_360.remove("previousVersion");
         this.field_379 = null;
      }

      return var1;
   }

   public String getPublisherSecret() {
      return this.field_357 == null?"":this.field_357.getPublisherSecret();
   }

   public DispatchQueue getQueue() {
      return this.field_363;
   }

   public int getRunsCount() {
      return this.field_373.get();
   }

   @Deprecated
   public String getSalt() {
      return this.getPublisherSecret();
   }

   public SessionState getSessionState() {
      return this.field_329;
   }

   public Storage getStorage() {
      return this.field_360;
   }

   public TaskExecutor getTaskExecutor() {
      return this.field_364;
   }

   public int getUserInteractionCount(boolean var1) {
      int var2 = this.field_339;
      if(var1 && this.field_358) {
         this.field_339 = 0;
         this.field_360.set("userInteractionCount", Integer.toString(this.field_339));
      }

      return var2;
   }

   public int getUserSessionCountDelta(boolean var1) {
      int var2 = -1;
      if(this.field_334 >= 0) {
         var2 = this.field_334;
         if(var1 && this.field_358) {
            this.field_334 = 0;
            this.field_360.set("userSessionCount", Integer.toString(this.field_334));
         }
      }

      return var2;
   }

   public long getUserSessionTimeDelta(boolean var1) {
      long var2 = this.field_331;
      if(var1 && this.field_358) {
         this.field_331 = 0L;
         this.field_360.set("accumulatedUserSessionTime", Long.toString(this.field_331));
      }

      return var2;
   }

   public String getVersion() {
      return "3.1508.28";
   }

   public String getVisitorId() {
      return this.field_357 == null?null:this.field_357.getVisitorId();
   }

   // $FF: renamed from: h () com.comscore.utils.CacheFlusher
   protected CacheFlusher method_254() {
      return new CacheFlusher(this);
   }

   public boolean handleColdStart() {
      if(this.field_358 && !this.field_372) {
         this.field_372 = true;
         this.field_375.getAndIncrement();
         this.field_360.set("coldStartCount", String.valueOf(this.field_375));
         this.field_374 = Date.unixTime();
         return true;
      } else {
         return false;
      }
   }

   // $FF: renamed from: i () com.comscore.utils.ConnectivityChangeReceiver
   protected ConnectivityChangeReceiver method_255() {
      return new ConnectivityChangeReceiver(this);
   }

   public void incrementRunsCount() {
      if(this.field_358) {
         this.field_373.getAndIncrement();
         this.field_360.set("runs", Long.toString((long)this.field_373.get()));
      }
   }

   public boolean isAutoStartEnabled() {
      return this.field_380;
   }

   public boolean isAutoUpdateEnabled() {
      return this.field_369 > 0L;
   }

   public boolean isEnabled() {
      return this.field_358;
   }

   public boolean isKeepAliveEnabled() {
      return this.field_349;
   }

   public boolean isSecure() {
      return this.field_353;
   }

   // $FF: renamed from: j () void
   protected void method_256() {
      this.field_328 = Utils.getLong(this.field_360.get("lastApplicationAccumulationTimestamp"), -1L);
      this.field_341 = Utils.getLong(this.field_360.get("lastSessionAccumulationTimestamp"), -1L);
      this.field_336 = Utils.getLong(this.field_360.get("lastApplicationSessionTimestamp"), -1L);
      this.field_337 = Utils.getLong(this.field_360.get("lastUserSessionTimestamp"), -1L);
      this.field_338 = Utils.getLong(this.field_360.get("lastActiveUserSessionTimestamp"), -1L);
      this.field_319.set(Utils.getInteger(this.field_360.get("foregroundTransitionsCount")));
      this.field_324 = Utils.getLong(this.field_360.get("accumulatedForegroundTime"));
      this.field_323 = Utils.getLong(this.field_360.get("accumulatedBackgroundTime"));
      this.field_325 = Utils.getLong(this.field_360.get("accumulatedInactiveTime"));
      this.field_320 = Utils.getLong(this.field_360.get("totalForegroundTime"));
      this.field_321 = Utils.getLong(this.field_360.get("totalBackgroundTime"));
      this.field_322 = Utils.getLong(this.field_360.get("totalInactiveTime"));
      this.field_330 = Utils.getLong(this.field_360.get("accumulatedApplicationSessionTime"));
      this.field_332 = Utils.getLong(this.field_360.get("accumulatedActiveUserSessionTime"));
      this.field_331 = Utils.getLong(this.field_360.get("accumulatedUserSessionTime"));
      this.field_335 = Utils.getInteger(this.field_360.get("activeUserSessionCount"), -1);
      this.field_334 = Utils.getInteger(this.field_360.get("userSessionCount"), -1);
      this.field_340 = Utils.getLong(this.field_360.get("lastUserInteractionTimestamp"), -1L);
      this.field_339 = Utils.getInteger(this.field_360.get("userInteractionCount"), 0);
      this.field_333 = Utils.getInteger(this.field_360.get("applicationSessionCountKey"), 0);
      this.field_378 = this.method_257();
      this.field_327 = Utils.getLong(this.field_360.get("previousGenesis"), 0L);
      this.field_326 = Utils.getLong(this.field_360.get("genesis"), -1L);
      if(this.field_326 < 0L) {
         this.field_326 = Date.unixTime();
         this.field_327 = 0L;
         this.field_336 = this.field_326;
         ++this.field_333;
      } else {
         if(!this.method_262()) {
            this.field_330 += Date.unixTime() - this.field_341;
            this.field_360.set("accumulatedApplicationSessionTime", Long.toString(this.field_330));
         }

         this.field_336 = this.field_326;
      }

      this.field_377 = Utils.getLong(this.field_360.get("firstInstallId"), -1L);
      if(this.field_377 < 0L) {
         this.field_377 = this.field_326;
         this.field_376 = this.field_326;
         this.field_360.set("currentVersion", this.field_378);
         this.field_360.set("firstInstallId", String.valueOf(this.field_377));
         this.field_360.set("installId", String.valueOf(this.field_376));
      } else {
         if(this.field_360.has("previousVersion").booleanValue()) {
            this.field_379 = this.field_360.get("previousVersion");
         }

         String var1 = this.field_360.get("currentVersion");
         if(!var1.equals(this.field_378)) {
            this.field_379 = var1;
            this.field_360.set("previousVersion", this.field_379);
            this.field_376 = this.field_326;
            this.field_360.set("installId", String.valueOf(this.field_376));
         } else {
            this.field_376 = Utils.getLong(this.field_360.get("installId"), -1L);
         }

         this.field_360.set("currentVersion", this.field_378);
      }

      this.field_360.set("genesis", Long.toString(this.field_326));
      this.field_360.set("previousGenesis", Long.toString(this.field_327));
      long var2 = Date.unixTime();
      if(this.field_328 >= 0L) {
         long var4 = var2 - this.field_328;
         this.field_325 += var4;
         this.field_360.set("accumulatedInactiveTime", Long.toString(this.field_325));
         this.field_322 += var4;
         this.field_360.set("totalInactiveTime", Long.toString(this.field_322));
      }

      this.field_328 = var2;
      this.field_341 = var2;
      this.field_360.set("lastApplicationAccumulationTimestamp", Long.toString(this.field_328));
      this.field_360.set("lastSessionAccumulationTimestamp", Long.toString(this.field_341));
      this.field_360.set("lastApplicationSessionTimestamp", Long.toString(this.field_336));
      if(!this.field_360.has("runs").booleanValue()) {
         this.field_360.set("runs", "0");
      }

      this.field_373.set(Utils.getInteger(this.field_360.get("runs")));
      this.field_375.set(Utils.getInteger(this.field_360.get("coldStartCount")));
   }

   // $FF: renamed from: k () java.lang.String
   protected String method_257() {
      String var1 = this.field_346.getPackageName();

      try {
         String var3 = this.field_346.getPackageManager().getPackageInfo(var1, 0).versionName;
         return var3;
      } catch (NameNotFoundException var4) {
         return "0";
      }
   }

   // $FF: renamed from: l () void
   protected void method_258() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: m () android.content.Context
   protected Context method_259() {
      return this.field_346;
   }

   // $FF: renamed from: n () void
   protected void method_260() {
      if(this.field_358) {
         if(this.field_364.containsTask(this.field_368)) {
            this.field_364.removeEnqueuedTask(this.field_368);
            this.field_368 = null;
         }

         long var1 = Date.unixTime();
         ApplicationState var3;
         if(this.field_383.get() > 0) {
            var3 = ApplicationState.FOREGROUND;
         } else if(this.field_318.get() > 0) {
            var3 = ApplicationState.BACKGROUND_UX_ACTIVE;
         } else {
            var3 = ApplicationState.INACTIVE;
         }

         SessionState var4;
         if(var1 - this.field_340 < 300000L) {
            var4 = SessionState.ACTIVE_USER;
         } else if(this.field_318.get() > 0) {
            var4 = SessionState.USER;
         } else if(this.field_383.get() > 0) {
            var4 = SessionState.APPLICATION;
         } else {
            var4 = SessionState.INACTIVE;
         }

         ApplicationState var5 = this.field_382;
         SessionState var6 = this.field_329;
         if(var3 != var5 || var4 != var6) {
            this.field_368 = new class_13(this, var5, var3, var6, var4);
            if(this.field_371 && var3 != ApplicationState.FOREGROUND) {
               this.field_364.execute(this.field_368, 300L);
               return;
            }

            this.field_368.run();
            this.field_368 = null;
            return;
         }
      }

   }

   public void notify(EventType var1, HashMap<String, String> var2, boolean var3) {
      if(this.field_358) {
         if(!var3) {
            this.method_237(var1, var2);
            return;
         }

         if(this.field_364 != null) {
            this.field_364.execute(new class_25(this, var1, var2), var3);
            return;
         }
      }

   }

   // $FF: renamed from: o () void
   protected void method_261() {
      if(this.field_358) {
         if(this.field_342 != null) {
            this.field_364.removeEnqueuedTask(this.field_342);
            this.field_342 = null;
         }

         this.field_342 = new Core$UserInteractionTask(this);
         this.field_364.execute(this.field_342, 300000L);
      }
   }

   public void onEnterForeground() {
      if(this.field_358 && this.field_364 != null) {
         this.field_364.execute(new class_8(this), true);
      }
   }

   public void onExitForeground() {
      if(this.field_358 && this.field_364 != null) {
         this.field_364.execute(new class_11(this), true);
      }
   }

   public void onUserInteraction() {
      if(this.field_358 && this.field_364 != null) {
         this.field_364.execute(new class_10(this), true);
      }
   }

   public void onUxActive() {
      if(this.field_358 && this.field_364 != null) {
         this.field_364.execute(new class_50(this), true);
      }
   }

   public void onUxInactive() {
      if(this.field_358 && this.field_364 != null) {
         this.field_364.execute(new class_37(this), true);
      }
   }

   // $FF: renamed from: p () boolean
   protected boolean method_262() {
      if(!this.field_358) {
         return false;
      } else {
         long var1 = Date.unixTime();
         long var5;
         int var3 = (var5 = var1 - this.field_336 - 1800000L) == 0L?0:(var5 < 0L?-1:1);
         boolean var4 = false;
         if(var3 > 0) {
            this.field_327 = this.field_326;
            this.field_326 = var1;
            ++this.field_333;
            var4 = true;
         }

         this.field_336 = var1;
         return var4;
      }
   }

   // $FF: renamed from: q () void
   protected void method_263() {
      if(this.field_358) {
         long var1 = Date.unixTime();
         if(var1 - this.field_338 >= 300000L) {
            ++this.field_335;
         }

         this.field_338 = var1;
      }
   }

   // $FF: renamed from: r () void
   protected void method_264() {
      if(this.field_358) {
         long var1 = Date.unixTime();
         if(var1 - this.field_337 >= 300000L) {
            ++this.field_334;
         }

         this.field_337 = var1;
      }
   }

   public void reset() {
      this.field_354 = TransmissionMode.DEFAULT;
      this.field_355 = TransmissionMode.DEFAULT;
      this.field_353 = false;
      this.field_356 = Constants.LABELS_ORDER;
      this.field_382 = ApplicationState.INACTIVE;
      this.field_329 = SessionState.INACTIVE;
      this.field_372 = false;
      this.field_373.set(0);
      this.field_374 = -1L;
      this.field_375.set(0);
      this.field_377 = -1L;
      this.field_376 = -1L;
      this.field_378 = null;
      this.field_379 = null;
      this.field_383.set(0);
      this.field_318.set(0);
      this.field_320 = 0L;
      this.field_321 = 0L;
      this.field_322 = 0L;
      this.field_323 = 0L;
      this.field_324 = 0L;
      this.field_325 = 0L;
      this.field_330 = 0L;
      this.field_332 = 0L;
      this.field_331 = 0L;
      this.field_326 = -1L;
      this.field_327 = 0L;
      this.field_335 = -1;
      this.field_334 = -1;
      this.field_339 = 0;
      this.field_340 = -1L;
      this.field_328 = -1L;
      this.field_341 = -1L;
      this.field_336 = -1L;
      this.field_337 = -1L;
      this.field_338 = -1L;
      this.field_376 = -1L;
      this.field_377 = -1L;
      this.disableAutoUpdate();
      if(this.field_368 != null) {
         this.field_364.removeEnqueuedTask(this.field_368);
         this.field_368 = null;
      }

      if(this.field_342 != null) {
         this.field_364.removeEnqueuedTask(this.field_342);
         this.field_342 = null;
      }

      if(this.field_361 != null) {
         this.field_361.cancel();
      }

      if(this.field_362 != null) {
         this.field_362.stop();
      }

      if(this.field_364 != null) {
         this.field_364.removeAllEnqueuedTasks();
      }

      if(this.field_360 != null) {
         this.field_360.close();
      }

   }

   public void resetVisitorId() {
      this.field_364.execute(new class_32(this), true);
   }

   // $FF: renamed from: s () void
   protected void method_265() {
      this.method_242(true);
   }

   public void setAppContext(Context var1) {
      if(this.field_346 == null && var1 != null) {
         this.field_346 = var1;
         this.field_364 = this.method_249();
         this.field_364.execute(new class_12(this), true);
      }
   }

   public void setAppName(String var1, boolean var2) {
      if(this.field_358) {
         if(!var2) {
            this.method_226(var1);
            return;
         }

         if(this.field_364 != null) {
            this.field_364.execute(new class_28(this, var1), var2);
            return;
         }
      }

   }

   public void setAutoStartEnabled(boolean var1, boolean var2) {
      if(this.field_358) {
         this.field_364.execute(new class_44(this, var1), var2);
      }
   }

   public void setAutoStartLabel(String var1, String var2) {
      if(this.field_358) {
         this.field_348.put(var1, var2);
      }
   }

   public void setAutoStartLabels(HashMap<String, String> var1) {
      if(this.field_358 && var1 != null) {
         this.field_348.putAll(Utils.mapOfStrings(var1));
      }
   }

   public void setCacheFlushingInterval(long var1, boolean var3) {
      if(this.field_358 && this.field_364 != null && this.field_350 != var1) {
         this.field_364.execute(new class_42(this, var1), var3);
      }
   }

   public void setCacheMaxBatchFiles(int var1, boolean var2) {
      if(this.field_358 && this.field_364 != null && this.field_344 != null) {
         this.field_364.execute(new class_46(this, var1), var2);
      }
   }

   public void setCacheMaxFlushesInARow(int var1, boolean var2) {
      if(this.field_358 && this.field_364 != null && this.field_344 != null) {
         this.field_364.execute(new class_39(this, var1), var2);
      }
   }

   public void setCacheMaxMeasurements(int var1, boolean var2) {
      if(this.field_358 && this.field_364 != null && this.field_344 != null) {
         this.field_364.execute(new class_45(this, var1), var2);
      }
   }

   public void setCacheMeasurementExpiry(int var1, boolean var2) {
      if(this.field_358 && this.field_364 != null && this.field_344 != null) {
         this.field_364.execute(new class_41(this, var1), var2);
      }
   }

   public void setCacheMinutesToRetry(int var1, boolean var2) {
      if(this.field_358 && this.field_364 != null && this.field_344 != null) {
         this.field_364.execute(new class_40(this, var1), var2);
      }
   }

   public void setCurrentActivityName(String var1) {
      this.field_381 = var1;
   }

   public void setCustomerC2(String var1, boolean var2) {
      if(this.field_358 && var1 != null && var1.length() != 0) {
         if(!var2) {
            this.method_228(var1);
            return;
         }

         if(this.field_364 != null) {
            this.field_364.execute(new class_29(this, var1), var2);
            return;
         }
      }

   }

   public void setDebug(boolean var1) {
      if(this.field_358) {
         this.field_364.execute(new class_43(this, var1), true);
      }
   }

   public void setEnabled(boolean var1) {
      this.field_364.execute(new class_7(this, var1), true);
   }

   public void setErrorHandlingEnabled(boolean var1) {
      if(this.field_358) {
         this.field_351 = var1;
         if(var1) {
            Thread.setDefaultUncaughtExceptionHandler(new CustomExceptionHandler(this));
            return;
         }

         if(Thread.getDefaultUncaughtExceptionHandler() != this.field_352) {
            Thread.setDefaultUncaughtExceptionHandler(this.field_352);
            return;
         }
      }

   }

   public void setKeepAliveEnabled(boolean var1, boolean var2) {
      if(this.field_358) {
         if(!var2) {
            this.method_248(var1);
            return;
         }

         if(this.field_364 != null) {
            this.field_364.execute(new class_34(this, var1), var2);
            return;
         }
      }

   }

   public void setLabel(String var1, String var2, boolean var3) {
      if(this.field_358) {
         if(!var3) {
            this.method_222(var1, var2);
            return;
         }

         if(this.field_364 != null) {
            this.field_364.execute(new class_30(this, var1, var2), var3);
            return;
         }
      }

   }

   public void setLabels(HashMap<String, String> var1, boolean var2) {
      if(this.field_358 && var1 != null && this.field_364 != null) {
         this.field_364.execute(new class_27(this, var1), var2);
      }
   }

   public void setMeasurementLabelOrder(String[] var1, boolean var2) {
      if(this.field_358 && this.field_364 != null && var1 != this.field_356 && var1 != null && var1.length > 0) {
         this.field_364.execute(new class_35(this, var1), var2);
      }
   }

   public void setOfflineURL(String var1) {
      if(this.field_358 && var1 != null && var1.length() != 0 && this.field_364 != null) {
         this.field_364.execute(new class_31(this, var1), true);
      }
   }

   public void setPixelURL(String var1, boolean var2) {
      if(this.field_358 && var1 != null && var1.length() != 0) {
         if(!var2) {
            this.method_239(var1);
            return;
         }

         if(this.field_364 != null) {
            this.field_364.execute(new class_6(this, var1), var2);
            return;
         }
      }

   }

   public void setPublisherSecret(String var1, boolean var2) {
      if(this.field_358 && var1 != null && var1.length() != 0 && this.field_364 != null) {
         this.field_364.execute(new class_33(this, var1), var2);
      }
   }

   public void setSecure(boolean var1, boolean var2) {
      if(this.field_358) {
         if(!var2) {
            this.field_353 = var1;
            return;
         }

         if(this.field_364 != null) {
            this.field_364.execute(new class_49(this, var1), var2);
            return;
         }
      }

   }

   // $FF: renamed from: t () void
   protected void method_266() {
      this.method_246(true);
   }

   // $FF: renamed from: u () com.comscore.utils.OfflineMeasurementsCache
   protected OfflineMeasurementsCache method_267() {
      return this.field_344;
   }

   public void update() {
      this.update(true);
   }

   public void update(boolean var1) {
      if(this.field_358) {
         if(this.field_364.containsTask(this.field_368)) {
            this.field_364.removeEnqueuedTask(this.field_368);
            this.field_368.run();
            this.field_368 = null;
         }

         this.method_242(var1);
         this.method_246(var1);
      }
   }

   // $FF: renamed from: v () void
   protected void method_268() {
      if(this.field_358) {
         this.method_269();
         if(this.field_369 >= 60000L) {
            this.field_367 = new class_26(this);
            this.field_364.execute(this.field_367, this.field_369, true, this.field_369);
            return;
         }
      }

   }

   // $FF: renamed from: w () void
   protected void method_269() {
      if(this.field_358 && this.field_367 != null) {
         this.field_364.removeEnqueuedTask(this.field_367);
         this.field_367 = null;
      }
   }

   // $FF: renamed from: x () void
   protected void method_270() {
   }

   // $FF: renamed from: y () void
   protected void method_271() {
   }

   // $FF: renamed from: z () boolean
   boolean method_272() {
      return this.field_346 == null || this.field_357.isPublisherSecretEmpty() || this.field_343 == null || this.field_343.length() == 0;
   }
}
