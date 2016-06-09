package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzjw;
import com.google.android.gms.internal.zzjx;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;

@zzhb
@TargetApi(8)
public class zzis {
   private zzis() {
   }

   // $FF: synthetic method
   zzis(Object var1) {
      this();
   }

   public static zzis zzP(int var0) {
      return (zzis)(var0 >= 19?new zzis.zzg():(var0 >= 18?new zzis.zze():(var0 >= 17?new zzis.zzd():(var0 >= 16?new zzis.zzf():(var0 >= 14?new zzis.zzc():(var0 >= 11?new zzis.zzb():(var0 >= 9?new zzis.zza():new zzis())))))));
   }

   public String getDefaultUserAgent(Context var1) {
      return "";
   }

   public Drawable zza(Context var1, Bitmap var2, boolean var3, float var4) {
      return new BitmapDrawable(var1.getResources(), var2);
   }

   public String zza(SslError var1) {
      return "";
   }

   public void zza(ViewTreeObserver var1, OnGlobalLayoutListener var2) {
      var1.removeGlobalOnLayoutListener(var2);
   }

   public boolean zza(Request var1) {
      return false;
   }

   public boolean zza(Context var1, WebSettings var2) {
      return false;
   }

   public boolean zza(Window var1) {
      return false;
   }

   public zzjq zzb(zzjp var1, boolean var2) {
      return new zzjq(var1, var2);
   }

   public void zzb(Activity var1, OnGlobalLayoutListener var2) {
      Window var3 = var1.getWindow();
      if(var3 != null && var3.getDecorView() != null && var3.getDecorView().getViewTreeObserver() != null) {
         this.zza(var3.getDecorView().getViewTreeObserver(), var2);
      }

   }

   public Set<String> zzf(Uri var1) {
      if(var1.isOpaque()) {
         return Collections.emptySet();
      } else {
         String var2 = var1.getEncodedQuery();
         if(var2 == null) {
            return Collections.emptySet();
         } else {
            LinkedHashSet var3 = new LinkedHashSet();
            int var4 = 0;

            do {
               int var5 = var2.indexOf(38, var4);
               if(var5 == -1) {
                  var5 = var2.length();
               }

               int var6 = var2.indexOf(61, var4);
               if(var6 > var5 || var6 == -1) {
                  var6 = var5;
               }

               var3.add(Uri.decode(var2.substring(var4, var6)));
               var4 = var5 + 1;
            } while(var4 < var2.length());

            return Collections.unmodifiableSet(var3);
         }
      }
   }

   public int zzhv() {
      return 0;
   }

   public int zzhw() {
      return 1;
   }

   public int zzhx() {
      return 5;
   }

   public boolean zzi(zzjp var1) {
      if(var1 == null) {
         return false;
      } else {
         var1.onPause();
         return true;
      }
   }

   public boolean zzj(zzjp var1) {
      if(var1 == null) {
         return false;
      } else {
         var1.onResume();
         return true;
      }
   }

   public WebChromeClient zzk(zzjp var1) {
      return null;
   }

   public boolean zzm(View var1) {
      return false;
   }

   public boolean zzn(View var1) {
      return false;
   }

   @TargetApi(9)
   public static class zza extends zzis {
      public zza() {
         super(null);
      }

      public boolean zza(Request var1) {
         var1.setShowRunningNotification(true);
         return true;
      }

      public int zzhv() {
         return 6;
      }

      public int zzhw() {
         return 7;
      }
   }

   @TargetApi(11)
   public static class zzb extends zzis.zza {
      public boolean zza(Request var1) {
         var1.allowScanningByMediaScanner();
         var1.setNotificationVisibility(1);
         return true;
      }

      public boolean zza(final Context var1, WebSettings var2) {
         super.zza(var1, var2);
         if((File)zzjb.zzb(new Callable() {
            // $FF: synthetic method
            public Object call() throws Exception {
               return this.zzhz();
            }

            public File zzhz() {
               return var1.getCacheDir();
            }
         }) != null) {
            var2.setAppCachePath(var1.getCacheDir().getAbsolutePath());
            var2.setAppCacheMaxSize(0L);
            var2.setAppCacheEnabled(true);
         }

         var2.setDatabasePath(var1.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
         var2.setDatabaseEnabled(true);
         var2.setDomStorageEnabled(true);
         var2.setDisplayZoomControls(false);
         var2.setBuiltInZoomControls(true);
         var2.setSupportZoom(true);
         var2.setAllowContentAccess(false);
         return true;
      }

      public boolean zza(Window var1) {
         var1.setFlags(16777216, 16777216);
         return true;
      }

      public zzjq zzb(zzjp var1, boolean var2) {
         return new zzjw(var1, var2);
      }

      public Set<String> zzf(Uri var1) {
         return var1.getQueryParameterNames();
      }

      public WebChromeClient zzk(zzjp var1) {
         return new zzjv(var1);
      }

      public boolean zzm(View var1) {
         var1.setLayerType(0, (Paint)null);
         return true;
      }

      public boolean zzn(View var1) {
         var1.setLayerType(1, (Paint)null);
         return true;
      }
   }

   @TargetApi(14)
   public static class zzc extends zzis.zzb {
      public String zza(SslError var1) {
         return var1.getUrl();
      }

      public WebChromeClient zzk(zzjp var1) {
         return new zzjx(var1);
      }
   }

   @TargetApi(17)
   public static class zzd extends zzis.zzf {
      public String getDefaultUserAgent(Context var1) {
         return WebSettings.getDefaultUserAgent(var1);
      }

      public Drawable zza(Context var1, Bitmap var2, boolean var3, float var4) {
         if(var3 && var4 > 0.0F && var4 <= 25.0F) {
            try {
               Bitmap var6 = Bitmap.createScaledBitmap(var2, var2.getWidth(), var2.getHeight(), false);
               Bitmap var7 = Bitmap.createBitmap(var6);
               RenderScript var8 = RenderScript.create(var1);
               ScriptIntrinsicBlur var9 = ScriptIntrinsicBlur.create(var8, Element.U8_4(var8));
               Allocation var10 = Allocation.createFromBitmap(var8, var6);
               Allocation var11 = Allocation.createFromBitmap(var8, var7);
               var9.setRadius(var4);
               var9.setInput(var10);
               var9.forEach(var11);
               var11.copyTo(var7);
               BitmapDrawable var12 = new BitmapDrawable(var1.getResources(), var7);
               return var12;
            } catch (RuntimeException var13) {
               return new BitmapDrawable(var1.getResources(), var2);
            }
         } else {
            return new BitmapDrawable(var1.getResources(), var2);
         }
      }

      public boolean zza(Context var1, WebSettings var2) {
         super.zza(var1, var2);
         var2.setMediaPlaybackRequiresUserGesture(false);
         return true;
      }
   }

   @TargetApi(18)
   public static class zze extends zzis.zzd {
      public int zzhx() {
         return 14;
      }
   }

   @TargetApi(16)
   public static class zzf extends zzis.zzc {
      public void zza(ViewTreeObserver var1, OnGlobalLayoutListener var2) {
         var1.removeOnGlobalLayoutListener(var2);
      }

      public boolean zza(Context var1, WebSettings var2) {
         super.zza(var1, var2);
         var2.setAllowFileAccessFromFileURLs(false);
         var2.setAllowUniversalAccessFromFileURLs(false);
         return true;
      }

      public void zzb(Activity var1, OnGlobalLayoutListener var2) {
         Window var3 = var1.getWindow();
         if(var3 != null && var3.getDecorView() != null && var3.getDecorView().getViewTreeObserver() != null) {
            this.zza(var3.getDecorView().getViewTreeObserver(), var2);
         }

      }
   }

   @TargetApi(19)
   public static class zzg extends zzis.zze {
   }
}
