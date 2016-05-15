package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.internal.zzah;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetChangesRequest implements SafeParcelable {
   public static final Creator<GetChangesRequest> CREATOR = new zzah();
   final int mVersionCode;
   final List<DriveSpace> zzapB;
   private final Set<DriveSpace> zzapC;
   final ChangeSequenceNumber zzarJ;
   final int zzarK;
   final boolean zzarL;

   private GetChangesRequest(int var1, ChangeSequenceNumber var2, int var3, List<DriveSpace> var4, Set<DriveSpace> var5, boolean var6) {
      this.mVersionCode = var1;
      this.zzarJ = var2;
      this.zzarK = var3;
      this.zzapB = var4;
      this.zzapC = var5;
      this.zzarL = var6;
   }

   GetChangesRequest(int var1, ChangeSequenceNumber var2, int var3, List<DriveSpace> var4, boolean var5) {
      HashSet var6;
      if(var4 == null) {
         var6 = null;
      } else {
         var6 = new HashSet(var4);
      }

      this(var1, var2, var3, var4, var6, var5);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzah.zza(this, var1, var2);
   }
}
