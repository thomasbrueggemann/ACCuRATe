package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.HttpTransaction;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class HttpTransactions extends HarvestableArray {
   private final Collection<HttpTransaction> httpTransactions = new CopyOnWriteArrayList();

   public void add(HttpTransaction var1) {
      synchronized(this){}

      try {
         this.httpTransactions.add(var1);
      } finally {
         ;
      }

   }

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      Iterator var2 = this.httpTransactions.iterator();

      while(var2.hasNext()) {
         var1.add(((HttpTransaction)var2.next()).asJson());
      }

      return var1;
   }

   public void clear() {
      this.httpTransactions.clear();
   }

   public int count() {
      return this.httpTransactions.size();
   }

   public Collection<HttpTransaction> getHttpTransactions() {
      return this.httpTransactions;
   }

   public void remove(HttpTransaction var1) {
      synchronized(this){}

      try {
         this.httpTransactions.remove(var1);
      } finally {
         ;
      }

   }

   public String toString() {
      return "HttpTransactions{httpTransactions=" + this.httpTransactions + '}';
   }
}
