package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.do;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.gv;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.do
@ez
public final class class_468 extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    // $FF: renamed from: md com.google.android.gms.internal.gv
    private final class_381 field_1796;
    // $FF: renamed from: rX android.widget.MediaController
    private final MediaController field_1797;
    // $FF: renamed from: rY com.google.android.gms.internal.do$a
    private final class_468.class_1660 field_1798;
    // $FF: renamed from: rZ android.widget.VideoView
    private final VideoView field_1799;
    // $FF: renamed from: sa long
    private long field_1800;
    // $FF: renamed from: sb java.lang.String
    private String field_1801;

    public class_468(Context var1, class_381 var2) {
        super(var1);
        this.field_1796 = var2;
        this.field_1799 = new VideoView(var1);
        LayoutParams var3 = new LayoutParams(-1, -1, 17);
        this.addView(this.field_1799, var3);
        this.field_1797 = new MediaController(var1);
        this.field_1798 = new class_468.class_1660(this);
        this.field_1798.method_5548();
        this.field_1799.setOnCompletionListener(this);
        this.field_1799.setOnPreparedListener(this);
        this.field_1799.setOnErrorListener(this);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.gv, java.lang.String) void
    private static void method_2851(class_381 var0, String var1) {
        method_2854(var0, var1, new HashMap(1));
    }

    // $FF: renamed from: a (com.google.android.gms.internal.gv, java.lang.String, java.lang.String) void
    public static void method_2852(class_381 var0, String var1, String var2) {
        boolean var3;
        if(var2 == null) {
            var3 = true;
        } else {
            var3 = false;
        }

        byte var4;
        if(var3) {
            var4 = 2;
        } else {
            var4 = 3;
        }

        HashMap var5 = new HashMap(var4);
        var5.put("what", var1);
        if(!var3) {
            var5.put("extra", var2);
        }

        method_2854(var0, "error", var5);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.gv, java.lang.String, java.lang.String, java.lang.String) void
    private static void method_2853(class_381 var0, String var1, String var2, String var3) {
        HashMap var4 = new HashMap(2);
        var4.put(var2, var3);
        method_2854(var0, var1, var4);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.gv, java.lang.String, java.util.Map) void
    private static void method_2854(gv var0, String var1, Map<String, String> var2) {
        var2.put("event", var1);
        var0.method_2479("onVideoEvent", var2);
    }

    // $FF: renamed from: C (java.lang.String) void
    public void method_2855(String var1) {
        this.field_1801 = var1;
    }

    // $FF: renamed from: b (android.view.MotionEvent) void
    public void method_2856(MotionEvent var1) {
        this.field_1799.dispatchTouchEvent(var1);
    }

    // $FF: renamed from: ch () void
    public void method_2857() {
        if(!TextUtils.isEmpty(this.field_1801)) {
            this.field_1799.setVideoPath(this.field_1801);
        } else {
            method_2852(this.field_1796, "no_src", (String)null);
        }
    }

    // $FF: renamed from: ci () void
    public void method_2858() {
        long var1 = (long)this.field_1799.getCurrentPosition();
        if(this.field_1800 != var1) {
            float var3 = (float)var1 / 1000.0F;
            method_2853(this.field_1796, "timeupdate", "time", String.valueOf(var3));
            this.field_1800 = var1;
        }

    }

    public void destroy() {
        this.field_1798.cancel();
        this.field_1799.stopPlayback();
    }

    public void onCompletion(MediaPlayer var1) {
        method_2851(this.field_1796, "ended");
    }

    public boolean onError(MediaPlayer var1, int var2, int var3) {
        method_2852(this.field_1796, String.valueOf(var2), String.valueOf(var3));
        return true;
    }

    public void onPrepared(MediaPlayer var1) {
        float var2 = (float)this.field_1799.getDuration() / 1000.0F;
        method_2853(this.field_1796, "canplaythrough", "duration", String.valueOf(var2));
    }

    public void pause() {
        this.field_1799.pause();
    }

    public void play() {
        this.field_1799.start();
    }

    // $FF: renamed from: q (boolean) void
    public void method_2859(boolean var1) {
        if(var1) {
            this.field_1799.setMediaController(this.field_1797);
        } else {
            this.field_1797.hide();
            this.field_1799.setMediaController((MediaController)null);
        }
    }

    public void seekTo(int var1) {
        this.field_1799.seekTo(var1);
    }

    private static final class class_1660 {
        // $FF: renamed from: mk java.lang.Runnable
        private final Runnable field_5024;
        // $FF: renamed from: sc boolean
        private volatile boolean field_5025 = false;

        public class_1660(final class_468 var1) {
            this.field_5024 = new Runnable() {
                // $FF: renamed from: sd java.lang.ref.WeakReference
                private final WeakReference<do> field_4729 = new WeakReference(var1);

                public void run() {
                    class_468 var1x = (class_468)this.field_4729.get();
                    if(!class_1660.this.field_5025 && var1x != null) {
                        var1x.method_2858();
                        class_1660.this.method_5548();
                    }

                }
            };
        }

        public void cancel() {
            this.field_5025 = true;
            class_377.field_1386.removeCallbacks(this.field_5024);
        }

        // $FF: renamed from: cj () void
        public void method_5548() {
            class_377.field_1386.postDelayed(this.field_5024, 250L);
        }
    }
}
