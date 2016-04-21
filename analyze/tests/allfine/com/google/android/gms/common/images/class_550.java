package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1097;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.class_323;
import com.google.android.gms.internal.class_326;
import com.google.android.gms.internal.class_327;
import java.lang.ref.WeakReference;

// $FF: renamed from: com.google.android.gms.common.images.a
public abstract class class_550 {
    // $FF: renamed from: KH com.google.android.gms.common.images.a$a
    final class_550.class_1812 field_2965;
    // $FF: renamed from: KI int
    protected int field_2966 = 0;
    // $FF: renamed from: KJ int
    protected int field_2967 = 0;
    // $FF: renamed from: KK com.google.android.gms.common.images.ImageManager$OnImageLoadedListener
    protected ImageManager.OnImageLoadedListener field_2968;
    // $FF: renamed from: KL boolean
    private boolean field_2969 = true;
    // $FF: renamed from: KM boolean
    private boolean field_2970 = false;
    // $FF: renamed from: KN int
    protected int field_2971;

    public class_550(Uri var1, int var2) {
        this.field_2965 = new class_550.class_1812(var1);
        this.field_2967 = var2;
    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.iz, int) android.graphics.drawable.Drawable
    private Drawable method_3377(Context var1, class_322 var2, int var3) {
        Resources var4 = var1.getResources();
        if(this.field_2971 > 0) {
            class_322.class_1696 var5 = new class_322.class_1696(var3, this.field_2971);
            Drawable var6 = (Drawable)var2.get(var5);
            if(var6 == null) {
                var6 = var4.getDrawable(var3);
                if((1 & this.field_2971) != 0) {
                    var6 = this.method_3378(var4, var6);
                }

                var2.put(var5, var6);
            }

            return var6;
        } else {
            return var4.getDrawable(var3);
        }
    }

    // $FF: renamed from: a (android.content.res.Resources, android.graphics.drawable.Drawable) android.graphics.drawable.Drawable
    protected Drawable method_3378(Resources var1, Drawable var2) {
        return class_327.method_2245(var1, var2);
    }

    // $FF: renamed from: a (android.graphics.drawable.Drawable, android.graphics.drawable.Drawable) com.google.android.gms.internal.iw
    protected class_326 method_3379(Drawable var1, Drawable var2) {
        if(var1 != null) {
            if(var1 instanceof class_326) {
                var1 = ((class_326)var1).method_2242();
            }
        } else {
            var1 = null;
        }

        return new class_326(var1, var2);
    }

    // $FF: renamed from: a (android.content.Context, android.graphics.Bitmap, boolean) void
    void method_3380(Context var1, Bitmap var2, boolean var3) {
        class_1097.method_5714(var2);
        if((1 & this.field_2971) != 0) {
            var2 = class_327.method_2243(var2);
        }

        BitmapDrawable var4 = new BitmapDrawable(var1.getResources(), var2);
        if(this.field_2968 != null) {
            this.field_2968.onImageLoaded(this.field_2965.uri, var4, true);
        }

        this.method_3383(var4, var3, false, true);
    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.iz) void
    void method_3381(Context var1, class_322 var2) {
        int var3 = this.field_2966;
        Drawable var4 = null;
        if(var3 != 0) {
            var4 = this.method_3377(var1, var2, this.field_2966);
        }

        this.method_3383(var4, false, true, false);
    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.iz, boolean) void
    void method_3382(Context var1, class_322 var2, boolean var3) {
        int var4 = this.field_2967;
        Drawable var5 = null;
        if(var4 != 0) {
            var5 = this.method_3377(var1, var2, this.field_2967);
        }

        if(this.field_2968 != null) {
            this.field_2968.onImageLoaded(this.field_2965.uri, var5, false);
        }

        this.method_3383(var5, var3, false, false);
    }

    // $FF: renamed from: a (android.graphics.drawable.Drawable, boolean, boolean, boolean) void
    protected abstract void method_3383(Drawable var1, boolean var2, boolean var3, boolean var4);

    // $FF: renamed from: aw (int) void
    public void method_3384(int var1) {
        this.field_2967 = var1;
    }

    // $FF: renamed from: b (boolean, boolean) boolean
    protected boolean method_3385(boolean var1, boolean var2) {
        return this.field_2969 && !var2 && (!var1 || this.field_2970);
    }

    static final class class_1812 {
        public final Uri uri;

        public class_1812(Uri var1) {
            this.uri = var1;
        }

        public boolean equals(Object var1) {
            return !(var1 instanceof class_550.class_1812)?false:(this == var1?true:class_1089.equal(((class_550.class_1812)var1).uri, this.uri));
        }

        public int hashCode() {
            Object[] var1 = new Object[] {this.uri};
            return class_1089.hashCode(var1);
        }
    }

    public static final class class_1813 extends class_550 {
        // $FF: renamed from: KO java.lang.ref.WeakReference
        private WeakReference<ImageView> field_2973;

        public class_1813(ImageView var1, int var2) {
            super((Uri)null, var2);
            class_1097.method_5714(var1);
            this.field_2973 = new WeakReference(var1);
        }

        public class_1813(ImageView var1, Uri var2) {
            super(var2, 0);
            class_1097.method_5714(var1);
            this.field_2973 = new WeakReference(var1);
        }

        // $FF: renamed from: a (android.widget.ImageView, android.graphics.drawable.Drawable, boolean, boolean, boolean) void
        private void method_3386(ImageView var1, Drawable var2, boolean var3, boolean var4, boolean var5) {
            boolean var6;
            if(!var4 && !var5) {
                var6 = true;
            } else {
                var6 = false;
            }

            if(var6 && var1 instanceof class_323) {
                int var12 = ((class_323)var1).method_2230();
                if(this.KJ != 0 && var12 == this.KJ) {
                    return;
                }
            }

            boolean var7 = this.b(var3, var4);
            Object var8;
            if(var7) {
                var8 = this.a(var1.getDrawable(), var2);
            } else {
                var8 = var2;
            }

            var1.setImageDrawable((Drawable)var8);
            if(var1 instanceof class_323) {
                class_323 var9 = (class_323)var1;
                Uri var10;
                if(var5) {
                    var10 = this.KH.uri;
                } else {
                    var10 = null;
                }

                var9.method_2229(var10);
                int var11;
                if(var6) {
                    var11 = this.KJ;
                } else {
                    var11 = 0;
                }

                var9.method_2228(var11);
            }

            if(var7) {
                ((class_326)var8).startTransition(250);
            }
        }

        // $FF: renamed from: a (android.graphics.drawable.Drawable, boolean, boolean, boolean) void
        protected void method_3383(Drawable var1, boolean var2, boolean var3, boolean var4) {
            ImageView var5 = (ImageView)this.field_2973.get();
            if(var5 != null) {
                this.method_3386(var5, var1, var2, var3, var4);
            }

        }

        public boolean equals(Object var1) {
            if(!(var1 instanceof class_550.class_1813)) {
                return false;
            } else if(this == var1) {
                return true;
            } else {
                class_550.class_1813 var2 = (class_550.class_1813)var1;
                ImageView var3 = (ImageView)this.field_2973.get();
                ImageView var4 = (ImageView)var2.field_2973.get();
                boolean var5;
                if(var4 != null && var3 != null && class_1089.equal(var4, var3)) {
                    var5 = true;
                } else {
                    var5 = false;
                }

                return var5;
            }
        }

        public int hashCode() {
            return 0;
        }
    }

    public static final class class_1814 extends class_550 {
        // $FF: renamed from: KP java.lang.ref.WeakReference
        private WeakReference<ImageManager.OnImageLoadedListener> field_2972;

        public class_1814(ImageManager.OnImageLoadedListener var1, Uri var2) {
            super(var2, 0);
            class_1097.method_5714(var1);
            this.field_2972 = new WeakReference(var1);
        }

        // $FF: renamed from: a (android.graphics.drawable.Drawable, boolean, boolean, boolean) void
        protected void method_3383(Drawable var1, boolean var2, boolean var3, boolean var4) {
            if(!var3) {
                ImageManager.OnImageLoadedListener var5 = (ImageManager.OnImageLoadedListener)this.field_2972.get();
                if(var5 != null) {
                    var5.onImageLoaded(this.KH.uri, var1, var4);
                }
            }

        }

        public boolean equals(Object var1) {
            if(!(var1 instanceof class_550.class_1814)) {
                return false;
            } else if(this == var1) {
                return true;
            } else {
                class_550.class_1814 var2 = (class_550.class_1814)var1;
                ImageManager.OnImageLoadedListener var3 = (ImageManager.OnImageLoadedListener)this.field_2972.get();
                ImageManager.OnImageLoadedListener var4 = (ImageManager.OnImageLoadedListener)var2.field_2972.get();
                boolean var5;
                if(var4 != null && var3 != null && class_1089.equal(var4, var3) && class_1089.equal(var2.KH, this.KH)) {
                    var5 = true;
                } else {
                    var5 = false;
                }

                return var5;
            }
        }

        public int hashCode() {
            Object[] var1 = new Object[] {this.KH};
            return class_1089.hashCode(var1);
        }
    }
}
