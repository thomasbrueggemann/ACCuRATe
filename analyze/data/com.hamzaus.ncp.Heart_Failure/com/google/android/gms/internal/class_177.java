package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.class_156;
import com.google.android.gms.dynamic.class_176;
import com.google.android.gms.dynamic.class_741;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.class_125;
import com.google.android.gms.internal.class_126;
import com.google.android.gms.internal.class_128;
import com.google.android.gms.internal.lo;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

// $FF: renamed from: com.google.android.gms.internal.lt
public class class_177 extends g<lo> {
   private static class_177 akK;

   protected class_177() {
      super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
   }

   // $FF: renamed from: a (android.app.Activity, com.google.android.gms.dynamic.c, com.google.android.gms.wallet.fragment.WalletFragmentOptions, com.google.android.gms.internal.lm) com.google.android.gms.internal.ll
   public static class_125 method_1278(Activity var0, class_156 var1, WalletFragmentOptions var2, class_126 var3) throws GooglePlayServicesNotAvailableException {
      int var4 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0);
      if(var4 != 0) {
         throw new GooglePlayServicesNotAvailableException(var4);
      } else {
         try {
            class_125 var7 = ((class_128)method_1279().D(var0)).method_695(class_741.method_4178(var0), var1, var2, var3);
            return var7;
         } catch (RemoteException var8) {
            throw new RuntimeException(var8);
         } catch (class_176.class_1202 var9) {
            throw new RuntimeException(var9);
         }
      }
   }

   // $FF: renamed from: ne () com.google.android.gms.internal.lt
   private static class_177 method_1279() {
      if(akK == null) {
         akK = new class_177();
      }

      return akK;
   }

   // $FF: renamed from: bv (android.os.IBinder) com.google.android.gms.internal.lo
   protected class_128 method_1280(IBinder var1) {
      return class_128.class_1079.method_4346(var1);
   }

   // $FF: renamed from: d (android.os.IBinder) java.lang.Object
   // $FF: synthetic method
   protected Object method_1277(IBinder var1) {
      return this.method_1280(var1);
   }
}
