package crittercism.android;

import crittercism.android.class_103;
import crittercism.android.class_774;
import crittercism.android.class_777;
import crittercism.android.class_783;
import org.apache.http.ParseException;
import org.apache.http.RequestLine;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

// $FF: renamed from: crittercism.android.an
public final class class_778 extends class_774 {
    public class_778(class_103 var1) {
        super(var1);
    }

    // $FF: renamed from: a (org.apache.http.util.CharArrayBuffer) boolean
    public final boolean method_4063(CharArrayBuffer var1) {
        ParserCursor var2 = new ParserCursor(0, var1.length());

        try {
            RequestLine var4 = BasicLineParser.DEFAULT.parseRequestLine(var1, var2);
            super.field_3652.method_406(var4.getMethod(), var4.getUri());
            return true;
        } catch (ParseException var5) {
            return false;
        }
    }

    // $FF: renamed from: b () crittercism.android.af
    public final class_774 method_4065() {
        return new class_783(this);
    }

    // $FF: renamed from: c () crittercism.android.af
    public final class_774 method_4067() {
        return class_777.field_3658;
    }

    // $FF: renamed from: d () int
    protected final int method_4068() {
        return 64;
    }

    // $FF: renamed from: e () int
    protected final int method_4069() {
        return 2048;
    }
}
