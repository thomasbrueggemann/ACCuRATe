package com.google.android.gms.internal;

import com.google.android.gms.internal.class_65;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

// $FF: renamed from: com.google.android.gms.internal.p
public class class_454 {
   // $FF: renamed from: jQ com.google.android.gms.internal.n
   private final class_65 field_2735;
   // $FF: renamed from: kj java.security.SecureRandom
   private final SecureRandom field_2736;

   public class_454(class_65 var1, SecureRandom var2) {
      this.field_2735 = var1;
      this.field_2736 = var2;
   }

   // $FF: renamed from: c (byte[]) void
   static void method_2811(byte[] var0) {
      for(int var1 = 0; var1 < var0.length; ++var1) {
         var0[var1] = (byte)(68 ^ var0[var1]);
      }

   }

   // $FF: renamed from: b (java.lang.String) byte[]
   public byte[] method_2812(String var1) throws class_454.class_1168 {
      try {
         byte[] var3 = this.field_2735.method_339(var1, false);
         if(var3.length != 32) {
            throw new class_454.class_1168();
         } else {
            ByteBuffer var4 = ByteBuffer.wrap(var3, 4, 16);
            byte[] var5 = new byte[16];
            var4.get(var5);
            method_2811(var5);
            return var5;
         }
      } catch (IllegalArgumentException var6) {
         throw new class_454.class_1168(var6);
      }
   }

   // $FF: renamed from: c (byte[], java.lang.String) byte[]
   public byte[] method_2813(byte[] var1, String var2) throws class_454.class_1168 {
      if(var1.length != 16) {
         throw new class_454.class_1168();
      } else {
         try {
            byte[] var10 = this.field_2735.method_339(var2, false);
            if(var10.length <= 16) {
               throw new class_454.class_1168();
            } else {
               ByteBuffer var11 = ByteBuffer.allocate(var10.length);
               var11.put(var10);
               var11.flip();
               byte[] var14 = new byte[16];
               byte[] var15 = new byte[-16 + var10.length];
               var11.get(var14);
               var11.get(var15);
               SecretKeySpec var18 = new SecretKeySpec(var1, "AES");
               Cipher var19 = Cipher.getInstance("AES/CBC/PKCS5Padding");
               var19.init(2, var18, new IvParameterSpec(var14));
               byte[] var20 = var19.doFinal(var15);
               return var20;
            }
         } catch (NoSuchAlgorithmException var21) {
            throw new class_454.class_1168(var21);
         } catch (InvalidKeyException var22) {
            throw new class_454.class_1168(var22);
         } catch (IllegalBlockSizeException var23) {
            throw new class_454.class_1168(var23);
         } catch (NoSuchPaddingException var24) {
            throw new class_454.class_1168(var24);
         } catch (BadPaddingException var25) {
            throw new class_454.class_1168(var25);
         } catch (InvalidAlgorithmParameterException var26) {
            throw new class_454.class_1168(var26);
         } catch (IllegalArgumentException var27) {
            throw new class_454.class_1168(var27);
         }
      }
   }

   public class class_1168 extends Exception {
      public class_1168() {
      }

      public class_1168(Throwable var2) {
         super(var2);
      }
   }
}
