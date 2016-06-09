package com.newrelic.agent.android.util;

import android.content.Context;
import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticAttributeStore;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.List;

public class SharedPrefsAnalyticAttributeStore implements AnalyticAttributeStore {
   private static final String STORE_FILE = "NRAnalyticAttributeStore";
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private final Context context;

   public SharedPrefsAnalyticAttributeStore(Context var1) {
      this.context = var1;
   }

   public void clear() {
      // $FF: Couldn't be decompiled
   }

   public int count() {
      int var1 = this.context.getSharedPreferences("NRAnalyticAttributeStore", 0).getAll().size();
      if(log.getLevel() == 4) {
         log.verbose("SharedPrefsAnalyticAttributeStore.count - returning " + var1);
      }

      return var1;
   }

   public void delete(AnalyticAttribute param1) {
      // $FF: Couldn't be decompiled
   }

   public List<AnalyticAttribute> fetchAll() {
      // $FF: Couldn't be decompiled
   }

   public boolean store(AnalyticAttribute param1) {
      // $FF: Couldn't be decompiled
   }
}
