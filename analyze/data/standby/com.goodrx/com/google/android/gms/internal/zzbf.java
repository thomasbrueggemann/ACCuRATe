package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.internal.zzbc;
import com.google.android.gms.internal.zzbd;
import com.google.android.gms.internal.zzbe;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzne;

@zzhb
@TargetApi(14)
public class zzbf extends Thread {
   private boolean zzam;
   private final Object zzpV;
   private final int zzsK;
   private final int zzsM;
   private boolean zzsY;
   private final zzbe zzsZ;
   private final zzbd zzta;
   private final zzha zztb;
   private final int zztc;
   private final int zztd;
   private final int zzte;

   public void run() {
      // $FF: Couldn't be decompiled
   }

   zzbf.zza zza(View var1, zzbc var2) {
      int var3 = 0;
      if(var1 == null) {
         return new zzbf.zza(0, 0);
      } else {
         boolean var4 = var1.getGlobalVisibleRect(new Rect());
         if(var1 instanceof TextView && !(var1 instanceof EditText)) {
            CharSequence var9 = ((TextView)var1).getText();
            if(!TextUtils.isEmpty(var9)) {
               var2.zzd(var9.toString(), var4);
               return new zzbf.zza(1, 0);
            } else {
               return new zzbf.zza(0, 0);
            }
         } else if(var1 instanceof WebView && !(var1 instanceof zzjp)) {
            var2.zzcC();
            return this.zza((WebView)var1, var2, var4)?new zzbf.zza(0, 1):new zzbf.zza(0, 0);
         } else if(!(var1 instanceof ViewGroup)) {
            return new zzbf.zza(0, 0);
         } else {
            ViewGroup var5 = (ViewGroup)var1;
            int var6 = 0;

            int var7;
            for(var7 = 0; var3 < var5.getChildCount(); ++var3) {
               zzbf.zza var8 = this.zza(var5.getChildAt(var3), var2);
               var7 += var8.zztm;
               var6 += var8.zztn;
            }

            return new zzbf.zza(var7, var6);
         }
      }
   }

   void zza(Activity var1) {
      if(var1 != null) {
         Window var2 = var1.getWindow();
         View var3 = null;
         if(var2 != null) {
            View var5 = var1.getWindow().getDecorView();
            var3 = null;
            if(var5 != null) {
               var3 = var1.getWindow().getDecorView().findViewById(16908290);
            }
         }

         if(var3 != null) {
            this.zze(var3);
            return;
         }
      }

   }

   void zza(zzbc param1, WebView param2, String param3, boolean param4) {
      // $FF: Couldn't be decompiled
   }

   boolean zza(RunningAppProcessInfo var1) {
      return var1.importance == 100;
   }

   @TargetApi(19)
   boolean zza(final WebView var1, final zzbc var2, final boolean var3) {
      if(!zzne.zzsk()) {
         return false;
      } else {
         var2.zzcC();
         var1.post(new Runnable() {
            ValueCallback<String> zzth = new ValueCallback() {
               // $FF: synthetic method
               public void onReceiveValue(Object var1x) {
                  this.zzt((String)var1x);
               }

               public void zzt(String var1x) {
                  zzbf.this.zza(var2, var1, var1x, var3);
               }
            };

            public void run() {
               if(var1.getSettings().getJavaScriptEnabled()) {
                  try {
                     var1.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzth);
                  } catch (Throwable var2x) {
                     this.zzth.onReceiveValue("");
                     return;
                  }
               }

            }
         });
         return true;
      }
   }

   boolean zzcH() {
      // $FF: Couldn't be decompiled
   }

   public void zzcJ() {
      // $FF: Couldn't be decompiled
   }

   boolean zze(final View var1) {
      if(var1 == null) {
         return false;
      } else {
         var1.post(new Runnable() {
            public void run() {
               zzbf.this.zzf(var1);
            }
         });
         return true;
      }
   }

   void zzf(View var1) {
      try {
         zzbc var2 = new zzbc(this.zzsK, this.zztd, this.zzsM, this.zzte);
         zzbf.zza var4 = this.zza(var1, var2);
         var2.zzcD();
         if(var4.zztm == 0 && var4.zztn == 0) {
            return;
         }

         if((var4.zztn != 0 || var2.zzcE() != 0) && (var4.zztn != 0 || !this.zzta.zza(var2))) {
            this.zzta.zzc(var2);
            return;
         }
      } catch (Exception var5) {
         zzin.zzb("Exception in fetchContentOnUIThread", var5);
         this.zztb.zza(var5, true);
      }

   }

   boolean zzs(Context var1) {
      PowerManager var2 = (PowerManager)var1.getSystemService("power");
      return var2 == null?false:var2.isScreenOn();
   }

   @zzhb
   class zza {
      final int zztm;
      final int zztn;

      zza(int var2, int var3) {
         this.zztm = var2;
         this.zztn = var3;
      }
   }
}
