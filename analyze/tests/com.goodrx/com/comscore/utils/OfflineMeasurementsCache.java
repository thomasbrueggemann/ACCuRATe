package com.comscore.utils;

import android.content.Context;
import com.comscore.analytics.Core;
import com.comscore.applications.ApplicationMeasurement;
import com.comscore.applications.EventType;
import com.comscore.measurement.Measurement;
import com.comscore.utils.CSLog;
import com.comscore.utils.Connectivity;
import com.comscore.utils.Date;
import com.comscore.utils.FileUtils;
import com.comscore.utils.Permissions;
import com.comscore.utils.Storage;
import com.comscore.utils.Utils;
import com.comscore.utils.XMLBuilder;
import com.comscore.utils.class_18;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class OfflineMeasurementsCache {
   // $FF: renamed from: a com.comscore.analytics.Core
   protected final Core field_249;
   // $FF: renamed from: b int
   private int field_250;
   // $FF: renamed from: c int
   private int field_251;
   // $FF: renamed from: d int
   private int field_252;
   // $FF: renamed from: e long
   private long field_253;
   // $FF: renamed from: f long
   private long field_254;
   // $FF: renamed from: g java.lang.String
   private String field_255;
   // $FF: renamed from: h java.lang.String
   private final String field_256;
   // $FF: renamed from: i java.util.ArrayList
   private ArrayList<String> field_257;
   // $FF: renamed from: j java.lang.String
   private String field_258;
   // $FF: renamed from: k int
   private int field_259;
   // $FF: renamed from: l long
   private long field_260;
   // $FF: renamed from: m long
   private long field_261;

   public OfflineMeasurementsCache(Core var1) {
      this(var1, "cs_cache_");
   }

   protected OfflineMeasurementsCache(Core var1, String var2) {
      this.field_255 = null;
      this.field_257 = null;
      this.field_258 = null;
      this.field_259 = 0;
      this.field_260 = 0L;
      this.field_261 = 0L;
      this.field_249 = var1;
      this.field_256 = var2;
      this.setCacheMaxMeasurements(2000);
      this.setCacheMaxBatchFiles(100);
      this.setCacheMaxPosts(10);
      this.setCacheWaitMinutes(30);
      this.setCacheMeasurementExpiry(31);
      this.method_199();
   }

   // $FF: renamed from: a (int) void
   private void method_186(int var1) {
      Storage var2 = this.field_249.getStorage();
      if(var2.has("CACHE_DROPPED_MEASUREMENTS").booleanValue()) {
         var1 += Integer.valueOf(var2.get("CACHE_DROPPED_MEASUREMENTS")).intValue();
      }

      var2.set("CACHE_DROPPED_MEASUREMENTS", String.valueOf(var1));
   }

   // $FF: renamed from: a (java.lang.String) void
   private void method_187(String var1) {
      Storage var2 = this.field_249.getStorage();
      if(var2.has(var1).booleanValue()) {
         this.method_186(Integer.valueOf(var2.get(var1)).intValue());
      }

   }

   // $FF: renamed from: a (java.lang.String, boolean) void
   private void method_188(String var1, boolean var2) {
      if(var1 != null) {
         if(var2) {
            this.method_187(var1);
         }

         FileUtils.deleteFile(this.field_249, var1);
         this.field_257.remove(var1);
      }

   }

   // $FF: renamed from: a (long) boolean
   private boolean method_189(long var1) {
      long var3 = Date.unixTime() - var1;
      return 1000L * 60L * 60L * 24L * this.field_254 - var3 <= 0L;
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String) boolean
   private boolean method_190(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.String[], int, int) java.lang.String[]
   private static String[] method_191(String[] var0, int var1, int var2) {
      if(var1 > var2) {
         throw new IllegalArgumentException();
      } else {
         int var3 = var0.length;
         if(var1 >= 0 && var1 <= var3) {
            int var4 = var2 - var1;
            int var5 = Math.min(var4, var3 - var1);
            String[] var6 = new String[var4];
            System.arraycopy(var0, var1, var6, 0, var5);
            return var6;
         } else {
            throw new ArrayIndexOutOfBoundsException();
         }
      }
   }

   // $FF: renamed from: b (java.lang.String) void
   private void method_192(String var1) {
      CSLog.method_372(this, "Creating new cache batch file");
      String var2 = this.field_256 + XMLBuilder.getLabelFromEvent(var1, "ns_ts");
      FileUtils.writeEvent(this.field_249, var2, 0, var1);
      if(this.field_257 == null) {
         this.field_257 = new ArrayList();
      }

      this.field_257.add(var2);
      this.method_195();
   }

   // $FF: renamed from: b () boolean
   private boolean method_193() {
      if(this.method_196().booleanValue() && !this.isEmpty() && this.field_249.getCustomerC2() != null) {
         if(this.field_259 < this.field_252) {
            return true;
         }

         long var1 = 60L * 1000L * this.field_253 - (Date.unixTime() - this.field_261);
         if(var1 <= 0L) {
            this.field_259 = 0;
            this.field_261 = 0L;
            return true;
         }

         CSLog.method_372(this, "Max flushes in a row (" + this.field_252 + ") reached. Waiting " + (double)var1 / 1000.0D / 60.0D + " minutes");
      }

      return false;
   }

   // $FF: renamed from: c (java.lang.String) int
   private int method_194(String var1) {
      Storage var2 = this.field_249.getStorage();
      int var3 = 0;
      if(var1 != null) {
         if(!var2.has(var1).booleanValue()) {
            return FileUtils.readCachedEvents(this.field_249.getAppContext(), var1).length;
         }

         var3 = Integer.valueOf(var2.get(var1)).intValue();
      }

      return var3;
   }

   // $FF: renamed from: c () void
   private void method_195() {
      this.field_260 = 0L;
      if(this.field_258 != null) {
         this.field_258 = null;
      }

   }

   // $FF: renamed from: d () java.lang.Boolean
   private Boolean method_196() {
      Context var1 = this.field_249.getAppContext();
      return Connectivity.isEmulator()?Boolean.valueOf(true):(!Permissions.check(var1, "android.permission.ACCESS_NETWORK_STATE").booleanValue()?Boolean.valueOf(true):(Connectivity.isConnectedWiFi(var1)?Boolean.valueOf(true):(Connectivity.isConnectedMobile(var1)?Boolean.valueOf(true):Boolean.valueOf(false))));
   }

   // $FF: renamed from: d (java.lang.String) java.lang.String[]
   private String[] method_197(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: e (java.lang.String) long
   private long method_198(String var1) {
      return Long.valueOf(var1.substring(this.field_256.length())).longValue();
   }

   // $FF: renamed from: e () void
   private void method_199() {
      List var1 = this.method_200();

      for(int var2 = -1 + var1.size(); var2 >= 0; --var2) {
         if(this.method_189(this.method_198((String)var1.get(var2)))) {
            CSLog.method_372(this, "Deleting expired cache file " + (String)var1.get(var2));
            this.method_188((String)var1.get(var2), true);
         }
      }

   }

   // $FF: renamed from: f () java.util.List
   private List<String> method_200() {
      if(this.field_257 == null) {
         this.field_257 = FileUtils.getFileList(this.field_249.getAppContext());
      }

      return this.field_257;
   }

   // $FF: renamed from: g () java.lang.String
   private String method_201() {
      return this.field_257 != null && this.field_257.size() > 0?(String)this.field_257.get(0):null;
   }

   // $FF: renamed from: h () java.lang.String
   private String method_202() {
      return this.field_257 != null && this.field_257.size() > 0?(String)this.field_257.get(-1 + this.field_257.size()):null;
   }

   // $FF: renamed from: a () java.lang.String
   protected String method_203() {
      StringBuilder var1;
      if(this.field_255 != null) {
         var1 = new StringBuilder(this.field_255);
      } else {
         String var13;
         if(this.field_249.isSecure()) {
            var13 = "https://udm.scorecardresearch.com/offline";
         } else {
            var13 = "http://udm.scorecardresearch.com/offline";
         }

         var1 = new StringBuilder(var13);
      }

      boolean var2;
      if(var1.indexOf("?") == -1) {
         var1.append("?");
         var2 = false;
      } else {
         var2 = true;
      }

      String var3 = this.field_249.getCustomerC2();
      if(var3 != null && !var3.equals("")) {
         if(var2) {
            var1.append("&");
         }

         var1.append("c2=");
         var1.append(var3);
         var2 = true;
      }

      Object[] var4 = new Object[]{this.field_249.getPublisherSecret()};
      String var5 = Utils.md5(String.format("JetportGotAMaskOfThe%sS.D_K-", var4));
      if(var5 != null && !var5.equals("")) {
         if(var2) {
            var1.append("&");
         }

         var1.append("s=");
         var1.append(var5);
      }

      return var1.toString().toLowerCase(new Locale("en", "US"));
   }

   public void clear() {
      if(this.field_249.isEnabled()) {
         List var1 = this.method_200();

         for(int var2 = var1.size(); var2 > 0; --var2) {
            this.method_188((String)var1.get(var2 - 1), true);
         }
      }

   }

   public boolean flush() {
      // $FF: Couldn't be decompiled
   }

   public int getCacheMaxBatchFiles() {
      return this.field_251;
   }

   public int getCacheMaxMeasurements() {
      return this.field_250;
   }

   public int getCacheMaxPosts() {
      return this.field_252;
   }

   public long getCacheMeasurementExpiry() {
      return this.field_254;
   }

   public long getCacheWaitMinutes() {
      return this.field_253;
   }

   public int getEventCount() {
      int var1 = this.method_194(this.method_202());
      List var2 = this.method_200();
      if(var2.size() > 0) {
         var1 += (-1 + var2.size()) * this.getCacheMaxBatchFiles();
      }

      return var1;
   }

   public boolean isEmpty() {
      return this.getEventCount() == 0;
   }

   public void saveApplicationMeasurement(EventType var1, HashMap<String, String> var2) {
      this.saveApplicationMeasurement(var1, var2, false);
   }

   public void saveApplicationMeasurement(EventType var1, HashMap<String, String> var2, boolean var3) {
      if(this.field_249.isEnabled()) {
         ApplicationMeasurement var4 = ApplicationMeasurement.newApplicationMeasurement(this.field_249, var1, var2, (String)null);
         this.field_249.getMeasurementDispatcher().addAggregateData(var4);
         this.field_249.getMeasurementDispatcher().addEventCounter(var4);
         this.saveEvent(var4, var3);
      }
   }

   public void saveEvent(Measurement var1) {
      this.saveEvent(var1, false);
   }

   public void saveEvent(Measurement var1, boolean var2) {
      if(this.field_249.isEnabled()) {
         if(var2) {
            this.field_249.getTaskExecutor().execute(new class_18(this, var1), true);
         } else {
            this.saveEvent(var1.retrieveLabelsAsString(this.field_249.getMeasurementLabelOrder()));
         }
      }
   }

   public void saveEvent(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void setCacheMaxBatchFiles(int var1) {
      if(this.field_249.isEnabled() && var1 > 0) {
         this.field_251 = var1;
      }
   }

   public void setCacheMaxMeasurements(int var1) {
      if(this.field_249.isEnabled()) {
         this.field_250 = var1;
      }
   }

   public void setCacheMaxPosts(int var1) {
      this.field_252 = var1;
   }

   public void setCacheMeasurementExpiry(int var1) {
      if(this.field_249.isEnabled()) {
         this.field_254 = (long)var1;
      }
   }

   public void setCacheWaitMinutes(int var1) {
      if(this.field_249.isEnabled()) {
         this.field_253 = (long)var1;
      }
   }

   public void setUrl(String var1) {
      if(this.field_249.isEnabled()) {
         this.field_255 = var1;
      }
   }
}
