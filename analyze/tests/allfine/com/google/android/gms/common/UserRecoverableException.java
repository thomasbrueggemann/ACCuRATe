package com.google.android.gms.common;

import android.content.Intent;

public class UserRecoverableException extends Exception {
    private final Intent mIntent;

    public UserRecoverableException(String var1, Intent var2) {
        super(var1);
        this.mIntent = var2;
    }

    public Intent getIntent() {
        return new Intent(this.mIntent);
    }
}
