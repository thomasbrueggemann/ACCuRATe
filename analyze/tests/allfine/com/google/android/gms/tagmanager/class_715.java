package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.Container;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;
import com.google.android.gms.tagmanager.class_612;

// $FF: renamed from: com.google.android.gms.tagmanager.n
class class_715 implements ContainerHolder {
    // $FF: renamed from: CM com.google.android.gms.common.api.Status
    private Status field_3461;
    // $FF: renamed from: IH android.os.Looper
    private final Looper field_3462;
    // $FF: renamed from: NU boolean
    private boolean field_3463;
    private Container aok;
    private Container aol;
    private class_715.class_1203 aom;
    private class_715.class_1204 aon;
    private TagManager aoo;

    public class_715(Status var1) {
        this.field_3461 = var1;
        this.field_3462 = null;
    }

    public class_715(TagManager var1, Looper var2, Container var3, class_715.class_1204 var4) {
        this.aoo = var1;
        if(var2 == null) {
            var2 = Looper.getMainLooper();
        }

        this.field_3462 = var2;
        this.aok = var3;
        this.aon = var4;
        this.field_3461 = Status.field_4739;
        var1.method_3830(this);
    }

    // $FF: renamed from: nV () void
    private void method_3912() {
        if(this.aom != null) {
            this.aom.method_2497(this.aol.method_5968());
        }

    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.Container) void
    public void method_3913(Container param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: cp (java.lang.String) void
    public void method_3914(String param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: cr (java.lang.String) void
    void method_3915(String var1) {
        if(this.field_3463) {
            class_612.method_3456("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.aon.method_135(var1);
        }
    }

    public Container getContainer() {
        Container var1 = null;
        synchronized(this) {}

        try {
            if(this.field_3463) {
                class_612.method_3456("ContainerHolder is released.");
            } else {
                if(this.aol != null) {
                    this.aok = this.aol;
                    this.aol = null;
                }

                var1 = this.aok;
            }
        } finally {
            ;
        }

        return var1;
    }

    String getContainerId() {
        if(this.field_3463) {
            class_612.method_3456("getContainerId called on a released ContainerHolder.");
            return "";
        } else {
            return this.aok.getContainerId();
        }
    }

    public Status getStatus() {
        return this.field_3461;
    }

    // $FF: renamed from: nU () java.lang.String
    String method_3916() {
        if(this.field_3463) {
            class_612.method_3456("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
            return "";
        } else {
            return this.aon.method_136();
        }
    }

    public void refresh() {
        synchronized(this) {}

        try {
            if(this.field_3463) {
                class_612.method_3456("Refreshing a released ContainerHolder.");
            } else {
                this.aon.method_137();
            }
        } finally {
            ;
        }

    }

    public void release() {
        synchronized(this) {}

        try {
            if(this.field_3463) {
                class_612.method_3456("Releasing a released ContainerHolder.");
            } else {
                this.field_3463 = true;
                this.aoo.method_3831(this);
                this.aok.release();
                this.aok = null;
                this.aol = null;
                this.aon = null;
                this.aom = null;
            }
        } finally {
            ;
        }

    }

    public void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener param1) {
        // $FF: Couldn't be decompiled
    }

    public interface class_1204 {
        // $FF: renamed from: cr (java.lang.String) void
        void method_135(String var1);

        // $FF: renamed from: nU () java.lang.String
        String method_136();

        // $FF: renamed from: nW () void
        void method_137();
    }

    private class class_1203 extends Handler {
        private final ContainerHolder.ContainerAvailableListener aop;

        public class_1203(ContainerHolder.ContainerAvailableListener var2, Looper var3) {
            super(var3);
            this.aop = var2;
        }

        // $FF: renamed from: cs (java.lang.String) void
        public void method_2497(String var1) {
            this.sendMessage(this.obtainMessage(1, var1));
        }

        // $FF: renamed from: ct (java.lang.String) void
        protected void method_2498(String var1) {
            this.aop.onContainerAvailable(class_715.this, var1);
        }

        public void handleMessage(Message var1) {
            switch(var1.what) {
                case 1:
                    this.method_2498((String)var1.obj);
                    return;
                default:
                    class_612.method_3456("Don\'t know how to handle this message.");
            }
        }
    }
}
