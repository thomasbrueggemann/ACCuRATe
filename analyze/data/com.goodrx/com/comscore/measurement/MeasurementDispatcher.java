package com.comscore.measurement;

import com.comscore.analytics.Core;
import com.comscore.applications.AggregateMeasurement;
import com.comscore.measurement.Label;
import com.comscore.measurement.Measurement;
import com.comscore.measurement.class_53;
import com.comscore.metrics.Request;
import com.comscore.utils.CSLog;
import com.comscore.utils.Constants;
import com.comscore.utils.Date;
import com.comscore.utils.Storage;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class MeasurementDispatcher {
   public static final String DAY_CHECK_COUNTER = "q_dcc";
   public static final String DAY_CHECK_OFFSET = "q_dcf";
   public static final long MILLIS_PER_DAY = 86400000L;
   public static final long MILLIS_PER_SECOND = 1000L;
   // $FF: renamed from: a com.comscore.analytics.Core
   Core field_415;
   // $FF: renamed from: b java.util.concurrent.atomic.AtomicLong
   protected AtomicLong field_416 = new AtomicLong(-1L);
   // $FF: renamed from: c java.util.concurrent.atomic.AtomicInteger
   protected AtomicInteger field_417 = new AtomicInteger(0);
   // $FF: renamed from: d java.util.concurrent.atomic.AtomicLong
   protected AtomicLong field_418 = new AtomicLong(-1L);
   // $FF: renamed from: e java.util.concurrent.atomic.AtomicInteger
   protected AtomicInteger field_419 = new AtomicInteger(0);
   // $FF: renamed from: f java.util.concurrent.atomic.AtomicInteger
   protected AtomicInteger field_420 = new AtomicInteger(0);
   // $FF: renamed from: g java.lang.Object
   protected Object field_421 = new Object();
   // $FF: renamed from: h com.comscore.applications.AggregateMeasurement
   private AggregateMeasurement field_422 = null;

   public MeasurementDispatcher(Core var1) {
      this.field_415 = var1;
   }

   // $FF: renamed from: a (com.comscore.applications.AggregateMeasurement) void
   private void method_308(AggregateMeasurement param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.comscore.measurement.MeasurementDispatcher, com.comscore.measurement.Measurement) void
   // $FF: synthetic method
   static void method_309(MeasurementDispatcher var0, Measurement var1) {
      var0.method_311(var1);
   }

   // $FF: renamed from: a () boolean
   private boolean method_310() {
      Storage var1 = this.field_415.getStorage();
      long var2 = Date.unixTime();
      if(var2 < this.field_416.get()) {
         this.field_417.set(0);
         this.field_416.set(var2);
         this.field_419.set(0);
         this.field_418.set(var2);
         var1.set("q_dcc", Integer.toString(this.field_419.get(), 10));
         var1.set("q_dcf", Long.toString(this.field_418.get(), 10));
      } else {
         if(var2 - this.field_416.get() > 1000L) {
            this.field_417.set(0);
            this.field_416.set(var2);
         }

         if(var2 - this.field_418.get() > 86400000L) {
            this.field_419.set(0);
            this.field_418.set(var2);
            var1.set("q_dcc", Integer.toString(this.field_419.get(), 10));
            var1.set("q_dcf", Long.toString(this.field_418.get(), 10));
         }
      }

      int var4 = this.field_417.get();
      boolean var5 = false;
      if(var4 < 20) {
         int var6 = this.field_419.get();
         var5 = false;
         if(var6 < 6000) {
            this.field_417.incrementAndGet();
            this.field_419.getAndIncrement();
            var1.set("q_dcc", Integer.toString(this.field_419.get(), 10));
            var5 = true;
         }
      }

      return var5;
   }

   // $FF: renamed from: b (com.comscore.measurement.Measurement) void
   private void method_311(Measurement var1) {
      if(this.field_415.isEnabled()) {
         CSLog.method_372(this, "sendMeasurmement: " + var1.retrieveLabelsAsString(this.field_415.getMeasurementLabelOrder()));
         this.addAggregateData(var1);
         if(!(var1 instanceof AggregateMeasurement)) {
            this.addEventCounter(var1);
            this.method_312(var1);
            (new Request(this.field_415, var1)).send();
            return;
         }
      }

   }

   // $FF: renamed from: a (com.comscore.measurement.Measurement) void
   protected void method_312(Measurement var1) {
      if(this.field_415.isEnabled()) {
         var1.setLabel(new Label("c12", this.field_415.getVisitorId(), Boolean.valueOf(false)));
         if(this.field_415.getCrossPublisherId() != null) {
            var1.setLabel(new Label("ns_ak", this.field_415.getCrossPublisherId(), Boolean.valueOf(false)));
            return;
         }
      }

   }

   public void addAggregateData(Measurement param1) {
      // $FF: Couldn't be decompiled
   }

   public void addEventCounter(Measurement var1) {
      if(this.field_415.isEnabled()) {
         this.field_420.getAndIncrement();
         var1.setLabel(new Label("ns_ap_ec", String.valueOf(this.field_420), Boolean.valueOf(false)));
      }
   }

   public void loadEventData() {
      if(this.field_415.isEnabled()) {
         Storage var1 = this.field_415.getStorage();
         if(var1.has("q_dcc").booleanValue() && var1.has("q_dcf").booleanValue()) {
            try {
               int var3 = Integer.parseInt(var1.get("q_dcc"), 10);
               long var4 = Long.parseLong(var1.get("q_dcf"), 10);
               if(Date.unixTime() >= var4) {
                  this.field_419.set(var3);
                  this.field_418.set(var4);
                  return;
               }
            } catch (NumberFormatException var6) {
               if(Constants.DEBUG) {
                  CSLog.method_374(this, "Unexpected error parsing storage data: ");
                  CSLog.printStackTrace(var6);
                  throw var6;
               }
            }
         }
      }

   }

   public boolean sendMeasurmement(Measurement var1, boolean var2) {
      if(this.field_415.isEnabled() && var1 != null) {
         if(!this.method_310() && this.field_415.getStorage() != null) {
            CSLog.method_372(this, "Data not sent");
            return false;
         } else {
            return this.field_415.getTaskExecutor().execute(new class_53(this, var1), var2);
         }
      } else {
         return false;
      }
   }
}
