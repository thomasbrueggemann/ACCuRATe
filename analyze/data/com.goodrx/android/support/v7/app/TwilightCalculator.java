package android.support.v7.app;

class TwilightCalculator {
   private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976F;
   // $FF: renamed from: C1 float
   private static final float field_313 = 0.0334196F;
   // $FF: renamed from: C2 float
   private static final float field_314 = 3.49066E-4F;
   // $FF: renamed from: C3 float
   private static final float field_315 = 5.236E-6F;
   public static final int DAY = 0;
   private static final float DEGREES_TO_RADIANS = 0.017453292F;
   // $FF: renamed from: J0 float
   private static final float field_316 = 9.0E-4F;
   public static final int NIGHT = 1;
   private static final float OBLIQUITY = 0.4092797F;
   private static final long UTC_2000 = 946728000000L;
   private static TwilightCalculator sInstance;
   public int state;
   public long sunrise;
   public long sunset;

   static TwilightCalculator getInstance() {
      if(sInstance == null) {
         sInstance = new TwilightCalculator();
      }

      return sInstance;
   }

   public void calculateTwilight(long var1, double var3, double var5) {
      float var7 = (float)(var1 - 946728000000L) / 8.64E7F;
      float var8 = 6.24006F + 0.01720197F * var7;
      double var9 = 3.141592653589793D + 1.796593063D + (double)var8 + 0.03341960161924362D * Math.sin((double)var8) + 3.4906598739326E-4D * Math.sin((double)(2.0F * var8)) + 5.236000106378924E-6D * Math.sin((double)(3.0F * var8));
      double var11 = -var5 / 360.0D;
      double var13 = var11 + (double)(9.0E-4F + (float)Math.round((double)(var7 - 9.0E-4F) - var11)) + 0.0053D * Math.sin((double)var8) + -0.0069D * Math.sin(2.0D * var9);
      double var15 = Math.asin(Math.sin(var9) * Math.sin(0.4092797040939331D));
      double var17 = var3 * 0.01745329238474369D;
      double var19 = (Math.sin(-0.10471975803375244D) - Math.sin(var17) * Math.sin(var15)) / (Math.cos(var17) * Math.cos(var15));
      if(var19 >= 1.0D) {
         this.state = 1;
         this.sunset = -1L;
         this.sunrise = -1L;
      } else if(var19 <= -1.0D) {
         this.state = 0;
         this.sunset = -1L;
         this.sunrise = -1L;
      } else {
         float var21 = (float)(Math.acos(var19) / 6.283185307179586D);
         this.sunset = 946728000000L + Math.round(8.64E7D * (var13 + (double)var21));
         this.sunrise = 946728000000L + Math.round(8.64E7D * (var13 - (double)var21));
         if(this.sunrise < var1 && this.sunset > var1) {
            this.state = 0;
         } else {
            this.state = 1;
         }
      }
   }
}
