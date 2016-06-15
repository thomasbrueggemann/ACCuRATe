package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.class_197;
import com.google.android.gms.dynamic.class_211;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.class_157;
import com.google.android.gms.internal.class_158;
import com.google.android.gms.internal.class_160;
import com.google.android.gms.internal.qd;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

// $FF: renamed from: com.google.android.gms.internal.qi
public class class_213 extends g<qd> {
   private static class_213 awH;

   protected class_213() {
      super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
   }

   // $FF: renamed from: a (android.app.Activity, com.google.android.gms.dynamic.c, com.google.android.gms.wallet.fragment.WalletFragmentOptions, com.google.android.gms.internal.qb) com.google.android.gms.internal.qa
   public static class_157 method_1514(Activity var0, class_197 var1, WalletFragmentOptions var2, class_158 var3) throws GooglePlayServicesNotAvailableException {
      int var4 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0);
      if(var4 != 0) {
         throw new GooglePlayServicesNotAvailableException(var4);
      } else {
         try {
            class_157 var7 = ((class_160)method_1515().L(var0)).method_835(class_960.method_5293(var0), var1, var2, var3);
            return var7;
         } catch (RemoteException var8) {
            throw new RuntimeException(var8);
         } catch (class_211.class_1565 var9) {
            throw new RuntimeException(var9);
         }
      }
   }

   // $FF: renamed from: rg () com.google.android.gms.internal.qi
   private static class_213 method_1515() {
      if(awH == null) {
         awH = new class_213();
      }

      return awH;
   }

   // $FF: renamed from: bW (android.os.IBinder) com.google.android.gms.internal.qd
   protected class_160 method_1516(IBinder var1) {
      return class_160.class_1082.method_4101(var1);
   }

   // $FF: renamed from: d (android.os.IBinder) java.lang.Object
   // $FF: synthetic method
   protected Object method_1511(IBinder var1) {
      return this.method_1516(var1);
   }
}
