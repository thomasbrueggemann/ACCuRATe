package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.class_168;
import com.google.android.gms.internal.class_347;
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
   // $FF: renamed from: kq com.google.android.gms.internal.au
   private final class_168 field_3870;

   static {
      DEVICE_ID_EMULATOR = class_168.DEVICE_ID_EMULATOR;
   }

   private PublisherAdRequest(PublisherAdRequest.Builder var1) {
      this.field_3870 = new class_168(var1.field_4003);
   }

   // $FF: synthetic method
   PublisherAdRequest(PublisherAdRequest.Builder var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: O () com.google.android.gms.internal.au
   class_168 method_4100() {
      return this.field_3870;
   }

   public Date getBirthday() {
      return this.field_3870.getBirthday();
   }

   public String getContentUrl() {
      return this.field_3870.getContentUrl();
   }

   public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> var1) {
      return this.field_3870.getCustomEventExtrasBundle(var1);
   }

   public int getGender() {
      return this.field_3870.getGender();
   }

   public Set<String> getKeywords() {
      return this.field_3870.getKeywords();
   }

   public Location getLocation() {
      return this.field_3870.getLocation();
   }

   public boolean getManualImpressionsEnabled() {
      return this.field_3870.getManualImpressionsEnabled();
   }

   @Deprecated
   public <T extends NetworkExtras> T getNetworkExtras(Class<T> var1) {
      return this.field_3870.getNetworkExtras(var1);
   }

   public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> var1) {
      return this.field_3870.getNetworkExtrasBundle(var1);
   }

   public String getPublisherProvidedId() {
      return this.field_3870.getPublisherProvidedId();
   }

   public boolean isTestDevice(Context var1) {
      return this.field_3870.isTestDevice(var1);
   }

   public static final class Builder {
      // $FF: renamed from: kr com.google.android.gms.internal.au$a
      private final class_168.class_982 field_4003 = new class_168.class_982();

      public PublisherAdRequest.Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> var1, Bundle var2) {
         this.field_4003.method_2772(var1, var2);
         return this;
      }

      public PublisherAdRequest.Builder addKeyword(String var1) {
         this.field_4003.method_2774(var1);
         return this;
      }

      public PublisherAdRequest.Builder addNetworkExtras(NetworkExtras var1) {
         this.field_4003.method_2769(var1);
         return this;
      }

      public PublisherAdRequest.Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> var1, Bundle var2) {
         this.field_4003.method_2770(var1, var2);
         return this;
      }

      public PublisherAdRequest.Builder addTestDevice(String var1) {
         this.field_4003.method_2776(var1);
         return this;
      }

      public PublisherAdRequest build() {
         return new PublisherAdRequest(this);
      }

      public PublisherAdRequest.Builder setBirthday(Date var1) {
         this.field_4003.method_2771(var1);
         return this;
      }

      public PublisherAdRequest.Builder setContentUrl(String var1) {
         class_347.method_2166(var1, "Content URL must be non-null.");
         class_347.method_2167(var1, "Content URL must be non-empty.");
         boolean var4;
         if(var1.length() <= 512) {
            var4 = true;
         } else {
            var4 = false;
         }

         Object[] var5 = new Object[]{Integer.valueOf(512), Integer.valueOf(var1.length())};
         class_347.method_2169(var4, "Content URL must not exceed %d in length.  Provided length was %d.", var5);
         this.field_4003.method_2778(var1);
         return this;
      }

      public PublisherAdRequest.Builder setGender(int var1) {
         this.field_4003.method_2773(var1);
         return this;
      }

      public PublisherAdRequest.Builder setLocation(Location var1) {
         this.field_4003.method_2768(var1);
         return this;
      }

      public PublisherAdRequest.Builder setManualImpressionsEnabled(boolean var1) {
         this.field_4003.method_2775(var1);
         return this;
      }

      public PublisherAdRequest.Builder setPublisherProvidedId(String var1) {
         this.field_4003.method_2779(var1);
         return this;
      }

      public PublisherAdRequest.Builder tagForChildDirectedTreatment(boolean var1) {
         this.field_4003.method_2777(var1);
         return this;
      }
   }
}
