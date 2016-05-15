package com.criteo.events;

import com.criteo.events.EventQueue;
import com.criteo.events.EventQueueItem;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;

class PostInBackground implements Runnable {
   private EventQueue eventQueue;
   ArrayList<EventQueueItem> events;
   private URL url;
   HttpURLConnection urlConnection = null;

   PostInBackground(EventQueue var1, ArrayList<EventQueueItem> var2, URL var3) {
      this.events = var2;
      this.url = var3;
      this.eventQueue = var1;
   }

   private HttpURLConnection createHTTPConnection(URL var1, JSONObject var2) throws IOException {
      HttpURLConnection var3 = (HttpURLConnection)HttpInstrumentation.openConnection(var1.openConnection());
      var3.setReadTimeout('\uea60');
      var3.setConnectTimeout('\uea60');
      var3.setDoInput(true);
      var3.setDoOutput(true);
      var3.setInstanceFollowRedirects(true);
      String var4;
      if(!(var2 instanceof JSONObject)) {
         var4 = var2.toString();
      } else {
         var4 = JSONObjectInstrumentation.toString((JSONObject)var2);
      }

      var3.setFixedLengthStreamingMode(var4.length());
      return var3;
   }

   private void postToURL(URL param1, ArrayList<EventQueueItem> param2) {
      // $FF: Couldn't be decompiled
   }

   private void sendPayload(HttpURLConnection var1, JSONObject var2) throws IOException {
      OutputStream var3 = var1.getOutputStream();
      BufferedWriter var4 = new BufferedWriter(new OutputStreamWriter(var3, "UTF-8"));
      String var5;
      if(!(var2 instanceof JSONObject)) {
         var5 = var2.toString();
      } else {
         var5 = JSONObjectInstrumentation.toString((JSONObject)var2);
      }

      var4.write(var5);
      var4.flush();
      var4.close();
      var3.close();
   }

   public void run() {
      this.postToURL(this.url, this.events);
   }
}
