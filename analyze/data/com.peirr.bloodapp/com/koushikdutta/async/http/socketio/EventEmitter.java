package com.koushikdutta.async.http.socketio;

import com.koushikdutta.async.http.socketio.Acknowledge;
import com.koushikdutta.async.http.socketio.EventCallback;
import com.koushikdutta.async.util.HashList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class EventEmitter {
   HashList<EventCallback> callbacks = new HashList();

   public void addListener(String var1, EventCallback var2) {
      this.method_4(var1, var2);
   }

   // $FF: renamed from: on (java.lang.String, com.koushikdutta.async.http.socketio.EventCallback) void
   public void method_4(String var1, EventCallback var2) {
      this.callbacks.add(var1, var2);
   }

   void onEvent(String var1, JSONArray var2, Acknowledge var3) {
      List var4 = (List)this.callbacks.get(var1);
      if(var4 != null) {
         Iterator var5 = var4.iterator();

         while(var5.hasNext()) {
            EventCallback var6 = (EventCallback)var5.next();
            var6.onEvent(var2, var3);
            if(var6 instanceof EventEmitter.OnceCallback) {
               var5.remove();
            }
         }
      }

   }

   public void once(String var1, final EventCallback var2) {
      this.method_4(var1, new EventEmitter.OnceCallback() {
         public void onEvent(JSONArray var1, Acknowledge var2x) {
            var2.onEvent(var1, var2x);
         }
      });
   }

   public void removeListener(String var1, EventCallback var2) {
      List var3 = (List)this.callbacks.get(var1);
      if(var3 != null) {
         var3.remove(var2);
      }
   }

   interface OnceCallback extends EventCallback {
   }
}
