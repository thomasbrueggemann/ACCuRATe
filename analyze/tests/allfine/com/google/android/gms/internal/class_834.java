package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_299;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionApi;

// $FF: renamed from: com.google.android.gms.internal.lr
public class class_834 implements ActivityRecognitionApi {
    public PendingResult<Status> removeActivityUpdates(GoogleApiClient var1, final PendingIntent var2) {
        return var1.method_899(new class_834.class_1680(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.lz) void
            protected void method_1156(class_299 var1) throws RemoteException {
                var1.removeActivityUpdates(var2);
                this.b(Status.field_4739);
            }
        });
    }

    public PendingResult<Status> requestActivityUpdates(GoogleApiClient var1, final long var2, final PendingIntent var4) {
        return var1.method_899(new class_834.class_1680(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.lz) void
            protected void method_1155(class_299 var1) throws RemoteException {
                var1.requestActivityUpdates(var2, var4);
                this.b(Status.field_4739);
            }
        });
    }

    private abstract static class class_1680 extends ActivityRecognition.class_1781<Status> {
        private class_1680() {
        }

        // $FF: synthetic method
        class_1680(Object var1) {
            this();
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1154(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        public Status method_1154(Status var1) {
            return var1;
        }
    }
}
