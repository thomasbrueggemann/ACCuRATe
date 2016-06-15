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
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_1032;
import com.google.android.gms.internal.class_21;
import com.google.android.gms.internal.class_335;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BaseImplementation {
   // $FF: renamed from: a (com.google.android.gms.common.api.Result) void
   static void method_1546(Result var0) {
      if(var0 instanceof Releasable) {
         try {
            ((Releasable)var0).release();
         } catch (RuntimeException var2) {
            Log.w("GoogleApi", "Unable to release " + var0, var2);
            return;
         }
      }

   }

   public abstract static class AbstractPendingResult<R extends Result> implements BaseImplementation.class_1058<R>, PendingResult<R> {
      // $FF: renamed from: Jp java.lang.Object
      private final Object field_65 = new Object();
      // $FF: renamed from: Jq java.util.ArrayList
      private final ArrayList<PendingResult.class_1650> field_66 = new ArrayList();
      // $FF: renamed from: Jr com.google.android.gms.common.api.ResultCallback
      private ResultCallback<R> field_67;
      // $FF: renamed from: Js com.google.android.gms.common.api.Result
      private volatile R field_68;
      // $FF: renamed from: Jt boolean
      private volatile boolean field_69;
      // $FF: renamed from: Ju boolean
      private boolean field_70;
      // $FF: renamed from: Jv boolean
      private boolean field_71;
      // $FF: renamed from: Jw com.google.android.gms.internal.jr
      private class_21 field_72;
      protected final BaseImplementation.CallbackHandler<R> mHandler;
      // $FF: renamed from: mr java.util.concurrent.CountDownLatch
      private final CountDownLatch field_73 = new CountDownLatch(1);

      protected AbstractPendingResult(Looper var1) {
         this.mHandler = new BaseImplementation.CallbackHandler(var1);
      }

      protected AbstractPendingResult(BaseImplementation.CallbackHandler<R> var1) {
         this.mHandler = var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Result) void
      private void method_1103(R var1) {
         this.field_68 = var1;
         this.field_72 = null;
         this.field_73.countDown();
         Status var2 = this.field_68.getStatus();
         if(this.field_67 != null) {
            this.mHandler.removeTimeoutMessages();
            if(!this.field_70) {
               this.mHandler.sendResultCallback(this.field_67, this.method_1104());
            }
         }

         Iterator var3 = this.field_66.iterator();

         while(var3.hasNext()) {
            ((PendingResult.class_1650)var3.next()).method_940(var2);
         }

         this.field_66.clear();
      }

      // $FF: renamed from: gA () com.google.android.gms.common.api.Result
      private R method_1104() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: gC () void
      private void method_1105() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: gD () void
      private void method_1106() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.PendingResult$a) void
      public final void method_919(PendingResult.class_1650 param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.jr) void
      protected final void method_1107(class_21 param1) {
         // $FF: Couldn't be decompiled
      }

      public final R await() {
         boolean var1 = true;
         boolean var2;
         if(Looper.myLooper() != Looper.getMainLooper()) {
            var2 = var1;
         } else {
            var2 = false;
         }

         class_335.method_2302(var2, "await must not be called on the UI thread");
         if(this.field_69) {
            var1 = false;
         }

         class_335.method_2302(var1, "Result has already been consumed");

         try {
            this.field_73.await();
         } catch (InterruptedException var4) {
            this.method_1105();
         }

         class_335.method_2302(this.isReady(), "Result is not ready.");
         return this.method_1104();
      }

      public final R await(long var1, TimeUnit var3) {
         boolean var4 = true;
         boolean var5;
         if(var1 > 0L && Looper.myLooper() == Looper.getMainLooper()) {
            var5 = false;
         } else {
            var5 = var4;
         }

         class_335.method_2302(var5, "await must not be called on the UI thread when time is greater than zero.");
         if(this.field_69) {
            var4 = false;
         }

         class_335.method_2302(var4, "Result has already been consumed.");

         try {
            if(!this.field_73.await(var1, var3)) {
               this.method_1106();
            }
         } catch (InterruptedException var7) {
            this.method_1105();
         }

         class_335.method_2302(this.isReady(), "Result is not ready.");
         return this.method_1104();
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Result) void
      public final void method_1108(R param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      protected abstract R method_1109(Status var1);

      public void cancel() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: gB () void
      protected void method_1110() {
         this.field_69 = true;
         this.field_68 = null;
         this.field_67 = null;
      }

      public boolean isCanceled() {
         // $FF: Couldn't be decompiled
      }

      public final boolean isReady() {
         return this.field_73.getCount() == 0L;
      }

      public final void setResultCallback(ResultCallback<R> param1) {
         // $FF: Couldn't be decompiled
      }

      public final void setResultCallback(ResultCallback<R> param1, long param2, TimeUnit param4) {
         // $FF: Couldn't be decompiled
      }
   }

   public static class CallbackHandler<R extends Result> extends Handler {
      public static final int CALLBACK_ON_COMPLETE = 1;
      public static final int CALLBACK_ON_TIMEOUT = 2;

      public CallbackHandler() {
         this(Looper.getMainLooper());
      }

      public CallbackHandler(Looper var1) {
         super(var1);
      }

      protected void deliverResultCallback(ResultCallback<R> var1, R var2) {
         try {
            var1.onResult(var2);
         } catch (RuntimeException var4) {
            BaseImplementation.method_1546(var2);
            throw var4;
         }
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            Pair var2 = (Pair)var1.obj;
            this.deliverResultCallback((ResultCallback)var2.first, (Result)var2.second);
            return;
         case 2:
            ((BaseImplementation.AbstractPendingResult)var1.obj).method_1106();
            return;
         default:
            Log.wtf("GoogleApi", "Don\'t know how to handle this message.");
         }
      }

      public void removeTimeoutMessages() {
         this.removeMessages(2);
      }

      public void sendResultCallback(ResultCallback<R> var1, R var2) {
         this.sendMessage(this.obtainMessage(1, new Pair(var1, var2)));
      }

      public void sendTimeoutResultCallback(BaseImplementation.AbstractPendingResult<R> var1, long var2) {
         this.sendMessageDelayed(this.obtainMessage(2, var1), var2);
      }
   }

   public abstract static class class_1057<R extends Result, A extends Api.class_1390> extends BaseImplementation.AbstractPendingResult<R> implements class_1032.class_1141<A> {
      // $FF: renamed from: Jn com.google.android.gms.common.api.Api$c
      private final Api.class_1394<A> field_81;
      // $FF: renamed from: Jx com.google.android.gms.common.api.GoogleApiClient
      private final GoogleApiClient field_82;
      // $FF: renamed from: Jy com.google.android.gms.common.api.c$b
      private class_1032.class_1139 field_83;

      protected class_1057(Api.class_1394<A> var1, GoogleApiClient var2) {
         super(var2.getLooper());
         this.field_81 = (Api.class_1394)class_335.method_2311(var1);
         this.field_82 = var2;
      }

      // $FF: renamed from: a (android.os.RemoteException) void
      private void method_1142(RemoteException var1) {
         this.method_393(new Status(8, var1.getLocalizedMessage(), (PendingIntent)null));
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Api$a) void
      protected abstract void method_1143(A var1) throws RemoteException;

      // $FF: renamed from: a (com.google.android.gms.common.api.c$b) void
      public void method_389(class_1032.class_1139 var1) {
         this.field_83 = var1;
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Api$a) void
      public final void method_390(A var1) throws DeadObjectException {
         try {
            this.method_1143(var1);
         } catch (DeadObjectException var4) {
            this.method_1142(var4);
            throw var4;
         } catch (RemoteException var5) {
            this.method_1142(var5);
         }
      }

      // $FF: renamed from: gB () void
      protected void method_1110() {
         super.method_1110();
         if(this.field_83 != null) {
            this.field_83.method_394(this);
            this.field_83 = null;
         }

      }

      // $FF: renamed from: gE () com.google.android.gms.common.api.BaseImplementation$a
      public final BaseImplementation.class_1057 method_1144() {
         class_335.method_2306(this.field_82, "GoogleApiClient was not set.");
         this.field_82.method_944(this);
         return this;
      }

      // $FF: renamed from: gF () int
      public int method_391() {
         return 0;
      }

      // $FF: renamed from: gz () com.google.android.gms.common.api.Api$c
      public final Api.class_1394<A> method_392() {
         return this.field_81;
      }

      // $FF: renamed from: l (com.google.android.gms.common.api.Status) void
      public final void method_393(Status var1) {
         boolean var2;
         if(!var1.isSuccess()) {
            var2 = true;
         } else {
            var2 = false;
         }

         class_335.method_2308(var2, "Failed result must not be success");
         this.b(this.c(var1));
      }
   }

   public interface class_1058<R> {
      // $FF: renamed from: b (java.lang.Object) void
      void method_110(R var1);
   }
}
