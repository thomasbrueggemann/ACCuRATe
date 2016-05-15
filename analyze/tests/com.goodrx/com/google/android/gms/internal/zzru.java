package com.google.android.gms.internal;

import com.google.android.gms.internal.zzrv;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class zzru implements zzrv {
   private HttpURLConnection zzbmy;

   private InputStream zzd(HttpURLConnection var1) throws IOException {
      int var2 = var1.getResponseCode();
      if(var2 == 200) {
         return var1.getInputStream();
      } else {
         String var3 = "Bad response: " + var2;
         if(var2 == 404) {
            throw new FileNotFoundException(var3);
         } else {
            throw new IOException(var3);
         }
      }
   }

   private void zze(HttpURLConnection var1) {
      if(var1 != null) {
         var1.disconnect();
      }

   }

   public void close() {
      this.zze(this.zzbmy);
   }

   public InputStream zzgI(String var1) throws IOException {
      this.zzbmy = this.zzgJ(var1);
      return this.zzd(this.zzbmy);
   }

   HttpURLConnection zzgJ(String var1) throws IOException {
      HttpURLConnection var2 = (HttpURLConnection)HttpInstrumentation.openConnection((new URL(var1)).openConnection());
      var2.setReadTimeout(20000);
      var2.setConnectTimeout(20000);
      return var2;
   }
}
