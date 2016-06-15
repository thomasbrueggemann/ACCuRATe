package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.ey;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.fv
@ey
public final class class_434 {
   // $FF: renamed from: vA boolean
   public final boolean field_1408;
   // $FF: renamed from: vB boolean
   public final boolean field_1409;
   // $FF: renamed from: vC int
   public final int field_1410;
   // $FF: renamed from: vg int
   public final int field_1411;
   // $FF: renamed from: vh boolean
   public final boolean field_1412;
   // $FF: renamed from: vi boolean
   public final boolean field_1413;
   // $FF: renamed from: vj java.lang.String
   public final String field_1414;
   // $FF: renamed from: vk java.lang.String
   public final String field_1415;
   // $FF: renamed from: vl boolean
   public final boolean field_1416;
   // $FF: renamed from: vm boolean
   public final boolean field_1417;
   // $FF: renamed from: vn boolean
   public final boolean field_1418;
   // $FF: renamed from: vo java.lang.String
   public final String field_1419;
   // $FF: renamed from: vp java.lang.String
   public final String field_1420;
   // $FF: renamed from: vq int
   public final int field_1421;
   // $FF: renamed from: vr int
   public final int field_1422;
   // $FF: renamed from: vs int
   public final int field_1423;
   // $FF: renamed from: vt int
   public final int field_1424;
   // $FF: renamed from: vu int
   public final int field_1425;
   // $FF: renamed from: vv int
   public final int field_1426;
   // $FF: renamed from: vw float
   public final float field_1427;
   // $FF: renamed from: vx int
   public final int field_1428;
   // $FF: renamed from: vy int
   public final int field_1429;
   // $FF: renamed from: vz double
   public final double field_1430;

   public class_434(Context var1) {
      boolean var2 = true;
      super();
      AudioManager var3 = (AudioManager)var1.getSystemService("audio");
      ConnectivityManager var4 = (ConnectivityManager)var1.getSystemService("connectivity");
      DisplayMetrics var5 = var1.getResources().getDisplayMetrics();
      Locale var6 = Locale.getDefault();
      PackageManager var7 = var1.getPackageManager();
      TelephonyManager var8 = (TelephonyManager)var1.getSystemService("phone");
      Intent var9 = var1.registerReceiver((BroadcastReceiver)null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      this.field_1411 = var3.getMode();
      boolean var10;
      if(method_2857(var7, "geo:0,0?q=donuts") != null) {
         var10 = var2;
      } else {
         var10 = false;
      }

      this.field_1412 = var10;
      boolean var11;
      if(method_2857(var7, "http://www.google.com") != null) {
         var11 = var2;
      } else {
         var11 = false;
      }

      this.field_1413 = var11;
      this.field_1414 = var8.getNetworkOperator();
      this.field_1415 = var6.getCountry();
      this.field_1416 = class_367.method_2499();
      this.field_1417 = var3.isMusicActive();
      this.field_1418 = var3.isSpeakerphoneOn();
      this.field_1419 = var6.getLanguage();
      this.field_1420 = method_2858(var7);
      this.field_1421 = var3.getStreamVolume(3);
      this.field_1422 = method_2856(var1, var4, var7);
      this.field_1423 = var8.getNetworkType();
      this.field_1424 = var8.getPhoneType();
      this.field_1425 = var3.getRingerMode();
      this.field_1426 = var3.getStreamVolume(2);
      this.field_1427 = var5.density;
      this.field_1428 = var5.widthPixels;
      this.field_1429 = var5.heightPixels;
      if(var9 != null) {
         int var12 = var9.getIntExtra("status", -1);
         int var13 = var9.getIntExtra("level", -1);
         int var14 = var9.getIntExtra("scale", -1);
         this.field_1430 = (double)((float)var13 / (float)var14);
         if(var12 != 2 && var12 != 5) {
            var2 = false;
         }

         this.field_1408 = var2;
      } else {
         this.field_1430 = -1.0D;
         this.field_1408 = false;
      }

      if(VERSION.SDK_INT >= 16) {
         this.field_1409 = var4.isActiveNetworkMetered();
         if(var4.getActiveNetworkInfo() != null) {
            this.field_1410 = var4.getActiveNetworkInfo().getDetailedState().ordinal();
         } else {
            this.field_1410 = -1;
         }
      } else {
         this.field_1409 = false;
         this.field_1410 = -1;
      }
   }

   // $FF: renamed from: a (android.content.Context, android.net.ConnectivityManager, android.content.pm.PackageManager) int
   private static int method_2856(Context var0, ConnectivityManager var1, PackageManager var2) {
      int var3 = -2;
      if(class_375.method_2563(var2, var0.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
         NetworkInfo var4 = var1.getActiveNetworkInfo();
         if(var4 == null) {
            return -1;
         }

         var3 = var4.getType();
      }

      return var3;
   }

   // $FF: renamed from: a (android.content.pm.PackageManager, java.lang.String) android.content.pm.ResolveInfo
   private static ResolveInfo method_2857(PackageManager var0, String var1) {
      return var0.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(var1)), 65536);
   }

   // $FF: renamed from: a (android.content.pm.PackageManager) java.lang.String
   private static String method_2858(PackageManager param0) {
      // $FF: Couldn't be decompiled
   }
}
