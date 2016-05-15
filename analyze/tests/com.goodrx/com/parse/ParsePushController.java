package com.parse;

import bolts.Task;
import com.parse.ParseHttpClient;
import com.parse.ParsePush;
import com.parse.ParseQuery;
import com.parse.ParseRESTCommand;
import com.parse.ParseRESTPushCommand;

class ParsePushController {
   static final String DEVICE_TYPE_ANDROID = "android";
   static final String DEVICE_TYPE_IOS = "ios";
   private final ParseHttpClient restClient;

   public ParsePushController(ParseHttpClient var1) {
      this.restClient = var1;
   }

   ParseRESTCommand buildRESTSendPushCommand(ParsePush.State var1, String var2) {
      ParseQuery.State var3 = var1.queryState();
      String var4 = null;
      if(var3 == null) {
         boolean var5;
         if(var1.pushToAndroid() != null && var1.pushToAndroid().booleanValue()) {
            var5 = true;
         } else {
            var5 = false;
         }

         boolean var6;
         if(var1.pushToIOS() != null && var1.pushToIOS().booleanValue()) {
            var6 = true;
         } else {
            var6 = false;
         }

         if(var6) {
            var4 = null;
            if(var5) {
               return ParseRESTPushCommand.sendPushCommand(var1.queryState(), var1.channelSet(), var4, var1.expirationTime(), var1.expirationTimeInterval(), var1.data(), var2);
            }
         }

         if(var6) {
            var4 = "ios";
         } else {
            var4 = null;
            if(var5) {
               var4 = "android";
            }
         }
      }

      return ParseRESTPushCommand.sendPushCommand(var1.queryState(), var1.channelSet(), var4, var1.expirationTime(), var1.expirationTimeInterval(), var1.data(), var2);
   }

   public Task<Void> sendInBackground(ParsePush.State var1, String var2) {
      return this.buildRESTSendPushCommand(var1, var2).executeAsync(this.restClient).makeVoid();
   }
}
