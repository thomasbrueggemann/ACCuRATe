package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imageutils.BitmapUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CloseableAnimatedBitmap extends CloseableBitmap {
   @GuardedBy("this")
   private List<CloseableReference<Bitmap>> mBitmapReferences;
   private volatile List<Bitmap> mBitmaps;
   private volatile List<Integer> mDurations;

   public CloseableAnimatedBitmap(List<CloseableReference<Bitmap>> var1, List<Integer> var2) {
      byte var3 = 1;
      super();
      Preconditions.checkNotNull(var1);
      byte var5;
      if(var1.size() >= var3) {
         var5 = var3;
      } else {
         var5 = 0;
      }

      Preconditions.checkState((boolean)var5, "Need at least 1 frame!");
      this.mBitmapReferences = new ArrayList();
      this.mBitmaps = new ArrayList();
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         CloseableReference var7 = (CloseableReference)var6.next();
         this.mBitmapReferences.add(var7.clone());
         this.mBitmaps.add(var7.get());
      }

      this.mDurations = (List)Preconditions.checkNotNull(var2);
      if(this.mDurations.size() != this.mBitmaps.size()) {
         var3 = 0;
      }

      Preconditions.checkState((boolean)var3, "Arrays length mismatch!");
   }

   public CloseableAnimatedBitmap(List<Bitmap> var1, List<Integer> var2, ResourceReleaser<Bitmap> var3) {
      byte var4 = 1;
      super();
      Preconditions.checkNotNull(var1);
      byte var6;
      if(var1.size() >= var4) {
         var6 = var4;
      } else {
         var6 = 0;
      }

      Preconditions.checkState((boolean)var6, "Need at least 1 frame!");
      this.mBitmaps = new ArrayList();
      this.mBitmapReferences = new ArrayList();
      Iterator var7 = var1.iterator();

      while(var7.hasNext()) {
         Bitmap var8 = (Bitmap)var7.next();
         this.mBitmapReferences.add(CloseableReference.method_307(var8, var3));
         this.mBitmaps.add(var8);
      }

      this.mDurations = (List)Preconditions.checkNotNull(var2);
      if(this.mDurations.size() != this.mBitmaps.size()) {
         var4 = 0;
      }

      Preconditions.checkState((boolean)var4, "Arrays length mismatch!");
   }

   public void close() {
      // $FF: Couldn't be decompiled
   }

   public List<Bitmap> getBitmaps() {
      return this.mBitmaps;
   }

   public List<Integer> getDurations() {
      return this.mDurations;
   }

   public int getHeight() {
      List var1 = this.mBitmaps;
      return var1 == null?0:((Bitmap)var1.get(0)).getHeight();
   }

   public int getSizeInBytes() {
      List var1 = this.mBitmaps;
      return var1 != null && var1.size() != 0?BitmapUtil.getSizeInBytes((Bitmap)var1.get(0)) * var1.size():0;
   }

   public Bitmap getUnderlyingBitmap() {
      List var1 = this.mBitmaps;
      return var1 != null?(Bitmap)var1.get(0):null;
   }

   public int getWidth() {
      List var1 = this.mBitmaps;
      return var1 == null?0:((Bitmap)var1.get(0)).getWidth();
   }

   public boolean isClosed() {
      synchronized(this){}
      boolean var5 = false;

      List var2;
      try {
         var5 = true;
         var2 = this.mBitmaps;
         var5 = false;
      } finally {
         if(var5) {
            ;
         }
      }

      boolean var3;
      if(var2 == null) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }
}
