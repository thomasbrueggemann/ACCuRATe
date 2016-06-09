package com.google.ads.conversiontracking;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Log;
import com.google.ads.conversiontracking.class_72;
import com.google.ads.conversiontracking.class_73;
import com.google.ads.conversiontracking.class_77;
import com.google.ads.conversiontracking.class_87;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.ads.conversiontracking.g
@TargetApi(4)
public class class_79 {
   // $FF: renamed from: a java.util.Map
   private static final Map<String, String> field_580 = new HashMap();
   // $FF: renamed from: b boolean
   private static boolean field_581 = false;
   // $FF: renamed from: c long
   private static long field_582 = -1L;
   // $FF: renamed from: d boolean
   private static boolean field_583 = true;
   // $FF: renamed from: e boolean
   private static boolean field_584 = false;
   // $FF: renamed from: f java.lang.Object
   private static final Object field_585 = new Object();
   // $FF: renamed from: g com.google.ads.conversiontracking.e
   private static class_73 field_586 = null;
   // $FF: renamed from: h boolean
   private static boolean field_587 = false;

   // $FF: renamed from: a () long
   static long method_522() {
      return field_581 && field_582 >= 0L?field_582:System.currentTimeMillis();
   }

   // $FF: renamed from: a (android.content.Context) com.google.ads.conversiontracking.e
   public static class_73 method_523(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String) com.google.ads.conversiontracking.g$a
   public static class_79.class_94 method_524(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.net.Uri) com.google.ads.conversiontracking.g$b
   public static class_79.class_96 method_525(Uri var0) {
      if(var0 == null) {
         return null;
      } else {
         String var1 = var0.getQueryParameter("referrer");
         if(TextUtils.isEmpty(var1)) {
            return null;
         } else {
            String var2 = String.valueOf(var1);
            String var3;
            if(var2.length() != 0) {
               var3 = "http://hostname/?".concat(var2);
            } else {
               var3 = new String("http://hostname/?");
            }

            Uri var4 = Uri.parse(var3);
            String var5 = var4.getQueryParameter("conv");
            String var6 = var4.getQueryParameter("gclid");
            if(!TextUtils.isEmpty(var5) && !TextUtils.isEmpty(var6)) {
               String var7 = var4.getQueryParameter("ai");
               if(var7 == null) {
                  var7 = "";
               }

               return new class_79.class_96(var5, new class_79.class_94(var6, var7));
            } else {
               return null;
            }
         }
      }
   }

   // $FF: renamed from: a (long) java.lang.String
   static String method_526(long var0) {
      Locale var2 = Locale.US;
      Object[] var3 = new Object[]{Long.valueOf(var0 / 1000L), Long.valueOf(var0 % 1000L)};
      return String.format(var2, "%d.%03d", var3);
   }

   // $FF: renamed from: a (android.content.Context, com.google.ads.conversiontracking.g$c) java.lang.String
   public static String method_527(Context var0, class_79.class_95 var1) throws NoSuchAlgorithmException {
      return method_528(var0, var1, (new class_72(var0)).method_487());
   }

   // $FF: renamed from: a (android.content.Context, com.google.ads.conversiontracking.g$c, com.google.ads.conversiontracking.i$a) java.lang.String
   public static String method_528(Context var0, class_79.class_95 var1, class_77.class_100 var2) throws NoSuchAlgorithmException {
      String var3 = var0.getPackageName();
      String var4 = "";

      label31: {
         String var8;
         try {
            var8 = var0.getPackageManager().getPackageInfo(var3, 0).versionName;
         } catch (NameNotFoundException var9) {
            Log.w("GoogleConversionReporter", "Error to retrieve app version", var9);
            break label31;
         }

         var4 = var8;
      }

      String var7 = null;
      if(var2 == null) {
         var7 = method_548(var0);
      }

      return !var1.field_87 && var1.field_88 == class_79.class_97.field_100?method_532(var1, var3, var4, var2, var7):(var1.field_88 == class_79.class_97.field_99?method_531(var1, var2):(var1.field_88 == class_79.class_97.field_102?method_545(var1, var3, var4, var2, var7):method_544(var1, var3, var4, var2, var7)));
   }

   // $FF: renamed from: a (com.google.ads.conversiontracking.g$a) java.lang.String
   public static String method_529(class_79.class_94 var0) {
      if(var0 == null) {
         return "";
      } else if(TextUtils.isEmpty(var0.field_83)) {
         String var5 = String.valueOf("&gclid=");
         String var6 = String.valueOf(var0.field_82);
         return var6.length() != 0?var5.concat(var6):new String(var5);
      } else {
         String var1 = String.valueOf("&gclid=");
         String var2 = var0.field_82;
         String var3 = String.valueOf("ai");
         String var4 = var0.field_83;
         return (new StringBuilder(2 + String.valueOf(var1).length() + String.valueOf(var2).length() + String.valueOf(var3).length() + String.valueOf(var4).length())).append(var1).append(var2).append("&").append(var3).append("=").append(var4).toString();
      }
   }

   // $FF: renamed from: a (com.google.ads.conversiontracking.g$c) java.lang.String
   public static String method_530(class_79.class_95 var0) {
      switch(null.field_81[var0.field_88.ordinal()]) {
      case 1:
         return "doubleclick_nonrepeatable_conversion";
      case 2:
         return "iap_nonrepeatable_conversion";
      default:
         return "google_nonrepeatable_conversion";
      }
   }

   // $FF: renamed from: a (com.google.ads.conversiontracking.g$c, com.google.ads.conversiontracking.i$a) java.lang.String
   public static String method_531(class_79.class_95 var0, class_77.class_100 var1) {
      if(var1 == null) {
         return null;
      } else {
         String var2 = String.valueOf("https://pubads.g.doubleclick.net/activity;dc_iu=");
         String var3 = String.valueOf(var0.field_90);
         String var4;
         if(var3.length() != 0) {
            var4 = var2.concat(var3);
         } else {
            var4 = new String(var2);
         }

         StringBuilder var5 = new StringBuilder(var4);
         method_538(var5, var1, (String)null);
         if(var0.field_93 != null) {
            Iterator var6 = var0.field_93.entrySet().iterator();

            while(var6.hasNext()) {
               Entry var7 = (Entry)var6.next();
               String var8 = Uri.encode((String)var7.getKey());
               String var9 = Uri.encode(var7.getValue().toString());
               var5.append((new StringBuilder(2 + String.valueOf(var8).length() + String.valueOf(var9).length())).append(";").append(var8).append("=").append(var9).toString());
            }
         }

         return var5.toString();
      }
   }

   // $FF: renamed from: a (com.google.ads.conversiontracking.g$c, java.lang.String, java.lang.String, com.google.ads.conversiontracking.i$a, java.lang.String) java.lang.String
   public static String method_532(class_79.class_95 var0, String var1, String var2, class_77.class_100 var3, String var4) {
      String var5 = String.valueOf("https://pubads.g.doubleclick.net/activity;xsp=");
      String var6 = var0.field_85;
      String var7 = String.valueOf("ait");
      String var8 = String.valueOf("bundleid");
      String var9 = String.valueOf("appversion");
      String var10 = String.valueOf("osversion");
      String var11 = String.valueOf(VERSION.RELEASE);
      String var12 = String.valueOf("sdkversion");
      String var13 = String.valueOf("ct-sdk-a-v2.2.4");
      String var14 = String.valueOf("timestamp");
      String var15 = method_526(method_522());
      StringBuilder var16 = new StringBuilder((new StringBuilder(13 + String.valueOf(var5).length() + String.valueOf(var6).length() + String.valueOf(var7).length() + String.valueOf(var8).length() + String.valueOf(var1).length() + String.valueOf(var9).length() + String.valueOf(var2).length() + String.valueOf(var10).length() + String.valueOf(var11).length() + String.valueOf(var12).length() + String.valueOf(var13).length() + String.valueOf(var14).length() + String.valueOf(var15).length())).append(var5).append(var6).append(";").append(var7).append("=").append("1").append(";").append(var8).append("=").append(var1).append(";").append(var9).append("=").append(var2).append(";").append(var10).append("=").append(var11).append(";").append(var12).append("=").append(var13).append(";").append(var14).append("=").append(var15).toString());
      method_538(var16, var3, var4);
      return var16.toString();
   }

   // $FF: renamed from: a (com.google.ads.conversiontracking.i$a) java.lang.String
   private static String method_533(class_77.class_100 var0) {
      return var0 == null?null:(var0.method_170()?"1":"0");
   }

   // $FF: renamed from: a (android.content.SharedPreferences) java.util.List
   private static List<String> method_534(SharedPreferences var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.getAll().entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(class_79.class_94.method_35((String)var3.getValue()) == null) {
            var1.add(var3.getKey());
         }
      }

      return var1;
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String) void
   public static void method_535(Context var0, String var1, String var2) {
      Editor var3 = var0.getSharedPreferences(var1, 0).edit();
      var3.putBoolean(var2, true);
      var3.commit();
   }

   // $FF: renamed from: a (android.net.Uri.Builder, com.google.ads.conversiontracking.i$a, java.lang.String) void
   private static void method_536(Builder var0, class_77.class_100 var1, String var2) {
      if(method_533(var1) != null) {
         var0.appendQueryParameter("lat", method_533(var1));
      }

      if(var1 != null) {
         var0.appendQueryParameter("rdid", var1.method_169());
      } else {
         var0.appendQueryParameter("muid", var2);
      }
   }

   // $FF: renamed from: a (android.net.Uri.Builder, boolean, java.util.Map) void
   private static void method_537(Builder var0, boolean var1, Map<String, ?> var2) {
      if(var1 && var2 != null) {
         Iterator var3 = var2.entrySet().iterator();

         while(true) {
            while(var3.hasNext()) {
               Entry var4 = (Entry)var3.next();
               if(var4.getValue() instanceof String) {
                  String var13 = String.valueOf("data.");
                  String var14 = String.valueOf((String)var4.getKey());
                  String var15;
                  if(var14.length() != 0) {
                     var15 = var13.concat(var14);
                  } else {
                     var15 = new String(var13);
                  }

                  var0.appendQueryParameter(var15, (String)var4.getValue());
               } else if(var4.getValue() instanceof String[]) {
                  String[] var5 = (String[])var4.getValue();
                  int var6 = var5.length;

                  for(int var7 = 0; var7 < var6; ++var7) {
                     String var8 = var5[var7];
                     String var9 = String.valueOf("data.");
                     String var10 = String.valueOf((String)var4.getKey());
                     String var11;
                     if(var10.length() != 0) {
                        var11 = var9.concat(var10);
                     } else {
                        var11 = new String(var9);
                     }

                     var0.appendQueryParameter(var11, var8);
                  }
               }
            }

            return;
         }
      }
   }

   // $FF: renamed from: a (java.lang.StringBuilder, com.google.ads.conversiontracking.i$a, java.lang.String) void
   private static void method_538(StringBuilder var0, class_77.class_100 var1, String var2) {
      String var3 = method_533(var1);
      if(var3 != null) {
         String var12 = String.valueOf(";dc_lat=");
         String var13 = String.valueOf(var3);
         String var14;
         if(var13.length() != 0) {
            var14 = var12.concat(var13);
         } else {
            var14 = new String(var12);
         }

         var0.append(var14);
      }

      if(var1 == null) {
         String var8 = String.valueOf(";isu=");
         String var9 = String.valueOf(var2);
         String var10;
         if(var9.length() != 0) {
            var10 = var8.concat(var9);
         } else {
            var10 = new String(var8);
         }

         var0.append(var10);
      } else {
         String var4 = String.valueOf(";dc_rdid=");
         String var5 = String.valueOf(var1.method_169());
         String var6;
         if(var5.length() != 0) {
            var6 = var4.concat(var5);
         } else {
            var6 = new String(var4);
         }

         var0.append(var6);
      }
   }

   // $FF: renamed from: a (android.content.Context, com.google.ads.conversiontracking.g$b) boolean
   public static boolean method_539(Context param0, class_79.class_96 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.content.Context, com.google.ads.conversiontracking.g$c, boolean) boolean
   public static boolean method_540(Context var0, class_79.class_95 var1, boolean var2) {
      return method_541(var0, method_530(var1), method_543(var1), var2);
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String, boolean) boolean
   public static boolean method_541(Context var0, String var1, String var2, boolean var3) {
      boolean var4 = true;
      if(field_581 && field_584) {
         var4 = field_583;
      } else if(!var3) {
         boolean var5 = var0.getSharedPreferences(var1, 0).getBoolean(var2, false);
         if(var5) {
            String var7 = String.valueOf(var2);
            String var8;
            if(var7.length() != 0) {
               var8 = "Already sent ping for conversion ".concat(var7);
            } else {
               var8 = new String("Already sent ping for conversion ");
            }

            Log.i("GoogleConversionReporter", var8);
         }

         boolean var6;
         if(!var5) {
            var6 = var4;
         } else {
            var6 = false;
         }

         return var6;
      }

      return var4;
   }

   // $FF: renamed from: b (android.content.Context) long
   public static long method_542(Context var0) {
      return var0.getSharedPreferences("google_conversion", 0).getLong("last_retry_time", 0L);
   }

   // $FF: renamed from: b (com.google.ads.conversiontracking.g$c) java.lang.String
   public static String method_543(class_79.class_95 var0) {
      switch(null.field_81[var0.field_88.ordinal()]) {
      case 1:
         return var0.field_85;
      case 2:
         Object[] var1 = new Object[]{var0.field_94};
         return String.format("google_iap_ping:%s", var1);
      default:
         return var0.field_89;
      }
   }

   // $FF: renamed from: b (com.google.ads.conversiontracking.g$c, java.lang.String, java.lang.String, com.google.ads.conversiontracking.i$a, java.lang.String) java.lang.String
   public static String method_544(class_79.class_95 var0, String var1, String var2, class_77.class_100 var3, String var4) {
      String var5 = method_529(var0.field_92);
      Builder var6 = Uri.parse("https://www.googleadservices.com/pagead/conversion/").buildUpon().appendEncodedPath(String.valueOf(var0.field_85).concat("/")).appendQueryParameter("bundleid", var1).appendQueryParameter("appversion", var2).appendQueryParameter("osversion", VERSION.RELEASE).appendQueryParameter("sdkversion", "ct-sdk-a-v2.2.4");
      String var7;
      if(var3 != null) {
         var7 = "1";
      } else {
         var7 = "0";
      }

      Builder var8 = var6.appendQueryParameter("gms", var7);
      method_536(var8, var3, var4);
      if(var0.field_89 != null && var0.field_90 != null) {
         var8.appendQueryParameter("label", var0.field_89).appendQueryParameter("value", var0.field_90);
      }

      if(var0.field_95 != 0L) {
         var8.appendQueryParameter("timestamp", method_526(var0.field_95));
      } else {
         var8.appendQueryParameter("timestamp", method_526(method_522()));
      }

      if(var0.field_87) {
         var8.appendQueryParameter("remarketing_only", "1");
      }

      if(var0.field_96) {
         var8.appendQueryParameter("auto", "1");
      }

      if(var0.field_86) {
         var8.appendQueryParameter("usage_tracking_enabled", "1");
      } else {
         var8.appendQueryParameter("usage_tracking_enabled", "0");
      }

      if(var0.field_91 != null) {
         var8.appendQueryParameter("currency_code", var0.field_91);
      }

      method_537(var8, var0.field_87, var0.field_93);
      String var11 = String.valueOf(var8.build());
      return (new StringBuilder(0 + String.valueOf(var11).length() + String.valueOf(var5).length())).append(var11).append(var5).toString();
   }

   // $FF: renamed from: c (com.google.ads.conversiontracking.g$c, java.lang.String, java.lang.String, com.google.ads.conversiontracking.i$a, java.lang.String) java.lang.String
   public static String method_545(class_79.class_95 var0, String var1, String var2, class_77.class_100 var3, String var4) {
      Builder var5 = Uri.parse("https://www.googleadservices.com/pagead/conversion/").buildUpon().appendQueryParameter("sku", var0.field_94).appendQueryParameter("value", var0.field_90).appendQueryParameter("bundleid", var1).appendQueryParameter("appversion", var2).appendQueryParameter("osversion", VERSION.RELEASE).appendQueryParameter("sdkversion", "ct-sdk-a-v2.2.4").appendQueryParameter("timestamp", method_526(method_522()));
      method_536(var5, var3, var4);
      return var5.build().toString();
   }

   // $FF: renamed from: c (android.content.Context) void
   public static void method_546(Context var0) {
      Editor var1 = var0.getSharedPreferences("google_conversion", 0).edit();
      var1.putLong("last_retry_time", method_522());
      var1.commit();
   }

   // $FF: renamed from: d (android.content.Context) boolean
   public static boolean method_547(Context var0) {
      if(field_581) {
         return field_587;
      } else {
         ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService("connectivity");
         if(var1 != null) {
            NetworkInfo var2 = var1.getActiveNetworkInfo();
            if(var2 == null || !var2.isConnected()) {
               return false;
            }
         }

         return true;
      }
   }

   // $FF: renamed from: e (android.content.Context) java.lang.String
   private static String method_548(Context var0) throws NoSuchAlgorithmException {
      String var1 = Secure.getString(var0.getContentResolver(), "android_id");
      if(var1 == null) {
         var1 = "null";
      }

      MessageDigest var2 = MessageDigest.getInstance("MD5");
      var2.update(var1.getBytes());
      return class_87.method_568(var2.digest(), false);
   }

   public static class class_94 {
      // $FF: renamed from: a java.lang.String
      private final String field_82;
      // $FF: renamed from: b java.lang.String
      private final String field_83;
      // $FF: renamed from: c long
      private final long field_84;

      public class_94(String var1, String var2) {
         this(var1, var2, class_79.method_522());
      }

      private class_94(String var1, String var2, long var3) {
         this.field_82 = var1;
         this.field_83 = var2;
         this.field_84 = var3;
      }

      // $FF: renamed from: a (java.lang.String) com.google.ads.conversiontracking.g$a
      public static class_79.class_94 method_35(String var0) {
         if(!TextUtils.isEmpty(var0)) {
            String[] var1 = var0.split(" ");
            if(var1.length == 3) {
               class_79.class_94 var2;
               boolean var4;
               try {
                  var2 = new class_79.class_94(var1[0], var1[1], Long.parseLong(var1[2]));
                  var4 = var2.method_39();
               } catch (NumberFormatException var5) {
                  return null;
               }

               if(!var4) {
                  return var2;
               }
            }
         }

         return null;
      }

      // $FF: renamed from: c (com.google.ads.conversiontracking.g$a) long
      // $FF: synthetic method
      static long method_38(class_79.class_94 var0) {
         return var0.field_84;
      }

      // $FF: renamed from: a () boolean
      public boolean method_39() {
         return 7776000000L + this.field_84 < class_79.method_522();
      }
   }

   public static class class_96 {
      // $FF: renamed from: a java.lang.String
      private final String field_97;
      // $FF: renamed from: b com.google.ads.conversiontracking.g$a
      private final class_79.class_94 field_98;

      public class_96(String var1, class_79.class_94 var2) {
         this.field_97 = var1;
         this.field_98 = var2;
      }

      // $FF: renamed from: a (com.google.ads.conversiontracking.g$b) java.lang.String
      // $FF: synthetic method
      static String method_61(class_79.class_96 var0) {
         return var0.field_97;
      }

      // $FF: renamed from: b (com.google.ads.conversiontracking.g$b) com.google.ads.conversiontracking.g$a
      // $FF: synthetic method
      static class_79.class_94 method_62(class_79.class_96 var0) {
         return var0.field_98;
      }
   }

   public static class class_95 {
      // $FF: renamed from: a java.lang.String
      private String field_85;
      // $FF: renamed from: b boolean
      private boolean field_86;
      // $FF: renamed from: c boolean
      private boolean field_87;
      // $FF: renamed from: d com.google.ads.conversiontracking.g$d
      private class_79.class_97 field_88;
      // $FF: renamed from: e java.lang.String
      private String field_89;
      // $FF: renamed from: f java.lang.String
      private String field_90;
      // $FF: renamed from: g java.lang.String
      private String field_91;
      // $FF: renamed from: h com.google.ads.conversiontracking.g$a
      private class_79.class_94 field_92;
      // $FF: renamed from: i java.util.Map
      private Map<String, ?> field_93;
      // $FF: renamed from: j java.lang.String
      private String field_94;
      // $FF: renamed from: k long
      private long field_95;
      // $FF: renamed from: l boolean
      private boolean field_96;

      // $FF: renamed from: a (long) com.google.ads.conversiontracking.g$c
      public class_79.class_95 method_52(long var1) {
         this.field_95 = TimeUnit.MILLISECONDS.toSeconds(var1);
         return this;
      }

      // $FF: renamed from: a (com.google.ads.conversiontracking.g$a) com.google.ads.conversiontracking.g$c
      public class_79.class_95 method_53(class_79.class_94 var1) {
         this.field_92 = var1;
         return this;
      }

      // $FF: renamed from: a (com.google.ads.conversiontracking.g$d) com.google.ads.conversiontracking.g$c
      public class_79.class_95 method_54(class_79.class_97 var1) {
         this.field_88 = var1;
         return this;
      }

      // $FF: renamed from: a (java.lang.String) com.google.ads.conversiontracking.g$c
      public class_79.class_95 method_55(String var1) {
         this.field_85 = var1;
         return this;
      }

      // $FF: renamed from: a (boolean) com.google.ads.conversiontracking.g$c
      public class_79.class_95 method_56(boolean var1) {
         this.field_86 = var1;
         return this;
      }

      // $FF: renamed from: b () com.google.ads.conversiontracking.g$c
      public class_79.class_95 method_57() {
         this.field_96 = true;
         return this;
      }

      // $FF: renamed from: b (java.lang.String) com.google.ads.conversiontracking.g$c
      public class_79.class_95 method_58(String var1) {
         this.field_89 = var1;
         return this;
      }

      // $FF: renamed from: c (java.lang.String) com.google.ads.conversiontracking.g$c
      public class_79.class_95 method_59(String var1) {
         this.field_90 = var1;
         return this;
      }

      // $FF: renamed from: d (java.lang.String) com.google.ads.conversiontracking.g$c
      public class_79.class_95 method_60(String var1) {
         this.field_91 = var1;
         return this;
      }
   }

   public static enum class_97 {
      // $FF: renamed from: a com.google.ads.conversiontracking.g$d
      field_99,
      // $FF: renamed from: b com.google.ads.conversiontracking.g$d
      field_100,
      // $FF: renamed from: c com.google.ads.conversiontracking.g$d
      field_101,
      // $FF: renamed from: d com.google.ads.conversiontracking.g$d
      field_102;

      static {
         class_79.class_97[] var0 = new class_79.class_97[]{field_99, field_100, field_101, field_102};
      }

      // $FF: renamed from: a () com.google.ads.conversiontracking.g$d[]
      public static class_79.class_97[] method_63() {
         return (class_79.class_97[])field_103.clone();
      }
   }
}
