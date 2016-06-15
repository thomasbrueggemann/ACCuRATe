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
import com.google.android.gms.internal.class_365;
import com.google.android.gms.internal.class_371;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.ed
public final class class_377 {
   // $FF: renamed from: qY int
   public final int field_1639;
   // $FF: renamed from: qZ boolean
   public final boolean field_1640;
   // $FF: renamed from: ra boolean
   public final boolean field_1641;
   // $FF: renamed from: rb java.lang.String
   public final String field_1642;
   // $FF: renamed from: rc java.lang.String
   public final String field_1643;
   // $FF: renamed from: rd boolean
   public final boolean field_1644;
   // $FF: renamed from: re boolean
   public final boolean field_1645;
   // $FF: renamed from: rf boolean
   public final boolean field_1646;
   // $FF: renamed from: rg java.lang.String
   public final String field_1647;
   // $FF: renamed from: rh java.lang.String
   public final String field_1648;
   // $FF: renamed from: ri int
   public final int field_1649;
   // $FF: renamed from: rj int
   public final int field_1650;
   // $FF: renamed from: rk int
   public final int field_1651;
   // $FF: renamed from: rl int
   public final int field_1652;
   // $FF: renamed from: rm int
   public final int field_1653;
   // $FF: renamed from: rn int
   public final int field_1654;
   // $FF: renamed from: ro float
   public final float field_1655;
   // $FF: renamed from: rp int
   public final int field_1656;
   // $FF: renamed from: rq int
   public final int field_1657;
   // $FF: renamed from: rr double
   public final double field_1658;
   // $FF: renamed from: rs boolean
   public final boolean field_1659;
   // $FF: renamed from: rt boolean
   public final boolean field_1660;
   // $FF: renamed from: ru int
   public final int field_1661;

   public class_377(Context var1) {
      boolean var2 = true;
      super();
      AudioManager var3 = (AudioManager)var1.getSystemService("audio");
      ConnectivityManager var4 = (ConnectivityManager)var1.getSystemService("connectivity");
      DisplayMetrics var5 = var1.getResources().getDisplayMetrics();
      Locale var6 = Locale.getDefault();
      PackageManager var7 = var1.getPackageManager();
      TelephonyManager var8 = (TelephonyManager)var1.getSystemService("phone");
      Intent var9 = var1.registerReceiver((BroadcastReceiver)null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      this.field_1639 = var3.getMode();
      boolean var10;
      if(method_2403(var7, "geo:0,0?q=donuts") != null) {
         var10 = var2;
      } else {
         var10 = false;
      }

      this.field_1640 = var10;
      boolean var11;
      if(method_2403(var7, "http://www.google.com") != null) {
         var11 = var2;
      } else {
         var11 = false;
      }

      this.field_1641 = var11;
      this.field_1642 = var8.getNetworkOperator();
      this.field_1643 = var6.getCountry();
      this.field_1644 = class_371.method_2369();
      this.field_1645 = var3.isMusicActive();
      this.field_1646 = var3.isSpeakerphoneOn();
      this.field_1647 = var6.getLanguage();
      this.field_1648 = method_2404(var7);
      this.field_1649 = var3.getStreamVolume(3);
      this.field_1650 = method_2402(var1, var4, var7);
      this.field_1651 = var8.getNetworkType();
      this.field_1652 = var8.getPhoneType();
      this.field_1653 = var3.getRingerMode();
      this.field_1654 = var3.getStreamVolume(2);
      this.field_1655 = var5.density;
      this.field_1656 = var5.widthPixels;
      this.field_1657 = var5.heightPixels;
      if(var9 != null) {
         int var12 = var9.getIntExtra("status", -1);
         int var13 = var9.getIntExtra("level", -1);
         int var14 = var9.getIntExtra("scale", -1);
         this.field_1658 = (double)((float)var13 / (float)var14);
         if(var12 != 2 && var12 != 5) {
            var2 = false;
         }

         this.field_1659 = var2;
      } else {
         this.field_1658 = -1.0D;
         this.field_1659 = false;
      }

      if(VERSION.SDK_INT >= 16) {
         this.field_1660 = var4.isActiveNetworkMetered();
         if(var4.getActiveNetworkInfo() != null) {
            this.field_1661 = var4.getActiveNetworkInfo().getDetailedState().ordinal();
         } else {
            this.field_1661 = -1;
         }
      } else {
         this.field_1660 = false;
         this.field_1661 = -1;
      }
   }

   // $FF: renamed from: a (android.content.Context, android.net.ConnectivityManager, android.content.pm.PackageManager) int
   private static int method_2402(Context var0, ConnectivityManager var1, PackageManager var2) {
      int var3 = -2;
      if(class_365.method_2298(var2, var0.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
         NetworkInfo var4 = var1.getActiveNetworkInfo();
         if(var4 == null) {
            return -1;
         }

         var3 = var4.getType();
      }

      return var3;
   }

   // $FF: renamed from: a (android.content.pm.PackageManager, java.lang.String) android.content.pm.ResolveInfo
   private static ResolveInfo method_2403(PackageManager var0, String var1) {
      return var0.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(var1)), 65536);
   }

   // $FF: renamed from: a (android.content.pm.PackageManager) java.lang.String
   private static String method_2404(PackageManager param0) {
      // $FF: Couldn't be decompiled
   }
}
