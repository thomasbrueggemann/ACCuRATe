package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class ObjectTypeAdapter extends TypeAdapter<Object> {
   public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
      public <T> TypeAdapter<T> create(Gson var1, TypeToken<T> var2) {
         return var2.getRawType() == Object.class?new ObjectTypeAdapter(var1):null;
      }
   };
   private final Gson gson;

   ObjectTypeAdapter(Gson var1) {
      this.gson = var1;
   }

   public Object read(JsonReader var1) throws IOException {
      JsonToken var2 = var1.peek();
      switch(null.$SwitchMap$com$google$gson$stream$JsonToken[var2.ordinal()]) {
      case 1:
         ArrayList var5 = new ArrayList();
         var1.beginArray();

         while(var1.hasNext()) {
            var5.add(this.read(var1));
         }

         var1.endArray();
         return var5;
      case 2:
         LinkedTreeMap var3 = new LinkedTreeMap();
         var1.beginObject();

         while(var1.hasNext()) {
            var3.put(var1.nextName(), this.read(var1));
         }

         var1.endObject();
         return var3;
      case 3:
         return var1.nextString();
      case 4:
         return Double.valueOf(var1.nextDouble());
      case 5:
         return Boolean.valueOf(var1.nextBoolean());
      case 6:
         var1.nextNull();
         return null;
      default:
         throw new IllegalStateException();
      }
   }

   public void write(JsonWriter var1, Object var2) throws IOException {
      if(var2 == null) {
         var1.nullValue();
      } else {
         TypeAdapter var3 = this.gson.getAdapter(var2.getClass());
         if(var3 instanceof ObjectTypeAdapter) {
            var1.beginObject();
            var1.endObject();
         } else {
            var3.write(var1, var2);
         }
      }
   }
}
