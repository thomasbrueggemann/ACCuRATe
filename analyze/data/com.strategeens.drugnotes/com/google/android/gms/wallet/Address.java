package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_943;

@Deprecated
public final class Address implements SafeParcelable {
   public static final Creator<Address> CREATOR = new class_943();
   // $FF: renamed from: CK int
   private final int field_3188;
   String afK;
   String afL;
   String afM;
   String afR;
   String afT;
   boolean afU;
   String afV;
   String auD;
   String auE;
   String name;
   // $FF: renamed from: vk java.lang.String
   String field_3189;

   Address() {
      this.field_3188 = 1;
   }

   Address(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, boolean var11, String var12) {
      this.field_3188 = var1;
      this.name = var2;
      this.afK = var3;
      this.afL = var4;
      this.afM = var5;
      this.field_3189 = var6;
      this.auD = var7;
      this.auE = var8;
      this.afR = var9;
      this.afT = var10;
      this.afU = var11;
      this.afV = var12;
   }

   public int describeContents() {
      return 0;
   }

   public String getAddress1() {
      return this.afK;
   }

   public String getAddress2() {
      return this.afL;
   }

   public String getAddress3() {
      return this.afM;
   }

   public String getCity() {
      return this.auD;
   }

   public String getCompanyName() {
      return this.afV;
   }

   public String getCountryCode() {
      return this.field_3189;
   }

   public String getName() {
      return this.name;
   }

   public String getPhoneNumber() {
      return this.afT;
   }

   public String getPostalCode() {
      return this.afR;
   }

   public String getState() {
      return this.auE;
   }

   public int getVersionCode() {
      return this.field_3188;
   }

   public boolean isPostBox() {
      return this.afU;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_943.method_5215(this, var1, var2);
   }
}
