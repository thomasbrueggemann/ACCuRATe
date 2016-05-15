package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.util.Args;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCookieSpec implements CookieSpec {
   private final Map<String, CookieAttributeHandler> attribHandlerMap = new HashMap(10);

   protected CookieAttributeHandler findAttribHandler(String var1) {
      return (CookieAttributeHandler)this.attribHandlerMap.get(var1);
   }

   protected Collection<CookieAttributeHandler> getAttribHandlers() {
      return this.attribHandlerMap.values();
   }

   public void registerAttribHandler(String var1, CookieAttributeHandler var2) {
      Args.notNull(var1, "Attribute name");
      Args.notNull(var2, "Attribute handler");
      this.attribHandlerMap.put(var1, var2);
   }
}
