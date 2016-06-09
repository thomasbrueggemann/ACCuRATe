package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.ActivitySighting;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActivityHistory extends HarvestableArray {
   private final List<ActivitySighting> activityHistory;

   public ActivityHistory(List<ActivitySighting> var1) {
      this.activityHistory = var1;
   }

   public static ActivityHistory newFromJson(JsonArray var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         var1.add(ActivitySighting.newFromJson(((JsonElement)var2.next()).getAsJsonArray()));
      }

      return new ActivityHistory(var1);
   }

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      Iterator var2 = this.activityHistory.iterator();

      while(var2.hasNext()) {
         var1.add(((ActivitySighting)var2.next()).asJsonArray());
      }

      return var1;
   }

   public JsonArray asJsonArrayWithoutDuration() {
      JsonArray var1 = new JsonArray();
      Iterator var2 = this.activityHistory.iterator();

      while(var2.hasNext()) {
         var1.add(((ActivitySighting)var2.next()).asJsonArrayWithoutDuration());
      }

      return var1;
   }

   public int size() {
      return this.activityHistory.size();
   }
}
