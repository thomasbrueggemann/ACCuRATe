package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.ey;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

// $FF: renamed from: com.google.android.gms.internal.el
@ey
public class class_416 {
   // $FF: renamed from: F (java.lang.String) java.security.PublicKey
   public static PublicKey method_2750(String var0) {
      try {
         byte[] var3 = Base64.decode(var0, 0);
         PublicKey var4 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(var3));
         return var4;
      } catch (NoSuchAlgorithmException var5) {
         throw new RuntimeException(var5);
      } catch (InvalidKeySpecException var6) {
         class_368.method_2503("Invalid key specification.");
         throw new IllegalArgumentException(var6);
      }
   }

   // $FF: renamed from: a (java.security.PublicKey, java.lang.String, java.lang.String) boolean
   public static boolean method_2751(PublicKey var0, String var1, String var2) {
      try {
         Signature var6 = Signature.getInstance("SHA1withRSA");
         var6.initVerify(var0);
         var6.update(var1.getBytes());
         if(!var6.verify(Base64.decode(var2, 0))) {
            class_368.method_2503("Signature verification failed.");
            return false;
         } else {
            return true;
         }
      } catch (NoSuchAlgorithmException var7) {
         class_368.method_2503("NoSuchAlgorithmException.");
         return false;
      } catch (InvalidKeyException var8) {
         class_368.method_2503("Invalid key specification.");
         return false;
      } catch (SignatureException var9) {
         class_368.method_2503("Signature exception.");
         return false;
      }
   }

   // $FF: renamed from: b (java.lang.String, java.lang.String, java.lang.String) boolean
   public static boolean method_2752(String var0, String var1, String var2) {
      if(!TextUtils.isEmpty(var1) && !TextUtils.isEmpty(var0) && !TextUtils.isEmpty(var2)) {
         return method_2751(method_2750(var0), var1, var2);
      } else {
         class_368.method_2503("Purchase verification failed: missing data.");
         return false;
      }
   }
}
