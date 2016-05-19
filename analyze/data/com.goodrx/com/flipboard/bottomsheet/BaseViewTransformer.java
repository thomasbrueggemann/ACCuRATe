package com.flipboard.bottomsheet;

import android.view.View;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.ViewTransformer;

public abstract class BaseViewTransformer implements ViewTransformer {
   public float getDimAlpha(float var1, float var2, float var3, BottomSheetLayout var4, View var5) {
      return 0.7F * (var1 / var2);
   }
}
