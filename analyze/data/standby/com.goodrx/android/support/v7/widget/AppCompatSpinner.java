package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.class_22;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.AppCompatBackgroundHelper;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.ViewUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;

public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
   private static final int[] ATTRS_ANDROID_SPINNERMODE;
   private static final boolean IS_AT_LEAST_JB = false;
   private static final boolean IS_AT_LEAST_M = false;
   private static final int MAX_ITEMS_MEASURED = 15;
   private static final int MODE_DIALOG = 0;
   private static final int MODE_DROPDOWN = 1;
   private static final int MODE_THEME = -1;
   private static final String TAG = "AppCompatSpinner";
   private AppCompatBackgroundHelper mBackgroundTintHelper;
   private AppCompatDrawableManager mDrawableManager;
   private int mDropDownWidth;
   private ListPopupWindow.ForwardingListener mForwardingListener;
   private AppCompatSpinner.DropdownPopup mPopup;
   private Context mPopupContext;
   private boolean mPopupSet;
   private SpinnerAdapter mTempAdapter;
   private final Rect mTempRect;

   static {
      boolean var0;
      if(VERSION.SDK_INT >= 23) {
         var0 = true;
      } else {
         var0 = false;
      }

      IS_AT_LEAST_M = var0;
      boolean var1;
      if(VERSION.SDK_INT >= 16) {
         var1 = true;
      } else {
         var1 = false;
      }

      IS_AT_LEAST_JB = var1;
      ATTRS_ANDROID_SPINNERMODE = new int[]{16843505};
   }

   public AppCompatSpinner(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AppCompatSpinner(Context var1, int var2) {
      this(var1, (AttributeSet)null, class_22.attr.spinnerStyle, var2);
   }

   public AppCompatSpinner(Context var1, AttributeSet var2) {
      this(var1, var2, class_22.attr.spinnerStyle);
   }

   public AppCompatSpinner(Context var1, AttributeSet var2, int var3) {
      this(var1, var2, var3, -1);
   }

   public AppCompatSpinner(Context var1, AttributeSet var2, int var3, int var4) {
      this(var1, var2, var3, var4, (Theme)null);
   }

   public AppCompatSpinner(Context var1, AttributeSet var2, int var3, int var4, Theme var5) {
      super(var1, var2, var3);
      this.mTempRect = new Rect();
      TintTypedArray var6 = TintTypedArray.obtainStyledAttributes(var1, var2, class_22.styleable.Spinner, var3, 0);
      this.mDrawableManager = AppCompatDrawableManager.get();
      this.mBackgroundTintHelper = new AppCompatBackgroundHelper(this, this.mDrawableManager);
      if(var5 != null) {
         this.mPopupContext = new ContextThemeWrapper(var1, var5);
      } else {
         int var7 = var6.getResourceId(class_22.styleable.Spinner_popupTheme, 0);
         if(var7 != 0) {
            this.mPopupContext = new ContextThemeWrapper(var1, var7);
         } else {
            Context var8;
            if(!IS_AT_LEAST_M) {
               var8 = var1;
            } else {
               var8 = null;
            }

            this.mPopupContext = var8;
         }
      }

      if(this.mPopupContext != null) {
         if(var4 == -1) {
            if(VERSION.SDK_INT >= 11) {
               label155: {
                  TypedArray var13 = null;
                  boolean var20 = false;

                  label143: {
                     int var17;
                     label142: {
                        try {
                           var20 = true;
                           var13 = var1.obtainStyledAttributes(var2, ATTRS_ANDROID_SPINNERMODE, var3, 0);
                           if(!var13.hasValue(0)) {
                              var20 = false;
                              break label143;
                           }

                           var17 = var13.getInt(0, 0);
                           var20 = false;
                           break label142;
                        } catch (Exception var21) {
                           Log.i("AppCompatSpinner", "Could not read android:spinnerMode", var21);
                           var20 = false;
                        } finally {
                           if(var20) {
                              if(var13 != null) {
                                 var13.recycle();
                              }

                           }
                        }

                        if(var13 != null) {
                           var13.recycle();
                        }
                        break label155;
                     }

                     var4 = var17;
                  }

                  if(var13 != null) {
                     var13.recycle();
                  }
               }
            } else {
               var4 = 1;
            }
         }

         if(var4 == 1) {
            final AppCompatSpinner.DropdownPopup var11 = new AppCompatSpinner.DropdownPopup(this.mPopupContext, var2, var3);
            TintTypedArray var12 = TintTypedArray.obtainStyledAttributes(this.mPopupContext, var2, class_22.styleable.Spinner, var3, 0);
            this.mDropDownWidth = var12.getLayoutDimension(class_22.styleable.Spinner_android_dropDownWidth, -2);
            var11.setBackgroundDrawable(var12.getDrawable(class_22.styleable.Spinner_android_popupBackground));
            var11.setPromptText(var6.getString(class_22.styleable.Spinner_android_prompt));
            var12.recycle();
            this.mPopup = var11;
            this.mForwardingListener = new ListPopupWindow.ForwardingListener(this) {
               public ListPopupWindow getPopup() {
                  return var11;
               }

               public boolean onForwardingStarted() {
                  if(!AppCompatSpinner.this.mPopup.isShowing()) {
                     AppCompatSpinner.this.mPopup.show();
                  }

                  return true;
               }
            };
         }
      }

      CharSequence[] var9 = var6.getTextArray(class_22.styleable.Spinner_android_entries);
      if(var9 != null) {
         ArrayAdapter var10 = new ArrayAdapter(var1, class_22.layout.support_simple_spinner_dropdown_item, var9);
         var10.setDropDownViewResource(class_22.layout.support_simple_spinner_dropdown_item);
         this.setAdapter((SpinnerAdapter)var10);
      }

      var6.recycle();
      this.mPopupSet = true;
      if(this.mTempAdapter != null) {
         this.setAdapter(this.mTempAdapter);
         this.mTempAdapter = null;
      }

      this.mBackgroundTintHelper.loadFromAttributes(var2, var3);
   }

   private int compatMeasureContentWidth(SpinnerAdapter var1, Drawable var2) {
      int var3;
      if(var1 == null) {
         var3 = 0;
      } else {
         var3 = 0;
         View var4 = null;
         int var5 = 0;
         int var6 = MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0);
         int var7 = MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0);
         int var8 = Math.max(0, this.getSelectedItemPosition());
         int var9 = Math.min(var1.getCount(), var8 + 15);

         for(int var10 = Math.max(0, var8 - (15 - (var9 - var8))); var10 < var9; ++var10) {
            int var12 = var1.getItemViewType(var10);
            if(var12 != var5) {
               var5 = var12;
               var4 = null;
            }

            var4 = var1.getView(var10, var4, this);
            if(var4.getLayoutParams() == null) {
               var4.setLayoutParams(new LayoutParams(-2, -2));
            }

            var4.measure(var6, var7);
            var3 = Math.max(var3, var4.getMeasuredWidth());
         }

         if(var2 != null) {
            var2.getPadding(this.mTempRect);
            return var3 + this.mTempRect.left + this.mTempRect.right;
         }
      }

      return var3;
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      if(this.mBackgroundTintHelper != null) {
         this.mBackgroundTintHelper.applySupportBackgroundTint();
      }

   }

   public int getDropDownHorizontalOffset() {
      return this.mPopup != null?this.mPopup.getHorizontalOffset():(IS_AT_LEAST_JB?super.getDropDownHorizontalOffset():0);
   }

   public int getDropDownVerticalOffset() {
      return this.mPopup != null?this.mPopup.getVerticalOffset():(IS_AT_LEAST_JB?super.getDropDownVerticalOffset():0);
   }

   public int getDropDownWidth() {
      return this.mPopup != null?this.mDropDownWidth:(IS_AT_LEAST_JB?super.getDropDownWidth():0);
   }

   public Drawable getPopupBackground() {
      return this.mPopup != null?this.mPopup.getBackground():(IS_AT_LEAST_JB?super.getPopupBackground():null);
   }

   public Context getPopupContext() {
      return this.mPopup != null?this.mPopupContext:(IS_AT_LEAST_M?super.getPopupContext():null);
   }

   public CharSequence getPrompt() {
      return this.mPopup != null?this.mPopup.getHintText():super.getPrompt();
   }

   @Nullable
   public ColorStateList getSupportBackgroundTintList() {
      return this.mBackgroundTintHelper != null?this.mBackgroundTintHelper.getSupportBackgroundTintList():null;
   }

   @Nullable
   public Mode getSupportBackgroundTintMode() {
      return this.mBackgroundTintHelper != null?this.mBackgroundTintHelper.getSupportBackgroundTintMode():null;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if(this.mPopup != null && this.mPopup.isShowing()) {
         this.mPopup.dismiss();
      }

   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if(this.mPopup != null && MeasureSpec.getMode(var1) == Integer.MIN_VALUE) {
         this.setMeasuredDimension(Math.min(Math.max(this.getMeasuredWidth(), this.compatMeasureContentWidth(this.getAdapter(), this.getBackground())), MeasureSpec.getSize(var1)), this.getMeasuredHeight());
      }

   }

   public boolean onTouchEvent(MotionEvent var1) {
      return this.mForwardingListener != null && this.mForwardingListener.onTouch(this, var1)?true:super.onTouchEvent(var1);
   }

   public boolean performClick() {
      if(this.mPopup != null && !this.mPopup.isShowing()) {
         this.mPopup.show();
         return true;
      } else {
         return super.performClick();
      }
   }

   public void setAdapter(SpinnerAdapter var1) {
      if(!this.mPopupSet) {
         this.mTempAdapter = var1;
      } else {
         super.setAdapter(var1);
         if(this.mPopup != null) {
            Context var2;
            if(this.mPopupContext == null) {
               var2 = this.getContext();
            } else {
               var2 = this.mPopupContext;
            }

            this.mPopup.setAdapter(new AppCompatSpinner.DropDownAdapter(var1, var2.getTheme()));
            return;
         }
      }

   }

   public void setBackgroundDrawable(Drawable var1) {
      super.setBackgroundDrawable(var1);
      if(this.mBackgroundTintHelper != null) {
         this.mBackgroundTintHelper.onSetBackgroundDrawable(var1);
      }

   }

   public void setBackgroundResource(@DrawableRes int var1) {
      super.setBackgroundResource(var1);
      if(this.mBackgroundTintHelper != null) {
         this.mBackgroundTintHelper.onSetBackgroundResource(var1);
      }

   }

   public void setDropDownHorizontalOffset(int var1) {
      if(this.mPopup != null) {
         this.mPopup.setHorizontalOffset(var1);
      } else if(IS_AT_LEAST_JB) {
         super.setDropDownHorizontalOffset(var1);
         return;
      }

   }

   public void setDropDownVerticalOffset(int var1) {
      if(this.mPopup != null) {
         this.mPopup.setVerticalOffset(var1);
      } else if(IS_AT_LEAST_JB) {
         super.setDropDownVerticalOffset(var1);
         return;
      }

   }

   public void setDropDownWidth(int var1) {
      if(this.mPopup != null) {
         this.mDropDownWidth = var1;
      } else if(IS_AT_LEAST_JB) {
         super.setDropDownWidth(var1);
         return;
      }

   }

   public void setPopupBackgroundDrawable(Drawable var1) {
      if(this.mPopup != null) {
         this.mPopup.setBackgroundDrawable(var1);
      } else if(IS_AT_LEAST_JB) {
         super.setPopupBackgroundDrawable(var1);
         return;
      }

   }

   public void setPopupBackgroundResource(@DrawableRes int var1) {
      this.setPopupBackgroundDrawable(this.getPopupContext().getDrawable(var1));
   }

   public void setPrompt(CharSequence var1) {
      if(this.mPopup != null) {
         this.mPopup.setPromptText(var1);
      } else {
         super.setPrompt(var1);
      }
   }

   public void setSupportBackgroundTintList(@Nullable ColorStateList var1) {
      if(this.mBackgroundTintHelper != null) {
         this.mBackgroundTintHelper.setSupportBackgroundTintList(var1);
      }

   }

   public void setSupportBackgroundTintMode(@Nullable Mode var1) {
      if(this.mBackgroundTintHelper != null) {
         this.mBackgroundTintHelper.setSupportBackgroundTintMode(var1);
      }

   }

   private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
      private SpinnerAdapter mAdapter;
      private ListAdapter mListAdapter;

      public DropDownAdapter(@Nullable SpinnerAdapter var1, @Nullable Theme var2) {
         this.mAdapter = var1;
         if(var1 instanceof ListAdapter) {
            this.mListAdapter = (ListAdapter)var1;
         }

         if(var2 != null) {
            if(AppCompatSpinner.IS_AT_LEAST_M && var1 instanceof android.widget.ThemedSpinnerAdapter) {
               android.widget.ThemedSpinnerAdapter var4 = (android.widget.ThemedSpinnerAdapter)var1;
               if(var4.getDropDownViewTheme() != var2) {
                  var4.setDropDownViewTheme(var2);
               }
            } else if(var1 instanceof ThemedSpinnerAdapter) {
               ThemedSpinnerAdapter var3 = (ThemedSpinnerAdapter)var1;
               if(var3.getDropDownViewTheme() == null) {
                  var3.setDropDownViewTheme(var2);
                  return;
               }
            }
         }

      }

      public boolean areAllItemsEnabled() {
         ListAdapter var1 = this.mListAdapter;
         return var1 != null?var1.areAllItemsEnabled():true;
      }

      public int getCount() {
         return this.mAdapter == null?0:this.mAdapter.getCount();
      }

      public View getDropDownView(int var1, View var2, ViewGroup var3) {
         return this.mAdapter == null?null:this.mAdapter.getDropDownView(var1, var2, var3);
      }

      public Object getItem(int var1) {
         return this.mAdapter == null?null:this.mAdapter.getItem(var1);
      }

      public long getItemId(int var1) {
         return this.mAdapter == null?-1L:this.mAdapter.getItemId(var1);
      }

      public int getItemViewType(int var1) {
         return 0;
      }

      public View getView(int var1, View var2, ViewGroup var3) {
         return this.getDropDownView(var1, var2, var3);
      }

      public int getViewTypeCount() {
         return 1;
      }

      public boolean hasStableIds() {
         return this.mAdapter != null && this.mAdapter.hasStableIds();
      }

      public boolean isEmpty() {
         return this.getCount() == 0;
      }

      public boolean isEnabled(int var1) {
         ListAdapter var2 = this.mListAdapter;
         return var2 != null?var2.isEnabled(var1):true;
      }

      public void registerDataSetObserver(DataSetObserver var1) {
         if(this.mAdapter != null) {
            this.mAdapter.registerDataSetObserver(var1);
         }

      }

      public void unregisterDataSetObserver(DataSetObserver var1) {
         if(this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(var1);
         }

      }
   }

   private class DropdownPopup extends ListPopupWindow {
      private ListAdapter mAdapter;
      private CharSequence mHintText;
      private final Rect mVisibleRect = new Rect();

      public DropdownPopup(Context var2, AttributeSet var3, int var4) {
         super(var2, var3, var4);
         this.setAnchorView(AppCompatSpinner.this);
         this.setModal(true);
         this.setPromptPosition(0);
         this.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
               AppCompatSpinner.this.setSelection(var3);
               if(AppCompatSpinner.this.getOnItemClickListener() != null) {
                  AppCompatSpinner.this.performItemClick(var2, var3, DropdownPopup.this.mAdapter.getItemId(var3));
               }

               DropdownPopup.this.dismiss();
            }
         });
      }

      private boolean isVisibleToUser(View var1) {
         return ViewCompat.isAttachedToWindow(var1) && var1.getGlobalVisibleRect(this.mVisibleRect);
      }

      void computeContentWidth() {
         Drawable var1 = this.getBackground();
         int var3;
         if(var1 != null) {
            var1.getPadding(AppCompatSpinner.this.mTempRect);
            if(ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
               var3 = AppCompatSpinner.this.mTempRect.right;
            } else {
               var3 = -AppCompatSpinner.this.mTempRect.left;
            }
         } else {
            Rect var2 = AppCompatSpinner.this.mTempRect;
            AppCompatSpinner.this.mTempRect.right = 0;
            var2.left = 0;
            var3 = 0;
         }

         int var4 = AppCompatSpinner.this.getPaddingLeft();
         int var5 = AppCompatSpinner.this.getPaddingRight();
         int var6 = AppCompatSpinner.this.getWidth();
         if(AppCompatSpinner.this.mDropDownWidth == -2) {
            int var8 = AppCompatSpinner.this.compatMeasureContentWidth((SpinnerAdapter)this.mAdapter, this.getBackground());
            int var9 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.mTempRect.left - AppCompatSpinner.this.mTempRect.right;
            if(var8 > var9) {
               var8 = var9;
            }

            this.setContentWidth(Math.max(var8, var6 - var4 - var5));
         } else if(AppCompatSpinner.this.mDropDownWidth == -1) {
            this.setContentWidth(var6 - var4 - var5);
         } else {
            this.setContentWidth(AppCompatSpinner.this.mDropDownWidth);
         }

         int var7;
         if(ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
            var7 = var3 + (var6 - var5 - this.getWidth());
         } else {
            var7 = var3 + var4;
         }

         this.setHorizontalOffset(var7);
      }

      public CharSequence getHintText() {
         return this.mHintText;
      }

      public void setAdapter(ListAdapter var1) {
         super.setAdapter(var1);
         this.mAdapter = var1;
      }

      public void setPromptText(CharSequence var1) {
         this.mHintText = var1;
      }

      public void show() {
         boolean var1 = this.isShowing();
         this.computeContentWidth();
         this.setInputMethodMode(2);
         super.show();
         this.getListView().setChoiceMode(1);
         this.setSelection(AppCompatSpinner.this.getSelectedItemPosition());
         if(!var1) {
            ViewTreeObserver var2 = AppCompatSpinner.this.getViewTreeObserver();
            if(var2 != null) {
               final OnGlobalLayoutListener var3 = new OnGlobalLayoutListener() {
                  public void onGlobalLayout() {
                     if(!DropdownPopup.this.isVisibleToUser(AppCompatSpinner.this)) {
                        DropdownPopup.this.dismiss();
                     } else {
                        DropdownPopup.this.computeContentWidth();
                        AppCompatSpinner.DropdownPopup.super.show();
                     }
                  }
               };
               var2.addOnGlobalLayoutListener(var3);
               this.setOnDismissListener(new OnDismissListener() {
                  public void onDismiss() {
                     ViewTreeObserver var1 = AppCompatSpinner.this.getViewTreeObserver();
                     if(var1 != null) {
                        var1.removeGlobalOnLayoutListener(var3);
                     }

                  }
               });
               return;
            }
         }

      }
   }
}
