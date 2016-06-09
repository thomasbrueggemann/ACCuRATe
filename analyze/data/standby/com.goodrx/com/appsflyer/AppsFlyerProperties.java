package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AppsFlyerProperties {
   private static AppsFlyerProperties instance = new AppsFlyerProperties();
   private boolean isLaunchCalled;
   private boolean isOnReceiveCalled;
   private Map<String, Object> properties = new HashMap();
   private String referrer;

   public static AppsFlyerProperties getInstance() {
      return instance;
   }

   public boolean getBoolean(String var1, boolean var2) {
      String var3 = this.getString(var1);
      return var3 == null?var2:Boolean.valueOf(var3).booleanValue();
   }

   public String getReferrer(Context var1) {
      return this.referrer != null?this.referrer:(this.getString("AF_REFERRER") != null?this.getString("AF_REFERRER"):var1.getSharedPreferences("appsflyer-data", 0).getString("referrer", (String)null));
   }

   public String getString(String var1) {
      return (String)this.properties.get(var1);
   }

   public boolean isEnableLog() {
      return this.getBoolean("shouldLog", true);
   }

   protected boolean isLaunchCollectedReferrerd() {
      return this.isLaunchCalled;
   }

   public void loadProperties(Context param1) {
      // $FF: Couldn't be decompiled
   }

   public void saveProperties(Context var1) {
      JSONObject var2 = new JSONObject(this.properties);
      String var3;
      if(!(var2 instanceof JSONObject)) {
         var3 = var2.toString();
      } else {
         var3 = JSONObjectInstrumentation.toString((JSONObject)var2);
      }

      Editor var4 = var1.getSharedPreferences("appsflyer-data", 0).edit();
      var4.putString("savedPropertoes", var3);
      if(VERSION.SDK_INT >= 9) {
         var4.apply();
      } else {
         var4.commit();
      }
   }

   public void set(String var1, String var2) {
      this.properties.put(var1, var2);
   }

   public void set(String var1, boolean var2) {
      this.properties.put(var1, Boolean.toString(var2));
   }

   protected void setLaunchCollectedReferrer() {
      this.isLaunchCalled = true;
   }

   protected void setOnReceiveCalled() {
      this.isOnReceiveCalled = true;
   }

   protected void setReferrer(String var1) {
      this.set("AF_REFERRER", var1);
      this.referrer = var1;
   }
}
