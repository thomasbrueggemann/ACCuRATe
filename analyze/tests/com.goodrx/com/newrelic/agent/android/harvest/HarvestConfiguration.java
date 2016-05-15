package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.activity.config.ActivityTraceConfiguration;
import com.newrelic.agent.android.harvest.DataToken;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class HarvestConfiguration {
   private static final int DEFAULT_ACTIVITY_TRACE_LENGTH = 65534;
   private static final int DEFAULT_ACTIVITY_TRACE_MAX_REPORT_ATTEMPTS = 1;
   private static final float DEFAULT_ACTIVITY_TRACE_MIN_UTILIZATION = 0.3F;
   private static final int DEFAULT_ERROR_LIMIT = 50;
   private static final int DEFAULT_MAX_TRANSACTION_AGE = 600;
   private static final int DEFAULT_MAX_TRANSACTION_COUNT = 1000;
   private static final int DEFAULT_REPORT_PERIOD = 60;
   private static final int DEFAULT_RESPONSE_BODY_LIMIT = 2048;
   private static final int DEFAULT_STACK_TRACE_LIMIT = 100;
   private static HarvestConfiguration defaultHarvestConfiguration;
   private int activity_trace_max_report_attempts;
   private int activity_trace_max_size;
   private double activity_trace_min_utilization;
   private ActivityTraceConfiguration at_capture;
   private boolean collect_network_errors;
   private String cross_process_id;
   private int data_report_period;
   private int[] data_token;
   private int error_limit;
   private int report_max_transaction_age;
   private int report_max_transaction_count;
   private int response_body_limit;
   private long server_timestamp;
   private int stack_trace_limit;

   public HarvestConfiguration() {
      this.setDefaultValues();
   }

   public static HarvestConfiguration getDefaultHarvestConfiguration() {
      if(defaultHarvestConfiguration != null) {
         return defaultHarvestConfiguration;
      } else {
         defaultHarvestConfiguration = new HarvestConfiguration();
         return defaultHarvestConfiguration;
      }
   }

   public boolean equals(Object var1) {
      boolean var2;
      if(this == var1) {
         var2 = true;
      } else {
         var2 = false;
         if(var1 != null) {
            Class var3 = this.getClass();
            Class var4 = var1.getClass();
            var2 = false;
            if(var3 == var4) {
               HarvestConfiguration var5 = (HarvestConfiguration)var1;
               boolean var6 = this.collect_network_errors;
               boolean var7 = var5.collect_network_errors;
               var2 = false;
               if(var6 == var7) {
                  int var8 = this.data_report_period;
                  int var9 = var5.data_report_period;
                  var2 = false;
                  if(var8 == var9) {
                     int var10 = this.error_limit;
                     int var11 = var5.error_limit;
                     var2 = false;
                     if(var10 == var11) {
                        int var12 = this.report_max_transaction_age;
                        int var13 = var5.report_max_transaction_age;
                        var2 = false;
                        if(var12 == var13) {
                           int var14 = this.report_max_transaction_count;
                           int var15 = var5.report_max_transaction_count;
                           var2 = false;
                           if(var14 == var15) {
                              int var16 = this.response_body_limit;
                              int var17 = var5.response_body_limit;
                              var2 = false;
                              if(var16 == var17) {
                                 int var18 = this.stack_trace_limit;
                                 int var19 = var5.stack_trace_limit;
                                 var2 = false;
                                 if(var18 == var19) {
                                    int var20 = this.activity_trace_max_size;
                                    int var21 = var5.activity_trace_max_size;
                                    var2 = false;
                                    if(var20 == var21) {
                                       int var22 = this.activity_trace_max_report_attempts;
                                       int var23 = var5.activity_trace_max_report_attempts;
                                       var2 = false;
                                       if(var22 == var23) {
                                          if(this.cross_process_id == null) {
                                             String var28 = var5.cross_process_id;
                                             var2 = false;
                                             if(var28 != null) {
                                                return var2;
                                             }
                                          }

                                          if(this.cross_process_id != null) {
                                             String var27 = var5.cross_process_id;
                                             var2 = false;
                                             if(var27 == null) {
                                                return var2;
                                             }
                                          }

                                          if(this.cross_process_id != null) {
                                             boolean var26 = this.cross_process_id.equals(var5.cross_process_id);
                                             var2 = false;
                                             if(!var26) {
                                                return var2;
                                             }
                                          }

                                          int var24 = 100 * (int)this.activity_trace_min_utilization;
                                          int var25 = 100 * (int)var5.activity_trace_min_utilization;
                                          var2 = false;
                                          if(var24 == var25) {
                                             return Arrays.equals(this.data_token, var5.data_token);
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public int getActivity_trace_max_report_attempts() {
      return this.activity_trace_max_report_attempts;
   }

   public int getActivity_trace_max_size() {
      return this.activity_trace_max_size;
   }

   public double getActivity_trace_min_utilization() {
      return this.activity_trace_min_utilization;
   }

   public ActivityTraceConfiguration getAt_capture() {
      return this.at_capture;
   }

   public String getCross_process_id() {
      return this.cross_process_id;
   }

   public DataToken getDataToken() {
      return this.data_token == null?null:new DataToken(this.data_token[0], this.data_token[1]);
   }

   public int getData_report_period() {
      return this.data_report_period;
   }

   public int[] getData_token() {
      return this.data_token;
   }

   public int getError_limit() {
      return this.error_limit;
   }

   public long getReportMaxTransactionAgeMilliseconds() {
      return TimeUnit.MILLISECONDS.convert((long)this.report_max_transaction_age, TimeUnit.SECONDS);
   }

   public int getReport_max_transaction_age() {
      return this.report_max_transaction_age;
   }

   public int getReport_max_transaction_count() {
      return this.report_max_transaction_count;
   }

   public int getResponse_body_limit() {
      return this.response_body_limit;
   }

   public long getServer_timestamp() {
      return this.server_timestamp;
   }

   public int getStack_trace_limit() {
      return this.stack_trace_limit;
   }

   public int hashCode() {
      byte var1;
      if(this.collect_network_errors) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      int var2 = var1 * 31;
      int var3;
      if(this.cross_process_id != null) {
         var3 = this.cross_process_id.hashCode();
      } else {
         var3 = 0;
      }

      int var4 = 31 * (31 * (var2 + var3) + this.data_report_period);
      int var5;
      if(this.data_token != null) {
         var5 = Arrays.hashCode(this.data_token);
      } else {
         var5 = 0;
      }

      int var6 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (var4 + var5) + this.error_limit) + this.report_max_transaction_age) + this.report_max_transaction_count) + this.response_body_limit) + this.stack_trace_limit) + this.activity_trace_max_size) + this.activity_trace_max_report_attempts;
      long var7 = Double.doubleToLongBits(this.activity_trace_min_utilization);
      int var9 = 31 * (var6 * 31 + (int)(var7 ^ var7 >>> 32));
      ActivityTraceConfiguration var10 = this.at_capture;
      int var11 = 0;
      if(var10 != null) {
         var11 = this.at_capture.hashCode();
      }

      return var9 + var11;
   }

   public boolean isCollect_network_errors() {
      return this.collect_network_errors;
   }

   public void reconfigure(HarvestConfiguration var1) {
      this.setCollect_network_errors(var1.isCollect_network_errors());
      if(var1.getCross_process_id() != null) {
         this.setCross_process_id(var1.getCross_process_id());
      }

      this.setData_report_period(var1.getData_report_period());
      if(var1.getDataToken().isValid()) {
         this.setData_token(var1.getData_token());
      }

      this.setError_limit(var1.getError_limit());
      this.setReport_max_transaction_age(var1.getReport_max_transaction_age());
      this.setReport_max_transaction_count(var1.getReport_max_transaction_count());
      this.setResponse_body_limit(var1.getResponse_body_limit());
      this.setServer_timestamp(var1.getServer_timestamp());
      this.setStack_trace_limit(var1.getStack_trace_limit());
      this.setActivity_trace_min_utilization(var1.getActivity_trace_min_utilization());
      this.setActivity_trace_max_report_attempts(var1.getActivity_trace_max_report_attempts());
      if(var1.getAt_capture() != null) {
         this.setAt_capture(var1.getAt_capture());
      }

   }

   public void setActivity_trace_max_report_attempts(int var1) {
      this.activity_trace_max_report_attempts = var1;
   }

   public void setActivity_trace_max_size(int var1) {
      this.activity_trace_max_size = var1;
   }

   public void setActivity_trace_min_utilization(double var1) {
      this.activity_trace_min_utilization = var1;
   }

   public void setAt_capture(ActivityTraceConfiguration var1) {
      this.at_capture = var1;
   }

   public void setCollect_network_errors(boolean var1) {
      this.collect_network_errors = var1;
   }

   public void setCross_process_id(String var1) {
      this.cross_process_id = var1;
   }

   public void setData_report_period(int var1) {
      this.data_report_period = var1;
   }

   public void setData_token(int[] var1) {
      this.data_token = var1;
   }

   public void setDefaultValues() {
      this.setData_token(new int[2]);
      this.setCollect_network_errors(true);
      this.setData_report_period(60);
      this.setError_limit(50);
      this.setResponse_body_limit(2048);
      this.setStack_trace_limit(100);
      this.setReport_max_transaction_age(600);
      this.setReport_max_transaction_count(1000);
      this.setActivity_trace_max_size('\ufffe');
      this.setActivity_trace_max_report_attempts(1);
      this.setActivity_trace_min_utilization(0.30000001192092896D);
      this.setAt_capture(ActivityTraceConfiguration.defaultActivityTraceConfiguration());
   }

   public void setError_limit(int var1) {
      this.error_limit = var1;
   }

   public void setReport_max_transaction_age(int var1) {
      this.report_max_transaction_age = var1;
   }

   public void setReport_max_transaction_count(int var1) {
      this.report_max_transaction_count = var1;
   }

   public void setResponse_body_limit(int var1) {
      this.response_body_limit = var1;
   }

   public void setServer_timestamp(long var1) {
      this.server_timestamp = var1;
   }

   public void setStack_trace_limit(int var1) {
      this.stack_trace_limit = var1;
   }

   public String toString() {
      return "HarvestConfiguration{collect_network_errors=" + this.collect_network_errors + ", cross_process_id=\'" + this.cross_process_id + '\'' + ", data_report_period=" + this.data_report_period + ", data_token=" + Arrays.toString(this.data_token) + ", error_limit=" + this.error_limit + ", report_max_transaction_age=" + this.report_max_transaction_age + ", report_max_transaction_count=" + this.report_max_transaction_count + ", response_body_limit=" + this.response_body_limit + ", server_timestamp=" + this.server_timestamp + ", stack_trace_limit=" + this.stack_trace_limit + ", activity_trace_max_size=" + this.activity_trace_max_size + ", activity_trace_max_report_attempts=" + this.activity_trace_max_report_attempts + ", activity_trace_min_utilization=" + this.activity_trace_min_utilization + ", at_capture=" + this.at_capture + '}';
   }
}
