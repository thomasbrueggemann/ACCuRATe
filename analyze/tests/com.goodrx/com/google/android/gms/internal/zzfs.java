package com.google.android.gms.internal;

import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzfs {
   private final String zzDJ;
   private final zzjp zzpD;

   public zzfs(zzjp var1) {
      this(var1, "");
   }

   public zzfs(zzjp var1, String var2) {
      this.zzpD = var1;
      this.zzDJ = var2;
   }

   public void zza(int var1, int var2, int var3, int var4, float var5, int var6) {
      try {
         JSONObject var8 = (new JSONObject()).put("width", var1).put("height", var2).put("maxSizeWidth", var3).put("maxSizeHeight", var4).put("density", (double)var5).put("rotation", var6);
         this.zzpD.zzb("onScreenInfoChanged", var8);
      } catch (JSONException var9) {
         zzin.zzb("Error occured while obtaining screen information.", var9);
      }
   }

   public void zzam(String var1) {
      try {
         JSONObject var3 = (new JSONObject()).put("message", var1).put("action", this.zzDJ);
         this.zzpD.zzb("onError", var3);
      } catch (JSONException var4) {
         zzin.zzb("Error occurred while dispatching error event.", var4);
      }
   }

   public void zzan(String var1) {
      try {
         JSONObject var3 = (new JSONObject()).put("js", var1);
         this.zzpD.zzb("onReadyEventReceived", var3);
      } catch (JSONException var4) {
         zzin.zzb("Error occured while dispatching ready Event.", var4);
      }
   }

   public void zzao(String var1) {
      try {
         JSONObject var3 = (new JSONObject()).put("state", var1);
         this.zzpD.zzb("onStateChanged", var3);
      } catch (JSONException var4) {
         zzin.zzb("Error occured while dispatching state change.", var4);
      }
   }

   public void zzb(int var1, int var2, int var3, int var4) {
      try {
         JSONObject var6 = (new JSONObject()).put("x", var1).put("y", var2).put("width", var3).put("height", var4);
         this.zzpD.zzb("onSizeChanged", var6);
      } catch (JSONException var7) {
         zzin.zzb("Error occured while dispatching size change.", var7);
      }
   }

   public void zzc(int var1, int var2, int var3, int var4) {
      try {
         JSONObject var6 = (new JSONObject()).put("x", var1).put("y", var2).put("width", var3).put("height", var4);
         this.zzpD.zzb("onDefaultPositionReceived", var6);
      } catch (JSONException var7) {
         zzin.zzb("Error occured while dispatching default position.", var7);
      }
   }
}
