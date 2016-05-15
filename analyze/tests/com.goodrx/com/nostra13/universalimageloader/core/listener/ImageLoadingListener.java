package com.nostra13.universalimageloader.core.listener;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.FailReason;

public interface ImageLoadingListener {
   void onLoadingCancelled(String var1, View var2);

   void onLoadingComplete(String var1, View var2, Bitmap var3);

   void onLoadingFailed(String var1, View var2, FailReason var3);

   void onLoadingStarted(String var1, View var2);
}
