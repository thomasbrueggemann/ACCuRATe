package com.newrelic.agent.android.background;

import com.newrelic.agent.android.background.ApplicationStateEvent;

public interface ApplicationStateListener {
   void applicationBackgrounded(ApplicationStateEvent var1);

   void applicationForegrounded(ApplicationStateEvent var1);
}
