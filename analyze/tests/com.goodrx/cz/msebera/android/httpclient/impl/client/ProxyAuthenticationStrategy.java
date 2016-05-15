package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.impl.client.AuthenticationStrategyImpl;
import java.util.Collection;

public class ProxyAuthenticationStrategy extends AuthenticationStrategyImpl {
   public static final ProxyAuthenticationStrategy INSTANCE = new ProxyAuthenticationStrategy();

   public ProxyAuthenticationStrategy() {
      super(407, "Proxy-Authenticate");
   }

   Collection<String> getPreferredAuthSchemes(RequestConfig var1) {
      return var1.getProxyPreferredAuthSchemes();
   }
}
