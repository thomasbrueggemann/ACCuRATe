package com.comscore.utils.task;

import com.comscore.utils.task.TaskExecutor;
import com.comscore.utils.task.class_21;

public class TaskThread extends Thread {
   // $FF: renamed from: a boolean
   private boolean field_138 = false;
   // $FF: renamed from: b java.lang.Object
   private Object field_139;
   // $FF: renamed from: c com.comscore.utils.task.TaskExecutor
   private TaskExecutor field_140;

   TaskThread(TaskExecutor var1) {
      this.field_140 = var1;
      this.field_139 = new Object();
   }

   // $FF: renamed from: a (long) void
   private void method_81(long param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a () boolean
   boolean method_82() {
      return this.field_138;
   }

   // $FF: renamed from: b () void
   void method_83() {
      this.field_138 = true;
   }

   // $FF: renamed from: c () void
   void method_84() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: d () void
   void method_85() {
      long var1 = this.field_140.method_339();
      if(var1 > 0L) {
         this.method_81(var1);
      }

   }

   public void run() {
      while(!this.method_82()) {
         class_21 var1 = this.field_140.method_341();
         if(var1 != null) {
            var1.run();
            this.field_140.method_340(var1);
            if(var1.method_166()) {
               this.field_140.execute(var1.method_168(), var1.method_167(), var1.method_166(), var1.method_167());
            }
         } else {
            this.method_85();
         }
      }

   }
}
