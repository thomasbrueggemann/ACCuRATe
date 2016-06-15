package com.google.android.gms.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.os.Build;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.internal.class_366;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.ey;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.gi
@ey
public final class class_375 {
   // $FF: renamed from: ut java.lang.Object
   private static final Object field_1145 = new Object();
   // $FF: renamed from: wB java.text.SimpleDateFormat[]
   private static final SimpleDateFormat[] field_1146;
   // $FF: renamed from: wC boolean
   private static boolean field_1147;
   // $FF: renamed from: wD java.lang.String
   private static String field_1148;
   // $FF: renamed from: wE boolean
   private static boolean field_1149;

   static {
      SimpleDateFormat[] var0 = new SimpleDateFormat[]{new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss"), new SimpleDateFormat("yyyyMMdd")};
      field_1146 = var0;
      field_1147 = true;
      field_1149 = false;
   }

   // $FF: renamed from: L (java.lang.String) java.lang.String
   public static String method_2546(String var0) {
      return Uri.parse(var0).buildUpon().query((String)null).build().toString();
   }

   // $FF: renamed from: M (java.lang.String) int
   public static int method_2547(String var0) {
      try {
         int var2 = Integer.parseInt(var0);
         return var2;
      } catch (NumberFormatException var3) {
         class_368.method_2506("Could not parse value:" + var3);
         return 0;
      }
   }

   // $FF: renamed from: N (java.lang.String) boolean
   public static boolean method_2548(String var0) {
      return TextUtils.isEmpty(var0)?false:var0.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
   }

   // $FF: renamed from: O (java.lang.String) long
   public static long method_2549(String var0) {
      int var1 = 0;
      if(TextUtils.isEmpty(var0)) {
         return -1L;
      } else {
         SimpleDateFormat[] var2 = field_1146;
         int var3 = var2.length;

         while(var1 < var3) {
            SimpleDateFormat var7 = var2[var1];

            try {
               var7.setLenient(false);
               var7.setTimeZone(TimeZone.getTimeZone("UTC"));
               long var9 = var7.parse(var0).getTime();
               return var9;
            } catch (ParseException var12) {
               ++var1;
            }
         }

         try {
            long var5 = Long.parseLong(var0);
            return var5;
         } catch (NumberFormatException var11) {
            return -1L;
         }
      }
   }

   // $FF: renamed from: P (java.lang.String) java.lang.String
   // $FF: synthetic method
   static String method_2550(String var0) {
      field_1148 = var0;
      return var0;
   }

   // $FF: renamed from: a (java.lang.Readable) java.lang.String
   public static String method_2551(Readable var0) throws IOException {
      StringBuilder var1 = new StringBuilder();
      CharBuffer var2 = CharBuffer.allocate(2048);

      while(true) {
         int var3 = var0.read(var2);
         if(var3 == -1) {
            return var1.toString();
         }

         var2.flip();
         var1.append(var2, 0, var3);
      }
   }

   // $FF: renamed from: a (java.util.Collection) org.json.JSONArray
   private static JSONArray method_2552(Collection<?> var0) throws JSONException {
      JSONArray var1 = new JSONArray();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         method_2561(var1, var2.next());
      }

      return var1;
   }

   // $FF: renamed from: a (java.lang.Object[]) org.json.JSONArray
   static JSONArray method_2553(Object[] var0) throws JSONException {
      JSONArray var1 = new JSONArray();
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         method_2561(var1, var0[var3]);
      }

      return var1;
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, android.webkit.WebSettings) void
   public static void method_2554(Context var0, String var1, WebSettings var2) {
      var2.setUserAgentString(method_2566(var0, var1));
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, java.util.List) void
   public static void method_2555(Context var0, String var1, List<String> var2) {
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         (new class_366(var0, var1, (String)var3.next())).start();
      }

   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, java.util.List, java.lang.String) void
   public static void method_2556(Context var0, String var1, List<String> var2, String var3) {
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         (new class_366(var0, var1, (String)var4.next(), var3)).start();
      }

   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, boolean, java.net.HttpURLConnection) void
   public static void method_2557(Context var0, String var1, boolean var2, HttpURLConnection var3) {
      method_2559(var0, var1, var2, var3, false);
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, boolean, java.net.HttpURLConnection, java.lang.String) void
   public static void method_2558(Context var0, String var1, boolean var2, HttpURLConnection var3, String var4) {
      var3.setConnectTimeout('\uea60');
      var3.setInstanceFollowRedirects(var2);
      var3.setReadTimeout('\uea60');
      var3.setRequestProperty("User-Agent", var4);
      var3.setUseCaches(false);
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, boolean, java.net.HttpURLConnection, boolean) void
   public static void method_2559(Context var0, String var1, boolean var2, HttpURLConnection var3, boolean var4) {
      var3.setConnectTimeout('\uea60');
      var3.setInstanceFollowRedirects(var2);
      var3.setReadTimeout('\uea60');
      var3.setRequestProperty("User-Agent", method_2566(var0, var1));
      var3.setUseCaches(var4);
   }

   // $FF: renamed from: a (android.webkit.WebView) void
   public static void method_2560(WebView var0) {
      if(VERSION.SDK_INT >= 11) {
         class_379.method_2591(var0);
      }

   }

   // $FF: renamed from: a (org.json.JSONArray, java.lang.Object) void
   private static void method_2561(JSONArray var0, Object var1) throws JSONException {
      if(var1 instanceof Bundle) {
         var0.put(method_2568((Bundle)var1));
      } else if(var1 instanceof Map) {
         var0.put(method_2580((Map)var1));
      } else if(var1 instanceof Collection) {
         var0.put(method_2552((Collection)var1));
      } else if(var1 instanceof Object[]) {
         var0.put(method_2553((Object[])((Object[])var1)));
      } else {
         var0.put(var1);
      }
   }

   // $FF: renamed from: a (org.json.JSONObject, java.lang.String, java.lang.Object) void
   private static void method_2562(JSONObject var0, String var1, Object var2) throws JSONException {
      if(var2 instanceof Bundle) {
         var0.put(var1, method_2568((Bundle)var2));
      } else if(var2 instanceof Map) {
         var0.put(var1, method_2580((Map)var2));
      } else if(var2 instanceof Collection) {
         if(var1 == null) {
            var1 = "null";
         }

         var0.put(var1, method_2552((Collection)var2));
      } else if(var2 instanceof Object[]) {
         var0.put(var1, method_2552(Arrays.asList((Object[])((Object[])var2))));
      } else {
         var0.put(var1, var2);
      }
   }

   // $FF: renamed from: a (android.content.pm.PackageManager, java.lang.String, java.lang.String) boolean
   public static boolean method_2563(PackageManager var0, String var1, String var2) {
      return var0.checkPermission(var2, var1) == 0;
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.lang.Class, java.lang.String) boolean
   public static boolean method_2564(ClassLoader var0, Class<?> var1, String var2) {
      try {
         boolean var4 = var1.isAssignableFrom(Class.forName(var2, false, var0));
         return var4;
      } catch (Throwable var5) {
         return false;
      }
   }

   // $FF: renamed from: b (android.webkit.WebView) void
   public static void method_2565(WebView var0) {
      if(VERSION.SDK_INT >= 11) {
         class_379.method_2592(var0);
      }

   }

   // $FF: renamed from: c (android.content.Context, java.lang.String) java.lang.String
   public static String method_2566(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (android.net.Uri) java.util.Map
   public static Map<String, String> method_2567(Uri var0) {
      if(var0 == null) {
         return null;
      } else {
         HashMap var1 = new HashMap();
         UrlQuerySanitizer var2 = new UrlQuerySanitizer();
         var2.setAllowUnregisteredParamaters(true);
         var2.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
         var2.parseUrl(var0.toString());
         Iterator var3 = var2.getParameterList().iterator();

         while(var3.hasNext()) {
            ParameterValuePair var4 = (ParameterValuePair)var3.next();
            var1.put(var4.mParameter, var4.mValue);
         }

         return var1;
      }
   }

   // $FF: renamed from: c (android.os.Bundle) org.json.JSONObject
   private static JSONObject method_2568(Bundle var0) throws JSONException {
      JSONObject var1 = new JSONObject();
      Iterator var2 = var0.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         method_2562(var1, var3, var0.get(var3));
      }

      return var1;
   }

   // $FF: renamed from: c (android.content.Context, java.lang.String, java.lang.String) void
   public static void method_2569(Context var0, String var1, String var2) {
      ArrayList var3 = new ArrayList();
      var3.add(var2);
      method_2555(var0, var1, var3);
   }

   // $FF: renamed from: dt () boolean
   public static boolean method_2570() {
      return field_1147;
   }

   // $FF: renamed from: du () int
   public static int method_2571() {
      return VERSION.SDK_INT >= 9?6:0;
   }

   // $FF: renamed from: dv () int
   public static int method_2572() {
      return VERSION.SDK_INT >= 9?7:1;
   }

   // $FF: renamed from: dw () java.lang.String
   static String method_2573() {
      StringBuffer var0 = new StringBuffer(256);
      var0.append("Mozilla/5.0 (Linux; U; Android");
      if(VERSION.RELEASE != null) {
         var0.append(" ").append(VERSION.RELEASE);
      }

      var0.append("; ").append(Locale.getDefault());
      if(Build.DEVICE != null) {
         var0.append("; ").append(Build.DEVICE);
         if(Build.DISPLAY != null) {
            var0.append(" Build/").append(Build.DISPLAY);
         }
      }

      var0.append(") AppleWebKit/533 Version/4.0 Safari/533");
      return var0.toString();
   }

   // $FF: renamed from: dx () java.lang.String
   public static String method_2574() {
      UUID var0 = UUID.randomUUID();
      byte[] var1 = BigInteger.valueOf(var0.getLeastSignificantBits()).toByteArray();
      byte[] var2 = BigInteger.valueOf(var0.getMostSignificantBits()).toByteArray();
      String var3 = (new BigInteger(1, var1)).toString();

      for(int var4 = 0; var4 < 2; ++var4) {
         String var8;
         try {
            MessageDigest var6 = MessageDigest.getInstance("MD5");
            var6.update(var1);
            var6.update(var2);
            byte[] var7 = new byte[8];
            System.arraycopy(var6.digest(), 0, var7, 0, 8);
            var8 = (new BigInteger(1, var7)).toString();
         } catch (NoSuchAlgorithmException var9) {
            continue;
         }

         var3 = var8;
      }

      return var3;
   }

   // $FF: renamed from: dy () java.lang.Object
   // $FF: synthetic method
   static Object method_2575() {
      return field_1145;
   }

   // $FF: renamed from: p (android.content.Context) boolean
   public static boolean method_2576(Context var0) {
      Intent var1 = new Intent();
      var1.setClassName(var0, "com.google.android.gms.ads.AdActivity");
      ResolveInfo var3 = var0.getPackageManager().resolveActivity(var1, 65536);
      if(var3 != null && var3.activityInfo != null) {
         boolean var4;
         if((16 & var3.activityInfo.configChanges) == 0) {
            class_368.method_2506(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"keyboard"}));
            var4 = false;
         } else {
            var4 = true;
         }

         if((32 & var3.activityInfo.configChanges) == 0) {
            class_368.method_2506(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"keyboardHidden"}));
            var4 = false;
         }

         if((128 & var3.activityInfo.configChanges) == 0) {
            class_368.method_2506(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"orientation"}));
            var4 = false;
         }

         if((256 & var3.activityInfo.configChanges) == 0) {
            class_368.method_2506(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"screenLayout"}));
            var4 = false;
         }

         if((512 & var3.activityInfo.configChanges) == 0) {
            class_368.method_2506(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"uiMode"}));
            var4 = false;
         }

         if((1024 & var3.activityInfo.configChanges) == 0) {
            class_368.method_2506(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"screenSize"}));
            var4 = false;
         }

         if((2048 & var3.activityInfo.configChanges) == 0) {
            class_368.method_2506(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"smallestScreenSize"}));
            return false;
         } else {
            return var4;
         }
      } else {
         class_368.method_2506("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
         return false;
      }
   }

   // $FF: renamed from: q (android.content.Context) void
   public static void method_2577(Context var0) {
      if(!field_1149) {
         IntentFilter var1 = new IntentFilter();
         var1.addAction("android.intent.action.USER_PRESENT");
         var1.addAction("android.intent.action.SCREEN_OFF");
         var0.getApplicationContext().registerReceiver(new class_375.class_1613(null), var1);
         field_1149 = true;
      }
   }

   // $FF: renamed from: r (android.content.Context) java.lang.String
   private static String method_2578(Context var0) {
      return (new WebView(var0)).getSettings().getUserAgentString();
   }

   // $FF: renamed from: s (android.content.Context) int
   public static int method_2579(Context var0) {
      int var1;
      int var2;
      if(var0 instanceof Activity) {
         Window var3 = ((Activity)var0).getWindow();
         Rect var4 = new Rect();
         var3.getDecorView().getWindowVisibleDisplayFrame(var4);
         var2 = var4.top;
         var1 = var3.findViewById(16908290).getTop() - var2;
      } else {
         var1 = 0;
         var2 = 0;
      }

      return var1 + var2;
   }

   // $FF: renamed from: t (java.util.Map) org.json.JSONObject
   public static JSONObject method_2580(Map<String, ?> param0) throws JSONException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: t (android.content.Context) int[]
   public static int[] method_2581(Context var0) {
      WindowManager var1 = (WindowManager)var0.getSystemService("window");
      DisplayMetrics var2 = new DisplayMetrics();
      var1.getDefaultDisplay().getMetrics(var2);
      float var3 = 160.0F / (float)var2.densityDpi;
      return new int[]{(int)(var3 * (float)var2.widthPixels), (int)(var3 * (float)var2.heightPixels)};
   }

   // $FF: renamed from: u (android.content.Context) java.lang.String
   // $FF: synthetic method
   static String method_2582(Context var0) {
      return method_2578(var0);
   }

   private static final class class_1613 extends BroadcastReceiver {
      private class_1613() {
      }

      // $FF: synthetic method
      class_1613(Object var1) {
         this();
      }

      public void onReceive(Context var1, Intent var2) {
         if("android.intent.action.USER_PRESENT".equals(var2.getAction())) {
            class_375.field_1147 = true;
         } else if("android.intent.action.SCREEN_OFF".equals(var2.getAction())) {
            class_375.field_1147 = false;
            return;
         }

      }
   }
}
