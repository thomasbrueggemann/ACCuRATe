package crittercism.android;

import android.location.Location;
import crittercism.android.class_668;
import crittercism.android.class_676;
import crittercism.android.class_688;
import crittercism.android.class_732;
import crittercism.android.class_744;
import crittercism.android.class_807;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import org.json.JSONArray;

// $FF: renamed from: crittercism.android.c
public final class class_675 extends class_668 {
    // $FF: renamed from: a long
    public long field_3261 = Long.MAX_VALUE;
    // $FF: renamed from: b boolean
    public boolean field_3262 = false;
    // $FF: renamed from: c crittercism.android.c$a
    class_675.class_1233 field_3263;
    // $FF: renamed from: d long
    public long field_3264;
    // $FF: renamed from: e int
    public int field_3265;
    // $FF: renamed from: f java.lang.String
    public String field_3266;
    // $FF: renamed from: g crittercism.android.cn
    public class_744 field_3267;
    // $FF: renamed from: h crittercism.android.k
    public class_688 field_3268;
    // $FF: renamed from: i java.lang.String
    public String field_3269;
    // $FF: renamed from: j crittercism.android.b
    public class_676 field_3270;
    // $FF: renamed from: k long
    private long field_3271 = Long.MAX_VALUE;
    // $FF: renamed from: l boolean
    private boolean field_3272 = false;
    // $FF: renamed from: m boolean
    private boolean field_3273 = false;
    // $FF: renamed from: n java.lang.String
    private String field_3274;
    // $FF: renamed from: o long
    private long field_3275;
    // $FF: renamed from: p boolean
    private boolean field_3276;
    // $FF: renamed from: q boolean
    private boolean field_3277;
    // $FF: renamed from: r double[]
    private double[] field_3278;

    public class_675() {
        this.field_3263 = class_675.class_1233.field_3850;
        this.field_3275 = 0L;
        this.field_3264 = 0L;
        this.field_3276 = false;
        this.field_3277 = false;
        this.field_3265 = 0;
        this.field_3266 = "";
        this.field_3267 = new class_744((Throwable)null);
        this.field_3268 = new class_688();
        this.field_3270 = class_676.field_3279;
        this.field_3274 = class_732.field_3484.method_3968();
    }

    public class_675(String var1) {
        this.field_3263 = class_675.class_1233.field_3850;
        this.field_3275 = 0L;
        this.field_3264 = 0L;
        this.field_3276 = false;
        this.field_3277 = false;
        this.field_3265 = 0;
        this.field_3266 = "";
        this.field_3267 = new class_744((Throwable)null);
        this.field_3268 = new class_688();
        this.field_3270 = class_676.field_3279;
        this.field_3274 = class_732.field_3484.method_3968();
        if(var1 != null) {
            this.field_3269 = var1;
        }

    }

    public class_675(URL var1) {
        this.field_3263 = class_675.class_1233.field_3850;
        this.field_3275 = 0L;
        this.field_3264 = 0L;
        this.field_3276 = false;
        this.field_3277 = false;
        this.field_3265 = 0;
        this.field_3266 = "";
        this.field_3267 = new class_744((Throwable)null);
        this.field_3268 = new class_688();
        this.field_3270 = class_676.field_3279;
        this.field_3274 = class_732.field_3484.method_3968();
        if(var1 != null) {
            this.field_3269 = var1.toExternalForm();
        }

    }

    // $FF: renamed from: g () long
    private long method_3731() {
        long var1 = Long.MAX_VALUE;
        if(this.field_3261 != var1 && this.field_3271 != var1) {
            var1 = this.field_3271 - this.field_3261;
        }

        return var1;
    }

    // $FF: renamed from: a () java.lang.String
    public final String method_3732() {
        boolean var1 = true;
        String var2 = this.field_3269;
        if(var2 == null) {
            class_688 var3 = this.field_3268;
            if(var3.field_3348 != null) {
                var2 = var3.field_3348;
            } else if(var3.field_3347 != null) {
                var2 = var3.field_3347.getHostName();
            } else {
                var2 = "unknown-host";
            }

            if(var3.field_3352) {
                int var9 = var3.field_3351;
                if(var9 > 0) {
                    String var10 = ":" + var9;
                    if(!var2.endsWith(var10)) {
                        var2 = var2 + var10;
                    }
                }
            } else {
                String var4 = var3.field_3349;
                if(var4 == null || !var4.regionMatches(var1, 0, "http:", 0, 5) && !var4.regionMatches(var1, 0, "https:", 0, 6)) {
                    var1 = false;
                }

                if(var1) {
                    var2 = var4;
                } else {
                    String var5;
                    if(var3.field_3350 != null) {
                        var5 = "" + class_688.class_1196.method_5084(var3.field_3350) + ":";
                    } else {
                        var5 = "";
                    }

                    if(var4.startsWith("//")) {
                        var2 = var5 + var4;
                    } else {
                        String var6 = var5 + "//";
                        if(var4.startsWith(var2)) {
                            var2 = var6 + var4;
                        } else {
                            String var7 = "";
                            if(var3.field_3351 > 0 && (var3.field_3350 == null || class_688.class_1196.method_5085(var3.field_3350) != var3.field_3351)) {
                                String var8 = ":" + var3.field_3351;
                                if(!var2.endsWith(var8)) {
                                    var7 = var8;
                                }
                            }

                            var2 = var6 + var2 + var7 + var4;
                        }
                    }
                }
            }

            this.field_3269 = var2;
        }

        return var2;
    }

    // $FF: renamed from: a (int) void
    public final void method_3733(int var1) {
        class_688 var2 = this.field_3268;
        if(var1 > 0) {
            var2.field_3351 = var1;
        }

    }

    // $FF: renamed from: a (long) void
    public final void method_3734(long var1) {
        if(!this.field_3276) {
            this.field_3275 += var1;
        }

    }

    // $FF: renamed from: a (android.location.Location) void
    public final void method_3735(Location var1) {
        double[] var2 = new double[] {var1.getLatitude(), var1.getLongitude()};
        this.field_3278 = var2;
    }

    // $FF: renamed from: a (crittercism.android.k$a) void
    public final void method_3736(class_688.class_1196 var1) {
        this.field_3268.field_3350 = var1;
    }

    // $FF: renamed from: a (java.io.OutputStream) void
    public final void method_391(OutputStream var1) {
        var1.write(this.method_3745().toString().getBytes());
    }

    // $FF: renamed from: a (java.lang.String) void
    public final void method_3737(String var1) {
        if(var1 == null) {
            throw new NullPointerException();
        } else {
            this.field_3269 = var1;
        }
    }

    // $FF: renamed from: a (java.lang.Throwable) void
    public final void method_3738(Throwable var1) {
        this.field_3267 = new class_744(var1);
    }

    // $FF: renamed from: a (java.net.InetAddress) void
    public final void method_3739(InetAddress var1) {
        this.field_3269 = null;
        this.field_3268.field_3347 = var1;
    }

    // $FF: renamed from: b () void
    public final void method_3740() {
        if(!this.field_3272 && this.field_3261 == Long.MAX_VALUE) {
            this.field_3261 = System.currentTimeMillis();
        }

    }

    // $FF: renamed from: b (long) void
    public final void method_3741(long var1) {
        this.field_3276 = true;
        this.field_3275 = var1;
    }

    // $FF: renamed from: b (java.lang.String) void
    public final void method_3742(String var1) {
        this.field_3269 = null;
        this.field_3268.field_3348 = var1;
    }

    // $FF: renamed from: c () void
    public final void method_3743() {
        if(!this.field_3273 && this.field_3271 == Long.MAX_VALUE) {
            this.field_3271 = System.currentTimeMillis();
        }

    }

    // $FF: renamed from: c (long) void
    public final void method_3744(long var1) {
        if(!this.field_3277) {
            this.field_3264 += var1;
        }

    }

    // $FF: renamed from: d () org.json.JSONArray
    public final JSONArray method_3745() {
        JSONArray var1 = new JSONArray();

        try {
            var1.put(this.field_3266);
            var1.put(this.method_3732());
            var1.put(class_807.field_3864.method_4195(new Date(this.field_3261)));
            var1.put(this.method_3731());
            var1.put(this.field_3270.method_3751());
            var1.put(this.field_3275);
            var1.put(this.field_3264);
            var1.put(this.field_3265);
            var1.put(this.field_3267.field_3520);
            var1.put(this.field_3267.field_3521);
            if(this.field_3278 != null) {
                JSONArray var13 = new JSONArray();
                var13.put(this.field_3278[0]);
                var13.put(this.field_3278[1]);
                var1.put(var13);
            }

            return var1;
        } catch (Exception var14) {
            System.out.println("Failed to create statsArray");
            var14.printStackTrace();
            return null;
        }
    }

    // $FF: renamed from: d (long) void
    public final void method_3746(long var1) {
        this.field_3277 = true;
        this.field_3264 = var1;
    }

    // $FF: renamed from: e () java.lang.String
    public final String method_392() {
        return this.field_3274;
    }

    // $FF: renamed from: e (long) void
    public final void method_3747(long var1) {
        this.field_3261 = var1;
        this.field_3272 = true;
    }

    // $FF: renamed from: f () void
    public final void method_3748() {
        this.field_3268.field_3352 = true;
    }

    // $FF: renamed from: f (long) void
    public final void method_3749(long var1) {
        this.field_3271 = var1;
        this.field_3273 = true;
    }

    public final String toString() {
        String var1 = "" + "URI            : " + this.field_3269 + "\n";
        String var2 = var1 + "URI Builder    : " + this.field_3268.toString() + "\n";
        String var3 = var2 + "\n";
        String var4 = var3 + "Logged by      : " + this.field_3263.toString() + "\n";
        String var5 = var4 + "Error type:         : " + this.field_3267.field_3520 + "\n";
        String var6 = var5 + "Error code:         : " + this.field_3267.field_3521 + "\n";
        String var7 = var6 + "\n";
        String var8 = var7 + "Response time  : " + this.method_3731() + "\n";
        String var9 = var8 + "Start time     : " + this.field_3261 + "\n";
        String var10 = var9 + "End time       : " + this.field_3271 + "\n";
        String var11 = var10 + "\n";
        String var12 = var11 + "Bytes out    : " + this.field_3264 + "\n";
        String var13 = var12 + "Bytes in     : " + this.field_3275 + "\n";
        String var14 = var13 + "\n";
        String var15 = var14 + "Response code  : " + this.field_3265 + "\n";
        String var16 = var15 + "Request method : " + this.field_3266 + "\n";
        if(this.field_3278 != null) {
            var16 = var16 + "Location       : " + Arrays.toString(this.field_3278) + "\n";
        }

        return var16;
    }

    public static enum class_1233 {
        // $FF: renamed from: a crittercism.android.c$a
        field_3850("Not logged"),
        // $FF: renamed from: b crittercism.android.c$a
        field_3851("InputStream.read()"),
        // $FF: renamed from: c crittercism.android.c$a
        field_3852("InputStream.close()"),
        // $FF: renamed from: d crittercism.android.c$a
        field_3853("Socket.close()"),
        // $FF: renamed from: e crittercism.android.c$a
        field_3854("Legacy java.net"),
        // $FF: renamed from: f crittercism.android.c$a
        field_3855("parse()"),
        // $FF: renamed from: g crittercism.android.c$a
        field_3856("finishedMessage()"),
        // $FF: renamed from: h crittercism.android.c$a
        field_3857("logError()"),
        // $FF: renamed from: i crittercism.android.c$a
        field_3858("MonitoredSocketImpl.connect()"),
        // $FF: renamed from: j crittercism.android.c$a
        field_3859("MonitoredSSLSocket.startHandshake"),
        // $FF: renamed from: k crittercism.android.c$a
        field_3860("Unit test"),
        // $FF: renamed from: l crittercism.android.c$a
        field_3861("logEndpoint");

        // $FF: renamed from: m java.lang.String
        private String field_3863;

        static {
            class_675.class_1233[] var0 = new class_675.class_1233[]{field_3850, field_3851, field_3852, field_3853, field_3854, field_3855, field_3856, field_3857, field_3858, field_3859, field_3860, field_3861};
        }

        private class_1233(String var3) {
            this.field_3863 = var3;
        }

        public final String toString() {
            return this.field_3863;
        }
    }
}
