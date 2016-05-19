package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.zzq;

public class ParcelableCollaborator implements SafeParcelable {
   public static final Creator<ParcelableCollaborator> CREATOR = new zzq();
   final int mVersionCode;
   final String zzLq;
   final String zzWQ;
   final boolean zzaeW;
   final boolean zzauI;
   final String zzauJ;
   final String zzauK;
   final String zzrG;

   ParcelableCollaborator(int var1, boolean var2, boolean var3, String var4, String var5, String var6, String var7, String var8) {
      this.mVersionCode = var1;
      this.zzauI = var2;
      this.zzaeW = var3;
      this.zzLq = var4;
      this.zzrG = var5;
      this.zzWQ = var6;
      this.zzauJ = var7;
      this.zzauK = var8;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof ParcelableCollaborator)) {
         return false;
      } else {
         ParcelableCollaborator var2 = (ParcelableCollaborator)var1;
         return this.zzLq.equals(var2.zzLq);
      }
   }

   public int hashCode() {
      return this.zzLq.hashCode();
   }

   public String toString() {
      return "Collaborator [isMe=" + this.zzauI + ", isAnonymous=" + this.zzaeW + ", sessionId=" + this.zzLq + ", userId=" + this.zzrG + ", displayName=" + this.zzWQ + ", color=" + this.zzauJ + ", photoUrl=" + this.zzauK + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzq.zza(this, var1, var2);
   }
}
