package com.google.android.gms.cast;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.internal.class_304;
import com.google.android.gms.internal.ij;
import java.io.IOException;

public final class Cast {
    public static final Api<Cast.CastOptions> API;
    // $FF: renamed from: CU com.google.android.gms.common.api.Api$c
    static final Api.class_1482<ij> field_4034 = new Api.class_1482();
    // $FF: renamed from: CV com.google.android.gms.common.api.Api$b
    private static final Api.class_1479<ij, Cast.CastOptions> field_4035 = new Api.class_1479() {
        // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.cast.Cast$CastOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.ij
        public class_304 method_5516(Context var1, Looper var2, ClientSettings var3, Cast.CastOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            class_1090.method_5681(var4, "Setting the API options is required.");
            return new class_304(var1, var2, var4.field_4785, (long)var4.field_4787, var4.field_4786, var5, var6);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };
    public static final Cast.CastApi CastApi;
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;

    static {
        API = new Api(field_4035, field_4034, new Scope[0]);
        CastApi = new Cast.class_1683();
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public interface CastApi {
        ApplicationMetadata getApplicationMetadata(GoogleApiClient var1) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient var1) throws IllegalStateException;

        double getVolume(GoogleApiClient var1) throws IllegalStateException;

        boolean isMute(GoogleApiClient var1) throws IllegalStateException;

        PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient var1);

        PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient var1, String var2);

        PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient var1, String var2, String var3);

        PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, String var2);

        PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, String var2, LaunchOptions var3);

        @Deprecated
        PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, String var2, boolean var3);

        PendingResult<Status> leaveApplication(GoogleApiClient var1);

        void removeMessageReceivedCallbacks(GoogleApiClient var1, String var2) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient var1) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient var1, String var2, String var3);

        void setMessageReceivedCallbacks(GoogleApiClient var1, String var2, Cast.MessageReceivedCallback var3) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient var1, boolean var2) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient var1, double var2) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient var1);

        PendingResult<Status> stopApplication(GoogleApiClient var1, String var2);
    }

    public static final class class_1683 implements Cast.CastApi {
        public ApplicationMetadata getApplicationMetadata(GoogleApiClient var1) throws IllegalStateException {
            return ((class_304)var1.method_896(Cast.field_4034)).getApplicationMetadata();
        }

        public String getApplicationStatus(GoogleApiClient var1) throws IllegalStateException {
            return ((class_304)var1.method_896(Cast.field_4034)).getApplicationStatus();
        }

        public double getVolume(GoogleApiClient var1) throws IllegalStateException {
            return ((class_304)var1.method_896(Cast.field_4034)).method_2085();
        }

        public boolean isMute(GoogleApiClient var1) throws IllegalStateException {
            return ((class_304)var1.method_896(Cast.field_4034)).isMute();
        }

        public PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient var1) {
            return var1.method_899(new Cast.class_1318(null) {
                // $FF: renamed from: a (com.google.android.gms.internal.ij) void
                protected void method_1265(class_304 var1) throws RemoteException {
                    try {
                        var1.method_2082((String)null, (String)null, this);
                    } catch (IllegalStateException var3) {
                        this.V(2001);
                    }
                }
            });
        }

        public PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient var1, final String var2) {
            return var1.method_899(new Cast.class_1318(null) {
                // $FF: renamed from: a (com.google.android.gms.internal.ij) void
                protected void method_1266(class_304 var1) throws RemoteException {
                    try {
                        var1.method_2082(var2, (String)null, this);
                    } catch (IllegalStateException var3) {
                        this.V(2001);
                    }
                }
            });
        }

        public PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient var1, final String var2, final String var3) {
            return var1.method_899(new Cast.class_1318(null) {
                // $FF: renamed from: a (com.google.android.gms.internal.ij) void
                protected void method_1267(class_304 var1) throws RemoteException {
                    try {
                        var1.method_2082(var2, var3, this);
                    } catch (IllegalStateException var3x) {
                        this.V(2001);
                    }
                }
            });
        }

        public PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, final String var2) {
            return var1.method_899(new Cast.class_1318(null) {
                // $FF: renamed from: a (com.google.android.gms.internal.ij) void
                protected void method_1269(class_304 var1) throws RemoteException {
                    try {
                        var1.method_2080(var2, false, this);
                    } catch (IllegalStateException var3) {
                        this.V(2001);
                    }
                }
            });
        }

        public PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, final String var2, final LaunchOptions var3) {
            return var1.method_899(new Cast.class_1318(null) {
                // $FF: renamed from: a (com.google.android.gms.internal.ij) void
                protected void method_1268(class_304 var1) throws RemoteException {
                    try {
                        var1.method_2077(var2, var3, this);
                    } catch (IllegalStateException var3x) {
                        this.V(2001);
                    }
                }
            });
        }

        @Deprecated
        public PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, String var2, boolean var3) {
            return this.launchApplication(var1, var2, (new LaunchOptions.Builder()).setRelaunchIfRunning(var3).build());
        }

        public PendingResult<Status> leaveApplication(GoogleApiClient var1) {
            return var1.method_899(new Cast.class_1685(null) {
                // $FF: renamed from: a (com.google.android.gms.internal.ij) void
                protected void method_1273(class_304 var1) throws RemoteException {
                    try {
                        var1.method_2083(this);
                    } catch (IllegalStateException var3) {
                        this.V(2001);
                    }
                }
            });
        }

        public void removeMessageReceivedCallbacks(GoogleApiClient var1, String var2) throws IOException, IllegalArgumentException {
            try {
                ((class_304)var1.method_896(Cast.field_4034)).method_2081(var2);
            } catch (RemoteException var4) {
                throw new IOException("service error");
            }
        }

        public void requestStatus(GoogleApiClient var1) throws IOException, IllegalStateException {
            try {
                ((class_304)var1.method_896(Cast.field_4034)).method_2084();
            } catch (RemoteException var3) {
                throw new IOException("service error");
            }
        }

        public PendingResult<Status> sendMessage(GoogleApiClient var1, final String var2, final String var3) {
            return var1.method_899(new Cast.class_1685(null) {
                // $FF: renamed from: a (com.google.android.gms.internal.ij) void
                protected void method_1274(class_304 var1) throws RemoteException {
                    try {
                        var1.method_2079(var2, var3, this);
                    } catch (IllegalArgumentException var4) {
                        this.V(2001);
                    } catch (IllegalStateException var5) {
                        this.V(2001);
                    }
                }
            });
        }

        public void setMessageReceivedCallbacks(GoogleApiClient var1, String var2, Cast.MessageReceivedCallback var3) throws IOException, IllegalStateException {
            try {
                ((class_304)var1.method_896(Cast.field_4034)).method_2076(var2, var3);
            } catch (RemoteException var5) {
                throw new IOException("service error");
            }
        }

        public void setMute(GoogleApiClient var1, boolean var2) throws IOException, IllegalStateException {
            try {
                ((class_304)var1.method_896(Cast.field_4034)).method_2073(var2);
            } catch (RemoteException var4) {
                throw new IOException("service error");
            }
        }

        public void setVolume(GoogleApiClient var1, double var2) throws IOException, IllegalArgumentException, IllegalStateException {
            try {
                ((class_304)var1.method_896(Cast.field_4034)).method_2075(var2);
            } catch (RemoteException var5) {
                throw new IOException("service error");
            }
        }

        public PendingResult<Status> stopApplication(GoogleApiClient var1) {
            return var1.method_899(new Cast.class_1685(null) {
                // $FF: renamed from: a (com.google.android.gms.internal.ij) void
                protected void method_1272(class_304 var1) throws RemoteException {
                    try {
                        var1.method_2078("", this);
                    } catch (IllegalStateException var3) {
                        this.V(2001);
                    }
                }
            });
        }

        public PendingResult<Status> stopApplication(GoogleApiClient var1, final String var2) {
            return var1.method_899(new Cast.class_1685(null) {
                // $FF: renamed from: a (com.google.android.gms.internal.ij) void
                protected void method_1271(class_304 var1) throws RemoteException {
                    if(TextUtils.isEmpty(var2)) {
                        this.e(2001, "IllegalArgument: sessionId cannot be null or empty");
                    } else {
                        try {
                            var1.method_2078(var2, this);
                        } catch (IllegalStateException var3) {
                            this.V(2001);
                        }
                    }
                }
            });
        }
    }

    public static final class CastOptions implements Api.HasOptions {
        // $FF: renamed from: EK com.google.android.gms.cast.CastDevice
        final CastDevice field_4785;
        // $FF: renamed from: EL com.google.android.gms.cast.Cast$Listener
        final Cast.Listener field_4786;
        // $FF: renamed from: EM int
        private final int field_4787;

        private CastOptions(Cast.Builder var1) {
            this.field_4785 = var1.field_4876;
            this.field_4786 = var1.field_4877;
            this.field_4787 = var1.field_4878;
        }

        // $FF: synthetic method
        CastOptions(Cast.Builder var1, Object var2) {
            this(var1);
        }

        public static Cast.Builder builder(CastDevice var0, Cast.Listener var1) {
            return new Cast.Builder(var0, var1, null);
        }
    }

    public static final class Builder {
        // $FF: renamed from: EN com.google.android.gms.cast.CastDevice
        CastDevice field_4876;
        // $FF: renamed from: EO com.google.android.gms.cast.Cast$Listener
        Cast.Listener field_4877;
        // $FF: renamed from: EP int
        private int field_4878;

        private Builder(CastDevice var1, Cast.Listener var2) {
            class_1090.method_5681(var1, "CastDevice parameter cannot be null");
            class_1090.method_5681(var2, "CastListener parameter cannot be null");
            this.field_4876 = var1;
            this.field_4877 = var2;
            this.field_4878 = 0;
        }

        // $FF: synthetic method
        Builder(CastDevice var1, Cast.Listener var2, Object var3) {
            this(var1, var2);
        }

        public Cast.CastOptions build() {
            return new Cast.CastOptions(this, null);
        }

        public Cast.Builder setVerboseLoggingEnabled(boolean var1) {
            if(var1) {
                this.field_4878 |= 1;
                return this;
            } else {
                this.field_4878 &= -2;
                return this;
            }
        }
    }

    public static class Listener {
        // $FF: renamed from: W (int) void
        public void method_4108(int var1) {
        }

        // $FF: renamed from: X (int) void
        public void method_4109(int var1) {
        }

        public void onApplicationDisconnected(int var1) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice var1, String var2, String var3);
    }

    protected abstract static class class_1684<R extends Result> extends BaseImplementation.class_1146<R, ij> {
        public class_1684() {
            super(Cast.field_4034);
        }

        // $FF: renamed from: V (int) void
        public void method_1262(int var1) {
            this.b(this.c(new Status(var1)));
        }

        // $FF: renamed from: e (int, java.lang.String) void
        public void method_1263(int var1, String var2) {
            this.b(this.c(new Status(var1, var2, (PendingIntent)null)));
        }
    }

    private abstract static class class_1685 extends Cast.class_1684<Status> {
        private class_1685() {
        }

        // $FF: synthetic method
        class_1685(Object var1) {
            this();
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1270(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        public Status method_1270(Status var1) {
            return var1;
        }
    }

    private abstract static class class_1318 extends Cast.class_1684<Cast.ApplicationConnectionResult> {
        private class_1318() {
        }

        // $FF: synthetic method
        class_1318(Object var1) {
            this();
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1264(var1);
        }

        // $FF: renamed from: j (com.google.android.gms.common.api.Status) com.google.android.gms.cast.Cast$ApplicationConnectionResult
        public Cast.ApplicationConnectionResult method_1264(final Status var1) {
            return new Cast.ApplicationConnectionResult() {
                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                public String getApplicationStatus() {
                    return null;
                }

                public String getSessionId() {
                    return null;
                }

                public Status getStatus() {
                    return var1;
                }

                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }
}
