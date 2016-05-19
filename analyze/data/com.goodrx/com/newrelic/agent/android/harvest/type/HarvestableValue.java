package com.newrelic.agent.android.harvest.type;

import com.newrelic.agent.android.harvest.type.BaseHarvestable;
import com.newrelic.agent.android.harvest.type.Harvestable;
import com.newrelic.com.google.gson.JsonPrimitive;

public abstract class HarvestableValue extends BaseHarvestable {
   public HarvestableValue() {
      super(Harvestable.Type.VALUE);
   }

   public abstract JsonPrimitive asJsonPrimitive();
}
