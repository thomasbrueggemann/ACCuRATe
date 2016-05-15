package com.newrelic.com.google.gson;

import com.newrelic.com.google.gson.JsonDeserializationContext;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public interface JsonDeserializer<T> {
   T deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException;
}
