package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.internal.zzaj;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zzf;

public class zzai extends zzd {
   private SharedPreferences zzTh;
   private long zzTi;
   private long zzTj = -1L;
   private final zzai.zza zzTk = new zzai.zza("monitoring", this.zzjn().zzkX());

   protected zzai(zzf var1) {
      super(var1);
   }

   public void zzbp(String var1) {
      this.zzjk();
      this.zzjv();
      Editor var2 = this.zzTh.edit();
      if(TextUtils.isEmpty(var1)) {
         var2.remove("installation_campaign");
      } else {
         var2.putString("installation_campaign", var1);
      }

      if(!var2.commit()) {
         this.zzbg("Failed to commit campaign data");
      }

   }

   protected void zziJ() {
      this.zzTh = this.getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
   }

   public long zzlF() {
      this.zzjk();
      this.zzjv();
      if(this.zzTi == 0L) {
         long var1 = this.zzTh.getLong("first_run", 0L);
         if(var1 != 0L) {
            this.zzTi = var1;
         } else {
            long var3 = this.zzjl().currentTimeMillis();
            Editor var5 = this.zzTh.edit();
            var5.putLong("first_run", var3);
            if(!var5.commit()) {
               this.zzbg("Failed to commit first run time");
            }

            this.zzTi = var3;
         }
      }

      return this.zzTi;
   }

   public zzaj zzlG() {
      return new zzaj(this.zzjl(), this.zzlF());
   }

   public long zzlH() {
      this.zzjk();
      this.zzjv();
      if(this.zzTj == -1L) {
         this.zzTj = this.zzTh.getLong("last_dispatch", 0L);
      }

      return this.zzTj;
   }

   public void zzlI() {
      this.zzjk();
      this.zzjv();
      long var1 = this.zzjl().currentTimeMillis();
      Editor var3 = this.zzTh.edit();
      var3.putLong("last_dispatch", var1);
      var3.apply();
      this.zzTj = var1;
   }

   public String zzlJ() {
      this.zzjk();
      this.zzjv();
      String var1 = this.zzTh.getString("installation_campaign", (String)null);
      return TextUtils.isEmpty(var1)?null:var1;
   }

   public zzai.zza zzlK() {
      return this.zzTk;
   }

   public final class zza {
      private final String mName;
      private final long zzTl;

      private zza(String var2, long var3) {
         com.google.android.gms.common.internal.zzx.zzcM(var2);
         boolean var6;
         if(var3 > 0L) {
            var6 = true;
         } else {
            var6 = false;
         }

         com.google.android.gms.common.internal.zzx.zzac(var6);
         this.mName = var2;
         this.zzTl = var3;
      }

      // $FF: synthetic method
      zza(String var2, long var3, Object var5) {
         this();
      }

      private void zzlL() {
         long var1 = zzai.this.zzjl().currentTimeMillis();
         Editor var3 = zzai.this.zzTh.edit();
         var3.remove(this.zzlQ());
         var3.remove(this.zzlR());
         var3.putLong(this.zzlP(), var1);
         var3.commit();
      }

      private long zzlM() {
         long var1 = this.zzlO();
         return var1 == 0L?0L:Math.abs(var1 - zzai.this.zzjl().currentTimeMillis());
      }

      private long zzlO() {
         return zzai.this.zzTh.getLong(this.zzlP(), 0L);
      }

      private String zzlP() {
         return this.mName + ":start";
      }

      private String zzlQ() {
         return this.mName + ":count";
      }

      public void zzbq(String param1) {
         // $FF: Couldn't be decompiled
      }

      public Pair<String, Long> zzlN() {
         long var1 = this.zzlM();
         if(var1 >= this.zzTl) {
            if(var1 > 2L * this.zzTl) {
               this.zzlL();
               return null;
            }

            String var3 = zzai.this.zzTh.getString(this.zzlR(), (String)null);
            long var4 = zzai.this.zzTh.getLong(this.zzlQ(), 0L);
            this.zzlL();
            if(var3 != null && var4 > 0L) {
               return new Pair(var3, Long.valueOf(var4));
            }
         }

         return null;
      }

      protected String zzlR() {
         return this.mName + ":value";
      }
   }
}
