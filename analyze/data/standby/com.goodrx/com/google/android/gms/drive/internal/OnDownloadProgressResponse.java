package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveFileRange;
import com.google.android.gms.drive.internal.zzay;
import java.util.Collections;
import java.util.List;

public class OnDownloadProgressResponse implements SafeParcelable {
   public static final Creator<OnDownloadProgressResponse> CREATOR = new zzay();
   private static final List<DriveFileRange> zzash = Collections.emptyList();
   final int mVersionCode;
   final int zzBc;
   final long zzasi;
   final long zzasj;
   final List<DriveFileRange> zzask;

   OnDownloadProgressResponse(int var1, long var2, long var4, int var6, List<DriveFileRange> var7) {
      this.mVersionCode = var1;
      this.zzasi = var2;
      this.zzasj = var4;
      this.zzBc = var6;
      this.zzask = var7;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzay.zza(this, var1, var2);
   }
}
