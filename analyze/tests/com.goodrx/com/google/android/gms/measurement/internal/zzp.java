package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzt;
import com.google.android.gms.measurement.internal.zzv;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzz;

public class zzp extends zzz {
   private final long zzaVj = this.zzCp().zzBp();
   private final char zzaWB;
   private final zzp.zza zzaWC;
   private final zzp.zza zzaWD;
   private final zzp.zza zzaWE;
   private final zzp.zza zzaWF;
   private final zzp.zza zzaWG;
   private final zzp.zza zzaWH;
   private final zzp.zza zzaWI;
   private final zzp.zza zzaWJ;
   private final zzp.zza zzaWK;
   private final String zzamn = this.zzCp().zzBz();

   zzp(zzw var1) {
      super(var1);
      if(this.zzCp().zzks()) {
         byte var3;
         if(this.zzCp().zzkr()) {
            var3 = 80;
         } else {
            var3 = 67;
         }

         this.zzaWB = (char)var3;
      } else {
         byte var2;
         if(this.zzCp().zzkr()) {
            var2 = 112;
         } else {
            var2 = 99;
         }

         this.zzaWB = (char)var2;
      }

      this.zzaWC = new zzp.zza(6, false, false);
      this.zzaWD = new zzp.zza(6, true, false);
      this.zzaWE = new zzp.zza(6, false, true);
      this.zzaWF = new zzp.zza(5, false, false);
      this.zzaWG = new zzp.zza(5, true, false);
      this.zzaWH = new zzp.zza(5, false, true);
      this.zzaWI = new zzp.zza(4, false, false);
      this.zzaWJ = new zzp.zza(3, false, false);
      this.zzaWK = new zzp.zza(2, false, false);
   }

   static String zza(boolean var0, String var1, Object var2, Object var3, Object var4) {
      if(var1 == null) {
         var1 = "";
      }

      String var5 = zzc(var0, var2);
      String var6 = zzc(var0, var3);
      String var7 = zzc(var0, var4);
      StringBuilder var8 = new StringBuilder();
      String var9 = "";
      if(!TextUtils.isEmpty(var1)) {
         var8.append(var1);
         var9 = ": ";
      }

      if(!TextUtils.isEmpty(var5)) {
         var8.append(var9);
         var8.append(var5);
         var9 = ", ";
      }

      if(!TextUtils.isEmpty(var6)) {
         var8.append(var9);
         var8.append(var6);
         var9 = ", ";
      }

      if(!TextUtils.isEmpty(var7)) {
         var8.append(var9);
         var8.append(var7);
      }

      return var8.toString();
   }

   static String zzc(boolean var0, Object var1) {
      if(var1 == null) {
         return "";
      } else {
         Object var2;
         if(var1 instanceof Integer) {
            var2 = Long.valueOf((long)((Integer)var1).intValue());
         } else {
            var2 = var1;
         }

         if(var2 instanceof Long) {
            if(!var0) {
               return String.valueOf(var2);
            } else if(Math.abs(((Long)var2).longValue()) < 100L) {
               return String.valueOf(var2);
            } else {
               String var15;
               if(String.valueOf(var2).charAt(0) == 45) {
                  var15 = "-";
               } else {
                  var15 = "";
               }

               String var16 = String.valueOf(Math.abs(((Long)var2).longValue()));
               return var15 + Math.round(Math.pow(10.0D, (double)(-1 + var16.length()))) + "..." + var15 + Math.round(Math.pow(10.0D, (double)var16.length()) - 1.0D);
            }
         } else if(var2 instanceof Boolean) {
            return String.valueOf(var2);
         } else if(!(var2 instanceof Throwable)) {
            return var0?"-":String.valueOf(var2);
         } else {
            Throwable var3 = (Throwable)var2;
            StringBuilder var4 = new StringBuilder(var3.toString());
            String var5 = zzff(AppMeasurement.class.getCanonicalName());
            String var6 = zzff(zzw.class.getCanonicalName());
            StackTraceElement[] var7 = var3.getStackTrace();
            int var8 = var7.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               StackTraceElement var10 = var7[var9];
               if(!var10.isNativeMethod()) {
                  String var11 = var10.getClassName();
                  if(var11 != null) {
                     String var12 = zzff(var11);
                     if(var12.equals(var5) || var12.equals(var6)) {
                        var4.append(": ");
                        var4.append(var10);
                        break;
                     }
                  }
               }
            }

            return var4.toString();
         }
      }
   }

   private static String zzff(String var0) {
      if(TextUtils.isEmpty(var0)) {
         var0 = "";
      } else {
         int var1 = var0.lastIndexOf(46);
         if(var1 != -1) {
            return var0.substring(0, var1);
         }
      }

      return var0;
   }

   public zzp.zza zzCE() {
      return this.zzaWC;
   }

   public zzp.zza zzCF() {
      return this.zzaWF;
   }

   public zzp.zza zzCG() {
      return this.zzaWG;
   }

   public zzp.zza zzCH() {
      return this.zzaWH;
   }

   public zzp.zza zzCI() {
      return this.zzaWI;
   }

   public zzp.zza zzCJ() {
      return this.zzaWJ;
   }

   public zzp.zza zzCK() {
      return this.zzaWK;
   }

   public String zzCL() {
      Pair var1 = this.zzCo().zzaXi.zzlN();
      return var1 == null?null:var1.second + ":" + (String)var1.first;
   }

   protected boolean zzQ(int var1) {
      return Log.isLoggable(this.zzamn, var1);
   }

   protected void zza(int var1, boolean var2, boolean var3, String var4, Object var5, Object var6, Object var7) {
      if(!var2 && this.zzQ(var1)) {
         this.zzl(var1, zza(false, var4, var5, var6, var7));
      }

      if(!var3 && var1 >= 5) {
         this.zzb(var1, var4, var5, var6, var7);
      }

   }

   public void zzb(int var1, String var2, Object var3, Object var4, Object var5) {
      com.google.android.gms.common.internal.zzx.zzz(var2);
      zzv var7 = this.zzaTV.zzCU();
      if(var7 == null) {
         this.zzl(6, "Scheduler not set. Not logging error/warn.");
      } else if(!var7.isInitialized()) {
         this.zzl(6, "Scheduler not initialized. Not logging error/warn.");
      } else if(var7.zzDi()) {
         this.zzl(6, "Scheduler shutdown. Not logging error/warn.");
      } else {
         if(var1 < 0) {
            var1 = 0;
         }

         if(var1 >= "01VDIWEA?".length()) {
            var1 = -1 + "01VDIWEA?".length();
         }

         String var8 = "1" + "01VDIWEA?".charAt(var1) + this.zzaWB + this.zzaVj + ":" + zza(true, var2, var3, var4, var5);
         final String var9;
         if(var8.length() > 1024) {
            var9 = var2.substring(0, 1024);
         } else {
            var9 = var8;
         }

         var7.zzg(new Runnable() {
            public void run() {
               zzt var1 = zzp.this.zzaTV.zzCo();
               if(var1.isInitialized() && !var1.zzDi()) {
                  var1.zzaXi.zzbq(var9);
               } else {
                  zzp.this.zzl(6, "Persisted config not initialized . Not logging error/warn.");
               }
            }
         });
      }
   }

   protected void zziJ() {
   }

   protected void zzl(int var1, String var2) {
      Log.println(var1, this.zzamn, var2);
   }

   public class zza {
      private final int mPriority;
      private final boolean zzaWN;
      private final boolean zzaWO;

      zza(int var2, boolean var3, boolean var4) {
         this.mPriority = var2;
         this.zzaWN = var3;
         this.zzaWO = var4;
      }

      public void zzd(String var1, Object var2, Object var3, Object var4) {
         zzp.this.zza(this.mPriority, this.zzaWN, this.zzaWO, var1, var2, var3, var4);
      }

      public void zze(String var1, Object var2, Object var3) {
         zzp.this.zza(this.mPriority, this.zzaWN, this.zzaWO, var1, var2, var3, (Object)null);
      }

      public void zzfg(String var1) {
         zzp.this.zza(this.mPriority, this.zzaWN, this.zzaWO, var1, (Object)null, (Object)null, (Object)null);
      }

      public void zzj(String var1, Object var2) {
         zzp.this.zza(this.mPriority, this.zzaWN, this.zzaWO, var1, var2, (Object)null, (Object)null);
      }
   }
}
