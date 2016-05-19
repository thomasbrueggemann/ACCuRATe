package com.newrelic.agent.android.harvest.type;

import com.newrelic.agent.android.harvest.type.BaseHarvestable;
import com.newrelic.agent.android.harvest.type.Harvestable;
import com.newrelic.com.google.gson.JsonArray;

public abstract class HarvestableArray extends BaseHarvestable {
   public HarvestableArray() {
      super(Harvestable.Type.ARRAY);
   }

   public abstract JsonArray asJsonArray();
}
