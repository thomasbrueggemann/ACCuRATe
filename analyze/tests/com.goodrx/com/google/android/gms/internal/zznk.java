package com.google.android.gms.internal;

import com.google.android.gms.internal.zznl;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class zznk implements ThreadFactory {
   private final int mPriority;
   private final String zzaoq;
   private final AtomicInteger zzaor;
   private final ThreadFactory zzaos;

   public zznk(String var1) {
      this(var1, 0);
   }

   public zznk(String var1, int var2) {
      this.zzaor = new AtomicInteger();
      this.zzaos = Executors.defaultThreadFactory();
      this.zzaoq = (String)com.google.android.gms.common.internal.zzx.zzb(var1, "Name must not be null");
      this.mPriority = var2;
   }

   public Thread newThread(Runnable var1) {
      Thread var2 = this.zzaos.newThread(new zznl(var1, this.mPriority));
      var2.setName(this.zzaoq + "[" + this.zzaor.getAndIncrement() + "]");
      return var2;
   }
}
