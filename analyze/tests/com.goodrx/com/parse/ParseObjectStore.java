package com.parse;

import bolts.Task;
import com.parse.ParseObject;

interface ParseObjectStore<T extends ParseObject> {
   Task<Void> deleteAsync();

   Task<Boolean> existsAsync();

   Task<T> getAsync();

   Task<Void> setAsync(T var1);
}
