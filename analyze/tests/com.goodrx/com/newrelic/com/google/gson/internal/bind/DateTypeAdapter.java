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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class DateTypeAdapter extends TypeAdapter<Date> {
   public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
      public <T> TypeAdapter<T> create(Gson var1, TypeToken<T> var2) {
         return var2.getRawType() == Date.class?new DateTypeAdapter():null;
      }
   };
   private final DateFormat enUsFormat;
   private final DateFormat iso8601Format;
   private final DateFormat localFormat;

   public DateTypeAdapter() {
      this.enUsFormat = DateFormat.getDateTimeInstance(2, 2, Locale.US);
      this.localFormat = DateFormat.getDateTimeInstance(2, 2);
      this.iso8601Format = buildIso8601Format();
   }

   private static DateFormat buildIso8601Format() {
      SimpleDateFormat var0 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss\'Z\'", Locale.US);
      var0.setTimeZone(TimeZone.getTimeZone("UTC"));
      return var0;
   }

   private Date deserializeToDate(String var1) {
      synchronized(this){}
      boolean var14 = false;

      Date var7;
      Date var9;
      label84: {
         Date var8;
         label85: {
            Date var6;
            try {
               try {
                  var14 = true;
                  var9 = this.localFormat.parse(var1);
                  var14 = false;
                  break label84;
               } catch (ParseException var16) {
                  ;
               }

               try {
                  var8 = this.enUsFormat.parse(var1);
                  var14 = false;
                  break label85;
               } catch (ParseException var17) {
                  try {
                     var6 = this.iso8601Format.parse(var1);
                     var14 = false;
                  } catch (ParseException var15) {
                     throw new JsonSyntaxException(var1, var15);
                  }
               }
            } finally {
               if(var14) {
                  ;
               }
            }

            var7 = var6;
            return var7;
         }

         var7 = var8;
         return var7;
      }

      var7 = var9;
      return var7;
   }

   public Date read(JsonReader var1) throws IOException {
      if(var1.peek() == JsonToken.NULL) {
         var1.nextNull();
         return null;
      } else {
         return this.deserializeToDate(var1.nextString());
      }
   }

   public void write(JsonWriter param1, Date param2) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
