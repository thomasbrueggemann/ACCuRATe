package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.class_504;
import com.google.android.gms.fitness.request.class_520;
import com.google.android.gms.fitness.request.class_522;
import com.google.android.gms.fitness.request.class_524;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.class_152;
import com.google.android.gms.internal.class_154;
import com.google.android.gms.internal.class_86;

// $FF: renamed from: com.google.android.gms.internal.ld
public class class_839 implements SessionsApi {
    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, java.lang.String, java.lang.String) com.google.android.gms.common.api.PendingResult
    private PendingResult<SessionStopResult> method_4463(GoogleApiClient var1, final String var2, final String var3) {
        return var1.method_899(new class_86.class_1401() {
            // $FF: renamed from: B (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.SessionStopResult
            protected SessionStopResult method_1208(Status var1) {
                return SessionStopResult.method_5569(var1);
            }

            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1209(class_86 var1) throws RemoteException {
                class_839.class_1773 var2x = new class_839.class_1773(this, null);
                String var3x = var1.getContext().getPackageName();
                var1.method_372().method_784((new class_520.class_1566()).method_5421(var2).method_5422(var3).method_5423(), var2x, var3x);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1208(var1);
            }
        });
    }

    public PendingResult<Status> insertSession(GoogleApiClient var1, final SessionInsertRequest var2) {
        return var1.method_897(new class_86.class_1403() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1223(class_86 var1) throws RemoteException {
                class_86.class_1402 var2x = new class_86.class_1402(this);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_768(var2, var2x, var3);
            }
        });
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient var1, final SessionReadRequest var2) {
        return var1.method_897(new class_86.class_1401() {
            // $FF: renamed from: C (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.SessionReadResult
            protected SessionReadResult method_1206(Status var1) {
                return SessionReadResult.method_3485(var1);
            }

            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1207(class_86 var1) throws RemoteException {
                class_839.class_1774 var2x = new class_839.class_1774(this, null);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_769(var2, var2x, var3);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1206(var1);
            }
        });
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient var1, final PendingIntent var2) {
        return var1.method_899(new class_86.class_1403() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1222(class_86 var1) throws RemoteException {
                class_86.class_1402 var2x = new class_86.class_1402(this);
                class_524 var3 = new class_524(var2);
                String var4 = var1.getContext().getPackageName();
                var1.method_372().method_782(var3, var2x, var4);
            }
        });
    }

    public PendingResult<Status> startSession(GoogleApiClient var1, final Session var2) {
        return var1.method_899(new class_86.class_1403() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1224(class_86 var1) throws RemoteException {
                class_86.class_1402 var2x = new class_86.class_1402(this);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_783((new class_522.class_1567()).method_4395(var2).method_4396(), var2x, var3);
            }
        });
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient var1, String var2) {
        return this.method_4463(var1, (String)null, var2);
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient var1, final PendingIntent var2) {
        return var1.method_899(new class_86.class_1403() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1221(class_86 var1) throws RemoteException {
                class_86.class_1402 var2x = new class_86.class_1402(this);
                class_504 var3 = new class_504(var2);
                String var4 = var1.getContext().getPackageName();
                var1.method_372().method_771(var3, var2x, var4);
            }
        });
    }

    private static class class_1774 extends class_154.class_1250 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<SessionReadResult> field_4552;

        private class_1774(BaseImplementation.class_1147<SessionReadResult> var1) {
            this.field_4552 = var1;
        }

        // $FF: synthetic method
        class_1774(BaseImplementation.class_1147 var1, Object var2) {
            this(var1);
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.result.SessionReadResult) void
        public void method_762(SessionReadResult var1) throws RemoteException {
            this.field_4552.method_120(var1);
        }
    }

    private static class class_1773 extends class_152.class_1525 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<SessionStopResult> field_4550;

        private class_1773(BaseImplementation.class_1147<SessionStopResult> var1) {
            this.field_4550 = var1;
        }

        // $FF: synthetic method
        class_1773(BaseImplementation.class_1147 var1, Object var2) {
            this(var1);
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.result.SessionStopResult) void
        public void method_760(SessionStopResult var1) {
            this.field_4550.method_120(var1);
        }
    }
}
