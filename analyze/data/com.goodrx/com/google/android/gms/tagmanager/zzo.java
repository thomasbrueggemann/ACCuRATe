package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.Container;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;
import com.google.android.gms.tagmanager.zzbg;

class zzo implements ContainerHolder {
   private Status zzUX;
   private final Looper zzagr;
   private boolean zzapK;
   private Container zzbhU;
   private Container zzbhV;
   private zzo.zzb zzbhW;
   private zzo.zza zzbhX;
   private TagManager zzbhY;

   public zzo(Status var1) {
      this.zzUX = var1;
      this.zzagr = null;
   }

   public zzo(TagManager var1, Looper var2, Container var3, zzo.zza var4) {
      this.zzbhY = var1;
      if(var2 == null) {
         var2 = Looper.getMainLooper();
      }

      this.zzagr = var2;
      this.zzbhU = var3;
      this.zzbhX = var4;
      this.zzUX = Status.zzagC;
      var1.zza(this);
   }

   private void zzGe() {
      if(this.zzbhW != null) {
         this.zzbhW.zzfU(this.zzbhV.zzGb());
      }

   }

   public Container getContainer() {
      Container var1 = null;
      synchronized(this){}

      try {
         if(this.zzapK) {
            zzbg.method_353("ContainerHolder is released.");
         } else {
            if(this.zzbhV != null) {
               this.zzbhU = this.zzbhV;
               this.zzbhV = null;
            }

            var1 = this.zzbhU;
         }
      } finally {
         ;
      }

      return var1;
   }

   String getContainerId() {
      if(this.zzapK) {
         zzbg.method_353("getContainerId called on a released ContainerHolder.");
         return "";
      } else {
         return this.zzbhU.getContainerId();
      }
   }

   public Status getStatus() {
      return this.zzUX;
   }

   public void refresh() {
      synchronized(this){}

      try {
         if(this.zzapK) {
            zzbg.method_353("Refreshing a released ContainerHolder.");
         } else {
            this.zzbhX.zzGf();
         }
      } finally {
         ;
      }

   }

   public void release() {
      synchronized(this){}

      try {
         if(this.zzapK) {
            zzbg.method_353("Releasing a released ContainerHolder.");
         } else {
            this.zzapK = true;
            this.zzbhY.zzb(this);
            this.zzbhU.release();
            this.zzbhU = null;
            this.zzbhV = null;
            this.zzbhX = null;
            this.zzbhW = null;
         }
      } finally {
         ;
      }

   }

   public void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener param1) {
      // $FF: Couldn't be decompiled
   }

   String zzGd() {
      if(this.zzapK) {
         zzbg.method_353("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
         return "";
      } else {
         return this.zzbhX.zzGd();
      }
   }

   public void zza(Container param1) {
      // $FF: Couldn't be decompiled
   }

   public void zzfR(String param1) {
      // $FF: Couldn't be decompiled
   }

   void zzfT(String var1) {
      if(this.zzapK) {
         zzbg.method_353("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
      } else {
         this.zzbhX.zzfT(var1);
      }
   }

   public interface zza {
      String zzGd();

      void zzGf();

      void zzfT(String var1);
   }

   private class zzb extends Handler {
      private final ContainerHolder.ContainerAvailableListener zzbhZ;

      public zzb(ContainerHolder.ContainerAvailableListener var2, Looper var3) {
         super(var3);
         this.zzbhZ = var2;
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            this.zzfV((String)var1.obj);
            return;
         default:
            zzbg.method_353("Don\'t know how to handle this message.");
         }
      }

      public void zzfU(String var1) {
         this.sendMessage(this.obtainMessage(1, var1));
      }

      protected void zzfV(String var1) {
         this.zzbhZ.onContainerAvailable(zzo.this, var1);
      }
   }
}
