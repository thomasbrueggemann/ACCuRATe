package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStripIcs;
import android.support.v4.view.ViewPager;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class PagerTitleStrip extends ViewGroup implements ViewPager.Decor {
   private static final int[] ATTRS = new int[]{16842804, 16842901, 16842904, 16842927};
   private static final PagerTitleStrip.PagerTitleStripImpl IMPL;
   private static final float SIDE_ALPHA = 0.6F;
   private static final String TAG = "PagerTitleStrip";
   private static final int[] TEXT_ATTRS = new int[]{16843660};
   private static final int TEXT_SPACING = 16;
   TextView mCurrText;
   private int mGravity;
   private int mLastKnownCurrentPage;
   private float mLastKnownPositionOffset;
   TextView mNextText;
   private int mNonPrimaryAlpha;
   private final PagerTitleStrip.PageListener mPageListener;
   ViewPager mPager;
   TextView mPrevText;
   private int mScaledTextSpacing;
   int mTextColor;
   private boolean mUpdatingPositions;
   private boolean mUpdatingText;
   private WeakReference<PagerAdapter> mWatchingAdapter;

   static {
      if(VERSION.SDK_INT >= 14) {
         IMPL = new PagerTitleStrip.PagerTitleStripImplIcs();
      } else {
         IMPL = new PagerTitleStrip.PagerTitleStripImplBase();
      }
   }

   public PagerTitleStrip(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public PagerTitleStrip(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.mLastKnownCurrentPage = -1;
      this.mLastKnownPositionOffset = -1.0F;
      this.mPageListener = new PagerTitleStrip.PageListener();
      TextView var3 = new TextView(var1);
      this.mPrevText = var3;
      this.addView(var3);
      TextView var4 = new TextView(var1);
      this.mCurrText = var4;
      this.addView(var4);
      TextView var5 = new TextView(var1);
      this.mNextText = var5;
      this.addView(var5);
      TypedArray var6 = var1.obtainStyledAttributes(var2, ATTRS);
      int var7 = var6.getResourceId(0, 0);
      if(var7 != 0) {
         this.mPrevText.setTextAppearance(var1, var7);
         this.mCurrText.setTextAppearance(var1, var7);
         this.mNextText.setTextAppearance(var1, var7);
      }

      int var8 = var6.getDimensionPixelSize(1, 0);
      if(var8 != 0) {
         this.setTextSize(0, (float)var8);
      }

      if(var6.hasValue(2)) {
         int var11 = var6.getColor(2, 0);
         this.mPrevText.setTextColor(var11);
         this.mCurrText.setTextColor(var11);
         this.mNextText.setTextColor(var11);
      }

      this.mGravity = var6.getInteger(3, 80);
      var6.recycle();
      this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
      this.setNonPrimaryAlpha(0.6F);
      this.mPrevText.setEllipsize(TruncateAt.END);
      this.mCurrText.setEllipsize(TruncateAt.END);
      this.mNextText.setEllipsize(TruncateAt.END);
      boolean var9 = false;
      if(var7 != 0) {
         TypedArray var10 = var1.obtainStyledAttributes(var7, TEXT_ATTRS);
         var9 = var10.getBoolean(0, false);
         var10.recycle();
      }

      if(var9) {
         setSingleLineAllCaps(this.mPrevText);
         setSingleLineAllCaps(this.mCurrText);
         setSingleLineAllCaps(this.mNextText);
      } else {
         this.mPrevText.setSingleLine();
         this.mCurrText.setSingleLine();
         this.mNextText.setSingleLine();
      }

      this.mScaledTextSpacing = (int)(16.0F * var1.getResources().getDisplayMetrics().density);
   }

   private static void setSingleLineAllCaps(TextView var0) {
      IMPL.setSingleLineAllCaps(var0);
   }

   int getMinHeight() {
      Drawable var1 = this.getBackground();
      int var2 = 0;
      if(var1 != null) {
         var2 = var1.getIntrinsicHeight();
      }

      return var2;
   }

   public int getTextSpacing() {
      return this.mScaledTextSpacing;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      ViewParent var1 = this.getParent();
      if(!(var1 instanceof ViewPager)) {
         throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
      } else {
         ViewPager var2 = (ViewPager)var1;
         PagerAdapter var3 = var2.getAdapter();
         var2.setInternalPageChangeListener(this.mPageListener);
         var2.setOnAdapterChangeListener(this.mPageListener);
         this.mPager = var2;
         PagerAdapter var5;
         if(this.mWatchingAdapter != null) {
            var5 = (PagerAdapter)this.mWatchingAdapter.get();
         } else {
            var5 = null;
         }

         this.updateAdapter(var5, var3);
      }
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if(this.mPager != null) {
         this.updateAdapter(this.mPager.getAdapter(), (PagerAdapter)null);
         this.mPager.setInternalPageChangeListener((ViewPager.OnPageChangeListener)null);
         this.mPager.setOnAdapterChangeListener((ViewPager.OnAdapterChangeListener)null);
         this.mPager = null;
      }

   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      if(this.mPager != null) {
         float var8;
         int var6 = (var8 = this.mLastKnownPositionOffset - 0.0F) == 0.0F?0:(var8 < 0.0F?-1:1);
         float var7 = 0.0F;
         if(var6 >= 0) {
            var7 = this.mLastKnownPositionOffset;
         }

         this.updateTextPositions(this.mLastKnownCurrentPage, var7, true);
      }

   }

   protected void onMeasure(int var1, int var2) {
      int var3 = MeasureSpec.getMode(var1);
      int var4 = MeasureSpec.getMode(var2);
      int var5 = MeasureSpec.getSize(var1);
      int var6 = MeasureSpec.getSize(var2);
      if(var3 != 1073741824) {
         throw new IllegalStateException("Must measure with an exact width");
      } else {
         int var7 = this.getMinHeight();
         int var8 = this.getPaddingTop() + this.getPaddingBottom();
         int var9 = var6 - var8;
         int var10 = MeasureSpec.makeMeasureSpec((int)(0.8F * (float)var5), Integer.MIN_VALUE);
         int var11 = MeasureSpec.makeMeasureSpec(var9, Integer.MIN_VALUE);
         this.mPrevText.measure(var10, var11);
         this.mCurrText.measure(var10, var11);
         this.mNextText.measure(var10, var11);
         if(var4 == 1073741824) {
            this.setMeasuredDimension(var5, var6);
         } else {
            this.setMeasuredDimension(var5, Math.max(var7, var8 + this.mCurrText.getMeasuredHeight()));
         }
      }
   }

   public void requestLayout() {
      if(!this.mUpdatingText) {
         super.requestLayout();
      }

   }

   public void setGravity(int var1) {
      this.mGravity = var1;
      this.requestLayout();
   }

   public void setNonPrimaryAlpha(float var1) {
      this.mNonPrimaryAlpha = 255 & (int)(255.0F * var1);
      int var2 = this.mNonPrimaryAlpha << 24 | 16777215 & this.mTextColor;
      this.mPrevText.setTextColor(var2);
      this.mNextText.setTextColor(var2);
   }

   public void setTextColor(int var1) {
      this.mTextColor = var1;
      this.mCurrText.setTextColor(var1);
      int var2 = this.mNonPrimaryAlpha << 24 | 16777215 & this.mTextColor;
      this.mPrevText.setTextColor(var2);
      this.mNextText.setTextColor(var2);
   }

   public void setTextSize(int var1, float var2) {
      this.mPrevText.setTextSize(var1, var2);
      this.mCurrText.setTextSize(var1, var2);
      this.mNextText.setTextSize(var1, var2);
   }

   public void setTextSpacing(int var1) {
      this.mScaledTextSpacing = var1;
      this.requestLayout();
   }

   void updateAdapter(PagerAdapter var1, PagerAdapter var2) {
      if(var1 != null) {
         var1.unregisterDataSetObserver(this.mPageListener);
         this.mWatchingAdapter = null;
      }

      if(var2 != null) {
         var2.registerDataSetObserver(this.mPageListener);
         this.mWatchingAdapter = new WeakReference(var2);
      }

      if(this.mPager != null) {
         this.mLastKnownCurrentPage = -1;
         this.mLastKnownPositionOffset = -1.0F;
         this.updateText(this.mPager.getCurrentItem(), var2);
         this.requestLayout();
      }

   }

   void updateText(int var1, PagerAdapter var2) {
      int var3;
      if(var2 != null) {
         var3 = var2.getCount();
      } else {
         var3 = 0;
      }

      this.mUpdatingText = true;
      CharSequence var4 = null;
      if(var1 >= 1) {
         var4 = null;
         if(var2 != null) {
            var4 = var2.getPageTitle(var1 - 1);
         }
      }

      this.mPrevText.setText(var4);
      TextView var5 = this.mCurrText;
      CharSequence var6;
      if(var2 != null && var1 < var3) {
         var6 = var2.getPageTitle(var1);
      } else {
         var6 = null;
      }

      var5.setText(var6);
      int var7 = var1 + 1;
      CharSequence var8 = null;
      if(var7 < var3) {
         var8 = null;
         if(var2 != null) {
            var8 = var2.getPageTitle(var1 + 1);
         }
      }

      this.mNextText.setText(var8);
      int var9 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
      int var10 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
      int var11 = MeasureSpec.makeMeasureSpec((int)(0.8F * (float)var9), Integer.MIN_VALUE);
      int var12 = MeasureSpec.makeMeasureSpec(var10, Integer.MIN_VALUE);
      this.mPrevText.measure(var11, var12);
      this.mCurrText.measure(var11, var12);
      this.mNextText.measure(var11, var12);
      this.mLastKnownCurrentPage = var1;
      if(!this.mUpdatingPositions) {
         this.updateTextPositions(var1, this.mLastKnownPositionOffset, false);
      }

      this.mUpdatingText = false;
   }

   void updateTextPositions(int var1, float var2, boolean var3) {
      if(var1 != this.mLastKnownCurrentPage) {
         this.updateText(var1, this.mPager.getAdapter());
      } else if(!var3 && var2 == this.mLastKnownPositionOffset) {
         return;
      }

      this.mUpdatingPositions = true;
      int var4 = this.mPrevText.getMeasuredWidth();
      int var5 = this.mCurrText.getMeasuredWidth();
      int var6 = this.mNextText.getMeasuredWidth();
      int var7 = var5 / 2;
      int var8 = this.getWidth();
      int var9 = this.getHeight();
      int var10 = this.getPaddingLeft();
      int var11 = this.getPaddingRight();
      int var12 = this.getPaddingTop();
      int var13 = this.getPaddingBottom();
      int var14 = var10 + var7;
      int var15 = var11 + var7;
      int var16 = var8 - var14 - var15;
      float var17 = var2 + 0.5F;
      if(var17 > 1.0F) {
         --var17;
      }

      int var18 = var8 - var15 - (int)(var17 * (float)var16) - var5 / 2;
      int var19 = var18 + var5;
      int var20 = this.mPrevText.getBaseline();
      int var21 = this.mCurrText.getBaseline();
      int var22 = this.mNextText.getBaseline();
      int var23 = Math.max(Math.max(var20, var21), var22);
      int var24 = var23 - var20;
      int var25 = var23 - var21;
      int var26 = var23 - var22;
      int var27 = var24 + this.mPrevText.getMeasuredHeight();
      int var28 = var25 + this.mCurrText.getMeasuredHeight();
      int var29 = var26 + this.mNextText.getMeasuredHeight();
      int var30 = Math.max(Math.max(var27, var28), var29);
      int var34;
      int var32;
      int var33;
      switch(112 & this.mGravity) {
      case 16:
         int var45 = (var9 - var12 - var13 - var30) / 2;
         var32 = var45 + var24;
         var33 = var45 + var25;
         var34 = var45 + var26;
         break;
      case 80:
         int var31 = var9 - var13 - var30;
         var32 = var31 + var24;
         var33 = var31 + var25;
         var34 = var31 + var26;
         break;
      default:
         var32 = var12 + var24;
         var33 = var12 + var25;
         var34 = var12 + var26;
      }

      TextView var35 = this.mCurrText;
      int var36 = var33 + this.mCurrText.getMeasuredHeight();
      var35.layout(var18, var33, var19, var36);
      int var37 = Math.min(var10, var18 - this.mScaledTextSpacing - var4);
      TextView var38 = this.mPrevText;
      int var39 = var37 + var4;
      int var40 = var32 + this.mPrevText.getMeasuredHeight();
      var38.layout(var37, var32, var39, var40);
      int var41 = Math.max(var8 - var11 - var6, var19 + this.mScaledTextSpacing);
      TextView var42 = this.mNextText;
      int var43 = var41 + var6;
      int var44 = var34 + this.mNextText.getMeasuredHeight();
      var42.layout(var41, var34, var43, var44);
      this.mLastKnownPositionOffset = var2;
      this.mUpdatingPositions = false;
   }

   private class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
      private int mScrollState;

      private PageListener() {
      }

      // $FF: synthetic method
      PageListener(Object var2) {
         this();
      }

      public void onAdapterChanged(PagerAdapter var1, PagerAdapter var2) {
         PagerTitleStrip.this.updateAdapter(var1, var2);
      }

      public void onChanged() {
         PagerTitleStrip.this.updateText(PagerTitleStrip.this.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
         float var3;
         int var1 = (var3 = PagerTitleStrip.this.mLastKnownPositionOffset - 0.0F) == 0.0F?0:(var3 < 0.0F?-1:1);
         float var2 = 0.0F;
         if(var1 >= 0) {
            var2 = PagerTitleStrip.this.mLastKnownPositionOffset;
         }

         PagerTitleStrip.this.updateTextPositions(PagerTitleStrip.this.mPager.getCurrentItem(), var2, true);
      }

      public void onPageScrollStateChanged(int var1) {
         this.mScrollState = var1;
      }

      public void onPageScrolled(int var1, float var2, int var3) {
         if(var2 > 0.5F) {
            ++var1;
         }

         PagerTitleStrip.this.updateTextPositions(var1, var2, false);
      }

      public void onPageSelected(int var1) {
         if(this.mScrollState == 0) {
            PagerTitleStrip.this.updateText(PagerTitleStrip.this.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
            float var4;
            int var2 = (var4 = PagerTitleStrip.this.mLastKnownPositionOffset - 0.0F) == 0.0F?0:(var4 < 0.0F?-1:1);
            float var3 = 0.0F;
            if(var2 >= 0) {
               var3 = PagerTitleStrip.this.mLastKnownPositionOffset;
            }

            PagerTitleStrip.this.updateTextPositions(PagerTitleStrip.this.mPager.getCurrentItem(), var3, true);
         }

      }
   }

   interface PagerTitleStripImpl {
      void setSingleLineAllCaps(TextView var1);
   }

   static class PagerTitleStripImplBase implements PagerTitleStrip.PagerTitleStripImpl {
      public void setSingleLineAllCaps(TextView var1) {
         var1.setSingleLine();
      }
   }

   static class PagerTitleStripImplIcs implements PagerTitleStrip.PagerTitleStripImpl {
      public void setSingleLineAllCaps(TextView var1) {
         PagerTitleStripIcs.setSingleLineAllCaps(var1);
      }
   }
}
