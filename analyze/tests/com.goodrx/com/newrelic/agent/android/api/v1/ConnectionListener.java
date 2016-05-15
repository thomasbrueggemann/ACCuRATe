package com.newrelic.agent.android.api.v1;

import com.newrelic.agent.android.api.v1.ConnectionEvent;

public interface ConnectionListener {
   void connected(ConnectionEvent var1);

   void disconnected(ConnectionEvent var1);
}
