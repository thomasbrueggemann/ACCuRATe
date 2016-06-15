package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest {
   // $FF: renamed from: d java.util.Date
   private final Date field_3226;
   // $FF: renamed from: e com.google.ads.AdRequest$Gender
   private final AdRequest.Gender field_3227;
   // $FF: renamed from: f java.util.Set
   private final Set<String> field_3228;
   // $FF: renamed from: g boolean
   private final boolean field_3229;
   // $FF: renamed from: h android.location.Location
   private final Location field_3230;

   public MediationAdRequest(Date var1, AdRequest.Gender var2, Set<String> var3, boolean var4, Location var5) {
      this.field_3226 = var1;
      this.field_3227 = var2;
      this.field_3228 = var3;
      this.field_3229 = var4;
      this.field_3230 = var5;
   }

   public Integer getAgeInYears() {
      if(this.field_3226 == null) {
         return null;
      } else {
         Calendar var1 = Calendar.getInstance();
         Calendar var2 = Calendar.getInstance();
         var1.setTime(this.field_3226);
         Integer var3 = Integer.valueOf(var2.get(1) - var1.get(1));
         if(var2.get(2) < var1.get(2) || var2.get(2) == var1.get(2) && var2.get(5) < var1.get(5)) {
            var3 = Integer.valueOf(-1 + var3.intValue());
         }

         return var3;
      }
   }

   public Date getBirthday() {
      return this.field_3226;
   }

   public AdRequest.Gender getGender() {
      return this.field_3227;
   }

   public Set<String> getKeywords() {
      return this.field_3228;
   }

   public Location getLocation() {
      return this.field_3230;
   }

   public boolean isTesting() {
      return this.field_3229;
   }
}
