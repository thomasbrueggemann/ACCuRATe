package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.internal.class_305;

public final class ExecutionOptions {
    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
    // $FF: renamed from: Nn java.lang.String
    private final String field_4149;
    // $FF: renamed from: No boolean
    private final boolean field_4150;
    // $FF: renamed from: Np int
    private final int field_4151;

    private ExecutionOptions(String var1, boolean var2, int var3) {
        this.field_4149 = var1;
        this.field_4150 = var2;
        this.field_4151 = var3;
    }

    // $FF: synthetic method
    ExecutionOptions(String var1, boolean var2, int var3, Object var4) {
        this(var1, var2, var3);
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.ExecutionOptions) void
    public static void method_4481(GoogleApiClient var0, ExecutionOptions var1) {
        class_305 var2 = (class_305)var0.method_896(Drive.field_3554);
        if(var1.method_4486() && !var2.method_2094()) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
        }
    }

    // $FF: renamed from: aV (int) boolean
    public static boolean method_4482(int var0) {
        switch(var0) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    // $FF: renamed from: aW (int) boolean
    public static boolean method_4483(int var0) {
        switch(var0) {
            case 0:
            case 1:
                return true;
            default:
                return false;
        }
    }

    // $FF: renamed from: bh (java.lang.String) boolean
    public static boolean method_4484(String var0) {
        return var0 != null && !var0.isEmpty() && var0.length() <= 65536;
    }

    // $FF: renamed from: hO () java.lang.String
    public String method_4485() {
        return this.field_4149;
    }

    // $FF: renamed from: hP () boolean
    public boolean method_4486() {
        return this.field_4150;
    }

    // $FF: renamed from: hQ () int
    public int method_4487() {
        return this.field_4151;
    }

    public static final class Builder {
        // $FF: renamed from: Nn java.lang.String
        private String field_4045;
        // $FF: renamed from: No boolean
        private boolean field_4046;
        // $FF: renamed from: Np int
        private int field_4047 = 0;

        public ExecutionOptions build() {
            if(this.field_4047 == 1 && !this.field_4046) {
                throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
            } else {
                return new ExecutionOptions(this.field_4045, this.field_4046, this.field_4047);
            }
        }

        public ExecutionOptions.Builder setConflictStrategy(int var1) {
            if(!ExecutionOptions.method_4483(var1)) {
                throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + var1);
            } else {
                this.field_4047 = var1;
                return this;
            }
        }

        public ExecutionOptions.Builder setNotifyOnCompletion(boolean var1) {
            this.field_4046 = var1;
            return this;
        }

        public ExecutionOptions.Builder setTrackingTag(String var1) {
            if(!ExecutionOptions.method_4484(var1)) {
                Object[] var2 = new Object[] {Integer.valueOf(65536)};
                throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", var2));
            } else {
                this.field_4045 = var1;
                return this;
            }
        }
    }
}
