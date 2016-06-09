package com.newrelic.com.google.gson.internal.bind;

import com.newrelic.com.google.gson.FieldNamingStrategy;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.TypeAdapter;
import com.newrelic.com.google.gson.TypeAdapterFactory;
import com.newrelic.com.google.gson.annotations.SerializedName;
import com.newrelic.com.google.gson.internal.$Gson$Types;
import com.newrelic.com.google.gson.internal.ConstructorConstructor;
import com.newrelic.com.google.gson.internal.Excluder;
import com.newrelic.com.google.gson.internal.ObjectConstructor;
import com.newrelic.com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.newrelic.com.google.gson.reflect.TypeToken;
import com.newrelic.com.google.gson.stream.JsonReader;
import com.newrelic.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
   private final ConstructorConstructor constructorConstructor;
   private final Excluder excluder;
   private final FieldNamingStrategy fieldNamingPolicy;

   public ReflectiveTypeAdapterFactory(ConstructorConstructor var1, FieldNamingStrategy var2, Excluder var3) {
      this.constructorConstructor = var1;
      this.fieldNamingPolicy = var2;
      this.excluder = var3;
   }

   private ReflectiveTypeAdapterFactory.BoundField createBoundField(final Gson var1, final Field var2, final String var3, final TypeToken<?> var4, final boolean var5, final boolean var6) {
      return new ReflectiveTypeAdapterFactory.BoundField(var3, var5, var6) {
         final TypeAdapter<?> typeAdapter;
         // $FF: synthetic field
         final boolean val$isPrimitive;

         {
            this.val$isPrimitive = var8;
            this.typeAdapter = var1.getAdapter(var4);
         }

         void read(JsonReader var1x, Object var2x) throws IOException, IllegalAccessException {
            Object var3 = this.typeAdapter.read(var1x);
            if(var3 != null || !this.val$isPrimitive) {
               var2.set(var2x, var3);
            }

         }

         void write(JsonWriter var1x, Object var2x) throws IOException, IllegalAccessException {
            Object var3 = var2.get(var2x);
            (new TypeAdapterRuntimeTypeWrapper(var1, this.typeAdapter, var4.getType())).write(var1x, var3);
         }
      };
   }

   private Map<String, ReflectiveTypeAdapterFactory.BoundField> getBoundFields(Gson var1, TypeToken<?> var2, Class<?> var3) {
      LinkedHashMap var4 = new LinkedHashMap();
      if(!var3.isInterface()) {
         for(Type var5 = var2.getType(); var3 != Object.class; var3 = var2.getRawType()) {
            Field[] var6 = var3.getDeclaredFields();
            int var7 = var6.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               Field var11 = var6[var8];
               boolean var12 = this.excludeField(var11, true);
               boolean var13 = this.excludeField(var11, false);
               if(var12 || var13) {
                  var11.setAccessible(true);
                  Type var14 = var2.getType();
                  Type var15 = var11.getGenericType();
                  Type var16 = $Gson$Types.resolve(var14, var3, var15);
                  ReflectiveTypeAdapterFactory.BoundField var17 = this.createBoundField(var1, var11, this.getFieldName(var11), TypeToken.get(var16), var12, var13);
                  ReflectiveTypeAdapterFactory.BoundField var18 = (ReflectiveTypeAdapterFactory.BoundField)var4.put(var17.name, var17);
                  if(var18 != null) {
                     throw new IllegalArgumentException(var5 + " declares multiple JSON fields named " + var18.name);
                  }
               }
            }

            Type var9 = var2.getType();
            Type var10 = var3.getGenericSuperclass();
            var2 = TypeToken.get($Gson$Types.resolve(var9, var3, var10));
         }
      }

      return var4;
   }

   private String getFieldName(Field var1) {
      SerializedName var2 = (SerializedName)var1.getAnnotation(SerializedName.class);
      return var2 == null?this.fieldNamingPolicy.translateName(var1):var2.value();
   }

   public <T> TypeAdapter<T> create(Gson var1, TypeToken<T> var2) {
      Class var3 = var2.getRawType();
      return !Object.class.isAssignableFrom(var3)?null:new ReflectiveTypeAdapterFactory.Adapter(this.constructorConstructor.get(var2), this.getBoundFields(var1, var2, var3), null);
   }

   public boolean excludeField(Field var1, boolean var2) {
      return !this.excluder.excludeClass(var1.getType(), var2) && !this.excluder.excludeField(var1, var2);
   }

   public static final class Adapter<T> extends TypeAdapter<T> {
      private final Map<String, ReflectiveTypeAdapterFactory.BoundField> boundFields;
      private final ObjectConstructor<T> constructor;

      private Adapter(ObjectConstructor<T> var1, Map<String, ReflectiveTypeAdapterFactory.BoundField> var2) {
         this.constructor = var1;
         this.boundFields = var2;
      }

      // $FF: synthetic method
      Adapter(ObjectConstructor var1, Map var2, Object var3) {
         this(var1, var2);
      }

      public T read(JsonReader param1) throws IOException {
         // $FF: Couldn't be decompiled
      }

      public void write(JsonWriter param1, T param2) throws IOException {
         // $FF: Couldn't be decompiled
      }
   }

   abstract static class BoundField {
      final boolean deserialized;
      final String name;
      final boolean serialized;

      protected BoundField(String var1, boolean var2, boolean var3) {
         this.name = var1;
         this.serialized = var2;
         this.deserialized = var3;
      }

      abstract void read(JsonReader var1, Object var2) throws IOException, IllegalAccessException;

      abstract void write(JsonWriter var1, Object var2) throws IOException, IllegalAccessException;
   }
}
