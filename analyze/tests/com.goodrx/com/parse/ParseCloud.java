package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.FunctionCallback;
import com.parse.ParseCallback2;
import com.parse.ParseCloudCodeController;
import com.parse.ParseCorePlugins;
import com.parse.ParseException;
import com.parse.ParseTaskUtils;
import com.parse.ParseUser;
import java.util.Map;

public final class ParseCloud {
   public static <T> T callFunction(String var0, Map<String, ?> var1) throws ParseException {
      return ParseTaskUtils.wait(callFunctionInBackground(var0, var1));
   }

   public static <T> Task<T> callFunctionInBackground(final String var0, final Map<String, ?> var1) {
      return ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation() {
         public Task<T> then(Task<String> var1x) throws Exception {
            String var2 = (String)var1x.getResult();
            return ParseCloud.getCloudCodeController().callFunctionInBackground(var0, var1, var2);
         }
      });
   }

   public static <T> void callFunctionInBackground(String var0, Map<String, ?> var1, FunctionCallback<T> var2) {
      ParseTaskUtils.callbackOnMainThreadAsync(callFunctionInBackground(var0, var1), (ParseCallback2)var2);
   }

   static ParseCloudCodeController getCloudCodeController() {
      return ParseCorePlugins.getInstance().getCloudCodeController();
   }
}
