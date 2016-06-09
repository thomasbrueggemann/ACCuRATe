package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementException;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.ThreadInfo;

public class BaseMeasurement implements Measurement {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private long endTime;
   private long exclusiveTime;
   private boolean finished;
   private String name;
   private String scope;
   private long startTime;
   private ThreadInfo threadInfo;
   private MeasurementType type;

   public BaseMeasurement(Measurement var1) {
      this.setType(var1.getType());
      this.setName(var1.getName());
      this.setScope(var1.getScope());
      this.setStartTime(var1.getStartTime());
      this.setEndTime(var1.getEndTime());
      this.setExclusiveTime(var1.getExclusiveTime());
      this.setThreadInfo(var1.getThreadInfo());
      this.finished = var1.isFinished();
   }

   public BaseMeasurement(MeasurementType var1) {
      this.setType(var1);
   }

   private void throwIfFinished() {
      if(this.finished) {
         throw new MeasurementException("Attempted to modify finished Measurement");
      }
   }

   public double asDouble() {
      throw new UnsupportedOperationException();
   }

   public void finish() {
      if(this.finished) {
         throw new MeasurementException("Finish called on already finished Measurement");
      } else {
         this.finished = true;
      }
   }

   public long getEndTime() {
      return this.endTime;
   }

   public double getEndTimeInSeconds() {
      return (double)this.endTime / 1000.0D;
   }

   public long getExclusiveTime() {
      return this.exclusiveTime;
   }

   public double getExclusiveTimeInSeconds() {
      return (double)this.exclusiveTime / 1000.0D;
   }

   public String getName() {
      return this.name;
   }

   public String getScope() {
      return this.scope;
   }

   public long getStartTime() {
      return this.startTime;
   }

   public double getStartTimeInSeconds() {
      return (double)this.startTime / 1000.0D;
   }

   public ThreadInfo getThreadInfo() {
      return this.threadInfo;
   }

   public MeasurementType getType() {
      return this.type;
   }

   public boolean isFinished() {
      return this.finished;
   }

   public boolean isInstantaneous() {
      return this.endTime == 0L;
   }

   public void setEndTime(long var1) {
      this.throwIfFinished();
      if(var1 < this.startTime) {
         log.error("Measurement end time must not precede start time - startTime: " + this.startTime + " endTime: " + var1);
      } else {
         this.endTime = var1;
      }
   }

   public void setExclusiveTime(long var1) {
      this.throwIfFinished();
      this.exclusiveTime = var1;
   }

   public void setName(String var1) {
      this.throwIfFinished();
      this.name = var1;
   }

   public void setScope(String var1) {
      this.throwIfFinished();
      this.scope = var1;
   }

   public void setStartTime(long var1) {
      this.throwIfFinished();
      this.startTime = var1;
   }

   public void setThreadInfo(ThreadInfo var1) {
      this.threadInfo = var1;
   }

   void setType(MeasurementType var1) {
      this.throwIfFinished();
      this.type = var1;
   }

   public String toString() {
      return "BaseMeasurement{type=" + this.type + ", name=\'" + this.name + '\'' + ", scope=\'" + this.scope + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", exclusiveTime=" + this.exclusiveTime + ", threadInfo=" + this.threadInfo + ", finished=" + this.finished + '}';
   }
}
