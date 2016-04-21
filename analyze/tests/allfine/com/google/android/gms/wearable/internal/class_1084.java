package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.class_210;
import com.google.android.gms.wearable.internal.class_292;
import java.util.List;

// $FF: renamed from: com.google.android.gms.wearable.internal.aj
public final class class_1084 implements NodeApi {
    public PendingResult<Status> addListener(GoogleApiClient var1, final NodeApi.NodeListener var2) {
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1159(class_292 var1) throws RemoteException {
                var1.method_1832(this, var2);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            public Result method_1104(Status var1) {
                return this.method_1160(var1);
            }

            // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
            public Status method_1160(Status var1) {
                return new Status(13);
            }
        });
    }

    public PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(GoogleApiClient var1) {
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1165(class_292 var1) throws RemoteException {
                var1.method_1842(this);
            }

            // $FF: renamed from: aL (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.NodeApi$GetConnectedNodesResult
            protected NodeApi.GetConnectedNodesResult method_1166(Status var1) {
                return new class_1084.class_1732(var1, (List)null);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1166(var1);
            }
        });
    }

    public PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(GoogleApiClient var1) {
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1163(class_292 var1) throws RemoteException {
                var1.method_1841(this);
            }

            // $FF: renamed from: aK (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.NodeApi$GetLocalNodeResult
            protected NodeApi.GetLocalNodeResult method_1164(Status var1) {
                return new class_1084.class_1733(var1, (Node)null);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1164(var1);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient var1, final NodeApi.NodeListener var2) {
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1161(class_292 var1) throws RemoteException {
                var1.method_1837(this, var2);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            public Result method_1104(Status var1) {
                return this.method_1162(var1);
            }

            // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
            public Status method_1162(Status var1) {
                return new Status(13);
            }
        });
    }

    public static class class_1732 implements NodeApi.GetConnectedNodesResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_4806;
        private final List<Node> avL;

        public class_1732(Status var1, List<Node> var2) {
            this.field_4806 = var1;
            this.avL = var2;
        }

        public List<Node> getNodes() {
            return this.avL;
        }

        public Status getStatus() {
            return this.field_4806;
        }
    }

    public static class class_1733 implements NodeApi.GetLocalNodeResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_4805;
        private final Node avM;

        public class_1733(Status var1, Node var2) {
            this.field_4805 = var1;
            this.avM = var2;
        }

        public Node getNode() {
            return this.avM;
        }

        public Status getStatus() {
            return this.field_4805;
        }
    }
}
