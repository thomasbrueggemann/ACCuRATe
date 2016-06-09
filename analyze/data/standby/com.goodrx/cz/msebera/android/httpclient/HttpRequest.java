package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.RequestLine;

public interface HttpRequest extends HttpMessage {
   RequestLine getRequestLine();
}
