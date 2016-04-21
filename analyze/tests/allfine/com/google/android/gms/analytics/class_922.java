package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.class_179;
import com.google.android.gms.analytics.class_938;
import com.google.android.gms.internal.class_25;
import com.google.android.gms.internal.hb;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.analytics.c
class class_922 implements class_179 {
    private Context mContext;
    // $FF: renamed from: xG android.content.ServiceConnection
    private ServiceConnection field_4227;
    // $FF: renamed from: xH com.google.android.gms.analytics.c$b
    private class_922.class_1635 field_4228;
    // $FF: renamed from: xI com.google.android.gms.analytics.c$c
    private class_922.class_1636 field_4229;
    // $FF: renamed from: xJ com.google.android.gms.internal.hc
    private class_25 field_4230;

    public class_922(Context var1, class_922.class_1635 var2, class_922.class_1636 var3) {
        this.mContext = var1;
        if(var2 == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        } else {
            this.field_4228 = var2;
            if(var3 == null) {
                throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
            } else {
                this.field_4229 = var3;
            }
        }
    }

    // $FF: renamed from: dI () com.google.android.gms.internal.hc
    private class_25 method_4770() {
        this.method_4773();
        return this.field_4230;
    }

    // $FF: renamed from: dK () void
    private void method_4771() {
        this.method_4772();
    }

    // $FF: renamed from: dL () void
    private void method_4772() {
        this.field_4228.onConnected();
    }

    // $FF: renamed from: a (java.util.Map, long, java.lang.String, java.util.List) void
    public void method_829(Map<String, String> var1, long var2, String var4, List<hb> var5) {
        try {
            this.method_4770().method_148(var1, var2, var4, var5);
        } catch (RemoteException var7) {
            class_938.method_4858("sendHit failed: " + var7);
        }
    }

    public void connect() {
        Intent var1 = new Intent("com.google.android.gms.analytics.service.START");
        var1.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        var1.putExtra("app_package_name", this.mContext.getPackageName());
        if(this.field_4227 != null) {
            class_938.method_4858("Calling connect() while still connected, missing disconnect().");
        } else {
            this.field_4227 = new class_922.class_1634();
            boolean var4 = this.mContext.bindService(var1, this.field_4227, 129);
            class_938.method_4860("connect: bindService returned " + var4 + " for " + var1);
            if(!var4) {
                this.field_4227 = null;
                this.field_4229.method_1045(1, (Intent)null);
                return;
            }
        }

    }

    // $FF: renamed from: dH () void
    public void method_830() {
        try {
            this.method_4770().method_149();
        } catch (RemoteException var2) {
            class_938.method_4858("clear hits failed: " + var2);
        }
    }

    // $FF: renamed from: dJ () void
    protected void method_4773() {
        if(!this.isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void disconnect() {
        this.field_4230 = null;
        if(this.field_4227 != null) {
            try {
                this.mContext.unbindService(this.field_4227);
            } catch (IllegalStateException var3) {
                ;
            } catch (IllegalArgumentException var4) {
                ;
            }

            this.field_4227 = null;
            this.field_4228.onDisconnected();
        }

    }

    public boolean isConnected() {
        return this.field_4230 != null;
    }

    final class class_1634 implements ServiceConnection {
        public void onServiceConnected(ComponentName var1, IBinder var2) {
            class_938.method_4860("service connected, binder: " + var2);

            try {
                if("com.google.android.gms.analytics.internal.IAnalyticsService".equals(var2.getInterfaceDescriptor())) {
                    class_938.method_4860("bound to service");
                    class_922.this.field_4230 = class_25.class_1344.method_3252(var2);
                    class_922.this.method_4771();
                    return;
                }
            } catch (RemoteException var6) {
                ;
            }

            try {
                class_922.this.mContext.unbindService(this);
            } catch (IllegalArgumentException var5) {
                ;
            }

            class_922.this.field_4227 = null;
            class_922.this.field_4229.method_1045(2, (Intent)null);
        }

        public void onServiceDisconnected(ComponentName var1) {
            class_938.method_4860("service disconnected: " + var1);
            class_922.this.field_4227 = null;
            class_922.this.field_4228.onDisconnected();
        }
    }

    public interface class_1635 {
        void onConnected();

        void onDisconnected();
    }

    public interface class_1636 {
        // $FF: renamed from: a (int, android.content.Intent) void
        void method_1045(int var1, Intent var2);
    }
}
