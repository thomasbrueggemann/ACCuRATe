package crittercism.android;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.os.Debug.MemoryInfo;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;
import crittercism.android.class_109;
import crittercism.android.class_764;
import crittercism.android.class_787;
import crittercism.android.class_797;
import crittercism.android.class_93;
import java.math.BigInteger;
import org.json.JSONArray;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.bx
public final class class_806 {
    // $FF: renamed from: a crittercism.android.at
    private static class_787 field_3826 = null;
    // $FF: renamed from: b android.content.Context
    private static Context field_3827 = null;
    // $FF: renamed from: c crittercism.android.bf
    private static class_797 field_3828 = null;
    // $FF: renamed from: d crittercism.android.cb
    private static class_93 field_3829 = null;

    // $FF: renamed from: a (android.content.Context) void
    public static void method_4181(Context var0) {
        field_3827 = var0;
    }

    // $FF: renamed from: a (crittercism.android.at) void
    public static void method_4182(class_787 var0) {
        field_3826 = var0;
    }

    // $FF: renamed from: a (crittercism.android.bf) void
    public static void method_4183(class_797 var0) {
        field_3828 = var0;
    }

    // $FF: renamed from: a (crittercism.android.cb) void
    public static void method_4184(class_93 var0) {
        field_3829 = var0;
    }

    public static final class class_1426 implements class_109 {
        // $FF: renamed from: a java.lang.String
        private String field_4632 = null;

        public class_1426() {
            class_806.field_3828;
            class_806.field_3827;
            boolean var3 = class_806.field_3828.field_3768;
            String var4 = null;
            if(var3) {
                var4 = ((RunningTaskInfo)((ActivityManager)class_806.field_3827.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.flattenToShortString().replace("/", "");
            }

            this.field_4632 = var4;
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "activity";
        }
    }

    public static final class class_1427 implements class_109 {
        // $FF: renamed from: a java.lang.Float
        private Float field_3907 = null;

        public class_1427() {
            class_806.field_3827;
            this.field_3907 = Float.valueOf(class_806.field_3827.getResources().getDisplayMetrics().ydpi);
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "ydpi";
        }
    }

    public static final class class_1428 implements class_109 {
        // $FF: renamed from: a java.lang.Integer
        private Integer field_4629 = null;

        public class_1428() {
            class_806.field_3826;
            this.field_4629 = Integer.valueOf(class_806.field_3826.field_3677);
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "app_version_code";
        }
    }

    public static final class class_1429 implements class_109 {
        // $FF: renamed from: a java.lang.String
        private String field_4630 = null;

        public class_1429() {
            class_806.field_3826;
            this.field_4630 = class_806.field_3826.field_3676;
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "app_version";
        }
    }

    public static final class class_1430 implements class_109 {
        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "arch";
        }

        // $FF: renamed from: b () java.lang.Object
        // $FF: synthetic method
        public final Object method_633() {
            return System.getProperty("os.arch");
        }
    }

    public static final class class_1431 implements class_109 {
        // $FF: renamed from: a java.lang.Double
        private Double field_4631 = null;

        public class_1431() {
            class_806.field_3827;
            double var2 = 1.0D;
            Intent var4 = class_806.field_3827.getApplicationContext().registerReceiver((BroadcastReceiver)null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int var5 = var4.getIntExtra("level", -1);
            double var6 = (double)var4.getIntExtra("scale", -1);
            if(var5 >= 0 && var6 > 0.0D) {
                var2 = (double)var5 / var6;
            }

            this.field_4631 = Double.valueOf(var2);
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "battery_level";
        }
    }

    public static final class class_1432 implements class_109 {
        // $FF: renamed from: a java.lang.String
        public String field_4638 = null;

        public class_1432() {
            class_806.field_3827;

            String var3;
            label13: {
                String var5;
                try {
                    var5 = ((TelephonyManager)class_806.field_3827.getSystemService("phone")).getNetworkOperatorName();
                } catch (Exception var6) {
                    var3 = Build.BRAND;
                    break label13;
                }

                var3 = var5;
            }

            this.field_4638 = var3;
            (new StringBuilder("carrier == ")).append(this.field_4638);
            class_764.method_4020();
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "carrier";
        }
    }

    static class class_1433 implements class_109 {
        // $FF: renamed from: a org.json.JSONObject
        private JSONObject field_4633;

        public class_1433(int param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a () java.lang.String
        public String method_634() {
            return null;
        }

        // $FF: renamed from: b () java.lang.Object
        // $FF: synthetic method
        public final Object method_633() {
            return this.method_5266();
        }

        // $FF: renamed from: c () org.json.JSONObject
        public JSONObject method_5266() {
            return this.field_4633;
        }
    }

    public static final class class_1434 implements class_109 {
        // $FF: renamed from: a java.lang.Float
        private Float field_4636 = null;

        public class_1434() {
            class_806.field_3827;
            this.field_4636 = Float.valueOf(class_806.field_3827.getResources().getDisplayMetrics().density);
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "dpi";
        }
    }

    public static final class class_1435 implements class_109 {
        // $FF: renamed from: a java.lang.String
        private String field_4637 = null;

        public class_1435() {
            try {
                BigInteger.valueOf(-1L);
                StatFs var4 = new StatFs(Environment.getDataDirectory().getPath());
                this.field_4637 = BigInteger.valueOf((long)var4.getAvailableBlocks()).multiply(BigInteger.valueOf((long)var4.getBlockSize())).toString();
            } catch (ThreadDeath var5) {
                throw var5;
            } catch (Throwable var6) {
                this.field_4637 = null;
            }
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "disk_space_free";
        }
    }

    public static final class class_1436 implements class_109 {
        // $FF: renamed from: a java.lang.String
        private String field_4641 = null;

        public class_1436() {
            try {
                BigInteger.valueOf(-1L);
                StatFs var4 = new StatFs(Environment.getDataDirectory().getPath());
                this.field_4641 = BigInteger.valueOf((long)var4.getBlockCount()).multiply(BigInteger.valueOf((long)var4.getBlockSize())).toString();
            } catch (ThreadDeath var5) {
                throw var5;
            } catch (Throwable var6) {
                this.field_4641 = null;
            }
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "disk_space_total";
        }
    }

    public static final class class_1437 implements class_109 {
        // $FF: renamed from: a java.lang.String
        public String field_4642 = null;

        public class_1437() {
            class_806.field_3827;
            this.field_4642 = class_806.field_3827.getResources().getConfiguration().locale.getLanguage();
            if(this.field_4642 == null || this.field_4642.length() == 0) {
                this.field_4642 = "en";
            }

        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "locale";
        }
    }

    public static final class class_1438 implements class_109 {
        // $FF: renamed from: a org.json.JSONArray
        private JSONArray field_4639 = null;

        public class_1438() {
            class_806.field_3828;
            class_806.field_3829;
            if(class_806.field_3828.field_3767) {
                this.field_4639 = class_806.field_3829.method_390();
            }

        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "logcat";
        }
    }

    public static final class class_1439 implements class_109 {
        // $FF: renamed from: a java.lang.Long
        private Long field_4640 = null;

        public class_1439() {
            this.field_4640 = Long.valueOf(Runtime.getRuntime().maxMemory());
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "memory_total";
        }
    }

    public static final class class_1440 implements class_109 {
        // $FF: renamed from: a java.lang.Integer
        private Integer field_4644 = null;

        public class_1440() {
            MemoryInfo var1 = new MemoryInfo();
            Debug.getMemoryInfo(var1);
            this.field_4644 = Integer.valueOf(1024 * (var1.dalvikPss + var1.nativePss + var1.otherPss));
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "memory_usage";
        }
    }

    public static final class class_1441 implements class_109 {
        // $FF: renamed from: a java.lang.Integer
        public Integer field_4645;

        public class_1441() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "mobile_country_code";
        }
    }

    public static final class class_1442 implements class_109 {
        // $FF: renamed from: a java.lang.Integer
        public Integer field_4643;

        public class_1442() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "mobile_network_code";
        }
    }

    public static final class class_1443 extends class_806.class_1433 {
        public class_1443() {
            super(0);
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "mobile_network";
        }
    }

    public static final class class_1444 implements class_109 {
        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "model";
        }
    }

    public static final class class_1445 implements class_109 {
        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "name";
        }

        // $FF: renamed from: b () java.lang.Object
        // $FF: synthetic method
        public final Object method_633() {
            return new String();
        }
    }

    public static final class class_1446 implements class_109 {
        // $FF: renamed from: a java.lang.Integer
        private Integer field_4646 = null;

        public class_1446() {
            class_806.field_3827;
            int var2 = class_806.field_3827.getResources().getConfiguration().orientation;
            if(var2 == 0) {
                Display var3 = ((WindowManager)class_806.field_3827.getSystemService("window")).getDefaultDisplay();
                if(var3.getWidth() == var3.getHeight()) {
                    var2 = 3;
                } else if(var3.getWidth() > var3.getHeight()) {
                    var2 = 2;
                } else {
                    var2 = 1;
                }
            }

            this.field_4646 = Integer.valueOf(var2);
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "orientation";
        }
    }

    public static final class class_1447 implements class_109 {
        // $FF: renamed from: a java.lang.String
        private String field_4647 = null;

        public class_1447() {
            try {
                BigInteger.valueOf(-1L);
                StatFs var4 = new StatFs(Environment.getExternalStorageDirectory().getPath());
                this.field_4647 = BigInteger.valueOf((long)var4.getAvailableBlocks()).multiply(BigInteger.valueOf((long)var4.getBlockSize())).toString();
            } catch (ThreadDeath var5) {
                throw var5;
            } catch (Throwable var6) {
                this.field_4647 = null;
            }
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "sd_space_free";
        }
    }

    public static final class class_1448 implements class_109 {
        // $FF: renamed from: a java.lang.String
        private String field_4634 = null;

        public class_1448() {
            try {
                BigInteger.valueOf(-1L);
                StatFs var4 = new StatFs(Environment.getExternalStorageDirectory().getPath());
                this.field_4634 = BigInteger.valueOf((long)var4.getBlockCount()).multiply(BigInteger.valueOf((long)var4.getBlockSize())).toString();
            } catch (ThreadDeath var5) {
                throw var5;
            } catch (Throwable var6) {
                this.field_4634 = null;
            }
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "sd_space_total";
        }
    }

    public static final class class_1449 implements class_109 {
        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "system";
        }
    }

    public static final class class_1450 implements class_109 {
        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "system_version";
        }
    }

    public static final class class_1451 extends class_806.class_1433 {
        public class_1451() {
            super(1);
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "wifi";
        }
    }

    public static final class class_1452 implements class_109 {
        // $FF: renamed from: a java.lang.Float
        private Float field_4635 = null;

        public class_1452() {
            class_806.field_3827;
            this.field_4635 = Float.valueOf(class_806.field_3827.getResources().getDisplayMetrics().xdpi);
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_634() {
            return "xdpi";
        }
    }
}
