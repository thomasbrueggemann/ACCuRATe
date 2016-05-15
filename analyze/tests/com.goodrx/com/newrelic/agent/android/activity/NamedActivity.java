package com.newrelic.agent.android.activity;

import com.newrelic.agent.android.activity.BaseMeasuredActivity;

public class NamedActivity extends BaseMeasuredActivity {
   public NamedActivity(String var1) {
      this.setName(var1);
      this.setAutoInstrumented(false);
   }

   public void rename(String var1) {
      this.setName(var1);
   }
}
