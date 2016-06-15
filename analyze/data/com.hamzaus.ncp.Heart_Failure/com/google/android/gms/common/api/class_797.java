package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_798;
import com.google.android.gms.internal.class_33;
import com.google.android.gms.internal.class_347;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.common.api.a
public class class_797 {
   // $FF: renamed from: a (com.google.android.gms.common.api.Result) void
   static void method_4433(Result var0) {
      if(var0 instanceof Releasable) {
         try {
            ((Releasable)var0).release();
         } catch (RuntimeException var2) {
            Log.w("GoogleApi", "Unable to release " + var0, var2);
            return;
         }
      }

   }

   public abstract static class class_1207<R extends Result> implements PendingResult<R>, class_797.class_1206<R> {
      // $FF: renamed from: Dm java.lang.Object
      private final Object field_36 = new Object();
      // $FF: renamed from: Dn com.google.android.gms.common.api.a$c
      private class_797.class_1205<R> field_37;
      // $FF: renamed from: Do java.util.ArrayList
      private final ArrayList<PendingResult.class_1287> field_38 = new ArrayList();
      // $FF: renamed from: Dp com.google.android.gms.common.api.ResultCallback
      private ResultCallback<R> field_39;
      // $FF: renamed from: Dq com.google.android.gms.common.api.Result
      private volatile R field_40;
      // $FF: renamed from: Dr boolean
      private volatile boolean field_41;
      // $FF: renamed from: Ds boolean
      private boolean field_42;
      // $FF: renamed from: Dt boolean
      private boolean field_43;
      // $FF: renamed from: Du com.google.android.gms.internal.hh
      private class_33 field_44;
      // $FF: renamed from: kI java.util.concurrent.CountDownLatch
      private final CountDownLatch field_45 = new CountDownLatch(1);

      class_1207() {
      }

      public class_1207(Looper var1) {
         this.field_37 = new class_797.class_1205(var1);
      }

      public class_1207(class_797.class_1205<R> var1) {
         this.field_37 = var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Result) void
      private void method_877(R var1) {
         this.field_40 = var1;
         this.field_44 = null;
         this.field_45.countDown();
         Status var2 = this.field_40.getStatus();
         if(this.field_39 != null) {
            this.field_37.method_3455();
            if(!this.field_42) {
               this.field_37.method_3452(this.field_39, this.method_879());
            }
         }

         Iterator var3 = this.field_38.iterator();

         while(var3.hasNext()) {
            ((PendingResult.class_1287)var3.next()).method_765(var2);
         }

         this.field_38.clear();
      }

      // $FF: renamed from: eA () void
      private void method_878() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: ex () com.google.android.gms.common.api.Result
      private R method_879() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: ez () void
      private void method_880() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.PendingResult$a) void
      public final void method_758(PendingResult.class_1287 param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.a$c) void
      protected void method_881(class_797.class_1205<R> var1) {
         this.field_37 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hh) void
      protected final void method_882(class_33 param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.Object) void
      // $FF: synthetic method
      public void method_673(Object var1) {
         this.method_883((Result)var1);
      }

      public final R await() {
         boolean var1 = true;
         boolean var2;
         if(Looper.myLooper() != Looper.getMainLooper()) {
            var2 = var1;
         } else {
            var2 = false;
         }

         class_347.method_2161(var2, "await must not be called on the UI thread");
         if(this.field_41) {
            var1 = false;
         }

         class_347.method_2161(var1, "Result has already been consumed");

         try {
            this.field_45.await();
         } catch (InterruptedException var4) {
            this.method_880();
         }

         class_347.method_2161(this.isReady(), "Result is not ready.");
         return this.method_879();
      }

      public final R await(long var1, TimeUnit var3) {
         boolean var4 = true;
         boolean var5;
         if(var1 > 0L && Looper.myLooper() == Looper.getMainLooper()) {
            var5 = false;
         } else {
            var5 = var4;
         }

         class_347.method_2161(var5, "await must not be called on the UI thread when time is greater than zero.");
         if(this.field_41) {
            var4 = false;
         }

         class_347.method_2161(var4, "Result has already been consumed.");

         try {
            if(!this.field_45.await(var1, var3)) {
               this.method_878();
            }
         } catch (InterruptedException var7) {
            this.method_880();
         }

         class_347.method_2161(this.isReady(), "Result is not ready.");
         return this.method_879();
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Result) void
      public final void method_883(R param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      protected abstract R method_884(Status var1);

      public void cancel() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: ey () void
      protected void method_885() {
         this.field_41 = true;
         this.field_40 = null;
         this.field_39 = null;
      }

      public boolean isCanceled() {
         // $FF: Couldn't be decompiled
      }

      public final boolean isReady() {
         return this.field_45.getCount() == 0L;
      }

      public final void setResultCallback(ResultCallback<R> param1) {
         // $FF: Couldn't be decompiled
      }

      public final void setResultCallback(ResultCallback<R> param1, long param2, TimeUnit param4) {
         // $FF: Couldn't be decompiled
      }
   }

   public abstract static class class_1203<R extends Result, A extends Api.class_1073> extends class_797.class_1207<R> implements class_798.class_1019<A> {
      // $FF: renamed from: Dk com.google.android.gms.common.api.Api$c
      private final Api.class_1077<A> field_52;
      // $FF: renamed from: Dv com.google.android.gms.common.api.c$a
      private class_798.class_1021 field_53;

      protected class_1203(Api.class_1077<A> var1) {
         this.field_52 = (Api.class_1077)class_347.method_2170(var1);
      }

      // $FF: renamed from: a (android.os.RemoteException) void
      private void method_916(RemoteException var1) {
         this.method_351(new Status(8, var1.getLocalizedMessage(), (PendingIntent)null));
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Api$a) void
      protected abstract void method_917(A var1) throws RemoteException;

      // $FF: renamed from: a (com.google.android.gms.common.api.c$a) void
      public void method_347(class_798.class_1021 var1) {
         this.field_53 = var1;
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Api$a) void
      public final void method_348(A var1) throws DeadObjectException {
         this.a(new class_797.class_1205(var1.getLooper()));

         try {
            this.method_917(var1);
         } catch (DeadObjectException var4) {
            this.method_916(var4);
            throw var4;
         } catch (RemoteException var5) {
            this.method_916(var5);
         }
      }

      // $FF: renamed from: eB () int
      public int method_349() {
         return 0;
      }

      // $FF: renamed from: ew () com.google.android.gms.common.api.Api$c
      public final Api.class_1077<A> method_350() {
         return this.field_52;
      }

      // $FF: renamed from: ey () void
      protected void method_885() {
         super.method_885();
         if(this.field_53 != null) {
            this.field_53.method_352(this);
            this.field_53 = null;
         }

      }

      // $FF: renamed from: m (com.google.android.gms.common.api.Status) void
      public final void method_351(Status var1) {
         boolean var2;
         if(!var1.isSuccess()) {
            var2 = true;
         } else {
            var2 = false;
         }

         class_347.method_2168(var2, "Failed result must not be success");
         this.b(this.c(var1));
      }
   }

   public static class class_1205<R extends Result> extends Handler {
      public class_1205() {
         this(Looper.getMainLooper());
      }

      public class_1205(Looper var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.ResultCallback, com.google.android.gms.common.api.Result) void
      public void method_3452(ResultCallback<R> var1, R var2) {
         this.sendMessage(this.obtainMessage(1, new Pair(var1, var2)));
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.a$a, long) void
      public void method_3453(class_797.class_1207<R> var1, long var2) {
         this.sendMessageDelayed(this.obtainMessage(2, var1), var2);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.ResultCallback, com.google.android.gms.common.api.Result) void
      protected void method_3454(ResultCallback<R> var1, R var2) {
         try {
            var1.onResult(var2);
         } catch (RuntimeException var4) {
            class_797.method_4433(var2);
            throw var4;
         }
      }

      // $FF: renamed from: eC () void
      public void method_3455() {
         this.removeMessages(2);
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            Pair var2 = (Pair)var1.obj;
            this.method_3454((ResultCallback)var2.first, (Result)var2.second);
            return;
         case 2:
            ((class_797.class_1207)var1.obj).method_878();
            return;
         default:
            Log.wtf("GoogleApi", "Don\'t know how to handle this message.");
         }
      }
   }

   public interface class_1206<R> {
      // $FF: renamed from: a (java.lang.Object) void
      void method_673(R var1);
   }
}
