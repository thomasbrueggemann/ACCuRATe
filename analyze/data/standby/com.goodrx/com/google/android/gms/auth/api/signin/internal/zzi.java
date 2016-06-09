package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class zzi {
   public static void zza(SignInConfiguration var0, List<com.google.android.gms.auth.api.signin.zzd> var1, Map<com.google.android.gms.auth.api.signin.zzd, List<String>> var2) {
      zzx.zzz(var0);
      zzx.zzz(var1);
      zzx.zzz(var2);
      GoogleSignInOptions var6 = var0.zznm();
      if(var6 != null) {
         var1.add(com.google.android.gms.auth.api.signin.zzd.zzXh);
         LinkedList var8 = new LinkedList();
         Iterator var9 = var6.zzmN().iterator();

         while(var9.hasNext()) {
            var8.add(((Scope)var9.next()).zzpb());
         }

         var2.put(com.google.android.gms.auth.api.signin.zzd.zzXh, var8);
      }

   }
}
