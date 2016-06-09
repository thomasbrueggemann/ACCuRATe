package com.newrelic.com.google.gson;

import com.newrelic.com.google.gson.FieldNamingPolicy;
import com.newrelic.com.google.gson.FieldNamingStrategy;
import com.newrelic.com.google.gson.InstanceCreator;
import com.newrelic.com.google.gson.JsonDeserializationContext;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonIOException;
import com.newrelic.com.google.gson.JsonNull;
import com.newrelic.com.google.gson.JsonParseException;
import com.newrelic.com.google.gson.JsonSerializationContext;
import com.newrelic.com.google.gson.JsonSyntaxException;
import com.newrelic.com.google.gson.LongSerializationPolicy;
import com.newrelic.com.google.gson.TypeAdapter;
import com.newrelic.com.google.gson.TypeAdapterFactory;
import com.newrelic.com.google.gson.internal.ConstructorConstructor;
import com.newrelic.com.google.gson.internal.Excluder;
import com.newrelic.com.google.gson.internal.Primitives;
import com.newrelic.com.google.gson.internal.Streams;
import com.newrelic.com.google.gson.internal.bind.ArrayTypeAdapter;
import com.newrelic.com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.newrelic.com.google.gson.internal.bind.DateTypeAdapter;
import com.newrelic.com.google.gson.internal.bind.JsonTreeReader;
import com.newrelic.com.google.gson.internal.bind.JsonTreeWriter;
import com.newrelic.com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.newrelic.com.google.gson.internal.bind.ObjectTypeAdapter;
import com.newrelic.com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.newrelic.com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.newrelic.com.google.gson.internal.bind.TimeTypeAdapter;
import com.newrelic.com.google.gson.internal.bind.TypeAdapters;
import com.newrelic.com.google.gson.reflect.TypeToken;
import com.newrelic.com.google.gson.stream.JsonReader;
import com.newrelic.com.google.gson.stream.JsonToken;
import com.newrelic.com.google.gson.stream.JsonWriter;
import com.newrelic.com.google.gson.stream.MalformedJsonException;
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

public final class Gson {
   static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
   private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}\'\n";
   private final ThreadLocal<Map<TypeToken<?>, Gson.FutureTypeAdapter<?>>> calls;
   private final ConstructorConstructor constructorConstructor;
   final JsonDeserializationContext deserializationContext;
   private final List<TypeAdapterFactory> factories;
   private final boolean generateNonExecutableJson;
   private final boolean htmlSafe;
   private final boolean prettyPrinting;
   final JsonSerializationContext serializationContext;
   private final boolean serializeNulls;
   private final Map<TypeToken<?>, TypeAdapter<?>> typeTokenCache;

   public Gson() {
      this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
   }

   Gson(Excluder var1, FieldNamingStrategy var2, Map<Type, InstanceCreator<?>> var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9, LongSerializationPolicy var10, List<TypeAdapterFactory> var11) {
      this.calls = new ThreadLocal();
      this.typeTokenCache = Collections.synchronizedMap(new HashMap());
      this.deserializationContext = new JsonDeserializationContext() {
         public <T> T deserialize(JsonElement var1, Type var2) throws JsonParseException {
            return Gson.this.fromJson(var1, var2);
         }
      };
      this.serializationContext = new JsonSerializationContext() {
         public JsonElement serialize(Object var1) {
            return Gson.this.toJsonTree(var1);
         }

         public JsonElement serialize(Object var1, Type var2) {
            return Gson.this.toJsonTree(var1, var2);
         }
      };
      this.constructorConstructor = new ConstructorConstructor(var3);
      this.serializeNulls = var4;
      this.generateNonExecutableJson = var6;
      this.htmlSafe = var7;
      this.prettyPrinting = var8;
      ArrayList var12 = new ArrayList();
      var12.add(TypeAdapters.JSON_ELEMENT_FACTORY);
      var12.add(ObjectTypeAdapter.FACTORY);
      var12.add(var1);
      var12.addAll(var11);
      var12.add(TypeAdapters.STRING_FACTORY);
      var12.add(TypeAdapters.INTEGER_FACTORY);
      var12.add(TypeAdapters.BOOLEAN_FACTORY);
      var12.add(TypeAdapters.BYTE_FACTORY);
      var12.add(TypeAdapters.SHORT_FACTORY);
      var12.add(TypeAdapters.newFactory(Long.TYPE, Long.class, this.longAdapter(var10)));
      var12.add(TypeAdapters.newFactory(Double.TYPE, Double.class, this.doubleAdapter(var9)));
      var12.add(TypeAdapters.newFactory(Float.TYPE, Float.class, this.floatAdapter(var9)));
      var12.add(TypeAdapters.NUMBER_FACTORY);
      var12.add(TypeAdapters.CHARACTER_FACTORY);
      var12.add(TypeAdapters.STRING_BUILDER_FACTORY);
      var12.add(TypeAdapters.STRING_BUFFER_FACTORY);
      var12.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
      var12.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
      var12.add(TypeAdapters.URL_FACTORY);
      var12.add(TypeAdapters.URI_FACTORY);
      var12.add(TypeAdapters.UUID_FACTORY);
      var12.add(TypeAdapters.LOCALE_FACTORY);
      var12.add(TypeAdapters.INET_ADDRESS_FACTORY);
      var12.add(TypeAdapters.BIT_SET_FACTORY);
      var12.add(DateTypeAdapter.FACTORY);
      var12.add(TypeAdapters.CALENDAR_FACTORY);
      var12.add(TimeTypeAdapter.FACTORY);
      var12.add(SqlDateTypeAdapter.FACTORY);
      var12.add(TypeAdapters.TIMESTAMP_FACTORY);
      var12.add(ArrayTypeAdapter.FACTORY);
      var12.add(TypeAdapters.ENUM_FACTORY);
      var12.add(TypeAdapters.CLASS_FACTORY);
      var12.add(new CollectionTypeAdapterFactory(this.constructorConstructor));
      var12.add(new MapTypeAdapterFactory(this.constructorConstructor, var5));
      var12.add(new ReflectiveTypeAdapterFactory(this.constructorConstructor, var2, var1));
      this.factories = Collections.unmodifiableList(var12);
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

   private void checkValidFloatingPoint(double var1) {
      if(Double.isNaN(var1) || Double.isInfinite(var1)) {
         throw new IllegalArgumentException(var1 + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
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
               double var3 = var2.doubleValue();
               Gson.this.checkValidFloatingPoint(var3);
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
               float var3 = var2.floatValue();
               Gson.this.checkValidFloatingPoint((double)var3);
               var1.value(var2);
            }
         }
      };
   }

   private TypeAdapter<Number> longAdapter(LongSerializationPolicy var1) {
      return var1 == LongSerializationPolicy.DEFAULT?TypeAdapters.LONG:new TypeAdapter() {
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

   private JsonWriter newJsonWriter(Writer var1) throws IOException {
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
      JsonReader var3 = new JsonReader(var1);
      Object var4 = this.fromJson((JsonReader)var3, (Type)var2);
      assertFullConsumption(var4, var3);
      return Primitives.wrap(var2).cast(var4);
   }

   public <T> T fromJson(Reader var1, Type var2) throws JsonIOException, JsonSyntaxException {
      JsonReader var3 = new JsonReader(var1);
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
      boolean var3 = false;
      Iterator var4 = this.factories.iterator();

      while(var4.hasNext()) {
         TypeAdapterFactory var5 = (TypeAdapterFactory)var4.next();
         if(!var3) {
            if(var5 == var1) {
               var3 = true;
            }
         } else {
            TypeAdapter var6 = var5.create(this, var2);
            if(var6 != null) {
               return var6;
            }
         }
      }

      throw new IllegalArgumentException("GSON cannot serialize " + var2);
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

   public JsonElement toJsonTree(Object var1) {
      return (JsonElement)(var1 == null?JsonNull.INSTANCE:this.toJsonTree(var1, var1.getClass()));
   }

   public JsonElement toJsonTree(Object var1, Type var2) {
      JsonTreeWriter var3 = new JsonTreeWriter();
      this.toJson(var1, var2, (JsonWriter)var3);
      return var3.get();
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
