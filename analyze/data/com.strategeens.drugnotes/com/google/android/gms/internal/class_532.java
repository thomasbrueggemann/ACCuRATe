package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_372;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_548;
import com.google.android.gms.internal.class_556;
import com.google.android.gms.internal.class_56;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.g;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

// $FF: renamed from: com.google.android.gms.internal.x
@ey
class class_532 implements class_56, Runnable {
   // $FF: renamed from: lB com.google.android.gms.internal.u$b
   private class_548.class_1277 field_2514;
   // $FF: renamed from: mp java.util.List
   private final List<Object[]> field_2515 = new Vector();
   // $FF: renamed from: mq java.util.concurrent.atomic.AtomicReference
   private final AtomicReference<g> field_2516 = new AtomicReference();
   // $FF: renamed from: mr java.util.concurrent.CountDownLatch
   CountDownLatch field_2517 = new CountDownLatch(1);

   public class_532(class_548.class_1277 var1) {
      this.field_2514 = var1;
      if(class_367.method_2500()) {
         class_372.method_2539(this);
      } else {
         this.run();
      }
   }

   // $FF: renamed from: aB () void
   private void method_3271() {
      if(!this.field_2515.isEmpty()) {
         Iterator var1 = this.field_2515.iterator();

         while(var1.hasNext()) {
            Object[] var2 = (Object[])var1.next();
            if(var2.length == 1) {
               ((class_56)this.field_2516.get()).method_289((MotionEvent)var2[0]);
            } else if(var2.length == 3) {
               ((class_56)this.field_2516.get()).method_288(((Integer)var2[0]).intValue(), ((Integer)var2[1]).intValue(), ((Integer)var2[2]).intValue());
            }
         }
      }

   }

   // $FF: renamed from: i (android.content.Context) android.content.Context
   private Context method_3272(Context var1) {
      if(this.method_3275()) {
         Context var2 = var1.getApplicationContext();
         if(var2 != null) {
            return var2;
         }
      }

      return var1;
   }

   // $FF: renamed from: a (android.content.Context) java.lang.String
   public String method_286(Context var1) {
      if(this.method_3274()) {
         class_56 var2 = (class_56)this.field_2516.get();
         if(var2 != null) {
            this.method_3271();
            return var2.method_286(this.method_3272(var1));
         }
      }

      return "";
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String) java.lang.String
   public String method_287(Context var1, String var2) {
      if(this.method_3274()) {
         class_56 var3 = (class_56)this.field_2516.get();
         if(var3 != null) {
            this.method_3271();
            return var3.method_287(this.method_3272(var1), var2);
         }
      }

      return "";
   }

   // $FF: renamed from: a (int, int, int) void
   public void method_288(int var1, int var2, int var3) {
      class_56 var4 = (class_56)this.field_2516.get();
      if(var4 != null) {
         this.method_3271();
         var4.method_288(var1, var2, var3);
      } else {
         List var5 = this.field_2515;
         Object[] var6 = new Object[]{Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3)};
         var5.add(var6);
      }
   }

   // $FF: renamed from: a (android.view.MotionEvent) void
   public void method_289(MotionEvent var1) {
      class_56 var2 = (class_56)this.field_2516.get();
      if(var2 != null) {
         this.method_3271();
         var2.method_289(var1);
      } else {
         this.field_2515.add(new Object[]{var1});
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.g) void
   protected void method_3273(class_56 var1) {
      this.field_2516.set(var1);
   }

   // $FF: renamed from: aA () boolean
   protected boolean method_3274() {
      try {
         this.field_2517.await();
         return true;
      } catch (InterruptedException var2) {
         class_368.method_2510("Interrupted during GADSignals creation.", var2);
         return false;
      }
   }

   // $FF: renamed from: aC () boolean
   protected boolean method_3275() {
      return class_381.method_2605().getBoolean("gads:spam_app_context:enabled", false);
   }

   public void run() {
      try {
         this.method_3273(class_556.method_3386(this.field_2514.field_1948.field_1121, this.method_3272(this.field_2514.field_1946)));
      } finally {
         this.field_2517.countDown();
         this.field_2514 = null;
      }

   }
}
