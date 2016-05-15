package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

public class BitmapCounter {
   @GuardedBy("this")
   private int mCount;
   private final int mMaxCount;
   private final int mMaxSize;
   @GuardedBy("this")
   private long mSize;
   private final ResourceReleaser<Bitmap> mUnpooledBitmapsReleaser;

   public BitmapCounter(int var1, int var2) {
      boolean var3 = true;
      super();
      boolean var4;
      if(var1 > 0) {
         var4 = var3;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4);
      if(var2 <= 0) {
         var3 = false;
      }

      Preconditions.checkArgument(var3);
      this.mMaxCount = var1;
      this.mMaxSize = var2;
      this.mUnpooledBitmapsReleaser = new ResourceReleaser() {
         public void release(Bitmap var1) {
            try {
               BitmapCounter.this.decrease(var1);
            } finally {
               var1.recycle();
            }

         }
      };
   }

   public List<CloseableReference<Bitmap>> associateBitmapsWithBitmapCounter(List<Bitmap> param1) {
      // $FF: Couldn't be decompiled
   }

   public void decrease(Bitmap param1) {
      // $FF: Couldn't be decompiled
   }

   public int getCount() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.mCount;
      } finally {
         ;
      }

      return var2;
   }

   public ResourceReleaser<Bitmap> getReleaser() {
      return this.mUnpooledBitmapsReleaser;
   }

   public long getSize() {
      synchronized(this){}

      long var2;
      try {
         var2 = this.mSize;
      } finally {
         ;
      }

      return var2;
   }

   public boolean increase(Bitmap param1) {
      // $FF: Couldn't be decompiled
   }
}
