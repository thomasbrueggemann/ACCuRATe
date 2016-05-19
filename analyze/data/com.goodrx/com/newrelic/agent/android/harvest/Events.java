package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.Event;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Events extends HarvestableArray {
   private final Collection<Event> events = new ArrayList();

   public void addEvent(Event var1) {
      this.events.add(var1);
   }

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      Iterator var2 = this.events.iterator();

      while(var2.hasNext()) {
         var1.add(((Event)var2.next()).asJson());
      }

      return var1;
   }
}
