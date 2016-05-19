package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.lang.reflect.Method;

@zzhb
public class zzb {
   private final Context mContext;
   private final boolean zzFA;
   Object zzFz;

   public zzb(Context var1) {
      this(var1, true);
   }

   public zzb(Context var1, boolean var2) {
      this.mContext = var1;
      this.zzFA = var2;
   }

   public void destroy() {
      this.zzFz = null;
   }

   public void zzN(IBinder var1) {
      try {
         this.zzFz = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke((Object)null, new Object[]{var1});
      } catch (Exception var3) {
         if(this.zzFA) {
            zzin.zzaK("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
            return;
         }
      }

   }

   public Bundle zzb(String var1, String var2, String var3) {
      try {
         Class var5 = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
         Class[] var6 = new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class};
         Method var7 = var5.getDeclaredMethod("getBuyIntent", var6);
         Object var8 = var5.cast(this.zzFz);
         Object[] var9 = new Object[]{Integer.valueOf(3), var1, var2, "inapp", var3};
         Bundle var10 = (Bundle)var7.invoke(var8, var9);
         return var10;
      } catch (Exception var11) {
         if(this.zzFA) {
            zzin.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", var11);
         }

         return null;
      }
   }
}
