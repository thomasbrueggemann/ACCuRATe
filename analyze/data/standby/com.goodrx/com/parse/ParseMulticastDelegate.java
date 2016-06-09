package com.parse;

import com.parse.ParseCallback2;
import com.parse.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class ParseMulticastDelegate<T> {
   private final List<ParseCallback2<T, ParseException>> callbacks = new LinkedList();

   public void clear() {
      this.callbacks.clear();
   }

   public void invoke(T var1, ParseException var2) {
      Iterator var3 = (new ArrayList(this.callbacks)).iterator();

      while(var3.hasNext()) {
         ((ParseCallback2)var3.next()).done(var1, var2);
      }

   }

   public void subscribe(ParseCallback2<T, ParseException> var1) {
      this.callbacks.add(var1);
   }

   public void unsubscribe(ParseCallback2<T, ParseException> var1) {
      this.callbacks.remove(var1);
   }
}
