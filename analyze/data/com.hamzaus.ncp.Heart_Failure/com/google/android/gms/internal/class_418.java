package com.google.android.gms.internal;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.class_740;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_182;
import java.util.Date;
import java.util.HashSet;

// $FF: renamed from: com.google.android.gms.internal.cc
public final class class_418 {
   // $FF: renamed from: a (com.google.ads.AdRequest$ErrorCode) int
   public static int method_2545(AdRequest.ErrorCode var0) {
      switch(null.field_2057[var0.ordinal()]) {
      case 2:
         return 1;
      case 3:
         return 2;
      case 4:
         return 3;
      default:
         return 0;
      }
   }

   // $FF: renamed from: b (com.google.android.gms.internal.am) com.google.ads.AdSize
   public static AdSize method_2546(class_172 var0) {
      int var1 = 0;

      for(AdSize[] var2 = new AdSize[]{AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER}; var1 < var2.length; ++var1) {
         if(var2[var1].getWidth() == var0.width && var2[var1].getHeight() == var0.height) {
            return var2[var1];
         }
      }

      return new AdSize(class_740.method_4163(var0.width, var0.height, var0.field_569));
   }

   // $FF: renamed from: e (com.google.android.gms.internal.aj) com.google.ads.mediation.MediationAdRequest
   public static MediationAdRequest method_2547(class_182 var0) {
      HashSet var1;
      if(var0.field_581 != null) {
         var1 = new HashSet(var0.field_581);
      } else {
         var1 = null;
      }

      return new MediationAdRequest(new Date(var0.field_579), method_2548(var0.field_580), var1, var0.field_582, var0.field_587);
   }

   // $FF: renamed from: h (int) com.google.ads.AdRequest$Gender
   public static AdRequest.Gender method_2548(int var0) {
      switch(var0) {
      case 1:
         return AdRequest.Gender.MALE;
      case 2:
         return AdRequest.Gender.FEMALE;
      default:
         return AdRequest.Gender.UNKNOWN;
      }
   }
}
