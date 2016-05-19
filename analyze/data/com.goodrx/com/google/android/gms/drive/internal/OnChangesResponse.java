package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.WriteAwareParcelable;
import com.google.android.gms.drive.internal.zzav;
import java.util.List;

public class OnChangesResponse extends WriteAwareParcelable implements SafeParcelable {
   public static final Creator<OnChangesResponse> CREATOR = new zzav();
   final int mVersionCode;
   final DataHolder zzasb;
   final List<DriveId> zzasc;
   final ChangeSequenceNumber zzasd;
   final boolean zzase;

   OnChangesResponse(int var1, DataHolder var2, List<DriveId> var3, ChangeSequenceNumber var4, boolean var5) {
      this.mVersionCode = var1;
      this.zzasb = var2;
      this.zzasc = var3;
      this.zzasd = var4;
      this.zzase = var5;
   }

   public int describeContents() {
      return 0;
   }

   protected void zzJ(Parcel var1, int var2) {
      zzav.zza(this, var1, var2 | 1);
   }
}
