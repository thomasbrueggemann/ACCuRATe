package com.google.android.gms.internal;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.class_959;
import com.google.android.gms.internal.class_218;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.ey;
import java.util.Date;
import java.util.HashSet;

// $FF: renamed from: com.google.android.gms.internal.dg
@ey
public final class class_474 {
   // $FF: renamed from: a (com.google.ads.AdRequest$ErrorCode) int
   public static int method_3006(AdRequest.ErrorCode var0) {
      switch(null.field_4095[var0.ordinal()]) {
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

   // $FF: renamed from: b (com.google.android.gms.internal.ay) com.google.ads.AdSize
   public static AdSize method_3007(class_237 var0) {
      int var1 = 0;

      for(AdSize[] var2 = new AdSize[]{AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER}; var1 < var2.length; ++var1) {
         if(var2[var1].getWidth() == var0.width && var2[var1].getHeight() == var0.height) {
            return var2[var1];
         }
      }

      return new AdSize(class_959.method_5282(var0.width, var0.height, var0.field_446));
   }

   // $FF: renamed from: d (com.google.android.gms.internal.av) com.google.ads.mediation.MediationAdRequest
   public static MediationAdRequest method_3008(class_218 var0) {
      HashSet var1;
      if(var0.field_359 != null) {
         var1 = new HashSet(var0.field_359);
      } else {
         var1 = null;
      }

      return new MediationAdRequest(new Date(var0.field_357), method_3009(var0.field_358), var1, var0.field_360, var0.field_365);
   }

   // $FF: renamed from: l (int) com.google.ads.AdRequest$Gender
   public static AdRequest.Gender method_3009(int var0) {
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
