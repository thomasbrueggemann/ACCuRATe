package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.extras.Base64;
import cz.msebera.android.httpclient.impl.auth.NTLMEngine;
import cz.msebera.android.httpclient.impl.auth.NTLMEngineException;
import cz.msebera.android.httpclient.util.EncodingUtils;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

final class NTLMEngineImpl implements NTLMEngine {
   private static final SecureRandom RND_GEN;
   private static final byte[] SIGNATURE;
   private String credentialCharset = "ASCII";

   static {
      SecureRandom var1;
      label12: {
         SecureRandom var3;
         try {
            var3 = SecureRandom.getInstance("SHA1PRNG");
         } catch (Exception var4) {
            var1 = null;
            break label12;
         }

         var1 = var3;
      }

      RND_GEN = var1;
      byte[] var2 = EncodingUtils.getBytes("NTLMSSP", "ASCII");
      SIGNATURE = new byte[1 + var2.length];
      System.arraycopy(var2, 0, SIGNATURE, 0, var2.length);
      SIGNATURE[var2.length] = 0;
   }

   // $FF: renamed from: F (int, int, int) int
   static int method_76(int var0, int var1, int var2) {
      return var0 & var1 | var2 & ~var0;
   }

   // $FF: renamed from: G (int, int, int) int
   static int method_77(int var0, int var1, int var2) {
      return var0 & var1 | var0 & var2 | var1 & var2;
   }

   // $FF: renamed from: H (int, int, int) int
   static int method_78(int var0, int var1, int var2) {
      return var2 ^ var0 ^ var1;
   }

   static byte[] RC4(byte[] var0, byte[] var1) throws NTLMEngineException {
      try {
         Cipher var3 = Cipher.getInstance("RC4");
         var3.init(1, new SecretKeySpec(var1, "RC4"));
         byte[] var4 = var3.doFinal(var0);
         return var4;
      } catch (Exception var5) {
         throw new NTLMEngineException(var5.getMessage(), var5);
      }
   }

   // $FF: synthetic method
   static String access$1400(String var0) {
      return convertHost(var0);
   }

   // $FF: synthetic method
   static String access$1500(String var0) {
      return convertDomain(var0);
   }

   private static String convertDomain(String var0) {
      return stripDotSuffix(var0);
   }

   private static String convertHost(String var0) {
      return stripDotSuffix(var0);
   }

   private static byte[] createBlob(byte[] var0, byte[] var1, byte[] var2) {
      byte[] var3 = new byte[]{(byte)1, (byte)1, (byte)0, (byte)0};
      byte[] var4 = new byte[]{(byte)0, (byte)0, (byte)0, (byte)0};
      byte[] var5 = new byte[]{(byte)0, (byte)0, (byte)0, (byte)0};
      byte[] var6 = new byte[]{(byte)0, (byte)0, (byte)0, (byte)0};
      byte[] var7 = new byte[8 + var3.length + var4.length + var2.length + var5.length + var1.length + var6.length];
      System.arraycopy(var3, 0, var7, 0, var3.length);
      int var8 = 0 + var3.length;
      System.arraycopy(var4, 0, var7, var8, var4.length);
      int var9 = var8 + var4.length;
      System.arraycopy(var2, 0, var7, var9, var2.length);
      int var10 = var9 + var2.length;
      System.arraycopy(var0, 0, var7, var10, 8);
      int var11 = var10 + 8;
      System.arraycopy(var5, 0, var7, var11, var5.length);
      int var12 = var11 + var5.length;
      System.arraycopy(var1, 0, var7, var12, var1.length);
      int var13 = var12 + var1.length;
      System.arraycopy(var6, 0, var7, var13, var6.length);
      int var10000 = var13 + var6.length;
      return var7;
   }

   private static Key createDESKey(byte[] var0, int var1) {
      byte[] var2 = new byte[7];
      System.arraycopy(var0, var1, var2, 0, 7);
      byte[] var3 = new byte[]{var2[0], (byte)(var2[0] << 7 | (255 & var2[1]) >>> 1), (byte)(var2[1] << 6 | (255 & var2[2]) >>> 2), (byte)(var2[2] << 5 | (255 & var2[3]) >>> 3), (byte)(var2[3] << 4 | (255 & var2[4]) >>> 4), (byte)(var2[4] << 3 | (255 & var2[5]) >>> 5), (byte)(var2[5] << 2 | (255 & var2[6]) >>> 6), (byte)(var2[6] << 1)};
      oddParity(var3);
      return new SecretKeySpec(var3, "DES");
   }

   static byte[] hmacMD5(byte[] var0, byte[] var1) throws NTLMEngineException {
      NTLMEngineImpl.HMACMD5 var2 = new NTLMEngineImpl.HMACMD5(var1);
      var2.update(var0);
      return var2.getOutput();
   }

   private static byte[] lmHash(String var0) throws NTLMEngineException {
      try {
         byte[] var2 = var0.toUpperCase(Locale.ENGLISH).getBytes("US-ASCII");
         int var3 = Math.min(var2.length, 14);
         byte[] var4 = new byte[14];
         System.arraycopy(var2, 0, var4, 0, var3);
         Key var5 = createDESKey(var4, 0);
         Key var6 = createDESKey(var4, 7);
         byte[] var7 = "KGS!@#$%".getBytes("US-ASCII");
         Cipher var8 = Cipher.getInstance("DES/ECB/NoPadding");
         var8.init(1, var5);
         byte[] var9 = var8.doFinal(var7);
         var8.init(1, var6);
         byte[] var10 = var8.doFinal(var7);
         byte[] var11 = new byte[16];
         System.arraycopy(var9, 0, var11, 0, 8);
         System.arraycopy(var10, 0, var11, 8, 8);
         return var11;
      } catch (Exception var12) {
         throw new NTLMEngineException(var12.getMessage(), var12);
      }
   }

   private static byte[] lmResponse(byte[] var0, byte[] var1) throws NTLMEngineException {
      try {
         byte[] var3 = new byte[21];
         System.arraycopy(var0, 0, var3, 0, 16);
         Key var4 = createDESKey(var3, 0);
         Key var5 = createDESKey(var3, 7);
         Key var6 = createDESKey(var3, 14);
         Cipher var7 = Cipher.getInstance("DES/ECB/NoPadding");
         var7.init(1, var4);
         byte[] var8 = var7.doFinal(var1);
         var7.init(1, var5);
         byte[] var9 = var7.doFinal(var1);
         var7.init(1, var6);
         byte[] var10 = var7.doFinal(var1);
         byte[] var11 = new byte[24];
         System.arraycopy(var8, 0, var11, 0, 8);
         System.arraycopy(var9, 0, var11, 8, 8);
         System.arraycopy(var10, 0, var11, 16, 8);
         return var11;
      } catch (Exception var12) {
         throw new NTLMEngineException(var12.getMessage(), var12);
      }
   }

   private static byte[] lmv2Hash(String param0, String param1, byte[] param2) throws NTLMEngineException {
      // $FF: Couldn't be decompiled
   }

   private static byte[] lmv2Response(byte[] var0, byte[] var1, byte[] var2) throws NTLMEngineException {
      NTLMEngineImpl.HMACMD5 var3 = new NTLMEngineImpl.HMACMD5(var0);
      var3.update(var1);
      var3.update(var2);
      byte[] var4 = var3.getOutput();
      byte[] var5 = new byte[var4.length + var2.length];
      System.arraycopy(var4, 0, var5, 0, var4.length);
      System.arraycopy(var2, 0, var5, var4.length, var2.length);
      return var5;
   }

   private static byte[] makeRandomChallenge() throws NTLMEngineException {
      // $FF: Couldn't be decompiled
   }

   private static byte[] makeSecondaryKey() throws NTLMEngineException {
      // $FF: Couldn't be decompiled
   }

   static byte[] ntlm2SessionResponse(byte[] var0, byte[] var1, byte[] var2) throws NTLMEngineException {
      try {
         MessageDigest var4 = MessageDigest.getInstance("MD5");
         var4.update(var1);
         var4.update(var2);
         byte[] var5 = var4.digest();
         byte[] var6 = new byte[8];
         System.arraycopy(var5, 0, var6, 0, 8);
         byte[] var7 = lmResponse(var0, var6);
         return var7;
      } catch (Exception var8) {
         if(var8 instanceof NTLMEngineException) {
            throw (NTLMEngineException)var8;
         } else {
            throw new NTLMEngineException(var8.getMessage(), var8);
         }
      }
   }

   private static byte[] ntlmHash(String var0) throws NTLMEngineException {
      try {
         byte[] var2 = var0.getBytes("UnicodeLittleUnmarked");
         NTLMEngineImpl.MD4 var3 = new NTLMEngineImpl.MD4();
         var3.update(var2);
         byte[] var4 = var3.getOutput();
         return var4;
      } catch (UnsupportedEncodingException var5) {
         throw new NTLMEngineException("Unicode not supported: " + var5.getMessage(), var5);
      }
   }

   private static byte[] ntlmv2Hash(String param0, String param1, byte[] param2) throws NTLMEngineException {
      // $FF: Couldn't be decompiled
   }

   private static void oddParity(byte[] var0) {
      for(int var1 = 0; var1 < var0.length; ++var1) {
         byte var2 = var0[var1];
         boolean var3;
         if((1 & (var2 >>> 7 ^ var2 >>> 6 ^ var2 >>> 5 ^ var2 >>> 4 ^ var2 >>> 3 ^ var2 >>> 2 ^ var2 >>> 1)) == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(var3) {
            var0[var1] = (byte)(1 | var0[var1]);
         } else {
            var0[var1] &= -2;
         }
      }

   }

   private static byte[] readSecurityBuffer(byte[] var0, int var1) throws NTLMEngineException {
      int var2 = readUShort(var0, var1);
      int var3 = readULong(var0, var1 + 4);
      if(var0.length < var3 + var2) {
         throw new NTLMEngineException("NTLM authentication - buffer too small for data item");
      } else {
         byte[] var4 = new byte[var2];
         System.arraycopy(var0, var3, var4, 0, var2);
         return var4;
      }
   }

   private static int readULong(byte[] var0, int var1) throws NTLMEngineException {
      if(var0.length < var1 + 4) {
         throw new NTLMEngineException("NTLM authentication - buffer too small for DWORD");
      } else {
         return 255 & var0[var1] | (255 & var0[var1 + 1]) << 8 | (255 & var0[var1 + 2]) << 16 | (255 & var0[var1 + 3]) << 24;
      }
   }

   private static int readUShort(byte[] var0, int var1) throws NTLMEngineException {
      if(var0.length < var1 + 2) {
         throw new NTLMEngineException("NTLM authentication - buffer too small for WORD");
      } else {
         return 255 & var0[var1] | (255 & var0[var1 + 1]) << 8;
      }
   }

   static int rotintlft(int var0, int var1) {
      return var0 << var1 | var0 >>> 32 - var1;
   }

   private static String stripDotSuffix(String var0) {
      if(var0 == null) {
         var0 = null;
      } else {
         int var1 = var0.indexOf(".");
         if(var1 != -1) {
            return var0.substring(0, var1);
         }
      }

      return var0;
   }

   static void writeULong(byte[] var0, int var1, int var2) {
      var0[var2] = (byte)(var1 & 255);
      var0[var2 + 1] = (byte)(255 & var1 >> 8);
      var0[var2 + 2] = (byte)(255 & var1 >> 16);
      var0[var2 + 3] = (byte)(255 & var1 >> 24);
   }

   public String generateType1Msg(String var1, String var2) throws NTLMEngineException {
      return this.getType1Message(var2, var1);
   }

   public String generateType3Msg(String var1, String var2, String var3, String var4, String var5) throws NTLMEngineException {
      NTLMEngineImpl.Type2Message var6 = new NTLMEngineImpl.Type2Message(var5);
      return this.getType3Message(var1, var2, var4, var3, var6.getChallenge(), var6.getFlags(), var6.getTarget(), var6.getTargetInfo());
   }

   String getType1Message(String var1, String var2) throws NTLMEngineException {
      return (new NTLMEngineImpl.Type1Message(var2, var1)).getResponse();
   }

   String getType3Message(String var1, String var2, String var3, String var4, byte[] var5, int var6, String var7, byte[] var8) throws NTLMEngineException {
      return (new NTLMEngineImpl.Type3Message(var4, var3, var1, var2, var5, var6, var7, var8)).getResponse();
   }

   protected static class CipherGen {
      protected final byte[] challenge;
      protected byte[] clientChallenge;
      protected byte[] clientChallenge2;
      protected final String domain;
      protected byte[] lanManagerSessionKey;
      protected byte[] lm2SessionResponse;
      protected byte[] lmHash;
      protected byte[] lmResponse;
      protected byte[] lmUserSessionKey;
      protected byte[] lmv2Hash;
      protected byte[] lmv2Response;
      protected byte[] ntlm2SessionResponse;
      protected byte[] ntlm2SessionResponseUserSessionKey;
      protected byte[] ntlmHash;
      protected byte[] ntlmResponse;
      protected byte[] ntlmUserSessionKey;
      protected byte[] ntlmv2Blob;
      protected byte[] ntlmv2Hash;
      protected byte[] ntlmv2Response;
      protected byte[] ntlmv2UserSessionKey;
      protected final String password;
      protected byte[] secondaryKey;
      protected final String target;
      protected final byte[] targetInformation;
      protected byte[] timestamp;
      protected final String user;

      public CipherGen(String var1, String var2, String var3, byte[] var4, String var5, byte[] var6) {
         this(var1, var2, var3, var4, var5, var6, (byte[])null, (byte[])null, (byte[])null, (byte[])null);
      }

      public CipherGen(String var1, String var2, String var3, byte[] var4, String var5, byte[] var6, byte[] var7, byte[] var8, byte[] var9, byte[] var10) {
         this.lmHash = null;
         this.lmResponse = null;
         this.ntlmHash = null;
         this.ntlmResponse = null;
         this.ntlmv2Hash = null;
         this.lmv2Hash = null;
         this.lmv2Response = null;
         this.ntlmv2Blob = null;
         this.ntlmv2Response = null;
         this.ntlm2SessionResponse = null;
         this.lm2SessionResponse = null;
         this.lmUserSessionKey = null;
         this.ntlmUserSessionKey = null;
         this.ntlmv2UserSessionKey = null;
         this.ntlm2SessionResponseUserSessionKey = null;
         this.lanManagerSessionKey = null;
         this.domain = var1;
         this.target = var5;
         this.user = var2;
         this.password = var3;
         this.challenge = var4;
         this.targetInformation = var6;
         this.clientChallenge = var7;
         this.clientChallenge2 = var8;
         this.secondaryKey = var9;
         this.timestamp = var10;
      }

      public byte[] getClientChallenge() throws NTLMEngineException {
         if(this.clientChallenge == null) {
            this.clientChallenge = NTLMEngineImpl.makeRandomChallenge();
         }

         return this.clientChallenge;
      }

      public byte[] getClientChallenge2() throws NTLMEngineException {
         if(this.clientChallenge2 == null) {
            this.clientChallenge2 = NTLMEngineImpl.makeRandomChallenge();
         }

         return this.clientChallenge2;
      }

      public byte[] getLM2SessionResponse() throws NTLMEngineException {
         if(this.lm2SessionResponse == null) {
            byte[] var1 = this.getClientChallenge();
            this.lm2SessionResponse = new byte[24];
            System.arraycopy(var1, 0, this.lm2SessionResponse, 0, var1.length);
            Arrays.fill(this.lm2SessionResponse, var1.length, this.lm2SessionResponse.length, (byte)0);
         }

         return this.lm2SessionResponse;
      }

      public byte[] getLMHash() throws NTLMEngineException {
         if(this.lmHash == null) {
            this.lmHash = NTLMEngineImpl.lmHash(this.password);
         }

         return this.lmHash;
      }

      public byte[] getLMResponse() throws NTLMEngineException {
         if(this.lmResponse == null) {
            this.lmResponse = NTLMEngineImpl.lmResponse(this.getLMHash(), this.challenge);
         }

         return this.lmResponse;
      }

      public byte[] getLMUserSessionKey() throws NTLMEngineException {
         if(this.lmUserSessionKey == null) {
            this.lmUserSessionKey = new byte[16];
            System.arraycopy(this.getLMHash(), 0, this.lmUserSessionKey, 0, 8);
            Arrays.fill(this.lmUserSessionKey, 8, 16, (byte)0);
         }

         return this.lmUserSessionKey;
      }

      public byte[] getLMv2Hash() throws NTLMEngineException {
         if(this.lmv2Hash == null) {
            this.lmv2Hash = NTLMEngineImpl.lmv2Hash(this.domain, this.user, this.getNTLMHash());
         }

         return this.lmv2Hash;
      }

      public byte[] getLMv2Response() throws NTLMEngineException {
         if(this.lmv2Response == null) {
            this.lmv2Response = NTLMEngineImpl.lmv2Response(this.getLMv2Hash(), this.challenge, this.getClientChallenge());
         }

         return this.lmv2Response;
      }

      public byte[] getLanManagerSessionKey() throws NTLMEngineException {
         if(this.lanManagerSessionKey == null) {
            try {
               byte[] var2 = new byte[14];
               System.arraycopy(this.getLMHash(), 0, var2, 0, 8);
               Arrays.fill(var2, 8, var2.length, (byte)-67);
               Key var3 = NTLMEngineImpl.createDESKey(var2, 0);
               Key var4 = NTLMEngineImpl.createDESKey(var2, 7);
               byte[] var5 = new byte[8];
               System.arraycopy(this.getLMResponse(), 0, var5, 0, var5.length);
               Cipher var6 = Cipher.getInstance("DES/ECB/NoPadding");
               var6.init(1, var3);
               byte[] var7 = var6.doFinal(var5);
               Cipher var8 = Cipher.getInstance("DES/ECB/NoPadding");
               var8.init(1, var4);
               byte[] var9 = var8.doFinal(var5);
               this.lanManagerSessionKey = new byte[16];
               System.arraycopy(var7, 0, this.lanManagerSessionKey, 0, var7.length);
               System.arraycopy(var9, 0, this.lanManagerSessionKey, var7.length, var9.length);
            } catch (Exception var10) {
               throw new NTLMEngineException(var10.getMessage(), var10);
            }
         }

         return this.lanManagerSessionKey;
      }

      public byte[] getNTLM2SessionResponse() throws NTLMEngineException {
         if(this.ntlm2SessionResponse == null) {
            this.ntlm2SessionResponse = NTLMEngineImpl.ntlm2SessionResponse(this.getNTLMHash(), this.challenge, this.getClientChallenge());
         }

         return this.ntlm2SessionResponse;
      }

      public byte[] getNTLM2SessionResponseUserSessionKey() throws NTLMEngineException {
         if(this.ntlm2SessionResponseUserSessionKey == null) {
            byte[] var1 = this.getLM2SessionResponse();
            byte[] var2 = new byte[this.challenge.length + var1.length];
            System.arraycopy(this.challenge, 0, var2, 0, this.challenge.length);
            System.arraycopy(var1, 0, var2, this.challenge.length, var1.length);
            this.ntlm2SessionResponseUserSessionKey = NTLMEngineImpl.hmacMD5(var2, this.getNTLMUserSessionKey());
         }

         return this.ntlm2SessionResponseUserSessionKey;
      }

      public byte[] getNTLMHash() throws NTLMEngineException {
         if(this.ntlmHash == null) {
            this.ntlmHash = NTLMEngineImpl.ntlmHash(this.password);
         }

         return this.ntlmHash;
      }

      public byte[] getNTLMResponse() throws NTLMEngineException {
         if(this.ntlmResponse == null) {
            this.ntlmResponse = NTLMEngineImpl.lmResponse(this.getNTLMHash(), this.challenge);
         }

         return this.ntlmResponse;
      }

      public byte[] getNTLMUserSessionKey() throws NTLMEngineException {
         if(this.ntlmUserSessionKey == null) {
            NTLMEngineImpl.MD4 var1 = new NTLMEngineImpl.MD4();
            var1.update(this.getNTLMHash());
            this.ntlmUserSessionKey = var1.getOutput();
         }

         return this.ntlmUserSessionKey;
      }

      public byte[] getNTLMv2Blob() throws NTLMEngineException {
         if(this.ntlmv2Blob == null) {
            this.ntlmv2Blob = NTLMEngineImpl.createBlob(this.getClientChallenge2(), this.targetInformation, this.getTimestamp());
         }

         return this.ntlmv2Blob;
      }

      public byte[] getNTLMv2Hash() throws NTLMEngineException {
         if(this.ntlmv2Hash == null) {
            this.ntlmv2Hash = NTLMEngineImpl.ntlmv2Hash(this.domain, this.user, this.getNTLMHash());
         }

         return this.ntlmv2Hash;
      }

      public byte[] getNTLMv2Response() throws NTLMEngineException {
         if(this.ntlmv2Response == null) {
            this.ntlmv2Response = NTLMEngineImpl.lmv2Response(this.getNTLMv2Hash(), this.challenge, this.getNTLMv2Blob());
         }

         return this.ntlmv2Response;
      }

      public byte[] getNTLMv2UserSessionKey() throws NTLMEngineException {
         if(this.ntlmv2UserSessionKey == null) {
            byte[] var1 = this.getNTLMv2Hash();
            byte[] var2 = new byte[16];
            System.arraycopy(this.getNTLMv2Response(), 0, var2, 0, 16);
            this.ntlmv2UserSessionKey = NTLMEngineImpl.hmacMD5(var2, var1);
         }

         return this.ntlmv2UserSessionKey;
      }

      public byte[] getSecondaryKey() throws NTLMEngineException {
         if(this.secondaryKey == null) {
            this.secondaryKey = NTLMEngineImpl.makeSecondaryKey();
         }

         return this.secondaryKey;
      }

      public byte[] getTimestamp() {
         if(this.timestamp == null) {
            long var1 = 10000L * (11644473600000L + System.currentTimeMillis());
            this.timestamp = new byte[8];

            for(int var3 = 0; var3 < 8; ++var3) {
               this.timestamp[var3] = (byte)((int)var1);
               var1 >>>= 8;
            }
         }

         return this.timestamp;
      }
   }

   static class HMACMD5 {
      protected byte[] ipad;
      protected MessageDigest md5;
      protected byte[] opad;

      HMACMD5(byte[] var1) throws NTLMEngineException {
         byte[] var2 = var1;

         try {
            this.md5 = MessageDigest.getInstance("MD5");
         } catch (Exception var6) {
            throw new NTLMEngineException("Error getting md5 message digest implementation: " + var6.getMessage(), var6);
         }

         this.ipad = new byte[64];
         this.opad = new byte[64];
         int var4 = var1.length;
         if(var4 > 64) {
            this.md5.update(var1);
            var2 = this.md5.digest();
            var4 = var2.length;
         }

         int var5;
         for(var5 = 0; var5 < var4; ++var5) {
            this.ipad[var5] = (byte)(54 ^ var2[var5]);
            this.opad[var5] = (byte)(92 ^ var2[var5]);
         }

         while(var5 < 64) {
            this.ipad[var5] = 54;
            this.opad[var5] = 92;
            ++var5;
         }

         this.md5.reset();
         this.md5.update(this.ipad);
      }

      byte[] getOutput() {
         byte[] var1 = this.md5.digest();
         this.md5.update(this.opad);
         return this.md5.digest(var1);
      }

      void update(byte[] var1) {
         this.md5.update(var1);
      }
   }

   static class MD4 {
      // $FF: renamed from: A int
      protected int field_219 = 1732584193;
      // $FF: renamed from: B int
      protected int field_220 = -271733879;
      // $FF: renamed from: C int
      protected int field_221 = -1732584194;
      // $FF: renamed from: D int
      protected int field_222 = 271733878;
      protected long count = 0L;
      protected byte[] dataBuffer = new byte[64];

      byte[] getOutput() {
         int var1 = (int)(63L & this.count);
         int var2;
         if(var1 < 56) {
            var2 = 56 - var1;
         } else {
            var2 = 120 - var1;
         }

         byte[] var3 = new byte[var2 + 8];
         var3[0] = -128;

         for(int var4 = 0; var4 < 8; ++var4) {
            var3[var2 + var4] = (byte)((int)(8L * this.count >>> var4 * 8));
         }

         this.update(var3);
         byte[] var5 = new byte[16];
         NTLMEngineImpl.writeULong(var5, this.field_219, 0);
         NTLMEngineImpl.writeULong(var5, this.field_220, 4);
         NTLMEngineImpl.writeULong(var5, this.field_221, 8);
         NTLMEngineImpl.writeULong(var5, this.field_222, 12);
         return var5;
      }

      protected void processBuffer() {
         int[] var1 = new int[16];

         for(int var2 = 0; var2 < 16; ++var2) {
            var1[var2] = (255 & this.dataBuffer[var2 * 4]) + ((255 & this.dataBuffer[1 + var2 * 4]) << 8) + ((255 & this.dataBuffer[2 + var2 * 4]) << 16) + ((255 & this.dataBuffer[3 + var2 * 4]) << 24);
         }

         int var3 = this.field_219;
         int var4 = this.field_220;
         int var5 = this.field_221;
         int var6 = this.field_222;
         this.round1(var1);
         this.round2(var1);
         this.round3(var1);
         this.field_219 += var3;
         this.field_220 += var4;
         this.field_221 += var5;
         this.field_222 += var6;
      }

      protected void round1(int[] var1) {
         this.field_219 = NTLMEngineImpl.rotintlft(this.field_219 + NTLMEngineImpl.method_76(this.field_220, this.field_221, this.field_222) + var1[0], 3);
         this.field_222 = NTLMEngineImpl.rotintlft(this.field_222 + NTLMEngineImpl.method_76(this.field_219, this.field_220, this.field_221) + var1[1], 7);
         this.field_221 = NTLMEngineImpl.rotintlft(this.field_221 + NTLMEngineImpl.method_76(this.field_222, this.field_219, this.field_220) + var1[2], 11);
         this.field_220 = NTLMEngineImpl.rotintlft(this.field_220 + NTLMEngineImpl.method_76(this.field_221, this.field_222, this.field_219) + var1[3], 19);
         this.field_219 = NTLMEngineImpl.rotintlft(this.field_219 + NTLMEngineImpl.method_76(this.field_220, this.field_221, this.field_222) + var1[4], 3);
         this.field_222 = NTLMEngineImpl.rotintlft(this.field_222 + NTLMEngineImpl.method_76(this.field_219, this.field_220, this.field_221) + var1[5], 7);
         this.field_221 = NTLMEngineImpl.rotintlft(this.field_221 + NTLMEngineImpl.method_76(this.field_222, this.field_219, this.field_220) + var1[6], 11);
         this.field_220 = NTLMEngineImpl.rotintlft(this.field_220 + NTLMEngineImpl.method_76(this.field_221, this.field_222, this.field_219) + var1[7], 19);
         this.field_219 = NTLMEngineImpl.rotintlft(this.field_219 + NTLMEngineImpl.method_76(this.field_220, this.field_221, this.field_222) + var1[8], 3);
         this.field_222 = NTLMEngineImpl.rotintlft(this.field_222 + NTLMEngineImpl.method_76(this.field_219, this.field_220, this.field_221) + var1[9], 7);
         this.field_221 = NTLMEngineImpl.rotintlft(this.field_221 + NTLMEngineImpl.method_76(this.field_222, this.field_219, this.field_220) + var1[10], 11);
         this.field_220 = NTLMEngineImpl.rotintlft(this.field_220 + NTLMEngineImpl.method_76(this.field_221, this.field_222, this.field_219) + var1[11], 19);
         this.field_219 = NTLMEngineImpl.rotintlft(this.field_219 + NTLMEngineImpl.method_76(this.field_220, this.field_221, this.field_222) + var1[12], 3);
         this.field_222 = NTLMEngineImpl.rotintlft(this.field_222 + NTLMEngineImpl.method_76(this.field_219, this.field_220, this.field_221) + var1[13], 7);
         this.field_221 = NTLMEngineImpl.rotintlft(this.field_221 + NTLMEngineImpl.method_76(this.field_222, this.field_219, this.field_220) + var1[14], 11);
         this.field_220 = NTLMEngineImpl.rotintlft(this.field_220 + NTLMEngineImpl.method_76(this.field_221, this.field_222, this.field_219) + var1[15], 19);
      }

      protected void round2(int[] var1) {
         this.field_219 = NTLMEngineImpl.rotintlft(1518500249 + this.field_219 + NTLMEngineImpl.method_77(this.field_220, this.field_221, this.field_222) + var1[0], 3);
         this.field_222 = NTLMEngineImpl.rotintlft(1518500249 + this.field_222 + NTLMEngineImpl.method_77(this.field_219, this.field_220, this.field_221) + var1[4], 5);
         this.field_221 = NTLMEngineImpl.rotintlft(1518500249 + this.field_221 + NTLMEngineImpl.method_77(this.field_222, this.field_219, this.field_220) + var1[8], 9);
         this.field_220 = NTLMEngineImpl.rotintlft(1518500249 + this.field_220 + NTLMEngineImpl.method_77(this.field_221, this.field_222, this.field_219) + var1[12], 13);
         this.field_219 = NTLMEngineImpl.rotintlft(1518500249 + this.field_219 + NTLMEngineImpl.method_77(this.field_220, this.field_221, this.field_222) + var1[1], 3);
         this.field_222 = NTLMEngineImpl.rotintlft(1518500249 + this.field_222 + NTLMEngineImpl.method_77(this.field_219, this.field_220, this.field_221) + var1[5], 5);
         this.field_221 = NTLMEngineImpl.rotintlft(1518500249 + this.field_221 + NTLMEngineImpl.method_77(this.field_222, this.field_219, this.field_220) + var1[9], 9);
         this.field_220 = NTLMEngineImpl.rotintlft(1518500249 + this.field_220 + NTLMEngineImpl.method_77(this.field_221, this.field_222, this.field_219) + var1[13], 13);
         this.field_219 = NTLMEngineImpl.rotintlft(1518500249 + this.field_219 + NTLMEngineImpl.method_77(this.field_220, this.field_221, this.field_222) + var1[2], 3);
         this.field_222 = NTLMEngineImpl.rotintlft(1518500249 + this.field_222 + NTLMEngineImpl.method_77(this.field_219, this.field_220, this.field_221) + var1[6], 5);
         this.field_221 = NTLMEngineImpl.rotintlft(1518500249 + this.field_221 + NTLMEngineImpl.method_77(this.field_222, this.field_219, this.field_220) + var1[10], 9);
         this.field_220 = NTLMEngineImpl.rotintlft(1518500249 + this.field_220 + NTLMEngineImpl.method_77(this.field_221, this.field_222, this.field_219) + var1[14], 13);
         this.field_219 = NTLMEngineImpl.rotintlft(1518500249 + this.field_219 + NTLMEngineImpl.method_77(this.field_220, this.field_221, this.field_222) + var1[3], 3);
         this.field_222 = NTLMEngineImpl.rotintlft(1518500249 + this.field_222 + NTLMEngineImpl.method_77(this.field_219, this.field_220, this.field_221) + var1[7], 5);
         this.field_221 = NTLMEngineImpl.rotintlft(1518500249 + this.field_221 + NTLMEngineImpl.method_77(this.field_222, this.field_219, this.field_220) + var1[11], 9);
         this.field_220 = NTLMEngineImpl.rotintlft(1518500249 + this.field_220 + NTLMEngineImpl.method_77(this.field_221, this.field_222, this.field_219) + var1[15], 13);
      }

      protected void round3(int[] var1) {
         this.field_219 = NTLMEngineImpl.rotintlft(1859775393 + this.field_219 + NTLMEngineImpl.method_78(this.field_220, this.field_221, this.field_222) + var1[0], 3);
         this.field_222 = NTLMEngineImpl.rotintlft(1859775393 + this.field_222 + NTLMEngineImpl.method_78(this.field_219, this.field_220, this.field_221) + var1[8], 9);
         this.field_221 = NTLMEngineImpl.rotintlft(1859775393 + this.field_221 + NTLMEngineImpl.method_78(this.field_222, this.field_219, this.field_220) + var1[4], 11);
         this.field_220 = NTLMEngineImpl.rotintlft(1859775393 + this.field_220 + NTLMEngineImpl.method_78(this.field_221, this.field_222, this.field_219) + var1[12], 15);
         this.field_219 = NTLMEngineImpl.rotintlft(1859775393 + this.field_219 + NTLMEngineImpl.method_78(this.field_220, this.field_221, this.field_222) + var1[2], 3);
         this.field_222 = NTLMEngineImpl.rotintlft(1859775393 + this.field_222 + NTLMEngineImpl.method_78(this.field_219, this.field_220, this.field_221) + var1[10], 9);
         this.field_221 = NTLMEngineImpl.rotintlft(1859775393 + this.field_221 + NTLMEngineImpl.method_78(this.field_222, this.field_219, this.field_220) + var1[6], 11);
         this.field_220 = NTLMEngineImpl.rotintlft(1859775393 + this.field_220 + NTLMEngineImpl.method_78(this.field_221, this.field_222, this.field_219) + var1[14], 15);
         this.field_219 = NTLMEngineImpl.rotintlft(1859775393 + this.field_219 + NTLMEngineImpl.method_78(this.field_220, this.field_221, this.field_222) + var1[1], 3);
         this.field_222 = NTLMEngineImpl.rotintlft(1859775393 + this.field_222 + NTLMEngineImpl.method_78(this.field_219, this.field_220, this.field_221) + var1[9], 9);
         this.field_221 = NTLMEngineImpl.rotintlft(1859775393 + this.field_221 + NTLMEngineImpl.method_78(this.field_222, this.field_219, this.field_220) + var1[5], 11);
         this.field_220 = NTLMEngineImpl.rotintlft(1859775393 + this.field_220 + NTLMEngineImpl.method_78(this.field_221, this.field_222, this.field_219) + var1[13], 15);
         this.field_219 = NTLMEngineImpl.rotintlft(1859775393 + this.field_219 + NTLMEngineImpl.method_78(this.field_220, this.field_221, this.field_222) + var1[3], 3);
         this.field_222 = NTLMEngineImpl.rotintlft(1859775393 + this.field_222 + NTLMEngineImpl.method_78(this.field_219, this.field_220, this.field_221) + var1[11], 9);
         this.field_221 = NTLMEngineImpl.rotintlft(1859775393 + this.field_221 + NTLMEngineImpl.method_78(this.field_222, this.field_219, this.field_220) + var1[7], 11);
         this.field_220 = NTLMEngineImpl.rotintlft(1859775393 + this.field_220 + NTLMEngineImpl.method_78(this.field_221, this.field_222, this.field_219) + var1[15], 15);
      }

      void update(byte[] var1) {
         int var2 = (int)(63L & this.count);

         int var3;
         for(var3 = 0; var2 + (var1.length - var3) >= this.dataBuffer.length; var2 = 0) {
            int var6 = this.dataBuffer.length - var2;
            System.arraycopy(var1, var3, this.dataBuffer, var2, var6);
            this.count += (long)var6;
            var3 += var6;
            this.processBuffer();
         }

         if(var3 < var1.length) {
            int var4 = var1.length - var3;
            System.arraycopy(var1, var3, this.dataBuffer, var2, var4);
            this.count += (long)var4;
            int var10000 = var2 + var4;
         }

      }
   }

   static class NTLMMessage {
      private int currentOutputPosition = 0;
      private byte[] messageContents = null;

      NTLMMessage() {
      }

      NTLMMessage(String var1, int var2) throws NTLMEngineException {
         this.messageContents = Base64.decode(EncodingUtils.getBytes(var1, "ASCII"), 2);
         if(this.messageContents.length < NTLMEngineImpl.SIGNATURE.length) {
            throw new NTLMEngineException("NTLM message decoding error - packet too short");
         } else {
            for(int var3 = 0; var3 < NTLMEngineImpl.SIGNATURE.length; ++var3) {
               if(this.messageContents[var3] != NTLMEngineImpl.SIGNATURE[var3]) {
                  throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
               }
            }

            int var4 = this.readULong(NTLMEngineImpl.SIGNATURE.length);
            if(var4 != var2) {
               throw new NTLMEngineException("NTLM type " + Integer.toString(var2) + " message expected - instead got type " + Integer.toString(var4));
            } else {
               this.currentOutputPosition = this.messageContents.length;
            }
         }
      }

      protected void addByte(byte var1) {
         this.messageContents[this.currentOutputPosition] = var1;
         ++this.currentOutputPosition;
      }

      protected void addBytes(byte[] var1) {
         if(var1 != null) {
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
               byte var4 = var1[var3];
               this.messageContents[this.currentOutputPosition] = var4;
               ++this.currentOutputPosition;
            }
         }

      }

      protected void addULong(int var1) {
         this.addByte((byte)(var1 & 255));
         this.addByte((byte)(255 & var1 >> 8));
         this.addByte((byte)(255 & var1 >> 16));
         this.addByte((byte)(255 & var1 >> 24));
      }

      protected void addUShort(int var1) {
         this.addByte((byte)(var1 & 255));
         this.addByte((byte)(255 & var1 >> 8));
      }

      protected int getMessageLength() {
         return this.currentOutputPosition;
      }

      String getResponse() {
         byte[] var1;
         if(this.messageContents.length > this.currentOutputPosition) {
            byte[] var2 = new byte[this.currentOutputPosition];
            System.arraycopy(this.messageContents, 0, var2, 0, this.currentOutputPosition);
            var1 = var2;
         } else {
            var1 = this.messageContents;
         }

         return EncodingUtils.getAsciiString(Base64.encode(var1, 2));
      }

      protected void prepareResponse(int var1, int var2) {
         this.messageContents = new byte[var1];
         this.currentOutputPosition = 0;
         this.addBytes(NTLMEngineImpl.SIGNATURE);
         this.addULong(var2);
      }

      protected void readBytes(byte[] var1, int var2) throws NTLMEngineException {
         if(this.messageContents.length < var2 + var1.length) {
            throw new NTLMEngineException("NTLM: Message too short");
         } else {
            System.arraycopy(this.messageContents, var2, var1, 0, var1.length);
         }
      }

      protected byte[] readSecurityBuffer(int var1) throws NTLMEngineException {
         return NTLMEngineImpl.readSecurityBuffer(this.messageContents, var1);
      }

      protected int readULong(int var1) throws NTLMEngineException {
         return NTLMEngineImpl.readULong(this.messageContents, var1);
      }
   }

   static class Type1Message extends NTLMEngineImpl.NTLMMessage {
      protected byte[] domainBytes;
      protected byte[] hostBytes;

      Type1Message(String param1, String param2) throws NTLMEngineException {
         // $FF: Couldn't be decompiled
      }

      String getResponse() {
         this.prepareResponse(40, 1);
         this.addULong(-1576500735);
         this.addUShort(0);
         this.addUShort(0);
         this.addULong(40);
         this.addUShort(0);
         this.addUShort(0);
         this.addULong(40);
         this.addUShort(261);
         this.addULong(2600);
         this.addUShort(3840);
         return super.getResponse();
      }
   }

   static class Type2Message extends NTLMEngineImpl.NTLMMessage {
      protected byte[] challenge = new byte[8];
      protected int flags;
      protected String target;
      protected byte[] targetInfo;

      Type2Message(String var1) throws NTLMEngineException {
         super(var1, 2);
         this.readBytes(this.challenge, 24);
         this.flags = this.readULong(20);
         if((1 & this.flags) == 0) {
            throw new NTLMEngineException("NTLM type 2 message indicates no support for Unicode. Flags are: " + Integer.toString(this.flags));
         } else {
            this.target = null;
            if(this.getMessageLength() >= 20) {
               byte[] var3 = this.readSecurityBuffer(12);
               if(var3.length != 0) {
                  try {
                     this.target = new String(var3, "UnicodeLittleUnmarked");
                  } catch (UnsupportedEncodingException var5) {
                     throw new NTLMEngineException(var5.getMessage(), var5);
                  }
               }
            }

            this.targetInfo = null;
            if(this.getMessageLength() >= 48) {
               byte[] var2 = this.readSecurityBuffer(40);
               if(var2.length != 0) {
                  this.targetInfo = var2;
               }
            }

         }
      }

      byte[] getChallenge() {
         return this.challenge;
      }

      int getFlags() {
         return this.flags;
      }

      String getTarget() {
         return this.target;
      }

      byte[] getTargetInfo() {
         return this.targetInfo;
      }
   }

   static class Type3Message extends NTLMEngineImpl.NTLMMessage {
      protected byte[] domainBytes;
      protected byte[] hostBytes;
      protected byte[] lmResp;
      protected byte[] ntResp;
      protected byte[] sessionKey;
      protected int type2Flags;
      protected byte[] userBytes;

      Type3Message(String param1, String param2, String param3, String param4, byte[] param5, int param6, String param7, byte[] param8) throws NTLMEngineException {
         // $FF: Couldn't be decompiled
      }

      String getResponse() {
         int var1 = this.ntResp.length;
         int var2 = this.lmResp.length;
         int var3;
         if(this.domainBytes != null) {
            var3 = this.domainBytes.length;
         } else {
            var3 = 0;
         }

         int var4;
         if(this.hostBytes != null) {
            var4 = this.hostBytes.length;
         } else {
            var4 = 0;
         }

         int var5 = this.userBytes.length;
         int var6;
         if(this.sessionKey != null) {
            var6 = this.sessionKey.length;
         } else {
            var6 = 0;
         }

         int var7 = var2 + 72;
         int var8 = var7 + var1;
         int var9 = var8 + var3;
         int var10 = var9 + var5;
         int var11 = var10 + var4;
         this.prepareResponse(var11 + var6, 3);
         this.addUShort(var2);
         this.addUShort(var2);
         this.addULong(72);
         this.addUShort(var1);
         this.addUShort(var1);
         this.addULong(var7);
         this.addUShort(var3);
         this.addUShort(var3);
         this.addULong(var8);
         this.addUShort(var5);
         this.addUShort(var5);
         this.addULong(var9);
         this.addUShort(var4);
         this.addUShort(var4);
         this.addULong(var10);
         this.addUShort(var6);
         this.addUShort(var6);
         this.addULong(var11);
         this.addULong(33554432 | 128 & this.type2Flags | 512 & this.type2Flags | 524288 & this.type2Flags | '耀' & this.type2Flags | 32 & this.type2Flags | 16 & this.type2Flags | 536870912 & this.type2Flags | Integer.MIN_VALUE & this.type2Flags | 1073741824 & this.type2Flags | 8388608 & this.type2Flags | 1 & this.type2Flags | 4 & this.type2Flags);
         this.addUShort(261);
         this.addULong(2600);
         this.addUShort(3840);
         this.addBytes(this.lmResp);
         this.addBytes(this.ntResp);
         this.addBytes(this.domainBytes);
         this.addBytes(this.userBytes);
         this.addBytes(this.hostBytes);
         if(this.sessionKey != null) {
            this.addBytes(this.sessionKey);
         }

         return super.getResponse();
      }
   }
}
