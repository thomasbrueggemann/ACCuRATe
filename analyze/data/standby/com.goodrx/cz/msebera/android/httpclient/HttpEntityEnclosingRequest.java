package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpRequest;

public interface HttpEntityEnclosingRequest extends HttpRequest {
   boolean expectContinue();

   HttpEntity getEntity();
}
