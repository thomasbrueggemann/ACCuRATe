package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonPrimitive;

public class DataToken extends HarvestableArray {
   private int accountId;
   private int agentId;

   public DataToken() {
   }

   public DataToken(int var1, int var2) {
      this.accountId = var1;
      this.agentId = var2;
   }

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      var1.add(new JsonPrimitive(Integer.valueOf(this.accountId)));
      var1.add(new JsonPrimitive(Integer.valueOf(this.agentId)));
      return var1;
   }

   public void clear() {
      this.accountId = 0;
      this.agentId = 0;
   }

   public int getAccountId() {
      return this.accountId;
   }

   public int getAgentId() {
      return this.agentId;
   }

   public boolean isValid() {
      return this.accountId > 0 && this.agentId > 0;
   }

   public void setAccountId(int var1) {
      this.accountId = var1;
   }

   public void setAgentId(int var1) {
      this.agentId = var1;
   }

   public String toString() {
      return "DataToken{accountId=" + this.accountId + ", agentId=" + this.agentId + '}';
   }
}
