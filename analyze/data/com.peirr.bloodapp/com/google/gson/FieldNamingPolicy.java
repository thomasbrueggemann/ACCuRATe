package com.google.gson;

import com.google.gson.FieldNamingStrategy;
import java.lang.reflect.Field;

public enum FieldNamingPolicy implements FieldNamingStrategy {
   IDENTITY {
      public String translateName(Field var1) {
         return var1.getName();
      }
   },
   LOWER_CASE_WITH_DASHES {
      public String translateName(Field var1) {
         return FieldNamingPolicy.separateCamelCase(var1.getName(), "-").toLowerCase();
      }
   },
   LOWER_CASE_WITH_UNDERSCORES {
      public String translateName(Field var1) {
         return FieldNamingPolicy.separateCamelCase(var1.getName(), "_").toLowerCase();
      }
   },
   UPPER_CAMEL_CASE {
      public String translateName(Field var1) {
         return FieldNamingPolicy.upperCaseFirstLetter(var1.getName());
      }
   },
   UPPER_CAMEL_CASE_WITH_SPACES {
      public String translateName(Field var1) {
         return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(var1.getName(), " "));
      }
   };

   static {
      FieldNamingPolicy[] var0 = new FieldNamingPolicy[]{IDENTITY, UPPER_CAMEL_CASE, UPPER_CAMEL_CASE_WITH_SPACES, LOWER_CASE_WITH_UNDERSCORES, LOWER_CASE_WITH_DASHES};
   }

   private FieldNamingPolicy() {
   }

   // $FF: synthetic method
   FieldNamingPolicy(Object var3) {
      this();
   }

   private static String modifyString(char var0, String var1, int var2) {
      return var2 < var1.length()?var0 + var1.substring(var2):String.valueOf(var0);
   }

   private static String separateCamelCase(String var0, String var1) {
      StringBuilder var2 = new StringBuilder();

      for(int var3 = 0; var3 < var0.length(); ++var3) {
         char var4 = var0.charAt(var3);
         if(Character.isUpperCase(var4) && var2.length() != 0) {
            var2.append(var1);
         }

         var2.append(var4);
      }

      return var2.toString();
   }

   private static String upperCaseFirstLetter(String var0) {
      StringBuilder var1 = new StringBuilder();
      int var2 = 0;

      char var3;
      for(var3 = var0.charAt(0); var2 < -1 + var0.length() && !Character.isLetter(var3); var3 = var0.charAt(var2)) {
         var1.append(var3);
         ++var2;
      }

      if(var2 == var0.length()) {
         var0 = var1.toString();
      } else if(!Character.isUpperCase(var3)) {
         return var1.append(modifyString(Character.toUpperCase(var3), var0, var2 + 1)).toString();
      }

      return var0;
   }
}
