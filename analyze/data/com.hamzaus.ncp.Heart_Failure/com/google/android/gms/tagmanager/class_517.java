package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_69;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

// $FF: renamed from: com.google.android.gms.tagmanager.av
class class_517 implements class_69 {
   private HttpClient afL;

   // $FF: renamed from: a (org.apache.http.client.HttpClient, org.apache.http.HttpResponse) java.io.InputStream
   private InputStream method_2930(HttpClient var1, HttpResponse var2) throws IOException {
      int var3 = var2.getStatusLine().getStatusCode();
      if(var3 == 200) {
         class_515.method_2918("Success response");
         return var2.getEntity().getContent();
      } else {
         String var4 = "Bad response: " + var3;
         if(var3 == 404) {
            throw new FileNotFoundException(var4);
         } else {
            throw new IOException(var4);
         }
      }
   }

   // $FF: renamed from: a (org.apache.http.client.HttpClient) void
   private void method_2931(HttpClient var1) {
      if(var1 != null && var1.getConnectionManager() != null) {
         var1.getConnectionManager().shutdown();
      }

   }

   // $FF: renamed from: bV (java.lang.String) java.io.InputStream
   public InputStream method_356(String var1) throws IOException {
      this.afL = this.method_2932();
      HttpResponse var2 = this.afL.execute(new HttpGet(var1));
      return this.method_2930(this.afL, var2);
   }

   public void close() {
      this.method_2931(this.afL);
   }

   // $FF: renamed from: lK () org.apache.http.client.HttpClient
   HttpClient method_2932() {
      BasicHttpParams var1 = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout(var1, 20000);
      HttpConnectionParams.setSoTimeout(var1, 20000);
      return new DefaultHttpClient(var1);
   }
}
