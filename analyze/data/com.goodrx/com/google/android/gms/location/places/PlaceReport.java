package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.zzj;

public class PlaceReport implements SafeParcelable {
   public static final Creator<PlaceReport> CREATOR = new zzj();
   private final String mTag;
   final int mVersionCode;
   private final String zzaPH;
   private final String zzaPI;

   PlaceReport(int var1, String var2, String var3, String var4) {
      this.mVersionCode = var1;
      this.zzaPH = var2;
      this.mTag = var3;
      this.zzaPI = var4;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof PlaceReport) {
         PlaceReport var2 = (PlaceReport)var1;
         if(zzw.equal(this.zzaPH, var2.zzaPH) && zzw.equal(this.mTag, var2.mTag) && zzw.equal(this.zzaPI, var2.zzaPI)) {
            return true;
         }
      }

      return false;
   }

   public String getPlaceId() {
      return this.zzaPH;
   }

   public String getSource() {
      return this.zzaPI;
   }

   public String getTag() {
      return this.mTag;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzaPH, this.mTag, this.zzaPI};
      return zzw.hashCode(var1);
   }

   public String toString() {
      zzw.zza var1 = zzw.zzy(this);
      var1.zzg("placeId", this.zzaPH);
      var1.zzg("tag", this.mTag);
      if(!"unknown".equals(this.zzaPI)) {
         var1.zzg("source", this.zzaPI);
      }

      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj.zza(this, var1, var2);
   }
}
