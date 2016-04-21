package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_209;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_641;
import com.google.android.gms.tagmanager.class_714;
import com.google.android.gms.tagmanager.class_715;
import com.google.android.gms.tagmanager.class_722;
import com.google.android.gms.tagmanager.n;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager arN;
    private final DataLayer aod;
    private final class_722 aqu;
    private final TagManager.class_1530 arK;
    private final class_641 arL;
    private final ConcurrentMap<n, Boolean> arM;
    private final Context mContext;

    TagManager(Context var1, TagManager.class_1530 var2, DataLayer var3, class_641 var4) {
        if(var1 == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.mContext = var1.getApplicationContext();
            this.arL = var4;
            this.arK = var2;
            this.arM = new ConcurrentHashMap();
            this.aod = var3;
            this.aod.method_5142(new DataLayer.class_1771() {
                // $FF: renamed from: D (java.util.Map) void
                public void method_998(Map<String, Object> var1) {
                    Object var2 = var1.get("event");
                    if(var2 != null) {
                        TagManager.this.method_3828(var2.toString());
                    }

                }
            });
            this.aod.method_5142(new class_714(this.mContext));
            this.aqu = new class_722();
            this.method_3829();
        }
    }

    // $FF: renamed from: cT (java.lang.String) void
    private void method_3828(String var1) {
        Iterator var2 = this.arM.keySet().iterator();

        while(var2.hasNext()) {
            ((class_715)var2.next()).method_3914(var1);
        }

    }

    public static TagManager getInstance(Context param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: py () void
    private void method_3829() {
        if(VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new ComponentCallbacks2() {
                public void onConfigurationChanged(Configuration var1) {
                }

                public void onLowMemory() {
                }

                public void onTrimMemory(int var1) {
                    if(var1 == 20) {
                        TagManager.this.dispatch();
                    }

                }
            });
        }

    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.n) void
    void method_3830(class_715 var1) {
        this.arM.put(var1, Boolean.valueOf(true));
    }

    // $FF: renamed from: b (com.google.android.gms.tagmanager.n) boolean
    boolean method_3831(class_715 var1) {
        return this.arM.remove(var1) != null;
    }

    public void dispatch() {
        this.arL.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.aod;
    }

    // $FF: renamed from: i (android.net.Uri) boolean
    boolean method_3832(Uri param1) {
        // $FF: Couldn't be decompiled
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String var1, int var2) {
        class_209 var3 = this.arK.method_880(this.mContext, this, (Looper)null, var1, var2, this.aqu);
        var3.method_1124();
        return var3;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String var1, int var2, Handler var3) {
        class_209 var4 = this.arK.method_880(this.mContext, this, var3.getLooper(), var1, var2, this.aqu);
        var4.method_1124();
        return var4;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String var1, int var2) {
        class_209 var3 = this.arK.method_880(this.mContext, this, (Looper)null, var1, var2, this.aqu);
        var3.method_1126();
        return var3;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String var1, int var2, Handler var3) {
        class_209 var4 = this.arK.method_880(this.mContext, this, var3.getLooper(), var1, var2, this.aqu);
        var4.method_1126();
        return var4;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String var1, int var2) {
        class_209 var3 = this.arK.method_880(this.mContext, this, (Looper)null, var1, var2, this.aqu);
        var3.method_1125();
        return var3;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String var1, int var2, Handler var3) {
        class_209 var4 = this.arK.method_880(this.mContext, this, var3.getLooper(), var1, var2, this.aqu);
        var4.method_1125();
        return var4;
    }

    public void setVerboseLoggingEnabled(boolean var1) {
        byte var2;
        if(var1) {
            var2 = 2;
        } else {
            var2 = 5;
        }

        class_612.setLogLevel(var2);
    }

    interface class_1530 {
        // $FF: renamed from: a (android.content.Context, com.google.android.gms.tagmanager.TagManager, android.os.Looper, java.lang.String, int, com.google.android.gms.tagmanager.r) com.google.android.gms.tagmanager.o
        class_209 method_880(Context var1, TagManager var2, Looper var3, String var4, int var5, class_722 var6);
    }
}
