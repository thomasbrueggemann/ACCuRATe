package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.class_192;
import com.google.android.gms.common.internal.class_291;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.internal.class_159;
import com.google.android.gms.internal.class_872;
import com.google.android.gms.internal.class_873;
import com.google.android.gms.internal.class_875;
import com.google.android.gms.internal.class_876;
import com.google.android.gms.internal.nh;

// $FF: renamed from: com.google.android.gms.internal.no
public class class_296 extends e<nh> {
    // $FF: renamed from: BZ java.lang.String
    private final String field_891;
    private final class_875 akW;
    private final class_873 akX;
    private boolean akY;
    // $FF: renamed from: mw java.lang.Object
    private final Object field_892;

    public class_296(Context var1, class_875 var2) {
        super(var1, var2, var2, new String[0]);
        this.field_891 = var1.getPackageName();
        this.akW = (class_875)class_1090.method_5685(var2);
        this.akW.method_4544(this);
        this.akX = new class_873();
        this.field_892 = new Object();
        this.akY = true;
    }

    // $FF: renamed from: c (com.google.android.gms.internal.nm, com.google.android.gms.internal.ni) void
    private void method_1864(class_876 var1, class_872 var2) {
        this.akX.method_4535(var1, var2);
    }

    // $FF: renamed from: d (com.google.android.gms.internal.nm, com.google.android.gms.internal.ni) void
    private void method_1865(class_876 var1, class_872 var2) {
        try {
            this.method_1866();
            ((class_159)this.gS()).method_790(this.field_891, var1, var2);
        } catch (RemoteException var6) {
            Log.e("PlayLoggerImpl", "Couldn\'t send log event.  Will try caching.");
            this.method_1864(var1, var2);
        } catch (IllegalStateException var7) {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            this.method_1864(var1, var2);
        }
    }

    // $FF: renamed from: mY () void
    private void method_1866() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: S (boolean) void
    void method_1867(boolean param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        Bundle var3 = new Bundle();
        var1.method_976(var2, 6171000, this.getContext().getPackageName(), var3);
    }

    // $FF: renamed from: b (com.google.android.gms.internal.nm, com.google.android.gms.internal.ni) void
    public void method_1868(class_876 param1, class_872 param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: bD (android.os.IBinder) com.google.android.gms.internal.nh
    protected class_159 method_1869(IBinder var1) {
        return class_159.class_1542.method_5790(var1);
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.playlog.service.START";
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    protected IInterface method_1820(IBinder var1) {
        return this.method_1869(var1);
    }

    public void start() {
        // $FF: Couldn't be decompiled
    }

    public void stop() {
        // $FF: Couldn't be decompiled
    }
}
