package com.google.android.gms.appstate;

import com.google.android.gms.appstate.AppState;
import com.google.android.gms.common.internal.class_1089;

// $FF: renamed from: com.google.android.gms.appstate.a
public final class class_713 implements AppState {
    // $FF: renamed from: CO int
    private final int field_3445;
    // $FF: renamed from: CP java.lang.String
    private final String field_3446;
    // $FF: renamed from: CQ byte[]
    private final byte[] field_3447;
    // $FF: renamed from: CR boolean
    private final boolean field_3448;
    // $FF: renamed from: CS java.lang.String
    private final String field_3449;
    // $FF: renamed from: CT byte[]
    private final byte[] field_3450;

    public class_713(AppState var1) {
        this.field_3445 = var1.getKey();
        this.field_3446 = var1.getLocalVersion();
        this.field_3447 = var1.getLocalData();
        this.field_3448 = var1.hasConflict();
        this.field_3449 = var1.getConflictVersion();
        this.field_3450 = var1.getConflictData();
    }

    // $FF: renamed from: a (com.google.android.gms.appstate.AppState) int
    static int method_3898(AppState var0) {
        Object[] var1 = new Object[] {Integer.valueOf(var0.getKey()), var0.getLocalVersion(), var0.getLocalData(), Boolean.valueOf(var0.hasConflict()), var0.getConflictVersion(), var0.getConflictData()};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.appstate.AppState, java.lang.Object) boolean
    static boolean method_3899(AppState var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof AppState)) {
            var2 = false;
        } else if(var0 != var1) {
            AppState var3 = (AppState)var1;
            if(!class_1089.equal(Integer.valueOf(var3.getKey()), Integer.valueOf(var0.getKey())) || !class_1089.equal(var3.getLocalVersion(), var0.getLocalVersion()) || !class_1089.equal(var3.getLocalData(), var0.getLocalData()) || !class_1089.equal(Boolean.valueOf(var3.hasConflict()), Boolean.valueOf(var0.hasConflict())) || !class_1089.equal(var3.getConflictVersion(), var0.getConflictVersion()) || !class_1089.equal(var3.getConflictData(), var0.getConflictData())) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.appstate.AppState) java.lang.String
    static String method_3900(AppState var0) {
        return class_1089.method_5673(var0).method_5425("Key", Integer.valueOf(var0.getKey())).method_5425("LocalVersion", var0.getLocalVersion()).method_5425("LocalData", var0.getLocalData()).method_5425("HasConflict", Boolean.valueOf(var0.hasConflict())).method_5425("ConflictVersion", var0.getConflictVersion()).method_5425("ConflictData", var0.getConflictData()).toString();
    }

    public boolean equals(Object var1) {
        return method_3899(this, var1);
    }

    // $FF: renamed from: fo () com.google.android.gms.appstate.AppState
    public AppState method_3901() {
        return this;
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_3901();
    }

    public byte[] getConflictData() {
        return this.field_3450;
    }

    public String getConflictVersion() {
        return this.field_3449;
    }

    public int getKey() {
        return this.field_3445;
    }

    public byte[] getLocalData() {
        return this.field_3447;
    }

    public String getLocalVersion() {
        return this.field_3446;
    }

    public boolean hasConflict() {
        return this.field_3448;
    }

    public int hashCode() {
        return method_3898(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return method_3900(this);
    }
}
