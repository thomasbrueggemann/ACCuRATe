package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_51;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.class_160;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_525;
import com.google.android.gms.tagmanager.class_578;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.tagmanager.co
class class_524 implements class_160.class_1197 {
   private String aeM;
   private final String aeq;
   private bg<class_51.class_961> agK;
   private class_578 agL;
   private final ScheduledExecutorService agN;
   private final class_524.class_1309 agO;
   private ScheduledFuture<?> agP;
   private boolean mClosed;
   private final Context mContext;

   public class_524(Context var1, String var2, class_578 var3) {
      this(var1, var2, var3, (class_524.class_1310)null, (class_524.class_1309)null);
   }

   class_524(Context var1, String var2, class_578 var3, class_524.class_1310 var4, class_524.class_1309 var5) {
      this.agL = var3;
      this.mContext = var1;
      this.aeq = var2;
      if(var4 == null) {
         var4 = new class_524.class_1310() {
            // $FF: renamed from: mf () java.util.concurrent.ScheduledExecutorService
            public ScheduledExecutorService method_763() {
               return Executors.newSingleThreadScheduledExecutor();
            }
         };
      }

      this.agN = var4.method_763();
      if(var5 == null) {
         this.agO = new class_524.class_1309() {
            // $FF: renamed from: a (com.google.android.gms.tagmanager.r) com.google.android.gms.tagmanager.cn
            public class_525 method_762(class_578 var1) {
               return new class_525(class_524.this.mContext, class_524.this.aeq, var1);
            }
         };
      } else {
         this.agO = var5;
      }
   }

   // $FF: renamed from: cc (java.lang.String) com.google.android.gms.tagmanager.cn
   private class_525 method_2979(String var1) {
      class_525 var2 = this.agO.method_762(this.agL);
      var2.method_2983(this.agK);
      var2.method_2984(this.aeM);
      var2.method_2985(var1);
      return var2;
   }

   // $FF: renamed from: me () void
   private void method_2980() {
      synchronized(this){}

      try {
         if(this.mClosed) {
            throw new IllegalStateException("called method after closed");
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.bg) void
   public void method_250(bg<class_51.class_961> var1) {
      synchronized(this){}

      try {
         this.method_2980();
         this.agK = var1;
      } finally {
         ;
      }

   }

   // $FF: renamed from: bM (java.lang.String) void
   public void method_251(String var1) {
      synchronized(this){}

      try {
         this.method_2980();
         this.aeM = var1;
      } finally {
         ;
      }

   }

   // $FF: renamed from: e (long, java.lang.String) void
   public void method_252(long var1, String var3) {
      synchronized(this){}

      try {
         class_515.method_2918("loadAfterDelay: containerId=" + this.aeq + " delay=" + var1);
         this.method_2980();
         if(this.agK == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
         }

         if(this.agP != null) {
            this.agP.cancel(false);
         }

         this.agP = this.agN.schedule(this.method_2979(var3), var1, TimeUnit.MILLISECONDS);
      } finally {
         ;
      }

   }

   public void release() {
      synchronized(this){}

      try {
         this.method_2980();
         if(this.agP != null) {
            this.agP.cancel(false);
         }

         this.agN.shutdown();
         this.mClosed = true;
      } finally {
         ;
      }

   }

   interface class_1309 {
      // $FF: renamed from: a (com.google.android.gms.tagmanager.r) com.google.android.gms.tagmanager.cn
      class_525 method_762(class_578 var1);
   }

   interface class_1310 {
      // $FF: renamed from: mf () java.util.concurrent.ScheduledExecutorService
      ScheduledExecutorService method_763();
   }
}
