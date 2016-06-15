package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.class_168;

public final class SearchAdRequest {
   public static final int BORDER_TYPE_DASHED = 1;
   public static final int BORDER_TYPE_DOTTED = 2;
   public static final int BORDER_TYPE_NONE = 0;
   public static final int BORDER_TYPE_SOLID = 3;
   public static final int CALL_BUTTON_COLOR_DARK = 2;
   public static final int CALL_BUTTON_COLOR_LIGHT = 0;
   public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
   public static final String DEVICE_ID_EMULATOR;
   public static final int ERROR_CODE_INTERNAL_ERROR = 0;
   public static final int ERROR_CODE_INVALID_REQUEST = 1;
   public static final int ERROR_CODE_NETWORK_ERROR = 2;
   public static final int ERROR_CODE_NO_FILL = 3;
   // $FF: renamed from: kq com.google.android.gms.internal.au
   private final class_168 field_2058;
   // $FF: renamed from: sZ int
   private final int field_2059;
   // $FF: renamed from: ta int
   private final int field_2060;
   // $FF: renamed from: tb int
   private final int field_2061;
   // $FF: renamed from: tc int
   private final int field_2062;
   // $FF: renamed from: td int
   private final int field_2063;
   // $FF: renamed from: te int
   private final int field_2064;
   // $FF: renamed from: tf int
   private final int field_2065;
   // $FF: renamed from: tg int
   private final int field_2066;
   // $FF: renamed from: th java.lang.String
   private final String field_2067;
   // $FF: renamed from: ti int
   private final int field_2068;
   // $FF: renamed from: tj java.lang.String
   private final String field_2069;
   // $FF: renamed from: tk int
   private final int field_2070;
   // $FF: renamed from: tl int
   private final int field_2071;
   // $FF: renamed from: tm java.lang.String
   private final String field_2072;

   static {
      DEVICE_ID_EMULATOR = class_168.DEVICE_ID_EMULATOR;
   }

   private SearchAdRequest(SearchAdRequest.Builder var1) {
      this.field_2059 = var1.field_3956;
      this.field_2060 = var1.field_3957;
      this.field_2061 = var1.field_3958;
      this.field_2062 = var1.field_3959;
      this.field_2063 = var1.field_3960;
      this.field_2064 = var1.field_3961;
      this.field_2065 = var1.field_3962;
      this.field_2066 = var1.field_3963;
      this.field_2067 = var1.field_3964;
      this.field_2068 = var1.field_3965;
      this.field_2069 = var1.field_3966;
      this.field_2070 = var1.field_3967;
      this.field_2071 = var1.field_3968;
      this.field_2072 = var1.field_3969;
      this.field_2058 = new class_168(var1.field_3955, this);
   }

   // $FF: synthetic method
   SearchAdRequest(SearchAdRequest.Builder var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: O () com.google.android.gms.internal.au
   class_168 method_2684() {
      return this.field_2058;
   }

   public int getAnchorTextColor() {
      return this.field_2059;
   }

   public int getBackgroundColor() {
      return this.field_2060;
   }

   public int getBackgroundGradientBottom() {
      return this.field_2061;
   }

   public int getBackgroundGradientTop() {
      return this.field_2062;
   }

   public int getBorderColor() {
      return this.field_2063;
   }

   public int getBorderThickness() {
      return this.field_2064;
   }

   public int getBorderType() {
      return this.field_2065;
   }

   public int getCallButtonColor() {
      return this.field_2066;
   }

   public String getCustomChannels() {
      return this.field_2067;
   }

   public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> var1) {
      return this.field_2058.getCustomEventExtrasBundle(var1);
   }

   public int getDescriptionTextColor() {
      return this.field_2068;
   }

   public String getFontFace() {
      return this.field_2069;
   }

   public int getHeaderTextColor() {
      return this.field_2070;
   }

   public int getHeaderTextSize() {
      return this.field_2071;
   }

   public Location getLocation() {
      return this.field_2058.getLocation();
   }

   @Deprecated
   public <T extends NetworkExtras> T getNetworkExtras(Class<T> var1) {
      return this.field_2058.getNetworkExtras(var1);
   }

   public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> var1) {
      return this.field_2058.getNetworkExtrasBundle(var1);
   }

   public String getQuery() {
      return this.field_2072;
   }

   public boolean isTestDevice(Context var1) {
      return this.field_2058.isTestDevice(var1);
   }

   public static final class Builder {
      // $FF: renamed from: kr com.google.android.gms.internal.au$a
      private final class_168.class_982 field_3955 = new class_168.class_982();
      // $FF: renamed from: sZ int
      private int field_3956;
      // $FF: renamed from: ta int
      private int field_3957;
      // $FF: renamed from: tb int
      private int field_3958;
      // $FF: renamed from: tc int
      private int field_3959;
      // $FF: renamed from: td int
      private int field_3960;
      // $FF: renamed from: te int
      private int field_3961;
      // $FF: renamed from: tf int
      private int field_3962 = 0;
      // $FF: renamed from: tg int
      private int field_3963;
      // $FF: renamed from: th java.lang.String
      private String field_3964;
      // $FF: renamed from: ti int
      private int field_3965;
      // $FF: renamed from: tj java.lang.String
      private String field_3966;
      // $FF: renamed from: tk int
      private int field_3967;
      // $FF: renamed from: tl int
      private int field_3968;
      // $FF: renamed from: tm java.lang.String
      private String field_3969;

      public SearchAdRequest.Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> var1, Bundle var2) {
         this.field_3955.method_2772(var1, var2);
         return this;
      }

      public SearchAdRequest.Builder addNetworkExtras(NetworkExtras var1) {
         this.field_3955.method_2769(var1);
         return this;
      }

      public SearchAdRequest.Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> var1, Bundle var2) {
         this.field_3955.method_2770(var1, var2);
         return this;
      }

      public SearchAdRequest.Builder addTestDevice(String var1) {
         this.field_3955.method_2776(var1);
         return this;
      }

      public SearchAdRequest build() {
         return new SearchAdRequest(this);
      }

      public SearchAdRequest.Builder setAnchorTextColor(int var1) {
         this.field_3956 = var1;
         return this;
      }

      public SearchAdRequest.Builder setBackgroundColor(int var1) {
         this.field_3957 = var1;
         this.field_3958 = Color.argb(0, 0, 0, 0);
         this.field_3959 = Color.argb(0, 0, 0, 0);
         return this;
      }

      public SearchAdRequest.Builder setBackgroundGradient(int var1, int var2) {
         this.field_3957 = Color.argb(0, 0, 0, 0);
         this.field_3958 = var2;
         this.field_3959 = var1;
         return this;
      }

      public SearchAdRequest.Builder setBorderColor(int var1) {
         this.field_3960 = var1;
         return this;
      }

      public SearchAdRequest.Builder setBorderThickness(int var1) {
         this.field_3961 = var1;
         return this;
      }

      public SearchAdRequest.Builder setBorderType(int var1) {
         this.field_3962 = var1;
         return this;
      }

      public SearchAdRequest.Builder setCallButtonColor(int var1) {
         this.field_3963 = var1;
         return this;
      }

      public SearchAdRequest.Builder setCustomChannels(String var1) {
         this.field_3964 = var1;
         return this;
      }

      public SearchAdRequest.Builder setDescriptionTextColor(int var1) {
         this.field_3965 = var1;
         return this;
      }

      public SearchAdRequest.Builder setFontFace(String var1) {
         this.field_3966 = var1;
         return this;
      }

      public SearchAdRequest.Builder setHeaderTextColor(int var1) {
         this.field_3967 = var1;
         return this;
      }

      public SearchAdRequest.Builder setHeaderTextSize(int var1) {
         this.field_3968 = var1;
         return this;
      }

      public SearchAdRequest.Builder setLocation(Location var1) {
         this.field_3955.method_2768(var1);
         return this;
      }

      public SearchAdRequest.Builder setQuery(String var1) {
         this.field_3969 = var1;
         return this;
      }

      public SearchAdRequest.Builder tagForChildDirectedTreatment(boolean var1) {
         this.field_3955.method_2777(var1);
         return this;
      }
   }
}
