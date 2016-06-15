package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.Container;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;
import com.google.android.gms.tagmanager.class_515;

// $FF: renamed from: com.google.android.gms.tagmanager.n
class class_571 implements ContainerHolder {
   // $FF: renamed from: DC android.os.Looper
   private final Looper field_3019;
   // $FF: renamed from: Im boolean
   private boolean field_3020;
   private class_571.class_832 aeA;
   private class_571.class_833 aeB;
   private TagManager aeC;
   private Container aey;
   private Container aez;
   // $FF: renamed from: yw com.google.android.gms.common.api.Status
   private Status field_3021;

   public class_571(Status var1) {
      this.field_3021 = var1;
      this.field_3019 = null;
   }

   public class_571(TagManager var1, Looper var2, Container var3, class_571.class_833 var4) {
      this.aeC = var1;
      if(var2 == null) {
         var2 = Looper.getMainLooper();
      }

      this.field_3019 = var2;
      this.aey = var3;
      this.aeB = var4;
      this.field_3021 = Status.field_3880;
      var1.method_3131(this);
   }

   // $FF: renamed from: lk () void
   private void method_3188() {
      if(this.aeA != null) {
         this.aeA.method_2115(this.aez.method_4537());
      }

   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.Container) void
   public void method_3189(Container param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bH (java.lang.String) void
   public void method_3190(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bJ (java.lang.String) void
   void method_3191(String var1) {
      if(this.field_3020) {
         class_515.method_2916("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
      } else {
         this.aeB.method_110(var1);
      }
   }

   public Container getContainer() {
      Container var1 = null;
      synchronized(this){}

      try {
         if(this.field_3020) {
            class_515.method_2916("ContainerHolder is released.");
         } else {
            if(this.aez != null) {
               this.aey = this.aez;
               this.aez = null;
            }

            var1 = this.aey;
         }
      } finally {
         ;
      }

      return var1;
   }

   String getContainerId() {
      if(this.field_3020) {
         class_515.method_2916("getContainerId called on a released ContainerHolder.");
         return "";
      } else {
         return this.aey.getContainerId();
      }
   }

   public Status getStatus() {
      return this.field_3021;
   }

   // $FF: renamed from: lj () java.lang.String
   String method_3192() {
      if(this.field_3020) {
         class_515.method_2916("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
         return "";
      } else {
         return this.aeB.method_111();
      }
   }

   public void refresh() {
      synchronized(this){}

      try {
         if(this.field_3020) {
            class_515.method_2916("Refreshing a released ContainerHolder.");
         } else {
            this.aeB.method_112();
         }
      } finally {
         ;
      }

   }

   public void release() {
      synchronized(this){}

      try {
         if(this.field_3020) {
            class_515.method_2916("Releasing a released ContainerHolder.");
         } else {
            this.field_3020 = true;
            this.aeC.method_3132(this);
            this.aey.release();
            this.aey = null;
            this.aez = null;
            this.aeB = null;
            this.aeA = null;
         }
      } finally {
         ;
      }

   }

   public void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener param1) {
      // $FF: Couldn't be decompiled
   }

   public interface class_833 {
      // $FF: renamed from: bJ (java.lang.String) void
      void method_110(String var1);

      // $FF: renamed from: lj () java.lang.String
      String method_111();

      // $FF: renamed from: ll () void
      void method_112();
   }

   private class class_832 extends Handler {
      private final ContainerHolder.ContainerAvailableListener aeD;

      public class_832(ContainerHolder.ContainerAvailableListener var2, Looper var3) {
         super(var3);
         this.aeD = var2;
      }

      // $FF: renamed from: bK (java.lang.String) void
      public void method_2115(String var1) {
         this.sendMessage(this.obtainMessage(1, var1));
      }

      // $FF: renamed from: bL (java.lang.String) void
      protected void method_2116(String var1) {
         this.aeD.onContainerAvailable(class_571.this, var1);
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            this.method_2116((String)var1.obj);
            return;
         default:
            class_515.method_2916("Don\'t know how to handle this message.");
         }
      }
   }
}
