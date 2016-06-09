package com.koushikdutta.async.http.socketio;

import android.net.Uri;
import com.koushikdutta.async.http.AsyncHttpPost;

public class SocketIORequest extends AsyncHttpPost {
   String endpoint;

   public SocketIORequest(String var1) {
      this(var1, "");
   }

   public SocketIORequest(String var1, String var2) {
      super(Uri.parse(var1).buildUpon().encodedPath("/socket.io/1/").build().toString());
      this.endpoint = var2;
   }

   public String getEndpoint() {
      return this.endpoint;
   }
}
