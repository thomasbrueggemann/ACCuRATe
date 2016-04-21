package crittercism.android;

import crittercism.android.class_746;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

// $FF: renamed from: crittercism.android.j
public final class class_689 {
    // $FF: renamed from: a (java.lang.reflect.Field, java.lang.Object) java.lang.Object
    public static Object method_3796(Field var0, Object var1) {
        if(var0 != null && var0 != null) {
            var0.setAccessible(true);

            try {
                Object var4 = var0.get(var1);
                return var4;
            } catch (ThreadDeath var5) {
                throw var5;
            } catch (Throwable var6) {
                throw new class_746("Unable to get value of field", var6);
            }
        } else {
            return null;
        }
    }

    // $FF: renamed from: a (java.lang.Class, java.lang.Class) java.lang.reflect.Field
    public static Field method_3797(Class var0, Class var1) {
        Field[] var2 = var0.getDeclaredFields();
        Field var3 = null;

        for(int var4 = 0; var4 < var2.length; ++var4) {
            if(var1.isAssignableFrom(var2[var4].getType())) {
                if(var3 != null) {
                    throw new class_746("Field is ambiguous: " + var3.getName() + ", " + var2[var4].getName());
                }

                var3 = var2[var4];
            }
        }

        if(var3 == null) {
            throw new class_746("Could not find field matching type: " + var1.getName());
        } else {
            var3.setAccessible(true);
            return var3;
        }
    }

    // $FF: renamed from: a (java.lang.reflect.AccessibleObject[]) void
    public static void method_3798(AccessibleObject[] var0) {
        for(int var1 = 0; var1 < var0.length; ++var1) {
            AccessibleObject var2 = var0[var1];
            if(var2 != null) {
                var2.setAccessible(true);
            }
        }

    }
}
