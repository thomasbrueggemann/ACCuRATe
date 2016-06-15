package com.smartmobilesoftware.util;

import android.text.TextUtils;
import android.util.Log;
import com.smartmobilesoftware.util.Base64;
import com.smartmobilesoftware.util.Base64DecoderException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class Security {
   private static final String KEY_FACTORY_ALGORITHM = "RSA";
   private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
   private static final String TAG = "IABUtil/Security";

   public static PublicKey generatePublicKey(String var0) {
      try {
         byte[] var6 = Base64.decode(var0);
         PublicKey var7 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(var6));
         return var7;
      } catch (NoSuchAlgorithmException var8) {
         throw new RuntimeException(var8);
      } catch (InvalidKeySpecException var9) {
         Log.e("IABUtil/Security", "Invalid key specification.");
         throw new IllegalArgumentException(var9);
      } catch (Base64DecoderException var10) {
         Log.e("IABUtil/Security", "Base64 decoding failed.");
         throw new IllegalArgumentException(var10);
      }
   }

   public static boolean verify(PublicKey var0, String var1, String var2) {
      try {
         Signature var11 = Signature.getInstance("SHA1withRSA");
         var11.initVerify(var0);
         var11.update(var1.getBytes());
         if(!var11.verify(Base64.decode(var2))) {
            Log.e("IABUtil/Security", "Signature verification failed.");
            return false;
         } else {
            return true;
         }
      } catch (NoSuchAlgorithmException var12) {
         Log.e("IABUtil/Security", "NoSuchAlgorithmException.");
         return false;
      } catch (InvalidKeyException var13) {
         Log.e("IABUtil/Security", "Invalid key specification.");
         return false;
      } catch (SignatureException var14) {
         Log.e("IABUtil/Security", "Signature exception.");
         return false;
      } catch (Base64DecoderException var15) {
         Log.e("IABUtil/Security", "Base64 decoding failed.");
         return false;
      }
   }

   public static boolean verifyPurchase(String var0, String var1, String var2) {
      if(!TextUtils.isEmpty(var1) && !TextUtils.isEmpty(var0) && !TextUtils.isEmpty(var2)) {
         return verify(generatePublicKey(var0), var1, var2);
      } else {
         Log.e("IABUtil/Security", "Purchase verification failed: missing data.");
         return false;
      }
   }
}
