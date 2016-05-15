package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import java.util.Map;

@zzhb
public final class zzdd implements zzdf {
   private void zzb(zzjp var1, Map<String, String> var2) {
      String var3 = (String)var2.get("label");
      String var4 = (String)var2.get("start_label");
      String var5 = (String)var2.get("timestamp");
      if(TextUtils.isEmpty(var3)) {
         zzin.zzaK("No label given for CSI tick.");
      } else if(TextUtils.isEmpty(var5)) {
         zzin.zzaK("No timestamp given for CSI tick.");
      } else {
         long var7;
         try {
            var7 = this.zzc(Long.parseLong(var5));
         } catch (NumberFormatException var9) {
            zzin.zzd("Malformed timestamp for CSI tick.", var9);
            return;
         }

         if(TextUtils.isEmpty(var4)) {
            var4 = "native:view_load";
         }

         var1.zzic().zza(var3, var4, var7);
      }
   }

   private long zzc(long var1) {
      long var3 = com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis();
      return com.google.android.gms.ads.internal.zzr.zzbG().elapsedRealtime() + (var1 - var3);
   }

   private void zzc(zzjp var1, Map<String, String> var2) {
      String var3 = (String)var2.get("value");
      if(TextUtils.isEmpty(var3)) {
         zzin.zzaK("No value given for CSI experiment.");
      } else {
         zzcb var4 = var1.zzic().zzdA();
         if(var4 == null) {
            zzin.zzaK("No ticker for WebView, dropping experiment ID.");
         } else {
            var4.zzc("e", var3);
         }
      }
   }

   private void zzd(zzjp var1, Map<String, String> var2) {
      String var3 = (String)var2.get("name");
      String var4 = (String)var2.get("value");
      if(TextUtils.isEmpty(var4)) {
         zzin.zzaK("No value given for CSI extra.");
      } else if(TextUtils.isEmpty(var3)) {
         zzin.zzaK("No name given for CSI extra.");
      } else {
         zzcb var5 = var1.zzic().zzdA();
         if(var5 == null) {
            zzin.zzaK("No ticker for WebView, dropping extra parameter.");
         } else {
            var5.zzc(var3, var4);
         }
      }
   }

   public void zza(zzjp var1, Map<String, String> var2) {
      String var3 = (String)var2.get("action");
      if("tick".equals(var3)) {
         this.zzb(var1, var2);
      } else {
         if("experiment".equals(var3)) {
            this.zzc(var1, var2);
            return;
         }

         if("extra".equals(var3)) {
            this.zzd(var1, var2);
            return;
         }
      }

   }
}
