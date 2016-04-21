package com.google.android.gms.auth.api;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;

public class GoogleAuthApiException extends Exception {
    // $FF: renamed from: CM com.google.android.gms.common.api.Status
    private Status field_4216;
    private PendingIntent mPendingIntent;

    public GoogleAuthApiException(String var1, Status var2) {
        super(var1);
        this.field_4216 = var2;
    }

    public GoogleAuthApiException(String var1, Status var2, PendingIntent var3) {
        super(var1);
        this.field_4216 = var2;
        this.mPendingIntent = var3;
    }

    public PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this.field_4216;
    }

    public boolean isUserRecoverable() {
        return this.mPendingIntent != null;
    }
}
