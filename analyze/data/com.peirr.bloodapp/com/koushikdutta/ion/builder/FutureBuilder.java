package com.koushikdutta.ion.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.ion.builder.BitmapFutureBuilder;
import com.koushikdutta.ion.builder.Builders;
import com.koushikdutta.ion.builder.ImageViewFutureBuilder;
import com.koushikdutta.ion.future.ResponseFuture;
import java.io.File;
import java.io.OutputStream;

public interface FutureBuilder extends BitmapFutureBuilder, ImageViewFutureBuilder {
   // $FF: renamed from: as (com.google.gson.reflect.TypeToken) com.koushikdutta.ion.future.ResponseFuture
   <T> ResponseFuture<T> method_0(TypeToken<T> var1);

   // $FF: renamed from: as (java.lang.Class) com.koushikdutta.ion.future.ResponseFuture
   <T> ResponseFuture<T> method_1(Class<T> var1);

   ResponseFuture<JsonArray> asJsonArray();

   ResponseFuture<JsonObject> asJsonObject();

   ResponseFuture<String> asString();

   FutureBuilder group(Object var1);

   Builders.class_4<? extends Builders.class_4<?>> withBitmap();

   ResponseFuture<File> write(File var1);

   <T extends OutputStream> ResponseFuture<T> write(T var1);

   <T extends OutputStream> ResponseFuture<T> write(T var1, boolean var2);
}
