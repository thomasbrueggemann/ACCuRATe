package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.AccountChangeEvent;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.auth.UserRecoverableNotifiedException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.class_949;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_64;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public final class GoogleAuthUtil {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    // $FF: renamed from: Dn android.content.ComponentName
    private static final ComponentName field_5237;
    // $FF: renamed from: Do android.content.ComponentName
    private static final ComponentName field_5238;
    // $FF: renamed from: Dp android.content.Intent
    private static final Intent field_5239;
    // $FF: renamed from: Dq android.content.Intent
    private static final Intent field_5240;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME;
    public static final String KEY_CALLER_UID;
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
    @Deprecated
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";

    static {
        String var0;
        if(VERSION.SDK_INT >= 11) {
            var0 = "callerUid";
        } else {
            var0 = "callerUid";
        }

        KEY_CALLER_UID = var0;
        String var1;
        if(VERSION.SDK_INT >= 14) {
            var1 = "androidPackageName";
        } else {
            var1 = "androidPackageName";
        }

        KEY_ANDROID_PACKAGE_NAME = var1;
        field_5237 = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
        field_5238 = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
        field_5239 = (new Intent()).setPackage("com.google.android.gms").setComponent(field_5237);
        field_5240 = (new Intent()).setPackage("com.google.android.gms").setComponent(field_5238);
    }

    // $FF: renamed from: D (android.content.Context) void
    private static void method_5859(Context var0) throws GoogleAuthException {
        try {
            GooglePlayServicesUtil.method_4955(var0);
        } catch (GooglePlayServicesRepairableException var3) {
            throw new GooglePlayServicesAvailabilityException(var3.getConnectionStatusCode(), var3.getMessage(), var3.getIntent());
        } catch (GooglePlayServicesNotAvailableException var4) {
            throw new GoogleAuthException(var4.getMessage());
        }
    }

    // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String, android.os.Bundle) java.lang.String
    private static String method_5860(Context var0, String var1, String var2, Bundle var3) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if(var3 == null) {
            var3 = new Bundle();
        }

        try {
            String var9 = getToken(var0, var1, var2, var3);
            return var9;
        } catch (GooglePlayServicesAvailabilityException var10) {
            int var6 = var10.getConnectionStatusCode();
            if(method_5863(var0, var6)) {
                GoogleAuthUtil.class_1792 var7 = new GoogleAuthUtil.class_1792(var0.getApplicationContext());
                var7.sendMessageDelayed(var7.obtainMessage(1), 30000L);
            } else {
                GooglePlayServicesUtil.showErrorNotification(var6, var0);
            }

            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        } catch (UserRecoverableAuthException var11) {
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        }
    }

    // $FF: renamed from: aw (java.lang.String) boolean
    private static boolean method_5861(String var0) {
        return "NetworkError".equals(var0) || "ServiceUnavailable".equals(var0) || "Timeout".equals(var0);
    }

    // $FF: renamed from: ax (java.lang.String) boolean
    private static boolean method_5862(String var0) {
        return "BadAuthentication".equals(var0) || "CaptchaRequired".equals(var0) || "DeviceManagementRequiredOrSyncDisabled".equals(var0) || "NeedPermission".equals(var0) || "NeedsBrowser".equals(var0) || "UserCancel".equals(var0) || "AppDownloadRequired".equals(var0) || class_335.field_1160.method_2306().equals(var0) || class_335.field_1161.method_2306().equals(var0) || class_335.field_1162.method_2306().equals(var0) || class_335.field_1163.method_2306().equals(var0) || class_335.field_1164.method_2306().equals(var0) || class_335.field_1165.method_2306().equals(var0);
    }

    // $FF: renamed from: b (android.content.Context, int) boolean
    private static boolean method_5863(Context var0, int var1) {
        if(var1 == 1) {
            PackageManager var2 = var0.getPackageManager();

            boolean var4;
            try {
                var4 = var2.getApplicationInfo("com.google.android.gms", 8192).enabled;
            } catch (NameNotFoundException var5) {
                return false;
            }

            if(var4) {
                return true;
            }
        }

        return false;
    }

    public static void clearToken(Context var0, String var1) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        Context var2 = var0.getApplicationContext();
        class_1090.method_5679("Calling this from your main thread can lead to deadlock");
        method_5859(var2);
        Bundle var3 = new Bundle();
        String var4 = var0.getApplicationInfo().packageName;
        var3.putString("clientPackageName", var4);
        if(!var3.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            var3.putString(KEY_ANDROID_PACKAGE_NAME, var4);
        }

        class_949 var5 = new class_949();
        if(!var2.bindService(field_5239, var5, 1)) {
            throw new IOException("Could not bind to service with the given context.");
        } else {
            try {
                Bundle var10 = class_64.class_1411.method_5515(var5.method_4986()).method_313(var1, var3);
                String var11 = var10.getString(class_335.field_1188);
                if(!var10.getBoolean("booleanResult")) {
                    throw new GoogleAuthException(var11);
                }
            } catch (RemoteException var15) {
                Log.i("GoogleAuthUtil", "GMS remote exception ", var15);
                throw new IOException("remote exception");
            } catch (InterruptedException var16) {
                throw new GoogleAuthException("Interrupted");
            } finally {
                var2.unbindService(var5);
            }

        }
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context var0, int var1, String var2) throws GoogleAuthException, IOException {
        class_1090.method_5682(var2, "accountName must be provided");
        class_1090.method_5679("Calling this from your main thread can lead to deadlock");
        Context var4 = var0.getApplicationContext();
        method_5859(var4);
        class_949 var5 = new class_949();
        if(var4.bindService(field_5239, var5, 1)) {
            List var10;
            try {
                var10 = class_64.class_1411.method_5515(var5.method_4986()).method_315((new AccountChangeEventsRequest()).setAccountName(var2).setEventIndex(var1)).getEvents();
            } catch (RemoteException var14) {
                Log.i("GoogleAuthUtil", "GMS remote exception ", var14);
                throw new IOException("remote exception");
            } catch (InterruptedException var15) {
                throw new GoogleAuthException("Interrupted");
            } finally {
                var4.unbindService(var5);
            }

            return var10;
        } else {
            throw new IOException("Could not bind to service with the given context.");
        }
    }

    public static String getAccountId(Context var0, String var1) throws GoogleAuthException, IOException {
        class_1090.method_5682(var1, "accountName must be provided");
        class_1090.method_5679("Calling this from your main thread can lead to deadlock");
        method_5859(var0.getApplicationContext());
        return getToken(var0, var1, "^^_account_id_^^", new Bundle());
    }

    public static String getAppCert(Context var0, String var1) {
        return "spatula";
    }

    public static String getToken(Context var0, String var1, String var2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(var0, var1, var2, new Bundle());
    }

    public static String getToken(Context param0, String param1, String param2, Bundle param3) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        // $FF: Couldn't be decompiled
    }

    public static String getTokenWithNotification(Context var0, String var1, String var2, Bundle var3) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if(var3 == null) {
            var3 = new Bundle();
        }

        var3.putBoolean("handle_notification", true);
        return method_5860(var0, var1, var2, var3);
    }

    public static String getTokenWithNotification(Context var0, String var1, String var2, Bundle var3, Intent var4) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        method_5864(var4);
        if(var3 == null) {
            var3 = new Bundle();
        }

        var3.putParcelable("callback_intent", var4);
        var3.putBoolean("handle_notification", true);
        return method_5860(var0, var1, var2, var3);
    }

    public static String getTokenWithNotification(Context var0, String var1, String var2, Bundle var3, String var4, Bundle var5) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if(TextUtils.isEmpty(var4)) {
            throw new IllegalArgumentException("Authority cannot be empty or null.");
        } else {
            if(var3 == null) {
                var3 = new Bundle();
            }

            if(var5 == null) {
                var5 = new Bundle();
            }

            ContentResolver.validateSyncExtrasBundle(var5);
            var3.putString("authority", var4);
            var3.putBundle("sync_extras", var5);
            var3.putBoolean("handle_notification", true);
            return method_5860(var0, var1, var2, var3);
        }
    }

    // $FF: renamed from: h (android.content.Intent) void
    private static void method_5864(Intent var0) {
        if(var0 == null) {
            throw new IllegalArgumentException("Callback cannot be null.");
        } else {
            String var1 = var0.toUri(1);

            try {
                Intent.parseUri(var1, 1);
            } catch (URISyntaxException var3) {
                throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
            }
        }
    }

    @Deprecated
    public static void invalidateToken(Context var0, String var1) {
        AccountManager.get(var0).invalidateAuthToken("com.google", var1);
    }

    private static class class_1792 extends Handler {
        // $FF: renamed from: mD android.content.Context
        private final Context field_4747;

        class_1792(Context var1) {
            Looper var2;
            if(Looper.myLooper() == null) {
                var2 = Looper.getMainLooper();
            } else {
                var2 = Looper.myLooper();
            }

            super(var2);
            this.field_4747 = var1;
        }

        public void handleMessage(Message var1) {
            if(var1.what == 1) {
                int var3 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.field_4747);
                if(GooglePlayServicesUtil.isUserRecoverableError(var3)) {
                    GooglePlayServicesUtil.showErrorNotification(var3, this.field_4747);
                }

            } else {
                Log.wtf("GoogleAuthUtil", "Don\'t know how to handle this message: " + var1.what);
            }
        }
    }
}
