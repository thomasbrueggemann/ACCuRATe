package com.koushikdutta.async.http.libcore;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class HttpDate {
   private static final String[] BROWSER_COMPATIBLE_DATE_FORMATS = new String[]{"EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
   private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT = new ThreadLocal() {
      protected DateFormat initialValue() {
         SimpleDateFormat var1 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
         var1.setTimeZone(TimeZone.getTimeZone("UTC"));
         return var1;
      }
   };

   public static String format(Date var0) {
      return ((DateFormat)STANDARD_DATE_FORMAT.get()).format(var0);
   }

   public static Date parse(String var0) {
      try {
         Date var8 = ((DateFormat)STANDARD_DATE_FORMAT.get()).parse(var0);
         return var8;
      } catch (ParseException var10) {
         String[] var2 = BROWSER_COMPATIBLE_DATE_FORMATS;
         int var3 = var2.length;
         int var4 = 0;

         while(var4 < var3) {
            String var5 = var2[var4];

            try {
               Date var7 = (new SimpleDateFormat(var5, Locale.US)).parse(var0);
               return var7;
            } catch (ParseException var9) {
               ++var4;
            }
         }

         return null;
      }
   }
}
