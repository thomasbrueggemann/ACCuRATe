package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.internal.zzk;
import java.util.List;
import java.util.Set;

public class CapabilityInfoParcelable implements SafeParcelable {
   public static final Creator<CapabilityInfoParcelable> CREATOR = new zzk();
   private final String mName;
   final int mVersionCode;
   private Set<Object> zzbrS;
   private final List<NodeParcelable> zzbrV;
   private final Object zzpV = new Object();

   CapabilityInfoParcelable(int var1, String var2, List<NodeParcelable> var3) {
      this.mVersionCode = var1;
      this.mName = var2;
      this.zzbrV = var3;
      this.zzbrS = null;
      this.zzIH();
   }

   private void zzIH() {
      zzx.zzz(this.mName);
      zzx.zzz(this.zzbrV);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 != null && this.getClass() == var1.getClass()) {
            CapabilityInfoParcelable var2 = (CapabilityInfoParcelable)var1;
            if(this.mVersionCode != var2.mVersionCode) {
               return false;
            } else {
               label31: {
                  if(this.mName != null) {
                     if(this.mName.equals(var2.mName)) {
                        break label31;
                     }
                  } else if(var2.mName == null) {
                     break label31;
                  }

                  return false;
               }

               if(this.zzbrV != null) {
                  if(this.zzbrV.equals(var2.zzbrV)) {
                     return true;
                  }
               } else if(var2.zzbrV == null) {
                  return true;
               }

               return false;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public String getName() {
      return this.mName;
   }

   public int hashCode() {
      int var1 = 31 * this.mVersionCode;
      int var2;
      if(this.mName != null) {
         var2 = this.mName.hashCode();
      } else {
         var2 = 0;
      }

      int var3 = 31 * (var2 + var1);
      List var4 = this.zzbrV;
      int var5 = 0;
      if(var4 != null) {
         var5 = this.zzbrV.hashCode();
      }

      return var3 + var5;
   }

   public String toString() {
      return "CapabilityInfo{" + this.mName + ", " + this.zzbrV + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzk.zza(this, var1, var2);
   }

   public List<NodeParcelable> zzII() {
      return this.zzbrV;
   }
}
