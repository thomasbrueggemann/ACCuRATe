package android.support.v4.app;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;

public abstract class FragmentContainer {
   @Nullable
   public abstract View onFindViewById(@IdRes int var1);

   public abstract boolean onHasView();
}
