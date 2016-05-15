package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonPrimitive;

public class ApplicationInformation extends HarvestableArray {
   private String appBuild;
   private String appName;
   private String appVersion;
   private String packageId;
   private int versionCode;

   public ApplicationInformation() {
      this.versionCode = -1;
   }

   public ApplicationInformation(String var1, String var2, String var3, String var4) {
      this();
      this.appName = var1;
      this.appVersion = var2;
      this.packageId = var3;
      this.appBuild = var4;
   }

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      this.notEmpty(this.appName);
      var1.add(new JsonPrimitive(this.appName));
      this.notEmpty(this.appVersion);
      var1.add(new JsonPrimitive(this.appVersion));
      this.notEmpty(this.packageId);
      var1.add(new JsonPrimitive(this.packageId));
      return var1;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 != null && this.getClass() == var1.getClass()) {
            ApplicationInformation var2;
            label55: {
               var2 = (ApplicationInformation)var1;
               if(this.appName != null) {
                  if(this.appName.equals(var2.appName)) {
                     break label55;
                  }
               } else if(var2.appName == null) {
                  break label55;
               }

               return false;
            }

            label48: {
               if(this.appVersion != null) {
                  if(this.appVersion.equals(var2.appVersion)) {
                     break label48;
                  }
               } else if(var2.appVersion == null) {
                  break label48;
               }

               return false;
            }

            if(this.appBuild != null) {
               if(!this.appBuild.equals(var2.appBuild)) {
                  return false;
               }
            } else if(var2.appBuild != null) {
               return false;
            }

            if(this.packageId != null) {
               if(!this.packageId.equals(var2.packageId)) {
                  return false;
               }
            } else if(var2.packageId != null) {
               return false;
            }

            if(this.versionCode != var2.versionCode) {
               return false;
            } else {
               return true;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public String getAppBuild() {
      return this.appBuild;
   }

   public String getAppName() {
      return this.appName;
   }

   public String getAppVersion() {
      return this.appVersion;
   }

   public String getPackageId() {
      return this.packageId;
   }

   public int getVersionCode() {
      return this.versionCode;
   }

   public int hashCode() {
      int var1;
      if(this.appName != null) {
         var1 = this.appName.hashCode();
      } else {
         var1 = 0;
      }

      int var2 = var1 * 31;
      int var3;
      if(this.appVersion != null) {
         var3 = this.appVersion.hashCode();
      } else {
         var3 = 0;
      }

      int var4 = 31 * (var2 + var3);
      int var5;
      if(this.appBuild != null) {
         var5 = this.appBuild.hashCode();
      } else {
         var5 = 0;
      }

      int var6 = 31 * (var4 + var5);
      String var7 = this.packageId;
      int var8 = 0;
      if(var7 != null) {
         var8 = this.packageId.hashCode();
      }

      return var6 + var8;
   }

   public boolean isAppUpgrade(ApplicationInformation var1) {
      return var1.versionCode == -1?this.versionCode >= 0 && var1.appVersion != null:this.versionCode > var1.versionCode;
   }

   public void setAppBuild(String var1) {
      this.appBuild = var1;
   }

   public void setAppName(String var1) {
      this.appName = var1;
   }

   public void setAppVersion(String var1) {
      this.appVersion = var1;
   }

   public void setPackageId(String var1) {
      this.packageId = var1;
   }

   public void setVersionCode(int var1) {
      this.versionCode = var1;
   }
}
