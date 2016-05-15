package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class BitmapMemoryCacheKey implements CacheKey {
   private final boolean mAutoRotated;
   private final int mHash;
   private final ImageDecodeOptions mImageDecodeOptions;
   @Nullable
   private final CacheKey mPostprocessorCacheKey;
   @Nullable
   private final String mPostprocessorName;
   @Nullable
   private final ResizeOptions mResizeOptions;
   private final String mSourceString;

   public BitmapMemoryCacheKey(String var1, @Nullable ResizeOptions var2, boolean var3, ImageDecodeOptions var4, @Nullable CacheKey var5, @Nullable String var6) {
      this.mSourceString = (String)Preconditions.checkNotNull(var1);
      this.mResizeOptions = var2;
      this.mAutoRotated = var3;
      this.mImageDecodeOptions = var4;
      this.mPostprocessorCacheKey = var5;
      this.mPostprocessorName = var6;
      Integer var7 = Integer.valueOf(var1.hashCode());
      int var8;
      if(var2 != null) {
         var8 = var2.hashCode();
      } else {
         var8 = 0;
      }

      Integer var9 = Integer.valueOf(var8);
      int var10;
      if(var3) {
         var10 = Boolean.TRUE.hashCode();
      } else {
         var10 = Boolean.FALSE.hashCode();
      }

      this.mHash = HashCodeUtil.hashCode(var7, var9, Integer.valueOf(var10), this.mImageDecodeOptions, this.mPostprocessorCacheKey, var6);
   }

   public boolean equals(Object var1) {
      if(var1 instanceof BitmapMemoryCacheKey) {
         BitmapMemoryCacheKey var2 = (BitmapMemoryCacheKey)var1;
         if(this.mHash == var2.mHash && this.mSourceString.equals(var2.mSourceString) && Objects.equal(this.mResizeOptions, var2.mResizeOptions) && this.mAutoRotated == var2.mAutoRotated && Objects.equal(this.mImageDecodeOptions, var2.mImageDecodeOptions) && Objects.equal(this.mPostprocessorCacheKey, var2.mPostprocessorCacheKey) && Objects.equal(this.mPostprocessorName, var2.mPostprocessorName)) {
            return true;
         }
      }

      return false;
   }

   @Nullable
   public String getPostprocessorName() {
      return this.mPostprocessorName;
   }

   public String getSourceUriString() {
      return this.mSourceString;
   }

   public int hashCode() {
      return this.mHash;
   }

   public String toString() {
      Locale var1 = (Locale)null;
      Object[] var2 = new Object[]{this.mSourceString, this.mResizeOptions, Boolean.toString(this.mAutoRotated), this.mImageDecodeOptions, this.mPostprocessorCacheKey, this.mPostprocessorName, Integer.valueOf(this.mHash)};
      return String.format(var1, "%s_%s_%s_%s_%s_%s_%d", var2);
   }
}
