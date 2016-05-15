package com.google.android.gms.internal;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzk;
import com.google.android.gms.internal.zzy;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class zzw implements zzy {
   protected final HttpClient zzaD;

   public zzw(HttpClient var1) {
      this.zzaD = var1;
   }

   private static void zza(HttpEntityEnclosingRequestBase var0, zzk<?> var1) throws zza {
      byte[] var2 = var1.zzq();
      if(var2 != null) {
         var0.setEntity(new ByteArrayEntity(var2));
      }

   }

   private static void zza(HttpUriRequest var0, Map<String, String> var1) {
      Iterator var2 = var1.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var0.setHeader(var3, (String)var1.get(var3));
      }

   }

   static HttpUriRequest zzb(zzk<?> var0, Map<String, String> var1) throws zza {
      switch(var0.getMethod()) {
      case -1:
         byte[] var5 = var0.zzm();
         if(var5 != null) {
            HttpPost var6 = new HttpPost(var0.getUrl());
            var6.addHeader("Content-Type", var0.zzl());
            var6.setEntity(new ByteArrayEntity(var5));
            return var6;
         }

         return new HttpGet(var0.getUrl());
      case 0:
         return new HttpGet(var0.getUrl());
      case 1:
         HttpPost var4 = new HttpPost(var0.getUrl());
         var4.addHeader("Content-Type", var0.zzp());
         zza((HttpEntityEnclosingRequestBase)var4, (zzk)var0);
         return var4;
      case 2:
         HttpPut var3 = new HttpPut(var0.getUrl());
         var3.addHeader("Content-Type", var0.zzp());
         zza((HttpEntityEnclosingRequestBase)var3, (zzk)var0);
         return var3;
      case 3:
         return new HttpDelete(var0.getUrl());
      case 4:
         return new HttpHead(var0.getUrl());
      case 5:
         return new HttpOptions(var0.getUrl());
      case 6:
         return new HttpTrace(var0.getUrl());
      case 7:
         zzw.zza var2 = new zzw.zza(var0.getUrl());
         var2.addHeader("Content-Type", var0.zzp());
         zza((HttpEntityEnclosingRequestBase)var2, (zzk)var0);
         return var2;
      default:
         throw new IllegalStateException("Unknown request method.");
      }
   }

   public HttpResponse zza(zzk<?> var1, Map<String, String> var2) throws IOException, zza {
      HttpUriRequest var3 = zzb(var1, var2);
      zza(var3, var2);
      zza(var3, var1.getHeaders());
      this.zza(var3);
      HttpParams var4 = var3.getParams();
      int var5 = var1.zzt();
      HttpConnectionParams.setConnectionTimeout(var4, 5000);
      HttpConnectionParams.setSoTimeout(var4, var5);
      HttpClient var6 = this.zzaD;
      return !(var6 instanceof HttpClient)?var6.execute(var3):HttpInstrumentation.execute((HttpClient)var6, var3);
   }

   protected void zza(HttpUriRequest var1) throws IOException {
   }

   public static final class zza extends HttpEntityEnclosingRequestBase {
      public zza() {
      }

      public zza(String var1) {
         this.setURI(URI.create(var1));
      }

      public String getMethod() {
         return "PATCH";
      }
   }
}
