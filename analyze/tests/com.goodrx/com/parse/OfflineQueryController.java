package com.parse;

import bolts.Task;
import com.parse.AbstractQueryController;
import com.parse.OfflineStore;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryController;
import com.parse.ParseUser;
import java.util.List;

class OfflineQueryController extends AbstractQueryController {
   private final ParseQueryController networkController;
   private final OfflineStore offlineStore;

   public OfflineQueryController(OfflineStore var1, ParseQueryController var2) {
      this.offlineStore = var1;
      this.networkController = var2;
   }

   public <T extends ParseObject> Task<Integer> countAsync(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3) {
      return var1.isFromLocalDatastore()?this.offlineStore.countFromPinAsync(var1.pinName(), var1, var2):this.networkController.countAsync(var1, var2, var3);
   }

   public <T extends ParseObject> Task<List<T>> findAsync(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3) {
      return var1.isFromLocalDatastore()?this.offlineStore.findFromPinAsync(var1.pinName(), var1, var2):this.networkController.findAsync(var1, var2, var3);
   }
}
