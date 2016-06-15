package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.Container;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;
import com.google.android.gms.tagmanager.class_613;

// $FF: renamed from: com.google.android.gms.tagmanager.n
class class_672 implements ContainerHolder {
   // $FF: renamed from: Eb com.google.android.gms.common.api.Status
   private Status field_2909;
   // $FF: renamed from: JF android.os.Looper
   private final Looper field_2910;
   // $FF: renamed from: Pf boolean
   private boolean field_2911;
   private Container aqu;
   private Container aqv;
   private class_672.class_1115 aqw;
   private class_672.class_1116 aqx;
   private TagManager aqy;

   public class_672(Status var1) {
      this.field_2909 = var1;
      this.field_2910 = null;
   }

   public class_672(TagManager var1, Looper var2, Container var3, class_672.class_1116 var4) {
      this.aqy = var1;
      if(var2 == null) {
         var2 = Looper.getMainLooper();
      }

      this.field_2910 = var2;
      this.aqu = var3;
      this.aqx = var4;
      this.field_2909 = Status.field_3960;
      var1.method_3759(this);
   }

   // $FF: renamed from: pm () void
   private void method_3820() {
      if(this.aqw != null) {
         this.aqw.method_2543(this.aqv.method_5811());
      }

   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.Container) void
   public void method_3821(Container param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cr (java.lang.String) void
   public void method_3822(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ct (java.lang.String) void
   void method_3823(String var1) {
      if(this.field_2911) {
         class_613.method_3491("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
      } else {
         this.aqx.method_173(var1);
      }
   }

   public Container getContainer() {
      Container var1 = null;
      synchronized(this){}

      try {
         if(this.field_2911) {
            class_613.method_3491("ContainerHolder is released.");
         } else {
            if(this.aqv != null) {
               this.aqu = this.aqv;
               this.aqv = null;
            }

            var1 = this.aqu;
         }
      } finally {
         ;
      }

      return var1;
   }

   String getContainerId() {
      if(this.field_2911) {
         class_613.method_3491("getContainerId called on a released ContainerHolder.");
         return "";
      } else {
         return this.aqu.getContainerId();
      }
   }

   public Status getStatus() {
      return this.field_2909;
   }

   // $FF: renamed from: pl () java.lang.String
   String method_3824() {
      if(this.field_2911) {
         class_613.method_3491("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
         return "";
      } else {
         return this.aqx.method_174();
      }
   }

   public void refresh() {
      synchronized(this){}

      try {
         if(this.field_2911) {
            class_613.method_3491("Refreshing a released ContainerHolder.");
         } else {
            this.aqx.method_175();
         }
      } finally {
         ;
      }

   }

   public void release() {
      synchronized(this){}

      try {
         if(this.field_2911) {
            class_613.method_3491("Releasing a released ContainerHolder.");
         } else {
            this.field_2911 = true;
            this.aqy.method_3760(this);
            this.aqu.release();
            this.aqu = null;
            this.aqv = null;
            this.aqx = null;
            this.aqw = null;
         }
      } finally {
         ;
      }

   }

   public void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener param1) {
      // $FF: Couldn't be decompiled
   }

   public interface class_1116 {
      // $FF: renamed from: ct (java.lang.String) void
      void method_173(String var1);

      // $FF: renamed from: pl () java.lang.String
      String method_174();

      // $FF: renamed from: pn () void
      void method_175();
   }

   private class class_1115 extends Handler {
      private final ContainerHolder.ContainerAvailableListener aqz;

      public class_1115(ContainerHolder.ContainerAvailableListener var2, Looper var3) {
         super(var3);
         this.aqz = var2;
      }

      // $FF: renamed from: cu (java.lang.String) void
      public void method_2543(String var1) {
         this.sendMessage(this.obtainMessage(1, var1));
      }

      // $FF: renamed from: cv (java.lang.String) void
      protected void method_2544(String var1) {
         this.aqz.onContainerAvailable(class_672.this, var1);
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            this.method_2544((String)var1.obj);
            return;
         default:
            class_613.method_3491("Don\'t know how to handle this message.");
         }
      }
   }
}
