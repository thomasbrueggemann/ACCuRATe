package com.newrelic.agent.android.measurement;

public enum MeasurementType {
   Activity,
   Any,
   Custom,
   HttpError,
   Machine,
   Method,
   Network;

   static {
      MeasurementType[] var0 = new MeasurementType[]{Network, HttpError, Method, Activity, Custom, Any, Machine};
   }
}
