package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzi;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public class AdSizeParcel implements SafeParcelable {
   public static final zzi CREATOR = new zzi();
   public final int height;
   public final int heightPixels;
   public final int versionCode;
   public final int width;
   public final int widthPixels;
   public final String zzuh;
   public final boolean zzui;
   public final AdSizeParcel[] zzuj;
   public final boolean zzuk;
   public final boolean zzul;
   public boolean zzum;

   public AdSizeParcel() {
      this(5, "interstitial_mb", 0, 0, true, 0, 0, (AdSizeParcel[])null, false, false, false);
   }

   AdSizeParcel(int var1, String var2, int var3, int var4, boolean var5, int var6, int var7, AdSizeParcel[] var8, boolean var9, boolean var10, boolean var11) {
      this.versionCode = var1;
      this.zzuh = var2;
      this.height = var3;
      this.heightPixels = var4;
      this.zzui = var5;
      this.width = var6;
      this.widthPixels = var7;
      this.zzuj = var8;
      this.zzuk = var9;
      this.zzul = var10;
      this.zzum = var11;
   }

   public AdSizeParcel(Context var1, AdSize var2) {
      this(var1, new AdSize[]{var2});
   }

   public AdSizeParcel(Context var1, AdSize[] var2) {
      AdSize var3 = var2[0];
      this.versionCode = 5;
      this.zzui = false;
      this.zzul = var3.isFluid();
      if(this.zzul) {
         this.width = AdSize.BANNER.getWidth();
         this.height = AdSize.BANNER.getHeight();
      } else {
         this.width = var3.getWidth();
         this.height = var3.getHeight();
      }

      boolean var4;
      if(this.width == -1) {
         var4 = true;
      } else {
         var4 = false;
      }

      boolean var5;
      if(this.height == -2) {
         var5 = true;
      } else {
         var5 = false;
      }

      DisplayMetrics var6 = var1.getResources().getDisplayMetrics();
      int var8;
      if(var4) {
         if(zzn.zzcS().zzV(var1) && zzn.zzcS().zzW(var1)) {
            this.widthPixels = zza(var6) - zzn.zzcS().zzX(var1);
         } else {
            this.widthPixels = zza(var6);
         }

         double var11 = (double)((float)this.widthPixels / var6.density);
         int var13 = (int)var11;
         if(var11 - (double)((int)var11) >= 0.01D) {
            ++var13;
         }

         var8 = var13;
      } else {
         int var7 = this.width;
         this.widthPixels = zzn.zzcS().zza(var6, this.width);
         var8 = var7;
      }

      int var9;
      if(var5) {
         var9 = zzc(var6);
      } else {
         var9 = this.height;
      }

      this.heightPixels = zzn.zzcS().zza(var6, var9);
      if(!var4 && !var5) {
         if(this.zzul) {
            this.zzuh = "320x50_mb";
         } else {
            this.zzuh = var3.toString();
         }
      } else {
         this.zzuh = var8 + "x" + var9 + "_as";
      }

      if(var2.length > 1) {
         this.zzuj = new AdSizeParcel[var2.length];

         for(int var10 = 0; var10 < var2.length; ++var10) {
            this.zzuj[var10] = new AdSizeParcel(var1, var2[var10]);
         }
      } else {
         this.zzuj = null;
      }

      this.zzuk = false;
      this.zzum = false;
   }

   public static int zza(DisplayMetrics var0) {
      return var0.widthPixels;
   }

   public static int zzb(DisplayMetrics var0) {
      return (int)((float)zzc(var0) * var0.density);
   }

   private static int zzc(DisplayMetrics var0) {
      int var1 = (int)((float)var0.heightPixels / var0.density);
      return var1 <= 400?32:(var1 <= 720?50:90);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzi.zza(this, var1, var2);
   }

   public AdSize zzcQ() {
      return com.google.android.gms.ads.zza.zza(this.width, this.height, this.zzuh);
   }

   public void zzi(boolean var1) {
      this.zzum = var1;
   }
}
