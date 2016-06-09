package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class JsonTreeWriter extends JsonWriter {
   private static final JsonPrimitive SENTINEL_CLOSED = new JsonPrimitive("closed");
   private static final Writer UNWRITABLE_WRITER = new Writer() {
      public void close() throws IOException {
         throw new AssertionError();
      }

      public void flush() throws IOException {
         throw new AssertionError();
      }

      public void write(char[] var1, int var2, int var3) {
         throw new AssertionError();
      }
   };
   private String pendingName;
   private JsonElement product;
   private final List<JsonElement> stack = new ArrayList();

   public JsonTreeWriter() {
      super(UNWRITABLE_WRITER);
      this.product = JsonNull.INSTANCE;
   }

   private JsonElement peek() {
      return (JsonElement)this.stack.get(-1 + this.stack.size());
   }

   private void put(JsonElement var1) {
      if(this.pendingName == null) {
         if(this.stack.isEmpty()) {
            this.product = var1;
         } else {
            JsonElement var2 = this.peek();
            if(var2 instanceof JsonArray) {
               ((JsonArray)var2).add(var1);
            } else {
               throw new IllegalStateException();
            }
         }
      } else {
         if(!var1.isJsonNull() || this.getSerializeNulls()) {
            ((JsonObject)this.peek()).add(this.pendingName, var1);
         }

         this.pendingName = null;
      }
   }

   public JsonWriter beginArray() throws IOException {
      JsonArray var1 = new JsonArray();
      this.put(var1);
      this.stack.add(var1);
      return this;
   }

   public JsonWriter beginObject() throws IOException {
      JsonObject var1 = new JsonObject();
      this.put(var1);
      this.stack.add(var1);
      return this;
   }

   public void close() throws IOException {
      if(!this.stack.isEmpty()) {
         throw new IOException("Incomplete document");
      } else {
         this.stack.add(SENTINEL_CLOSED);
      }
   }

   public JsonWriter endArray() throws IOException {
      if(!this.stack.isEmpty() && this.pendingName == null) {
         if(this.peek() instanceof JsonArray) {
            this.stack.remove(-1 + this.stack.size());
            return this;
         } else {
            throw new IllegalStateException();
         }
      } else {
         throw new IllegalStateException();
      }
   }

   public JsonWriter endObject() throws IOException {
      if(!this.stack.isEmpty() && this.pendingName == null) {
         if(this.peek() instanceof JsonObject) {
            this.stack.remove(-1 + this.stack.size());
            return this;
         } else {
            throw new IllegalStateException();
         }
      } else {
         throw new IllegalStateException();
      }
   }

   public void flush() throws IOException {
   }

   public JsonElement get() {
      if(!this.stack.isEmpty()) {
         throw new IllegalStateException("Expected one JSON element but was " + this.stack);
      } else {
         return this.product;
      }
   }

   public JsonWriter name(String var1) throws IOException {
      if(!this.stack.isEmpty() && this.pendingName == null) {
         if(this.peek() instanceof JsonObject) {
            this.pendingName = var1;
            return this;
         } else {
            throw new IllegalStateException();
         }
      } else {
         throw new IllegalStateException();
      }
   }

   public JsonWriter nullValue() throws IOException {
      this.put(JsonNull.INSTANCE);
      return this;
   }

   public JsonWriter value(long var1) throws IOException {
      this.put(new JsonPrimitive(Long.valueOf(var1)));
      return this;
   }

   public JsonWriter value(Number var1) throws IOException {
      if(var1 == null) {
         return this.nullValue();
      } else {
         if(!this.isLenient()) {
            double var2 = var1.doubleValue();
            if(Double.isNaN(var2) || Double.isInfinite(var2)) {
               throw new IllegalArgumentException("JSON forbids NaN and infinities: " + var1);
            }
         }

         this.put(new JsonPrimitive(var1));
         return this;
      }
   }

   public JsonWriter value(String var1) throws IOException {
      if(var1 == null) {
         return this.nullValue();
      } else {
         this.put(new JsonPrimitive(var1));
         return this;
      }
   }

   public JsonWriter value(boolean var1) throws IOException {
      this.put(new JsonPrimitive(Boolean.valueOf(var1)));
      return this;
   }
}
