package cz.msebera.android.httpclient.params;

import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpParams;

@Deprecated
public class SyncBasicHttpParams extends BasicHttpParams {
   public Object clone() throws CloneNotSupportedException {
      synchronized(this){}

      Object var2;
      try {
         var2 = super.clone();
      } finally {
         ;
      }

      return var2;
   }

   public Object getParameter(String var1) {
      synchronized(this){}

      Object var3;
      try {
         var3 = super.getParameter(var1);
      } finally {
         ;
      }

      return var3;
   }

   public HttpParams setParameter(String var1, Object var2) {
      synchronized(this){}

      HttpParams var4;
      try {
         var4 = super.setParameter(var1, var2);
      } finally {
         ;
      }

      return var4;
   }
}
