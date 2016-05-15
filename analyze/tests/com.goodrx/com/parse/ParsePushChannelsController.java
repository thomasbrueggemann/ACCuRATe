package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ManifestInfo;
import com.parse.PLog;
import com.parse.ParseCorePlugins;
import com.parse.ParseCurrentInstallationController;
import com.parse.ParseInstallation;
import com.parse.PushType;
import java.util.Collections;
import java.util.List;

class ParsePushChannelsController {
   private static final String TAG = "com.parse.ParsePushChannelsController";
   private static boolean loggedManifestError = false;

   private static void checkManifestAndLogErrorIfNecessary() {
      if(!loggedManifestError && ManifestInfo.getPushType() == PushType.NONE) {
         loggedManifestError = true;
         PLog.method_361("com.parse.ParsePushChannelsController", "Tried to subscribe or unsubscribe from a channel, but push is not enabled correctly. " + ManifestInfo.getNonePushTypeLogMessage());
      }

   }

   private static ParseCurrentInstallationController getCurrentInstallationController() {
      return ParseCorePlugins.getInstance().getCurrentInstallationController();
   }

   public Task<Void> subscribeInBackground(final String var1) {
      checkManifestAndLogErrorIfNecessary();
      if(var1 == null) {
         throw new IllegalArgumentException("Can\'t subscribe to null channel.");
      } else {
         return getCurrentInstallationController().getAsync().onSuccessTask(new Continuation() {
            public Task<Void> then(Task<ParseInstallation> var1x) throws Exception {
               ParseInstallation var2 = (ParseInstallation)var1x.getResult();
               List var3 = var2.getList("channels");
               if(var3 != null && !var2.isDirty("channels") && var3.contains(var1)) {
                  return Task.forResult((Object)null);
               } else {
                  var2.addUnique("channels", var1);
                  return var2.saveInBackground();
               }
            }
         });
      }
   }

   public Task<Void> unsubscribeInBackground(final String var1) {
      checkManifestAndLogErrorIfNecessary();
      if(var1 == null) {
         throw new IllegalArgumentException("Can\'t unsubscribe from null channel.");
      } else {
         return getCurrentInstallationController().getAsync().onSuccessTask(new Continuation() {
            public Task<Void> then(Task<ParseInstallation> var1x) throws Exception {
               ParseInstallation var2 = (ParseInstallation)var1x.getResult();
               List var3 = var2.getList("channels");
               if(var3 != null && var3.contains(var1)) {
                  var2.removeAll("channels", Collections.singletonList(var1));
                  return var2.saveInBackground();
               } else {
                  return Task.forResult((Object)null);
               }
            }
         });
      }
   }
}
