package crittercism.android;

import crittercism.android.class_103;
import crittercism.android.class_774;
import crittercism.android.class_777;
import crittercism.android.class_784;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

// $FF: renamed from: crittercism.android.ap
public final class class_779 extends class_774 {
    // $FF: renamed from: d int
    private int field_3659 = -1;

    public class_779(class_103 var1) {
        super(var1);
    }

    // $FF: renamed from: a (org.apache.http.util.CharArrayBuffer) boolean
    public final boolean method_4063(CharArrayBuffer var1) {
        ParserCursor var2 = new ParserCursor(0, var1.length());

        try {
            StatusLine var4 = BasicLineParser.DEFAULT.parseStatusLine(var1, var2);
            this.field_3659 = var4.getStatusCode();
            super.field_3652.method_403(var4.getStatusCode());
            return true;
        } catch (ParseException var5) {
            return false;
        }
    }

    // $FF: renamed from: b () crittercism.android.af
    public final class_774 method_4065() {
        return new class_784(this, this.field_3659);
    }

    // $FF: renamed from: c () crittercism.android.af
    public final class_774 method_4067() {
        return class_777.field_3658;
    }

    // $FF: renamed from: d () int
    protected final int method_4068() {
        return 20;
    }

    // $FF: renamed from: e () int
    protected final int method_4069() {
        return 64;
    }
}
