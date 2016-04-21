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
import com.google.android.gms.common.api.class_1122;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.class_194;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BaseImplementation {
    // $FF: renamed from: a (com.google.android.gms.common.api.Result) void
    static void method_1540(Result var0) {
        if(var0 instanceof Releasable) {
            try {
                ((Releasable)var0).release();
            } catch (RuntimeException var2) {
                Log.w("GoogleApi", "Unable to release " + var0, var2);
                return;
            }
        }

    }

    public abstract static class AbstractPendingResult<R extends Result> implements BaseImplementation.class_1147<R>, PendingResult<R> {
        // $FF: renamed from: Ir java.lang.Object
        private final Object field_60 = new Object();
        // $FF: renamed from: Is java.util.ArrayList
        private final ArrayList<PendingResult.class_1778> field_61 = new ArrayList();
        // $FF: renamed from: It com.google.android.gms.common.api.ResultCallback
        private ResultCallback<R> field_62;
        // $FF: renamed from: Iu com.google.android.gms.common.api.Result
        private volatile R field_63;
        // $FF: renamed from: Iv boolean
        private volatile boolean field_64;
        // $FF: renamed from: Iw boolean
        private boolean field_65;
        // $FF: renamed from: Ix boolean
        private boolean field_66;
        // $FF: renamed from: Iy com.google.android.gms.common.internal.j
        private class_194 field_67;
        protected BaseImplementation.CallbackHandler<R> mHandler;
        // $FF: renamed from: mg java.util.concurrent.CountDownLatch
        private final CountDownLatch field_68 = new CountDownLatch(1);

        AbstractPendingResult() {
        }

        public AbstractPendingResult(Looper var1) {
            this.mHandler = new BaseImplementation.CallbackHandler(var1);
        }

        public AbstractPendingResult(BaseImplementation.CallbackHandler<R> var1) {
            this.mHandler = var1;
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Result) void
        private void method_1097(R var1) {
            this.field_63 = var1;
            this.field_67 = null;
            this.field_68.countDown();
            Status var2 = this.field_63.getStatus();
            if(this.field_62 != null) {
                this.mHandler.removeTimeoutMessages();
                if(!this.field_65) {
                    this.mHandler.sendResultCallback(this.field_62, this.method_1098());
                }
            }

            Iterator var3 = this.field_61.iterator();

            while(var3.hasNext()) {
                ((PendingResult.class_1778)var3.next()).method_895(var2);
            }

            this.field_61.clear();
        }

        // $FF: renamed from: gf () com.google.android.gms.common.api.Result
        private R method_1098() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: gh () void
        private void method_1099() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: gi () void
        private void method_1100() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$CallbackHandler) void
        protected void method_1101(BaseImplementation.CallbackHandler<R> var1) {
            this.mHandler = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.common.api.PendingResult$a) void
        public final void method_877(PendingResult.class_1778 param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.common.internal.j) void
        protected final void method_1102(class_194 param1) {
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

            class_1090.method_5676(var2, "await must not be called on the UI thread");
            if(this.field_64) {
                var1 = false;
            }

            class_1090.method_5676(var1, "Result has already been consumed");

            try {
                this.field_68.await();
            } catch (InterruptedException var4) {
                this.method_1099();
            }

            class_1090.method_5676(this.isReady(), "Result is not ready.");
            return this.method_1098();
        }

        public final R await(long var1, TimeUnit var3) {
            boolean var4 = true;
            boolean var5;
            if(var1 > 0L && Looper.myLooper() == Looper.getMainLooper()) {
                var5 = false;
            } else {
                var5 = var4;
            }

            class_1090.method_5676(var5, "await must not be called on the UI thread when time is greater than zero.");
            if(this.field_64) {
                var4 = false;
            }

            class_1090.method_5676(var4, "Result has already been consumed.");

            try {
                if(!this.field_68.await(var1, var3)) {
                    this.method_1100();
                }
            } catch (InterruptedException var7) {
                this.method_1099();
            }

            class_1090.method_5676(this.isReady(), "Result is not ready.");
            return this.method_1098();
        }

        // $FF: renamed from: b (com.google.android.gms.common.api.Result) void
        public final void method_1103(R param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        protected abstract R method_1104(Status var1);

        public void cancel() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: gg () void
        protected void method_1105() {
            this.field_64 = true;
            this.field_63 = null;
            this.field_62 = null;
        }

        public boolean isCanceled() {
            // $FF: Couldn't be decompiled
        }

        public final boolean isReady() {
            return this.field_68.getCount() == 0L;
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
                BaseImplementation.method_1540(var2);
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
                    ((BaseImplementation.AbstractPendingResult)var1.obj).method_1100();
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

    public abstract static class class_1146<R extends Result, A extends Api.class_1478> extends BaseImplementation.AbstractPendingResult<R> implements class_1122.class_1571<A> {
        // $FF: renamed from: Ip com.google.android.gms.common.api.Api$c
        private final Api.class_1482<A> field_76;
        // $FF: renamed from: Iz com.google.android.gms.common.api.b$a
        private class_1122.class_1569 field_77;

        protected class_1146(Api.class_1482<A> var1) {
            this.field_76 = (Api.class_1482)class_1090.method_5685(var1);
        }

        // $FF: renamed from: a (android.os.RemoteException) void
        private void method_1136(RemoteException var1) {
            this.method_385(new Status(8, var1.getLocalizedMessage(), (PendingIntent)null));
        }

        // $FF: renamed from: a (com.google.android.gms.common.api.Api$a) void
        protected abstract void method_1137(A var1) throws RemoteException;

        // $FF: renamed from: a (com.google.android.gms.common.api.b$a) void
        public void method_381(class_1122.class_1569 var1) {
            this.field_77 = var1;
        }

        // $FF: renamed from: b (com.google.android.gms.common.api.Api$a) void
        public final void method_382(A var1) throws DeadObjectException {
            if(this.mHandler == null) {
                this.a(new BaseImplementation.CallbackHandler(var1.getLooper()));
            }

            try {
                this.method_1137(var1);
            } catch (DeadObjectException var4) {
                this.method_1136(var4);
                throw var4;
            } catch (RemoteException var5) {
                this.method_1136(var5);
            }
        }

        // $FF: renamed from: ge () com.google.android.gms.common.api.Api$c
        public final Api.class_1482<A> method_383() {
            return this.field_76;
        }

        // $FF: renamed from: gg () void
        protected void method_1105() {
            super.method_1105();
            if(this.field_77 != null) {
                this.field_77.method_380(this);
                this.field_77 = null;
            }

        }

        // $FF: renamed from: gj () int
        public int method_384() {
            return 0;
        }

        // $FF: renamed from: m (com.google.android.gms.common.api.Status) void
        public final void method_385(Status var1) {
            boolean var2;
            if(!var1.isSuccess()) {
                var2 = true;
            } else {
                var2 = false;
            }

            class_1090.method_5683(var2, "Failed result must not be success");
            this.b(this.c(var1));
        }
    }

    public interface class_1147<R> {
        // $FF: renamed from: b (java.lang.Object) void
        void method_120(R var1);
    }
}
