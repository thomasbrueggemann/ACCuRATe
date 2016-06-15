package com.strategeens.drugnotes.model;

public class NavDrawerItem {
   private String count = "0";
   private int icon;
   private boolean isCounterVisible = false;
   private String title;

   public NavDrawerItem() {
   }

   public NavDrawerItem(String var1, int var2) {
      this.title = var1;
      this.icon = var2;
   }

   public NavDrawerItem(String var1, int var2, boolean var3, String var4) {
      this.title = var1;
      this.icon = var2;
      this.isCounterVisible = var3;
      this.count = var4;
   }

   public String getCount() {
      return this.count;
   }

   public boolean getCounterVisibility() {
      return this.isCounterVisible;
   }

   public int getIcon() {
      return this.icon;
   }

   public String getTitle() {
      return this.title;
   }

   public void setCount(String var1) {
      this.count = var1;
   }

   public void setCounterVisibility(boolean var1) {
      this.isCounterVisible = var1;
   }

   public void setIcon(int var1) {
      this.icon = var1;
   }

   public void setTitle(String var1) {
      this.title = var1;
   }
}
