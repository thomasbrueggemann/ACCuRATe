package com.koushikdutta.ion;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.builder.Builders;
import java.lang.ref.WeakReference;

public class NetworkImageView extends ImageView {
   private int mDefaultImageId;
   private int mErrorImageId;
   private WeakReference<Future<ImageView>> mFuture;
   private Ion mIon;
   private String mUrl;

   public NetworkImageView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public NetworkImageView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public NetworkImageView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   private void loadImageIfNecessary(String var1) {
      int var2 = this.getWidth();
      int var3 = this.getHeight();
      String var4 = this.mUrl;
      this.mUrl = var1;
      if(var2 != 0 || var3 != 0) {
         Future var5;
         if(this.mFuture == null) {
            var5 = null;
         } else {
            var5 = (Future)this.mFuture.get();
         }

         if(TextUtils.isEmpty(this.mUrl)) {
            if(var5 != null) {
               var5.cancel();
               this.mFuture = null;
            }

            this.setImageBitmap((Bitmap)null);
         } else {
            if(var5 != null && var4 != null) {
               if(var4.equals(this.mUrl)) {
                  return;
               }

               var5.cancel();
               this.setImageBitmap((Bitmap)null);
            }

            this.mFuture = new WeakReference(((Builders.class_9)((Builders.class_9)this.mIon.build((ImageView)this).placeholder(this.mDefaultImageId)).error(this.mErrorImageId)).load(this.mUrl));
         }
      }
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      this.invalidate();
   }

   protected void onDetachedFromWindow() {
      Future var1;
      if(this.mFuture == null) {
         var1 = null;
      } else {
         var1 = (Future)this.mFuture.get();
      }

      if(var1 != null) {
         var1.cancel();
         this.setImageBitmap((Bitmap)null);
         this.mFuture = null;
      }

      super.onDetachedFromWindow();
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      this.loadImageIfNecessary(this.mUrl);
   }

   public void setDefaultImageResId(int var1) {
      this.mDefaultImageId = var1;
   }

   public void setErrorImageResId(int var1) {
      this.mErrorImageId = var1;
   }

   public void setImageUrl(String var1) {
      this.mIon = Ion.getDefault(this.getContext());
      this.loadImageIfNecessary(var1);
   }

   public void setImageUrl(String var1, Ion var2) {
      this.mIon = var2;
      this.loadImageIfNecessary(var1);
   }
}
