package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.analytics.class_176;
import com.google.android.gms.analytics.class_938;
import com.google.android.gms.analytics.i;

// $FF: renamed from: com.google.android.gms.analytics.j
abstract class class_923<T extends i> {
    Context mContext;
    // $FF: renamed from: xV com.google.android.gms.analytics.j$a
    class_923.class_1618<T> field_4231;

    public class_923(Context var1, class_923.class_1618<T> var2) {
        this.mContext = var1;
        this.field_4231 = var2;
    }

    // $FF: renamed from: a (android.content.res.XmlResourceParser) com.google.android.gms.analytics.i
    private T method_4774(XmlResourceParser param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: w (int) com.google.android.gms.analytics.i
    public T method_4775(int var1) {
        try {
            class_176 var3 = this.method_4774(this.mContext.getResources().getXml(var1));
            return var3;
        } catch (NotFoundException var4) {
            class_938.method_4861("inflate() called with unknown resourceId: " + var4);
            return null;
        }
    }

    public interface class_1618<U extends i> {
        // $FF: renamed from: c (java.lang.String, int) void
        void method_1047(String var1, int var2);

        // $FF: renamed from: d (java.lang.String, boolean) void
        void method_1048(String var1, boolean var2);

        // $FF: renamed from: dW () com.google.android.gms.analytics.i
        U method_1049();

        // $FF: renamed from: f (java.lang.String, java.lang.String) void
        void method_1050(String var1, String var2);

        // $FF: renamed from: g (java.lang.String, java.lang.String) void
        void method_1051(String var1, String var2);
    }
}
