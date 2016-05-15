package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzab;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjd;
import com.google.android.gms.internal.zzjg;
import com.google.android.gms.internal.zzl;
import com.google.android.gms.internal.zzm;
import com.google.android.gms.internal.zzr;
import java.util.Map;

@zzhb
public class zziw {
   private static zzl zzMy;
   public static final zziw.zza<Void> zzMz = new zziw.zza() {
   };
   private static final Object zzqy = new Object();

   public zziw(Context var1) {
      zzMy = zzS(var1);
   }

   private static zzl zzS(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public zzjg<String> zzb(final String var1, final Map<String, String> var2) {
      final zziw.zzc var3 = new zziw.zzc(null);
      zzab var4 = new zzab(var1, var3, new zzm.zza() {
         public void zze(zzr var1x) {
            zzin.zzaK("Failed to load URL: " + var1 + "\n" + var1x.toString());
            var3.zzb((Object)null);
         }
      }) {
         public Map<String, String> getHeaders() throws zza {
            return var2 == null?super.getHeaders():var2;
         }
      };
      zzMy.zze(var4);
      return var3;
   }

   public interface zza<T> {
   }

   private class zzc<T> extends zzjd<T> implements zzm.zzb<T> {
      private zzc() {
      }

      // $FF: synthetic method
      zzc(Object var2) {
         this();
      }

      public void zzb(T var1) {
         super.zzg(var1);
      }
   }
}
