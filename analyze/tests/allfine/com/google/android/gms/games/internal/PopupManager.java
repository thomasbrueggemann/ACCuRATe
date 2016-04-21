package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.class_854;
import java.lang.ref.WeakReference;

public class PopupManager {
    // $FF: renamed from: XZ com.google.android.gms.games.internal.GamesClientImpl
    protected GamesClientImpl field_4244;
    // $FF: renamed from: Ya com.google.android.gms.games.internal.PopupManager$PopupLocationInfo
    protected PopupManager.PopupLocationInfo field_4245;

    private PopupManager(GamesClientImpl var1, int var2) {
        this.field_4244 = var1;
        this.method_4802(var2);
    }

    // $FF: synthetic method
    PopupManager(GamesClientImpl var1, int var2, Object var3) {
        this(var1, var2);
    }

    // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl, int) com.google.android.gms.games.internal.PopupManager
    public static PopupManager method_4801(GamesClientImpl var0, int var1) {
        return (PopupManager)(class_854.method_4494()?new PopupManager.PopupManagerHCMR1(var0, var1):new PopupManager(var0, var1));
    }

    // $FF: renamed from: dG (int) void
    protected void method_4802(int var1) {
        this.field_4245 = new PopupManager.PopupLocationInfo(var1, new Binder());
    }

    // $FF: renamed from: kM () void
    public void method_4803() {
        this.field_4244.method_1893(this.field_4245.field_3065, this.field_4245.method_3407());
    }

    // $FF: renamed from: kN () android.os.Bundle
    public Bundle method_4804() {
        return this.field_4245.method_3407();
    }

    // $FF: renamed from: kO () android.os.IBinder
    public IBinder method_4805() {
        return this.field_4245.field_3065;
    }

    // $FF: renamed from: l (android.view.View) void
    public void method_4806(View var1) {
    }

    public void setGravity(int var1) {
        this.field_4245.gravity = var1;
    }

    public static final class PopupLocationInfo {
        // $FF: renamed from: Yb android.os.IBinder
        public IBinder field_3065;
        // $FF: renamed from: Yc int
        public int field_3066;
        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;

        private PopupLocationInfo(int var1, IBinder var2) {
            this.field_3066 = -1;
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.gravity = var1;
            this.field_3065 = var2;
        }

        // $FF: synthetic method
        PopupLocationInfo(int var1, IBinder var2, Object var3) {
            this(var1, var2);
        }

        // $FF: renamed from: kP () android.os.Bundle
        public Bundle method_3407() {
            Bundle var1 = new Bundle();
            var1.putInt("popupLocationInfo.gravity", this.gravity);
            var1.putInt("popupLocationInfo.displayId", this.field_3066);
            var1.putInt("popupLocationInfo.left", this.left);
            var1.putInt("popupLocationInfo.top", this.top);
            var1.putInt("popupLocationInfo.right", this.right);
            var1.putInt("popupLocationInfo.bottom", this.bottom);
            return var1;
        }
    }

    private static final class PopupManagerHCMR1 extends PopupManager implements OnAttachStateChangeListener, OnGlobalLayoutListener {
        // $FF: renamed from: Wy boolean
        private boolean field_4246 = false;
        // $FF: renamed from: Yd java.lang.ref.WeakReference
        private WeakReference<View> field_4247;

        protected PopupManagerHCMR1(GamesClientImpl var1, int var2) {
            super(var1, var2, null);
        }

        // $FF: renamed from: m (android.view.View) void
        private void method_4807(View var1) {
            int var2 = -1;
            if(class_854.method_4498()) {
                Display var7 = var1.getDisplay();
                if(var7 != null) {
                    var2 = var7.getDisplayId();
                }
            }

            IBinder var3 = var1.getWindowToken();
            int[] var4 = new int[2];
            var1.getLocationInWindow(var4);
            int var5 = var1.getWidth();
            int var6 = var1.getHeight();
            this.Ya.field_3066 = var2;
            this.Ya.field_3065 = var3;
            this.Ya.left = var4[0];
            this.Ya.top = var4[1];
            this.Ya.right = var5 + var4[0];
            this.Ya.bottom = var6 + var4[1];
            if(this.field_4246) {
                this.method_4803();
                this.field_4246 = false;
            }

        }

        // $FF: renamed from: dG (int) void
        protected void method_4802(int var1) {
            this.Ya = new PopupManager.PopupLocationInfo(var1, (IBinder)null);
        }

        // $FF: renamed from: kM () void
        public void method_4803() {
            if(this.Ya.field_3065 != null) {
                super.method_4803();
            } else {
                boolean var1;
                if(this.field_4247 != null) {
                    var1 = true;
                } else {
                    var1 = false;
                }

                this.field_4246 = var1;
            }
        }

        // $FF: renamed from: l (android.view.View) void
        public void method_4806(View var1) {
            this.XZ.method_2021();
            if(this.field_4247 != null) {
                View var4 = (View)this.field_4247.get();
                Context var5 = this.XZ.getContext();
                if(var4 == null && var5 instanceof Activity) {
                    var4 = ((Activity)var5).getWindow().getDecorView();
                }

                if(var4 != null) {
                    var4.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver var6 = var4.getViewTreeObserver();
                    if(class_854.method_4497()) {
                        var6.removeOnGlobalLayoutListener(this);
                    } else {
                        var6.removeGlobalOnLayoutListener(this);
                    }
                }
            }

            this.field_4247 = null;
            Context var2 = this.XZ.getContext();
            if(var1 == null && var2 instanceof Activity) {
                View var3 = ((Activity)var2).findViewById(16908290);
                if(var3 == null) {
                    var3 = ((Activity)var2).getWindow().getDecorView();
                }

                GamesLog.method_6005("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
                var1 = var3;
            }

            if(var1 != null) {
                this.method_4807(var1);
                this.field_4247 = new WeakReference(var1);
                var1.addOnAttachStateChangeListener(this);
                var1.getViewTreeObserver().addOnGlobalLayoutListener(this);
            } else {
                GamesLog.method_6006("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client\'s calls. Use setViewForPopups() to set your content view.");
            }
        }

        public void onGlobalLayout() {
            if(this.field_4247 != null) {
                View var1 = (View)this.field_4247.get();
                if(var1 != null) {
                    this.method_4807(var1);
                    return;
                }
            }

        }

        public void onViewAttachedToWindow(View var1) {
            this.method_4807(var1);
        }

        public void onViewDetachedFromWindow(View var1) {
            this.XZ.method_2021();
            var1.removeOnAttachStateChangeListener(this);
        }
    }
}
