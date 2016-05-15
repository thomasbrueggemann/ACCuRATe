package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzi;
import com.google.android.gms.internal.zzoz;

public final class Device implements SafeParcelable {
   public static final Creator<Device> CREATOR = new zzi();
   private final int mVersionCode;
   private final int zzabB;
   private final String zzadc;
   private final String zzawI;
   private final String zzawJ;
   private final String zzawK;
   private final int zzawL;

   Device(int var1, String var2, String var3, String var4, String var5, int var6, int var7) {
      this.mVersionCode = var1;
      this.zzawI = (String)zzx.zzz(var2);
      this.zzawJ = (String)zzx.zzz(var3);
      this.zzadc = "";
      this.zzawK = (String)zzx.zzz(var5);
      this.zzabB = var6;
      this.zzawL = var7;
   }

   private boolean zza(Device var1) {
      return zzw.equal(this.zzawI, var1.zzawI) && zzw.equal(this.zzawJ, var1.zzawJ) && zzw.equal(this.zzadc, var1.zzadc) && zzw.equal(this.zzawK, var1.zzawK) && this.zzabB == var1.zzabB && this.zzawL == var1.zzawL;
   }

   private boolean zzus() {
      return this.zzur() == 1;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof Device && this.zza((Device)var1);
   }

   public String getManufacturer() {
      return this.zzawI;
   }

   public String getModel() {
      return this.zzawJ;
   }

   String getStreamIdentifier() {
      Object[] var1 = new Object[]{this.zzawI, this.zzawJ, this.zzawK};
      return String.format("%s:%s:%s", var1);
   }

   public int getType() {
      return this.zzabB;
   }

   public String getUid() {
      return this.zzawK;
   }

   public String getVersion() {
      return this.zzadc;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzawI, this.zzawJ, this.zzadc, this.zzawK, Integer.valueOf(this.zzabB)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Object[] var1 = new Object[]{this.getStreamIdentifier(), this.zzadc, Integer.valueOf(this.zzabB), Integer.valueOf(this.zzawL)};
      return String.format("Device{%s:%s:%s:%s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzi.zza(this, var1, var2);
   }

   public int zzur() {
      return this.zzawL;
   }

   public String zzut() {
      return this.zzus()?this.zzawK:zzoz.zzdF(this.zzawK);
   }
}
