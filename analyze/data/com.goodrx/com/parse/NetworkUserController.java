package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseDecoder;
import com.parse.ParseHttpClient;
import com.parse.ParseObject;
import com.parse.ParseObjectCoder;
import com.parse.ParseOperationSet;
import com.parse.ParseRESTUserCommand;
import com.parse.ParseUser;
import com.parse.ParseUserController;
import com.parse.PointerEncoder;
import java.util.Map;
import org.json.JSONObject;

class NetworkUserController implements ParseUserController {
   private static final int STATUS_CODE_CREATED = 201;
   private final ParseHttpClient client;
   private final ParseObjectCoder coder;
   private final boolean revocableSession;

   public NetworkUserController(ParseHttpClient var1) {
      this(var1, false);
   }

   public NetworkUserController(ParseHttpClient var1, boolean var2) {
      this.client = var1;
      this.coder = ParseObjectCoder.get();
      this.revocableSession = var2;
   }

   public Task<ParseUser.State> getUserAsync(String var1) {
      return ParseRESTUserCommand.getCurrentUserCommand(var1).executeAsync(this.client).onSuccess(new Continuation() {
         public ParseUser.State then(Task<JSONObject> var1) throws Exception {
            JSONObject var2 = (JSONObject)var1.getResult();
            return ((ParseUser.Builder)((ParseUser.Builder)NetworkUserController.this.coder.decode(new ParseUser.Builder(), var2, ParseDecoder.get())).isComplete(true)).build();
         }
      });
   }

   public Task<ParseUser.State> logInAsync(ParseUser.State var1, ParseOperationSet var2) {
      final ParseRESTUserCommand var3 = ParseRESTUserCommand.serviceLogInUserCommand(this.coder.encode(var1, var2, PointerEncoder.get()), var1.sessionToken(), this.revocableSession);
      return var3.executeAsync(this.client).onSuccess(new Continuation() {
         public ParseUser.State then(Task<JSONObject> var1) throws Exception {
            boolean var2 = true;
            JSONObject var3x = (JSONObject)var1.getResult();
            boolean var4;
            if(var3.getStatusCode() == 201) {
               var4 = var2;
            } else {
               var4 = false;
            }

            if(var4) {
               var2 = false;
            }

            return ((ParseUser.Builder)((ParseUser.Builder)NetworkUserController.this.coder.decode(new ParseUser.Builder(), var3x, ParseDecoder.get())).isComplete(var2)).isNew(var4).build();
         }
      });
   }

   public Task<ParseUser.State> logInAsync(String var1, String var2) {
      return ParseRESTUserCommand.logInUserCommand(var1, var2, this.revocableSession).executeAsync(this.client).onSuccess(new Continuation() {
         public ParseUser.State then(Task<JSONObject> var1) throws Exception {
            JSONObject var2 = (JSONObject)var1.getResult();
            return ((ParseUser.Builder)((ParseUser.Builder)NetworkUserController.this.coder.decode(new ParseUser.Builder(), var2, ParseDecoder.get())).isComplete(true)).build();
         }
      });
   }

   public Task<ParseUser.State> logInAsync(final String var1, final Map<String, String> var2) {
      final ParseRESTUserCommand var3 = ParseRESTUserCommand.serviceLogInUserCommand(var1, var2, this.revocableSession);
      return var3.executeAsync(this.client).onSuccess(new Continuation() {
         public ParseUser.State then(Task<JSONObject> var1x) throws Exception {
            boolean var2x = true;
            JSONObject var3x = (JSONObject)var1x.getResult();
            ParseUser.Builder var4 = (ParseUser.Builder)((ParseUser.Builder)NetworkUserController.this.coder.decode(new ParseUser.Builder(), var3x, ParseDecoder.get())).isComplete(var2x);
            if(var3.getStatusCode() != 201) {
               var2x = false;
            }

            return var4.isNew(var2x).putAuthData(var1, var2).build();
         }
      });
   }

   public Task<Void> requestPasswordResetAsync(String var1) {
      return ParseRESTUserCommand.resetPasswordResetCommand(var1).executeAsync(this.client).makeVoid();
   }

   public Task<ParseUser.State> signUpAsync(ParseObject.State var1, ParseOperationSet var2, String var3) {
      return ParseRESTUserCommand.signUpUserCommand(this.coder.encode(var1, var2, PointerEncoder.get()), var3, this.revocableSession).executeAsync(this.client).onSuccess(new Continuation() {
         public ParseUser.State then(Task<JSONObject> var1) throws Exception {
            JSONObject var2 = (JSONObject)var1.getResult();
            return ((ParseUser.Builder)((ParseUser.Builder)NetworkUserController.this.coder.decode(new ParseUser.Builder(), var2, ParseDecoder.get())).isComplete(false)).isNew(true).build();
         }
      });
   }
}
