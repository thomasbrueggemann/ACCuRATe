package com.koushikdutta.ion;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.ResponseCacheMiddleware;
import com.koushikdutta.async.http.libcore.RawHeaders;
import com.koushikdutta.async.util.HashList;
import com.koushikdutta.ion.IonBitmapRequestBuilder;
import com.koushikdutta.ion.IonLog;
import com.koushikdutta.ion.IonRequestBuilder;
import com.koushikdutta.ion.Loader;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.IonBitmapCache;
import com.koushikdutta.ion.builder.Builders;
import com.koushikdutta.ion.builder.FutureBuilder;
import com.koushikdutta.ion.builder.LoadBuilder;
import com.koushikdutta.ion.cookie.CookieMiddleware;
import com.koushikdutta.ion.loader.AsyncHttpRequestFactory;
import com.koushikdutta.ion.loader.ContentLoader;
import com.koushikdutta.ion.loader.FileLoader;
import com.koushikdutta.ion.loader.HttpLoader;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public class Ion {
   static Ion instance;
   public static final Handler mainHandler = new Handler(Looper.getMainLooper());
   String LOGTAG;
   IonBitmapRequestBuilder bitmapBuilder = new IonBitmapRequestBuilder(this);
   IonBitmapCache bitmapCache;
   HashList<FutureCallback<BitmapInfo>> bitmapsPending = new HashList();
   Ion.Config config = new Ion.Config();
   ContentLoader contentLoader;
   Context context;
   CookieMiddleware cookieMiddleware;
   FileLoader fileLoader;
   Gson gson = new Gson();
   AsyncHttpClient httpClient = new AsyncHttpClient(new AsyncServer());
   HttpLoader httpLoader;
   WeakHashMap<Object, Ion.FutureSet> inFlight = new WeakHashMap();
   int logLevel;
   ResponseCacheMiddleware responseCache;

   private Ion(Context var1) {
      Context var2 = var1.getApplicationContext();
      this.context = var2;

      try {
         this.responseCache = ResponseCacheMiddleware.addCache(this.httpClient, new File(var2.getCacheDir(), "ion"), 10485760L);
      } catch (Exception var10) {
         IonLog.method_15("unable to set up response cache", var10);
      }

      if(VERSION.SDK_INT >= 9) {
         this.addCookieMiddleware();
      }

      this.httpClient.getSocketMiddleware().setConnectAllAddresses(true);
      this.httpClient.getSSLSocketMiddleware().setConnectAllAddresses(true);
      this.bitmapCache = new IonBitmapCache(this);
      Ion.Config var4 = this.configure();
      HttpLoader var5 = new HttpLoader();
      this.httpLoader = var5;
      Ion.Config var6 = var4.addLoader(var5);
      ContentLoader var7 = new ContentLoader();
      this.contentLoader = var7;
      Ion.Config var8 = var6.addLoader(var7);
      FileLoader var9 = new FileLoader();
      this.fileLoader = var9;
      var8.addLoader(var9);
   }

   private void addCookieMiddleware() {
      AsyncHttpClient var1 = this.httpClient;
      CookieMiddleware var2 = new CookieMiddleware(this.context);
      this.cookieMiddleware = var2;
      var1.insertMiddleware(var2);
   }

   public static Ion getDefault(Context var0) {
      if(instance == null) {
         instance = new Ion(var0);
      }

      return instance;
   }

   public static Builders.class_3 with(Context var0, String var1) {
      return getDefault(var0).build(var0, var1);
   }

   public static Builders.class_9<? extends Builders.class_9<?>> with(ImageView var0) {
      return getDefault(var0.getContext()).build(var0);
   }

   public static FutureBuilder with(Context var0, File var1) {
      return getDefault(var0).build(var0, var1);
   }

   public static LoadBuilder<Builders.class_3> with(Context var0) {
      return getDefault(var0).build(var0);
   }

   void addFutureInFlight(Future param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   public Builders.class_3 build(Context var1, String var2) {
      return (new IonRequestBuilder(var1, this)).load(var2);
   }

   public Builders.class_9<? extends Builders.class_9<?>> build(ImageView var1) {
      if(Thread.currentThread() != Looper.getMainLooper().getThread()) {
         throw new IllegalStateException("must be called from UI thread");
      } else {
         this.bitmapBuilder.reset();
         this.bitmapBuilder.ion = this;
         return this.bitmapBuilder.withImageView(var1);
      }
   }

   public FutureBuilder build(Context var1, File var2) {
      return (new IonRequestBuilder(var1, this)).load(var2);
   }

   public LoadBuilder<Builders.class_3> build(Context var1) {
      return new IonRequestBuilder(var1, this);
   }

   public void cancelAll() {
      // $FF: Couldn't be decompiled
   }

   public void cancelAll(Context var1) {
      this.cancelAll((Object)var1);
   }

   public void cancelAll(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public Ion.Config configure() {
      return this.config;
   }

   public void disableProxy() {
      this.httpClient.getSocketMiddleware().disableProxy();
   }

   public void disableSecureProxy() {
      this.httpClient.getSocketMiddleware().disableProxy();
   }

   public void dump() {
      this.bitmapCache.dump();
      Log.i(this.LOGTAG, "Pending bitmaps: " + this.bitmapsPending.size());
      Log.i(this.LOGTAG, "Groups: " + this.inFlight.size());
      Iterator var3 = this.inFlight.values().iterator();

      while(var3.hasNext()) {
         Ion.FutureSet var4 = (Ion.FutureSet)var3.next();
         Log.i(this.LOGTAG, "Group size: " + var4.size());
      }

   }

   public IonBitmapCache getBitmapCache() {
      return this.bitmapCache;
   }

   public ContentLoader getContentLoader() {
      return this.contentLoader;
   }

   public Context getContext() {
      return this.context;
   }

   public CookieMiddleware getCookieMiddleware() {
      return this.cookieMiddleware;
   }

   public FileLoader getFileLoader() {
      return this.fileLoader;
   }

   public Gson getGson() {
      return this.gson;
   }

   public AsyncHttpClient getHttpClient() {
      return this.httpClient;
   }

   public HttpLoader getHttpLoader() {
      return this.httpLoader;
   }

   public int getPendingRequestCount(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public AsyncServer getServer() {
      return this.httpClient.getServer();
   }

   public void proxy(String var1, int var2) {
      this.httpClient.getSocketMiddleware().enableProxy(var1, var2);
   }

   public void proxySecure(String var1, int var2) {
      this.httpClient.getSSLSocketMiddleware().enableProxy(var1, var2);
   }

   void removeFutureInFlight(Future var1, Object var2) {
   }

   public void setLogging(String var1, int var2) {
      this.LOGTAG = var1;
      this.logLevel = var2;
   }

   private static class AsyncHttpRequestFactoryImpl implements AsyncHttpRequestFactory {
      private AsyncHttpRequestFactoryImpl() {
      }

      // $FF: synthetic method
      AsyncHttpRequestFactoryImpl(Object var1) {
         this();
      }

      public AsyncHttpRequest createAsyncHttpRequest(URI var1, String var2, RawHeaders var3) {
         return new AsyncHttpRequest(var1, var2, var3);
      }
   }

   public static class Config {
      AsyncHttpRequestFactory asyncHttpRequestFactory = new Ion.AsyncHttpRequestFactoryImpl();
      ArrayList<Loader> loaders = new ArrayList();

      public Ion.Config addLoader(int var1, Loader var2) {
         this.loaders.add(var1, var2);
         return this;
      }

      public Ion.Config addLoader(Loader var1) {
         this.loaders.add(var1);
         return this;
      }

      public AsyncHttpRequestFactory getAsyncHttpRequestFactory() {
         return this.asyncHttpRequestFactory;
      }

      public List<Loader> getLoaders() {
         return this.loaders;
      }

      public Ion.Config insertLoader(Loader var1) {
         this.loaders.add(0, var1);
         return this;
      }

      public Ion.Config setAsyncHttpRequestFactory(AsyncHttpRequestFactory var1) {
         this.asyncHttpRequestFactory = var1;
         return this;
      }
   }

   static class FutureSet extends WeakHashMap<Future, Boolean> {
   }
}
