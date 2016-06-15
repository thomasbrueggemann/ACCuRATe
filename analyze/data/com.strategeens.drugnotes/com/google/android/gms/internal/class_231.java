package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.ey;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.bg
@ey
public final class class_231 {
   public static final String DEVICE_ID_EMULATOR = class_367.method_2493("emulator");
   // $FF: renamed from: d java.util.Date
   private final Date field_405;
   // $FF: renamed from: f java.util.Set
   private final Set<String> field_406;
   // $FF: renamed from: h android.location.Location
   private final Location field_407;
   // $FF: renamed from: oA java.lang.String
   private final String field_408;
   // $FF: renamed from: oB com.google.android.gms.ads.search.SearchAdRequest
   private final SearchAdRequest field_409;
   // $FF: renamed from: oC int
   private final int field_410;
   // $FF: renamed from: oD java.util.Set
   private final Set<String> field_411;
   // $FF: renamed from: ov java.lang.String
   private final String field_412;
   // $FF: renamed from: ow int
   private final int field_413;
   // $FF: renamed from: ox boolean
   private final boolean field_414;
   // $FF: renamed from: oy android.os.Bundle
   private final Bundle field_415;
   // $FF: renamed from: oz java.util.Map
   private final Map<Class<? extends NetworkExtras>, NetworkExtras> field_416;

   public class_231(class_231.class_1076 var1) {
      this(var1, (SearchAdRequest)null);
   }

   public class_231(class_231.class_1076 var1, SearchAdRequest var2) {
      this.field_405 = var1.field_559;
      this.field_412 = var1.field_566;
      this.field_413 = var1.field_567;
      this.field_406 = Collections.unmodifiableSet(var1.field_563);
      this.field_407 = var1.field_560;
      this.field_414 = var1.field_568;
      this.field_415 = var1.field_569;
      this.field_416 = Collections.unmodifiableMap(var1.field_564);
      this.field_408 = var1.field_561;
      this.field_409 = var2;
      this.field_410 = var1.field_562;
      this.field_411 = Collections.unmodifiableSet(var1.field_565);
   }

   // $FF: renamed from: bi () com.google.android.gms.ads.search.SearchAdRequest
   public SearchAdRequest method_1581() {
      return this.field_409;
   }

   // $FF: renamed from: bj () java.util.Map
   public Map<Class<? extends NetworkExtras>, NetworkExtras> method_1582() {
      return this.field_416;
   }

   // $FF: renamed from: bk () android.os.Bundle
   public Bundle method_1583() {
      return this.field_415;
   }

   // $FF: renamed from: bl () int
   public int method_1584() {
      return this.field_410;
   }

   public Date getBirthday() {
      return this.field_405;
   }

   public String getContentUrl() {
      return this.field_412;
   }

   public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> var1) {
      Bundle var2 = this.field_415.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
      return var2 != null?var2.getBundle(var1.getClass().getName()):null;
   }

   public int getGender() {
      return this.field_413;
   }

   public Set<String> getKeywords() {
      return this.field_406;
   }

   public Location getLocation() {
      return this.field_407;
   }

   public boolean getManualImpressionsEnabled() {
      return this.field_414;
   }

   @Deprecated
   public <T extends NetworkExtras> T getNetworkExtras(Class<T> var1) {
      return (NetworkExtras)this.field_416.get(var1);
   }

   public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> var1) {
      return this.field_415.getBundle(var1.getName());
   }

   public String getPublisherProvidedId() {
      return this.field_408;
   }

   public boolean isTestDevice(Context var1) {
      return this.field_411.contains(class_367.method_2501(var1));
   }

   public static final class class_1076 {
      // $FF: renamed from: d java.util.Date
      private Date field_559;
      // $FF: renamed from: h android.location.Location
      private Location field_560;
      // $FF: renamed from: oA java.lang.String
      private String field_561;
      // $FF: renamed from: oC int
      private int field_562 = -1;
      // $FF: renamed from: oE java.util.HashSet
      private final HashSet<String> field_563 = new HashSet();
      // $FF: renamed from: oF java.util.HashMap
      private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> field_564 = new HashMap();
      // $FF: renamed from: oG java.util.HashSet
      private final HashSet<String> field_565 = new HashSet();
      // $FF: renamed from: ov java.lang.String
      private String field_566;
      // $FF: renamed from: ow int
      private int field_567 = -1;
      // $FF: renamed from: ox boolean
      private boolean field_568 = false;
      // $FF: renamed from: oy android.os.Bundle
      private final Bundle field_569 = new Bundle();

      // $FF: renamed from: a (android.location.Location) void
      public void method_1720(Location var1) {
         this.field_560 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.ads.mediation.NetworkExtras) void
      @Deprecated
      public void method_1721(NetworkExtras var1) {
         if(var1 instanceof AdMobExtras) {
            this.method_1722(AdMobAdapter.class, ((AdMobExtras)var1).getExtras());
         } else {
            this.field_564.put(var1.getClass(), var1);
         }
      }

      // $FF: renamed from: a (java.lang.Class, android.os.Bundle) void
      public void method_1722(Class<? extends MediationAdapter> var1, Bundle var2) {
         this.field_569.putBundle(var1.getName(), var2);
      }

      // $FF: renamed from: a (java.util.Date) void
      public void method_1723(Date var1) {
         this.field_559 = var1;
      }

      // $FF: renamed from: b (java.lang.Class, android.os.Bundle) void
      public void method_1724(Class<? extends CustomEvent> var1, Bundle var2) {
         if(this.field_569.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.field_569.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
         }

         this.field_569.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(var1.getName(), var2);
      }

      // $FF: renamed from: h (int) void
      public void method_1725(int var1) {
         this.field_567 = var1;
      }

      // $FF: renamed from: i (boolean) void
      public void method_1726(boolean var1) {
         this.field_568 = var1;
      }

      // $FF: renamed from: j (boolean) void
      public void method_1727(boolean var1) {
         byte var2;
         if(var1) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         this.field_562 = var2;
      }

      // $FF: renamed from: r (java.lang.String) void
      public void method_1728(String var1) {
         this.field_563.add(var1);
      }

      // $FF: renamed from: s (java.lang.String) void
      public void method_1729(String var1) {
         this.field_565.add(var1);
      }

      // $FF: renamed from: t (java.lang.String) void
      public void method_1730(String var1) {
         this.field_566 = var1;
      }

      // $FF: renamed from: u (java.lang.String) void
      public void method_1731(String var1) {
         this.field_561 = var1;
      }
   }
}
