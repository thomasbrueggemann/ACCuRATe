package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.class_134;
import com.google.android.gms.analytics.class_135;
import com.google.android.gms.analytics.class_136;
import com.google.android.gms.analytics.class_140;
import com.google.android.gms.analytics.class_147;
import com.google.android.gms.analytics.class_641;
import com.google.android.gms.analytics.class_669;
import com.google.android.gms.internal.fe;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedQueue;

// $FF: renamed from: com.google.android.gms.analytics.s
class class_659 implements class_147, class_641.class_1330, class_641.class_1331 {
   private final Context mContext;
   // $FF: renamed from: tR com.google.android.gms.analytics.d
   private class_135 field_3442;
   // $FF: renamed from: tS com.google.android.gms.analytics.f
   private final class_134 field_3443;
   // $FF: renamed from: tU boolean
   private boolean field_3444;
   // $FF: renamed from: ue long
   private volatile long field_3445;
   // $FF: renamed from: uf com.google.android.gms.analytics.s$a
   private volatile class_659.class_1332 field_3446;
   // $FF: renamed from: ug com.google.android.gms.analytics.b
   private volatile class_140 field_3447;
   // $FF: renamed from: uh com.google.android.gms.analytics.d
   private class_135 field_3448;
   // $FF: renamed from: ui com.google.android.gms.analytics.GoogleAnalytics
   private final GoogleAnalytics field_3449;
   // $FF: renamed from: uj java.util.Queue
   private final Queue<class_659.class_1335> field_3450;
   // $FF: renamed from: uk int
   private volatile int field_3451;
   // $FF: renamed from: ul java.util.Timer
   private volatile Timer field_3452;
   // $FF: renamed from: um java.util.Timer
   private volatile Timer field_3453;
   // $FF: renamed from: un java.util.Timer
   private volatile Timer field_3454;
   // $FF: renamed from: uo boolean
   private boolean field_3455;
   // $FF: renamed from: up boolean
   private boolean field_3456;
   // $FF: renamed from: uq boolean
   private boolean field_3457;
   // $FF: renamed from: ur com.google.android.gms.analytics.i
   private class_136 field_3458;
   // $FF: renamed from: us long
   private long field_3459;

   class_659(Context var1, class_134 var2) {
      this(var1, var2, (class_135)null, GoogleAnalytics.getInstance(var1));
   }

   class_659(Context var1, class_134 var2, class_135 var3, GoogleAnalytics var4) {
      this.field_3450 = new ConcurrentLinkedQueue();
      this.field_3459 = 300000L;
      this.field_3448 = var3;
      this.mContext = var1;
      this.field_3443 = var2;
      this.field_3449 = var4;
      this.field_3458 = new class_136() {
         public long currentTimeMillis() {
            return System.currentTimeMillis();
         }
      };
      this.field_3451 = 0;
      this.field_3446 = class_659.class_1332.field_4224;
   }

   // $FF: renamed from: a (java.util.Timer) java.util.Timer
   private Timer method_3776(Timer var1) {
      if(var1 != null) {
         var1.cancel();
      }

      return null;
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.s) void
   // $FF: synthetic method
   static void method_3777(class_659 var0) {
      var0.method_3782();
   }

   // $FF: renamed from: bn () void
   private void method_3779() {
      synchronized(this){}

      try {
         if(this.field_3447 != null && this.field_3446 == class_659.class_1332.field_4227) {
            this.field_3446 = class_659.class_1332.field_4223;
            this.field_3447.disconnect();
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: cF () void
   private void method_3781() {
      this.field_3452 = this.method_3776(this.field_3452);
      this.field_3453 = this.method_3776(this.field_3453);
      this.field_3454 = this.method_3776(this.field_3454);
   }

   // $FF: renamed from: cH () void
   private void method_3782() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cI () void
   private void method_3783() {
      this.field_3442.method_705();
      this.field_3444 = false;
   }

   // $FF: renamed from: cJ () void
   private void method_3784() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cK () void
   private void method_3785() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cL () void
   private void method_3786() {
      this.field_3452 = this.method_3776(this.field_3452);
      this.field_3452 = new Timer("Service Reconnect");
      this.field_3452.schedule(new class_659.class_1336(null), 5000L);
   }

   // $FF: renamed from: a (int, android.content.Intent) void
   public void method_865(int var1, Intent var2) {
      synchronized(this){}

      try {
         this.field_3446 = class_659.class_1332.field_4230;
         if(this.field_3451 < 2) {
            class_669.method_3891("Service unavailable (code=" + var1 + "), will retry.");
            this.method_3786();
         } else {
            class_669.method_3891("Service unavailable (code=" + var1 + "), using local store.");
            this.method_3784();
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: b (java.util.Map, long, java.lang.String, java.util.List) void
   public void method_751(Map<String, String> var1, long var2, String var4, List<fe> var5) {
      class_669.method_3890("putHit called");
      this.field_3450.add(new class_659.class_1335(var1, var2, var4, var5));
      this.method_3782();
   }

   // $FF: renamed from: cG () void
   public void method_752() {
      if(this.field_3447 == null) {
         this.field_3447 = new class_641(this.mContext, this, this);
         this.method_3785();
      }
   }

   // $FF: renamed from: cg () void
   public void method_753() {
      class_669.method_3890("clearHits called");
      this.field_3450.clear();
      switch(null.field_4217[this.field_3446.ordinal()]) {
      case 1:
         this.field_3442.method_707(0L);
         this.field_3455 = false;
         return;
      case 2:
         this.field_3447.method_712();
         this.field_3455 = false;
         return;
      default:
         this.field_3455 = true;
      }
   }

   // $FF: renamed from: cl () void
   public void method_754() {
      switch(null.field_4217[this.field_3446.ordinal()]) {
      case 1:
         this.method_3783();
         return;
      default:
         this.field_3444 = true;
      case 2:
      }
   }

   // $FF: renamed from: cn () void
   public void method_755() {
      // $FF: Couldn't be decompiled
   }

   public void onConnected() {
      synchronized(this){}

      try {
         this.field_3453 = this.method_3776(this.field_3453);
         this.field_3451 = 0;
         class_669.method_3890("Connected to service");
         this.field_3446 = class_659.class_1332.field_4227;
         if(this.field_3456) {
            this.method_3779();
            this.field_3456 = false;
         } else {
            this.method_3782();
            this.field_3454 = this.method_3776(this.field_3454);
            this.field_3454 = new Timer("disconnect check");
            this.field_3454.schedule(new class_659.class_1333(null), this.field_3459);
         }
      } finally {
         ;
      }

   }

   public void onDisconnected() {
      synchronized(this){}

      try {
         if(this.field_3446 == class_659.class_1332.field_4223) {
            class_669.method_3890("Disconnected from service");
            this.method_3781();
            this.field_3446 = class_659.class_1332.field_4224;
         } else {
            class_669.method_3890("Unexpected disconnect.");
            this.field_3446 = class_659.class_1332.field_4230;
            if(this.field_3451 < 2) {
               this.method_3786();
            } else {
               this.method_3784();
            }
         }
      } finally {
         ;
      }

   }

   private static enum class_1332 {
      // $FF: renamed from: uA com.google.android.gms.analytics.s$a
      field_4223,
      // $FF: renamed from: uB com.google.android.gms.analytics.s$a
      field_4224,
      // $FF: renamed from: uv com.google.android.gms.analytics.s$a
      field_4226,
      // $FF: renamed from: uw com.google.android.gms.analytics.s$a
      field_4227,
      // $FF: renamed from: ux com.google.android.gms.analytics.s$a
      field_4228,
      // $FF: renamed from: uy com.google.android.gms.analytics.s$a
      field_4229,
      // $FF: renamed from: uz com.google.android.gms.analytics.s$a
      field_4230;

      static {
         class_659.class_1332[] var0 = new class_659.class_1332[]{field_4226, field_4227, field_4228, field_4229, field_4230, field_4223, field_4224};
      }
   }

   private class class_1333 extends TimerTask {
      private class_1333() {
      }

      // $FF: synthetic method
      class_1333(Object var2) {
         this();
      }

      public void run() {
         if(class_659.this.field_3446 == class_659.class_1332.field_4227 && class_659.this.field_3450.isEmpty() && class_659.this.field_3445 + class_659.this.field_3459 < class_659.this.field_3458.currentTimeMillis()) {
            class_669.method_3890("Disconnecting due to inactivity");
            class_659.this.method_3779();
         } else {
            class_659.this.field_3454.schedule(class_659.this.new class_1333(), class_659.this.field_3459);
         }
      }
   }

   private class class_1334 extends TimerTask {
      private class_1334() {
      }

      // $FF: synthetic method
      class_1334(Object var2) {
         this();
      }

      public void run() {
         if(class_659.this.field_3446 == class_659.class_1332.field_4226) {
            class_659.this.method_3784();
         }

      }
   }

   private static class class_1335 {
      // $FF: renamed from: uD java.util.Map
      private final Map<String, String> field_4253;
      // $FF: renamed from: uE long
      private final long field_4254;
      // $FF: renamed from: uF java.lang.String
      private final String field_4255;
      // $FF: renamed from: uG java.util.List
      private final List<fe> field_4256;

      public class_1335(Map<String, String> var1, long var2, String var4, List<fe> var5) {
         this.field_4253 = var1;
         this.field_4254 = var2;
         this.field_4255 = var4;
         this.field_4256 = var5;
      }

      // $FF: renamed from: cM () java.util.Map
      public Map<String, String> method_4492() {
         return this.field_4253;
      }

      // $FF: renamed from: cN () long
      public long method_4493() {
         return this.field_4254;
      }

      // $FF: renamed from: cO () java.util.List
      public List<fe> method_4494() {
         return this.field_4256;
      }

      public String getPath() {
         return this.field_4255;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("PATH: ");
         var1.append(this.field_4255);
         if(this.field_4253 != null) {
            var1.append("  PARAMS: ");
            Iterator var5 = this.field_4253.entrySet().iterator();

            while(var5.hasNext()) {
               Entry var6 = (Entry)var5.next();
               var1.append((String)var6.getKey());
               var1.append("=");
               var1.append((String)var6.getValue());
               var1.append(",  ");
            }
         }

         return var1.toString();
      }
   }

   private class class_1336 extends TimerTask {
      private class_1336() {
      }

      // $FF: synthetic method
      class_1336(Object var2) {
         this();
      }

      public void run() {
         class_659.this.method_3785();
      }
   }
}
