package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseDecoder;
import com.parse.ParseHttpClient;
import com.parse.ParseObject;
import com.parse.ParseObjectCoder;
import com.parse.ParseRESTSessionCommand;
import com.parse.ParseSessionController;
import org.json.JSONObject;

class NetworkSessionController implements ParseSessionController {
   private final ParseHttpClient client;
   private final ParseObjectCoder coder;

   public NetworkSessionController(ParseHttpClient var1) {
      this.client = var1;
      this.coder = ParseObjectCoder.get();
   }

   public Task<ParseObject.State> getSessionAsync(String var1) {
      return ParseRESTSessionCommand.getCurrentSessionCommand(var1).executeAsync(this.client).onSuccess(new Continuation() {
         public ParseObject.State then(Task<JSONObject> var1) throws Exception {
            JSONObject var2 = (JSONObject)var1.getResult();
            return ((ParseObject.Builder)((ParseObject.Builder)NetworkSessionController.this.coder.decode(new ParseObject.Builder("_Session"), var2, ParseDecoder.get())).isComplete(true)).build();
         }
      });
   }

   public Task<Void> revokeAsync(String var1) {
      return ParseRESTSessionCommand.revoke(var1).executeAsync(this.client).makeVoid();
   }

   public Task<ParseObject.State> upgradeToRevocable(String var1) {
      return ParseRESTSessionCommand.upgradeToRevocableSessionCommand(var1).executeAsync(this.client).onSuccess(new Continuation() {
         public ParseObject.State then(Task<JSONObject> var1) throws Exception {
            JSONObject var2 = (JSONObject)var1.getResult();
            return ((ParseObject.Builder)((ParseObject.Builder)NetworkSessionController.this.coder.decode(new ParseObject.Builder("_Session"), var2, ParseDecoder.get())).isComplete(true)).build();
         }
      });
   }
}
