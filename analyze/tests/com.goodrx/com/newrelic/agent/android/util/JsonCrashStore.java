package com.newrelic.agent.android.util;

import android.content.Context;
import com.newrelic.agent.android.crashes.CrashStore;
import com.newrelic.agent.android.harvest.crash.Crash;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.List;

public class JsonCrashStore implements CrashStore {
   private static final String STORE_FILE = "NRCrashStore";
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private final Context context;

   public JsonCrashStore(Context var1) {
      this.context = var1;
   }

   public void clear() {
      // $FF: Couldn't be decompiled
   }

   public int count() {
      return this.context.getSharedPreferences("NRCrashStore", 0).getAll().size();
   }

   public void delete(Crash param1) {
      // $FF: Couldn't be decompiled
   }

   public List<Crash> fetchAll() {
      // $FF: Couldn't be decompiled
   }

   public void store(Crash param1) {
      // $FF: Couldn't be decompiled
   }
}
