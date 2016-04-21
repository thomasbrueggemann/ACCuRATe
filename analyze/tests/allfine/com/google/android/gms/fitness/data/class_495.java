package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.class_200;
import com.google.android.gms.fitness.data.l;
import com.google.android.gms.fitness.request.OnDataPointListener;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.fitness.data.l
public class class_495 extends class_200.class_1284 {
    // $FF: renamed from: Ti com.google.android.gms.fitness.request.OnDataPointListener
    private final OnDataPointListener field_2134;

    private class_495(OnDataPointListener var1) {
        this.field_2134 = (OnDataPointListener)class_1090.method_5685(var1);
    }

    // $FF: synthetic method
    class_495(OnDataPointListener var1, Object var2) {
        this(var1);
    }

    // $FF: renamed from: c (com.google.android.gms.fitness.data.DataPoint) void
    public void method_1046(DataPoint var1) throws RemoteException {
        this.field_2134.onDataPoint(var1);
    }

    public static class class_1739 {
        // $FF: renamed from: Tj com.google.android.gms.fitness.data.l$a
        private static final class_495.class_1739 field_4324 = new class_495.class_1739();
        // $FF: renamed from: Tk java.util.Map
        private final Map<OnDataPointListener, l> field_4325 = new HashMap();

        // $FF: renamed from: iV () com.google.android.gms.fitness.data.l$a
        public static class_495.class_1739 method_4906() {
            return field_4324;
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.OnDataPointListener) com.google.android.gms.fitness.data.l
        public class_495 method_4907(OnDataPointListener param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.fitness.request.OnDataPointListener) com.google.android.gms.fitness.data.l
        public class_495 method_4908(OnDataPointListener param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.fitness.request.OnDataPointListener) com.google.android.gms.fitness.data.l
        public class_495 method_4909(OnDataPointListener param1) {
            // $FF: Couldn't be decompiled
        }
    }
}
