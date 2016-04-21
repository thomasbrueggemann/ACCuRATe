package crittercism.android;

import java.util.List;
import java.util.Map;

// $FF: renamed from: crittercism.android.n
public abstract class class_682 {
    // $FF: renamed from: a java.util.Map
    Map field_3331;

    public class_682(Map var1) {
        this.field_3331 = var1;
    }

    // $FF: renamed from: c (java.lang.String) java.lang.String
    private String method_3781(String var1) {
        List var2 = (List)this.field_3331.get(var1);
        return var2 != null?(String)var2.get(-1 + var2.size()):null;
    }

    // $FF: renamed from: a (java.lang.String) long
    public final long method_3782(String var1) {
        long var2 = Long.MAX_VALUE;
        String var4 = this.method_3781(var1);
        if(var4 != null) {
            long var6;
            try {
                var6 = Long.parseLong(var4);
            } catch (NumberFormatException var8) {
                return var2;
            }

            var2 = var6;
        }

        return var2;
    }

    // $FF: renamed from: b (java.lang.String) int
    public final int method_3783(String var1) {
        int var2 = -1;
        String var3 = this.method_3781(var1);
        if(var3 != null) {
            int var5;
            try {
                var5 = Integer.parseInt(var3);
            } catch (NumberFormatException var6) {
                return var2;
            }

            var2 = var5;
        }

        return var2;
    }

    public final String toString() {
        return this.field_3331.toString();
    }
}
