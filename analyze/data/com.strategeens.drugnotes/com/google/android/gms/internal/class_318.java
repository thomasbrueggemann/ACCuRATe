package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.class_319;
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

// $FF: renamed from: com.google.android.gms.internal.ix
public class class_318 {
   // $FF: renamed from: Hh com.google.android.gms.internal.is
   private static final class_319 field_786 = new class_319("MetadataUtils");
   // $FF: renamed from: Iq java.lang.String[]
   private static final String[] field_787 = new String[]{"Z", "+hh", "+hhmm", "+hh:mm"};
   // $FF: renamed from: Ir java.lang.String
   private static final String field_788;

   static {
      field_788 = "yyyyMMdd\'T\'HHmmss" + field_787[0];
   }

   // $FF: renamed from: a (java.util.Calendar) java.lang.String
   public static String method_2222(Calendar var0) {
      String var3;
      if(var0 == null) {
         field_786.method_2233("Calendar object cannot be null", new Object[0]);
         var3 = null;
      } else {
         String var1 = field_788;
         if(var0.get(11) == 0 && var0.get(12) == 0 && var0.get(13) == 0) {
            var1 = "yyyyMMdd";
         }

         SimpleDateFormat var2 = new SimpleDateFormat(var1);
         var2.setTimeZone(var0.getTimeZone());
         var3 = var2.format(var0.getTime());
         if(var3.endsWith("+0000")) {
            return var3.replace("+0000", field_787[0]);
         }
      }

      return var3;
   }

   // $FF: renamed from: a (java.util.List, org.json.JSONObject) void
   public static void method_2223(List<WebImage> param0, JSONObject param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (org.json.JSONObject, java.util.List) void
   public static void method_2224(JSONObject var0, List<WebImage> var1) {
      if(var1 != null && !var1.isEmpty()) {
         JSONArray var2 = new JSONArray();
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            var2.put(((WebImage)var3.next()).toJson());
         }

         try {
            var0.put("images", var2);
         } catch (JSONException var5) {
            return;
         }
      }

   }

   // $FF: renamed from: aL (java.lang.String) java.util.Calendar
   public static Calendar method_2225(String var0) {
      if(TextUtils.isEmpty(var0)) {
         field_786.method_2233("Input string is empty or null", new Object[0]);
         return null;
      } else {
         String var1 = method_2226(var0);
         if(TextUtils.isEmpty(var1)) {
            field_786.method_2233("Invalid date format", new Object[0]);
            return null;
         } else {
            String var2 = method_2227(var0);
            String var3 = "yyyyMMdd";
            if(!TextUtils.isEmpty(var2)) {
               var1 = var1 + "T" + var2;
               if(var2.length() == "HHmmss".length()) {
                  var3 = "yyyyMMdd\'T\'HHmmss";
               } else {
                  var3 = field_788;
               }
            }

            Calendar var4 = GregorianCalendar.getInstance();

            Date var8;
            try {
               var8 = (new SimpleDateFormat(var3)).parse(var1);
            } catch (ParseException var9) {
               class_319 var6 = field_786;
               Object[] var7 = new Object[]{var9.getMessage()};
               var6.method_2233("Error parsing string: %s", var7);
               return null;
            }

            var4.setTime(var8);
            return var4;
         }
      }
   }

   // $FF: renamed from: aM (java.lang.String) java.lang.String
   private static String method_2226(String var0) {
      if(TextUtils.isEmpty(var0)) {
         field_786.method_2233("Input string is empty or null", new Object[0]);
         return null;
      } else {
         try {
            String var4 = var0.substring(0, "yyyyMMdd".length());
            return var4;
         } catch (IndexOutOfBoundsException var5) {
            class_319 var2 = field_786;
            Object[] var3 = new Object[]{var5.getMessage()};
            var2.method_2234("Error extracting the date: %s", var3);
            return null;
         }
      }
   }

   // $FF: renamed from: aN (java.lang.String) java.lang.String
   private static String method_2227(String var0) {
      if(TextUtils.isEmpty(var0)) {
         field_786.method_2233("string is empty or null", new Object[0]);
      } else {
         int var1 = var0.indexOf(84);
         int var2 = var1 + 1;
         if(var1 != "yyyyMMdd".length()) {
            field_786.method_2233("T delimeter is not found", new Object[0]);
            return null;
         }

         String var6;
         try {
            var6 = var0.substring(var2);
         } catch (IndexOutOfBoundsException var7) {
            class_319 var4 = field_786;
            Object[] var5 = new Object[]{var7.getMessage()};
            var4.method_2233("Error extracting the time substring: %s", var5);
            return null;
         }

         if(var6.length() == "HHmmss".length()) {
            return var6;
         }

         switch(var6.charAt("HHmmss".length())) {
         case '+':
         case '-':
            if(method_2228(var6)) {
               return var6.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
            }
            break;
         case 'Z':
            if(var6.length() == "HHmmss".length() + field_787[0].length()) {
               return var6.substring(0, -1 + var6.length()) + "+0000";
            }
            break;
         default:
            return null;
         }
      }

      return null;
   }

   // $FF: renamed from: aO (java.lang.String) boolean
   private static boolean method_2228(String var0) {
      int var1 = var0.length();
      int var2 = "HHmmss".length();
      return var1 == var2 + field_787[1].length() || var1 == var2 + field_787[2].length() || var1 == var2 + field_787[3].length();
   }
}
