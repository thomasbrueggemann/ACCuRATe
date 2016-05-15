package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.AspectRatioMeasure;
import com.facebook.drawee.view.DraweeHolder;
import javax.annotation.Nullable;

public class DraweeView<DH extends DraweeHierarchy> extends ImageView {
   private float mAspectRatio = 0.0F;
   private DraweeHolder<DH> mDraweeHolder;
   private boolean mInitialised = false;
   private final AspectRatioMeasure.Spec mMeasureSpec = new AspectRatioMeasure.Spec();

   public DraweeView(Context var1) {
      super(var1);
      this.init(var1);
   }

   public DraweeView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
   }

   public DraweeView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1);
   }

   @TargetApi(21)
   public DraweeView(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3, var4);
      this.init(var1);
   }

   private void init(Context var1) {
      if(!this.mInitialised) {
         this.mInitialised = true;
         this.mDraweeHolder = DraweeHolder.create((DraweeHierarchy)null, var1);
         if(VERSION.SDK_INT >= 21) {
            ColorStateList var2 = this.getImageTintList();
            if(var2 != null) {
               this.setColorFilter(var2.getDefaultColor());
               return;
            }
         }
      }

   }

   public float getAspectRatio() {
      return this.mAspectRatio;
   }

   @Nullable
   public DraweeController getController() {
      return this.mDraweeHolder.getController();
   }

   public DH getHierarchy() {
      return this.mDraweeHolder.getHierarchy();
   }

   @Nullable
   public Drawable getTopLevelDrawable() {
      return this.mDraweeHolder.getTopLevelDrawable();
   }

   public boolean hasController() {
      return this.mDraweeHolder.getController() != null;
   }

   public boolean hasHierarchy() {
      return this.mDraweeHolder.hasHierarchy();
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.mDraweeHolder.onAttach();
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.mDraweeHolder.onDetach();
   }

   public void onFinishTemporaryDetach() {
      super.onFinishTemporaryDetach();
      this.mDraweeHolder.onAttach();
   }

   protected void onMeasure(int var1, int var2) {
      this.mMeasureSpec.width = var1;
      this.mMeasureSpec.height = var2;
      AspectRatioMeasure.updateMeasureSpec(this.mMeasureSpec, this.mAspectRatio, this.getLayoutParams(), this.getPaddingLeft() + this.getPaddingRight(), this.getPaddingTop() + this.getPaddingBottom());
      super.onMeasure(this.mMeasureSpec.width, this.mMeasureSpec.height);
   }

   public void onStartTemporaryDetach() {
      super.onStartTemporaryDetach();
      this.mDraweeHolder.onDetach();
   }

   public boolean onTouchEvent(MotionEvent var1) {
      return this.mDraweeHolder.onTouchEvent(var1)?true:super.onTouchEvent(var1);
   }

   public void setAspectRatio(float var1) {
      if(var1 != this.mAspectRatio) {
         this.mAspectRatio = var1;
         this.requestLayout();
      }
   }

   public void setController(@Nullable DraweeController var1) {
      this.mDraweeHolder.setController(var1);
      super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
   }

   public void setHierarchy(DH var1) {
      this.mDraweeHolder.setHierarchy(var1);
      super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
   }

   @Deprecated
   public void setImageBitmap(Bitmap var1) {
      this.init(this.getContext());
      this.mDraweeHolder.setController((DraweeController)null);
      super.setImageBitmap(var1);
   }

   @Deprecated
   public void setImageDrawable(Drawable var1) {
      this.init(this.getContext());
      this.mDraweeHolder.setController((DraweeController)null);
      super.setImageDrawable(var1);
   }

   @Deprecated
   public void setImageResource(int var1) {
      this.init(this.getContext());
      this.mDraweeHolder.setController((DraweeController)null);
      super.setImageResource(var1);
   }

   @Deprecated
   public void setImageURI(Uri var1) {
      this.init(this.getContext());
      this.mDraweeHolder.setController((DraweeController)null);
      super.setImageURI(var1);
   }

   public String toString() {
      Objects.ToStringHelper var1 = Objects.toStringHelper((Object)this);
      String var2;
      if(this.mDraweeHolder != null) {
         var2 = this.mDraweeHolder.toString();
      } else {
         var2 = "<no holder set>";
      }

      return var1.add("holder", var2).toString();
   }
}
