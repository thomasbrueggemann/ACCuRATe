package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.class_231;

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
   // $FF: renamed from: lg com.google.android.gms.internal.bg
   private final class_231 field_1729;
   // $FF: renamed from: xA int
   private final int field_1730;
   // $FF: renamed from: xB int
   private final int field_1731;
   // $FF: renamed from: xC int
   private final int field_1732;
   // $FF: renamed from: xD int
   private final int field_1733;
   // $FF: renamed from: xE int
   private final int field_1734;
   // $FF: renamed from: xF int
   private final int field_1735;
   // $FF: renamed from: xG int
   private final int field_1736;
   // $FF: renamed from: xH int
   private final int field_1737;
   // $FF: renamed from: xI java.lang.String
   private final String field_1738;
   // $FF: renamed from: xJ int
   private final int field_1739;
   // $FF: renamed from: xK java.lang.String
   private final String field_1740;
   // $FF: renamed from: xL int
   private final int field_1741;
   // $FF: renamed from: xM int
   private final int field_1742;
   // $FF: renamed from: xN java.lang.String
   private final String field_1743;

   static {
      DEVICE_ID_EMULATOR = class_231.DEVICE_ID_EMULATOR;
   }

   private SearchAdRequest(SearchAdRequest.Builder var1) {
      this.field_1730 = var1.field_4049;
      this.field_1731 = var1.field_4050;
      this.field_1732 = var1.field_4051;
      this.field_1733 = var1.field_4052;
      this.field_1734 = var1.field_4053;
      this.field_1735 = var1.field_4054;
      this.field_1736 = var1.field_4055;
      this.field_1737 = var1.field_4056;
      this.field_1738 = var1.field_4057;
      this.field_1739 = var1.field_4058;
      this.field_1740 = var1.field_4059;
      this.field_1741 = var1.field_4060;
      this.field_1742 = var1.field_4061;
      this.field_1743 = var1.field_4062;
      this.field_1729 = new class_231(var1.field_4048, this);
   }

   // $FF: synthetic method
   SearchAdRequest(SearchAdRequest.Builder var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: Y () com.google.android.gms.internal.bg
   class_231 method_3043() {
      return this.field_1729;
   }

   public int getAnchorTextColor() {
      return this.field_1730;
   }

   public int getBackgroundColor() {
      return this.field_1731;
   }

   public int getBackgroundGradientBottom() {
      return this.field_1732;
   }

   public int getBackgroundGradientTop() {
      return this.field_1733;
   }

   public int getBorderColor() {
      return this.field_1734;
   }

   public int getBorderThickness() {
      return this.field_1735;
   }

   public int getBorderType() {
      return this.field_1736;
   }

   public int getCallButtonColor() {
      return this.field_1737;
   }

   public String getCustomChannels() {
      return this.field_1738;
   }

   public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> var1) {
      return this.field_1729.getCustomEventExtrasBundle(var1);
   }

   public int getDescriptionTextColor() {
      return this.field_1739;
   }

   public String getFontFace() {
      return this.field_1740;
   }

   public int getHeaderTextColor() {
      return this.field_1741;
   }

   public int getHeaderTextSize() {
      return this.field_1742;
   }

   public Location getLocation() {
      return this.field_1729.getLocation();
   }

   @Deprecated
   public <T extends NetworkExtras> T getNetworkExtras(Class<T> var1) {
      return this.field_1729.getNetworkExtras(var1);
   }

   public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> var1) {
      return this.field_1729.getNetworkExtrasBundle(var1);
   }

   public String getQuery() {
      return this.field_1743;
   }

   public boolean isTestDevice(Context var1) {
      return this.field_1729.isTestDevice(var1);
   }

   public static final class Builder {
      // $FF: renamed from: lh com.google.android.gms.internal.bg$a
      private final class_231.class_1076 field_4048 = new class_231.class_1076();
      // $FF: renamed from: xA int
      private int field_4049;
      // $FF: renamed from: xB int
      private int field_4050;
      // $FF: renamed from: xC int
      private int field_4051;
      // $FF: renamed from: xD int
      private int field_4052;
      // $FF: renamed from: xE int
      private int field_4053;
      // $FF: renamed from: xF int
      private int field_4054;
      // $FF: renamed from: xG int
      private int field_4055 = 0;
      // $FF: renamed from: xH int
      private int field_4056;
      // $FF: renamed from: xI java.lang.String
      private String field_4057;
      // $FF: renamed from: xJ int
      private int field_4058;
      // $FF: renamed from: xK java.lang.String
      private String field_4059;
      // $FF: renamed from: xL int
      private int field_4060;
      // $FF: renamed from: xM int
      private int field_4061;
      // $FF: renamed from: xN java.lang.String
      private String field_4062;

      public SearchAdRequest.Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> var1, Bundle var2) {
         this.field_4048.method_1724(var1, var2);
         return this;
      }

      public SearchAdRequest.Builder addNetworkExtras(NetworkExtras var1) {
         this.field_4048.method_1721(var1);
         return this;
      }

      public SearchAdRequest.Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> var1, Bundle var2) {
         this.field_4048.method_1722(var1, var2);
         return this;
      }

      public SearchAdRequest.Builder addTestDevice(String var1) {
         this.field_4048.method_1729(var1);
         return this;
      }

      public SearchAdRequest build() {
         return new SearchAdRequest(this);
      }

      public SearchAdRequest.Builder setAnchorTextColor(int var1) {
         this.field_4049 = var1;
         return this;
      }

      public SearchAdRequest.Builder setBackgroundColor(int var1) {
         this.field_4050 = var1;
         this.field_4051 = Color.argb(0, 0, 0, 0);
         this.field_4052 = Color.argb(0, 0, 0, 0);
         return this;
      }

      public SearchAdRequest.Builder setBackgroundGradient(int var1, int var2) {
         this.field_4050 = Color.argb(0, 0, 0, 0);
         this.field_4051 = var2;
         this.field_4052 = var1;
         return this;
      }

      public SearchAdRequest.Builder setBorderColor(int var1) {
         this.field_4053 = var1;
         return this;
      }

      public SearchAdRequest.Builder setBorderThickness(int var1) {
         this.field_4054 = var1;
         return this;
      }

      public SearchAdRequest.Builder setBorderType(int var1) {
         this.field_4055 = var1;
         return this;
      }

      public SearchAdRequest.Builder setCallButtonColor(int var1) {
         this.field_4056 = var1;
         return this;
      }

      public SearchAdRequest.Builder setCustomChannels(String var1) {
         this.field_4057 = var1;
         return this;
      }

      public SearchAdRequest.Builder setDescriptionTextColor(int var1) {
         this.field_4058 = var1;
         return this;
      }

      public SearchAdRequest.Builder setFontFace(String var1) {
         this.field_4059 = var1;
         return this;
      }

      public SearchAdRequest.Builder setHeaderTextColor(int var1) {
         this.field_4060 = var1;
         return this;
      }

      public SearchAdRequest.Builder setHeaderTextSize(int var1) {
         this.field_4061 = var1;
         return this;
      }

      public SearchAdRequest.Builder setLocation(Location var1) {
         this.field_4048.method_1720(var1);
         return this;
      }

      public SearchAdRequest.Builder setQuery(String var1) {
         this.field_4062 = var1;
         return this;
      }

      public SearchAdRequest.Builder tagForChildDirectedTreatment(boolean var1) {
         this.field_4048.method_1727(var1);
         return this;
      }
   }
}
