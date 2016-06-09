package com.flipboard.bottomsheet;

import android.view.View;
import com.flipboard.bottomsheet.BottomSheetLayout;

public interface ViewTransformer {
   float getDimAlpha(float var1, float var2, float var3, BottomSheetLayout var4, View var5);

   void transformView(float var1, float var2, float var3, BottomSheetLayout var4, View var5);
}
