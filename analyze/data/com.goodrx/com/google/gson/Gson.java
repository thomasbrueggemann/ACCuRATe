package com.google.gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson {
   private final ThreadLocal<Map<TypeToken<?>, Gson.FutureTypeAdapter<?>>> calls;
   private final ConstructorConstructor constructorConstructor;
   final JsonDeserializationContext deserializationContext;
   private final List<TypeAdapterFactory> factories;
   private final boolean generateNonExecutableJson;
   private final boolean htmlSafe;
   private final boolean lenient;
   private final boolean prettyPrinting;
   final JsonSerializationContext serializationContext;
   private final boolean serializeNulls;
   private final Map<TypeToken<?>, TypeAdapter<?>> typeTokenCache;

   public Gson() {
      this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
   }

   Gson(Excluder var1, FieldNamingStrategy var2, Map<Type, InstanceCreator<?>> var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10, LongSerializationPolicy var11, List<TypeAdapterFactory> var12) {
      this.calls = new ThreadLocal();
      this.typeTokenCache = Collections.synchronizedMap(new HashMap());
      this.deserializationContext = new JsonDeserializationContext() {
      };
      this.serializationContext = new JsonSerializationContext() {
      };
      this.constructorConstructor = new ConstructorConstructor(var3);
      this.serializeNulls = var4;
      this.generateNonExecutableJson = var6;
      this.htmlSafe = var7;
      this.prettyPrinting = var8;
      this.lenient = var9;
      ArrayList var13 = new ArrayList();
      var13.add(TypeAdapters.JSON_ELEMENT_FACTORY);
      var13.add(ObjectTypeAdapter.FACTORY);
      var13.add(var1);
      var13.addAll(var12);
      var13.add(TypeAdapters.STRING_FACTORY);
      var13.add(TypeAdapters.INTEGER_FACTORY);
      var13.add(TypeAdapters.BOOLEAN_FACTORY);
      var13.add(TypeAdapters.BYTE_FACTORY);
      var13.add(TypeAdapters.SHORT_FACTORY);
      TypeAdapter var23 = longAdapter(var11);
      var13.add(TypeAdapters.newFactory(Long.TYPE, Long.class, var23));
      var13.add(TypeAdapters.newFactory(Double.TYPE, Double.class, this.doubleAdapter(var10)));
      var13.add(TypeAdapters.newFactory(Float.TYPE, Float.class, this.floatAdapter(var10)));
      var13.add(TypeAdapters.NUMBER_FACTORY);
      var13.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
      var13.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
      var13.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(var23)));
      var13.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(var23)));
      var13.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
      var13.add(TypeAdapters.CHARACTER_FACTORY);
      var13.add(TypeAdapters.STRING_BUILDER_FACTORY);
      var13.add(TypeAdapters.STRING_BUFFER_FACTORY);
      var13.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
      var13.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
      var13.add(TypeAdapters.URL_FACTORY);
      var13.add(TypeAdapters.URI_FACTORY);
      var13.add(TypeAdapters.UUID_FACTORY);
      var13.add(TypeAdapters.CURRENCY_FACTORY);
      var13.add(TypeAdapters.LOCALE_FACTORY);
      var13.add(TypeAdapters.INET_ADDRESS_FACTORY);
      var13.add(TypeAdapters.BIT_SET_FACTORY);
      var13.add(DateTypeAdapter.FACTORY);
      var13.add(TypeAdapters.CALENDAR_FACTORY);
      var13.add(TimeTypeAdapter.FACTORY);
      var13.add(SqlDateTypeAdapter.FACTORY);
      var13.add(TypeAdapters.TIMESTAMP_FACTORY);
      var13.add(ArrayTypeAdapter.FACTORY);
      var13.add(TypeAdapters.CLASS_FACTORY);
      var13.add(new CollectionTypeAdapterFactory(this.constructorConstructor));
      var13.add(new MapTypeAdapterFactory(this.constructorConstructor, var5));
      var13.add(new JsonAdapterAnnotationTypeAdapterFactory(this.constructorConstructor));
      var13.add(TypeAdapters.ENUM_FACTORY);
      var13.add(new ReflectiveTypeAdapterFactory(this.constructorConstructor, var2, var1));
      this.factories = Collections.unmodifiableList(var13);
   }

   private static void assertFullConsumption(Object var0, JsonReader var1) {
      if(var0 != null) {
         try {
            if(var1.peek() != JsonToken.END_DOCUMENT) {
               throw new JsonIOException("JSON document was not fully consumed.");
            }
         } catch (MalformedJsonException var4) {
            throw new JsonSyntaxException(var4);
         } catch (IOException var5) {
            throw new JsonIOException(var5);
         }
      }

   }

   private static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> var0) {
      return (new TypeAdapter() {
         public AtomicLong read(JsonReader var1) throws IOException {
            return new AtomicLong(((Number)var0.read(var1)).longValue());
         }

         public void write(JsonWriter var1, AtomicLong var2) throws IOException {
            var0.write(var1, Long.valueOf(var2.get()));
         }
      }).nullSafe();
   }

   private static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> var0) {
      return (new TypeAdapter() {
         public AtomicLongArray read(JsonReader var1) throws IOException {
            ArrayList var2 = new ArrayList();
            var1.beginArray();

            while(var1.hasNext()) {
               var2.add(Long.valueOf(((Number)var0.read(var1)).longValue()));
            }

            var1.endArray();
            int var3 = var2.size();
            AtomicLongArray var4 = new AtomicLongArray(var3);

            for(int var5 = 0; var5 < var3; ++var5) {
               var4.set(var5, ((Long)var2.get(var5)).longValue());
            }

            return var4;
         }

         public void write(JsonWriter var1, AtomicLongArray var2) throws IOException {
            var1.beginArray();
            int var4 = 0;

            for(int var5 = var2.length(); var4 < var5; ++var4) {
               var0.write(var1, Long.valueOf(var2.get(var4)));
            }

            var1.endArray();
         }
      }).nullSafe();
   }

   static void checkValidFloatingPoint(double var0) {
      if(Double.isNaN(var0) || Double.isInfinite(var0)) {
         throw new IllegalArgumentException(var0 + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
      }
   }

   private TypeAdapter<Number> doubleAdapter(boolean var1) {
      return var1?TypeAdapters.DOUBLE:new TypeAdapter() {
         public Double read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return Double.valueOf(var1.nextDouble());
            }
         }

         public void write(JsonWriter var1, Number var2) throws IOException {
            if(var2 == null) {
               var1.nullValue();
            } else {
               Gson.checkValidFloatingPoint(var2.doubleValue());
               var1.value(var2);
            }
         }
      };
   }

   private TypeAdapter<Number> floatAdapter(boolean var1) {
      return var1?TypeAdapters.FLOAT:new TypeAdapter() {
         public Float read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return Float.valueOf((float)var1.nextDouble());
            }
         }

         public void write(JsonWriter var1, Number var2) throws IOException {
            if(var2 == null) {
               var1.nullValue();
            } else {
               Gson.checkValidFloatingPoint((double)var2.floatValue());
               var1.value(var2);
            }
         }
      };
   }

   private static TypeAdapter<Number> longAdapter(LongSerializationPolicy var0) {
      return var0 == LongSerializationPolicy.DEFAULT?TypeAdapters.LONG:new TypeAdapter() {
         public Number read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return Long.valueOf(var1.nextLong());
            }
         }

         public void write(JsonWriter var1, Number var2) throws IOException {
            if(var2 == null) {
               var1.nullValue();
            } else {
               var1.value(var2.toString());
            }
         }
      };
   }

   public <T> T fromJson(JsonElement var1, Class<T> var2) throws JsonSyntaxException {
      Object var3 = this.fromJson((JsonElement)var1, (Type)var2);
      return Primitives.wrap(var2).cast(var3);
   }

   public <T> T fromJson(JsonElement var1, Type var2) throws JsonSyntaxException {
      return var1 == null?null:this.fromJson((JsonReader)(new JsonTreeReader(var1)), (Type)var2);
   }

   public <T> T fromJson(JsonReader param1, Type param2) throws JsonIOException, JsonSyntaxException {
      // $FF: Couldn't be decompiled
   }

   public <T> T fromJson(Reader var1, Class<T> var2) throws JsonSyntaxException, JsonIOException {
      JsonReader var3 = this.newJsonReader(var1);
      Object var4 = this.fromJson((JsonReader)var3, (Type)var2);
      assertFullConsumption(var4, var3);
      return Primitives.wrap(var2).cast(var4);
   }

   public <T> T fromJson(Reader var1, Type var2) throws JsonIOException, JsonSyntaxException {
      JsonReader var3 = this.newJsonReader(var1);
      Object var4 = this.fromJson(var3, var2);
      assertFullConsumption(var4, var3);
      return var4;
   }

   public <T> T fromJson(String var1, Class<T> var2) throws JsonSyntaxException {
      Object var3 = this.fromJson((String)var1, (Type)var2);
      return Primitives.wrap(var2).cast(var3);
   }

   public <T> T fromJson(String var1, Type var2) throws JsonSyntaxException {
      return var1 == null?null:this.fromJson((Reader)(new StringReader(var1)), (Type)var2);
   }

   public <T> TypeAdapter<T> getAdapter(TypeToken<T> param1) {
      // $FF: Couldn't be decompiled
   }

   public <T> TypeAdapter<T> getAdapter(Class<T> var1) {
      return this.getAdapter(TypeToken.get(var1));
   }

   public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory var1, TypeToken<T> var2) {
      boolean var3 = this.factories.contains(var1);
      boolean var4 = false;
      if(!var3) {
         var4 = true;
      }

      Iterator var5 = this.factories.iterator();

      while(var5.hasNext()) {
         TypeAdapterFactory var6 = (TypeAdapterFactory)var5.next();
         if(!var4) {
            if(var6 == var1) {
               var4 = true;
            }
         } else {
            TypeAdapter var7 = var6.create(this, var2);
            if(var7 != null) {
               return var7;
            }
         }
      }

      throw new IllegalArgumentException("GSON cannot serialize " + var2);
   }

   public JsonReader newJsonReader(Reader var1) {
      JsonReader var2 = new JsonReader(var1);
      var2.setLenient(this.lenient);
      return var2;
   }

   public JsonWriter newJsonWriter(Writer var1) throws IOException {
      if(this.generateNonExecutableJson) {
         var1.write(")]}\'\n");
      }

      JsonWriter var2 = new JsonWriter(var1);
      if(this.prettyPrinting) {
         var2.setIndent("  ");
      }

      var2.setSerializeNulls(this.serializeNulls);
      return var2;
   }

   public String toJson(JsonElement var1) {
      StringWriter var2 = new StringWriter();
      this.toJson((JsonElement)var1, (Appendable)var2);
      return var2.toString();
   }

   public String toJson(Object var1) {
      return var1 == null?this.toJson((JsonElement)JsonNull.INSTANCE):this.toJson((Object)var1, (Type)var1.getClass());
   }

   public String toJson(Object var1, Type var2) {
      StringWriter var3 = new StringWriter();
      this.toJson(var1, var2, (Appendable)var3);
      return var3.toString();
   }

   public void toJson(JsonElement var1, JsonWriter var2) throws JsonIOException {
      boolean var3 = var2.isLenient();
      var2.setLenient(true);
      boolean var4 = var2.isHtmlSafe();
      var2.setHtmlSafe(this.htmlSafe);
      boolean var5 = var2.getSerializeNulls();
      var2.setSerializeNulls(this.serializeNulls);

      try {
         Streams.write(var1, var2);
      } catch (IOException var10) {
         throw new JsonIOException(var10);
      } finally {
         var2.setLenient(var3);
         var2.setHtmlSafe(var4);
         var2.setSerializeNulls(var5);
      }

   }

   public void toJson(JsonElement var1, Appendable var2) throws JsonIOException {
      try {
         this.toJson(var1, this.newJsonWriter(Streams.writerForAppendable(var2)));
      } catch (IOException var4) {
         throw new RuntimeException(var4);
      }
   }

   public void toJson(Object var1, Appendable var2) throws JsonIOException {
      if(var1 != null) {
         this.toJson(var1, var1.getClass(), (Appendable)var2);
      } else {
         this.toJson((JsonElement)JsonNull.INSTANCE, (Appendable)var2);
      }
   }

   public void toJson(Object var1, Type var2, JsonWriter var3) throws JsonIOException {
      TypeAdapter var4 = this.getAdapter(TypeToken.get(var2));
      boolean var5 = var3.isLenient();
      var3.setLenient(true);
      boolean var6 = var3.isHtmlSafe();
      var3.setHtmlSafe(this.htmlSafe);
      boolean var7 = var3.getSerializeNulls();
      var3.setSerializeNulls(this.serializeNulls);

      try {
         var4.write(var3, var1);
      } catch (IOException var12) {
         throw new JsonIOException(var12);
      } finally {
         var3.setLenient(var5);
         var3.setHtmlSafe(var6);
         var3.setSerializeNulls(var7);
      }

   }

   public void toJson(Object var1, Type var2, Appendable var3) throws JsonIOException {
      try {
         this.toJson(var1, var2, this.newJsonWriter(Streams.writerForAppendable(var3)));
      } catch (IOException var5) {
         throw new JsonIOException(var5);
      }
   }

   public String toString() {
      return "{serializeNulls:" + this.serializeNulls + "factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
   }

   static class FutureTypeAdapter<T> extends TypeAdapter<T> {
      private TypeAdapter<T> delegate;

      public T read(JsonReader var1) throws IOException {
         if(this.delegate == null) {
            throw new IllegalStateException();
         } else {
            return this.delegate.read(var1);
         }
      }

      public void setDelegate(TypeAdapter<T> var1) {
         if(this.delegate != null) {
            throw new AssertionError();
         } else {
            this.delegate = var1;
         }
      }

      public void write(JsonWriter var1, T var2) throws IOException {
         if(this.delegate == null) {
            throw new IllegalStateException();
         } else {
            this.delegate.write(var1, var2);
         }
      }
   }
}
