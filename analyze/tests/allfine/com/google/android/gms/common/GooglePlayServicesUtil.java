package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.AlertDialog.Builder;
import android.app.Notification.BigTextStyle;
import android.content.Context;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.class_492;
import com.google.android.gms.common.ErrorDialogFragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.SupportErrorDialogFragment;
import com.google.android.gms.common.class_948;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.class_1091;
import com.google.android.gms.common.internal.class_1095;
import com.google.android.gms.common.internal.class_1096;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_854;
import java.util.Arrays;
import java.util.Set;

public final class GooglePlayServicesUtil {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 6171000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    // $FF: renamed from: Ii boolean
    public static boolean field_4372 = false;
    // $FF: renamed from: Ij boolean
    public static boolean field_4373 = false;
    // $FF: renamed from: Ik int
    private static int field_4374 = -1;
    // $FF: renamed from: Il java.lang.Object
    private static final Object field_4375 = new Object();

    // $FF: renamed from: D (android.content.Context) void
    public static void method_4955(Context var0) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int var1 = isGooglePlayServicesAvailable(var0);
        if(var1 != 0) {
            Intent var2 = method_4967(var0, var1);
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + var1);
            if(var2 == null) {
                throw new GooglePlayServicesNotAvailableException(var1);
            } else {
                throw new GooglePlayServicesRepairableException(var1, "Google Play Services not available", var2);
            }
        }
    }

    // $FF: renamed from: E (android.content.Context) void
    private static void method_4956(Context var0) {
        ApplicationInfo var3;
        label20: {
            ApplicationInfo var6;
            try {
                var6 = var0.getPackageManager().getApplicationInfo(var0.getPackageName(), 128);
            } catch (NameNotFoundException var7) {
                Log.wtf("GooglePlayServicesUtil", "This should never happen.", var7);
                var3 = null;
                break label20;
            }

            var3 = var6;
        }

        Bundle var4 = var3.metaData;
        if(var4 != null) {
            int var5 = var4.getInt("com.google.android.gms.version");
            if(var5 != 6171000) {
                throw new IllegalStateException("The meta-data tag in your app\'s AndroidManifest.xml does not have the right value.  Expected 6171000 but found " + var5 + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
            }
        } else {
            throw new IllegalStateException("A required meta-data tag in your app\'s AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
    }

    // $FF: renamed from: F (android.content.Context) java.lang.String
    private static String method_4957(Context var0) {
        String var1 = var0.getApplicationInfo().name;
        if(TextUtils.isEmpty(var1)) {
            var1 = var0.getPackageName();
            PackageManager var2 = var0.getApplicationContext().getPackageManager();

            ApplicationInfo var4;
            label17: {
                ApplicationInfo var5;
                try {
                    var5 = var2.getApplicationInfo(var0.getPackageName(), 0);
                } catch (NameNotFoundException var6) {
                    var4 = null;
                    break label17;
                }

                var4 = var5;
            }

            if(var4 != null) {
                var1 = var2.getApplicationLabel(var4).toString();
            }
        }

        return var1;
    }

    // $FF: renamed from: a (int, android.app.Activity, android.support.v4.app.Fragment, int, android.content.DialogInterface.OnCancelListener) android.app.Dialog
    private static Dialog method_4958(int var0, Activity var1, Fragment var2, int var3, OnCancelListener var4) {
        if(class_347.method_2327(var1) && var0 == 2) {
            var0 = 42;
        }

        Builder var7;
        label48: {
            if(class_854.method_4496()) {
                TypedValue var5 = new TypedValue();
                var1.getTheme().resolveAttribute(16843529, var5, true);
                if("Theme.Dialog.Alert".equals(var1.getResources().getResourceEntryName(var5.resourceId))) {
                    var7 = new Builder(var1, 5);
                    break label48;
                }
            }

            var7 = null;
        }

        if(var7 == null) {
            var7 = new Builder(var1);
        }

        var7.setMessage(method_4969(var1, var0));
        if(var4 != null) {
            var7.setOnCancelListener(var4);
        }

        Intent var9 = method_4967(var1, var0);
        class_1095 var10;
        if(var2 == null) {
            var10 = new class_1095(var1, var9, var3);
        } else {
            var10 = new class_1095(var2, var9, var3);
        }

        String var11 = method_4970(var1, var0);
        if(var11 != null) {
            var7.setPositiveButton(var11, var10);
        }

        switch(var0) {
            case 0:
                return null;
            case 1:
                return var7.setTitle(class_492.string.common_google_play_services_install_title).create();
            case 2:
                return var7.setTitle(class_492.string.common_google_play_services_update_title).create();
            case 3:
                return var7.setTitle(class_492.string.common_google_play_services_enable_title).create();
            case 4:
            case 6:
                return var7.create();
            case 5:
                Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
                return var7.setTitle(class_492.string.common_google_play_services_invalid_account_title).create();
            case 7:
                Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
                return var7.setTitle(class_492.string.common_google_play_services_network_error_title).create();
            case 8:
                Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
                return var7.create();
            case 9:
                Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
                return var7.setTitle(class_492.string.common_google_play_services_unsupported_title).create();
            case 10:
                Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
                return var7.create();
            case 11:
                Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
                return var7.create();
            case 42:
                return var7.setTitle(class_492.string.common_android_wear_update_title).create();
            default:
                Log.e("GooglePlayServicesUtil", "Unexpected error code " + var0);
                return var7.create();
        }
    }

    // $FF: renamed from: a (android.content.pm.PackageManager, android.content.pm.PackageInfo) boolean
    public static boolean method_4959(PackageManager var0, PackageInfo var1) {
        boolean var2 = true;
        boolean var3 = false;
        if(var1 != null) {
            if(method_4968(var0)) {
                if(method_4961(var1, var2) == null) {
                    var2 = false;
                }

                return var2;
            }

            byte[] var4 = method_4961(var1, false);
            var3 = false;
            if(var4 != null) {
                var3 = var2;
            }

            if(!var3 && method_4961(var1, var2) != null) {
                Log.w("GooglePlayServicesUtil", "Test-keys aren\'t accepted on this build.");
                return var3;
            }
        }

        return var3;
    }

    // $FF: renamed from: a (android.content.res.Resources) boolean
    public static boolean method_4960(Resources var0) {
        if(var0 != null) {
            boolean var1;
            if((15 & var0.getConfiguration().screenLayout) > 3) {
                var1 = true;
            } else {
                var1 = false;
            }

            if(class_854.method_4493() && var1 || method_4966(var0)) {
                return true;
            }
        }

        return false;
    }

    // $FF: renamed from: a (android.content.pm.PackageInfo, boolean) byte[]
    private static byte[] method_4961(PackageInfo var0, boolean var1) {
        if(var0.signatures.length != 1) {
            Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
            return null;
        } else {
            byte[] var2 = var0.signatures[0].toByteArray();
            Set var3;
            if(var1) {
                var3 = class_948.method_4984();
            } else {
                var3 = class_948.method_4985();
            }

            if(var3.contains(var2)) {
                return var2;
            } else {
                if(Log.isLoggable("GooglePlayServicesUtil", 2)) {
                    Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(var2, 0));
                }

                return null;
            }
        }
    }

    // $FF: renamed from: a (android.content.pm.PackageInfo, byte[][]) byte[]
    private static byte[] method_4962(PackageInfo var0, byte[]... var1) {
        if(var0.signatures.length != 1) {
            Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
            return null;
        } else {
            byte[] var2 = var0.signatures[0].toByteArray();

            for(int var3 = 0; var3 < var1.length; ++var3) {
                byte[] var5 = var1[var3];
                if(Arrays.equals(var5, var2)) {
                    return var5;
                }
            }

            if(Log.isLoggable("GooglePlayServicesUtil", 2)) {
                Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(var2, 0));
            }

            return null;
        }
    }

    // $FF: renamed from: ai (int) android.content.Intent
    public static Intent method_4963(int var0) {
        switch(var0) {
            case 1:
            case 2:
                return class_1091.method_5688("com.google.android.gms");
            case 3:
                return class_1091.method_5686("com.google.android.gms");
            case 42:
                return class_1091.method_5689();
            default:
                return null;
        }
    }

    // $FF: renamed from: b (android.content.pm.PackageManager) boolean
    public static boolean method_4964(PackageManager param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (android.content.pm.PackageManager, java.lang.String) boolean
    public static boolean method_4965(PackageManager var0, String var1) {
        PackageInfo var4;
        try {
            var4 = var0.getPackageInfo(var1, 64);
        } catch (NameNotFoundException var5) {
            if(Log.isLoggable("GooglePlayServicesUtil", 3)) {
                Log.d("GooglePlayServicesUtil", "Package manager can\'t find package " + var1 + ", defaulting to false");
            }

            return false;
        }

        return method_4959(var0, var4);
    }

    // $FF: renamed from: b (android.content.res.Resources) boolean
    private static boolean method_4966(Resources var0) {
        Configuration var1 = var0.getConfiguration();
        boolean var2 = class_854.method_4495();
        boolean var3 = false;
        if(var2) {
            int var4 = 15 & var1.screenLayout;
            var3 = false;
            if(var4 <= 3) {
                int var5 = var1.smallestScreenWidthDp;
                var3 = false;
                if(var5 >= 600) {
                    var3 = true;
                }
            }
        }

        return var3;
    }

    // $FF: renamed from: c (android.content.Context, int) android.content.Intent
    @Deprecated
    public static Intent method_4967(Context var0, int var1) {
        return method_4963(var1);
    }

    // $FF: renamed from: c (android.content.pm.PackageManager) boolean
    public static boolean method_4968(PackageManager var0) {
        return method_4964(var0) || !method_4972();
    }

    // $FF: renamed from: d (android.content.Context, int) java.lang.String
    public static String method_4969(Context var0, int var1) {
        Resources var2 = var0.getResources();
        switch(var1) {
            case 1:
                if(method_4960(var0.getResources())) {
                    return var2.getString(class_492.string.common_google_play_services_install_text_tablet);
                }

                return var2.getString(class_492.string.common_google_play_services_install_text_phone);
            case 2:
                return var2.getString(class_492.string.common_google_play_services_update_text);
            case 3:
                return var2.getString(class_492.string.common_google_play_services_enable_text);
            case 5:
                return var2.getString(class_492.string.common_google_play_services_invalid_account_text);
            case 7:
                return var2.getString(class_492.string.common_google_play_services_network_error_text);
            case 9:
                return var2.getString(class_492.string.common_google_play_services_unsupported_text);
            case 42:
                return var2.getString(class_492.string.common_android_wear_update_text);
            default:
                return var2.getString(class_492.string.common_google_play_services_unknown_issue);
        }
    }

    // $FF: renamed from: e (android.content.Context, int) java.lang.String
    public static String method_4970(Context var0, int var1) {
        Resources var2 = var0.getResources();
        switch(var1) {
            case 1:
                return var2.getString(class_492.string.common_google_play_services_install_button);
            case 2:
            case 42:
                return var2.getString(class_492.string.common_google_play_services_update_button);
            case 3:
                return var2.getString(class_492.string.common_google_play_services_enable_button);
            default:
                return var2.getString(17039370);
        }
    }

    // $FF: renamed from: f (android.content.Context, int) java.lang.String
    public static String method_4971(Context var0, int var1) {
        Resources var2 = var0.getResources();
        switch(var1) {
            case 1:
                return var2.getString(class_492.string.common_google_play_services_notification_needs_installation_title);
            case 2:
                return var2.getString(class_492.string.common_google_play_services_notification_needs_update_title);
            case 3:
                return var2.getString(class_492.string.common_google_play_services_needs_enabling_title);
            case 5:
                return var2.getString(class_492.string.common_google_play_services_invalid_account_text);
            case 7:
                return var2.getString(class_492.string.common_google_play_services_network_error_text);
            case 9:
                return var2.getString(class_492.string.common_google_play_services_unsupported_text);
            case 42:
                return var2.getString(class_492.string.common_android_wear_notification_needs_update_text);
            default:
                return var2.getString(class_492.string.common_google_play_services_unknown_issue);
        }
    }

    // $FF: renamed from: ga () boolean
    public static boolean method_4972() {
        return field_4372?field_4373:"user".equals(Build.TYPE);
    }

    public static Dialog getErrorDialog(int var0, Activity var1, int var2) {
        return getErrorDialog(var0, var1, var2, (OnCancelListener)null);
    }

    public static Dialog getErrorDialog(int var0, Activity var1, int var2, OnCancelListener var3) {
        return method_4958(var0, var1, (Fragment)null, var2, var3);
    }

    public static PendingIntent getErrorPendingIntent(int var0, Context var1, int var2) {
        Intent var3 = method_4967(var1, var0);
        return var3 == null?null:PendingIntent.getActivity(var1, var2, var3, 268435456);
    }

    public static String getErrorString(int var0) {
        switch(var0) {
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                return "UNKNOWN_ERROR_CODE";
        }
    }

    public static String getOpenSourceSoftwareLicenseInfo(Context param0) {
        // $FF: Couldn't be decompiled
    }

    public static Context getRemoteContext(Context var0) {
        try {
            Context var2 = var0.createPackageContext("com.google.android.gms", 3);
            return var2;
        } catch (NameNotFoundException var3) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context var0) {
        try {
            Resources var2 = var0.getPackageManager().getResourcesForApplication("com.google.android.gms");
            return var2;
        } catch (NameNotFoundException var3) {
            return null;
        }
    }

    public static int isGooglePlayServicesAvailable(Context var0) {
        PackageManager var1 = var0.getPackageManager();
        if(!class_1096.field_5146) {
            try {
                var0.getResources().getString(class_492.string.common_google_play_services_unknown_issue);
            } catch (Throwable var30) {
                Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
            }
        }

        if(!class_1096.field_5146) {
            method_4956(var0);
        }

        PackageInfo var4;
        try {
            var4 = var1.getPackageInfo("com.google.android.gms", 64);
        } catch (NameNotFoundException var29) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }

        if(class_347.method_2330(var4.versionCode)) {
            byte var17;
            if(method_4972()) {
                var17 = 0;
            } else {
                var17 = 1;
            }

            byte[][] var18 = new byte[][] {class_948.field_4395[var17], class_948.field_4401[var17], class_948.field_4400[var17]};
            if(method_4962(var4, var18) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play Services signature invalid on Glass.");
                return 9;
            }

            String var19 = var0.getPackageName();

            try {
                PackageInfo var22 = var1.getPackageInfo(var19, 64);
                if(!method_4959(var1, var22)) {
                    Log.w("GooglePlayServicesUtil", "Calling package " + var22.packageName + " signature invalid on Glass.");
                    return 9;
                }
            } catch (NameNotFoundException var28) {
                Log.w("GooglePlayServicesUtil", "Could not get info for calling package: " + var19);
                return 9;
            }
        } else if(class_347.method_2327(var0)) {
            if(method_4962(var4, class_948.field_4395) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
        } else {
            PackageInfo var7;
            try {
                var7 = var1.getPackageInfo("com.android.vending", 64);
            } catch (NameNotFoundException var27) {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }

            byte[] var8 = method_4962(var7, class_948.field_4395);
            if(var8 == null) {
                Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                return 9;
            }

            if(method_4962(var4, new byte[][] {var8}) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
        }

        int var9 = class_347.method_2328(6171000);
        if(class_347.method_2328(var4.versionCode) < var9) {
            Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires 6171000 but found " + var4.versionCode);
            return 2;
        } else {
            ApplicationInfo var12;
            try {
                var12 = var1.getApplicationInfo("com.google.android.gms", 0);
            } catch (NameNotFoundException var26) {
                Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                var26.printStackTrace();
                return 1;
            }

            return !var12.enabled?3:0;
        }
    }

    public static boolean isGoogleSignedUid(PackageManager var0, int var1) {
        if(var0 == null) {
            throw new SecurityException("Unknown error: invalid Package Manager");
        } else {
            String[] var2 = var0.getPackagesForUid(var1);
            if(var2.length != 0 && method_4965(var0, var2[0])) {
                return true;
            } else {
                throw new SecurityException("Uid is not Google Signed");
            }
        }
    }

    public static boolean isUserRecoverableError(int var0) {
        switch(var0) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return false;
        }
    }

    public static boolean showErrorDialogFragment(int var0, Activity var1, int var2) {
        return showErrorDialogFragment(var0, var1, var2, (OnCancelListener)null);
    }

    public static boolean showErrorDialogFragment(int var0, Activity var1, int var2, OnCancelListener var3) {
        return showErrorDialogFragment(var0, var1, (Fragment)null, var2, var3);
    }

    public static boolean showErrorDialogFragment(int var0, Activity var1, Fragment var2, int var3, OnCancelListener var4) {
        Dialog var5 = method_4958(var0, var1, var2, var3, var4);
        if(var5 == null) {
            return false;
        } else {
            boolean var7;
            try {
                var7 = var1 instanceof FragmentActivity;
            } catch (NoClassDefFoundError var10) {
                var7 = false;
            }

            if(var7) {
                FragmentManager var9 = ((FragmentActivity)var1).getSupportFragmentManager();
                SupportErrorDialogFragment.newInstance(var5, var4).show(var9, "GooglePlayServicesErrorDialog");
            } else {
                if(!class_854.method_4493()) {
                    throw new RuntimeException("This Activity does not support Fragments.");
                }

                android.app.FragmentManager var8 = var1.getFragmentManager();
                ErrorDialogFragment.newInstance(var5, var4).show(var8, "GooglePlayServicesErrorDialog");
            }

            return true;
        }
    }

    public static void showErrorNotification(int var0, Context var1) {
        boolean var2 = class_347.method_2327(var1);
        if(var2 && var0 == 2) {
            var0 = 42;
        }

        Resources var3 = var1.getResources();
        String var4 = method_4971(var1, var0);
        int var5 = class_492.string.common_google_play_services_error_notification_requested_by_msg;
        Object[] var6 = new Object[] {method_4957(var1)};
        String var7 = var3.getString(var5, var6);
        PendingIntent var8 = getErrorPendingIntent(var0, var1, 0);
        Notification var10;
        if(var2) {
            class_1090.method_5674(class_854.method_4497());
            var10 = (new android.app.Notification.Builder(var1)).setSmallIcon(class_492.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle((new BigTextStyle()).bigText(var4 + " " + var7)).addAction(class_492.drawable.common_full_open_on_phone, var3.getString(class_492.string.common_open_on_phone), var8).build();
        } else {
            Notification var9 = new Notification(17301642, var3.getString(class_492.string.common_google_play_services_notification_ticker), System.currentTimeMillis());
            var9.flags |= 16;
            var9.setLatestEventInfo(var1, var4, var7, var8);
            var10 = var9;
        }

        ((NotificationManager)var1.getSystemService("notification")).notify('魭', var10);
    }
}
