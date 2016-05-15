package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
   private final ConstructorConstructor constructorConstructor;

   public CollectionTypeAdapterFactory(ConstructorConstructor var1) {
      this.constructorConstructor = var1;
   }

   public <T> TypeAdapter<T> create(Gson var1, TypeToken<T> var2) {
      Type var3 = var2.getType();
      Class var4 = var2.getRawType();
      if(!Collection.class.isAssignableFrom(var4)) {
         return null;
      } else {
         Type var5 = $Gson$Types.getCollectionElementType(var3, var4);
         return new CollectionTypeAdapterFactory.Adapter(var1, var5, var1.getAdapter(TypeToken.get(var5)), this.constructorConstructor.get(var2));
      }
   }

   private static final class Adapter<E> extends TypeAdapter<Collection<E>> {
      private final ObjectConstructor<? extends Collection<E>> constructor;
      private final TypeAdapter<E> elementTypeAdapter;

      public Adapter(Gson var1, Type var2, TypeAdapter<E> var3, ObjectConstructor<? extends Collection<E>> var4) {
         this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper(var1, var3, var2);
         this.constructor = var4;
      }

      public Collection<E> read(JsonReader var1) throws IOException {
         if(var1.peek() == JsonToken.NULL) {
            var1.nextNull();
            return null;
         } else {
            Collection var2 = (Collection)this.constructor.construct();
            var1.beginArray();

            while(var1.hasNext()) {
               var2.add(this.elementTypeAdapter.read(var1));
            }

            var1.endArray();
            return var2;
         }
      }

      public void write(JsonWriter var1, Collection<E> var2) throws IOException {
         if(var2 == null) {
            var1.nullValue();
         } else {
            var1.beginArray();
            Iterator var4 = var2.iterator();

            while(var4.hasNext()) {
               Object var6 = var4.next();
               this.elementTypeAdapter.write(var1, var6);
            }

            var1.endArray();
         }
      }
   }
}
