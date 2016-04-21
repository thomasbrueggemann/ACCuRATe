package crittercism.android;

import crittercism.android.class_661;
import crittercism.android.class_662;
import crittercism.android.class_680;
import crittercism.android.class_681;
import crittercism.android.class_764;
import crittercism.android.class_810;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.LinkedList;

// $FF: renamed from: crittercism.android.v
public final class class_685 implements URLStreamHandlerFactory {
    // $FF: renamed from: a java.lang.Object
    private static final Object field_3337 = new Object();
    // $FF: renamed from: b crittercism.android.v
    private static class_685 field_3338;
    // $FF: renamed from: c java.util.LinkedList
    private LinkedList field_3339 = new LinkedList();
    // $FF: renamed from: d boolean
    private boolean field_3340 = false;
    // $FF: renamed from: e boolean
    private boolean field_3341 = false;

    public class_685(class_685.class_1199 var1, class_661 var2, class_662 var3) {
        if(var1 == class_685.class_1199.field_4999 || var1 == class_685.class_1199.field_4997) {
            this.field_3339.add(new class_680(var2, var3));
        }

        if(var1 == class_685.class_1199.field_4999 || var1 == class_685.class_1199.field_4998) {
            this.field_3339.add(new class_681(var2, var3));
        }

    }

    // $FF: renamed from: a () crittercism.android.v
    public static class_685 method_3788() {
        return field_3338;
    }

    // $FF: renamed from: d () boolean
    private boolean method_3789() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: e () boolean
    private static boolean method_3790() {
        Field[] var0 = URL.class.getDeclaredFields();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            Field var3 = var0[var2];
            if(URLStreamHandlerFactory.class.isAssignableFrom(var3.getType())) {
                try {
                    class_810 var10000 = class_810.field_3876;
                    var3.setAccessible(true);
                    var3.set((Object)null, (Object)null);
                    var3.setAccessible(false);
                    URL.setURLStreamHandlerFactory((URLStreamHandlerFactory)null);
                    return true;
                } catch (IllegalAccessException var7) {
                    class_764.method_4023();
                } catch (SecurityException var8) {
                    class_764.method_4023();
                } catch (Throwable var9) {
                    class_764.method_4023();
                }
            }
        }

        return false;
    }

    // $FF: renamed from: f () boolean
    private static boolean method_3791() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b () boolean
    public final boolean method_3792() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: c () boolean
    public final boolean method_3793() {
        // $FF: Couldn't be decompiled
    }

    public final URLStreamHandler createURLStreamHandler(String param1) {
        // $FF: Couldn't be decompiled
    }

    public static enum class_1199 {
        // $FF: renamed from: a crittercism.android.v$a
        field_4997,
        // $FF: renamed from: b crittercism.android.v$a
        field_4998,
        // $FF: renamed from: c crittercism.android.v$a
        field_4999;

        static {
            class_685.class_1199[] var0 = new class_685.class_1199[]{field_4997, field_4998, field_4999};
        }
    }
}
