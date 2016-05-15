package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzag;

public final class FileUploadPreferencesImpl implements SafeParcelable {
   public static final Creator<FileUploadPreferencesImpl> CREATOR = new zzag();
   final int mVersionCode;
   int zzarG;
   int zzarH;
   boolean zzarI;

   FileUploadPreferencesImpl(int var1, int var2, int var3, boolean var4) {
      this.mVersionCode = var1;
      this.zzarG = var2;
      this.zzarH = var3;
      this.zzarI = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzag.zza(this, var1, var2);
   }
}
