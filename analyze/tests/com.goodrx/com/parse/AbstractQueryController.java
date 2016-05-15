package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryController;
import com.parse.ParseUser;
import java.util.List;

abstract class AbstractQueryController implements ParseQueryController {
   public <T extends ParseObject> Task<T> getFirstAsync(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3) {
      return this.findAsync(var1, var2, var3).continueWith(new Continuation() {
         public T then(Task<List<T>> var1) throws Exception {
            if(var1.isFaulted()) {
               throw var1.getError();
            } else if(var1.getResult() != null && ((List)var1.getResult()).size() > 0) {
               return (ParseObject)((List)var1.getResult()).get(0);
            } else {
               throw new ParseException(101, "no results found for query");
            }
         }
      });
   }
}
