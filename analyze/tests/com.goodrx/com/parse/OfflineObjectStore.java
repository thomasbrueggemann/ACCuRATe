package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseCorePlugins;
import com.parse.ParseObject;
import com.parse.ParseObjectStore;
import com.parse.ParseObjectSubclassingController;
import com.parse.ParseQuery;
import java.util.Arrays;
import java.util.List;

class OfflineObjectStore<T extends ParseObject> implements ParseObjectStore<T> {
   private final String className;
   private final ParseObjectStore<T> legacy;
   private final String pinName;

   public OfflineObjectStore(Class<T> var1, String var2, ParseObjectStore<T> var3) {
      this(getSubclassingController().getClassName(var1), var2, var3);
   }

   public OfflineObjectStore(String var1, String var2, ParseObjectStore<T> var3) {
      this.className = var1;
      this.pinName = var2;
      this.legacy = var3;
   }

   private static ParseObjectSubclassingController getSubclassingController() {
      return ParseCorePlugins.getInstance().getSubclassingController();
   }

   private static <T extends ParseObject> Task<T> migrate(final ParseObjectStore<T> var0, final ParseObjectStore<T> var1) {
      return var0.getAsync().onSuccessTask(new Continuation() {
         public Task<T> then(Task<T> var1x) throws Exception {
            final ParseObject var2 = (ParseObject)var1x.getResult();
            if(var2 == null) {
               return var1x;
            } else {
               Task[] var3 = new Task[]{var0.deleteAsync(), var1.setAsync(var2)};
               return Task.whenAll(Arrays.asList(var3)).continueWith(new Continuation() {
                  public T then(Task<Void> var1x) throws Exception {
                     return var2;
                  }
               });
            }
         }
      });
   }

   public Task<Void> deleteAsync() {
      final Task var1 = ParseObject.unpinAllInBackground(this.pinName);
      Task[] var2 = new Task[]{this.legacy.deleteAsync(), var1};
      return Task.whenAll(Arrays.asList(var2)).continueWithTask(new Continuation() {
         public Task<Void> then(Task<Void> var1x) throws Exception {
            return var1;
         }
      });
   }

   public Task<Boolean> existsAsync() {
      return ParseQuery.getQuery(this.className).fromPin(this.pinName).ignoreACLs().countInBackground().onSuccessTask(new Continuation() {
         public Task<Boolean> then(Task<Integer> var1) throws Exception {
            boolean var2;
            if(((Integer)var1.getResult()).intValue() == 1) {
               var2 = true;
            } else {
               var2 = false;
            }

            return var2?Task.forResult(Boolean.valueOf(true)):OfflineObjectStore.this.legacy.existsAsync();
         }
      });
   }

   public Task<T> getAsync() {
      return ParseQuery.getQuery(this.className).fromPin(this.pinName).ignoreACLs().findInBackground().onSuccessTask(new Continuation() {
         public Task<T> then(Task<List<T>> var1) throws Exception {
            List var2 = (List)var1.getResult();
            return var2 != null?(var2.size() == 1?Task.forResult(var2.get(0)):ParseObject.unpinAllInBackground(OfflineObjectStore.this.pinName).cast()):Task.forResult((Object)null);
         }
      }).onSuccessTask(new Continuation() {
         public Task<T> then(Task<T> var1) throws Exception {
            return (ParseObject)var1.getResult() != null?var1:OfflineObjectStore.migrate(OfflineObjectStore.this.legacy, OfflineObjectStore.this).cast();
         }
      });
   }

   public Task<Void> setAsync(final T var1) {
      return ParseObject.unpinAllInBackground(this.pinName).continueWithTask(new Continuation() {
         public Task<Void> then(Task<Void> var1x) throws Exception {
            return var1.pinInBackground(OfflineObjectStore.this.pinName, false);
         }
      });
   }
}
