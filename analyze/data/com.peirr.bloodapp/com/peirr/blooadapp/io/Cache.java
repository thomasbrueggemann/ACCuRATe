package com.peirr.blooadapp.io;

import java.util.Map;

public class Cache {
   private static Cache ourInstance = new Cache();
   private boolean cardiac;
   private boolean male;
   Map<String, String> values;

   public static Cache getInstance() {
      return ourInstance;
   }

   public Map<String, String> getValues() {
      return this.values;
   }

   public boolean isCardiac() {
      return this.cardiac;
   }

   public boolean isFemale() {
      return this.male;
   }

   public void setCardiac(boolean var1) {
      this.cardiac = var1;
   }

   public void setFemale(boolean var1) {
      this.male = var1;
   }

   public void setValues(Map<String, String> var1) {
      this.values = var1;
   }
}
