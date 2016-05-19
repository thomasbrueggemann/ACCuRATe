package com.google.android.gms.measurement;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import com.google.android.gms.measurement.zzc;
import com.google.android.gms.measurement.zze;
import com.google.android.gms.measurement.zzi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class zzb implements zzi {
   private static final Uri zzaUf;
   private final LogPrinter zzaUg = new LogPrinter(4, "GA/LogCatTransport");

   static {
      Builder var0 = new Builder();
      var0.scheme("uri");
      var0.authority("local");
      zzaUf = var0.build();
   }

   public void zzb(zzc var1) {
      ArrayList var2 = new ArrayList(var1.zzAv());
      Collections.sort(var2, new Comparator() {
         // $FF: synthetic method
         public int compare(Object var1, Object var2) {
            return this.zza((zze)var1, (zze)var2);
         }

         public int zza(zze var1, zze var2) {
            return var1.getClass().getCanonicalName().compareTo(var2.getClass().getCanonicalName());
         }
      });
      StringBuilder var3 = new StringBuilder();
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         String var5 = ((zze)var4.next()).toString();
         if(!TextUtils.isEmpty(var5)) {
            if(var3.length() != 0) {
               var3.append(", ");
            }

            var3.append(var5);
         }
      }

      this.zzaUg.println(var3.toString());
   }

   public Uri zziA() {
      return zzaUf;
   }
}
