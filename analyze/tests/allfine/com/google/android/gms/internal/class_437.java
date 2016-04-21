package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.internal.class_0;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_248;
import com.google.android.gms.internal.class_344;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_385;
import com.google.android.gms.internal.class_386;
import com.google.android.gms.internal.class_435;
import com.google.android.gms.internal.class_436;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.class_538;
import com.google.android.gms.internal.class_9;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fz;
import com.google.android.gms.internal.gv;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.fo
@ez
public class class_437 implements Callable<fz> {
    private final Context mContext;
    // $FF: renamed from: mw java.lang.Object
    private final Object field_1617 = new Object();
    // $FF: renamed from: pw com.google.android.gms.internal.u
    private final class_538 field_1618;
    // $FF: renamed from: tX com.google.android.gms.internal.go
    private final class_368 field_1619;
    // $FF: renamed from: tY com.google.android.gms.internal.ai
    private final class_234 field_1620;
    // $FF: renamed from: tZ boolean
    private boolean field_1621;
    // $FF: renamed from: tc int
    private int field_1622;
    // $FF: renamed from: tn com.google.android.gms.internal.fz$a
    private final class_438.class_1623 field_1623;
    // $FF: renamed from: ua java.util.List
    private List<String> field_1624;

    public class_437(Context var1, class_538 var2, class_234 var3, class_368 var4, class_438.class_1623 var5) {
        this.mContext = var1;
        this.field_1618 = var2;
        this.field_1619 = var4;
        this.field_1620 = var3;
        this.field_1623 = var5;
        this.field_1621 = false;
        this.field_1622 = -2;
        this.field_1624 = null;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ah, com.google.android.gms.internal.fo$a, org.json.JSONObject) com.google.android.gms.internal.bq$a
    private class_248.class_1288 method_2765(class_0 var1, class_437.class_1622 var2, JSONObject var3) throws ExecutionException, InterruptedException, JSONException {
        if(this.method_2774()) {
            return null;
        } else {
            String[] var4 = this.method_2767(var3.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
            List var5;
            if(var4 == null) {
                var5 = null;
            } else {
                var5 = Arrays.asList(var4);
            }

            this.field_1624 = var5;
            class_248.class_1288 var6 = var2.method_878(this, var3);
            if(var6 == null) {
                class_378.method_2458("Failed to retrieve ad assets.");
                return null;
            } else {
                var6.method_832(new class_248(this.field_1618, var1, var3));
                return var6;
            }
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.bq$a) com.google.android.gms.internal.fz
    private class_438 method_2766(class_248.class_1288 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (org.json.JSONObject, java.lang.String) java.lang.String[]
    private String[] method_2767(JSONObject var1, String var2) throws JSONException {
        JSONArray var3 = var1.optJSONArray(var2);
        if(var3 == null) {
            return null;
        } else {
            String[] var4 = new String[var3.length()];

            for(int var5 = 0; var5 < var3.length(); ++var5) {
                var4[var5] = var3.getString(var5);
            }

            return var4;
        }
    }

    // $FF: renamed from: c (com.google.android.gms.internal.ah) org.json.JSONObject
    private JSONObject method_2768(final class_0 var1) throws TimeoutException, JSONException {
        if(this.method_2774()) {
            return null;
        } else {
            final class_386 var2 = new class_386();
            var1.method_2("/nativeAdPreProcess", new class_9() {
                // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
                public void method_24(gv var1x, Map<String, String> var2x) {
                    var1.method_5("/nativeAdPreProcess");

                    try {
                        String var4 = (String)var2x.get("success");
                        if(!TextUtils.isEmpty(var4)) {
                            var2.method_2538((new JSONObject(var4)).getJSONArray("ads").getJSONObject(0));
                            return;
                        }
                    } catch (JSONException var5) {
                        class_378.method_2463("Malformed native JSON response.", var5);
                    }

                    class_437.this.method_2775(0);
                    class_1090.method_5676(class_437.this.method_2774(), "Unable to set the ad state error!");
                    var2.method_2538((Object)null);
                }
            });
            var1.method_3("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.field_1623.field_5210.field_1697));
            return (JSONObject)var2.get();
        }
    }

    // $FF: renamed from: cG () com.google.android.gms.internal.ah
    private class_0 method_2769() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        if(this.method_2774()) {
            return null;
        } else {
            class_0 var1 = (class_0)this.field_1620.method_1573(this.mContext, this.field_1623.field_5209.field_1712, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html").get();
            var1.method_1(this.field_1618, this.field_1618, this.field_1618, this.field_1618, false, this.field_1618);
            return var1;
        }
    }

    // $FF: renamed from: a (org.json.JSONObject, java.lang.String, boolean) java.util.concurrent.Future
    public Future<Drawable> method_2770(JSONObject var1, String var2, final boolean var3) throws JSONException {
        JSONObject var4;
        if(var3) {
            var4 = var1.getJSONObject(var2);
        } else {
            var4 = var1.optJSONObject(var2);
        }

        if(var4 == null) {
            var4 = new JSONObject();
        }

        String var5;
        if(var3) {
            var5 = var4.getString("url");
        } else {
            var5 = var4.optString("url");
        }

        if(TextUtils.isEmpty(var5)) {
            this.method_2771(0, var3);
            return new class_385((Object)null);
        } else {
            return this.field_1619.method_2416(var5, new class_368.class_1521() {
                // $FF: renamed from: a (java.io.InputStream) android.graphics.drawable.Drawable
                public Drawable method_5276(InputStream var1) {
                    byte[] var3x;
                    label20: {
                        byte[] var5;
                        try {
                            var5 = class_344.method_2324(var1);
                        } catch (IOException var6) {
                            var3x = null;
                            break label20;
                        }

                        var3x = var5;
                    }

                    if(var3x == null) {
                        class_437.this.method_2771(2, var3);
                        return null;
                    } else {
                        Bitmap var4 = BitmapFactory.decodeByteArray(var3x, 0, var3x.length);
                        if(var4 == null) {
                            class_437.this.method_2771(2, var3);
                            return null;
                        } else {
                            return new BitmapDrawable(Resources.getSystem(), var4);
                        }
                    }
                }

                // $FF: renamed from: b (java.io.InputStream) java.lang.Object
                // $FF: synthetic method
                public Object method_376(InputStream var1) {
                    return this.method_5276(var1);
                }

                // $FF: renamed from: cI () android.graphics.drawable.Drawable
                public Drawable method_5277() {
                    class_437.this.method_2771(2, var3);
                    return null;
                }

                // $FF: renamed from: cJ () java.lang.Object
                // $FF: synthetic method
                public Object method_377() {
                    return this.method_5277();
                }
            });
        }
    }

    // $FF: renamed from: a (int, boolean) void
    public void method_2771(int var1, boolean var2) {
        if(var2) {
            this.method_2775(var1);
        }

    }

    // $FF: renamed from: b (org.json.JSONObject) com.google.android.gms.internal.fo$a
    protected class_437.class_1622 method_2772(JSONObject var1) throws JSONException {
        if(this.method_2774()) {
            return null;
        } else {
            String var2 = var1.getString("template_id");
            if("2".equals(var2)) {
                return new class_436();
            } else if("1".equals(var2)) {
                return new class_435();
            } else {
                this.method_2775(0);
                return null;
            }
        }
    }

    // $FF: renamed from: cF () com.google.android.gms.internal.fz
    public class_438 method_2773() {
        try {
            class_0 var6 = this.method_2769();
            JSONObject var7 = this.method_2768(var6);
            class_438 var8 = this.method_2766(this.method_2765(var6, this.method_2772(var7), var7));
            return var8;
        } catch (CancellationException var9) {
            ;
        } catch (ExecutionException var10) {
            ;
        } catch (InterruptedException var11) {
            ;
        } catch (JSONException var12) {
            class_378.method_2465("Malformed native JSON response.", var12);
        } catch (TimeoutException var13) {
            class_378.method_2465("Timeout when loading native ad.", var13);
        }

        if(!this.field_1621) {
            this.method_2775(0);
        }

        return this.method_2766((class_248.class_1288)null);
    }

    // $FF: renamed from: cH () boolean
    public boolean method_2774() {
        // $FF: Couldn't be decompiled
    }

    // $FF: synthetic method
    public Object call() throws Exception {
        return this.method_2773();
    }

    // $FF: renamed from: s (int) void
    public void method_2775(int param1) {
        // $FF: Couldn't be decompiled
    }

    public interface class_1622<T extends class_248.class_1288> {
        // $FF: renamed from: a (com.google.android.gms.internal.fo, org.json.JSONObject) com.google.android.gms.internal.bq$a
        T method_878(fo var1, JSONObject var2) throws JSONException, InterruptedException, ExecutionException;
    }
}
