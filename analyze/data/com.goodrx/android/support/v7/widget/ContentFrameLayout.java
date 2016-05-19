package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout {
   private ContentFrameLayout.OnAttachListener mAttachListener;
   private final Rect mDecorPadding;
   private TypedValue mFixedHeightMajor;
   private TypedValue mFixedHeightMinor;
   private TypedValue mFixedWidthMajor;
   private TypedValue mFixedWidthMinor;
   private TypedValue mMinWidthMajor;
   private TypedValue mMinWidthMinor;

   public ContentFrameLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public ContentFrameLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public ContentFrameLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mDecorPadding = new Rect();
   }

   public void dispatchFitSystemWindows(Rect var1) {
      this.fitSystemWindows(var1);
   }

   public TypedValue getFixedHeightMajor() {
      if(this.mFixedHeightMajor == null) {
         this.mFixedHeightMajor = new TypedValue();
      }

      return this.mFixedHeightMajor;
   }

   public TypedValue getFixedHeightMinor() {
      if(this.mFixedHeightMinor == null) {
         this.mFixedHeightMinor = new TypedValue();
      }

      return this.mFixedHeightMinor;
   }

   public TypedValue getFixedWidthMajor() {
      if(this.mFixedWidthMajor == null) {
         this.mFixedWidthMajor = new TypedValue();
      }

      return this.mFixedWidthMajor;
   }

   public TypedValue getFixedWidthMinor() {
      if(this.mFixedWidthMinor == null) {
         this.mFixedWidthMinor = new TypedValue();
      }

      return this.mFixedWidthMinor;
   }

   public TypedValue getMinWidthMajor() {
      if(this.mMinWidthMajor == null) {
         this.mMinWidthMajor = new TypedValue();
      }

      return this.mMinWidthMajor;
   }

   public TypedValue getMinWidthMinor() {
      if(this.mMinWidthMinor == null) {
         this.mMinWidthMinor = new TypedValue();
      }

      return this.mMinWidthMinor;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      if(this.mAttachListener != null) {
         this.mAttachListener.onAttachedFromWindow();
      }

   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if(this.mAttachListener != null) {
         this.mAttachListener.onDetachedFromWindow();
      }

   }

   protected void onMeasure(int var1, int var2) {
      DisplayMetrics var3 = this.getContext().getResources().getDisplayMetrics();
      boolean var4;
      if(var3.widthPixels < var3.heightPixels) {
         var4 = true;
      } else {
         var4 = false;
      }

      int var5 = MeasureSpec.getMode(var1);
      int var6 = MeasureSpec.getMode(var2);
      boolean var7 = false;
      if(var5 == Integer.MIN_VALUE) {
         TypedValue var18;
         if(var4) {
            var18 = this.mFixedWidthMinor;
         } else {
            var18 = this.mFixedWidthMajor;
         }

         var7 = false;
         if(var18 != null) {
            int var19 = var18.type;
            var7 = false;
            if(var19 != 0) {
               int var21;
               if(var18.type == 5) {
                  var21 = (int)var18.getDimension(var3);
               } else {
                  int var20 = var18.type;
                  var21 = 0;
                  if(var20 == 6) {
                     var21 = (int)var18.getFraction((float)var3.widthPixels, (float)var3.widthPixels);
                  }
               }

               var7 = false;
               if(var21 > 0) {
                  var1 = MeasureSpec.makeMeasureSpec(Math.min(var21 - (this.mDecorPadding.left + this.mDecorPadding.right), MeasureSpec.getSize(var1)), 1073741824);
                  var7 = true;
               }
            }
         }
      }

      if(var6 == Integer.MIN_VALUE) {
         TypedValue var15;
         if(var4) {
            var15 = this.mFixedHeightMajor;
         } else {
            var15 = this.mFixedHeightMinor;
         }

         if(var15 != null && var15.type != 0) {
            int var17;
            if(var15.type == 5) {
               var17 = (int)var15.getDimension(var3);
            } else {
               int var16 = var15.type;
               var17 = 0;
               if(var16 == 6) {
                  var17 = (int)var15.getFraction((float)var3.heightPixels, (float)var3.heightPixels);
               }
            }

            if(var17 > 0) {
               var2 = MeasureSpec.makeMeasureSpec(Math.min(var17 - (this.mDecorPadding.top + this.mDecorPadding.bottom), MeasureSpec.getSize(var2)), 1073741824);
            }
         }
      }

      super.onMeasure(var1, var2);
      int var8 = this.getMeasuredWidth();
      int var9 = MeasureSpec.makeMeasureSpec(var8, 1073741824);
      boolean var10 = false;
      if(!var7) {
         var10 = false;
         if(var5 == Integer.MIN_VALUE) {
            TypedValue var11;
            if(var4) {
               var11 = this.mMinWidthMinor;
            } else {
               var11 = this.mMinWidthMajor;
            }

            var10 = false;
            if(var11 != null) {
               int var12 = var11.type;
               var10 = false;
               if(var12 != 0) {
                  int var14;
                  if(var11.type == 5) {
                     var14 = (int)var11.getDimension(var3);
                  } else {
                     int var13 = var11.type;
                     var14 = 0;
                     if(var13 == 6) {
                        var14 = (int)var11.getFraction((float)var3.widthPixels, (float)var3.widthPixels);
                     }
                  }

                  if(var14 > 0) {
                     var14 -= this.mDecorPadding.left + this.mDecorPadding.right;
                  }

                  var10 = false;
                  if(var8 < var14) {
                     var9 = MeasureSpec.makeMeasureSpec(var14, 1073741824);
                     var10 = true;
                  }
               }
            }
         }
      }

      if(var10) {
         super.onMeasure(var9, var2);
      }

   }

   public void setAttachListener(ContentFrameLayout.OnAttachListener var1) {
      this.mAttachListener = var1;
   }

   public void setDecorPadding(int var1, int var2, int var3, int var4) {
      this.mDecorPadding.set(var1, var2, var3, var4);
      if(ViewCompat.isLaidOut(this)) {
         this.requestLayout();
      }

   }

   public interface OnAttachListener {
      void onAttachedFromWindow();

      void onDetachedFromWindow();
   }
}
