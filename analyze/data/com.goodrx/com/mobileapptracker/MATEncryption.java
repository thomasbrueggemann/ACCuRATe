package com.mobileapptracker;

import com.mobileapptracker.MATUtils;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MATEncryption {
   private Cipher cipher;
   private IvParameterSpec ivspec;
   private SecretKeySpec keyspec;

   public MATEncryption(String var1, String var2) {
      this.ivspec = new IvParameterSpec(var2.getBytes());
      this.keyspec = new SecretKeySpec(var1.getBytes(), "AES");

      try {
         this.cipher = Cipher.getInstance("AES/CBC/NoPadding");
      } catch (NoSuchAlgorithmException var5) {
         var5.printStackTrace();
      } catch (NoSuchPaddingException var6) {
         var6.printStackTrace();
      }
   }

   private static String padString(String var0) {
      int var1 = 16 - var0.length() % 16;

      for(int var2 = 0; var2 < var1; ++var2) {
         var0 = var0 + ' ';
      }

      return var0;
   }

   public byte[] decrypt(String var1) throws Exception {
      if(var1 != null && var1.length() != 0) {
         try {
            this.cipher.init(2, this.keyspec, this.ivspec);
            byte[] var3 = this.cipher.doFinal(MATUtils.hexToBytes(var1));
            return var3;
         } catch (Exception var4) {
            throw new Exception("[decrypt] " + var4.getMessage());
         }
      } else {
         throw new Exception("Empty string");
      }
   }

   public byte[] encrypt(String var1) throws Exception {
      if(var1 != null && var1.length() != 0) {
         try {
            this.cipher.init(1, this.keyspec, this.ivspec);
            byte[] var3 = this.cipher.doFinal(padString(var1).getBytes());
            return var3;
         } catch (Exception var4) {
            throw new Exception("[encrypt] " + var4.getMessage());
         }
      } else {
         throw new Exception("Empty string");
      }
   }
}
