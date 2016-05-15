package com.newrelic.agent.android.api.v1;

import com.newrelic.agent.android.api.common.ConnectionState;
import java.util.EventObject;

public final class ConnectionEvent extends EventObject {
   private static final long serialVersionUID = 1L;
   private final ConnectionState connectionState;

   public ConnectionEvent(Object var1) {
      this(var1, (ConnectionState)null);
   }

   public ConnectionEvent(Object var1, ConnectionState var2) {
      super(var1);
      this.connectionState = var2;
   }

   public ConnectionState getConnectionState() {
      return this.connectionState;
   }
}
