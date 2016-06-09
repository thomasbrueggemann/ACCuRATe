package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;
import java.io.IOException;
import java.net.URI;

public interface ResponseHandlerInterface {
   boolean getUsePoolThread();

   boolean getUseSynchronousMode();

   void onPostProcessResponse(ResponseHandlerInterface var1, HttpResponse var2);

   void onPreProcessResponse(ResponseHandlerInterface var1, HttpResponse var2);

   void sendCancelMessage();

   void sendFailureMessage(int var1, Header[] var2, byte[] var3, Throwable var4);

   void sendFinishMessage();

   void sendProgressMessage(long var1, long var3);

   void sendResponseMessage(HttpResponse var1) throws IOException;

   void sendRetryMessage(int var1);

   void sendStartMessage();

   void setRequestHeaders(Header[] var1);

   void setRequestURI(URI var1);
}
