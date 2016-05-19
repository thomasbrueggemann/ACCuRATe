package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzz;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class zzg extends zzz {
   private long zzaVK;
   private String zzaVL;

   zzg(zzw var1) {
      super(var1);
   }

   public String zzCA() {
      this.zzjv();
      return this.zzaVL;
   }

   public String zzCy() {
      this.zzjv();
      return VERSION.RELEASE;
   }

   public long zzCz() {
      this.zzjv();
      return this.zzaVK;
   }

   public String zzht() {
      this.zzjv();
      return Build.MODEL;
   }

   protected void zziJ() {
      Calendar var1 = Calendar.getInstance();
      this.zzaVK = TimeUnit.MINUTES.convert((long)(var1.get(15) + var1.get(16)), TimeUnit.MILLISECONDS);
      Locale var2 = Locale.getDefault();
      this.zzaVL = var2.getLanguage().toLowerCase(Locale.ENGLISH) + "-" + var2.getCountry().toLowerCase(Locale.ENGLISH);
   }
}
