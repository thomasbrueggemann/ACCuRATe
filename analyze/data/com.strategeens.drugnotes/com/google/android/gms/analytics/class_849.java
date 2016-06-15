package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

// $FF: renamed from: com.google.android.gms.analytics.y
class class_849 {
   // $FF: renamed from: zV com.google.android.gms.analytics.y
   private static final class_849 field_3544 = new class_849();
   // $FF: renamed from: zS java.util.SortedSet
   private SortedSet<class_849.class_1322> field_3545 = new TreeSet();
   // $FF: renamed from: zT java.lang.StringBuilder
   private StringBuilder field_3546 = new StringBuilder();
   // $FF: renamed from: zU boolean
   private boolean field_3547 = false;

   // $FF: renamed from: eK () com.google.android.gms.analytics.y
   public static class_849 method_4705() {
      return field_3544;
   }

   // $FF: renamed from: D (boolean) void
   public void method_4706(boolean var1) {
      synchronized(this){}

      try {
         this.field_3547 = var1;
      } finally {
         ;
      }

   }

   // $FF: renamed from: a (com.google.android.gms.analytics.y$a) void
   public void method_4707(class_849.class_1322 var1) {
      synchronized(this){}

      try {
         if(!this.field_3547) {
            this.field_3545.add(var1);
            this.field_3546.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(var1.ordinal()));
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: eL () java.lang.String
   public String method_4708() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: eM () java.lang.String
   public String method_4709() {
      synchronized(this){}

      String var2;
      try {
         if(this.field_3546.length() > 0) {
            this.field_3546.insert(0, ".");
         }

         var2 = this.field_3546.toString();
         this.field_3546 = new StringBuilder();
      } finally {
         ;
      }

      return var2;
   }

   public static enum class_1322 {
      // $FF: renamed from: AA com.google.android.gms.analytics.y$a
      field_2979,
      // $FF: renamed from: AB com.google.android.gms.analytics.y$a
      field_2980,
      // $FF: renamed from: AC com.google.android.gms.analytics.y$a
      field_2981,
      // $FF: renamed from: AD com.google.android.gms.analytics.y$a
      field_2982,
      // $FF: renamed from: AE com.google.android.gms.analytics.y$a
      field_2983,
      // $FF: renamed from: AF com.google.android.gms.analytics.y$a
      field_2984,
      // $FF: renamed from: AG com.google.android.gms.analytics.y$a
      field_2985,
      // $FF: renamed from: AH com.google.android.gms.analytics.y$a
      field_2986,
      // $FF: renamed from: AI com.google.android.gms.analytics.y$a
      field_2987,
      // $FF: renamed from: AJ com.google.android.gms.analytics.y$a
      field_2988,
      // $FF: renamed from: AK com.google.android.gms.analytics.y$a
      field_2989,
      // $FF: renamed from: AL com.google.android.gms.analytics.y$a
      field_2990,
      // $FF: renamed from: AM com.google.android.gms.analytics.y$a
      field_2991,
      // $FF: renamed from: AN com.google.android.gms.analytics.y$a
      field_2992,
      // $FF: renamed from: AO com.google.android.gms.analytics.y$a
      field_2993,
      // $FF: renamed from: AP com.google.android.gms.analytics.y$a
      field_2994,
      // $FF: renamed from: AQ com.google.android.gms.analytics.y$a
      field_2995,
      // $FF: renamed from: AR com.google.android.gms.analytics.y$a
      field_2996,
      // $FF: renamed from: AS com.google.android.gms.analytics.y$a
      field_2997,
      // $FF: renamed from: AT com.google.android.gms.analytics.y$a
      field_2998,
      // $FF: renamed from: AU com.google.android.gms.analytics.y$a
      field_2999,
      // $FF: renamed from: AV com.google.android.gms.analytics.y$a
      field_3000,
      // $FF: renamed from: AW com.google.android.gms.analytics.y$a
      field_3001,
      // $FF: renamed from: AX com.google.android.gms.analytics.y$a
      field_3002,
      // $FF: renamed from: AY com.google.android.gms.analytics.y$a
      field_3003,
      // $FF: renamed from: AZ com.google.android.gms.analytics.y$a
      field_3004,
      // $FF: renamed from: Aa com.google.android.gms.analytics.y$a
      field_3005,
      // $FF: renamed from: Ab com.google.android.gms.analytics.y$a
      field_3006,
      // $FF: renamed from: Ac com.google.android.gms.analytics.y$a
      field_3007,
      // $FF: renamed from: Ad com.google.android.gms.analytics.y$a
      field_3008,
      // $FF: renamed from: Ae com.google.android.gms.analytics.y$a
      field_3009,
      // $FF: renamed from: Af com.google.android.gms.analytics.y$a
      field_3010,
      // $FF: renamed from: Ag com.google.android.gms.analytics.y$a
      field_3011,
      // $FF: renamed from: Ah com.google.android.gms.analytics.y$a
      field_3012,
      // $FF: renamed from: Ai com.google.android.gms.analytics.y$a
      field_3013,
      // $FF: renamed from: Aj com.google.android.gms.analytics.y$a
      field_3014,
      // $FF: renamed from: Ak com.google.android.gms.analytics.y$a
      field_3015,
      // $FF: renamed from: Al com.google.android.gms.analytics.y$a
      field_3016,
      // $FF: renamed from: Am com.google.android.gms.analytics.y$a
      field_3017,
      // $FF: renamed from: An com.google.android.gms.analytics.y$a
      field_3018,
      // $FF: renamed from: Ao com.google.android.gms.analytics.y$a
      field_3019,
      // $FF: renamed from: Ap com.google.android.gms.analytics.y$a
      field_3020,
      // $FF: renamed from: Aq com.google.android.gms.analytics.y$a
      field_3021,
      // $FF: renamed from: Ar com.google.android.gms.analytics.y$a
      field_3022,
      // $FF: renamed from: As com.google.android.gms.analytics.y$a
      field_3023,
      // $FF: renamed from: At com.google.android.gms.analytics.y$a
      field_3024,
      // $FF: renamed from: Au com.google.android.gms.analytics.y$a
      field_3025,
      // $FF: renamed from: Av com.google.android.gms.analytics.y$a
      field_3026,
      // $FF: renamed from: Aw com.google.android.gms.analytics.y$a
      field_3027,
      // $FF: renamed from: Ax com.google.android.gms.analytics.y$a
      field_3028,
      // $FF: renamed from: Ay com.google.android.gms.analytics.y$a
      field_3029,
      // $FF: renamed from: Az com.google.android.gms.analytics.y$a
      field_3030,
      // $FF: renamed from: Ba com.google.android.gms.analytics.y$a
      field_3031,
      // $FF: renamed from: Bb com.google.android.gms.analytics.y$a
      field_3032,
      // $FF: renamed from: Bc com.google.android.gms.analytics.y$a
      field_3033,
      // $FF: renamed from: Bd com.google.android.gms.analytics.y$a
      field_3034,
      // $FF: renamed from: Be com.google.android.gms.analytics.y$a
      field_3035,
      // $FF: renamed from: Bf com.google.android.gms.analytics.y$a
      field_3036,
      // $FF: renamed from: Bg com.google.android.gms.analytics.y$a
      field_3037,
      // $FF: renamed from: zW com.google.android.gms.analytics.y$a
      field_3039,
      // $FF: renamed from: zX com.google.android.gms.analytics.y$a
      field_3040,
      // $FF: renamed from: zY com.google.android.gms.analytics.y$a
      field_3041,
      // $FF: renamed from: zZ com.google.android.gms.analytics.y$a
      field_3042;

      static {
         class_849.class_1322[] var0 = new class_849.class_1322[]{field_3039, field_3040, field_3041, field_3042, field_3005, field_3006, field_3007, field_3008, field_3009, field_3010, field_3011, field_3012, field_3013, field_3014, field_3015, field_3016, field_3017, field_3018, field_3019, field_3020, field_3021, field_3022, field_3023, field_3024, field_3025, field_3026, field_3027, field_3028, field_3029, field_3030, field_2979, field_2980, field_2981, field_2982, field_2983, field_2984, field_2985, field_2986, field_2987, field_2988, field_2989, field_2990, field_2991, field_2992, field_2993, field_2994, field_2995, field_2996, field_2997, field_2998, field_2999, field_3000, field_3001, field_3002, field_3003, field_3004, field_3031, field_3032, field_3033, field_3034, field_3035, field_3036, field_3037};
      }
   }
}
