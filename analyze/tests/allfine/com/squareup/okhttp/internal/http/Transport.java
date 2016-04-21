package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.http.ResponseHeaders;
import com.squareup.okhttp.internal.http.RetryableOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;

interface Transport {
    OutputStream createRequestBody() throws IOException;

    void flushRequest() throws IOException;

    InputStream getTransferStream(CacheRequest var1) throws IOException;

    boolean makeReusable(boolean var1, OutputStream var2, InputStream var3);

    ResponseHeaders readResponseHeaders() throws IOException;

    void writeRequestBody(RetryableOutputStream var1) throws IOException;

    void writeRequestHeaders() throws IOException;
}
