package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.util.Log;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.class_192;
import com.google.android.gms.common.internal.class_291;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.ae;
import com.google.android.gms.wearable.internal.af;
import com.google.android.gms.wearable.internal.ax;
import com.google.android.gms.wearable.internal.class_1003;
import com.google.android.gms.wearable.internal.class_1005;
import com.google.android.gms.wearable.internal.class_1007;
import com.google.android.gms.wearable.internal.class_1068;
import com.google.android.gms.wearable.internal.class_1070;
import com.google.android.gms.wearable.internal.class_1076;
import com.google.android.gms.wearable.internal.class_1080;
import com.google.android.gms.wearable.internal.class_1081;
import com.google.android.gms.wearable.internal.class_1084;
import com.google.android.gms.wearable.internal.class_191;
import com.google.android.gms.wearable.internal.class_534;
import com.google.android.gms.wearable.internal.class_992;
import com.google.android.gms.wearable.internal.class_997;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

// $FF: renamed from: com.google.android.gms.wearable.internal.aw
public class class_292 extends e<af> {
    private final ExecutorService aqA = Executors.newCachedThreadPool();
    private final HashMap<DataApi.DataListener, ax> avQ = new HashMap();
    private final HashMap<MessageApi.MessageListener, ax> avR = new HashMap();
    private final HashMap<NodeApi.NodeListener, ax> avS = new HashMap();

    public class_292(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4) {
        super(var1, var2, var3, var4, new String[0]);
    }

    // $FF: renamed from: a (android.os.ParcelFileDescriptor, byte[]) java.util.concurrent.FutureTask
    private FutureTask<Boolean> method_1821(final ParcelFileDescriptor var1, final byte[] var2) {
        return new FutureTask(new Callable() {
            // $FF: synthetic method
            public Object call() throws Exception {
                return this.method_3408();
            }

            // $FF: renamed from: qa () java.lang.Boolean
            public Boolean method_3408() {
                if(Log.isLoggable("WearableClient", 3)) {
                    Log.d("WearableClient", "processAssets: writing data to FD : " + var1);
                }

                AutoCloseOutputStream var1x = new AutoCloseOutputStream(var1);

                try {
                    var1x.write(var2);
                    var1x.flush();
                    if(Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: wrote data: " + var1);
                    }

                    Boolean var9 = Boolean.valueOf(true);
                    return var9;
                } catch (IOException var17) {
                    Log.w("WearableClient", "processAssets: writing data failed: " + var1);
                } finally {
                    try {
                        if(Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + var1);
                        }

                        var1x.close();
                    } catch (IOException var16) {
                        ;
                    }

                }

                return Boolean.valueOf(false);
            }
        });
    }

    // $FF: renamed from: b (com.google.android.gms.wearable.internal.aw) java.util.HashMap
    // $FF: synthetic method
    static HashMap method_1822(class_292 var0) {
        return var0.avQ;
    }

    // $FF: renamed from: c (com.google.android.gms.wearable.internal.aw) java.util.HashMap
    // $FF: synthetic method
    static HashMap method_1823(class_292 var0) {
        return var0.avR;
    }

    // $FF: renamed from: d (com.google.android.gms.wearable.internal.aw) java.util.HashMap
    // $FF: synthetic method
    static HashMap method_1824(class_292 var0) {
        return var0.avS;
    }

    // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
    protected void method_1812(int param1, IBinder param2, Bundle param3) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, android.net.Uri) void
    public void method_1825(final BaseImplementation.class_1147<DataApi.DataItemResult> var1, Uri var2) throws RemoteException {
        ((class_191)this.gS()).method_928(new class_534() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.x) void
            public void method_920(class_1003 var1x) {
                var1.method_120(new class_992.class_1644(new Status(var1x.statusCode), var1x.avA));
            }
        }, var2);
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.Asset) void
    public void method_1826(final BaseImplementation.class_1147<DataApi.GetFdForAssetResult> var1, Asset var2) throws RemoteException {
        ((class_191)this.gS()).method_929(new class_534() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.z) void
            public void method_921(class_1007 var1x) {
                var1.method_120(new class_992.class_1643(new Status(var1x.statusCode), var1x.avB));
            }
        }, var2);
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.DataApi$DataListener) void
    public void method_1827(BaseImplementation.class_1147<Status> param1, DataApi.DataListener param2) throws RemoteException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.DataApi$DataListener, android.content.IntentFilter[]) void
    public void method_1828(BaseImplementation.class_1147<Status> param1, DataApi.DataListener param2, IntentFilter[] param3) throws RemoteException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.DataItemAsset) void
    public void method_1829(BaseImplementation.class_1147<DataApi.GetFdForAssetResult> var1, DataItemAsset var2) throws RemoteException {
        this.method_1826(var1, Asset.createFromRef(var2.getId()));
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.MessageApi$MessageListener) void
    public void method_1830(BaseImplementation.class_1147<Status> param1, MessageApi.MessageListener param2) throws RemoteException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.MessageApi$MessageListener, android.content.IntentFilter[]) void
    public void method_1831(BaseImplementation.class_1147<Status> param1, MessageApi.MessageListener param2, IntentFilter[] param3) throws RemoteException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.NodeApi$NodeListener) void
    public void method_1832(BaseImplementation.class_1147<Status> param1, NodeApi.NodeListener param2) throws RemoteException, RemoteException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.PutDataRequest) void
    public void method_1833(BaseImplementation.class_1147<DataApi.DataItemResult> var1, PutDataRequest var2) throws RemoteException {
        Iterator var3 = var2.getAssets().entrySet().iterator();

        Asset var19;
        do {
            if(!var3.hasNext()) {
                PutDataRequest var4 = PutDataRequest.method_1634(var2.getUri());
                var4.setData(var2.getData());
                ArrayList var6 = new ArrayList();
                Iterator var7 = var2.getAssets().entrySet().iterator();

                while(var7.hasNext()) {
                    Entry var9 = (Entry)var7.next();
                    Asset var10 = (Asset)var9.getValue();
                    if(var10.getData() == null) {
                        var4.putAsset((String)var9.getKey(), (Asset)var9.getValue());
                    } else {
                        ParcelFileDescriptor[] var12;
                        try {
                            var12 = ParcelFileDescriptor.createPipe();
                        } catch (IOException var21) {
                            throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + var2, var21);
                        }

                        if(Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + var10 + " read:" + var12[0] + " write:" + var12[1]);
                        }

                        var4.putAsset((String)var9.getKey(), Asset.createFromFd(var12[0]));
                        FutureTask var14 = this.method_1821(var12[1], var10.getData());
                        var6.add(var14);
                        this.aqA.submit(var14);
                    }
                }

                try {
                    ((class_191)this.gS()).method_930(new class_292.class_1387(var1, var6), var4);
                    return;
                } catch (NullPointerException var20) {
                    throw new IllegalStateException("Unable to putDataItem: " + var2, var20);
                }
            }

            var19 = (Asset)((Entry)var3.next()).getValue();
        } while(var19.getData() != null || var19.getDigest() != null || var19.getFd() != null || var19.getUri() != null);

        throw new IllegalArgumentException("Put for " + var2.getUri() + " contains invalid asset: " + var19);
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.internal.ae) void
    public void method_1834(final BaseImplementation.class_1147<Status> var1, ae var2) throws RemoteException {
        ((class_191)this.gS()).method_932(new class_534() {
            // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
            public void method_911(Status var1x) {
                var1.method_120(var1x);
            }
        }, new class_1070(var2));
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, byte[]) void
    public void method_1835(final BaseImplementation.class_1147<MessageApi.SendMessageResult> var1, String var2, String var3, byte[] var4) throws RemoteException {
        ((class_191)this.gS()).method_935(new class_534() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.as) void
            public void method_914(class_1076 var1x) {
                var1.method_120(new class_1081.class_1687(new Status(var1x.statusCode), var1x.avO));
            }
        }, var2, var3, var4);
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        var1.method_973(var2, 6171000, this.getContext().getPackageName());
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, android.net.Uri) void
    public void method_1836(final BaseImplementation.class_1147<DataItemBuffer> var1, Uri var2) throws RemoteException {
        ((class_191)this.gS()).method_937(new class_534() {
            // $FF: renamed from: aa (com.google.android.gms.common.data.DataHolder) void
            public void method_922(DataHolder var1x) {
                var1.method_120(new DataItemBuffer(var1x));
            }
        }, var2);
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.NodeApi$NodeListener) void
    public void method_1837(BaseImplementation.class_1147<Status> param1, NodeApi.NodeListener param2) throws RemoteException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: bU (android.os.IBinder) com.google.android.gms.wearable.internal.af
    protected class_191 method_1838(IBinder var1) {
        return class_191.class_1208.method_2682(var1);
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, android.net.Uri) void
    public void method_1839(final BaseImplementation.class_1147<DataApi.DeleteDataItemsResult> var1, Uri var2) throws RemoteException {
        ((class_191)this.gS()).method_941(new class_534() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.p) void
            public void method_916(class_997 var1x) {
                var1.method_120(new class_992.class_1642(new Status(var1x.statusCode), var1x.avw));
            }
        }, var2);
    }

    public void disconnect() {
        super.disconnect();
        this.avQ.clear();
        this.avR.clear();
        this.avS.clear();
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.wearable.BIND";
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    protected IInterface method_1820(IBinder var1) {
        return this.method_1838(var1);
    }

    // $FF: renamed from: o (com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_1840(final BaseImplementation.class_1147<DataItemBuffer> var1) throws RemoteException {
        ((class_191)this.gS()).method_936(new class_534() {
            // $FF: renamed from: aa (com.google.android.gms.common.data.DataHolder) void
            public void method_922(DataHolder var1x) {
                var1.method_120(new DataItemBuffer(var1x));
            }
        });
    }

    // $FF: renamed from: p (com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_1841(final BaseImplementation.class_1147<NodeApi.GetLocalNodeResult> var1) throws RemoteException {
        ((class_191)this.gS()).method_940(new class_534() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab) void
            public void method_912(class_1080 var1x) {
                var1.method_120(new class_1084.class_1733(new Status(var1x.statusCode), var1x.avC));
            }
        });
    }

    // $FF: renamed from: q (com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_1842(final BaseImplementation.class_1147<NodeApi.GetConnectedNodesResult> var1) throws RemoteException {
        ((class_191)this.gS()).method_943(new class_534() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.v) void
            public void method_919(class_1005 var1x) {
                ArrayList var2 = new ArrayList();
                var2.addAll(var1x.avz);
                var1.method_120(new class_1084.class_1732(new Status(var1x.statusCode), var2));
            }
        });
    }

    private static class class_1387 extends class_534 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<DataApi.DataItemResult> field_2847;
        private final List<FutureTask<Boolean>> avW;

        class_1387(BaseImplementation.class_1147<DataApi.DataItemResult> var1, List<FutureTask<Boolean>> var2) {
            this.field_2847 = var1;
            this.avW = var2;
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ao) void
        public void method_913(class_1068 var1) {
            this.field_2847.method_120(new class_992.class_1644(new Status(var1.statusCode), var1.avA));
            if(var1.statusCode != 0) {
                Iterator var2 = this.avW.iterator();

                while(var2.hasNext()) {
                    ((FutureTask)var2.next()).cancel(true);
                }
            }

        }
    }
}
