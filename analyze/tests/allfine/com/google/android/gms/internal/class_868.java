package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.class_293;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

// $FF: renamed from: com.google.android.gms.internal.ns
public final class class_868 implements Moments {
    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient var1) {
        return var1.method_897(new class_868.class_1145(null) {
            // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
            protected void method_1248(class_293 var1) {
                var1.method_1850(this);
            }
        });
    }

    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient var1, final int var2, final String var3, final Uri var4, final String var5, final String var6) {
        return var1.method_897(new class_868.class_1145(null) {
            // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
            protected void method_1249(class_293 var1) {
                var1.method_1844(this, var2, var3, var4, var5, var6);
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient var1, final String var2) {
        return var1.method_899(new class_868.class_1522(null) {
            // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
            protected void method_1246(class_293 var1) {
                var1.removeMoment(var2);
                this.b(Status.field_4739);
            }
        });
    }

    public PendingResult<Status> write(GoogleApiClient var1, final Moment var2) {
        return var1.method_899(new class_868.class_1523(null) {
            // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
            protected void method_1244(class_293 var1) {
                var1.method_1845(this, var2);
            }
        });
    }

    private abstract static class class_1145 extends Plus.class_1173<Moments.LoadMomentsResult> {
        private class_1145() {
        }

        // $FF: synthetic method
        class_1145(Object var1) {
            this();
        }

        // $FF: renamed from: aC (com.google.android.gms.common.api.Status) com.google.android.gms.plus.Moments$LoadMomentsResult
        public Moments.LoadMomentsResult method_1247(final Status var1) {
            return new Moments.LoadMomentsResult() {
                public MomentBuffer getMomentBuffer() {
                    return null;
                }

                public String getNextPageToken() {
                    return null;
                }

                public Status getStatus() {
                    return var1;
                }

                public String getUpdated() {
                    return null;
                }

                public void release() {
                }
            };
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1247(var1);
        }
    }

    private abstract static class class_1522 extends Plus.class_1173<Status> {
        private class_1522() {
        }

        // $FF: synthetic method
        class_1522(Object var1) {
            this();
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1245(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        public Status method_1245(Status var1) {
            return var1;
        }
    }

    private abstract static class class_1523 extends Plus.class_1173<Status> {
        private class_1523() {
        }

        // $FF: synthetic method
        class_1523(Object var1) {
            this();
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1243(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        public Status method_1243(Status var1) {
            return var1;
        }
    }
}
