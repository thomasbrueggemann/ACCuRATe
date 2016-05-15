package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

public final class DisplayImageOptions {
   private final boolean cacheInMemory;
   private final boolean cacheOnDisk;
   private final boolean considerExifParams;
   private final Options decodingOptions;
   private final int delayBeforeLoading;
   private final BitmapDisplayer displayer;
   private final Object extraForDownloader;
   private final Handler handler;
   private final Drawable imageForEmptyUri;
   private final Drawable imageOnFail;
   private final Drawable imageOnLoading;
   private final int imageResForEmptyUri;
   private final int imageResOnFail;
   private final int imageResOnLoading;
   private final ImageScaleType imageScaleType;
   private final boolean isSyncLoading;
   private final BitmapProcessor postProcessor;
   private final BitmapProcessor preProcessor;
   private final boolean resetViewBeforeLoading;

   private DisplayImageOptions(DisplayImageOptions.Builder var1) {
      this.imageResOnLoading = var1.imageResOnLoading;
      this.imageResForEmptyUri = var1.imageResForEmptyUri;
      this.imageResOnFail = var1.imageResOnFail;
      this.imageOnLoading = var1.imageOnLoading;
      this.imageForEmptyUri = var1.imageForEmptyUri;
      this.imageOnFail = var1.imageOnFail;
      this.resetViewBeforeLoading = var1.resetViewBeforeLoading;
      this.cacheInMemory = var1.cacheInMemory;
      this.cacheOnDisk = var1.cacheOnDisk;
      this.imageScaleType = var1.imageScaleType;
      this.decodingOptions = var1.decodingOptions;
      this.delayBeforeLoading = var1.delayBeforeLoading;
      this.considerExifParams = var1.considerExifParams;
      this.extraForDownloader = var1.extraForDownloader;
      this.preProcessor = var1.preProcessor;
      this.postProcessor = var1.postProcessor;
      this.displayer = var1.displayer;
      this.handler = var1.handler;
      this.isSyncLoading = var1.isSyncLoading;
   }

   // $FF: synthetic method
   DisplayImageOptions(DisplayImageOptions.Builder var1, Object var2) {
      this(var1);
   }

   public static DisplayImageOptions createSimple() {
      return (new DisplayImageOptions.Builder()).build();
   }

   public Options getDecodingOptions() {
      return this.decodingOptions;
   }

   public int getDelayBeforeLoading() {
      return this.delayBeforeLoading;
   }

   public BitmapDisplayer getDisplayer() {
      return this.displayer;
   }

   public Object getExtraForDownloader() {
      return this.extraForDownloader;
   }

   public Handler getHandler() {
      return this.handler;
   }

   public Drawable getImageForEmptyUri(Resources var1) {
      return this.imageResForEmptyUri != 0?var1.getDrawable(this.imageResForEmptyUri):this.imageForEmptyUri;
   }

   public Drawable getImageOnFail(Resources var1) {
      return this.imageResOnFail != 0?var1.getDrawable(this.imageResOnFail):this.imageOnFail;
   }

   public Drawable getImageOnLoading(Resources var1) {
      return this.imageResOnLoading != 0?var1.getDrawable(this.imageResOnLoading):this.imageOnLoading;
   }

   public ImageScaleType getImageScaleType() {
      return this.imageScaleType;
   }

   public BitmapProcessor getPostProcessor() {
      return this.postProcessor;
   }

   public BitmapProcessor getPreProcessor() {
      return this.preProcessor;
   }

   public boolean isCacheInMemory() {
      return this.cacheInMemory;
   }

   public boolean isCacheOnDisk() {
      return this.cacheOnDisk;
   }

   public boolean isConsiderExifParams() {
      return this.considerExifParams;
   }

   public boolean isResetViewBeforeLoading() {
      return this.resetViewBeforeLoading;
   }

   boolean isSyncLoading() {
      return this.isSyncLoading;
   }

   public boolean shouldDelayBeforeLoading() {
      return this.delayBeforeLoading > 0;
   }

   public boolean shouldPostProcess() {
      return this.postProcessor != null;
   }

   public boolean shouldPreProcess() {
      return this.preProcessor != null;
   }

   public boolean shouldShowImageForEmptyUri() {
      return this.imageForEmptyUri != null || this.imageResForEmptyUri != 0;
   }

   public boolean shouldShowImageOnFail() {
      return this.imageOnFail != null || this.imageResOnFail != 0;
   }

   public boolean shouldShowImageOnLoading() {
      return this.imageOnLoading != null || this.imageResOnLoading != 0;
   }

   public static class Builder {
      private boolean cacheInMemory = false;
      private boolean cacheOnDisk = false;
      private boolean considerExifParams;
      private Options decodingOptions;
      private int delayBeforeLoading;
      private BitmapDisplayer displayer;
      private Object extraForDownloader;
      private Handler handler;
      private Drawable imageForEmptyUri = null;
      private Drawable imageOnFail = null;
      private Drawable imageOnLoading = null;
      private int imageResForEmptyUri = 0;
      private int imageResOnFail = 0;
      private int imageResOnLoading = 0;
      private ImageScaleType imageScaleType;
      private boolean isSyncLoading;
      private BitmapProcessor postProcessor;
      private BitmapProcessor preProcessor;
      private boolean resetViewBeforeLoading = false;

      public Builder() {
         this.imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
         this.decodingOptions = new Options();
         this.delayBeforeLoading = 0;
         this.considerExifParams = false;
         this.extraForDownloader = null;
         this.preProcessor = null;
         this.postProcessor = null;
         this.displayer = DefaultConfigurationFactory.createBitmapDisplayer();
         this.handler = null;
         this.isSyncLoading = false;
      }

      public DisplayImageOptions build() {
         return new DisplayImageOptions(this);
      }

      public DisplayImageOptions.Builder cacheInMemory(boolean var1) {
         this.cacheInMemory = var1;
         return this;
      }

      public DisplayImageOptions.Builder cacheOnDisk(boolean var1) {
         this.cacheOnDisk = var1;
         return this;
      }

      public DisplayImageOptions.Builder cloneFrom(DisplayImageOptions var1) {
         this.imageResOnLoading = var1.imageResOnLoading;
         this.imageResForEmptyUri = var1.imageResForEmptyUri;
         this.imageResOnFail = var1.imageResOnFail;
         this.imageOnLoading = var1.imageOnLoading;
         this.imageForEmptyUri = var1.imageForEmptyUri;
         this.imageOnFail = var1.imageOnFail;
         this.resetViewBeforeLoading = var1.resetViewBeforeLoading;
         this.cacheInMemory = var1.cacheInMemory;
         this.cacheOnDisk = var1.cacheOnDisk;
         this.imageScaleType = var1.imageScaleType;
         this.decodingOptions = var1.decodingOptions;
         this.delayBeforeLoading = var1.delayBeforeLoading;
         this.considerExifParams = var1.considerExifParams;
         this.extraForDownloader = var1.extraForDownloader;
         this.preProcessor = var1.preProcessor;
         this.postProcessor = var1.postProcessor;
         this.displayer = var1.displayer;
         this.handler = var1.handler;
         this.isSyncLoading = var1.isSyncLoading;
         return this;
      }

      public DisplayImageOptions.Builder imageScaleType(ImageScaleType var1) {
         this.imageScaleType = var1;
         return this;
      }

      public DisplayImageOptions.Builder showImageForEmptyUri(int var1) {
         this.imageResForEmptyUri = var1;
         return this;
      }

      public DisplayImageOptions.Builder showImageOnFail(int var1) {
         this.imageResOnFail = var1;
         return this;
      }

      public DisplayImageOptions.Builder showImageOnLoading(int var1) {
         this.imageResOnLoading = var1;
         return this;
      }

      DisplayImageOptions.Builder syncLoading(boolean var1) {
         this.isSyncLoading = var1;
         return this;
      }
   }
}
