package com.peirr.blooadapp.activities;

import android.app.Activity;
import android.os.Bundle;
import com.peirr.blooadapp.fragments.SummaryFragment;
import com.peirr.blooadapp.io.PreBypassCalculation;

public class SummaryActivity extends Activity {
   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130903044);
      PreBypassCalculation var2 = (PreBypassCalculation)this.getIntent().getParcelableExtra("calculation");
      this.getFragmentManager().beginTransaction().add(2131427338, SummaryFragment.newinstance(var2)).commit();
   }
}
