package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.BaseFragmentActivityDonut;
import android.util.AttributeSet;
import android.view.View;

abstract class BaseFragmentActivityHoneycomb extends BaseFragmentActivityDonut {
   public View onCreateView(View var1, String var2, Context var3, AttributeSet var4) {
      View var5 = this.dispatchFragmentsOnCreateView(var1, var2, var3, var4);
      if(var5 == null && VERSION.SDK_INT >= 11) {
         var5 = super.onCreateView(var1, var2, var3, var4);
      }

      return var5;
   }
}
