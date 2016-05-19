package com.newrelic.agent.android.tracing;

public enum TraceType {
   NETWORK,
   TRACE;

   static {
      TraceType[] var0 = new TraceType[]{TRACE, NETWORK};
   }
}
