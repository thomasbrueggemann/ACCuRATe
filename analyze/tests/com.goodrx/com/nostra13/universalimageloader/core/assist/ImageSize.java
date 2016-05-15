package com.nostra13.universalimageloader.core.assist;

public class ImageSize {
   private final int height;
   private final int width;

   public ImageSize(int var1, int var2) {
      this.width = var1;
      this.height = var2;
   }

   public ImageSize(int var1, int var2, int var3) {
      if(var3 % 180 == 0) {
         this.width = var1;
         this.height = var2;
      } else {
         this.width = var2;
         this.height = var1;
      }
   }

   public int getHeight() {
      return this.height;
   }

   public int getWidth() {
      return this.width;
   }

   public ImageSize scale(float var1) {
      return new ImageSize((int)(var1 * (float)this.width), (int)(var1 * (float)this.height));
   }

   public ImageSize scaleDown(int var1) {
      return new ImageSize(this.width / var1, this.height / var1);
   }

   public String toString() {
      return (new StringBuilder(9)).append(this.width).append("x").append(this.height).toString();
   }
}
