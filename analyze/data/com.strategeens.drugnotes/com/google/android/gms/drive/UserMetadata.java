package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_686;

public class UserMetadata implements SafeParcelable {
   public static final Creator<UserMetadata> CREATOR = new class_686();
   // $FF: renamed from: CK int
   final int field_2608;
   // $FF: renamed from: OR java.lang.String
   final String field_2609;
   // $FF: renamed from: OS java.lang.String
   final String field_2610;
   // $FF: renamed from: OT java.lang.String
   final String field_2611;
   // $FF: renamed from: OU boolean
   final boolean field_2612;
   // $FF: renamed from: OV java.lang.String
   final String field_2613;

   UserMetadata(int var1, String var2, String var3, String var4, boolean var5, String var6) {
      this.field_2608 = var1;
      this.field_2609 = var2;
      this.field_2610 = var3;
      this.field_2611 = var4;
      this.field_2612 = var5;
      this.field_2613 = var6;
   }

   public UserMetadata(String var1, String var2, String var3, boolean var4, String var5) {
      this(1, var1, var2, var3, var4, var5);
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_2609, this.field_2610, this.field_2611, Boolean.valueOf(this.field_2612), this.field_2613};
      return String.format("Permission ID: \'%s\', Display Name: \'%s\', Picture URL: \'%s\', Authenticated User: %b, Email: \'%s\'", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_686.method_3874(this, var1, var2);
   }
}
