package com.parse;

import bolts.AggregateException;
import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.parse.ParseCallback1;
import com.parse.ParseCallback2;
import com.parse.ParseException;
import com.parse.ParseExecutors;
import java.util.concurrent.CancellationException;

class ParseTaskUtils {
   static Task<Void> callbackOnMainThreadAsync(Task<Void> var0, ParseCallback1<ParseException> var1) {
      return callbackOnMainThreadAsync(var0, var1, false);
   }

   static Task<Void> callbackOnMainThreadAsync(Task<Void> var0, final ParseCallback1<ParseException> var1, boolean var2) {
      return var1 == null?var0:callbackOnMainThreadAsync(var0, new ParseCallback2() {
         public void done(Void var1x, ParseException var2) {
            var1.done(var2);
         }
      }, var2);
   }

   static <T> Task<T> callbackOnMainThreadAsync(Task<T> var0, ParseCallback2<T, ParseException> var1) {
      return callbackOnMainThreadAsync(var0, var1, false);
   }

   static <T> Task<T> callbackOnMainThreadAsync(Task<T> var0, final ParseCallback2<T, ParseException> var1, final boolean var2) {
      if(var1 == null) {
         return var0;
      } else {
         final TaskCompletionSource var3 = new TaskCompletionSource();
         var0.continueWith(new Continuation() {
            public Void then(final Task<T> var1x) throws Exception {
               if(var1x.isCancelled() && !var2) {
                  var3.setCancelled();
                  return null;
               } else {
                  ParseExecutors.main().execute(new Runnable() {
                     public void run() {
                        // $FF: Couldn't be decompiled
                     }
                  });
                  return null;
               }
            }
         });
         return var3.getTask();
      }
   }

   static <T> T wait(Task<T> var0) throws ParseException {
      try {
         var0.waitForCompletion();
         if(var0.isFaulted()) {
            Exception var3 = var0.getError();
            if(var3 instanceof ParseException) {
               throw (ParseException)var3;
            } else if(var3 instanceof AggregateException) {
               throw new ParseException(var3);
            } else if(var3 instanceof RuntimeException) {
               throw (RuntimeException)var3;
            } else {
               throw new RuntimeException(var3);
            }
         } else if(var0.isCancelled()) {
            throw new RuntimeException(new CancellationException());
         } else {
            Object var2 = var0.getResult();
            return var2;
         }
      } catch (InterruptedException var4) {
         throw new RuntimeException(var4);
      }
   }
}
