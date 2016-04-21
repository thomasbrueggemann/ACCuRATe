package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.class_1123;
import com.google.android.gms.common.api.class_1124;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.class_1094;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// $FF: renamed from: com.google.android.gms.common.api.b
final class class_1122 implements GoogleApiClient {
    // $FF: renamed from: IH android.os.Looper
    private final Looper field_5168;
    // $FF: renamed from: IU int
    final int field_5169;
    // $FF: renamed from: IV java.util.concurrent.locks.Lock
    private final Lock field_5170 = new ReentrantLock();
    // $FF: renamed from: IW java.util.concurrent.locks.Condition
    private final Condition field_5171;
    // $FF: renamed from: IX com.google.android.gms.common.internal.f
    private final class_1094 field_5172;
    // $FF: renamed from: IY int
    private final int field_5173;
    // $FF: renamed from: IZ java.util.Queue
    final Queue<class_1122.class_1571<?>> field_5174;
    // $FF: renamed from: Iz com.google.android.gms.common.api.b$a
    private final class_1122.class_1569 field_5175;
    // $FF: renamed from: Ja com.google.android.gms.common.ConnectionResult
    private ConnectionResult field_5176;
    // $FF: renamed from: Jb int
    private int field_5177;
    // $FF: renamed from: Jc int
    private volatile int field_5178;
    // $FF: renamed from: Jd int
    private volatile int field_5179;
    // $FF: renamed from: Je boolean
    private boolean field_5180;
    // $FF: renamed from: Jf int
    private int field_5181;
    // $FF: renamed from: Jg long
    private long field_5182;
    // $FF: renamed from: Jh android.os.Handler
    final Handler field_5183;
    // $FF: renamed from: Ji android.os.Bundle
    private final Bundle field_5184;
    // $FF: renamed from: Jj java.util.Map
    private final Map<Api.class_1482<?>, Api.class_1478> field_5185;
    // $FF: renamed from: Jk java.util.List
    private final List<String> field_5186;
    // $FF: renamed from: Jl boolean
    private boolean field_5187;
    // $FF: renamed from: Jm java.util.Set
    private final Set<c<?>> field_5188;
    // $FF: renamed from: Jn java.util.Set
    final Set<class_1122.class_1571<?>> field_5189;
    // $FF: renamed from: Jo com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
    private final GoogleApiClient.ConnectionCallbacks field_5190;
    // $FF: renamed from: Jp com.google.android.gms.common.internal.f$b
    private final class_1094.class_1787 field_5191;

    public class_1122(Context var1, Looper var2, ClientSettings var3, Map<Api<?>, Api.ApiOptions> var4, Set<GoogleApiClient.ConnectionCallbacks> var5, Set<GoogleApiClient.OnConnectionFailedListener> var6, int var7, int var8) {
        this.field_5171 = this.field_5170.newCondition();
        this.field_5174 = new LinkedList();
        this.field_5178 = 4;
        this.field_5180 = false;
        this.field_5182 = 5000L;
        this.field_5184 = new Bundle();
        this.field_5185 = new HashMap();
        this.field_5188 = Collections.newSetFromMap(new WeakHashMap());
        this.field_5189 = Collections.newSetFromMap(new ConcurrentHashMap());
        this.field_5175 = new class_1122.class_1569() {
            // $FF: renamed from: b (com.google.android.gms.common.api.b$c) void
            public void method_380(class_1122.class_1571<?> var1) {
                class_1122.this.field_5189.remove(var1);
            }
        };
        this.field_5190 = new GoogleApiClient.ConnectionCallbacks() {
            public void onConnected(Bundle param1) {
                // $FF: Couldn't be decompiled
            }

            public void onConnectionSuspended(int param1) {
                // $FF: Couldn't be decompiled
            }
        };
        this.field_5191 = new class_1094.class_1787() {
            // $FF: renamed from: fC () android.os.Bundle
            public Bundle method_950() {
                return null;
            }

            // $FF: renamed from: gq () boolean
            public boolean method_951() {
                return class_1122.this.field_5187;
            }

            public boolean isConnected() {
                return class_1122.this.isConnected();
            }
        };
        this.field_5172 = new class_1094(var1, var2, this.field_5191);
        this.field_5168 = var2;
        this.field_5183 = new class_1122.class_1570(var2);
        this.field_5173 = var7;
        this.field_5169 = var8;
        Iterator var9 = var5.iterator();

        while(var9.hasNext()) {
            GoogleApiClient.ConnectionCallbacks var17 = (GoogleApiClient.ConnectionCallbacks)var9.next();
            this.field_5172.registerConnectionCallbacks(var17);
        }

        Iterator var10 = var6.iterator();

        while(var10.hasNext()) {
            GoogleApiClient.OnConnectionFailedListener var16 = (GoogleApiClient.OnConnectionFailedListener)var10.next();
            this.field_5172.registerConnectionFailedListener(var16);
        }

        Iterator var11 = var4.keySet().iterator();

        while(var11.hasNext()) {
            Api var12 = (Api)var11.next();
            final Api.class_1479 var13 = var12.method_3758();
            Object var14 = var4.get(var12);
            this.field_5185.put(var12.method_3760(), method_5797(var13, var14, var1, var2, var3, this.field_5190, new GoogleApiClient.OnConnectionFailedListener() {
                public void onConnectionFailed(ConnectionResult var1) {
                    class_1122.this.field_5170.lock();

                    try {
                        if(class_1122.this.field_5176 == null || var13.getPriority() < class_1122.this.field_5177) {
                            class_1122.this.field_5176 = var1;
                            class_1122.this.field_5177 = var13.getPriority();
                        }

                        class_1122.this.method_5810();
                    } finally {
                        class_1122.this.field_5170.unlock();
                    }

                }
            }));
        }

        this.field_5186 = Collections.unmodifiableList(var3.getScopes());
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.Api$b, java.lang.Object, android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
    private static <C extends Api.class_1478, O> C method_5797(Api.class_1479<C, O> var0, Object var1, Context var2, Looper var3, ClientSettings var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
        return var0.method_373(var2, var3, var4, var1, var5, var6);
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.b$c) void
    private <A extends Api.class_1478> void method_5799(class_1122.class_1571<A> param1) throws DeadObjectException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.b, int) void
    // $FF: synthetic method
    static void method_5800(class_1122 var0, int var1) {
        var0.method_5801(var1);
    }

    // $FF: renamed from: aj (int) void
    private void method_5801(int param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.b) int
    // $FF: synthetic method
    static int method_5802(class_1122 var0) {
        return var0.field_5178;
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.b, int) int
    // $FF: synthetic method
    static int method_5803(class_1122 var0, int var1) {
        var0.field_5179 = var1;
        return var1;
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.b) android.os.Bundle
    // $FF: synthetic method
    static Bundle method_5805(class_1122 var0) {
        return var0.field_5184;
    }

    // $FF: renamed from: e (com.google.android.gms.common.api.b) boolean
    // $FF: synthetic method
    static boolean method_5807(class_1122 var0) {
        return var0.method_5812();
    }

    // $FF: renamed from: f (com.google.android.gms.common.api.b) long
    // $FF: synthetic method
    static long method_5808(class_1122 var0) {
        return var0.field_5182;
    }

    // $FF: renamed from: gm () void
    private void method_5810() {
        this.field_5181 += -1;
        if(this.field_5181 == 0) {
            if(this.field_5176 == null) {
                this.field_5178 = 2;
                this.method_5813();
                this.field_5171.signalAll();
                this.method_5811();
                if(this.field_5180) {
                    this.field_5180 = false;
                    this.method_5801(-1);
                    return;
                }

                Bundle var1;
                if(this.field_5184.isEmpty()) {
                    var1 = null;
                } else {
                    var1 = this.field_5184;
                }

                this.field_5172.method_5707(var1);
                return;
            }

            this.field_5180 = false;
            this.method_5801(3);
            if(this.method_5812()) {
                this.field_5183.sendMessageDelayed(this.field_5183.obtainMessage(1), this.field_5182);
            } else {
                this.field_5172.method_5706(this.field_5176);
            }

            this.field_5187 = false;
        }

    }

    // $FF: renamed from: gn () void
    private void method_5811() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: go () boolean
    private boolean method_5812() {
        return this.field_5179 != 0;
    }

    // $FF: renamed from: gp () void
    private void method_5813() {
        this.field_5170.lock();

        try {
            this.field_5179 = 0;
            this.field_5183.removeMessages(1);
        } finally {
            this.field_5170.unlock();
        }

    }

    // $FF: renamed from: h (com.google.android.gms.common.api.b) int
    // $FF: synthetic method
    static int method_5814(class_1122 var0) {
        int var1 = var0.field_5179;
        var0.field_5179 = var1 - 1;
        return var1;
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.Api$c) com.google.android.gms.common.api.Api$a
    public <C extends Api.class_1478> C method_896(Api.class_1482<C> var1) {
        Api.class_1478 var2 = (Api.class_1478)this.field_5185.get(var1);
        class_1090.method_5681(var2, "Appropriate Api was not requested.");
        return var2;
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$a) com.google.android.gms.common.api.BaseImplementation$a
    public <A extends Api.class_1478, R extends Result, T extends BaseImplementation.class_1146<R, A>> T method_897(T var1) {
        this.field_5170.lock();

        try {
            var1.a(new BaseImplementation.CallbackHandler(this.getLooper()));
            if(this.isConnected()) {
                this.method_899(var1);
            } else {
                this.field_5174.add(var1);
            }
        } finally {
            this.field_5170.unlock();
        }

        return var1;
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.Scope) boolean
    public boolean method_898(Scope var1) {
        return this.field_5186.contains(var1.method_1619());
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$a) com.google.android.gms.common.api.BaseImplementation$a
    public <A extends Api.class_1478, T extends BaseImplementation.class_1146<? extends Result, A>> T method_899(T var1) {
        boolean var2;
        if(!this.isConnected() && !this.method_5812()) {
            var2 = false;
        } else {
            var2 = true;
        }

        class_1090.method_5676(var2, "GoogleApiClient is not connected yet.");
        this.method_5811();

        try {
            this.method_5799(var1);
            return var1;
        } catch (DeadObjectException var4) {
            this.method_5801(1);
            return var1;
        }
    }

    public ConnectionResult blockingConnect() {
        // $FF: Couldn't be decompiled
    }

    public ConnectionResult blockingConnect(long param1, TimeUnit param3) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: c (java.lang.Object) com.google.android.gms.common.api.c
    public <L> c<L> method_900(L var1) {
        class_1090.method_5681(var1, "Listener must not be null");
        this.field_5170.lock();

        class_1123 var3;
        try {
            var3 = new class_1123(this.field_5168, var1);
            this.field_5188.add(var3);
        } finally {
            this.field_5170.unlock();
        }

        return var3;
    }

    public void connect() {
        // $FF: Couldn't be decompiled
    }

    public void disconnect() {
        this.method_5813();
        this.method_5801(-1);
    }

    public Looper getLooper() {
        return this.field_5168;
    }

    public boolean isConnected() {
        return this.field_5178 == 2;
    }

    public boolean isConnecting() {
        return this.field_5178 == 1;
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks var1) {
        return this.field_5172.isConnectionCallbacksRegistered(var1);
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener var1) {
        return this.field_5172.isConnectionFailedListenerRegistered(var1);
    }

    public void reconnect() {
        this.disconnect();
        this.connect();
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
        this.field_5172.registerConnectionCallbacks(var1);
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
        this.field_5172.registerConnectionFailedListener(var1);
    }

    public void stopAutoManage(FragmentActivity var1) {
        boolean var2;
        if(this.field_5173 >= 0) {
            var2 = true;
        } else {
            var2 = false;
        }

        class_1090.method_5676(var2, "Called stopAutoManage but automatic lifecycle management is not enabled.");
        class_1124.method_5820(var1).method_5830(this.field_5173);
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
        this.field_5172.unregisterConnectionCallbacks(var1);
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
        this.field_5172.unregisterConnectionFailedListener(var1);
    }

    interface class_1569 {
        // $FF: renamed from: b (com.google.android.gms.common.api.b$c) void
        void method_380(class_1122.class_1571<?> var1);
    }

    class class_1570 extends Handler {
        class_1570(Looper var2) {
            super(var2);
        }

        public void handleMessage(Message param1) {
            // $FF: Couldn't be decompiled
        }
    }

    interface class_1571<A extends Api.class_1478> {
        // $FF: renamed from: a (com.google.android.gms.common.api.b$a) void
        void method_381(class_1122.class_1569 var1);

        // $FF: renamed from: b (com.google.android.gms.common.api.Api$a) void
        void method_382(A var1) throws DeadObjectException;

        void cancel();

        // $FF: renamed from: ge () com.google.android.gms.common.api.Api$c
        Api.class_1482<A> method_383();

        // $FF: renamed from: gj () int
        int method_384();

        // $FF: renamed from: m (com.google.android.gms.common.api.Status) void
        void method_385(Status var1);
    }
}
