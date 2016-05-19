package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.ThreadInfo;

public interface Measurement {
   double asDouble();

   void finish();

   long getEndTime();

   double getEndTimeInSeconds();

   long getExclusiveTime();

   double getExclusiveTimeInSeconds();

   String getName();

   String getScope();

   long getStartTime();

   double getStartTimeInSeconds();

   ThreadInfo getThreadInfo();

   MeasurementType getType();

   boolean isFinished();

   boolean isInstantaneous();
}
