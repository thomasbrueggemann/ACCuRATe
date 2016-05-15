package com.nostra13.universalimageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.class_52;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LruDiskCache implements DiskCache {
   public static final CompressFormat DEFAULT_COMPRESS_FORMAT;
   protected int bufferSize = '耀';
   protected DiskLruCache cache;
   protected CompressFormat compressFormat;
   protected int compressQuality;
   protected final FileNameGenerator fileNameGenerator;
   private File reserveCacheDir;

   static {
      DEFAULT_COMPRESS_FORMAT = CompressFormat.PNG;
   }

   public LruDiskCache(File var1, File var2, FileNameGenerator var3, long var4, int var6) throws IOException {
      this.compressFormat = DEFAULT_COMPRESS_FORMAT;
      this.compressQuality = 100;
      if(var1 == null) {
         throw new IllegalArgumentException("cacheDir argument must be not null");
      } else if(var4 < 0L) {
         throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
      } else if(var6 < 0) {
         throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
      } else if(var3 == null) {
         throw new IllegalArgumentException("fileNameGenerator argument must be not null");
      } else {
         if(var4 == 0L) {
            var4 = Long.MAX_VALUE;
         }

         if(var6 == 0) {
            var6 = Integer.MAX_VALUE;
         }

         this.reserveCacheDir = var2;
         this.fileNameGenerator = var3;
         this.initCache(var1, var2, var4, var6);
      }
   }

   private String getKey(String var1) {
      return this.fileNameGenerator.generate(var1);
   }

   private void initCache(File var1, File var2, long var3, int var5) throws IOException {
      try {
         this.cache = DiskLruCache.open(var1, 1, 1, var3, var5);
      } catch (IOException var7) {
         class_52.method_331(var7);
         if(var2 != null) {
            this.initCache(var2, (File)null, var3, var5);
         }

         if(this.cache == null) {
            throw var7;
         }
      }

   }

   public void clear() {
      try {
         this.cache.delete();
      } catch (IOException var4) {
         class_52.method_331(var4);
      }

      try {
         this.initCache(this.cache.getDirectory(), this.reserveCacheDir, this.cache.getMaxSize(), this.cache.getMaxFileCount());
      } catch (IOException var3) {
         class_52.method_331(var3);
      }
   }

   public File get(String param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean save(String var1, Bitmap var2) throws IOException {
      DiskLruCache.Editor var3 = this.cache.edit(this.getKey(var1));
      if(var3 == null) {
         return false;
      } else {
         BufferedOutputStream var4 = new BufferedOutputStream(var3.newOutputStream(0), this.bufferSize);

         boolean var6;
         try {
            var6 = var2.compress(this.compressFormat, this.compressQuality, var4);
         } finally {
            IoUtils.closeSilently(var4);
         }

         if(var6) {
            var3.commit();
            return var6;
         } else {
            var3.abort();
            return var6;
         }
      }
   }

   public boolean save(String var1, InputStream var2, IoUtils.CopyListener var3) throws IOException {
      DiskLruCache.Editor var4 = this.cache.edit(this.getKey(var1));
      if(var4 == null) {
         return false;
      } else {
         BufferedOutputStream var5 = new BufferedOutputStream(var4.newOutputStream(0), this.bufferSize);
         boolean var9 = false;

         boolean var7;
         try {
            var9 = true;
            var7 = IoUtils.copyStream(var2, var5, var3, this.bufferSize);
            var9 = false;
         } finally {
            if(var9) {
               IoUtils.closeSilently(var5);
               if(false) {
                  var4.commit();
               } else {
                  var4.abort();
               }

            }
         }

         IoUtils.closeSilently(var5);
         if(var7) {
            var4.commit();
            return var7;
         } else {
            var4.abort();
            return var7;
         }
      }
   }
}
