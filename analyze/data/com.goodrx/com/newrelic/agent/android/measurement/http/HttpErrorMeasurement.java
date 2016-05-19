package com.newrelic.agent.android.measurement.http;

import com.newrelic.agent.android.measurement.BaseMeasurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import java.util.Map;

public class HttpErrorMeasurement extends BaseMeasurement {
   private int httpStatusCode;
   private Map<String, String> params;
   private String responseBody;
   private String stackTrace;
   private String url;

   public HttpErrorMeasurement(String var1, int var2) {
      super(MeasurementType.HttpError);
      this.setUrl(var1);
      this.setName(var1);
      this.setHttpStatusCode(var2);
      this.setStartTime(System.currentTimeMillis());
   }

   public int getHttpStatusCode() {
      return this.httpStatusCode;
   }

   public Map<String, String> getParams() {
      return this.params;
   }

   public String getResponseBody() {
      return this.responseBody;
   }

   public String getStackTrace() {
      return this.stackTrace;
   }

   public String getUrl() {
      return this.url;
   }

   public void setHttpStatusCode(int var1) {
      this.httpStatusCode = var1;
   }

   public void setParams(Map<String, String> var1) {
      this.params = var1;
   }

   public void setResponseBody(String var1) {
      this.responseBody = var1;
   }

   public void setStackTrace(String var1) {
      this.stackTrace = var1;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }
}
