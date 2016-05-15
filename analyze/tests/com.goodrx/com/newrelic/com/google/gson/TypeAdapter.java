package com.newrelic.com.google.gson;

import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonIOException;
import com.newrelic.com.google.gson.internal.bind.JsonTreeReader;
import com.newrelic.com.google.gson.internal.bind.JsonTreeWriter;
import com.newrelic.com.google.gson.stream.JsonReader;
import com.newrelic.com.google.gson.stream.JsonToken;
import com.newrelic.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class TypeAdapter<T> {
   public final T fromJson(Reader var1) throws IOException {
      return this.read(new JsonReader(var1));
   }

   public final T fromJson(String var1) throws IOException {
      return this.fromJson((Reader)(new StringReader(var1)));
   }

   public final T fromJsonTree(JsonElement var1) {
      try {
         Object var3 = this.read(new JsonTreeReader(var1));
         return var3;
      } catch (IOException var4) {
         throw new JsonIOException(var4);
      }
   }

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

   public final String toJson(T var1) throws IOException {
      StringWriter var2 = new StringWriter();
      this.toJson(var2, var1);
      return var2.toString();
   }

   public final void toJson(Writer var1, T var2) throws IOException {
      this.write(new JsonWriter(var1), var2);
   }

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
