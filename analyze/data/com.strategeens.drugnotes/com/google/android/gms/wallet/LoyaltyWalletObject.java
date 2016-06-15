package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_724;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.class_937;
import com.google.android.gms.wallet.wobs.class_654;
import com.google.android.gms.wallet.wobs.class_668;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.j;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;
import java.util.ArrayList;

public final class LoyaltyWalletObject implements SafeParcelable {
   public static final Creator<LoyaltyWalletObject> CREATOR = new class_937();
   // $FF: renamed from: CK int
   private final int field_2793;
   String aki;
   String avd;
   String ave;
   String avf;
   String avg;
   String avh;
   String avi;
   String avj;
   String avk;
   ArrayList<p> avl;
   class_668 avm;
   ArrayList<LatLng> avn;
   String avo;
   String avp;
   ArrayList<d> avq;
   boolean avr;
   ArrayList<n> avs;
   ArrayList<j> avt;
   ArrayList<n> avu;
   class_654 avv;
   // $FF: renamed from: fl java.lang.String
   String field_2794;
   int state;

   LoyaltyWalletObject() {
      this.field_2793 = 4;
      this.avl = class_724.method_4217();
      this.avn = class_724.method_4217();
      this.avq = class_724.method_4217();
      this.avs = class_724.method_4217();
      this.avt = class_724.method_4217();
      this.avu = class_724.method_4217();
   }

   LoyaltyWalletObject(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, int var12, ArrayList<p> var13, l var14, ArrayList<LatLng> var15, String var16, String var17, ArrayList<d> var18, boolean var19, ArrayList<n> var20, ArrayList<j> var21, ArrayList<n> var22, f var23) {
      this.field_2793 = var1;
      this.field_2794 = var2;
      this.avd = var3;
      this.ave = var4;
      this.avf = var5;
      this.aki = var6;
      this.avg = var7;
      this.avh = var8;
      this.avi = var9;
      this.avj = var10;
      this.avk = var11;
      this.state = var12;
      this.avl = var13;
      this.avm = var14;
      this.avn = var15;
      this.avo = var16;
      this.avp = var17;
      this.avq = var18;
      this.avr = var19;
      this.avs = var20;
      this.avt = var21;
      this.avu = var22;
      this.avv = var23;
   }

   public int describeContents() {
      return 0;
   }

   public String getAccountId() {
      return this.avd;
   }

   public String getAccountName() {
      return this.aki;
   }

   public String getBarcodeAlternateText() {
      return this.avg;
   }

   public String getBarcodeType() {
      return this.avh;
   }

   public String getBarcodeValue() {
      return this.avi;
   }

   public String getId() {
      return this.field_2794;
   }

   public String getIssuerName() {
      return this.ave;
   }

   public String getProgramName() {
      return this.avf;
   }

   public int getVersionCode() {
      return this.field_2793;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_937.method_5195(this, var1, var2);
   }
}
