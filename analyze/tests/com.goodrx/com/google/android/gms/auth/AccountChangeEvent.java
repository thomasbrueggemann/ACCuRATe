package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEvent implements SafeParcelable {
   public static final Creator<AccountChangeEvent> CREATOR = new zza();
   final int mVersion;
   final long zzUZ;
   final String zzVa;
   final int zzVb;
   final int zzVc;
   final String zzVd;

   AccountChangeEvent(int var1, long var2, String var4, int var5, int var6, String var7) {
      this.mVersion = var1;
      this.zzUZ = var2;
      this.zzVa = (String)zzx.zzz(var4);
      this.zzVb = var5;
      this.zzVc = var6;
      this.zzVd = var7;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof AccountChangeEvent)) {
            return false;
         }

         AccountChangeEvent var2 = (AccountChangeEvent)var1;
         if(this.mVersion != var2.mVersion || this.zzUZ != var2.zzUZ || !zzw.equal(this.zzVa, var2.zzVa) || this.zzVb != var2.zzVb || this.zzVc != var2.zzVc || !zzw.equal(this.zzVd, var2.zzVd)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.mVersion), Long.valueOf(this.zzUZ), this.zzVa, Integer.valueOf(this.zzVb), Integer.valueOf(this.zzVc), this.zzVd};
      return zzw.hashCode(var1);
   }

   public String toString() {
      String var1 = "UNKNOWN";
      switch(this.zzVb) {
      case 1:
         var1 = "ADDED";
         break;
      case 2:
         var1 = "REMOVED";
         break;
      case 3:
         var1 = "RENAMED_FROM";
         break;
      case 4:
         var1 = "RENAMED_TO";
      }

      return "AccountChangeEvent {accountName = " + this.zzVa + ", changeType = " + var1 + ", changeData = " + this.zzVd + ", eventIndex = " + this.zzVc + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
