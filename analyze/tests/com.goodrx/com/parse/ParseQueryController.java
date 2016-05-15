package com.parse;

import bolts.Task;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import java.util.List;

interface ParseQueryController {
   <T extends ParseObject> Task<Integer> countAsync(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3);

   <T extends ParseObject> Task<List<T>> findAsync(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3);

   <T extends ParseObject> Task<T> getFirstAsync(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3);
}
