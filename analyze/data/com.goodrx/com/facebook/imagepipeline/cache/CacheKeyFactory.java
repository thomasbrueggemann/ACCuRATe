package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;

public interface CacheKeyFactory {
   CacheKey getBitmapCacheKey(ImageRequest var1);

   Uri getCacheKeySourceUri(Uri var1);

   CacheKey getEncodedCacheKey(ImageRequest var1);

   CacheKey getPostprocessedBitmapCacheKey(ImageRequest var1);
}
