package com.newrelic.com.google.gson.internal.bind;

import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonSyntaxException;
import com.newrelic.com.google.gson.TypeAdapter;
import com.newrelic.com.google.gson.TypeAdapterFactory;
import com.newrelic.com.google.gson.reflect.TypeToken;
import com.newrelic.com.google.gson.stream.JsonReader;
import com.newrelic.com.google.gson.stream.JsonToken;
import com.newrelic.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
   public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
      public <T> TypeAdapter<T> create(Gson var1, TypeToken<T> var2) {
         return var2.getRawType() == Date.class?new SqlDateTypeAdapter():null;
      }
   };
   private final DateFormat format = new SimpleDateFormat("MMM d, yyyy");

   public Date read(JsonReader var1) throws IOException {
      synchronized(this){}
      boolean var7 = false;

      Date var3;
      try {
         var7 = true;
         if(var1.peek() != JsonToken.NULL) {
            try {
               var3 = new Date(this.format.parse(var1.nextString()).getTime());
               var7 = false;
               return var3;
            } catch (ParseException var8) {
               throw new JsonSyntaxException(var8);
            }
         }

         var1.nextNull();
         var7 = false;
      } finally {
         if(var7) {
            ;
         }
      }

      var3 = null;
      return var3;
   }

   public void write(JsonWriter param1, Date param2) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
