package com.google.android.gms.tagmanager;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzdf;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class zzdb extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_37;
   private static final String NAME;
   private static final String zzblp;
   private static final String zzblq;
   private static final String zzblr;
   private final Context mContext;
   private Handler mHandler;
   private DataLayer zzbhN;
   private boolean zzbls;
   private boolean zzblt;
   private final HandlerThread zzblu;
   private final Set<String> zzblv;

   static {
      field_37 = com.google.android.gms.internal.zzad.zzdl.toString();
      NAME = com.google.android.gms.internal.zzae.zzgo.toString();
      zzblp = com.google.android.gms.internal.zzae.zzfT.toString();
      zzblq = com.google.android.gms.internal.zzae.zzgb.toString();
      zzblr = com.google.android.gms.internal.zzae.zzhW.toString();
   }

   public zzdb(Context var1, DataLayer var2) {
      String var3 = field_37;
      String[] var4 = new String[]{zzblp, NAME};
      super(var3, var4);
      this.zzblv = new HashSet();
      this.mContext = var1;
      this.zzbhN = var2;
      this.zzblu = new HandlerThread("Google GTM SDK Timer", 10);
      this.zzblu.start();
      this.mHandler = new Handler(this.zzblu.getLooper());
   }

   public boolean zzFW() {
      return false;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      String var2 = zzdf.zzg((com.google.android.gms.internal.zzag.zza)var1.get(NAME));
      String var3 = zzdf.zzg((com.google.android.gms.internal.zzag.zza)var1.get(zzblr));
      String var4 = zzdf.zzg((com.google.android.gms.internal.zzag.zza)var1.get(zzblp));
      String var5 = zzdf.zzg((com.google.android.gms.internal.zzag.zza)var1.get(zzblq));

      long var7;
      label41: {
         long var16;
         try {
            var16 = Long.parseLong(var4);
         } catch (NumberFormatException var19) {
            var7 = 0L;
            break label41;
         }

         var7 = var16;
      }

      long var10;
      label37: {
         long var14;
         try {
            var14 = Long.parseLong(var5);
         } catch (NumberFormatException var18) {
            var10 = 0L;
            break label37;
         }

         var10 = var14;
      }

      if(var7 > 0L && !TextUtils.isEmpty(var2)) {
         if(var3 == null || var3.isEmpty()) {
            var3 = "0";
         }

         if(!this.zzblv.contains(var3)) {
            if(!"0".equals(var3)) {
               this.zzblv.add(var3);
            }

            this.mHandler.postDelayed(new zzdb.zza(var2, var3, var7, var10), var7);
         }
      }

      return zzdf.zzHF();
   }

   private final class zza implements Runnable {
      private final long zzCv;
      private final long zzaNY;
      private final String zzblw;
      private final String zzblx;
      private final long zzbly;
      private long zzblz;

      zza(String var2, String var3, long var4, long var6) {
         this.zzblw = var2;
         this.zzblx = var3;
         this.zzaNY = var4;
         this.zzbly = var6;
         this.zzCv = System.currentTimeMillis();
      }

      public void run() {
         if(this.zzbly > 0L && this.zzblz >= this.zzbly) {
            if(!"0".equals(this.zzblx)) {
               zzdb.this.zzblv.remove(this.zzblx);
            }

         } else {
            ++this.zzblz;
            if(this.zzcH()) {
               long var2 = System.currentTimeMillis();
               DataLayer var4 = zzdb.this.zzbhN;
               Object[] var5 = new Object[]{"event", this.zzblw, "gtm.timerInterval", String.valueOf(this.zzaNY), "gtm.timerLimit", String.valueOf(this.zzbly), "gtm.timerStartTime", String.valueOf(this.zzCv), "gtm.timerCurrentTime", String.valueOf(var2), "gtm.timerElapsedTime", String.valueOf(var2 - this.zzCv), "gtm.timerEventNumber", String.valueOf(this.zzblz), "gtm.triggers", this.zzblx};
               var4.push(DataLayer.mapOf(var5));
            }

            zzdb.this.mHandler.postDelayed(this, this.zzaNY);
         }
      }

      protected boolean zzcH() {
         if(zzdb.this.zzblt) {
            return zzdb.this.zzbls;
         } else {
            ActivityManager var1 = (ActivityManager)zzdb.this.mContext.getSystemService("activity");
            KeyguardManager var2 = (KeyguardManager)zzdb.this.mContext.getSystemService("keyguard");
            PowerManager var3 = (PowerManager)zzdb.this.mContext.getSystemService("power");
            Iterator var4 = var1.getRunningAppProcesses().iterator();

            RunningAppProcessInfo var5;
            do {
               if(!var4.hasNext()) {
                  return false;
               }

               var5 = (RunningAppProcessInfo)var4.next();
            } while(Process.myPid() != var5.pid || var5.importance != 100 || var2.inKeyguardRestrictedInputMode() || !var3.isScreenOn());

            return true;
         }
      }
   }
}
