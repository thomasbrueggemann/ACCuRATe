package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import com.google.android.gms.tagmanager.zzas;
import com.google.android.gms.tagmanager.zzau;
import com.google.android.gms.tagmanager.zzav;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzbl;
import com.google.android.gms.tagmanager.zzby;
import com.google.android.gms.tagmanager.zzct;

class zzcu extends zzct {
   private static final Object zzbkP = new Object();
   private static zzcu zzbla;
   private boolean connected = true;
   private Handler handler;
   private Context zzbkQ;
   private zzau zzbkR;
   private volatile zzas zzbkS;
   private int zzbkT = 1800000;
   private boolean zzbkU = true;
   private boolean zzbkV = false;
   private boolean zzbkW = true;
   private zzav zzbkX = new zzav() {
      public void zzax(boolean var1) {
         zzcu.this.zzd(var1, zzcu.this.connected);
      }
   };
   private zzbl zzbkY;
   private boolean zzbkZ = false;

   public static zzcu zzHo() {
      if(zzbla == null) {
         zzbla = new zzcu();
      }

      return zzbla;
   }

   private void zzHp() {
      this.zzbkY = new zzbl(this);
      this.zzbkY.zzba(this.zzbkQ);
   }

   private void zzHq() {
      this.handler = new Handler(this.zzbkQ.getMainLooper(), new Callback() {
         public boolean handleMessage(Message var1) {
            if(1 == var1.what && zzcu.zzbkP.equals(var1.obj)) {
               zzcu.this.dispatch();
               if(zzcu.this.zzbkT > 0 && !zzcu.this.zzbkZ) {
                  zzcu.this.handler.sendMessageDelayed(zzcu.this.handler.obtainMessage(1, zzcu.zzbkP), (long)zzcu.this.zzbkT);
               }
            }

            return true;
         }
      });
      if(this.zzbkT > 0) {
         this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzbkP), (long)this.zzbkT);
      }

   }

   public void dispatch() {
      synchronized(this){}

      try {
         if(!this.zzbkV) {
            zzbg.method_354("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zzbkU = true;
         } else {
            this.zzbkS.zzj(new Runnable() {
               public void run() {
                  zzcu.this.zzbkR.dispatch();
               }
            });
         }
      } finally {
         ;
      }

   }

   zzau zzHr() {
      synchronized(this){}

      zzau var2;
      try {
         if(this.zzbkR == null) {
            if(this.zzbkQ == null) {
               throw new IllegalStateException("Cant get a store unless we have a context");
            }

            this.zzbkR = new zzby(this.zzbkX, this.zzbkQ);
         }

         if(this.handler == null) {
            this.zzHq();
         }

         this.zzbkV = true;
         if(this.zzbkU) {
            this.dispatch();
            this.zzbkU = false;
         }

         if(this.zzbkY == null && this.zzbkW) {
            this.zzHp();
         }

         var2 = this.zzbkR;
      } finally {
         ;
      }

      return var2;
   }

   void zza(Context param1, zzas param2) {
      // $FF: Couldn't be decompiled
   }

   public void zzay(boolean var1) {
      synchronized(this){}

      try {
         this.zzd(this.zzbkZ, var1);
      } finally {
         ;
      }

   }

   void zzd(boolean param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public void zzjg() {
      synchronized(this){}

      try {
         if(!this.zzbkZ && this.connected && this.zzbkT > 0) {
            this.handler.removeMessages(1, zzbkP);
            this.handler.sendMessage(this.handler.obtainMessage(1, zzbkP));
         }
      } finally {
         ;
      }

   }
}
