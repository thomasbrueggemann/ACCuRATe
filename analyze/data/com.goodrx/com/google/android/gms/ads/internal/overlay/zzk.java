package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.overlay.zzi;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;
import java.util.HashMap;

@zzhb
public class zzk extends FrameLayout implements zzh {
   private final FrameLayout zzEN;
   private final zzu zzEO;
   @Nullable
   private zzi zzEP;
   private boolean zzEQ;
   private boolean zzER;
   private TextView zzES;
   private long zzET;
   private String zzEV;
   private final zzjp zzpD;
   private String zzzK;

   public zzk(Context var1, zzjp var2, int var3, zzcb var4, zzbz var5) {
      super(var1);
      this.zzpD = var2;
      this.zzEN = new FrameLayout(var1);
      this.addView(this.zzEN, new LayoutParams(-1, -1));
      com.google.android.gms.common.internal.zzb.zzv(var2.zzhR());
      this.zzEP = var2.zzhR().zzpx.zza(var1, var2, var3, var4, var5);
      if(this.zzEP != null) {
         this.zzEN.addView(this.zzEP, new LayoutParams(-1, -1, 17));
      }

      this.zzES = new TextView(var1);
      this.zzES.setBackgroundColor(-16777216);
      this.zzfG();
      this.zzEO = new zzu(this);
      this.zzEO.zzfQ();
      if(this.zzEP != null) {
         this.zzEP.zza(this);
      }

      if(this.zzEP == null) {
         this.zzg("AdVideoUnderlay Error", "Allocating player failed.");
      }

   }

   private void zza(String var1, String... var2) {
      HashMap var3 = new HashMap();
      var3.put("event", var1);
      int var5 = var2.length;
      int var6 = 0;

      String var8;
      for(String var7 = null; var6 < var5; var7 = var8) {
         var8 = var2[var6];
         if(var7 != null) {
            var3.put(var7, var8);
            var8 = null;
         }

         ++var6;
      }

      this.zzpD.zza("onVideoEvent", var3);
   }

   private void zzfG() {
      if(!this.zzfI()) {
         this.zzEN.addView(this.zzES, new LayoutParams(-1, -1));
         this.zzEN.bringChildToFront(this.zzES);
      }

   }

   private void zzfH() {
      if(this.zzfI()) {
         this.zzEN.removeView(this.zzES);
      }

   }

   private boolean zzfI() {
      return this.zzES.getParent() != null;
   }

   private void zzfK() {
      if(this.zzpD.zzhP() != null && this.zzEQ && !this.zzER) {
         this.zzpD.zzhP().getWindow().clearFlags(128);
         this.zzEQ = false;
      }
   }

   public static void zzg(zzjp var0) {
      HashMap var1 = new HashMap();
      var1.put("event", "no_video_view");
      var0.zza("onVideoEvent", var1);
   }

   public void destroy() {
      this.zzEO.cancel();
      if(this.zzEP != null) {
         this.zzEP.stop();
      }

      this.zzfK();
   }

   public void pause() {
      if(this.zzEP != null) {
         this.zzEP.pause();
      }
   }

   public void play() {
      if(this.zzEP != null) {
         this.zzEP.play();
      }
   }

   public void seekTo(int var1) {
      if(this.zzEP != null) {
         this.zzEP.seekTo(var1);
      }
   }

   public void setMimeType(String var1) {
      this.zzEV = var1;
   }

   public void zza(float var1) {
      if(this.zzEP != null) {
         this.zzEP.zza(var1);
      }
   }

   public void zzap(String var1) {
      this.zzzK = var1;
   }

   public void zzd(int var1, int var2, int var3, int var4) {
      if(var3 != 0 && var4 != 0) {
         LayoutParams var5 = new LayoutParams(var3 + 2, var4 + 2);
         var5.setMargins(var1 - 1, var2 - 1, 0, 0);
         this.zzEN.setLayoutParams(var5);
         this.requestLayout();
      }
   }

   public void zzd(MotionEvent var1) {
      if(this.zzEP != null) {
         this.zzEP.dispatchTouchEvent(var1);
      }
   }

   public void zzfD() {
      if(this.zzEP != null) {
         if(!TextUtils.isEmpty(this.zzzK)) {
            this.zzEP.setMimeType(this.zzEV);
            this.zzEP.setVideoPath(this.zzzK);
         } else {
            this.zza("no_src", new String[0]);
         }
      }
   }

   public void zzfE() {
      if(this.zzEP != null) {
         TextView var1 = new TextView(this.zzEP.getContext());
         var1.setText("AdMob - " + this.zzEP.zzeZ());
         var1.setTextColor(-65536);
         var1.setBackgroundColor(-256);
         this.zzEN.addView(var1, new LayoutParams(-2, -2, 17));
         this.zzEN.bringChildToFront(var1);
      }
   }

   void zzfF() {
      if(this.zzEP != null) {
         long var1 = (long)this.zzEP.getCurrentPosition();
         if(this.zzET != var1 && var1 > 0L) {
            this.zzfH();
            float var3 = (float)var1 / 1000.0F;
            String[] var4 = new String[]{"time", String.valueOf(var3)};
            this.zza("timeupdate", var4);
            this.zzET = var1;
            return;
         }
      }

   }

   public void zzff() {
      if(this.zzEP != null) {
         this.zzEP.zzff();
      }
   }

   public void zzfg() {
      if(this.zzEP != null) {
         this.zzEP.zzfg();
      }
   }

   public void zzg(String var1, String var2) {
      this.zza("error", new String[]{"what", var1, "extra", var2});
   }
}
