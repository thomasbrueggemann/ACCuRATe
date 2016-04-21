package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.a;
import com.google.android.gms.common.images.class_550;
import com.google.android.gms.common.internal.class_1097;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.class_854;
import com.google.android.gms.internal.ja;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    // $FF: renamed from: Ks java.lang.Object
    private static final Object field_2095 = new Object();
    // $FF: renamed from: Kt java.util.HashSet
    private static HashSet<Uri> field_2096 = new HashSet();
    // $FF: renamed from: Ku com.google.android.gms.common.images.ImageManager
    private static ImageManager field_2097;
    // $FF: renamed from: Kv com.google.android.gms.common.images.ImageManager
    private static ImageManager field_2098;
    // $FF: renamed from: KA java.util.Map
    private final Map<Uri, ImageManager.ImageReceiver> field_2099;
    // $FF: renamed from: KB java.util.Map
    private final Map<Uri, Long> field_2100;
    // $FF: renamed from: Kw java.util.concurrent.ExecutorService
    private final ExecutorService field_2101;
    // $FF: renamed from: Kx com.google.android.gms.common.images.ImageManager$b
    private final ImageManager.class_1271 field_2102;
    // $FF: renamed from: Ky com.google.android.gms.internal.iz
    private final class_322 field_2103;
    // $FF: renamed from: Kz java.util.Map
    private final Map<a, ImageManager.ImageReceiver> field_2104;
    private final Context mContext;
    private final Handler mHandler;

    private ImageManager(Context var1, boolean var2) {
        this.mContext = var1.getApplicationContext();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.field_2101 = Executors.newFixedThreadPool(4);
        if(var2) {
            this.field_2102 = new ImageManager.class_1271(this.mContext);
            if(class_854.method_4496()) {
                this.method_3025();
            }
        } else {
            this.field_2102 = null;
        }

        this.field_2103 = new class_322();
        this.field_2104 = new HashMap();
        this.field_2099 = new HashMap();
        this.field_2100 = new HashMap();
    }

    // $FF: renamed from: a (com.google.android.gms.common.images.ImageManager, com.google.android.gms.common.images.a$a) android.graphics.Bitmap
    // $FF: synthetic method
    static Bitmap method_3015(ImageManager var0, class_550.class_1812 var1) {
        return var0.method_3016(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.common.images.a$a) android.graphics.Bitmap
    private Bitmap method_3016(class_550.class_1812 var1) {
        return this.field_2102 == null?null:(Bitmap)this.field_2102.get(var1);
    }

    // $FF: renamed from: c (android.content.Context, boolean) com.google.android.gms.common.images.ImageManager
    public static ImageManager method_3019(Context var0, boolean var1) {
        if(var1) {
            if(field_2098 == null) {
                field_2098 = new ImageManager(var0, true);
            }

            return field_2098;
        } else {
            if(field_2097 == null) {
                field_2097 = new ImageManager(var0, false);
            }

            return field_2097;
        }
    }

    public static ImageManager create(Context var0) {
        return method_3019(var0, false);
    }

    // $FF: renamed from: e (com.google.android.gms.common.images.ImageManager) java.util.Map
    // $FF: synthetic method
    static Map method_3022(ImageManager var0) {
        return var0.field_2099;
    }

    // $FF: renamed from: gG () void
    private void method_3025() {
        this.mContext.registerComponentCallbacks(new ImageManager.class_1274(this.field_2102));
    }

    // $FF: renamed from: gH () java.lang.Object
    // $FF: synthetic method
    static Object method_3026() {
        return field_2095;
    }

    // $FF: renamed from: gI () java.util.HashSet
    // $FF: synthetic method
    static HashSet method_3027() {
        return field_2096;
    }

    // $FF: renamed from: h (com.google.android.gms.common.images.ImageManager) com.google.android.gms.common.images.ImageManager$b
    // $FF: synthetic method
    static ImageManager.class_1271 method_3028(ImageManager var0) {
        return var0.field_2102;
    }

    // $FF: renamed from: a (com.google.android.gms.common.images.a) void
    public void method_3029(class_550 var1) {
        class_1097.method_5712("ImageManager.loadImage() must be called in the main thread");
        (new ImageManager.class_1273(var1)).run();
    }

    public void loadImage(ImageView var1, int var2) {
        this.method_3029(new class_550.class_1813(var1, var2));
    }

    public void loadImage(ImageView var1, Uri var2) {
        this.method_3029(new class_550.class_1813(var1, var2));
    }

    public void loadImage(ImageView var1, Uri var2, int var3) {
        class_550.class_1813 var4 = new class_550.class_1813(var1, var2);
        var4.method_3384(var3);
        this.method_3029(var4);
    }

    public void loadImage(ImageManager.OnImageLoadedListener var1, Uri var2) {
        this.method_3029(new class_550.class_1814(var1, var2));
    }

    public void loadImage(ImageManager.OnImageLoadedListener var1, Uri var2, int var3) {
        class_550.class_1814 var4 = new class_550.class_1814(var1, var2);
        var4.method_3384(var3);
        this.method_3029(var4);
    }

    private final class ImageReceiver extends ResultReceiver {
        // $FF: renamed from: KC java.util.ArrayList
        private final ArrayList<a> field_3174;
        private final Uri mUri;

        ImageReceiver(Uri var2) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = var2;
            this.field_3174 = new ArrayList();
        }

        // $FF: renamed from: b (com.google.android.gms.common.images.a) void
        public void method_3636(class_550 var1) {
            class_1097.method_5712("ImageReceiver.addImageRequest() must be called in the main thread");
            this.field_3174.add(var1);
        }

        // $FF: renamed from: c (com.google.android.gms.common.images.a) void
        public void method_3637(class_550 var1) {
            class_1097.method_5712("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.field_3174.remove(var1);
        }

        // $FF: renamed from: gJ () void
        public void method_3638() {
            Intent var1 = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            var1.putExtra("com.google.android.gms.extras.uri", this.mUri);
            var1.putExtra("com.google.android.gms.extras.resultReceiver", this);
            var1.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(var1);
        }

        public void onReceiveResult(int var1, Bundle var2) {
            ParcelFileDescriptor var3 = (ParcelFileDescriptor)var2.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager.this.field_2101.execute(ImageManager.this.new class_1272(this.mUri, var3));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri var1, Drawable var2, boolean var3);
    }

    private static final class class_1270 {
        // $FF: renamed from: a (android.app.ActivityManager) int
        static int method_5781(ActivityManager var0) {
            return var0.getLargeMemoryClass();
        }
    }

    private static final class class_1271 extends ja<class_550.class_1812, Bitmap> {
        public class_1271(Context var1) {
            super(method_2225(var1));
        }

        // $FF: renamed from: I (android.content.Context) int
        private static int method_2225(Context var0) {
            ActivityManager var1 = (ActivityManager)var0.getSystemService("activity");
            boolean var2;
            if((1048576 & var0.getApplicationInfo().flags) != 0) {
                var2 = true;
            } else {
                var2 = false;
            }

            int var3;
            if(var2 && class_854.method_4493()) {
                var3 = var1.getLargeMemoryClass();
            } else {
                var3 = var1.getMemoryClass();
            }

            return (int)(0.33F * (float)(var3 * 1048576));
        }

        // $FF: renamed from: a (com.google.android.gms.common.images.a$a, android.graphics.Bitmap) int
        protected int method_2226(class_550.class_1812 var1, Bitmap var2) {
            return var2.getHeight() * var2.getRowBytes();
        }

        // $FF: renamed from: a (boolean, com.google.android.gms.common.images.a$a, android.graphics.Bitmap, android.graphics.Bitmap) void
        protected void method_2227(boolean var1, class_550.class_1812 var2, Bitmap var3, Bitmap var4) {
            super.entryRemoved(var1, var2, var3, var4);
        }

        // $FF: synthetic method
        protected void entryRemoved(boolean var1, Object var2, Object var3, Object var4) {
            this.method_2227(var1, (class_550.class_1812)var2, (Bitmap)var3, (Bitmap)var4);
        }

        // $FF: synthetic method
        protected int sizeOf(Object var1, Object var2) {
            return this.method_2226((class_550.class_1812)var1, (Bitmap)var2);
        }
    }

    private final class class_1272 implements Runnable {
        // $FF: renamed from: KE android.os.ParcelFileDescriptor
        private final ParcelFileDescriptor field_5157;
        private final Uri mUri;

        public class_1272(Uri var2, ParcelFileDescriptor var3) {
            this.mUri = var2;
            this.field_5157 = var3;
        }

        public void run() {
            class_1097.method_5713("LoadBitmapFromDiskRunnable can\'t be executed in the main thread");
            ParcelFileDescriptor var1 = this.field_5157;
            Bitmap var2 = null;
            boolean var3 = false;
            if(var1 != null) {
                label23: {
                    Bitmap var12;
                    try {
                        var12 = BitmapFactory.decodeFileDescriptor(this.field_5157.getFileDescriptor());
                    } catch (OutOfMemoryError var15) {
                        Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, var15);
                        var3 = true;
                        var2 = null;
                        break label23;
                    }

                    var2 = var12;
                }

                try {
                    this.field_5157.close();
                } catch (IOException var14) {
                    Log.e("ImageManager", "closed failed", var14);
                }
            }

            CountDownLatch var4 = new CountDownLatch(1);
            ImageManager.this.mHandler.post(ImageManager.this.new class_1275(this.mUri, var2, var3, var4));

            try {
                var4.await();
            } catch (InterruptedException var13) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    private final class class_1273 implements Runnable {
        // $FF: renamed from: KF com.google.android.gms.common.images.a
        private final class_550 field_5155;

        public class_1273(class_550 var2) {
            this.field_5155 = var2;
        }

        public void run() {
            // $FF: Couldn't be decompiled
        }
    }

    private static final class class_1274 implements ComponentCallbacks2 {
        // $FF: renamed from: Kx com.google.android.gms.common.images.ImageManager$b
        private final ImageManager.class_1271 field_5160;

        public class_1274(ImageManager.class_1271 var1) {
            this.field_5160 = var1;
        }

        public void onConfigurationChanged(Configuration var1) {
        }

        public void onLowMemory() {
            this.field_5160.evictAll();
        }

        public void onTrimMemory(int var1) {
            if(var1 >= 60) {
                this.field_5160.evictAll();
            } else if(var1 >= 20) {
                this.field_5160.trimToSize(this.field_5160.size() / 2);
                return;
            }

        }
    }

    private final class class_1275 implements Runnable {
        // $FF: renamed from: KG boolean
        private boolean field_5162;
        private final Bitmap mBitmap;
        private final Uri mUri;
        // $FF: renamed from: mg java.util.concurrent.CountDownLatch
        private final CountDownLatch field_5163;

        public class_1275(Uri var2, Bitmap var3, boolean var4, CountDownLatch var5) {
            this.mUri = var2;
            this.mBitmap = var3;
            this.field_5162 = var4;
            this.field_5163 = var5;
        }

        // $FF: renamed from: a (com.google.android.gms.common.images.ImageManager$ImageReceiver, boolean) void
        private void method_5791(ImageManager.ImageReceiver var1, boolean var2) {
            ArrayList var3 = var1.field_3174;
            int var4 = var3.size();

            for(int var5 = 0; var5 < var4; ++var5) {
                class_550 var6 = (class_550)var3.get(var5);
                if(var2) {
                    var6.method_3380(ImageManager.this.mContext, this.mBitmap, false);
                } else {
                    ImageManager.this.field_2100.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    var6.method_3382(ImageManager.this.mContext, ImageManager.this.field_2103, false);
                }

                if(!(var6 instanceof class_550.class_1814)) {
                    ImageManager.this.field_2104.remove(var6);
                }
            }

        }

        public void run() {
            // $FF: Couldn't be decompiled
        }
    }
}
