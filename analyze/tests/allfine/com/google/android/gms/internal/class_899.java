package com.google.android.gms.internal;

import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.pm
public class class_899 extends IOException {
    public class_899(String var1) {
        super(var1);
    }

    // $FF: renamed from: qA () com.google.android.gms.internal.pm
    static class_899 method_4599() {
        return new class_899("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    // $FF: renamed from: qB () com.google.android.gms.internal.pm
    static class_899 method_4600() {
        return new class_899("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    // $FF: renamed from: qC () com.google.android.gms.internal.pm
    static class_899 method_4601() {
        return new class_899("CodedInputStream encountered a malformed varint.");
    }

    // $FF: renamed from: qD () com.google.android.gms.internal.pm
    static class_899 method_4602() {
        return new class_899("Protocol message contained an invalid tag (zero).");
    }

    // $FF: renamed from: qE () com.google.android.gms.internal.pm
    static class_899 method_4603() {
        return new class_899("Protocol message end-group tag did not match expected tag.");
    }

    // $FF: renamed from: qF () com.google.android.gms.internal.pm
    static class_899 method_4604() {
        return new class_899("Protocol message tag had invalid wire type.");
    }

    // $FF: renamed from: qG () com.google.android.gms.internal.pm
    static class_899 method_4605() {
        return new class_899("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
