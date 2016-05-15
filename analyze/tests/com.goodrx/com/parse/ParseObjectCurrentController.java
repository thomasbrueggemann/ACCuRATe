package com.parse;

import bolts.Task;
import com.parse.ParseObject;

interface ParseObjectCurrentController<T extends ParseObject> {
   void clearFromDisk();

   void clearFromMemory();

   Task<Boolean> existsAsync();

   Task<T> getAsync();

   boolean isCurrent(T var1);

   Task<Void> setAsync(T var1);
}
