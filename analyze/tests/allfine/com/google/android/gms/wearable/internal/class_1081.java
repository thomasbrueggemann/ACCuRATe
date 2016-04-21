package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.internal.class_210;
import com.google.android.gms.wearable.internal.class_292;

// $FF: renamed from: com.google.android.gms.wearable.internal.ag
public final class class_1081 implements MessageApi {
    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.wearable.MessageApi$MessageListener, android.content.IntentFilter[]) com.google.android.gms.common.api.PendingResult
    private PendingResult<Status> method_5610(GoogleApiClient var1, final MessageApi.MessageListener var2, final IntentFilter[] var3) {
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1169(class_292 var1) throws RemoteException {
                var1.method_1831(this, var2, var3);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            public Result method_1104(Status var1) {
                return this.method_1170(var1);
            }

            // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
            public Status method_1170(Status var1) {
                return new Status(13);
            }
        });
    }

    public PendingResult<Status> addListener(GoogleApiClient var1, MessageApi.MessageListener var2) {
        return this.method_5610(var1, var2, (IntentFilter[])null);
    }

    public PendingResult<Status> removeListener(GoogleApiClient var1, final MessageApi.MessageListener var2) {
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1167(class_292 var1) throws RemoteException {
                var1.method_1830(this, var2);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            public Result method_1104(Status var1) {
                return this.method_1168(var1);
            }

            // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
            public Status method_1168(Status var1) {
                return new Status(13);
            }
        });
    }

    public PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient var1, final String var2, final String var3, final byte[] var4) {
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1171(class_292 var1) throws RemoteException {
                var1.method_1835(this, var2, var3, var4);
            }

            // $FF: renamed from: aJ (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.MessageApi$SendMessageResult
            protected MessageApi.SendMessageResult method_1172(Status var1) {
                return new class_1081.class_1687(var1, -1);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1172(var1);
            }
        });
    }

    public static class class_1687 implements MessageApi.SendMessageResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_4053;
        // $FF: renamed from: uQ int
        private final int field_4054;

        public class_1687(Status var1, int var2) {
            this.field_4053 = var1;
            this.field_4054 = var2;
        }

        public int getRequestId() {
            return this.field_4054;
        }

        public Status getStatus() {
            return this.field_4053;
        }
    }
}
