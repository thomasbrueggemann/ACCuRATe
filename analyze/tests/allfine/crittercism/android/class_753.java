package crittercism.android;

import crittercism.android.class_764;
import java.net.MalformedURLException;
import java.net.URL;

// $FF: renamed from: crittercism.android.db
public final class class_753 {
    // $FF: renamed from: a java.lang.String
    private String field_3572;
    // $FF: renamed from: b java.lang.String
    private String field_3573;

    public class_753(String var1, String var2) {
        var1.endsWith("/");
        var2.startsWith("/");
        this.field_3572 = var1;
        this.field_3573 = var2;
    }

    // $FF: renamed from: a () java.net.URL
    public final URL method_3999() {
        try {
            URL var1 = new URL(this.field_3572 + this.field_3573);
            return var1;
        } catch (MalformedURLException var3) {
            (new StringBuilder("Invalid url: ")).append(this.field_3572).append(this.field_3573);
            class_764.method_4020();
            return null;
        }
    }
}
