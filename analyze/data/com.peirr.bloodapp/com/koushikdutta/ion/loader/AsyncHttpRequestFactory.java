package com.koushikdutta.ion.loader;

import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.libcore.RawHeaders;
import java.net.URI;

public interface AsyncHttpRequestFactory {
   AsyncHttpRequest createAsyncHttpRequest(URI var1, String var2, RawHeaders var3);
}
