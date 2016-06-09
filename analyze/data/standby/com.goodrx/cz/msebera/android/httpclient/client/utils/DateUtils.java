package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.util.Args;
import java.lang.ref.SoftReference;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class DateUtils {
   private static final String[] DEFAULT_PATTERNS = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"};
   private static final Date DEFAULT_TWO_DIGIT_YEAR_START;
   public static final TimeZone GMT = TimeZone.getTimeZone("GMT");

   static {
      Calendar var0 = Calendar.getInstance();
      var0.setTimeZone(GMT);
      var0.set(2000, 0, 1, 0, 0, 0);
      var0.set(14, 0);
      DEFAULT_TWO_DIGIT_YEAR_START = var0.getTime();
   }

   public static Date parseDate(String var0, String[] var1) {
      return parseDate(var0, var1, (Date)null);
   }

   public static Date parseDate(String var0, String[] var1, Date var2) {
      Args.notNull(var0, "Date value");
      String[] var4;
      if(var1 != null) {
         var4 = var1;
      } else {
         var4 = DEFAULT_PATTERNS;
      }

      Date var5;
      if(var2 != null) {
         var5 = var2;
      } else {
         var5 = DEFAULT_TWO_DIGIT_YEAR_START;
      }

      String var6 = var0;
      if(var0.length() > 1 && var0.startsWith("\'") && var0.endsWith("\'")) {
         var6 = var0.substring(1, -1 + var0.length());
      }

      int var7 = var4.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         SimpleDateFormat var9 = DateUtils.DateFormatHolder.formatFor(var4[var8]);
         var9.set2DigitYearStart(var5);
         ParsePosition var10 = new ParsePosition(0);
         Date var11 = var9.parse(var6, var10);
         if(var10.getIndex() != 0) {
            return var11;
         }
      }

      return null;
   }

   static final class DateFormatHolder {
      private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> THREADLOCAL_FORMATS = new ThreadLocal() {
         protected SoftReference<Map<String, SimpleDateFormat>> initialValue() {
            return new SoftReference(new HashMap());
         }
      };

      public static SimpleDateFormat formatFor(String var0) {
         Object var1 = (Map)((SoftReference)THREADLOCAL_FORMATS.get()).get();
         if(var1 == null) {
            var1 = new HashMap();
            THREADLOCAL_FORMATS.set(new SoftReference(var1));
         }

         SimpleDateFormat var2 = (SimpleDateFormat)((Map)var1).get(var0);
         if(var2 == null) {
            var2 = new SimpleDateFormat(var0, Locale.US);
            var2.setTimeZone(TimeZone.getTimeZone("GMT"));
            ((Map)var1).put(var0, var2);
         }

         return var2;
      }
   }
}
