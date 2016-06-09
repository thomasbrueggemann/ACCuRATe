package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzne;

@zzhb
public class zza {
   public static final Handler zzMS = new Handler(Looper.getMainLooper());
   private static final String zzMT = AdView.class.getName();
   private static final String zzMU = InterstitialAd.class.getName();
   private static final String zzMV = PublisherAdView.class.getName();
   private static final String zzMW = PublisherInterstitialAd.class.getName();
   private static final String zzMX = SearchAdView.class.getName();
   private static final String zzMY = AdLoader.class.getName();

   public boolean zzV(Context var1) {
      if(var1.getResources().getConfiguration().orientation == 2) {
         DisplayMetrics var2 = var1.getResources().getDisplayMetrics();
         if((int)((float)var2.heightPixels / var2.density) < 600) {
            return true;
         }
      }

      return false;
   }

   public boolean zzW(Context var1) {
      DisplayMetrics var2 = var1.getResources().getDisplayMetrics();
      Display var3 = ((WindowManager)var1.getSystemService("window")).getDefaultDisplay();
      int var5;
      int var7;
      if(zzne.zzsi()) {
         var3.getRealMetrics(var2);
         var5 = var2.heightPixels;
         var7 = var2.widthPixels;
      } else {
         int var6;
         try {
            var5 = ((Integer)Display.class.getMethod("getRawHeight", new Class[0]).invoke(var3, new Object[0])).intValue();
            var6 = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(var3, new Object[0])).intValue();
         } catch (Exception var11) {
            return false;
         }

         var7 = var6;
      }

      var3.getMetrics(var2);
      int var8 = var2.heightPixels;
      int var9 = var2.widthPixels;
      boolean var10;
      if(var8 == var5 && var9 == var7) {
         var10 = true;
      } else {
         var10 = false;
      }

      return var10;
   }

   public int zzX(Context var1) {
      int var2 = var1.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
      return var2 > 0?var1.getResources().getDimensionPixelSize(var2):0;
   }

   public int zza(DisplayMetrics var1, int var2) {
      return (int)TypedValue.applyDimension(1, (float)var2, var1);
   }

   public int zzb(Context var1, int var2) {
      return this.zza(var1.getResources().getDisplayMetrics(), var2);
   }

   public int zzb(DisplayMetrics var1, int var2) {
      return Math.round((float)var2 / var1.density);
   }

   public int zzc(Context var1, int var2) {
      Display var3 = ((WindowManager)var1.getSystemService("window")).getDefaultDisplay();
      DisplayMetrics var4 = new DisplayMetrics();
      var3.getMetrics(var4);
      return this.zzb(var4, var2);
   }

   public boolean zzhJ() {
      return Looper.myLooper() == Looper.getMainLooper();
   }
}
