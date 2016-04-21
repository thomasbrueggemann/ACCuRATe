package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.OkResponseCache;
import com.squareup.okhttp.ResponseSource;
import java.io.IOException;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public final class OkResponseCacheAdapter implements OkResponseCache {
    private final ResponseCache responseCache;

    public OkResponseCacheAdapter(ResponseCache var1) {
        this.responseCache = var1;
    }

    public CacheResponse get(URI var1, String var2, Map<String, List<String>> var3) throws IOException {
        return this.responseCache.get(var1, var2, var3);
    }

    public void maybeRemove(String var1, URI var2) throws IOException {
    }

    public CacheRequest put(URI var1, URLConnection var2) throws IOException {
        return this.responseCache.put(var1, var2);
    }

    public void trackConditionalCacheHit() {
    }

    public void trackResponse(ResponseSource var1) {
    }

    public void update(CacheResponse var1, HttpURLConnection var2) throws IOException {
    }
}
