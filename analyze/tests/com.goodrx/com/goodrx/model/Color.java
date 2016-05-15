package com.goodrx.model;

public class Color {
   String name;
   int rgb;

   public Color(String var1, int var2) {
      this.name = var1;
      this.rgb = var2;
   }

   public String getName() {
      return this.name;
   }

   public int getRgb() {
      return this.rgb;
   }
}
