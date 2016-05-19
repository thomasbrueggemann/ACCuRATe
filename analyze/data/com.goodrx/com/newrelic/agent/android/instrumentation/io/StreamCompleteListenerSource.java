package com.newrelic.agent.android.instrumentation.io;

import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;

public interface StreamCompleteListenerSource {
   void addStreamCompleteListener(StreamCompleteListener var1);

   void removeStreamCompleteListener(StreamCompleteListener var1);
}
