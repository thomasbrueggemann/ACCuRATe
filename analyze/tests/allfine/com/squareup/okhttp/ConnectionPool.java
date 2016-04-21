package com.squareup.okhttp;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.internal.Util;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ConnectionPool {
    private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000L;
    private static final int MAX_CONNECTIONS_TO_CLEANUP = 2;
    private static final ConnectionPool systemDefault;
    private final LinkedList<Connection> connections = new LinkedList();
    private final Callable<Void> connectionsCleanupCallable;
    private final ExecutorService executorService;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    static {
        String var0 = System.getProperty("http.keepAlive");
        String var1 = System.getProperty("http.keepAliveDuration");
        String var2 = System.getProperty("http.maxConnections");
        long var3;
        if(var1 != null) {
            var3 = Long.parseLong(var1);
        } else {
            var3 = 300000L;
        }

        if(var0 != null && !Boolean.parseBoolean(var0)) {
            systemDefault = new ConnectionPool(0, var3);
        } else if(var2 != null) {
            systemDefault = new ConnectionPool(Integer.parseInt(var2), var3);
        } else {
            systemDefault = new ConnectionPool(5, var3);
        }
    }

    public ConnectionPool(int var1, long var2) {
        this.executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.daemonThreadFactory("OkHttp ConnectionPool"));
        this.connectionsCleanupCallable = new Callable() {
            public Void call() throws Exception {
                // $FF: Couldn't be decompiled
            }
        };
        this.maxIdleConnections = var1;
        this.keepAliveDurationNs = 1000L * var2 * 1000L;
    }

    // $FF: synthetic method
    static LinkedList access$000(ConnectionPool var0) {
        return var0.connections;
    }

    // $FF: synthetic method
    static long access$100(ConnectionPool var0) {
        return var0.keepAliveDurationNs;
    }

    // $FF: synthetic method
    static int access$200(ConnectionPool var0) {
        return var0.maxIdleConnections;
    }

    public static ConnectionPool getDefault() {
        return systemDefault;
    }

    private void waitForCleanupCallableToRun() {
        try {
            this.executorService.submit(new Runnable() {
                public void run() {
                }
            }).get();
        } catch (Exception var2) {
            throw new AssertionError();
        }
    }

    public void evictAll() {
        // $FF: Couldn't be decompiled
    }

    public Connection get(Address param1) {
        // $FF: Couldn't be decompiled
    }

    public int getConnectionCount() {
        synchronized(this) {}

        int var2;
        try {
            var2 = this.connections.size();
        } finally {
            ;
        }

        return var2;
    }

    List<Connection> getConnections() {
        // $FF: Couldn't be decompiled
    }

    public int getHttpConnectionCount() {
        // $FF: Couldn't be decompiled
    }

    public int getSpdyConnectionCount() {
        // $FF: Couldn't be decompiled
    }

    public void maybeShare(Connection param1) {
        // $FF: Couldn't be decompiled
    }

    public void recycle(Connection param1) {
        // $FF: Couldn't be decompiled
    }
}
