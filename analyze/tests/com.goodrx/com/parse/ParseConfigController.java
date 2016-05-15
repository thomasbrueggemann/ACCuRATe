package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseConfig;
import com.parse.ParseCurrentConfigController;
import com.parse.ParseDecoder;
import com.parse.ParseHttpClient;
import com.parse.ParseRESTConfigCommand;
import org.json.JSONObject;

class ParseConfigController {
   private ParseCurrentConfigController currentConfigController;
   private final ParseHttpClient restClient;

   public ParseConfigController(ParseHttpClient var1, ParseCurrentConfigController var2) {
      this.restClient = var1;
      this.currentConfigController = var2;
   }

   public Task<ParseConfig> getAsync(String var1) {
      ParseRESTConfigCommand var2 = ParseRESTConfigCommand.fetchConfigCommand(var1);
      var2.enableRetrying();
      return var2.executeAsync(this.restClient).onSuccessTask(new Continuation() {
         public Task<ParseConfig> then(Task<JSONObject> var1) throws Exception {
            final ParseConfig var2 = ParseConfig.decode((JSONObject)var1.getResult(), ParseDecoder.get());
            return ParseConfigController.this.currentConfigController.setCurrentConfigAsync(var2).continueWith(new Continuation() {
               public ParseConfig then(Task<Void> var1) throws Exception {
                  return var2;
               }
            });
         }
      });
   }

   ParseCurrentConfigController getCurrentConfigController() {
      return this.currentConfigController;
   }
}
