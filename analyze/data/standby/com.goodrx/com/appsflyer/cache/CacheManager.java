package com.appsflyer.cache;

import android.content.Context;
import android.util.Log;
import com.appsflyer.cache.RequestCacheData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class CacheManager {
   private static CacheManager ourInstance = new CacheManager();

   private File getCacheDir(Context var1) {
      return new File(var1.getFilesDir(), "AFRequestCache");
   }

   public static CacheManager getInstance() {
      return ourInstance;
   }

   private RequestCacheData loadRequestData(File var1) {
      try {
         FileReader var2 = new FileReader(var1);
         char[] var4 = new char[(int)var1.length()];
         var2.read(var4);
         RequestCacheData var6 = new RequestCacheData(var4);
         var6.setCacheKey(var1.getName());
         var2.close();
         return var6;
      } catch (Exception var7) {
         return null;
      }
   }

   public void cacheRequest(RequestCacheData var1, Context var2) {
      try {
         File var5 = this.getCacheDir(var2);
         if(!var5.exists()) {
            var5.mkdir();
         } else if(var5.listFiles().length > 40) {
            Log.i("AppsFlyer_3.2", "reached cache limit, not caching request");
         } else {
            Log.i("AppsFlyer_3.2", "caching request...");
            File var7 = new File(this.getCacheDir(var2), Long.toString(System.currentTimeMillis()));
            var7.createNewFile();
            OutputStreamWriter var9 = new OutputStreamWriter(new FileOutputStream(var7.getPath(), true));
            var9.write("version=");
            var9.write(var1.getVersion());
            var9.write(10);
            var9.write("url=");
            var9.write(var1.getRequestURL());
            var9.write(10);
            var9.write("data=");
            var9.write(var1.getPostData());
            var9.write(10);
            var9.flush();
            var9.close();
         }
      } catch (Exception var10) {
         Log.i("AppsFlyer_3.2", "Could not cache request");
      }
   }

   public void deleteRequest(String var1, Context var2) {
      File var3 = new File(this.getCacheDir(var2), var1);
      Log.i("AppsFlyer_3.2", "Deleting " + var1 + " from cache");
      if(var3.exists()) {
         try {
            var3.delete();
         } catch (Exception var6) {
            Log.i("AppsFlyer_3.2", "Could not delete " + var1 + " from cache", var6);
            return;
         }
      }

   }

   public List<RequestCacheData> getCachedRequests(Context param1) {
      // $FF: Couldn't be decompiled
   }

   public void init(Context var1) {
      try {
         if(!this.getCacheDir(var1).exists()) {
            this.getCacheDir(var1).mkdir();
         }

      } catch (Exception var3) {
         Log.i("AppsFlyer_3.2", "Could not create cache directory");
      }
   }
}
