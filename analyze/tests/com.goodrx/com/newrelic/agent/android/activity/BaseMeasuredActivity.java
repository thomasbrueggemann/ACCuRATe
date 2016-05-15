package com.newrelic.agent.android.activity;

import com.newrelic.agent.android.activity.MeasuredActivity;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementException;
import com.newrelic.agent.android.measurement.MeasurementPool;
import com.newrelic.agent.android.measurement.ThreadInfo;
import com.newrelic.agent.android.tracing.TraceMachine;

public class BaseMeasuredActivity implements MeasuredActivity {
   private boolean autoInstrumented;
   private long endTime;
   private Measurement endingMeasurement;
   private ThreadInfo endingThread;
   private boolean finished;
   private MeasurementPool measurementPool;
   private String name;
   private long startTime;
   private Measurement startingMeasurement;
   private ThreadInfo startingThread;

   private void throwIfFinished() {
      if(this.finished) {
         throw new MeasurementException("Cannot modify finished Activity");
      }
   }

   public void finish() {
      this.finished = true;
   }

   public String getBackgroundMetricName() {
      return TraceMachine.formatActivityBackgroundMetricName(this.name);
   }

   public long getEndTime() {
      return this.endTime;
   }

   public Measurement getEndingMeasurement() {
      return this.endingMeasurement;
   }

   public ThreadInfo getEndingThread() {
      return this.endingThread;
   }

   public MeasurementPool getMeasurementPool() {
      return this.measurementPool;
   }

   public String getMetricName() {
      return TraceMachine.formatActivityMetricName(this.name);
   }

   public String getName() {
      return this.name;
   }

   public long getStartTime() {
      return this.startTime;
   }

   public Measurement getStartingMeasurement() {
      return this.startingMeasurement;
   }

   public ThreadInfo getStartingThread() {
      return this.startingThread;
   }

   public boolean isAutoInstrumented() {
      return this.autoInstrumented;
   }

   public boolean isFinished() {
      return this.finished;
   }

   public void setAutoInstrumented(boolean var1) {
      this.throwIfFinished();
      this.autoInstrumented = var1;
   }

   public void setEndTime(long var1) {
      this.throwIfFinished();
      this.endTime = var1;
   }

   public void setEndingMeasurement(Measurement var1) {
      this.throwIfFinished();
      this.endingMeasurement = var1;
   }

   public void setEndingThread(ThreadInfo var1) {
      this.throwIfFinished();
      this.endingThread = var1;
   }

   public void setMeasurementPool(MeasurementPool var1) {
      this.throwIfFinished();
      this.measurementPool = var1;
   }

   public void setName(String var1) {
      this.throwIfFinished();
      this.name = var1;
   }

   public void setStartTime(long var1) {
      this.throwIfFinished();
      this.startTime = var1;
   }

   public void setStartingMeasurement(Measurement var1) {
      this.throwIfFinished();
      this.startingMeasurement = var1;
   }

   public void setStartingThread(ThreadInfo var1) {
      this.throwIfFinished();
      this.startingThread = var1;
   }
}
