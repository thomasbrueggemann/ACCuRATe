package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_385;
import com.google.android.gms.internal.class_389;
import com.google.android.gms.internal.ez;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// $FF: renamed from: com.google.android.gms.internal.gi
@ez
public final class class_384 {
    // $FF: renamed from: wh java.util.concurrent.ThreadFactory
    private static final ThreadFactory field_1408 = new ThreadFactory() {
        // $FF: renamed from: wl java.util.concurrent.atomic.AtomicInteger
        private final AtomicInteger field_5286 = new AtomicInteger(1);

        public Thread newThread(Runnable var1) {
            return new Thread(var1, "AdWorker #" + this.field_5286.getAndIncrement());
        }
    };
    // $FF: renamed from: wi java.util.concurrent.ExecutorService
    private static final ExecutorService field_1409;

    static {
        field_1409 = Executors.newFixedThreadPool(10, field_1408);
    }

    // $FF: renamed from: a (java.lang.Runnable) java.util.concurrent.Future
    public static Future<Void> method_2537(final Runnable var0) {
        return submit(new Callable() {
            // $FF: synthetic method
            public Object call() throws Exception {
                return this.method_5936();
            }

            // $FF: renamed from: dj () java.lang.Void
            public Void method_5936() {
                var0.run();
                return null;
            }
        });
    }

    public static <T> Future<T> submit(final Callable<T> var0) {
        try {
            Future var2 = field_1409.submit(new Callable() {
                public T call() throws Exception {
                    try {
                        Process.setThreadPriority(10);
                        Object var2 = var0.call();
                        return var2;
                    } catch (Exception var3) {
                        class_389.method_2561(var3);
                        return null;
                    }
                }
            });
            return var2;
        } catch (RejectedExecutionException var3) {
            class_378.method_2465("Thread execution is rejected.", var3);
            return new class_385((Object)null);
        }
    }
}
