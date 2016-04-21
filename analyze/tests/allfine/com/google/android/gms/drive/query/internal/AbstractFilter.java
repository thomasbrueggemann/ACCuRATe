package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.class_947;

public abstract class AbstractFilter implements Filter {
    public String toString() {
        Object[] var1 = new Object[] {this.a(new class_947())};
        return String.format("Filter[%s]", var1);
    }
}
