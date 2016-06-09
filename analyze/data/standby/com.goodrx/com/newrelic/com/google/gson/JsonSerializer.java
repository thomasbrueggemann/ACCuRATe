package com.newrelic.com.google.gson;

import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;

public interface JsonSerializer<T> {
   JsonElement serialize(T var1, Type var2, JsonSerializationContext var3);
}
