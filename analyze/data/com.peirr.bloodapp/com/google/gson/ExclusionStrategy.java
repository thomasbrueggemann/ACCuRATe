package com.google.gson;

import com.google.gson.FieldAttributes;

public interface ExclusionStrategy {
   boolean shouldSkipClass(Class<?> var1);

   boolean shouldSkipField(FieldAttributes var1);
}
