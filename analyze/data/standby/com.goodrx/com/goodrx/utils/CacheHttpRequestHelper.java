package com.goodrx.utils;

import android.content.Context;
import android.util.Log;
import com.goodrx.model.ResponseEntity;
import com.goodrx.utils.DBManager;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.utils.Utils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.DataAsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import cz.msebera.android.httpclient.Header;

public class CacheHttpRequestHelper {
   public static String USER_AGENT = "GoodRxAndroidApp";
   private static CacheHttpRequestHelper instance;
   private AsyncHttpClient client;
   private DBManager dbManager;

   public static CacheHttpRequestHelper getInstance() {
      if(instance == null) {
         instance = new CacheHttpRequestHelper();
      }

      return instance;
   }

   public void get(String var1, RequestParams var2, final MyResponseHandler var3) {
      final String var4 = AsyncHttpClient.getUrlWithQueryString(false, var1, var2);
      Log.i("goodrx_request", var4);
      this.client.get(var1, var2, new DataAsyncHttpResponseHandler() {
         public void onFailure(int var1, Header[] var2, byte[] var3x, Throwable var4x) {
            var3.onFailure(var1, var2, var3x, var4x, var4);
         }

         public void onSuccess(int var1, Header[] var2, byte[] var3x) {
            String var4x = new String(var3x);
            var3.onSuccess(var4x);
         }
      });
   }

   protected void getUsingCache(final String var1, RequestParams var2, long var3, final int var5, final MyResponseHandler var6) {
      if(var2 == null) {
         var2 = new RequestParams();
      }

      var2.add("platform", "Android");
      var2.add("version", "5.0.4");
      final String var7 = AsyncHttpClient.getUrlWithQueryString(false, var1, var2);
      ResponseEntity var8 = this.dbManager.getDataFromUrl(var1, var2.toString());
      if(var8 != null) {
         long var12 = Utils.getCurrentTimeInMillis() - var8.getLastModified();
         if(var12 > 0L && var12 < var3) {
            var6.onSuccess(var8.getContent());
            Log.i("goodrx_request", var7 + " true");
            return;
         }
      }

      Log.i("goodrx_request", var7 + " false");
      final String var10 = var2.toString();
      this.client.get(var1, var2, new DataAsyncHttpResponseHandler() {
         public void onFailure(int var1x, Header[] var2, byte[] var3, Throwable var4) {
            var6.onFailure(var1x, var2, var3, var4, var7);
         }

         public void onSuccess(int var1x, Header[] var2, byte[] var3) {
            String var4 = new String(var3);
            var6.onSuccess(var4);
            CacheHttpRequestHelper.this.dbManager.insertOrUpdate(new ResponseEntity(var1, var10, var4, Utils.getCurrentTimeInMillis(), var5));
         }
      });
   }

   public void getUsingCache(String var1, RequestParams var2, long var3, MyResponseHandler var5) {
      this.getUsingCache(var1, var2, var3, 0, var5);
   }

   public void getUsingLocationSensitiveCache(String var1, RequestParams var2, long var3, MyResponseHandler var5) {
      this.getUsingCache(var1, var2, var3, 1, var5);
   }

   public void init(Context var1) {
      this.client = new AsyncHttpClient();
      this.client.setTimeout(30000);
      PersistentCookieStore var2 = new PersistentCookieStore(var1);
      this.client.setCookieStore(var2);
      this.client.setUserAgent(USER_AGENT + "/" + "5.0.4");
      this.dbManager = new DBManager(var1);
   }

   public void post(final String var1, final RequestParams var2, final MyResponseHandler var3) {
      this.client.post(var1, var2, new DataAsyncHttpResponseHandler() {
         public void onFailure(int var1x, Header[] var2x, byte[] var3x, Throwable var4) {
            var3.onFailure(var1x, var2x, var3x, var4, AsyncHttpClient.getUrlWithQueryString(false, var1, var2));
         }

         public void onSuccess(int var1x, Header[] var2x, byte[] var3x) {
            String var4 = new String(var3x);
            var3.onSuccess(var4);
         }
      });
      Log.i("goodrx_request", AsyncHttpClient.getUrlWithQueryString(false, var1, var2) + " false");
   }
}
