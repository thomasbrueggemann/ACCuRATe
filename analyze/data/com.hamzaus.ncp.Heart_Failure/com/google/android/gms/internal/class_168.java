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
import com.google.android.gms.internal.class_371;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.au
public final class class_168 {
   public static final String DEVICE_ID_EMULATOR = class_371.method_2372("emulator");
   // $FF: renamed from: d java.util.Date
   private final Date field_543;
   // $FF: renamed from: f java.util.Set
   private final Set<String> field_544;
   // $FF: renamed from: h android.location.Location
   private final Location field_545;
   // $FF: renamed from: mi java.lang.String
   private final String field_546;
   // $FF: renamed from: mj int
   private final int field_547;
   // $FF: renamed from: mk boolean
   private final boolean field_548;
   // $FF: renamed from: ml android.os.Bundle
   private final Bundle field_549;
   // $FF: renamed from: mm java.util.Map
   private final Map<Class<? extends NetworkExtras>, NetworkExtras> field_550;
   // $FF: renamed from: mn java.lang.String
   private final String field_551;
   // $FF: renamed from: mo com.google.android.gms.ads.search.SearchAdRequest
   private final SearchAdRequest field_552;
   // $FF: renamed from: mp int
   private final int field_553;
   // $FF: renamed from: mq java.util.Set
   private final Set<String> field_554;

   public class_168(class_168.class_982 var1) {
      this(var1, (SearchAdRequest)null);
   }

   public class_168(class_168.class_982 var1, SearchAdRequest var2) {
      this.field_543 = var1.field_2693;
      this.field_546 = var1.field_2695;
      this.field_547 = var1.field_2696;
      this.field_544 = Collections.unmodifiableSet(var1.field_2701);
      this.field_545 = var1.field_2694;
      this.field_548 = var1.field_2697;
      this.field_549 = var1.field_2698;
      this.field_550 = Collections.unmodifiableMap(var1.field_2702);
      this.field_551 = var1.field_2699;
      this.field_552 = var2;
      this.field_553 = var1.field_2700;
      this.field_554 = Collections.unmodifiableSet(var1.field_2703);
   }

   // $FF: renamed from: aC () com.google.android.gms.ads.search.SearchAdRequest
   public SearchAdRequest method_1253() {
      return this.field_552;
   }

   // $FF: renamed from: aD () java.util.Map
   public Map<Class<? extends NetworkExtras>, NetworkExtras> method_1254() {
      return this.field_550;
   }

   // $FF: renamed from: aE () android.os.Bundle
   public Bundle method_1255() {
      return this.field_549;
   }

   // $FF: renamed from: aF () int
   public int method_1256() {
      return this.field_553;
   }

   public Date getBirthday() {
      return this.field_543;
   }

   public String getContentUrl() {
      return this.field_546;
   }

   public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> var1) {
      Bundle var2 = this.field_549.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
      return var2 != null?var2.getBundle(var1.getClass().getName()):null;
   }

   public int getGender() {
      return this.field_547;
   }

   public Set<String> getKeywords() {
      return this.field_544;
   }

   public Location getLocation() {
      return this.field_545;
   }

   public boolean getManualImpressionsEnabled() {
      return this.field_548;
   }

   @Deprecated
   public <T extends NetworkExtras> T getNetworkExtras(Class<T> var1) {
      return (NetworkExtras)this.field_550.get(var1);
   }

   public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> var1) {
      return this.field_549.getBundle(var1.getName());
   }

   public String getPublisherProvidedId() {
      return this.field_551;
   }

   public boolean isTestDevice(Context var1) {
      return this.field_554.contains(class_371.method_2371(var1));
   }

   public static final class class_982 {
      // $FF: renamed from: d java.util.Date
      private Date field_2693;
      // $FF: renamed from: h android.location.Location
      private Location field_2694;
      // $FF: renamed from: mi java.lang.String
      private String field_2695;
      // $FF: renamed from: mj int
      private int field_2696 = -1;
      // $FF: renamed from: mk boolean
      private boolean field_2697 = false;
      // $FF: renamed from: ml android.os.Bundle
      private final Bundle field_2698 = new Bundle();
      // $FF: renamed from: mn java.lang.String
      private String field_2699;
      // $FF: renamed from: mp int
      private int field_2700 = -1;
      // $FF: renamed from: mr java.util.HashSet
      private final HashSet<String> field_2701 = new HashSet();
      // $FF: renamed from: ms java.util.HashMap
      private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> field_2702 = new HashMap();
      // $FF: renamed from: mt java.util.HashSet
      private final HashSet<String> field_2703 = new HashSet();

      // $FF: renamed from: a (android.location.Location) void
      public void method_2768(Location var1) {
         this.field_2694 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.ads.mediation.NetworkExtras) void
      @Deprecated
      public void method_2769(NetworkExtras var1) {
         if(var1 instanceof AdMobExtras) {
            this.method_2770(AdMobAdapter.class, ((AdMobExtras)var1).getExtras());
         } else {
            this.field_2702.put(var1.getClass(), var1);
         }
      }

      // $FF: renamed from: a (java.lang.Class, android.os.Bundle) void
      public void method_2770(Class<? extends MediationAdapter> var1, Bundle var2) {
         this.field_2698.putBundle(var1.getName(), var2);
      }

      // $FF: renamed from: a (java.util.Date) void
      public void method_2771(Date var1) {
         this.field_2693 = var1;
      }

      // $FF: renamed from: b (java.lang.Class, android.os.Bundle) void
      public void method_2772(Class<? extends CustomEvent> var1, Bundle var2) {
         if(this.field_2698.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.field_2698.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
         }

         this.field_2698.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(var1.getName(), var2);
      }

      // $FF: renamed from: e (int) void
      public void method_2773(int var1) {
         this.field_2696 = var1;
      }

      // $FF: renamed from: g (java.lang.String) void
      public void method_2774(String var1) {
         this.field_2701.add(var1);
      }

      // $FF: renamed from: g (boolean) void
      public void method_2775(boolean var1) {
         this.field_2697 = var1;
      }

      // $FF: renamed from: h (java.lang.String) void
      public void method_2776(String var1) {
         this.field_2703.add(var1);
      }

      // $FF: renamed from: h (boolean) void
      public void method_2777(boolean var1) {
         byte var2;
         if(var1) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         this.field_2700 = var2;
      }

      // $FF: renamed from: i (java.lang.String) void
      public void method_2778(String var1) {
         this.field_2695 = var1;
      }

      // $FF: renamed from: j (java.lang.String) void
      public void method_2779(String var1) {
         this.field_2699 = var1;
      }
   }
}
