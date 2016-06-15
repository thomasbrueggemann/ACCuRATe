package com.google.android.gms.ads;

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

public final class AdRequest {
   public static final String DEVICE_ID_EMULATOR;
   public static final int ERROR_CODE_INTERNAL_ERROR = 0;
   public static final int ERROR_CODE_INVALID_REQUEST = 1;
   public static final int ERROR_CODE_NETWORK_ERROR = 2;
   public static final int ERROR_CODE_NO_FILL = 3;
   public static final int GENDER_FEMALE = 2;
   public static final int GENDER_MALE = 1;
   public static final int GENDER_UNKNOWN = 0;
   public static final int MAX_CONTENT_URL_LENGTH = 512;
   // $FF: renamed from: kq com.google.android.gms.internal.au
   private final class_168 field_4189;

   static {
      DEVICE_ID_EMULATOR = class_168.DEVICE_ID_EMULATOR;
   }

   private AdRequest(AdRequest.Builder var1) {
      this.field_4189 = new class_168(var1.field_4040);
   }

   // $FF: synthetic method
   AdRequest(AdRequest.Builder var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: O () com.google.android.gms.internal.au
   class_168 method_4466() {
      return this.field_4189;
   }

   public Date getBirthday() {
      return this.field_4189.getBirthday();
   }

   public String getContentUrl() {
      return this.field_4189.getContentUrl();
   }

   public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> var1) {
      return this.field_4189.getCustomEventExtrasBundle(var1);
   }

   public int getGender() {
      return this.field_4189.getGender();
   }

   public Set<String> getKeywords() {
      return this.field_4189.getKeywords();
   }

   public Location getLocation() {
      return this.field_4189.getLocation();
   }

   @Deprecated
   public <T extends NetworkExtras> T getNetworkExtras(Class<T> var1) {
      return this.field_4189.getNetworkExtras(var1);
   }

   public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> var1) {
      return this.field_4189.getNetworkExtrasBundle(var1);
   }

   public boolean isTestDevice(Context var1) {
      return this.field_4189.isTestDevice(var1);
   }

   public static final class Builder {
      // $FF: renamed from: kr com.google.android.gms.internal.au$a
      private final class_168.class_982 field_4040 = new class_168.class_982();

      public AdRequest.Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> var1, Bundle var2) {
         this.field_4040.method_2772(var1, var2);
         return this;
      }

      public AdRequest.Builder addKeyword(String var1) {
         this.field_4040.method_2774(var1);
         return this;
      }

      public AdRequest.Builder addNetworkExtras(NetworkExtras var1) {
         this.field_4040.method_2769(var1);
         return this;
      }

      public AdRequest.Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> var1, Bundle var2) {
         this.field_4040.method_2770(var1, var2);
         return this;
      }

      public AdRequest.Builder addTestDevice(String var1) {
         this.field_4040.method_2776(var1);
         return this;
      }

      public AdRequest build() {
         return new AdRequest(this);
      }

      public AdRequest.Builder setBirthday(Date var1) {
         this.field_4040.method_2771(var1);
         return this;
      }

      public AdRequest.Builder setContentUrl(String var1) {
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
         this.field_4040.method_2778(var1);
         return this;
      }

      public AdRequest.Builder setGender(int var1) {
         this.field_4040.method_2773(var1);
         return this;
      }

      public AdRequest.Builder setLocation(Location var1) {
         this.field_4040.method_2768(var1);
         return this;
      }

      public AdRequest.Builder tagForChildDirectedTreatment(boolean var1) {
         this.field_4040.method_2777(var1);
         return this;
      }
   }
}
