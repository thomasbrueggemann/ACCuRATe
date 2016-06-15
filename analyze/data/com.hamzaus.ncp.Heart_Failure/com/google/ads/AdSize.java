package com.google.ads;

import android.content.Context;

@Deprecated
public final class AdSize {
   public static final int AUTO_HEIGHT = -2;
   public static final AdSize BANNER = new AdSize(320, 50, "mb");
   public static final int FULL_WIDTH = -1;
   public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
   public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
   public static final AdSize IAB_MRECT = new AdSize(300, 250, "as");
   public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");
   public static final int LANDSCAPE_AD_HEIGHT = 32;
   public static final int LARGE_AD_HEIGHT = 90;
   public static final int PORTRAIT_AD_HEIGHT = 50;
   public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
   // $FF: renamed from: c com.google.android.gms.ads.AdSize
   private final com.google.android.gms.ads.AdSize field_3709;

   public AdSize(int var1, int var2) {
      this(new com.google.android.gms.ads.AdSize(var1, var2));
   }

   private AdSize(int var1, int var2, String var3) {
      this(new com.google.android.gms.ads.AdSize(var1, var2));
   }

   public AdSize(com.google.android.gms.ads.AdSize var1) {
      this.field_3709 = var1;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof AdSize)) {
         return false;
      } else {
         AdSize var2 = (AdSize)var1;
         return this.field_3709.equals(var2.field_3709);
      }
   }

   public AdSize findBestSize(AdSize... var1) {
      AdSize var2 = null;
      if(var1 != null) {
         float var3 = 0.0F;
         int var4 = this.getWidth();
         int var5 = this.getHeight();
         int var6 = var1.length;

         float var11;
         for(int var7 = 0; var7 < var6; var3 = var11) {
            AdSize var12;
            label22: {
               AdSize var8 = var1[var7];
               int var9 = var8.getWidth();
               int var10 = var8.getHeight();
               if(this.isSizeAppropriate(var9, var10)) {
                  var11 = (float)(var9 * var10) / (float)(var4 * var5);
                  if(var11 > 1.0F) {
                     var11 = 1.0F / var11;
                  }

                  if(var11 > var3) {
                     var12 = var8;
                     break label22;
                  }
               }

               var11 = var3;
               var12 = var2;
            }

            ++var7;
            var2 = var12;
         }
      }

      return var2;
   }

   public int getHeight() {
      return this.field_3709.getHeight();
   }

   public int getHeightInPixels(Context var1) {
      return this.field_3709.getHeightInPixels(var1);
   }

   public int getWidth() {
      return this.field_3709.getWidth();
   }

   public int getWidthInPixels(Context var1) {
      return this.field_3709.getWidthInPixels(var1);
   }

   public int hashCode() {
      return this.field_3709.hashCode();
   }

   public boolean isAutoHeight() {
      return this.field_3709.isAutoHeight();
   }

   public boolean isCustomAdSize() {
      return false;
   }

   public boolean isFullWidth() {
      return this.field_3709.isFullWidth();
   }

   public boolean isSizeAppropriate(int var1, int var2) {
      int var3 = this.getWidth();
      int var4 = this.getHeight();
      return (float)var1 <= 1.25F * (float)var3 && (float)var1 >= 0.8F * (float)var3 && (float)var2 <= 1.25F * (float)var4 && (float)var2 >= 0.8F * (float)var4;
   }

   public String toString() {
      return this.field_3709.toString();
   }
}
