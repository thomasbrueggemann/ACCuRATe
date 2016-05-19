package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.analytics.AnalyticAttribute;
import java.util.List;

public interface AnalyticAttributeStore {
   void clear();

   int count();

   void delete(AnalyticAttribute var1);

   List<AnalyticAttribute> fetchAll();

   boolean store(AnalyticAttribute var1);
}
