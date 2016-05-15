package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.internal.zzc;

public class ClientIdentity implements SafeParcelable {
   public static final zzc CREATOR = new zzc();
   private final int mVersionCode;
   public final String packageName;
   public final int uid;

   ClientIdentity(int var1, int var2, String var3) {
      this.mVersionCode = var1;
      this.uid = var2;
      this.packageName = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(var1 != null && var1 instanceof ClientIdentity) {
            ClientIdentity var2 = (ClientIdentity)var1;
            if(var2.uid == this.uid && zzw.equal(var2.packageName, this.packageName)) {
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return this.uid;
   }

   public String toString() {
      Object[] var1 = new Object[]{Integer.valueOf(this.uid), this.packageName};
      return String.format("%d:%s", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
