package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Excluder implements TypeAdapterFactory, Cloneable {
   public static final Excluder DEFAULT = new Excluder();
   private static final double IGNORE_VERSIONS = -1.0D;
   private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();
   private int modifiers = 136;
   private boolean requireExpose;
   private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
   private boolean serializeInnerClasses = true;
   private double version = -1.0D;

   private boolean isAnonymousOrLocal(Class<?> var1) {
      return !Enum.class.isAssignableFrom(var1) && (var1.isAnonymousClass() || var1.isLocalClass());
   }

   private boolean isInnerClass(Class<?> var1) {
      return var1.isMemberClass() && !this.isStatic(var1);
   }

   private boolean isStatic(Class<?> var1) {
      return (8 & var1.getModifiers()) != 0;
   }

   private boolean isValidSince(Since var1) {
      return var1 == null || var1.value() <= this.version;
   }

   private boolean isValidUntil(Until var1) {
      return var1 == null || var1.value() > this.version;
   }

   private boolean isValidVersion(Since var1, Until var2) {
      return this.isValidSince(var1) && this.isValidUntil(var2);
   }

   protected Excluder clone() {
      try {
         Excluder var2 = (Excluder)super.clone();
         return var2;
      } catch (CloneNotSupportedException var3) {
         throw new AssertionError();
      }
   }

   public <T> TypeAdapter<T> create(final Gson var1, final TypeToken<T> var2) {
      Class var3 = var2.getRawType();
      final boolean var4 = this.excludeClass(var3, true);
      final boolean var5 = this.excludeClass(var3, false);
      return !var4 && !var5?null:new TypeAdapter() {
         private TypeAdapter<T> delegate;

         private TypeAdapter<T> delegate() {
            TypeAdapter var1x = this.delegate;
            if(var1x != null) {
               return var1x;
            } else {
               TypeAdapter var2x = var1.getDelegateAdapter(Excluder.this, var2);
               this.delegate = var2x;
               return var2x;
            }
         }

         public T read(JsonReader var1x) throws IOException {
            if(var5) {
               var1x.skipValue();
               return null;
            } else {
               return this.delegate().read(var1x);
            }
         }

         public void write(JsonWriter var1x, T var2x) throws IOException {
            if(var4) {
               var1x.nullValue();
            } else {
               this.delegate().write(var1x, var2x);
            }
         }
      };
   }

   public Excluder disableInnerClassSerialization() {
      Excluder var1 = this.clone();
      var1.serializeInnerClasses = false;
      return var1;
   }

   public boolean excludeClass(Class<?> var1, boolean var2) {
      if(this.version != -1.0D && !this.isValidVersion((Since)var1.getAnnotation(Since.class), (Until)var1.getAnnotation(Until.class))) {
         return true;
      } else if(!this.serializeInnerClasses && this.isInnerClass(var1)) {
         return true;
      } else if(this.isAnonymousOrLocal(var1)) {
         return true;
      } else {
         List var3;
         if(var2) {
            var3 = this.serializationStrategies;
         } else {
            var3 = this.deserializationStrategies;
         }

         Iterator var4 = var3.iterator();

         do {
            if(!var4.hasNext()) {
               return false;
            }
         } while(!((ExclusionStrategy)var4.next()).shouldSkipClass(var1));

         return true;
      }
   }

   public boolean excludeField(Field var1, boolean var2) {
      if((this.modifiers & var1.getModifiers()) != 0) {
         return true;
      } else if(this.version != -1.0D && !this.isValidVersion((Since)var1.getAnnotation(Since.class), (Until)var1.getAnnotation(Until.class))) {
         return true;
      } else if(var1.isSynthetic()) {
         return true;
      } else {
         if(this.requireExpose) {
            label67: {
               Expose var6 = (Expose)var1.getAnnotation(Expose.class);
               if(var6 != null) {
                  if(var2) {
                     if(var6.serialize()) {
                        break label67;
                     }
                  } else if(var6.deserialize()) {
                     break label67;
                  }
               }

               return true;
            }
         }

         if(!this.serializeInnerClasses && this.isInnerClass(var1.getType())) {
            return true;
         } else if(this.isAnonymousOrLocal(var1.getType())) {
            return true;
         } else {
            List var3;
            if(var2) {
               var3 = this.serializationStrategies;
            } else {
               var3 = this.deserializationStrategies;
            }

            if(!var3.isEmpty()) {
               FieldAttributes var4 = new FieldAttributes(var1);
               Iterator var5 = var3.iterator();

               while(var5.hasNext()) {
                  if(((ExclusionStrategy)var5.next()).shouldSkipField(var4)) {
                     return true;
                  }
               }
            }

            return false;
         }
      }
   }

   public Excluder excludeFieldsWithoutExposeAnnotation() {
      Excluder var1 = this.clone();
      var1.requireExpose = true;
      return var1;
   }

   public Excluder withExclusionStrategy(ExclusionStrategy var1, boolean var2, boolean var3) {
      Excluder var4 = this.clone();
      if(var2) {
         var4.serializationStrategies = new ArrayList(this.serializationStrategies);
         var4.serializationStrategies.add(var1);
      }

      if(var3) {
         var4.deserializationStrategies = new ArrayList(this.deserializationStrategies);
         var4.deserializationStrategies.add(var1);
      }

      return var4;
   }

   public Excluder withModifiers(int... var1) {
      Excluder var2 = this.clone();
      var2.modifiers = 0;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         var2.modifiers |= var1[var4];
      }

      return var2;
   }

   public Excluder withVersion(double var1) {
      Excluder var3 = this.clone();
      var3.version = var1;
      return var3;
   }
}
