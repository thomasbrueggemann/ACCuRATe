package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.class_22;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

public class AppCompatPopupWindow extends PopupWindow {
   private static final boolean COMPAT_OVERLAP_ANCHOR = false;
   private static final String TAG = "AppCompatPopupWindow";
   private boolean mOverlapAnchor;

   static {
      boolean var0;
      if(VERSION.SDK_INT < 21) {
         var0 = true;
      } else {
         var0 = false;
      }

      COMPAT_OVERLAP_ANCHOR = var0;
   }

   public AppCompatPopupWindow(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      TintTypedArray var4 = TintTypedArray.obtainStyledAttributes(var1, var2, class_22.styleable.PopupWindow, var3, 0);
      if(var4.hasValue(class_22.styleable.PopupWindow_overlapAnchor)) {
         this.setSupportOverlapAnchor(var4.getBoolean(class_22.styleable.PopupWindow_overlapAnchor, false));
      }

      this.setBackgroundDrawable(var4.getDrawable(class_22.styleable.PopupWindow_android_popupBackground));
      var4.recycle();
      if(VERSION.SDK_INT < 14) {
         wrapOnScrollChangedListener(this);
      }

   }

   private static void wrapOnScrollChangedListener(final PopupWindow var0) {
      try {
         final Field var3 = PopupWindow.class.getDeclaredField("mAnchor");
         var3.setAccessible(true);
         Field var4 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
         var4.setAccessible(true);
         var4.set(var0, new OnScrollChangedListener() {
            // $FF: synthetic field
            final OnScrollChangedListener val$originalListener;

            {
               this.val$originalListener = var3x;
            }

            public void onScrollChanged() {
               // $FF: Couldn't be decompiled
            }
         });
      } catch (Exception var5) {
         Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", var5);
      }
   }

   public boolean getSupportOverlapAnchor() {
      return COMPAT_OVERLAP_ANCHOR?this.mOverlapAnchor:PopupWindowCompat.getOverlapAnchor(this);
   }

   public void setSupportOverlapAnchor(boolean var1) {
      if(COMPAT_OVERLAP_ANCHOR) {
         this.mOverlapAnchor = var1;
      } else {
         PopupWindowCompat.setOverlapAnchor(this, var1);
      }
   }

   public void showAsDropDown(View var1, int var2, int var3) {
      if(COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
         var3 -= var1.getHeight();
      }

      super.showAsDropDown(var1, var2, var3);
   }

   @TargetApi(19)
   public void showAsDropDown(View var1, int var2, int var3, int var4) {
      if(COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
         var3 -= var1.getHeight();
      }

      super.showAsDropDown(var1, var2, var3, var4);
   }

   public void update(View var1, int var2, int var3, int var4, int var5) {
      if(COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
         var3 -= var1.getHeight();
      }

      super.update(var1, var2, var3, var4, var5);
   }
}
