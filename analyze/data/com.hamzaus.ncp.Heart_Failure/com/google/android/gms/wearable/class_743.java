package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.class_744;

// $FF: renamed from: com.google.android.gms.wearable.c
public class class_743 implements SafeParcelable {
   public static final Creator<c> CREATOR = new class_744();
   // $FF: renamed from: AQ int
   private final int field_4000;
   // $FF: renamed from: YI java.lang.String
   private final String field_4001;
   private final int alf;
   private final boolean alg;
   private final String mName;
   // $FF: renamed from: xJ int
   final int field_4002;

   class_743(int var1, String var2, String var3, int var4, int var5, boolean var6) {
      this.field_4002 = var1;
      this.mName = var2;
      this.field_4001 = var3;
      this.field_4000 = var4;
      this.alf = var5;
      this.alg = var6;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof class_743) {
         class_743 var2 = (class_743)var1;
         if(class_349.equal(Integer.valueOf(this.field_4002), Integer.valueOf(var2.field_4002)) && class_349.equal(this.mName, var2.mName) && class_349.equal(this.field_4001, var2.field_4001) && class_349.equal(Integer.valueOf(this.field_4000), Integer.valueOf(var2.field_4000)) && class_349.equal(Integer.valueOf(this.alf), Integer.valueOf(var2.alf)) && class_349.equal(Boolean.valueOf(this.alg), Boolean.valueOf(var2.alg))) {
            return true;
         }
      }

      return false;
   }

   public String getAddress() {
      return this.field_4001;
   }

   public String getName() {
      return this.mName;
   }

   public int getRole() {
      return this.alf;
   }

   public int getType() {
      return this.field_4000;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_4002), this.mName, this.field_4001, Integer.valueOf(this.field_4000), Integer.valueOf(this.alf), Boolean.valueOf(this.alg)};
      return class_349.hashCode(var1);
   }

   public boolean isEnabled() {
      return this.alg;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("ConnectionConfiguration[ ");
      var1.append("mName=" + this.mName);
      var1.append(", mAddress=" + this.field_4001);
      var1.append(", mType=" + this.field_4000);
      var1.append(", mRole=" + this.alf);
      var1.append(", mEnabled=" + this.alg);
      var1.append("]");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_744.method_4261(this, var1, var2);
   }
}
