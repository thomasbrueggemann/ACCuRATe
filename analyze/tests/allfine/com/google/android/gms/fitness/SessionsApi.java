package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.class_822;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;

public interface SessionsApi {
    PendingResult<Status> insertSession(GoogleApiClient var1, SessionInsertRequest var2);

    PendingResult<SessionReadResult> readSession(GoogleApiClient var1, SessionReadRequest var2);

    PendingResult<Status> registerForSessions(GoogleApiClient var1, PendingIntent var2);

    PendingResult<Status> startSession(GoogleApiClient var1, Session var2);

    PendingResult<SessionStopResult> stopSession(GoogleApiClient var1, String var2);

    PendingResult<Status> unregisterForSessions(GoogleApiClient var1, PendingIntent var2);

    public static class ViewIntentBuilder {
        // $FF: renamed from: Ss java.lang.String
        private String field_3672;
        // $FF: renamed from: St com.google.android.gms.fitness.data.Session
        private Session field_3673;
        // $FF: renamed from: Su boolean
        private boolean field_3674 = false;
        private final Context mContext;

        public ViewIntentBuilder(Context var1) {
            this.mContext = var1;
        }

        // $FF: renamed from: i (android.content.Intent) android.content.Intent
        private Intent method_4072(Intent var1) {
            if(this.field_3672 != null) {
                Intent var2 = (new Intent(var1)).setPackage(this.field_3672);
                ResolveInfo var3 = this.mContext.getPackageManager().resolveActivity(var2, 0);
                if(var3 != null) {
                    String var4 = var3.activityInfo.name;
                    var2.setComponent(new ComponentName(this.field_3672, var4));
                    return var2;
                }
            }

            return var1;
        }

        public Intent build() {
            boolean var1;
            if(this.field_3673 != null) {
                var1 = true;
            } else {
                var1 = false;
            }

            class_1090.method_5676(var1, "Session must be set");
            Intent var2 = new Intent("vnd.google.fitness.VIEW");
            var2.setType(Session.getMimeType(this.field_3673.getActivity()));
            class_822.method_4296(this.field_3673, var2, "vnd.google.fitness.session");
            if(!this.field_3674) {
                this.field_3672 = this.field_3673.getAppPackageName();
            }

            return this.method_4072(var2);
        }

        public SessionsApi.ViewIntentBuilder setPreferredApplication(String var1) {
            this.field_3672 = var1;
            this.field_3674 = true;
            return this;
        }

        public SessionsApi.ViewIntentBuilder setSession(Session var1) {
            this.field_3673 = var1;
            return this;
        }
    }
}
