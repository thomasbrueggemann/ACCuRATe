package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.params.HttpParams;

public interface HttpMessage {
   void addHeader(Header var1);

   void addHeader(String var1, String var2);

   boolean containsHeader(String var1);

   Header[] getAllHeaders();

   Header getFirstHeader(String var1);

   Header[] getHeaders(String var1);

   @Deprecated
   HttpParams getParams();

   ProtocolVersion getProtocolVersion();

   HeaderIterator headerIterator();

   HeaderIterator headerIterator(String var1);

   void removeHeader(Header var1);

   void removeHeaders(String var1);

   void setHeader(String var1, String var2);

   void setHeaders(Header[] var1);

   @Deprecated
   void setParams(HttpParams var1);
}
