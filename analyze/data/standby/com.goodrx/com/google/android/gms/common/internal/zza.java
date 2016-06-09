package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzp;

public class zza extends zzp.zza {
   private Context mContext;
   private Account zzTI;
   int zzakz;

   public static Account zza(zzp var0) {
      Account var1 = null;
      if(var0 != null) {
         long var2 = Binder.clearCallingIdentity();
         boolean var10 = false;

         Account var7;
         label52: {
            try {
               var10 = true;
               var7 = var0.getAccount();
               var10 = false;
               break label52;
            } catch (RemoteException var11) {
               Log.w("AccountAccessor", "Remote account accessor probably died");
               var10 = false;
            } finally {
               if(var10) {
                  Binder.restoreCallingIdentity(var2);
               }
            }

            Binder.restoreCallingIdentity(var2);
            return null;
         }

         var1 = var7;
         Binder.restoreCallingIdentity(var2);
      }

      return var1;
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof zza)?false:this.zzTI.equals(((zza)var1).zzTI));
   }

   public Account getAccount() {
      int var1 = Binder.getCallingUid();
      if(var1 == this.zzakz) {
         return this.zzTI;
      } else if(com.google.android.gms.common.zze.zzf(this.mContext, var1)) {
         this.zzakz = var1;
         return this.zzTI;
      } else {
         throw new SecurityException("Caller is not GooglePlayServices");
      }
   }
}
