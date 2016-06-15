package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.google.android.gms.internal.class_0;
import com.google.android.gms.internal.class_229;
import com.google.android.gms.internal.class_238;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_374;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_428;
import com.google.android.gms.internal.class_429;
import com.google.android.gms.internal.class_432;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_548;
import com.google.android.gms.internal.class_715;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fn;
import com.google.android.gms.internal.fy;
import com.google.android.gms.internal.gu;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.fn
@ey
public class class_430 implements Callable<fy> {
   private final Context mContext;
   // $FF: renamed from: mH java.lang.Object
   private final Object field_1365 = new Object();
   // $FF: renamed from: pM com.google.android.gms.internal.u
   private final class_548 field_1366;
   // $FF: renamed from: tB com.google.android.gms.internal.fy$a
   private final class_432.class_1521 field_1367;
   // $FF: renamed from: tq int
   private int field_1368;
   // $FF: renamed from: ul com.google.android.gms.internal.gn
   private final class_378 field_1369;
   // $FF: renamed from: um com.google.android.gms.internal.ai
   private final class_229 field_1370;
   // $FF: renamed from: un boolean
   private boolean field_1371;
   // $FF: renamed from: uo java.util.List
   private List<String> field_1372;

   public class_430(Context var1, class_548 var2, class_229 var3, class_378 var4, class_432.class_1521 var5) {
      this.mContext = var1;
      this.field_1366 = var2;
      this.field_1369 = var4;
      this.field_1370 = var3;
      this.field_1367 = var5;
      this.field_1371 = false;
      this.field_1368 = -2;
      this.field_1372 = null;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ah, com.google.android.gms.internal.fn$a, org.json.JSONObject) com.google.android.gms.internal.bv$a
   private class_238.class_1220 method_2837(class_0 var1, class_430.class_1524 var2, JSONObject var3) throws ExecutionException, InterruptedException, JSONException {
      if(this.method_2846()) {
         return null;
      } else {
         String[] var4 = this.method_2839(var3.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
         List var5;
         if(var4 == null) {
            var5 = null;
         } else {
            var5 = Arrays.asList(var4);
         }

         this.field_1372 = var5;
         class_238.class_1220 var6 = var2.method_933(this, var3);
         if(var6 == null) {
            class_368.method_2503("Failed to retrieve ad assets.");
            return null;
         } else {
            var6.method_1005(new class_238(this.field_1366, var1, var3));
            return var6;
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.bv$a) com.google.android.gms.internal.fy
   private class_432 method_2838(class_238.class_1220 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (org.json.JSONObject, java.lang.String) java.lang.String[]
   private String[] method_2839(JSONObject var1, String var2) throws JSONException {
      JSONArray var3 = var1.optJSONArray(var2);
      if(var3 == null) {
         return null;
      } else {
         String[] var4 = new String[var3.length()];

         for(int var5 = 0; var5 < var3.length(); ++var5) {
            var4[var5] = var3.getString(var5);
         }

         return var4;
      }
   }

   // $FF: renamed from: c (com.google.android.gms.internal.ah) org.json.JSONObject
   private JSONObject method_2840(final class_0 var1) throws TimeoutException, JSONException {
      if(this.method_2846()) {
         return null;
      } else {
         final class_374 var2 = new class_374();
         var1.method_2("/nativeAdPreProcess", new class_46() {
            // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
            public void method_213(gu var1x, Map<String, String> var2x) {
               var1.method_5("/nativeAdPreProcess");

               try {
                  String var4 = (String)var2x.get("success");
                  if(!TextUtils.isEmpty(var4)) {
                     var2.method_2545((new JSONObject(var4)).getJSONArray("ads").getJSONObject(0));
                     return;
                  }
               } catch (JSONException var5) {
                  class_368.method_2508("Malformed native JSON response.", var5);
               }

               class_430.this.method_2847(0);
               class_335.method_2302(class_430.this.method_2846(), "Unable to set the ad state error!");
               var2.method_2545((Object)null);
            }
         });
         var1.method_3("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.field_1367.field_4105.field_1445));
         return (JSONObject)var2.get();
      }
   }

   // $FF: renamed from: cN () com.google.android.gms.internal.ah
   private class_0 method_2841() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
      if(this.method_2846()) {
         return null;
      } else {
         class_0 var1 = (class_0)this.field_1370.method_1579(this.mContext, this.field_1367.field_4104.field_1460, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html").get();
         var1.method_1(this.field_1366, this.field_1366, this.field_1366, this.field_1366, false, this.field_1366);
         return var1;
      }
   }

   // $FF: renamed from: a (org.json.JSONObject, java.lang.String, boolean) java.util.concurrent.Future
   public Future<Drawable> method_2842(JSONObject var1, String var2, final boolean var3) throws JSONException {
      JSONObject var4;
      if(var3) {
         var4 = var1.getJSONObject(var2);
      } else {
         var4 = var1.optJSONObject(var2);
      }

      if(var4 == null) {
         var4 = new JSONObject();
      }

      String var5;
      if(var3) {
         var5 = var4.getString("url");
      } else {
         var5 = var4.optString("url");
      }

      if(TextUtils.isEmpty(var5)) {
         this.method_2843(0, var3);
         return new class_377((Object)null);
      } else {
         return this.field_1369.method_2588(var5, new class_378.class_1549() {
            // $FF: renamed from: a (java.io.InputStream) android.graphics.drawable.Drawable
            public Drawable method_3902(InputStream var1) {
               byte[] var3x;
               label20: {
                  byte[] var5;
                  try {
                     var5 = class_715.method_4192(var1);
                  } catch (IOException var6) {
                     var3x = null;
                     break label20;
                  }

                  var3x = var5;
               }

               if(var3x == null) {
                  class_430.this.method_2843(2, var3);
                  return null;
               } else {
                  Bitmap var4 = BitmapFactory.decodeByteArray(var3x, 0, var3x.length);
                  if(var4 == null) {
                     class_430.this.method_2843(2, var3);
                     return null;
                  } else {
                     return new BitmapDrawable(Resources.getSystem(), var4);
                  }
               }
            }

            // $FF: renamed from: b (java.io.InputStream) java.lang.Object
            // $FF: synthetic method
            public Object method_730(InputStream var1) {
               return this.method_3902(var1);
            }

            // $FF: renamed from: cP () android.graphics.drawable.Drawable
            public Drawable method_3903() {
               class_430.this.method_2843(2, var3);
               return null;
            }

            // $FF: renamed from: cQ () java.lang.Object
            // $FF: synthetic method
            public Object method_731() {
               return this.method_3903();
            }
         });
      }
   }

   // $FF: renamed from: a (int, boolean) void
   public void method_2843(int var1, boolean var2) {
      if(var2) {
         this.method_2847(var1);
      }

   }

   // $FF: renamed from: b (org.json.JSONObject) com.google.android.gms.internal.fn$a
   protected class_430.class_1524 method_2844(JSONObject var1) throws JSONException {
      if(this.method_2846()) {
         return null;
      } else {
         String var2 = var1.getString("template_id");
         if("2".equals(var2)) {
            return new class_429();
         } else if("1".equals(var2)) {
            return new class_428();
         } else {
            this.method_2847(0);
            return null;
         }
      }
   }

   // $FF: renamed from: cM () com.google.android.gms.internal.fy
   public class_432 method_2845() {
      try {
         class_0 var6 = this.method_2841();
         JSONObject var7 = this.method_2840(var6);
         class_432 var8 = this.method_2838(this.method_2837(var6, this.method_2844(var7), var7));
         return var8;
      } catch (CancellationException var9) {
         ;
      } catch (ExecutionException var10) {
         ;
      } catch (InterruptedException var11) {
         ;
      } catch (JSONException var12) {
         class_368.method_2510("Malformed native JSON response.", var12);
      } catch (TimeoutException var13) {
         class_368.method_2510("Timeout when loading native ad.", var13);
      }

      if(!this.field_1371) {
         this.method_2847(0);
      }

      return this.method_2838((class_238.class_1220)null);
   }

   // $FF: renamed from: cO () boolean
   public boolean method_2846() {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   public Object call() throws Exception {
      return this.method_2845();
   }

   // $FF: renamed from: t (int) void
   public void method_2847(int param1) {
      // $FF: Couldn't be decompiled
   }

   public interface class_1524<T extends class_238.class_1220> {
      // $FF: renamed from: a (com.google.android.gms.internal.fn, org.json.JSONObject) com.google.android.gms.internal.bv$a
      T method_933(fn var1, JSONObject var2) throws JSONException, InterruptedException, ExecutionException;
   }
}
