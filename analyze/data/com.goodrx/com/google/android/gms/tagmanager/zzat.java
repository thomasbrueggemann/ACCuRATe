package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.zzas;
import com.google.android.gms.tagmanager.zzau;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzcu;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class zzat extends Thread implements zzas {
   private static zzat zzbjb;
   private volatile boolean mClosed = false;
   private final Context mContext;
   private volatile boolean zzRE = false;
   private final LinkedBlockingQueue<Runnable> zzbja = new LinkedBlockingQueue();
   private volatile zzau zzbjc;

   private zzat(Context var1) {
      super("GAThread");
      if(var1 != null) {
         this.mContext = var1.getApplicationContext();
      } else {
         this.mContext = var1;
      }

      this.start();
   }

   static zzat zzaZ(Context var0) {
      if(zzbjb == null) {
         zzbjb = new zzat(var0);
      }

      return zzbjb;
   }

   private String zzd(Throwable var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      PrintStream var3 = new PrintStream(var2);
      var1.printStackTrace(var3);
      var3.flush();
      return new String(var2.toByteArray());
   }

   public void run() {
      while(!this.mClosed) {
         try {
            try {
               Runnable var3 = (Runnable)this.zzbja.take();
               if(!this.zzRE) {
                  var3.run();
               }
            } catch (InterruptedException var4) {
               zzbg.zzaJ(var4.toString());
            }
         } catch (Throwable var5) {
            zzbg.method_353("Error on Google TagManager Thread: " + this.zzd(var5));
            zzbg.method_353("Google TagManager is shutting down.");
            this.zzRE = true;
         }
      }

   }

   public void zzgg(String var1) {
      this.zzk(var1, System.currentTimeMillis());
   }

   public void zzj(Runnable var1) {
      this.zzbja.add(var1);
   }

   void zzk(final String var1, final long var2) {
      this.zzj(new Runnable() {
         public void run() {
            if(zzat.this.zzbjc == null) {
               zzcu var1x = zzcu.zzHo();
               var1x.zza(zzat.this.mContext, zzat.this);
               zzat.this.zzbjc = var1x.zzHr();
            }

            zzat.this.zzbjc.zzg(var2, var1);
         }
      });
   }
}
