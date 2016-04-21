package crittercism.android;

import java.lang.reflect.Constructor;

// $FF: renamed from: crittercism.android.l
public final class class_692 {
    // $FF: renamed from: a (java.lang.String, java.lang.String[]) java.lang.reflect.Constructor
    public static Constructor method_3812(String var0, String[] var1) {
        Constructor[] var2 = Class.forName(var0).getDeclaredConstructors();

        for(int var3 = 0; var3 < var2.length; ++var3) {
            Class[] var4 = var2[var3].getParameterTypes();
            boolean var6;
            if(var4.length != var1.length) {
                var6 = false;
            } else {
                int var5 = 0;

                while(true) {
                    if(var5 >= var4.length) {
                        var6 = true;
                        break;
                    }

                    if(!var4[var5].getName().equals(var1[var5])) {
                        var6 = false;
                        break;
                    }

                    ++var5;
                }
            }

            if(var6) {
                return var2[var3];
            }
        }

        return null;
    }
}
