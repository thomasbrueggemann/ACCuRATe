package com.goodrx.model;

public class Shape {
   private int imageSrc;
   private String name;

   public Shape(String var1, int var2) {
      this.name = var1;
      this.imageSrc = var2;
   }

   public int getImageSrc() {
      return this.imageSrc;
   }

   public String getName() {
      return this.name;
   }
}
