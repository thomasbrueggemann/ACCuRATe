package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.zza;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLConfig implements SafeParcelable {
   public static final zza CREATOR = new zza();
   final int version;
   boolean zzYm;
   String zzYn;
   boolean zzYo;
   boolean zzYp;
   boolean zzYq;
   boolean zzYr;

   FACLConfig(int var1, boolean var2, String var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      this.version = var1;
      this.zzYm = var2;
      this.zzYn = var3;
      this.zzYo = var4;
      this.zzYp = var5;
      this.zzYq = var6;
      this.zzYr = var7;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2 = var1 instanceof FACLConfig;
      boolean var3 = false;
      if(var2) {
         FACLConfig var4 = (FACLConfig)var1;
         boolean var5 = this.zzYm;
         boolean var6 = var4.zzYm;
         var3 = false;
         if(var5 == var6) {
            boolean var7 = TextUtils.equals(this.zzYn, var4.zzYn);
            var3 = false;
            if(var7) {
               boolean var8 = this.zzYo;
               boolean var9 = var4.zzYo;
               var3 = false;
               if(var8 == var9) {
                  boolean var10 = this.zzYp;
                  boolean var11 = var4.zzYp;
                  var3 = false;
                  if(var10 == var11) {
                     boolean var12 = this.zzYq;
                     boolean var13 = var4.zzYq;
                     var3 = false;
                     if(var12 == var13) {
                        boolean var14 = this.zzYr;
                        boolean var15 = var4.zzYr;
                        var3 = false;
                        if(var14 == var15) {
                           var3 = true;
                        }
                     }
                  }
               }
            }
         }
      }

      return var3;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Boolean.valueOf(this.zzYm), this.zzYn, Boolean.valueOf(this.zzYo), Boolean.valueOf(this.zzYp), Boolean.valueOf(this.zzYq), Boolean.valueOf(this.zzYr)};
      return zzw.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
