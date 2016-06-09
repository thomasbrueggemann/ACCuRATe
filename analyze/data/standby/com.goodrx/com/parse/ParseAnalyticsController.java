package com.parse;

import bolts.Task;
import com.parse.ParseEventuallyQueue;
import com.parse.ParseObject;
import com.parse.ParseRESTAnalyticsCommand;
import java.util.Map;

class ParseAnalyticsController {
   ParseEventuallyQueue eventuallyQueue;

   public ParseAnalyticsController(ParseEventuallyQueue var1) {
      this.eventuallyQueue = var1;
   }

   public Task<Void> trackAppOpenedInBackground(String var1, String var2) {
      ParseRESTAnalyticsCommand var3 = ParseRESTAnalyticsCommand.trackAppOpenedCommand(var1, var2);
      return this.eventuallyQueue.enqueueEventuallyAsync(var3, (ParseObject)null).makeVoid();
   }

   public Task<Void> trackEventInBackground(String var1, Map<String, String> var2, String var3) {
      ParseRESTAnalyticsCommand var4 = ParseRESTAnalyticsCommand.trackEventCommand(var1, var2, var3);
      return this.eventuallyQueue.enqueueEventuallyAsync(var4, (ParseObject)null).makeVoid();
   }
}
