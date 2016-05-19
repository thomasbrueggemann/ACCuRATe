package com.newrelic.com.google.gson;

import com.newrelic.com.google.gson.internal.$Gson$Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

public final class FieldAttributes {
   private final Field field;

   public FieldAttributes(Field var1) {
      $Gson$Preconditions.checkNotNull(var1);
      this.field = var1;
   }

   Object get(Object var1) throws IllegalAccessException {
      return this.field.get(var1);
   }

   public <T extends Annotation> T getAnnotation(Class<T> var1) {
      return this.field.getAnnotation(var1);
   }

   public Collection<Annotation> getAnnotations() {
      return Arrays.asList(this.field.getAnnotations());
   }

   public Class<?> getDeclaredClass() {
      return this.field.getType();
   }

   public Type getDeclaredType() {
      return this.field.getGenericType();
   }

   public Class<?> getDeclaringClass() {
      return this.field.getDeclaringClass();
   }

   public String getName() {
      return this.field.getName();
   }

   public boolean hasModifier(int var1) {
      return (var1 & this.field.getModifiers()) != 0;
   }

   boolean isSynthetic() {
      return this.field.isSynthetic();
   }
}
