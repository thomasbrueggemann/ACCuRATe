package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.auth.BasicUserPrincipal;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;

public class UsernamePasswordCredentials implements Credentials, Serializable {
   private final String password;
   private final BasicUserPrincipal principal;

   public UsernamePasswordCredentials(String var1) {
      Args.notNull(var1, "Username:password string");
      int var3 = var1.indexOf(58);
      if(var3 >= 0) {
         this.principal = new BasicUserPrincipal(var1.substring(0, var3));
         this.password = var1.substring(var3 + 1);
      } else {
         this.principal = new BasicUserPrincipal(var1);
         this.password = null;
      }
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 instanceof UsernamePasswordCredentials) {
            UsernamePasswordCredentials var2 = (UsernamePasswordCredentials)var1;
            if(LangUtils.equals(this.principal, var2.principal)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   public String getPassword() {
      return this.password;
   }

   public Principal getUserPrincipal() {
      return this.principal;
   }

   public int hashCode() {
      return this.principal.hashCode();
   }

   public String toString() {
      return this.principal.toString();
   }
}
