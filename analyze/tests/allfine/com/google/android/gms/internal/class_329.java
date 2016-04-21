package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.internal.class_15;
import com.google.android.gms.internal.class_328;
import com.google.android.gms.internal.class_330;
import com.google.android.gms.internal.class_334;
import com.google.android.gms.internal.it;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.iq
public class class_329 extends class_328 {
    // $FF: renamed from: Hb long
    private static final long field_1094;
    // $FF: renamed from: Hc long
    private static final long field_1095;
    // $FF: renamed from: Hd long
    private static final long field_1096;
    // $FF: renamed from: He long
    private static final long field_1097;
    private static final String NAMESPACE = class_334.method_2302("com.google.cast.media");
    // $FF: renamed from: Hf long
    private long field_1098;
    // $FF: renamed from: Hg com.google.android.gms.cast.MediaStatus
    private MediaStatus field_1099;
    // $FF: renamed from: Hh com.google.android.gms.internal.it
    private final class_330 field_1100;
    // $FF: renamed from: Hi com.google.android.gms.internal.it
    private final class_330 field_1101;
    // $FF: renamed from: Hj com.google.android.gms.internal.it
    private final class_330 field_1102;
    // $FF: renamed from: Hk com.google.android.gms.internal.it
    private final class_330 field_1103;
    // $FF: renamed from: Hl com.google.android.gms.internal.it
    private final class_330 field_1104;
    // $FF: renamed from: Hm com.google.android.gms.internal.it
    private final class_330 field_1105;
    // $FF: renamed from: Hn com.google.android.gms.internal.it
    private final class_330 field_1106;
    // $FF: renamed from: Ho com.google.android.gms.internal.it
    private final class_330 field_1107;
    // $FF: renamed from: Hp com.google.android.gms.internal.it
    private final class_330 field_1108;
    // $FF: renamed from: Hq com.google.android.gms.internal.it
    private final class_330 field_1109;
    // $FF: renamed from: Hr java.util.List
    private final List<it> field_1110;
    // $FF: renamed from: Hs java.lang.Runnable
    private final Runnable field_1111;
    // $FF: renamed from: Ht boolean
    private boolean field_1112;
    private final Handler mHandler;

    static {
        field_1094 = TimeUnit.HOURS.toMillis(24L);
        field_1095 = TimeUnit.HOURS.toMillis(24L);
        field_1096 = TimeUnit.HOURS.toMillis(24L);
        field_1097 = TimeUnit.SECONDS.toMillis(1L);
    }

    public class_329() {
        this((String)null);
    }

    public class_329(String var1) {
        super(NAMESPACE, "MediaControlChannel", var1);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.field_1111 = new class_329.class_1698();
        this.field_1110 = new ArrayList();
        this.field_1100 = new class_330(field_1095);
        this.field_1110.add(this.field_1100);
        this.field_1101 = new class_330(field_1094);
        this.field_1110.add(this.field_1101);
        this.field_1102 = new class_330(field_1094);
        this.field_1110.add(this.field_1102);
        this.field_1103 = new class_330(field_1094);
        this.field_1110.add(this.field_1103);
        this.field_1104 = new class_330(field_1096);
        this.field_1110.add(this.field_1104);
        this.field_1105 = new class_330(field_1094);
        this.field_1110.add(this.field_1105);
        this.field_1106 = new class_330(field_1094);
        this.field_1110.add(this.field_1106);
        this.field_1107 = new class_330(field_1094);
        this.field_1110.add(this.field_1107);
        this.field_1108 = new class_330(field_1094);
        this.field_1110.add(this.field_1108);
        this.field_1109 = new class_330(field_1094);
        this.field_1110.add(this.field_1109);
        this.method_2257();
    }

    // $FF: renamed from: H (boolean) void
    private void method_2252(boolean var1) {
        if(this.field_1112 != var1) {
            this.field_1112 = var1;
            if(!var1) {
                this.mHandler.removeCallbacks(this.field_1111);
                return;
            }

            this.mHandler.postDelayed(this.field_1111, field_1097);
        }

    }

    // $FF: renamed from: a (com.google.android.gms.internal.iq) java.util.List
    // $FF: synthetic method
    static List method_2253(class_329 var0) {
        return var0.field_1110;
    }

    // $FF: renamed from: a (long, org.json.JSONObject) void
    private void method_2254(long var1, JSONObject var3) throws JSONException {
        boolean var4 = true;
        boolean var5 = this.field_1100.method_2275(var1);
        boolean var6;
        if(this.field_1104.method_2274() && !this.field_1104.method_2275(var1)) {
            var6 = var4;
        } else {
            var6 = false;
        }

        if((!this.field_1105.method_2274() || this.field_1105.method_2275(var1)) && (!this.field_1106.method_2274() || this.field_1106.method_2275(var1))) {
            var4 = false;
        }

        int var7;
        if(var6) {
            var7 = 2;
        } else {
            var7 = 0;
        }

        if(var4) {
            var7 |= 1;
        }

        int var8;
        if(!var5 && this.field_1099 != null) {
            var8 = this.field_1099.method_4389(var3, var7);
        } else {
            this.field_1099 = new MediaStatus(var3);
            this.field_1098 = SystemClock.elapsedRealtime();
            var8 = 7;
        }

        if((var8 & 1) != 0) {
            this.field_1098 = SystemClock.elapsedRealtime();
            this.onStatusUpdated();
        }

        if((var8 & 2) != 0) {
            this.field_1098 = SystemClock.elapsedRealtime();
            this.onStatusUpdated();
        }

        if((var8 & 4) != 0) {
            this.onMetadataUpdated();
        }

        Iterator var9 = this.field_1110.iterator();

        while(var9.hasNext()) {
            ((class_330)var9.next()).method_2272(var1, 0);
        }

    }

    // $FF: renamed from: a (com.google.android.gms.internal.iq, boolean) boolean
    // $FF: synthetic method
    static boolean method_2255(class_329 var0, boolean var1) {
        var0.field_1112 = var1;
        return var1;
    }

    // $FF: renamed from: b (com.google.android.gms.internal.iq, boolean) void
    // $FF: synthetic method
    static void method_2256(class_329 var0, boolean var1) {
        var0.method_2252(var1);
    }

    // $FF: renamed from: fT () void
    private void method_2257() {
        this.method_2252(false);
        this.field_1098 = 0L;
        this.field_1099 = null;
        this.field_1100.clear();
        this.field_1104.clear();
        this.field_1105.clear();
    }

    // $FF: renamed from: a (com.google.android.gms.internal.is) long
    public long method_2258(class_15 var1) throws IOException {
        JSONObject var2 = new JSONObject();
        long var3 = this.fz();
        this.field_1107.method_2270(var3, var1);
        this.method_2252(true);

        try {
            var2.put("requestId", var3);
            var2.put("type", "GET_STATUS");
            if(this.field_1099 != null) {
                var2.put("mediaSessionId", this.field_1099.method_4390());
            }
        } catch (JSONException var6) {
            ;
        }

        this.a(var2.toString(), var3, (String)null);
        return var3;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.is, double, org.json.JSONObject) long
    public long method_2259(class_15 param1, double param2, JSONObject param4) throws IOException, IllegalStateException, IllegalArgumentException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.internal.is, long, int, org.json.JSONObject) long
    public long method_2260(class_15 param1, long param2, int param4, JSONObject param5) throws IOException, IllegalStateException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.internal.is, com.google.android.gms.cast.MediaInfo, boolean, long, long[], org.json.JSONObject) long
    public long method_2261(class_15 param1, MediaInfo param2, boolean param3, long param4, long[] param6, JSONObject param7) throws IOException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.internal.is, com.google.android.gms.cast.TextTrackStyle) long
    public long method_2262(class_15 param1, TextTrackStyle param2) throws IOException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.internal.is, org.json.JSONObject) long
    public long method_2263(class_15 param1, JSONObject param2) throws IOException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.internal.is, boolean, org.json.JSONObject) long
    public long method_2264(class_15 param1, boolean param2, JSONObject param3) throws IOException, IllegalStateException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.internal.is, long[]) long
    public long method_2265(class_15 param1, long[] param2) throws IOException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: aD (java.lang.String) void
    public final void method_2248(String param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (com.google.android.gms.internal.is, org.json.JSONObject) long
    public long method_2266(class_15 param1, JSONObject param2) throws IOException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (long, int) void
    public void method_2249(long var1, int var3) {
        Iterator var4 = this.field_1110.iterator();

        while(var4.hasNext()) {
            ((class_330)var4.next()).method_2272(var1, var3);
        }

    }

    // $FF: renamed from: c (com.google.android.gms.internal.is, org.json.JSONObject) long
    public long method_2267(class_15 param1, JSONObject param2) throws IOException, IllegalStateException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: fA () void
    public void method_2250() {
        this.method_2257();
    }

    // $FF: renamed from: fw () long
    public long method_2268() throws IllegalStateException {
        if(this.field_1099 == null) {
            throw new IllegalStateException("No current media session");
        } else {
            return this.field_1099.method_4390();
        }
    }

    public long getApproximateStreamPosition() {
        MediaInfo var1 = this.getMediaInfo();
        if(var1 != null && this.field_1098 != 0L) {
            double var2 = this.field_1099.getPlaybackRate();
            long var4 = this.field_1099.getStreamPosition();
            int var6 = this.field_1099.getPlayerState();
            if(var2 != 0.0D && var6 == 2) {
                long var7 = SystemClock.elapsedRealtime() - this.field_1098;
                long var9;
                if(var7 < 0L) {
                    var9 = 0L;
                } else {
                    var9 = var7;
                }

                if(var9 == 0L) {
                    return var4;
                } else {
                    long var11 = var1.getStreamDuration();
                    long var13 = var4 + (long)(var2 * (double)var9);
                    if(var11 <= 0L || var13 <= var11) {
                        if(var13 < 0L) {
                            var11 = 0L;
                        } else {
                            var11 = var13;
                        }
                    }

                    return var11;
                }
            } else {
                return var4;
            }
        } else {
            return 0L;
        }
    }

    public MediaInfo getMediaInfo() {
        return this.field_1099 == null?null:this.field_1099.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.field_1099;
    }

    public long getStreamDuration() {
        MediaInfo var1 = this.getMediaInfo();
        return var1 != null?var1.getStreamDuration():0L;
    }

    protected void onMetadataUpdated() {
    }

    protected void onStatusUpdated() {
    }

    private class class_1698 implements Runnable {
        private class_1698() {
        }

        // $FF: synthetic method
        class_1698(Object var2) {
            this();
        }

        public void run() {
            // $FF: Couldn't be decompiled
        }
    }
}
