package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.class_1072;
import com.google.android.gms.wearable.internal.class_1082;
import com.google.android.gms.wearable.internal.class_190;

// $FF: renamed from: com.google.android.gms.wearable.internal.ax
public class class_549 extends class_190.class_1376 {
    private final DataApi.DataListener avX;
    private final MessageApi.MessageListener avY;
    private final NodeApi.NodeListener avZ;
    private final IntentFilter[] awa;

    public class_549(DataApi.DataListener var1, MessageApi.MessageListener var2, NodeApi.NodeListener var3, IntentFilter[] var4) {
        this.avX = var1;
        this.avY = var2;
        this.avZ = var3;
        this.awa = var4;
    }

    // $FF: renamed from: a (com.google.android.gms.wearable.DataApi$DataListener, android.content.IntentFilter[]) com.google.android.gms.wearable.internal.ax
    public static class_549 method_3369(DataApi.DataListener var0, IntentFilter[] var1) {
        return new class_549(var0, (MessageApi.MessageListener)null, (NodeApi.NodeListener)null, var1);
    }

    // $FF: renamed from: a (com.google.android.gms.wearable.MessageApi$MessageListener, android.content.IntentFilter[]) com.google.android.gms.wearable.internal.ax
    public static class_549 method_3370(MessageApi.MessageListener var0, IntentFilter[] var1) {
        return new class_549((DataApi.DataListener)null, var0, (NodeApi.NodeListener)null, var1);
    }

    // $FF: renamed from: a (com.google.android.gms.wearable.NodeApi$NodeListener) com.google.android.gms.wearable.internal.ax
    public static class_549 method_3371(NodeApi.NodeListener var0) {
        return new class_549((DataApi.DataListener)null, (MessageApi.MessageListener)null, var0, (IntentFilter[])null);
    }

    // $FF: renamed from: Z (com.google.android.gms.common.data.DataHolder) void
    public void method_923(DataHolder var1) {
        if(this.avX != null) {
            try {
                this.avX.onDataChanged(new DataEventBuffer(var1));
            } finally {
                var1.close();
            }

        } else {
            var1.close();
        }
    }

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ah) void
    public void method_924(class_1082 var1) {
        if(this.avY != null) {
            this.avY.onMessageReceived(var1);
        }

    }

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ak) void
    public void method_925(class_1072 var1) {
        if(this.avZ != null) {
            this.avZ.onPeerConnected(var1);
        }

    }

    // $FF: renamed from: b (com.google.android.gms.wearable.internal.ak) void
    public void method_926(class_1072 var1) {
        if(this.avZ != null) {
            this.avZ.onPeerDisconnected(var1);
        }

    }

    // $FF: renamed from: qb () android.content.IntentFilter[]
    public IntentFilter[] method_3372() {
        return this.awa;
    }
}
