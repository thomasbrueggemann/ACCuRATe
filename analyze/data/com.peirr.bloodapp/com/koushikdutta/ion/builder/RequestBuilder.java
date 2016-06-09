package com.koushikdutta.ion.builder;

import android.app.ProgressDialog;
import android.os.Handler;
import android.widget.ProgressBar;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.ion.HeadersCallback;
import com.koushikdutta.ion.ProgressCallback;
import com.koushikdutta.ion.builder.MultipartBodyBuilder;
import com.koushikdutta.ion.builder.UrlEncodedBuilder;

public interface RequestBuilder<F, R extends RequestBuilder, M extends MultipartBodyBuilder, U extends UrlEncodedBuilder> extends MultipartBodyBuilder<M>, UrlEncodedBuilder<U> {
   R addHeader(String var1, String var2);

   R addQuery(String var1, String var2);

   R basicAuthentication(String var1, String var2);

   R followRedirect(boolean var1);

   R onHeaders(HeadersCallback var1);

   R progress(ProgressCallback var1);

   R progressBar(ProgressBar var1);

   R progressDialog(ProgressDialog var1);

   R progressHandler(ProgressCallback var1);

   R proxy(String var1, int var2);

   R setHandler(Handler var1);

   R setHeader(String var1, String var2);

   F setJsonArrayBody(JsonArray var1);

   F setJsonObjectBody(JsonObject var1);

   <T> F setJsonObjectBody(T var1);

   <T> F setJsonObjectBody(T var1, TypeToken<T> var2);

   R setLogging(String var1, int var2);

   F setStringBody(String var1);

   R setTimeout(int var1);

   R uploadProgress(ProgressCallback var1);

   R uploadProgressBar(ProgressBar var1);

   R uploadProgressDialog(ProgressDialog var1);

   R uploadProgressHandler(ProgressCallback var1);

   R userAgent(String var1);
}
