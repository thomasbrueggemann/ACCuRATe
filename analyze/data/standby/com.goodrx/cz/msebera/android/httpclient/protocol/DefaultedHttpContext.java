package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

@Deprecated
public final class DefaultedHttpContext implements HttpContext {
   private final HttpContext defaults;
   private final HttpContext local;

   public DefaultedHttpContext(HttpContext var1, HttpContext var2) {
      this.local = (HttpContext)Args.notNull(var1, "HTTP context");
      this.defaults = var2;
   }

   public Object getAttribute(String var1) {
      Object var2 = this.local.getAttribute(var1);
      if(var2 == null) {
         var2 = this.defaults.getAttribute(var1);
      }

      return var2;
   }

   public void setAttribute(String var1, Object var2) {
      this.local.setAttribute(var1, var2);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[local: ").append(this.local);
      var1.append("defaults: ").append(this.defaults);
      var1.append("]");
      return var1.toString();
   }
}
