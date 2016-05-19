package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRESTCommand;
import com.parse.http.ParseHttpRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

@ParseClassName("_EventuallyPin")
class EventuallyPin extends ParseObject {
   public static final String PIN_NAME = "_eventuallyPin";
   public static final int TYPE_COMMAND = 3;
   public static final int TYPE_DELETE = 2;
   public static final int TYPE_SAVE = 1;

   public EventuallyPin() {
      super("_EventuallyPin");
   }

   public static Task<List<EventuallyPin>> findAllPinned() {
      return findAllPinned((Collection)null);
   }

   public static Task<List<EventuallyPin>> findAllPinned(Collection<String> var0) {
      ParseQuery var1 = (new ParseQuery(EventuallyPin.class)).fromPin("_eventuallyPin").ignoreACLs().orderByAscending("time");
      if(var0 != null) {
         var1.whereNotContainedIn("uuid", var0);
      }

      return var1.findInBackground().continueWithTask(new Continuation() {
         public Task<List<EventuallyPin>> then(Task<List<EventuallyPin>> var1) throws Exception {
            final List var2 = (List)var1.getResult();
            ArrayList var3 = new ArrayList();
            Iterator var4 = var2.iterator();

            while(var4.hasNext()) {
               ParseObject var5 = ((EventuallyPin)var4.next()).getObject();
               if(var5 != null) {
                  var3.add(var5.fetchFromLocalDatastoreAsync().makeVoid());
               }
            }

            return Task.whenAll(var3).continueWithTask(new Continuation() {
               public Task<List<EventuallyPin>> then(Task<Void> var1) throws Exception {
                  return Task.forResult(var2);
               }
            });
         }
      });
   }

   private static Task<EventuallyPin> pinEventuallyCommand(int var0, ParseObject var1, String var2, String var3, JSONObject var4) {
      final EventuallyPin var5 = new EventuallyPin();
      var5.put("uuid", UUID.randomUUID().toString());
      var5.put("time", new Date());
      var5.put("type", Integer.valueOf(var0));
      if(var1 != null) {
         var5.put("object", var1);
      }

      if(var2 != null) {
         var5.put("operationSetUUID", var2);
      }

      if(var3 != null) {
         var5.put("sessionToken", var3);
      }

      if(var4 != null) {
         var5.put("command", var4);
      }

      return var5.pinInBackground("_eventuallyPin").continueWith(new Continuation() {
         public EventuallyPin then(Task<Void> var1) throws Exception {
            return var5;
         }
      });
   }

   public static Task<EventuallyPin> pinEventuallyCommand(ParseObject var0, ParseRESTCommand var1) {
      byte var2 = 3;
      JSONObject var3 = null;
      if(var1.httpPath.startsWith("classes")) {
         if(var1.method != ParseHttpRequest.Method.POST && var1.method != ParseHttpRequest.Method.PUT) {
            ParseHttpRequest.Method var4 = var1.method;
            ParseHttpRequest.Method var5 = ParseHttpRequest.Method.DELETE;
            var3 = null;
            if(var4 == var5) {
               var2 = 2;
               var3 = null;
            }
         } else {
            var2 = 1;
         }
      } else {
         var3 = var1.toJSONObject();
      }

      return pinEventuallyCommand(var2, var0, var1.getOperationSetUUID(), var1.getSessionToken(), var3);
   }

   public ParseRESTCommand getCommand() throws JSONException {
      JSONObject var1 = this.getJSONObject("command");
      ParseRESTCommand var3;
      if(ParseRESTCommand.isValidCommandJSONObject(var1)) {
         var3 = ParseRESTCommand.fromJSONObject(var1);
      } else {
         boolean var2 = ParseRESTCommand.isValidOldFormatCommandJSONObject(var1);
         var3 = null;
         if(!var2) {
            throw new JSONException("Failed to load command from JSON.");
         }
      }

      return var3;
   }

   public ParseObject getObject() {
      return this.getParseObject("object");
   }

   public String getOperationSetUUID() {
      return this.getString("operationSetUUID");
   }

   public String getSessionToken() {
      return this.getString("sessionToken");
   }

   public int getType() {
      return this.getInt("type");
   }

   public String getUUID() {
      return this.getString("uuid");
   }

   boolean needsDefaultACL() {
      return false;
   }
}
