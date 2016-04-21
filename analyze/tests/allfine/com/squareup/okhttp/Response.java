package com.squareup.okhttp;

import com.squareup.okhttp.Failure;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.RawHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;

final class Response {
    private final Response.Body body;
    private final int code;
    private final RawHeaders headers;
    private final Response redirectedBy;
    private final Request request;

    private Response(Response.Builder var1) {
        this.request = var1.request;
        this.code = var1.code;
        this.headers = new RawHeaders(var1.headers);
        this.body = var1.body;
        this.redirectedBy = var1.redirectedBy;
    }

    // $FF: synthetic method
    Response(Response.Builder var1, Object var2) {
        this(var1);
    }

    public Response.Body body() {
        return this.body;
    }

    public int code() {
        return this.code;
    }

    public String header(String var1) {
        return this.header(var1, (String)null);
    }

    public String header(String var1, String var2) {
        String var3 = this.headers.get(var1);
        return var3 != null?var3:var2;
    }

    public int headerCount() {
        return this.headers.length();
    }

    public String headerName(int var1) {
        return this.headers.getFieldName(var1);
    }

    public Set<String> headerNames() {
        return this.headers.names();
    }

    public String headerValue(int var1) {
        return this.headers.getValue(var1);
    }

    public List<String> headers(String var1) {
        return this.headers.values(var1);
    }

    RawHeaders rawHeaders() {
        return new RawHeaders(this.headers);
    }

    public Response redirectedBy() {
        return this.redirectedBy;
    }

    public Request request() {
        return this.request;
    }

    public abstract static class Body {
        private Reader reader;

        private Charset charset() {
            MediaType var1 = this.contentType();
            return var1 != null?var1.charset(Util.UTF_8):Util.UTF_8;
        }

        public abstract InputStream byteStream() throws IOException;

        public final byte[] bytes() throws IOException {
            long var1 = this.contentLength();
            if(var1 > 2147483647L) {
                throw new IOException("Cannot buffer entire body for content length: " + var1);
            } else {
                byte[] var5;
                if(var1 != -1L) {
                    var5 = new byte[(int)var1];
                    InputStream var6 = this.byteStream();
                    Util.readFully(var6, var5);
                    if(var6.read() != -1) {
                        throw new IOException("Content-Length and stream length disagree");
                    }
                } else {
                    ByteArrayOutputStream var3 = new ByteArrayOutputStream();
                    Util.copy(this.byteStream(), var3);
                    var5 = var3.toByteArray();
                }

                return var5;
            }
        }

        public final Reader charStream() throws IOException {
            if(this.reader == null) {
                this.reader = new InputStreamReader(this.byteStream(), this.charset());
            }

            return this.reader;
        }

        public abstract long contentLength();

        public abstract MediaType contentType();

        public abstract boolean ready() throws IOException;

        public final String string() throws IOException {
            return new String(this.bytes(), this.charset().name());
        }
    }

    public static class Builder {
        private Response.Body body;
        private final int code;
        private RawHeaders headers = new RawHeaders();
        private Response redirectedBy;
        private final Request request;

        public Builder(Request var1, int var2) {
            if(var1 == null) {
                throw new IllegalArgumentException("request == null");
            } else if(var2 <= 0) {
                throw new IllegalArgumentException("code <= 0");
            } else {
                this.request = var1;
                this.code = var2;
            }
        }

        public Response.Builder addHeader(String var1, String var2) {
            this.headers.add(var1, var2);
            return this;
        }

        public Response.Builder body(Response.Body var1) {
            this.body = var1;
            return this;
        }

        public Response build() {
            if(this.request == null) {
                throw new IllegalStateException("Response has no request.");
            } else if(this.code == -1) {
                throw new IllegalStateException("Response has no code.");
            } else {
                return new Response(this);
            }
        }

        public Response.Builder header(String var1, String var2) {
            this.headers.set(var1, var2);
            return this;
        }

        Response.Builder rawHeaders(RawHeaders var1) {
            this.headers = new RawHeaders(var1);
            return this;
        }

        public Response.Builder redirectedBy(Response var1) {
            this.redirectedBy = var1;
            return this;
        }
    }

    public interface Receiver {
        void onFailure(Failure var1);

        boolean onResponse(Response var1) throws IOException;
    }
}
