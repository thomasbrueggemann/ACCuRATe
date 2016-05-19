package butterknife.internal;

import android.view.View;
import android.view.View.OnClickListener;

public abstract class DebouncingOnClickListener implements OnClickListener {
   private static final Runnable ENABLE_AGAIN = new Runnable() {
      public void run() {
         DebouncingOnClickListener.enabled = true;
      }
   };
   private static boolean enabled = true;

   public abstract void doClick(View var1);

   public final void onClick(View var1) {
      if(enabled) {
         enabled = false;
         var1.post(ENABLE_AGAIN);
         this.doClick(var1);
      }

   }
}
