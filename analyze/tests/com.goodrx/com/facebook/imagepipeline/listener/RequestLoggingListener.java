package com.facebook.imagepipeline.listener;

import android.os.SystemClock;
import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class RequestLoggingListener implements RequestListener {
   private static final String TAG = "RequestLoggingListener";
   @GuardedBy("this")
   private final Map<Pair<String, String>, Long> mProducerStartTimeMap = new HashMap();
   @GuardedBy("this")
   private final Map<String, Long> mRequestStartTimeMap = new HashMap();

   private static long getElapsedTime(@Nullable Long var0, long var1) {
      return var0 != null?var1 - var0.longValue():-1L;
   }

   private static long getTime() {
      return SystemClock.elapsedRealtime();
   }

   public void onProducerEvent(String var1, String var2, String var3) {
      synchronized(this){}

      try {
         if(FLog.isLoggable(2)) {
            Pair var5 = Pair.create(var1, var2);
            Long var6 = (Long)this.mProducerStartTimeMap.get(var5);
            long var7 = getTime();
            Object[] var9 = new Object[]{Long.valueOf(getTime()), var1, var2, var3, Long.valueOf(getElapsedTime(var6, var7))};
            FLog.method_431("RequestLoggingListener", "time %d: onProducerEvent: {requestId: %s, stage: %s, eventName: %s; elapsedTime: %d ms}", var9);
         }
      } finally {
         ;
      }

   }

   public void onProducerFinishWithCancellation(String var1, String var2, @Nullable Map<String, String> var3) {
      synchronized(this){}

      try {
         if(FLog.isLoggable(2)) {
            Pair var5 = Pair.create(var1, var2);
            Long var6 = (Long)this.mProducerStartTimeMap.remove(var5);
            long var7 = getTime();
            Object[] var9 = new Object[]{Long.valueOf(var7), var1, var2, Long.valueOf(getElapsedTime(var6, var7)), var3};
            FLog.method_431("RequestLoggingListener", "time %d: onProducerFinishWithCancellation: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s}", var9);
         }
      } finally {
         ;
      }

   }

   public void onProducerFinishWithFailure(String var1, String var2, Throwable var3, @Nullable Map<String, String> var4) {
      synchronized(this){}

      try {
         if(FLog.isLoggable(5)) {
            Pair var6 = Pair.create(var1, var2);
            Long var7 = (Long)this.mProducerStartTimeMap.remove(var6);
            long var8 = getTime();
            Object[] var10 = new Object[]{Long.valueOf(var8), var1, var2, Long.valueOf(getElapsedTime(var7, var8)), var4, var3.toString()};
            FLog.method_439("RequestLoggingListener", "time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", var10);
         }
      } finally {
         ;
      }

   }

   public void onProducerFinishWithSuccess(String var1, String var2, @Nullable Map<String, String> var3) {
      synchronized(this){}

      try {
         if(FLog.isLoggable(2)) {
            Pair var5 = Pair.create(var1, var2);
            Long var6 = (Long)this.mProducerStartTimeMap.remove(var5);
            long var7 = getTime();
            Object[] var9 = new Object[]{Long.valueOf(var7), var1, var2, Long.valueOf(getElapsedTime(var6, var7)), var3};
            FLog.method_431("RequestLoggingListener", "time %d: onProducerFinishWithSuccess: {requestId: %s, producer: %s, elapsedTime: %d ms, extraMap: %s}", var9);
         }
      } finally {
         ;
      }

   }

   public void onProducerStart(String var1, String var2) {
      synchronized(this){}

      try {
         if(FLog.isLoggable(2)) {
            Pair var4 = Pair.create(var1, var2);
            long var5 = getTime();
            this.mProducerStartTimeMap.put(var4, Long.valueOf(var5));
            FLog.method_428("RequestLoggingListener", "time %d: onProducerStart: {requestId: %s, producer: %s}", Long.valueOf(var5), var1, var2);
         }
      } finally {
         ;
      }

   }

   public void onRequestCancellation(String var1) {
      synchronized(this){}

      try {
         if(FLog.isLoggable(2)) {
            Long var3 = (Long)this.mRequestStartTimeMap.remove(var1);
            long var4 = getTime();
            FLog.method_428("RequestLoggingListener", "time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(var4), var1, Long.valueOf(getElapsedTime(var3, var4)));
         }
      } finally {
         ;
      }

   }

   public void onRequestFailure(ImageRequest var1, String var2, Throwable var3, boolean var4) {
      synchronized(this){}

      try {
         if(FLog.isLoggable(5)) {
            Long var6 = (Long)this.mRequestStartTimeMap.remove(var2);
            long var7 = getTime();
            Object[] var9 = new Object[]{Long.valueOf(var7), var2, Long.valueOf(getElapsedTime(var6, var7)), var3.toString()};
            FLog.method_439("RequestLoggingListener", "time %d: onRequestFailure: {requestId: %s, elapsedTime: %d ms, throwable: %s}", var9);
         }
      } finally {
         ;
      }

   }

   public void onRequestStart(ImageRequest var1, Object var2, String var3, boolean var4) {
      synchronized(this){}

      try {
         if(FLog.isLoggable(2)) {
            FLog.method_429("RequestLoggingListener", "time %d: onRequestSubmit: {requestId: %s, callerContext: %s, isPrefetch: %b}", Long.valueOf(getTime()), var3, var2, Boolean.valueOf(var4));
            this.mRequestStartTimeMap.put(var3, Long.valueOf(getTime()));
         }
      } finally {
         ;
      }

   }

   public void onRequestSuccess(ImageRequest var1, String var2, boolean var3) {
      synchronized(this){}

      try {
         if(FLog.isLoggable(2)) {
            Long var5 = (Long)this.mRequestStartTimeMap.remove(var2);
            long var6 = getTime();
            FLog.method_428("RequestLoggingListener", "time %d: onRequestSuccess: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(var6), var2, Long.valueOf(getElapsedTime(var5, var6)));
         }
      } finally {
         ;
      }

   }

   public boolean requiresExtraMap(String var1) {
      return FLog.isLoggable(2);
   }
}
