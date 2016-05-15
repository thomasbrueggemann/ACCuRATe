package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.impl.client.AuthenticationStrategyImpl;
import java.util.Collection;

public class TargetAuthenticationStrategy extends AuthenticationStrategyImpl {
   public static final TargetAuthenticationStrategy INSTANCE = new TargetAuthenticationStrategy();

   public TargetAuthenticationStrategy() {
      super(401, "WWW-Authenticate");
   }

   Collection<String> getPreferredAuthSchemes(RequestConfig var1) {
      return var1.getTargetPreferredAuthSchemes();
   }
}
