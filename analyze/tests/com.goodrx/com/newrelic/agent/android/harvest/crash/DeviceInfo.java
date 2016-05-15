package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import java.util.Iterator;

public class DeviceInfo extends HarvestableObject {
   private String OSBuild;
   private String OSVersion;
   private String architecture;
   private String deviceName;
   private String deviceUuid;
   private long[] diskAvailable;
   private long memoryUsage;
   private String modelNumber;
   private String networkStatus;
   private int orientation;
   private String runTime;
   private String screenResolution;

   public DeviceInfo() {
   }

   public DeviceInfo(DeviceInformation var1, EnvironmentInformation var2) {
      this.memoryUsage = var2.getMemoryUsage();
      this.orientation = var2.getOrientation();
      this.networkStatus = var2.getNetworkStatus();
      this.diskAvailable = var2.getDiskAvailable();
      this.OSVersion = var1.getOsVersion();
      this.deviceName = var1.getManufacturer();
      this.OSBuild = var1.getOsBuild();
      this.architecture = var1.getArchitecture();
      this.modelNumber = var1.getModel();
      this.screenResolution = var1.getSize();
      this.deviceUuid = var1.getDeviceId();
      this.runTime = var1.getRunTime();
   }

   private JsonArray getDiskAvailableAsJson() {
      JsonArray var1 = new JsonArray();
      long[] var2 = this.diskAvailable;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         var1.add(SafeJsonPrimitive.factory((Number)Long.valueOf(var2[var4])));
      }

      return var1;
   }

   private static long[] longArrayFromJsonArray(JsonArray var0) {
      long[] var1 = new long[var0.size()];
      int var2 = 0;

      int var5;
      for(Iterator var3 = var0.iterator(); var3.hasNext(); var2 = var5) {
         JsonElement var4 = (JsonElement)var3.next();
         var5 = var2 + 1;
         var1[var2] = var4.getAsLong();
      }

      return var1;
   }

   public static DeviceInfo newFromJson(JsonObject var0) {
      DeviceInfo var1 = new DeviceInfo();
      var1.memoryUsage = var0.get("memoryUsage").getAsLong();
      var1.orientation = var0.get("orientation").getAsInt();
      var1.networkStatus = var0.get("networkStatus").getAsString();
      var1.diskAvailable = longArrayFromJsonArray(var0.get("diskAvailable").getAsJsonArray());
      var1.OSVersion = var0.get("osVersion").getAsString();
      var1.deviceName = var0.get("deviceName").getAsString();
      var1.OSBuild = var0.get("osBuild").getAsString();
      var1.architecture = var0.get("architecture").getAsString();
      var1.runTime = var0.get("runTime").getAsString();
      var1.modelNumber = var0.get("modelNumber").getAsString();
      var1.screenResolution = var0.get("screenResolution").getAsString();
      var1.deviceUuid = var0.get("deviceUuid").getAsString();
      return var1;
   }

   public JsonObject asJsonObject() {
      JsonObject var1 = new JsonObject();
      var1.add("memoryUsage", SafeJsonPrimitive.factory((Number)Long.valueOf(this.memoryUsage)));
      var1.add("orientation", SafeJsonPrimitive.factory((Number)Integer.valueOf(this.orientation)));
      var1.add("networkStatus", SafeJsonPrimitive.factory(this.networkStatus));
      var1.add("diskAvailable", this.getDiskAvailableAsJson());
      var1.add("osVersion", SafeJsonPrimitive.factory(this.OSVersion));
      var1.add("deviceName", SafeJsonPrimitive.factory(this.deviceName));
      var1.add("osBuild", SafeJsonPrimitive.factory(this.OSBuild));
      var1.add("architecture", SafeJsonPrimitive.factory(this.architecture));
      var1.add("runTime", SafeJsonPrimitive.factory(this.runTime));
      var1.add("modelNumber", SafeJsonPrimitive.factory(this.modelNumber));
      var1.add("screenResolution", SafeJsonPrimitive.factory(this.screenResolution));
      var1.add("deviceUuid", SafeJsonPrimitive.factory(this.deviceUuid));
      return var1;
   }
}
