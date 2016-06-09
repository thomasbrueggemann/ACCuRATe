package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ResourceEvent;
import com.google.android.gms.drive.events.zze;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent implements SafeParcelable, ResourceEvent {
   public static final Creator<CompletionEvent> CREATOR = new zze();
   final int mVersionCode;
   final int zzBc;
   final String zzVa;
   final DriveId zzaoz;
   final ParcelFileDescriptor zzapD;
   final ParcelFileDescriptor zzapE;
   final MetadataBundle zzapF;
   final List<String> zzapG;
   final IBinder zzapH;
   private boolean zzapI = false;
   private boolean zzapJ = false;
   private boolean zzapK = false;

   CompletionEvent(int var1, DriveId var2, String var3, ParcelFileDescriptor var4, ParcelFileDescriptor var5, MetadataBundle var6, List<String> var7, int var8, IBinder var9) {
      this.mVersionCode = var1;
      this.zzaoz = var2;
      this.zzVa = var3;
      this.zzapD = var4;
      this.zzapE = var5;
      this.zzapF = var6;
      this.zzapG = var7;
      this.zzBc = var8;
      this.zzapH = var9;
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      String var1;
      if(this.zzapG == null) {
         var1 = "<null>";
      } else {
         var1 = "\'" + TextUtils.join("\',\'", this.zzapG) + "\'";
      }

      Locale var2 = Locale.US;
      Object[] var3 = new Object[]{this.zzaoz, Integer.valueOf(this.zzBc), var1};
      return String.format(var2, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", var3);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2 | 1);
   }
}
