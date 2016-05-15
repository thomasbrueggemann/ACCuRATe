package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.Harvestable;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class HarvestableCache {
   private static final int DEFAULT_CACHE_LIMIT = 1024;
   private final Collection<Harvestable> cache = this.getNewCache();
   private int limit = 1024;

   public void add(Harvestable var1) {
      if(var1 != null && this.cache.size() < this.limit) {
         this.cache.add(var1);
      }
   }

   public Collection<Harvestable> flush() {
      // $FF: Couldn't be decompiled
   }

   public boolean get(Object var1) {
      return this.cache.contains(var1);
   }

   protected Collection<Harvestable> getNewCache() {
      return new CopyOnWriteArrayList();
   }

   public int getSize() {
      return this.cache.size();
   }

   public void setLimit(int var1) {
      this.limit = var1;
   }
}
