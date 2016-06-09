package com.koushikdutta.async.http.socketio;

import com.koushikdutta.async.http.socketio.Acknowledge;
import org.json.JSONObject;

public interface JSONCallback {
   void onJSON(JSONObject var1, Acknowledge var2);
}
