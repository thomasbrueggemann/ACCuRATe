package com.comscore.utils.task;

import com.comscore.analytics.Core;
import com.comscore.utils.CSLog;
import com.comscore.utils.task.TaskThread;
import com.comscore.utils.task.a;
import com.comscore.utils.task.class_21;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskExecutor {
   // $FF: renamed from: b long
   private static final long field_442 = 50000L;
   // $FF: renamed from: a com.comscore.analytics.Core
   Core field_443;
   // $FF: renamed from: c com.comscore.utils.task.TaskThread
   private TaskThread field_444;
   // $FF: renamed from: d java.util.concurrent.BlockingQueue
   private BlockingQueue<a> field_445;

   public TaskExecutor(Core var1) {
      this.field_443 = var1;
      this.field_445 = new LinkedBlockingQueue();
      this.field_444 = new TaskThread(this);
      this.field_444.start();
   }

   // $FF: renamed from: a () long
   long method_339() {
      Iterator var1 = this.field_445.iterator();

      long var2;
      for(var2 = 50000L; var1.hasNext(); var2 = Math.min(var2, ((class_21)var1.next()).method_160())) {
         ;
      }

      return var2;
   }

   // $FF: renamed from: a (com.comscore.utils.task.a) void
   void method_340(class_21 var1) {
      this.field_445.remove(var1);
   }

   // $FF: renamed from: b () com.comscore.utils.task.a
   class_21 method_341() {
      Iterator var1 = this.field_445.iterator();

      class_21 var2;
      do {
         if(!var1.hasNext()) {
            return null;
         }

         var2 = (class_21)var1.next();
      } while(var2.method_165() > System.currentTimeMillis());

      return var2;
   }

   public boolean containsTask(Runnable var1) {
      Iterator var2 = this.field_445.iterator();

      class_21 var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (class_21)var2.next();
      } while(var3.method_168() != var1 && (!(var1 instanceof class_21) || var3 != var1));

      return true;
   }

   public boolean execute(Runnable var1, long var2) {
      return this.execute(var1, var2, false, 0L);
   }

   public boolean execute(Runnable var1, long var2, boolean var4, long var5) {
      Iterator var7 = this.field_445.iterator();

      class_21 var9;
      do {
         if(!var7.hasNext()) {
            this.field_445.add(new class_21(var1, this.field_443, var2, var4, var5));
            this.field_444.method_84();
            return true;
         }

         var9 = (class_21)var7.next();
      } while(var9 == null || var9.method_168() != var1);

      return false;
   }

   public boolean execute(Runnable var1, boolean var2) {
      if(!this.field_443.isEnabled()) {
         return false;
      } else if(!var2) {
         try {
            var1.run();
            return true;
         } catch (Exception var5) {
            CSLog.method_373(this.getClass(), "Unexpected error: ");
            CSLog.printStackTrace(var5);
            return true;
         }
      } else {
         this.execute(var1, 0L);
         return true;
      }
   }

   public void removeAllEnqueuedTasks() {
      this.field_445.clear();
   }

   public void removeEnqueuedTask(Runnable var1) {
      if(var1 != null) {
         Iterator var2 = this.field_445.iterator();

         while(var2.hasNext()) {
            class_21 var3 = (class_21)var2.next();
            if(var3.method_168() == var1) {
               this.field_445.remove(var3);
               return;
            }
         }
      }

   }

   public int size() {
      return this.field_445.size();
   }

   public void waitForLastNonDelayedTaskToFinish() {
      class_21[] var1 = new class_21[this.field_445.size()];
      this.field_445.toArray(var1);
      int var3 = -1 + var1.length;

      class_21 var4;
      while(true) {
         var4 = null;
         if(var3 < 0) {
            break;
         }

         if(var1[var3] != null && !var1[var3].method_163()) {
            var4 = var1[var3];
            break;
         }

         --var3;
      }

      this.waitForTaskToFinish(var4, 0L);
   }

   public void waitForTaskToFinish(Runnable var1, long var2) {
      class_21 var4;
      if(!(var1 instanceof class_21)) {
         Iterator var8 = this.field_445.iterator();
         var4 = null;

         while(var8.hasNext()) {
            class_21 var9 = (class_21)var8.next();
            if(var9.method_168() == var1) {
               var4 = var9;
            }
         }
      } else {
         var4 = (class_21)var1;
      }

      if(var4 != null) {
         long var5 = System.currentTimeMillis();

         while(this.field_445.contains(var4) && (var2 <= 0L || System.currentTimeMillis() < var5 + var2)) {
            try {
               Thread.sleep(100L);
            } catch (InterruptedException var10) {
               ;
            }
         }
      }

   }

   public void waitForTasks() {
      while(this.field_445.size() != 0) {
         try {
            Thread.sleep(100L);
         } catch (InterruptedException var2) {
            ;
         }
      }

   }
}
