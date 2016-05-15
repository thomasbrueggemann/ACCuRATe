package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.message.HeaderGroup;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;

public abstract class AbstractHttpMessage implements HttpMessage {
   protected HeaderGroup headergroup;
   @Deprecated
   protected HttpParams params;

   protected AbstractHttpMessage() {
      this((HttpParams)null);
   }

   @Deprecated
   protected AbstractHttpMessage(HttpParams var1) {
      this.headergroup = new HeaderGroup();
      this.params = var1;
   }

   public void addHeader(Header var1) {
      this.headergroup.addHeader(var1);
   }

   public void addHeader(String var1, String var2) {
      Args.notNull(var1, "Header name");
      this.headergroup.addHeader(new BasicHeader(var1, var2));
   }

   public boolean containsHeader(String var1) {
      return this.headergroup.containsHeader(var1);
   }

   public Header[] getAllHeaders() {
      return this.headergroup.getAllHeaders();
   }

   public Header getFirstHeader(String var1) {
      return this.headergroup.getFirstHeader(var1);
   }

   public Header[] getHeaders(String var1) {
      return this.headergroup.getHeaders(var1);
   }

   @Deprecated
   public HttpParams getParams() {
      if(this.params == null) {
         this.params = new BasicHttpParams();
      }

      return this.params;
   }

   public HeaderIterator headerIterator() {
      return this.headergroup.iterator();
   }

   public HeaderIterator headerIterator(String var1) {
      return this.headergroup.iterator(var1);
   }

   public void removeHeader(Header var1) {
      this.headergroup.removeHeader(var1);
   }

   public void removeHeaders(String var1) {
      if(var1 != null) {
         HeaderIterator var2 = this.headergroup.iterator();

         while(var2.hasNext()) {
            if(var1.equalsIgnoreCase(var2.nextHeader().getName())) {
               var2.remove();
            }
         }
      }

   }

   public void setHeader(String var1, String var2) {
      Args.notNull(var1, "Header name");
      this.headergroup.updateHeader(new BasicHeader(var1, var2));
   }

   public void setHeaders(Header[] var1) {
      this.headergroup.setHeaders(var1);
   }

   @Deprecated
   public void setParams(HttpParams var1) {
      this.params = (HttpParams)Args.notNull(var1, "HTTP parameters");
   }
}
