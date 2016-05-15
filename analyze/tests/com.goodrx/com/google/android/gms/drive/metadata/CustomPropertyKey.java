package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.zzc;
import java.util.regex.Pattern;

public class CustomPropertyKey implements SafeParcelable {
   public static final Creator<CustomPropertyKey> CREATOR = new zzc();
   private static final Pattern zzasJ = Pattern.compile("[\\w.!@$%^&*()/-]+");
   final int mVersionCode;
   final int mVisibility;
   final String zzvs;

   CustomPropertyKey(int var1, String var2, int var3) {
      byte var4 = 1;
      super();
      zzx.zzb(var2, "key");
      zzx.zzb(zzasJ.matcher(var2).matches(), "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
      if(var3 != 0 && var3 != var4) {
         var4 = 0;
      }

      zzx.zzb((boolean)var4, "visibility must be either PUBLIC or PRIVATE");
      this.mVersionCode = var1;
      this.zzvs = var2;
      this.mVisibility = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if(var1 != null) {
         if(var1 == this) {
            return var2;
         }

         if(var1 instanceof CustomPropertyKey) {
            CustomPropertyKey var3 = (CustomPropertyKey)var1;
            if(!var3.getKey().equals(this.zzvs) || var3.getVisibility() != this.mVisibility) {
               var2 = false;
            }

            return var2;
         }
      }

      return false;
   }

   public String getKey() {
      return this.zzvs;
   }

   public int getVisibility() {
      return this.mVisibility;
   }

   public int hashCode() {
      return (this.zzvs + this.mVisibility).hashCode();
   }

   public String toString() {
      return "CustomPropertyKey(" + this.zzvs + "," + this.mVisibility + ")";
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
