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
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class TimeTypeAdapter extends TypeAdapter<Time> {
   public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
      public <T> TypeAdapter<T> create(Gson var1, TypeToken<T> var2) {
         return var2.getRawType() == Time.class?new TimeTypeAdapter():null;
      }
   };
   private final DateFormat format = new SimpleDateFormat("hh:mm:ss a");

   public Time read(JsonReader var1) throws IOException {
      synchronized(this){}
      boolean var7 = false;

      Time var3;
      try {
         var7 = true;
         if(var1.peek() != JsonToken.NULL) {
            try {
               var3 = new Time(this.format.parse(var1.nextString()).getTime());
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

   public void write(JsonWriter param1, Time param2) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
