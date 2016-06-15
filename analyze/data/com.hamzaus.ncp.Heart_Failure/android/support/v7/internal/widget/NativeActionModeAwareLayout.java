package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.ActionMode.Callback;
import android.widget.LinearLayout;

public class NativeActionModeAwareLayout extends LinearLayout {
   private NativeActionModeAwareLayout.OnActionModeForChildListener mActionModeForChildListener;

   public NativeActionModeAwareLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public void setActionModeForChildListener(NativeActionModeAwareLayout.OnActionModeForChildListener var1) {
      this.mActionModeForChildListener = var1;
   }

   public ActionMode startActionModeForChild(View var1, Callback var2) {
      if(this.mActionModeForChildListener != null) {
         var2 = this.mActionModeForChildListener.onActionModeForChild(var2);
      }

      return super.startActionModeForChild(var1, var2);
   }

   public interface OnActionModeForChildListener {
      Callback onActionModeForChild(Callback var1);
   }
}
