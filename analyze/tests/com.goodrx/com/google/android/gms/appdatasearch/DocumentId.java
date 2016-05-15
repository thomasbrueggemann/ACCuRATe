package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DocumentId implements SafeParcelable {
   public static final zzc CREATOR = new zzc();
   final int mVersionCode;
   final String zzTJ;
   final String zzTK;
   final String zzTL;

   DocumentId(int var1, String var2, String var3, String var4) {
      this.mVersionCode = var1;
      this.zzTJ = var2;
      this.zzTK = var3;
      this.zzTL = var4;
   }

   public DocumentId(String var1, String var2, String var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      zzc var10000 = CREATOR;
      return 0;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.zzTJ, this.zzTK, this.zzTL};
      return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc var10000 = CREATOR;
      zzc.zza(this, var1, var2);
   }
}
