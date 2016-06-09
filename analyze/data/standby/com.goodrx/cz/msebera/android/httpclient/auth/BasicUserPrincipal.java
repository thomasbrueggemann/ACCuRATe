package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;

public final class BasicUserPrincipal implements Serializable, Principal {
   private final String username;

   public BasicUserPrincipal(String var1) {
      Args.notNull(var1, "User name");
      this.username = var1;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 instanceof BasicUserPrincipal) {
            BasicUserPrincipal var2 = (BasicUserPrincipal)var1;
            if(LangUtils.equals(this.username, var2.username)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   public String getName() {
      return this.username;
   }

   public int hashCode() {
      return LangUtils.hashCode(17, this.username);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[principal: ");
      var1.append(this.username);
      var1.append("]");
      return var1.toString();
   }
}
