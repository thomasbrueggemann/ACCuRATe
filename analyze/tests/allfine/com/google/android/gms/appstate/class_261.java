package com.google.android.gms.appstate;

import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.class_713;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_255;

// $FF: renamed from: com.google.android.gms.appstate.b
public final class class_261 extends class_255 implements AppState {
    class_261(DataHolder var1, int var2) {
        super(var1, var2);
    }

    public boolean equals(Object var1) {
        return class_713.method_3899(this, var1);
    }

    // $FF: renamed from: fo () com.google.android.gms.appstate.AppState
    public AppState method_1676() {
        return new class_713(this);
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_1676();
    }

    public byte[] getConflictData() {
        return this.getByteArray("conflict_data");
    }

    public String getConflictVersion() {
        return this.getString("conflict_version");
    }

    public int getKey() {
        return this.getInteger("key");
    }

    public byte[] getLocalData() {
        return this.getByteArray("local_data");
    }

    public String getLocalVersion() {
        return this.getString("local_version");
    }

    public boolean hasConflict() {
        return !this.aS("conflict_version");
    }

    public int hashCode() {
        return class_713.method_3898(this);
    }

    public String toString() {
        return class_713.method_3900(this);
    }
}
