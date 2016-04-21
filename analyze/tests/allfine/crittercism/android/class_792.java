package crittercism.android;

import com.crittercism.app.CrittercismConfig;
import crittercism.android.class_802;
import java.util.List;

// $FF: renamed from: crittercism.android.bb
public final class class_792 extends CrittercismConfig {
    // $FF: renamed from: b java.lang.String
    private String field_3736 = "https://api.crittercism.com";
    // $FF: renamed from: c java.lang.String
    private String field_3737 = "https://apm.crittercism.com";
    // $FF: renamed from: d java.lang.String
    private String field_3738 = "https://txn.ingest.crittercism.com/api/v1/transactions";
    // $FF: renamed from: e java.lang.String
    private String field_3739 = "https://appload.ingest.crittercism.com";
    // $FF: renamed from: f java.lang.String
    private String field_3740 = "524c99a04002057fcd000001";

    public class_792(String var1, CrittercismConfig var2) {
        super(var2);
        String var3 = class_802.class_1424.method_5480(var1).method_5481();
        this.field_3736 = "https://api." + var3;
        this.field_3737 = "https://apm." + var3;
        this.field_3739 = "https://appload.ingest." + var3;
        this.field_3738 = "https://txn.ingest." + var3 + "/api/v1/transactions";
    }

    // $FF: renamed from: a () java.util.List
    public final List method_4101() {
        List var1 = super.method_4101();
        var1.add(this.field_3737);
        return var1;
    }

    // $FF: renamed from: b () java.lang.String
    public final String method_4102() {
        return this.field_3736;
    }

    // $FF: renamed from: c () java.lang.String
    public final String method_4103() {
        return this.field_3737;
    }

    // $FF: renamed from: d () java.lang.String
    public final String method_4104() {
        return this.field_3738;
    }

    // $FF: renamed from: e () java.lang.String
    public final String method_4105() {
        return this.field_3739;
    }

    public final boolean equals(Object var1) {
        if(!(var1 instanceof class_792)) {
            return false;
        } else {
            class_792 var2 = (class_792)var1;
            return super.equals(var1) && a(this.field_3736, var2.field_3736) && a(this.field_3737, var2.field_3737) && a(this.field_3738, var2.field_3738) && a(this.field_3739, var2.field_3739) && a(this.field_3740, var2.field_3740);
        }
    }

    // $FF: renamed from: f () java.lang.String
    public final String method_4106() {
        return this.field_3740;
    }

    // $FF: renamed from: g () java.lang.String
    public final String method_4107() {
        return this.a;
    }

    public final int hashCode() {
        return 31 * (31 * (31 * (31 * (31 * super.hashCode() + this.field_3736.hashCode()) + this.field_3737.hashCode()) + this.field_3738.hashCode()) + this.field_3739.hashCode()) + this.field_3740.hashCode();
    }
}
