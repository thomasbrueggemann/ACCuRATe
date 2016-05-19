package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.com.google.gson.JsonArray;

public class ConnectInformation extends HarvestableArray {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private ApplicationInformation applicationInformation;
   private DeviceInformation deviceInformation;

   public ConnectInformation(ApplicationInformation var1, DeviceInformation var2) {
      if(var1 == null) {
         log.error("null applicationInformation passed into ConnectInformation constructor");
      }

      if(var2 == null) {
         log.error("null deviceInformation passed into ConnectInformation constructor");
      }

      this.applicationInformation = var1;
      this.deviceInformation = var2;
   }

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      this.notNull(this.applicationInformation);
      var1.add(this.applicationInformation.asJsonArray());
      this.notNull(this.deviceInformation);
      var1.add(this.deviceInformation.asJsonArray());
      return var1;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 != null && this.getClass() == var1.getClass()) {
            ConnectInformation var2;
            label28: {
               var2 = (ConnectInformation)var1;
               if(this.applicationInformation != null) {
                  if(this.applicationInformation.equals(var2.applicationInformation)) {
                     break label28;
                  }
               } else if(var2.applicationInformation == null) {
                  break label28;
               }

               return false;
            }

            if(this.deviceInformation != null) {
               if(this.deviceInformation.equals(var2.deviceInformation)) {
                  return true;
               }
            } else if(var2.deviceInformation == null) {
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

   public ApplicationInformation getApplicationInformation() {
      return this.applicationInformation;
   }

   public DeviceInformation getDeviceInformation() {
      return this.deviceInformation;
   }

   public int hashCode() {
      int var1;
      if(this.applicationInformation != null) {
         var1 = this.applicationInformation.hashCode();
      } else {
         var1 = 0;
      }

      int var2 = var1 * 31;
      DeviceInformation var3 = this.deviceInformation;
      int var4 = 0;
      if(var3 != null) {
         var4 = this.deviceInformation.hashCode();
      }

      return var2 + var4;
   }

   public void setApplicationInformation(ApplicationInformation var1) {
      this.applicationInformation = var1;
   }

   public void setDeviceInformation(DeviceInformation var1) {
      this.deviceInformation = var1;
   }
}
