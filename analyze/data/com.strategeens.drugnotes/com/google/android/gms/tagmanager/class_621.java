package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_55;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.class_202;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_622;
import com.google.android.gms.tagmanager.class_679;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.tagmanager.cp
class class_621 implements class_202.class_1363 {
   private String aqI;
   private final String aqm;
   private bg<class_55.class_1260> asC;
   private class_679 asD;
   private final ScheduledExecutorService asF;
   private final class_621.class_1647 asG;
   private ScheduledFuture<?> asH;
   private boolean mClosed;
   private final Context mContext;

   public class_621(Context var1, String var2, class_679 var3) {
      this(var1, var2, var3, (class_621.class_1646)null, (class_621.class_1647)null);
   }

   class_621(Context var1, String var2, class_679 var3, class_621.class_1646 var4, class_621.class_1647 var5) {
      this.asD = var3;
      this.mContext = var1;
      this.aqm = var2;
      if(var4 == null) {
         var4 = new class_621.class_1646() {
            // $FF: renamed from: qh () java.util.concurrent.ScheduledExecutorService
            public ScheduledExecutorService method_917() {
               return Executors.newSingleThreadScheduledExecutor();
            }
         };
      }

      this.asF = var4.method_917();
      if(var5 == null) {
         this.asG = new class_621.class_1647() {
            // $FF: renamed from: a (com.google.android.gms.tagmanager.r) com.google.android.gms.tagmanager.co
            public class_622 method_918(class_679 var1) {
               return new class_622(class_621.this.mContext, class_621.this.aqm, var1);
            }
         };
      } else {
         this.asG = var5;
      }
   }

   // $FF: renamed from: cM (java.lang.String) com.google.android.gms.tagmanager.co
   private class_622 method_3551(String var1) {
      class_622 var2 = this.asG.method_918(this.asD);
      var2.method_3557(this.asC);
      var2.method_3559(this.aqI);
      var2.method_3558(var1);
      return var2;
   }

   // $FF: renamed from: qg () void
   private void method_3552() {
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
   public void method_280(bg<class_55.class_1260> var1) {
      synchronized(this){}

      try {
         this.method_3552();
         this.asC = var1;
      } finally {
         ;
      }

   }

   // $FF: renamed from: cw (java.lang.String) void
   public void method_281(String var1) {
      synchronized(this){}

      try {
         this.method_3552();
         this.aqI = var1;
      } finally {
         ;
      }

   }

   // $FF: renamed from: e (long, java.lang.String) void
   public void method_282(long var1, String var3) {
      synchronized(this){}

      try {
         class_613.method_3493("loadAfterDelay: containerId=" + this.aqm + " delay=" + var1);
         this.method_3552();
         if(this.asC == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
         }

         if(this.asH != null) {
            this.asH.cancel(false);
         }

         this.asH = this.asF.schedule(this.method_3551(var3), var1, TimeUnit.MILLISECONDS);
      } finally {
         ;
      }

   }

   public void release() {
      synchronized(this){}

      try {
         this.method_3552();
         if(this.asH != null) {
            this.asH.cancel(false);
         }

         this.asF.shutdown();
         this.mClosed = true;
      } finally {
         ;
      }

   }

   interface class_1647 {
      // $FF: renamed from: a (com.google.android.gms.tagmanager.r) com.google.android.gms.tagmanager.co
      class_622 method_918(class_679 var1);
   }

   interface class_1646 {
      // $FF: renamed from: qh () java.util.concurrent.ScheduledExecutorService
      ScheduledExecutorService method_917();
   }
}
