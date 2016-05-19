package com.comscore.instrumentation;

import android.os.Bundle;
import com.comscore.analytics.comScore;
import com.google.android.maps.MapActivity;

public class InstrumentedMapActivity extends MapActivity {
   protected boolean isRouteDisplayed() {
      return false;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      comScore.setAppContext(this.getApplicationContext());
   }

   protected void onPause() {
      super.onPause();
      comScore.onExitForeground();
   }

   protected void onResume() {
      super.onResume();
      comScore.getCore().setCurrentActivityName(this.getClass().getSimpleName());
      comScore.onEnterForeground();
   }
}
