package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.zzk;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

public final class LoyaltyWalletObject implements SafeParcelable {
   public static final Creator<LoyaltyWalletObject> CREATOR = new zzk();
   private final int mVersionCode;
   int state;
   String zzaQZ;
   String zzboP;
   String zzboQ;
   String zzboR;
   String zzboS;
   String zzboT;
   String zzboU;
   String zzboV;
   String zzboW;
   ArrayList<WalletObjectMessage> zzboX;
   TimeInterval zzboY;
   ArrayList<LatLng> zzboZ;
   String zzbpa;
   String zzbpb;
   ArrayList<LabelValueRow> zzbpc;
   boolean zzbpd;
   ArrayList<UriData> zzbpe;
   ArrayList<TextModuleData> zzbpf;
   ArrayList<UriData> zzbpg;
   LoyaltyPoints zzbph;
   String zzio;

   LoyaltyWalletObject() {
      this.mVersionCode = 4;
      this.zzboX = zzmn.zzsa();
      this.zzboZ = zzmn.zzsa();
      this.zzbpc = zzmn.zzsa();
      this.zzbpe = zzmn.zzsa();
      this.zzbpf = zzmn.zzsa();
      this.zzbpg = zzmn.zzsa();
   }

   LoyaltyWalletObject(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, int var12, ArrayList<WalletObjectMessage> var13, TimeInterval var14, ArrayList<LatLng> var15, String var16, String var17, ArrayList<LabelValueRow> var18, boolean var19, ArrayList<UriData> var20, ArrayList<TextModuleData> var21, ArrayList<UriData> var22, LoyaltyPoints var23) {
      this.mVersionCode = var1;
      this.zzio = var2;
      this.zzboP = var3;
      this.zzboQ = var4;
      this.zzboR = var5;
      this.zzaQZ = var6;
      this.zzboS = var7;
      this.zzboT = var8;
      this.zzboU = var9;
      this.zzboV = var10;
      this.zzboW = var11;
      this.state = var12;
      this.zzboX = var13;
      this.zzboY = var14;
      this.zzboZ = var15;
      this.zzbpa = var16;
      this.zzbpb = var17;
      this.zzbpc = var18;
      this.zzbpd = var19;
      this.zzbpe = var20;
      this.zzbpf = var21;
      this.zzbpg = var22;
      this.zzbph = var23;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzk.zza(this, var1, var2);
   }
}
