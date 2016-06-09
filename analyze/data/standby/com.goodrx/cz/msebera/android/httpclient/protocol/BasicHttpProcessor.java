package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public final class BasicHttpProcessor implements HttpProcessor, Cloneable {
   protected final List<HttpRequestInterceptor> requestInterceptors = new ArrayList();
   protected final List<HttpResponseInterceptor> responseInterceptors = new ArrayList();

   public final void addInterceptor(HttpRequestInterceptor var1) {
      this.addRequestInterceptor(var1);
   }

   public final void addInterceptor(HttpRequestInterceptor var1, int var2) {
      this.addRequestInterceptor(var1, var2);
   }

   public final void addInterceptor(HttpResponseInterceptor var1) {
      this.addResponseInterceptor(var1);
   }

   public void addRequestInterceptor(HttpRequestInterceptor var1) {
      if(var1 != null) {
         this.requestInterceptors.add(var1);
      }
   }

   public void addRequestInterceptor(HttpRequestInterceptor var1, int var2) {
      if(var1 != null) {
         this.requestInterceptors.add(var2, var1);
      }
   }

   public void addResponseInterceptor(HttpResponseInterceptor var1) {
      if(var1 != null) {
         this.responseInterceptors.add(var1);
      }
   }

   public Object clone() throws CloneNotSupportedException {
      BasicHttpProcessor var1 = (BasicHttpProcessor)super.clone();
      this.copyInterceptors(var1);
      return var1;
   }

   protected void copyInterceptors(BasicHttpProcessor var1) {
      var1.requestInterceptors.clear();
      var1.requestInterceptors.addAll(this.requestInterceptors);
      var1.responseInterceptors.clear();
      var1.responseInterceptors.addAll(this.responseInterceptors);
   }

   public HttpRequestInterceptor getRequestInterceptor(int var1) {
      return var1 >= 0 && var1 < this.requestInterceptors.size()?(HttpRequestInterceptor)this.requestInterceptors.get(var1):null;
   }

   public int getRequestInterceptorCount() {
      return this.requestInterceptors.size();
   }

   public HttpResponseInterceptor getResponseInterceptor(int var1) {
      return var1 >= 0 && var1 < this.responseInterceptors.size()?(HttpResponseInterceptor)this.responseInterceptors.get(var1):null;
   }

   public int getResponseInterceptorCount() {
      return this.responseInterceptors.size();
   }

   public void process(HttpRequest var1, HttpContext var2) throws IOException, HttpException {
      Iterator var3 = this.requestInterceptors.iterator();

      while(var3.hasNext()) {
         ((HttpRequestInterceptor)var3.next()).process(var1, var2);
      }

   }

   public void process(HttpResponse var1, HttpContext var2) throws IOException, HttpException {
      Iterator var3 = this.responseInterceptors.iterator();

      while(var3.hasNext()) {
         ((HttpResponseInterceptor)var3.next()).process(var1, var2);
      }

   }
}
