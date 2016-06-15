package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.class_324;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.gt
public class class_328 {
   // $FF: renamed from: BD com.google.android.gms.internal.go
   private static final class_324 field_1336 = new class_324("MetadataUtils");
   // $FF: renamed from: CL java.lang.String[]
   private static final String[] field_1337 = new String[]{"Z", "+hh", "+hhmm", "+hh:mm"};
   // $FF: renamed from: CM java.lang.String
   private static final String field_1338;

   static {
      field_1338 = "yyyyMMdd\'T\'HHmmss" + field_1337[0];
   }

   // $FF: renamed from: a (java.util.Calendar) java.lang.String
   public static String method_2101(Calendar var0) {
      String var3;
      if(var0 == null) {
         field_1336.method_2066("Calendar object cannot be null", new Object[0]);
         var3 = null;
      } else {
         String var1 = field_1338;
         if(var0.get(11) == 0 && var0.get(12) == 0 && var0.get(13) == 0) {
            var1 = "yyyyMMdd";
         }

         SimpleDateFormat var2 = new SimpleDateFormat(var1);
         var2.setTimeZone(var0.getTimeZone());
         var3 = var2.format(var0.getTime());
         if(var3.endsWith("+0000")) {
            return var3.replace("+0000", field_1337[0]);
         }
      }

      return var3;
   }

   // $FF: renamed from: a (java.util.List, org.json.JSONObject) void
   public static void method_2102(List<WebImage> param0, JSONObject param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (org.json.JSONObject, java.util.List) void
   public static void method_2103(JSONObject var0, List<WebImage> var1) {
      if(var1 != null && !var1.isEmpty()) {
         JSONArray var2 = new JSONArray();
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            var2.put(((WebImage)var3.next()).method_4497());
         }

         try {
            var0.put("images", var2);
         } catch (JSONException var5) {
            return;
         }
      }

   }

   // $FF: renamed from: aq (java.lang.String) java.util.Calendar
   public static Calendar method_2104(String var0) {
      if(TextUtils.isEmpty(var0)) {
         field_1336.method_2066("Input string is empty or null", new Object[0]);
         return null;
      } else {
         String var1 = method_2105(var0);
         if(TextUtils.isEmpty(var1)) {
            field_1336.method_2066("Invalid date format", new Object[0]);
            return null;
         } else {
            String var2 = method_2106(var0);
            String var3 = "yyyyMMdd";
            if(!TextUtils.isEmpty(var2)) {
               var1 = var1 + "T" + var2;
               if(var2.length() == "HHmmss".length()) {
                  var3 = "yyyyMMdd\'T\'HHmmss";
               } else {
                  var3 = field_1338;
               }
            }

            Calendar var4 = GregorianCalendar.getInstance();

            Date var8;
            try {
               var8 = (new SimpleDateFormat(var3)).parse(var1);
            } catch (ParseException var9) {
               class_324 var6 = field_1336;
               Object[] var7 = new Object[]{var9.getMessage()};
               var6.method_2066("Error parsing string: %s", var7);
               return null;
            }

            var4.setTime(var8);
            return var4;
         }
      }
   }

   // $FF: renamed from: ar (java.lang.String) java.lang.String
   private static String method_2105(String var0) {
      if(TextUtils.isEmpty(var0)) {
         field_1336.method_2066("Input string is empty or null", new Object[0]);
         return null;
      } else {
         try {
            String var4 = var0.substring(0, "yyyyMMdd".length());
            return var4;
         } catch (IndexOutOfBoundsException var5) {
            class_324 var2 = field_1336;
            Object[] var3 = new Object[]{var5.getMessage()};
            var2.method_2067("Error extracting the date: %s", var3);
            return null;
         }
      }
   }

   // $FF: renamed from: as (java.lang.String) java.lang.String
   private static String method_2106(String var0) {
      if(TextUtils.isEmpty(var0)) {
         field_1336.method_2066("string is empty or null", new Object[0]);
      } else {
         int var1 = var0.indexOf(84);
         int var2 = var1 + 1;
         if(var1 != "yyyyMMdd".length()) {
            field_1336.method_2066("T delimeter is not found", new Object[0]);
            return null;
         }

         String var6;
         try {
            var6 = var0.substring(var2);
         } catch (IndexOutOfBoundsException var7) {
            class_324 var4 = field_1336;
            Object[] var5 = new Object[]{var7.getMessage()};
            var4.method_2066("Error extracting the time substring: %s", var5);
            return null;
         }

         if(var6.length() == "HHmmss".length()) {
            return var6;
         }

         switch(var6.charAt("HHmmss".length())) {
         case '+':
         case '-':
            if(method_2107(var6)) {
               return var6.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
            }
            break;
         case 'Z':
            if(var6.length() == "HHmmss".length() + field_1337[0].length()) {
               return var6.substring(0, -1 + var6.length()) + "+0000";
            }
            break;
         default:
            return null;
         }
      }

      return null;
   }

   // $FF: renamed from: at (java.lang.String) boolean
   private static boolean method_2107(String var0) {
      int var1 = var0.length();
      int var2 = "HHmmss".length();
      return var1 == var2 + field_1337[1].length() || var1 == var2 + field_1337[2].length() || var1 == var2 + field_1337[3].length();
   }
}
