package com.nostra13.universalimageloader.cache.disc.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class BaseDiskCache implements DiskCache {
   public static final CompressFormat DEFAULT_COMPRESS_FORMAT;
   protected int bufferSize = '耀';
   protected final File cacheDir;
   protected CompressFormat compressFormat;
   protected int compressQuality;
   protected final FileNameGenerator fileNameGenerator;
   protected final File reserveCacheDir;

   static {
      DEFAULT_COMPRESS_FORMAT = CompressFormat.PNG;
   }

   public BaseDiskCache(File var1, File var2, FileNameGenerator var3) {
      this.compressFormat = DEFAULT_COMPRESS_FORMAT;
      this.compressQuality = 100;
      if(var1 == null) {
         throw new IllegalArgumentException("cacheDir argument must be not null");
      } else if(var3 == null) {
         throw new IllegalArgumentException("fileNameGenerator argument must be not null");
      } else {
         this.cacheDir = var1;
         this.reserveCacheDir = var2;
         this.fileNameGenerator = var3;
      }
   }

   public void clear() {
      File[] var1 = this.cacheDir.listFiles();
      if(var1 != null) {
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            var1[var3].delete();
         }
      }

   }

   public File get(String var1) {
      return this.getFile(var1);
   }

   protected File getFile(String var1) {
      String var2 = this.fileNameGenerator.generate(var1);
      File var3 = this.cacheDir;
      if(!this.cacheDir.exists() && !this.cacheDir.mkdirs() && this.reserveCacheDir != null && (this.reserveCacheDir.exists() || this.reserveCacheDir.mkdirs())) {
         var3 = this.reserveCacheDir;
      }

      return new File(var3, var2);
   }

   public boolean save(String var1, Bitmap var2) throws IOException {
      File var3 = this.getFile(var1);
      File var4 = new File(var3.getAbsolutePath() + ".tmp");
      BufferedOutputStream var5 = new BufferedOutputStream(new FileOutputStream(var4), this.bufferSize);
      boolean var11 = false;

      boolean var8;
      try {
         var11 = true;
         var8 = var2.compress(this.compressFormat, this.compressQuality, var5);
         var11 = false;
      } finally {
         if(var11) {
            IoUtils.closeSilently(var5);
            if(false && !var4.renameTo(var3)) {
               ;
            }

            if(true) {
               var4.delete();
            }

         }
      }

      boolean var9 = var8;
      IoUtils.closeSilently(var5);
      if(var8 && !var4.renameTo(var3)) {
         var9 = false;
      }

      if(!var9) {
         var4.delete();
      }

      var2.recycle();
      return var9;
   }

   public boolean save(String param1, InputStream param2, IoUtils.CopyListener param3) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
