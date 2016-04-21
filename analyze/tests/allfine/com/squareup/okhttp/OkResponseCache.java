package com.squareup.okhttp;

import com.squareup.okhttp.ResponseSource;
import java.io.IOException;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public interface OkResponseCache {
    CacheResponse get(URI var1, String var2, Map<String, List<String>> var3) throws IOException;

    void maybeRemove(String var1, URI var2) throws IOException;

    CacheRequest put(URI var1, URLConnection var2) throws IOException;

    void trackConditionalCacheHit();

    void trackResponse(ResponseSource var1);

    void update(CacheResponse var1, HttpURLConnection var2) throws IOException;
}
