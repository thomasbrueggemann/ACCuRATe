package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_727;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class OfferWalletObject implements SafeParcelable {
   public static final Creator<OfferWalletObject> CREATOR = new class_727();
   String ajQ;
   CommonWalletObject ajR;
   // $FF: renamed from: eC java.lang.String
   String field_4295;
   // $FF: renamed from: xJ int
   private final int field_4296;

   OfferWalletObject() {
      this.field_4296 = 3;
   }

   OfferWalletObject(int var1, String var2, String var3, CommonWalletObject var4) {
      this.field_4296 = var1;
      this.ajQ = var3;
      if(var1 < 3) {
         this.ajR = CommonWalletObject.method_4510().method_2744(var2).method_2745();
      } else {
         this.ajR = var4;
      }
   }

   public int describeContents() {
      return 0;
   }

   public String getId() {
      return this.ajR.getId();
   }

   public String getRedemptionCode() {
      return this.ajQ;
   }

   public int getVersionCode() {
      return this.field_4296;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_727.method_4113(this, var1, var2);
   }
}
