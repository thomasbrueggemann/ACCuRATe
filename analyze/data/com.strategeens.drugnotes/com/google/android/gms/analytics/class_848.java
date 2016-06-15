package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.class_169;
import com.google.android.gms.analytics.class_170;
import com.google.android.gms.analytics.class_175;
import com.google.android.gms.analytics.class_179;
import com.google.android.gms.analytics.class_835;
import com.google.android.gms.analytics.class_863;
import com.google.android.gms.internal.class_141;
import com.google.android.gms.internal.class_720;
import com.google.android.gms.internal.ha;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedQueue;

// $FF: renamed from: com.google.android.gms.analytics.w
class class_848 implements class_179, class_835.class_1312, class_835.class_1313 {
   private final Context mContext;
   // $FF: renamed from: wb com.google.android.gms.internal.ld
   private class_141 field_3526;
   // $FF: renamed from: yU com.google.android.gms.analytics.d
   private class_170 field_3527;
   // $FF: renamed from: yV com.google.android.gms.analytics.f
   private final class_169 field_3528;
   // $FF: renamed from: yX boolean
   private boolean field_3529;
   // $FF: renamed from: zh long
   private volatile long field_3530;
   // $FF: renamed from: zi com.google.android.gms.analytics.w$a
   private volatile class_848.class_1192 field_3531;
   // $FF: renamed from: zj com.google.android.gms.analytics.b
   private volatile class_175 field_3532;
   // $FF: renamed from: zk com.google.android.gms.analytics.d
   private class_170 field_3533;
   // $FF: renamed from: zl com.google.android.gms.analytics.GoogleAnalytics
   private final GoogleAnalytics field_3534;
   // $FF: renamed from: zm java.util.Queue
   private final Queue<class_848.class_1195> field_3535;
   // $FF: renamed from: zn int
   private volatile int field_3536;
   // $FF: renamed from: zo java.util.Timer
   private volatile Timer field_3537;
   // $FF: renamed from: zp java.util.Timer
   private volatile Timer field_3538;
   // $FF: renamed from: zq java.util.Timer
   private volatile Timer field_3539;
   // $FF: renamed from: zr boolean
   private boolean field_3540;
   // $FF: renamed from: zs boolean
   private boolean field_3541;
   // $FF: renamed from: zt boolean
   private boolean field_3542;
   // $FF: renamed from: zu long
   private long field_3543;

   class_848(Context var1, class_169 var2) {
      this(var1, var2, (class_170)null, GoogleAnalytics.getInstance(var1));
   }

   class_848(Context var1, class_169 var2, class_170 var3, GoogleAnalytics var4) {
      this.field_3535 = new ConcurrentLinkedQueue();
      this.field_3543 = 300000L;
      this.field_3533 = var3;
      this.mContext = var1;
      this.field_3528 = var2;
      this.field_3534 = var4;
      this.field_3526 = class_720.method_4198();
      this.field_3536 = 0;
      this.field_3531 = class_848.class_1192.field_1785;
   }

   // $FF: renamed from: a (java.util.Timer) java.util.Timer
   private Timer method_4687(Timer var1) {
      if(var1 != null) {
         var1.cancel();
      }

      return null;
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.w) void
   // $FF: synthetic method
   static void method_4688(class_848 var0) {
      var0.method_4695();
   }

   // $FF: renamed from: cJ () void
   private void method_4691() {
      synchronized(this){}

      try {
         if(this.field_3532 != null && this.field_3531 == class_848.class_1192.field_1788) {
            this.field_3531 = class_848.class_1192.field_1784;
            this.field_3532.disconnect();
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: eA () void
   private void method_4694() {
      this.field_3537 = this.method_4687(this.field_3537);
      this.field_3538 = this.method_4687(this.field_3538);
      this.field_3539 = this.method_4687(this.field_3539);
   }

   // $FF: renamed from: eC () void
   private void method_4695() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: eD () void
   private void method_4696() {
      this.field_3527.dispatch();
      this.field_3529 = false;
   }

   // $FF: renamed from: eE () void
   private void method_4697() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: eF () void
   private void method_4698() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: eG () void
   private void method_4699() {
      this.field_3537 = this.method_4687(this.field_3537);
      this.field_3537 = new Timer("Service Reconnect");
      this.field_3537.schedule(new class_848.class_1196(null), 5000L);
   }

   // $FF: renamed from: a (int, android.content.Intent) void
   public void method_1062(int var1, Intent var2) {
      synchronized(this){}

      try {
         this.field_3531 = class_848.class_1192.field_1783;
         if(this.field_3536 < 2) {
            class_863.method_4842("Service unavailable (code=" + var1 + "), will retry.");
            this.method_4699();
         } else {
            class_863.method_4842("Service unavailable (code=" + var1 + "), using local store.");
            this.method_4697();
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: b (java.util.Map, long, java.lang.String, java.util.List) void
   public void method_891(Map<String, String> var1, long var2, String var4, List<ha> var5) {
      class_863.method_4841("putHit called");
      this.field_3535.add(new class_848.class_1195(var1, var2, var4, var5));
      this.method_4695();
   }

   // $FF: renamed from: dQ () void
   public void method_892() {
      class_863.method_4841("clearHits called");
      this.field_3535.clear();
      switch(null.field_1144[this.field_3531.ordinal()]) {
      case 1:
         this.field_3527.method_852(0L);
         this.field_3540 = false;
         return;
      case 2:
         this.field_3532.method_867();
         this.field_3540 = false;
         return;
      default:
         this.field_3540 = true;
      }
   }

   // $FF: renamed from: dW () void
   public void method_893() {
      // $FF: Couldn't be decompiled
   }

   public void dispatch() {
      switch(null.field_1144[this.field_3531.ordinal()]) {
      case 1:
         this.method_4696();
         return;
      default:
         this.field_3529 = true;
      case 2:
      }
   }

   // $FF: renamed from: eB () void
   public void method_894() {
      if(this.field_3532 == null) {
         this.field_3532 = new class_835(this.mContext, this, this);
         this.method_4698();
      }
   }

   public void onConnected() {
      synchronized(this){}

      try {
         this.field_3538 = this.method_4687(this.field_3538);
         this.field_3536 = 0;
         class_863.method_4841("Connected to service");
         this.field_3531 = class_848.class_1192.field_1788;
         if(this.field_3541) {
            this.method_4691();
            this.field_3541 = false;
         } else {
            this.method_4695();
            this.field_3539 = this.method_4687(this.field_3539);
            this.field_3539 = new Timer("disconnect check");
            this.field_3539.schedule(new class_848.class_1190(null), this.field_3543);
         }
      } finally {
         ;
      }

   }

   public void onDisconnected() {
      synchronized(this){}

      try {
         if(this.field_3531 == class_848.class_1192.field_1782) {
            class_863.method_4841("Service blocked.");
            this.method_4694();
         } else if(this.field_3531 == class_848.class_1192.field_1784) {
            class_863.method_4841("Disconnected from service");
            this.method_4694();
            this.field_3531 = class_848.class_1192.field_1785;
         } else {
            class_863.method_4841("Unexpected disconnect.");
            this.field_3531 = class_848.class_1192.field_1783;
            if(this.field_3536 < 2) {
               this.method_4699();
            } else {
               this.method_4697();
            }
         }
      } finally {
         ;
      }

   }

   private static enum class_1192 {
      // $FF: renamed from: zA com.google.android.gms.analytics.w$a
      field_1782,
      // $FF: renamed from: zB com.google.android.gms.analytics.w$a
      field_1783,
      // $FF: renamed from: zC com.google.android.gms.analytics.w$a
      field_1784,
      // $FF: renamed from: zD com.google.android.gms.analytics.w$a
      field_1785,
      // $FF: renamed from: zx com.google.android.gms.analytics.w$a
      field_1787,
      // $FF: renamed from: zy com.google.android.gms.analytics.w$a
      field_1788,
      // $FF: renamed from: zz com.google.android.gms.analytics.w$a
      field_1789;

      static {
         class_848.class_1192[] var0 = new class_848.class_1192[]{field_1787, field_1788, field_1789, field_1782, field_1783, field_1784, field_1785};
      }
   }

   private class class_1190 extends TimerTask {
      private class_1190() {
      }

      // $FF: synthetic method
      class_1190(Object var2) {
         this();
      }

      public void run() {
         if(class_848.this.field_3531 == class_848.class_1192.field_1788 && class_848.this.field_3535.isEmpty() && class_848.this.field_3530 + class_848.this.field_3543 < class_848.this.field_3526.elapsedRealtime()) {
            class_863.method_4841("Disconnecting due to inactivity");
            class_848.this.method_4691();
         } else {
            class_848.this.field_3539.schedule(class_848.this.new class_1190(), class_848.this.field_3543);
         }
      }
   }

   private class class_1191 extends TimerTask {
      private class_1191() {
      }

      // $FF: synthetic method
      class_1191(Object var2) {
         this();
      }

      public void run() {
         if(class_848.this.field_3531 == class_848.class_1192.field_1787) {
            class_848.this.method_4697();
         }

      }
   }

   private static class class_1195 {
      // $FF: renamed from: zF java.util.Map
      private final Map<String, String> field_1790;
      // $FF: renamed from: zG long
      private final long field_1791;
      // $FF: renamed from: zH java.lang.String
      private final String field_1792;
      // $FF: renamed from: zI java.util.List
      private final List<ha> field_1793;

      public class_1195(Map<String, String> var1, long var2, String var4, List<ha> var5) {
         this.field_1790 = var1;
         this.field_1791 = var2;
         this.field_1792 = var4;
         this.field_1793 = var5;
      }

      // $FF: renamed from: eH () java.util.Map
      public Map<String, String> method_3068() {
         return this.field_1790;
      }

      // $FF: renamed from: eI () long
      public long method_3069() {
         return this.field_1791;
      }

      // $FF: renamed from: eJ () java.util.List
      public List<ha> method_3070() {
         return this.field_1793;
      }

      public String getPath() {
         return this.field_1792;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("PATH: ");
         var1.append(this.field_1792);
         if(this.field_1790 != null) {
            var1.append("  PARAMS: ");
            Iterator var5 = this.field_1790.entrySet().iterator();

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

   private class class_1196 extends TimerTask {
      private class_1196() {
      }

      // $FF: synthetic method
      class_1196(Object var2) {
         this();
      }

      public void run() {
         class_848.this.method_4698();
      }
   }
}
