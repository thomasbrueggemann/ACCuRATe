package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.class_335;

// $FF: renamed from: com.google.android.gms.common.api.d
public final class class_1033<L> {
   // $FF: renamed from: Kt com.google.android.gms.common.api.d$a
   private final com/google/android/gms/common/api/d<L>.a field_4333;
   private volatile L mListener;

   class_1033(Looper var1, L var2) {
      this.field_4333 = new class_1033.class_1136(var1);
      this.mListener = class_335.method_2306(var2, "Listener must not be null");
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.d$b) void
   public void method_5677(class_1033.class_1137<? super L> var1) {
      class_335.method_2306(var1, "Notifier must not be null");
      Message var3 = this.field_4333.obtainMessage(1, var1);
      this.field_4333.sendMessage(var3);
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.d$b) void
   void method_5678(class_1033.class_1137<? super L> var1) {
      Object var2 = this.mListener;
      if(var2 == null) {
         var1.method_200();
      } else {
         try {
            var1.method_199(var2);
         } catch (Exception var4) {
            Log.w("ListenerHolder", "Notifying listener failed", var4);
            var1.method_200();
         }
      }
   }

   public void clear() {
      this.mListener = null;
   }

   private final class class_1136 extends Handler {
      public class_1136(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message var1) {
         byte var2 = 1;
         if(var1.what != var2) {
            var2 = 0;
         }

         class_335.method_2301((boolean)var2);
         class_1033.this.method_5678((class_1033.class_1137)var1.obj);
      }
   }

   public interface class_1137<L> {
      // $FF: renamed from: c (java.lang.Object) void
      void method_199(L var1);

      // $FF: renamed from: gG () void
      void method_200();
   }
}
