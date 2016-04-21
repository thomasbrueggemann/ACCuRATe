package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.internal.class_364;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_410;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.fc
@ez
public class class_443 implements Runnable {
    // $FF: renamed from: lf int
    private final int field_1682;
    // $FF: renamed from: lg int
    private final int field_1683;
    // $FF: renamed from: md com.google.android.gms.internal.gv
    protected final class_381 field_1684;
    // $FF: renamed from: td android.os.Handler
    private final Handler field_1685;
    // $FF: renamed from: te long
    private final long field_1686;
    // $FF: renamed from: tf long
    private long field_1687;
    // $FF: renamed from: tg com.google.android.gms.internal.gw$a
    private class_364.class_1738 field_1688;
    // $FF: renamed from: th boolean
    protected boolean field_1689;
    // $FF: renamed from: ti boolean
    protected boolean field_1690;

    public class_443(class_364.class_1738 var1, class_381 var2, int var3, int var4) {
        this(var1, var2, var3, var4, 200L, 50L);
    }

    public class_443(class_364.class_1738 var1, class_381 var2, int var3, int var4, long var5, long var7) {
        this.field_1686 = var5;
        this.field_1687 = var7;
        this.field_1685 = new Handler(Looper.getMainLooper());
        this.field_1684 = var2;
        this.field_1688 = var1;
        this.field_1689 = false;
        this.field_1690 = false;
        this.field_1683 = var4;
        this.field_1682 = var3;
    }

    // $FF: renamed from: c (com.google.android.gms.internal.fc) long
    // $FF: synthetic method
    static long method_2786(class_443 var0) {
        long var1 = var0.field_1687 - 1L;
        var0.field_1687 = var1;
        return var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.fk, com.google.android.gms.internal.ha) void
    public void method_2791(class_447 var1, class_410 var2) {
        this.field_1684.setWebViewClient(var2);
        class_381 var3 = this.field_1684;
        String var4;
        if(TextUtils.isEmpty(var1.field_1695)) {
            var4 = null;
        } else {
            var4 = class_383.method_2499(var1.field_1695);
        }

        var3.loadDataWithBaseURL(var4, var1.field_1697, "text/html", "UTF-8", (String)null);
    }

    // $FF: renamed from: b (com.google.android.gms.internal.fk) void
    public void method_2792(class_447 var1) {
        this.method_2791(var1, new class_410(this, this.field_1684, var1.field_1706));
    }

    // $FF: renamed from: cA () boolean
    public boolean method_2793() {
        synchronized(this) {}

        boolean var2;
        try {
            var2 = this.field_1689;
        } finally {
            ;
        }

        return var2;
    }

    // $FF: renamed from: cB () boolean
    public boolean method_2794() {
        return this.field_1690;
    }

    // $FF: renamed from: cy () void
    public void method_2795() {
        this.field_1685.postDelayed(this, this.field_1686);
    }

    // $FF: renamed from: cz () void
    public void method_2796() {
        synchronized(this) {}

        try {
            this.field_1689 = true;
        } finally {
            ;
        }

    }

    public void run() {
        if(this.field_1684 != null && !this.method_2793()) {
            (new class_443.class_1269(this.field_1684)).execute(new Void[0]);
        } else {
            this.field_1688.method_831(this.field_1684);
        }
    }

    protected final class class_1269 extends AsyncTask<Void, Void, Boolean> {
        // $FF: renamed from: tj android.webkit.WebView
        private final WebView field_2092;
        // $FF: renamed from: tk android.graphics.Bitmap
        private Bitmap field_2093;

        public class_1269(WebView var2) {
            this.field_2092 = var2;
        }

        // $FF: renamed from: a (java.lang.Void[]) java.lang.Boolean
        protected Boolean method_3013(Void... param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.Boolean) void
        protected void method_3014(Boolean var1) {
            class_443.method_2786(class_443.this);
            if(!var1.booleanValue() && !class_443.this.method_2793() && class_443.this.field_1687 > 0L) {
                if(class_443.this.field_1687 > 0L) {
                    if(class_378.method_2466(2)) {
                        class_378.method_2457("Ad not detected, scheduling another run.");
                    }

                    class_443.this.field_1685.postDelayed(class_443.this, class_443.this.field_1686);
                    return;
                }
            } else {
                class_443.this.field_1690 = var1.booleanValue();
                class_443.this.field_1688.method_831(class_443.this.field_1684);
            }

        }

        // $FF: synthetic method
        protected Object doInBackground(Object[] var1) {
            return this.method_3013((Void[])var1);
        }

        // $FF: synthetic method
        protected void onPostExecute(Object var1) {
            this.method_3014((Boolean)var1);
        }

        protected void onPreExecute() {
            synchronized(this) {}

            try {
                this.field_2093 = Bitmap.createBitmap(class_443.this.field_1682, class_443.this.field_1683, Config.ARGB_8888);
                this.field_2092.setVisibility(0);
                this.field_2092.measure(MeasureSpec.makeMeasureSpec(class_443.this.field_1682, 0), MeasureSpec.makeMeasureSpec(class_443.this.field_1683, 0));
                this.field_2092.layout(0, 0, class_443.this.field_1682, class_443.this.field_1683);
                Canvas var2 = new Canvas(this.field_2093);
                this.field_2092.draw(var2);
                this.field_2092.invalidate();
            } finally {
                ;
            }

        }
    }
}
