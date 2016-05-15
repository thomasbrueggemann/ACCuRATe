package com.google.android.gms.iid;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class zza {
   public static KeyPair zzyy() {
      try {
         KeyPairGenerator var1 = KeyPairGenerator.getInstance("RSA");
         var1.initialize(2048);
         KeyPair var2 = var1.generateKeyPair();
         return var2;
      } catch (NoSuchAlgorithmException var3) {
         throw new AssertionError(var3);
      }
   }
}
