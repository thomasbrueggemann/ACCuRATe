package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;

@Deprecated
public class SyncBasicHttpContext extends BasicHttpContext {
   public SyncBasicHttpContext() {
   }

   public SyncBasicHttpContext(HttpContext var1) {
      super(var1);
   }

   public Object getAttribute(String var1) {
      synchronized(this){}

      Object var3;
      try {
         var3 = super.getAttribute(var1);
      } finally {
         ;
      }

      return var3;
   }

   public void setAttribute(String var1, Object var2) {
      synchronized(this){}

      try {
         super.setAttribute(var1, var2);
      } finally {
         ;
      }

   }
}
