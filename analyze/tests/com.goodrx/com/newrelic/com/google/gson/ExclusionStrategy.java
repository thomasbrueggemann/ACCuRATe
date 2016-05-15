package com.newrelic.com.google.gson;

import com.newrelic.com.google.gson.FieldAttributes;

public interface ExclusionStrategy {
   boolean shouldSkipClass(Class<?> var1);

   boolean shouldSkipField(FieldAttributes var1);
}
