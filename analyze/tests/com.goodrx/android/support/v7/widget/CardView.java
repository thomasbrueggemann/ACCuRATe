package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.cardview.class_91;
import android.support.v7.widget.CardViewApi21;
import android.support.v7.widget.CardViewDelegate;
import android.support.v7.widget.CardViewEclairMr1;
import android.support.v7.widget.CardViewImpl;
import android.support.v7.widget.CardViewJellybeanMr1;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout implements CardViewDelegate {
   private static final CardViewImpl IMPL;
   private boolean mCompatPadding;
   private final Rect mContentPadding = new Rect();
   private boolean mPreventCornerOverlap;
   private final Rect mShadowBounds = new Rect();
   private int mUserSetMinHeight;
   private int mUserSetMinWidth;

   static {
      if(VERSION.SDK_INT >= 21) {
         IMPL = new CardViewApi21();
      } else if(VERSION.SDK_INT >= 17) {
         IMPL = new CardViewJellybeanMr1();
      } else {
         IMPL = new CardViewEclairMr1();
      }

      IMPL.initStatic();
   }

   public CardView(Context var1) {
      super(var1);
      this.initialize(var1, (AttributeSet)null, 0);
   }

   public CardView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.initialize(var1, var2, 0);
   }

   public CardView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.initialize(var1, var2, var3);
   }

   private void initialize(Context var1, AttributeSet var2, int var3) {
      TypedArray var4 = var1.obtainStyledAttributes(var2, class_91.styleable.CardView, var3, class_91.style.CardView_Light);
      int var5 = var4.getColor(class_91.styleable.CardView_cardBackgroundColor, 0);
      float var6 = var4.getDimension(class_91.styleable.CardView_cardCornerRadius, 0.0F);
      float var7 = var4.getDimension(class_91.styleable.CardView_cardElevation, 0.0F);
      float var8 = var4.getDimension(class_91.styleable.CardView_cardMaxElevation, 0.0F);
      this.mCompatPadding = var4.getBoolean(class_91.styleable.CardView_cardUseCompatPadding, false);
      this.mPreventCornerOverlap = var4.getBoolean(class_91.styleable.CardView_cardPreventCornerOverlap, true);
      int var9 = var4.getDimensionPixelSize(class_91.styleable.CardView_contentPadding, 0);
      this.mContentPadding.left = var4.getDimensionPixelSize(class_91.styleable.CardView_contentPaddingLeft, var9);
      this.mContentPadding.top = var4.getDimensionPixelSize(class_91.styleable.CardView_contentPaddingTop, var9);
      this.mContentPadding.right = var4.getDimensionPixelSize(class_91.styleable.CardView_contentPaddingRight, var9);
      this.mContentPadding.bottom = var4.getDimensionPixelSize(class_91.styleable.CardView_contentPaddingBottom, var9);
      if(var7 > var8) {
         var8 = var7;
      }

      this.mUserSetMinWidth = var4.getDimensionPixelSize(class_91.styleable.CardView_android_minWidth, 0);
      this.mUserSetMinHeight = var4.getDimensionPixelSize(class_91.styleable.CardView_android_minHeight, 0);
      var4.recycle();
      IMPL.initialize(this, var1, var5, var6, var7, var8);
   }

   public float getCardElevation() {
      return IMPL.getElevation(this);
   }

   public int getContentPaddingBottom() {
      return this.mContentPadding.bottom;
   }

   public int getContentPaddingLeft() {
      return this.mContentPadding.left;
   }

   public int getContentPaddingRight() {
      return this.mContentPadding.right;
   }

   public int getContentPaddingTop() {
      return this.mContentPadding.top;
   }

   public float getMaxCardElevation() {
      return IMPL.getMaxElevation(this);
   }

   public boolean getPreventCornerOverlap() {
      return this.mPreventCornerOverlap;
   }

   public float getRadius() {
      return IMPL.getRadius(this);
   }

   public boolean getUseCompatPadding() {
      return this.mCompatPadding;
   }

   protected void onMeasure(int var1, int var2) {
      if(!(IMPL instanceof CardViewApi21)) {
         int var3 = MeasureSpec.getMode(var1);
         switch(var3) {
         case Integer.MIN_VALUE:
         case 1073741824:
            var1 = MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil((double)IMPL.getMinWidth(this)), MeasureSpec.getSize(var1)), var3);
         default:
            int var4 = MeasureSpec.getMode(var2);
            switch(var4) {
            case Integer.MIN_VALUE:
            case 1073741824:
               var2 = MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil((double)IMPL.getMinHeight(this)), MeasureSpec.getSize(var2)), var4);
            default:
               super.onMeasure(var1, var2);
            }
         }
      } else {
         super.onMeasure(var1, var2);
      }
   }

   public void setCardBackgroundColor(int var1) {
      IMPL.setBackgroundColor(this, var1);
   }

   public void setCardElevation(float var1) {
      IMPL.setElevation(this, var1);
   }

   public void setContentPadding(int var1, int var2, int var3, int var4) {
      this.mContentPadding.set(var1, var2, var3, var4);
      IMPL.updatePadding(this);
   }

   public void setMaxCardElevation(float var1) {
      IMPL.setMaxElevation(this, var1);
   }

   public void setMinWidthHeightInternal(int var1, int var2) {
      if(var1 > this.mUserSetMinWidth) {
         super.setMinimumWidth(var1);
      }

      if(var2 > this.mUserSetMinHeight) {
         super.setMinimumHeight(var2);
      }

   }

   public void setMinimumHeight(int var1) {
      this.mUserSetMinHeight = var1;
      super.setMinimumHeight(var1);
   }

   public void setMinimumWidth(int var1) {
      this.mUserSetMinWidth = var1;
      super.setMinimumWidth(var1);
   }

   public void setPadding(int var1, int var2, int var3, int var4) {
   }

   public void setPaddingRelative(int var1, int var2, int var3, int var4) {
   }

   public void setPreventCornerOverlap(boolean var1) {
      if(var1 != this.mPreventCornerOverlap) {
         this.mPreventCornerOverlap = var1;
         IMPL.onPreventCornerOverlapChanged(this);
      }
   }

   public void setRadius(float var1) {
      IMPL.setRadius(this, var1);
   }

   public void setShadowPadding(int var1, int var2, int var3, int var4) {
      this.mShadowBounds.set(var1, var2, var3, var4);
      super.setPadding(var1 + this.mContentPadding.left, var2 + this.mContentPadding.top, var3 + this.mContentPadding.right, var4 + this.mContentPadding.bottom);
   }

   public void setUseCompatPadding(boolean var1) {
      if(this.mCompatPadding != var1) {
         this.mCompatPadding = var1;
         IMPL.onCompatPaddingChanged(this);
      }
   }
}
