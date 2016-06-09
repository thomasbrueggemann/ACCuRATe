package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class MapTypeAdapterFactory implements TypeAdapterFactory {
   private final boolean complexMapKeySerialization;
   private final ConstructorConstructor constructorConstructor;

   public MapTypeAdapterFactory(ConstructorConstructor var1, boolean var2) {
      this.constructorConstructor = var1;
      this.complexMapKeySerialization = var2;
   }

   private TypeAdapter<?> getKeyAdapter(Gson var1, Type var2) {
      return var2 != Boolean.TYPE && var2 != Boolean.class?var1.getAdapter(TypeToken.get(var2)):TypeAdapters.BOOLEAN_AS_STRING;
   }

   public <T> TypeAdapter<T> create(Gson var1, TypeToken<T> var2) {
      Type var3 = var2.getType();
      if(!Map.class.isAssignableFrom(var2.getRawType())) {
         return null;
      } else {
         Type[] var4 = $Gson$Types.getMapKeyAndValueTypes(var3, $Gson$Types.getRawType(var3));
         TypeAdapter var5 = this.getKeyAdapter(var1, var4[0]);
         TypeAdapter var6 = var1.getAdapter(TypeToken.get(var4[1]));
         ObjectConstructor var7 = this.constructorConstructor.get(var2);
         return new MapTypeAdapterFactory.Adapter(var1, var4[0], var5, var4[1], var6, var7);
      }
   }

   private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
      private final ObjectConstructor<? extends Map<K, V>> constructor;
      private final TypeAdapter<K> keyTypeAdapter;
      private final TypeAdapter<V> valueTypeAdapter;

      public Adapter(Gson var1, Type var2, TypeAdapter<K> var3, Type var4, TypeAdapter<V> var5, ObjectConstructor<? extends Map<K, V>> var6) {
         this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper(var2, var4, var3);
         this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper(var2, var6, var5);
         this.constructor = var7;
      }

      private String keyToString(JsonElement var1) {
         if(var1.isJsonPrimitive()) {
            JsonPrimitive var2 = var1.getAsJsonPrimitive();
            if(var2.isNumber()) {
               return String.valueOf(var2.getAsNumber());
            } else if(var2.isBoolean()) {
               return Boolean.toString(var2.getAsBoolean());
            } else if(var2.isString()) {
               return var2.getAsString();
            } else {
               throw new AssertionError();
            }
         } else if(var1.isJsonNull()) {
            return "null";
         } else {
            throw new AssertionError();
         }
      }

      public Map<K, V> read(JsonReader var1) throws IOException {
         JsonToken var2 = var1.peek();
         if(var2 == JsonToken.NULL) {
            var1.nextNull();
            return null;
         } else {
            Map var3 = (Map)this.constructor.construct();
            if(var2 == JsonToken.BEGIN_ARRAY) {
               var1.beginArray();

               while(var1.hasNext()) {
                  var1.beginArray();
                  Object var5 = this.keyTypeAdapter.read(var1);
                  if(var3.put(var5, this.valueTypeAdapter.read(var1)) != null) {
                     throw new JsonSyntaxException("duplicate key: " + var5);
                  }

                  var1.endArray();
               }

               var1.endArray();
               return var3;
            } else {
               var1.beginObject();

               Object var4;
               do {
                  if(!var1.hasNext()) {
                     var1.endObject();
                     return var3;
                  }

                  JsonReaderInternalAccess.INSTANCE.promoteNameToValue(var1);
                  var4 = this.keyTypeAdapter.read(var1);
               } while(var3.put(var4, this.valueTypeAdapter.read(var1)) == null);

               throw new JsonSyntaxException("duplicate key: " + var4);
            }
         }
      }

      public void write(JsonWriter var1, Map<K, V> var2) throws IOException {
         if(var2 == null) {
            var1.nullValue();
         } else if(!MapTypeAdapterFactory.this.complexMapKeySerialization) {
            var1.beginObject();
            Iterator var22 = var2.entrySet().iterator();

            while(var22.hasNext()) {
               Entry var24 = (Entry)var22.next();
               var1.name(String.valueOf(var24.getKey()));
               this.valueTypeAdapter.write(var1, var24.getValue());
            }

            var1.endObject();
         } else {
            boolean var3 = false;
            ArrayList var4 = new ArrayList(var2.size());
            ArrayList var5 = new ArrayList(var2.size());

            boolean var20;
            for(Iterator var6 = var2.entrySet().iterator(); var6.hasNext(); var3 |= var20) {
               Entry var16 = (Entry)var6.next();
               JsonElement var17 = this.keyTypeAdapter.toJsonTree(var16.getKey());
               var4.add(var17);
               var5.add(var16.getValue());
               if(!var17.isJsonArray() && !var17.isJsonObject()) {
                  var20 = false;
               } else {
                  var20 = true;
               }
            }

            if(var3) {
               var1.beginArray();

               for(int var12 = 0; var12 < var4.size(); ++var12) {
                  var1.beginArray();
                  Streams.write((JsonElement)var4.get(var12), var1);
                  this.valueTypeAdapter.write(var1, var5.get(var12));
                  var1.endArray();
               }

               var1.endArray();
            } else {
               var1.beginObject();

               for(int var8 = 0; var8 < var4.size(); ++var8) {
                  var1.name(this.keyToString((JsonElement)var4.get(var8)));
                  this.valueTypeAdapter.write(var1, var5.get(var8));
               }

               var1.endObject();
            }
         }
      }
   }
}
