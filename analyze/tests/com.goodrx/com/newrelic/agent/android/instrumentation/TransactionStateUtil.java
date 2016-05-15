package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.harvest.type.HarvestErrorCodes;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.httpclient.ContentBufferingResponseEntityImpl;
import com.newrelic.agent.android.instrumentation.httpclient.HttpRequestEntityImpl;
import com.newrelic.agent.android.instrumentation.httpclient.HttpResponseEntityImpl;
import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.text.MessageFormat;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpUriRequest;

public class TransactionStateUtil implements HarvestErrorCodes {
   public static final String APP_DATA_HEADER = "X-NewRelic-App-Data";
   public static final String CONTENT_LENGTH_HEADER = "Content-Length";
   public static final String CONTENT_TYPE_HEADER = "Content-Type";
   public static final String CROSS_PROCESS_ID_HEADER = "X-NewRelic-ID";
   private static final AgentLog log = AgentLogManager.getAgentLog();

   private static void addCrossProcessIdHeader(HttpRequest var0) {
      String var1 = Agent.getCrossProcessId();
      if(var1 != null) {
         TraceMachine.setCurrentTraceParam("cross_process_data", var1);
         var0.setHeader("X-NewRelic-ID", var1);
      }

   }

   private static void addTransactionAndErrorData(TransactionState var0, HttpResponse var1) {
      TransactionData var2 = var0.end();
      if(var2 != null) {
         TaskQueue.queue(new HttpTransactionMeasurement(var2.getUrl(), var2.getHttpMethod(), var2.getStatusCode(), var2.getErrorCode(), var2.getTimestamp(), (double)var2.getTime(), var2.getBytesSent(), var2.getBytesReceived(), var2.getAppData()));
         if((long)var0.getStatusCode() >= 400L) {
            StringBuilder var3 = new StringBuilder();
            TreeMap var4 = new TreeMap();
            if(var1 != null) {
               try {
                  if(var1.getEntity() != null) {
                     if(!(var1.getEntity() instanceof HttpRequestEntityImpl)) {
                        var1.setEntity(new ContentBufferingResponseEntityImpl(var1.getEntity()));
                     }

                     InputStream var13 = var1.getEntity().getContent();
                     if(var13 instanceof CountingInputStream) {
                        var3.append(((CountingInputStream)var13).getBufferAsString());
                     } else {
                        log.error("Unable to wrap content stream for entity");
                     }
                  } else {
                     log.debug("null response entity. response-body will be reported empty");
                  }
               } catch (IllegalStateException var14) {
                  log.error(var14.toString());
               } catch (IOException var15) {
                  log.error(var15.toString());
               }

               Header[] var7 = var1.getHeaders("Content-Type");
               String var8 = null;
               if(var7 != null) {
                  int var10 = var7.length;
                  var8 = null;
                  if(var10 > 0) {
                     boolean var11 = "".equals(var7[0].getValue());
                     var8 = null;
                     if(!var11) {
                        var8 = var7[0].getValue();
                     }
                  }
               }

               if(var8 != null && var8.length() > 0) {
                  var4.put("content_type", var8);
               }
            }

            var4.put("content_length", var0.getBytesReceived() + "");
            Measurements.addHttpError(var2.getUrl(), var2.getHttpMethod(), var2.getStatusCode(), var3.toString(), var4);
            return;
         }
      }

   }

   public static HttpRequest inspectAndInstrument(TransactionState var0, HttpHost var1, HttpRequest var2) {
      addCrossProcessIdHeader(var2);
      RequestLine var3 = var2.getRequestLine();
      if(var3 != null) {
         String var7 = var3.getUri();
         boolean var8;
         if(var7 != null && var7.length() >= 10 && var7.substring(0, 10).indexOf("://") >= 0) {
            var8 = true;
         } else {
            var8 = false;
         }

         String var9;
         if(!var8 && var7 != null && var1 != null) {
            String var10 = var1.toURI().toString();
            StringBuilder var11 = (new StringBuilder()).append(var10);
            String var12;
            if(!var10.endsWith("/") && !var7.startsWith("/")) {
               var12 = "/";
            } else {
               var12 = "";
            }

            var9 = var11.append(var12).append(var7).toString();
         } else {
            var9 = null;
            if(var8) {
               var9 = var7;
            }
         }

         inspectAndInstrument(var0, var9, var3.getMethod());
      }

      if(var0.getUrl() != null && var0.getHttpMethod() != null) {
         wrapRequestEntity(var0, var2);
         return var2;
      } else {
         try {
            throw new Exception("TransactionData constructor was not provided with a valid URL, host or HTTP method");
         } catch (Exception var13) {
            AgentLog var5 = AgentLogManager.getAgentLog();
            Object[] var6 = new Object[]{var2.getClass().getCanonicalName(), var1, var3};
            var5.error(MessageFormat.format("TransactionStateUtil.inspectAndInstrument(...) for {0} could not determine request URL or HTTP method [host={1}, requestLine={2}]", var6), var13);
            return var2;
         }
      }
   }

   public static HttpResponse inspectAndInstrument(TransactionState var0, HttpResponse var1) {
      var0.setStatusCode(var1.getStatusLine().getStatusCode());
      Header[] var2 = var1.getHeaders("X-NewRelic-App-Data");
      if(var2 != null && var2.length > 0 && !"".equals(var2[0].getValue())) {
         var0.setAppData(var2[0].getValue());
      }

      Header[] var3 = var1.getHeaders("Content-Length");
      if(var3 != null && var3.length > 0) {
         try {
            var0.setBytesReceived(Long.parseLong(var3[0].getValue()));
            addTransactionAndErrorData(var0, var1);
            return var1;
         } catch (NumberFormatException var5) {
            log.warning("Failed to parse content length: " + var5.toString());
            return var1;
         }
      } else if(var1.getEntity() != null) {
         var1.setEntity(new HttpResponseEntityImpl(var1.getEntity(), var0, -1L));
         return var1;
      } else {
         var0.setBytesReceived(0L);
         addTransactionAndErrorData(var0, (HttpResponse)null);
         return var1;
      }
   }

   public static HttpUriRequest inspectAndInstrument(TransactionState var0, HttpUriRequest var1) {
      addCrossProcessIdHeader(var1);
      inspectAndInstrument(var0, var1.getURI().toString(), var1.getMethod());
      wrapRequestEntity(var0, var1);
      return var1;
   }

   public static void inspectAndInstrument(TransactionState var0, String var1, String var2) {
      var0.setUrl(var1);
      var0.setHttpMethod(var2);
      var0.setCarrier(Agent.getActiveNetworkCarrier());
      var0.setWanType(Agent.getActiveNetworkWanType());
   }

   public static void inspectAndInstrument(TransactionState var0, HttpURLConnection var1) {
      inspectAndInstrument(var0, var1.getURL().toString(), var1.getRequestMethod());
   }

   public static void inspectAndInstrumentResponse(TransactionState var0, String var1, int var2, int var3) {
      if(var1 != null && !var1.equals("")) {
         var0.setAppData(var1);
      }

      if(var2 >= 0) {
         var0.setBytesReceived((long)var2);
      }

      var0.setStatusCode(var3);
   }

   public static void inspectAndInstrumentResponse(TransactionState var0, HttpURLConnection var1) {
      String var2 = var1.getHeaderField("X-NewRelic-App-Data");
      int var3 = var1.getContentLength();

      int var5;
      label15: {
         int var7;
         try {
            var7 = var1.getResponseCode();
         } catch (IOException var8) {
            log.debug("Failed to retrieve response code due to an I/O exception: " + var8.getMessage());
            var5 = 0;
            break label15;
         } catch (NullPointerException var9) {
            log.error("Failed to retrieve response code due to underlying (Harmony?) NPE", var9);
            var5 = 0;
            break label15;
         }

         var5 = var7;
      }

      inspectAndInstrumentResponse(var0, var2, var3, var5);
   }

   public static void setCrossProcessHeader(HttpURLConnection var0) {
      String var1 = Agent.getCrossProcessId();
      if(var1 != null) {
         var0.setRequestProperty("X-NewRelic-ID", var1);
      }

   }

   public static void setErrorCodeFromException(TransactionState var0, Exception var1) {
      int var2 = ExceptionHelper.exceptionToErrorCode(var1);
      log.error("TransactionStateUtil: Attempting to convert network exception " + var1.getClass().getName() + " to error code.");
      var0.setErrorCode(var2);
   }

   private static void wrapRequestEntity(TransactionState var0, HttpRequest var1) {
      if(var1 instanceof HttpEntityEnclosingRequest) {
         HttpEntityEnclosingRequest var2 = (HttpEntityEnclosingRequest)var1;
         if(var2.getEntity() != null) {
            var2.setEntity(new HttpRequestEntityImpl(var2.getEntity(), var0));
         }
      }

   }
}
