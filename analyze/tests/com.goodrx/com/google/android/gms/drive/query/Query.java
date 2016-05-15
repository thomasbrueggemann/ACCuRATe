package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.SortOrder;
import com.google.android.gms.drive.query.zza;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Query implements SafeParcelable {
   public static final Creator<Query> CREATOR = new zza();
   final int mVersionCode;
   final List<DriveSpace> zzapB;
   private final Set<DriveSpace> zzapC;
   final boolean zzarL;
   final LogicalFilter zzatV;
   final String zzatW;
   final SortOrder zzatX;
   final List<String> zzatY;
   final boolean zzatZ;

   private Query(int var1, LogicalFilter var2, String var3, SortOrder var4, List<String> var5, boolean var6, List<DriveSpace> var7, Set<DriveSpace> var8, boolean var9) {
      this.mVersionCode = var1;
      this.zzatV = var2;
      this.zzatW = var3;
      this.zzatX = var4;
      this.zzatY = var5;
      this.zzatZ = var6;
      this.zzapB = var7;
      this.zzapC = var8;
      this.zzarL = var9;
   }

   Query(int var1, LogicalFilter var2, String var3, SortOrder var4, List<String> var5, boolean var6, List<DriveSpace> var7, boolean var8) {
      HashSet var9;
      if(var7 == null) {
         var9 = null;
      } else {
         var9 = new HashSet(var7);
      }

      this(var1, var2, var3, var4, var5, var6, var7, var9, var8);
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{this.zzatV, this.zzatX, this.zzatW, this.zzapB};
      return String.format(var1, "Query[%s,%s,PageToken=%s,Spaces=%s]", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
