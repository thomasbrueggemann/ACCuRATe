package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.class_963;

// $FF: renamed from: com.google.android.gms.wearable.c
public class class_962 implements SafeParcelable {
   public static final Creator<c> CREATOR = new class_963();
   // $FF: renamed from: CK int
   final int field_4096;
   // $FF: renamed from: Gt int
   private final int field_4097;
   // $FF: renamed from: TW java.lang.String
   private final String field_4098;
   private final int axc;
   private final boolean axd;
   private boolean axe;
   private String axf;
   private final String mName;

   class_962(int var1, String var2, String var3, int var4, int var5, boolean var6, boolean var7, String var8) {
      this.field_4096 = var1;
      this.mName = var2;
      this.field_4098 = var3;
      this.field_4097 = var4;
      this.axc = var5;
      this.axd = var6;
      this.axe = var7;
      this.axf = var8;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof class_962) {
         class_962 var2 = (class_962)var1;
         if(class_336.equal(Integer.valueOf(this.field_4096), Integer.valueOf(var2.field_4096)) && class_336.equal(this.mName, var2.mName) && class_336.equal(this.field_4098, var2.field_4098) && class_336.equal(Integer.valueOf(this.field_4097), Integer.valueOf(var2.field_4097)) && class_336.equal(Integer.valueOf(this.axc), Integer.valueOf(var2.axc)) && class_336.equal(Boolean.valueOf(this.axd), Boolean.valueOf(var2.axd))) {
            return true;
         }
      }

      return false;
   }

   public String getAddress() {
      return this.field_4098;
   }

   public String getName() {
      return this.mName;
   }

   public int getRole() {
      return this.axc;
   }

   public int getType() {
      return this.field_4097;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_4096), this.mName, this.field_4098, Integer.valueOf(this.field_4097), Integer.valueOf(this.axc), Boolean.valueOf(this.axd)};
      return class_336.hashCode(var1);
   }

   public boolean isConnected() {
      return this.axe;
   }

   public boolean isEnabled() {
      return this.axd;
   }

   // $FF: renamed from: rj () java.lang.String
   public String method_5366() {
      return this.axf;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("ConnectionConfiguration[ ");
      var1.append("mName=" + this.mName);
      var1.append(", mAddress=" + this.field_4098);
      var1.append(", mType=" + this.field_4097);
      var1.append(", mRole=" + this.axc);
      var1.append(", mEnabled=" + this.axd);
      var1.append(", mIsConnected=" + this.axe);
      var1.append(", mEnabled=" + this.axf);
      var1.append("]");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_963.method_5367(this, var1, var2);
   }
}
