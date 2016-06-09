package com.google.gson;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TreeTypeAdapter<T> extends TypeAdapter<T> {
   private TypeAdapter<T> delegate;
   private final JsonDeserializer<T> deserializer;
   private final Gson gson;
   private final JsonSerializer<T> serializer;
   private final TypeAdapterFactory skipPast;
   private final TypeToken<T> typeToken;

   private TreeTypeAdapter(JsonSerializer<T> var1, JsonDeserializer<T> var2, Gson var3, TypeToken<T> var4, TypeAdapterFactory var5) {
      this.serializer = var1;
      this.deserializer = var2;
      this.gson = var3;
      this.typeToken = var4;
      this.skipPast = var5;
   }

   // $FF: synthetic method
   TreeTypeAdapter(JsonSerializer var1, JsonDeserializer var2, Gson var3, TypeToken var4, TypeAdapterFactory var5, Object var6) {
      this(var1, var2, var3, var4, var5);
   }

   private TypeAdapter<T> delegate() {
      TypeAdapter var1 = this.delegate;
      if(var1 != null) {
         return var1;
      } else {
         TypeAdapter var2 = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
         this.delegate = var2;
         return var2;
      }
   }

   public static TypeAdapterFactory newFactory(TypeToken<?> var0, Object var1) {
      return new TreeTypeAdapter.SingleTypeFactory(var1, var0, false, (Class)null);
   }

   public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> var0, Object var1) {
      boolean var2;
      if(var0.getType() == var0.getRawType()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return new TreeTypeAdapter.SingleTypeFactory(var1, var0, var2, (Class)null);
   }

   public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> var0, Object var1) {
      return new TreeTypeAdapter.SingleTypeFactory(var1, (TypeToken)null, false, var0);
   }

   public T read(JsonReader var1) throws IOException {
      if(this.deserializer == null) {
         return this.delegate().read(var1);
      } else {
         JsonElement var2 = Streams.parse(var1);
         return var2.isJsonNull()?null:this.deserializer.deserialize(var2, this.typeToken.getType(), this.gson.deserializationContext);
      }
   }

   public void write(JsonWriter var1, T var2) throws IOException {
      if(this.serializer == null) {
         this.delegate().write(var1, var2);
      } else if(var2 == null) {
         var1.nullValue();
      } else {
         Streams.write(this.serializer.serialize(var2, this.typeToken.getType(), this.gson.serializationContext), var1);
      }
   }

   private static class SingleTypeFactory implements TypeAdapterFactory {
      private final JsonDeserializer<?> deserializer;
      private final TypeToken<?> exactType;
      private final Class<?> hierarchyType;
      private final boolean matchRawType;
      private final JsonSerializer<?> serializer;

      private SingleTypeFactory(Object var1, TypeToken<?> var2, boolean var3, Class<?> var4) {
         JsonSerializer var5;
         if(var1 instanceof JsonSerializer) {
            var5 = (JsonSerializer)var1;
         } else {
            var5 = null;
         }

         this.serializer = var5;
         JsonDeserializer var6;
         if(var1 instanceof JsonDeserializer) {
            var6 = (JsonDeserializer)var1;
         } else {
            var6 = null;
         }

         this.deserializer = var6;
         boolean var7;
         if(this.serializer == null && this.deserializer == null) {
            var7 = false;
         } else {
            var7 = true;
         }

         $Gson$Preconditions.checkArgument(var7);
         this.exactType = var2;
         this.matchRawType = var3;
         this.hierarchyType = var4;
      }

      // $FF: synthetic method
      SingleTypeFactory(Object var1, TypeToken var2, boolean var3, Class var4, Object var5) {
         this(var1, var2, var3, var4);
      }

      public <T> TypeAdapter<T> create(Gson var1, TypeToken<T> var2) {
         boolean var3;
         if(this.exactType != null) {
            if(!this.exactType.equals(var2) && (!this.matchRawType || this.exactType.getType() != var2.getRawType())) {
               var3 = false;
            } else {
               var3 = true;
            }
         } else {
            var3 = this.hierarchyType.isAssignableFrom(var2.getRawType());
         }

         return var3?new TreeTypeAdapter(this.serializer, this.deserializer, var1, var2, this):null;
      }
   }
}
