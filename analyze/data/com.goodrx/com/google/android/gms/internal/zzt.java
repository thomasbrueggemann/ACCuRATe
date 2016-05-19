package com.google.android.gms.internal;

import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzf;
import com.google.android.gms.internal.zzi;
import com.google.android.gms.internal.zzk;
import com.google.android.gms.internal.zzo;
import com.google.android.gms.internal.zzp;
import com.google.android.gms.internal.zzr;
import com.google.android.gms.internal.zzs;
import com.google.android.gms.internal.zzu;
import com.google.android.gms.internal.zzy;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class zzt implements zzf {
   protected static final boolean DEBUG;
   private static int zzao;
   private static int zzap;
   protected final zzy zzaq;
   protected final zzu zzar;

   static {
      DEBUG = zzs.DEBUG;
      zzao = 3000;
      zzap = 4096;
   }

   public zzt(zzy var1) {
      this(var1, new zzu(zzap));
   }

   public zzt(zzy var1, zzu var2) {
      this.zzaq = var1;
      this.zzar = var2;
   }

   protected static Map<String, String> zza(Header[] var0) {
      TreeMap var1 = new TreeMap(String.CASE_INSENSITIVE_ORDER);

      for(int var2 = 0; var2 < var0.length; ++var2) {
         var1.put(var0[var2].getName(), var0[var2].getValue());
      }

      return var1;
   }

   private void zza(long var1, zzk<?> var3, byte[] var4, StatusLine var5) {
      if(DEBUG || var1 > (long)zzao) {
         Object[] var6 = new Object[]{var3, Long.valueOf(var1), null, null, null};
         Object var7;
         if(var4 != null) {
            var7 = Integer.valueOf(var4.length);
         } else {
            var7 = "null";
         }

         var6[2] = var7;
         var6[3] = Integer.valueOf(var5.getStatusCode());
         var6[4] = Integer.valueOf(var3.zzu().zze());
         zzs.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", var6);
      }

   }

   private static void zza(String var0, zzk<?> var1, zzr var2) throws zzr {
      zzo var3 = var1.zzu();
      int var4 = var1.zzt();

      try {
         var3.zza(var2);
      } catch (zzr var8) {
         Object[] var6 = new Object[]{var0, Integer.valueOf(var4)};
         var1.zzc(String.format("%s-timeout-giveup [timeout=%s]", var6));
         throw var8;
      }

      Object[] var7 = new Object[]{var0, Integer.valueOf(var4)};
      var1.zzc(String.format("%s-retry [timeout=%s]", var7));
   }

   private void zza(Map<String, String> var1, zzb.zza var2) {
      if(var2 != null) {
         if(var2.zzb != null) {
            var1.put("If-None-Match", var2.zzb);
         }

         if(var2.zzd > 0L) {
            var1.put("If-Modified-Since", DateUtils.formatDate(new Date(var2.zzd)));
            return;
         }
      }

   }

   private byte[] zza(HttpEntity param1) throws IOException, zzp {
      // $FF: Couldn't be decompiled
   }

   public zzi zza(zzk<?> param1) throws zzr {
      // $FF: Couldn't be decompiled
   }
}
