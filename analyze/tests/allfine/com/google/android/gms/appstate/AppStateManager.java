package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.internal.class_303;
import com.google.android.gms.internal.ib;

public final class AppStateManager {
    public static final Api<Api.NoOptions> API;
    // $FF: renamed from: CU com.google.android.gms.common.api.Api$c
    static final Api.class_1482<ib> field_3291 = new Api.class_1482();
    // $FF: renamed from: CV com.google.android.gms.common.api.Api$b
    private static final Api.class_1479<ib, Api.NoOptions> field_3292 = new Api.class_1479() {
        // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
        // $FF: synthetic method
        public Api.class_1478 method_373(Context var1, Looper var2, ClientSettings var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            return this.method_4073(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
        }

        // $FF: renamed from: b (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.ib
        public class_303 method_4073(Context var1, Looper var2, ClientSettings var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            return new class_303(var1, var2, var5, var6, var3.getAccountNameOrDefault(), (String[])var3.getScopes().toArray(new String[0]));
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };
    public static final Scope SCOPE_APP_STATE = new Scope("https://www.googleapis.com/auth/appstate");

    static {
        Api.class_1479 var0 = field_3292;
        Api.class_1482 var1 = field_3291;
        Scope[] var2 = new Scope[] {SCOPE_APP_STATE};
        API = new Api(var0, var1, var2);
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient) com.google.android.gms.internal.ib
    public static class_303 method_3754(GoogleApiClient var0) {
        boolean var1 = true;
        boolean var2;
        if(var0 != null) {
            var2 = var1;
        } else {
            var2 = false;
        }

        class_1090.method_5683(var2, "GoogleApiClient parameter is required.");
        class_1090.method_5676(var0.isConnected(), "GoogleApiClient must be connected.");
        class_303 var3 = (class_303)var0.method_896(field_3291);
        if(var3 == null) {
            var1 = false;
        }

        class_1090.method_5676(var1, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return var3;
    }

    public static PendingResult<AppStateManager.StateDeletedResult> delete(GoogleApiClient var0, final int var1) {
        return var0.method_899(new AppStateManager.class_1498(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.ib) void
            protected void method_1200(class_303 var1x) {
                var1x.method_2040(this, var1);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            public Result method_1104(Status var1x) {
                return this.method_1201(var1x);
            }

            // $FF: renamed from: g (com.google.android.gms.common.api.Status) com.google.android.gms.appstate.AppStateManager$StateDeletedResult
            public AppStateManager.StateDeletedResult method_1201(final Status var1x) {
                return new AppStateManager.StateDeletedResult() {
                    public int getStateKey() {
                        return var1;
                    }

                    public Status getStatus() {
                        return var1x;
                    }
                };
            }
        });
    }

    // $FF: renamed from: e (com.google.android.gms.common.api.Status) com.google.android.gms.appstate.AppStateManager$StateResult
    private static AppStateManager.StateResult method_3755(final Status var0) {
        return new AppStateManager.StateResult() {
            public AppStateManager.StateConflictResult getConflictResult() {
                return null;
            }

            public AppStateManager.StateLoadedResult getLoadedResult() {
                return null;
            }

            public Status getStatus() {
                return var0;
            }

            public void release() {
            }
        };
    }

    public static int getMaxNumKeys(GoogleApiClient var0) {
        return method_3754(var0).method_2046();
    }

    public static int getMaxStateSize(GoogleApiClient var0) {
        return method_3754(var0).method_2045();
    }

    public static PendingResult<AppStateManager.StateListResult> list(GoogleApiClient var0) {
        return var0.method_897(new AppStateManager.class_1415(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.ib) void
            protected void method_1199(class_303 var1) {
                var1.method_2039(this);
            }
        });
    }

    public static PendingResult<AppStateManager.StateResult> load(GoogleApiClient var0, final int var1) {
        return var0.method_897(new AppStateManager.class_1500(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.ib) void
            protected void method_1192(class_303 var1x) {
                var1x.method_2044(this, var1);
            }
        });
    }

    public static PendingResult<AppStateManager.StateResult> resolve(GoogleApiClient var0, final int var1, final String var2, final byte[] var3) {
        return var0.method_899(new AppStateManager.class_1500(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.ib) void
            protected void method_1194(class_303 var1x) {
                var1x.method_2041(this, var1, var2, var3);
            }
        });
    }

    public static PendingResult<Status> signOut(GoogleApiClient var0) {
        return var0.method_899(new AppStateManager.class_1499(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.ib) void
            protected void method_1197(class_303 var1) {
                var1.method_2043(this);
            }
        });
    }

    public static void update(GoogleApiClient var0, final int var1, final byte[] var2) {
        var0.method_899(new AppStateManager.class_1500(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.ib) void
            protected void method_1195(class_303 var1x) {
                var1x.method_2042((BaseImplementation.class_1147)null, var1, var2);
            }
        });
    }

    public static PendingResult<AppStateManager.StateResult> updateImmediate(GoogleApiClient var0, final int var1, final byte[] var2) {
        return var0.method_899(new AppStateManager.class_1500(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.ib) void
            protected void method_1193(class_303 var1x) {
                var1x.method_2042(this, var1, var2);
            }
        });
    }

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    public interface StateResult extends Releasable, Result {
        AppStateManager.StateConflictResult getConflictResult();

        AppStateManager.StateLoadedResult getLoadedResult();
    }

    public abstract static class class_1497<R extends Result> extends BaseImplementation.class_1146<R, ib> {
        public class_1497() {
            super(AppStateManager.field_3291);
        }
    }

    private abstract static class class_1498 extends AppStateManager.class_1497<AppStateManager.StateDeletedResult> {
        private class_1498() {
        }

        // $FF: synthetic method
        class_1498(Object var1) {
            this();
        }
    }

    private abstract static class class_1415 extends AppStateManager.class_1497<AppStateManager.StateListResult> {
        private class_1415() {
        }

        // $FF: synthetic method
        class_1415(Object var1) {
            this();
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1198(var1);
        }

        // $FF: renamed from: h (com.google.android.gms.common.api.Status) com.google.android.gms.appstate.AppStateManager$StateListResult
        public AppStateManager.StateListResult method_1198(final Status var1) {
            return new AppStateManager.StateListResult() {
                public AppStateBuffer getStateBuffer() {
                    return new AppStateBuffer((DataHolder)null);
                }

                public Status getStatus() {
                    return var1;
                }
            };
        }
    }

    private abstract static class class_1499 extends AppStateManager.class_1497<Status> {
        private class_1499() {
        }

        // $FF: synthetic method
        class_1499(Object var1) {
            this();
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1196(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        public Status method_1196(Status var1) {
            return var1;
        }
    }

    private abstract static class class_1500 extends AppStateManager.class_1497<AppStateManager.StateResult> {
        private class_1500() {
        }

        // $FF: synthetic method
        class_1500(Object var1) {
            this();
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1191(var1);
        }

        // $FF: renamed from: i (com.google.android.gms.common.api.Status) com.google.android.gms.appstate.AppStateManager$StateResult
        public AppStateManager.StateResult method_1191(Status var1) {
            return AppStateManager.method_3755(var1);
        }
    }
}
