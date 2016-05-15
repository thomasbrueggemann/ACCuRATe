package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

public final class DateTypeAdapter extends TypeAdapter<Date> {
   public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
      public <T> TypeAdapter<T> create(Gson var1, TypeToken<T> var2) {
         return var2.getRawType() == Date.class?new DateTypeAdapter():null;
      }
   };
   private final DateFormat enUsFormat;
   private final DateFormat localFormat;

   public DateTypeAdapter() {
      this.enUsFormat = DateFormat.getDateTimeInstance(2, 2, Locale.US);
      this.localFormat = DateFormat.getDateTimeInstance(2, 2);
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
                     var6 = ISO8601Utils.parse(var1, new ParsePosition(0));
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
