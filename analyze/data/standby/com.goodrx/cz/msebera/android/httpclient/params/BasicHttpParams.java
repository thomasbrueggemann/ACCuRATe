package cz.msebera.android.httpclient.params;

import cz.msebera.android.httpclient.params.AbstractHttpParams;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public class BasicHttpParams extends AbstractHttpParams implements Serializable, Cloneable {
   private final Map<String, Object> parameters = new ConcurrentHashMap();

   public Object clone() throws CloneNotSupportedException {
      BasicHttpParams var1 = (BasicHttpParams)super.clone();
      this.copyParams(var1);
      return var1;
   }

   public void copyParams(HttpParams var1) {
      Iterator var2 = this.parameters.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.setParameter((String)var3.getKey(), var3.getValue());
      }

   }

   public Object getParameter(String var1) {
      return this.parameters.get(var1);
   }

   public HttpParams setParameter(String var1, Object var2) {
      if(var1 == null) {
         return this;
      } else if(var2 != null) {
         this.parameters.put(var1, var2);
         return this;
      } else {
         this.parameters.remove(var1);
         return this;
      }
   }
}
