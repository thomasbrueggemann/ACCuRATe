package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.internal.class_13;
import com.google.android.gms.internal.class_317;
import com.google.android.gms.internal.class_320;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.iw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.it
public class class_321 extends class_320 {
   // $FF: renamed from: HR long
   private static final long field_796;
   // $FF: renamed from: HS long
   private static final long field_797;
   // $FF: renamed from: HT long
   private static final long field_798;
   // $FF: renamed from: HU long
   private static final long field_799;
   private static final String NAMESPACE = class_322.method_2264("com.google.cast.media");
   // $FF: renamed from: HV long
   private long field_800;
   // $FF: renamed from: HW com.google.android.gms.cast.MediaStatus
   private MediaStatus field_801;
   // $FF: renamed from: HX com.google.android.gms.internal.iw
   private final class_317 field_802;
   // $FF: renamed from: HY com.google.android.gms.internal.iw
   private final class_317 field_803;
   // $FF: renamed from: HZ com.google.android.gms.internal.iw
   private final class_317 field_804;
   // $FF: renamed from: Ia com.google.android.gms.internal.iw
   private final class_317 field_805;
   // $FF: renamed from: Ib com.google.android.gms.internal.iw
   private final class_317 field_806;
   // $FF: renamed from: Ic com.google.android.gms.internal.iw
   private final class_317 field_807;
   // $FF: renamed from: Id com.google.android.gms.internal.iw
   private final class_317 field_808;
   // $FF: renamed from: Ie com.google.android.gms.internal.iw
   private final class_317 field_809;
   // $FF: renamed from: If com.google.android.gms.internal.iw
   private final class_317 field_810;
   // $FF: renamed from: Ig com.google.android.gms.internal.iw
   private final class_317 field_811;
   // $FF: renamed from: Ih java.util.List
   private final List<iw> field_812;
   // $FF: renamed from: Ii java.lang.Runnable
   private final Runnable field_813;
   // $FF: renamed from: Ij boolean
   private boolean field_814;
   private final Handler mHandler;

   static {
      field_796 = TimeUnit.HOURS.toMillis(24L);
      field_797 = TimeUnit.HOURS.toMillis(24L);
      field_798 = TimeUnit.HOURS.toMillis(24L);
      field_799 = TimeUnit.SECONDS.toMillis(1L);
   }

   public class_321() {
      this((String)null);
   }

   public class_321(String var1) {
      super(NAMESPACE, "MediaControlChannel", var1);
      this.mHandler = new Handler(Looper.getMainLooper());
      this.field_813 = new class_321.class_1117();
      this.field_812 = new ArrayList();
      this.field_802 = new class_317(field_797);
      this.field_812.add(this.field_802);
      this.field_803 = new class_317(field_796);
      this.field_812.add(this.field_803);
      this.field_804 = new class_317(field_796);
      this.field_812.add(this.field_804);
      this.field_805 = new class_317(field_796);
      this.field_812.add(this.field_805);
      this.field_806 = new class_317(field_798);
      this.field_812.add(this.field_806);
      this.field_807 = new class_317(field_796);
      this.field_812.add(this.field_807);
      this.field_808 = new class_317(field_796);
      this.field_812.add(this.field_808);
      this.field_809 = new class_317(field_796);
      this.field_812.add(this.field_809);
      this.field_810 = new class_317(field_796);
      this.field_812.add(this.field_810);
      this.field_811 = new class_317(field_796);
      this.field_812.add(this.field_811);
      this.method_2250();
   }

   // $FF: renamed from: J (boolean) void
   private void method_2245(boolean var1) {
      if(this.field_814 != var1) {
         this.field_814 = var1;
         if(!var1) {
            this.mHandler.removeCallbacks(this.field_813);
            return;
         }

         this.mHandler.postDelayed(this.field_813, field_799);
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.it) java.util.List
   // $FF: synthetic method
   static List method_2246(class_321 var0) {
      return var0.field_812;
   }

   // $FF: renamed from: a (long, org.json.JSONObject) void
   private void method_2247(long var1, JSONObject var3) throws JSONException {
      boolean var4 = true;
      boolean var5 = this.field_802.method_2221(var1);
      boolean var6;
      if(this.field_806.method_2220() && !this.field_806.method_2221(var1)) {
         var6 = var4;
      } else {
         var6 = false;
      }

      if((!this.field_807.method_2220() || this.field_807.method_2221(var1)) && (!this.field_808.method_2220() || this.field_808.method_2221(var1))) {
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
      if(!var5 && this.field_801 != null) {
         var8 = this.field_801.method_4121(var3, var7);
      } else {
         this.field_801 = new MediaStatus(var3);
         this.field_800 = SystemClock.elapsedRealtime();
         var8 = 7;
      }

      if((var8 & 1) != 0) {
         this.field_800 = SystemClock.elapsedRealtime();
         this.onStatusUpdated();
      }

      if((var8 & 2) != 0) {
         this.field_800 = SystemClock.elapsedRealtime();
         this.onStatusUpdated();
      }

      if((var8 & 4) != 0) {
         this.onMetadataUpdated();
      }

      Iterator var9 = this.field_812.iterator();

      while(var9.hasNext()) {
         ((class_317)var9.next()).method_2218(var1, 0);
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.it, boolean) boolean
   // $FF: synthetic method
   static boolean method_2248(class_321 var0, boolean var1) {
      var0.field_814 = var1;
      return var1;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.it, boolean) void
   // $FF: synthetic method
   static void method_2249(class_321 var0, boolean var1) {
      var0.method_2245(var1);
   }

   // $FF: renamed from: gp () void
   private void method_2250() {
      this.method_2245(false);
      this.field_800 = 0L;
      this.field_801 = null;
      this.field_802.clear();
      this.field_806.clear();
      this.field_807.clear();
   }

   // $FF: renamed from: a (com.google.android.gms.internal.iv) long
   public long method_2251(class_13 var1) throws IOException {
      JSONObject var2 = new JSONObject();
      long var3 = this.fU();
      this.field_809.method_2216(var3, var1);
      this.method_2245(true);

      try {
         var2.put("requestId", var3);
         var2.put("type", "GET_STATUS");
         if(this.field_801 != null) {
            var2.put("mediaSessionId", this.field_801.method_4122());
         }
      } catch (JSONException var6) {
         ;
      }

      this.a(var2.toString(), var3, (String)null);
      return var3;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.iv, double, org.json.JSONObject) long
   public long method_2252(class_13 param1, double param2, JSONObject param4) throws IOException, IllegalStateException, IllegalArgumentException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.iv, long, int, org.json.JSONObject) long
   public long method_2253(class_13 param1, long param2, int param4, JSONObject param5) throws IOException, IllegalStateException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.iv, com.google.android.gms.cast.MediaInfo, boolean, long, long[], org.json.JSONObject) long
   public long method_2254(class_13 param1, MediaInfo param2, boolean param3, long param4, long[] param6, JSONObject param7) throws IOException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.iv, com.google.android.gms.cast.TextTrackStyle) long
   public long method_2255(class_13 param1, TextTrackStyle param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.iv, org.json.JSONObject) long
   public long method_2256(class_13 param1, JSONObject param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.iv, boolean, org.json.JSONObject) long
   public long method_2257(class_13 param1, boolean param2, JSONObject param3) throws IOException, IllegalStateException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.iv, long[]) long
   public long method_2258(class_13 param1, long[] param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: aD (java.lang.String) void
   public final void method_2241(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.internal.iv, org.json.JSONObject) long
   public long method_2259(class_13 param1, JSONObject param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (long, int) void
   public void method_2242(long var1, int var3) {
      Iterator var4 = this.field_812.iterator();

      while(var4.hasNext()) {
         ((class_317)var4.next()).method_2218(var1, var3);
      }

   }

   // $FF: renamed from: c (com.google.android.gms.internal.iv, org.json.JSONObject) long
   public long method_2260(class_13 param1, JSONObject param2) throws IOException, IllegalStateException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: fR () long
   public long method_2261() throws IllegalStateException {
      if(this.field_801 == null) {
         throw new IllegalStateException("No current media session");
      } else {
         return this.field_801.method_4122();
      }
   }

   // $FF: renamed from: fV () void
   public void method_2244() {
      this.method_2250();
   }

   public long getApproximateStreamPosition() {
      MediaInfo var1 = this.getMediaInfo();
      if(var1 != null && this.field_800 != 0L) {
         double var2 = this.field_801.getPlaybackRate();
         long var4 = this.field_801.getStreamPosition();
         int var6 = this.field_801.getPlayerState();
         if(var2 != 0.0D && var6 == 2) {
            long var7 = SystemClock.elapsedRealtime() - this.field_800;
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
               if(var11 <= 0L || var13 <= var11) {
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
      return this.field_801 == null?null:this.field_801.getMediaInfo();
   }

   public MediaStatus getMediaStatus() {
      return this.field_801;
   }

   public long getStreamDuration() {
      MediaInfo var1 = this.getMediaInfo();
      return var1 != null?var1.getStreamDuration():0L;
   }

   protected void onMetadataUpdated() {
   }

   protected void onStatusUpdated() {
   }

   private class class_1117 implements Runnable {
      private class_1117() {
      }

      // $FF: synthetic method
      class_1117(Object var2) {
         this();
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }
}
