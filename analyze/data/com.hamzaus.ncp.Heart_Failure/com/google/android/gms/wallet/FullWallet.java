package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.ProxyCard;
import com.google.android.gms.wallet.class_714;

public final class FullWallet implements SafeParcelable {
   public static final Creator<FullWallet> CREATOR = new class_714();
   String aiN;
   String aiO;
   ProxyCard aiP;
   String aiQ;
   Address aiR;
   Address aiS;
   String[] aiT;
   UserAddress aiU;
   UserAddress aiV;
   InstrumentInfo[] aiW;
   // $FF: renamed from: xJ int
   private final int field_3321;

   private FullWallet() {
      this.field_3321 = 1;
   }

   FullWallet(int var1, String var2, String var3, ProxyCard var4, String var5, Address var6, Address var7, String[] var8, UserAddress var9, UserAddress var10, InstrumentInfo[] var11) {
      this.field_3321 = var1;
      this.aiN = var2;
      this.aiO = var3;
      this.aiP = var4;
      this.aiQ = var5;
      this.aiR = var6;
      this.aiS = var7;
      this.aiT = var8;
      this.aiU = var9;
      this.aiV = var10;
      this.aiW = var11;
   }

   public int describeContents() {
      return 0;
   }

   @Deprecated
   public Address getBillingAddress() {
      return this.aiR;
   }

   public UserAddress getBuyerBillingAddress() {
      return this.aiU;
   }

   public UserAddress getBuyerShippingAddress() {
      return this.aiV;
   }

   public String getEmail() {
      return this.aiQ;
   }

   public String getGoogleTransactionId() {
      return this.aiN;
   }

   public InstrumentInfo[] getInstrumentInfos() {
      return this.aiW;
   }

   public String getMerchantTransactionId() {
      return this.aiO;
   }

   public String[] getPaymentDescriptions() {
      return this.aiT;
   }

   public ProxyCard getProxyCard() {
      return this.aiP;
   }

   @Deprecated
   public Address getShippingAddress() {
      return this.aiS;
   }

   public int getVersionCode() {
      return this.field_3321;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_714.method_4075(this, var1, var2);
   }
}
