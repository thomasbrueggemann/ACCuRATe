package com.facebook.common.statfs;

import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class StatFsHelper {
   private static final long RESTAT_INTERVAL_MS;
   private static StatFsHelper sStatsFsHelper;
   private final Lock lock = new ReentrantLock();
   private volatile File mExternalPath;
   private volatile StatFs mExternalStatFs = null;
   private volatile boolean mInitialized = false;
   private volatile File mInternalPath;
   private volatile StatFs mInternalStatFs = null;
   @GuardedBy("lock")
   private long mLastRestatTime;

   static {
      RESTAT_INTERVAL_MS = TimeUnit.MINUTES.toMillis(2L);
   }

   protected static StatFs createStatFs(String var0) {
      return new StatFs(var0);
   }

   private void ensureInitialized() {
      if(!this.mInitialized) {
         this.lock.lock();

         try {
            if(!this.mInitialized) {
               this.mInternalPath = Environment.getDataDirectory();
               this.mExternalPath = Environment.getExternalStorageDirectory();
               this.updateStats();
               this.mInitialized = true;
            }
         } finally {
            this.lock.unlock();
         }
      }

   }

   public static StatFsHelper getInstance() {
      synchronized(StatFsHelper.class){}

      StatFsHelper var1;
      try {
         if(sStatsFsHelper == null) {
            sStatsFsHelper = new StatFsHelper();
         }

         var1 = sStatsFsHelper;
      } finally {
         ;
      }

      return var1;
   }

   private void maybeUpdateStats() {
      if(this.lock.tryLock()) {
         try {
            if(SystemClock.elapsedRealtime() - this.mLastRestatTime > RESTAT_INTERVAL_MS) {
               this.updateStats();
            }
         } finally {
            this.lock.unlock();
         }
      }

   }

   @GuardedBy("lock")
   private void updateStats() {
      this.mInternalStatFs = this.updateStatsHelper(this.mInternalStatFs, this.mInternalPath);
      this.mExternalStatFs = this.updateStatsHelper(this.mExternalStatFs, this.mExternalPath);
      this.mLastRestatTime = SystemClock.elapsedRealtime();
   }

   private StatFs updateStatsHelper(@Nullable StatFs param1, @Nullable File param2) {
      // $FF: Couldn't be decompiled
   }

   public long getAvailableStorageSpace(StatFsHelper.StorageType var1) {
      this.ensureInitialized();
      this.maybeUpdateStats();
      StatFs var2;
      if(var1 == StatFsHelper.StorageType.INTERNAL) {
         var2 = this.mInternalStatFs;
      } else {
         var2 = this.mExternalStatFs;
      }

      return var2 != null?(long)var2.getBlockSize() * (long)var2.getAvailableBlocks():0L;
   }

   public void resetStats() {
      if(this.lock.tryLock()) {
         try {
            this.ensureInitialized();
            this.updateStats();
         } finally {
            this.lock.unlock();
         }
      }

   }

   public boolean testLowDiskSpace(StatFsHelper.StorageType var1, long var2) {
      this.ensureInitialized();
      long var4 = this.getAvailableStorageSpace(var1);
      return var4 <= 0L || var4 < var2;
   }

   public static enum StorageType {
      EXTERNAL,
      INTERNAL;

      static {
         StatFsHelper.StorageType[] var0 = new StatFsHelper.StorageType[]{INTERNAL, EXTERNAL};
      }
   }
}
