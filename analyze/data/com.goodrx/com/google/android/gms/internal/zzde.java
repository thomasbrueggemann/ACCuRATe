package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzdd;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzds;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzjp;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public final class zzde {
   public static final zzdf zzyX = new zzdf() {
      public void zza(zzjp var1, Map<String, String> var2) {
      }
   };
   public static final zzdf zzyY = new zzdf() {
      public void zza(zzjp var1, Map<String, String> var2) {
         String var3 = (String)var2.get("urls");
         if(TextUtils.isEmpty(var3)) {
            zzin.zzaK("URLs missing in canOpenURLs GMSG.");
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

            var1.zza("openableURLs", var5);
         }
      }
   };
   public static final zzdf zzyZ = new zzdf() {
      public void zza(zzjp var1, Map<String, String> var2) {
         PackageManager var3 = var1.getContext().getPackageManager();
         String var4 = (String)var2.get("data");

         JSONObject var7;
         try {
            new JSONObject;
            var7 = JSONObjectInstrumentation.init(var4);
         } catch (JSONException var29) {
            var1.zzb("openableIntents", new JSONObject());
            return;
         }

         JSONArray var9;
         try {
            var9 = var7.getJSONArray("intents");
         } catch (JSONException var28) {
            var1.zzb("openableIntents", new JSONObject());
            return;
         }

         JSONObject var10 = new JSONObject();

         for(int var11 = 0; var11 < var9.length(); ++var11) {
            JSONObject var13;
            try {
               var13 = var9.getJSONObject(var11);
            } catch (JSONException var30) {
               zzin.zzb("Error parsing the intent data.", var30);
               continue;
            }

            String var14 = var13.optString("id");
            String var15 = var13.optString("u");
            String var16 = var13.optString("i");
            String var17 = var13.optString("m");
            String var18 = var13.optString("p");
            String var19 = var13.optString("c");
            var13.optString("f");
            var13.optString("e");
            Intent var22 = new Intent();
            if(!TextUtils.isEmpty(var15)) {
               var22.setData(Uri.parse(var15));
            }

            if(!TextUtils.isEmpty(var16)) {
               var22.setAction(var16);
            }

            if(!TextUtils.isEmpty(var17)) {
               var22.setType(var17);
            }

            if(!TextUtils.isEmpty(var18)) {
               var22.setPackage(var18);
            }

            if(!TextUtils.isEmpty(var19)) {
               String[] var26 = var19.split("/", 2);
               if(var26.length == 2) {
                  var22.setComponent(new ComponentName(var26[0], var26[1]));
               }
            }

            boolean var23;
            if(var3.resolveActivity(var22, 65536) != null) {
               var23 = true;
            } else {
               var23 = false;
            }

            try {
               var10.put(var14, var23);
            } catch (JSONException var27) {
               zzin.zzb("Error constructing openable urls response.", var27);
            }
         }

         var1.zzb("openableIntents", var10);
      }
   };
   public static final zzdf zzza = new zzdf() {
      public void zza(zzjp param1, Map<String, String> param2) {
         // $FF: Couldn't be decompiled
      }
   };
   public static final zzdf zzzb = new zzdf() {
      public void zza(zzjp var1, Map<String, String> var2) {
         com.google.android.gms.ads.internal.overlay.zzd var3 = var1.zzhS();
         if(var3 != null) {
            var3.close();
         } else {
            com.google.android.gms.ads.internal.overlay.zzd var4 = var1.zzhT();
            if(var4 != null) {
               var4.close();
            } else {
               zzin.zzaK("A GMSG tried to close something that wasn\'t an overlay.");
            }
         }
      }
   };
   public static final zzdf zzzc = new zzdf() {
      private void zzc(zzjp var1) {
         zzin.zzaJ("Received support message, responding.");
         com.google.android.gms.ads.internal.zzd var2 = var1.zzhR();
         boolean var3 = false;
         if(var2 != null) {
            com.google.android.gms.ads.internal.overlay.zzm var8 = var2.zzpy;
            var3 = false;
            if(var8 != null) {
               var3 = var8.zzfM();
            }
         }

         JSONObject var4 = new JSONObject();

         try {
            var4.put("event", "checkSupport");
            var4.put("supports", var3);
            var1.zzb("appStreaming", var4);
         } catch (Throwable var9) {
            ;
         }
      }

      public void zza(zzjp var1, Map<String, String> var2) {
         if("checkSupport".equals(var2.get("action"))) {
            this.zzc(var1);
         } else {
            com.google.android.gms.ads.internal.overlay.zzd var3 = var1.zzhS();
            if(var3 != null) {
               var3.zzg(var1, var2);
               return;
            }
         }

      }
   };
   public static final zzdf zzzd = new zzdf() {
      public void zza(zzjp var1, Map<String, String> var2) {
         var1.zzE("1".equals(var2.get("custom_close")));
      }
   };
   public static final zzdf zzze = new zzdf() {
      public void zza(zzjp var1, Map<String, String> var2) {
         String var3 = (String)var2.get("u");
         if(var3 == null) {
            zzin.zzaK("URL missing from httpTrack GMSG.");
         } else {
            (new zziy(var1.getContext(), var1.zzhX().afmaVersion, var3)).zzhn();
         }
      }
   };
   public static final zzdf zzzf = new zzdf() {
      public void zza(zzjp var1, Map<String, String> var2) {
         zzin.zzaJ("Received log message: " + (String)var2.get("string"));
      }
   };
   public static final zzdf zzzg = new zzdf() {
      public void zza(zzjp param1, Map<String, String> param2) {
         // $FF: Couldn't be decompiled
      }
   };
   public static final zzdf zzzh = new zzdf() {
      public void zza(zzjp var1, Map<String, String> var2) {
         if(((Boolean)zzbt.zzwT.get()).booleanValue()) {
            boolean var3;
            if(!Boolean.parseBoolean((String)var2.get("disabled"))) {
               var3 = true;
            } else {
               var3 = false;
            }

            var1.zzF(var3);
         }
      }
   };
   public static final zzdf zzzi = new zzdo();
   public static final zzdf zzzj = new zzds();
   public static final zzdf zzzk = new zzdd();
}
