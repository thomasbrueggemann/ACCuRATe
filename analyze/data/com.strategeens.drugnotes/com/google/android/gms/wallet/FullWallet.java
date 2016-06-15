package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.ProxyCard;
import com.google.android.gms.wallet.class_933;

public final class FullWallet implements SafeParcelable {
   public static final Creator<FullWallet> CREATOR = new class_933();
   // $FF: renamed from: CK int
   private final int field_3287;
   String auL;
   String auM;
   ProxyCard auN;
   String auO;
   Address auP;
   Address auQ;
   String[] auR;
   UserAddress auS;
   UserAddress auT;
   InstrumentInfo[] auU;

   private FullWallet() {
      this.field_3287 = 1;
   }

   FullWallet(int var1, String var2, String var3, ProxyCard var4, String var5, Address var6, Address var7, String[] var8, UserAddress var9, UserAddress var10, InstrumentInfo[] var11) {
      this.field_3287 = var1;
      this.auL = var2;
      this.auM = var3;
      this.auN = var4;
      this.auO = var5;
      this.auP = var6;
      this.auQ = var7;
      this.auR = var8;
      this.auS = var9;
      this.auT = var10;
      this.auU = var11;
   }

   public int describeContents() {
      return 0;
   }

   @Deprecated
   public Address getBillingAddress() {
      return this.auP;
   }

   public UserAddress getBuyerBillingAddress() {
      return this.auS;
   }

   public UserAddress getBuyerShippingAddress() {
      return this.auT;
   }

   public String getEmail() {
      return this.auO;
   }

   public String getGoogleTransactionId() {
      return this.auL;
   }

   public InstrumentInfo[] getInstrumentInfos() {
      return this.auU;
   }

   public String getMerchantTransactionId() {
      return this.auM;
   }

   public String[] getPaymentDescriptions() {
      return this.auR;
   }

   public ProxyCard getProxyCard() {
      return this.auN;
   }

   @Deprecated
   public Address getShippingAddress() {
      return this.auQ;
   }

   public int getVersionCode() {
      return this.field_3287;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_933.method_5186(this, var1, var2);
   }
}
