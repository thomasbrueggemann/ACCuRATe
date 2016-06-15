package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_724;

@Deprecated
public final class Address implements SafeParcelable {
   public static final Creator<Address> CREATOR = new class_724();
   // $FF: renamed from: UE java.lang.String
   String field_3229;
   // $FF: renamed from: UF java.lang.String
   String field_3230;
   // $FF: renamed from: UG java.lang.String
   String field_3231;
   // $FF: renamed from: UL java.lang.String
   String field_3232;
   // $FF: renamed from: UN java.lang.String
   String field_3233;
   // $FF: renamed from: UO boolean
   boolean field_3234;
   // $FF: renamed from: UP java.lang.String
   String field_3235;
   String aiF;
   String aiG;
   String name;
   // $FF: renamed from: rc java.lang.String
   String field_3236;
   // $FF: renamed from: xJ int
   private final int field_3237;

   Address() {
      this.field_3237 = 1;
   }

   Address(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, boolean var11, String var12) {
      this.field_3237 = var1;
      this.name = var2;
      this.field_3229 = var3;
      this.field_3230 = var4;
      this.field_3231 = var5;
      this.field_3236 = var6;
      this.aiF = var7;
      this.aiG = var8;
      this.field_3232 = var9;
      this.field_3233 = var10;
      this.field_3234 = var11;
      this.field_3235 = var12;
   }

   public int describeContents() {
      return 0;
   }

   public String getAddress1() {
      return this.field_3229;
   }

   public String getAddress2() {
      return this.field_3230;
   }

   public String getAddress3() {
      return this.field_3231;
   }

   public String getCity() {
      return this.aiF;
   }

   public String getCompanyName() {
      return this.field_3235;
   }

   public String getCountryCode() {
      return this.field_3236;
   }

   public String getName() {
      return this.name;
   }

   public String getPhoneNumber() {
      return this.field_3233;
   }

   public String getPostalCode() {
      return this.field_3232;
   }

   public String getState() {
      return this.aiG;
   }

   public int getVersionCode() {
      return this.field_3237;
   }

   public boolean isPostBox() {
      return this.field_3234;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_724.method_4104(this, var1, var2);
   }
}
