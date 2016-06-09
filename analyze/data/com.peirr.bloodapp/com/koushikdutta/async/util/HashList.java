package com.koushikdutta.async.util;

import java.util.ArrayList;
import java.util.Hashtable;

public class HashList<T> extends Hashtable<String, ArrayList<T>> {
   public void add(String var1, T var2) {
      ArrayList var3 = (ArrayList)this.get(var1);
      if(var3 == null) {
         var3 = new ArrayList();
         this.put(var1, var3);
      }

      var3.add(var2);
   }

   public boolean contains(String var1) {
      ArrayList var2 = (ArrayList)this.get(var1);
      return var2 != null && var2.size() > 0;
   }
}
