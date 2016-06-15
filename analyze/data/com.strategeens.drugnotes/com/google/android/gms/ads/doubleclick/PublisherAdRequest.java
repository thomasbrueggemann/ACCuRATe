package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.class_231;
import com.google.android.gms.internal.class_335;
import java.util.Date;
import java.util.Set;

public final class PublisherAdRequest {
   public static final String DEVICE_ID_EMULATOR;
   public static final int ERROR_CODE_INTERNAL_ERROR = 0;
   public static final int ERROR_CODE_INVALID_REQUEST = 1;
   public static final int ERROR_CODE_NETWORK_ERROR = 2;
   public static final int ERROR_CODE_NO_FILL = 3;
   public static final int GENDER_FEMALE = 2;
   public static final int GENDER_MALE = 1;
   public static final int GENDER_UNKNOWN;
   // $FF: renamed from: lg com.google.android.gms.internal.bg
   private final class_231 field_3953;

   static {
      DEVICE_ID_EMULATOR = class_231.DEVICE_ID_EMULATOR;
   }

   private PublisherAdRequest(PublisherAdRequest.Builder var1) {
      this.field_3953 = new class_231(var1.field_4112);
   }

   // $FF: synthetic method
   PublisherAdRequest(PublisherAdRequest.Builder var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: Y () com.google.android.gms.internal.bg
   public class_231 method_5211() {
      return this.field_3953;
   }

   public Date getBirthday() {
      return this.field_3953.getBirthday();
   }

   public String getContentUrl() {
      return this.field_3953.getContentUrl();
   }

   public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> var1) {
      return this.field_3953.getCustomEventExtrasBundle(var1);
   }

   public int getGender() {
      return this.field_3953.getGender();
   }

   public Set<String> getKeywords() {
      return this.field_3953.getKeywords();
   }

   public Location getLocation() {
      return this.field_3953.getLocation();
   }

   public boolean getManualImpressionsEnabled() {
      return this.field_3953.getManualImpressionsEnabled();
   }

   @Deprecated
   public <T extends NetworkExtras> T getNetworkExtras(Class<T> var1) {
      return this.field_3953.getNetworkExtras(var1);
   }

   public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> var1) {
      return this.field_3953.getNetworkExtrasBundle(var1);
   }

   public String getPublisherProvidedId() {
      return this.field_3953.getPublisherProvidedId();
   }

   public boolean isTestDevice(Context var1) {
      return this.field_3953.isTestDevice(var1);
   }

   public static final class Builder {
      // $FF: renamed from: lh com.google.android.gms.internal.bg$a
      private final class_231.class_1076 field_4112 = new class_231.class_1076();

      public PublisherAdRequest.Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> var1, Bundle var2) {
         this.field_4112.method_1724(var1, var2);
         return this;
      }

      public PublisherAdRequest.Builder addKeyword(String var1) {
         this.field_4112.method_1728(var1);
         return this;
      }

      public PublisherAdRequest.Builder addNetworkExtras(NetworkExtras var1) {
         this.field_4112.method_1721(var1);
         return this;
      }

      public PublisherAdRequest.Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> var1, Bundle var2) {
         this.field_4112.method_1722(var1, var2);
         return this;
      }

      public PublisherAdRequest.Builder addTestDevice(String var1) {
         this.field_4112.method_1729(var1);
         return this;
      }

      public PublisherAdRequest build() {
         return new PublisherAdRequest(this);
      }

      public PublisherAdRequest.Builder setBirthday(Date var1) {
         this.field_4112.method_1723(var1);
         return this;
      }

      public PublisherAdRequest.Builder setContentUrl(String var1) {
         class_335.method_2306(var1, "Content URL must be non-null.");
         class_335.method_2307(var1, "Content URL must be non-empty.");
         boolean var4;
         if(var1.length() <= 512) {
            var4 = true;
         } else {
            var4 = false;
         }

         Object[] var5 = new Object[]{Integer.valueOf(512), Integer.valueOf(var1.length())};
         class_335.method_2309(var4, "Content URL must not exceed %d in length.  Provided length was %d.", var5);
         this.field_4112.method_1730(var1);
         return this;
      }

      public PublisherAdRequest.Builder setGender(int var1) {
         this.field_4112.method_1725(var1);
         return this;
      }

      public PublisherAdRequest.Builder setLocation(Location var1) {
         this.field_4112.method_1720(var1);
         return this;
      }

      public PublisherAdRequest.Builder setManualImpressionsEnabled(boolean var1) {
         this.field_4112.method_1726(var1);
         return this;
      }

      public PublisherAdRequest.Builder setPublisherProvidedId(String var1) {
         this.field_4112.method_1731(var1);
         return this;
      }

      public PublisherAdRequest.Builder tagForChildDirectedTreatment(boolean var1) {
         this.field_4112.method_1727(var1);
         return this;
      }
   }
}
