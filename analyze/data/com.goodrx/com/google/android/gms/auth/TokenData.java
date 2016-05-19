package com.google.android.gms.auth;

import android.os.Parcel;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.zze;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class TokenData implements SafeParcelable {
   public static final zze CREATOR = new zze();
   final int mVersionCode;
   private final String zzVo;
   private final Long zzVp;
   private final boolean zzVq;
   private final boolean zzVr;
   private final List<String> zzVs;

   TokenData(int var1, String var2, Long var3, boolean var4, boolean var5, List<String> var6) {
      this.mVersionCode = var1;
      this.zzVo = zzx.zzcM(var2);
      this.zzVp = var3;
      this.zzVq = var4;
      this.zzVr = var5;
      this.zzVs = var6;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof TokenData) {
         TokenData var2 = (TokenData)var1;
         if(TextUtils.equals(this.zzVo, var2.zzVo) && zzw.equal(this.zzVp, var2.zzVp) && this.zzVq == var2.zzVq && this.zzVr == var2.zzVr && zzw.equal(this.zzVs, var2.zzVs)) {
            return true;
         }
      }

      return false;
   }

   public String getToken() {
      return this.zzVo;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzVo, this.zzVp, Boolean.valueOf(this.zzVq), Boolean.valueOf(this.zzVr), this.zzVs};
      return zzw.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }

   @Nullable
   public Long zzmn() {
      return this.zzVp;
   }

   public boolean zzmo() {
      return this.zzVq;
   }

   public boolean zzmp() {
      return this.zzVr;
   }

   @Nullable
   public List<String> zzmq() {
      return this.zzVs;
   }
}
