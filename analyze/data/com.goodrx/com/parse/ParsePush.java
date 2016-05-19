package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.PLog;
import com.parse.ParseCallback1;
import com.parse.ParseCorePlugins;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObjectSubclassingController;
import com.parse.ParsePushChannelsController;
import com.parse.ParsePushController;
import com.parse.ParseQuery;
import com.parse.ParseTaskUtils;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SendCallback;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ParsePush {
   static String KEY_DATA_MESSAGE = "alert";
   private static final String TAG = "com.parse.ParsePush";
   final ParsePush.Builder builder;

   public ParsePush() {
      this(new ParsePush.Builder());
   }

   private ParsePush(ParsePush.Builder var1) {
      this.builder = var1;
   }

   public ParsePush(ParsePush var1) {
      this(new ParsePush.Builder(var1.builder.build()));
   }

   private static void checkArgument(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalArgumentException(String.valueOf(var1));
      }
   }

   static ParsePushChannelsController getPushChannelsController() {
      return ParseCorePlugins.getInstance().getPushChannelsController();
   }

   static ParsePushController getPushController() {
      return ParseCorePlugins.getInstance().getPushController();
   }

   private static ParseObjectSubclassingController getSubclassingController() {
      return ParseCorePlugins.getInstance().getSubclassingController();
   }

   public static Task<Void> sendDataInBackground(JSONObject var0, ParseQuery<ParseInstallation> var1) {
      ParsePush var2 = new ParsePush();
      var2.setQuery(var1);
      var2.setData(var0);
      return var2.sendInBackground();
   }

   public static void sendDataInBackground(JSONObject var0, ParseQuery<ParseInstallation> var1, SendCallback var2) {
      ParseTaskUtils.callbackOnMainThreadAsync(sendDataInBackground(var0, var1), (ParseCallback1)var2);
   }

   public static Task<Void> sendMessageInBackground(String var0, ParseQuery<ParseInstallation> var1) {
      ParsePush var2 = new ParsePush();
      var2.setQuery(var1);
      var2.setMessage(var0);
      return var2.sendInBackground();
   }

   public static void sendMessageInBackground(String var0, ParseQuery<ParseInstallation> var1, SendCallback var2) {
      ParseTaskUtils.callbackOnMainThreadAsync(sendMessageInBackground(var0, var1), (ParseCallback1)var2);
   }

   public static Task<Void> subscribeInBackground(String var0) {
      return getPushChannelsController().subscribeInBackground(var0);
   }

   public static void subscribeInBackground(String var0, SaveCallback var1) {
      ParseTaskUtils.callbackOnMainThreadAsync(subscribeInBackground(var0), (ParseCallback1)var1);
   }

   public static Task<Void> unsubscribeInBackground(String var0) {
      return getPushChannelsController().unsubscribeInBackground(var0);
   }

   public static void unsubscribeInBackground(String var0, SaveCallback var1) {
      ParseTaskUtils.callbackOnMainThreadAsync(unsubscribeInBackground(var0), (ParseCallback1)var1);
   }

   public void clearExpiration() {
      this.builder.expirationTime((Long)null);
      this.builder.expirationTimeInterval((Long)null);
   }

   public void send() throws ParseException {
      ParseTaskUtils.wait(this.sendInBackground());
   }

   public Task<Void> sendInBackground() {
      final ParsePush.State var1 = this.builder.build();
      return ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation() {
         public Task<Void> then(Task<String> var1x) throws Exception {
            String var2 = (String)var1x.getResult();
            return ParsePush.getPushController().sendInBackground(var1, var2);
         }
      });
   }

   public void sendInBackground(SendCallback var1) {
      ParseTaskUtils.callbackOnMainThreadAsync(this.sendInBackground(), (ParseCallback1)var1);
   }

   public void setChannel(String var1) {
      this.builder.channelSet(Collections.singletonList(var1));
   }

   public void setChannels(Collection<String> var1) {
      this.builder.channelSet(var1);
   }

   public void setData(JSONObject var1) {
      this.builder.data(var1);
   }

   public void setExpirationTime(long var1) {
      this.builder.expirationTime(Long.valueOf(var1));
   }

   public void setExpirationTimeInterval(long var1) {
      this.builder.expirationTimeInterval(Long.valueOf(var1));
   }

   public void setMessage(String var1) {
      JSONObject var2 = new JSONObject();

      try {
         var2.put(KEY_DATA_MESSAGE, var1);
      } catch (JSONException var4) {
         PLog.method_362("com.parse.ParsePush", "JSONException in setMessage", var4);
      }

      this.setData(var2);
   }

   @Deprecated
   public void setPushToAndroid(boolean var1) {
      this.builder.pushToAndroid(Boolean.valueOf(var1));
   }

   @Deprecated
   public void setPushToIOS(boolean var1) {
      this.builder.pushToIOS(Boolean.valueOf(var1));
   }

   public void setQuery(ParseQuery<ParseInstallation> var1) {
      this.builder.query(var1);
   }

   static class State {
      private final Set<String> channelSet;
      private final JSONObject data;
      private final Long expirationTime;
      private final Long expirationTimeInterval;
      private final Boolean pushToAndroid;
      private final Boolean pushToIOS;
      private final ParseQuery.State<ParseInstallation> queryState;

      private State(ParsePush.Builder param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: synthetic method
      State(ParsePush.Builder var1, Object var2) {
         this(var1);
      }

      public Set<String> channelSet() {
         return this.channelSet;
      }

      public JSONObject data() {
         // $FF: Couldn't be decompiled
      }

      public Long expirationTime() {
         return this.expirationTime;
      }

      public Long expirationTimeInterval() {
         return this.expirationTimeInterval;
      }

      public Boolean pushToAndroid() {
         return this.pushToAndroid;
      }

      public Boolean pushToIOS() {
         return this.pushToIOS;
      }

      public ParseQuery.State<ParseInstallation> queryState() {
         return this.queryState;
      }
   }

   static class Builder {
      private Set<String> channelSet;
      private JSONObject data;
      private Long expirationTime;
      private Long expirationTimeInterval;
      private Boolean pushToAndroid;
      private Boolean pushToIOS;
      private ParseQuery<ParseInstallation> query;

      public Builder() {
      }

      public Builder(ParsePush.State param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: synthetic method
      static Set access$300(ParsePush.Builder var0) {
         return var0.channelSet;
      }

      // $FF: synthetic method
      static ParseQuery access$400(ParsePush.Builder var0) {
         return var0.query;
      }

      // $FF: synthetic method
      static Long access$500(ParsePush.Builder var0) {
         return var0.expirationTime;
      }

      // $FF: synthetic method
      static Long access$600(ParsePush.Builder var0) {
         return var0.expirationTimeInterval;
      }

      // $FF: synthetic method
      static Boolean access$700(ParsePush.Builder var0) {
         return var0.pushToIOS;
      }

      // $FF: synthetic method
      static Boolean access$800(ParsePush.Builder var0) {
         return var0.pushToAndroid;
      }

      // $FF: synthetic method
      static JSONObject access$900(ParsePush.Builder var0) {
         return var0.data;
      }

      public ParsePush.State build() {
         if(this.data == null) {
            throw new IllegalArgumentException("Cannot send a push without calling either setMessage or setData");
         } else {
            return new ParsePush.State(this, null);
         }
      }

      public ParsePush.Builder channelSet(Collection<String> var1) {
         boolean var2;
         if(var1 != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         ParsePush.checkArgument(var2, "channels collection cannot be null");

         boolean var4;
         for(Iterator var3 = var1.iterator(); var3.hasNext(); ParsePush.checkArgument(var4, "channel cannot be null")) {
            if((String)var3.next() != null) {
               var4 = true;
            } else {
               var4 = false;
            }
         }

         this.channelSet = new HashSet(var1);
         this.query = null;
         return this;
      }

      public ParsePush.Builder data(JSONObject var1) {
         this.data = var1;
         return this;
      }

      public ParsePush.Builder expirationTime(Long var1) {
         this.expirationTime = var1;
         this.expirationTimeInterval = null;
         return this;
      }

      public ParsePush.Builder expirationTimeInterval(Long var1) {
         this.expirationTimeInterval = var1;
         this.expirationTime = null;
         return this;
      }

      public ParsePush.Builder pushToAndroid(Boolean var1) {
         boolean var2;
         if(this.query == null) {
            var2 = true;
         } else {
            var2 = false;
         }

         ParsePush.checkArgument(var2, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
         this.pushToAndroid = var1;
         return this;
      }

      public ParsePush.Builder pushToIOS(Boolean var1) {
         boolean var2;
         if(this.query == null) {
            var2 = true;
         } else {
            var2 = false;
         }

         ParsePush.checkArgument(var2, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
         this.pushToIOS = var1;
         return this;
      }

      public ParsePush.Builder query(ParseQuery<ParseInstallation> var1) {
         boolean var2 = true;
         boolean var3;
         if(var1 != null) {
            var3 = var2;
         } else {
            var3 = false;
         }

         ParsePush.checkArgument(var3, "Cannot target a null query");
         if(this.pushToIOS != null || this.pushToAndroid != null) {
            var2 = false;
         }

         ParsePush.checkArgument(var2, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
         ParsePush.checkArgument(var1.getClassName().equals(ParsePush.getSubclassingController().getClassName(ParseInstallation.class)), "Can only push to a query for Installations");
         this.channelSet = null;
         this.query = var1;
         return this;
      }
   }
}
