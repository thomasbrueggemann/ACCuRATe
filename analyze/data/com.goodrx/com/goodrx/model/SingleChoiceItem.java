package com.goodrx.model;

public class SingleChoiceItem {
   private boolean checked;
   private String name;

   public SingleChoiceItem(String var1) {
      this.name = var1;
      this.checked = false;
   }

   public String getName() {
      return this.name;
   }

   public boolean isChecked() {
      return this.checked;
   }

   public void setChecked(boolean var1) {
      this.checked = var1;
   }

   public void setName(String var1) {
      this.name = var1;
   }
}
