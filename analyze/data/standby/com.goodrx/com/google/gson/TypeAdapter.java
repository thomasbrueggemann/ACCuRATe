package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public abstract class TypeAdapter<T> {
   public final TypeAdapter<T> nullSafe() {
      return new TypeAdapter() {
         public T read(JsonReader var1) throws IOException {
            if(var1.peek() == JsonToken.NULL) {
               var1.nextNull();
               return null;
            } else {
               return TypeAdapter.this.read(var1);
            }
         }

         public void write(JsonWriter var1, T var2) throws IOException {
            if(var2 == null) {
               var1.nullValue();
            } else {
               TypeAdapter.this.write(var1, var2);
            }
         }
      };
   }

   public abstract T read(JsonReader var1) throws IOException;

   public final JsonElement toJsonTree(T var1) {
      try {
         JsonTreeWriter var2 = new JsonTreeWriter();
         this.write(var2, var1);
         JsonElement var4 = var2.get();
         return var4;
      } catch (IOException var5) {
         throw new JsonIOException(var5);
      }
   }

   public abstract void write(JsonWriter var1, T var2) throws IOException;
}
