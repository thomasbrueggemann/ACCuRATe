package com.koushikdutta.async.http.socketio;

import com.koushikdutta.async.http.socketio.Acknowledge;
import org.json.JSONArray;

public interface EventCallback {
   void onEvent(JSONArray var1, Acknowledge var2);
}
