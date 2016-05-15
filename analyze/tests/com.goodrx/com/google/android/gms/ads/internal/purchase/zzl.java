package com.google.android.gms.ads.internal.purchase;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

@zzhb
public class zzl {
   public static boolean zza(PublicKey var0, String var1, String var2) {
      try {
         Signature var6 = Signature.getInstance("SHA1withRSA");
         var6.initVerify(var0);
         var6.update(var1.getBytes());
         if(!var6.verify(Base64.decode(var2, 0))) {
            zzin.e("Signature verification failed.");
            return false;
         } else {
            return true;
         }
      } catch (NoSuchAlgorithmException var7) {
         zzin.e("NoSuchAlgorithmException.");
         return false;
      } catch (InvalidKeyException var8) {
         zzin.e("Invalid key specification.");
         return false;
      } catch (SignatureException var9) {
         zzin.e("Signature exception.");
         return false;
      }
   }

   public static PublicKey zzas(String var0) {
      try {
         byte[] var3 = Base64.decode(var0, 0);
         PublicKey var4 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(var3));
         return var4;
      } catch (NoSuchAlgorithmException var5) {
         throw new RuntimeException(var5);
      } catch (InvalidKeySpecException var6) {
         zzin.e("Invalid key specification.");
         throw new IllegalArgumentException(var6);
      }
   }

   public static boolean zzc(String var0, String var1, String var2) {
      if(!TextUtils.isEmpty(var1) && !TextUtils.isEmpty(var0) && !TextUtils.isEmpty(var2)) {
         return zza(zzas(var0), var1, var2);
      } else {
         zzin.e("Purchase verification failed: missing data.");
         return false;
      }
   }
}
