package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.zzk;

public final class EventParcel implements SafeParcelable {
   public static final zzk CREATOR = new zzk();
   public final String name;
   public final int versionCode;
   public final EventParams zzaVV;
   public final String zzaVW;
   public final long zzaVX;

   EventParcel(int var1, String var2, EventParams var3, String var4, long var5) {
      this.versionCode = var1;
      this.name = var2;
      this.zzaVV = var3;
      this.zzaVW = var4;
      this.zzaVX = var5;
   }

   public EventParcel(String var1, EventParams var2, String var3, long var4) {
      this.versionCode = 1;
      this.name = var1;
      this.zzaVV = var2;
      this.zzaVW = var3;
      this.zzaVX = var4;
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      return "origin=" + this.zzaVW + ",name=" + this.name + ",params=" + this.zzaVV;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzk.zza(this, var1, var2);
   }
}
