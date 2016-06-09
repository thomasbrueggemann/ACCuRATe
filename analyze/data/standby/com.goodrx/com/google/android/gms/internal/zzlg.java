package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.internal.zzlf;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class zzlg implements zzlf {
   protected final Activity mActivity;
   private String zzWP;
   private String zzXT;
   protected final Set<String> zzXf;
   private zzlf.zza zzYe;

   protected zzlg(Activity var1, List<String> var2, List<String> var3) {
      this.mActivity = (Activity)com.google.android.gms.common.internal.zzx.zzz(var1);
      HashSet var4 = new HashSet((Collection)com.google.android.gms.common.internal.zzx.zzz(var2));
      var4.addAll((Collection)com.google.android.gms.common.internal.zzx.zzz(var3));
      this.zzXf = Collections.unmodifiableSet(var4);
   }

   protected Intent zza(IdpTokenType var1, String var2, String var3) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      com.google.android.gms.common.internal.zzx.zzcM(var2);
      Intent var6 = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
      var6.putExtra("idpTokenType", var1);
      var6.putExtra("idpToken", var2);
      var6.putExtra("pendingToken", var3);
      com.google.android.gms.auth.api.signin.zzd var10 = this.zzmU();
      if(var10 != null) {
         var6.putExtra("idProvider", var10.zzmT());
      }

      return var6;
   }

   protected void zzb(zzlf.zza var1) {
      this.zzYe = (zzlf.zza)com.google.android.gms.common.internal.zzx.zzz(var1);
   }

   protected void zzb(String var1, String var2, zzlf.zza var3) {
      this.zzbW(var1);
      this.zzbX(var2);
      this.zzb(var3);
   }

   protected void zzbW(String var1) {
      this.zzWP = var1;
   }

   protected void zzbX(String var1) {
      this.zzXT = var1;
   }

   protected Set<String> zzns() {
      return this.zzXf;
   }

   protected zzlf.zza zznt() {
      return this.zzYe;
   }

   protected String zznu() {
      return this.zzXT;
   }
}
