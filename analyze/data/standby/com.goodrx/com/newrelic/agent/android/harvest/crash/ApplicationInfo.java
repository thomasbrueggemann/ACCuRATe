package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonObject;

public class ApplicationInfo extends HarvestableObject {
   private String applicationBuild = "";
   private String applicationName = "";
   private String applicationVersion = "";
   private String bundleId = "";
   private int processId = 0;

   public ApplicationInfo() {
   }

   public ApplicationInfo(ApplicationInformation var1) {
      this.applicationName = var1.getAppName();
      this.applicationVersion = var1.getAppVersion();
      this.applicationBuild = var1.getAppBuild();
      this.bundleId = var1.getPackageId();
   }

   public static ApplicationInfo newFromJson(JsonObject var0) {
      ApplicationInfo var1 = new ApplicationInfo();
      var1.applicationName = var0.get("appName").getAsString();
      var1.applicationVersion = var0.get("appVersion").getAsString();
      var1.applicationBuild = var0.get("appBuild").getAsString();
      var1.bundleId = var0.get("bundleId").getAsString();
      var1.processId = var0.get("processId").getAsInt();
      return var1;
   }

   public JsonObject asJsonObject() {
      JsonObject var1 = new JsonObject();
      var1.add("appName", SafeJsonPrimitive.factory(this.applicationName));
      var1.add("appVersion", SafeJsonPrimitive.factory(this.applicationVersion));
      var1.add("appBuild", SafeJsonPrimitive.factory(this.applicationBuild));
      var1.add("bundleId", SafeJsonPrimitive.factory(this.bundleId));
      var1.add("processId", SafeJsonPrimitive.factory((Number)Integer.valueOf(this.processId)));
      return var1;
   }
}
