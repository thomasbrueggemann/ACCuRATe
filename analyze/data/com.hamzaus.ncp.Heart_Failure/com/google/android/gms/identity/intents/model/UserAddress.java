package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.class_662;

public final class UserAddress implements SafeParcelable {
   public static final Creator<UserAddress> CREATOR = new class_662();
   // $FF: renamed from: UE java.lang.String
   String field_3637;
   // $FF: renamed from: UF java.lang.String
   String field_3638;
   // $FF: renamed from: UG java.lang.String
   String field_3639;
   // $FF: renamed from: UH java.lang.String
   String field_3640;
   // $FF: renamed from: UI java.lang.String
   String field_3641;
   // $FF: renamed from: UJ java.lang.String
   String field_3642;
   // $FF: renamed from: UK java.lang.String
   String field_3643;
   // $FF: renamed from: UL java.lang.String
   String field_3644;
   // $FF: renamed from: UM java.lang.String
   String field_3645;
   // $FF: renamed from: UN java.lang.String
   String field_3646;
   // $FF: renamed from: UO boolean
   boolean field_3647;
   // $FF: renamed from: UP java.lang.String
   String field_3648;
   // $FF: renamed from: UQ java.lang.String
   String field_3649;
   String name;
   // $FF: renamed from: rc java.lang.String
   String field_3650;
   // $FF: renamed from: xJ int
   private final int field_3651;

   UserAddress() {
      this.field_3651 = 1;
   }

   UserAddress(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, boolean var14, String var15, String var16) {
      this.field_3651 = var1;
      this.name = var2;
      this.field_3637 = var3;
      this.field_3638 = var4;
      this.field_3639 = var5;
      this.field_3640 = var6;
      this.field_3641 = var7;
      this.field_3642 = var8;
      this.field_3643 = var9;
      this.field_3650 = var10;
      this.field_3644 = var11;
      this.field_3645 = var12;
      this.field_3646 = var13;
      this.field_3647 = var14;
      this.field_3648 = var15;
      this.field_3649 = var16;
   }

   public static UserAddress fromIntent(Intent var0) {
      return var0 != null && var0.hasExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS")?(UserAddress)var0.getParcelableExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS"):null;
   }

   public int describeContents() {
      return 0;
   }

   public String getAddress1() {
      return this.field_3637;
   }

   public String getAddress2() {
      return this.field_3638;
   }

   public String getAddress3() {
      return this.field_3639;
   }

   public String getAddress4() {
      return this.field_3640;
   }

   public String getAddress5() {
      return this.field_3641;
   }

   public String getAdministrativeArea() {
      return this.field_3642;
   }

   public String getCompanyName() {
      return this.field_3648;
   }

   public String getCountryCode() {
      return this.field_3650;
   }

   public String getEmailAddress() {
      return this.field_3649;
   }

   public String getLocality() {
      return this.field_3643;
   }

   public String getName() {
      return this.name;
   }

   public String getPhoneNumber() {
      return this.field_3646;
   }

   public String getPostalCode() {
      return this.field_3644;
   }

   public String getSortingCode() {
      return this.field_3645;
   }

   public int getVersionCode() {
      return this.field_3651;
   }

   public boolean isPostBox() {
      return this.field_3647;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_662.method_3810(this, var1, var2);
   }
}
