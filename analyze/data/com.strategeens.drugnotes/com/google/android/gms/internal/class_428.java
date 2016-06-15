package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.bu;
import com.google.android.gms.internal.class_238;
import com.google.android.gms.internal.class_241;
import com.google.android.gms.internal.class_430;
import com.google.android.gms.internal.ey;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.fp
@ey
public class class_428 implements class_430.class_1524<bu> {
   // $FF: renamed from: a (com.google.android.gms.internal.fn, org.json.JSONObject) com.google.android.gms.internal.bv$a
   // $FF: synthetic method
   public class_238.class_1220 method_933(class_430 var1, JSONObject var2) throws JSONException, InterruptedException, ExecutionException {
      return this.method_2835(var1, var2);
   }

   // $FF: renamed from: c (com.google.android.gms.internal.fn, org.json.JSONObject) com.google.android.gms.internal.bu
   public class_241 method_2835(class_430 var1, JSONObject var2) throws JSONException, InterruptedException, ExecutionException {
      Future var3 = var1.method_2842(var2, "image", true);
      Future var4 = var1.method_2842(var2, "secondary_image", false);
      return new class_241(var2.getString("headline"), (Drawable)var3.get(), var2.getString("body"), (Drawable)var4.get(), var2.getString("call_to_action"), var2.getString("attribution"));
   }
}
