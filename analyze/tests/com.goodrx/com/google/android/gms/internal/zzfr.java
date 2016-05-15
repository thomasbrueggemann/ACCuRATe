package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.zzbl;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzfq;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import java.util.Map;

@zzhb
public class zzfr extends zzfs implements zzdf {
   private final Context mContext;
   DisplayMetrics zzDA;
   private float zzDB;
   int zzDC = -1;
   int zzDD = -1;
   private int zzDE;
   int zzDF = -1;
   int zzDG = -1;
   int zzDH = -1;
   int zzDI = -1;
   private final zzbl zzDz;
   private final zzjp zzpD;
   private final WindowManager zzsb;

   public zzfr(zzjp var1, Context var2, zzbl var3) {
      super(var1);
      this.zzpD = var1;
      this.mContext = var2;
      this.zzDz = var3;
      this.zzsb = (WindowManager)var2.getSystemService("window");
   }

   private void zzeQ() {
      this.zzDA = new DisplayMetrics();
      Display var1 = this.zzsb.getDefaultDisplay();
      var1.getMetrics(this.zzDA);
      this.zzDB = this.zzDA.density;
      this.zzDE = var1.getRotation();
   }

   private void zzeV() {
      int[] var1 = new int[2];
      this.zzpD.getLocationOnScreen(var1);
      this.zzf(com.google.android.gms.ads.internal.client.zzn.zzcS().zzc(this.mContext, var1[0]), com.google.android.gms.ads.internal.client.zzn.zzcS().zzc(this.mContext, var1[1]));
   }

   private zzfq zzeY() {
      return (new zzfq.zza()).zzr(this.zzDz.zzdj()).zzq(this.zzDz.zzdk()).zzs(this.zzDz.zzdo()).zzt(this.zzDz.zzdl()).zzu(this.zzDz.zzdm()).zzeP();
   }

   public void zza(zzjp var1, Map<String, String> var2) {
      this.zzeT();
   }

   void zzeR() {
      this.zzDC = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDA, this.zzDA.widthPixels);
      this.zzDD = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDA, this.zzDA.heightPixels);
      Activity var1 = this.zzpD.zzhP();
      if(var1 != null && var1.getWindow() != null) {
         int[] var2 = com.google.android.gms.ads.internal.zzr.zzbC().zze(var1);
         this.zzDF = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDA, var2[0]);
         this.zzDG = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDA, var2[1]);
      } else {
         this.zzDF = this.zzDC;
         this.zzDG = this.zzDD;
      }
   }

   void zzeS() {
      if(this.zzpD.zzaN().zzui) {
         this.zzDH = this.zzDC;
         this.zzDI = this.zzDD;
      } else {
         this.zzpD.measure(0, 0);
         this.zzDH = com.google.android.gms.ads.internal.client.zzn.zzcS().zzc(this.mContext, this.zzpD.getMeasuredWidth());
         this.zzDI = com.google.android.gms.ads.internal.client.zzn.zzcS().zzc(this.mContext, this.zzpD.getMeasuredHeight());
      }
   }

   public void zzeT() {
      this.zzeQ();
      this.zzeR();
      this.zzeS();
      this.zzeW();
      this.zzeX();
      this.zzeV();
      this.zzeU();
   }

   void zzeU() {
      if(zzin.zzQ(2)) {
         zzin.zzaJ("Dispatching Ready Event.");
      }

      this.zzan(this.zzpD.zzhX().afmaVersion);
   }

   void zzeW() {
      this.zza(this.zzDC, this.zzDD, this.zzDF, this.zzDG, this.zzDB, this.zzDE);
   }

   void zzeX() {
      zzfq var1 = this.zzeY();
      this.zzpD.zzb("onDeviceFeaturesReceived", var1.toJson());
   }

   public void zzf(int var1, int var2) {
      int var3;
      if(this.mContext instanceof Activity) {
         var3 = com.google.android.gms.ads.internal.zzr.zzbC().zzh((Activity)this.mContext)[0];
      } else {
         var3 = 0;
      }

      this.zzc(var1, var2 - var3, this.zzDH, this.zzDI);
      this.zzpD.zzhU().zze(var1, var2);
   }
}
