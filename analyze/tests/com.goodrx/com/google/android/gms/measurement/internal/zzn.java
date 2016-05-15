package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzz;
import javax.security.auth.x500.X500Principal;

public class zzn extends zzz {
   private static final X500Principal zzaWz = new X500Principal("CN=Android Debug,O=Android,C=US");
   private String zzSE;
   private String zzSF;
   private String zzaUa;
   private String zzaVd;
   private String zzaVi;
   private long zzaWA;

   zzn(zzw var1) {
      super(var1);
   }

   String zzBk() {
      this.zzjv();
      return this.zzaVd;
   }

   String zzBo() {
      this.zzjv();
      return this.zzaVi;
   }

   long zzBp() {
      return this.zzCp().zzBp();
   }

   long zzBq() {
      this.zzjv();
      return this.zzaWA;
   }

   boolean zzCD() {
      // $FF: Couldn't be decompiled
   }

   protected void zzba(Status var1) {
      if(var1 == null) {
         this.zzAo().zzCE().zzfg("GoogleService failed to initialize (no status)");
      } else {
         this.zzAo().zzCE().zze("GoogleService failed to initialize, status", Integer.valueOf(var1.getStatusCode()), var1.getStatusMessage());
      }
   }

   AppMetadata zzfe(String var1) {
      String var2 = this.zzwK();
      String var3 = this.zzBk();
      String var4 = this.zzli();
      String var5 = this.zzBo();
      long var6 = this.zzBp();
      long var8 = this.zzBq();
      boolean var10 = this.zzCo().zzAr();
      boolean var11;
      if(!this.zzCo().zzaXx) {
         var11 = true;
      } else {
         var11 = false;
      }

      return new AppMetadata(var2, var3, var4, var5, var6, var8, var1, var10, var11);
   }

   protected void zziJ() {
      // $FF: Couldn't be decompiled
   }

   String zzli() {
      this.zzjv();
      return this.zzSF;
   }

   String zzwK() {
      this.zzjv();
      return this.zzaUa;
   }
}
