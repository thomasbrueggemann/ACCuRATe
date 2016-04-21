package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.math.BigInteger;
import java.security.MessageDigest;

// $FF: renamed from: crittercism.android.dr
public final class class_760 {
    // $FF: renamed from: a android.content.SharedPreferences
    private SharedPreferences field_3593;
    // $FF: renamed from: b android.content.SharedPreferences
    private SharedPreferences field_3594;
    // $FF: renamed from: c android.content.Context
    private Context field_3595;

    public class_760(Context var1) {
        if(var1 == null) {
            throw new NullPointerException("context was null");
        } else {
            this.field_3595 = var1;
            this.field_3593 = var1.getSharedPreferences("com.crittercism.usersettings", 0);
            this.field_3594 = var1.getSharedPreferences("com.crittercism.prefs", 0);
            if(this.field_3593 == null) {
                throw new NullPointerException("prefs were null");
            } else if(this.field_3594 == null) {
                throw new NullPointerException("legacy prefs were null");
            }
        }
    }

    // $FF: renamed from: a (java.lang.String) java.lang.String
    private static String method_4010(String var0) {
        if(var0 != null && var0.length() > 0) {
            try {
                var0 = new String((new BigInteger(1, MessageDigest.getInstance("SHA-256").digest(var0.getBytes()))).toString(16));
            } catch (ThreadDeath var3) {
                throw var3;
            } catch (Throwable var4) {
                return null;
            }
        }

        return var0;
    }

    // $FF: renamed from: b () java.lang.String
    private String method_4011() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (java.lang.String) boolean
    private boolean method_4012(String var1) {
        Editor var2 = this.field_3593.edit();
        var2.putString("hashedDeviceID", var1);
        return var2.commit();
    }

    // $FF: renamed from: a () java.lang.String
    public final String method_4013() {
        String var1 = this.field_3593.getString("hashedDeviceID", (String)null);
        if(var1 == null) {
            var1 = this.field_3594.getString("com.crittercism.prefs.did", (String)null);
            if(var1 != null && this.method_4012(var1)) {
                Editor var3 = this.field_3594.edit();
                var3.remove("com.crittercism.prefs.did");
                var3.commit();
            }
        }

        if(var1 == null) {
            var1 = this.method_4011();
            this.method_4012(var1);
        }

        return var1;
    }
}
