package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.spdy.FrameReader;
import com.squareup.okhttp.internal.spdy.FrameWriter;
import com.squareup.okhttp.internal.spdy.Http20Draft06;
import com.squareup.okhttp.internal.spdy.Spdy3;
import java.io.InputStream;
import java.io.OutputStream;

interface Variant {
    Variant HTTP_20_DRAFT_06 = new Http20Draft06();
    Variant SPDY3 = new Spdy3();

    FrameReader newReader(InputStream var1, boolean var2);

    FrameWriter newWriter(OutputStream var1, boolean var2);
}
