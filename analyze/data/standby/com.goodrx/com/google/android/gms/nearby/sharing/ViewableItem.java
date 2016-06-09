package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.zzf;
import java.util.Arrays;

public class ViewableItem implements SafeParcelable {
   public static final Creator<ViewableItem> CREATOR = new zzf();
   private final int versionCode;
   private String[] zzbdj;

   private ViewableItem() {
      this.versionCode = 1;
   }

   ViewableItem(int var1, String[] var2) {
      this.versionCode = var1;
      this.zzbdj = var2;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ViewableItem)) {
         return false;
      } else {
         ViewableItem var2 = (ViewableItem)var1;
         return zzw.equal(this.zzbdj, var2.zzbdj);
      }
   }

   int getVersionCode() {
      return this.versionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzbdj};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return "ViewableItem[uris=" + Arrays.toString(this.zzbdj) + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }

   public String[] zzEN() {
      return this.zzbdj;
   }
}
