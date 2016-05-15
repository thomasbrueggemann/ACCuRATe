package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.NTUserPrincipal;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;

public class NTCredentials implements Credentials, Serializable {
   private final String password;
   private final NTUserPrincipal principal;
   private final String workstation;

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 instanceof NTCredentials) {
            NTCredentials var2 = (NTCredentials)var1;
            if(LangUtils.equals(this.principal, var2.principal) && LangUtils.equals(this.workstation, var2.workstation)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   public String getDomain() {
      return this.principal.getDomain();
   }

   public String getPassword() {
      return this.password;
   }

   public String getUserName() {
      return this.principal.getUsername();
   }

   public Principal getUserPrincipal() {
      return this.principal;
   }

   public String getWorkstation() {
      return this.workstation;
   }

   public int hashCode() {
      return LangUtils.hashCode(LangUtils.hashCode(17, this.principal), this.workstation);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[principal: ");
      var1.append(this.principal);
      var1.append("][workstation: ");
      var1.append(this.workstation);
      var1.append("]");
      return var1.toString();
   }
}
