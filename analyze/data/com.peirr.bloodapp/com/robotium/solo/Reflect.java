package com.robotium.solo;

import java.lang.reflect.Field;

class Reflect {
   private Object object;

   public Reflect(Object var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Object can not be null.");
      } else {
         this.object = var1;
      }
   }

   public Reflect.FieldRf field(String var1) {
      return new Reflect.FieldRf(this.object, var1);
   }

   public class FieldRf {
      private Class<?> clazz;
      private String name;
      private Object object;

      public FieldRf(Object var2, String var3) {
         this.object = var2;
         this.name = var3;
      }

      private Field getField() {
         if(this.clazz == null) {
            this.clazz = this.object.getClass();
         }

         Field var1 = null;

         try {
            var1 = this.clazz.getDeclaredField(this.name);
            var1.setAccessible(true);
            return var1;
         } catch (NoSuchFieldException var3) {
            return var1;
         }
      }

      private Object getValue(Field var1) {
         if(var1 == null) {
            return null;
         } else {
            try {
               Object var4 = var1.get(this.object);
               return var4;
            } catch (IllegalArgumentException var5) {
               var5.printStackTrace();
               return null;
            } catch (IllegalAccessException var6) {
               var6.printStackTrace();
               return null;
            }
         }
      }

      // $FF: renamed from: in (java.lang.Object) void
      public void method_6(Object var1) {
         Field var2 = this.getField();

         try {
            var2.set(this.object, var1);
         } catch (IllegalArgumentException var5) {
            var5.printStackTrace();
         } catch (IllegalAccessException var6) {
            var6.printStackTrace();
         }
      }

      public <T> T out(Class<T> var1) {
         return var1.cast(this.getValue(this.getField()));
      }

      public Reflect.FieldRf type(Class<?> var1) {
         this.clazz = var1;
         return this;
      }
   }
}
