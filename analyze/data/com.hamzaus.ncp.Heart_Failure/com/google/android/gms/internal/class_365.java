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
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.internal.class_356;
import com.google.android.gms.internal.class_362;
import com.google.android.gms.internal.class_370;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.ep
public final class class_365 {
   // $FF: renamed from: qm java.lang.Object
   private static final Object field_1574 = new Object();
   // $FF: renamed from: si boolean
   private static boolean field_1575 = true;
   // $FF: renamed from: sj java.lang.String
   private static String field_1576;
   // $FF: renamed from: sk boolean
   private static boolean field_1577 = false;

   // $FF: renamed from: a (java.lang.Readable) java.lang.String
   public static String method_2289(Readable var0) throws IOException {
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
   private static JSONArray method_2290(Collection<?> var0) throws JSONException {
      JSONArray var1 = new JSONArray();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         method_2296(var1, var2.next());
      }

      return var1;
   }

   // $FF: renamed from: a (java.lang.Object[]) org.json.JSONArray
   static JSONArray method_2291(Object[] var0) throws JSONException {
      JSONArray var1 = new JSONArray();
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         method_2296(var1, var0[var3]);
      }

      return var1;
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, android.webkit.WebSettings) void
   public static void method_2292(Context var0, String var1, WebSettings var2) {
      var2.setUserAgentString(method_2308(var0, var1));
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, java.util.List) void
   public static void method_2293(Context var0, String var1, List<String> var2) {
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         (new class_362(var0, var1, (String)var3.next())).start();
      }

   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, boolean, java.net.HttpURLConnection) void
   public static void method_2294(Context var0, String var1, boolean var2, HttpURLConnection var3) {
      var3.setConnectTimeout('\uea60');
      var3.setInstanceFollowRedirects(var2);
      var3.setReadTimeout('\uea60');
      var3.setRequestProperty("User-Agent", method_2308(var0, var1));
      var3.setUseCaches(false);
   }

   // $FF: renamed from: a (android.webkit.WebView) void
   public static void method_2295(WebView var0) {
      if(VERSION.SDK_INT >= 11) {
         class_356.method_2252(var0);
      }

   }

   // $FF: renamed from: a (org.json.JSONArray, java.lang.Object) void
   private static void method_2296(JSONArray var0, Object var1) throws JSONException {
      if(var1 instanceof Bundle) {
         var0.put(method_2301((Bundle)var1));
      } else if(var1 instanceof Map) {
         var0.put(method_2314((Map)var1));
      } else if(var1 instanceof Collection) {
         var0.put(method_2290((Collection)var1));
      } else if(var1 instanceof Object[]) {
         var0.put(method_2291((Object[])((Object[])var1)));
      } else {
         var0.put(var1);
      }
   }

   // $FF: renamed from: a (org.json.JSONObject, java.lang.String, java.lang.Object) void
   private static void method_2297(JSONObject var0, String var1, Object var2) throws JSONException {
      if(var2 instanceof Bundle) {
         var0.put(var1, method_2301((Bundle)var2));
      } else if(var2 instanceof Map) {
         var0.put(var1, method_2314((Map)var2));
      } else if(var2 instanceof Collection) {
         if(var1 == null) {
            var1 = "null";
         }

         var0.put(var1, method_2290((Collection)var2));
      } else if(var2 instanceof Object[]) {
         var0.put(var1, method_2290(Arrays.asList((Object[])((Object[])var2))));
      } else {
         var0.put(var1, var2);
      }
   }

   // $FF: renamed from: a (android.content.pm.PackageManager, java.lang.String, java.lang.String) boolean
   public static boolean method_2298(PackageManager var0, String var1, String var2) {
      return var0.checkPermission(var2, var1) == 0;
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.lang.Class, java.lang.String) boolean
   public static boolean method_2299(ClassLoader var0, Class<?> var1, String var2) {
      try {
         boolean var4 = var1.isAssignableFrom(Class.forName(var2, false, var0));
         return var4;
      } catch (Throwable var5) {
         return false;
      }
   }

   // $FF: renamed from: b (android.net.Uri) java.util.Map
   public static Map<String, String> method_2300(Uri var0) {
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

   // $FF: renamed from: b (android.os.Bundle) org.json.JSONObject
   private static JSONObject method_2301(Bundle var0) throws JSONException {
      JSONObject var1 = new JSONObject();
      Iterator var2 = var0.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         method_2297(var1, var3, var0.get(var3));
      }

      return var1;
   }

   // $FF: renamed from: b (android.webkit.WebView) void
   public static void method_2302(WebView var0) {
      if(VERSION.SDK_INT >= 11) {
         class_356.method_2253(var0);
      }

   }

   // $FF: renamed from: bL () boolean
   public static boolean method_2303() {
      return field_1575;
   }

   // $FF: renamed from: bM () int
   public static int method_2304() {
      return VERSION.SDK_INT >= 9?6:0;
   }

   // $FF: renamed from: bN () int
   public static int method_2305() {
      return VERSION.SDK_INT >= 9?7:1;
   }

   // $FF: renamed from: bO () java.lang.String
   public static String method_2306() {
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

   // $FF: renamed from: bP () java.lang.Object
   // $FF: synthetic method
   static Object method_2307() {
      return field_1574;
   }

   // $FF: renamed from: c (android.content.Context, java.lang.String) java.lang.String
   private static String method_2308(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: j (android.content.Context) boolean
   public static boolean method_2309(Context var0) {
      Intent var1 = new Intent();
      var1.setClassName(var0, "com.google.android.gms.ads.AdActivity");
      ResolveInfo var3 = var0.getPackageManager().resolveActivity(var1, 65536);
      if(var3 != null && var3.activityInfo != null) {
         boolean var4;
         if((16 & var3.activityInfo.configChanges) == 0) {
            class_370.method_2358(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"keyboard"}));
            var4 = false;
         } else {
            var4 = true;
         }

         if((32 & var3.activityInfo.configChanges) == 0) {
            class_370.method_2358(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"keyboardHidden"}));
            var4 = false;
         }

         if((128 & var3.activityInfo.configChanges) == 0) {
            class_370.method_2358(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"orientation"}));
            var4 = false;
         }

         if((256 & var3.activityInfo.configChanges) == 0) {
            class_370.method_2358(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"screenLayout"}));
            var4 = false;
         }

         if((512 & var3.activityInfo.configChanges) == 0) {
            class_370.method_2358(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"uiMode"}));
            var4 = false;
         }

         if((1024 & var3.activityInfo.configChanges) == 0) {
            class_370.method_2358(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"screenSize"}));
            var4 = false;
         }

         if((2048 & var3.activityInfo.configChanges) == 0) {
            class_370.method_2358(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"smallestScreenSize"}));
            return false;
         } else {
            return var4;
         }
      } else {
         class_370.method_2358("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
         return false;
      }
   }

   // $FF: renamed from: k (android.content.Context) void
   public static void method_2310(Context var0) {
      if(!field_1577) {
         IntentFilter var1 = new IntentFilter();
         var1.addAction("android.intent.action.USER_PRESENT");
         var1.addAction("android.intent.action.SCREEN_OFF");
         var0.getApplicationContext().registerReceiver(new class_365.class_1261(null), var1);
         field_1577 = true;
      }
   }

   // $FF: renamed from: l (android.content.Context) java.lang.String
   private static String method_2311(Context var0) {
      return (new WebView(var0)).getSettings().getUserAgentString();
   }

   // $FF: renamed from: m (android.content.Context) int
   public static int method_2312(Context var0) {
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

   // $FF: renamed from: n (android.content.Context) java.lang.String
   // $FF: synthetic method
   static String method_2313(Context var0) {
      return method_2311(var0);
   }

   // $FF: renamed from: o (java.util.Map) org.json.JSONObject
   public static JSONObject method_2314(Map<String, ?> param0) throws JSONException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: v (java.lang.String) java.lang.String
   public static String method_2316(String var0) {
      return Uri.parse(var0).buildUpon().query((String)null).build().toString();
   }

   // $FF: renamed from: w (java.lang.String) java.lang.String
   // $FF: synthetic method
   static String method_2317(String var0) {
      field_1576 = var0;
      return var0;
   }

   private static final class class_1261 extends BroadcastReceiver {
      private class_1261() {
      }

      // $FF: synthetic method
      class_1261(Object var1) {
         this();
      }

      public void onReceive(Context var1, Intent var2) {
         if("android.intent.action.USER_PRESENT".equals(var2.getAction())) {
            class_365.field_1575 = true;
         } else if("android.intent.action.SCREEN_OFF".equals(var2.getAction())) {
            class_365.field_1575 = false;
            return;
         }

      }
   }
}
