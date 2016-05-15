package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzdj;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zziu;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import java.util.Collections;
import java.util.Map;

@zzhb
public class zzd extends zzfv.zza implements zzs {
   static final int zzEg = Color.argb(0, 0, 0, 0);
   private final Activity mActivity;
   RelativeLayout zzDm;
   AdOverlayInfoParcel zzEh;
   zzd.zzc zzEi;
   zzo zzEj;
   boolean zzEk = false;
   FrameLayout zzEl;
   CustomViewCallback zzEm;
   boolean zzEn = false;
   boolean zzEo = false;
   boolean zzEp = false;
   int zzEq = 0;
   zzl zzEr;
   private boolean zzEs;
   private boolean zzEt = false;
   private boolean zzEu = true;
   zzjp zzpD;

   public zzd(Activity var1) {
      this.mActivity = var1;
      this.zzEr = new zzq();
   }

   public void close() {
      this.zzEq = 2;
      this.mActivity.finish();
   }

   public void onBackPressed() {
      this.zzEq = 0;
   }

   public void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public void onDestroy() {
      if(this.zzpD != null) {
         this.zzDm.removeView(this.zzpD.getView());
      }

      this.zzfp();
   }

   public void onPause() {
      this.zzEr.pause();
      this.zzfl();
      if(this.zzEh.zzEC != null) {
         this.zzEh.zzEC.onPause();
      }

      if(this.zzpD != null && (!this.mActivity.isFinishing() || this.zzEi == null)) {
         zzr.zzbE().zzi(this.zzpD);
      }

      this.zzfp();
   }

   public void onRestart() {
   }

   public void onResume() {
      if(this.zzEh != null && this.zzEh.zzEJ == 4) {
         if(this.zzEn) {
            this.zzEq = 3;
            this.mActivity.finish();
         } else {
            this.zzEn = true;
         }
      }

      if(this.zzEh.zzEC != null) {
         this.zzEh.zzEC.onResume();
      }

      if(this.zzpD != null && !this.zzpD.isDestroyed()) {
         zzr.zzbE().zzj(this.zzpD);
      } else {
         zzin.zzaK("The webview does not exit. Ignoring action.");
      }

      this.zzEr.resume();
   }

   public void onSaveInstanceState(Bundle var1) {
      var1.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzEn);
   }

   public void onStart() {
   }

   public void onStop() {
      this.zzfp();
   }

   public void setRequestedOrientation(int var1) {
      this.mActivity.setRequestedOrientation(var1);
   }

   public void zza(View var1, CustomViewCallback var2) {
      this.zzEl = new FrameLayout(this.mActivity);
      this.zzEl.setBackgroundColor(-16777216);
      this.zzEl.addView(var1, -1, -1);
      this.mActivity.setContentView(this.zzEl);
      this.zzaD();
      this.zzEm = var2;
      this.zzEk = true;
   }

   public void zza(boolean var1, boolean var2) {
      if(this.zzEj != null) {
         this.zzEj.zza(var1, var2);
      }

   }

   public void zzaD() {
      this.zzEs = true;
   }

   public void zzfl() {
      if(this.zzEh != null && this.zzEk) {
         this.setRequestedOrientation(this.zzEh.orientation);
      }

      if(this.zzEl != null) {
         this.mActivity.setContentView(this.zzDm);
         this.zzaD();
         this.zzEl.removeAllViews();
         this.zzEl = null;
      }

      if(this.zzEm != null) {
         this.zzEm.onCustomViewHidden();
         this.zzEm = null;
      }

      this.zzEk = false;
   }

   public void zzfm() {
      this.zzEq = 1;
      this.mActivity.finish();
   }

   public boolean zzfn() {
      boolean var1 = true;
      this.zzEq = 0;
      if(this.zzpD != null) {
         if(!this.zzpD.zzfL() || !this.zzEr.zzfL()) {
            var1 = false;
         }

         if(!var1) {
            this.zzpD.zza("onbackblocked", Collections.emptyMap());
            return var1;
         }
      }

      return var1;
   }

   public void zzfo() {
      this.zzDm.removeView(this.zzEj);
      this.zzw(true);
   }

   protected void zzfp() {
      if(this.mActivity.isFinishing() && !this.zzEt) {
         this.zzEt = true;
         if(this.zzpD != null) {
            this.zzy(this.zzEq);
            this.zzDm.removeView(this.zzpD.getView());
            if(this.zzEi != null) {
               this.zzpD.setContext(this.zzEi.context);
               this.zzpD.zzD(false);
               this.zzEi.zzEx.addView(this.zzpD.getView(), this.zzEi.index, this.zzEi.zzEw);
               this.zzEi = null;
            } else if(this.mActivity.getApplicationContext() != null) {
               this.zzpD.setContext(this.mActivity.getApplicationContext());
            }

            this.zzpD = null;
         }

         if(this.zzEh != null && this.zzEh.zzEC != null) {
            this.zzEh.zzEC.zzaW();
         }

         this.zzEr.destroy();
      }
   }

   public void zzfq() {
      if(this.zzEp) {
         this.zzEp = false;
         this.zzfr();
      }

   }

   protected void zzfr() {
      this.zzpD.zzfr();
   }

   public void zzg(zzjp var1, Map<String, String> var2) {
      this.zzEr.zzg(var1, var2);
   }

   public void zzw(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 50;
      } else {
         var2 = 32;
      }

      this.zzEj = new zzo(this.mActivity, var2, this);
      LayoutParams var3 = new LayoutParams(-2, -2);
      var3.addRule(10);
      byte var4;
      if(var1) {
         var4 = 11;
      } else {
         var4 = 9;
      }

      var3.addRule(var4);
      this.zzEj.zza(var1, this.zzEh.zzEG);
      this.zzDm.addView(this.zzEj, var3);
   }

   protected void zzx(boolean var1) throws zzd.zza {
      if(!this.zzEs) {
         this.mActivity.requestWindowFeature(1);
      }

      Window var2 = this.mActivity.getWindow();
      if(var2 == null) {
         throw new zzd.zza("Invalid activity, no window available.");
      } else {
         if(!this.zzEo || this.zzEh.zzEM != null && this.zzEh.zzEM.zzqm) {
            var2.setFlags(1024, 1024);
         }

         boolean var3 = this.zzEh.zzED.zzhU().zzcv();
         this.zzEp = false;
         if(var3) {
            if(this.zzEh.orientation == zzr.zzbE().zzhv()) {
               boolean var8;
               if(this.mActivity.getResources().getConfiguration().orientation == 1) {
                  var8 = true;
               } else {
                  var8 = false;
               }

               this.zzEp = var8;
            } else if(this.zzEh.orientation == zzr.zzbE().zzhw()) {
               boolean var7;
               if(this.mActivity.getResources().getConfiguration().orientation == 2) {
                  var7 = true;
               } else {
                  var7 = false;
               }

               this.zzEp = var7;
            }
         }

         zzin.zzaI("Delay onShow to next orientation change: " + this.zzEp);
         this.setRequestedOrientation(this.zzEh.orientation);
         if(zzr.zzbE().zza(var2)) {
            zzin.zzaI("Hardware acceleration on the AdActivity window enabled.");
         }

         if(!this.zzEo) {
            this.zzDm.setBackgroundColor(-16777216);
         } else {
            this.zzDm.setBackgroundColor(zzEg);
         }

         this.mActivity.setContentView(this.zzDm);
         this.zzaD();
         if(var1) {
            this.zzpD = zzr.zzbD().zza(this.mActivity, this.zzEh.zzED.zzaN(), true, var3, (zzan)null, this.zzEh.zzrl, (zzcb)null, this.zzEh.zzED.zzhR());
            this.zzpD.zzhU().zzb((com.google.android.gms.ads.internal.client.zza)null, (zzg)null, this.zzEh.zzEE, this.zzEh.zzEI, true, this.zzEh.zzEK, (zzdj)null, this.zzEh.zzED.zzhU().zzig(), (zzft)null);
            this.zzpD.zzhU().zza(new zzjq.zza() {
               public void zza(zzjp var1, boolean var2) {
                  var1.zzfr();
               }
            });
            if(this.zzEh.url != null) {
               this.zzpD.loadUrl(this.zzEh.url);
            } else {
               if(this.zzEh.zzEH == null) {
                  throw new zzd.zza("No URL or HTML to display in ad overlay.");
               }

               this.zzpD.loadDataWithBaseURL(this.zzEh.zzEF, this.zzEh.zzEH, "text/html", "UTF-8", (String)null);
            }

            if(this.zzEh.zzED != null) {
               this.zzEh.zzED.zzc(this);
            }
         } else {
            this.zzpD = this.zzEh.zzED;
            this.zzpD.setContext(this.mActivity);
         }

         this.zzpD.zzb(this);
         ViewParent var4 = this.zzpD.getParent();
         if(var4 != null && var4 instanceof ViewGroup) {
            ((ViewGroup)var4).removeView(this.zzpD.getView());
         }

         if(this.zzEo) {
            this.zzpD.setBackgroundColor(zzEg);
         }

         this.zzDm.addView(this.zzpD.getView(), -1, -1);
         if(!var1 && !this.zzEp) {
            this.zzfr();
         }

         this.zzw(var3);
         if(this.zzpD.zzhV()) {
            this.zza(var3, true);
         }

         com.google.android.gms.ads.internal.zzd var5 = this.zzpD.zzhR();
         zzm var6;
         if(var5 != null) {
            var6 = var5.zzpy;
         } else {
            var6 = null;
         }

         if(var6 != null) {
            this.zzEr = var6.zza(this.mActivity, this.zzpD, this.zzDm);
         } else {
            zzin.zzaK("Appstreaming controller is null.");
         }
      }
   }

   protected void zzy(int var1) {
      this.zzpD.zzy(var1);
   }

   @zzhb
   private static final class zza extends Exception {
      public zza(String var1) {
         super(var1);
      }
   }

   @zzhb
   static final class zzb extends RelativeLayout {
      zziu zzrU;

      public zzb(Context var1, String var2) {
         super(var1);
         this.zzrU = new zziu(var1, var2);
      }

      public boolean onInterceptTouchEvent(MotionEvent var1) {
         this.zzrU.zze(var1);
         return false;
      }
   }

   @zzhb
   public static class zzc {
      public final Context context;
      public final int index;
      public final android.view.ViewGroup.LayoutParams zzEw;
      public final ViewGroup zzEx;

      public zzc(zzjp var1) throws zzd.zza {
         this.zzEw = var1.getLayoutParams();
         ViewParent var2 = var1.getParent();
         this.context = var1.zzhQ();
         if(var2 != null && var2 instanceof ViewGroup) {
            this.zzEx = (ViewGroup)var2;
            this.index = this.zzEx.indexOfChild(var1.getView());
            this.zzEx.removeView(var1.getView());
            var1.zzD(true);
         } else {
            throw new zzd.zza("Could not get the parent of the WebView for an overlay.");
         }
      }
   }

   @zzhb
   private class zzd extends zzim {
      private zzd() {
      }

      // $FF: synthetic method
      zzd(Object var2) {
         this();
      }

      public void zzbr() {
         Bitmap var1 = zzr.zzbC().zzf(zzd.this.mActivity, zzd.this.zzEh.zzEM.zzqn);
         if(var1 != null) {
            final Drawable var2 = zzr.zzbE().zza(zzd.this.mActivity, var1, zzd.this.zzEh.zzEM.zzqo, zzd.this.zzEh.zzEM.zzqp);
            zzir.zzMc.post(new Runnable() {
               public void run() {
                  zzd.this.mActivity.getWindow().setBackgroundDrawable(var2);
               }
            });
         }

      }
   }
}
