package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;

public class NTUserPrincipal implements Serializable, Principal {
   private final String domain;
   private final String ntname;
   private final String username;

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 instanceof NTUserPrincipal) {
            NTUserPrincipal var2 = (NTUserPrincipal)var1;
            if(LangUtils.equals(this.username, var2.username) && LangUtils.equals(this.domain, var2.domain)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   public String getDomain() {
      return this.domain;
   }

   public String getName() {
      return this.ntname;
   }

   public String getUsername() {
      return this.username;
   }

   public int hashCode() {
      return LangUtils.hashCode(LangUtils.hashCode(17, this.username), this.domain);
   }

   public String toString() {
      return this.ntname;
   }
}
