package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;

abstract class BaseFragmentActivityDonut extends Activity implements TraceFieldInterface {
   abstract View dispatchFragmentsOnCreateView(View var1, String var2, Context var3, AttributeSet var4);

   protected void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public View onCreateView(String var1, Context var2, AttributeSet var3) {
      View var4 = this.dispatchFragmentsOnCreateView((View)null, var1, var2, var3);
      if(var4 == null) {
         var4 = super.onCreateView(var1, var2, var3);
      }

      return var4;
   }

   protected void onStart() {
      super.onStart();
      ApplicationStateMonitor.getInstance().activityStarted();
   }

   protected void onStop() {
      super.onStop();
      ApplicationStateMonitor.getInstance().activityStopped();
   }
}
