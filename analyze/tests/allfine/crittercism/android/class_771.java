package crittercism.android;

import crittercism.android.class_661;
import crittercism.android.class_662;
import crittercism.android.class_746;
import crittercism.android.class_770;
import java.net.SocketImpl;
import java.net.SocketImplFactory;

// $FF: renamed from: crittercism.android.ad
public final class class_771 implements SocketImplFactory {
    // $FF: renamed from: a java.lang.Class
    private Class field_3639;
    // $FF: renamed from: b java.net.SocketImplFactory
    private SocketImplFactory field_3640;
    // $FF: renamed from: c crittercism.android.e
    private class_661 field_3641;
    // $FF: renamed from: d crittercism.android.d
    private class_662 field_3642;

    public class_771(Class var1, class_661 var2, class_662 var3) {
        this.field_3641 = var2;
        this.field_3642 = var3;
        this.field_3639 = var1;
        Class var4 = this.field_3639;
        if(var4 == null) {
            throw new class_746("Class was null");
        } else {
            try {
                var4.newInstance();
            } catch (Throwable var6) {
                throw new class_746("Unable to create new instance", var6);
            }
        }
    }

    public class_771(SocketImplFactory var1, class_661 var2, class_662 var3) {
        this.field_3641 = var2;
        this.field_3642 = var3;
        this.field_3640 = var1;
        SocketImplFactory var4 = this.field_3640;
        if(var4 == null) {
            throw new class_746("Factory was null");
        } else {
            try {
                if(var4.createSocketImpl() == null) {
                    throw new class_746("Factory does not work");
                }
            } catch (Throwable var6) {
                throw new class_746("Factory does not work", var6);
            }
        }
    }

    public final SocketImpl createSocketImpl() {
        SocketImpl var3;
        if(this.field_3640 != null) {
            var3 = this.field_3640.createSocketImpl();
        } else {
            Class var10000 = this.field_3639;

            SocketImpl var5;
            try {
                var5 = (SocketImpl)this.field_3639.newInstance();
            } catch (IllegalAccessException var6) {
                var6.printStackTrace();
                var3 = null;
                return (SocketImpl)(var3 != null?new class_770(this.field_3641, this.field_3642, var3):var3);
            } catch (InstantiationException var7) {
                var7.printStackTrace();
                var3 = null;
                return (SocketImpl)(var3 != null?new class_770(this.field_3641, this.field_3642, var3):var3);
            }

            var3 = var5;
        }

        return (SocketImpl)(var3 != null?new class_770(this.field_3641, this.field_3642, var3):var3);
    }
}
