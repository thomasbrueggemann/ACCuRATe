package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzro;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzf {
   private final Account zzTI;
   private final String zzUW;
   private final Set<Scope> zzagh;
   private final int zzagj;
   private final View zzagk;
   private final String zzagl;
   private final Set<Scope> zzalb;
   private final Map<Api<?>, zzf.zza> zzalc;
   private final zzro zzald;
   private Integer zzale;

   public zzf(Account var1, Set<Scope> var2, Map<Api<?>, zzf.zza> var3, int var4, View var5, String var6, String var7, zzro var8) {
      this.zzTI = var1;
      Set var9;
      if(var2 == null) {
         var9 = Collections.EMPTY_SET;
      } else {
         var9 = Collections.unmodifiableSet(var2);
      }

      this.zzagh = var9;
      if(var3 == null) {
         var3 = Collections.EMPTY_MAP;
      }

      this.zzalc = var3;
      this.zzagk = var5;
      this.zzagj = var4;
      this.zzUW = var6;
      this.zzagl = var7;
      this.zzald = var8;
      HashSet var10 = new HashSet(this.zzagh);
      Iterator var11 = this.zzalc.values().iterator();

      while(var11.hasNext()) {
         var10.addAll(((zzf.zza)var11.next()).zzXf);
      }

      this.zzalb = Collections.unmodifiableSet(var10);
   }

   public static zzf zzat(Context var0) {
      return (new GoogleApiClient.Builder(var0)).zzoY();
   }

   public Account getAccount() {
      return this.zzTI;
   }

   @Deprecated
   public String getAccountName() {
      return this.zzTI != null?this.zzTI.name:null;
   }

   public void zza(Integer var1) {
      this.zzale = var1;
   }

   public Set<Scope> zzb(Api<?> var1) {
      zzf.zza var2 = (zzf.zza)this.zzalc.get(var1);
      if(var2 != null && !var2.zzXf.isEmpty()) {
         HashSet var3 = new HashSet(this.zzagh);
         var3.addAll(var2.zzXf);
         return var3;
      } else {
         return this.zzagh;
      }
   }

   public Account zzqq() {
      return this.zzTI != null?this.zzTI:new Account("<<default account>>", "com.google");
   }

   public Set<Scope> zzqs() {
      return this.zzagh;
   }

   public Set<Scope> zzqt() {
      return this.zzalb;
   }

   public Map<Api<?>, zzf.zza> zzqu() {
      return this.zzalc;
   }

   public String zzqv() {
      return this.zzUW;
   }

   public String zzqw() {
      return this.zzagl;
   }

   public zzro zzqy() {
      return this.zzald;
   }

   public Integer zzqz() {
      return this.zzale;
   }

   public static final class zza {
      public final Set<Scope> zzXf;
      public final boolean zzalf;
   }
}
