package com.newrelic.com.google.gson;

import com.newrelic.com.google.gson.JsonDeserializationContext;
import com.newrelic.com.google.gson.JsonDeserializer;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonParseException;
import com.newrelic.com.google.gson.JsonPrimitive;
import com.newrelic.com.google.gson.JsonSerializationContext;
import com.newrelic.com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

final class DefaultDateTypeAdapter implements JsonDeserializer<Date>, JsonSerializer<Date> {
   private final DateFormat enUsFormat;
   private final DateFormat iso8601Format;
   private final DateFormat localFormat;

   DefaultDateTypeAdapter() {
      this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
   }

   DefaultDateTypeAdapter(int var1) {
      this(DateFormat.getDateInstance(var1, Locale.US), DateFormat.getDateInstance(var1));
   }

   public DefaultDateTypeAdapter(int var1, int var2) {
      this(DateFormat.getDateTimeInstance(var1, var2, Locale.US), DateFormat.getDateTimeInstance(var1, var2));
   }

   DefaultDateTypeAdapter(String var1) {
      this(new SimpleDateFormat(var1, Locale.US), new SimpleDateFormat(var1));
   }

   DefaultDateTypeAdapter(DateFormat var1, DateFormat var2) {
      this.enUsFormat = var1;
      this.localFormat = var2;
      this.iso8601Format = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss\'Z\'", Locale.US);
      this.iso8601Format.setTimeZone(TimeZone.getTimeZone("UTC"));
   }

   private Date deserializeToDate(JsonElement param1) {
      // $FF: Couldn't be decompiled
   }

   public Date deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      if(!(var1 instanceof JsonPrimitive)) {
         throw new JsonParseException("The date should be a string value");
      } else {
         Date var4 = this.deserializeToDate(var1);
         if(var2 == Date.class) {
            return var4;
         } else if(var2 == Timestamp.class) {
            return new Timestamp(var4.getTime());
         } else if(var2 == java.sql.Date.class) {
            return new java.sql.Date(var4.getTime());
         } else {
            throw new IllegalArgumentException(this.getClass() + " cannot deserialize to " + var2);
         }
      }
   }

   public JsonElement serialize(Date param1, Type param2, JsonSerializationContext param3) {
      // $FF: Couldn't be decompiled
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(DefaultDateTypeAdapter.class.getSimpleName());
      var1.append('(').append(this.localFormat.getClass().getSimpleName()).append(')');
      return var1.toString();
   }
}
