package org.apache.cordova;

public class AuthenticationToken {
   private String password;
   private String userName;

   public String getPassword() {
      return this.password;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setPassword(String var1) {
      this.password = var1;
   }

   public void setUserName(String var1) {
      this.userName = var1;
   }
}
