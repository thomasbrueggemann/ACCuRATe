package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.StatusLine;

public interface HttpResponse extends HttpMessage {
   HttpEntity getEntity();

   StatusLine getStatusLine();

   void setEntity(HttpEntity var1);
}
