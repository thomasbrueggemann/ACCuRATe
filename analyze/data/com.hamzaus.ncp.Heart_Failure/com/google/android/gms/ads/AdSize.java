package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_371;

public final class AdSize {
   public static final int AUTO_HEIGHT = -2;
   public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
   public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
   public static final int FULL_WIDTH = -1;
   public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
   public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
   public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
   public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
   public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
   // $FF: renamed from: ks int
   private final int field_3822;
   // $FF: renamed from: kt int
   private final int field_3823;
   // $FF: renamed from: ku java.lang.String
   private final String field_3824;

   public AdSize(int var1, int var2) {
      StringBuilder var3 = new StringBuilder();
      String var4;
      if(var1 == -1) {
         var4 = "FULL";
      } else {
         var4 = String.valueOf(var1);
      }

      StringBuilder var5 = var3.append(var4).append("x");
      String var6;
      if(var2 == -2) {
         var6 = "AUTO";
      } else {
         var6 = String.valueOf(var2);
      }

      this(var1, var2, var5.append(var6).append("_as").toString());
   }

   AdSize(int var1, int var2, String var3) {
      if(var1 < 0 && var1 != -1) {
         throw new IllegalArgumentException("Invalid width for AdSize: " + var1);
      } else if(var2 < 0 && var2 != -2) {
         throw new IllegalArgumentException("Invalid height for AdSize: " + var2);
      } else {
         this.field_3822 = var1;
         this.field_3823 = var2;
         this.field_3824 = var3;
      }
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof AdSize)) {
            return false;
         }

         AdSize var2 = (AdSize)var1;
         if(this.field_3822 != var2.field_3822 || this.field_3823 != var2.field_3823 || !this.field_3824.equals(var2.field_3824)) {
            return false;
         }
      }

      return true;
   }

   public int getHeight() {
      return this.field_3823;
   }

   public int getHeightInPixels(Context var1) {
      return this.field_3823 == -2?class_172.method_1265(var1.getResources().getDisplayMetrics()):class_371.method_2364(var1, this.field_3823);
   }

   public int getWidth() {
      return this.field_3822;
   }

   public int getWidthInPixels(Context var1) {
      return this.field_3822 == -1?class_172.method_1264(var1.getResources().getDisplayMetrics()):class_371.method_2364(var1, this.field_3822);
   }

   public int hashCode() {
      return this.field_3824.hashCode();
   }

   public boolean isAutoHeight() {
      return this.field_3823 == -2;
   }

   public boolean isFullWidth() {
      return this.field_3822 == -1;
   }

   public String toString() {
      return this.field_3824;
   }
}
