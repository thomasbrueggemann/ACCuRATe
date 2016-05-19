package com.newrelic.agent.android.crashes;

import com.newrelic.agent.android.harvest.crash.Crash;
import java.util.List;

public interface CrashStore {
   void clear();

   int count();

   void delete(Crash var1);

   List<Crash> fetchAll();

   void store(Crash var1);
}
