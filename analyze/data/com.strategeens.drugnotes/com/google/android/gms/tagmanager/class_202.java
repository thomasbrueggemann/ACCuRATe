package com.google.android.gms.tagmanager;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_141;
import com.google.android.gms.internal.class_161;
import com.google.android.gms.internal.class_55;
import com.google.android.gms.internal.class_720;
import com.google.android.gms.tagmanager.Container;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.class_608;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_619;
import com.google.android.gms.tagmanager.class_621;
import com.google.android.gms.tagmanager.class_638;
import com.google.android.gms.tagmanager.class_639;
import com.google.android.gms.tagmanager.class_672;
import com.google.android.gms.tagmanager.class_679;
import com.google.android.gms.tagmanager.class_73;
import com.google.android.gms.tagmanager.class_81;

// $FF: renamed from: com.google.android.gms.tagmanager.o
class class_202 extends BaseImplementation.AbstractPendingResult<ContainerHolder> {
   // $FF: renamed from: JF android.os.Looper
   private final Looper field_74;
   private final class_202.class_1362 aqB;
   private final class_81 aqC;
   private final int aqD;
   private class_202.class_1364 aqE;
   private volatile class_672 aqF;
   private volatile boolean aqG;
   private class_55.class_1260 aqH;
   private String aqI;
   private class_202.class_1363 aqJ;
   private class_202.class_1359 aqK;
   private final String aqm;
   private long aqr;
   private final TagManager aqy;
   private final Context mContext;
   // $FF: renamed from: wb com.google.android.gms.internal.ld
   private final class_141 field_75;

   class_202(Context var1, TagManager var2, Looper var3, String var4, int var5, class_202.class_1364 var6, class_202.class_1363 var7, class_141 var8, class_81 var9) {
      Looper var10;
      if(var3 == null) {
         var10 = Looper.getMainLooper();
      } else {
         var10 = var3;
      }

      super(var10);
      this.mContext = var1;
      this.aqy = var2;
      if(var3 == null) {
         var3 = Looper.getMainLooper();
      }

      this.field_74 = var3;
      this.aqm = var4;
      this.aqD = var5;
      this.aqE = var6;
      this.aqJ = var7;
      this.aqB = new class_202.class_1362(null);
      this.aqH = new class_55.class_1260();
      this.field_75 = var8;
      this.aqC = var9;
      if(this.method_1125()) {
         this.method_1128(class_619.method_3526().method_3529());
      }

   }

   public class_202(Context var1, TagManager var2, Looper var3, String var4, int var5, class_679 var6) {
      this(var1, var2, var3, var4, var5, new class_638(var1, var4), new class_621(var1, var4, var6), class_720.method_4198(), new class_608(30, 900000L, 5000L, "refreshing", class_720.method_4198()));
   }

   // $FF: renamed from: V (boolean) void
   private void method_1112(final boolean var1) {
      this.aqE.method_276(new class_202.class_1360(null));
      this.aqJ.method_280(new class_202.class_1361(null));
      class_639.class_1684 var2 = this.aqE.method_278(this.aqD);
      if(var2 != null) {
         this.aqF = new class_672(this.aqy, this.field_74, new Container(this.mContext, this.aqy.getDataLayer(), this.aqm, 0L, var2), this.aqB);
      }

      this.aqK = new class_202.class_1359() {
         // $FF: renamed from: b (com.google.android.gms.tagmanager.Container) boolean
         public boolean method_733(Container var1x) {
            if(var1) {
               if(43200000L + var1x.getLastRefreshTime() < class_202.this.field_75.currentTimeMillis()) {
                  return false;
               }
            } else if(var1x.isDefault()) {
               return false;
            }

            return true;
         }
      };
      if(this.method_1125()) {
         this.aqJ.method_282(0L, "");
      } else {
         this.aqE.method_279();
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.c$j) void
   private void method_1114(class_55.class_1260 var1) {
      synchronized(this){}

      try {
         if(this.aqE != null) {
            class_161.class_1310 var3 = new class_161.class_1310();
            var3.auB = this.aqr;
            var3.field_666 = new class_55.class_1269();
            var3.auC = var1;
            this.aqE.method_277(var3);
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.c$j, long, boolean) void
   private void method_1115(class_55.class_1260 param1, long param2, boolean param4) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.o, com.google.android.gms.internal.c$j) void
   // $FF: synthetic method
   static void method_1117(class_202 var0, class_55.class_1260 var1) {
      var0.method_1114(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.o, com.google.android.gms.internal.c$j, long, boolean) void
   // $FF: synthetic method
   static void method_1118(class_202 var0, class_55.class_1260 var1, long var2, boolean var4) {
      var0.method_1115(var1, var2, var4);
   }

   // $FF: renamed from: c (com.google.android.gms.tagmanager.o) com.google.android.gms.internal.c$j
   // $FF: synthetic method
   static class_55.class_1260 method_1120(class_202 var0) {
      return var0.aqH;
   }

   // $FF: renamed from: d (com.google.android.gms.tagmanager.o) long
   // $FF: synthetic method
   static long method_1121(class_202 var0) {
      return var0.aqr;
   }

   // $FF: renamed from: e (com.google.android.gms.tagmanager.o) boolean
   // $FF: synthetic method
   static boolean method_1122(class_202 var0) {
      return var0.method_1125();
   }

   // $FF: renamed from: pr () boolean
   private boolean method_1125() {
      class_619 var1 = class_619.method_3526();
      return (var1.method_3528() == class_619.class_1644.asr || var1.method_3528() == class_619.class_1644.ass) && this.aqm.equals(var1.getContainerId());
   }

   // $FF: renamed from: w (long) void
   private void method_1126(long var1) {
      synchronized(this){}

      try {
         if(this.aqJ == null) {
            class_613.method_3494("Refresh requested, but no network load scheduler.");
         } else {
            this.aqJ.method_282(var1, this.aqH.field_722);
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: aD (com.google.android.gms.common.api.Status) com.google.android.gms.tagmanager.ContainerHolder
   protected ContainerHolder method_1127(Status var1) {
      if(this.aqF != null) {
         return this.aqF;
      } else {
         if(var1 == Status.field_3963) {
            class_613.method_3491("timer expired: setting result to failure");
         }

         return new class_672(var1);
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
   // $FF: synthetic method
   protected Result method_1109(Status var1) {
      return this.method_1127(var1);
   }

   // $FF: renamed from: ct (java.lang.String) void
   void method_1128(String var1) {
      synchronized(this){}

      try {
         this.aqI = var1;
         if(this.aqJ != null) {
            this.aqJ.method_281(var1);
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: pl () java.lang.String
   String method_1129() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.aqI;
      } finally {
         ;
      }

      return var2;
   }

   // $FF: renamed from: po () void
   public void method_1130() {
      class_639.class_1684 var1 = this.aqE.method_278(this.aqD);
      if(var1 != null) {
         Container var2 = new Container(this.mContext, this.aqy.getDataLayer(), this.aqm, 0L, var1);
         this.b(new class_672(this.aqy, this.field_74, var2, new class_672.class_1116() {
            // $FF: renamed from: ct (java.lang.String) void
            public void method_173(String var1) {
               class_202.this.method_1128(var1);
            }

            // $FF: renamed from: pl () java.lang.String
            public String method_174() {
               return class_202.this.method_1129();
            }

            // $FF: renamed from: pn () void
            public void method_175() {
               class_613.method_3494("Refresh ignored: container loaded as default only.");
            }
         }));
      } else {
         class_613.method_3491("Default was requested, but no default container was found");
         this.b(this.method_1127(new Status(10, "Default was requested, but no default container was found", (PendingIntent)null)));
      }

      this.aqJ = null;
      this.aqE = null;
   }

   // $FF: renamed from: pp () void
   public void method_1131() {
      this.method_1112(false);
   }

   // $FF: renamed from: pq () void
   public void method_1132() {
      this.method_1112(true);
   }

   interface class_1359 {
      // $FF: renamed from: b (com.google.android.gms.tagmanager.Container) boolean
      boolean method_733(Container var1);
   }

   private class class_1360 implements bg<class_161.class_1310> {
      private class_1360() {
      }

      // $FF: synthetic method
      class_1360(Object var2) {
         this();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.pu$a) void
      public void method_4141(class_161.class_1310 var1) {
         class_55.class_1260 var3;
         if(var1.auC != null) {
            var3 = var1.auC;
         } else {
            class_55.class_1269 var2 = var1.field_666;
            var3 = new class_55.class_1260();
            var3.field_721 = var2;
            var3.field_720 = null;
            var3.field_722 = var2.version;
         }

         class_202.method_1118(class_202.this, var3, var1.auB, true);
      }

      // $FF: renamed from: a (com.google.android.gms.tagmanager.bg$a) void
      public void method_395(class_73.class_1072 var1) {
         if(!class_202.this.aqG) {
            class_202.this.method_1126(0L);
         }

      }

      // $FF: renamed from: l (java.lang.Object) void
      // $FF: synthetic method
      public void method_396(Object var1) {
         this.method_4141((class_161.class_1310)var1);
      }

      // $FF: renamed from: ps () void
      public void method_397() {
      }
   }

   private class class_1361 implements bg<class_55.class_1260> {
      private class_1361() {
      }

      // $FF: synthetic method
      class_1361(Object var2) {
         this();
      }

      // $FF: renamed from: a (com.google.android.gms.tagmanager.bg$a) void
      public void method_395(class_73.class_1072 var1) {
         if(class_202.this.aqF != null) {
            class_202.this.b(class_202.this.aqF);
         } else {
            class_202.this.b(class_202.this.method_1127(Status.field_3963));
         }

         class_202.this.method_1126(3600000L);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.c$j) void
      public void method_4140(class_55.class_1260 param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: l (java.lang.Object) void
      // $FF: synthetic method
      public void method_396(Object var1) {
         this.method_4140((class_55.class_1260)var1);
      }

      // $FF: renamed from: ps () void
      public void method_397() {
      }
   }

   private class class_1362 implements class_672.class_1116 {
      private class_1362() {
      }

      // $FF: synthetic method
      class_1362(Object var2) {
         this();
      }

      // $FF: renamed from: ct (java.lang.String) void
      public void method_173(String var1) {
         class_202.this.method_1128(var1);
      }

      // $FF: renamed from: pl () java.lang.String
      public String method_174() {
         return class_202.this.method_1129();
      }

      // $FF: renamed from: pn () void
      public void method_175() {
         if(class_202.this.aqC.method_414()) {
            class_202.this.method_1126(0L);
         }

      }
   }

   interface class_1363 extends Releasable {
      // $FF: renamed from: a (com.google.android.gms.tagmanager.bg) void
      void method_280(bg<class_55.class_1260> var1);

      // $FF: renamed from: cw (java.lang.String) void
      void method_281(String var1);

      // $FF: renamed from: e (long, java.lang.String) void
      void method_282(long var1, String var3);
   }

   interface class_1364 extends Releasable {
      // $FF: renamed from: a (com.google.android.gms.tagmanager.bg) void
      void method_276(bg<class_161.class_1310> var1);

      // $FF: renamed from: b (com.google.android.gms.internal.pu$a) void
      void method_277(class_161.class_1310 var1);

      // $FF: renamed from: fH (int) com.google.android.gms.tagmanager.cr$c
      class_639.class_1684 method_278(int var1);

      // $FF: renamed from: pt () void
      void method_279();
   }
}
