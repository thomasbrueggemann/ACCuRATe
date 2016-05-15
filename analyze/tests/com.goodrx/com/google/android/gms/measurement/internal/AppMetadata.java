package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.measurement.internal.zzb;

public class AppMetadata implements SafeParcelable {
   public static final zzb CREATOR = new zzb();
   public final String packageName;
   public final int versionCode;
   public final String zzaMV;
   public final String zzaVt;
   public final String zzaVu;
   public final long zzaVv;
   public final long zzaVw;
   public final String zzaVx;
   public final boolean zzaVy;
   public final boolean zzaVz;

   AppMetadata(int var1, String var2, String var3, String var4, String var5, long var6, long var8, String var10, boolean var11, boolean var12) {
      this.versionCode = var1;
      this.packageName = var2;
      this.zzaVt = var3;
      this.zzaMV = var4;
      this.zzaVu = var5;
      this.zzaVv = var6;
      this.zzaVw = var8;
      this.zzaVx = var10;
      if(var1 >= 3) {
         this.zzaVy = var11;
      } else {
         this.zzaVy = true;
      }

      this.zzaVz = var12;
   }

   AppMetadata(String var1, String var2, String var3, String var4, long var5, long var7, String var9, boolean var10, boolean var11) {
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      this.versionCode = 4;
      this.packageName = var1;
      if(TextUtils.isEmpty(var2)) {
         var2 = null;
      }

      this.zzaVt = var2;
      this.zzaMV = var3;
      this.zzaVu = var4;
      this.zzaVv = var5;
      this.zzaVw = var7;
      this.zzaVx = var9;
      this.zzaVy = var10;
      this.zzaVz = var11;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
