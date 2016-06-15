package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_74;
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
class class_615 implements class_74 {
   private HttpClient arD;

   // $FF: renamed from: a (org.apache.http.client.HttpClient, org.apache.http.HttpResponse) java.io.InputStream
   private InputStream method_3505(HttpClient var1, HttpResponse var2) throws IOException {
      int var3 = var2.getStatusLine().getStatusCode();
      if(var3 == 200) {
         class_613.method_3493("Success response");
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
   private void method_3506(HttpClient var1) {
      if(var1 != null && var1.getConnectionManager() != null) {
         var1.getConnectionManager().shutdown();
      }

   }

   // $FF: renamed from: cF (java.lang.String) java.io.InputStream
   public InputStream method_398(String var1) throws IOException {
      this.arD = this.method_3507();
      HttpResponse var2 = this.arD.execute(new HttpGet(var1));
      return this.method_3505(this.arD, var2);
   }

   public void close() {
      this.method_3506(this.arD);
   }

   // $FF: renamed from: pM () org.apache.http.client.HttpClient
   HttpClient method_3507() {
      BasicHttpParams var1 = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout(var1, 20000);
      HttpConnectionParams.setSoTimeout(var1, 20000);
      return new DefaultHttpClient(var1);
   }
}
