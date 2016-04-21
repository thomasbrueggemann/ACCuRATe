package crittercism.android;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Process;
import android.os.Build.VERSION;
import android.os.MessageQueue.IdleHandler;
import com.crittercism.app.CrittercismConfig;
import com.crittercism.integrations.PluginException;
import crittercism.android.class_101;
import crittercism.android.class_104;
import crittercism.android.class_105;
import crittercism.android.class_106;
import crittercism.android.class_552;
import crittercism.android.class_553;
import crittercism.android.class_555;
import crittercism.android.class_558;
import crittercism.android.class_661;
import crittercism.android.class_662;
import crittercism.android.class_663;
import crittercism.android.class_670;
import crittercism.android.class_675;
import crittercism.android.class_676;
import crittercism.android.class_691;
import crittercism.android.class_748;
import crittercism.android.class_749;
import crittercism.android.class_750;
import crittercism.android.class_752;
import crittercism.android.class_753;
import crittercism.android.class_754;
import crittercism.android.class_755;
import crittercism.android.class_756;
import crittercism.android.class_757;
import crittercism.android.class_758;
import crittercism.android.class_760;
import crittercism.android.class_764;
import crittercism.android.class_765;
import crittercism.android.class_767;
import crittercism.android.class_768;
import crittercism.android.class_769;
import crittercism.android.class_787;
import crittercism.android.class_792;
import crittercism.android.class_793;
import crittercism.android.class_795;
import crittercism.android.class_798;
import crittercism.android.class_799;
import crittercism.android.class_801;
import crittercism.android.class_803;
import crittercism.android.class_804;
import crittercism.android.class_806;
import crittercism.android.class_87;
import crittercism.android.class_98;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.az
public final class class_790 implements class_106, class_105, class_104, class_87 {
    // $FF: renamed from: a crittercism.android.az
    static class_790 field_3687;
    // $FF: renamed from: A crittercism.android.dt
    public class_767 field_3688 = null;
    // $FF: renamed from: B int
    int field_3689 = 0;
    // $FF: renamed from: C boolean
    public boolean field_3690 = false;
    // $FF: renamed from: D java.lang.String
    private String field_3691 = null;
    // $FF: renamed from: E crittercism.android.bs
    private class_803 field_3692;
    // $FF: renamed from: F crittercism.android.bs
    private class_803 field_3693;
    // $FF: renamed from: G crittercism.android.g
    private class_663 field_3694 = null;
    // $FF: renamed from: H crittercism.android.at
    private class_787 field_3695;
    // $FF: renamed from: I boolean
    private boolean field_3696 = false;
    // $FF: renamed from: J java.lang.String
    private String field_3697 = "";
    // $FF: renamed from: b boolean
    public boolean field_3698 = false;
    // $FF: renamed from: c android.content.Context
    public Context field_3699 = null;
    // $FF: renamed from: d android.os.ConditionVariable
    public final ConditionVariable field_3700 = new ConditionVariable(false);
    // $FF: renamed from: e android.os.ConditionVariable
    public final ConditionVariable field_3701 = new ConditionVariable(false);
    // $FF: renamed from: f crittercism.android.dw
    public class_768 field_3702 = new class_768();
    // $FF: renamed from: g crittercism.android.bs
    class_803 field_3703;
    // $FF: renamed from: h crittercism.android.bs
    class_803 field_3704;
    // $FF: renamed from: i crittercism.android.bs
    class_803 field_3705;
    // $FF: renamed from: j crittercism.android.bs
    class_803 field_3706;
    // $FF: renamed from: k crittercism.android.bs
    class_803 field_3707;
    // $FF: renamed from: l crittercism.android.bs
    class_803 field_3708;
    // $FF: renamed from: m crittercism.android.bs
    class_803 field_3709;
    // $FF: renamed from: n crittercism.android.bs
    class_803 field_3710;
    // $FF: renamed from: o crittercism.android.bs
    class_803 field_3711;
    // $FF: renamed from: p crittercism.android.cv
    class_748 field_3712 = null;
    // $FF: renamed from: q crittercism.android.dg
    public class_555 field_3713 = null;
    // $FF: renamed from: r java.util.concurrent.ExecutorService
    ExecutorService field_3714 = Executors.newCachedThreadPool(new class_765());
    // $FF: renamed from: s java.util.concurrent.ExecutorService
    public ExecutorService field_3715 = Executors.newSingleThreadExecutor(new class_765());
    // $FF: renamed from: t boolean
    public boolean field_3716 = false;
    // $FF: renamed from: u crittercism.android.bb
    public class_792 field_3717;
    // $FF: renamed from: v crittercism.android.e
    protected class_661 field_3718;
    // $FF: renamed from: w crittercism.android.dr
    public class_760 field_3719;
    // $FF: renamed from: x crittercism.android.dv
    class_769 field_3720 = null;
    // $FF: renamed from: y crittercism.android.bi
    public class_553 field_3721;
    // $FF: renamed from: z java.util.Map
    public Map field_3722 = new HashMap();

    protected class_790() {
        this.field_3718 = new class_661(this.field_3715);
    }

    // $FF: renamed from: A () crittercism.android.az
    public static class_790 method_4077() {
        if(field_3687 == null) {
            field_3687 = new class_790();
        }

        return field_3687;
    }

    // $FF: renamed from: F () boolean
    private static boolean method_4078() {
        StackTraceElement[] var0 = Thread.currentThread().getStackTrace();
        int var1 = 0;

        boolean var3;
        while(true) {
            int var2 = var0.length;
            var3 = false;
            if(var1 >= var2) {
                break;
            }

            StackTraceElement var4 = var0[var1];
            if(var4.getMethodName().equals("onCreate") || var4.getMethodName().equals("onResume")) {
                var3 = true;
                break;
            }

            ++var1;
        }

        return var3;
    }

    // $FF: renamed from: G () void
    private void method_4079() {
        int var1 = Process.myUid();
        int var2 = Process.myPid();
        ActivityManager var3 = (ActivityManager)this.field_3699.getSystemService("activity");
        Iterator var4 = var3.getRunningAppProcesses().iterator();

        int var5;
        int var7;
        for(var5 = 0; var4.hasNext(); var5 = var7) {
            if(((RunningAppProcessInfo)var4.next()).uid == var1) {
                var7 = var5 + 1;
            } else {
                var7 = var5;
            }
        }

        if(var5 <= 1) {
            this.field_3716 = false;
        } else {
            Iterator var6 = var3.getRunningServices(Integer.MAX_VALUE).iterator();

            while(var6.hasNext()) {
                if(((RunningServiceInfo)var6.next()).pid == var2) {
                    this.field_3716 = true;
                    return;
                }
            }
        }

    }

    // $FF: renamed from: H () java.lang.String
    private String method_4080() {
        try {
            if(this.field_3697 == null || this.field_3697.equals("")) {
                this.field_3697 = this.field_3699.getPackageName();
            }
        } catch (Exception var2) {
            class_764.method_4024("Call to getPackageName() failed.  Please contact us at support@crittercism.com.");
            this.field_3697 = new String();
        }

        return this.field_3697;
    }

    // $FF: renamed from: B () boolean
    public final boolean method_4081() {
        this.field_3700.block();
        return this.field_3702.method_4040();
    }

    // $FF: renamed from: C () void
    public final void method_4082() {
        class_767 var10000 = this.field_3688;
        if(this.field_3688 != null) {
            this.field_3688.method_4035();
        }

    }

    // $FF: renamed from: D () java.lang.String
    public final String method_4083() {
        PackageManager var1 = this.field_3699.getPackageManager();
        String var2 = this.method_4080();
        String var3 = null;
        if(var2 != null) {
            int var4 = var2.length();
            var3 = null;
            if(var4 > 0) {
                class_101 var5 = class_758.method_4008(var1.getInstallerPackageName(var2));
                if(var5 == null) {
                    class_764.method_4024("Could not find app market for this app.  Will try rate-my-app test target in config.");
                    return this.field_3717.getRateMyAppTestTarget();
                }

                var3 = var5.method_398(var2).method_4014();
            }
        }

        return var3;
    }

    // $FF: renamed from: E () void
    public final void method_4084() {
        if(!this.field_3716) {
            class_552 var1 = new class_552() {
                // $FF: renamed from: a () void
                public final void method_3390() {
                    if(!class_790.this.field_3702.method_4040()) {
                        class_749 var1 = new class_749(class_790.this);
                        JSONObject var2 = class_790.this.field_3720.method_4042();
                        var1.field_3562.put("metadata", var2);
                        (new class_558(var1, new class_754((new class_753(class_790.this.field_3717.method_4102(), "/android_v2/update_user_metadata")).method_3999()), new class_755(class_790.this.field_3720))).run();
                    }
                }
            };
            if(!this.field_3713.method_3405(var1)) {
                this.field_3714.execute(var1);
                return;
            }
        }

    }

    // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String) android.app.AlertDialog
    public final AlertDialog method_4085(Context var1, String var2, String var3) {
        boolean var4 = false;
        if(this.field_3702.method_4040()) {
            class_764.method_4021("User has opted out of crittercism.  generateRateMyAppAlertDialog returning null.");
        } else if(!(var1 instanceof Activity)) {
            class_764.method_4021("Context object must be an instance of Activity for AlertDialog to form correctly.  generateRateMyAppAlertDialog returning null.");
            var4 = false;
        } else if(var3 == null || var3 != null && var3.length() == 0) {
            class_764.method_4021("Message has to be a non-empty string.  generateRateMyAppAlertDialog returning null.");
            var4 = false;
        } else if(VERSION.SDK_INT < 5) {
            class_764.method_4021("Rate my app not supported below api level 5");
            var4 = false;
        } else {
            var4 = true;
        }

        if(!var4) {
            return null;
        } else {
            final String var5 = this.method_4083();
            if(var5 == null) {
                class_764.method_4021("Cannot create proper URI to open app market.  Returning null.");
                return null;
            } else {
                Builder var6 = new Builder(var1);
                var6.setTitle(var2).setMessage(var3);

                AlertDialog var9;
                try {
                    var9 = var6.create();
                } catch (Exception var10) {
                    class_764.method_4021("Failed to create AlertDialog instance from AlertDialog.Builder.  Did you remember to call Looper.prepare() before calling Crittercism.generateRateMyAppAlertDialog()?");
                    return null;
                }

                var9.setButton(-1, "Yes", new OnClickListener() {
                    public final void onClick(DialogInterface var1, int var2) {
                        try {
                            class_790.method_4077().method_4090(var5);
                        } catch (Exception var4) {
                            class_764.method_4024("YES button failed.  Email support@crittercism.com.");
                        }
                    }
                });
                var9.setButton(-2, "No", new OnClickListener() {
                    public final void onClick(DialogInterface var1, int var2) {
                        try {
                            class_790.method_4077().method_4082();
                        } catch (Exception var4) {
                            class_764.method_4024("NO button failed.  Email support@crittercism.com.");
                        }
                    }
                });
                var9.setButton(-3, "Maybe Later", new OnClickListener() {
                    public final void onClick(DialogInterface var1, int var2) {
                        try {
                            class_790.method_4077();
                        } catch (Exception var4) {
                            class_764.method_4024("MAYBE LATER button failed.  Email support@crittercism.com.");
                        }
                    }
                });
                return var9;
            }
        }
    }

    // $FF: renamed from: a () java.lang.String
    public final String method_428() {
        String var1 = this.field_3691;
        if(var1 == null) {
            var1 = "";
        }

        return var1;
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String) java.lang.String
    public final String method_410(String var1, String var2) {
        SharedPreferences var3 = this.field_3699.getSharedPreferences(var1, 0);
        String var4 = null;
        if(var3 != null) {
            var4 = var3.getString(var2, (String)null);
        }

        return var4;
    }

    // $FF: renamed from: a (android.content.Context, java.lang.String, com.crittercism.app.CrittercismConfig) void
    public final void method_4086(Context param1, String param2, CrittercismConfig param3) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (crittercism.android.bh) void
    public final void method_4087(class_798 var1) {
        class_553 var10000 = this.field_3721;
        if(this.field_3721 != null) {
            class_795.method_4125(var1);
            class_795.method_4133();
            if(var1.field_3771) {
                this.field_3721.method_3393(var1.field_3772, TimeUnit.SECONDS);
                this.field_3721.method_3394();
                return;
            }
        }

    }

    // $FF: renamed from: a (crittercism.android.c) void
    public final void method_375(final class_675 var1) {
        class_552 var2 = new class_552() {
            // $FF: renamed from: a () void
            public final void method_3390() {
                class_790.this.field_3708.method_4168(var1);
            }
        };
        if(!this.field_3713.method_3405(var2)) {
            this.field_3715.execute(var2);
        }

    }

    // $FF: renamed from: a (crittercism.android.ci) void
    public final void method_4088(final class_670 var1) {
        if(!this.field_3702.method_4040()) {
            class_552 var2 = new class_552() {
                // $FF: renamed from: a () void
                public final void method_3390() {
                    class_790.this.field_3709.method_4168(var1);
                }
            };
            if(!this.field_3713.method_3405(var2)) {
                this.field_3715.execute(var2);
                return;
            }
        }

    }

    // $FF: renamed from: a (crittercism.android.h) void
    public final void method_4089(class_691 var1) {
        if(this.field_3694 != null && var1.field_3364 && !var1.field_3366) {
            class_764.method_4017("Enabling OPTMZ");
            this.field_3694.method_3721(var1.field_3367, TimeUnit.SECONDS);
            this.field_3694.method_3720();
        }
    }

    // $FF: renamed from: a (java.lang.String) void
    public final void method_4090(String var1) {
        class_767 var10000 = this.field_3688;
        if(this.field_3688 != null) {
            this.field_3688.method_4035();
        }

        Intent var3 = new Intent("android.intent.action.VIEW");
        var3.setFlags(268435456);
        var3.setData(Uri.parse(var1));
        this.field_3699.startActivity(var3);
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String, int) void
    public final void method_411(String var1, String var2, int var3) {
        SharedPreferences var4 = this.field_3699.getSharedPreferences(var1, 0);
        if(var4 != null) {
            Editor var5 = var4.edit();
            if(var5 != null) {
                var5.remove(var2);
                var5.putInt(var2, var3);
                var5.commit();
            }
        }

    }

    // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.String) void
    public final void method_412(String var1, String var2, String var3) {
        SharedPreferences var4 = this.field_3699.getSharedPreferences(var1, 0);
        if(var4 != null) {
            Editor var5 = var4.edit();
            if(var5 != null) {
                var5.remove(var2);
                var5.putString(var2, var3);
                var5.commit();
            }
        }

    }

    // $FF: renamed from: a (java.lang.String, java.net.URL, long, long, long, int, java.lang.Exception, long) void
    public final void method_4091(String var1, URL var2, long var3, long var5, long var7, int var9, Exception var10, long var11) {
        if(var1 == null) {
            class_764.method_4021("Null HTTP request method provided. Endpoint will not be logged.");
        } else {
            String var13 = var1.toUpperCase(Locale.US);
            HashSet var14 = new HashSet();
            var14.add("GET");
            var14.add("POST");
            var14.add("HEAD");
            var14.add("PUT");
            var14.add("DELETE");
            var14.add("TRACE");
            var14.add("OPTIONS");
            var14.add("CONNECT");
            var14.add("PATCH");
            if(!var14.contains(var13)) {
                class_764.method_4024("Logging endpoint with invalid HTTP request method: " + var1);
            }

            if(var2 == null) {
                class_764.method_4021("Null URL provided. Endpoint will not be logged");
            } else if(var5 >= 0L && var7 >= 0L) {
                if(var9 != 0) {
                    if(var9 < 100 || var9 >= 600) {
                        class_764.method_4024("Logging endpoint with invalid HTTP response code: " + Integer.toString(var9));
                    }
                } else if(var10 == null) {
                    class_764.method_4024("Logging endpoint with null error and response code of 0.");
                }

                class_676 var24 = (new class_662(this.field_3699)).method_3714();
                if(var3 < 0L) {
                    class_764.method_4021("Invalid latency. Endpoint will not be logged.");
                } else if(var11 < 0L) {
                    class_764.method_4021("Invalid start time. Endpoint will not be logged.");
                } else {
                    class_675 var25 = new class_675();
                    var25.field_3266 = var13;
                    var25.method_3737(var2.toExternalForm());
                    var25.method_3741(var5);
                    var25.method_3746(var7);
                    var25.field_3265 = var9;
                    var25.field_3270 = var24;
                    var25.method_3747(var11);
                    var25.method_3749(var11 + var3);
                    if(class_793.method_4112()) {
                        var25.method_3735(class_793.method_4110());
                    }

                    var25.method_3738(var10);
                    this.field_3718.method_3710(var25, class_675.class_1233.field_3861);
                }
            } else {
                class_764.method_4021("Invalid byte values. Bytes need to be non-negative. Endpoint will not be logged.");
            }
        }
    }

    // $FF: renamed from: a (java.lang.Throwable) void
    public final void method_4092(Throwable var1) {
        if(this.field_3713 == null) {
            class_764.method_4021("Unable to handle application crash. Crittercism not yet initialized");
        } else {
            this.field_3713.method_3406();
            class_757.method_4007(this.field_3699, true);
            if(!this.field_3702.method_4040()) {
                if(this.field_3716) {
                    class_799 var2 = new class_799(var1, Thread.currentThread().getId());
                    JSONArray var3 = (new JSONArray()).put(var2.method_4156());
                    (new class_558((new class_749(this)).method_3997(class_804.field_3811.method_4177(), var3), new class_754((new class_753(this.field_3717.method_4102(), "/android_v2/handle_crashes")).method_3999()), (class_98)null)).run();
                    return;
                }

                List var4 = class_795.method_4120(this, var1 instanceof PluginException);
                class_799 var5 = new class_799(var1, Thread.currentThread().getId());
                var5.method_4154("crashed_session", this.field_3707);
                if(this.field_3693.method_4169() > 0) {
                    var5.method_4154("previous_session", this.field_3693);
                }

                var5.method_4153(this.field_3708);
                var5.field_3778 = (new class_801(this.field_3709)).field_3795;
                var5.method_4152();
                var5.method_4155(var4);
                this.field_3706.method_4168(var5);
                class_756 var7 = new class_756(this.field_3699);
                var7.method_4004(this.field_3703, new class_750.class_1263(), this.field_3717.method_4105(), "/v0/appload/", (String)null, this, new class_752.class_1262());
                var7.method_4004(this.field_3704, new class_750.class_1263(), this.field_3717.method_4102(), "/android_v2/handle_exceptions", (String)null, this, new class_749.class_1255());
                var7.method_4004(this.field_3705, new class_750.class_1263(), this.field_3717.method_4102(), "/android_v2/handle_ndk_crashes", (String)null, this, new class_749.class_1255());
                var7.method_4004(this.field_3706, new class_750.class_1263(), this.field_3717.method_4102(), "/android_v2/handle_crashes", (String)null, this, new class_749.class_1255());

                try {
                    var7.method_4003();
                    return;
                } catch (InterruptedException var11) {
                    (new StringBuilder("InterruptedException in logCrashException: ")).append(var11.getMessage());
                    class_764.method_4020();
                    class_764.method_4023();
                    return;
                } catch (Throwable var12) {
                    (new StringBuilder("Unexpected throwable in logCrashException: ")).append(var12.getMessage());
                    class_764.method_4020();
                    class_764.method_4023();
                    return;
                }
            }
        }

    }

    // $FF: renamed from: a (org.json.JSONObject) void
    public final void method_4093(final JSONObject var1) {
        if(!this.field_3716) {
            class_552 var2 = new class_552() {
                // $FF: renamed from: a () void
                public final void method_3390() {
                    if(!class_790.this.field_3702.method_4040()) {
                        class_790.this.field_3720.method_4043(var1);
                        if(class_790.this.field_3720.method_4045()) {
                            class_790.this.method_4084();
                            return;
                        }
                    }

                }
            };
            if(!this.field_3713.method_3405(var2)) {
                this.field_3715.execute(var2);
                return;
            }
        }

    }

    // $FF: renamed from: b (java.lang.String) int
    public final int method_4094(String param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (java.lang.String, java.lang.String) int
    public final int method_413(String var1, String var2) {
        SharedPreferences var3 = this.field_3699.getSharedPreferences(var1, 0);
        int var4 = 0;
        if(var3 != null) {
            var4 = var3.getInt(var2, 0);
        }

        return var4;
    }

    // $FF: renamed from: b () java.lang.String
    public final String method_429() {
        return this.field_3695.field_3676;
    }

    // $FF: renamed from: b (java.lang.Throwable) void
    public final void method_4095(Throwable param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: c () java.lang.String
    public final String method_430() {
        String var1 = "";
        if(this.field_3719 != null) {
            var1 = this.field_3719.method_4013();
        }

        return var1;
    }

    // $FF: renamed from: c (java.lang.String, java.lang.String) boolean
    public final boolean method_414(String var1, String var2) {
        SharedPreferences var3 = this.field_3699.getSharedPreferences(var1, 0);
        boolean var4 = false;
        if(var3 != null) {
            var4 = var3.getBoolean(var2, false);
        }

        return var4;
    }

    // $FF: renamed from: d () java.lang.String
    public final String method_431() {
        return "5.1.4";
    }

    // $FF: renamed from: e () int
    public final int method_432() {
        int var1 = -1;
        if(this.field_3702 != null) {
            var1 = Integer.valueOf(this.field_3702.method_4038().field_3604).intValue();
        }

        return var1;
    }

    // $FF: renamed from: f () java.lang.String
    public final String method_433() {
        return (new class_806.class_1432()).field_4638;
    }

    // $FF: renamed from: g () int
    public final int method_434() {
        return (new class_806.class_1441()).field_4645.intValue();
    }

    // $FF: renamed from: h () int
    public final int method_435() {
        return (new class_806.class_1442()).field_4643.intValue();
    }

    // $FF: renamed from: i () java.lang.String
    public final String method_436() {
        return "Android";
    }

    // $FF: renamed from: j () java.lang.String
    public final String method_437() {
        return Build.MODEL;
    }

    // $FF: renamed from: k () java.lang.String
    public final String method_438() {
        return VERSION.RELEASE;
    }

    // $FF: renamed from: l () crittercism.android.dw
    public final class_768 method_439() {
        return this.field_3702;
    }

    // $FF: renamed from: m () crittercism.android.dt
    public final class_767 method_440() {
        return this.field_3688;
    }

    // $FF: renamed from: n () crittercism.android.bs
    public final class_803 method_415() {
        return this.field_3703;
    }

    // $FF: renamed from: o () crittercism.android.bs
    public final class_803 method_416() {
        return this.field_3704;
    }

    // $FF: renamed from: p () crittercism.android.bs
    public final class_803 method_417() {
        return this.field_3692;
    }

    // $FF: renamed from: q () crittercism.android.bs
    public final class_803 method_418() {
        return this.field_3705;
    }

    // $FF: renamed from: r () crittercism.android.bs
    public final class_803 method_419() {
        return this.field_3706;
    }

    // $FF: renamed from: s () crittercism.android.bs
    public final class_803 method_420() {
        return this.field_3707;
    }

    // $FF: renamed from: t () crittercism.android.bs
    public final class_803 method_421() {
        return this.field_3708;
    }

    // $FF: renamed from: u () crittercism.android.bs
    public final class_803 method_422() {
        return this.field_3693;
    }

    // $FF: renamed from: v () crittercism.android.bs
    public final class_803 method_423() {
        return this.field_3709;
    }

    // $FF: renamed from: w () crittercism.android.bs
    public final class_803 method_424() {
        return this.field_3710;
    }

    // $FF: renamed from: x () crittercism.android.bs
    public final class_803 method_425() {
        return this.field_3711;
    }

    // $FF: renamed from: y () crittercism.android.dv
    public final class_769 method_426() {
        return this.field_3720;
    }

    // $FF: renamed from: z () void
    public final void method_427() {
        if(this.field_3716) {
            this.field_3707 = (new class_803(this.field_3699, class_804.field_3812)).method_4164(this.field_3699);
        } else {
            this.field_3707 = new class_803(this.field_3699, class_804.field_3812);
        }

        this.field_3693 = new class_803(this.field_3699, class_804.field_3814);
        this.field_3708 = new class_803(this.field_3699, class_804.field_3813);
        this.field_3709 = new class_803(this.field_3699, class_804.field_3817);
        this.field_3703 = new class_803(this.field_3699, class_804.field_3807);
        this.field_3704 = new class_803(this.field_3699, class_804.field_3808);
        this.field_3692 = new class_803(this.field_3699, class_804.field_3809);
        this.field_3705 = new class_803(this.field_3699, class_804.field_3810);
        this.field_3706 = new class_803(this.field_3699, class_804.field_3811);
        this.field_3710 = new class_803(this.field_3699, class_804.field_3815);
        this.field_3711 = new class_803(this.field_3699, class_804.field_3816);
        if(!this.field_3716) {
            this.field_3720 = new class_769(this.field_3699, this.field_3691);
        }

    }

    static final class class_1359 implements IdleHandler {
        // $FF: renamed from: a boolean
        private boolean field_2935;

        private class_1359() {
            this.field_2935 = false;
        }

        // $FF: synthetic method
        class_1359(byte var1) {
            this();
        }

        public final boolean queueIdle() {
            synchronized(this) {
                if(!this.field_2935) {
                    this.field_2935 = true;
                    class_795.method_4132();
                }

                return true;
            }
        }
    }
}
