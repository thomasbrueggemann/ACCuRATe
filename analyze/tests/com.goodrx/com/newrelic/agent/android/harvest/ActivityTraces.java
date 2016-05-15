package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ActivityTraces extends HarvestableArray {
   private final Collection<ActivityTrace> activityTraces = new ArrayList();

   public void add(ActivityTrace var1) {
      synchronized(this){}

      try {
         this.activityTraces.add(var1);
      } finally {
         ;
      }

   }

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      Iterator var2 = this.activityTraces.iterator();

      while(var2.hasNext()) {
         var1.add(((ActivityTrace)var2.next()).asJson());
      }

      return var1;
   }

   public void clear() {
      this.activityTraces.clear();
   }

   public int count() {
      return this.activityTraces.size();
   }

   public Collection<ActivityTrace> getActivityTraces() {
      return this.activityTraces;
   }

   public void remove(ActivityTrace var1) {
      synchronized(this){}

      try {
         this.activityTraces.remove(var1);
      } finally {
         ;
      }

   }
}
