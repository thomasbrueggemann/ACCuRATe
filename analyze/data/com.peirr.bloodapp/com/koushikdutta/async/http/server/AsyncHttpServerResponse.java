package com.koushikdutta.async.http.server;

import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.libcore.ResponseHeaders;
import java.io.File;
import org.json.JSONObject;

public interface AsyncHttpServerResponse extends DataSink, CompletedCallback {
   void end();

   ResponseHeaders getHeaders();

   AsyncSocket getSocket();

   void onCompleted(Exception var1);

   void redirect(String var1);

   void responseCode(int var1);

   void send(String var1);

   void send(String var1, String var2);

   void send(JSONObject var1);

   void sendFile(File var1);

   void setContentType(String var1);

   void writeHead();
}
