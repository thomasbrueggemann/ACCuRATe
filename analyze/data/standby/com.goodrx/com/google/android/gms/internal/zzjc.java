package com.google.android.gms.internal;

import android.app.Activity;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class zzjc {
   private Activity zzMM;
   private boolean zzMN;
   private boolean zzMO;
   private boolean zzMP;
   private OnGlobalLayoutListener zzMQ;
   private OnScrollChangedListener zzMR;

   public zzjc(Activity var1, OnGlobalLayoutListener var2, OnScrollChangedListener var3) {
      this.zzMM = var1;
      this.zzMQ = var2;
      this.zzMR = var3;
   }

   private void zzhG() {
      if(this.zzMM != null && !this.zzMN) {
         if(this.zzMQ != null) {
            com.google.android.gms.ads.internal.zzr.zzbC().zza(this.zzMM, this.zzMQ);
         }

         if(this.zzMR != null) {
            com.google.android.gms.ads.internal.zzr.zzbC().zza(this.zzMM, this.zzMR);
         }

         this.zzMN = true;
      }
   }

   private void zzhH() {
      if(this.zzMM != null && this.zzMN) {
         if(this.zzMQ != null) {
            com.google.android.gms.ads.internal.zzr.zzbE().zzb(this.zzMM, this.zzMQ);
         }

         if(this.zzMR != null) {
            com.google.android.gms.ads.internal.zzr.zzbC().zzb(this.zzMM, this.zzMR);
         }

         this.zzMN = false;
      }
   }

   public void onAttachedToWindow() {
      this.zzMO = true;
      if(this.zzMP) {
         this.zzhG();
      }

   }

   public void onDetachedFromWindow() {
      this.zzMO = false;
      this.zzhH();
   }

   public void zzhE() {
      this.zzMP = true;
      if(this.zzMO) {
         this.zzhG();
      }

   }

   public void zzhF() {
      this.zzMP = false;
      this.zzhH();
   }

   public void zzi(Activity var1) {
      this.zzMM = var1;
   }
}
