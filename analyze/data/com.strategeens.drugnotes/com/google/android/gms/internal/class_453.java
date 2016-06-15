package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.class_366;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_457;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_464;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gu;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.cc
@ey
public final class class_453 {
   // $FF: renamed from: pQ com.google.android.gms.internal.cd
   public static final class_46 field_1524 = new class_46() {
      // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
      public void method_213(gu var1, Map<String, String> var2) {
      }
   };
   // $FF: renamed from: pR com.google.android.gms.internal.cd
   public static final class_46 field_1525 = new class_46() {
      // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
      public void method_213(gu var1, Map<String, String> var2) {
         String var3 = (String)var2.get("urls");
         if(TextUtils.isEmpty(var3)) {
            class_368.method_2506("URLs missing in canOpenURLs GMSG.");
         } else {
            String[] var4 = var3.split(",");
            HashMap var5 = new HashMap();
            PackageManager var6 = var1.getContext().getPackageManager();
            int var7 = var4.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               String var9 = var4[var8];
               String[] var10 = var9.split(";", 2);
               String var11 = var10[0].trim();
               String var12;
               if(var10.length > 1) {
                  var12 = var10[1].trim();
               } else {
                  var12 = "android.intent.action.VIEW";
               }

               boolean var13;
               if(var6.resolveActivity(new Intent(var12, Uri.parse(var11)), 65536) != null) {
                  var13 = true;
               } else {
                  var13 = false;
               }

               var5.put(var9, Boolean.valueOf(var13));
            }

            var1.method_2523("openableURLs", var5);
         }
      }
   };
   // $FF: renamed from: pS com.google.android.gms.internal.cd
   public static final class_46 field_1526 = new class_46() {
      // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
      public void method_213(gu var1, Map<String, String> var2) {
         PackageManager var3 = var1.getContext().getPackageManager();
         String var4 = (String)var2.get("data");

         JSONObject var5;
         try {
            var5 = new JSONObject(var4);
         } catch (JSONException var33) {
            var1.method_2526("openableIntents", new JSONObject());
            return;
         }

         JSONArray var7;
         try {
            var7 = var5.getJSONArray("intents");
         } catch (JSONException var32) {
            var1.method_2526("openableIntents", new JSONObject());
            return;
         }

         JSONObject var8 = new JSONObject();

         for(int var9 = 0; var9 < var7.length(); ++var9) {
            JSONObject var11;
            try {
               var11 = var7.getJSONObject(var9);
            } catch (JSONException var34) {
               class_368.method_2508("Error parsing the intent data.", var34);
               continue;
            }

            String var12 = var11.optString("id");
            String var13 = var11.optString("u");
            String var14 = var11.optString("i");
            String var15 = var11.optString("m");
            String var16 = var11.optString("p");
            String var17 = var11.optString("c");
            var11.optString("f");
            var11.optString("e");
            Intent var20 = new Intent();
            if(!TextUtils.isEmpty(var13)) {
               var20.setData(Uri.parse(var13));
            }

            if(!TextUtils.isEmpty(var14)) {
               var20.setAction(var14);
            }

            if(!TextUtils.isEmpty(var15)) {
               var20.setType(var15);
            }

            if(!TextUtils.isEmpty(var16)) {
               var20.setPackage(var16);
            }

            if(!TextUtils.isEmpty(var17)) {
               String[] var24 = var17.split("/", 2);
               if(var24.length == 2) {
                  var20.setComponent(new ComponentName(var24[0], var24[1]));
               }
            }

            boolean var21;
            if(var3.resolveActivity(var20, 65536) != null) {
               var21 = true;
            } else {
               var21 = false;
            }

            try {
               var8.put(var12, var21);
            } catch (JSONException var31) {
               class_368.method_2508("Error constructing openable urls response.", var31);
            }
         }

         var1.method_2526("openableIntents", var8);
      }
   };
   // $FF: renamed from: pT com.google.android.gms.internal.cd
   public static final class_46 field_1527 = new class_46() {
      // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
      public void method_213(gu param1, Map<String, String> param2) {
         // $FF: Couldn't be decompiled
      }
   };
   // $FF: renamed from: pU com.google.android.gms.internal.cd
   public static final class_46 field_1528 = new class_46() {
      // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
      public void method_213(gu var1, Map<String, String> var2) {
         class_464 var3 = var1.method_2530();
         if(var3 == null) {
            class_368.method_2506("A GMSG tried to close something that wasn\'t an overlay.");
         } else {
            var3.close();
         }
      }
   };
   // $FF: renamed from: pV com.google.android.gms.internal.cd
   public static final class_46 field_1529 = new class_46() {
      // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
      public void method_213(gu var1, Map<String, String> var2) {
         var1.method_2537("1".equals(var2.get("custom_close")));
      }
   };
   // $FF: renamed from: pW com.google.android.gms.internal.cd
   public static final class_46 field_1530 = new class_46() {
      // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
      public void method_213(gu var1, Map<String, String> var2) {
         String var3 = (String)var2.get("u");
         if(var3 == null) {
            class_368.method_2506("URL missing from httpTrack GMSG.");
         } else {
            (new class_366(var1.getContext(), var1.method_2534().field_1121, var3)).start();
         }
      }
   };
   // $FF: renamed from: pX com.google.android.gms.internal.cd
   public static final class_46 field_1531 = new class_46() {
      // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
      public void method_213(gu var1, Map<String, String> var2) {
         class_368.method_2504("Received log message: " + (String)var2.get("string"));
      }
   };
   // $FF: renamed from: pY com.google.android.gms.internal.cd
   public static final class_46 field_1532 = new class_46() {
      // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
      public void method_213(gu param1, Map<String, String> param2) {
         // $FF: Couldn't be decompiled
      }
   };
   // $FF: renamed from: pZ com.google.android.gms.internal.cd
   public static final class_46 field_1533 = new class_457();
}
