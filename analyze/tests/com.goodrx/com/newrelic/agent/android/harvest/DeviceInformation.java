package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DeviceInformation extends HarvestableArray {
   private String agentName;
   private String agentVersion;
   private String architecture;
   private String countryCode;
   private String deviceId;
   private String manufacturer;
   private Map<String, String> misc = new HashMap();
   private String model;
   private String osBuild;
   private String osName;
   private String osVersion;
   private String regionCode;
   private String runTime;
   private String size;

   public void addMisc(String var1, String var2) {
      this.misc.put(var1, var2);
   }

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      this.notEmpty(this.osName);
      var1.add(new JsonPrimitive(this.osName));
      this.notEmpty(this.osVersion);
      var1.add(new JsonPrimitive(this.osVersion));
      this.notEmpty(this.manufacturer);
      this.notEmpty(this.model);
      var1.add(new JsonPrimitive(this.manufacturer + " " + this.model));
      this.notEmpty(this.agentName);
      var1.add(new JsonPrimitive(this.agentName));
      this.notEmpty(this.agentVersion);
      var1.add(new JsonPrimitive(this.agentVersion));
      this.notEmpty(this.deviceId);
      var1.add(new JsonPrimitive(this.deviceId));
      var1.add(new JsonPrimitive(this.optional(this.countryCode)));
      var1.add(new JsonPrimitive(this.optional(this.regionCode)));
      var1.add(new JsonPrimitive(this.manufacturer));
      if(this.misc == null || this.misc.isEmpty()) {
         this.misc = Collections.emptyMap();
      }

      var1.add((new Gson()).toJsonTree(this.misc, GSON_STRING_MAP_TYPE));
      return var1;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 != null && this.getClass() == var1.getClass()) {
            DeviceInformation var2;
            label124: {
               var2 = (DeviceInformation)var1;
               if(this.agentName != null) {
                  if(this.agentName.equals(var2.agentName)) {
                     break label124;
                  }
               } else if(var2.agentName == null) {
                  break label124;
               }

               return false;
            }

            label117: {
               if(this.agentVersion != null) {
                  if(this.agentVersion.equals(var2.agentVersion)) {
                     break label117;
                  }
               } else if(var2.agentVersion == null) {
                  break label117;
               }

               return false;
            }

            if(this.architecture != null) {
               if(!this.architecture.equals(var2.architecture)) {
                  return false;
               }
            } else if(var2.architecture != null) {
               return false;
            }

            label154: {
               if(this.deviceId != null) {
                  if(!this.deviceId.equals(var2.deviceId)) {
                     return false;
                  }
               } else if(var2.deviceId != null) {
                  return false;
               }

               label74: {
                  if(this.manufacturer != null) {
                     if(this.manufacturer.equals(var2.manufacturer)) {
                        break label74;
                     }
                  } else if(var2.manufacturer == null) {
                     break label74;
                  }

                  return false;
               }

               if(this.model != null) {
                  if(!this.model.equals(var2.model)) {
                     return false;
                  }
               } else if(var2.model != null) {
                  return false;
               }

               if(this.osBuild != null) {
                  if(this.osBuild.equals(var2.osBuild)) {
                     break label154;
                  }
               } else if(var2.osBuild == null) {
                  break label154;
               }

               return false;
            }

            label109: {
               if(this.osName != null) {
                  if(this.osName.equals(var2.osName)) {
                     break label109;
                  }
               } else if(var2.osName == null) {
                  break label109;
               }

               return false;
            }

            label102: {
               if(this.osVersion != null) {
                  if(this.osVersion.equals(var2.osVersion)) {
                     break label102;
                  }
               } else if(var2.osVersion == null) {
                  break label102;
               }

               return false;
            }

            label95: {
               if(this.runTime != null) {
                  if(this.runTime.equals(var2.runTime)) {
                     break label95;
                  }
               } else if(var2.runTime == null) {
                  break label95;
               }

               return false;
            }

            if(this.size != null) {
               if(this.size.equals(var2.size)) {
                  return true;
               }
            } else if(var2.size == null) {
               return true;
            }

            return false;
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public String getAgentName() {
      return this.agentName;
   }

   public String getAgentVersion() {
      return this.agentVersion;
   }

   public String getArchitecture() {
      return this.architecture;
   }

   public String getCountryCode() {
      return this.countryCode;
   }

   public String getDeviceId() {
      return this.deviceId;
   }

   public String getManufacturer() {
      return this.manufacturer;
   }

   public String getModel() {
      return this.model;
   }

   public String getOsBuild() {
      return this.osBuild;
   }

   public String getOsName() {
      return this.osName;
   }

   public String getOsVersion() {
      return this.osVersion;
   }

   public String getRegionCode() {
      return this.regionCode;
   }

   public String getRunTime() {
      return this.runTime;
   }

   public String getSize() {
      return this.size;
   }

   public int hashCode() {
      int var1;
      if(this.osName != null) {
         var1 = this.osName.hashCode();
      } else {
         var1 = 0;
      }

      int var2 = var1 * 31;
      int var3;
      if(this.osVersion != null) {
         var3 = this.osVersion.hashCode();
      } else {
         var3 = 0;
      }

      int var4 = 31 * (var2 + var3);
      int var5;
      if(this.osBuild != null) {
         var5 = this.osBuild.hashCode();
      } else {
         var5 = 0;
      }

      int var6 = 31 * (var4 + var5);
      int var7;
      if(this.model != null) {
         var7 = this.model.hashCode();
      } else {
         var7 = 0;
      }

      int var8 = 31 * (var6 + var7);
      int var9;
      if(this.agentName != null) {
         var9 = this.agentName.hashCode();
      } else {
         var9 = 0;
      }

      int var10 = 31 * (var8 + var9);
      int var11;
      if(this.agentVersion != null) {
         var11 = this.agentVersion.hashCode();
      } else {
         var11 = 0;
      }

      int var12 = 31 * (var10 + var11);
      int var13;
      if(this.deviceId != null) {
         var13 = this.deviceId.hashCode();
      } else {
         var13 = 0;
      }

      int var14 = 31 * (var12 + var13);
      int var15;
      if(this.manufacturer != null) {
         var15 = this.manufacturer.hashCode();
      } else {
         var15 = 0;
      }

      int var16 = 31 * (var14 + var15);
      int var17;
      if(this.architecture != null) {
         var17 = this.architecture.hashCode();
      } else {
         var17 = 0;
      }

      int var18 = 31 * (var16 + var17);
      int var19;
      if(this.runTime != null) {
         var19 = this.runTime.hashCode();
      } else {
         var19 = 0;
      }

      int var20 = 31 * (var18 + var19);
      String var21 = this.size;
      int var22 = 0;
      if(var21 != null) {
         var22 = this.size.hashCode();
      }

      return var20 + var22;
   }

   public void setAgentName(String var1) {
      this.agentName = var1;
   }

   public void setAgentVersion(String var1) {
      this.agentVersion = var1;
   }

   public void setArchitecture(String var1) {
      this.architecture = var1;
   }

   public void setCountryCode(String var1) {
      this.countryCode = var1;
   }

   public void setDeviceId(String var1) {
      this.deviceId = var1;
   }

   public void setManufacturer(String var1) {
      this.manufacturer = var1;
   }

   public void setMisc(Map<String, String> var1) {
      this.misc = new HashMap(var1);
   }

   public void setModel(String var1) {
      this.model = var1;
   }

   public void setOsBuild(String var1) {
      this.osBuild = var1;
   }

   public void setOsName(String var1) {
      this.osName = var1;
   }

   public void setOsVersion(String var1) {
      this.osVersion = var1;
   }

   public void setRegionCode(String var1) {
      this.regionCode = var1;
   }

   public void setRunTime(String var1) {
      this.runTime = var1;
   }

   public void setSize(String var1) {
      this.size = var1;
      this.addMisc("size", var1);
   }

   public String toJsonString() {
      return "DeviceInformation{manufacturer=\'" + this.manufacturer + '\'' + ", osName=\'" + this.osName + '\'' + ", osVersion=\'" + this.osVersion + '\'' + ", model=\'" + this.model + '\'' + ", agentName=\'" + this.agentName + '\'' + ", agentVersion=\'" + this.agentVersion + '\'' + ", deviceId=\'" + this.deviceId + '\'' + ", countryCode=\'" + this.countryCode + '\'' + ", regionCode=\'" + this.regionCode + '\'' + '}';
   }
}
