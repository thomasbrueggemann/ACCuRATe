package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.util.TreeMap;
import okio.Buffer;
import okio.BufferedSource;

public class OkHttp2TransactionStateUtil extends TransactionStateUtil {
   private static final String NO_BODY_TEXT = "Response BODY not found.";
   private static final AgentLog log = AgentLogManager.getAgentLog();

   private static Response addTransactionAndErrorData(TransactionState var0, Response var1) {
      TransactionData var2 = var0.end();
      if(var2 != null) {
         TaskQueue.queue(new HttpTransactionMeasurement(var2.getUrl(), var2.getHttpMethod(), var2.getStatusCode(), var2.getErrorCode(), var2.getTimestamp(), (double)var2.getTime(), var2.getBytesSent(), var2.getBytesReceived(), var2.getAppData()));
         if((long)var0.getStatusCode() >= 400L) {
            String var3 = var1.header("Content-Type");
            TreeMap var4 = new TreeMap();
            if(var3 != null && var3.length() > 0 && !"".equals(var3)) {
               var4.put("content_type", (Object)null);
            }

            var4.put("content_length", var0.getBytesReceived() + "");
            String var6 = "";

            label25: {
               Response var11;
               try {
                  final ResponseBody var8 = var1.body();
                  var6 = var8.string();
                  final Buffer var9 = (new Buffer()).write(var6.getBytes());
                  ResponseBody var10 = new ResponseBody() {
                     public long contentLength() {
                        return var9.size();
                     }

                     public MediaType contentType() {
                        return var8.contentType();
                     }

                     public BufferedSource source() {
                        return var9;
                     }
                  };
                  var11 = var1.newBuilder().body(var10).build();
               } catch (Exception var12) {
                  if(var1.message() != null) {
                     log.warning("Missing response body, using response message");
                     var6 = var1.message();
                  }
                  break label25;
               }

               var1 = var11;
            }

            Measurements.addHttpError(var2.getUrl(), var2.getHttpMethod(), var2.getStatusCode(), var6, var4);
         }
      }

      return var1;
   }

   public static void inspectAndInstrument(TransactionState var0, Request var1) {
      inspectAndInstrument(var0, var1.urlString(), var1.method());
   }

   public static Response inspectAndInstrumentResponse(TransactionState var0, Response var1) {
      String var2 = var1.header("X-NewRelic-App-Data");
      int var3 = var1.code();
      long var4 = 0L;

      label13: {
         long var7;
         try {
            var7 = var1.body().contentLength();
         } catch (Exception var9) {
            log.warning("Missing body or content length ");
            break label13;
         }

         var4 = var7;
      }

      inspectAndInstrumentResponse(var0, var2, (int)var4, var3);
      return addTransactionAndErrorData(var0, var1);
   }
}
