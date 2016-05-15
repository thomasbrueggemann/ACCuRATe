package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseDecoder;
import com.parse.ParseHttpClient;
import com.parse.ParseRESTCloudCommand;
import java.util.Map;
import org.json.JSONObject;

class ParseCloudCodeController {
   final ParseHttpClient restClient;

   public ParseCloudCodeController(ParseHttpClient var1) {
      this.restClient = var1;
   }

   public <T> Task<T> callFunctionInBackground(String var1, Map<String, ?> var2, String var3) {
      return ParseRESTCloudCommand.callFunctionCommand(var1, var2, var3).executeAsync(this.restClient).onSuccess(new Continuation() {
         public T then(Task<JSONObject> var1) throws Exception {
            return ParseCloudCodeController.this.convertCloudResponse(var1.getResult());
         }
      });
   }

   Object convertCloudResponse(Object var1) {
      if(var1 instanceof JSONObject) {
         var1 = ((JSONObject)var1).opt("result");
      }

      Object var2 = ParseDecoder.get().decode(var1);
      return var2 != null?var2:var1;
   }
}
