package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.bt;
import com.google.android.gms.internal.class_238;
import com.google.android.gms.internal.class_240;
import com.google.android.gms.internal.class_430;
import com.google.android.gms.internal.ey;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.fo
@ey
public class class_429 implements class_430.class_1524<bt> {
   // $FF: renamed from: a (com.google.android.gms.internal.fn, org.json.JSONObject) com.google.android.gms.internal.bv$a
   // $FF: synthetic method
   public class_238.class_1220 method_933(class_430 var1, JSONObject var2) throws JSONException, InterruptedException, ExecutionException {
      return this.method_2836(var1, var2);
   }

   // $FF: renamed from: b (com.google.android.gms.internal.fn, org.json.JSONObject) com.google.android.gms.internal.bt
   public class_240 method_2836(class_430 var1, JSONObject var2) throws JSONException, InterruptedException, ExecutionException {
      Future var3 = var1.method_2842(var2, "image", true);
      Future var4 = var1.method_2842(var2, "app_icon", true);
      return new class_240(var2.getString("headline"), (Drawable)var3.get(), var2.getString("body"), (Drawable)var4.get(), var2.getString("call_to_action"), var2.optDouble("rating", -1.0D), var2.optString("store"), var2.optString("price"));
   }
}
