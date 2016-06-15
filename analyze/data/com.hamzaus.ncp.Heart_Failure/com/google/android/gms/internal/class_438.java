package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.internal.class_370;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

// $FF: renamed from: com.google.android.gms.internal.db
public class class_438 {
   // $FF: renamed from: a (java.security.PublicKey, java.lang.String, java.lang.String) boolean
   public static boolean method_2668(PublicKey var0, String var1, String var2) {
      try {
         Signature var6 = Signature.getInstance("SHA1withRSA");
         var6.initVerify(var0);
         var6.update(var1.getBytes());
         if(!var6.verify(Base64.decode(var2, 0))) {
            class_370.method_2355("Signature verification failed.");
            return false;
         } else {
            return true;
         }
      } catch (NoSuchAlgorithmException var7) {
         class_370.method_2355("NoSuchAlgorithmException.");
         return false;
      } catch (InvalidKeyException var8) {
         class_370.method_2355("Invalid key specification.");
         return false;
      } catch (SignatureException var9) {
         class_370.method_2355("Signature exception.");
         return false;
      }
   }

   // $FF: renamed from: b (java.lang.String, java.lang.String, java.lang.String) boolean
   public static boolean method_2669(String var0, String var1, String var2) {
      if(!TextUtils.isEmpty(var1) && !TextUtils.isEmpty(var0) && !TextUtils.isEmpty(var2)) {
         return method_2668(method_2670(var0), var1, var2);
      } else {
         class_370.method_2355("Purchase verification failed: missing data.");
         return false;
      }
   }

   // $FF: renamed from: r (java.lang.String) java.security.PublicKey
   public static PublicKey method_2670(String var0) {
      try {
         byte[] var3 = Base64.decode(var0, 0);
         PublicKey var4 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(var3));
         return var4;
      } catch (NoSuchAlgorithmException var5) {
         throw new RuntimeException(var5);
      } catch (InvalidKeySpecException var6) {
         class_370.method_2355("Invalid key specification.");
         throw new IllegalArgumentException(var6);
      }
   }
}
