package android.support.design.widget;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.design.class_5;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatDialog;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class BottomSheetDialog extends AppCompatDialog {
   private BottomSheetBehavior.BottomSheetCallback mBottomSheetCallback;

   public BottomSheetDialog(@NonNull Context var1) {
      this(var1, 0);
   }

   public BottomSheetDialog(@NonNull Context var1, @StyleRes int var2) {
      super(var1, getThemeResId(var1, var2));
      this.mBottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
         public void onSlide(@NonNull View var1, float var2) {
         }

         public void onStateChanged(@NonNull View var1, int var2) {
            if(var2 == 5) {
               BottomSheetDialog.this.dismiss();
            }

         }
      };
   }

   protected BottomSheetDialog(@NonNull Context var1, boolean var2, OnCancelListener var3) {
      super(var1, var2, var3);
      this.mBottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
         public void onSlide(@NonNull View var1, float var2) {
         }

         public void onStateChanged(@NonNull View var1, int var2) {
            if(var2 == 5) {
               BottomSheetDialog.this.dismiss();
            }

         }
      };
   }

   private static int getThemeResId(Context var0, int var1) {
      if(var1 == 0) {
         TypedValue var2 = new TypedValue();
         if(!var0.getTheme().resolveAttribute(class_5.attr.bottomSheetDialogTheme, var2, true)) {
            return class_5.style.Theme_Design_Light_BottomSheetDialog;
         }

         var1 = var2.resourceId;
      }

      return var1;
   }

   private boolean shouldWindowCloseOnTouchOutside() {
      if(VERSION.SDK_INT >= 11) {
         TypedValue var1 = new TypedValue();
         if(!this.getContext().getTheme().resolveAttribute(16843611, var1, true)) {
            return false;
         }

         if(var1.data == 0) {
            return false;
         }
      }

      return true;
   }

   private View wrapInBottomSheet(int var1, final View var2, LayoutParams var3) {
      final CoordinatorLayout var4 = (CoordinatorLayout)View.inflate(this.getContext(), class_5.layout.design_bottom_sheet_dialog, (ViewGroup)null);
      if(var1 != 0 && var2 == null) {
         var2 = this.getLayoutInflater().inflate(var1, var4, false);
      }

      FrameLayout var5 = (FrameLayout)var4.findViewById(class_5.class_113.design_bottom_sheet);
      BottomSheetBehavior.from(var5).setBottomSheetCallback(this.mBottomSheetCallback);
      if(var3 == null) {
         var5.addView(var2);
      } else {
         var5.addView(var2, var3);
      }

      if(this.shouldWindowCloseOnTouchOutside()) {
         var4.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View var1, MotionEvent var2x) {
               if(BottomSheetDialog.this.isShowing() && MotionEventCompat.getActionMasked(var2x) == 1 && !var4.isPointInChildBounds(var2, (int)var2x.getX(), (int)var2x.getY())) {
                  BottomSheetDialog.this.cancel();
                  return true;
               } else {
                  return false;
               }
            }
         });
      }

      return var4;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.getWindow().setLayout(-1, -1);
   }

   public void setContentView(@LayoutRes int var1) {
      super.setContentView(this.wrapInBottomSheet(var1, (View)null, (LayoutParams)null));
   }

   public void setContentView(View var1) {
      super.setContentView(this.wrapInBottomSheet(0, var1, (LayoutParams)null));
   }

   public void setContentView(View var1, LayoutParams var2) {
      super.setContentView(this.wrapInBottomSheet(0, var1, var2));
   }
}
