package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.HttpError;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class HttpErrors extends HarvestableArray {
   private final Collection<HttpError> httpErrors = new CopyOnWriteArrayList();

   public void addHttpError(HttpError param1) {
      // $FF: Couldn't be decompiled
   }

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      Iterator var2 = this.httpErrors.iterator();

      while(var2.hasNext()) {
         var1.add(((HttpError)var2.next()).asJson());
      }

      return var1;
   }

   public void clear() {
      this.httpErrors.clear();
   }

   public int count() {
      return this.httpErrors.size();
   }

   public Collection<HttpError> getHttpErrors() {
      return this.httpErrors;
   }

   public void removeHttpError(HttpError var1) {
      synchronized(this){}

      try {
         this.httpErrors.remove(var1);
      } finally {
         ;
      }

   }
}
