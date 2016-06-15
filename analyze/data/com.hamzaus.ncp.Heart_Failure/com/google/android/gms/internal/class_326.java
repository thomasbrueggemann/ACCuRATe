package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.internal.class_25;
import com.google.android.gms.internal.class_325;
import com.google.android.gms.internal.class_327;
import com.google.android.gms.internal.class_332;
import com.google.android.gms.internal.gs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.gp
public class class_326 extends class_325 {
   // $FF: renamed from: Cm long
   private static final long field_1310;
   // $FF: renamed from: Cn long
   private static final long field_1311;
   // $FF: renamed from: Co long
   private static final long field_1312;
   // $FF: renamed from: Cp long
   private static final long field_1313;
   private static final String NAMESPACE = class_332.method_2119("com.google.cast.media");
   // $FF: renamed from: CA com.google.android.gms.internal.gs
   private final class_327 field_1314;
   // $FF: renamed from: CB com.google.android.gms.internal.gs
   private final class_327 field_1315;
   // $FF: renamed from: CC java.util.List
   private final List<gs> field_1316;
   // $FF: renamed from: CD java.lang.Runnable
   private final Runnable field_1317;
   // $FF: renamed from: CE boolean
   private boolean field_1318;
   // $FF: renamed from: Cq long
   private long field_1319;
   // $FF: renamed from: Cr com.google.android.gms.cast.MediaStatus
   private MediaStatus field_1320;
   // $FF: renamed from: Cs com.google.android.gms.internal.gs
   private final class_327 field_1321;
   // $FF: renamed from: Ct com.google.android.gms.internal.gs
   private final class_327 field_1322;
   // $FF: renamed from: Cu com.google.android.gms.internal.gs
   private final class_327 field_1323;
   // $FF: renamed from: Cv com.google.android.gms.internal.gs
   private final class_327 field_1324;
   // $FF: renamed from: Cw com.google.android.gms.internal.gs
   private final class_327 field_1325;
   // $FF: renamed from: Cx com.google.android.gms.internal.gs
   private final class_327 field_1326;
   // $FF: renamed from: Cy com.google.android.gms.internal.gs
   private final class_327 field_1327;
   // $FF: renamed from: Cz com.google.android.gms.internal.gs
   private final class_327 field_1328;
   private final Handler mHandler;

   static {
      field_1310 = TimeUnit.HOURS.toMillis(24L);
      field_1311 = TimeUnit.HOURS.toMillis(24L);
      field_1312 = TimeUnit.HOURS.toMillis(24L);
      field_1313 = TimeUnit.SECONDS.toMillis(1L);
   }

   public class_326() {
      this((String)null);
   }

   public class_326(String var1) {
      super(NAMESPACE, "MediaControlChannel", var1);
      this.mHandler = new Handler(Looper.getMainLooper());
      this.field_1317 = new class_326.class_933();
      this.field_1316 = new ArrayList();
      this.field_1321 = new class_327(field_1311);
      this.field_1316.add(this.field_1321);
      this.field_1322 = new class_327(field_1310);
      this.field_1316.add(this.field_1322);
      this.field_1323 = new class_327(field_1310);
      this.field_1316.add(this.field_1323);
      this.field_1324 = new class_327(field_1310);
      this.field_1316.add(this.field_1324);
      this.field_1325 = new class_327(field_1312);
      this.field_1316.add(this.field_1325);
      this.field_1326 = new class_327(field_1310);
      this.field_1316.add(this.field_1326);
      this.field_1327 = new class_327(field_1310);
      this.field_1316.add(this.field_1327);
      this.field_1328 = new class_327(field_1310);
      this.field_1316.add(this.field_1328);
      this.field_1314 = new class_327(field_1310);
      this.field_1316.add(this.field_1314);
      this.field_1315 = new class_327(field_1310);
      this.field_1316.add(this.field_1315);
      this.method_2081();
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gp) java.util.List
   // $FF: synthetic method
   static List method_2077(class_326 var0) {
      return var0.field_1316;
   }

   // $FF: renamed from: a (long, org.json.JSONObject) void
   private void method_2078(long var1, JSONObject var3) throws JSONException {
      boolean var4 = true;
      boolean var5 = this.field_1321.method_2100(var1);
      boolean var6;
      if(this.field_1325.method_2099() && !this.field_1325.method_2100(var1)) {
         var6 = var4;
      } else {
         var6 = false;
      }

      if((!this.field_1326.method_2099() || this.field_1326.method_2100(var1)) && (!this.field_1327.method_2099() || this.field_1327.method_2100(var1))) {
         var4 = false;
      }

      int var7;
      if(var6) {
         var7 = 2;
      } else {
         var7 = 0;
      }

      if(var4) {
         var7 |= 1;
      }

      int var8;
      if(!var5 && this.field_1320 != null) {
         var8 = this.field_1320.method_3445(var3, var7);
      } else {
         this.field_1320 = new MediaStatus(var3);
         this.field_1319 = SystemClock.elapsedRealtime();
         var8 = 7;
      }

      if((var8 & 1) != 0) {
         this.field_1319 = SystemClock.elapsedRealtime();
         this.onStatusUpdated();
      }

      if((var8 & 2) != 0) {
         this.field_1319 = SystemClock.elapsedRealtime();
         this.onStatusUpdated();
      }

      if((var8 & 4) != 0) {
         this.onMetadataUpdated();
      }

      Iterator var9 = this.field_1316.iterator();

      while(var9.hasNext()) {
         ((class_327)var9.next()).method_2097(var1, 0);
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.gp, boolean) boolean
   // $FF: synthetic method
   static boolean method_2079(class_326 var0, boolean var1) {
      var0.field_1318 = var1;
      return var1;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.gp, boolean) void
   // $FF: synthetic method
   static void method_2080(class_326 var0, boolean var1) {
      var0.method_2082(var1);
   }

   // $FF: renamed from: eo () void
   private void method_2081() {
      this.method_2082(false);
      this.field_1319 = 0L;
      this.field_1320 = null;
      this.field_1321.clear();
      this.field_1325.clear();
      this.field_1326.clear();
   }

   // $FF: renamed from: z (boolean) void
   private void method_2082(boolean var1) {
      if(this.field_1318 != var1) {
         this.field_1318 = var1;
         if(!var1) {
            this.mHandler.removeCallbacks(this.field_1317);
            return;
         }

         this.mHandler.postDelayed(this.field_1317, field_1313);
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.gr) long
   public long method_2083(class_25 var1) throws IOException {
      JSONObject var2 = new JSONObject();
      long var3 = this.dY();
      this.field_1328.method_2095(var3, var1);
      this.method_2082(true);

      try {
         var2.put("requestId", var3);
         var2.put("type", "GET_STATUS");
         if(this.field_1320 != null) {
            var2.put("mediaSessionId", this.field_1320.method_3446());
         }
      } catch (JSONException var6) {
         ;
      }

      this.a(var2.toString(), var3, (String)null);
      return var3;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gr, double, org.json.JSONObject) long
   public long method_2084(class_25 param1, double param2, JSONObject param4) throws IOException, IllegalStateException, IllegalArgumentException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gr, long, int, org.json.JSONObject) long
   public long method_2085(class_25 param1, long param2, int param4, JSONObject param5) throws IOException, IllegalStateException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gr, com.google.android.gms.cast.MediaInfo, boolean, long, org.json.JSONObject) long
   public long method_2086(class_25 param1, MediaInfo param2, boolean param3, long param4, JSONObject param6) throws IOException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gr, com.google.android.gms.cast.TextTrackStyle) long
   public long method_2087(class_25 param1, TextTrackStyle param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gr, org.json.JSONObject) long
   public long method_2088(class_25 param1, JSONObject param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gr, boolean, org.json.JSONObject) long
   public long method_2089(class_25 param1, boolean param2, JSONObject param3) throws IOException, IllegalStateException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gr, long[]) long
   public long method_2090(class_25 param1, long[] param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (long, int) void
   public void method_2071(long var1, int var3) {
      Iterator var4 = this.field_1316.iterator();

      while(var4.hasNext()) {
         ((class_327)var4.next()).method_2097(var1, var3);
      }

   }

   // $FF: renamed from: ai (java.lang.String) void
   public final void method_2074(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.internal.gr, org.json.JSONObject) long
   public long method_2091(class_25 param1, JSONObject param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (com.google.android.gms.internal.gr, org.json.JSONObject) long
   public long method_2092(class_25 param1, JSONObject param2) throws IOException, IllegalStateException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dV () long
   public long method_2093() throws IllegalStateException {
      if(this.field_1320 == null) {
         throw new IllegalStateException("No current media session");
      } else {
         return this.field_1320.method_3446();
      }
   }

   // $FF: renamed from: dZ () void
   public void method_2076() {
      this.method_2081();
   }

   public long getApproximateStreamPosition() {
      MediaInfo var1 = this.getMediaInfo();
      if(var1 != null && this.field_1319 != 0L) {
         double var2 = this.field_1320.getPlaybackRate();
         long var4 = this.field_1320.getStreamPosition();
         int var6 = this.field_1320.getPlayerState();
         if(var2 != 0.0D && var6 == 2) {
            long var7 = SystemClock.elapsedRealtime() - this.field_1319;
            long var9;
            if(var7 < 0L) {
               var9 = 0L;
            } else {
               var9 = var7;
            }

            if(var9 == 0L) {
               return var4;
            } else {
               long var11 = var1.getStreamDuration();
               long var13 = var4 + (long)(var2 * (double)var9);
               if(var13 <= var11) {
                  if(var13 < 0L) {
                     var11 = 0L;
                  } else {
                     var11 = var13;
                  }
               }

               return var11;
            }
         } else {
            return var4;
         }
      } else {
         return 0L;
      }
   }

   public MediaInfo getMediaInfo() {
      return this.field_1320 == null?null:this.field_1320.getMediaInfo();
   }

   public MediaStatus getMediaStatus() {
      return this.field_1320;
   }

   public long getStreamDuration() {
      MediaInfo var1 = this.getMediaInfo();
      return var1 != null?var1.getStreamDuration():0L;
   }

   protected void onMetadataUpdated() {
   }

   protected void onStatusUpdated() {
   }

   private class class_933 implements Runnable {
      private class_933() {
      }

      // $FF: synthetic method
      class_933(Object var2) {
         this();
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }
}
