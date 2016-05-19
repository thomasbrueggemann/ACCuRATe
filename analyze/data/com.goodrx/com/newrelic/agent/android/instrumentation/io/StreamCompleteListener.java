package com.newrelic.agent.android.instrumentation.io;

import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;

public interface StreamCompleteListener {
   void streamComplete(StreamCompleteEvent var1);

   void streamError(StreamCompleteEvent var1);
}
