package com.squareup.okhttp;

import com.squareup.okhttp.Job;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.http.ResponseHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class Dispatcher {
    private final Map<Object, List<Job>> enqueuedJobs;
    private final ThreadPoolExecutor executorService;

    Dispatcher() {
        this.executorService = new ThreadPoolExecutor(8, 8, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.enqueuedJobs = new LinkedHashMap();
    }

    public void cancel(Object param1) {
        // $FF: Couldn't be decompiled
    }

    public void enqueue(OkHttpClient param1, Request param2, Response.Receiver param3) {
        // $FF: Couldn't be decompiled
    }

    void finished(Job param1) {
        // $FF: Couldn't be decompiled
    }

    static class RealResponseBody extends Response.Body {
        // $FF: renamed from: in java.io.InputStream
        private final InputStream field_3050;
        private final ResponseHeaders responseHeaders;

        RealResponseBody(ResponseHeaders var1, InputStream var2) {
            this.responseHeaders = var1;
            this.field_3050 = var2;
        }

        public InputStream byteStream() throws IOException {
            return this.field_3050;
        }

        public long contentLength() {
            return this.responseHeaders.getContentLength();
        }

        public MediaType contentType() {
            String var1 = this.responseHeaders.getContentType();
            return var1 != null?MediaType.parse(var1):null;
        }

        public boolean ready() throws IOException {
            return true;
        }
    }
}
