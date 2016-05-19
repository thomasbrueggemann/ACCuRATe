package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;

public class ActivitySighting extends HarvestableArray {
   private long durationMs = 0L;
   private String name;
   private final long timestampMs;

   public ActivitySighting(long var1, String var3) {
      this.timestampMs = var1;
      this.name = var3;
   }

   public static ActivitySighting newFromJson(JsonArray var0) {
      return new ActivitySighting(var0.get(0).getAsLong(), var0.get(1).getAsString());
   }

   public JsonArray asJsonArray() {
      // $FF: Couldn't be decompiled
   }

   public JsonArray asJsonArrayWithoutDuration() {
      // $FF: Couldn't be decompiled
   }

   public void end(long param1) {
      // $FF: Couldn't be decompiled
   }

   public long getDuration() {
      return this.durationMs;
   }

   public String getName() {
      return this.name;
   }

   public long getTimestampMs() {
      return this.timestampMs;
   }

   public void setName(String param1) {
      // $FF: Couldn't be decompiled
   }
}
