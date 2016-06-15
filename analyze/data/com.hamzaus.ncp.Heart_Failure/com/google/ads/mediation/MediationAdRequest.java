package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest {
   // $FF: renamed from: d java.util.Date
   private final Date field_3275;
   // $FF: renamed from: e com.google.ads.AdRequest$Gender
   private final AdRequest.Gender field_3276;
   // $FF: renamed from: f java.util.Set
   private final Set<String> field_3277;
   // $FF: renamed from: g boolean
   private final boolean field_3278;
   // $FF: renamed from: h android.location.Location
   private final Location field_3279;

   public MediationAdRequest(Date var1, AdRequest.Gender var2, Set<String> var3, boolean var4, Location var5) {
      this.field_3275 = var1;
      this.field_3276 = var2;
      this.field_3277 = var3;
      this.field_3278 = var4;
      this.field_3279 = var5;
   }

   public Integer getAgeInYears() {
      return null;
   }

   public Date getBirthday() {
      return this.field_3275;
   }

   public AdRequest.Gender getGender() {
      return this.field_3276;
   }

   public Set<String> getKeywords() {
      return this.field_3277;
   }

   public Location getLocation() {
      return this.field_3279;
   }

   public boolean isTesting() {
      return this.field_3278;
   }
}
