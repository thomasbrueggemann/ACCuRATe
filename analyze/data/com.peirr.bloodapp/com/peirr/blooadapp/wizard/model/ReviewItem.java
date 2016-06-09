package com.peirr.blooadapp.wizard.model;

public class ReviewItem {
   public static final int DEFAULT_WEIGHT;
   private String pageSection;
   private String param;
   private String title;
   private String value;
   private int weight;

   public ReviewItem(String var1, String var2, String var3) {
      this(var1, var2, var3, 0);
   }

   public ReviewItem(String var1, String var2, String var3, int var4) {
      this.title = var1;
      this.value = var2;
      this.pageSection = var3;
      this.weight = var4;
   }

   public ReviewItem(String var1, String var2, String var3, String var4) {
      this(var2, var3, var4, 0);
      this.param = var1;
   }

   public ReviewItem(String var1, String var2, String var3, String var4, int var5) {
      this.title = var2;
      this.value = var3;
      this.pageSection = var4;
      this.weight = var5;
      this.param = var1;
   }

   public String getPageSection() {
      return this.pageSection;
   }

   public String getParam() {
      return this.param;
   }

   public String getTitle() {
      return this.title;
   }

   public String getValue() {
      return this.value;
   }

   public int getWeight() {
      return this.weight;
   }

   public void setTitle(String var1) {
      this.title = var1;
   }

   public void setValue(String var1) {
      this.value = var1;
   }

   public void setWeight(int var1) {
      this.weight = var1;
   }
}
