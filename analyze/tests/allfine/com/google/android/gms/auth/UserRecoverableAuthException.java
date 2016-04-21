package com.google.android.gms.auth;

import android.content.Intent;
import com.google.android.gms.auth.GoogleAuthException;

public class UserRecoverableAuthException extends GoogleAuthException {
    private final Intent mIntent;

    public UserRecoverableAuthException(String var1, Intent var2) {
        super(var1);
        this.mIntent = var2;
    }

    public Intent getIntent() {
        return this.mIntent == null?null:new Intent(this.mIntent);
    }
}
