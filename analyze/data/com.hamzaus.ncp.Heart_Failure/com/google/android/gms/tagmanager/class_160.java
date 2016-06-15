package com.google.android.gms.tagmanager;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.internal.class_129;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_279;
import com.google.android.gms.internal.class_51;
import com.google.android.gms.tagmanager.Container;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.class_509;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_521;
import com.google.android.gms.tagmanager.class_523;
import com.google.android.gms.tagmanager.class_524;
import com.google.android.gms.tagmanager.class_539;
import com.google.android.gms.tagmanager.class_571;
import com.google.android.gms.tagmanager.class_578;
import com.google.android.gms.tagmanager.class_68;
import com.google.android.gms.tagmanager.class_76;

// $FF: renamed from: com.google.android.gms.tagmanager.o
class class_160 extends class_797.class_1207<ContainerHolder> {
   // $FF: renamed from: DC android.os.Looper
   private final Looper field_46;
   private final TagManager aeC;
   private final class_160.class_1196 aeF;
   private final class_76 aeG;
   private final int aeH;
   private class_160.class_1198 aeI;
   private volatile class_571 aeJ;
   private volatile boolean aeK;
   private class_51.class_961 aeL;
   private String aeM;
   private class_160.class_1197 aeN;
   private class_160.class_1193 aeO;
   private final class_19 aec;
   private final String aeq;
   private long aev;
   private final Context mContext;

   class_160(Context var1, TagManager var2, Looper var3, String var4, int var5, class_160.class_1198 var6, class_160.class_1197 var7, class_19 var8, class_76 var9) {
      Looper var10;
      if(var3 == null) {
         var10 = Looper.getMainLooper();
      } else {
         var10 = var3;
      }

      super(var10);
      this.mContext = var1;
      this.aeC = var2;
      if(var3 == null) {
         var3 = Looper.getMainLooper();
      }

      this.field_46 = var3;
      this.aeq = var4;
      this.aeH = var5;
      this.aeI = var6;
      this.aeN = var7;
      this.aeF = new class_160.class_1196(null);
      this.aeL = new class_51.class_961();
      this.aec = var8;
      this.aeG = var9;
      if(this.method_899()) {
         this.method_902(class_521.method_2948().method_2951());
      }

   }

   public class_160(Context var1, TagManager var2, Looper var3, String var4, int var5, class_578 var6) {
      this(var1, var2, var3, var4, var5, new class_523(var1, var4), new class_524(var1, var4, var6), class_279.method_1858(), new class_509(30, 900000L, 5000L, "refreshing", class_279.method_1858()));
   }

   // $FF: renamed from: H (boolean) void
   private void method_886(final boolean var1) {
      this.aeI.method_246(new class_160.class_1194(null));
      this.aeN.method_250(new class_160.class_1195(null));
      class_539.class_1301 var2 = this.aeI.method_248(this.aeH);
      if(var2 != null) {
         this.aeJ = new class_571(this.aeC, this.field_46, new Container(this.mContext, this.aeC.getDataLayer(), this.aeq, 0L, var2), this.aeF);
      }

      this.aeO = new class_160.class_1193() {
         // $FF: renamed from: b (com.google.android.gms.tagmanager.Container) boolean
         public boolean method_677(Container var1x) {
            if(var1) {
               if(43200000L + var1x.getLastRefreshTime() < class_160.this.aec.currentTimeMillis()) {
                  return false;
               }
            } else if(var1x.isDefault()) {
               return false;
            }

            return true;
         }
      };
      if(this.method_899()) {
         this.aeN.method_252(0L, "");
      } else {
         this.aeI.method_249();
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.c$j) void
   private void method_888(class_51.class_961 var1) {
      synchronized(this){}

      try {
         if(this.aeI != null) {
            class_129.class_1078 var3 = new class_129.class_1078();
            var3.aiD = this.aev;
            var3.field_819 = new class_51.class_965();
            var3.aiE = var1;
            this.aeI.method_247(var3);
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.c$j, long, boolean) void
   private void method_889(class_51.class_961 param1, long param2, boolean param4) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.o, com.google.android.gms.internal.c$j) void
   // $FF: synthetic method
   static void method_891(class_160 var0, class_51.class_961 var1) {
      var0.method_888(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.o, com.google.android.gms.internal.c$j, long, boolean) void
   // $FF: synthetic method
   static void method_892(class_160 var0, class_51.class_961 var1, long var2, boolean var4) {
      var0.method_889(var1, var2, var4);
   }

   // $FF: renamed from: c (com.google.android.gms.tagmanager.o) com.google.android.gms.internal.c$j
   // $FF: synthetic method
   static class_51.class_961 method_894(class_160 var0) {
      return var0.aeL;
   }

   // $FF: renamed from: d (com.google.android.gms.tagmanager.o) long
   // $FF: synthetic method
   static long method_895(class_160 var0) {
      return var0.aev;
   }

   // $FF: renamed from: e (com.google.android.gms.tagmanager.o) boolean
   // $FF: synthetic method
   static boolean method_896(class_160 var0) {
      return var0.method_899();
   }

   // $FF: renamed from: lp () boolean
   private boolean method_899() {
      class_521 var1 = class_521.method_2948();
      return (var1.method_2950() == class_521.class_1311.agz || var1.method_2950() == class_521.class_1311.agA) && this.aeq.equals(var1.getContainerId());
   }

   // $FF: renamed from: w (long) void
   private void method_900(long var1) {
      synchronized(this){}

      try {
         if(this.aeN == null) {
            class_515.method_2919("Refresh requested, but no network load scheduler.");
         } else {
            this.aeN.method_252(var1, this.aeL.field_880);
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: ap (com.google.android.gms.common.api.Status) com.google.android.gms.tagmanager.ContainerHolder
   protected ContainerHolder method_901(Status var1) {
      if(this.aeJ != null) {
         return this.aeJ;
      } else {
         if(var1 == Status.field_3883) {
            class_515.method_2916("timer expired: setting result to failure");
         }

         return new class_571(var1);
      }
   }

   // $FF: renamed from: bJ (java.lang.String) void
   void method_902(String var1) {
      synchronized(this){}

      try {
         this.aeM = var1;
         if(this.aeN != null) {
            this.aeN.method_251(var1);
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
   // $FF: synthetic method
   protected Result method_884(Status var1) {
      return this.method_901(var1);
   }

   // $FF: renamed from: lj () java.lang.String
   String method_903() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.aeM;
      } finally {
         ;
      }

      return var2;
   }

   // $FF: renamed from: lm () void
   public void method_904() {
      class_539.class_1301 var1 = this.aeI.method_248(this.aeH);
      if(var1 != null) {
         Container var2 = new Container(this.mContext, this.aeC.getDataLayer(), this.aeq, 0L, var1);
         this.b(new class_571(this.aeC, this.field_46, var2, new class_571.class_833() {
            // $FF: renamed from: bJ (java.lang.String) void
            public void method_110(String var1) {
               class_160.this.method_902(var1);
            }

            // $FF: renamed from: lj () java.lang.String
            public String method_111() {
               return class_160.this.method_903();
            }

            // $FF: renamed from: ll () void
            public void method_112() {
               class_515.method_2919("Refresh ignored: container loaded as default only.");
            }
         }));
      } else {
         class_515.method_2916("Default was requested, but no default container was found");
         this.b(this.method_901(new Status(10, "Default was requested, but no default container was found", (PendingIntent)null)));
      }

      this.aeN = null;
      this.aeI = null;
   }

   // $FF: renamed from: ln () void
   public void method_905() {
      this.method_886(false);
   }

   // $FF: renamed from: lo () void
   public void method_906() {
      this.method_886(true);
   }

   interface class_1193 {
      // $FF: renamed from: b (com.google.android.gms.tagmanager.Container) boolean
      boolean method_677(Container var1);
   }

   private class class_1194 implements bg<class_129.class_1078> {
      private class_1194() {
      }

      // $FF: synthetic method
      class_1194(Object var2) {
         this();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.lf$a) void
      public void method_3464(class_129.class_1078 var1) {
         class_51.class_961 var3;
         if(var1.aiE != null) {
            var3 = var1.aiE;
         } else {
            class_51.class_965 var2 = var1.field_819;
            var3 = new class_51.class_961();
            var3.field_879 = var2;
            var3.field_878 = null;
            var3.field_880 = var2.field_852;
         }

         class_160.method_892(class_160.this, var3, var1.aiD, true);
      }

      // $FF: renamed from: a (com.google.android.gms.tagmanager.bg$a) void
      public void method_353(class_68.class_818 var1) {
         if(!class_160.this.aeK) {
            class_160.this.method_900(0L);
         }

      }

      // $FF: renamed from: i (java.lang.Object) void
      // $FF: synthetic method
      public void method_354(Object var1) {
         this.method_3464((class_129.class_1078)var1);
      }

      // $FF: renamed from: lq () void
      public void method_355() {
      }
   }

   private class class_1195 implements bg<class_51.class_961> {
      private class_1195() {
      }

      // $FF: synthetic method
      class_1195(Object var2) {
         this();
      }

      // $FF: renamed from: a (com.google.android.gms.tagmanager.bg$a) void
      public void method_353(class_68.class_818 var1) {
         if(class_160.this.aeJ != null) {
            class_160.this.b(class_160.this.aeJ);
         } else {
            class_160.this.b(class_160.this.method_901(Status.field_3883));
         }

         class_160.this.method_900(3600000L);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.c$j) void
      public void method_3463(class_51.class_961 param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: i (java.lang.Object) void
      // $FF: synthetic method
      public void method_354(Object var1) {
         this.method_3463((class_51.class_961)var1);
      }

      // $FF: renamed from: lq () void
      public void method_355() {
      }
   }

   private class class_1196 implements class_571.class_833 {
      private class_1196() {
      }

      // $FF: synthetic method
      class_1196(Object var2) {
         this();
      }

      // $FF: renamed from: bJ (java.lang.String) void
      public void method_110(String var1) {
         class_160.this.method_902(var1);
      }

      // $FF: renamed from: lj () java.lang.String
      public String method_111() {
         return class_160.this.method_903();
      }

      // $FF: renamed from: ll () void
      public void method_112() {
         if(class_160.this.aeG.method_373()) {
            class_160.this.method_900(0L);
         }

      }
   }

   interface class_1197 extends Releasable {
      // $FF: renamed from: a (com.google.android.gms.tagmanager.bg) void
      void method_250(bg<class_51.class_961> var1);

      // $FF: renamed from: bM (java.lang.String) void
      void method_251(String var1);

      // $FF: renamed from: e (long, java.lang.String) void
      void method_252(long var1, String var3);
   }

   interface class_1198 extends Releasable {
      // $FF: renamed from: a (com.google.android.gms.tagmanager.bg) void
      void method_246(bg<class_129.class_1078> var1);

      // $FF: renamed from: b (com.google.android.gms.internal.lf$a) void
      void method_247(class_129.class_1078 var1);

      // $FF: renamed from: dn (int) com.google.android.gms.tagmanager.cq$c
      class_539.class_1301 method_248(int var1);

      // $FF: renamed from: lr () void
      void method_249();
   }
}
