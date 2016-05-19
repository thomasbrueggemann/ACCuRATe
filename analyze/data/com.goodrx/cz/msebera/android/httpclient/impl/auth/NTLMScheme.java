package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.InvalidCredentialsException;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.auth.NTCredentials;
import cz.msebera.android.httpclient.impl.auth.AuthSchemeBase;
import cz.msebera.android.httpclient.impl.auth.NTLMEngine;
import cz.msebera.android.httpclient.impl.auth.NTLMEngineImpl;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

public class NTLMScheme extends AuthSchemeBase {
   private String challenge;
   private final NTLMEngine engine;
   private NTLMScheme.State state;

   public NTLMScheme() {
      this(new NTLMEngineImpl());
   }

   public NTLMScheme(NTLMEngine var1) {
      Args.notNull(var1, "NTLM engine");
      this.engine = var1;
      this.state = NTLMScheme.State.UNINITIATED;
      this.challenge = null;
   }

   public Header authenticate(Credentials var1, HttpRequest var2) throws AuthenticationException {
      NTCredentials var4;
      try {
         var4 = (NTCredentials)var1;
      } catch (ClassCastException var7) {
         throw new InvalidCredentialsException("Credentials cannot be used for NTLM authentication: " + var1.getClass().getName());
      }

      if(this.state == NTLMScheme.State.FAILED) {
         throw new AuthenticationException("NTLM authentication failed");
      } else {
         String var5;
         if(this.state == NTLMScheme.State.CHALLENGE_RECEIVED) {
            var5 = this.engine.generateType1Msg(var4.getDomain(), var4.getWorkstation());
            this.state = NTLMScheme.State.MSG_TYPE1_GENERATED;
         } else {
            if(this.state != NTLMScheme.State.MSG_TYPE2_RECEVIED) {
               throw new AuthenticationException("Unexpected state: " + this.state);
            }

            var5 = this.engine.generateType3Msg(var4.getUserName(), var4.getPassword(), var4.getDomain(), var4.getWorkstation(), this.challenge);
            this.state = NTLMScheme.State.MSG_TYPE3_GENERATED;
         }

         CharArrayBuffer var6 = new CharArrayBuffer(32);
         if(this.isProxy()) {
            var6.append("Proxy-Authorization");
         } else {
            var6.append("Authorization");
         }

         var6.append(": NTLM ");
         var6.append(var5);
         return new BufferedHeader(var6);
      }
   }

   public String getRealm() {
      return null;
   }

   public String getSchemeName() {
      return "ntlm";
   }

   public boolean isComplete() {
      return this.state == NTLMScheme.State.MSG_TYPE3_GENERATED || this.state == NTLMScheme.State.FAILED;
   }

   public boolean isConnectionBased() {
      return true;
   }

   protected void parseChallenge(CharArrayBuffer var1, int var2, int var3) throws MalformedChallengeException {
      this.challenge = var1.substringTrimmed(var2, var3);
      if(this.challenge.length() == 0) {
         if(this.state != NTLMScheme.State.UNINITIATED) {
            this.state = NTLMScheme.State.FAILED;
            return;
         }

         this.state = NTLMScheme.State.CHALLENGE_RECEIVED;
      } else {
         if(this.state.compareTo(NTLMScheme.State.MSG_TYPE1_GENERATED) < 0) {
            this.state = NTLMScheme.State.FAILED;
            throw new MalformedChallengeException("Out of sequence NTLM response message");
         }

         if(this.state == NTLMScheme.State.MSG_TYPE1_GENERATED) {
            this.state = NTLMScheme.State.MSG_TYPE2_RECEVIED;
            return;
         }
      }

   }

   static enum State {
      CHALLENGE_RECEIVED,
      FAILED,
      MSG_TYPE1_GENERATED,
      MSG_TYPE2_RECEVIED,
      MSG_TYPE3_GENERATED,
      UNINITIATED;

      static {
         NTLMScheme.State[] var0 = new NTLMScheme.State[]{UNINITIATED, CHALLENGE_RECEIVED, MSG_TYPE1_GENERATED, MSG_TYPE2_RECEVIED, MSG_TYPE3_GENERATED, FAILED};
      }
   }
}
