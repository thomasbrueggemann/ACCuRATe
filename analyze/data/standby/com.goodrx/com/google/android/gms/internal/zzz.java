package com.google.android.gms.internal;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzk;
import com.google.android.gms.internal.zzy;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class zzz implements zzy {
   private final zzz.zza zzaE;
   private final SSLSocketFactory zzaF;

   public zzz() {
      this((zzz.zza)null);
   }

   public zzz(zzz.zza var1) {
      this(var1, (SSLSocketFactory)null);
   }

   public zzz(zzz.zza var1, SSLSocketFactory var2) {
      this.zzaE = var1;
      this.zzaF = var2;
   }

   private HttpURLConnection zza(URL var1, zzk<?> var2) throws IOException {
      HttpURLConnection var3 = this.zza(var1);
      int var4 = var2.zzt();
      var3.setConnectTimeout(var4);
      var3.setReadTimeout(var4);
      var3.setUseCaches(false);
      var3.setDoInput(true);
      if("https".equals(var1.getProtocol()) && this.zzaF != null) {
         ((HttpsURLConnection)var3).setSSLSocketFactory(this.zzaF);
      }

      return var3;
   }

   private static HttpEntity zza(HttpURLConnection var0) {
      BasicHttpEntity var1 = new BasicHttpEntity();

      InputStream var3;
      label13: {
         InputStream var4;
         try {
            var4 = var0.getInputStream();
         } catch (IOException var5) {
            var3 = var0.getErrorStream();
            break label13;
         }

         var3 = var4;
      }

      var1.setContent(var3);
      var1.setContentLength((long)var0.getContentLength());
      var1.setContentEncoding(var0.getContentEncoding());
      var1.setContentType(var0.getContentType());
      return var1;
   }

   static void zza(HttpURLConnection var0, zzk<?> var1) throws IOException, zza {
      switch(var1.getMethod()) {
      case -1:
         byte[] var2 = var1.zzm();
         if(var2 != null) {
            var0.setDoOutput(true);
            var0.setRequestMethod("POST");
            var0.addRequestProperty("Content-Type", var1.zzl());
            DataOutputStream var3 = new DataOutputStream(var0.getOutputStream());
            var3.write(var2);
            var3.close();
         }

         return;
      case 0:
         var0.setRequestMethod("GET");
         return;
      case 1:
         var0.setRequestMethod("POST");
         zzb(var0, var1);
         return;
      case 2:
         var0.setRequestMethod("PUT");
         zzb(var0, var1);
         return;
      case 3:
         var0.setRequestMethod("DELETE");
         return;
      case 4:
         var0.setRequestMethod("HEAD");
         return;
      case 5:
         var0.setRequestMethod("OPTIONS");
         return;
      case 6:
         var0.setRequestMethod("TRACE");
         return;
      case 7:
         var0.setRequestMethod("PATCH");
         zzb(var0, var1);
         return;
      default:
         throw new IllegalStateException("Unknown method type.");
      }
   }

   private static void zzb(HttpURLConnection var0, zzk<?> var1) throws IOException, zza {
      byte[] var2 = var1.zzq();
      if(var2 != null) {
         var0.setDoOutput(true);
         var0.addRequestProperty("Content-Type", var1.zzp());
         DataOutputStream var3 = new DataOutputStream(var0.getOutputStream());
         var3.write(var2);
         var3.close();
      }

   }

   protected HttpURLConnection zza(URL var1) throws IOException {
      return (HttpURLConnection)HttpInstrumentation.openConnection(var1.openConnection());
   }

   public HttpResponse zza(zzk<?> var1, Map<String, String> var2) throws IOException, zza {
      String var3 = var1.getUrl();
      HashMap var4 = new HashMap();
      var4.putAll(var1.getHeaders());
      var4.putAll(var2);
      String var5;
      if(this.zzaE != null) {
         var5 = this.zzaE.zzh(var3);
         if(var5 == null) {
            throw new IOException("URL blocked by rewriter: " + var3);
         }
      } else {
         var5 = var3;
      }

      HttpURLConnection var6 = this.zza(new URL(var5), var1);
      Iterator var7 = var4.keySet().iterator();

      while(var7.hasNext()) {
         String var12 = (String)var7.next();
         var6.addRequestProperty(var12, (String)var4.get(var12));
      }

      zza(var6, var1);
      ProtocolVersion var8 = new ProtocolVersion("HTTP", 1, 1);
      if(var6.getResponseCode() == -1) {
         throw new IOException("Could not retrieve response code from HttpUrlConnection.");
      } else {
         BasicHttpResponse var9 = new BasicHttpResponse(new BasicStatusLine(var8, var6.getResponseCode(), var6.getResponseMessage()));
         var9.setEntity(zza(var6));
         Iterator var10 = var6.getHeaderFields().entrySet().iterator();

         while(var10.hasNext()) {
            Entry var11 = (Entry)var10.next();
            if(var11.getKey() != null) {
               var9.addHeader(new BasicHeader((String)var11.getKey(), (String)((List)var11.getValue()).get(0)));
            }
         }

         return var9;
      }
   }

   public interface zza {
      String zzh(String var1);
   }
}
