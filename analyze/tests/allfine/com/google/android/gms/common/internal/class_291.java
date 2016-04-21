package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.class_1093;
import com.google.android.gms.common.internal.class_1094;
import com.google.android.gms.common.internal.class_192;
import com.google.android.gms.common.internal.class_195;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.common.internal.e
public abstract class class_291<T extends IInterface> implements Api.class_1478, class_1094.class_1787 {
    // $FF: renamed from: LE java.lang.String[]
    public static final String[] field_880 = new String[] {"service_esmobile", "service_googleme"};
    // $FF: renamed from: Ds java.lang.String[]
    private final String[] field_881;
    // $FF: renamed from: IH android.os.Looper
    private final Looper field_882;
    // $FF: renamed from: IX com.google.android.gms.common.internal.f
    private final class_1094 field_883;
    // $FF: renamed from: LA java.util.ArrayList
    private final ArrayList<com/google/android/gms/common/internal/e<T>.b<?>> field_884;
    // $FF: renamed from: LB com.google.android.gms.common.internal.e$f
    private com/google/android/gms/common/internal/e<T>.f field_885;
    // $FF: renamed from: LC int
    private volatile int field_886;
    // $FF: renamed from: LD boolean
    boolean field_887;
    // $FF: renamed from: Lz android.os.IInterface
    private T field_888;
    private final Context mContext;
    final Handler mHandler;

    protected class_291(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String... var5) {
        this.field_884 = new ArrayList();
        this.field_886 = 1;
        this.field_887 = false;
        this.mContext = (Context)class_1090.method_5685(var1);
        this.field_882 = (Looper)class_1090.method_5681(var2, "Looper must not be null");
        this.field_883 = new class_1094(var1, var2, this);
        this.mHandler = new class_291.class_1746(var2);
        this.method_1816(var5);
        this.field_881 = var5;
        this.registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)class_1090.method_5685(var3));
        this.registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)class_1090.method_5685(var4));
    }

    @Deprecated
    protected class_291(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3, String... var4) {
        this(var1, var1.getMainLooper(), new class_291.class_1748(var2), new class_291.class_1752(var3), var4);
    }

    // $FF: renamed from: az (int) void
    private void method_1806(int var1) {
        int var2 = this.field_886;
        this.field_886 = var1;
        if(var2 != var1) {
            if(var1 == 3) {
                this.onConnected();
            } else if(var2 == 3 && var1 == 1) {
                this.onDisconnected();
                return;
            }
        }

    }

    // $FF: renamed from: b (com.google.android.gms.common.internal.e) java.util.ArrayList
    // $FF: synthetic method
    static ArrayList method_1807(class_291 var0) {
        return var0.field_884;
    }

    // $FF: renamed from: N (android.os.IBinder) void
    protected final void method_1811(IBinder var1) {
        try {
            this.method_1814(class_192.class_1632.method_5947(var1), new class_291.class_1750(this));
        } catch (RemoteException var3) {
            Log.w("GmsClient", "service died");
        }
    }

    // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
    protected void method_1812(int var1, IBinder var2, Bundle var3) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new class_291.class_1753(var1, var2, var3)));
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.e$b) void
    @Deprecated
    public final void method_1813(com/google/android/gms/common/internal/e<T>.b<?> param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected abstract void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException;

    // $FF: renamed from: aA (int) void
    public void method_1815(int var1) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(var1)));
    }

    // $FF: renamed from: c (java.lang.String[]) void
    protected void method_1816(String... var1) {
    }

    public void connect() {
        this.field_887 = true;
        this.method_1806(2);
        int var1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if(var1 != 0) {
            this.method_1806(1);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(var1)));
        } else {
            if(this.field_885 != null) {
                Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
                this.field_888 = null;
                class_1093.method_5699(this.mContext).method_5702(this.getStartServiceAction(), this.field_885);
            }

            this.field_885 = new class_291.class_1751();
            if(!class_1093.method_5699(this.mContext).method_5701(this.getStartServiceAction(), this.field_885)) {
                Log.e("GmsClient", "unable to connect to service: " + this.getStartServiceAction());
                this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
                return;
            }
        }

    }

    // $FF: renamed from: dJ () void
    protected final void method_1817() {
        if(!this.isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void disconnect() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: fC () android.os.Bundle
    public Bundle method_950() {
        return null;
    }

    // $FF: renamed from: gR () java.lang.String[]
    public final String[] method_1818() {
        return this.field_881;
    }

    // $FF: renamed from: gS () android.os.IInterface
    public final T method_1819() {
        this.method_1817();
        return this.field_888;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.field_882;
    }

    protected abstract String getServiceDescriptor();

    protected abstract String getStartServiceAction();

    // $FF: renamed from: gq () boolean
    public boolean method_951() {
        return this.field_887;
    }

    public boolean isConnected() {
        return this.field_886 == 3;
    }

    public boolean isConnecting() {
        return this.field_886 == 2;
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks var1) {
        return this.field_883.isConnectionCallbacksRegistered(new class_291.class_1748(var1));
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener var1) {
        return this.field_883.isConnectionFailedListenerRegistered(var1);
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    protected abstract T method_1820(IBinder var1);

    protected void onConnected() {
    }

    protected void onDisconnected() {
    }

    @Deprecated
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
        this.field_883.registerConnectionCallbacks(new class_291.class_1748(var1));
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
        this.field_883.registerConnectionCallbacks(var1);
    }

    @Deprecated
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
        this.field_883.registerConnectionFailedListener(var1);
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
        this.field_883.registerConnectionFailedListener(var1);
    }

    @Deprecated
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
        this.field_883.unregisterConnectionCallbacks(new class_291.class_1748(var1));
    }

    @Deprecated
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
        this.field_883.unregisterConnectionFailedListener(var1);
    }

    final class class_1746 extends Handler {
        public class_1746(Looper var2) {
            super(var2);
        }

        public void handleMessage(Message var1) {
            if(var1.what == 1 && !class_291.this.isConnecting()) {
                class_291.class_1747 var5 = (class_291.class_1747)var1.obj;
                var5.method_2916();
                var5.unregister();
            } else if(var1.what == 3) {
                class_291.this.field_883.method_5706(new ConnectionResult(((Integer)var1.obj).intValue(), (PendingIntent)null));
            } else if(var1.what == 4) {
                class_291.this.method_1806(1);
                class_291.this.field_888 = null;
                class_291.this.field_883.method_5705(((Integer)var1.obj).intValue());
            } else if(var1.what == 2 && !class_291.this.isConnected()) {
                class_291.class_1747 var3 = (class_291.class_1747)var1.obj;
                var3.method_2916();
                var3.unregister();
            } else if(var1.what != 2 && var1.what != 1) {
                Log.wtf("GmsClient", "Don\'t know how to handle this message.");
            } else {
                ((class_291.class_1747)var1.obj).method_2917();
            }
        }
    }

    protected abstract class class_1747<TListener> {
        // $FF: renamed from: LG boolean
        private boolean field_1849;
        private TListener mListener;

        public class_1747(TListener var1) {
            this.mListener = var2;
            this.field_1849 = false;
        }

        // $FF: renamed from: g (java.lang.Object) void
        protected abstract void method_2915(TListener var1);

        // $FF: renamed from: gT () void
        protected abstract void method_2916();

        // $FF: renamed from: gU () void
        public void method_2917() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: gV () void
        public void method_2918() {
            // $FF: Couldn't be decompiled
        }

        public void unregister() {
            // $FF: Couldn't be decompiled
        }
    }

    public static final class class_1748 implements GoogleApiClient.ConnectionCallbacks {
        // $FF: renamed from: LH com.google.android.gms.common.GooglePlayServicesClient$ConnectionCallbacks
        private final GooglePlayServicesClient.ConnectionCallbacks field_5352;

        public class_1748(GooglePlayServicesClient.ConnectionCallbacks var1) {
            this.field_5352 = var1;
        }

        public boolean equals(Object var1) {
            return var1 instanceof class_291.class_1748?this.field_5352.equals(((class_291.class_1748)var1).field_5352):this.field_5352.equals(var1);
        }

        public void onConnected(Bundle var1) {
            this.field_5352.onConnected(var1);
        }

        public void onConnectionSuspended(int var1) {
            this.field_5352.onDisconnected();
        }
    }

    public abstract class class_1749<TListener> extends com/google/android/gms/common/internal/e<T>.b<TListener> {
        // $FF: renamed from: II com.google.android.gms.common.data.DataHolder
        private final DataHolder field_1885;

        public class_1749(TListener var1, DataHolder var2) {
            super();
            this.field_1885 = var3;
        }

        // $FF: renamed from: a (java.lang.Object, com.google.android.gms.common.data.DataHolder) void
        protected abstract void method_2937(TListener var1, DataHolder var2);

        // $FF: renamed from: g (java.lang.Object) void
        protected final void method_2915(TListener var1) {
            this.method_2937(var1, this.field_1885);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
            if(this.field_1885 != null) {
                this.field_1885.close();
            }

        }
    }

    public static final class class_1750 extends class_195.class_1625 {
        // $FF: renamed from: LI com.google.android.gms.common.internal.e
        private class_291 field_5077;

        public class_1750(class_291 var1) {
            this.field_5077 = var1;
        }

        // $FF: renamed from: b (int, android.os.IBinder, android.os.Bundle) void
        public void method_997(int var1, IBinder var2, Bundle var3) {
            class_1090.method_5681("onPostInitComplete can be called only once per call to getServiceFromBroker", this.field_5077);
            this.field_5077.method_1812(var1, var2, var3);
            this.field_5077 = null;
        }
    }

    final class class_1751 implements ServiceConnection {
        public void onServiceConnected(ComponentName var1, IBinder var2) {
            class_291.this.method_1811(var2);
        }

        public void onServiceDisconnected(ComponentName var1) {
            class_291.this.mHandler.sendMessage(class_291.this.mHandler.obtainMessage(4, Integer.valueOf(1)));
        }
    }

    public static final class class_1752 implements GoogleApiClient.OnConnectionFailedListener {
        // $FF: renamed from: LJ com.google.android.gms.common.GooglePlayServicesClient$OnConnectionFailedListener
        private final GooglePlayServicesClient.OnConnectionFailedListener field_5354;

        public class_1752(GooglePlayServicesClient.OnConnectionFailedListener var1) {
            this.field_5354 = var1;
        }

        public boolean equals(Object var1) {
            return var1 instanceof class_291.class_1752?this.field_5354.equals(((class_291.class_1752)var1).field_5354):this.field_5354.equals(var1);
        }

        public void onConnectionFailed(ConnectionResult var1) {
            this.field_5354.onConnectionFailed(var1);
        }
    }

    protected final class class_1753 extends com/google/android/gms/common/internal/e<T>.b<Boolean> {
        // $FF: renamed from: LK android.os.Bundle
        public final Bundle field_1851;
        // $FF: renamed from: LL android.os.IBinder
        public final IBinder field_1852;
        public final int statusCode;

        public class_1753(int var2, IBinder var3, Bundle var4) {
            super();
            this.statusCode = var2;
            this.field_1852 = var3;
            this.field_1851 = var4;
        }

        // $FF: renamed from: b (java.lang.Boolean) void
        protected void method_2919(Boolean var1) {
            if(var1 == null) {
                class_291.this.method_1806(1);
            } else {
                switch(this.statusCode) {
                    case 0:
                        try {
                            String var5 = this.field_1852.getInterfaceDescriptor();
                            if(class_291.this.getServiceDescriptor().equals(var5)) {
                                class_291.this.field_888 = class_291.this.method_1820(this.field_1852);
                                if(class_291.this.field_888 != null) {
                                    class_291.this.method_1806(3);
                                    class_291.this.field_883.method_5708();
                                    return;
                                }
                            }
                        } catch (RemoteException var8) {
                            ;
                        }

                        class_1093.method_5699(class_291.this.mContext).method_5702(class_291.this.getStartServiceAction(), class_291.this.field_885);
                        class_291.this.field_885 = null;
                        class_291.this.method_1806(1);
                        class_291.this.field_888 = null;
                        class_291.this.field_883.method_5706(new ConnectionResult(8, (PendingIntent)null));
                        return;
                    case 10:
                        class_291.this.method_1806(1);
                        throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                    default:
                        PendingIntent var7;
                        if(this.field_1851 != null) {
                            var7 = (PendingIntent)this.field_1851.getParcelable("pendingIntent");
                        } else {
                            var7 = null;
                        }

                        if(class_291.this.field_885 != null) {
                            class_1093.method_5699(class_291.this.mContext).method_5702(class_291.this.getStartServiceAction(), class_291.this.field_885);
                            class_291.this.field_885 = null;
                        }

                        class_291.this.method_1806(1);
                        class_291.this.field_888 = null;
                        class_291.this.field_883.method_5706(new ConnectionResult(this.statusCode, var7));
                }
            }
        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        protected void method_2915(Object var1) {
            this.method_2919((Boolean)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }
}
