package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.zzc;
import java.util.Locale;

public class FieldWithSortOrder implements SafeParcelable {
   public static final zzc CREATOR = new zzc();
   final int mVersionCode;
   final String zzasF;
   final boolean zzauj;

   FieldWithSortOrder(int var1, String var2, boolean var3) {
      this.mVersionCode = var1;
      this.zzasF = var2;
      this.zzauj = var3;
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{this.zzasF, null};
      String var3;
      if(this.zzauj) {
         var3 = "ASC";
      } else {
         var3 = "DESC";
      }

      var2[1] = var3;
      return String.format(var1, "FieldWithSortOrder[%s %s]", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
