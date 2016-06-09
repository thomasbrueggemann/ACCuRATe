package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.client.methods.HttpRequestBase;
import cz.msebera.android.httpclient.client.utils.CloneUtils;

public abstract class HttpEntityEnclosingRequestBase extends HttpRequestBase implements HttpEntityEnclosingRequest {
   private HttpEntity entity;

   public Object clone() throws CloneNotSupportedException {
      HttpEntityEnclosingRequestBase var1 = (HttpEntityEnclosingRequestBase)super.clone();
      if(this.entity != null) {
         var1.entity = (HttpEntity)CloneUtils.cloneObject(this.entity);
      }

      return var1;
   }

   public boolean expectContinue() {
      Header var1 = this.getFirstHeader("Expect");
      return var1 != null && "100-continue".equalsIgnoreCase(var1.getValue());
   }

   public HttpEntity getEntity() {
      return this.entity;
   }

   public void setEntity(HttpEntity var1) {
      this.entity = var1;
   }
}
