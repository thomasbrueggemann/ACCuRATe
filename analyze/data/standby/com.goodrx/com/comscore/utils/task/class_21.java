package com.comscore.utils.task;

import com.comscore.analytics.Core;
import com.comscore.utils.CSLog;
import java.util.concurrent.atomic.AtomicBoolean;

// $FF: renamed from: com.comscore.utils.task.a
class class_21 implements Runnable {
   // $FF: renamed from: a java.util.concurrent.atomic.AtomicBoolean
   private AtomicBoolean field_205;
   // $FF: renamed from: b java.util.concurrent.atomic.AtomicBoolean
   private AtomicBoolean field_206;
   // $FF: renamed from: c java.lang.Runnable
   private Runnable field_207;
   // $FF: renamed from: d com.comscore.analytics.Core
   private Core field_208;
   // $FF: renamed from: e long
   private long field_209;
   // $FF: renamed from: f long
   private long field_210;
   // $FF: renamed from: g long
   private long field_211;
   // $FF: renamed from: h boolean
   private boolean field_212;
   // $FF: renamed from: i boolean
   private boolean field_213;

   class_21(Runnable var1, Core var2) {
      this(var1, var2, 0L);
   }

   class_21(Runnable var1, Core var2, long var3) {
      this(var1, var2, var3, false, 0L);
   }

   class_21(Runnable var1, Core var2, long var3, boolean var5, long var6) {
      this.field_207 = var1;
      this.field_208 = var2;
      long var8 = System.currentTimeMillis();
      long var10;
      if(var3 > 0L) {
         var10 = var3;
      } else {
         var10 = 0L;
      }

      this.field_209 = var10 + var8;
      boolean var12;
      if(var3 > 0L) {
         var12 = true;
      } else {
         var12 = false;
      }

      this.field_213 = var12;
      this.field_210 = System.currentTimeMillis();
      this.field_212 = var5;
      this.field_211 = var6;
      this.field_205 = new AtomicBoolean();
      this.field_206 = new AtomicBoolean();
      this.field_206.set(false);
      this.field_205.set(false);
   }

   // $FF: renamed from: a () long
   long method_160() {
      long var1 = this.field_209 - System.currentTimeMillis();
      return var1 > 0L?var1:0L;
   }

   // $FF: renamed from: b () long
   long method_161() {
      return this.field_210;
   }

   // $FF: renamed from: c () boolean
   boolean method_162() {
      return this.field_205.get();
   }

   // $FF: renamed from: d () boolean
   boolean method_163() {
      return this.field_213;
   }

   // $FF: renamed from: e () boolean
   boolean method_164() {
      return this.field_206.get();
   }

   // $FF: renamed from: f () long
   long method_165() {
      return this.field_209;
   }

   // $FF: renamed from: g () boolean
   boolean method_166() {
      return this.field_212;
   }

   // $FF: renamed from: h () long
   long method_167() {
      return this.field_211;
   }

   // $FF: renamed from: i () java.lang.Runnable
   Runnable method_168() {
      return this.field_207;
   }

   public void run() {
      this.field_205.set(true);

      try {
         this.field_207.run();
      } catch (Exception var2) {
         CSLog.method_373(this.getClass(), "Unexpected error running asynchronous task: ");
         CSLog.printStackTrace(var2);
         this.field_208.getStorage().add("exception_ocurrences", 1L);
         this.field_208.setEnabled(false);
      }

      this.field_205.set(false);
      this.field_206.set(true);
   }
}
