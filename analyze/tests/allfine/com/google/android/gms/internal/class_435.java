package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.bp;
import com.google.android.gms.internal.class_247;
import com.google.android.gms.internal.class_248;
import com.google.android.gms.internal.class_437;
import com.google.android.gms.internal.ez;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.fq
@ez
public class class_435 implements class_437.class_1622<bp> {
    // $FF: renamed from: a (com.google.android.gms.internal.fo, org.json.JSONObject) com.google.android.gms.internal.bq$a
    // $FF: synthetic method
    public class_248.class_1288 method_878(class_437 var1, JSONObject var2) throws JSONException, InterruptedException, ExecutionException {
        return this.method_2763(var1, var2);
    }

    // $FF: renamed from: c (com.google.android.gms.internal.fo, org.json.JSONObject) com.google.android.gms.internal.bp
    public class_247 method_2763(class_437 var1, JSONObject var2) throws JSONException, InterruptedException, ExecutionException {
        Future var3 = var1.method_2770(var2, "image", true);
        Future var4 = var1.method_2770(var2, "secondary_image", false);
        return new class_247(var2.getString("headline"), (Drawable)var3.get(), var2.getString("body"), (Drawable)var4.get(), var2.getString("call_to_action"), var2.getString("attribution"));
    }
}
