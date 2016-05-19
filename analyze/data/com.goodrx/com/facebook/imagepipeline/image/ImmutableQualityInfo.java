package com.facebook.imagepipeline.image;

import com.facebook.imagepipeline.image.QualityInfo;

public class ImmutableQualityInfo implements QualityInfo {
   public static final QualityInfo FULL_QUALITY = method_328(Integer.MAX_VALUE, true, true);
   boolean mIsOfFullQuality;
   boolean mIsOfGoodEnoughQuality;
   int mQuality;

   private ImmutableQualityInfo(int var1, boolean var2, boolean var3) {
      this.mQuality = var1;
      this.mIsOfGoodEnoughQuality = var2;
      this.mIsOfFullQuality = var3;
   }

   // $FF: renamed from: of (int, boolean, boolean) com.facebook.imagepipeline.image.QualityInfo
   public static QualityInfo method_328(int var0, boolean var1, boolean var2) {
      return new ImmutableQualityInfo(var0, var1, var2);
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof ImmutableQualityInfo)) {
            return false;
         }

         ImmutableQualityInfo var2 = (ImmutableQualityInfo)var1;
         if(this.mQuality != var2.mQuality || this.mIsOfGoodEnoughQuality != var2.mIsOfGoodEnoughQuality || this.mIsOfFullQuality != var2.mIsOfFullQuality) {
            return false;
         }
      }

      return true;
   }

   public int getQuality() {
      return this.mQuality;
   }

   public int hashCode() {
      int var1 = this.mQuality;
      int var2;
      if(this.mIsOfGoodEnoughQuality) {
         var2 = 4194304;
      } else {
         var2 = 0;
      }

      int var3 = var2 ^ var1;
      boolean var4 = this.mIsOfFullQuality;
      int var5 = 0;
      if(var4) {
         var5 = 8388608;
      }

      return var3 ^ var5;
   }

   public boolean isOfFullQuality() {
      return this.mIsOfFullQuality;
   }

   public boolean isOfGoodEnoughQuality() {
      return this.mIsOfGoodEnoughQuality;
   }
}
