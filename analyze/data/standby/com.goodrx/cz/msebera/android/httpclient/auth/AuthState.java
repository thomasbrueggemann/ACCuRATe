package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.util.Args;
import java.util.Queue;

public class AuthState {
   private Queue<AuthOption> authOptions;
   private AuthScheme authScheme;
   private AuthScope authScope;
   private Credentials credentials;
   private AuthProtocolState state;

   public AuthState() {
      this.state = AuthProtocolState.UNCHALLENGED;
   }

   public Queue<AuthOption> getAuthOptions() {
      return this.authOptions;
   }

   public AuthScheme getAuthScheme() {
      return this.authScheme;
   }

   public Credentials getCredentials() {
      return this.credentials;
   }

   public AuthProtocolState getState() {
      return this.state;
   }

   public void reset() {
      this.state = AuthProtocolState.UNCHALLENGED;
      this.authOptions = null;
      this.authScheme = null;
      this.authScope = null;
      this.credentials = null;
   }

   @Deprecated
   public void setAuthScheme(AuthScheme var1) {
      if(var1 == null) {
         this.reset();
      } else {
         this.authScheme = var1;
      }
   }

   @Deprecated
   public void setCredentials(Credentials var1) {
      this.credentials = var1;
   }

   public void setState(AuthProtocolState var1) {
      if(var1 == null) {
         var1 = AuthProtocolState.UNCHALLENGED;
      }

      this.state = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("state:").append(this.state).append(";");
      if(this.authScheme != null) {
         var1.append("auth scheme:").append(this.authScheme.getSchemeName()).append(";");
      }

      if(this.credentials != null) {
         var1.append("credentials present");
      }

      return var1.toString();
   }

   public void update(AuthScheme var1, Credentials var2) {
      Args.notNull(var1, "Auth scheme");
      Args.notNull(var2, "Credentials");
      this.authScheme = var1;
      this.credentials = var2;
      this.authOptions = null;
   }

   public void update(Queue<AuthOption> var1) {
      Args.notEmpty(var1, "Queue of auth options");
      this.authOptions = var1;
      this.authScheme = null;
      this.credentials = null;
   }
}
