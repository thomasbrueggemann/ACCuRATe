package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.class_192;
import com.google.android.gms.common.internal.class_291;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.internal.class_16;
import com.google.android.gms.internal.class_17;
import com.google.android.gms.internal.class_332;
import com.google.android.gms.internal.class_333;
import com.google.android.gms.internal.class_334;
import com.google.android.gms.internal.class_338;
import com.google.android.gms.internal.in;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

// $FF: renamed from: com.google.android.gms.internal.ij
public final class class_304 extends e<in> {
    // $FF: renamed from: GL java.lang.Object
    private static final Object field_913 = new Object();
    // $FF: renamed from: GM java.lang.Object
    private static final Object field_914 = new Object();
    // $FF: renamed from: Gr com.google.android.gms.internal.ip
    private static final class_332 field_915 = new class_332("CastClientImpl");
    // $FF: renamed from: EO com.google.android.gms.cast.Cast$Listener
    private final Cast.Listener field_916;
    // $FF: renamed from: FA double
    private double field_917;
    // $FF: renamed from: FB boolean
    private boolean field_918;
    // $FF: renamed from: GA boolean
    private boolean field_919;
    // $FF: renamed from: GB int
    private int field_920;
    // $FF: renamed from: GC int
    private int field_921;
    // $FF: renamed from: GD java.util.concurrent.atomic.AtomicLong
    private final AtomicLong field_922;
    // $FF: renamed from: GE java.lang.String
    private String field_923;
    // $FF: renamed from: GF java.lang.String
    private String field_924;
    // $FF: renamed from: GG android.os.Bundle
    private Bundle field_925;
    // $FF: renamed from: GH java.util.Map
    private Map<Long, BaseImplementation.class_1147<Status>> field_926;
    // $FF: renamed from: GI com.google.android.gms.internal.ij$b
    private class_304.class_1710 field_927;
    // $FF: renamed from: GJ com.google.android.gms.common.api.BaseImplementation$b
    private BaseImplementation.class_1147<Cast.ApplicationConnectionResult> field_928;
    // $FF: renamed from: GK com.google.android.gms.common.api.BaseImplementation$b
    private BaseImplementation.class_1147<Status> field_929;
    // $FF: renamed from: Gs com.google.android.gms.cast.ApplicationMetadata
    private ApplicationMetadata field_930;
    // $FF: renamed from: Gt com.google.android.gms.cast.CastDevice
    private final CastDevice field_931;
    // $FF: renamed from: Gu java.util.Map
    private final Map<String, Cast.MessageReceivedCallback> field_932;
    // $FF: renamed from: Gv long
    private final long field_933;
    // $FF: renamed from: Gw com.google.android.gms.internal.ij$c
    private class_304.class_1243 field_934;
    // $FF: renamed from: Gx java.lang.String
    private String field_935;
    // $FF: renamed from: Gy boolean
    private boolean field_936;
    // $FF: renamed from: Gz boolean
    private boolean field_937;
    private final Handler mHandler;

    public class_304(Context var1, Looper var2, CastDevice var3, long var4, Cast.Listener var6, GoogleApiClient.ConnectionCallbacks var7, GoogleApiClient.OnConnectionFailedListener var8) {
        super(var1, var2, var7, var8, (String[])null);
        this.field_931 = var3;
        this.field_916 = var6;
        this.field_933 = var4;
        this.mHandler = new Handler(var2);
        this.field_932 = new HashMap();
        this.field_922 = new AtomicLong(0L);
        this.field_926 = new HashMap();
        this.method_2063();
        this.field_927 = new class_304.class_1710();
        this.registerConnectionFailedListener(this.field_927);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ij, com.google.android.gms.cast.ApplicationMetadata) com.google.android.gms.cast.ApplicationMetadata
    // $FF: synthetic method
    static ApplicationMetadata method_2047(class_304 var0, ApplicationMetadata var1) {
        var0.field_930 = var1;
        return var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ij, com.google.android.gms.common.api.BaseImplementation$b) com.google.android.gms.common.api.BaseImplementation$b
    // $FF: synthetic method
    static BaseImplementation.class_1147 method_2048(class_304 var0, BaseImplementation.class_1147 var1) {
        var0.field_928 = var1;
        return var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ig) void
    private void method_2050(class_338 var1) {
        String var2 = var1.method_2312();
        boolean var3;
        if(!class_334.method_2300(var2, this.field_935)) {
            this.field_935 = var2;
            var3 = true;
        } else {
            var3 = false;
        }

        class_332 var4 = field_915;
        Object[] var5 = new Object[] {Boolean.valueOf(var3), Boolean.valueOf(this.field_936)};
        var4.method_2284("hasChanged=%b, mFirstApplicationStatusUpdate=%b", var5);
        if(this.field_916 != null && (var3 || this.field_936)) {
            this.field_916.onApplicationStatusChanged();
        }

        this.field_936 = false;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.il) void
    private void method_2053(class_333 var1) {
        this.field_930 = var1.getApplicationMetadata();
        double var2 = var1.method_2296();
        boolean var4;
        if(var2 != Double.NaN && var2 != this.field_917) {
            this.field_917 = var2;
            var4 = true;
        } else {
            var4 = false;
        }

        boolean var5 = var1.method_2297();
        if(var5 != this.field_918) {
            this.field_918 = var5;
            var4 = true;
        }

        class_332 var6 = field_915;
        Object[] var7 = new Object[] {Boolean.valueOf(var4), Boolean.valueOf(this.field_937)};
        var6.method_2284("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", var7);
        if(this.field_916 != null && (var4 || this.field_937)) {
            this.field_916.onVolumeChanged();
        }

        int var8 = var1.method_2298();
        boolean var9;
        if(var8 != this.field_920) {
            this.field_920 = var8;
            var9 = true;
        } else {
            var9 = false;
        }

        class_332 var10 = field_915;
        Object[] var11 = new Object[] {Boolean.valueOf(var9), Boolean.valueOf(this.field_937)};
        var10.method_2284("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", var11);
        if(this.field_916 != null && (var9 || this.field_937)) {
            this.field_916.method_4108(this.field_920);
        }

        int var12 = var1.method_2299();
        boolean var13;
        if(var12 != this.field_921) {
            this.field_921 = var12;
            var13 = true;
        } else {
            var13 = false;
        }

        class_332 var14 = field_915;
        Object[] var15 = new Object[] {Boolean.valueOf(var13), Boolean.valueOf(this.field_937)};
        var14.method_2284("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", var15);
        if(this.field_916 != null && (var13 || this.field_937)) {
            this.field_916.method_4109(this.field_921);
        }

        this.field_937 = false;
    }

    // $FF: renamed from: b (com.google.android.gms.internal.ij, com.google.android.gms.common.api.BaseImplementation$b) com.google.android.gms.common.api.BaseImplementation$b
    // $FF: synthetic method
    static BaseImplementation.class_1147 method_2054(class_304 var0, BaseImplementation.class_1147 var1) {
        var0.field_929 = var1;
        return var1;
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b) void
    private void method_2057(BaseImplementation.class_1147<Cast.ApplicationConnectionResult> param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: d (com.google.android.gms.internal.ij) com.google.android.gms.common.api.BaseImplementation$b
    // $FF: synthetic method
    static BaseImplementation.class_1147 method_2059(class_304 var0) {
        return var0.field_928;
    }

    // $FF: renamed from: e (com.google.android.gms.common.api.BaseImplementation$b) void
    private void method_2061(BaseImplementation.class_1147<Status> param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: fB () void
    private void method_2063() {
        this.field_919 = false;
        this.field_920 = -1;
        this.field_921 = -1;
        this.field_930 = null;
        this.field_935 = null;
        this.field_917 = 0.0D;
        this.field_918 = false;
    }

    // $FF: renamed from: fF () void
    private void method_2064() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: fG () void
    private void method_2065() throws IllegalStateException {
        if(!this.field_919 || this.field_934 == null || this.field_934.method_4980()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    // $FF: renamed from: fI () java.lang.Object
    // $FF: synthetic method
    static Object method_2067() {
        return field_913;
    }

    // $FF: renamed from: fJ () java.lang.Object
    // $FF: synthetic method
    static Object method_2068() {
        return field_914;
    }

    // $FF: renamed from: g (com.google.android.gms.internal.ij) java.util.Map
    // $FF: synthetic method
    static Map method_2069(class_304 var0) {
        return var0.field_932;
    }

    // $FF: renamed from: h (com.google.android.gms.internal.ij) com.google.android.gms.cast.CastDevice
    // $FF: synthetic method
    static CastDevice method_2070(class_304 var0) {
        return var0.field_931;
    }

    // $FF: renamed from: i (com.google.android.gms.internal.ij) java.util.Map
    // $FF: synthetic method
    static Map method_2071(class_304 var0) {
        return var0.field_926;
    }

    // $FF: renamed from: j (com.google.android.gms.internal.ij) com.google.android.gms.common.api.BaseImplementation$b
    // $FF: synthetic method
    static BaseImplementation.class_1147 method_2072(class_304 var0) {
        return var0.field_929;
    }

    // $FF: renamed from: G (boolean) void
    public void method_2073(boolean var1) throws IllegalStateException, RemoteException {
        ((class_16)this.gS()).method_100(var1, this.field_917, this.field_918);
    }

    // $FF: renamed from: L (android.os.IBinder) com.google.android.gms.internal.in
    protected class_16 method_2074(IBinder var1) {
        return class_16.class_1406.method_4409(var1);
    }

    // $FF: renamed from: a (double) void
    public void method_2075(double var1) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if(!Double.isInfinite(var1) && !Double.isNaN(var1)) {
            ((class_16)this.gS()).method_96(var1, this.field_917, this.field_918);
        } else {
            throw new IllegalArgumentException("Volume cannot be " + var1);
        }
    }

    // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
    protected void method_1812(int var1, IBinder var2, Bundle var3) {
        class_332 var4 = field_915;
        Object[] var5 = new Object[] {Integer.valueOf(var1)};
        var4.method_2284("in onPostInitHandler; statusCode=%d", var5);
        if(var1 != 0 && var1 != 1001) {
            this.field_919 = false;
        } else {
            this.field_919 = true;
            this.field_936 = true;
            this.field_937 = true;
        }

        if(var1 == 1001) {
            this.field_925 = new Bundle();
            this.field_925.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
            var1 = 0;
        }

        super.method_1812(var1, var2, var3);
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        Bundle var3 = new Bundle();
        class_332 var4 = field_915;
        Object[] var5 = new Object[] {this.field_923, this.field_924};
        var4.method_2284("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", var5);
        this.field_931.putInBundle(var3);
        var3.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.field_933);
        if(this.field_923 != null) {
            var3.putString("last_application_id", this.field_923);
            if(this.field_924 != null) {
                var3.putString("last_session_id", this.field_924);
            }
        }

        this.field_934 = new class_304.class_1243();
        var1.method_958(var2, 6171000, this.getContext().getPackageName(), this.field_934.asBinder(), var3);
    }

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.cast.Cast$MessageReceivedCallback) void
    public void method_2076(String param1, Cast.MessageReceivedCallback param2) throws IllegalArgumentException, IllegalStateException, RemoteException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.cast.LaunchOptions, com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_2077(String var1, LaunchOptions var2, BaseImplementation.class_1147<Cast.ApplicationConnectionResult> var3) throws IllegalStateException, RemoteException {
        this.method_2057(var3);
        ((class_16)this.gS()).method_97(var1, var2);
    }

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_2078(String var1, BaseImplementation.class_1147<Status> var2) throws IllegalStateException, RemoteException {
        this.method_2061(var2);
        ((class_16)this.gS()).method_101(var1);
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String, com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_2079(String var1, String var2, BaseImplementation.class_1147<Status> var3) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if(TextUtils.isEmpty(var2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if(var2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            class_334.method_2301(var1);
            this.method_2065();
            long var4 = this.field_922.incrementAndGet();

            try {
                this.field_926.put(Long.valueOf(var4), var3);
                ((class_16)this.gS()).method_98(var1, var2, var4);
            } catch (Throwable var7) {
                this.field_926.remove(Long.valueOf(var4));
                throw var7;
            }
        }
    }

    // $FF: renamed from: a (java.lang.String, boolean, com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_2080(String var1, boolean var2, BaseImplementation.class_1147<Cast.ApplicationConnectionResult> var3) throws IllegalStateException, RemoteException {
        this.method_2057(var3);
        ((class_16)this.gS()).method_104(var1, var2);
    }

    // $FF: renamed from: aE (java.lang.String) void
    public void method_2081(String param1) throws IllegalArgumentException, RemoteException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (java.lang.String, java.lang.String, com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_2082(String var1, String var2, BaseImplementation.class_1147<Cast.ApplicationConnectionResult> var3) throws IllegalStateException, RemoteException {
        this.method_2057(var3);
        ((class_16)this.gS()).method_107(var1, var2);
    }

    // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_2083(BaseImplementation.class_1147<Status> var1) throws IllegalStateException, RemoteException {
        this.method_2061(var1);
        ((class_16)this.gS()).method_106();
    }

    public void disconnect() {
        class_332 var1 = field_915;
        Object[] var2 = new Object[] {this.field_934, Boolean.valueOf(this.isConnected())};
        var1.method_2284("disconnect(); ServiceListener=%s, isConnected=%b", var2);
        class_304.class_1243 var3 = this.field_934;
        this.field_934 = null;
        if(var3 != null && var3.method_4979()) {
            this.method_2064();

            try {
                if(this.isConnected() || this.isConnecting()) {
                    ((class_16)this.gS()).disconnect();
                }

                return;
            } catch (RemoteException var10) {
                class_332 var6 = field_915;
                Object[] var7 = new Object[] {var10.getMessage()};
                var6.method_2282(var10, "Error while disconnecting the controller interface: %s", var7);
            } finally {
                super.disconnect();
            }

        } else {
            field_915.method_2284("already disposed, so short-circuiting", new Object[0]);
        }
    }

    // $FF: renamed from: fC () android.os.Bundle
    public Bundle method_950() {
        if(this.field_925 != null) {
            Bundle var1 = this.field_925;
            this.field_925 = null;
            return var1;
        } else {
            return super.method_950();
        }
    }

    // $FF: renamed from: fD () void
    public void method_2084() throws IllegalStateException, RemoteException {
        ((class_16)this.gS()).method_105();
    }

    // $FF: renamed from: fE () double
    public double method_2085() throws IllegalStateException {
        this.method_2065();
        return this.field_917;
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        this.method_2065();
        return this.field_930;
    }

    public String getApplicationStatus() throws IllegalStateException {
        this.method_2065();
        return this.field_935;
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    public boolean isMute() throws IllegalStateException {
        this.method_2065();
        return this.field_918;
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    protected IInterface method_1820(IBinder var1) {
        return this.method_2074(var1);
    }

    private static final class class_1709 implements Cast.ApplicationConnectionResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_4384;
        // $FF: renamed from: GN com.google.android.gms.cast.ApplicationMetadata
        private final ApplicationMetadata field_4385;
        // $FF: renamed from: GO java.lang.String
        private final String field_4386;
        // $FF: renamed from: GP boolean
        private final boolean field_4387;
        // $FF: renamed from: vL java.lang.String
        private final String field_4388;

        public class_1709(Status var1) {
            this(var1, (ApplicationMetadata)null, (String)null, (String)null, false);
        }

        public class_1709(Status var1, ApplicationMetadata var2, String var3, String var4, boolean var5) {
            this.field_4384 = var1;
            this.field_4385 = var2;
            this.field_4386 = var3;
            this.field_4388 = var4;
            this.field_4387 = var5;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.field_4385;
        }

        public String getApplicationStatus() {
            return this.field_4386;
        }

        public String getSessionId() {
            return this.field_4388;
        }

        public Status getStatus() {
            return this.field_4384;
        }

        public boolean getWasLaunched() {
            return this.field_4387;
        }
    }

    private class class_1710 implements GoogleApiClient.OnConnectionFailedListener {
        private class_1710() {
        }

        // $FF: synthetic method
        class_1710(Object var2) {
            this();
        }

        public void onConnectionFailed(ConnectionResult var1) {
            class_304.this.method_2064();
        }
    }

    private class class_1243 extends class_17.class_1487 {
        // $FF: renamed from: GR java.util.concurrent.atomic.AtomicBoolean
        private AtomicBoolean field_4392;

        private class_1243() {
            this.field_4392 = new AtomicBoolean(false);
        }

        // $FF: synthetic method
        class_1243(Object var2) {
            this();
        }

        // $FF: renamed from: ag (int) boolean
        private boolean method_4977(int param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (long, int) void
        private void method_4978(long param1, int param3) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.cast.ApplicationMetadata, java.lang.String, java.lang.String, boolean) void
        public void method_108(ApplicationMetadata param1, String param2, String param3, boolean param4) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, double, boolean) void
        public void method_109(String var1, double var2, boolean var4) {
            class_304.field_915.method_2284("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        // $FF: renamed from: a (java.lang.String, long) void
        public void method_110(String var1, long var2) {
            if(!this.field_4392.get()) {
                this.method_4978(var2, 0);
            }
        }

        // $FF: renamed from: a (java.lang.String, long, int) void
        public void method_111(String var1, long var2, int var4) {
            if(!this.field_4392.get()) {
                this.method_4978(var2, var4);
            }
        }

        // $FF: renamed from: ac (int) void
        public void method_112(int var1) {
            if(this.method_4979()) {
                class_332 var2 = class_304.field_915;
                Object[] var3 = new Object[] {Integer.valueOf(var1)};
                var2.method_2284("ICastDeviceControllerListener.onDisconnected: %d", var3);
                if(var1 != 0) {
                    class_304.this.aA(2);
                    return;
                }
            }

        }

        // $FF: renamed from: ad (int) void
        public void method_113(int param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: ae (int) void
        public void method_114(int var1) {
            if(!this.field_4392.get()) {
                this.method_4977(var1);
            }
        }

        // $FF: renamed from: af (int) void
        public void method_115(int var1) {
            if(!this.field_4392.get()) {
                this.method_4977(var1);
            }
        }

        // $FF: renamed from: b (com.google.android.gms.internal.ig) void
        public void method_116(final class_338 var1) {
            if(!this.field_4392.get()) {
                class_304.field_915.method_2284("onApplicationStatusChanged", new Object[0]);
                class_304.this.mHandler.post(new Runnable() {
                    public void run() {
                        class_304.this.method_2050(var1);
                    }
                });
            }
        }

        // $FF: renamed from: b (com.google.android.gms.internal.il) void
        public void method_117(final class_333 var1) {
            if(!this.field_4392.get()) {
                class_304.field_915.method_2284("onDeviceStatusChanged", new Object[0]);
                class_304.this.mHandler.post(new Runnable() {
                    public void run() {
                        class_304.this.method_2053(var1);
                    }
                });
            }
        }

        // $FF: renamed from: b (java.lang.String, byte[]) void
        public void method_118(String var1, byte[] var2) {
            if(!this.field_4392.get()) {
                class_332 var3 = class_304.field_915;
                Object[] var4 = new Object[] {var1, Integer.valueOf(var2.length)};
                var3.method_2284("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", var4);
            }
        }

        // $FF: renamed from: fK () boolean
        public boolean method_4979() {
            if(this.field_4392.getAndSet(true)) {
                return false;
            } else {
                class_304.this.method_2063();
                return true;
            }
        }

        // $FF: renamed from: fL () boolean
        public boolean method_4980() {
            return this.field_4392.get();
        }

        // $FF: renamed from: k (java.lang.String, java.lang.String) void
        public void method_119(final String var1, final String var2) {
            if(!this.field_4392.get()) {
                class_304.field_915.method_2284("Receive (type=text, ns=%s) %s", new Object[] {var1, var2});
                class_304.this.mHandler.post(new Runnable() {
                    public void run() {
                        // $FF: Couldn't be decompiled
                    }
                });
            }
        }

        public void onApplicationDisconnected(final int var1) {
            if(!this.field_4392.get()) {
                class_304.this.field_923 = null;
                class_304.this.field_924 = null;
                this.method_4977(var1);
                if(class_304.this.field_916 != null) {
                    class_304.this.mHandler.post(new Runnable() {
                        public void run() {
                            if(class_304.this.field_916 != null) {
                                class_304.this.field_916.onApplicationDisconnected(var1);
                            }

                        }
                    });
                    return;
                }
            }

        }
    }
}
