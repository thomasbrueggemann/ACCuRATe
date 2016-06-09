package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import com.google.android.gms.wallet.wobs.zza;
import java.util.ArrayList;

@KeepName
public class CommonWalletObject implements SafeParcelable {
   public static final Creator<CommonWalletObject> CREATOR = new zza();
   private final int mVersionCode;
   String name;
   int state;
   String zzboQ;
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
   String zzio;

   CommonWalletObject() {
      this.mVersionCode = 1;
      this.zzboX = zzmn.zzsa();
      this.zzboZ = zzmn.zzsa();
      this.zzbpc = zzmn.zzsa();
      this.zzbpe = zzmn.zzsa();
      this.zzbpf = zzmn.zzsa();
      this.zzbpg = zzmn.zzsa();
   }

   CommonWalletObject(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, int var10, ArrayList<WalletObjectMessage> var11, TimeInterval var12, ArrayList<LatLng> var13, String var14, String var15, ArrayList<LabelValueRow> var16, boolean var17, ArrayList<UriData> var18, ArrayList<TextModuleData> var19, ArrayList<UriData> var20) {
      this.mVersionCode = var1;
      this.zzio = var2;
      this.zzboW = var3;
      this.name = var4;
      this.zzboQ = var5;
      this.zzboS = var6;
      this.zzboT = var7;
      this.zzboU = var8;
      this.zzboV = var9;
      this.state = var10;
      this.zzboX = var11;
      this.zzboY = var12;
      this.zzboZ = var13;
      this.zzbpa = var14;
      this.zzbpb = var15;
      this.zzbpc = var16;
      this.zzbpd = var17;
      this.zzbpe = var18;
      this.zzbpf = var19;
      this.zzbpg = var20;
   }

   public static CommonWalletObject.zza zzIr() {
      CommonWalletObject var0 = new CommonWalletObject();
      return var0.new zza();
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public final class zza {
      private zza() {
      }

      // $FF: synthetic method
      zza(Object var2) {
         this();
      }

      public CommonWalletObject zzIs() {
         return CommonWalletObject.this;
      }

      public CommonWalletObject.zza zzgK(String var1) {
         CommonWalletObject.this.zzio = var1;
         return this;
      }
   }
}
