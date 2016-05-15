package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.view.TextureView;
import com.google.android.gms.ads.internal.overlay.zzh;

@TargetApi(14)
public abstract class zzi extends TextureView {
   public abstract int getCurrentPosition();

   public abstract int getDuration();

   public abstract int getVideoHeight();

   public abstract int getVideoWidth();

   public abstract void pause();

   public abstract void play();

   public abstract void seekTo(int var1);

   public abstract void setMimeType(String var1);

   public abstract void setVideoPath(String var1);

   public abstract void stop();

   public abstract void zza(float var1);

   public abstract void zza(zzh var1);

   public abstract String zzeZ();

   public abstract void zzff();

   public abstract void zzfg();
}
