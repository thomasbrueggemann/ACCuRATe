package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;

public final class AdSize {
   public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
   public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
   public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
   public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
   public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
   public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
   public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
   public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
   private final int zzoG;
   private final int zzoH;
   private final String zzoI;

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
      if(var1 < 0 && var1 != -1 && var1 != -3) {
         throw new IllegalArgumentException("Invalid width for AdSize: " + var1);
      } else if(var2 < 0 && var2 != -2 && var2 != -4) {
         throw new IllegalArgumentException("Invalid height for AdSize: " + var2);
      } else {
         this.zzoG = var1;
         this.zzoH = var2;
         this.zzoI = var3;
      }
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof AdSize)) {
            return false;
         }

         AdSize var2 = (AdSize)var1;
         if(this.zzoG != var2.zzoG || this.zzoH != var2.zzoH || !this.zzoI.equals(var2.zzoI)) {
            return false;
         }
      }

      return true;
   }

   public int getHeight() {
      return this.zzoH;
   }

   public int getHeightInPixels(Context var1) {
      switch(this.zzoH) {
      case -4:
      case -3:
         return -1;
      case -2:
         return AdSizeParcel.zzb(var1.getResources().getDisplayMetrics());
      default:
         return zzn.zzcS().zzb(var1, this.zzoH);
      }
   }

   public int getWidth() {
      return this.zzoG;
   }

   public int getWidthInPixels(Context var1) {
      switch(this.zzoG) {
      case -4:
      case -3:
         return -1;
      case -2:
      default:
         return zzn.zzcS().zzb(var1, this.zzoG);
      case -1:
         return AdSizeParcel.zza(var1.getResources().getDisplayMetrics());
      }
   }

   public int hashCode() {
      return this.zzoI.hashCode();
   }

   public boolean isFluid() {
      return this.zzoG == -3 && this.zzoH == -4;
   }

   public String toString() {
      return this.zzoI;
   }
}
