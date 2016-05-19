package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlf;
import com.google.android.gms.internal.zzlh;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zzk {
   private final Map<com.google.android.gms.auth.api.signin.zzd, zzlf> zzXD;

   public zzk(Activity var1, List<com.google.android.gms.auth.api.signin.zzd> var2, Map<com.google.android.gms.auth.api.signin.zzd, List<String>> var3) {
      zzx.zzz(var1);
      zzx.zzz(var2);
      zzx.zzz(var3);
      HashMap var7 = new HashMap();
      Iterator var8 = var2.iterator();

      while(var8.hasNext()) {
         com.google.android.gms.auth.api.signin.zzd var9 = (com.google.android.gms.auth.api.signin.zzd)var8.next();
         List var10 = (List)var3.get(var9);
         if(var10 == null) {
            var10 = Collections.emptyList();
         }

         zzlf var11 = this.zza(var9, var1, var10);
         if(var11 != null) {
            var7.put(var9, var11);
         }
      }

      this.zzXD = Collections.unmodifiableMap(var7);
   }

   private zzlf zza(com.google.android.gms.auth.api.signin.zzd var1, Activity var2, List<String> var3) {
      return com.google.android.gms.auth.api.signin.zzd.zzXi.equals(var1)?new zzlh(var2, var3):null;
   }

   public zzlf zza(com.google.android.gms.auth.api.signin.zzd var1) {
      zzx.zzz(var1);
      return (zzlf)this.zzXD.get(var1);
   }

   public Collection<zzlf> zznh() {
      return this.zzXD.values();
   }
}
