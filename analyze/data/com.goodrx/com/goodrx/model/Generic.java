package com.goodrx.model;

import com.goodrx.model.BaseDrugProperty;

public class Generic extends BaseDrugProperty {
   public Generic(String var1, String var2) {
      super(var1, var2);
   }

   public String getLongName() {
      return this.display + " (generic)";
   }
}
