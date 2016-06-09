package com.parse;

import android.os.Build.VERSION;
import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.parse.PLog;
import com.parse.ParseException;
import com.parse.ParseExecutors;
import com.parse.ParseHttpClient;
import com.parse.ProgressCallback;
import com.parse.http.ParseHttpBody;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ParseRequest<Response> {
   private static final int CORE_POOL_SIZE = 0;
   private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
   static final long DEFAULT_INITIAL_RETRY_DELAY = 1000L;
   protected static final int DEFAULT_MAX_RETRIES = 4;
   private static final long KEEP_ALIVE_TIME = 1L;
   private static final int MAX_POOL_SIZE = 0;
   private static final int MAX_QUEUE_SIZE = 128;
   static final ExecutorService NETWORK_EXECUTOR;
   private static long defaultInitialRetryDelay;
   private static final ThreadFactory sThreadFactory = new ThreadFactory() {
      private final AtomicInteger mCount = new AtomicInteger(1);

      public Thread newThread(Runnable var1) {
         return new Thread(var1, "ParseRequest.NETWORK_EXECUTOR-thread-" + this.mCount.getAndIncrement());
      }
   };
   private int maxRetries;
   ParseHttpRequest.Method method;
   String url;

   static {
      CORE_POOL_SIZE = 1 + 2 * CPU_COUNT;
      MAX_POOL_SIZE = 1 + 2 * 2 * CPU_COUNT;
      NETWORK_EXECUTOR = newThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), sThreadFactory);
      defaultInitialRetryDelay = 1000L;
   }

   public ParseRequest(ParseHttpRequest.Method var1, String var2) {
      this.maxRetries = 4;
      this.method = var1;
      this.url = var2;
   }

   public ParseRequest(String var1) {
      this(ParseHttpRequest.Method.GET, var1);
   }

   // $FF: synthetic method
   static Task access$100(ParseRequest var0, ParseHttpClient var1, ParseHttpRequest var2, int var3, long var4, ProgressCallback var6, Task var7) {
      return var0.executeAsync(var1, var2, var3, var4, var6, var7);
   }

   private Task<Response> executeAsync(final ParseHttpClient var1, final ParseHttpRequest var2, final int var3, final long var4, final ProgressCallback var6, final Task<Void> var7) {
      return var7 != null && var7.isCancelled()?Task.cancelled():this.sendOneRequestAsync(var1, var2, var6).continueWithTask(new Continuation() {
         public Task<Response> then(Task<Response> var1x) throws Exception {
            Exception var2x = var1x.getError();
            if(var1x.isFaulted() && var2x instanceof ParseException) {
               if(var7 != null && var7.isCancelled()) {
                  var1x = Task.cancelled();
               } else if((!(var2x instanceof ParseRequest.ParseRequestException) || !((ParseRequest.ParseRequestException)var2x).isPermanentFailure) && var3 < ParseRequest.this.maxRetries) {
                  PLog.method_363("com.parse.ParseRequest", "Request failed. Waiting " + var4 + " milliseconds before attempt #" + (1 + var3));
                  final TaskCompletionSource var3x = new TaskCompletionSource();
                  ParseExecutors.scheduled().schedule(new Runnable() {
                     public void run() {
                        ParseRequest.access$100(ParseRequest.this, var1, var2, 1 + var3, 2L * var4, var6, var7).continueWithTask(new Continuation() {
                           public Task<Void> then(Task<Response> var1x) throws Exception {
                              if(var1x.isCancelled()) {
                                 var3x.setCancelled();
                              } else if(var1x.isFaulted()) {
                                 var3x.setError(var1x.getError());
                              } else {
                                 var3x.setResult(var1x.getResult());
                              }

                              return null;
                           }
                        });
                     }
                  }, var4, TimeUnit.MILLISECONDS);
                  return var3x.getTask();
               }
            }

            return var1x;
         }
      });
   }

   private Task<Response> executeAsync(ParseHttpClient var1, ParseHttpRequest var2, ProgressCallback var3, Task<Void> var4) {
      return this.executeAsync(var1, var2, 0, defaultInitialRetryDelay + (long)((double)defaultInitialRetryDelay * Math.random()), var3, var4);
   }

   public static long getDefaultInitialRetryDelay() {
      return defaultInitialRetryDelay;
   }

   private static ThreadPoolExecutor newThreadPoolExecutor(int var0, int var1, long var2, TimeUnit var4, BlockingQueue<Runnable> var5, ThreadFactory var6) {
      ThreadPoolExecutor var7 = new ThreadPoolExecutor(var0, var1, var2, var4, var5, var6);
      if(VERSION.SDK_INT >= 9) {
         var7.allowCoreThreadTimeOut(true);
      }

      return var7;
   }

   private Task<Response> sendOneRequestAsync(final ParseHttpClient var1, final ParseHttpRequest var2, final ProgressCallback var3) {
      return Task.forResult((Object)null).onSuccessTask(new Continuation() {
         public Task<Response> then(Task<Void> var1x) throws Exception {
            ParseHttpResponse var2x = var1.execute(var2);
            return ParseRequest.this.onResponseAsync(var2x, var3);
         }
      }, NETWORK_EXECUTOR).continueWithTask(new Continuation() {
         public Task<Response> then(Task<Response> var1) throws Exception {
            if(var1.isFaulted()) {
               Exception var2 = var1.getError();
               if(var2 instanceof IOException) {
                  var1 = Task.forError(ParseRequest.this.newTemporaryException("i/o failure", var2));
               }
            }

            return var1;
         }
      }, Task.BACKGROUND_EXECUTOR);
   }

   public static void setDefaultInitialRetryDelay(long var0) {
      defaultInitialRetryDelay = var0;
   }

   public Task<Response> executeAsync(ParseHttpClient var1) {
      return this.executeAsync(var1, (ProgressCallback)((ProgressCallback)null), (ProgressCallback)null, (Task)null);
   }

   public Task<Response> executeAsync(ParseHttpClient var1, Task<Void> var2) {
      return this.executeAsync(var1, (ProgressCallback)((ProgressCallback)null), (ProgressCallback)null, var2);
   }

   public Task<Response> executeAsync(ParseHttpClient var1, ProgressCallback var2, ProgressCallback var3) {
      return this.executeAsync(var1, (ProgressCallback)var2, var3, (Task)null);
   }

   public Task<Response> executeAsync(ParseHttpClient var1, ProgressCallback var2, ProgressCallback var3, Task<Void> var4) {
      return this.executeAsync(var1, this.newRequest(this.method, this.url, var2), var3, var4);
   }

   protected ParseHttpBody newBody(ProgressCallback var1) {
      return null;
   }

   protected ParseException newPermanentException(int var1, String var2) {
      ParseRequest.ParseRequestException var3 = new ParseRequest.ParseRequestException(var1, var2);
      var3.isPermanentFailure = true;
      return var3;
   }

   protected ParseHttpRequest newRequest(ParseHttpRequest.Method var1, String var2, ProgressCallback var3) {
      ParseHttpRequest.Builder var4 = (new ParseHttpRequest.Builder()).setMethod(var1).setUrl(var2);
      switch(null.$SwitchMap$com$parse$http$ParseHttpRequest$Method[var1.ordinal()]) {
      case 3:
      case 4:
         var4.setBody(this.newBody(var3));
      case 1:
      case 2:
         return var4.build();
      default:
         throw new IllegalStateException("Invalid method " + var1);
      }
   }

   protected ParseException newTemporaryException(int var1, String var2) {
      ParseRequest.ParseRequestException var3 = new ParseRequest.ParseRequestException(var1, var2);
      var3.isPermanentFailure = false;
      return var3;
   }

   protected ParseException newTemporaryException(String var1, Throwable var2) {
      ParseRequest.ParseRequestException var3 = new ParseRequest.ParseRequestException(100, var1, var2);
      var3.isPermanentFailure = false;
      return var3;
   }

   protected abstract Task<Response> onResponseAsync(ParseHttpResponse var1, ProgressCallback var2);

   public void setMaxRetries(int var1) {
      this.maxRetries = var1;
   }

   private static class ParseRequestException extends ParseException {
      boolean isPermanentFailure = false;

      public ParseRequestException(int var1, String var2) {
         super(var1, var2);
      }

      public ParseRequestException(int var1, String var2, Throwable var3) {
         super(var1, var2, var3);
      }
   }
}
