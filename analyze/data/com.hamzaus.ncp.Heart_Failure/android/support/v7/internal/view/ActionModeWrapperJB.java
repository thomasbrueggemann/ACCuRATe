package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.internal.view.ActionModeWrapper;
import android.view.ActionMode;

public class ActionModeWrapperJB extends ActionModeWrapper {
   public ActionModeWrapperJB(Context var1, ActionMode var2) {
      super(var1, var2);
   }

   public boolean getTitleOptionalHint() {
      return this.mWrappedObject.getTitleOptionalHint();
   }

   public boolean isTitleOptional() {
      return this.mWrappedObject.isTitleOptional();
   }

   public void setTitleOptionalHint(boolean var1) {
      this.mWrappedObject.setTitleOptionalHint(var1);
   }

   public static class CallbackWrapper extends ActionModeWrapper.CallbackWrapper {
      public CallbackWrapper(Context var1, android.support.v7.view.ActionMode.Callback var2) {
         super(var1, var2);
      }

      protected ActionModeWrapper createActionModeWrapper(Context var1, ActionMode var2) {
         return new ActionModeWrapperJB(var1, var2);
      }
   }
}
